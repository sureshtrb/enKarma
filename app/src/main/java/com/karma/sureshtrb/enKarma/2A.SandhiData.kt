package com.karma.sureshtrb.enKarma

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.karma.sureshtrb.enKarma.databinding.ActivitySandhiDataBinding
import org.jsoup.Jsoup
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

var urGothram: String = ""
var urPravaras: String = ""
var tyDate: String = "__/__/____"
var yesterday: String = ""
var sSandyaFinishHrInMinutes: Int = 0
var sSandyaStartHrInMinutes: Int = 0
var pSandyaFinishHrInMinutes: Int = 0
var pSandyaStartHrInMinutes: Int = 0
var clockTimeInMinutes: Int = 0

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class SandhiData : AppCompatActivity() {

    var yurName: String = ""
    var tyOfSdya: String = ""
    val sharedPrefs: String = "myPrefs"

    @SuppressLint("SimpleDateFormat", "ResourceType")
    private lateinit var binding: ActivitySandhiDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySandhiDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val prathaSandyaBtn = binding.prathaButton
        val mathyanigamBtn = binding.mathyanigaButton
        val sayamSandyaBtn = binding.sayamsandyaButton
        val sandyaTime = binding.sandyaTimeTextView
        val yourNameTxtVw = binding.yourName
        val typeOfSandyaTxtVw = binding.typeOfSandyaTextView
        val sandyaBtn = binding.sandyaButton
        val gayathriBtn = binding.gayathriButton
        val yourGothram = binding.spinnerGothram
        val yourPravaras = binding.spinnerPravaras

        typeOfSandyaTxtVw.setText("ஸ்ந்தியா")

        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.US)
        tyDate = sdf.format(Date())
        println(tyDate)

        val cal1 = Calendar.getInstance()
        val sdf1 = SimpleDateFormat("dd/MM/yyyy", Locale.US)
        cal1.time = sdf1.parse(tyDate)
        cal1.add(Calendar.DATE, -1)
        println("cal1 : $cal1")
        println("1 day less: " + cal1.time)
        yesterday = sdf.format(cal1.time)
        println("yesterday : $yesterday")

        parseWeb()
        yesterDayParseWeb()
        loadData()
        updateViews()

        sandyaBtn.setOnClickListener {
            val intent = Intent(this, SandyaVandanamActivity::class.java)
            intent.putExtra("name", yourNameTxtVw.text.toString())
            intent.putExtra("gothram", urGothram)
            intent.putExtra("pravaras", urPravaras)
            intent.putExtra("sandhi", typeOfSandyaTxtVw.text.toString())
            startActivity(intent)
            saveData()
        }

        gayathriBtn.setOnClickListener {
            val intent = Intent(this, GayathriJapamActivity::class.java)
            intent.putExtra("name", yourNameTxtVw.text.toString())
            intent.putExtra("gothram", urGothram)
            intent.putExtra("pravaras", urPravaras)
            intent.putExtra("sandhi", typeOfSandyaTxtVw.text.toString())
            startActivity(intent)
            saveData()
        }

        prathaSandyaBtn.setOnClickListener {
            typeOfSandyaTxtVw.setText("ப்ராத்தஸ்ந்தியா")
            sandyaTime.setText(getString(R.string.sandhya_time, prathaSanthya))
            prathaSandyaBtn.setTextColor(Color.BLUE)
            mathyanigamBtn.setTextColor(Color.GRAY)
            sayamSandyaBtn.setTextColor(Color.GRAY)
            prathaSandyaBtn.setBackgroundColor(Color.YELLOW)
            mathyanigamBtn.setBackgroundColor(Color.LTGRAY)
            sayamSandyaBtn.setBackgroundColor(Color.LTGRAY)
        }

        mathyanigamBtn.setOnClickListener {
            typeOfSandyaTxtVw.setText("மாத்யாநிஹம்")
            sandyaTime.setText(getString(R.string.sandhya_time, madyana))
            mathyanigamBtn.setTextColor(Color.BLUE)
            prathaSandyaBtn.setTextColor(Color.GRAY)
            sayamSandyaBtn.setTextColor(Color.GRAY)
            prathaSandyaBtn.setBackgroundColor(Color.LTGRAY)
            mathyanigamBtn.setBackgroundColor(Color.YELLOW)
            sayamSandyaBtn.setBackgroundColor(Color.LTGRAY)
        }

        sayamSandyaBtn.setOnClickListener {
            typeOfSandyaTxtVw.setText("ஸாயம்ஸந்தியா")
            sandyaTime.setText(getString(R.string.sandhya_time, sayamSandya))
            sayamSandyaBtn.setTextColor(Color.BLUE)
            prathaSandyaBtn.setTextColor(Color.GRAY)
            mathyanigamBtn.setTextColor(Color.GRAY)
            prathaSandyaBtn.setBackgroundColor(Color.LTGRAY)
            mathyanigamBtn.setBackgroundColor(Color.LTGRAY)
            sayamSandyaBtn.setBackgroundColor(Color.YELLOW)
        }

        Thread {
            val builder = StringBuilder()
            try {
                val doc = Jsoup.connect(
                    "https://www.drikpanchang.com/panchang/day-panchang.html?geoname-id=1264527&date=Today()"
                ).get()
                val title = doc.title()
                val links = doc.select("dpGroupCard dpFlexWrap")
                builder.append(title).append("\n")
                for (link in links) {
                    builder.append("\n")
                        .append("Link : ").append(link.attr("href"))
                        .append("\n")
                        .append("Text : ").append(link.text())
                }
            } catch (e: IOException) {
                builder.append("Error : ").append(e.message).append("\n")
            }
            runOnUiThread { println(builder.toString()) }
        }.start()

        val t = object : Thread() {
            override fun run() {
                try {
                    while (!isInterrupted) {
                        sleep(1000)
                        runOnUiThread {
                            val tdate = binding.timeNowTextView
                            val date = System.currentTimeMillis()
                            val sdfNow = SimpleDateFormat(
                                "EEEE, MMM dd, yyyy, HH:mm:ss",
                                Locale.US
                            )
                            val dateString = sdfNow.format(date)
                            tdate.setText(dateString)
                        }
                    }
                } catch (_: InterruptedException) {
                }
            }
        }
        t.start()

        supportActionBar!!.setHomeAsUpIndicator(androidx.appcompat.R.drawable.abc_ic_ab_back_material)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.subtitle = "Sandiya Details / ஸந்தியா விவரங்கள்"
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setLogo(R.drawable.karma)
        supportActionBar!!.setDisplayUseLogoEnabled(true)

        if (clockTimeInMinutes >= sSandyaStartHrInMinutes &&
            clockTimeInMinutes <= sSandyaFinishHrInMinutes
        ) {
            sayamSandyaBtn.performClick()
            val sandyaTypeText =
                "<font color=#000080>Sayahna Sandhya: </font> <font color=#800000>$sayamSandya</font>"
            findViewById<TextView>(R.id.sandya_time_textView).text =
                HtmlCompat.fromHtml(sandyaTypeText, HtmlCompat.FROM_HTML_MODE_LEGACY)
            sandyaTime.setText(getString(R.string.sandhya_time, sayamSandya))
        } else if (clockTimeInMinutes >= pSandyaStartHrInMinutes &&
            clockTimeInMinutes <= pSandyaFinishHrInMinutes
        ) {
            prathaSandyaBtn.performClick()
            val sandyaTypeText =
                "<font color=#000080>Pratah Sandhya: </font> <font color=#800000>$prathaSanthya</font>"
            findViewById<TextView>(R.id.sandya_time_textView).text =
                HtmlCompat.fromHtml(sandyaTypeText, HtmlCompat.FROM_HTML_MODE_LEGACY)
            sandyaTime.setText(getString(R.string.sandhya_time, prathaSanthya))
        } else if (clockTimeInMinutes >= pSandyaFinishHrInMinutes &&
            clockTimeInMinutes <= sSandyaStartHrInMinutes
        ) {
            mathyanigamBtn.performClick()
            val sandyaTypeText =
                "<font color=#000080>Madhyahna</font> <font color=#800000>$madyana</font>"
            findViewById<TextView>(R.id.sandya_time_textView).text =
                HtmlCompat.fromHtml(sandyaTypeText, HtmlCompat.FROM_HTML_MODE_LEGACY)
            sandyaTime.setText(getString(R.string.sandhya_time, madyana))
        }

        val gothramPravarasMap = mapOf(
            "பாரத்வாஜ" to listOf(
                "Select Your Pravaras",
                "ஆங்கிரஸ பார்ஹஸ்பத்ய பாரத்வாஜேதி த்ரயார்ஷேய",
                "உப்ரெதி"
            ),
            "ஷடமாஷண" to listOf("Select Your Pravaras", "ஆங்கிரஸ பௌருகுத்ஸ த்ராஸ்தஸ்ய"),
            "ஆத்ரேய" to listOf("Select Your Pravaras", "ஆத்ரேய ஆர்ச்சநானஸ ஶ்யாவாஶ்வ"),
            "வாதூல" to listOf("Select Your Pravaras", "பார்க்கவ வைதஹவ்ய ஸாவேதஸ"),
            "ஸ்ரீவத்ஸ" to listOf(
                "Select Your Pravaras",
                "பார்கவ ச்யாவன ஆப்நவாந ஔர்வ பஞ்சார்ஷேய:",
                "ஜாமதக்ந்ய"
            ),
            "கௌஶிக" to listOf(
                "Select Your Pravaras",
                "வைஶ்வாமித்ர ஆகமர்ஷண கௌசிகேதி த்ரயார்ஷேய:"
            ),
            "விஶ்வாமித்ர" to listOf("Select Your Pravaras", "வைஶ்வாமித்ர தேவராத ஔதல"),
            "கௌண்டிந்ய" to listOf(
                "Select Your Pravaras",
                "வாஸிஷ்ட மைத்ராவருண கௌண்டிந்ய"
            ),
            "ஹாரித" to listOf("Select Your Pravaras", "ஆங்கிரஸ ஆம்பரீஷ யுவநாச்வ"),
            "மௌத்கல்ய" to listOf(
                "Select Your Pravaras",
                "ஆங்கிரஸ பௌர்ம்யஶ்வ மௌத்கல்யேதி த்ரயார்ஷேய:",
                "தார்க்ஷ்ப பௌர்ம்யஶ்வ மௌத்கல்யேதி த்ரயார்ஷேய:",
                "ஆங்கிரஸ தாவ்ய மௌத்கல்யேதி த்ரயார்ஷேய:"
            ),
            "சாண்டில்ய" to listOf(
                "Select Your Pravaras",
                "காஶ்யாப ஆவத்ஸார சாண்டில்ய",
                "காஶ்யாப ஆவத்ஸார தைவல"
            ),
            "நைத்ருவகாஶ்யப" to listOf("Select Your Pravaras", "காஶ்யாப ஆவத்ஸார நைத்ருவ"),
            "குத்ஸ" to listOf("Select Your Pravaras", "ஆங்கிரஸ மாந்தாத்ர கௌதஸ"),
            "கண்வ" to listOf(
                "Select Your Pravaras",
                "ஆங்கீரஸ அஜமீட காண்வ",
                "ஆங்கீரஸ கௌர காண்வ"
            ),
            "பராசர" to listOf("Select Your Pravaras", "வாஶிஷ்ட சாக்த்ய பாராசர்ய"),
            "அகஸ்த்ய" to listOf("Select Your Pravaras", "அகஸ்த்ய தார்ட்யச்யுத ஸௌமவாஹ"),
            "கௌதம" to listOf(
                "Select Your Pravaras",
                "ஆங்கீரஸ ஔஜித்ய கௌதமேத் த்ரயார்ஷேய:"
            ),
            "கர்கி" to listOf(
                "Select Your Pravaras",
                "ஆங்கீரஸ பார்ஹஸ்பத்ய பாரத்வாஜ ஶைந்ய கார்க்ய",
                "ஆங்கீரஸ ஶைந்ய கார்க்ய"
            ),
            "பாதராயண" to listOf("Select Your Pravaras", "ஆங்கீரஸ பார்ஷதச்வ ராதீதர"),
            "காஶ்யப" to listOf("Select Your Pravaras", "ஆங்கீரஸ ஆவத்ஸார தைவல"),
            "ஸங்க்ருத்ய" to listOf(
                "Select Your Pravaras",
                "ஆங்கீரஸ கௌரவீத ஸங்க்ருத்ய",
                "சாத்ய கௌரவீத ஸங்க்ருத்ய"
            )
        )

        val gothramArray = gothramPravarasMap.keys.toList()

        val mySpinner1 = findViewById<Spinner>(R.id.spinnerGothram)
        val adapter0 = ArrayAdapter(this, android.R.layout.simple_list_item_1, gothramArray)
        mySpinner1.adapter = adapter0

        val gothramAdapter =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, gothramArray)
        gothramAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        yourGothram.adapter = gothramAdapter

        yourGothram.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                urGothram = gothramArray[position]
                val pravarasAdapter = ArrayAdapter(
                    this@SandhiData,
                    android.R.layout.simple_spinner_item,
                    gothramPravarasMap[urGothram] ?: emptyList()
                )
                pravarasAdapter.setDropDownViewResource(
                    android.R.layout.simple_spinner_dropdown_item
                )
                yourPravaras.adapter = pravarasAdapter
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        yourPravaras.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                urPravaras = (gothramPravarasMap[urGothram] ?: emptyList())[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun createAndStorePdf() {
        val intent = Intent(Intent.ACTION_CREATE_DOCUMENT).apply {
            type = "application/pdf"
            putExtra(Intent.EXTRA_TITLE, "my_pdf_file.pdf")
        }
        createPdfFileLauncher.launch(intent)
    }

    private val createPdfFileLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            result.data?.data?.let { uri ->
                contentResolver.openOutputStream(uri)?.use { outputStream ->
                    // Write your PDF data to outputStream
                }
            }
        }
    }

    private fun saveData() {
        val sharedPreferences = getSharedPreferences(sharedPrefs, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("yurName", binding.yourName.text.toString())
        editor.putString("tyOfSdya", binding.typeOfSandyaTextView.text.toString())
        editor.apply()
    }

    private fun loadData() {
        val sharedPreferences = getSharedPreferences(sharedPrefs, Context.MODE_PRIVATE)
        yurName = sharedPreferences.getString("yurName", "") ?: ""
        tyOfSdya = sharedPreferences.getString("tyOfSdya", "") ?: ""
    }

    private fun updateViews() {
        binding.yourName.setText(yurName)
        binding.typeOfSandyaTextView.setText(tyOfSdya)
    }

    @Suppress("SENSELESS_COMPARISON")
    private fun parseWeb() {
        val basicWeb = "https://www.drikpanchang.com/panchang/day-panchang.html"
        try {
            Jsoup.connect(basicWeb).get().run {
                val panchangData = select("div.dpTableCardWrapper")
                    .flatMap { it.select("div.dpTableCard") }
                    .flatMap { it.select("div.dpTableCell") }
                    .associate {
                        val key = it.getElementsByClass("dpTableKey").text()
                        val value = it.getElementsByClass("dpTableValue").text()
                        key to value
                    }

                val database = FirebaseDatabase.getInstance()
                val panchangRef = database.getReference("panchangData")

                panchangRef.setValue(panchangData)

                panchangRef.addValueEventListener(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        val data = dataSnapshot.value
                        if (data is Map<*, *>) {
                            val stringMap = data.entries.associate { (key, value) ->
                                key.toString() to value.toString()
                            }
                            madyana = stringMap["Madhyahna"] ?: ""
                            sayamSandya = stringMap["Sayahna Sandhya"] ?: ""
                        }
                    }

                    override fun onCancelled(databaseError: DatabaseError) {
                        // Handle error
                    }
                })

                madyana = panchangData["Madhyahna"]!!
                sayamSandya = panchangData["Sayahna Sandhya"]!!

                val (sSandyaStartHour, sSandyaStartMinute) =
                    sayamSandya.split(" ")[0].split(":").map { it.toInt() }
                sSandyaStartHrInMinutes = (sSandyaStartHour + 12) * 60 + sSandyaStartMinute

                val (sSandyaFinishHour, sSandyaFinishMinute) =
                    sayamSandya.split(" ")[3].split(":").map { it.toInt() }
                sSandyaFinishHrInMinutes =
                    (sSandyaFinishHour + 12) * 60 + sSandyaFinishMinute

                val (clockHour, clockMinute) =
                    SimpleDateFormat("HH:mm", Locale.US).format(Date())
                        .split(":").map { it.toInt() }
                clockTimeInMinutes = clockHour * 60 + clockMinute
            }
        } catch (e: Exception) {
            println(e)
        }
    }

    private fun yesterDayParseWeb() = try {
        val basicWeb =
            "https://www.drikpanchang.com/panchang/day-panchang.html?geoname-id=1264527&date="
        val yesterdayWeb = basicWeb + yesterday
        println("yesterdayWeb : $yesterdayWeb")
        Jsoup.connect(yesterdayWeb).get().run {
            select("div.dpPanchangWrapper").forEach { element ->
                val anchor1 = element.select("div.dpTableCard")
                val dpCardRow1 = anchor1.select("div.dpTableCell")
                for (key in dpCardRow1) {
                    if (key.getElementsByClass("dpTableKey").hasText())
                        mapKey = key.getElementsByClass("dpTableKey").text()
                    DataList = key.getElementsByClass("dpTableValue").text()
                    mapPanch[mapKey] = DataList
                }
            }
            for (key in mapPanch.keys) {
                println("Map ---- Key : $key value : ${mapPanch[key]}")
            }
            prathaSanthya = mapPanch["Pratah Sandhya"]!!
            println("prathaSanthya : $prathaSanthya")

            val pSandyaStartTime = prathaSanthya.split(" ")[0]
            println("PSandyaStartTime : $pSandyaStartTime")
            pSandyaStartHrInMinutes =
                (pSandyaStartTime.split(":")[0].toInt() * 60) +
                        pSandyaStartTime.split(":")[1].toInt()
            println("PSandyaStartHrInMinutes : $pSandyaStartHrInMinutes")

            val pSandyaFinishTime = prathaSanthya.split(" ")[5]
            println("pSandyaFinishTime : $pSandyaFinishTime")
            pSandyaFinishHrInMinutes =
                (pSandyaFinishTime.split(":")[0].toInt() * 60) +
                        pSandyaFinishTime.split(":")[1].toInt()
            println("PSandyaFinishHrInMinutes : $pSandyaFinishHrInMinutes")
        }
        println("Yesterday Finished")
    } catch (e: Exception) {
        println(e)
    }
}
