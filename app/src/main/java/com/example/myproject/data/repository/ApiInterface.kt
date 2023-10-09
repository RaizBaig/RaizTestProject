package com.example.myproject.data.repository

import com.example.myproject.data.models.CategoryModel
import retrofit2.http.GET

interface CategoryService {
    @GET("categories.php")
    fun getCategory(): retrofit2.Call<List<CategoryModel >>
}

