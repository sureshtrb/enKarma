package com.karma.sureshtrb.enKarma

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.karma.sureshtrb.enKarma.databinding.ActivityFurtherDetailsBinding

// Top-level (app-wide) variables you previously used — kept here for compatibility.
var noOfDaysTpnm: String = ""
var ammaName: String = ""
var appaAmmaName: String = ""
var appaPattiName: String = ""
var appaKolluPattiName: String = ""
var ammaAmmaName: String = ""
var ammaPattiName: String = ""
var ammaKolluPattiName: String = ""
    }

    private lateinit var binding: ActivityFurtherDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFurtherDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Safe action bar setup
        supportActionBar?.apply {
            setHomeAsUpIndicator(R.drawable.home)
            setDisplayHomeAsUpEnabled(true)
            subtitle = "மேலும் விவரங்கள்"
            setDisplayShowHomeEnabled(true)
            setLogo(R.drawable.karma)
            setDisplayUseLogoEnabled(true)
        }

        // Note: the following variables are referenced in your original code but not defined here.
        // Keep them defined elsewhere in your project, e.g. in a shared object or passed via Intent:
        // motherLive, yrGFatherLive, fatherMotherLive, mFatherLive, motherMotherLive,
        // shakaSamvat, vedicAyana, vedicRithu, suryaRasi, paksha, todThithi, weekDay,
        // naksha, yoga, karana, shakaSamvat, vedicAyana, vedicRithu, etc.

        // Read incoming extras (defaults to empty string if absent)
        val dateTdy = intent.getStringExtra("Naal") ?: ""
        val place = intent.getStringExtra("Idam") ?: ""
        val Varusham = intent.getStringExtra("TamilYear") ?: ""
        val ayyanamm = intent.getStringExtra("Ayanamm") ?: ""
        val kalam = intent.getStringExtra("KAALAM") ?: ""
        val rasee = intent.getStringExtra("RASEEE") ?: ""
        val baksham = intent.getStringExtra("BAKKSHAMM") ?: ""
        val todThithi = intent.getStringExtra("TODAYSTHITHI") ?: ""
        val kizhamai = intent.getStringExtra("KIZHAMAAII") ?: ""
        val nachathirm = intent.getStringExtra("NAKSM") ?: ""
        val yog = intent.getStringExtra("YGM") ?: ""
        val kar = intent.getStringExtra("KRNM") ?: ""

        val yrNamee = intent.getStringExtra("Peyar") ?: ""
        val yrFNamee = intent.getStringExtra("Appa") ?: ""
        val yrGFNamee = intent.getStringExtra("Thatha") ?: ""
        val yrGGFNamee = intent.getStringExtra("Kollu") ?: ""
        val yrGGGFNamee = intent.getStringExtra("Yellu") ?: ""
        val MFNamee = intent.getStringExtra("AmmaAppa") ?: ""
        val MGFNamee = intent.getStringExtra("AmmaThatha") ?: ""
        val MGGFNamee = intent.getStringExtra("AmmaKolluThatha") ?: ""

        // Initialize UI state from saved prefs
        loadData()
        updateViews()

        // Manage visibility of mother/father related fields based on external flags.
        // These variables must be defined elsewhere (kept original logic).
        try {
            if (motherLive == "Living") {
                binding.yourMotherName.visibility = View.INVISIBLE
                binding.yourMotherName.setText("")
                binding.fatherMotherName.visibility = View.INVISIBLE
                binding.fatherMotherName.setText("")
                binding.fatherGrandmotherName.visibility = View.INVISIBLE
                binding.fatherGrandmotherName.setText("")
                binding.fatherGreatGrandmotherName.visibility = View.INVISIBLE
                binding.fatherGreatGrandmotherName.setText("")
            } else {
                if (yrGFatherLive != "Living") {
                    if (fatherMotherLive != "Living") {
                        binding.yourMotherName.visibility = View.VISIBLE
                        binding.fatherMotherName.visibility = View.VISIBLE
                        binding.fatherGrandmotherName.visibility = View.VISIBLE
                        binding.fatherGreatGrandmotherName.visibility = View.INVISIBLE
                    } else {
                        binding.fatherMotherName.visibility = View.INVISIBLE
                        binding.fatherGrandmotherName.visibility = View.INVISIBLE
                        binding.fatherGreatGrandmotherName.visibility = View.INVISIBLE
                    }
                } else {
                    binding.yourMotherName.visibility = View.INVISIBLE
                    binding.yourMotherName.setText("")
                    binding.fatherMotherName.visibility = View.INVISIBLE
                    binding.fatherMotherName.setText("")
                    binding.fatherGrandmotherName.visibility = View.INVISIBLE
                    binding.fatherGrandmotherName.setText("")
                    binding.fatherGreatGrandmotherName.visibility = View.INVISIBLE
                    binding.fatherGreatGrandmotherName.setText("")
                }
            }
        } catch (e: Throwable) {
            // If the global flags aren't present, ignore and continue; you may log if needed.
        }

        try {
            if (mFatherLive != "Living") {
                if (motherMotherLive != "Living") {
                    binding.motherMotherName.visibility = View.VISIBLE
                    binding.motherGrandmotherName.visibility = View.VISIBLE
                    binding.motherGreatgrandmotherName.visibility = View.VISIBLE
                } else {
                    binding.motherMotherName.setText("")
                    binding.motherGrandmotherName.setText("")
                    binding.motherGreatgrandmotherName.setText("")
                    binding.motherMotherName.visibility = View.INVISIBLE
                    binding.motherGrandmotherName.visibility = View.INVISIBLE
                    binding.motherGreatgrandmotherName.visibility = View.INVISIBLE
                }
            }
        } catch (e: Throwable) {
            // ignore if flags absent
        }

        // "Add Relatives" button -> open DeceasedListActivity passing through many extras
        binding.addRelatives.setOnClickListener {
            val intent = Intent(this, DeceasedListActivity::class.java)
            intent.putExtra("Naal", dateTdy)
            intent.putExtra("Idam", place)
            intent.putExtra("TamilYear", shakaSamvat) // external
            intent.putExtra("Ayanamm", vedicAyana) // external
            intent.putExtra("KAALAM", vedicRithu) // external
            intent.putExtra("RASEEE", suryaRasi) // external
            intent.putExtra("BAKKSHAMM", paksha) // external
            intent.putExtra("TODAYSTHITHI", todThithi)
            intent.putExtra("KIZHAMAAII", weekDay) // external
            intent.putExtra("NAKSM", naksha) // external
            intent.putExtra("YGM", yoga) // external
            intent.putExtra("KRNM", karana) // external

            intent.putExtra("Peyar", yrNamee)
            intent.putExtra("Appa", yrFNamee)
            intent.putExtra("Thatha", yrGFNamee)
            intent.putExtra("Kollu", yrGGFNamee)
            intent.putExtra("Yellu", yrGGGFNamee)
            intent.putExtra("AmmaAppa", MFNamee)
            intent.putExtra("AmmaThatha", MGFNamee)
            intent.putExtra("AmmaKolluThatha", MGGFNamee)
            intent.putExtra("howManyDays", noOfDaysTpnm)

            // Mother / father lineage details from UI
            intent.putExtra("ammaName", binding.yourMotherName.text.toString())
            intent.putExtra("appaAmmaName", binding.fatherMotherName.text.toString())
            intent.putExtra("appaPattiName", binding.fatherGrandmotherName.text.toString())
            intent.putExtra("appaKolluPattiName", binding.fatherGreatGrandmotherName.text.toString())
            intent.putExtra("ammaAmmaName", binding.motherMotherName.text.toString())
            intent.putExtra("ammaPattiName", binding.motherGrandmotherName.text.toString())
            intent.putExtra("ammaKolluPattiName", binding.motherGreatgrandmotherName.text.toString())

            saveData()
            startActivity(intent)
        }

        // "Proceed To Tharpanam" button -> open MahalayaTpnmActivity with same extras pattern
        binding.proceedToTharpanam.setOnClickListener {
            val intent = Intent(this, MahalayaTpnmActivity::class.java)
            intent.putExtra("Naal", dateTdy)
            intent.putExtra("Idam", place)
            intent.putExtra("TamilYear", shakaSamvat)
            intent.putExtra("Ayanamm", vedicAyana)
            intent.putExtra("KAALAM", vedicRithu)
            intent.putExtra("RASEEE", suryaRasi)
            intent.putExtra("BAKKSHAMM", paksha)
            intent.putExtra("TODAYSTHITHI", todThithi)
            intent.putExtra("KIZHAMAAII", weekDay)
            intent.putExtra("NAKSM", naksha)
            intent.putExtra("YGM", yoga)
            intent.putExtra("KRNM", karana)

            intent.putExtra("Peyar", yrNamee)
            intent.putExtra("Appa", yrFNamee)
            intent.putExtra("Thatha", yrGFNamee)
            intent.putExtra("Kollu", yrGGFNamee)
            intent.putExtra("Yellu", yrGGGFNamee)
            intent.putExtra("AmmaAppa", MFNamee)
            intent.putExtra("AmmaThatha", MGFNamee)
            intent.putExtra("AmmaKolluThatha", MGGFNamee)
            intent.putExtra("howManyDays", noOfDaysTpnm)

            intent.putExtra("ammaName", binding.yourMotherName.text.toString())
            intent.putExtra("appaAmmaName", binding.fatherMotherName.text.toString())
            intent.putExtra("appaPattiName", binding.fatherGrandmotherName.text.toString())
            intent.putExtra("appaKolluPattiName", binding.fatherGreatGrandmotherName.text.toString())
            intent.putExtra("ammaAmmaName", binding.motherMotherName.text.toString())
            intent.putExtra("ammaPattiName", binding.motherGrandmotherName.text.toString())
            intent.putExtra("ammaKolluPattiName", binding.motherGreatgrandmotherName.text.toString())

            saveData()
            startActivity(intent)
        }

        // RadioGroup listener for number of days selection
        binding.radioGroup7.setOnCheckedChangeListener { _: RadioGroup, checkedId: Int ->
            val rbOne = findViewById<RadioButton>(R.id.radio1G7)
            val rbFifteen = findViewById<RadioButton>(R.id.radio2G7)
            when (checkedId) {
                R.id.radio1G7 -> {
                    rbOne.setTextColor(Color.BLUE)
                    rbOne.setTypeface(null, Typeface.BOLD)
                    rbFifteen.setTextColor(Color.BLACK)
                    rbFifteen.setTypeface(null, Typeface.NORMAL)
                    noOfDaysTpnm = "OneDay"
                }
                R.id.radio2G7 -> {
                    rbOne.setTextColor(Color.BLACK)
                    rbOne.setTypeface(null, Typeface.NORMAL)
                    rbFifteen.setTextColor(Color.BLUE)
                    rbFifteen.setTypeface(null, Typeface.BOLD)
                    noOfDaysTpnm = "15Days"
                }
            }
        }
    }

    // -------------------------
    // SharedPreferences helpers
    // -------------------------
    private fun saveData() {
        val sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE)
        with(sharedPreferences.edit()) {
            putString("ammaName", binding.yourMotherName.text.toString())
            putString("appaAmmaName", binding.fatherMotherName.text.toString())
            putString("appaPattiName", binding.fatherGrandmotherName.text.toString())
            putString("appaKolluPattiName", binding.fatherGreatGrandmotherName.text.toString())
            putString("ammaAmmaName", binding.motherMotherName.text.toString())
            putString("ammaPattiName", binding.motherGrandmotherName.text.toString())
            putString("ammaKolluPattiName", binding.motherGreatgrandmotherName.text.toString())
            apply()
        }
    }

    private fun loadData() {
        val sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE)
        ammaName = sharedPreferences.getString("ammaName", "") ?: ""
        appaAmmaName = sharedPreferences.getString("appaAmmaName", "") ?: ""
        appaPattiName = sharedPreferences.getString("appaPattiName", "") ?: ""
        appaKolluPattiName = sharedPreferences.getString("appaKolluPattiName", "") ?: ""
        ammaAmmaName = sharedPreferences.getString("ammaAmmaName", "") ?: ""
        ammaPattiName = sharedPreferences.getString("ammaPattiName", "") ?: ""
        ammaKolluPattiName = sharedPreferences.getString("ammaKolluPattiName", "") ?: ""
    }

    private fun updateViews() {
        binding.yourMotherName.setText(ammaName)
        binding.fatherMotherName.setText(appaAmmaName)
        binding.fatherGrandmotherName.setText(appaPattiName)
        binding.fatherGreatGrandmotherName.setText(appaKolluPattiName)
        binding.motherMotherName.setText(ammaAmmaName)
        binding.motherGrandmotherName.setText(ammaPattiName)
        binding.motherGreatgrandmotherName.setText(ammaKolluPattiName)
    }
}
