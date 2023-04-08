package com.example.recursivenavigation.ui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recursivenavigation.R
import com.example.recursivenavigation.adapters.TreeAdapter
import com.example.recursivenavigation.databinding.ActivityMainBinding
import com.example.recursivenavigation.entity.TreeNode
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() , OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var  adapter: TreeAdapter
    private val viewModel : NodeViewModel by viewModels()
    private lateinit var treeNode :TreeNode
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        treeNode = TreeNode("root")
        getTree()
        setRecycler(treeNode)
        setListeners()

    }

    private fun getTree() {
        viewModel.getTree()
        viewModel.tree.observe(this@MainActivity, Observer {
           if(it!= null) {
               Log.d(TAG, "getTree: $it ")
                treeNode = it
                adapter.updateAdapter(treeNode)
            }else Log.d(TAG, "getTree: null")
        })
    }

    private fun setRecycler(child: TreeNode) {
        binding.apply {
            adapter = TreeAdapter(child){
                adapter.updateAdapter(it)
                if(it.children.isEmpty()) hideRecycler()
            }

            recycleView.adapter = adapter
            recycleView.layoutManager = LinearLayoutManager(this@MainActivity)

            ItemTouchHelper(itemTouchHelperCallback).apply {
                attachToRecyclerView(recycleView)
            }
        }

    }

    private fun showRecycler() {
       binding.apply {
           recycleView.visibility = View.VISIBLE
           linearlayout.visibility = View.GONE
       }
    }

    private fun hideRecycler() {
       binding.apply {
           recycleView.visibility = View.GONE
           linearlayout.visibility = View.VISIBLE
       }
    }

    private fun setListeners(){
       binding.apply {
           buRoot.setOnClickListener(this@MainActivity)
           buNewItem.setOnClickListener(this@MainActivity)
       }
    }

    override fun onClick(v: View?) {
       binding.apply {
           when(v?.id){
               buRoot.id ->{
                   showRecycler()
                   getTree()
               }
               buNewItem.id ->{
                   val value = etNewItem.text.toString()
                   if(value.isNotEmpty()){

                       adapter.addChild(value)
                       Log.d(TAG, "onClick: $treeNode")
                       viewModel.upsertTree(treeNode)

                       etNewItem.text.clear()
                       if(!recycleView.isVisible) showRecycler()
                   }
               }
           }
       }
    }

    private val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(
        ItemTouchHelper.UP or ItemTouchHelper.DOWN,
        ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
    ){
        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
            return true
        }

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val position = viewHolder.adapterPosition
            val node = adapter.getList().children[position]
            adapter.removeChild(position)

            viewModel.upsertTree(treeNode)

            Snackbar.make(findViewById(android.R.id.content), getString(R.string.snackBarMessage), Snackbar.LENGTH_LONG).apply {
                setAction(getString(R.string.undo)) {

                    adapter.addChild(node.value)
                    viewModel.upsertTree(treeNode)

                }
                show()
            }
        }
    }
}