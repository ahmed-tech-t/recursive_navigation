package com.example.recursivenavigation.di

import android.content.Context
import androidx.room.Room
import com.example.recursivenavigation.db.DaoApi
import com.example.recursivenavigation.db.TreeDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context): TreeDataBase = Room.databaseBuilder(
        context,
        TreeDataBase::class.java,
        TreeDataBase.databaseName
    )
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideDao(treeDataBase: TreeDataBase): DaoApi = treeDataBase.getDaoApi()


}