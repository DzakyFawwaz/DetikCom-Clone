package com.example.viewsapp.remote

import  com.example.viewsapp.remote.pojo.ResponseNews
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInterface {

    // Get URL Path : v2/top-headlines
    // htttp:/newsapi.org/v2/top-headlines
    @GET("/v2/top-headlines")
    suspend fun topheadlines(
        // Menambah Query country sehingga url menjadi
        // http://newsapi.org/v2/top-headlines?country=id
        @Query ("country") country : String
    ) : Response<ResponseNews>
}
