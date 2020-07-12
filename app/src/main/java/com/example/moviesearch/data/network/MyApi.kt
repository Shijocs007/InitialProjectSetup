package com.example.moviesearch.data.network

import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

interface MyApi {

    @GET("/planetary/apod")
    suspend fun getImageData() : Response<Unit>

    @GET("/planetary/apod")
    suspend fun getImageData(@Query("date") date : String) : Response<Unit>


    companion object {
        operator fun invoke(
            networkConnectionIntercepter: NetworkConnectionIntercepter
        ) : MyApi {

            val okhttpclient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionIntercepter)
                .build()


            return Retrofit.Builder()
                .client(okhttpclient)
                .baseUrl("https://api.nasa.gov")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }
}