package com.sureshtrb.enKarma

//import kotlinx.android.synthetic.main.activity_ansestor_data.*

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.sureshtrb.enKarma.databinding.ActivityAnsestorDataBinding
import kotlin.collections.arrayListOf

var yrGFatherLive: String = ""
var MFatherLive: String = ""
var MGothram: String = ""
var MPravaras: String = ""
var urName: String = ""
var yFName: String = ""
var yGFName: String = ""
var yFGFName: String = ""
var yFGGFName: String = ""
var MFName: String = ""
var MGFName: String = ""
var MGGFName: String = ""
class AnsestorDataActivity : AppCompatActivity() {
/*
    private var myPreferences = "myPrefs"
    private var mySpinner2: Spinner? = null
    private var MmySpinner2: Spinner? = null
    private var EMPTY = ""
    private var NAME = "name"
    private var GOTHRAM = "gothram"
    private var MGOTHRAM = "Mgothram"
    private var PRAVARAS = "pravaras"
    private var MPRAVARAS = "Mpravaras"
 */
   // val sharedPrefs: String = ""
    val sHAREDPREFS: String = ""

    private lateinit var binding: ActivityAnsestorDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_ansestor_data)
        binding = ActivityAnsestorDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.home)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.subtitle = "முன்னோர் விவரங்கள்"
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setLogo(R.drawable.karma)
        supportActionBar!!.setDisplayUseLogoEnabled(true)

        loadRadioState()

        val intent = intent
        val dateTdy: String = intent.getStringExtra("Naal").toString()
        val place: String = intent.getStringExtra("Idam").toString()
        val varusham: String = intent.getStringExtra("TamilYear").toString()
        val ayyanamm: String = intent.getStringExtra("Ayanamm").toString()
        val kalam: String = intent.getStringExtra("KAALAM").toString()
        val rasee: String = intent.getStringExtra("RASEEE").toString()
        val baksham: String = intent.getStringExtra("BAKKSHAMM").toString()
        val todThithi: String = intent.getStringExtra("TODAYSTHITHI").toString()
        val kizhamai: String = intent.getStringExtra("KIZHAMAAII").toString()
        val nachathirm: String = intent.getStringExtra("NAKSM").toString()
        val yog: String = intent.getStringExtra("YGM").toString()
        val kar: String = intent.getStringExtra("KRNM").toString()
        val aMAVASYA = findViewById<Button>(R.id.AMAVASYA)
        val mAHALAYA = findViewById<Button>(R.id.MAHALAYA)

        val rg5 = findViewById<RadioGroup>(R.id.radio_group5)
        val rbYrGFLiving = findViewById<RadioButton>(R.id.radio1G5)
        val rbYrGFDeceased = findViewById<RadioButton>(R.id.radio2G5)
        val rg6 = findViewById<RadioGroup>(R.id.radio_group6)
        val rbMFLiving = findViewById<RadioButton>(R.id.radio1G6)
        val rbMFeceased = findViewById<RadioButton>(R.id.radio2G6)

        val yrNamee = findViewById<EditText>(R.id.your_Name)
        yrNamee.hideKeyboard()
        val yrFNamee = findViewById<EditText>(R.id.yr_father_name)
        val yrGFNamee = findViewById<EditText>(R.id.yr_Gfather_name)
        val yrGGFNamee = findViewById<EditText>(R.id.yr_GGfather_name)
        val yrGGGFNamee = findViewById<EditText>(R.id.yr_GGGfather_name)
        val mFNamee = findViewById<EditText>(R.id.MFather_name)
        val mGFNamee = findViewById<EditText>(R.id.MGFather_name)
        val mGGFNamee = findViewById<EditText>(R.id.MGGFather_name)

        if (rbYrGFLiving.isChecked) {
            binding.yrGfatherName.visibility = View.INVISIBLE
            binding.yrGGfatherName.visibility = View.VISIBLE
            binding.yrGGGfatherName.visibility = View.VISIBLE
            binding.yrGfatherName.text = null
        }else if (rbYrGFDeceased.isChecked) {
            binding.yrGfatherName.visibility = View.VISIBLE
            binding.yrGGfatherName.visibility = View.VISIBLE
            binding.yrGGGfatherName.visibility = View.INVISIBLE
            binding.yrGGGfatherName.text = null
        }else{
            binding.yrGfatherName.visibility = View.INVISIBLE
            binding.yrGGfatherName.visibility = View.INVISIBLE
            binding.yrGGGfatherName.visibility = View.INVISIBLE
        }
        if (rbMFLiving.isChecked) {
            binding.MFatherName.visibility = View.INVISIBLE
            binding.MGFatherName.visibility = View.INVISIBLE
            binding.MGGFatherName.visibility = View.INVISIBLE
            binding.MspinnerGothram.visibility = View.INVISIBLE
            binding.MspinnerPravaras.visibility = View.INVISIBLE
            binding.AMAVASYA.visibility = View.VISIBLE
            binding.MAHALAYA.visibility = View.VISIBLE
        }else if (rbMFeceased.isChecked) {
            binding.MFatherName.visibility = View.VISIBLE
            binding.MGFatherName.visibility = View.VISIBLE
            binding.MGGFatherName.visibility = View.VISIBLE
            binding.MspinnerGothram.visibility = View.VISIBLE
            binding.MspinnerPravaras.visibility = View.VISIBLE
            binding.AMAVASYA.visibility = View.VISIBLE
            binding.MAHALAYA.visibility = View.VISIBLE
        }else{
            binding.MFatherName.visibility = View.INVISIBLE
            binding.MGFatherName.visibility = View.INVISIBLE
            binding.MGGFatherName.visibility = View.INVISIBLE
            binding.MspinnerGothram.visibility = View.INVISIBLE
            binding.MspinnerPravaras.visibility = View.INVISIBLE
            binding.AMAVASYA.visibility = View.INVISIBLE
            binding.MAHALAYA.visibility = View.INVISIBLE
        }

        loadData()
        updateViews()

        aMAVASYA.setOnClickListener {
            val intent = Intent(this, AmavasyaTharpanam::class.java)
            intent.putExtra("Naal", dateTdy)
            intent.putExtra("Idam", place)
            intent.putExtra("TamilYear", varusham)
            intent.putExtra("Ayanamm", ayyanamm)
            intent.putExtra("KAALAM", kalam)
            intent.putExtra("RASEEE", rasee)
            intent.putExtra("BAKKSHAMM", baksham)
            intent.putExtra("TODAYSTHITHI", todThithi)
            intent.putExtra("KIZHAMAAII", kizhamai)
            intent.putExtra("NAKSM", nachathirm)
            intent.putExtra("YGM", yog)
            intent.putExtra("KRNM", kar)
            intent.putExtra("Peyar", yrNamee.text.toString())
            intent.putExtra("Appa", yrFNamee.text.toString())
            intent.putExtra("Thatha", yrGFNamee.text.toString())
            intent.putExtra("Kollu", yrGGFNamee.text.toString())
            intent.putExtra("Yellu", yrGGGFNamee.text.toString())
            intent.putExtra("AmmaAppa", mFNamee.text.toString())
            intent.putExtra("AmmaThatha", mGFNamee.text.toString())
            intent.putExtra("AmmaKolluThatha", mGGFNamee.text.toString())
            saveRadioState()
            startActivity(intent)
            saveData()

        }
        mAHALAYA.setOnClickListener {
            val intent: Intent = Intent(this, FurtherDetailsActivity::class.java)
            intent.putExtra("Naal", dateTdy)
            intent.putExtra("Idam", place)
            intent.putExtra("TamilYear", varusham)
            intent.putExtra("Ayanamm", ayyanamm)
            intent.putExtra("KAALAM", kalam)
            intent.putExtra("RASEEE", rasee)
            intent.putExtra("BAKKSHAMM", baksham)
            intent.putExtra("TODAYSTHITHI", todThithi)
            intent.putExtra("KIZHAMAAII", kizhamai)
            intent.putExtra("NAKSM", nachathirm)
            intent.putExtra("YGM", yog)
            intent.putExtra("KRNM", kar)
            intent.putExtra("Peyar", yrNamee.text.toString())
            intent.putExtra("Appa", yrFNamee.text.toString())
            intent.putExtra("Thatha", yrGFNamee.text.toString())
            intent.putExtra("Kollu", yrGGFNamee.text.toString())
            intent.putExtra("Yellu", yrGGGFNamee.text.toString())
            intent.putExtra("AmmaAppa", mFNamee.text.toString())
            intent.putExtra("AmmaThatha", mGFNamee.text.toString())
            intent.putExtra("AmmaKolluThatha", mGGFNamee.text.toString())
            intent.putExtra("AppaAppaLive", yrGFatherLive)

            saveRadioState()
            startActivity(intent)
            saveData()

        }

        val gothramPravarasMap = mapOf(
            "பாரத்வாஜ" to arrayListOf("Select Your Pravaras", "ஆங்கிரஸ பார்ஹஸ்பத்ய பாரத்வாஜேதி த்ரயார்ஷேய", "உப்ரெதி"),
            "ஷடமாஷண" to arrayListOf("Select Your Pravaras", "ஆங்கிரஸ பௌருகுத்ஸ த்ராஸ்தஸ்ய"),
            "ஆத்ரேய" to arrayListOf("Select Your Pravaras", "ஆத்ரேய ஆர்ச்சநானஸ ஶ்யாவாஶ்வ"),
            "வாதூல" to arrayListOf("Select MotherSide  Pravaras", "பார்க்கவ வைதஹவ்ய ஸாவேதஸ"),
            "ஸ்ரீவத்ஸ" to arrayListOf("Select MotherSide  Pravaras", "பார்கவ ச்யாவன ஆப்நவாந ஔர்வ பஞ்சார்ஷேய:", "ஜாமதக்ந்ய"),
            "கௌஶிக" to arrayListOf("Select MotherSide  Pravaras", "வைஶ்வாமித்ர ஆகமர்ஷண கௌசிகேதி த்ரயார்ஷேய:"),
            "விஶ்வாமித்ர" to arrayListOf("Select MotherSide  Pravaras", "வைஶ்வாமித்ர தேவராத ஔதல"),
            "கௌண்டிந்ய" to arrayListOf("Select MotherSide  Pravaras", "வாஸிஷ்ட மைத்ராவருண கௌண்டிந்ய"),
            "ஹாரித" to arrayListOf("Select MotherSide  Pravaras", "ஆங்கிரஸ ஆம்பரீஷ யுவநாச்வ"),
            "மௌத்கல்ய" to arrayListOf("Select MotherSide  Pravaras", "ஆங்கிரஸ பௌர்ம்யஶ்வ மௌத்கல்யேதி த்ரயார்ஷேய:", "தார்க்ஷ்ப பௌர்ம்யஶ்வ மௌத்கல்யேதி த்ரயார்ஷேய:", "ஆங்கிரஸ தாவ்ய மௌத்கல்யேதி த்ரயார்ஷேய:"),
            "சாண்டில்ய" to arrayListOf("Select MotherSide  Pravaras", "காஶ்யாப ஆவத்ஸார சாண்டில்ய", "காஶ்யாப ஆவத்ஸார தைவல"),
            "நைத்ருவகாஶ்யப" to arrayListOf("Select MotherSide  Pravaras", "காஶ்யாப ஆவத்ஸார நைத்ருவ"),
            "குத்ஸ" to arrayListOf("Select MotherSide  Pravaras", "ஆங்கிரஸ மாந்தாத்ர கௌதஸ"),
            "கண்வ" to arrayListOf("Select MotherSide  Pravaras", "ஆங்கீரஸ அஜமீட காண்வ", "ஆங்கீரஸ கௌர காண்வ"),
            "பராசர" to arrayListOf("Select MotherSide  Pravaras", "வாஶிஷ்ட சாக்த்ய பாராசர்ய"),
            "அகஸ்த்ய" to arrayListOf("Select MotherSide  Pravaras", "அகஸ்த்ய தார்ட்யச்யுத ஸௌமவாஹ"),
            "கௌதம" to arrayListOf("Select MotherSide  Pravaras", "ஆங்கீரஸ ஔஜித்ய கௌதமேத் த்ரயார்ஷேய:"),
            "கர்கி" to arrayListOf("Select MotherSide  Pravaras", "ஆங்கீரஸ பார்ஹஸ்பத்ய பாரத்வாஜ ஶைந்ய கார்க்ய", "ஆங்கீரஸ ஶைந்ய கார்க்ய"),
            "பாதராயண" to arrayListOf("Select MotherSide  Pravaras", "ஆங்கீரஸ பார்ஷதச்வ ராதீதர"),
            "காஶ்யப" to arrayListOf("Select MotherSide  Pravaras", "ஆங்கீரஸ ஆவத்ஸார தைவல"),
            "ஸங்க்ருத்ய" to arrayListOf("Select MotherSide  Pravaras", "ஆங்கீரஸ கௌரவீத ஸங்க்ருத்ய", "சாத்ய கௌரவீத ஸங்க்ருத்ய")
        )
        val motherGothramPravarasMap = mapOf(
            "பாரத்வாஜ" to arrayListOf("Select Your Pravaras", "ஆங்கிரஸ பார்ஹஸ்பத்ய பாரத்வாஜேதி த்ரயார்ஷேய", "உப்ரெதி"),
            "ஷடமாஷண" to arrayListOf("Select Your Pravaras", "ஆங்கிரஸ பௌருகுத்ஸ த்ராஸ்தஸ்ய"),
            "ஆத்ரேய" to arrayListOf("Select Your Pravaras", "ஆத்ரேய ஆர்ச்சநானஸ ஶ்யாவாஶ்வ"),
            "வாதூல" to arrayListOf("Select MotherSide  Pravaras", "பார்க்கவ வைதஹவ்ய ஸாவேதஸ"),
            "ஸ்ரீவத்ஸ" to arrayListOf("Select MotherSide  Pravaras", "பார்கவ ச்யாவன ஆப்நவாந ஔர்வ பஞ்சார்ஷேய:", "ஜாமதக்ந்ய"),
            "கௌஶிக" to arrayListOf("Select MotherSide  Pravaras", "வைஶ்வாமித்ர ஆகமர்ஷண கௌசிகேதி த்ரயார்ஷேய:"),
            "விஶ்வாமித்ர" to arrayListOf("Select MotherSide  Pravaras", "வைஶ்வாமித்ர தேவராத ஔதல"),
            "கௌண்டிந்ய" to arrayListOf("Select MotherSide  Pravaras", "வாஸிஷ்ட மைத்ராவருண கௌண்டிந்ய"),
            "ஹாரித" to arrayListOf("Select MotherSide  Pravaras", "ஆங்கிரஸ ஆம்பரீஷ யுவநாச்வ"),
            "மௌத்கல்ய" to arrayListOf("Select MotherSide  Pravaras", "ஆங்கிரஸ பௌர்ம்யஶ்வ மௌத்கல்யேதி த்ரயார்ஷேய:", "தார்க்ஷ்ப பௌர்ம்யஶ்வ மௌத்கல்யேதி த்ரயார்ஷேய:", "ஆங்கிரஸ தாவ்ய மௌத்கல்யேதி த்ரயார்ஷேய:"),
            "சாண்டில்ய" to arrayListOf("Select MotherSide  Pravaras", "காஶ்யாப ஆவத்ஸார சாண்டில்ய", "காஶ்யாப ஆவத்ஸார தைவல"),
            "நைத்ருவகாஶ்யப" to arrayListOf("Select MotherSide  Pravaras", "காஶ்யாப ஆவத்ஸார நைத்ருவ"),
            "குத்ஸ" to arrayListOf("Select MotherSide  Pravaras", "ஆங்கிரஸ மாந்தாத்ர கௌதஸ"),
            "கண்வ" to arrayListOf("Select MotherSide  Pravaras", "ஆங்கீரஸ அஜமீட காண்வ", "ஆங்கீரஸ கௌர காண்வ"),
            "பராசர" to arrayListOf("Select MotherSide  Pravaras", "வாஶிஷ்ட சாக்த்ய பாராசர்ய"),
            "அகஸ்த்ய" to arrayListOf("Select MotherSide  Pravaras", "அகஸ்த்ய தார்ட்யச்யுத ஸௌமவாஹ"),
            "கௌதம" to arrayListOf("Select MotherSide  Pravaras", "ஆங்கீரஸ ஔஜித்ய கௌதமேத் த்ரயார்ஷேய:"),
            "கர்கி" to arrayListOf("Select MotherSide  Pravaras", "ஆங்கீரஸ பார்ஹஸ்பத்ய பாரத்வாஜ ஶைந்ய கார்க்ய", "ஆங்கீரஸ ஶைந்ய கார்க்ய"),
            "பாதராயண" to arrayListOf("Select MotherSide  Pravaras", "ஆங்கீரஸ பார்ஷதச்வ ராதீதர"),
            "காஶ்யப" to arrayListOf("Select MotherSide  Pravaras", "ஆங்கீரஸ ஆவத்ஸார தைவல"),
            "ஸங்க்ருத்ய" to arrayListOf("Select MotherSide  Pravaras", "ஆங்கீரஸ கௌரவீத ஸங்க்ருத்ய", "சாத்ய கௌரவீத ஸங்க்ருத்ய")
        )

