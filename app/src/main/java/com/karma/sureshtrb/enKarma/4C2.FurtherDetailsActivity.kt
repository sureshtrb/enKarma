package com.karma.sureshtrb.enKarma

//import kotlinx.android.synthetic.main.activity_further_details.*
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.preference.PreferenceManager
import android.text.Editable
import android.view.Gravity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.karma.sureshtrb.enKarma.databinding.ActivityFurtherDetailsBinding

var noOfDaysTpnm: String = ""
var ammaName:String = ""
var appaAmmaName:String = ""
var appaPattiName:String = ""
var appaKolluPattiName:String = ""
var ammaAmmaName:String = ""
var ammaPattiName:String = ""
var ammaKolluPattiName:String = ""

class FurtherDetailsActivity : AppCompatActivity() {

    val SHARED_PREFS:String = ""
    private lateinit var binding: ActivityFurtherDetailsBinding

        // Launcher to receive data back from DeceasedListActivity
    private val deceasedListLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            // Data returned; also saved in SharedPreferences by DeceasedListActivity
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_further_details)
        binding = ActivityFurtherDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.setHomeAsUpIndicator(R.drawable.home)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.subtitle = "மேலும் விவரங்கள்"
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setLogo(R.drawable.karma)
        supportActionBar!!.setDisplayUseLogoEnabled(true)

        val addNames = findViewById<Button>(R.id.AddRelatives)
        val mahTarpanam = findViewById<Button>(R.id.ProceedToTharpanam)
        // Initially disable the Proceed button until radio is selected
        mahTarpanam.isEnabled = false
        mahTarpanam.alpha = 0.5f  // Make it look disabled

        val rg7 = this.findViewById<RadioGroup>(R.id.radio_group7)
        val rb1_oneDayMTpnm = this.findViewById<RadioButton>(R.id.radio1G7)
        val rb2_FifteenDaysMTpnm = this.findViewById<RadioButton>(R.id.radio2G7)
        val motherName = this.findViewById<EditText>(R.id.your_mother_name)
        val yrGMName = this.findViewById<EditText>(R.id.father_mother_name)
        val yrGGMName = this.findViewById<EditText>(R.id.father_Grandmother_name)
        val yrGGGMName = this.findViewById<EditText>(R.id.father_GreatGrandmother_name)
        val ammaMName = this.findViewById<EditText>(R.id.mother_mother_name)
        val ammaGMName = this.findViewById<EditText>(R.id.mother_grandmother_name)
        val ammaGGMName = this.findViewById<EditText>(R.id.mother_greatgrandmother_name)

        val intent = intent
        val dateTdy: String = intent.getStringExtra("Naal") ?: ""
        val place: String = intent.getStringExtra("Idam") ?: ""
        val Varusham: String = intent.getStringExtra("TamilYear") ?: ""
        val ayyanamm: String = intent.getStringExtra("Ayanamm") ?: ""
        val kalam: String = intent.getStringExtra("KAALAM") ?: ""
        val rasee: String = intent.getStringExtra("RASEEE") ?: ""
        val baksham: String = intent.getStringExtra("BAKKSHAMM") ?: ""
        val todThithi: String = intent.getStringExtra("TODAYSTHITHI") ?: ""
        val kizhamai: String = intent.getStringExtra("KIZHAMAAII") ?: ""
        val nachathirm: String = intent.getStringExtra("NAKSM") ?: ""
        val yog: String = intent.getStringExtra("YGM") ?: ""
        val kar: String = intent.getStringExtra("KRNM") ?: ""

        val yrNamee: String = intent.getStringExtra("Peyar") ?: ""
        val yrFNamee: String = intent.getStringExtra("Appa") ?: ""
        val yrGFNamee: String = intent.getStringExtra("Thatha") ?: ""
        val yrGGFNamee: String = intent.getStringExtra("Kollu") ?: ""
        val yrGGGFNamee: String = intent.getStringExtra("Yellu") ?: ""
        val MFNamee: String = intent.getStringExtra("AmmaAppa") ?: ""
        val MGFNamee: String = intent.getStringExtra("AmmaThatha") ?: ""
        val MGGFNamee: String = intent.getStringExtra("AmmaKolluThatha") ?: ""

        if (motherLive == "Living"){
            motherName.visibility = View.INVISIBLE
            motherName.setText("")
            yrGMName.visibility = View.INVISIBLE
            yrGMName.setText("")
            yrGGMName.visibility = View.INVISIBLE
            yrGGMName.setText("")
            yrGGGMName.visibility = View.INVISIBLE
            yrGGGMName.setText("")

        }else{
            if (yrGFatherLive != "Living"){
                if (fatherMotherLive != "Living"){
                    motherName.visibility = View.VISIBLE
                    yrGMName.visibility = View.VISIBLE
                    yrGGMName.visibility = View.VISIBLE
                    yrGGGMName.visibility = View.INVISIBLE
                }else{
                    yrGMName.visibility = View.INVISIBLE
                    yrGGMName.visibility = View.INVISIBLE
                    yrGGGMName.visibility = View.INVISIBLE
                }
            }else{
                motherName.visibility = View.INVISIBLE
                motherName.setText("")
                yrGMName.visibility = View.INVISIBLE
                yrGMName.setText("")
                yrGGMName.visibility = View.INVISIBLE
                yrGGMName.setText("")
                yrGGGMName.visibility = View.INVISIBLE
                yrGGGMName.setText("")
            }
        }
