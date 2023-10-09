package com.example.myproject.ui.main.fragments.categoryfrag

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myproject.data.models.CategoryModel
import com.example.myproject.databinding.ItemCategoryBinding

class CategoryAdapter(private var list: MutableList<CategoryModel>):RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemBinding = ItemCategoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return MyViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(list[position])

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class MyViewHolder(private val itemBinding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(item: CategoryModel) {

            itemBinding.categoryModel = item

            itemBinding.cardView.setOnClickListener {
                itemClickListener?.let {
                    it(item, adapterPosition)
                }
            }
        }
    }

    private var itemClickListener: ((item: CategoryModel, position: Int) -> Unit)? = null
    fun itemClickListener(listener: (item: CategoryModel, position: Int) -> Unit) {
        this.itemClickListener = listener
    }
}

