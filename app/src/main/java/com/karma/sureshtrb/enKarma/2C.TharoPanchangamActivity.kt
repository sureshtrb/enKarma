package com.karma.sureshtrb.enKarma

import android.annotation.TargetApi
import android.app.DatePickerDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.karma.sureshtrb.enKarma.databinding.ActivityTharoPanchangamBinding
import org.jsoup.Jsoup
import java.text.SimpleDateFormat
import java.util.*

import android.animation.ValueAnimator
import android.animation.ArgbEvaluator
var dateToday = ""
var place: String = ""
var sunRise: String = ""
var sunSet: String = ""
var TithiValue: String = ""
var TodayThithi: String = ""
var paksha: String = ""
var todayPaksha: String = ""
var naksha: String = ""
var yoga: String = ""
var karana: String = ""
var weekDay: String = ""
var chandraMasa: String = ""
var shakaSamvat: String = ""
var suryaRasi: String = ""
var chandraRasi: String = ""
var suryaNakshatra: String = ""
var vedicRithu: String = ""
var vedicAyana: String = ""
var madyana: String = ""
var sayamSandya: String = ""
var prathaSanthya: String = ""
var DataList: String = ""
var mapKey: String = ""
var DataList2: String = ""
var mapKey2: String = ""
var DataList3: String = ""
var mapKey3: String = ""
var DataList4: String = ""
var mapKey4: String = ""
var nextDaypakshaValue: String = ""
var todaypakshaValue: String = ""
var mapPanch: HashMap<String, String> = HashMap()
var mapPanch2: HashMap<String, String> = HashMap()
var mapPanch3: HashMap<String, String> = HashMap()
var mapPanch4: HashMap<String, String> = HashMap()
var todThitgi: String = ""
var tithiNew: String = ""
var TodayThithiUptoInMinutesM: Int = 0
var nowTimeInMinutes: Int = 0
var currentTithi: String = ""
var nakshatraHrToMin: Int = 0
var currentNakshtram: String = ""
var nextDayNakshatra: String = ""
var karnaHrToMin: Int = 0
var currentKarnam: String = ""
var nextDayKarnam: String = ""
var todayYogaUptoInMinutesM: Int = 0
var currentYogam: String = ""
var nextDayYogam: String = ""
var sRiseInMinutes: Int = 0
var SSetInMinutes: Int = 0
var PrefixTithi: String = ""
var ThithiGlobal: String = ""
var SkippedthithiValue: String = ""
var SkippedThithiGlobal: String = ""
var fromSunRiseToTwelveHrs: Int = 0
var todatTitiUptoHrOnly: Int = 0
var SunRiseTo30NaligaiInMinutes: Int = 0
var fatherLive: String = ""
var motherLive: String = ""
var motherMotherLive: String = ""
var fatherMotherLive: String = ""
var dateNow: String = "__/__ /____"
var nextdy: String = ""
var NextDayThithi: String = ""
var thithiValuex: String = ""
var nextDaypaksha: String = ""
var NextDaySunRiseTime: Int = 0
var nextDayTitiUptoHrOnly: Int = 0
var nextDayTithiHrToMin: Int = 0
var pradamaiDay: String = ""
var pradamaiTithiValue: String = ""
var pradamaiDayThithiValue: String = ""
var pradamaiDayThithi: String = ""
var pradamaiDaySunRise: String = ""
var pradamaiDaySunSet: String = ""
var pradamaiDayPaksha: String = ""
var pradamaiThithiUptoInMinutes: Int = 0
var pradamaiDaySRiseInMinutes: Int = 0
var pradamaiDayTitiUptoHrOnly: Int = 0
var afterPradamaiDay: String = ""
var afterPradamaiDaySunRise: String = ""
var afterPradamaiDaySunSet: String = ""
var afterPradamaiDayPaksha: String = ""
var afterPradamaiSRiseHrAndMinConvInMinutes: Int = 0
var bodayana = "சதுர்தஸ்யோபரி அமாவாஸ்யா"

@Suppress("DEPRECATION")
class TharoPanchangamActivity : AppCompatActivity() {

    var cal = Calendar.getInstance()
    private lateinit var binding: ActivityTharoPanchangamBinding

    // TextView references (moved inside class to avoid conflicts with top-level String vars)
    private lateinit var tvVarusham: TextView
    private lateinit var tvAyyanamm: TextView
    private lateinit var tvKalam: TextView
    private lateinit var tvRasee: TextView
    private lateinit var tvBaksham: TextView
    private lateinit var tvTodThithi: TextView
    private lateinit var tvKizhamai: TextView
    private lateinit var tvNachathirm: TextView
    private lateinit var tvYog: TextView
    private lateinit var tvKar: TextView
        private lateinit var tvGeoLocation: TextView
    private var loadingAnimator: ValueAnimator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTharoPanchangamBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clearAllData()

        supportActionBar?.setHomeAsUpIndicator(R.drawable.home)
        this.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        this.supportActionBar?.subtitle = "பஞ்சாங்கம / பித்ரு விபரங்கள்"
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setLogo(R.drawable.karma)
        supportActionBar?.setDisplayUseLogoEnabled(true)

        loadData()

        val dateText = findViewById<TextView>(R.id.text_view_date_1)
        val changeDateBtn = findViewById<Button>(R.id.button_date_1)

        tvVarusham = this.findViewById(R.id.Year)
        tvAyyanamm = this.findViewById(R.id.Ayana)
        tvKalam = this.findViewById(R.id.Season)
        tvRasee = this.findViewById(R.id.Rasi)
        tvBaksham = this.findViewById(R.id.Paksha)
        tvTodThithi = this.findViewById(R.id.Thithi)
        tvKizhamai = this.findViewById(R.id.Day)
        tvNachathirm = this.findViewById(R.id.Natchatram)
        tvYog = this.findViewById(R.id.Yogam)
        tvKar = this.findViewById(R.id.Karanam)
        tvGeoLocation = this.findViewById(R.id.GEOLOCATION)

        val rg1 = this.findViewById<RadioGroup>(R.id.radio_group1)
        val rg2 = this.findViewById<RadioGroup>(R.id.radio_group2)
        val rg3 = this.findViewById<RadioGroup>(R.id.radio_group3)
        val rg4 = this.findViewById<RadioGroup>(R.id.radio_group4)
        val proceed = findViewById<Button>(R.id.Proceed)

