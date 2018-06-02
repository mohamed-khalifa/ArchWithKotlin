package com.learn.archwithkotlin.network

import com.learn.archwithkotlin.model.QuestionModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiRetrofit {
    @GET("questions.json")
    fun getQuestions():Call<List<QuestionModel>>
}