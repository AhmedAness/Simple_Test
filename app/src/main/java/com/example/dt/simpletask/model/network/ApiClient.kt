package com.example.dt.simpletask.model.network

import android.util.Log
import com.example.dt.simpletask.utilities.apiKey
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class ApiClient {

    private var retrofit: Retrofit? = null
    private val requestTimeOut: Long = 20


    fun getClient( /*String portNumber*/
        base: ApiBase
    ): Retrofit? {
        val gson: Gson = GsonBuilder()
            .setLenient()
            .create()

        val okHttpClient = OkHttpClient.Builder().apply {
            addInterceptor(
                Interceptor { chain ->
                    val builder = chain.request().newBuilder()
                    builder.header("lang", "en")
                    builder.header("apiKey", apiKey)
                    return@Interceptor chain.proceed(builder.build())
                }
            )
        }
            .connectTimeout(requestTimeOut, TimeUnit.SECONDS)
            .readTimeout(requestTimeOut, TimeUnit.SECONDS)
            .writeTimeout(requestTimeOut, TimeUnit.SECONDS)
            .build()
        if (retrofit == null) {
            val url: String = base.toString()
            Log.e("url**", url)
            retrofit = Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
        }
        return retrofit
    }
}