package com.learn.archwithkotlin.view

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.learn.archwithkotlin.R
import com.learn.archwithkotlin.databinding.QuestionItemBinding
import com.learn.archwithkotlin.model.QuestionModel

class QuestionsAdapter(val context: Context, val questions: List<QuestionModel>?) : RecyclerView.Adapter<QuestionsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: QuestionItemBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.question_item, parent, false);
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return questions?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val question = questions?.get(position)
        holder.binding.questionItem = question
        holder.binding.executePendingBindings()
    }

    class ViewHolder(val binding: QuestionItemBinding) : RecyclerView.ViewHolder(binding.root)

}

