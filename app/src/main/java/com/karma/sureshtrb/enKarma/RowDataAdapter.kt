package com.sureshtrb.enKarma

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sureshtrb.enKarma.R // Import R class for layout
data class RowData(
    var name: String = "",
    var birthOrder: String = "",
    var gothram: String = "",
    var gender: String = "",
    var relationship: String = ""
)
class RowDataAdapter(private val rowDataList: List<RowData>) :
    androidx.recyclerview.widget.RecyclerView.Adapter<RowDataAdapter.ViewHolder>() { // Fully qualified name

    class ViewHolder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) { // Fully qualified name
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val birthOrderTextView: TextView = itemView.findViewById(R.id.birthOrderTextView)
        //val birthOrderTextView: TextView = itemView.findViewById(R.id.birthOrderTextView) // ... other TextViews
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowDataAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.row_item, parent, false) // Use imported R class
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RowDataAdapter.ViewHolder, position: Int) {
        val rowData = rowDataList[position]
        holder.nameTextView.text = rowData.name
        holder.birthOrderTextView.text = rowData.birthOrder
        // ... bind other TextViews
    }

    override fun getItemCount(): Int {
        return rowDataList.size
    }
}