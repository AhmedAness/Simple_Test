package com.example.dt.simpletask.model.entities


import com.google.gson.annotations.SerializedName




class GeneralResponse<T> {

    @SerializedName("code")
    private var code: Int? = null

    @SerializedName("msg")
    private var msg: String? = null

    @SerializedName("item")
    private var data: T? = null



    fun getmsg(): String? {
        return msg
    }

    fun setMessage(msg: String?) {
        this.msg = msg
    }

    fun getcode(): Int? {
        return code
    }

    fun setcode(code: Int?) {
        this.code = code
    }
    fun getData(): T? {
        return data
    }

    fun setData(data: T?) {
        this.data = data
    }



}