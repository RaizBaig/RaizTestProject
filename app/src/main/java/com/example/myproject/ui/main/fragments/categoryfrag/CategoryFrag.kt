package com.example.myproject.ui.main.fragments.categoryfrag

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.myproject.R
import com.example.myproject.data.models.CategoryModel
import com.example.myproject.databinding.FragmentFirstBinding
import com.example.myproject.ui.main.fragments.base.BaseFragment

class CategoryFrag : BaseFragment(R.layout.fragment_first) {

    private lateinit var binding: FragmentFirstBinding
    private lateinit var viewModel: CategoryFragVM
    private lateinit var categoryAdapter: CategoryAdapter
    private val list = ArrayList<CategoryModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFirstBinding.bind(view)
        viewModel = CategoryFragVM()
        setOnClickListeners()
        setObserver()
    }

    private fun setOnClickListeners() {
        binding.also {
            list.clear()
            list.add(
                CategoryModel(
                    idCategory = "01",
                    strCategory = "Chicken",
                    strCategoryDescription = R.string.chicken_des
                )
            )
            list.add(
                CategoryModel(
                    idCategory = "02",
                    strCategory = "Mutton",
                    strCategoryDescription = R.string.mutton_des
                )
            )
            categoryAdapter = CategoryAdapter(list)
            val categoryAdt = categoryAdapter
            it.categoryRv.adapter = categoryAdapter

            categoryAdt.itemClickListener { item, position ->
                val bundle = Bundle()
                val stringValue = item.strCategory
                bundle.putString("category", stringValue)
                findNavController().navigate(R.id.action_categoryFragment_to_productsFragment, bundle)
            }

        }
    }

    private fun setObserver() {
        viewModel.categoryList.observe(this) {
            if (it.isNotEmpty()) {
                var data =""
            } else {
                Toast.makeText(binding.root.context, "No data found", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun setUi() {
        list.clear()
        list.add(
            CategoryModel(
                idCategory = "01",
                strCategory = "Chicken",
                strCategoryDescription = R.string.chicken_des
            )
        )
        list.add(
            CategoryModel(
                idCategory = "02",
                strCategory = "Mutton",
                strCategoryDescription = R.string.mutton_des
            )
        )
        categoryAdapter = CategoryAdapter(list)
        binding.categoryRv.adapter = categoryAdapter
    }


}

