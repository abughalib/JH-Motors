package com.abu.ghalib.abumotors.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.abu.ghalib.abumotors.ui.network.AppApi
import com.abu.ghalib.abumotors.ui.network.AppProperty
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

enum class AppApiStatus { LOADING, ERROR, DONE }

class HomeViewModel : ViewModel() {

    private val _status = MutableLiveData<AppApiStatus>()
    val status: LiveData<AppApiStatus>
        get() = _status

    private val _properties = MutableLiveData<List<AppProperty>>()
    val properties: LiveData<List<AppProperty>>
        get() = _properties

    private var viewModelJob = Job()
    private val coroutineScope = CoroutineScope(
        viewModelJob + Dispatchers.Main)

    init {
        getProperties()
    }

    private fun onClickImage(){

    }

    private fun getProperties(){
        coroutineScope.launch {
            _status.value = AppApiStatus.LOADING
            val getPropertiesDeferred = AppApi.retrofitService.getPropertiesAsync()
            try {
                _status.value = AppApiStatus.LOADING
                val listResult = getPropertiesDeferred.await()
                _status.value = AppApiStatus.DONE
                _properties.value = listResult
            }catch (e: Exception){
                _status.value = AppApiStatus.ERROR
                _properties.value = ArrayList()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

}
