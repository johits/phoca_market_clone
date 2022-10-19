package com.pm.data.di

import com.google.firebase.firestore.FirebaseFirestore
import com.pm.data.repository.RemoteDataRepository
import com.pm.data.repository.RemoteDataRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun dataRepository(database: FirebaseFirestore): RemoteDataRepository {
        return RemoteDataRepositoryImpl(database)
    }
}