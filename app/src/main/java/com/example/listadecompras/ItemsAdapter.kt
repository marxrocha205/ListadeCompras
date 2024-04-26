package com.example.listadecompras

import android.annotation.SuppressLint
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    private val items: MutableList<ItemModel> = mutableListOf<ItemModel>()

    fun  addItem(newItem : ItemModel){
    items.add(newItem)
        notifyDataSetChanged()

    }
    fun removeItem(item: ItemModel){
        items.remove(item)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
       val item = items[position]
        holder.bind(item)
    }

    class ItemViewHolder(view : View): RecyclerView.ViewHolder(view) {
        val textView = view.findViewById<TextView>(R.id.textViewItem)
        val button = view.findViewById<Button>(R.id.imageButton)
        fun bind(item : ItemModel){
            textView.text = item.name
            button.setOnClickListener{
                item.onRemove(item)
            }
        }



    }
}