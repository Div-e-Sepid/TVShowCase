package com.boozt.tvshowcase.presentation

import android.view.View
import android.widget.Toast.LENGTH_SHORT
import androidx.lifecycle.MutableLiveData
import com.google.android.material.snackbar.Snackbar

fun <T> MutableLiveData<T>.update(block: (T) -> T) {
    value = block(value!!)
}

fun View.showSnackbar(message: String) =
    Snackbar.make(this, message, LENGTH_SHORT).show()