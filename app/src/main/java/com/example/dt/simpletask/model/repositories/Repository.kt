package com.example.dt.simpletask.model.repositories

import com.example.dt.simpletask.model.entities.GeneralResponse
import com.example.dt.simpletask.model.entities.Top_Slider
import com.example.dt.simpletask.model.entities.User
import com.example.dt.simpletask.model.entities.trending_new
import com.example.dt.simpletask.model.network.ApiBase
import com.example.dt.simpletask.model.network.ApiClient
import com.example.dt.simpletask.model.network.ApiInterface
import io.reactivex.rxjava3.core.Single


class Repository {

    private var apiClient: ApiClient? = null
    private var apiInterface: ApiInterface? = null

    init {
        apiClient = ApiClient()
        apiInterface =
            apiClient!!.getClient(ApiBase.BASE_URL)!!.create(ApiInterface::class.java)
    }

    fun login(loginRequest: User): Single<GeneralResponse<String>> {
        return apiInterface!!.loginResult(loginRequest)
    }

    suspend fun getHome(): GeneralResponse<trending_new> {
        return apiInterface!!.getHomeList()
    }
    suspend fun getCat(): GeneralResponse<Top_Slider> {
        return apiInterface!!.getCatList()
    }
}
