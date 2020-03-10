package com.jahid.hakim.jhmotors.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.jahid.hakim.jhmotors.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class HomeViewModel : ViewModel() {

   /* private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    */

    private var _bikeImage = MutableLiveData<ArrayList<Int>>()
    private var _bikeTitle = MutableLiveData<ArrayList<String>>()
    private var _bikeDesc = MutableLiveData<ArrayList<String>>()

    init {

        _bikeImage.value = ArrayList()
        _bikeTitle.value = ArrayList()
        _bikeDesc.value = ArrayList()

        addBike()
        addTitle()
        addDesc()
    }

    val bikeImage: LiveData<ArrayList<Int>>
    get() = _bikeImage

    val bikeTitle: LiveData<ArrayList<String>>
    get() = _bikeTitle

    val bikeDesc: LiveData<ArrayList<String>>
    get() = _bikeDesc

    private fun addBike(){
        var values: Int
        for (i:Int in 1..10){
            values = when(i){
                1 -> R.drawable.one
                2 -> R.drawable.two
                3 -> R.drawable.three
                4 -> R.drawable.four
                5 -> R.drawable.five
                6 -> R.drawable.six
                7 -> R.drawable.seven
                8 -> R.drawable.eight
                9 -> R.drawable.nine
                else -> R.drawable.abughalib
            }
            _bikeImage.value?.add(values)
        }
    }
    private fun addTitle(){
        var values: String
        for (i:Int in 1..10){
            values = when(i){
                1 -> "KTM - xxx"
                2 -> "KTM - Duke 125"
                3 -> "KTM - RC8"
                4 -> "Suzuki - Gixxer SF"
                5 -> "KTM - RC 390"
                6 -> "Bajaj - Pulsar 400"
                7 -> "BMW - R 200"
                8 -> "Dibble Rosso"
                9 -> "Rock"
                else -> "None"
            }
            _bikeTitle.value?.add(values)
        }
    }
    private fun addDesc(){
        var values: String
        for (i:Int in 1..10){
            values = when(i){
                1 -> "Something must be written down here\nAnd Content Description about bikes"
                2 -> "Something must be written down here\nAnd Content Description about bikes"
                3 -> "Something must be written down here\nAnd Content Description about bikes"
                4 -> "Something must be written down here\nAnd Content Description about bikes"
                5 -> "Something must be written down here\nAnd Content Description about bikes"
                6 -> "Something must be written down here\nAnd Content Description about bikes"
                7 -> "Something must be written down here\nAnd Content Description about bikes"
                8 -> "Something must be written down here\nAnd Content Description about bikes"
                9 -> "Something must be written down here\nAnd Content Description about bikes"
                else -> "Value of something unknown\nAnd Content Description about bikes"
            }
            _bikeDesc.value?.add(values)
        }
    }

}
