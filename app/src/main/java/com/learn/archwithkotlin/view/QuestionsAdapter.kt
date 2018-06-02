package com.learn.archwithkotlin.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.learn.archwithkotlin.R
import com.learn.archwithkotlin.model.QuestionModel
import kotlinx.android.synthetic.main.question_item.view.*

class QuestionsAdapter( val context: Context,val questions: List<QuestionModel>?) : RecyclerView.Adapter<QuestionsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      return ViewHolder(LayoutInflater.from(context).inflate(R.layout.question_item, parent, false))
    }

    override fun getItemCount(): Int {
        return questions?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val question = questions?.get(position)
        holder.questions.text = question?.question
        holder.choiceATextView.text = question?.optA
        holder.choiceBTextView.text = question?.optB
        holder.choiceCTextView.text = question?.optC
        holder.answer.text = question?.answer
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val questions = view.questionTextView
        val choiceATextView = view.choiceATextView
        val choiceBTextView = view.choiceBTextView
        val choiceCTextView = view.choiceCTextView
        val answer = view.answerTextView

    }

}