        val rbFLiving = this.findViewById<RadioButton>(R.id.radio1G1)
        val rbFDeceased = this.findViewById<RadioButton>(R.id.radio2G1)
        val rbMLiving = this.findViewById<RadioButton>(R.id.radio1G2)
        val rbMDeceased = this.findViewById<RadioButton>(R.id.radio2G2)
        val rbMMLiving = this.findViewById<RadioButton>(R.id.radio1G3)
        val rbMMDeceased = this.findViewById<RadioButton>(R.id.radio2G3)
        val rbFMLiving = this.findViewById<RadioButton>(R.id.radio1G4)
        val rbFMDeceased = this.findViewById<RadioButton>(R.id.radio2G4)

        if (rbFLiving.isChecked) { rg2.visibility = View.INVISIBLE } else { rg2.visibility = View.VISIBLE }
        if (rbFDeceased.isChecked) { rg2.visibility = View.VISIBLE } else { rg2.visibility = View.INVISIBLE }
        if (rbMLiving.isChecked || rbMDeceased.isChecked) { rg3.visibility = View.VISIBLE } else { rg3.visibility = View.INVISIBLE }
        if (rbMMLiving.isChecked || rbMMDeceased.isChecked) { rg4.visibility = View.VISIBLE } else { rg4.visibility = View.INVISIBLE }
        if (rbFMLiving.isChecked || rbFMDeceased.isChecked) { proceed.visibility = View.VISIBLE } else { proceed.visibility = View.INVISIBLE }

        val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
        dateNow = dateFormat.format(Date())
        dateText.text = dateNow
        recalculateDays()

        val calen = Calendar.getInstance()
        val hourtoMinInt = calen.get(Calendar.HOUR_OF_DAY) * 60
        val minutesInt = calen.get(Calendar.MINUTE)
        nowTimeInMinutes = hourtoMinInt + minutesInt

        // Run all web scraping on background thread to avoid ANR
        fetchAllPanchangData()