if (MFatherLive != "Living"){
            if (motherMotherLive != "Living") {
                ammaMName.visibility = View.VISIBLE
                ammaGMName.visibility = View.VISIBLE
                ammaGGMName.visibility = View.VISIBLE
            } else {
                ammaMName.setText("")
                ammaGMName.setText("")
                ammaGGMName.setText("")
                ammaMName.visibility = View.INVISIBLE
                ammaGMName.visibility = View.INVISIBLE
                ammaGGMName.visibility = View.INVISIBLE
            }
        }
/*
        println("Further-dateTdy : $dateTdy")
        println("Further-place : $place")
        println("Further-Varusham : $Varusham")
        println("Further-ayyanamm : $ayyanamm")
        println("Further-kalam : $kalam")
        println("Further-rasee : $rasee")
        println("Further-baksham : $baksham")
        println("Further-todThithi : $todThithi")
        println("Further-kizhamai : $kizhamai")
        println("Further-nachathirm : $nachathirm")
        println("Further-yog: $yog")
        println("Further-kar : $kar")
        println("Further-FLiveStatus : $fatherLive")
        println("Further-MLiveStatus : $motherLive")
        println("Further-MMLiveSTatus: $motherMotherLive")
        println("Further-FMLiveSTatus : $fatherMotherLive")

        println("Further-yrNamee : $yrNamee")
        println("Further-yrFNamee : $yrFNamee")
        println("Further-yrGFNamee : $yrGFNamee")
        println("Further-yrGGFNamee : $yrGGFNamee")
        println("Further-yrGGGFNamee: $yrGGGFNamee")
        println("Further-MFNamee : $MFNamee")
        println("Further-MGFNamee : $MGFNamee")
        println("Further-MGGFNamee : $MGGFNamee")
*/
        loadData()
        updateViews()

        addNames.setOnClickListener {
            val intent = Intent(this, DeceasedListActivity::class.java)
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

            intent.putExtra("ammaName",motherName.text.toString())
            intent.putExtra("appaAmmaName",yrGMName.text.toString())
            intent.putExtra("appaPattiName",yrGGMName.text.toString())
            intent.putExtra("appaKolluPattiName",yrGGGMName.text.toString())
            intent.putExtra("ammaAmmaName",ammaMName.text.toString())
            intent.putExtra("ammaPattiName",ammaGMName.text.toString())
            intent.putExtra("ammaKolluPattiName",ammaGGMName.text.toString())
                        deceasedListLauncher.launch(intent)
            saveData()
        }
        mahTarpanam.setOnClickListener {
            // Check if no radio button is selected
            if (rg7.checkedRadioButtonId == -1) {
                // Show popup with arrow pointing to radio buttons
                val popupView = LinearLayout(this).apply {
                    orientation = LinearLayout.VERTICAL
                    setPadding(32, 24, 32, 24)
                    setBackgroundColor(Color.parseColor("#333333"))
                }

                // Arrow pointing up
                val arrow = TextView(this).apply {
                    text = "▲"
                    textSize = 20f
                    setTextColor(Color.parseColor("#333333"))
                    gravity = Gravity.CENTER
                }

                // Message text
                val message = TextView(this).apply {
                    text = "Select for 1 day or all the 15 days"
                    setTextColor(Color.WHITE)
                    textSize = 14f
                    gravity = Gravity.CENTER
                }

                popupView.addView(message)

                val popup = PopupWindow(
                    popupView,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    true
                ).apply {
                    setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                    elevation = 10f
                }

                // Show popup below the radio group
                popup.showAsDropDown(rg7, 0, 8, Gravity.CENTER)

                // Auto-dismiss after 3 seconds
                rg7.postDelayed({ popup.dismiss() }, 3000)

                return@setOnClickListener
            }

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

            intent.putExtra("ammaName",motherName.text.toString())
            intent.putExtra("appaAmmaName",yrGMName.text.toString())
            intent.putExtra("appaPattiName",yrGGMName.text.toString())
            intent.putExtra("appaKolluPattiName",yrGGGMName.text.toString())
            intent.putExtra("ammaAmmaName",ammaMName.text.toString())
            intent.putExtra("ammaPattiName",ammaGMName.text.toString())
            intent.putExtra("ammaKolluPattiName",ammaGGMName.text.toString())

            startActivity(intent)
            saveData()
        }

        rg7.setOnCheckedChangeListener { group, checkedId ->
            // Enable Proceed button when any radio is selected
            mahTarpanam.isEnabled = true
            mahTarpanam.alpha = 1.0f

            when (checkedId) {
                R.id.radio1G7 -> {
                    rb1_oneDayMTpnm.setTextColor(Color.BLUE)
                    rb1_oneDayMTpnm.setTypeface(null, Typeface.BOLD)
                    rb2_FifteenDaysMTpnm.setTextColor(Color.BLACK)
                    rb2_FifteenDaysMTpnm.setTypeface(null, Typeface.NORMAL)
                    noOfDaysTpnm = "OneDay"
                    println("noOfDaysTpnm =  $noOfDaysTpnm")
                }
                R.id.radio2G7 -> {
                    rb1_oneDayMTpnm.setTextColor(Color.BLACK)
                    rb1_oneDayMTpnm.setTypeface(null, Typeface.NORMAL)
                    rb2_FifteenDaysMTpnm.setTextColor(Color.BLUE)
                    rb2_FifteenDaysMTpnm.setTypeface(null, Typeface.BOLD)
                    noOfDaysTpnm = "15Days"
                    println("noOfDaysTpnm =  $noOfDaysTpnm")
                }
            }
        }
    }
    fun setDefaults(key: String, value: String, context: Context) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = preferences.edit()
        editor.putString(key, value)
        editor.apply()
    }
    fun getDefaults(key: String, context: Context): Editable {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        return (preferences.getString(key, null)) as Editable
    }
    fun View.hideKeyboard() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }
    fun saveData() {
        val sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.putString("ammaName", binding.yourMotherName.text.toString())
        editor.putString("appaAmmaName", binding.fatherMotherName.text.toString())
        editor.putString("appaPattiName", binding.fatherGrandmotherName.text.toString())
        editor.putString("appaKolluPattiName", binding.fatherGreatGrandmotherName.text.toString())
        editor.putString("ammaAmmaName", binding.motherMotherName.text.toString())
        editor.putString("ammaPattiName", binding.motherGrandmotherName.text.toString())
        editor.putString("ammaKolluPattiName", binding.motherGreatgrandmotherName.text.toString())

        editor.apply()
    }
    fun loadData() {
        val sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
        ammaName = sharedPreferences.getString("ammaName", "")!!
        appaAmmaName = sharedPreferences.getString("appaAmmaName", "")!!
        appaPattiName = sharedPreferences.getString("appaPattiName", "")!!
        appaKolluPattiName = sharedPreferences.getString("appaKolluPattiName", "")!!
        ammaAmmaName = sharedPreferences.getString("ammaAmmaName", "")!!
        ammaPattiName = sharedPreferences.getString("ammaPattiName", "")!!
        ammaKolluPattiName = sharedPreferences.getString("ammaKolluPattiName", "")!!

    }
    fun updateViews() {
        binding.yourMotherName.setText(ammaName)
        binding.fatherMotherName.setText(appaAmmaName)
        binding.fatherGrandmotherName.setText(appaPattiName)
        binding.fatherGreatGrandmotherName.setText(appaKolluPattiName)
        binding.motherMotherName.setText(ammaAmmaName)
        binding.motherGrandmotherName.setText(ammaPattiName)
        binding.motherGreatgrandmotherName.setText(ammaKolluPattiName)
    }
    private fun showSelectionPopup(anchorView: View) {
        // Create popup content
        val popupView = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(24, 16, 24, 16)
            setBackgroundColor(Color.parseColor("#333333"))

            // Arrow pointing up (using unicode triangle)
            val arrow = TextView(this@FurtherDetailsActivity).apply {
                text = "▲"
                textSize = 16f
                setTextColor(Color.parseColor("#333333"))
                gravity = Gravity.CENTER
            }

            // Message text
            val message = TextView(this@FurtherDetailsActivity).apply {
                text = "Select for 1 day or all the 15 days"
                setTextColor(Color.WHITE)
                textSize = 14f
                gravity = Gravity.CENTER
            }

            addView(message)
        }

        // Create and show popup
        val popup = PopupWindow(
            popupView,
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT,
            true
        ).apply {
            setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            elevation = 10f
        }

        // Show popup below the radio group with arrow effect
        popup.showAsDropDown(anchorView, 0, 8, Gravity.CENTER)

        // Auto-dismiss after 3 seconds
        anchorView.postDelayed({ popup.dismiss() }, 3000)
    }

}
