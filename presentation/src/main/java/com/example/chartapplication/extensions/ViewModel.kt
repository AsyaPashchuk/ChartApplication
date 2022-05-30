package com.example.chartapplication.extensions

import androidx.lifecycle.MutableLiveData

fun <T> mutable(value: T? = null): MutableLiveData<T> {
    return MutableLiveData<T>().apply {
        value?.let { this.value = it }
    }
}