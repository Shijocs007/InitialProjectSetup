package com.example.moviesearch.data.repository

import com.example.moviesearch.data.db.AppDataBase
import com.example.moviesearch.data.network.MyApi
import com.example.moviesearch.data.network.SafeApiRequest


class MainRepository(
    private val api : MyApi,
    private val db : AppDataBase
) : SafeApiRequest() {


    suspend fun getImageData() : Unit {
        return apiRequest { api.getImageData() }
    }

    suspend fun getImageData(date : String) : Unit {
        return apiRequest { api.getImageData(date) }
    }

    suspend fun insertImageData(imageData: Unit) = db.getMyDao().insertData()

    suspend fun getImageDataDb() = db.getMyDao().geImagetData()

    suspend fun getImageDataDb(date: String) = db.getMyDao().geImagetData(date)

}