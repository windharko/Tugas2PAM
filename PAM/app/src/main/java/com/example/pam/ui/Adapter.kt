package com.example.pam.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pam.databinding.ItemCustomBinding

class Adapter(
    val list: ArrayList<ItemModel>,
    val listener:MyClickListener
):RecyclerView.Adapter<Adapter.MyView>() {
    inner class MyView(val itemBinding: ItemCustomBinding):RecyclerView.ViewHolder(itemBinding.root){
        val imageView: ImageView = itemBinding.imageView
        val textView: TextView = itemBinding.textView

        init {
            itemView.setOnClickListener{
                val position=adapterPosition
                if(position !=RecyclerView.NO_POSITION){
                    listener.onClick(position)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {

        return MyView(ItemCustomBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        val item = list[position]
        holder.itemBinding.imageView.setImageResource(item.photoItem)
        holder.itemBinding.textView.text = item.itemName


    }

    interface MyClickListener{
        fun onClick(position: Int)
    }
}