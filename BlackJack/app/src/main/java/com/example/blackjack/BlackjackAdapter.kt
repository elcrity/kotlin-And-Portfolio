package com.example.blackjack

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.blackjack.R
import com.example.blackjack.databinding.ListCardBinding

class CardAdapter(private val dataList: MutableList<Card>) :
    RecyclerView.Adapter<CardAdapter.CardViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = ListCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(dataList[position])
        val layoutParams = holder.itemView.layoutParams
        layoutParams.width = 130
        holder.itemView.requestLayout()
    }

    override fun getItemCount() = dataList.size

    inner class CardViewHolder(val binding: ListCardBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Card) {
            binding.textView.text = """${data.suit}
                |${data.rank}
            """.trimMargin()
        }
    }
}