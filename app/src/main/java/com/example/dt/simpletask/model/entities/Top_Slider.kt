package com.example.dt.simpletask.model.entities

import com.google.gson.annotations.SerializedName



class Top_Slider {

    @SerializedName("list")
    private var categories: List<CategoriesTopSlider>? = null


    fun setCategoriesTopSlider(categoriestopslider: List<CategoriesTopSlider>?) {
        this.categories = categories
    }

    fun getCategoriesTopSlider(): List<CategoriesTopSlider>? {
        return categories
    }

}