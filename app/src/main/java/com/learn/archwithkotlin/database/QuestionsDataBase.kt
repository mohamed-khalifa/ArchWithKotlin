package com.learn.archwithkotlin.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.learn.archwithkotlin.model.QuestionModel

@Database(entities = arrayOf(QuestionModel::class), version = 1)
abstract class QuestionsDataBase : RoomDatabase() {
    abstract fun questionDao(): QuestionDao
    companion object {
        private var INSTANCE: QuestionsDataBase? = null
        fun getInstance(context: Context): QuestionsDataBase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext, QuestionsDataBase::class.java, "question.db")
                .build()
            }
            return INSTANCE
        }
    }
}