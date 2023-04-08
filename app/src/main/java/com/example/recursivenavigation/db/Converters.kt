package com.example.recursivenavigation.db

import androidx.room.TypeConverter
import com.example.recursivenavigation.entity.TreeNode
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class Converters {
    @TypeConverter
    fun fromTreeNodeToGson(node: TreeNode? ):String =  Gson().toJson(node)

    @TypeConverter
    fun fromGsonToTreeNode(treeNodeString: String): TreeNode = Gson().fromJson(treeNodeString , TreeNode::class.java)

    @TypeConverter
    fun fromJson(json: String): MutableList<TreeNode> {
        val listType = object : TypeToken<MutableList<TreeNode>>() {}.type
        return Gson().fromJson(json, listType)
    }

    @TypeConverter
    fun toJson(list: MutableList<TreeNode>): String {
        return Gson().toJson(list)
    }
}