// Father side spinner setup
val gothramArray = gothramPravarasMap.keys.toTypedArray()
val gothramAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, gothramArray)
binding.spinnerGothram.adapter = gothramAdapter

binding.spinnerGothram.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val selectedGothram = gothramArray[position]
        urGothram = selectedGothram
        println("urGothram = $urGothram")

        val pravarasArray = gothramPravarasMap[selectedGothram] ?: arrayListOf("Select Your Pravaras")
        val pravarasAdapter = ArrayAdapter(this@AnsestorDataActivity, android.R.layout.simple_spinner_item, pravarasArray)
        binding.spinnerPravaras.adapter = pravarasAdapter

        binding.spinnerPravaras.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (position in 0 until pravarasArray.size) {
                    urPravaras = pravarasArray[position]
                    println("urPravaras = $urPravaras")
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}
}

// Mother side spinner setup
val mgothramArray = motherGothramPravarasMap.keys.toTypedArray().toMutableList()
        mgothramArray.add(0, "Select - MotherSide Gothram")
val mAdapter0 = ArrayAdapter(this, android.R.layout.simple_list_item_1, mgothramArray)
binding.MspinnerGothram.adapter = mAdapter0

binding.MspinnerGothram.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        val selectedGothram = mgothramArray[position]
        MGothram = selectedGothram
        println("MGothram = $MGothram")

        if (selectedGothram != "Select - MotherSide Gothram") {
            val pravarasArray = motherGothramPravarasMap[selectedGothram] ?: emptyList()
            val pravarasAdapter = ArrayAdapter(this@AnsestorDataActivity, android.R.layout.simple_list_item_1, pravarasArray)
            binding.MspinnerPravaras.adapter = pravarasAdapter

            binding.MspinnerPravaras.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    if (position in 0 until pravarasArray.size) {
                        MPravaras = pravarasArray[position]
                        println("MPravaras = $MPravaras")
                    }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {}
            }
        } else {
            // Handle case where "Select - MotherSide Gothram" is selected
            binding.MspinnerPravaras.adapter = ArrayAdapter(this@AnsestorDataActivity, android.R.layout.simple_list_item_1, emptyList<String>())
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}
}

        rg5.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radio1G5 -> {
                    rbYrGFLiving.setTextColor(Color.BLUE)
                    rbYrGFLiving.setTypeface(null, Typeface.BOLD)
                    rbYrGFDeceased.setTextColor(Color.BLACK)
                    rbYrGFDeceased.setTypeface(null, Typeface.NORMAL)
                    yrGFatherLive = "Living"
                    binding.yrGfatherName.setText("")
                    println("yrGFatherLive =  $yrGFatherLive")
                    binding.yrGfatherName.visibility = View.INVISIBLE
                    binding.yrGGfatherName.visibility = View.VISIBLE
                    binding.yrGGGfatherName.visibility = View.VISIBLE
                }
                R.id.radio2G5 -> {
                    rbYrGFLiving.setTextColor(Color.BLACK)
                    rbYrGFLiving.setTypeface(null, Typeface.NORMAL)
                    rbYrGFDeceased.setTextColor(Color.RED)
                    rbYrGFDeceased.setTypeface(null, Typeface.BOLD)
                    yrGFatherLive = "Deceased"
                    binding.yrGGGfatherName.setText("")
                    println("yrGFatherLive =  $yrGFatherLive")
                    binding.yrGfatherName.visibility = View.VISIBLE
                    binding.yrGGfatherName.visibility = View.VISIBLE
                    binding.yrGGGfatherName.visibility = View.INVISIBLE
                }
            }
        }

        rg6.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radio1G6 -> {
                    rbMFLiving.setTextColor(Color.BLUE)
                    rbMFLiving.setTypeface(null, Typeface.BOLD)
                    rbMFeceased.setTextColor(Color.BLACK)
                    rbMFeceased.setTypeface(null, Typeface.NORMAL)
                    MFatherLive = "Living"
                    println("MFatherLive =  $MFatherLive")
                    binding.MFatherName.setText("")
                    binding.MGFatherName.setText("")
                    binding.MGGFatherName.setText("")
                    binding.MFatherName.visibility = View.INVISIBLE
                    binding.MGFatherName.visibility = View.INVISIBLE
                    binding.MGGFatherName.visibility = View.INVISIBLE
                    binding.MspinnerGothram.visibility = View.INVISIBLE
                    binding.MspinnerPravaras.visibility = View.INVISIBLE
                    binding.AMAVASYA.visibility = View.VISIBLE
                    binding.MAHALAYA.visibility = View.VISIBLE
                }
                R.id.radio2G6 -> {
                    rbMFLiving.setTextColor(Color.BLACK)
                    rbMFLiving.setTypeface(null, Typeface.NORMAL)
                    rbMFeceased.setTextColor(Color.RED)
                    rbMFeceased.setTypeface(null, Typeface.BOLD)
                    MFatherLive = "Deceased"
                    println("MFatherLive =  $MFatherLive")
                    binding.MFatherName.visibility = View.VISIBLE
                    binding.MGFatherName.visibility = View.VISIBLE
                    binding.MGGFatherName.visibility = View.VISIBLE
                    binding.MspinnerGothram.visibility = View.VISIBLE
                    binding.MspinnerPravaras.visibility = View.VISIBLE
                    aMAVASYA.visibility = View.VISIBLE
                    mAHALAYA.visibility = View.VISIBLE
                }
            }
        }
    }
