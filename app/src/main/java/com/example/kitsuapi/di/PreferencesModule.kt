package com.example.kitsuapi.di

import android.content.Context
import com.example.kitsuapi.data.local.preferences.PreferencesData
import com.example.kitsuapi.data.local.preferences.PreferencesHelper
import com.example.kitsuapi.data.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PreferencesModule {

    @Singleton
    val retrofitClient = RetrofitClient()

    @Singleton
    @Provides
    fun providePreferencesHelper(
        @ApplicationContext context: Context
    ) = PreferencesHelper(context)

    @Singleton
    @Provides
    fun providePreferenceData(preferencesHelper: PreferencesHelper) =
        PreferencesData(preferencesHelper)

    @Singleton
    @Provides
    fun providerSignInApiService() = retrofitClient.providerSignInApiService()
}