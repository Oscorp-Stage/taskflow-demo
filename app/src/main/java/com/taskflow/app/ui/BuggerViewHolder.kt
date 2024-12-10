package com.taskflow.app.ui

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.taskflow.app.databinding.RowBuggerBinding

class BuggerViewHolder(private val binding : RowBuggerBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bindData(item: com.taskflow.app.data.Character?) {
        item?.let { marvelEntity ->
            Glide.with(itemView.context)
                .load(marvelEntity.img)
                .into(binding.imageView)

            binding.tvCrashTitle.text = marvelEntity.name
        }
    }
}