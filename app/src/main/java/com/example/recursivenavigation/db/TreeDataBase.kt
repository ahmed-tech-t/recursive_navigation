package com.example.recursivenavigation.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.recursivenavigation.entity.TreeNode
import com.example.recursivenavigation.util.Constants.DATABASE_NAME


@Database(
    entities = [TreeNode::class],
    version = 3
)
@TypeConverters(Converters::class)
abstract class TreeDataBase : RoomDatabase(){
    abstract fun getDaoApi(): DaoApi

    companion object{
        const val databaseName: String = DATABASE_NAME
    }
}