package com.example.recursivenavigation.entity


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.recursivenavigation.util.Constants.TREE_TABLE
import com.example.recursivenavigation.util.SHA.sha3_256
import com.google.gson.annotations.SerializedName

@Entity(tableName = TREE_TABLE)
data class TreeNode (var value:String){

    @PrimaryKey(autoGenerate = false)
    var id :Int  = 0

    @Transient
    var parent:TreeNode ? = null

    @SerializedName("children")
    var children:MutableList<TreeNode> = mutableListOf()

    val name: String
        get() = value.toByteArray().sha3_256().takeLast(20).toString()

    override fun toString(): String {
        var s = "${value}"
        if (!children.isEmpty()) {
            s += " {" + children.map { it.toString() } + " }"
        }
        return s
    }

    fun addChild(node:TreeNode){
        children.add(node)
        node.parent = this
    }

    fun removeChild(node: TreeNode) {
        children.remove(node)
        node.parent = null
    }

}