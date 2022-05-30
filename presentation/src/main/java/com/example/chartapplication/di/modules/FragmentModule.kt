package com.example.chartapplication.di.modules

import com.example.chartapplication.di.PerFragment
import com.example.chartapplication.feature.month.MonthChartFragment
import com.example.chartapplication.feature.week.WeekChartFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Module(includes = [(AndroidSupportInjectionModule::class)])
interface FragmentModule {

    @PerFragment
    @ContributesAndroidInjector
    fun weekChartFragment(): WeekChartFragment

    @PerFragment
    @ContributesAndroidInjector
    fun monthChartFragment(): MonthChartFragment
}