package com.learn.archwithkotlin.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.learn.archwithkotlin.model.QuestionModel
import com.learn.archwithkotlin.repository.QuestionRepository


class QuestionViewModel(application: Application) : AndroidViewModel(application) {

    lateinit var questions: MutableLiveData<List<QuestionModel>>
    lateinit var error: MutableLiveData<String>
    var questionRepo: QuestionRepository = QuestionRepository
    var app: Application = application

    fun initObservers() {
        questions = MutableLiveData()
        error = MutableLiveData()
    }

    fun getQuestionsList() {
        questionRepo.getQuestions(questions, error, app)
    }

}