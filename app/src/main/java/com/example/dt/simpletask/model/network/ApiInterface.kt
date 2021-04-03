package com.example.dt.simpletask.model.network


import com.example.dt.simpletask.model.entities.GeneralResponse
import com.example.dt.simpletask.model.entities.Top_Slider
import com.example.dt.simpletask.model.entities.User
import com.example.dt.simpletask.model.entities.trending_new
import io.reactivex.rxjava3.core.Single
import retrofit2.http.*


interface ApiInterface {

  @POST("login/")
    fun loginResult( @Body user: User):
          Single<GeneralResponse<String>>


  @POST("getHome/")
  suspend fun getHomeList():
          GeneralResponse<trending_new>

  @POST("getCategory/")
  suspend fun getCatList():
          GeneralResponse<Top_Slider>

}
