package com.example.weatherapp.di

import android.app.Activity
import com.example.weatherapp.data.CurrentConditions
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class ApplicationModule {

    @Provides
    fun provideCurrentConditions(): CurrentConditions{
        return CurrentConditions(90f, "St.Paul, Mn")

    }
}