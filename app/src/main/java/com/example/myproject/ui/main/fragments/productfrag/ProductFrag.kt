package com.example.myproject.ui.main.fragments.productfrag

import android.os.Bundle
import android.view.View
import com.example.myproject.R
import com.example.myproject.data.models.ProductsModel
import com.example.myproject.databinding.FragmentProductsBinding
import com.example.myproject.ui.main.fragments.base.BaseFragment

class ProductFrag : BaseFragment(R.layout.fragment_products) {
    private lateinit var binding: FragmentProductsBinding
    private lateinit var productsAdapter: ProductsAdapter
    private val list = ArrayList<ProductsModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentProductsBinding.bind(view)
        val categoryName = arguments?.getString("category")
        setUi(categoryName!!)
        setOnClickListeners()
    }

    private fun setOnClickListeners() {

    }

    private fun setUi(categoryCode: String) {
        list.add(
            ProductsModel(
                idProduct = "01",
                productName = "Chicken fry",
                ingredients = R.string.chicken_fry,
                categoryCode = "Chicken"
            )
        )
        list.add(
            ProductsModel(
                idProduct = "02",
                productName = "Chicken 65",
                ingredients = R.string.chicken_65,
                categoryCode = "Chicken"
            )
        )
        list.add(
            ProductsModel(
                idProduct = "02",
                productName = "Chicken Afghani",
                ingredients = R.string.chicken_afghani,
                categoryCode = "Chicken"
            )
        )

        list.add(
            ProductsModel(
                idProduct = "01",
                productName = "Mutton fry",
                ingredients = R.string.mutton_fry,
                categoryCode = "Mutton"
            )
        )
        list.add(
            ProductsModel(
                idProduct = "02",
                productName = "Mutton Curry",
                ingredients = R.string.mutton_curry,
                categoryCode = "Mutton"
            )
        )
        list.add(
            ProductsModel(
                idProduct = "02",
                productName = "Mutton Curry",
                ingredients = R.string.mutton_afghani,
                categoryCode = "Mutton"
            )
        )
        val filteredList = list.filter {
            it.categoryCode == categoryCode
        }
        productsAdapter = ProductsAdapter(filteredList.toMutableList())
        binding.productsRv.adapter = productsAdapter
    }

}