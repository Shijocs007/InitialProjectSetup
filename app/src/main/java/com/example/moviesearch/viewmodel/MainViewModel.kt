package com.example.moviesearch.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.moviesearch.data.repository.MainRepository
import com.example.moviesearch.utils.ApiException
import com.example.moviesearch.utils.Coroutines
import com.example.moviesearch.utils.NoInternetException

class MainViewModel(
    private val mainRepository: MainRepository
) : ViewModel() {

    private var errorMessage = MutableLiveData<String>()

    fun getImageData() {
        Coroutines.main {
            try {
                val result = mainRepository.getImageData()
                result.let {

                }
            } catch (e: ApiException) {
                errorMessage.value = e.message
            } catch (e : NoInternetException) {
                errorMessage.value = e.message
            }
        }
    }

    fun getImageData(date : String) {
        Coroutines.main {
            try {
                val result = mainRepository.getImageData(date)
                result.let {
                    mainRepository.insertImageData(it)
                }
            } catch (e: ApiException) {
                errorMessage.value = e.message
            } catch (e : NoInternetException) {
                errorMessage.value = e.message
            }
        }
    }


    fun getErrorMessage() : LiveData<String> {
        return errorMessage
    }
}