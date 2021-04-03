package com.example.dt.simpletask.model.network

enum class ApiBase(baseurl: String) {
    BASE_URL("http://iconprojectss.com/2021/Tam/webServices/");

    private var baseUrl = ""

    override fun toString(): String {
        return baseUrl
    }

    init {
        baseUrl = baseurl
    }
}
