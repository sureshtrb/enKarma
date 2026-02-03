package com.karma.sureshtrb.enKarma

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.text.Editable
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import com.karma.sureshtrb.enKarma.databinding.ActivityAnsestorDataBinding

class AnsestorDataActivity : AppCompatActivity() {

    private var myPreferences = "myPrefs"
    private var mySpinner2: Spinner? = null
    private var mmySpinner2: Spinner? = null
    private var eMPTY = ""
    private var nAME = "name"
    private var gOTHRAM = "gothram"
    private var nGOTHRAM = "Mgothram"
    private var pRAVARAS = "pravaras"
    private var mPRAVARAS = "Mpravaras"

    val sharedPrefs: String = ""
    val SHARED_PREFS: String = ""
    private lateinit var binding: ActivityAnsestorDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)  // Add this line
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
        val Varusham: String = intent.getStringExtra("TamilYear").toString()
        val ayyanamm: String = intent.getStringExtra("Ayanamm").toString()
        val kalam: String = intent.getStringExtra("KAALAM").toString()
        val rasee: String = intent.getStringExtra("RASEEE").toString()
        val baksham: String = intent.getStringExtra("BAKKSHAMM").toString()
        val todThithi: String = intent.getStringExtra("TODAYSTHITHI").toString()
        val kizhamai: String = intent.getStringExtra("KIZHAMAAII").toString()
        val nachathirm: String = intent.getStringExtra("NAKSM").toString()
        val yog: String = intent.getStringExtra("YGM").toString()
        val kar: String = intent.getStringExtra("KRNM").toString()
        binding.aMAVASYA
        binding.mAHALAYA

        binding.radioGroup5
        binding.radio1G5
        binding.radio2G5
        binding.radioGroup6
        binding.radio1G6
        binding.radio2G6

        println("ANCESTORdateTdy : $dateTdy")
        println("ANCESTORplace : $place")
        println("ANCESTOR-Varusham : $Varusham")
        println("ANCESTOR-ayyanamm : $ayyanamm")
        println("ANCESTOR-kalam : $kalam")
        println("ANCESTOR-rasee : $rasee")
        println("ANCESTOR-baksham : $baksham")
        println("ANCESTOR-todThithi : $todThithi")
        println("ANCESTOR-kizhamai : $kizhamai")
        println("ANCESTOR-nachathirm : $nachathirm")
        println("ANCESTOR-yog: $yog")
        println("ANCESTOR-kar : $kar")
        println("ANCESTOR-FLiveStatus : $fatherLive")
        println("ANCESTOR-MLiveStatus : $motherLive")
        println("ANCESTOR-MMLiveSTatus: $motherMotherLive")
        println("ANCESTOR-FMLiveSTatus : $fatherMotherLive")

        binding.yourName.text
        binding.yourName.hideKeyboard()
        binding.yrFatherName
        binding.yrGfatherName
        binding.yrGGfatherName
        binding.yrGGGfatherName
        binding.mFatherName
        binding.mGFatherName
        binding.mGGFatherName

        if (binding.radio1G5.isChecked) {
            binding.yrGfatherName.visibility = View.INVISIBLE
            binding.yrGGfatherName.visibility = View.VISIBLE
            binding.yrGGGfatherName.visibility = View.VISIBLE
            binding.yrGfatherName.text = null
        }else if (binding.radio2G5.isChecked) {
            binding.yrGfatherName.visibility = View.VISIBLE
            binding.yrGGfatherName.visibility = View.VISIBLE
            binding.yrGGGfatherName.visibility = View.INVISIBLE
            binding.yrGGGfatherName.text = null
        }else{
            binding.yrGfatherName.visibility = View.INVISIBLE
            binding.yrGGfatherName.visibility = View.INVISIBLE
            binding.yrGGGfatherName.visibility = View.INVISIBLE
        }
        if (binding.radio1G6.isChecked) {
            binding.mFatherName.visibility = View.INVISIBLE
            binding.mGFatherName.visibility = View.INVISIBLE
            binding.mGGFatherName.visibility = View.INVISIBLE
            binding.mspinnerGothram.visibility = View.INVISIBLE
            binding.mspinnerPravaras.visibility = View.INVISIBLE
            binding.aMAVASYA.visibility = View.VISIBLE
            binding.mAHALAYA.visibility = View.VISIBLE
        }else if (binding.radio2G6.isChecked) {
            binding.mFatherName.visibility = View.VISIBLE
            binding.mGFatherName.visibility = View.VISIBLE
            binding.mGGFatherName.visibility = View.VISIBLE
            binding.mspinnerGothram.visibility = View.VISIBLE
            binding.mspinnerPravaras.visibility = View.VISIBLE
            binding.aMAVASYA.visibility = View.VISIBLE
            binding.mAHALAYA.visibility = View.VISIBLE
        }else{
            binding.mFatherName.visibility = View.INVISIBLE
            binding.mGFatherName.visibility = View.INVISIBLE
            binding.mGGFatherName.visibility = View.INVISIBLE
            binding.mspinnerGothram.visibility = View.INVISIBLE
            binding.mspinnerPravaras.visibility = View.INVISIBLE
            binding.aMAVASYA.visibility = View.INVISIBLE
            binding.mAHALAYA.visibility = View.INVISIBLE
        }

        loadData()
        updateViews()

        binding.aMAVASYA.setOnClickListener {
            val intent = Intent(this, AmavasyaTharpanam::class.java)
            intent.putExtra("Naal", dateTdy)
            intent.putExtra("Idam", place)
            intent.putExtra("TamilYear", Varusham)
            intent.putExtra("Ayanamm", ayyanamm)
            intent.putExtra("KAALAM", kalam)
            intent.putExtra("RASEEE", rasee)
            intent.putExtra("BAKKSHAMM", baksham)
            intent.putExtra("TODAYSTHITHI", todThithi)
            intent.putExtra("KIZHAMAAII", kizhamai)
            intent.putExtra("NAKSM", nachathirm)
            intent.putExtra("YGM", yog)
            intent.putExtra("KRNM", kar)
            intent.putExtra("Peyar", binding.yourName.text.toString())
            intent.putExtra("Appa", binding.yrFatherName.text.toString())
            intent.putExtra("Thatha", binding.yrGfatherName.text.toString())
            intent.putExtra("Kollu", binding.yrGGfatherName.text.toString())
            intent.putExtra("Yellu", binding.yrGGGfatherName.text.toString())
            intent.putExtra("AmmaAppa", binding.mFatherName.text.toString())
            intent.putExtra("AmmaThatha", binding.mGFatherName.text.toString())
            intent.putExtra("AmmaKolluThatha", binding.mGGFatherName.text.toString())
            SaveRadioState()
            startActivity(intent)
            saveData()

        }
        binding.mAHALAYA.setOnClickListener {
            val intent: Intent = Intent(this, FurtherDetailsActivity::class.java)
            intent.putExtra("Naal", dateTdy)
            intent.putExtra("Idam", place)
            intent.putExtra("TamilYear", Varusham)
            intent.putExtra("Ayanamm", ayyanamm)
            intent.putExtra("KAALAM", kalam)
            intent.putExtra("RASEEE", rasee)
            intent.putExtra("BAKKSHAMM", baksham)
            intent.putExtra("TODAYSTHITHI", todThithi)
            intent.putExtra("KIZHAMAAII", kizhamai)
            intent.putExtra("NAKSM", nachathirm)
            intent.putExtra("YGM", yog)
            intent.putExtra("KRNM", kar)
            intent.putExtra("Peyar", binding.yourName.text.toString())
            intent.putExtra("Appa", binding.yrFatherName.text.toString())
            intent.putExtra("Thatha", binding.yrGfatherName.text.toString())
            intent.putExtra("Kollu", binding.yrGGfatherName.text.toString())
            intent.putExtra("Yellu", binding.yrGGGfatherName.text.toString())
            intent.putExtra("AmmaAppa", binding.mFatherName.text.toString())
            intent.putExtra("AmmaThatha", binding.mGFatherName.text.toString())
            intent.putExtra("AmmaKolluThatha", binding.mGGFatherName.text.toString())
            intent.putExtra("AppaAppaLive", yrGFatherLive)

            SaveRadioState()
            startActivity(intent)
            saveData()

        }
        val gothram_array = arrayOf<String>(
            "Select - Your Gothram", "பாரத்வாஜ", "ஷடமாஷண",
            "ஆத்ரேய", "வாதூல", "ஸ்ரீவத்ஸ", "கௌஶிக", "விஶ்வாமித்ர", "கௌண்டிந்ய", "ஹாரித",
            "மௌத்கல்ய", "சாண்டில்ய", "நைத்ருவகாஶ்யப", "குத்ஸ", "கண்வ", "பராசர", "அகஸ்த்ய",
            "கௌதம", "கர்கி", "பாதராயண", "காஶ்யப", "ஸங்க்ருத்ய"
        )
        val pravaras_array1 =
            arrayOf<String>(
                "Select Your Pravaras",
                "ஆங்கிரஸ பார்ஹஸ்பத்ய பாரத்வாஜேதி த்ரயார்ஷேய",
                "உப்ரெதி"
            )
        val pravaras_array2 = arrayListOf("Select Your Pravaras", "ஆங்கிரஸ பௌருகுத்ஸ த்ராஸ்தஸ்ய")
        val pravaras_array3 = arrayListOf("Select Your Pravaras", "ஆத்ரேய ஆர்ச்சநானஸ ஶ்யாவாஶ்வ")
        val pravaras_array4 = arrayListOf("Select Your Pravaras", "பார்க்கவ வைதஹவ்ய ஸாவேதஸ")
        val pravaras_array5 = arrayListOf(
            "Select Your Pravaras",
            "பார்கவ ச்யாவன ஆப்நவாந ஔர்வ பஞ்சார்ஷேய:",
            "ஜாமதக்ந்ய"
        )
        val pravaras_array6 =
            arrayListOf("Select Your Pravaras", "வைஶ்வாமித்ர ஆகமர்ஷண கௌசிகேதி த்ரயார்ஷேய:")
        val pravaras_array7 = arrayListOf("Select Your Pravaras", "வைஶ்வாமித்ர தேவராத ஔதல")
        val pravaras_array8 = arrayListOf("Select Your Pravaras", "வாஸிஷ்ட மைத்ராவருண கௌண்டிந்ய")
        val pravaras_array9 = arrayListOf("Select Your Pravaras", "ஆங்கிரஸ ஆம்பரீஷ யுவநாச்வ")
        val pravaras_array10 = arrayListOf(
            "Select Your Pravaras", "ஆங்கிரஸ பௌர்ம்யஶ்வ மௌத்கல்யேதி த்ரயார்ஷேய:",
            "தார்க்ஷ்ப பௌர்ம்யஶ்வ மௌத்கல்யேதி த்ரயார்ஷேய:", "ஆங்கிரஸ தாவ்ய மௌத்கல்யேதி த்ரயார்ஷேய:"
        )
        val pravaras_array11 =
            arrayListOf("Select Your Pravaras", "காஶ்யாப ஆவத்ஸார சாண்டில்ய", "காஶ்யாப ஆவத்ஸார தைவல")
        val pravaras_array12 = arrayListOf("Select Your Pravaras", "காஶ்யாப ஆவத்ஸார நைத்ருவ")
        val pravaras_array13 = arrayListOf("Select Your Pravaras", "ஆங்கிரஸ மாந்தாத்ர கௌதஸ")
        val pravaras_array14 =
            arrayListOf("Select Your Pravaras", "ஆங்கீரஸ அஜமீட காண்வ", "ஆங்கீரஸ கௌர காண்வ")
        val pravaras_array15 = arrayListOf("Select Your Pravaras", "வாஶிஷ்ட சாக்த்ய பாராசர்ய")
        val pravaras_array16 = arrayListOf("Select Your Pravaras", "அகஸ்த்ய தார்ட்யச்யுத ஸௌமவாஹ")
        val pravaras_array17 =
            arrayListOf("Select Your Pravaras", "ஆங்கீரஸ ஔஜித்ய கௌதமேத் த்ரயார்ஷேய:")
        val pravaras_array18 = arrayListOf(
            "Select Your Pravaras", "ஆங்கீரஸ பார்ஹஸ்பத்ய பாரத்வாஜ ஶைந்ய கார்க்ய",
            "ஆங்கீரஸ ஶைந்ய கார்க்ய"
        )
        val pravaras_array19 = arrayListOf("Select Your Pravaras", "ஆங்கீரஸ பார்ஷதச்வ ராதீதர")
        val pravaras_array20 = arrayListOf("Select Your Pravaras", "ஆங்கீரஸ ஆவத்ஸார தைவல")
        val pravaras_array21 =
            arrayListOf(
                "Select Your Pravaras",
                "ஆங்கீரஸ கௌரவீத ஸங்க்ருத்ய",
                "சாத்ய கௌரவீத ஸங்க்ருத்ய"
            )

        val adapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_1, pravaras_array1)
        val adapter2 = ArrayAdapter(this, android.R.layout.simple_list_item_1, pravaras_array2)
        val adapter3 = ArrayAdapter(this, android.R.layout.simple_list_item_1, pravaras_array3)
        val adapter4 = ArrayAdapter(this, android.R.layout.simple_list_item_1, pravaras_array4)
        val adapter5 = ArrayAdapter(this, android.R.layout.simple_list_item_1, pravaras_array5)
        val adapter6 = ArrayAdapter(this, android.R.layout.simple_list_item_1, pravaras_array6)
        val adapter7 = ArrayAdapter(this, android.R.layout.simple_list_item_1, pravaras_array7)
        val adapter8 = ArrayAdapter(this, android.R.layout.simple_list_item_1, pravaras_array8)
        val adapter9 = ArrayAdapter(this, android.R.layout.simple_list_item_1, pravaras_array9)
        val adapter10 = ArrayAdapter(this, android.R.layout.simple_list_item_1, pravaras_array10)
        val adapter11 = ArrayAdapter(this, android.R.layout.simple_list_item_1, pravaras_array11)
        val adapter12 = ArrayAdapter(this, android.R.layout.simple_list_item_1, pravaras_array12)
        val adapter13 = ArrayAdapter(this, android.R.layout.simple_list_item_1, pravaras_array13)
        val adapter14 = ArrayAdapter(this, android.R.layout.simple_list_item_1, pravaras_array14)
        val adapter15 = ArrayAdapter(this, android.R.layout.simple_list_item_1, pravaras_array15)
        val adapter16 = ArrayAdapter(this, android.R.layout.simple_list_item_1, pravaras_array16)
        val adapter17 = ArrayAdapter(this, android.R.layout.simple_list_item_1, pravaras_array17)
        val adapter18 = ArrayAdapter(this, android.R.layout.simple_list_item_1, pravaras_array18)
        val adapter19 = ArrayAdapter(this, android.R.layout.simple_list_item_1, pravaras_array19)
        val adapter20 = ArrayAdapter(this, android.R.layout.simple_list_item_1, pravaras_array20)
        val adapter21 = ArrayAdapter(this, android.R.layout.simple_list_item_1, pravaras_array21)


        val mySpinner1 = findViewById<Spinner>(R.id.spinnerGothram)
        val mySpinner2 = findViewById<Spinner>(R.id.spinnerPravaras)

        val adapter0 = ArrayAdapter(this, android.R.layout.simple_list_item_1, gothram_array)
        mySpinner1.adapter = adapter0

        mySpinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                urGothram = gothram_array[position]
                println("urGothram = $urGothram")
                parent?.getItemAtPosition(position)
                if (gothram_array[position] == "பாரத்வாஜ") {
                    mySpinner2.adapter = adapter1
                    mySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                                urPravaras = pravaras_array1[position]
                                println("urPravaras = $urPravaras")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                              //  //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }

                if (gothram_array[position] == "ஷடமாஷண") {
                    mySpinner2.adapter = adapter2
                    mySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                urPravaras = pravaras_array2[position]
                                println("urPravaras = $urPravaras")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }
                if (gothram_array[position] == "ஆத்ரேய") {
                    mySpinner2.adapter = adapter3
                    mySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                urPravaras = pravaras_array3[position]
                                println("urPravaras = $urPravaras")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }
                if (gothram_array[position] == "வாதூல") {
                    mySpinner2.adapter = adapter4
                    mySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                urPravaras = pravaras_array4[position]
                                println("urPravaras = $urPravaras")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }
                if (gothram_array[position] == "ஸ்ரீவத்ஸ") {
                    mySpinner2.adapter = adapter5
                    mySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                urPravaras = pravaras_array5[position]
                                println("urPravaras = $urPravaras")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }
                if (gothram_array[position] == "கௌஶிக") {
                    mySpinner2.adapter = adapter6
                    mySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                urPravaras = pravaras_array6[position]
                                println("urPravaras = $urPravaras")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }
                if (gothram_array[position] == "விஶ்வாமித்ர") {
                    mySpinner2.adapter = adapter7
                    mySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                urPravaras = pravaras_array7[position]
                                println("urPravaras = $urPravaras")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }
                if (gothram_array[position] == "கௌண்டிந்ய") {
                    mySpinner2.adapter = adapter8
                    mySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                urPravaras = pravaras_array8[position]
                                println("urPravaras = $urPravaras")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }
                if (gothram_array[position] == "ஹாரித") {
                    mySpinner2.adapter = adapter9
                    mySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                urPravaras = pravaras_array9[position]
                                println("urPravaras = $urPravaras")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }
                if (gothram_array[position] == "மௌத்கல்ய") {
                    mySpinner2.adapter = adapter10
                    mySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                urPravaras = pravaras_array10[position]
                                println("urPravaras = $urPravaras")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }
                if (gothram_array[position] == "சாண்டில்ய") {
                    mySpinner2.adapter = adapter11
                    mySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                urPravaras = pravaras_array11[position]
                                println("urPravaras = $urPravaras")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }
                if (gothram_array[position] == "நைத்ருவகாஶ்யப") {
                    mySpinner2.adapter = adapter12
                    mySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                urPravaras = pravaras_array12[position]
                                println("urPravaras = $urPravaras")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }
                if (gothram_array[position] == "குத்ஸ") {
                    mySpinner2.adapter = adapter13
                    mySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                urPravaras = pravaras_array13[position]
                                println("urPravaras = $urPravaras")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }
                if (gothram_array[position] == "கண்வ") {
                    mySpinner2.adapter = adapter14
                    mySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                urPravaras = pravaras_array14[position]
                                println("urPravaras = $urPravaras")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }
                if (gothram_array[position] == "பராசர") {
                    mySpinner2.adapter = adapter15
                    mySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                urPravaras = pravaras_array15[position]
                                println("urPravaras = $urPravaras")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }
                if (gothram_array[position] == "அகஸ்த்ய") {
                    mySpinner2.adapter = adapter16
                    mySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                urPravaras = pravaras_array16[position]
                                println("urPravaras = $urPravaras")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }
                if (gothram_array[position] == "கௌதம") {
                    mySpinner2.adapter = adapter17
                    mySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                urPravaras = pravaras_array17[position]
                                println("urPravaras = $urPravaras")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }
                if (gothram_array[position] == "கர்கி") {
                    mySpinner2.adapter = adapter18
                    mySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                urPravaras = pravaras_array18[position]
                                println("urPravaras = $urPravaras")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }
                if (gothram_array[position] == "பாதராயண") {
                    mySpinner2.adapter = adapter19
                    mySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                urPravaras = pravaras_array19[position]
                                println("urPravaras = $urPravaras")
                                //   parent?.getItemAtPosition(position)
                            }


                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }
                if (gothram_array[position] == "காஶ்யப") {
                    mySpinner2.adapter = adapter20
                    mySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                urPravaras = pravaras_array20[position]
                                println("urPravaras = $urPravaras")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                    urPravaras = (mySpinner2.adapter).toString()
                }
                if (gothram_array[position] == "ஸங்க்ருத்ய") {
                    mySpinner2.adapter = adapter21
                    mySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                urPravaras = pravaras_array21[position]
                                println("urPravaras = $urPravaras")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }

        val Mgothram_array = arrayOf<String>(
            "Select - MotherSide Gothram", "பாரத்வாஜ", "ஷடமாஷண",
            "ஆத்ரேய", "வாதூல", "ஸ்ரீவத்ஸ", "கௌஶிக", "விஶ்வாமித்ர", "கௌண்டிந்ய", "ஹாரித",
            "மௌத்கல்ய", "சாண்டில்ய", "நைத்ருவகாஶ்யப", "குத்ஸ", "கண்வ", "பராசர", "அகஸ்த்ய",
            "கௌதம", "கர்கி", "பாதராயண", "காஶ்யப", "ஸங்க்ருத்ய"
        )

        val Mpravaras_array1 =
            arrayOf<String>(
                "Select MotherSide  Pravaras",
                "ஆங்கிரஸ பார்ஹஸ்பத்ய பாரத்வாஜேதி த்ரயார்ஷேய",
                "உப்ரெதி"
            )
        val Mpravaras_array2 =
            arrayListOf("Select MotherSide  Pravaras", "ஆங்கிரஸ பௌருகுத்ஸ த்ராஸ்தஸ்ய")
        val Mpravaras_array3 =
            arrayListOf("Select MotherSide  Pravaras", "ஆத்ரேய ஆர்ச்சநானஸ ஶ்யாவாஶ்வ")
        val Mpravaras_array4 = arrayListOf("Select MotherSide  Pravaras", "பார்க்கவ வைதஹவ்ய ஸாவேதஸ")
        val Mpravaras_array5 =
            arrayListOf(
                "Select MotherSide  Pravaras",
                "பார்கவ ச்யாவன ஆப்நவாந ஔர்வ பஞ்சார்ஷேய:",
                "ஜாமதக்ந்ய"
            )
        val Mpravaras_array6 =
            arrayListOf("Select MotherSide  Pravaras", "வைஶ்வாமித்ர ஆகமர்ஷண கௌசிகேதி த்ரயார்ஷேய:")
        val Mpravaras_array7 = arrayListOf("Select MotherSide  Pravaras", "வைஶ்வாமித்ர தேவராத ஔதல")
        val Mpravaras_array8 =
            arrayListOf("Select MotherSide  Pravaras", "வாஸிஷ்ட மைத்ராவருண கௌண்டிந்ய")
        val Mpravaras_array9 =
            arrayListOf("Select MotherSide  Pravaras", "ஆங்கிரஸ ஆம்பரீஷ யுவநாச்வ")
        val Mpravaras_array10 = arrayListOf(
            "Select MotherSide  Pravaras", "ஆங்கிரஸ பௌர்ம்யஶ்வ மௌத்கல்யேதி த்ரயார்ஷேய:",
            "தார்க்ஷ்ப பௌர்ம்யஶ்வ மௌத்கல்யேதி த்ரயார்ஷேய:", "ஆங்கிரஸ தாவ்ய மௌத்கல்யேதி த்ரயார்ஷேய:"
        )
        val Mpravaras_array11 =
            arrayListOf(
                "Select MotherSide  Pravaras",
                "காஶ்யாப ஆவத்ஸார சாண்டில்ய",
                "காஶ்யாப ஆவத்ஸார தைவல"
            )
        val Mpravaras_array12 =
            arrayListOf("Select MotherSide  Pravaras", "காஶ்யாப ஆவத்ஸார நைத்ருவ")
        val Mpravaras_array13 = arrayListOf("Select MotherSide  Pravaras", "ஆங்கிரஸ மாந்தாத்ர கௌதஸ")
        val Mpravaras_array14 =
            arrayListOf("Select MotherSide  Pravaras", "ஆங்கீரஸ அஜமீட காண்வ", "ஆங்கீரஸ கௌர காண்வ")
        val Mpravaras_array15 =
            arrayListOf("Select MotherSide  Pravaras", "வாஶிஷ்ட சாக்த்ய பாராசர்ய")
        val Mpravaras_array16 =
            arrayListOf("Select MotherSide  Pravaras", "அகஸ்த்ய தார்ட்யச்யுத ஸௌமவாஹ")
        val Mpravaras_array17 =
            arrayListOf("Select MotherSide  Pravaras", "ஆங்கீரஸ ஔஜித்ய கௌதமேத் த்ரயார்ஷேய:")
        val Mpravaras_array18 = arrayListOf(
            "Select MotherSide  Pravaras", "ஆங்கீரஸ பார்ஹஸ்பத்ய பாரத்வாஜ ஶைந்ய கார்க்ய",
            "ஆங்கீரஸ ஶைந்ய கார்க்ய"
        )
        val Mpravaras_array19 =
            arrayListOf("Select MotherSide  Pravaras", "ஆங்கீரஸ பார்ஷதச்வ ராதீதர")
        val Mpravaras_array20 = arrayListOf("Select MotherSide  Pravaras", "ஆங்கீரஸ ஆவத்ஸார தைவல")
        val Mpravaras_array21 =
            arrayListOf(
                "Select MotherSide  Pravaras",
                "ஆங்கீரஸ கௌரவீத ஸங்க்ருத்ய",
                "சாத்ய கௌரவீத ஸங்க்ருத்ய"
            )

        val Madapter1 = ArrayAdapter(this, android.R.layout.simple_list_item_1, Mpravaras_array1)
        val Madapter2 = ArrayAdapter(this, android.R.layout.simple_list_item_1, Mpravaras_array2)
        val Madapter3 = ArrayAdapter(this, android.R.layout.simple_list_item_1, Mpravaras_array3)
        val Madapter4 = ArrayAdapter(this, android.R.layout.simple_list_item_1, Mpravaras_array4)
        val Madapter5 = ArrayAdapter(this, android.R.layout.simple_list_item_1, Mpravaras_array5)
        val Madapter6 = ArrayAdapter(this, android.R.layout.simple_list_item_1, Mpravaras_array6)
        val Madapter7 = ArrayAdapter(this, android.R.layout.simple_list_item_1, Mpravaras_array7)
        val Madapter8 = ArrayAdapter(this, android.R.layout.simple_list_item_1, Mpravaras_array8)
        val Madapter9 = ArrayAdapter(this, android.R.layout.simple_list_item_1, Mpravaras_array9)
        val Madapter10 = ArrayAdapter(this, android.R.layout.simple_list_item_1, Mpravaras_array10)
        val Madapter11 = ArrayAdapter(this, android.R.layout.simple_list_item_1, Mpravaras_array11)
        val Madapter12 = ArrayAdapter(this, android.R.layout.simple_list_item_1, Mpravaras_array12)
        val Madapter13 = ArrayAdapter(this, android.R.layout.simple_list_item_1, Mpravaras_array13)
        val Madapter14 = ArrayAdapter(this, android.R.layout.simple_list_item_1, Mpravaras_array14)
        val Madapter15 = ArrayAdapter(this, android.R.layout.simple_list_item_1, Mpravaras_array15)
        val Madapter16 = ArrayAdapter(this, android.R.layout.simple_list_item_1, Mpravaras_array16)
        val Madapter17 = ArrayAdapter(this, android.R.layout.simple_list_item_1, Mpravaras_array17)
        var Madapter18 = ArrayAdapter(this, android.R.layout.simple_list_item_1, Mpravaras_array18)
        val Madapter19 = ArrayAdapter(this, android.R.layout.simple_list_item_1, Mpravaras_array19)
        val Madapter20 = ArrayAdapter(this, android.R.layout.simple_list_item_1, Mpravaras_array20)
        val Madapter21 = ArrayAdapter(this, android.R.layout.simple_list_item_1, Mpravaras_array21)


        val MmySpinner1 = binding.mspinnerGothram
        val MmySpinner2 = binding.mspinnerPravaras

        val Madapter0 = ArrayAdapter(this, android.R.layout.simple_list_item_1, Mgothram_array)
        MmySpinner1.adapter = Madapter0

        MmySpinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                mGothram = Mgothram_array[position]

                println("mGothram = $mGothram")
                parent?.getItemAtPosition(position)

                if (Mgothram_array[position] == "பாரத்வாஜ") {
                    MmySpinner2.adapter = Madapter1
                    MmySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                mPravaras = Mpravaras_array1[position]
                                println("mPravaras = $mPravaras")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }

                if (Mgothram_array[position] == "ஷடமாஷண") {
                    MmySpinner2.adapter = Madapter2
                    MmySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                mPravaras = Mpravaras_array2[position]
                                println("mPravaras = $mPravaras")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }
                if (Mgothram_array[position] == "ஆத்ரேய") {
                    MmySpinner2.adapter = Madapter3
                    MmySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                mPravaras = Mpravaras_array3[position]
                                println("mPravaras = $mPravaras")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }
                if (Mgothram_array[position] == "வாதூல") {
                    MmySpinner2.adapter = Madapter4
                    MmySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                mPravaras = Mpravaras_array4[position]
                                println("mPravaras = $mPravaras")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }
                if (Mgothram_array[position] == "ஸ்ரீவத்ஸ") {
                    MmySpinner2.adapter = Madapter5
                    MmySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                mPravaras = Mpravaras_array5[position]
                                println("mPravaras = $mPravaras")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }
                if (Mgothram_array[position] == "கௌஶிக") {
                    MmySpinner2.adapter = Madapter6
                    MmySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                mPravaras = Mpravaras_array6[position]
                                println("mPravaras = $mPravaras")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }
                if (Mgothram_array[position] == "விஶ்வாமித்ர") {
                    MmySpinner2.adapter = Madapter7
                    MmySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                mPravaras = Mpravaras_array7[position]
                                println("mPravaras = $mPravaras")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }
                if (Mgothram_array[position] == "கௌண்டிந்ய") {
                    MmySpinner2.adapter = Madapter8
                    MmySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                mPravaras = Mpravaras_array8[position]
                                println("mPravaras = $mPravaras")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }
                if (Mgothram_array[position] == "ஹாரித") {
                    MmySpinner2.adapter = Madapter9
                    MmySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                mPravaras = Mpravaras_array9[position]
                                println("mPravaras = $mPravaras")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }
                if (Mgothram_array[position] == "மௌத்கல்ய") {
                    MmySpinner2.adapter = Madapter10
                    MmySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                mPravaras = Mpravaras_array10[position]
                                println("mPravaras = $mPravaras")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }
                if (Mgothram_array[position] == "சாண்டில்ய") {
                    MmySpinner2.adapter = Madapter11
                    MmySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                mPravaras = Mpravaras_array11[position]
                                println("mPravaras = $mPravaras")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }
                if (Mgothram_array[position] == "நைத்ருவகாஶ்யப") {
                    MmySpinner2.adapter = Madapter12
                    MmySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                mPravaras = Mpravaras_array12[position]
                                println("mPravaras = $mPravaras")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }
                if (Mgothram_array[position] == "குத்ஸ") {
                    MmySpinner2.adapter = Madapter13
                    MmySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                mPravaras = Mpravaras_array13[position]
                                println("mPravaras = $mPravaras")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }
                if (Mgothram_array[position] == "கண்வ") {
                    MmySpinner2.adapter = Madapter14
                    MmySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                mPravaras = Mpravaras_array14[position]
                                println("mPravaras = $mPravaras")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }
                if (Mgothram_array[position] == "பராசர") {
                    MmySpinner2.adapter = Madapter15
                    MmySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                mPravaras = Mpravaras_array15[position]
                                println("mPravaras = $mPravaras")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }
                if (Mgothram_array[position] == "அகஸ்த்ய") {
                    MmySpinner2.adapter = Madapter16
                    MmySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                mPravaras = Mpravaras_array16[position]
                                println("mPravaras = $mPravaras")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }
                if (Mgothram_array[position] == "கௌதம") {
                    MmySpinner2.adapter = Madapter17
                    MmySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                mPravaras = Mpravaras_array17[position]
                                println("mPravaras = $mPravaras")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }
                if (Mgothram_array[position] == "கர்கி") {
                    MmySpinner2.adapter = Madapter18
                    MmySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                mPravaras = Mpravaras_array18[position]
                                println("mPravaras = $mPravaras")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }
                if (Mgothram_array[position] == "பாதராயண") {
                    MmySpinner2.adapter = Madapter19
                    MmySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                mPravaras = Mpravaras_array19[position]
                                println("mPravaras = $mPravaras")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }
                if (Mgothram_array[position] == "காஶ்யப") {
                    MmySpinner2.adapter = Madapter20
                    MmySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                mPravaras = Mpravaras_array20[position]
                                println("mPravaras = $mPravaras")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }
                if (Mgothram_array[position] == "ஸங்க்ருத்ய") {
                    MmySpinner2.adapter = Madapter21
                    MmySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                mPravaras = Mpravaras_array21[position]
                                println("mPravaras = $mPravaras")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        binding.radioGroup5.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radio1G5 -> {
                    binding.radio1G5.setTextColor(Color.BLUE)
                    binding.radio1G5.setTypeface(null, Typeface.BOLD)
                    binding.radio2G5.setTextColor(Color.BLACK)
                    binding.radio2G5.setTypeface(null, Typeface.NORMAL)
                    yrGFatherLive = "Living"
                    binding.yrGfatherName.setText("")
                    println("yrGFatherLive =  $yrGFatherLive")
                    binding.yrGfatherName.visibility = View.INVISIBLE
                    binding.yrGGfatherName.visibility = View.VISIBLE
                    binding.yrGGGfatherName.visibility = View.VISIBLE
                }
                R.id.radio2G5 -> {
                    binding.radio1G5.setTextColor(Color.BLACK)
                    binding.radio1G5.setTypeface(null, Typeface.NORMAL)
                    binding.radio2G5.setTextColor(Color.RED)
                    binding.radio2G5.setTypeface(null, Typeface.BOLD)
                    yrGFatherLive = "Deceased"
                    binding.yrGGGfatherName.setText("")
                    println("yrGFatherLive =  $yrGFatherLive")
                    binding.yrGfatherName.visibility = View.VISIBLE
                    binding.yrGGfatherName.visibility = View.VISIBLE
                    binding.yrGGGfatherName.visibility = View.INVISIBLE
                }
            }
        }

        binding.radioGroup6.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radio1G6 -> {
                    binding.radio1G6.setTextColor(Color.BLUE)
                    binding.radio1G6.setTypeface(null, Typeface.BOLD)
                    binding.radio2G6.setTextColor(Color.BLACK)
                    binding.radio2G6.setTypeface(null, Typeface.NORMAL)
                    mFatherLive = "Living"
                    println("mFatherLive =  $mFatherLive")
                    binding.mFatherName.setText("")
                    binding.mGFatherName.setText("")
                    binding.mGGFatherName.setText("")
                    binding.mFatherName.visibility = View.INVISIBLE
                    binding.mGFatherName.visibility = View.INVISIBLE
                    binding.mGGFatherName.visibility = View.INVISIBLE
                    binding.mspinnerGothram.visibility = View.INVISIBLE
                    binding.mspinnerPravaras.visibility = View.INVISIBLE
                    binding.aMAVASYA.visibility = View.VISIBLE
                    binding.mAHALAYA.visibility = View.VISIBLE
                }
                R.id.radio2G6 -> {
                    binding.radio1G6.setTextColor(Color.BLACK)
                    binding.radio1G6.setTypeface(null, Typeface.NORMAL)
                    binding.radio2G6.setTextColor(Color.RED)
                    binding.radio2G6.setTypeface(null, Typeface.BOLD)
                    mFatherLive = "Deceased"
                    println("mFatherLive =  $mFatherLive")
                    binding.mFatherName.visibility = View.VISIBLE
                    binding.mGFatherName.visibility = View.VISIBLE
                    binding.mGGFatherName.visibility = View.VISIBLE
                    binding.mspinnerGothram.visibility = View.VISIBLE
                    binding.mspinnerPravaras.visibility = View.VISIBLE
                    binding.aMAVASYA.visibility = View.VISIBLE
                    binding.mAHALAYA.visibility = View.VISIBLE
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

    fun getDefaults(key: String, context: Context): Editable? {
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

        editor.putString("Peyar", binding.yourName.text.toString())
        editor.putString("Appa", binding.yrFatherName.text.toString())
        editor.putString("Thatha", binding.yrGfatherName.text.toString())
        editor.putString("Kollu", binding.yrGGfatherName.text.toString())
        editor.putString("Yellu", binding.yrGGGfatherName.text.toString())
        editor.putString("AmmaAppa", binding.mFatherName.text.toString())
        editor.putString("AmmaThatha", binding.mGFatherName.text.toString())
        editor.putString("AmmaKolluThatha", binding.mGGFatherName.text.toString())

        editor.apply()
    }

    fun loadData() {
        val sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
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
        binding.mFatherName.setText(MFName)
        binding.mGFatherName.setText(MGFName)
        binding.mGGFatherName.setText(MGGFName)
    }

    private fun SaveRadioState() {
        val rb_yrGFLiving = findViewById<RadioButton>(R.id.radio1G5)
        val rb_yrGFDeceased = findViewById<RadioButton>(R.id.radio2G5)
        val rb_MFLiving = findViewById<RadioButton>(R.id.radio1G6)
        val rb_MFDeceased = findViewById<RadioButton>(R.id.radio2G6)

        val settings = getSharedPreferences("Answer", 0)
        val editor = settings.edit()
        editor.putBoolean("question5A", rb_yrGFLiving.isChecked)
        editor.putBoolean("question5B", rb_yrGFDeceased.isChecked)
        editor.putBoolean("question6A", rb_MFLiving.isChecked)
        editor.putBoolean("question6B", rb_MFDeceased.isChecked)

        editor.apply()
    }
    private fun loadRadioState() {
        binding.radio1G5
        binding.radio2G5
        binding.radio1G6
        binding.radio2G6
        binding.aMAVASYA
        binding.mAHALAYA

        val settings = getSharedPreferences("Answer",0)
        if (settings.getBoolean("question5A", binding.radio1G5.isChecked)){
            binding.radio1G5.isChecked = settings.getBoolean("question5A",false)
            yrGFatherLive = "Living"
            binding.yrGfatherName.setText("")
            binding.yrGfatherName.visibility = View.INVISIBLE
            binding.yrGGfatherName.visibility = View.VISIBLE
            binding.yrGGGfatherName.visibility = View.VISIBLE
        }
        if (settings.getBoolean("question5B", binding.radio2G5.isChecked)){
            binding.radio2G5.isChecked = settings.getBoolean("question5B", false)
            yrGFatherLive = "Deceased"
            binding.yrGGGfatherName.setText("")
            binding.yrGfatherName.visibility = View.VISIBLE
            binding.yrGGfatherName.visibility = View.VISIBLE
            binding.yrGGGfatherName.visibility = View.INVISIBLE
        }
        if (settings.getBoolean("question6A", binding.radio1G6.isChecked)){
            binding.radio1G6.isChecked = settings.getBoolean("question6A", false)
            mFatherLive = "Living"
            binding.mFatherName.setText("")
            binding.mGGFatherName.setText("")
            binding.mGGFatherName.setText("")
            binding.mFatherName.visibility = View.INVISIBLE
            binding.mGFatherName.visibility = View.INVISIBLE
            binding.mGGFatherName.visibility = View.INVISIBLE
            binding.mspinnerGothram.visibility = View.INVISIBLE
            binding.mspinnerPravaras.visibility = View.INVISIBLE
            binding.aMAVASYA.visibility = View.VISIBLE
            binding.mAHALAYA.visibility = View.VISIBLE
        }
        if (settings.getBoolean("question6B", binding.radio2G6.isChecked)){
            binding.radio2G6.isChecked = settings.getBoolean("question6B", false)
            mFatherLive = "Deceased"
            binding.mFatherName.visibility = View.VISIBLE
            binding.mGFatherName.visibility = View.VISIBLE
            binding.mGGFatherName.visibility = View.VISIBLE
            binding.mspinnerGothram.visibility = View.VISIBLE
            binding.mspinnerPravaras.visibility = View.VISIBLE
            binding.aMAVASYA.visibility = View.VISIBLE
            binding.mAHALAYA.visibility = View.VISIBLE
        }
    }
}
