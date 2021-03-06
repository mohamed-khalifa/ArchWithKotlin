package com.learn.archwithkotlin.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.learn.archwithkotlin.R
import com.learn.archwithkotlin.model.QuestionModel
import com.learn.archwithkotlin.viewmodel.QuestionViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.longToast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel: QuestionViewModel = ViewModelProviders.of(this).get(QuestionViewModel::class.java)

        val questionsObserver = Observer<List<QuestionModel>> {
            recyclerViewQuestions.adapter = QuestionsAdapter(this, it)
        }
        val errorObserver = Observer<String> {
            it?.let { errorMessage -> longToast(errorMessage) }
        }
        viewModel.initObservers()
        viewModel.questions.observe(this, questionsObserver)
        viewModel.error.observe(this, errorObserver)
        viewModel.getQuestionsList()
    }
}
