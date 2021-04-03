package com.example.dt.simpletask.model.entities

import com.google.gson.annotations.SerializedName



class ConcatedAPIResult {

    @SerializedName("category")
    private var CategoryModels: List<CategoryModel>? = null

    @SerializedName("whats_new")
    private var WhatsNew: List<WhatsNew>? = null

    @SerializedName("trending")
    private var Trending: List<Trending>? = null

    @SerializedName("list")
    private var categoriestopslider: List<CategoriesTopSlider>? = null

    fun getcategories(): List<CategoryModel>? {
        return CategoryModels
    }

    fun setcategories(CategoryModels: List<CategoryModel>?) {
        this.CategoryModels = CategoryModels
    }

    fun settrending(Trending: List<Trending>?) {
        this.Trending = Trending
    }

    fun gettrending(): List<Trending>? {
        return Trending
    }

    fun setwhats_new(WhatsNew: List<WhatsNew>?) {
        this.WhatsNew = WhatsNew
    }

    fun getwhats_new(): List<WhatsNew>? {
        return WhatsNew
    }

    fun setCategoriesTopSlider(categoriestopslider: List<CategoriesTopSlider>?) {
        this.categoriestopslider = categoriestopslider
    }

    fun getCategoriesTopSlider(): List<CategoriesTopSlider>? {
        return categoriestopslider
    }




}