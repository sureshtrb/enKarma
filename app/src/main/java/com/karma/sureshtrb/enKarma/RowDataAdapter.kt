package com.karma.sureshtrb.enKarma

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.karma.sureshtrb.enKarma.R

// Model class for each row item
data class RowData(
    var name: String = "",
    var birthOrder: String = "",
    var gothram: String = "",
    var gender: String = "",
    var relationship: String = ""
)

// RecyclerView adapter
class RowDataAdapter(private val rowDataList: List<RowData>) :
    RecyclerView.Adapter<RowDataAdapter.ViewHolder>() {

    // ViewHolder holds references to the TextView elements
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val birthOrderTextView: TextView = itemView.findViewById(R.id.birthOrderTextView)
        // Add other TextView references here if needed
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val rowData = rowDataList[position]
        holder.nameTextView.text = rowData.name
        holder.birthOrderTextView.text = rowData.birthOrder
        // Bind other TextViews similarly if required
    }

    override fun getItemCount(): Int = rowDataList.size
}
