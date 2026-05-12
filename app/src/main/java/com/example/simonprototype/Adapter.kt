package com.example.simonprototype

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.text.style.ForegroundColorSpan
import android.text.Spannable
import android.text.SpannableString


class Adapter(private val list: List<Item>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.score_element, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = list[position]

        // sets the image to the imageview from our itemHolder class
        holder.numberView.text = item.number.toString()

        val spannable = SpannableString(item.text)

        //index maps: 0 to 0, 1 to 3, 2 to 6, 3 to 9...
        //maybe remove spaces?
        val index = item.index

        val convertedindex = 3 * index

        spannable.setSpan(ForegroundColorSpan(Color.RED), convertedindex,item.text.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

        // sets the text to the textview from our itemHolder class
        holder.textView.text = spannable


    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return list.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val numberView: TextView = itemView.findViewById(R.id.numberSequence)
        val textView: TextView = itemView.findViewById(R.id.textSequence)
    }
}