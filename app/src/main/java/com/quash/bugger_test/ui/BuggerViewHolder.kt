package com.quash.bugger_test.ui

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.quash.bugger_test.databinding.RowBuggerBinding

class BuggerViewHolder(private val binding : RowBuggerBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bindData(item: com.quash.bugger_test.data.Character?) {
        item?.let { marvelEntity ->
            Glide.with(itemView.context)
                .load(marvelEntity.img)
                .into(binding.imageView)

            binding.tvCrashTitle.text = marvelEntity.name
        }
    }
}