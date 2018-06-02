package com.learn.archwithkotlin

import android.app.Application
import com.learn.archwithkotlin.database.QuestionsDataBase

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        QuestionsDataBase.getInstance(this)
    }

}