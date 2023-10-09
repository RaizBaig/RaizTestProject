package com.example.myproject.ui.main.fragments.categoryfrag

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myproject.data.models.CategoryModel
import com.example.myproject.data.repository.RetrofitClient
import com.google.gson.Gson
import com.google.gson.JsonParseException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryFragVM : ViewModel() {
    private var _categoryList = MutableLiveData<List<CategoryModel>>()
    var categoryList: LiveData<List<CategoryModel>> = _categoryList

   /* init {
//        getCategory()
    }*/

    private fun getCategory() {
        viewModelScope.launch(Dispatchers.IO) {
            var list = ArrayList<CategoryModel>()
            RetrofitClient.userService.getCategory()
                .enqueue(object : Callback<List<CategoryModel>> {
                    override fun onResponse(
                        call: Call<List<CategoryModel>>,
                        response: Response<List<CategoryModel>>
                    ) {
                        val gson = Gson()
                        val list = ArrayList<CategoryModel>()

                        try {
                            if (response.body() != null) {

                                for (i in response.body()!!) {
                                    val dataArray = gson.fromJson(
                                        response.toString(),
                                        CategoryModel::class.java
                                    )
                                    list.add(dataArray)
                                }
                                if (list.isNotEmpty()) {
                                    _categoryList.postValue(list)
                                }
                            }
                        } catch (e: JsonParseException) {
                            try {

                                for (i in response.body()!!) {
                                    val dataObject = gson.fromJson(
                                        response.toString(),
                                        CategoryModel::class.java
                                    )
                                    list.add(dataObject)
                                }

                                if (list.isNotEmpty()) {
                                    _categoryList.postValue(list)
                                }

                            } catch (e: JsonParseException) {
                                e.printStackTrace()
                            }
                        }

                    }

                    override fun onFailure(call: Call<List<CategoryModel>>, t: Throwable) {

                    }

                }
                )

        }

    }
}