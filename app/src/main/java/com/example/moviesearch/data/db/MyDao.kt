package com.example.moviesearch.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MyDao {

    @Insert
    suspend fun insertData()

   // @Query("SELECT * FROM imagedata WHERE date = :date LIMIT 1")
    suspend fun geImagetData(date : String) : Unit

   // @Query("SELECT * FROM imagedata ORDER BY uid desc LIMIT 1")
    suspend fun geImagetData() : Unit

}