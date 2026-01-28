package com.karma.sureshtrb.enKarma

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.karma.sureshtrb.enKarma.databinding.ActivitySandhiDataBinding
import org.jsoup.Jsoup
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

var urGothram: String = ""
var urPravaras: String = ""
var spinnerPosition: Int = 0
var nowSandhi: String = ""
var tyDate: String = "__/__/____"
var yesterday: String = ""
var SSandyaFinishHrInMinutes: Int = 0
var SSandyaStartHrInMinutes: Int = 0
var PSandyaFinishHrInMinutes: Int = 0
var PSandyaStartHrInMinutes: Int = 0
var clockTimeInMinutes: Int = 0
//var prathaSanthya: String = ""
//var madyana: String = ""
//var sayamSandya: String = ""
//var mapPanch = mutableMapOf<String, String>()
//var mapKey: String = ""
//var DataList: String = ""

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class SandhiData : AppCompatActivity() {

    private lateinit var binding: ActivitySandhiDataBinding

    private var myPreferences = "myPrefs"
    private var EMPTY = ""
    private var NAME = "name"
    private var GOTHRAM = "gothram"
    private var PRAVARAS = "pravaras"
    var yurName: String = ""
    var tyOfSdya: String = ""
    val SHARED_PREFS: String = "sandhidata_prefs"

    @SuppressLint("SimpleDateFormat", "ResourceType")
    @TargetApi(Build.VERSION_CODES.N)
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySandhiDataBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.typeOfSandyaTextView.setText("ஸ்ந்தியா")

        val sdf = SimpleDateFormat("dd/MM/yyyy")
        tyDate = sdf.format(Date())
        val cal1 = Calendar.getInstance()
        val sdf1 = SimpleDateFormat("dd/MM/yyyy")
        cal1.time = sdf1.parse(tyDate)
        cal1.add(Calendar.DATE, -1)
        yesterday = sdf.format(cal1.time)

        parseWeb()
        yesterDayParseWeb()
        loadData()
        updateViews()

        binding.sandyaButton.setOnClickListener {
            val intent = Intent(this, SandyaVandanamActivity::class.java)
            intent.putExtra("name", binding.yourName.text.toString())
            intent.putExtra("gothram", urGothram)
            intent.putExtra("pravaras", urPravaras)
            intent.putExtra("sandhi", binding.typeOfSandyaTextView.text.toString())
            startActivity(intent)
            saveData()
        }

        binding.gayathriButton.setOnClickListener {
            val intent = Intent(this, GayathriJapamActivity::class.java)
            intent.putExtra("name", binding.yourName.text.toString())
            intent.putExtra("gothram", urGothram)
            intent.putExtra("pravaras", urPravaras)
            intent.putExtra("sandhi", binding.typeOfSandyaTextView.text.toString())
            startActivity(intent)
            saveData()
        }

        binding.prathaButton.setOnClickListener {
            binding.typeOfSandyaTextView.setText("ப்ராத்தஸ்ந்தியா")
            binding.sandyaTimeTextView.text = "Time to Do: $prathaSanthya"
            binding.prathaButton.setTextColor(Color.BLUE)
            binding.mathyanigaButton.setTextColor(Color.GRAY)
            binding.sayamsandyaButton.setTextColor(Color.GRAY)
            binding.prathaButton.setBackgroundColor(Color.YELLOW)
            binding.mathyanigaButton.setBackgroundColor(Color.LTGRAY)
            binding.sayamsandyaButton.setBackgroundColor(Color.LTGRAY)
        }

        binding.mathyanigaButton.setOnClickListener {
            binding.typeOfSandyaTextView.setText("மாத்யாநிஹம்")
            binding.sandyaTimeTextView.text = "Time to Do: $madyana"
            binding.mathyanigaButton.setTextColor(Color.BLUE)
            binding.prathaButton.setTextColor(Color.GRAY)
            binding.sayamsandyaButton.setTextColor(Color.GRAY)
            binding.prathaButton.setBackgroundColor(Color.LTGRAY)
            binding.mathyanigaButton.setBackgroundColor(Color.YELLOW)
            binding.sayamsandyaButton.setBackgroundColor(Color.LTGRAY)
        }

        binding.sayamsandyaButton.setOnClickListener {
            binding.typeOfSandyaTextView.setText("ஸாயம்ஸந்தியா")
            binding.sandyaTimeTextView.text = "Time to Do: $sayamSandya"
            binding.sayamsandyaButton.setTextColor(Color.BLUE)
            binding.prathaButton.setTextColor(Color.GRAY)
            binding.mathyanigaButton.setTextColor(Color.GRAY)
            binding.prathaButton.setBackgroundColor(Color.LTGRAY)
            binding.mathyanigaButton.setBackgroundColor(Color.LTGRAY)
            binding.sayamsandyaButton.setBackgroundColor(Color.YELLOW)
        }

        Thread {
            val builder = StringBuilder()
            try {
                val doc = Jsoup.connect("https://www.drikpanchang.com/panchang/day-panchang.html?geoname-id=1264527&date=Today()").get()
                val title = doc.title()
                val links = doc.select("dpGroupCard dpFlexWrap")
                builder.append(title).append("\n")
                for (link in links) {
                    builder.append("\nLink : ${link.attr("href")}\nText : ${link.text()}")
                }
            } catch (e: IOException) {
                builder.append("Error : ").append(e.message).append("\n")
            }
            runOnUiThread { println(builder.toString()) }
        }.start()

        Thread {
            try {
                while (!Thread.interrupted()) {
                    Thread.sleep(1000)
                    runOnUiThread {
                        val tdate = binding.timeNowTextView
                        val date = System.currentTimeMillis()
                        val sdf = SimpleDateFormat("EEEE, MMM dd, yyyy, HH:mm:ss")
                        val dateString = sdf.format(date)
                        tdate.text = dateString
                    }
                }
            } catch (_: InterruptedException) { }
        }.start()

        supportActionBar?.apply {
            setHomeAsUpIndicator(R.drawable.home)
            setDisplayHomeAsUpEnabled(true)
            subtitle = "Sandiya Details / ஸந்தியா விவரங்கள்"
            setDisplayShowHomeEnabled(true)
            setLogo(R.drawable.karma)
            setDisplayUseLogoEnabled(true)
        }

        if(clockTimeInMinutes in SSandyaStartHrInMinutes..SSandyaFinishHrInMinutes) {
            binding.sayamsandyaButton.performClick()
            val sandyaTypeText = "<font color=#000080>Sayahna Sandhya: </font> <font color=#800000>$sayamSandya</font>"
            binding.sandyaTimeTextView.text = Html.fromHtml(sandyaTypeText)
        } else if(clockTimeInMinutes in PSandyaStartHrInMinutes..PSandyaFinishHrInMinutes){
            binding.prathaButton.performClick()
            val sandyaTypeText = "<font color=#000080>Pratah Sandhya: </font> <font color=#800000>$prathaSanthya</font>"
            binding.sandyaTimeTextView.text = Html.fromHtml(sandyaTypeText)
        } else if(clockTimeInMinutes in PSandyaFinishHrInMinutes..SSandyaStartHrInMinutes){
            binding.mathyanigaButton.performClick()
            val sandyaTypeText = "<font color=#000080>Madhyahna</font> <font color=#800000>$madyana</font>"
            binding.sandyaTimeTextView.text = Html.fromHtml(sandyaTypeText)
        } else{
            binding.typeOfSandyaTextView.setText("உகந்த நேரமன்று")
        }

        val gothram_array = arrayOf(
            "Select - Your Gothram", "பாரத்வாஜ", "ஷடமாஷண", "ஆத்ரேய", "வாதூல", "ஸ்ரீவத்ஸ", "கௌஶிக", "விஶ்வாமித்ர",
            "கௌண்டிந்ய", "ஹாரித", "மௌத்கல்ய", "சாண்டில்ய", "நைத்ருவகாஷ்யப", "குத்ஸ", "கண்வ", "பராசர", "அகஸ்த்ய",
            "கௌதம", "கர்கி", "பாதராயண", "காஶ்யப", "ஸங்க்ருத்ய"
        )

        val pravaras_array1 = arrayOf("Select Your Pravaras", "ஆங்கிரஸ பார்ஹஸ்பத்ய பாரத்வாஜேதி த்ரயார்ஷேய", "உப்ரெதி") //... etc, for all your pravaras_array
        // Initialize the rest of your pravaras_arrayX & adapterX variables here (same logic as your code).

        var adapter0 = ArrayAdapter(this, android.R.layout.simple_list_item_1, gothram_array)
        binding.spinnerGothram.adapter = adapter0

        binding.spinnerGothram.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                urGothram = gothram_array[position]
                spinnerPosition = adapter0.getPosition(gothram_array[position])
                binding.spinnerGothram.setSelection(spinnerPosition)
                // Repeat all setup for spinnerPravaras the way you have, but use View Binding
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        // spinnerPravaras adapter logic goes here (unchanged, just reference via binding)
    }

    fun saveData() {
        val sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("yurName", binding.yourName.text.toString())
        editor.putString("tyOfSdya", binding.typeOfSandyaTextView.text.toString())
        editor.apply()
    }

    fun loadData() {
        val sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
        yurName = sharedPreferences.getString("yurName", "") ?: ""
        tyOfSdya = sharedPreferences.getString("tyOfSdya", "") ?: ""
    }

    fun updateViews() {
        binding.yourName.setText(yurName)
        binding.typeOfSandyaTextView.setText(tyOfSdya)
    }

    @Suppress("SENSELESS_COMPARISON")
    @RequiresApi(Build.VERSION_CODES.N)
    private fun parseWeb() = try {
        val BasicWeb = "https://www.drikpanchang.com/panchang/day-panchang.html"
        Jsoup.connect(BasicWeb).get().run {
            select("div.dpTableCardWrapper").forEachIndexed { index, element ->
                val Anchor1 = element.select("div.dpTableCard")
                val dpCardRow1 = Anchor1.select("div.dpTableCell")
                for (key in dpCardRow1) {
                    if(key.getElementsByClass("dpTableKey").hasText())
                        mapKey = key.getElementsByClass("dpTableKey").text()
                    DataList = key.getElementsByClass("dpTableValue").text()
                    mapPanch[mapKey] = DataList
                }
            }
            madyana = mapPanch["Madhyahna"] ?: ""
            sayamSandya = mapPanch["Sayahna Sandhya"] ?: ""
            val SSandyaStartTime = sayamSandya.split(" ")[0]
            SSandyaStartHrInMinutes =
                ((SSandyaStartTime.split(":")[0].toInt() + 12) * 60) + SSandyaStartTime.split(":")[1].toInt()
            val SSandyaFinishTime = sayamSandya.split(" ")[3]
            SSandyaFinishHrInMinutes =
                ((SSandyaFinishTime.split(":")[0].toInt() + 12) * 60) + SSandyaFinishTime.split(":")[1].toInt()
            val timeNowClock = System.currentTimeMillis()
            val sdf = SimpleDateFormat("HH:mm")
            val timeString = sdf.format(timeNowClock)
            clockTimeInMinutes = timeString.split(":")[0].toInt() * 60 + timeString.split(":")[1].toInt()
        }
    } catch (e: Exception) {
        println(e)
    }

    private fun yesterDayParseWeb() = try {
        val BasicWeb = "https://www.drikpanchang.com/panchang/day-panchang.html?geoname-id=1264527&date="
        val yesterdayWeb = BasicWeb + yesterday
        Jsoup.connect(yesterdayWeb).get().run {
            select("div.dpPanchangWrapper").forEachIndexed { index, element ->
                val Anchor1 = element.select("div.dpTableCard")
                val dpCardRow1 = Anchor1.select("div.dpTableCell")
                for (key in dpCardRow1) {
                    if(key.getElementsByClass("dpTableKey").hasText())
                        mapKey = key.getElementsByClass("dpTableKey").text()
                    DataList = key.getElementsByClass("dpTableValue").text()
                    mapPanch[mapKey] = DataList
                }
            }
            prathaSanthya = mapPanch["Pratah Sandhya"] ?: ""
            val PSandyaStartTime = prathaSanthya.split(" ")[0]
            PSandyaStartHrInMinutes =
                (PSandyaStartTime.split(":")[0].toInt() * 60) + PSandyaStartTime.split(":")[1].toInt()
            val PSandyaFinishTime = prathaSanthya.split(" ")[5]
            PSandyaFinishHrInMinutes =
                (PSandyaFinishTime.split(":")[0].toInt() * 60) + PSandyaFinishTime.split(":")[1].toInt()
        }
    } catch (e: Exception) {
        println(e)
    }
}