        val dateSetListener = DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            updateDateInView()
        }

        changeDateBtn.setOnClickListener {
            clearAllData()
            DatePickerDialog(
                this@TharoPanchangamActivity,
                dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        binding.textViewDate1.addTextChangedListener {
            todThitgi = ""
            recalculateDays()
            // Run on background thread to avoid ANR
            fetchAllPanchangData()
        }

        proceed.setOnClickListener {
            val intent = Intent(this, AnsestorDataActivity::class.java)
            intent.putExtra("Naal", dateText.text.toString())
            intent.putExtra("Idam", place)
            intent.putExtra("TamilYear", shakaSamvat)
            intent.putExtra("Ayanamm", vedicAyana)
            intent.putExtra("KAALAM", vedicRithu)
            intent.putExtra("RASEEE", suryaRasi)
            intent.putExtra("BAKKSHAMM", paksha)
            intent.putExtra("TODAYSTHITHI", ThithiGlobal)
            intent.putExtra("KIZHAMAAII", weekDay)
            intent.putExtra("NAKSM", naksha)
            intent.putExtra("YGM", yoga)
            intent.putExtra("KRNM", karana)
            saveRadioState()
            startActivity(intent)
        }

        rg1.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.radio1G1 -> {
                    rbFLiving.setTextColor(Color.BLUE)
                    rbFLiving.setTypeface(null, Typeface.BOLD)
                    rbFDeceased.setTextColor(Color.BLACK)
                    rbFDeceased.setTypeface(null, Typeface.NORMAL)
                    fatherLive = "Living"
                    rg2.visibility = View.VISIBLE
                    rg3.visibility = View.INVISIBLE
                    rg4.visibility = View.INVISIBLE
                    proceed.visibility = View.INVISIBLE
                }
                R.id.radio2G1 -> {
                    rbFLiving.setTextColor(Color.BLACK)
                    rbFLiving.setTypeface(null, Typeface.NORMAL)
                    rbFDeceased.setTextColor(Color.RED)
                    rbFDeceased.setTypeface(null, Typeface.BOLD)
                    fatherLive = "Deceased"
                    rg2.visibility = View.VISIBLE
                    rg3.visibility = View.INVISIBLE
                    rg4.visibility = View.INVISIBLE
                    proceed.visibility = View.INVISIBLE
                }
            }
        }

        rg2.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.radio1G2 -> {
                    rbMLiving.setTextColor(Color.BLUE)
                    rbMLiving.setTypeface(null, Typeface.BOLD)
                    rbMDeceased.setTextColor(Color.BLACK)
                    rbMDeceased.setTypeface(null, Typeface.NORMAL)
                    motherLive = "Living"
                    rg3.visibility = View.VISIBLE
                    rg4.visibility = View.INVISIBLE
                    proceed.visibility = View.INVISIBLE
                }
                R.id.radio2G2 -> {
                    rbMLiving.setTextColor(Color.BLACK)
                    rbMLiving.setTypeface(null, Typeface.NORMAL)
                    rbMDeceased.setTextColor(Color.RED)
                    rbMDeceased.setTypeface(null, Typeface.BOLD)
                    motherLive = "Deceased"
                    rg3.visibility = View.VISIBLE
                    rg4.visibility = View.INVISIBLE
                    proceed.visibility = View.INVISIBLE
                }
            }
        }

        rg3.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.radio1G3 -> {
                    rbMMLiving.setTextColor(Color.BLUE)
                    rbMMLiving.setTypeface(null, Typeface.BOLD)
                    rbMMDeceased.setTextColor(Color.BLACK)
                    rbMMDeceased.setTypeface(null, Typeface.NORMAL)
                    motherMotherLive = "Living"
                    rg4.visibility = View.VISIBLE
                    proceed.visibility = View.INVISIBLE
                }
                R.id.radio2G3 -> {
                    rbMMLiving.setTextColor(Color.BLACK)
                    rbMMLiving.setTypeface(null, Typeface.NORMAL)
                    rbMMDeceased.setTextColor(Color.RED)
                    rbMMDeceased.setTypeface(null, Typeface.BOLD)
                    motherMotherLive = "Deceased"
                    rg4.visibility = View.VISIBLE
                    proceed.visibility = View.INVISIBLE
                }
            }
        }

        rg4.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.radio1G4 -> {
                    rbFMLiving.setTextColor(Color.BLUE)
                    rbFMLiving.setTypeface(null, Typeface.BOLD)
                    rbFMDeceased.setTextColor(Color.BLACK)
                    rbFMDeceased.setTypeface(null, Typeface.NORMAL)
                    fatherMotherLive = "Living"
                    proceed.visibility = View.VISIBLE
                }
                R.id.radio2G4 -> {
                    rbFMLiving.setTextColor(Color.BLACK)
                    rbFMLiving.setTypeface(null, Typeface.NORMAL)
                    rbFMDeceased.setTextColor(Color.RED)
                    rbFMDeceased.setTypeface(null, Typeface.BOLD)
                    fatherMotherLive = "Deceased"
                    proceed.visibility = View.VISIBLE
                }
            }
        }
    }

    // Background thread wrapper for all web scraping
    private fun fetchAllPanchangData() {
        tvGeoLocation.text = "Loading..."
        // Start blinking color animation for Loading text
        loadingAnimator?.cancel()
        loadingAnimator = ValueAnimator.ofObject(ArgbEvaluator(), Color.RED, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE, Color.MAGENTA, Color.RED).apply {
            duration = 2000
            repeatCount = ValueAnimator.INFINITE
            repeatMode = ValueAnimator.RESTART
            addUpdateListener { animator ->
                tvGeoLocation.setTextColor(animator.animatedValue as Int)
            }
            start()
        }
        Thread {
            try {
                afterPradamaiDayparseWeb()
                pradamaiDayparseWeb()
                nextDayparseWeb()
                parseWeb()
            } catch (e: Exception) {
                println("fetchAllPanchangData Error: $e")
            }
            runOnUiThread {
                updateUITexts()
            }
        }.start()
    }

    private fun recalculateDays() {
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
        val cal1 = Calendar.getInstance()
        cal1.time = sdf.parse(dateNow) ?: Date()
        cal1.add(Calendar.DATE, 1)
        nextdy = sdf.format(cal1.time)

        val cal2 = Calendar.getInstance()
        cal2.time = sdf.parse(dateNow) ?: Date()
        cal2.add(Calendar.DATE, 2)
        pradamaiDay = sdf.format(cal2.time)

        val cal3 = Calendar.getInstance()
        cal3.time = sdf.parse(dateNow) ?: Date()
        cal3.add(Calendar.DATE, 3)
        afterPradamaiDay = sdf.format(cal3.time)
    }

    private fun loadData() {
        val rbFLiving = this.findViewById<RadioButton>(R.id.radio1G1)
        val rbFDeceased = this.findViewById<RadioButton>(R.id.radio2G1)
        val rbMLiving = this.findViewById<RadioButton>(R.id.radio1G2)
        val rbMDeceased = this.findViewById<RadioButton>(R.id.radio2G2)
        val rbMMLiving = this.findViewById<RadioButton>(R.id.radio1G3)
        val rbMMDeceased = this.findViewById<RadioButton>(R.id.radio2G3)
        val rbFMLiving = this.findViewById<RadioButton>(R.id.radio1G4)
        val rbFMDeceased = this.findViewById<RadioButton>(R.id.radio2G4)
        val settings = getSharedPreferences("Answer", 0)
        if (settings.getBoolean("question1A", false)) { rbFLiving.isChecked = true; fatherLive = "Living" }
        if (settings.getBoolean("question1B", false)) { rbFDeceased.isChecked = true; fatherLive = "Deceased" }
        if (settings.getBoolean("question2A", false)) { rbMLiving.isChecked = true; motherLive = "Living" }
        if (settings.getBoolean("question2B", false)) { rbMDeceased.isChecked = true; motherLive = "Deceased" }
        if (settings.getBoolean("question3A", false)) { rbMMLiving.isChecked = true; motherMotherLive = "Living" }
        if (settings.getBoolean("question3B", false)) { rbMMDeceased.isChecked = true; motherMotherLive = "Deceased" }
        if (settings.getBoolean("question4A", false)) { rbFMLiving.isChecked = true; fatherMotherLive = "Living" }
        if (settings.getBoolean("question4B", false)) { rbFMDeceased.isChecked = true; fatherMotherLive = "Deceased" }
    }

    private fun saveRadioState() {
        val rbFLiving = this.findViewById<RadioButton>(R.id.radio1G1)
        val rbFDeceased = this.findViewById<RadioButton>(R.id.radio2G1)
        val rbMLiving = this.findViewById<RadioButton>(R.id.radio1G2)
        val rbMDeceased = this.findViewById<RadioButton>(R.id.radio2G2)
        val rbMMLiving = this.findViewById<RadioButton>(R.id.radio1G3)
        val rbMMDeceased = this.findViewById<RadioButton>(R.id.radio2G3)
        val rbFMLiving = this.findViewById<RadioButton>(R.id.radio1G4)
        val rbFMDeceased = this.findViewById<RadioButton>(R.id.radio2G4)
        val settings = getSharedPreferences("Answer", 0)
        val editor = settings.edit()
        editor.putBoolean("question1A", rbFLiving.isChecked)
        editor.putBoolean("question1B", rbFDeceased.isChecked)
        editor.putBoolean("question2A", rbMLiving.isChecked)
        editor.putBoolean("question2B", rbMDeceased.isChecked)
        editor.putBoolean("question3A", rbMMLiving.isChecked)
        editor.putBoolean("question3B", rbMMDeceased.isChecked)
        editor.putBoolean("question4A", rbFMLiving.isChecked)
        editor.putBoolean("question4B", rbFMDeceased.isChecked)
        editor.apply()
    }

    @TargetApi(Build.VERSION_CODES.O)
    private fun updateDateInView() {
        val myFormat = "dd/MM/yyyy"
        val sdf = SimpleDateFormat(myFormat, Locale.ENGLISH)
        binding.textViewDate1.text = sdf.format(cal.time)
        dateNow = binding.textViewDate1.text.toString()
    }

    private fun pradamaiDayparseWeb() = try {
        val basicWeb = "https://www.drikpanchang.com/panchang/day-panchang.html?geoname-id=1264527&date="
        val pradamaiDayWeb = (basicWeb + pradamaiDay)
        Jsoup.connect(pradamaiDayWeb).userAgent("Mozilla/5.0 (Linux; Android 13) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Mobile Safari/537.36").timeout(30000).followRedirects(true).ignoreHttpErrors(true).get().run {
            select("div.dpPHeaderWrapper").forEachIndexed { _, element ->
                val leftData2 = element.select("div.dpPHeaderLeftWrapper")
                for (key2 in leftData2) {
                    if (key2.select("div.dpPHeaderLeftContent").hasText()) {
                        val leftHeaderData2 = key2.text()
                        val retrivePaksha2 = leftHeaderData2.split(" ")[2]
                        pradamaiDayPaksha = retrivePaksha2
                    }
                    select("div.dpTableCardWrapper").forEachIndexed { _, element2 ->
                        val sunAnchor2 = element2.select("div.dpCard.dpFlexEqual")
                        val dpSunRiseRow2 = sunAnchor2.select("div.dpCardRow")
                        for (k2 in dpSunRiseRow2) {
                            if (k2.select("span.dpTitle").hasText()) {
                                val dataSunMoon2 = k2.text()
                                if (dataSunMoon2.startsWith("Sunrise")) { pradamaiDaySunRise = dataSunMoon2 }
                                else if (dataSunMoon2.startsWith("Sunset")) { pradamaiDaySunSet = dataSunMoon2 }
                            }
                        }
                        var isKey2 = false
                        val anchor2 = element2.select("div.dpTableCard")
                        val dpCardRow2 = anchor2.select("div.dpTableCell")
                        for (k2 in dpCardRow2) {
                            if (k2.getElementsByClass("dpTableKey").hasText()) { mapKey2 = k2.getElementsByClass("dpTableKey").text(); isKey2 = true }
                            if (k2.getElementsByClass("dpTableValue").hasText()) { if (isKey2) { DataList2 = k2.getElementsByClass("dpTableValue").text(); isKey2 = false } }
                            mapPanch2[mapKey2] = DataList2
                        }
                    }
                    val pradamaiDayTithiArr = (mapPanch2["Tithi"] ?: "")
                    val pradamaiDayThithee = pradamaiDayTithiArr.split(" upto ")[0]
                    val pradamaiDayTitiUpto0 = pradamaiDayTithiArr.split(" upto ")[1]
                    if ((pradamaiDayTithiArr.split(" ")[0]) == "Full") { pradamaiThithiUptoInMinutes = afterPradamaiSRiseHrAndMinConvInMinutes }
                    if ((pradamaiDayTithiArr.split(" ")[0]) != "Full") {
                        val pradmaiDayselectTimeOnly = pradamaiDayTitiUpto0.trim().split(" ")[0]
                        pradamaiDayTitiUptoHrOnly = pradmaiDayselectTimeOnly.split(":")[0].toInt()
                        val pradamaiDayTitiUptoMinutesOnly = pradmaiDayselectTimeOnly.split(":")[1].toInt()
                        val amPm = pradamaiDayTitiUpto0.split(" ")[1]
                        pradamaiThithiUptoInMinutes = convertToMinutes(pradamaiDayTitiUptoHrOnly, pradamaiDayTitiUptoMinutesOnly, amPm)
                    }
                    pradamaiTithiValue = pradamaiDayThithee
                    pradamaiDayThithiValue = pradamaiTithiValue
                    pradamaiDayThithi = convertThithiToTamil(pradamaiDayThithiValue)
                    val pradamaiDaySRise = (mapPanch2["Sunrise"] ?: "")
                    if (pradamaiDaySRise.isNotEmpty()) {
                        val pradamaiDaySRiseTime = pradamaiDaySRise.split(" ")[0]
                        val pradamaiDaySRiseHr = pradamaiDaySRiseTime.split(":")[0].toInt()
                        val pradamaiDaySRiseMinutes = pradamaiDaySRiseTime.split(":")[1].toInt()
                        pradamaiDaySRiseInMinutes = pradamaiDaySRiseHr * 60 + pradamaiDaySRiseMinutes
                    }
                }
            }
        }
    } catch (e: Exception) { println(e) }

    private fun afterPradamaiDayparseWeb() = try {
        val basicWeb = "https://www.drikpanchang.com/panchang/day-panchang.html?geoname-id=1264527&date="
        val dayAfterPradamaiDayWeb = (basicWeb + afterPradamaiDay)
        Jsoup.connect(dayAfterPradamaiDayWeb).userAgent("Mozilla/5.0 (Linux; Android 13) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Mobile Safari/537.36").timeout(30000).followRedirects(true).ignoreHttpErrors(true).get().run {
            select("div.dpPHeaderWrapper").forEachIndexed { _, element ->
                val leftData3 = element.select("div.dpPHeaderLeftWrapper")
                for (key3 in leftData3) {
                    if (key3.select("div.dpPHeaderLeftContent").hasText()) {
                        val leftHeaderData3 = key3.text()
                        val retrivePaksha3 = leftHeaderData3.split(" ")[2]
                        afterPradamaiDayPaksha = retrivePaksha3
                    }
                    select("div.dpTableCardWrapper").forEachIndexed { _, element3 ->
                        val sunAnchor3 = element3.select("div.dpCard.dpFlexEqual")
                        val dpSunRiseRow3 = sunAnchor3.select("div.dpCardRow")
                        for (k3 in dpSunRiseRow3) {
                            if (k3.select("span.dpTitle").hasText()) {
                                val dataSunMoon3 = k3.text()
                                if (dataSunMoon3.startsWith("Sunrise")) { afterPradamaiDaySunRise = dataSunMoon3 }
                                else if (dataSunMoon3.startsWith("Sunset")) { afterPradamaiDaySunSet = dataSunMoon3 }
                            }
                        }
                        var isKey3 = false
                        val anchor3 = element3.select("div.dpTableCard")
                        val dpCardRow3 = anchor3.select("div.dpTableCell")
                        for (k3 in dpCardRow3) {
                            if (k3.getElementsByClass("dpTableKey").hasText()) { mapKey3 = k3.getElementsByClass("dpTableKey").text(); isKey3 = true }
                            if (k3.getElementsByClass("dpTableValue").hasText()) { if (isKey3) { DataList3 = k3.getElementsByClass("dpTableValue").text(); isKey3 = false } }
                            mapPanch3[mapKey3] = DataList3
                        }
                    }
                    val afterPradamaiDaySRise = (mapPanch3["Sunrise"] ?: "")
                    if (afterPradamaiDaySRise.isNotEmpty()) {
                        val afterPradamaiDaySRiseTime = afterPradamaiDaySRise.split(" ")[0]
                        val afterPradamaiDaySRiseHour = afterPradamaiDaySRiseTime.split(":")[0].toInt()
                        val afterPradamaiDaySRiseMinutes = afterPradamaiDaySRiseTime.split(":")[1].toInt()
                        afterPradamaiSRiseHrAndMinConvInMinutes = afterPradamaiDaySRiseHour * 60 + afterPradamaiDaySRiseMinutes
                    }
                }
            }
        }
    } catch (e: Exception) { println(e) }

    private fun nextDayparseWeb() = try {
        val basicWeb = "https://www.drikpanchang.com/panchang/day-panchang.html?geoname-id=1264527&date="
        val nextDayWeb = (basicWeb + nextdy)
        Jsoup.connect(nextDayWeb).userAgent("Mozilla/5.0 (Linux; Android 13) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Mobile Safari/537.36").timeout(30000).followRedirects(true).ignoreHttpErrors(true).get().run {
            select("div.dpPHeaderWrapper").forEachIndexed { _, element ->
                val leftData4 = element.select("div.dpPHeaderLeftWrapper")
                for (key4 in leftData4) {
                    if (key4.select("div.dpPHeaderLeftContent").hasText()) {
                        val leftHeaderData4 = key4.text()
                        nextDaypakshaValue = leftHeaderData4.split(" ")[3]
                        nextDaypaksha = nextDaypakshaValue
                    }
                }
            }
            select("div.dpTableCardWrapper").forEachIndexed { _, element ->
                var isKey4 = false
                val anchor4 = element.select("div.dpTableCard")
                val dpCardRow4 = anchor4.select("div.dpTableCell")
                for (key4 in dpCardRow4) {
                    if (key4.getElementsByClass("dpTableKey").hasText()) { mapKey4 = key4.getElementsByClass("dpTableKey").text(); isKey4 = true }
                    if (key4.getElementsByClass("dpTableValue").hasText()) { if (isKey4) { DataList4 = key4.getElementsByClass("dpTableValue").text(); isKey4 = false } }
                    mapPanch4[mapKey4] = DataList4
                }
            }
            val nextDayTithiNew = (mapPanch4["Tithi"] ?: "")
            if (nextDayTithiNew.contains(" upto ")) {
                val nextDayTitiUpto0 = nextDayTithiNew.split(" upto ")[1]
                if ((nextDayTitiUpto0.split(" ")[0]) == "Full") {
                    nextDayTithiHrToMin = pradamaiDaySRiseInMinutes
                } else {
                    val nextDayselectTimeOnely = nextDayTitiUpto0.trim().split(" ")[0]
                    nextDayTitiUptoHrOnly = nextDayselectTimeOnely.split(":")[0].toInt()
                    val nextDayTitiUptoMinutesOnly = nextDayselectTimeOnely.split(":")[1].toInt()
                    val amPm = nextDayTitiUpto0.split(" ")[1]
                    nextDayTithiHrToMin = convertToMinutes(nextDayTitiUptoHrOnly, nextDayTitiUptoMinutesOnly, amPm)
                }
                thithiValuex = nextDayTithiNew.split(" upto ")[0]
                NextDayThithi = convertThithiToTamil(thithiValuex)
            }
            val nextDaySRise = (mapPanch4["Sunrise"] ?: "")
            if (nextDaySRise.isNotEmpty()) {
                val nextDaySRiseTime = nextDaySRise.split(" ")[0]
                val nextDaySRiseHr = nextDaySRiseTime.split(":")[0].toInt()
                val nextDaySRiseHMinutes = nextDaySRiseTime.split(":")[1].toInt()
                NextDaySunRiseTime = (nextDaySRiseHr * 60) + nextDaySRiseHMinutes
            }
            val nextDaySunNakshtra1 = mapPanch4["Nakshatra"]
            nextDayNakshatra = (nextDaySunNakshtra1 ?: "").split(" upto ")[0]
            val nextDayKarnm1 = mapPanch4["Karana"]
            nextDayKarnam = (nextDayKarnm1 ?: "").split(" upto ")[0]
            val nextDayYog0 = mapPanch4["Yoga"]
            nextDayYogam = (nextDayYog0 ?: "").split(" ")[0]
        }
    } catch (e: Exception) { println(e) }

    @Suppress("SENSELESS_COMPARISON")
    private fun parseWeb() = try {
        val basicWeb = "https://www.drikpanchang.com/panchang/day-panchang.html?geoname-id=1264527&date="
        val todayWeb = (basicWeb + dateNow)
        Jsoup.connect(todayWeb).userAgent("Mozilla/5.0 (Linux; Android 13) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/120.0.0.0 Mobile Safari/537.36").timeout(30000).followRedirects(true).ignoreHttpErrors(true).get().run {
            // Extract location from web page header
            val locationElement = select("span.dpHeaderLocationText")
            if (locationElement.hasText()) {
                place = locationElement.text()
            } else {
                place = "Chennai, India"
            }
            select("div.dpPHeaderWrapper").forEachIndexed { _, element ->
                val leftData = element.select("div.dpPHeaderLeftWrapper")
                for (key1 in leftData) {
                    if (key1.select("div.dpPHeaderLeftContent").hasText()) {
                        val leftHeaderData = key1.text()
                        TodayThithi = leftHeaderData.split(" ")[1]
                        todaypakshaValue = leftHeaderData.split(" ")[2]
                        todayPaksha = if (TodayThithi == "Purnima" || TodayThithi == "பௌர்ணமி") nextDaypaksha else todaypakshaValue
                        paksha = if (todayPaksha == "Shukla") "சுக்ல" else "க்ருஷ்ண"
                    }
                }
                val rightData = element.select("div.dpPHeaderRightContent")
                for (key2 in rightData) {
                    if (key2.select("div.dpPHeaderRightContent").hasText()) { dateToday = key2.text() }
                }
            }
            select("div.dpTableCardWrapper").forEachIndexed { _, element ->
                val sunAnchor = element.select("div.dpCard.dpFlexEqual")
                val dpSunRiseRow = sunAnchor.select("div.dpCardRow")
                for (key in dpSunRiseRow) {
                    if (key.select("span.dpTitle").hasText()) {
                        val dataSunMoon = key.text()
                        if (dataSunMoon.startsWith("Sunrise")) { sunRise = dataSunMoon }
                        else if (dataSunMoon.startsWith("Sunset")) { sunSet = dataSunMoon }
                    }
                }
                var isKey = false
                val anchor1 = element.select("div.dpTableCard")
                val dpCardRow1 = anchor1.select("div.dpTableCell")
                for (key in dpCardRow1) {
                    if (key.getElementsByClass("dpTableKey").hasText()) { mapKey = key.getElementsByClass("dpTableKey").text(); isKey = true }
                    if (key.getElementsByClass("dpTableValue").hasText()) { if (isKey) { DataList = key.getElementsByClass("dpTableValue").text(); isKey = false } }
                    mapPanch[mapKey] = DataList
                }
            }
            processSuryaRasi()
            processShakaSamvat()
            processYogam()
            processTithi()
            processSunrise()
            processSunset()
            processWeekday()
            processVedicAyana()
            processNakshatra()
            processKarana()
            processChandraMasa()
        }
    } catch (e: Exception) { println("Error Skipped $e") }

    private fun convertToMinutes(hour: Int, minutes: Int, amPm: String): Int {
        return when {
            amPm == "PM" -> { val hr = if (hour == 12) 12 else hour + 12; (hr * 60) + minutes }
            amPm == "PM," -> ((24 * 60) - nowTimeInMinutes) + 1440 + ((if (hour == 12) 12 else hour + 12) * 60) + minutes
            amPm == "AM" -> ((if (hour == 12) 0 else hour) * 60) + minutes
            amPm == "AM," -> { val hr = if (hour == 12) 0 else hour; ((24 * 60) - nowTimeInMinutes) + (hr * 60) + minutes }
            else -> 0
        }
    }

    private fun convertThithiToTamil(value: String): String {
        return when {
            value.contains("Amavasya") -> "அமாவாஸ்யா"
            value.contains("Pratipada") -> "பிரதமை"
            value.contains("Dwitiya") -> "த்விதியை"
            value.contains("Tritiya") -> "த்ருதியை"
            value.contains("Chaturthi") -> "சதுர்தி"
            value.contains("Panchami") -> "பஞ்சமி"
            value.contains("Shashthi") -> "ஷஷ்டி"
            value.contains("Saptami") -> "ஸப்தமி"
            value.contains("Ashtami") -> "அஷ்டமி"
            value.contains("Navami") -> "நவமி"
            value.contains("Dashami") -> "தஸமி"
            value.contains("Ekadashi") -> "ஏகாதஸி"
            value.contains("Dwadashi") -> "துவாதஸி"
            value.contains("Trayodashi") -> "த்ரயோதஸி"
            value.contains("Chaturdashi") -> "சதுர்தஸி"
            else -> "பௌர்ணமி"
        }
    }

    private fun processSuryaRasi() {
        val suRasi0A = mapPanch["Sunsign"]
        val suRasi0 = (suRasi0A ?: "").split(" ")[0]
        when {
            suRasi0.contains("Dhanu") -> { suryaRasi = "தநுர் (மார்கழி)"; vedicRithu = "ஹேமந்த" }
            suRasi0.contains("Makara") -> { suryaRasi = "மகர (தை)"; vedicRithu = "ஹேமந்த" }
            suRasi0.contains("Kumbha") -> { suryaRasi = "கும்ப (மாசி)"; vedicRithu = "சிசிர" }
            suRasi0.contains("Meena") -> { suryaRasi = "மீன (பங்குனி)"; vedicRithu = "சிசிர" }
            suRasi0.contains("Mesha") -> { suryaRasi = "மேஷ (சித்திரை)"; vedicRithu = "வஸந்த" }
            suRasi0.contains("Vrishabha") -> { suryaRasi = "வ்ருஷப (வைகாசி)"; vedicRithu = "வஸந்த" }
            suRasi0.contains("Mithuna") -> { suryaRasi = "மிதுன (ஆனி)"; vedicRithu = "க்ரீஷ்ம" }
            suRasi0.contains("Karka") -> { suryaRasi = "கர்கட (ஆடி)"; vedicRithu = "க்ரீஷ்ம" }
            suRasi0.contains("Simha") -> { suryaRasi = "ஸிம்ஹ (ஆவணி)"; vedicRithu = "வர்ஷ" }
            suRasi0.contains("Kanya") -> { suryaRasi = "கன்யா (புரட்டாசி)"; vedicRithu = "வர்ஷ" }
            suRasi0.contains("Tula") -> { suryaRasi = "துலா (ஐப்பசி)"; vedicRithu = "சரத்" }
            suRasi0.contains("Vrishchika") -> { suryaRasi = "வ்ருச்சிக (கார்த்திகை)"; vedicRithu = "சரத்" }
        }
    }

    private fun processShakaSamvat() {
        val tamyear = mapPanch["Shaka Samvat"]
        val tamYrValue = (tamyear ?: "").split(" ").getOrNull(1) ?: ""
        shakaSamvat = when {
            tamYrValue.contains("Shubhakrit") -> "சுபகிருது"
            tamYrValue.contains("Shobhakrit") -> "சோபகிருது"
            tamYrValue.contains("Krodhi") -> "குரோதி"
            tamYrValue.contains("Vishvavasu") -> "விசுவாசுவ"
            tamYrValue.contains("Parabhava") -> "பரபாவ"
            tamYrValue.contains("Plavanga") -> "பிலவங்க"
            tamYrValue.contains("Kilaka") -> "கீலக"
            tamYrValue.contains("Saumya") -> "சௌமிய"
            tamYrValue.contains("Sadharana") -> "சாதாரண"
            tamYrValue.contains("Paridhavi") -> "பரிதாபி"
            tamYrValue.contains("Pramathi") -> "பிரமாதீச"
            tamYrValue.contains("Aananda") -> "ஆனந்த"
            tamYrValue.contains("Rakshasa") -> "ராட்சச"
            tamYrValue.contains("Nala") -> "நள"
            tamYrValue.contains("Pingala") -> "பிங்கள"
            else -> tamYrValue
        }
    }

    private fun processYogam() {
        val yog0 = mapPanch["Yoga"]
        val yogaValue = (yog0 ?: "").split(" upto ")[0]
        if ((yog0 ?: "").contains(" upto ") && (yog0 ?: "").split(" ")[1] == "Full") {
            todayYogaUptoInMinutesM = NextDaySunRiseTime
        } else if ((yog0 ?: "").contains(" upto ")) {
            val yogaUptoTimeWithDay = (yog0 ?: "").split(" upto ")[1]
            val yogaUptoTime = yogaUptoTimeWithDay.split(" ")[0]
            val yogaUptoHrOnly = yogaUptoTime.split(":")[0].toInt()
            val yogaUptoMinutesOnly = yogaUptoTime.split(":")[1].toInt()
            val amPm = yogaUptoTimeWithDay.split(" ")[1]
            todayYogaUptoInMinutesM = convertToMinutes(yogaUptoHrOnly, yogaUptoMinutesOnly, amPm)
        }
        currentYogam = if (todayYogaUptoInMinutesM <= nowTimeInMinutes) nextDayYogam else yogaValue
        yoga = convertYogamToTamil(currentYogam)
    }

    private fun convertYogamToTamil(value: String): String {
        return when {
            value.contains("Vishkambha") -> "விஷ்கம்பா"
            value.contains("Priti") -> "ப்ரீதி"
            value.contains("Ayushman") -> "ஆயுஷ்மான்"
            value.contains("Saubhagya") -> "ஸௌபாக்யா"
            value.contains("Shobhana") -> "ஷோபனா"
            value.contains("Atiganda") -> "அதிகண்டா"
            value.contains("Sukarman") -> "சுகர்மன்"
            value.contains("Dhriti") -> "த்ரீதி"
            value.contains("Shula") -> "ஷூலா"
            value.contains("Ganda") -> "கண்டா"
            value.contains("Vriddhi") -> "வ்ருத்தி"
            value.contains("Dhruva") -> "த்ருவா"
            value.contains("Vyaghata") -> "வ்யாகதா"
            value.contains("Harshana") -> "ஹர்ஷாநா"
            value.contains("Vajra") -> "வஜ்ரா"
            value.contains("Siddhi") -> "ஸித்தி"
            value.contains("Vyatipata") -> "வ்யாதிபாடா"
            value.contains("Parigha") -> "பரீகா"
            value.contains("Shiva") -> "ஷிவா"
            value.contains("Siddha") -> "சித்தா"
            value.contains("Sadhya") -> "சட்யா"
            value.contains("Shubha") -> "ஷுபா"
            value.contains("Shukla") -> "சுக்லா"
            value.contains("Brahma") -> "ப்ரஹ்மா"
            value.contains("Indra") -> "இந்தரா"
            value.contains("Vaidhriti") -> "வைதீரிடீ"
            else -> value
        }
    }

    private fun processTithi() {
        tithiNew = (mapPanch["Tithi"] ?: "")
        if (tithiNew.contains(" upto ")) {
            val tThitiAfterUpto = tithiNew.split(" upto ")[1]
            if ((tThitiAfterUpto.split(" ")[0]) == "Full") {
                TodayThithiUptoInMinutesM = NextDaySunRiseTime
            } else {
                val selectTimeOnely = tThitiAfterUpto.split(" ")[0]
                todatTitiUptoHrOnly = selectTimeOnely.split(":")[0].toInt()
                val tThithiUptoMinutesOnly = selectTimeOnely.split(":")[1].toInt()
                val amPm = tThitiAfterUpto.split(" ")[1]
                TodayThithiUptoInMinutesM = convertToMinutes(todatTitiUptoHrOnly, tThithiUptoMinutesOnly, amPm)
            }
            TithiValue = tithiNew.split(" ")[0]
            currentTithi = if (TodayThithiUptoInMinutesM <= nowTimeInMinutes) NextDayThithi else TithiValue
            ThithiGlobal = convertThithiToTamil(currentTithi)
        }
    }

    private fun processSunrise() {
        val sRise = mapPanch["Sunrise"]
        val sRise0 = (sRise ?: "").split(" ")[0]
        if (sRise0.contains(":")) {
            val sRise3 = sRise0.split(":")[0].toInt()
            sRiseInMinutes = sRise3 * 60 + sRise0.split(":")[1].toInt()
            val hrvalue = sRise3 + 12
            val hrToMin = hrvalue * 60
            val minvalue = sRise0.split(":")[1].toInt()
            SunRiseTo30NaligaiInMinutes = hrToMin + minvalue
        }
        val twelveHrInMin = 12 * 60
        fromSunRiseToTwelveHrs = pradamaiDaySRiseInMinutes + twelveHrInMin
        if (pradamaiDayTitiUptoHrOnly >= 12) { pradamaiDayTitiUptoHrOnly -= 12 }
        pradamaiThithiUptoInMinutes = pradamaiDayTitiUptoHrOnly * 60
    }

    private fun processSunset() {
        val sSet = (mapPanch["Sunset"] ?: "")
        if (sSet.isNotEmpty()) {
            val sSetTime = sSet.split(" ")[0]
            val sSetHur = sSetTime.split(":")[0].toInt()
            val sSetMinu = sSetTime.split(":")[1].toInt()
            val sSetHrFinal = sSetHur + 12
            SSetInMinutes = sSetHrFinal * 60 + sSetMinu
        }
    }

    private fun processWeekday() {
        val weekDy = (mapPanch["Weekday"] ?: "")
        weekDay = when {
            weekDy.contains("Somawara") -> "இந்து"
            weekDy.contains("Mangalawara") -> "பௌம"
            weekDy.contains("Budhawara") -> "ஸௌம்ய"
            weekDy.contains("Guruwara") -> "குரு"
            weekDy.contains("Shukrawara") -> "ப்ருகு"
            weekDy.contains("Shaniwara") -> "ஸ்திர"
            weekDy.contains("Raviwara") -> "பாநு"
            else -> ""
        }
    }

    private fun processVedicAyana() {
        val vedAyanam = mapPanch["Vedic Ayana"]
        vedicAyana = if ((vedAyanam ?: "").contains("Dakshi")) "தக்ஷிணாயணே" else "உத்தராயணே"
    }

    private fun processNakshatra() {
        val sunNakshtra1 = mapPanch["Nakshatra"]
        if ((sunNakshtra1 ?: "").contains(" upto ")) {
            val nakshatravalue = (sunNakshtra1 ?: "").split(" upto ")[0]
            val sunNakshatraValue = (sunNakshtra1 ?: "").split(" upto ")[1]
            if (sunNakshatraValue.split(" ")[0] == "Full") {
                nakshatraHrToMin = NextDaySunRiseTime
            } else {
                val nakshaUptoTime = sunNakshatraValue.split(" ")[0]
                val nakshaUptoHrOnly = nakshaUptoTime.split(":")[0].toInt()
                val nakshaUptoMinutesOnly = nakshaUptoTime.split(":")[1].toInt()
                val amPm = sunNakshatraValue.split(" ")[1]
                nakshatraHrToMin = convertToMinutes(nakshaUptoHrOnly, nakshaUptoMinutesOnly, amPm)
            }
            currentNakshtram = if (nakshatraHrToMin <= nowTimeInMinutes) nextDayNakshatra else nakshatravalue
            naksha = convertNakshatraToTamil(currentNakshtram)
        }
    }

    private fun convertNakshatraToTamil(value: String): String {
        return when {
            value.contains("Ashwini") -> "அஞ்வினி"
            value.contains("Bharani") -> "அபபரணீ"
            value.contains("Krittika") -> "க்ருத்திகா"
            value.contains("Rohini") -> "ரோஹிணீ"
            value.contains("Mrigashirsha") -> "ம்ருகசீர்ஷ"
            value.contains("Ardra") -> "ஆர்த்ரா"
            value.contains("Punarvasu") -> "புனர்வசு"
            value.contains("Pushya") -> "புஷ்ய"
            value.contains("Ashlesha") -> "ஆச்'லேஷா'"
            value.contains("Magha") -> "மகா"
            value.contains("Purva Phalguni") -> "பூர்வ பல்குநீ"
            value.contains("Uttara Phalguni") -> "உத்தர பல்குநீ"
            value.contains("Hasta") -> "ஹஸ்த"
            value.contains("Chitra") -> "சித்ரா"
            value.contains("Swati") -> "ஸ்வாதீ"
            value.contains("Vishakha") -> "விசாகா"
            value.contains("Anuradha") -> "அநுராதா"
            value.contains("Jyeshtha") -> "ஜ்யேஷ்டா"
            value.contains("Mula") -> "மூலா"
            value.contains("Purva Ashadha") -> "பூர்வ ஆஷாடா"
            value.contains("Uttara Ashadha") -> "உத்தர ஆஷாடா"
            value.contains("Shravana") -> "ஞ்ரவண"
            value.contains("Dhanishtha") -> "ஞ்ரவிஷ்டா"
            value.contains("Shatabhisha") -> "சதபிஷக்"
            value.contains("Purva Bhadrapada") -> "பூர்வ ப்ரோஷ்டபதா"
            value.contains("Uttara Bhadrapada") -> "உத்தர ப்ரோஷ்டபதா"
            value.contains("Revati") -> "ரேவதீ"
            else -> value
        }
    }

    private fun processKarana() {
        val karnm1 = mapPanch["Karana"]
        if ((karnm1 ?: "").contains(" upto ")) {
            val karnaValue = (karnm1 ?: "").split(" upto ")[0]
            val karnaValueAfterUpto = (karnm1 ?: "").split(" upto ")[1]
            if (karnaValueAfterUpto.split(" ")[0] == "Full") {
                karnaHrToMin = NextDaySunRiseTime
            } else {
                val karnaUptoTime = karnaValueAfterUpto.split(" ")[0]
                val karnaUptoHrOnly = karnaUptoTime.split(":")[0].toInt()
                val karnaUptoMinutesOnly = karnaUptoTime.split(":")[1].toInt()
                val amPm = karnaValueAfterUpto.split(" ")[1]
                karnaHrToMin = convertToMinutes(karnaUptoHrOnly, karnaUptoMinutesOnly, amPm)
            }
            currentKarnam = if (karnaHrToMin <= nowTimeInMinutes) nextDayKarnam else karnaValue
            karana = convertKaranaToTamil(currentKarnam)
        }
    }

    private fun convertKaranaToTamil(value: String): String {
        return when {
            value.contains("Garaja") -> "கரஜ"
            value.contains("Balava") -> "பாலவ"
            value.contains("Taitila") -> "தைத்தில"
            value.contains("Vishti") -> "விஷ்டி"
            value.contains("Vanija") -> "வநிஜா"
            value.contains("Bava") -> "பாவா"
            value.contains("Kaulava") -> "கௌலவ"
            value.contains("Nagava") -> "நாகவா"
            value.contains("Shakuni") -> "ஷகுணி"
            value.contains("Chatushpada") -> "ச்சடுஷ்பாடா"
            value.contains("Kinstughna") -> "கின்ஸ்டுக்ணா"
            else -> value
        }
    }

    private fun processChandraMasa() {
        val chandMasa = (mapPanch["Chandramasa"] ?: "")
        chandraMasa = chandMasa.split(" ")[0]
        val chandRasi = (mapPanch["Moonsign"] ?: "")
        chandraRasi = chandRasi.split(" ")[0]
        val surNak = mapPanch["Surya Nakshatra"]
        suryaNakshatra = (surNak ?: "").split(" ")[0]
        madyana = (mapPanch["Madhyahna"] ?: "")
        prathaSanthya = (mapPanch["Pratah Sandhya"] ?: "")
        sayamSandya = (mapPanch["Sayahna Sandhya"] ?: "")
    }

    private fun updateUITexts() {
                // Stop the blinking Loading animation
        loadingAnimator?.cancel()
        loadingAnimator = null
        val titiText = "<font color='#228B22'>திதி (Thithi):-</font> <font color='#00008B'>$ThithiGlobal</font>"
        tvTodThithi.text = Html.fromHtml(titiText, Html.FROM_HTML_MODE_LEGACY)
        val paktext = "<font color='#228B22'>பக்ஷம் (Paksha):-</font> <font color='#00008B'>$paksha</font>"
        tvBaksham.text = Html.fromHtml(paktext, Html.FROM_HTML_MODE_LEGACY)
        val rasitext = "<font color='#228B22'>ராசி (Rasi):-</font> <font color='#00008B'>$suryaRasi</font>"
        tvRasee.text = Html.fromHtml(rasitext, Html.FROM_HTML_MODE_LEGACY)
        val placeText = "<font color='#228B22'>இடம் (GeoLocation):-</font> <font color='#00008B'>$place</font>"
        tvGeoLocation.text = Html.fromHtml(placeText, Html.FROM_HTML_MODE_LEGACY)
        val yearText = "<font color='#228B22'>வருடம் (Year):-</font> <font color='#00008B'>$shakaSamvat</font>"
        tvVarusham.text = Html.fromHtml(yearText, Html.FROM_HTML_MODE_LEGACY)
        val yogaText = "<font color='#228B22'>யோகம் (Yogam):-</font> <font color='#00008B'>$yoga</font>"
        tvYog.text = Html.fromHtml(yogaText, Html.FROM_HTML_MODE_LEGACY)
        val ruthuText = "<font color='#228B22'>ருது (Season-காலம்):-</font> <font color='#00008B'>$vedicRithu</font>"
        tvKalam.text = Html.fromHtml(ruthuText, Html.FROM_HTML_MODE_LEGACY)
        val ayanaText = "<font color='#228B22'>அயனம் (Ayana):-</font> <font color='#00008B'>$vedicAyana</font>"
        tvAyyanamm.text = Html.fromHtml(ayanaText, Html.FROM_HTML_MODE_LEGACY)
        val wDayText = "<font color='#228B22'>கிழமை (Day):-</font> <font color='#00008B'>$weekDay</font>"
        tvKizhamai.text = Html.fromHtml(wDayText, Html.FROM_HTML_MODE_LEGACY)
        val nakshText = "<font color='#228B22'>நட்ஷத்ரம் (Natchatram):-</font> <font color='#00008B'>$naksha</font>"
        tvNachathirm.text = Html.fromHtml(nakshText, Html.FROM_HTML_MODE_LEGACY)
        val karanaText = "<font color='#228B22'>கரணம் (Karanam):-</font> <font color='#00008B'>$karana</font>"
        tvKar.text = Html.fromHtml(karanaText, Html.FROM_HTML_MODE_LEGACY)
    }

    fun clearAllData() {
        tithiNew = ""
        ThithiGlobal = ""
        SkippedThithiGlobal = ""
        TithiValue = ""
        TodayThithi = ""
        NextDayThithi = ""
        pradamaiTithiValue = ""
        pradamaiDayThithi = ""
        mapPanch.clear()
        mapPanch2.clear()
        mapPanch3.clear()
        mapPanch4.clear()
    }
}
