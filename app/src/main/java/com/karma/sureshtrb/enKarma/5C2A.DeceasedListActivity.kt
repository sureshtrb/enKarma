package com.karma.sureshtrb.enKarma

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.preference.PreferenceManager
import android.text.Editable
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.karma.sureshtrb.enKarma.databinding.ActivityDeceasedListBinding

class DeceasedListActivity : AppCompatActivity() {

    // Class-level variables
    val sharedPrefs = "sharedPrefs"
    val SHAREDPREFS = "SHAREDPREFS"
    private lateinit var binding: ActivityDeceasedListBinding
    private var selectedRowForSwap: Int = -1

    var name1 = ""; var name2 = ""; var name3 = ""; var name4 = ""; var name5 = ""
    var name6 = ""; var name7 = ""; var name8 = ""; var name9 = ""; var name10 = ""
    var name11 = ""; var name12 = ""; var name13 = ""; var name14 = ""; var name15 = ""

    var BrOr1 = ""; var BrOr2 = ""; var BrOr3 = ""; var BrOr4 = ""; var BrOr5 = ""
    var BrOr6 = ""; var BrOr7 = ""; var BrOr8 = ""; var BrOr9 = ""; var BrOr10 = ""
    var BrOr11 = ""; var BrOr12 = ""; var BrOr13 = ""; var BrOr14 = ""; var BrOr15 = ""

    var Goth1 = ""; var Goth2 = ""; var Goth3 = ""; var Goth4 = ""; var Goth5 = ""
    var Goth6 = ""; var Goth7 = ""; var Goth8 = ""; var Goth9 = ""; var Goth10 = ""
    var Goth11 = ""; var Goth12 = ""; var Goth13 = ""; var Goth14 = ""; var Goth15 = ""

    var Gndr1 = ""; var Gndr2 = ""; var Gndr3 = ""; var Gndr4 = ""; var Gndr5 = ""
    var Gndr6 = ""; var Gndr7 = ""; var Gndr8 = ""; var Gndr9 = ""; var Gndr10 = ""
    var Gndr11 = ""; var Gndr12 = ""; var Gndr13 = ""; var Gndr14 = ""; var Gndr15 = ""

    var RlShp1 = ""; var RlShp2 = ""; var RlShp3 = ""; var RlShp4 = ""; var RlShp5 = ""
    var RlShp6 = ""; var RlShp7 = ""; var RlShp8 = ""; var RlShp9 = ""; var RlShp10 = ""
    var RlShp11 = ""; var RlShp12 = ""; var RlShp13 = ""; var RlShp14 = ""; var RlShp15 = ""

    var personGothram = ""
    var personRelationShip = ""
    var personGender = ""
    var personBirthOrder = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDeceasedListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setHomeAsUpIndicator(R.drawable.home)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.subtitle = "Deceased Names"
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setLogo(R.drawable.karma)
        supportActionBar?.setDisplayUseLogoEnabled(true)

        // Set initial visibility to INVISIBLE
        binding.headRow.visibility = View.INVISIBLE
        binding.firstRow.visibility = View.INVISIBLE
        binding.secondRow.visibility = View.INVISIBLE
        binding.thirdRow.visibility = View.INVISIBLE
        binding.fourthRow.visibility = View.INVISIBLE
        binding.fifthRow.visibility = View.INVISIBLE
        binding.sixthRow.visibility = View.INVISIBLE
        binding.seventhRow.visibility = View.INVISIBLE
        binding.eighthRow.visibility = View.INVISIBLE
        binding.ninethRow.visibility = View.INVISIBLE
        binding.tenRow.visibility = View.INVISIBLE
        binding.elevenRow.visibility = View.INVISIBLE
        binding.twelveRow.visibility = View.INVISIBLE
        binding.thirteenRow.visibility = View.INVISIBLE
        binding.fourteenRow.visibility = View.INVISIBLE
        binding.fifteenRow.visibility = View.INVISIBLE

        // Load data and setup
        loadData()
        updateViews()
        setupRowClickListeners()

        // Spinner arrays
        val genderarray = arrayOf("Select - Gender", "ஆண்", "பெண்")
        val birthOrderarray1 = arrayOf("Select - Birth Order", "Elder", "Younger")
        val birthOrderarray2 = arrayOf("")
        val relationarrayGents = arrayOf("Select - Relationship", "தந்தை", "தாத்தா", "கொள்ளு தாத்தா or எள்ளு தாத்தா", "சித்தப்பா", "பெரியப்பா", "மாமா", "அத்தான்", "அண்ணன்", "தம்பி", "மகன்", "பேரன்", "கொள்ளு பேரன்", "மருமகன்", "சகோதரன்", "மைத்துனன்", "நண்பன்", "குரு", "ஆசான்", "உறவினர்", "தெரியாதவர்", "மச்சான்", "அண்ணி மகன்", "தங்கை மகன்", "அக்கா மகன்")
        val relationarrayLadies = arrayOf("Select - Relationship", "தாய்", "பாட்டி", "கொள்ளு பாட்டி", "சித்தி", "பெரியம்மா", "அத்தை", "மாமி", "அக்கா", "தங்கை", "மகள்", "பேத்தி", "கொள்ளு பேத்தி", "மருமகள்", "சகோதரி", "நண்பி", "உறவினர்", "தெரியாதவர்", "மைத்துனி", "அண்ணி", "தங்கை மகள்")
        val gothramarray = arrayOf("Select - Gothram", "ஆங்கீரஸ", "அத்ரி", "பரத்வாஜ", "பார்கவ", "கௌசிக", "காஸ்யப", "கௌண்டின்ய", "கௌதம", "ஹரித", "ஜமதக்னி", "கபில", "கௌசல்ய", "க்ருஷ்ணாத்ரேய", "மாண்டவ்ய", "மௌத்கல்ய", "நித்ருவ", "பராசர", "சாண்டில்ய", "ஸ்ரீவத்ஸ", "வசிஷ்ட", "விஸ்வாமித்ர")

