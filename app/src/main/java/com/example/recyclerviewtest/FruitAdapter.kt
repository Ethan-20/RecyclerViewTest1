package com.example.recyclerviewtest


import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Ethan On 2022/3/25 14:49
 * God bless my code!
 */

class FruitAdapter(private val fruitList: List<Fruit>) : RecyclerView.Adapter<FruitAdapter.ViewHolder>() {
    val TAG = "FruitAdapter"
    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val fruitImage: ImageView = view.findViewById(R.id.fruitImage)
        val fruitName: TextView = view.findViewById(R.id.fruitName)
    }
    /**
     * 创建条目时调用的方法
     * Create new views (invoked by the layout manager)
     * parent	ViewGroup: The ViewGroup into which the new View will be added after it is bound to an adapter position.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //首先要找到条目，然后返回承载着该条目的ViewHolder
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fruit_item, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener {
//            val position = viewHolder.adapterPosition
//            val fruit = fruitList[position]
//            Toast.makeText(parent.context,"you clicked view ${fruit.name}",Toast.LENGTH_SHORT).show()
            Log.d(TAG,viewHolder.toString()+"CLICKDDDDDD???")
        }
        viewHolder.fruitImage.setOnClickListener {
//            val position = viewHolder.adapterPosition
//            val fruit = fruitList[position]
//            Toast.makeText(parent.context, "you clicked image ${fruit.name}", Toast.LENGTH_SHORT).show()
            Log.d(TAG,viewHolder.toString()+"CLICKDDDDDD???")
        }
        Log.d(TAG,viewHolder.toString()+"waitingForBounding")
        return ViewHolder(view)
    }

    /**
     * 为条目绑定数据时调用的方法
     * Replace the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        Log.d(TAG,holder.toString()+"hasBounded")
        val fruit = fruitList[position]
        holder.fruitImage.setImageResource(fruit.imageId)
        holder.fruitName.text=fruit.name
        holder.itemView.setOnClickListener {
            Log.d(TAG,holder.toString()+"CLICKDDDDDD")
        }
        holder.fruitImage.setOnClickListener {
            Log.d(TAG,holder.toString()+"CLICKDDDDDD")
        }
    }

    /**
     * 获取条目总数
     */
    override fun getItemCount(): Int = fruitList?.size ?: 0


}

