package com.example.recursivenavigation.ui

import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recursivenavigation.entity.Resource
import com.example.recursivenavigation.entity.TreeNode
import com.example.recursivenavigation.repo.TreeRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class NodeViewModel @Inject constructor(
    private val treeRepo: TreeRepo,
    ) :ViewModel() {
    private val TAG = "NodeViewModel"

    private var _tree: MutableLiveData<TreeNode> = MutableLiveData()
    var tree :LiveData<TreeNode> = _tree

    fun upsertTree(node: TreeNode) = viewModelScope.launch {
        treeRepo.upsertTree(node)
    }

    fun getTree() = viewModelScope.launch {

        when(val response = treeRepo.getTree()){
            is Resource.Error -> {
                Log.d(TAG, "getTree: ${response.message}")
            }
            is Resource.Success -> {
                _tree.value = response.data
            }
        }
    }
}