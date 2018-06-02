package com.learn.archwithkotlin.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "question")
data class QuestionModel(@PrimaryKey val question:String, val optA :String, val optB :String, val optC :String, val answer :String)