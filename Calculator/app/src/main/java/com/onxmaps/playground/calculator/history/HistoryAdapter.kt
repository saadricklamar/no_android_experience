package com.onxmaps.playground.calculator.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.onxmaps.playground.calculator.R
import kotlinx.android.synthetic.main.history_item.view.*


class HistoryAdapter : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    var historyItems = listOf<HistoryItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder =
        HistoryViewHolder(parent)

    override fun getItemCount(): Int = historyItems.size

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {

    }

    fun addItem(historyItem: HistoryItem) {

        notifyDataSetChanged()
    }

    fun removeItem(historyItem: HistoryItem) {

    }

    inner class HistoryViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.history_item,
            parent,
            false
        )
    ) {

        fun bind(historyItem: HistoryItem) = with(itemView) {
            first_number.text = historyItem.firstNumber.toString()
        }
    }
}