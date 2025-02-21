package com.example.registeraddresstestapp.di

import com.example.registeraddresstestapp.api.KarfarmasApi
import com.example.registeraddresstestapp.utils.BasicAuthInterceptor
import com.example.registeraddresstestapp.utils.Utils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object KarfarmasApiModule {


    @Provides
    @Singleton
    fun provideConverter() = GsonConverterFactory.create()



    @Provides
    @Singleton
    fun provideOkHttpClient() = OkHttpClient.Builder()
        .addInterceptor(BasicAuthInterceptor(Utils.USER_NAME, Utils.PASSWORD))
        .writeTimeout(60L, TimeUnit.SECONDS)
        .readTimeout(60L, TimeUnit.SECONDS)
        .connectTimeout(60L, TimeUnit.SECONDS)
        .retryOnConnectionFailure(true)
        .build()


    @Provides
    @Singleton
    fun provideApi(
        client: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ) =
        Retrofit.Builder()
            .baseUrl(Utils.BASE_KARFARMAS_URL)
            .client(client)
            .addConverterFactory(gsonConverterFactory)
            .build()
            .create(KarfarmasApi::class.java)

}