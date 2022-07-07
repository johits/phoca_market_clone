package com.pm.phocamarketclone.phocatalk.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pm.phocamarketclone.phocatalk.model.TalkVO

class TalkListViewModel : ViewModel() {


    private val _talkList = MutableLiveData<List<TalkVO>>()

    val talkList: LiveData<List<TalkVO>> get() = _talkList

    init {
        val list = mutableListOf<TalkVO>()
        repeat(100) {
            list.add(
                TalkVO(
                    "$it",
                    "ENHYPEN",
                    "성훈",
                    "여름 사진",
                    "안녕하세요?$it",
                    1,
                    1,
                    it,
                    System.currentTimeMillis(),
                    "https://d1sut5kn3lwnf7.cloudfront.net/media/photocard/2022/07/05/40e078d1c93d4857a8edca8eb19ba20c.jpg"
                )
            )
        }
        _talkList.postValue(list)
    }

}