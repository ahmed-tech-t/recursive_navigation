package com.example.recursivenavigation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recursivenavigation.databinding.TreeNodeItemBinding
import com.example.recursivenavigation.entity.TreeNode


class TreeAdapter(private var rootNode: TreeNode , private val listener : (TreeNode)->Unit ) : RecyclerView.Adapter<TreeAdapter.NodeViewHolder>() {
    inner class NodeViewHolder(private val binding: TreeNodeItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(node: TreeNode) {
            binding.tvItem.text = node.name
            binding.root.setOnClickListener {
                listener(node)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NodeViewHolder {
        val binding = TreeNodeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NodeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NodeViewHolder, position: Int) {
        val node = rootNode.children[position]
        holder.bind(node)
    }

    override fun getItemCount(): Int = rootNode.children.size


    fun getList() = rootNode

    fun addChild(value: String){
        val newNode = TreeNode(value)
        rootNode.addChild(newNode)
        notifyItemInserted(rootNode.children.size - 1)
    }

    fun removeChild(position: Int) {
        val removedNode = rootNode.children[position]
        rootNode.removeChild(removedNode)
        notifyItemRemoved(position)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateAdapter(treeNode: TreeNode){
        rootNode = treeNode
        notifyDataSetChanged()
    }
}