        // Setup Gender Spinner
        val adapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_1, genderarray)
        binding.genderOrder.adapter = adapter1

        binding.genderOrder.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                personGender = genderarray[position]

                if (genderarray[position] == "பெண்") {
                    binding.relShip.adapter = ArrayAdapter(this@DeceasedListActivity, android.R.layout.simple_list_item_1, relationarrayLadies)
                    binding.birthOrder.adapter = ArrayAdapter(this@DeceasedListActivity, android.R.layout.simple_list_item_1, birthOrderarray2)
                    binding.birthOrder.isEnabled = false
                } else {
                    binding.relShip.adapter = ArrayAdapter(this@DeceasedListActivity, android.R.layout.simple_list_item_1, relationarrayGents)
                    binding.birthOrder.adapter = ArrayAdapter(this@DeceasedListActivity, android.R.layout.simple_list_item_1, birthOrderarray1)
                    binding.birthOrder.isEnabled = true
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        // Setup Relationship Spinner
        binding.relShip.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                personRelationShip = parent?.getItemAtPosition(position).toString()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        // Setup Birth Order Spinner
        binding.birthOrder.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                personBirthOrder = parent?.getItemAtPosition(position).toString()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        // Setup Gothram Spinner
        val adapter4 = ArrayAdapter(this, android.R.layout.simple_list_item_1, gothramarray)
        binding.gthrm.adapter = adapter4

        binding.gthrm.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                personGothram = gothramarray[position]
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        // Save Button Click Listener
        binding.SaveName.setOnClickListener {
            val nameText = binding.nameOfThePerson.text.toString()

            if (nameText.isEmpty()) {
                Toast.makeText(this, "Please enter a name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (binding.Name1.text.isEmpty()) {
                binding.headRow.visibility = View.VISIBLE
                binding.firstRow.visibility = View.VISIBLE
                binding.Name1.text = nameText
                binding.BirthOrder1.text = personBirthOrder
                binding.gotram1.text = personGothram
                binding.relationship1.text = personRelationShip
                Gndr1 = personGender
            } else if (binding.Name2.text.isEmpty()) {
                binding.secondRow.visibility = View.VISIBLE
                binding.Name2.text = nameText
                binding.BirthOrder2.text = personBirthOrder
                binding.gotram2.text = personGothram
                binding.relationship2.text = personRelationShip
                Gndr2 = personGender
            } else if (binding.Name3.text.isEmpty()) {
                binding.thirdRow.visibility = View.VISIBLE
                binding.Name3.text = nameText
                binding.BirthOrder3.text = personBirthOrder
                binding.gotram3.text = personGothram
                binding.relationship3.text = personRelationShip
                Gndr3 = personGender
            } else if (binding.Name4.text.isEmpty()) {
                binding.fourthRow.visibility = View.VISIBLE
                binding.Name4.text = nameText
                binding.BirthOrder4.text = personBirthOrder
                binding.gotram4.text = personGothram
                binding.relationship4.text = personRelationShip
                Gndr4 = personGender
            } else if (binding.Name5.text.isEmpty()) {
                binding.fifthRow.visibility = View.VISIBLE
                binding.Name5.text = nameText
                binding.BirthOrder5.text = personBirthOrder
                binding.gotram5.text = personGothram
                binding.relationship5.text = personRelationShip
                Gndr5 = personGender
            } else if (binding.Name6.text.isEmpty()) {
                binding.sixthRow.visibility = View.VISIBLE
                binding.Name6.text = nameText
                binding.BirthOrder6.text = personBirthOrder
                binding.gotram6.text = personGothram
                binding.relationship6.text = personRelationShip
                Gndr6 = personGender
            } else if (binding.Name7.text.isEmpty()) {
                binding.seventhRow.visibility = View.VISIBLE
                binding.Name7.text = nameText
                binding.BirthOrder7.text = personBirthOrder
                binding.gotram7.text = personGothram
                binding.relationship7.text = personRelationShip
                Gndr7 = personGender
            } else if (binding.Name8.text.isEmpty()) {
                binding.eighthRow.visibility = View.VISIBLE
                binding.Name8.text = nameText
                binding.BirthOrder8.text = personBirthOrder
                binding.gotram8.text = personGothram
                binding.relationship8.text = personRelationShip
                Gndr8 = personGender
            } else if (binding.Name9.text.isEmpty()) {
                binding.ninethRow.visibility = View.VISIBLE
                binding.Name9.text = nameText
                binding.BirthOrder9.text = personBirthOrder
                binding.gotram9.text = personGothram
                binding.relationship9.text = personRelationShip
                Gndr9 = personGender
            } else if (binding.Name10.text.isEmpty()) {
                binding.tenRow.visibility = View.VISIBLE
                binding.Name10.text = nameText
                binding.BirthOrder10.text = personBirthOrder
                binding.gotram10.text = personGothram
                binding.relationship10.text = personRelationShip
                Gndr10 = personGender
            } else if (binding.Name11.text.isEmpty()) {
                binding.elevenRow.visibility = View.VISIBLE
                binding.Name11.text = nameText
                binding.BirthOrder
            } else if (binding.Name11.text.isEmpty()) {
                binding.elevenRow.visibility = View.VISIBLE
                binding.Name11.text = nameText
                binding.BirthOrder11.text = personBirthOrder
                binding.gotram11.text = personGothram
                binding.relationship11.text = personRelationShip
                Gndr11 = personGender
            } else if (binding.Name12.text.isEmpty()) {
                binding.twelveRow.visibility = View.VISIBLE
                binding.Name12.text = nameText
                binding.BirthOrder12.text = personBirthOrder
                binding.gotram12.text = personGothram
                binding.relationship12.text = personRelationShip
                Gndr12 = personGender
            } else if (binding.Name13.text.isEmpty()) {
                binding.thirteenRow.visibility = View.VISIBLE
                binding.Name13.text = nameText
                binding.BirthOrder13.text = personBirthOrder
                binding.gotram13.text = personGothram
                binding.relationship13.text = personRelationShip
                Gndr13 = personGender
            } else if (binding.Name14.text.isEmpty()) {
                binding.fourteenRow.visibility = View.VISIBLE
                binding.Name14.text = nameText
                binding.BirthOrder14.text = personBirthOrder
                binding.gotram14.text = personGothram
                binding.relationship14.text = personRelationShip
                Gndr14 = personGender
            } else if (binding.Name15.text.isEmpty()) {
                binding.fifteenRow.visibility = View.VISIBLE
                binding.Name15.text = nameText
                binding.BirthOrder15.text = personBirthOrder
                binding.gotram15.text = personGothram
                binding.relationship15.text = personRelationShip
                Gndr15 = personGender
            }
            savedData()
            binding.nameOfThePerson.text?.clear()
        }

        // Clear All Button
        binding.ClearAll.setOnClickListener {
            binding.headRow.visibility = View.INVISIBLE
            binding.firstRow.visibility = View.INVISIBLE
            binding.secondRow.visibility = View.INVISIBLE
            binding.thirdRow.visibility = View.INVISIBLE
            binding.fourthRow.visibility = View.INVISIBLE
            binding.fifthRow.visibility = View.INVISIBLE
            binding.sixthRow.visibility = View.INVISIBLE
            binding.seventhRow.visibility = View.INVISIBLE
            binding.eighthRow.visibility = View.INVISIBLE
            binding.ninethRow.visibility = View.INVISIBLE
            binding.tenRow.visibility = View.INVISIBLE
            binding.elevenRow.visibility = View.INVISIBLE
            binding.twelveRow.visibility = View.INVISIBLE
            binding.thirteenRow.visibility = View.INVISIBLE
            binding.fourteenRow.visibility = View.INVISIBLE
            binding.fifteenRow.visibility = View.INVISIBLE
            binding.Name1.text = ""; binding.Name2.text = ""; binding.Name3.text = ""
            binding.Name4.text = ""; binding.Name5.text = ""; binding.Name6.text = ""
            binding.Name7.text = ""; binding.Name8.text = ""; binding.Name9.text = ""
            binding.Name10.text = ""; binding.Name11.text = ""; binding.Name12.text = ""
            binding.Name13.text = ""; binding.Name14.text = ""; binding.Name15.text = ""
            binding.BirthOrder1.text = ""; binding.BirthOrder2.text = ""; binding.BirthOrder3.text = ""
            binding.BirthOrder4.text = ""; binding.BirthOrder5.text = ""; binding.BirthOrder6.text = ""
            binding.BirthOrder7.text = ""; binding.BirthOrder8.text = ""; binding.BirthOrder9.text = ""
            binding.BirthOrder10.text = ""; binding.BirthOrder11.text = ""; binding.BirthOrder12.text = ""
            binding.BirthOrder13.text = ""; binding.BirthOrder14.text = ""; binding.BirthOrder15.text = ""
            binding.gotram1.text = ""; binding.gotram2.text = ""; binding.gotram3.text = ""
            binding.gotram4.text = ""; binding.gotram5.text = ""; binding.gotram6.text = ""
            binding.gotram7.text = ""; binding.gotram8.text = ""; binding.gotram9.text = ""
            binding.gotram10.text = ""; binding.gotram11.text = ""; binding.gotram12.text = ""
            binding.gotram13.text = ""; binding.gotram14.text = ""; binding.gotram15.text = ""
            binding.relationship1.text = ""; binding.relationship2.text = ""; binding.relationship3.text = ""
            binding.relationship4.text = ""; binding.relationship5.text = ""; binding.relationship6.text = ""
            binding.relationship7.text = ""; binding.relationship8.text = ""; binding.relationship9.text = ""
            binding.relationship10.text = ""; binding.relationship11.text = ""; binding.relationship12.text = ""
            binding.relationship13.text = ""; binding.relationship14.text = ""; binding.relationship15.text = ""
            Gndr1 = ""; Gndr2 = ""; Gndr3 = ""; Gndr4 = ""; Gndr5 = ""
            Gndr6 = ""; Gndr7 = ""; Gndr8 = ""; Gndr9 = ""; Gndr10 = ""
            Gndr11 = ""; Gndr12 = ""; Gndr13 = ""; Gndr14 = ""; Gndr15 = ""
            savedData()
        }

        // MAHTARPANAMBTN Click Listener
        binding.MAHTARPANAMBTN.setOnClickListener {
            val intent = Intent(this, MahalayaTpnmActivity::class.java)
            intent.putExtra("N1", binding.Name1.text.toString())
            intent.putExtra("N2", binding.Name2.text.toString())
            intent.putExtra("N3", binding.Name3.text.toString())
            intent.putExtra("N4", binding.Name4.text.toString())
            intent.putExtra("N5", binding.Name5.text.toString())
            intent.putExtra("N6", binding.Name6.text.toString())
            intent.putExtra("N7", binding.Name7.text.toString())
            intent.putExtra("N8", binding.Name8.text.toString())
            intent.putExtra("N9", binding.Name9.text.toString())
            intent.putExtra("N10", binding.Name10.text.toString())
            intent.putExtra("N11", binding.Name11.text.toString())
            intent.putExtra("N12", binding.Name12.text.toString())
            intent.putExtra("N13", binding.Name13.text.toString())
            intent.putExtra("N14", binding.Name14.text.toString())
            intent.putExtra("N15", binding.Name15.text.toString())
            intent.putExtra("G1", Gndr1); intent.putExtra("G2", Gndr2)
            intent.putExtra("G3", Gndr3); intent.putExtra("G4", Gndr4)
            intent.putExtra("G5", Gndr5); intent.putExtra("G6", Gndr6)
            intent.putExtra("G7", Gndr7); intent.putExtra("G8", Gndr8)
            intent.putExtra("G9", Gndr9); intent.putExtra("G10", Gndr10)
            intent.putExtra("G11", Gndr11); intent.putExtra("G12", Gndr12)
            intent.putExtra("G13", Gndr13); intent.putExtra("G14", Gndr14)
            intent.putExtra("G15", Gndr15)
            startActivity(intent)
        }

    } // END OF onCreate()

    // ============ HELPER FUNCTIONS (OUTSIDE onCreate) ============

    fun loadData() {
        val sharedPreferences = getSharedPreferences(SHAREDPREFS, Context.MODE_PRIVATE)
        name1 = sharedPreferences.getString("N1", "")!!
        name2 = sharedPreferences.getString("N2", "")!!
        name3 = sharedPreferences.getString("N3", "")!!
        name4 = sharedPreferences.getString("N4", "")!!
        name5 = sharedPreferences.getString("N5", "")!!
        name6 = sharedPreferences.getString("N6", "")!!
        name7 = sharedPreferences.getString("N7", "")!!
        name8 = sharedPreferences.getString("N8", "")!!
        name9 = sharedPreferences.getString("N9", "")!!
        name10 = sharedPreferences.getString("N10", "")!!
        name11 = sharedPreferences.getString("N11", "")!!
        name12 = sharedPreferences.getString("N12", "")!!
        name13 = sharedPreferences.getString("N13", "")!!
        name14 = sharedPreferences.getString("N14", "")!!
        name15 = sharedPreferences.getString("N15", "")!!
        BrOr1 = sharedPreferences.getString("B1", "")!!
        BrOr2 = sharedPreferences.getString("B2", "")!!
        BrOr3 = sharedPreferences.getString("B3", "")!!
        BrOr4 = sharedPreferences.getString("B4", "")!!
        BrOr5 = sharedPreferences.getString("B5", "")!!
        BrOr6 = sharedPreferences.getString("B6", "")!!
        BrOr7 = sharedPreferences.getString("B7", "")!!
        BrOr8 = sharedPreferences.getString("B8", "")!!
        BrOr9 = sharedPreferences.getString("B9", "")!!
        BrOr10 = sharedPreferences.getString("B10", "")!!
        BrOr11 = sharedPreferences.getString("B11", "")!!
        BrOr12 = sharedPreferences.getString("B12", "")!!
        BrOr13 = sharedPreferences.getString("B13", "")!!
        BrOr14 = sharedPreferences.getString("B14", "")!!
        BrOr15 = sharedPreferences.getString("B15", "")!!
        Goth1 = sharedPreferences.getString("G1", "")!!
        Goth2 = sharedPreferences.getString("G2", "")!!
        Goth3 = sharedPreferences.getString("G3", "")!!
        Goth4 = sharedPreferences.getString("G4", "")!!
        Goth5 = sharedPreferences.getString("G5", "")!!
        Goth6 = sharedPreferences.getString("G6", "")!!
        Goth7 = sharedPreferences.getString("G7", "")!!
        Goth8 = sharedPreferences.getString("G8", "")!!
        Goth9 = sharedPreferences.getString("G9", "")!!
        Goth10 = sharedPreferences.getString("G10", "")!!
        Goth11 = sharedPreferences.getString("G11", "")!!
        Goth12 = sharedPreferences.getString("G12", "")!!
        Goth13 = sharedPreferences.getString("G13", "")!!
        Goth14 = sharedPreferences.getString("G14", "")!!
        Goth15 = sharedPreferences.getString("G15", "")!!
        RlShp1 = sharedPreferences.getString("R1", "")!!
        RlShp2 = sharedPreferences.getString("R2", "")!!
        RlShp3 = sharedPreferences.getString("R3", "")!!
        RlShp4 = sharedPreferences.getString("R4", "")!!
        RlShp5 = sharedPreferences.getString("R5", "")!!
        RlShp6 = sharedPreferences.getString("R6", "")!!
        RlShp7 = sharedPreferences.getString("R7", "")!!
        RlShp8 = sharedPreferences.getString("R8", "")!!
        RlShp9 = sharedPreferences.getString("R9", "")!!
        RlShp10 = sharedPreferences.getString("R10", "")!!
        RlShp11 = sharedPreferences.getString("R11", "")!!
        RlShp12 = sharedPreferences.getString("R12", "")!!
        RlShp13 = sharedPreferences.getString("R13", "")!!
        RlShp14 = sharedPreferences.getString("R14", "")!!
        RlShp15 = sharedPreferences.getString("R15", "")!!
        Gndr1 = sharedPreferences.getString("gdr1", "")!!
        Gndr2 = sharedPreferences.getString("gdr2", "")!!
        Gndr3 = sharedPreferences.getString("gdr3", "")!!
        Gndr4 = sharedPreferences.getString("gdr4", "")!!
        Gndr5 = sharedPreferences.getString("gdr5", "")!!
        Gndr6 = sharedPreferences.getString("gdr6", "")!!
        Gndr7 = sharedPreferences.getString("gdr7", "")!!
        Gndr8 = sharedPreferences.getString("gdr8", "")!!
        Gndr9 = sharedPreferences.getString("gdr9", "")!!
        Gndr10 = sharedPreferences.getString("gdr10", "")!!
        Gndr11 = sharedPreferences.getString("gdr11", "")!!
        Gndr12 = sharedPreferences.getString("gdr12", "")!!
        Gndr13 = sharedPreferences.getString("gdr13", "")!!
        Gndr14 = sharedPreferences.getString("gdr14", "")!!
        Gndr15 = sharedPreferences.getString("gdr15", "")!!
    }

    fun updateViews() {
        binding.Name1.text = name1; binding.Name2.text = name2; binding.Name3.text = name3
        binding.Name4.text = name4; binding.Name5.text = name5; binding.Name6.text = name6
        binding.Name7.text = name7; binding.Name8.text = name8; binding.Name9.text = name9
        binding.Name10.text = name10; binding.Name11.text = name11; binding.Name12.text = name12
        binding.Name13.text = name13; binding.Name14.text = name14; binding.Name15.text = name15
        binding.BirthOrder1.text = BrOr1; binding.BirthOrder2.text = BrOr2; binding.BirthOrder3.text = BrOr3
        binding.BirthOrder4.text = BrOr4; binding.BirthOrder5.text = BrOr5; binding.BirthOrder6.text = BrOr6
        binding.BirthOrder7.text = BrOr7; binding.BirthOrder8.text = BrOr8; binding.BirthOrder9.text = BrOr9
        binding.BirthOrder10.text = BrOr10; binding.BirthOrder11.text = BrOr11; binding.BirthOrder12.text = BrOr12
        binding.BirthOrder13.text = BrOr13; binding.BirthOrder14.text = BrOr14; binding.BirthOrder15.text = BrOr15
        binding.gotram1.text = Goth1; binding.gotram2.text = Goth2; binding.gotram3.text = Goth3
        binding.gotram4.text = Goth4; binding.gotram5.text = Goth5; binding.gotram6.text = Goth6
        binding.gotram7.text = Goth7; binding.gotram8.text = Goth8; binding.gotram9.text = Goth9
        binding.gotram10.text = Goth10; binding.gotram11.text = Goth11; binding.gotram12.text = Goth12
        binding.gotram13.text = Goth13; binding.gotram14.text = Goth14; binding.gotram15.text = Goth15
        binding.relationship1.text = RlShp1; binding.relationship2.text = RlShp2; binding.relationship3.text = RlShp3
        binding.relationship4.text = RlShp4; binding.relationship5.text = RlShp5; binding.relationship6.text = RlShp6
        binding.relationship7.text = RlShp7; binding.relationship8.text = RlShp8; binding.relationship9.text = RlShp9
        binding.relationship10.text = RlShp10; binding.relationship11.text = RlShp11; binding.relationship12.text = RlShp12
        binding.relationship13.text = RlShp13; binding.relationship14.text = RlShp14; binding.relationship15.text = RlShp15
        updateRowVisibility()
    }

    fun updateRowVisibility() {
        binding.headRow.visibility = if (binding.Name1.text.isEmpty()) View.INVISIBLE else View.VISIBLE
        binding.firstRow.visibility = if (binding.Name1.text.isEmpty()) View.INVISIBLE else View.VISIBLE
        binding.secondRow.visibility = if (binding.Name2.text.isEmpty()) View.INVISIBLE else View.VISIBLE
        binding.thirdRow.visibility = if (binding.Name3.text.isEmpty()) View.INVISIBLE else View.VISIBLE
        binding.fourthRow.visibility = if (binding.Name4.text.isEmpty()) View.INVISIBLE else View.VISIBLE
        binding.fifthRow.visibility = if (binding.Name5.text.isEmpty()) View.INVISIBLE else View.VISIBLE
        binding.sixthRow.visibility = if (binding.Name6.text.isEmpty()) View.INVISIBLE else View.VISIBLE
        binding.seventhRow.visibility = if (binding.Name7.text.isEmpty()) View.INVISIBLE else View.VISIBLE
        binding.eighthRow.visibility = if (binding.Name8.text.isEmpty()) View.INVISIBLE else View.VISIBLE
        binding.ninethRow.visibility = if (binding.Name9.text.isEmpty()) View.INVISIBLE else View.VISIBLE
        binding.tenRow.visibility = if (binding.Name10.text.isEmpty()) View.INVISIBLE else View.VISIBLE
        binding.elevenRow.visibility = if (binding.Name11.text.isEmpty()) View.INVISIBLE else View.VISIBLE
        binding.twelveRow.visibility = if (binding.Name12.text.isEmpty()) View.INVISIBLE else View.VISIBLE
        binding.thirteenRow.visibility = if (binding.Name13.text.isEmpty()) View.INVISIBLE else View.VISIBLE
        binding.fourteenRow.visibility = if (binding.Name14.text.isEmpty()) View.INVISIBLE else View.VISIBLE
        binding.fifteenRow.visibility = if (binding.Name15.text.isEmpty()) View.INVISIBLE else View.VISIBLE
    }

    fun savedData() {
        val sharedPreferences = getSharedPreferences(SHAREDPREFS, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("N1", binding.Name1.text.toString())
        editor.putString("N2", binding.Name2.text.toString())
        editor.putString("N3", binding.Name3.text.toString())
        editor.putString("N4", binding.Name4.text.toString())
        editor.putString("N5", binding.Name5.text.toString())
        editor.putString("N6", binding.Name6.text.toString())
        editor.putString("N7", binding.Name7.text.toString())
        editor.putString("N8", binding.Name8.text.toString())
        editor.putString("N9", binding.Name9.text.toString())
        editor.putString("N10", binding.Name10.text.toString())
        editor.putString("N11", binding.Name11.text.toString())
        editor.putString("N12", binding.Name12.text.toString())
        editor.putString("N13", binding.Name13.text.toString())
        editor.putString("N14", binding.Name14.text.toString())
        editor.putString("N15", binding.Name15.text.toString())
        editor.putString("B1", binding.BirthOrder1.text.toString())
        editor.putString("B2", binding.BirthOrder2.text.toString())
        editor.putString("B3", binding.BirthOrder3.text.toString())
        editor.putString("B4", binding.BirthOrder4.text.toString())
        editor.putString("B5", binding.BirthOrder5.text.toString())
        editor.putString("B6", binding.BirthOrder6.text.toString())
        editor.putString("B7", binding.BirthOrder7.text.toString())
        editor.putString("B8", binding.BirthOrder8.text.toString())
        editor.putString("B9", binding.BirthOrder9.text.toString())
        editor.putString("B10", binding.BirthOrder10.text.toString())
        editor.putString("B11", binding.BirthOrder11.text.toString())
        editor.putString("B12", binding.BirthOrder12.text.toString())
        editor.putString("B13", binding.BirthOrder13.text.toString())
        editor.putString("B14", binding.BirthOrder14.text.toString())
        editor.putString("B15", binding.BirthOrder15.text.toString())
        editor.putString("G1", binding.gotram1.text.toString())
        editor.putString("G2", binding.gotram2.text.toString())
        editor.putString("G3", binding.gotram3.text.toString())
        editor.putString("G4", binding.gotram4.text.toString())
        editor.putString("G5", binding.gotram5.text.toString())
        editor.putString("G6", binding.gotram6.text.toString())
        editor.putString("G7", binding.gotram7.text.toString())
        editor.putString("G8", binding.gotram8.text.toString())
        editor.putString("G9", binding.gotram9.text.toString())
        editor.putString("G10", binding.gotram10.text.toString())
        editor.putString("G11", binding.gotram11.text.toString())
        editor.putString("G12", binding.gotram12.text.toString())
        editor.putString("G13", binding.gotram13.text.toString())
        editor.putString("G14", binding.gotram14.text.toString())
        editor.putString("G15", binding.gotram15.text.toString())
        editor.putString("R1", binding.relationship1.text.toString())
        editor.putString("R2", binding.relationship2.text.toString())
        editor.putString("R3", binding.relationship3.text.toString())
        editor.putString("R4", binding.relationship4.text.toString())
        editor.putString("R5", binding.relationship5.text.toString())
        editor.putString("R6", binding.relationship6.text.toString())
        editor.putString("R7", binding.relationship7.text.toString())
        editor.putString("R8", binding.relationship8.text.toString())
        editor.putString("R9", binding.relationship9.text.toString())
        editor.putString("R10", binding.relationship10.text.toString())
        editor.putString("R11", binding.relationship11.text.toString())
        editor.putString("R12", binding.relationship12.text.toString())
        editor.putString("R13", binding.relationship13.text.toString())
        editor.putString("R14", binding.relationship14.text.toString())
        editor.putString("R15", binding.relationship15.text.toString())
        editor.putString("gdr1", Gndr1); editor.putString("gdr2", Gndr2)
        editor.putString("gdr3", Gndr3); editor.putString("gdr4", Gndr4)
        editor.putString("gdr5", Gndr5); editor.putString("gdr6", Gndr6)
        editor.putString("gdr7", Gndr7); editor.putString("gdr8", Gndr8)
        editor.putString("gdr9", Gndr9); editor.putString("gdr10", Gndr10)
        editor.putString("gdr11", Gndr11); editor.putString("gdr12", Gndr12)
        editor.putString("gdr13", Gndr13); editor.putString("gdr14", Gndr14)
        editor.putString("gdr15", Gndr15)
        editor.apply()
    }

    fun setupRowClickListeners() {
        val rows = listOf(
            Pair(1, binding.firstRow), Pair(2, binding.secondRow), Pair(3, binding.thirdRow),
            Pair(4, binding.fourthRow), Pair(5, binding.fifthRow), Pair(6, binding.sixthRow),
            Pair(7, binding.seventhRow), Pair(8, binding.eighthRow), Pair(9, binding.ninethRow),
            Pair(10, binding.tenRow), Pair(11, binding.elevenRow), Pair(12, binding.twelveRow),
            Pair(13, binding.thirteenRow), Pair(14, binding.fourteenRow), Pair(15, binding.fifteenRow)
        )
        for ((rowNum, rowView) in rows) {
            rowView.setOnClickListener {
                if (selectedRowForSwap == -1) {
                    selectedRowForSwap = rowNum
                    rowView.setBackgroundColor(android.graphics.Color.parseColor("#FFEB3B"))
                    Toast.makeText(this, "Row $rowNum selected. Tap another row to swap.", Toast.LENGTH_SHORT).show()
                } else if (selectedRowForSwap != rowNum) {
                    swapRows(selectedRowForSwap, rowNum)
                    resetRowBackgrounds()
                    selectedRowForSwap = -1
                    Toast.makeText(this, "Rows swapped!", Toast.LENGTH_SHORT).show()
                } else {
                    resetRowBackgrounds()
                    selectedRowForSwap = -1
                    Toast.makeText(this, "Selection cancelled.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun resetRowBackgrounds() {
        val defaultColor = android.graphics.Color.TRANSPARENT
        binding.firstRow.setBackgroundColor(defaultColor)
        binding.secondRow.setBackgroundColor(defaultColor)
        binding.thirdRow.setBackgroundColor(defaultColor)
        binding.fourthRow.setBackgroundColor(defaultColor)
        binding.fifthRow.setBackgroundColor(defaultColor)
        binding.sixthRow.setBackgroundColor(defaultColor)
        binding.seventhRow.setBackgroundColor(defaultColor)
        binding.eighthRow.setBackgroundColor(defaultColor)
        binding.ninethRow.setBackgroundColor(defaultColor)
        binding.tenRow.setBackgroundColor(defaultColor)
        binding.elevenRow.setBackgroundColor(defaultColor)
        binding.twelveRow.setBackgroundColor(defaultColor)
        binding.thirteenRow.setBackgroundColor(defaultColor)
        binding.fourteenRow.setBackgroundColor(defaultColor)
        binding.fifteenRow.setBackgroundColor(defaultColor)
    }

    fun swapRows(fromRow: Int, toRow: Int) {
        if (fromRow == toRow || fromRow < 1 || toRow < 1 || fromRow > 15 || toRow > 15) return
        val tempName = getRowName(fromRow)
        val tempBirthOrder = getRowBirthOrder(fromRow)
        val tempGothram = getRowGothram(fromRow)
        val tempRelation = getRowRelation(fromRow)
        val tempGender = getRowGender(fromRow)
        setRowData(fromRow, getRowName(toRow), getRowBirthOrder(toRow), getRowGothram(toRow), getRowRelation(toRow), getRowGender(toRow))
        setRowData(toRow, tempName, tempBirthOrder, tempGothram, tempRelation, tempGender)
        savedData()
        updateRowVisibility()
    }

    fun getRowName(row: Int): String {
        return when(row) {
            1 -> binding.Name1.text.toString();
            2 -> binding.Name2.text.toString()
            3 -> binding.Name3.text.toString();
            4 -> binding.Name4.text.toString()
            5 -> binding.Name5.text.toString();
            6 -> binding.Name6.text.toString()
            7 -> binding.Name7.text.toString();
            8 -> binding.Name8.text.toString()
            9 -> binding.Name9.text.toString();
            10 -> binding.Name10.text.toString()
            11 -> binding.Name11.text.toString();
            12 -> binding.Name12.text.toString()
            13 -> binding.Name13.text.toString();
            14 -> binding.Name14.text.toString()
            15 -> binding.Name15.text.toString();
            else -> ""
        }
    }

    fun getRowBirthOrder(row: Int): String {
        return when(row) {
            1 -> binding.BirthOrder1.text.toString();
            2 -> binding.BirthOrder2.text.toString()
            3 -> binding.BirthOrder3.text.toString();
            4 -> binding.BirthOrder4.text.toString()
            5 -> binding.BirthOrder5.text.toString();
            6 -> binding.BirthOrder6.text.toString()
            7 -> binding.BirthOrder7.text.toString();
            8 -> binding.BirthOrder8.text.toString()
            9 -> binding.BirthOrder9.text.toString();
            10 -> binding.BirthOrder10.text.toString()
            11 -> binding.BirthOrder11.text.toString();
            12 -> binding.BirthOrder12.text.toString()
            13 -> binding.BirthOrder13.text.toString();
            14 -> binding.BirthOrder14.text.toString()
            15 -> binding.BirthOrder15.text.toString();
            else -> ""
        }
    }

    fun getRowGothram(row: Int): String {
        return when(row) {
            1 -> binding.gotram1.text.toString(); 2 -> binding.gotram2.text.toString()
            3 -> binding.gotram3.text.toString(); 4 -> binding.gotram4.text.toString()
            5 -> binding.gotram5.text.toString(); 6 -> binding.gotram6.text.toString()
            7 -> binding.gotram7.text.toString(); 8 -> binding.gotram8.text.toString()
            9 -> binding.gotram9.text.toString(); 10 -> binding.gotram10.text.toString()
            11 -> binding.gotram11.text.toString(); 12 -> binding.gotram12.text.toString()
            13 -> binding.gotram13.text.toString(); 14 -> binding.gotram14.text.toString()
            15 -> binding.gotram15.text.toString(); else -> ""
        }
    }

    fun getRowRelation(row: Int): String {
        return when(row) {
            1 -> binding.relationship1.text.toString(); 2 -> binding.relationship2.text.toString()
            3 -> binding.relationship3.text.toString(); 4 -> binding.relationship4.text.toString()
            5 -> binding.relationship5.text.toString(); 6 -> binding.relationship6.text.toString()
            7 -> binding.relationship7.text.toString(); 8 -> binding.relationship8.text.toString()
            9 -> binding.relationship9.text.toString(); 10 -> binding.relationship10.text.toString()
            11 -> binding.relationship11.text.toString(); 12 -> binding.relationship12.text.toString()
            13 -> binding.relationship13.text.toString(); 14 -> binding.relationship14.text.toString()
            15 -> binding.relationship15.text.toString(); else -> ""
        }
    }

    fun getRowGender(row: Int): String {
        return when(row) {
            1 -> Gndr1; 2 -> Gndr2; 3 -> Gndr3; 4 -> Gndr4; 5 -> Gndr5
            6 -> Gndr6; 7 -> Gndr7; 8 -> Gndr8; 9 -> Gndr9; 10 -> Gndr10
            11 -> Gndr11; 12 -> Gndr12; 13 -> Gndr13; 14 -> Gndr14; 15 -> Gndr15
            else -> ""
        }
    }

    fun setRowData(row: Int, name: String, birthOrder: String, gothram: String, relation: String, gender: String) {
        when(row) {
            1 -> { binding.Name1.text = name; binding.BirthOrder1.text = birthOrder; binding.gotram1.text = gothram; binding.relationship1.text = relation; Gndr1 = gender }
            2 -> { binding.Name2.text = name; binding.BirthOrder2.text = birthOrder; binding.gotram2.text = gothram; binding.relationship2.text = relation; Gndr2 = gender }
            3 -> { binding.Name3.text = name; binding.BirthOrder3.text = birthOrder; binding.gotram3.text = gothram; binding.relationship3.text = relation; Gndr3 = gender }
            4 -> { binding.Name4.text = name; binding.BirthOrder4.text = birthOrder; binding.gotram4.text = gothram; binding.relationship4.text = relation; Gndr4 = gender }
            5 -> { binding.Name5.text = name; binding.BirthOrder5.text = birthOrder; binding.gotram5.text = gothram; binding.relationship5.text = relation; Gndr5 = gender }
            6 -> { binding.Name6.text = name; binding.BirthOrder6.text = birthOrder; binding.gotram6.text = gothram; binding.relationship6.text = relation; Gndr6 = gender }
            7 -> { binding.Name7.text = name; binding.BirthOrder7.text = birthOrder; binding.gotram7.text = gothram; binding.relationship7.text = relation; Gndr7 = gender }
            8 -> { binding.Name8.text = name; binding.BirthOrder8.text = birthOrder; binding.gotram8.text = gothram; binding.relationship8.text = relation; Gndr8 = gender }
            9 -> { binding.Name9.text = name; binding.BirthOrder9.text = birthOrder; binding.gotram9.text = gothram; binding.relationship9.text = relation; Gndr9 = gender }
            10 -> { binding.Name10.text = name; binding.BirthOrder10.text = birthOrder; binding.gotram10.text = gothram; binding.relationship10.text = relation; Gndr10 = gender }
            11 -> { binding.Name11.text = name; binding.BirthOrder11.text = birthOrder; binding.gotram11.text = gothram; binding.relationship11.text = relation; Gndr11 = gender }
            12 -> { binding.Name12.text = name; binding.BirthOrder12.text = birthOrder; binding.gotram12.text = gothram; binding.relationship12.text = relation; Gndr12 = gender }
            13 -> { binding.Name13.text = name; binding.BirthOrder13.text = birthOrder; binding.gotram13.text = gothram; binding.relationship13.text = relation; Gndr13 = gender }
            14 -> { binding.Name14.text = name; binding.BirthOrder14.text = birthOrder; binding.gotram14.text = gothram; binding.relationship14.text = relation; Gndr14 = gender }
            15 -> { binding.Name15.text = name; binding.BirthOrder15.text = birthOrder; binding.gotram15.text = gothram; binding.relationship15.text = relation; Gndr15 = gender }
        }
    }

    fun setDefaults(key: String, value: String, context: Context) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = preferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    fun getDefaults(key: String, context: Context): Editable? {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        return preferences.getString(key, null) as Editable?
    }

} // END OF CLASS


