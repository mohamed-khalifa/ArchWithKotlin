package com.learn.archwithkotlin.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.learn.archwithkotlin.model.QuestionModel

@Dao
abstract class QuestionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun save(users: List<QuestionModel>)

    @Query("SELECT * FROM question")
    abstract fun loadQuestions():List<QuestionModel>


}