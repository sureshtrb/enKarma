package com.karma.sureshtrb.enKarma

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.karma.sureshtrb.enKarma.databinding.ActivityDeceasedListBinding
import com.karma.sureshtrb.enKarma.databinding.ItemDeceasedRowBinding
import org.json.JSONArray
import org.json.JSONObject

// Data class for deceased entry
data class DeceasedEntry(
    var name: String = "",
    var birthStar: String = "",
    var gothram: String = "",
    var gender: String = "",
    var relationship: String = ""
)

class DeceasedListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDeceasedListBinding
    private val deceasedList = mutableListOf<DeceasedEntry>()
    private lateinit var adapter: DeceasedAdapter
    private val PREFS_NAME = "DeceasedPrefs"
    private val KEY_DECEASED_LIST = "deceased_list"
    private val MAX_ENTRIES = 15

    // Spinner data arrays
    private val birthStars = arrayOf("Select", "Ashwini", "Bharani", "Krittika", "Rohini", "Mrigashira", 
        "Ardra", "Punarvasu", "Pushya", "Ashlesha", "Magha", "Purva Phalguni", "Uttara Phalguni",
        "Hasta", "Chitra", "Swati", "Vishakha", "Anuradha", "Jyeshtha", "Mula", "Purva Ashadha",
        "Uttara Ashadha", "Shravana", "Dhanishta", "Shatabhisha", "Purva Bhadrapada", "Uttara Bhadrapada", "Revati")
    private val gothrams = arrayOf("Select", "Angirasa", "Atri", "Bharadwaja", "Bhrigu", "Gautama", 
        "Jamadagni", "Kashyapa", "Vasishta", "Vishwamitra", "Agastya", "Kaundinya", "Other")
    private val genders = arrayOf("Select", "Male", "Female")
    private val relationships = arrayOf("Select", "Father", "Mother", "Grandfather", "Grandmother", 
        "Great Grandfather", "Great Grandmother", "Uncle", "Aunt", "Brother", "Sister", "Other")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeceasedListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupActionBar()
        setupRecyclerView()
        loadData()
        setupButtons()
    }

    private fun setupActionBar() {
        supportActionBar?.apply {
            setHomeAsUpIndicator(R.drawable.home)
            setDisplayHomeAsUpEnabled(true)
            subtitle = "Deceased Names"
            setDisplayShowHomeEnabled(true)
            setLogo(R.drawable.karma)
            setDisplayUseLogoEnabled(true)
        }
    }

    private fun setupRecyclerView() {
        adapter = DeceasedAdapter(deceasedList) { position -> showEditDialog(position) }
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        // Setup drag-to-reorder
        val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN, 0
        ) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder,
                                target: RecyclerView.ViewHolder): Boolean {
                val fromPos = viewHolder.adapterPosition
                val toPos = target.adapterPosition
                java.util.Collections.swap(deceasedList, fromPos, toPos)
                adapter.notifyItemMoved(fromPos, toPos)
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {}

            override fun clearView(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder) {
                super.clearView(recyclerView, viewHolder)
                saveData() // Auto-save after reorder
            }
        })
        itemTouchHelper.attachToRecyclerView(binding.recyclerView)
    }

    private fun setupButtons() {
        binding.btnAdd.setOnClickListener {
            if (deceasedList.size < MAX_ENTRIES) {
                showEditDialog(-1) // -1 means add new
            } else {
                Toast.makeText(this, "Maximum $MAX_ENTRIES entries allowed", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnSave.setOnClickListener {
            saveData()
            Toast.makeText(this, "Data saved successfully", Toast.LENGTH_SHORT).show()
        }

        binding.btnClear.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Clear All")
                .setMessage("Are you sure you want to clear all entries?")
                .setPositiveButton("Yes") { _, _ ->
                    deceasedList.clear()
                    adapter.notifyDataSetChanged()
                    saveData()
                }
                .setNegativeButton("No", null)
                .show()
        }
    }

    private fun showEditDialog(position: Int) {
        val isNew = position == -1
        val entry = if (isNew) DeceasedEntry() else deceasedList[position].copy()
        val dialogView = layoutInflater.inflate(R.layout.dialog_edit_deceased, null)
        
        // Setup dialog views and spinners
        val etName = dialogView.findViewById<android.widget.EditText>(R.id.etName)
        val spBirthStar = dialogView.findViewById<android.widget.Spinner>(R.id.spBirthStar)
        val spGothram = dialogView.findViewById<android.widget.Spinner>(R.id.spGothram)
        val spGender = dialogView.findViewById<android.widget.Spinner>(R.id.spGender)
        val spRelationship = dialogView.findViewById<android.widget.Spinner>(R.id.spRelationship)

        etName.setText(entry.name)
        spBirthStar.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, birthStars)
        spGothram.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, gothrams)
        spGender.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, genders)
        spRelationship.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, relationships)

        // Set current selections
        spBirthStar.setSelection(birthStars.indexOf(entry.birthStar).coerceAtLeast(0))
        spGothram.setSelection(gothrams.indexOf(entry.gothram).coerceAtLeast(0))
        spGender.setSelection(genders.indexOf(entry.gender).coerceAtLeast(0))
        spRelationship.setSelection(relationships.indexOf(entry.relationship).coerceAtLeast(0))

        AlertDialog.Builder(this)
            .setTitle(if (isNew) "Add Entry" else "Edit Entry")
            .setView(dialogView)
            .setPositiveButton("Save") { _, _ ->
                entry.name = etName.text.toString()
                entry.birthStar = spBirthStar.selectedItem.toString()
                entry.gothram = spGothram.selectedItem.toString()
                entry.gender = spGender.selectedItem.toString()
                entry.relationship = spRelationship.selectedItem.toString()

                if (isNew) {
                    deceasedList.add(entry)
                    adapter.notifyItemInserted(deceasedList.size - 1)
                } else {
                    deceasedList[position] = entry
                    adapter.notifyItemChanged(position)
                }
                saveData()
            }
            .setNegativeButton("Cancel", null)
            .apply {
                if (!isNew) {
                    setNeutralButton("Delete") { _, _ ->
                        deceasedList.removeAt(position)
                        adapter.notifyItemRemoved(position)
                        saveData()
                    }
                }
            }
            .show()
    }

    private fun saveData() {
        val prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val jsonArray = JSONArray()
        deceasedList.forEach { entry ->
            val obj = JSONObject().apply {
                put("name", entry.name)
                put("birthStar", entry.birthStar)
                put("gothram", entry.gothram)
                put("gender", entry.gender)
                put("relationship", entry.relationship)
            }
            jsonArray.put(obj)
        }
        prefs.edit().putString(KEY_DECEASED_LIST, jsonArray.toString()).apply()
    }

    private fun loadData() {
        val prefs = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val jsonString = prefs.getString(KEY_DECEASED_LIST, null) ?: return
        try {
            val jsonArray = JSONArray(jsonString)
            deceasedList.clear()
            for (i in 0 until jsonArray.length()) {
                val obj = jsonArray.getJSONObject(i)
                deceasedList.add(DeceasedEntry(
                    name = obj.optString("name", ""),
                    birthStar = obj.optString("birthStar", ""),
                    gothram = obj.optString("gothram", ""),
                    gender = obj.optString("gender", ""),
                    relationship = obj.optString("relationship", "")
                ))
            }
            adapter.notifyDataSetChanged()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    // RecyclerView Adapter
    inner class DeceasedAdapter(
        private val items: MutableList<DeceasedEntry>,
        private val onItemClick: (Int) -> Unit
    ) : RecyclerView.Adapter<DeceasedAdapter.ViewHolder>() {

        inner class ViewHolder(val binding: ItemDeceasedRowBinding) : RecyclerView.ViewHolder(binding.root)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val binding = ItemDeceasedRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ViewHolder(binding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val entry = items[position]
            holder.binding.apply {
                tvNumber.text = "${position + 1}."
                tvName.text = entry.name.ifEmpty { "(No name)" }
                tvDetails.text = listOf(entry.relationship, entry.gender, entry.birthStar, entry.gothram)
                    .filter { it.isNotEmpty() && it != "Select" }.joinToString(" | ")
                root.setOnClickListener { onItemClick(position) }
            }
        }

        override fun getItemCount() = items.size
    }
}
