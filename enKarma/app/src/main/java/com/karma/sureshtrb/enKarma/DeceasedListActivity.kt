package com.karma.sureshtrb.enKarma

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import com.karma.sureshtrb.enKarma.databinding.ActivityDeceasedListBinding

class DeceasedListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDeceasedListBinding

    // Max rows supported
    private val MAX_ROWS = 15

    // Persistent prefs name
    companion object {
        private const val PREFS_NAME = "DeceasedListPrefs"
    }

    // Runtime lists to hold row data (indexes 0..MAX_ROWS-1)
    private val names = MutableList(MAX_ROWS) { "" }
    private val birthOrders = MutableList(MAX_ROWS) { "" }
    private val gothrams = MutableList(MAX_ROWS) { "" }
    private val relationships = MutableList(MAX_ROWS) { "" }
    private val genders = MutableList(MAX_ROWS) { "" }

    // Lists of views populated in onCreate (for convenience)
    private lateinit var rowViews: List<View>
    private lateinit var nameViews: List<android.widget.TextView>
    private lateinit var birthOrderViews: List<android.widget.TextView>
    private lateinit var gothramViews: List<android.widget.TextView>
    private lateinit var relViews: List<android.widget.TextView>
    private lateinit var editButtons: List<View>

    // Temp selection for "add new" entry (populated from spinners)
    private var personNameInput: String = ""
    private var personBirthOrder: String = ""
    private var personGothram: String = ""
    private var personRelationShip: String = ""
    private var personGender: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeceasedListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup action bar safely
        supportActionBar?.apply {
            setHomeAsUpIndicator(R.drawable.home)
            setDisplayHomeAsUpEnabled(true)
            subtitle = "Deceased Names / மறைந்தோர் விபரங்கள்"
            setDisplayShowHomeEnabled(true)
            setLogo(R.drawable.karma)
            setDisplayUseLogoEnabled(true)
        }

        // Initialize view lists using binding (must match your layout IDs)
        rowViews = listOf(
            binding.firstRow, binding.secondRow, binding.thirdRow, binding.fourthRow,
            binding.fifthRow, binding.sixthRow, binding.seventhRow, binding.eighthRow,
            binding.ninethRow, binding.tenRow, binding.elevenRow, binding.twelveRow,
            binding.thirteenRow, binding.fourteenRow, binding.fifteenRow
        )

        nameViews = listOf(
            binding.Name1, binding.Name2, binding.Name3, binding.Name4, binding.Name5,
            binding.Name6, binding.Name7, binding.Name8, binding.Name9, binding.Name10,
            binding.Name11, binding.Name12, binding.Name13, binding.Name14, binding.Name15
        )

        birthOrderViews = listOf(
            binding.BirthOrder1, binding.BirthOrder2, binding.BirthOrder3, binding.BirthOrder4, binding.BirthOrder5,
            binding.BirthOrder6, binding.BirthOrder7, binding.BirthOrder8, binding.BirthOrder9, binding.BirthOrder10,
            binding.BirthOrder11, binding.BirthOrder12, binding.BirthOrder13, binding.BirthOrder14, binding.BirthOrder15
        )

        gothramViews = listOf(
            binding.gotram1, binding.gotram2, binding.gotram3, binding.gotram4, binding.gotram5,
            binding.gotram6, binding.gotram7, binding.gotram8, binding.gotram9, binding.gotram10,
            binding.gotram11, binding.gotram12, binding.gotram13, binding.gotram14, binding.gotram15
        )

        relViews = listOf(
            binding.relationship1, binding.relationship2, binding.relationship3, binding.relationship4,
            binding.relationship5, binding.relationship6, binding.relationship7, binding.relationship8,
            binding.relationship9, binding.relationship10, binding.relationship11, binding.relationship12,
            binding.relationship13, binding.relationship14, binding.relationship15
        )

        editButtons = listOf(
            binding.editRow1, binding.editRow2, binding.editRow3, binding.editRow4, binding.editRow5,
            binding.editRow6, binding.editRow7, binding.editRow8, binding.editRow9, binding.editRow10,
            binding.editRow11, binding.editRow12, binding.editRow13, binding.editRow14, binding.editRow15
        )

        // Initially hide all rows (you control visibility from saved data / entries)
        hideAllRows()

        // Setup spinners and adapters
        setupSpinners()
        private fun updateViews() {
            refreshRowVisibility()
        }

        // Load previously saved data and update UI
        loadData()
        updateViews()

        // Hook edit button actions (remove/shift)
        for (i in editButtons.indices) {
            editButtons[i].setOnClickListener { removeRow(i) }
        }

        // Save name button: add new entry to first empty row
        binding.SaveName.setOnClickListener { addNewEntry() }

        // Clear all button
        binding.editRow.setOnClickListener { clearAllRows() }

        // Prepare intent and start MahalayaTpnmActivity
        binding.MAHTARPANAMBTN.setOnClickListener { openMahalayaActivity() }

        // Show/hide head row according to first visible row
        refreshRowVisibility()
    }

    // -------------------------
    // Spinner & selection setup
    // -------------------------
    private fun setupSpinners() {
        val genderArray = arrayOf("Select Gender", "Male", "Female")
        val birthOrderArray1 = arrayOf("Select - Birth Order", "Elder (மூத்த)", "Younger (இளைய)", "பொருந்தாது")
        val birthOrderArray2 = arrayOf("பொருந்தாது")
        val relationArrayGents = arrayOf(
            "Select - Relationship", "பிள்ளை", "கூடபிறந்த சகோதரர்", "பெரியப்பா or சித்தப்பா", "மாமா",
            "பெண்வயிற்றுப் பேரப் பிள்ளை", "மாப்பிள்ளை", "மருமகன்", "தாயாருடன் பிறந்தவர்கள்", "அத்தான் அம்மாஞ்ஜி",
            "மைத்துனர்", "ஆச்சாரியன்", "மாமனார்", "அத்திம்பேர்"
        )
        val relationArrayLadies = arrayOf(
            "Select - Relationship", "ஸம்ஸாரம்", "பெண் குழந்தை", "கூடபிறந்த சகோதரி", "தாயாருடன் பிறந்தவர்கள்",
            "அத்தை", "மருமகள்", "மாமியார்"
        )
        val gothramArray = arrayOf(
            "Select - Gothram", "பாரத்வாஜ", "ஷடமாஷண", "ஆத்ரேய", "வாதூல", "ஸ்ரீவத்ஸ",
            "கௌஶிக", "விஶ்வாமித்ர", "கௌண்டிந்ய", "ஹாரித", "மௌத்கல்ய"
        )

        // Adapters
        val genderAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, genderArray)
        val birthOrderAdapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_1, birthOrderArray1)
        val birthOrderAdapter2 = ArrayAdapter(this, android.R.layout.simple_list_item_1, birthOrderArray2)
        val relAdapterGents = ArrayAdapter(this, android.R.layout.simple_list_item_1, relationArrayGents)
        val relAdapterLadies = ArrayAdapter(this, android.R.layout.simple_list_item_1, relationArrayLadies)
        val gothramAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, gothramArray)

        binding.genderOrder.adapter = genderAdapter
        binding.birthOrder.adapter = birthOrderAdapter1
        binding.relShip.adapter = relAdapterGents
        binding.gthrm.adapter = gothramAdapter

        // Gender selection behavior
        binding.genderOrder.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                personGender = genderArray[position]
                // If female, change adapters accordingly
                if (personGender == "Female" || personGender == "பெண்") {
                    binding.birthOrder.adapter = birthOrderAdapter2
                    binding.birthOrder.isEnabled = false
                    binding.relShip.adapter = relAdapterLadies
                } else {
                    binding.birthOrder.adapter = birthOrderAdapter1
                    binding.birthOrder.isEnabled = true
                    binding.relShip.adapter = relAdapterGents
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        // Relationship selection -> map to canonical label (you previously had mapping logic)
        val relationshipMapForGents = mapOf(
            "பிள்ளை" to "ஸூத:",
            "கூடபிறந்த சகோதரர்" to "ப்ராதா",
            "மாமா" to "மாதுல:",
            "ஆச்சாரியன்" to "குரு"
        )
        val relationshipMapForLadies = mapOf(
            "ஸம்ஸாரம்" to "பத்நீ",
            "பெண் குழந்தை" to "துஹிதா",
            "அத்தை" to "பித்ருஷ்வஸா"
        )

        binding.relShip.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val key = parent.getItemAtPosition(position).toString()
                personRelationShip = when (personGender) {
                    "Female", "பெண்" -> relationshipMapForLadies[key] ?: key
                    else -> relationshipMapForGents[key] ?: key
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        binding.birthOrder.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                personBirthOrder = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        binding.gthrm.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                personGothram = parent.getItemAtPosition(position).toString()
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        // Keep track of typed name input
        binding.Name.setOnFocusChangeListener { _, _ -> personNameInput = binding.Name.text.toString().trim() }
    }

    // -------------------------
    // Row management functions
    // -------------------------
    private fun hideAllRows() {
        for (v in rowViews) v.visibility = View.INVISIBLE
        binding.headRow.visibility = View.INVISIBLE
    }

    private fun refreshRowVisibility() {
        // Show each row only if name exists
        for (i in rowViews.indices) {
            rowViews[i].visibility = if (names[i].isBlank()) View.INVISIBLE else View.VISIBLE
            nameViews[i].text = names[i]
            birthOrderViews[i].text = birthOrders[i]
            gothramViews[i].text = gothrams[i]
            relViews[i].text = relationships[i]
        }
        // Show head if first row is present
        binding.headRow.visibility = if (names[0].isBlank()) View.INVISIBLE else View.VISIBLE
    }

    private fun addNewEntry() {
        val nameInput = binding.editRow.text.toString().trim()
        if (nameInput.isBlank()) return

        for (i in names.indices) {
            if (names[i].isBlank()) {
                names[i] = nameInput
                birthOrders[i] = personBirthOrder
                gothrams[i] = personGothram
                relationships[i] = personRelationShip
                genders[i] = personGender
                break
            }
        }
        binding.Name.text?.clear()
        saveData()
        refreshRowVisibility()
    }

    private fun removeRow(index: Int) {
        if (index !in 0 until MAX_ROWS) return
        // Shift up subsequent rows
        for (i in index until MAX_ROWS - 1) {
            names[i] = names[i + 1]
            birthOrders[i] = birthOrders[i + 1]
            gothrams[i] = gothrams[i + 1]
            relationships[i] = relationships[i + 1]
            genders[i] = genders[i + 1]
        }
        // Clear the last
        names[MAX_ROWS - 1] = ""
        birthOrders[MAX_ROWS - 1] = ""
        gothrams[MAX_ROWS - 1] = ""
        relationships[MAX_ROWS - 1] = ""
        genders[MAX_ROWS - 1] = ""
        saveData()
        refreshRowVisibility()
    }

    private fun clearAllRows() {
        for (i in 0 until MAX_ROWS) {
            names[i] = ""
            birthOrders[i] = ""
            gothrams[i] = ""
            relationships[i] = ""
            genders[i] = ""
        }
        saveData()
        refreshRowVisibility()
    }

    // -------------------------
    // Persistence (SharedPrefs)
    // -------------------------
    private fun saveData() {
        val prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
        val editor = prefs.edit()
        for (i in 0 until MAX_ROWS) {
            editor.putString("N${i + 1}", names[i])
            editor.putString("B${i + 1}", birthOrders[i])
            editor.putString("G${i + 1}", gothrams[i])
            editor.putString("R${i + 1}", relationships[i])
            editor.putString("gdr${i + 1}", genders[i])
        }
        editor.apply()
    }

    private fun loadData() {
        val prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
        for (i in 0 until MAX_ROWS) {
            names[i] = prefs.getString("N${i + 1}", "") ?: ""
            birthOrders[i] = prefs.getString("B${i + 1}", "") ?: ""
            gothrams[i] = prefs.getString("G${i + 1}", "") ?: ""
            relationships[i] = prefs.getString("R${i + 1}", "") ?: ""
            genders[i] = prefs.getString("gdr${i + 1}", "") ?: ""
        }
    }

    // -------------------------
    // Launch MahalayaTpnmActivity with extras
    // -------------------------
    private fun openMahalayaActivity() {
        val intent = Intent(this, MahalayaTpnmActivity::class.java)

        // Put the rows
        for (i in 0 until MAX_ROWS) {
            intent.putExtra("N${i + 1}", names[i])
            intent.putExtra("B${i + 1}", birthOrders[i])
            intent.putExtra("G${i + 1}", gothrams[i])
            intent.putExtra("R${i + 1}", relationships[i])
            intent.putExtra("gdr${i + 1}", genders[i])
        }

        // Pass through extras that were forwarded to this Activity (if present)
        val extrasToForward = listOf(
            "Naal", "Idam", "TamilYear", "Ayanamm", "KAALAM", "RASEEE",
            "BAKKSHAMM", "TODAYSTHITHI", "KIZHAMAAII", "NAKSM", "YGM", "KRNM",
            "Peyar", "Appa", "Thatha", "Kollu", "Yellu", "AmmaAppa", "AmmaThatha",
            "AmmaKolluThatha", "ammaName", "appaAmmaName", "appaPattiName",
            "appaKolluPattiName", "ammaAmmaName", "ammaPattiName", "ammaKolluPattiName",
            "howManyDays"
        )
        for (key in extrasToForward) {
            intent.putExtra(key, intentFromThisActivityExtra(key))
        }

        startActivity(intent)
    }

    private fun intentFromThisActivityExtra(key: String): String {
        return intent.getStringExtra(key) ?: ""
    }
}
