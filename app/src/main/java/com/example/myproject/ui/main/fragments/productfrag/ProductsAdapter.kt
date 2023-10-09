package com.example.myproject.ui.main.fragments.productfrag

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myproject.data.models.ProductsModel
import com.example.myproject.databinding.ItemProductsBinding

class ProductsAdapter(private var list: MutableList<ProductsModel>) :
    RecyclerView.Adapter<ProductsAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemBinding = ItemProductsBinding.inflate(
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

    inner class MyViewHolder(private val itemBinding: ItemProductsBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(item: ProductsModel) {

            itemBinding.productModel = item

        }
    }

}

