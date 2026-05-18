package com.example.simonprototype

import android.graphics.Color
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter(
    private val list: List<Item>,
    private val onItemClick: (Item) -> Unit
) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.score_element, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        holder.numberView.text = item.number.toString()

        val spannable = SpannableString(item.text)
        val convertedindex = 3 * item.index

        if (convertedindex < item.text.length && convertedindex >= 0) {
            spannable.setSpan(ForegroundColorSpan(Color.RED), convertedindex, item.text.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
        holder.textView.text = spannable

        holder.itemView.setOnClickListener {
            onItemClick(item)
        }
    }

    override fun getItemCount(): Int = list.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val numberView: TextView = itemView.findViewById(R.id.numberSequence)
        val textView: TextView = itemView.findViewById(R.id.textSequence)
    }
}