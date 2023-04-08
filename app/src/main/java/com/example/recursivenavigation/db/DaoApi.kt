package com.example.recursivenavigation.db

import androidx.room.*
import com.example.recursivenavigation.entity.TreeNode
import com.example.recursivenavigation.util.Constants.TREE_TABLE

@Dao
interface DaoApi {

    @Query("Select * from $TREE_TABLE")
    suspend fun getTree():TreeNode

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertTree (treeNode: TreeNode)
}