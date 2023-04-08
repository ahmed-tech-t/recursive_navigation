package com.example.recursivenavigation.entity


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.recursivenavigation.util.Constants.TREE_TABLE
import com.google.gson.annotations.SerializedName
import java.security.MessageDigest

@Entity(tableName = TREE_TABLE)
data class TreeNode (var value:String){

    @PrimaryKey(autoGenerate = false)
    var id :Int  = 0

    @Transient
    var parent:TreeNode ? = null

    @SerializedName("children")
    var children:MutableList<TreeNode> = mutableListOf()

    var name: String = ""

    init {
        // Compute SHA-256 hash of the value property
        val digest = MessageDigest.getInstance("SHA-256")
        val hash = digest.digest(value.toByteArray(Charsets.UTF_8))

        // Extract last 20 bytes of the hash and use as the name
        val nameBytes = hash.sliceArray(hash.size - 20 until hash.size)
        name = nameBytes.joinToString("") { String.format("%02x", it) }
    }


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