/*
    fun setDefaults(key: String, value: String, context: Context) {
        val preferences = androidx.preference.PreferenceManager.getDefaultSharedPreferences(context)
        val editor = preferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getDefaults(key: String, context: Context): Editable {
        val preferences = androidx.preference.PreferenceManager.getDefaultSharedPreferences(context)
        return Editable.Factory.getInstance().newEditable(preferences.getString(key, null))
    }
*/
    fun View.hideKeyboard() {
        val imm = context.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }

    fun saveData() {
        val sharedPreferences = getSharedPreferences(sHAREDPREFS, MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.putString("Peyar", binding.yourName.text.toString())
        editor.putString("Appa", binding.yrFatherName.text.toString())
        editor.putString("Thatha", binding.yrGfatherName.text.toString())
        editor.putString("Kollu", binding.yrGGfatherName.text.toString())
        editor.putString("Yellu", binding.yrGGGfatherName.text.toString())
        editor.putString("AmmaAppa", binding.MFatherName.text.toString())
        editor.putString("AmmaThatha", binding.MGFatherName.text.toString())
        editor.putString("AmmaKolluThatha", binding.MGGFatherName.text.toString())

        editor.apply()
    }

    fun loadData() {
        val sharedPreferences = getSharedPreferences(sHAREDPREFS, MODE_PRIVATE)
        urName = sharedPreferences.getString("Peyar", "")!!
        yFName = sharedPreferences.getString("Appa", "")!!
        yGFName = sharedPreferences.getString("Thatha", "")!!
        yFGFName = sharedPreferences.getString("Kollu", "")!!
        yFGGFName = sharedPreferences.getString("Yellu", "")!!
        MFName = sharedPreferences.getString("AmmaAppa", "")!!
        MGFName = sharedPreferences.getString("AmmaThatha", "")!!
        MGGFName = sharedPreferences.getString("AmmaKolluThatha", "")!!
    }

    fun updateViews() {
        binding.yourName.setText(urName)
        binding.yrFatherName.setText(yFName)
        binding.yrGfatherName.setText(yGFName)
        binding.yrGGfatherName.setText(yFGFName)
        binding.yrGGGfatherName.setText(yFGGFName)
        binding.MFatherName.setText(MFName)
        binding.MGFatherName.setText(MGFName)
        binding.MGGFatherName.setText(MGGFName)
    }

    private fun saveRadioState() {
        val rbYrGFLiving = findViewById<RadioButton>(R.id.radio1G5)
        val rbYrGFDeceased = findViewById<RadioButton>(R.id.radio2G5)
        val rbMFLiving = findViewById<RadioButton>(R.id.radio1G6)
        val rbMFeceased = findViewById<RadioButton>(R.id.radio2G6)

        val settings = getSharedPreferences("Answer", 0)
        val editor = settings.edit()
        editor.putBoolean("question5A", rbYrGFLiving.isChecked)
        editor.putBoolean("question5B", rbYrGFDeceased.isChecked)
        editor.putBoolean("question6A", rbMFLiving.isChecked)
        editor.putBoolean("question6B", rbMFeceased.isChecked)

        editor.apply()
    }
    private fun loadRadioState() {
        val rbYrGFLiving = findViewById<RadioButton>(R.id.radio1G5)
        val rbYrGFDeceased = findViewById<RadioButton>(R.id.radio2G5)
        val rbMFLiving = findViewById<RadioButton>(R.id.radio1G6)
        val rbMFeceased = findViewById<RadioButton>(R.id.radio2G6)
        val amavasya = findViewById<Button>(R.id.AMAVASYA)
        val mahalaya = findViewById<Button>(R.id.MAHALAYA)

        val settings = getSharedPreferences("Answer",0)
        if (settings.getBoolean("question5A", rbYrGFLiving.isChecked)){
            rbYrGFLiving.isChecked = settings.getBoolean("question5A",false)
            yrGFatherLive = "Living"
            this.binding.yrGfatherName.setText("")
            binding.yrGfatherName.visibility = View.INVISIBLE
            binding.yrGGfatherName.visibility = View.VISIBLE
            binding.yrGGGfatherName.visibility = View.VISIBLE
        }
        if (settings.getBoolean("question5B", rbYrGFDeceased.isChecked)){
            rbYrGFDeceased.isChecked = settings.getBoolean("question5B", false)
            yrGFatherLive = "Deceased"
            this.binding.yrGGGfatherName.setText("")
            binding.yrGfatherName.visibility = View.VISIBLE
            binding.yrGGfatherName.visibility = View.VISIBLE
            binding.yrGGGfatherName.visibility = View.INVISIBLE
        }
        if (settings.getBoolean("question6A", rbMFLiving.isChecked)){
            rbMFLiving.isChecked = settings.getBoolean("question6A", false)
            MFatherLive = "Living"
            binding.MFatherName.setText("")
            binding.MGGFatherName.setText("")
            binding.MGGFatherName.setText("")
            binding.MFatherName.visibility = View.INVISIBLE
            binding.MGFatherName.visibility = View.INVISIBLE
            binding.MGGFatherName.visibility = View.INVISIBLE
            binding.MspinnerGothram.visibility = View.INVISIBLE
            binding.MspinnerPravaras.visibility = View.INVISIBLE
            amavasya.visibility = View.VISIBLE
            mahalaya.visibility = View.VISIBLE
        }
        if (settings.getBoolean("question6B", rbMFeceased.isChecked)){
            rbMFeceased.isChecked = settings.getBoolean("question6B", false)
            MFatherLive = "Deceased"
            binding.MFatherName.visibility = View.VISIBLE
            binding.MGFatherName.visibility = View.VISIBLE
            binding.MGGFatherName.visibility = View.VISIBLE
            binding.MspinnerGothram.visibility = View.VISIBLE
            binding.MspinnerPravaras.visibility = View.VISIBLE
            amavasya.visibility = View.VISIBLE
            mahalaya.visibility = View.VISIBLE
        }
    }
}
