package com.karma.sureshtrb.enKarma

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Data model class
data class RowData(
    var name: String = "",
    var birthOrder: String = "",
    var gothram: String = "",
    var gender: String = "",
    var relationship: String = ""
)

// Adapter class for RecyclerView
class RowDataAdapter(
    private val rowDataList: List<RowData>
) : RecyclerView.Adapter<RowDataAdapter.ViewHolder>() {

    // ViewHolder holds references to UI components of each row
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val birthOrderTextView: TextView = itemView.findViewById(R.id.birthOrderTextView)
        // Uncomment or add as needed:
        // val gothramTextView: TextView = itemView.findViewById(R.id.gothramTextView)
        // val genderTextView: TextView = itemView.findViewById(R.id.genderTextView)
        // val relationshipTextView: TextView = itemView.findViewById(R.id.relationshipTextView)
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
        // Bind other TextViews if available in layout:
        // holder.gothramTextView.text = rowData.gothram
        // holder.genderTextView.text = rowData.gender
        // holder.relationshipTextView.text = rowData.relationship
    }

    override fun getItemCount(): Int = rowDataList.size
}
