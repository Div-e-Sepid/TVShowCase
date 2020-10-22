package com.boozt.tvshowcase.presentation

import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<T>.update(block: (T) -> T) {
    value = block(value!!)
}