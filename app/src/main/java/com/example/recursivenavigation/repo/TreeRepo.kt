package com.example.recursivenavigation.repo

import java.lang.Exception
import com.example.recursivenavigation.db.DaoApi
import com.example.recursivenavigation.entity.Resource
import com.example.recursivenavigation.entity.TreeNode
import javax.inject.Inject

class TreeRepo @Inject constructor(private val daoApi: DaoApi) {

    suspend fun getTree (): Resource<TreeNode> = try {
        Resource.Success(daoApi.getTree())
    }catch (ex :Exception){
         Resource.Error("Error : ${ex.message}")
    }

    suspend fun upsertTree(treeNode: TreeNode)  = daoApi.upsertTree(treeNode)
}