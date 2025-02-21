package com.example.registeraddresstestapp.di

import com.example.registeraddresstestapp.api.NeshanApi
import com.example.registeraddresstestapp.utils.Utils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NeshanApiModule {



    @Provides
    @Singleton
    @Named(Utils.NESHAN)
    fun provideOkHttpClient() = OkHttpClient.Builder()
        .writeTimeout(60L, TimeUnit.SECONDS)
        .readTimeout(60L, TimeUnit.SECONDS)
        .connectTimeout(60L, TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
        .build()


    @Provides
    @Singleton
    fun provideApi(
        @Named(Utils.NESHAN) client: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ) =
        Retrofit.Builder()
            .baseUrl(Utils.BASE_NESHAN_URL)
            .client(client)
            .addConverterFactory(gsonConverterFactory)
            .build()
            .create(NeshanApi::class.java)

}