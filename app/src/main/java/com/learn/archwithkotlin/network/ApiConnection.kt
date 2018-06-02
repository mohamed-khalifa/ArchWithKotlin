package com.learn.archwithkotlin.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ApiConnection {
   private lateinit var retrofit: Retrofit

    fun getRetrofitCall():Retrofit {
         retrofit = Retrofit.Builder()
                .baseUrl("http://unitypuzzlegame.com/json/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit
    }
}