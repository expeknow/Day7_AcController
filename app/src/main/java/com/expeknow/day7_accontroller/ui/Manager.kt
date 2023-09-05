package com.expeknow.day7_accontroller.ui

import androidx.compose.runtime.mutableStateOf

class Manager {

    val currentSelectedChipName = mutableStateOf("Cool")

    fun changeSelectedChipName(name: String){
        currentSelectedChipName.value = name
    }


}