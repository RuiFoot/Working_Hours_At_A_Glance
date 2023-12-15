package com.example.myapplication.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.myapplication.R


class LawAdapter(private val context: Context, private val dataList: List<DataModel>) : BaseAdapter() {

    override fun getCount(): Int {
        return dataList.size
    }

    override fun getItem(position: Int): Any {
        return dataList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var itemView = convertView
        val holder: ViewHolder

        if (itemView == null) {
            // Inflate the custom layout for each item
            itemView = LayoutInflater.from(context).inflate(R.layout.list_item_layout, parent, false)

            // Create a ViewHolder to store the references to the views in each item
            holder = ViewHolder()
            holder.textMain = itemView.findViewById(R.id.textMain)
            holder.textMiddle = itemView.findViewById(R.id.textMiddle)
            holder.textQuestion = itemView.findViewById(R.id.textQuestion)

            // Set the ViewHolder as a tag for the itemView
            itemView.tag = holder
        } else {
            // Reuse the existing ViewHolder
            holder = itemView.tag as ViewHolder
        }

        // Populate the views with data from the DataModel
        val dataModel = getItem(position) as DataModel
        holder.textMain.text = dataModel.main
        holder.textMiddle.text = dataModel.middle
        holder.textQuestion.text = dataModel.question

        return itemView!!
    }

    // ViewHolder pattern to efficiently store references to the views
    private class ViewHolder {
        lateinit var textMain: TextView
        lateinit var textMiddle: TextView
        lateinit var textQuestion: TextView
    }
}