package com.learn.archwithkotlin.repository

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import com.learn.archwithkotlin.database.QuestionDao
import com.learn.archwithkotlin.database.QuestionsDataBase
import com.learn.archwithkotlin.model.QuestionModel
import com.learn.archwithkotlin.network.ApiConnection
import com.learn.archwithkotlin.network.ApiRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


object QuestionRepository {
    private var questionDao: QuestionDao? = null

    fun getQuestions(questions: MutableLiveData<List<QuestionModel>>, error: MutableLiveData<String>, application: Application) {
        val db = QuestionsDataBase.getInstance(application)
        questionDao = db?.questionDao()
        val questionsList = questionDao?.loadQuestions()

        if (questionsList != null && !questionsList.isEmpty()) {
            questions?.value = questionsList
            return
        }
        executeRequest(ApiConnection.getRetrofitCall().create(ApiRetrofit::class.java).getQuestions(), questions, error)
    }

    private fun executeRequest(questionsCall: Call<List<QuestionModel>>, questions: MutableLiveData<List<QuestionModel>>, error: MutableLiveData<String>) {
        questionsCall.enqueue(object : Callback<List<QuestionModel>> {
            override fun onFailure(call: Call<List<QuestionModel>>?, t: Throwable?) {
                error.value = "error"
            }

            override fun onResponse(call: Call<List<QuestionModel>>?, response: Response<List<QuestionModel>>?) {
                if (response?.body() != null) {
                    questionDao?.save(response.body()!!)
                    questions.value = response.body()
                } else {
                    error.value = "error"
                }
            }
        })
    }

}

