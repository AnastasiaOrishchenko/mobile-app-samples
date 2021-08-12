package com.example.numbers.ui.saved

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.numbers.R


class FactsRecyclerViewAdapter(private val facts: List<String>, private val context: Activity) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val rootView = LayoutInflater.from(context)
            .inflate(R.layout.fact_list_item, parent, false)
        return FactsRecyclerViewHolder(rootView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as FactsRecyclerViewHolder).text.text = facts[position]
    }

    override fun getItemCount(): Int {
        return facts.size
    }

    class FactsRecyclerViewHolder(
        itemView: View,
        val text: TextView = itemView.findViewById(R.id.factItem)
    ) : RecyclerView.ViewHolder(itemView)

}