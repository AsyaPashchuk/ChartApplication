package com.example.chartapplication.core.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment : DaggerFragment() {

    @Inject
    lateinit var vmFactory: ViewModelProvider.Factory

    protected inline fun <reified T: ViewModel> getViewModel(): T =
        ViewModelProvider(this, vmFactory)[T::class.java]

    abstract fun observeVM()
}