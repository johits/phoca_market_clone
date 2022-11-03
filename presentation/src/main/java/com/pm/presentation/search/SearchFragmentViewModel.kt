package com.pm.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.gms.tasks.OnFailureListener
import com.google.firebase.firestore.FirebaseFirestore
import com.pm.data.model.PhotoCardInfoModel
import com.pm.data.repository.RemoteDataRepository
import com.pm.data.util.FireStoreCollection
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject


@HiltViewModel
class SearchFragmentViewModel @Inject constructor(private val remoteDataRepository: RemoteDataRepository, private val database: FirebaseFirestore) :
    ViewModel() {
    private val _searchList = MutableLiveData<List<PhotoCardInfoModel>>()
    val searchList: LiveData<List<PhotoCardInfoModel>> = _searchList
    val isWish = MutableLiveData(false)

    init {
        remoteDataRepository.getPhotoCardInfoData {
            _searchList.value = it
        }
    }

    fun search(keyword: String) {
        remoteDataRepository.searchPhotoCardInfoData(keyword) {
            _searchList.value = it
        }
    }

    fun addHeartList(heartList: String, isChecked: Boolean){
        database.collection(FireStoreCollection.HEART_LIST).document("임시")
            .update("heart", heartList[0].dec()
            ){
            }
        database.collection(FireStoreCollection.HEART_LIST)
            .add(heartList)
            .addOnSuccessListener { documentReference ->
                Timber.tag("jhs").d("DocumentSnapshot added with ID: " + documentReference.id)
            }
            .addOnFailureListener(OnFailureListener { e ->
                Timber.tag("jhs").w(e, "Error adding document")
            })
    }

}