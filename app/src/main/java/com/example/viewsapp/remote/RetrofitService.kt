package com.example.viewsapp.remote

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {

    private fun interceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BASIC
        return interceptor
    }

    // client bertugas sebagai alat penghubung ke server
    // di sini tempat kita memasukkan Interceptor
    private val client = OkHttpClient.Builder()
        .addInterceptor(RequestInterceptor())
        .addInterceptor(interceptor())
        .build()

    // retrofit bertugas sebagai pengatur client
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://newsapi.org/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    fun <T> buildService(service: Class<T>): T {
        return retrofit.create(service)
    }
}

class RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val requestBuilder = originalRequest.newBuilder()
        requestBuilder.addHeader("Authorization", "6302d5c9ee20476b8f11df692f3a818c")
        val request = requestBuilder.build()
        return chain.proceed(request)
    }

//    private val client = OkHttpClient.Builder().addInterceptor(RequestInterceptor()).build()
//
//    private val retrofit = Retrofit.Builder()
//        .baseUrl("https://newsapi.org/")
//        .addConverterFactory(GsonConverterFactory.create())
//        .client(client)
//        .build()
//
//    fun <T> buildService(service: Class<T>): T {
//        return retrofit.create(service)
//    }
//}
//
//class RequestInterceptor : Interceptor {
//    override fun intercept(chain: Interceptor.Chain): Response {
//        val originalRequest = chain.request()
//        val requestBuilder = originalRequest.newBuilder()
//        requestBuilder.addHeader("Authorization", "6302d5c9ee20476b8f11df692f3a818c")
//        val request = requestBuilder.build()
//        return chain.proceed(request)
//    }
}