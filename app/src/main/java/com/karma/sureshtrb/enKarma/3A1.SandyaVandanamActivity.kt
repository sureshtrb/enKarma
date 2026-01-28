package com.karma.sureshtrb.enKarma

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.pdf.PdfDocument
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CancellationSignal
import android.os.ParcelFileDescriptor
import android.print.*
import android.print.pdf.PrintedPdfDocument
import androidx.annotation.RequiresApi
import android.text.*
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.text.style.UnderlineSpan
import android.widget.Button
import com.karma.sureshtrb.enKarma.databinding.ActivitySandyaVandanamBinding
import com.parse.ParseUser
import java.io.FileOutputStream
import java.io.IOException

class SandyaVandanamActivity : AppCompatActivity() {

    @SuppressLint("WrongViewCast")
    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(Build.VERSION_CODES.KITKAT)

    var exExFlag = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
    var incIncFlag = Spanned.SPAN_INCLUSIVE_INCLUSIVE
    var start: Int = 0
    var sandyaType: String = ""
    var pravarasYour: String = ""
    var gothramYour: String = ""
    var nameYour: String = ""

    var totalpages: Int = 1
    var pageOneText: kotlin.CharSequence? =null
    var pageTwoText: kotlin.CharSequence? = null
    var pageThreeText: kotlin.CharSequence? = null
    var pageFourText: kotlin.CharSequence? = null
    var pageFiveText: kotlin.CharSequence? = null
    var pageSixText: kotlin.CharSequence? = null
    var pageSevenText: kotlin.CharSequence? = null
    var pageEightText: kotlin.CharSequence? = null
    var pageNineText: kotlin.CharSequence? = null
    var pageTenText: kotlin.CharSequence? = null
    var pageElevenText: kotlin.CharSequence? = null
    var pageTwelveText: kotlin.CharSequence? = null
    var pageThirteenText: kotlin.CharSequence? = null
    var pageFourteenText: kotlin.CharSequence? = null
    var pageFifteenText: kotlin.CharSequence? = null
    var pageSixteenText: kotlin.CharSequence? = null
    var pageSeventeenText: kotlin.CharSequence? = null

    var startPos1 = 0
    var startPos2 = 0
    var startPos3 = 0
    var startPos4 = 0
    var startPos5 = 0
    var startPos6 = 0
    var startPos7 = 0
    var startPos8 = 0
    var startPos9 = 0
    var startPos10 = 0
    var startPos11 = 0
    var startPos12 = 0
    var startPos13 = 0
    var startPos14 = 0
    var startPos15 = 0
    var startPos16 = 0
    var startPos17 = 0
    var endPos1 = 0
    var endPos2 = 0
    var endPos3 = 0
    var endPos4 = 0
    var endPos5 = 0
    var endPos6 = 0
    var endPos7 = 0
    var endPos8 = 0
    var endPos9 = 0
    var endPos10 = 0
    var endPos11 = 0
    var endPos12 = 0
    var endPos13 = 0
    var endPos14 = 0
    var endPos15 = 0
    var endPos16 = 0
    var endPos17 = 0
    private lateinit var binding: ActivitySandyaVandanamBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySandyaVandanamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.printButton
        binding.sandyaVandanamTextView.text
        
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.home)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.subtitle = "ஸந்த்யாவந்தனம்"
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setLogo(R.drawable.karma)
        supportActionBar!!.setDisplayUseLogoEnabled(true)

        val intent = intent
        sandyaType = intent.getStringExtra("sandhi").toString()
        println("sandyaType : $sandyaType")
        pravarasYour = intent.getStringExtra("pravaras").toString()
        println("pravarasYour : $pravarasYour")
        gothramYour = intent.getStringExtra("gothram").toString()
        println("gothramYour : $gothramYour")
        nameYour = intent.getStringExtra("name").toString()
        println("nameYour : $nameYour")

        val heading = SpannableString("$sandyaType - $nameYour\n")

        val hdSt1 = SpannableString("குரு வந்தனம்\n")
        hdSt1.setSpan(AbsoluteSizeSpan(14, true), start, hdSt1.length, exExFlag)
        hdSt1.setSpan(StyleSpan(Typeface.BOLD), start, hdSt1.length, exExFlag)
        hdSt1.setSpan(UnderlineSpan(), start, hdSt1.length, exExFlag)
        hdSt1.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, hdSt1.length, exExFlag)

        val bdSt0 = SpannableString("வந்தேஹம் மங்காளத்மாநம்|\nபாஸ்வந்தம் வேதவிக்ரஹம் |\nயாக்ஞ வல்க்யம் முநிச்ரேஷ்டம்\n" +
                "ஜிஷ்ணும் ஹரிஹரப்ரபம் |\nஜிதேந்த்ரியம் ஜிதக்ரோதம்\nஸதாத்யாந பராயணம்|\nஆனந்த நிலயம் வந்தே\nயோகாநந்தம் முநீஸ்வரம் |\n")
        bdSt0.setSpan(AbsoluteSizeSpan(14, true), start, bdSt0.length, exExFlag)
        bdSt0.setSpan(StyleSpan(Typeface.BOLD), start, bdSt0.length, exExFlag)
        bdSt0.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt0.length, exExFlag)

        val comSt1A = SpannableString("(காலை- கிழக்கு முகமாக இருந்து)\n")
        comSt1A.setSpan(AbsoluteSizeSpan(13, true), start, comSt1A.length, exExFlag)
        comSt1A.setSpan(StyleSpan(Typeface.ITALIC), start, comSt1A.length, exExFlag)
        comSt1A.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt1A.length, exExFlag)

        val comSt1B = SpannableString("(மதியம் - கிழக்கு முகமாக இருந்து)\n")
        comSt1B.setSpan(AbsoluteSizeSpan(13, true), start, comSt1B.length, exExFlag)
        comSt1B.setSpan(StyleSpan(Typeface.ITALIC), start, comSt1B.length, exExFlag)
        comSt1B.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt1B.length, exExFlag)

        val comSt1C = SpannableString("(மாலை - வடக்கு முகமாக இருந்து)\n")
        comSt1C.setSpan(AbsoluteSizeSpan(13, true), start, comSt1C.length, exExFlag)
        comSt1C.setSpan(StyleSpan(Typeface.ITALIC), start, comSt1C.length, exExFlag)
        comSt1C.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt1C.length, exExFlag)
        //==============================================================================================================
        val hdSt2AC = SpannableString("ப்ரோக்ஷணம்")
        hdSt2AC.setSpan(AbsoluteSizeSpan(14, true), start, hdSt2AC.length, exExFlag)
        hdSt2AC.setSpan(StyleSpan(Typeface.BOLD), start, hdSt2AC.length, exExFlag)
        hdSt2AC.setSpan(UnderlineSpan(), start, hdSt2AC.length, exExFlag)
        hdSt2AC.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start,  hdSt2AC.length, exExFlag)

        val comSt2AC = SpannableString("\n(ஒவ்வொரு உத்தரிணி ஜலம் எடுத்து வலது கையில் விட்டு ஒவ்வொரு மந்திரத்துக்கும் " +
                "உட்கொள்ளவும்)")
        comSt2AC.setSpan(AbsoluteSizeSpan(13,true),start,comSt2AC.length,exExFlag)
        comSt2AC.setSpan(StyleSpan(Typeface.ITALIC), start, comSt2AC.length, exExFlag)
        comSt2AC.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt2AC.length,exExFlag)

        val bdSt1AC = SpannableString("- ஓம் அச்யுதாய நம: |  ஓம் அனந்தாய நம: |  ஓம் கோவிந்தாய நம: ||")
        bdSt1AC.setSpan(AbsoluteSizeSpan(14, true), start, bdSt1AC.length, exExFlag)
        bdSt1AC.setSpan(StyleSpan(Typeface.BOLD), start, bdSt1AC.length, exExFlag)
        bdSt1AC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt1AC.length, exExFlag)

        val comSt3AC = SpannableString("\n(ஒரு உத்தரிணி ஜலம் எடுத்து வலது கையில் விட்டு கீழே விடவும்)")
        comSt3AC.setSpan(AbsoluteSizeSpan(13,true),start,comSt3AC.length,exExFlag)
        comSt3AC.setSpan(StyleSpan(Typeface.ITALIC), start, comSt3AC.length, exExFlag)
        comSt3AC.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt3AC.length,exExFlag)

        val bdSt2AC = SpannableString("- அபஉபஸ்ப்ருஸ்ய ||\n")
        bdSt2AC.setSpan(AbsoluteSizeSpan(14, true), start, bdSt2AC.length, exExFlag)
        bdSt2AC.setSpan(StyleSpan(Typeface.BOLD), start, bdSt2AC.length, exExFlag)
        bdSt2AC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt2AC.length, exExFlag)

        val comSt4AC = SpannableString("\n(வலது கட்டை விரலால் வாயை துடைத்துக் கொள்ளவும்)\n(விரல்களால் அங்கங்களை " +
                "தொடவும்)\n(நடு+மோதிர விரல்)-வலது கன்னம்")
        comSt4AC.setSpan(AbsoluteSizeSpan(13,true),start,comSt4AC.length,exExFlag)
        comSt4AC.setSpan(StyleSpan(Typeface.ITALIC), start, comSt4AC.length, exExFlag)
        comSt4AC.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt4AC.length,exExFlag)

        val bdSt3AC = SpannableString("- கேசவா")
        bdSt3AC.setSpan(AbsoluteSizeSpan(14, true), start, bdSt3AC.length, exExFlag)
        bdSt3AC.setSpan(StyleSpan(Typeface.BOLD), start, bdSt3AC.length, exExFlag)
        bdSt3AC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt3AC.length, exExFlag)

        val comSt5AC = SpannableString("\n(நடு+மோதிர விரல்)-இடது கன்னம்")
        comSt5AC.setSpan(AbsoluteSizeSpan(13,true),start,comSt5AC.length,exExFlag)
        comSt5AC.setSpan(StyleSpan(Typeface.ITALIC), start, comSt5AC.length, exExFlag)
        comSt5AC.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt5AC.length,exExFlag)

        val bdSt4AC = SpannableString("- நாராயணா")
        bdSt4AC.setSpan(AbsoluteSizeSpan(14, true), start, bdSt4AC.length, exExFlag)
        bdSt4AC.setSpan(StyleSpan(Typeface.BOLD), start, bdSt4AC.length, exExFlag)
        bdSt4AC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt4AC.length, exExFlag)

        val comSt6AC = SpannableString("\n(ஆள்காட்டி+கட்டை விரல்)-வலது மூக்கு")
        comSt6AC.setSpan(AbsoluteSizeSpan(13,true),start,comSt6AC.length,exExFlag)
        comSt6AC.setSpan(StyleSpan(Typeface.ITALIC), start, comSt6AC.length, exExFlag)
        comSt6AC.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt6AC.length,exExFlag)

        val bdSt5AC = SpannableString("- மாதவா")
        bdSt5AC.setSpan(AbsoluteSizeSpan(14, true), start, bdSt5AC.length, exExFlag)
        bdSt5AC.setSpan(StyleSpan(Typeface.BOLD), start, bdSt5AC.length, exExFlag)
        bdSt5AC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt5AC.length, exExFlag)

        val comSt7AC = SpannableString("\n(ஆள்காட்டி+கட்டை விரல்)-இடது மூக்கு")
        comSt7AC.setSpan(AbsoluteSizeSpan(13,true),start,comSt7AC.length,exExFlag)
        comSt7AC.setSpan(StyleSpan(Typeface.ITALIC), start, comSt7AC.length, exExFlag)
        comSt7AC.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt7AC.length,exExFlag)

        val bdSt6AC = SpannableString("- கோவிந்தா")
        bdSt6AC.setSpan(AbsoluteSizeSpan(14, true), start, bdSt6AC.length, exExFlag)
        bdSt6AC.setSpan(StyleSpan(Typeface.BOLD), start, bdSt6AC.length, exExFlag)
        bdSt6AC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt6AC.length, exExFlag)

        val comSt8AC = SpannableString("\n(நடு+கட்டை விரல்)-வலது கண்")
        comSt8AC.setSpan(AbsoluteSizeSpan(13,true),start,comSt8AC.length,exExFlag)
        comSt8AC.setSpan(StyleSpan(Typeface.ITALIC), start, comSt8AC.length, exExFlag)
        comSt8AC.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt8AC.length,exExFlag)

        val bdSt7AC = SpannableString("- விஷ்ணு")
        bdSt7AC.setSpan(AbsoluteSizeSpan(14, true), start, bdSt7AC.length, exExFlag)
        bdSt7AC.setSpan(StyleSpan(Typeface.BOLD), start, bdSt7AC.length, exExFlag)
        bdSt7AC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt7AC.length, exExFlag)

        val comSt9AC = SpannableString("\n(நடு+கட்டை விரல்)-இடது கண்")
        comSt9AC.setSpan(AbsoluteSizeSpan(13,true),start,comSt9AC.length,exExFlag)
        comSt9AC.setSpan(StyleSpan(Typeface.ITALIC), start, comSt9AC.length, exExFlag)
        comSt9AC.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt9AC.length,exExFlag)

        val bdSt8AC = SpannableString("- மதுஸூதனா")
        bdSt8AC.setSpan(AbsoluteSizeSpan(14, true), start, bdSt8AC.length, exExFlag)
        bdSt8AC.setSpan(StyleSpan(Typeface.BOLD), start, bdSt8AC.length, exExFlag)
        bdSt8AC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt8AC.length, exExFlag)

        val comSt10AC = SpannableString("\n(மோதிர+கட்டை விரல்)-வலது காது")
        comSt10AC.setSpan(AbsoluteSizeSpan(13,true),start,comSt10AC.length,exExFlag)
        comSt10AC.setSpan(StyleSpan(Typeface.ITALIC), start, comSt10AC.length, exExFlag)
        comSt10AC.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt10AC.length,exExFlag)

        val bdSt9AC = SpannableString("- த்ரிவிக்ரமா")
        bdSt9AC.setSpan(AbsoluteSizeSpan(14, true), start, bdSt9AC.length, exExFlag)
        bdSt9AC.setSpan(StyleSpan(Typeface.BOLD), start, bdSt9AC.length, exExFlag)
        bdSt9AC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt9AC.length, exExFlag)

        val comSt11AC = SpannableString("\n(மோதிர+கட்டை விரல்)-இடது காது")
        comSt11AC.setSpan(AbsoluteSizeSpan(13,true),start,comSt11AC.length,exExFlag)
        comSt11AC.setSpan(StyleSpan(Typeface.ITALIC), start, comSt11AC.length, exExFlag)
        comSt11AC.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt11AC.length,exExFlag)

        val bdSt10AC = SpannableString("- வாமனா")
        bdSt10AC.setSpan(AbsoluteSizeSpan(14, true), start, bdSt10AC.length, exExFlag)
        bdSt10AC.setSpan(StyleSpan(Typeface.BOLD), start, bdSt10AC.length, exExFlag)
        bdSt10AC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt10AC.length, exExFlag)

        val comSt12AC = SpannableString("\n(வலது உள்ளங்கை)-மார்பு")
        comSt12AC.setSpan(AbsoluteSizeSpan(13,true),start,comSt12AC.length,exExFlag)
        comSt12AC.setSpan(StyleSpan(Typeface.ITALIC), start, comSt12AC.length, exExFlag)
        comSt12AC.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt12AC.length,exExFlag)

        val bdSt11AC = SpannableString("- ஸ்ரீதரா")
        bdSt11AC.setSpan(AbsoluteSizeSpan(14, true), start, bdSt11AC.length, exExFlag)
        bdSt11AC.setSpan(StyleSpan(Typeface.BOLD), start, bdSt11AC.length, exExFlag)
        bdSt11AC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt11AC.length, exExFlag)

        val comSt13AC = SpannableString("\n(ஐந்து விரல் நுனி)-முன் தலை")
        comSt13AC.setSpan(AbsoluteSizeSpan(13,true),start,comSt13AC.length,exExFlag)
        comSt13AC.setSpan(StyleSpan(Typeface.ITALIC), start, comSt13AC.length, exExFlag)
        comSt13AC.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt13AC.length,exExFlag)

        val bdSt12AC = SpannableString("- ஹ்ருஷீகேஷா")
        bdSt12AC.setSpan(AbsoluteSizeSpan(14, true), start, bdSt12AC.length, exExFlag)
        bdSt12AC.setSpan(StyleSpan(Typeface.BOLD), start, bdSt12AC.length, exExFlag)
        bdSt12AC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt12AC.length, exExFlag)

        val comSt14AC = SpannableString("\n(ஐந்து விரல் நுனி)-வலது தோள்")
        comSt14AC.setSpan(AbsoluteSizeSpan(13,true),start,comSt14AC.length,exExFlag)
        comSt14AC.setSpan(StyleSpan(Typeface.ITALIC), start, comSt14AC.length, exExFlag)
        comSt14AC.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt14AC.length,exExFlag)

        val bdSt13AC = SpannableString("- பத்மநாபா")
        bdSt13AC.setSpan(AbsoluteSizeSpan(14, true), start, bdSt13AC.length, exExFlag)
        bdSt13AC.setSpan(StyleSpan(Typeface.BOLD), start, bdSt13AC.length, exExFlag)
        bdSt13AC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt13AC.length, exExFlag)

        val comSt15AC = SpannableString("\n(ஐந்து விரல் நுனி)-இடது தோள்")
        comSt15AC.setSpan(AbsoluteSizeSpan(13,true),start,comSt15AC.length,exExFlag)
        comSt15AC.setSpan(StyleSpan(Typeface.ITALIC), start, comSt15AC.length, exExFlag)
        comSt15AC.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt15AC.length,exExFlag)

        val bdSt14AC = SpannableString("- தாமோதரா\n")
        bdSt14AC.setSpan(AbsoluteSizeSpan(14, true), start, bdSt14AC.length, exExFlag)
        bdSt14AC.setSpan(StyleSpan(Typeface.BOLD), start, bdSt14AC.length, exExFlag)
        bdSt14AC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt14AC.length, exExFlag)
        //==============================================================================================================
        val comSt2ACA = SpannableString("(ஒவ்வொரு உத்தரிணி ஜலம் எடுத்து வலது கையில் விட்டு ஒவ்வொரு மந்திரத்துக்கும் " +
                "உட்கொள்ளவும்)")
        comSt2ACA.setSpan(AbsoluteSizeSpan(13,true),start,comSt2ACA.length,exExFlag)
        comSt2ACA.setSpan(StyleSpan(Typeface.ITALIC), start, comSt2ACA.length, exExFlag)
        comSt2ACA.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt2ACA.length,exExFlag)

        val bdSt1ACA = SpannableString("- ஓம் அச்யுதாய நம: |  ஓம் அனந்தாய நம: |  ஓம் கோவிந்தாய நம: ||")
        bdSt1ACA.setSpan(AbsoluteSizeSpan(14, true), start, bdSt1ACA.length, exExFlag)
        bdSt1ACA.setSpan(StyleSpan(Typeface.BOLD), start, bdSt1ACA.length, exExFlag)
        bdSt1ACA.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt1ACA.length, exExFlag)

        val comSt3ACA = SpannableString("\n(ஒரு உத்தரிணி ஜலம் எடுத்து வலது கையில் விட்டு கீழே விடவும்)")
        comSt3ACA.setSpan(AbsoluteSizeSpan(13,true),start,comSt3ACA.length,exExFlag)
        comSt3ACA.setSpan(StyleSpan(Typeface.ITALIC), start, comSt3ACA.length, exExFlag)
        comSt3ACA.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt3ACA.length,exExFlag)

        val bdSt2ACA = SpannableString("- அபஉபஸ்ப்ருஸ்ய ||\n")
        bdSt2ACA.setSpan(AbsoluteSizeSpan(14, true), start, bdSt2ACA.length, exExFlag)
        bdSt2ACA.setSpan(StyleSpan(Typeface.BOLD), start, bdSt2ACA.length, exExFlag)
        bdSt2ACA.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt2ACA.length, exExFlag)

        val comSt4ACA = SpannableString("\n(வலது கட்டை விரலால் வாயை துடைத்துக் கொள்ளவும்)\n(விரல்களால் அங்கங்களை " +
                "தொடவும்)\n(நடு+மோதிர விரல்)-வலது கன்னம்")
        comSt4ACA.setSpan(AbsoluteSizeSpan(13,true),start,comSt4ACA.length,exExFlag)
        comSt4ACA.setSpan(StyleSpan(Typeface.ITALIC), start, comSt4ACA.length, exExFlag)
        comSt4ACA.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt4ACA.length,exExFlag)

        val bdSt3ACA = SpannableString("- கேசவா")
        bdSt3ACA.setSpan(AbsoluteSizeSpan(14, true), start, bdSt3ACA.length, exExFlag)
        bdSt3ACA.setSpan(StyleSpan(Typeface.BOLD), start, bdSt3ACA.length, exExFlag)
        bdSt3ACA.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt3ACA.length, exExFlag)

        val comSt5ACA = SpannableString("\n(நடு+மோதிர விரல்)-இடது கன்னம்")
        comSt5ACA.setSpan(AbsoluteSizeSpan(13,true),start,comSt5ACA.length,exExFlag)
        comSt5ACA.setSpan(StyleSpan(Typeface.ITALIC), start, comSt5ACA.length, exExFlag)
        comSt5ACA.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt5ACA.length,exExFlag)

        val bdSt4ACA = SpannableString("- நாராயணா")
        bdSt4ACA.setSpan(AbsoluteSizeSpan(14, true), start, bdSt4ACA.length, exExFlag)
        bdSt4ACA.setSpan(StyleSpan(Typeface.BOLD), start, bdSt4ACA.length, exExFlag)
        bdSt4ACA.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt4ACA.length, exExFlag)

        val comSt6ACA = SpannableString("\n(ஆள்காட்டி+கட்டை விரல்)-வலது மூக்கு")
        comSt6ACA.setSpan(AbsoluteSizeSpan(13,true),start,comSt6ACA.length,exExFlag)
        comSt6ACA.setSpan(StyleSpan(Typeface.ITALIC), start, comSt6ACA.length, exExFlag)
        comSt6ACA.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt6ACA.length,exExFlag)

        val bdSt5ACA = SpannableString("- மாதவா")
        bdSt5ACA.setSpan(AbsoluteSizeSpan(14, true), start, bdSt5ACA.length, exExFlag)
        bdSt5ACA.setSpan(StyleSpan(Typeface.BOLD), start, bdSt5ACA.length, exExFlag)
        bdSt5ACA.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt5ACA.length, exExFlag)

        val comSt7ACA = SpannableString("\n(ஆள்காட்டி+கட்டை விரல்)-இடது மூக்கு")
        comSt7ACA.setSpan(AbsoluteSizeSpan(13,true),start,comSt7ACA.length,exExFlag)
        comSt7ACA.setSpan(StyleSpan(Typeface.ITALIC), start, comSt7ACA.length, exExFlag)
        comSt7ACA.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt7ACA.length,exExFlag)

        val bdSt6ACA = SpannableString("- கோவிந்தா")
        bdSt6ACA.setSpan(AbsoluteSizeSpan(14, true), start, bdSt6ACA.length, exExFlag)
        bdSt6ACA.setSpan(StyleSpan(Typeface.BOLD), start, bdSt6ACA.length, exExFlag)
        bdSt6ACA.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt6ACA.length, exExFlag)

        val comSt8ACA = SpannableString("\n(நடு+கட்டை விரல்)-வலது கண்")
        comSt8ACA.setSpan(AbsoluteSizeSpan(13,true),start,comSt8ACA.length,exExFlag)
        comSt8ACA.setSpan(StyleSpan(Typeface.ITALIC), start, comSt8ACA.length, exExFlag)
        comSt8ACA.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt8ACA.length,exExFlag)

        val bdSt7ACA = SpannableString("- விஷ்ணு")
        bdSt7ACA.setSpan(AbsoluteSizeSpan(14, true), start, bdSt7ACA.length, exExFlag)
        bdSt7ACA.setSpan(StyleSpan(Typeface.BOLD), start, bdSt7ACA.length, exExFlag)
        bdSt7ACA.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt7ACA.length, exExFlag)

        val comSt9ACA = SpannableString("\n(நடு+கட்டை விரல்)-இடது கண்")
        comSt9ACA.setSpan(AbsoluteSizeSpan(13,true),start,comSt9ACA.length,exExFlag)
        comSt9ACA.setSpan(StyleSpan(Typeface.ITALIC), start, comSt9ACA.length, exExFlag)
        comSt9ACA.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt9ACA.length,exExFlag)

        val bdSt8ACA = SpannableString("- மதுஸூதனா")
        bdSt8ACA.setSpan(AbsoluteSizeSpan(14, true), start, bdSt8ACA.length, exExFlag)
        bdSt8ACA.setSpan(StyleSpan(Typeface.BOLD), start, bdSt8ACA.length, exExFlag)
        bdSt8ACA.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt8ACA.length, exExFlag)

        val comSt10ACA = SpannableString("\n(மோதிர+கட்டை விரல்)-வலது காது")
        comSt10ACA.setSpan(AbsoluteSizeSpan(13,true),start,comSt10ACA.length,exExFlag)
        comSt10ACA.setSpan(StyleSpan(Typeface.ITALIC), start, comSt10ACA.length, exExFlag)
        comSt10ACA.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt10ACA.length,exExFlag)

        val bdSt9ACA = SpannableString("- த்ரிவிக்ரமா")
        bdSt9ACA.setSpan(AbsoluteSizeSpan(14, true), start, bdSt9ACA.length, exExFlag)
        bdSt9ACA.setSpan(StyleSpan(Typeface.BOLD), start, bdSt9ACA.length, exExFlag)
        bdSt9ACA.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt9ACA.length, exExFlag)

        val comSt11ACA = SpannableString("\n(மோதிர+கட்டை விரல்)-இடது காது")
        comSt11ACA.setSpan(AbsoluteSizeSpan(13,true),start,comSt11ACA.length,exExFlag)
        comSt11ACA.setSpan(StyleSpan(Typeface.ITALIC), start, comSt11ACA.length, exExFlag)
        comSt11ACA.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt11ACA.length,exExFlag)

        val bdSt10ACA = SpannableString("- வாமனா")
        bdSt10ACA.setSpan(AbsoluteSizeSpan(14, true), start, bdSt10ACA.length, exExFlag)
        bdSt10ACA.setSpan(StyleSpan(Typeface.BOLD), start, bdSt10ACA.length, exExFlag)
        bdSt10ACA.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt10ACA.length, exExFlag)

        val comSt12ACA = SpannableString("\n(வலது உள்ளங்கை)-மார்பு")
        comSt12ACA.setSpan(AbsoluteSizeSpan(13,true),start,comSt12ACA.length,exExFlag)
        comSt12ACA.setSpan(StyleSpan(Typeface.ITALIC), start, comSt12ACA.length, exExFlag)
        comSt12ACA.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt12ACA.length,exExFlag)

        val bdSt11ACA = SpannableString("- ஸ்ரீதரா")
        bdSt11ACA.setSpan(AbsoluteSizeSpan(14, true), start, bdSt11ACA.length, exExFlag)
        bdSt11ACA.setSpan(StyleSpan(Typeface.BOLD), start, bdSt11ACA.length, exExFlag)
        bdSt11ACA.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt11ACA.length, exExFlag)

        val comSt13ACA = SpannableString("\n(ஐந்து விரல் நுனி)-முன் தலை")
        comSt13ACA.setSpan(AbsoluteSizeSpan(13,true),start,comSt13ACA.length,exExFlag)
        comSt13ACA.setSpan(StyleSpan(Typeface.ITALIC), start, comSt13ACA.length, exExFlag)
        comSt13ACA.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt13ACA.length,exExFlag)

        val bdSt12ACA = SpannableString("- ஹ்ருஷீகேஷா")
        bdSt12ACA.setSpan(AbsoluteSizeSpan(14, true), start, bdSt12ACA.length, exExFlag)
        bdSt12ACA.setSpan(StyleSpan(Typeface.BOLD), start, bdSt12ACA.length, exExFlag)
        bdSt12ACA.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt12ACA.length, exExFlag)

        val comSt14ACA = SpannableString("\n(ஐந்து விரல் நுனி)-வலது தோள்")
        comSt14ACA.setSpan(AbsoluteSizeSpan(13,true),start,comSt14ACA.length,exExFlag)
        comSt14ACA.setSpan(StyleSpan(Typeface.ITALIC), start, comSt14ACA.length, exExFlag)
        comSt14ACA.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt14ACA.length,exExFlag)

        val bdSt13ACA = SpannableString("- பத்மநாபா")
        bdSt13ACA.setSpan(AbsoluteSizeSpan(14, true), start, bdSt13ACA.length, exExFlag)
        bdSt13ACA.setSpan(StyleSpan(Typeface.BOLD), start, bdSt13ACA.length, exExFlag)
        bdSt13ACA.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt13ACA.length, exExFlag)

        val comSt15ACA = SpannableString("\n(ஐந்து விரல் நுனி)-இடது தோள்")
        comSt15ACA.setSpan(AbsoluteSizeSpan(13,true),start,comSt15ACA.length,exExFlag)
        comSt15ACA.setSpan(StyleSpan(Typeface.ITALIC), start, comSt15ACA.length, exExFlag)
        comSt15ACA.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt15ACA.length,exExFlag)

        val bdSt14ACA = SpannableString("- தாமோதரா\n")
        bdSt14ACA.setSpan(AbsoluteSizeSpan(14, true), start, bdSt14ACA.length, exExFlag)
        bdSt14ACA.setSpan(StyleSpan(Typeface.BOLD), start, bdSt14ACA.length, exExFlag)
        bdSt14ACA.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt14ACA.length, exExFlag)
        //==============================================================================================================
        val comSt2ACB = SpannableString("(ஒவ்வொரு உத்தரிணி ஜலம் எடுத்து வலது கையில் விட்டு ஒவ்வொரு மந்திரத்துக்கும் " +
                "உட்கொள்ளவும்)")
        comSt2ACB.setSpan(AbsoluteSizeSpan(13,true),start,comSt2ACB.length,exExFlag)
        comSt2ACB.setSpan(StyleSpan(Typeface.ITALIC), start, comSt2ACB.length, exExFlag)
        comSt2ACB.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt2ACB.length,exExFlag)

        val bdSt1ACB = SpannableString("- ஓம் அச்யுதாய நம: |  ஓம் அனந்தாய நம: |  ஓம் கோவிந்தாய நம: ||")
        bdSt1ACB.setSpan(AbsoluteSizeSpan(14, true), start, bdSt1ACB.length, exExFlag)
        bdSt1ACB.setSpan(StyleSpan(Typeface.BOLD), start, bdSt1ACB.length, exExFlag)
        bdSt1ACB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt1ACB.length, exExFlag)

        val comSt3ACB = SpannableString("\n(ஒரு உத்தரிணி ஜலம் எடுத்து வலது கையில் விட்டு கீழே விடவும்)")
        comSt3ACB.setSpan(AbsoluteSizeSpan(13,true),start,comSt3ACB.length,exExFlag)
        comSt3ACB.setSpan(StyleSpan(Typeface.ITALIC), start, comSt3ACB.length, exExFlag)
        comSt3ACB.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt3ACB.length,exExFlag)

        val bdSt2ACB = SpannableString("- அபஉபஸ்ப்ருஸ்ய ||\n")
        bdSt2ACB.setSpan(AbsoluteSizeSpan(14, true), start, bdSt2ACB.length, exExFlag)
        bdSt2ACB.setSpan(StyleSpan(Typeface.BOLD), start, bdSt2ACB.length, exExFlag)
        bdSt2ACB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt2ACB.length, exExFlag)

        val comSt4ACB = SpannableString("\n(வலது கட்டை விரலால் வாயை துடைத்துக் கொள்ளவும்)\n(விரல்களால் அங்கங்களை " +
                "தொடவும்)\n(நடு+மோதிர விரல்)-வலது கன்னம்")
        comSt4ACB.setSpan(AbsoluteSizeSpan(13,true),start,comSt4ACB.length,exExFlag)
        comSt4ACB.setSpan(StyleSpan(Typeface.ITALIC), start, comSt4ACB.length, exExFlag)
        comSt4ACB.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt4ACB.length,exExFlag)

        val bdSt3ACB = SpannableString("- கேசவா")
        bdSt3ACB.setSpan(AbsoluteSizeSpan(14, true), start, bdSt3ACB.length, exExFlag)
        bdSt3ACB.setSpan(StyleSpan(Typeface.BOLD), start, bdSt3ACB.length, exExFlag)
        bdSt3ACB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt3ACB.length, exExFlag)

        val comSt5ACB = SpannableString("\n(நடு+மோதிர விரல்)-இடது கன்னம்")
        comSt5ACB.setSpan(AbsoluteSizeSpan(13,true),start,comSt5ACB.length,exExFlag)
        comSt5ACB.setSpan(StyleSpan(Typeface.ITALIC), start, comSt5ACB.length, exExFlag)
        comSt5ACB.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt5ACB.length,exExFlag)

        val bdSt4ACB = SpannableString("- நாராயணா")
        bdSt4ACB.setSpan(AbsoluteSizeSpan(14, true), start, bdSt4ACB.length, exExFlag)
        bdSt4ACB.setSpan(StyleSpan(Typeface.BOLD), start, bdSt4ACB.length, exExFlag)
        bdSt4ACB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt4ACB.length, exExFlag)

        val comSt6ACB = SpannableString("\n(ஆள்காட்டி+கட்டை விரல்)-வலது மூக்கு")
        comSt6ACB.setSpan(AbsoluteSizeSpan(13,true),start,comSt6ACB.length,exExFlag)
        comSt6ACB.setSpan(StyleSpan(Typeface.ITALIC), start, comSt6ACB.length, exExFlag)
        comSt6ACB.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt6ACB.length,exExFlag)

        val bdSt5ACB = SpannableString("- மாதவா")
        bdSt5ACB.setSpan(AbsoluteSizeSpan(14, true), start, bdSt5ACB.length, exExFlag)
        bdSt5ACB.setSpan(StyleSpan(Typeface.BOLD), start, bdSt5ACB.length, exExFlag)
        bdSt5ACB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt5ACB.length, exExFlag)

        val comSt7ACB = SpannableString("\n(ஆள்காட்டி+கட்டை விரல்)-இடது மூக்கு")
        comSt7ACB.setSpan(AbsoluteSizeSpan(13,true),start,comSt7ACB.length,exExFlag)
        comSt7ACB.setSpan(StyleSpan(Typeface.ITALIC), start, comSt7ACB.length, exExFlag)
        comSt7ACB.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt7ACB.length,exExFlag)

        val bdSt6ACB = SpannableString("- கோவிந்தா")
        bdSt6ACB.setSpan(AbsoluteSizeSpan(14, true), start, bdSt6ACB.length, exExFlag)
        bdSt6ACB.setSpan(StyleSpan(Typeface.BOLD), start, bdSt6ACB.length, exExFlag)
        bdSt6ACB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt6ACB.length, exExFlag)

        val comSt8ACB = SpannableString("\n(நடு+கட்டை விரல்)-வலது கண்")
        comSt8ACB.setSpan(AbsoluteSizeSpan(13,true),start,comSt8ACB.length,exExFlag)
        comSt8ACB.setSpan(StyleSpan(Typeface.ITALIC), start, comSt8ACB.length, exExFlag)
        comSt8ACB.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt8ACB.length,exExFlag)

        val bdSt7ACB = SpannableString("- விஷ்ணு")
        bdSt7ACB.setSpan(AbsoluteSizeSpan(14, true), start, bdSt7ACB.length, exExFlag)
        bdSt7ACB.setSpan(StyleSpan(Typeface.BOLD), start, bdSt7ACB.length, exExFlag)
        bdSt7ACB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt7ACB.length, exExFlag)

        val comSt9ACB = SpannableString("\n(நடு+கட்டை விரல்)-இடது கண்")
        comSt9ACB.setSpan(AbsoluteSizeSpan(13,true),start,comSt9ACB.length,exExFlag)
        comSt9ACB.setSpan(StyleSpan(Typeface.ITALIC), start, comSt9ACB.length, exExFlag)
        comSt9ACB.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt9ACB.length,exExFlag)

        val bdSt8ACB = SpannableString("- மதுஸூதனா")
        bdSt8ACB.setSpan(AbsoluteSizeSpan(14, true), start, bdSt8ACB.length, exExFlag)
        bdSt8ACB.setSpan(StyleSpan(Typeface.BOLD), start, bdSt8ACB.length, exExFlag)
        bdSt8ACB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt8ACB.length, exExFlag)

        val comSt10ACB = SpannableString("\n(மோதிர+கட்டை விரல்)-வலது காது")
        comSt10ACB.setSpan(AbsoluteSizeSpan(13,true),start,comSt10ACB.length,exExFlag)
        comSt10ACB.setSpan(StyleSpan(Typeface.ITALIC), start, comSt10ACB.length, exExFlag)
        comSt10ACB.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt10ACB.length,exExFlag)

        val bdSt9ACB = SpannableString("- த்ரிவிக்ரமா")
        bdSt9ACB.setSpan(AbsoluteSizeSpan(14, true), start, bdSt9ACB.length, exExFlag)
        bdSt9ACB.setSpan(StyleSpan(Typeface.BOLD), start, bdSt9ACB.length, exExFlag)
        bdSt9ACB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt9ACB.length, exExFlag)

        val comSt11ACB = SpannableString("\n(மோதிர+கட்டை விரல்)-இடது காது")
        comSt11ACB.setSpan(AbsoluteSizeSpan(13,true),start,comSt11ACB.length,exExFlag)
        comSt11ACB.setSpan(StyleSpan(Typeface.ITALIC), start, comSt11ACB.length, exExFlag)
        comSt11ACB.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt11ACB.length,exExFlag)

        val bdSt10ACB = SpannableString("- வாமனா")
        bdSt10ACB.setSpan(AbsoluteSizeSpan(14, true), start, bdSt10ACB.length, exExFlag)
        bdSt10ACB.setSpan(StyleSpan(Typeface.BOLD), start, bdSt10ACB.length, exExFlag)
        bdSt10ACB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt10ACB.length, exExFlag)

        val comSt12ACB = SpannableString("\n(வலது உள்ளங்கை)-மார்பு")
        comSt12ACB.setSpan(AbsoluteSizeSpan(13,true),start,comSt12ACB.length,exExFlag)
        comSt12ACB.setSpan(StyleSpan(Typeface.ITALIC), start, comSt12ACB.length, exExFlag)
        comSt12ACB.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt12ACB.length,exExFlag)

        val bdSt11ACB = SpannableString("- ஸ்ரீதரா")
        bdSt11ACB.setSpan(AbsoluteSizeSpan(14, true), start, bdSt11ACB.length, exExFlag)
        bdSt11ACB.setSpan(StyleSpan(Typeface.BOLD), start, bdSt11ACB.length, exExFlag)
        bdSt11ACB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt11ACB.length, exExFlag)

        val comSt13ACB = SpannableString("\n(ஐந்து விரல் நுனி)-முன் தலை")
        comSt13ACB.setSpan(AbsoluteSizeSpan(13,true),start,comSt13ACB.length,exExFlag)
        comSt13ACB.setSpan(StyleSpan(Typeface.ITALIC), start, comSt13ACB.length, exExFlag)
        comSt13ACB.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt13ACB.length,exExFlag)

        val bdSt12ACB = SpannableString("- ஹ்ருஷீகேஷா")
        bdSt12ACB.setSpan(AbsoluteSizeSpan(14, true), start, bdSt12ACB.length, exExFlag)
        bdSt12ACB.setSpan(StyleSpan(Typeface.BOLD), start, bdSt12ACB.length, exExFlag)
        bdSt12ACB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt12ACB.length, exExFlag)

        val comSt14ACB = SpannableString("\n(ஐந்து விரல் நுனி)-வலது தோள்")
        comSt14ACB.setSpan(AbsoluteSizeSpan(13,true),start,comSt14ACB.length,exExFlag)
        comSt14ACB.setSpan(StyleSpan(Typeface.ITALIC), start, comSt14ACB.length, exExFlag)
        comSt14ACB.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt14ACB.length,exExFlag)

        val bdSt13ACB = SpannableString("- பத்மநாபா")
        bdSt13ACB.setSpan(AbsoluteSizeSpan(14, true), start, bdSt13ACB.length, exExFlag)
        bdSt13ACB.setSpan(StyleSpan(Typeface.BOLD), start, bdSt13ACB.length, exExFlag)
        bdSt13ACB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt13ACB.length, exExFlag)

        val comSt15ACB = SpannableString("\n(ஐந்து விரல் நுனி)-இடது தோள்")
        comSt15ACB.setSpan(AbsoluteSizeSpan(13,true),start,comSt15ACB.length,exExFlag)
        comSt15ACB.setSpan(StyleSpan(Typeface.ITALIC), start, comSt15ACB.length, exExFlag)
        comSt15ACB.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt15ACB.length,exExFlag)

        val bdSt14ACB = SpannableString("- தாமோதரா\n")
        bdSt14ACB.setSpan(AbsoluteSizeSpan(14, true), start, bdSt14ACB.length, exExFlag)
        bdSt14ACB.setSpan(StyleSpan(Typeface.BOLD), start, bdSt14ACB.length, exExFlag)
        bdSt14ACB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt14ACB.length, exExFlag)
        //==============================================================================================================
        val comSt2ACC = SpannableString("(ஒவ்வொரு உத்தரிணி ஜலம் எடுத்து வலது கையில் விட்டு ஒவ்வொரு மந்திரத்துக்கும் " +
                "உட்கொள்ளவும்)")
        comSt2ACC.setSpan(AbsoluteSizeSpan(13,true),start,comSt2ACC.length,exExFlag)
        comSt2ACC.setSpan(StyleSpan(Typeface.ITALIC), start, comSt2ACC.length, exExFlag)
        comSt2ACC.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt2ACC.length,exExFlag)

        val bdSt1ACC = SpannableString("- ஓம் அச்யுதாய நம: |  ஓம் அனந்தாய நம: |  ஓம் கோவிந்தாய நம: ||")
        bdSt1ACC.setSpan(AbsoluteSizeSpan(14, true), start, bdSt1ACC.length, exExFlag)
        bdSt1ACC.setSpan(StyleSpan(Typeface.BOLD), start, bdSt1ACC.length, exExFlag)
        bdSt1ACC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt1ACC.length, exExFlag)

        val comSt3ACC = SpannableString("\n(ஒரு உத்தரிணி ஜலம் எடுத்து வலது கையில் விட்டு கீழே விடவும்)")
        comSt3ACC.setSpan(AbsoluteSizeSpan(13,true),start,comSt3ACC.length,exExFlag)
        comSt3ACC.setSpan(StyleSpan(Typeface.ITALIC), start, comSt3ACC.length, exExFlag)
        comSt3ACC.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt3ACC.length,exExFlag)

        val bdSt2ACC = SpannableString("- அபஉபஸ்ப்ருஸ்ய ||\n")
        bdSt2ACC.setSpan(AbsoluteSizeSpan(14, true), start, bdSt2ACC.length, exExFlag)
        bdSt2ACC.setSpan(StyleSpan(Typeface.BOLD), start, bdSt2ACC.length, exExFlag)
        bdSt2ACC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt2ACC.length, exExFlag)

        val comSt4ACC = SpannableString("\n(வலது கட்டை விரலால் வாயை துடைத்துக் கொள்ளவும்)\n(விரல்களால் அங்கங்களை " +
                "தொடவும்)\n(நடு+மோதிர விரல்)-வலது கன்னம்")
        comSt4ACC.setSpan(AbsoluteSizeSpan(13,true),start,comSt4ACC.length,exExFlag)
        comSt4ACC.setSpan(StyleSpan(Typeface.ITALIC), start, comSt4ACC.length, exExFlag)
        comSt4ACC.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt4ACC.length,exExFlag)

        val bdSt3ACC = SpannableString("- கேசவா")
        bdSt3ACC.setSpan(AbsoluteSizeSpan(14, true), start, bdSt3ACC.length, exExFlag)
        bdSt3ACC.setSpan(StyleSpan(Typeface.BOLD), start, bdSt3ACC.length, exExFlag)
        bdSt3ACC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt3ACC.length, exExFlag)

        val comSt5ACC = SpannableString("\n(நடு+மோதிர விரல்)-இடது கன்னம்")
        comSt5ACC.setSpan(AbsoluteSizeSpan(13,true),start,comSt5ACC.length,exExFlag)
        comSt5ACC.setSpan(StyleSpan(Typeface.ITALIC), start, comSt5ACC.length, exExFlag)
        comSt5ACC.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt5ACC.length,exExFlag)

        val bdSt4ACC = SpannableString("- நாராயணா")
        bdSt4ACC.setSpan(AbsoluteSizeSpan(14, true), start, bdSt4ACC.length, exExFlag)
        bdSt4ACC.setSpan(StyleSpan(Typeface.BOLD), start, bdSt4ACC.length, exExFlag)
        bdSt4ACC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt4ACC.length, exExFlag)

        val comSt6ACC = SpannableString("\n(ஆள்காட்டி+கட்டை விரல்)-வலது மூக்கு")
        comSt6ACC.setSpan(AbsoluteSizeSpan(13,true),start,comSt6ACC.length,exExFlag)
        comSt6ACC.setSpan(StyleSpan(Typeface.ITALIC), start, comSt6ACC.length, exExFlag)
        comSt6ACC.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt6ACC.length,exExFlag)

        val bdSt5ACC = SpannableString("- மாதவா")
        bdSt5ACC.setSpan(AbsoluteSizeSpan(14, true), start, bdSt5ACC.length, exExFlag)
        bdSt5ACC.setSpan(StyleSpan(Typeface.BOLD), start, bdSt5ACC.length, exExFlag)
        bdSt5ACC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt5ACC.length, exExFlag)

        val comSt7ACC = SpannableString("\n(ஆள்காட்டி+கட்டை விரல்)-இடது மூக்கு")
        comSt7ACC.setSpan(AbsoluteSizeSpan(13,true),start,comSt7ACC.length,exExFlag)
        comSt7ACC.setSpan(StyleSpan(Typeface.ITALIC), start, comSt7ACC.length, exExFlag)
        comSt7ACC.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt7ACC.length,exExFlag)

        val bdSt6ACC = SpannableString("- கோவிந்தா")
        bdSt6ACC.setSpan(AbsoluteSizeSpan(14, true), start, bdSt6ACC.length, exExFlag)
        bdSt6ACC.setSpan(StyleSpan(Typeface.BOLD), start, bdSt6ACC.length, exExFlag)
        bdSt6ACC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt6ACC.length, exExFlag)

        val comSt8ACC = SpannableString("\n(நடு+கட்டை விரல்)-வலது கண்")
        comSt8ACC.setSpan(AbsoluteSizeSpan(13,true),start,comSt8ACC.length,exExFlag)
        comSt8ACC.setSpan(StyleSpan(Typeface.ITALIC), start, comSt8ACC.length, exExFlag)
        comSt8ACC.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt8ACC.length,exExFlag)

        val bdSt7ACC = SpannableString("- விஷ்ணு")
        bdSt7ACC.setSpan(AbsoluteSizeSpan(14, true), start, bdSt7ACC.length, exExFlag)
        bdSt7ACC.setSpan(StyleSpan(Typeface.BOLD), start, bdSt7ACC.length, exExFlag)
        bdSt7ACC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt7ACC.length, exExFlag)

        val comSt9ACC = SpannableString("\n(நடு+கட்டை விரல்)-இடது கண்")
        comSt9ACC.setSpan(AbsoluteSizeSpan(13,true),start,comSt9ACC.length,exExFlag)
        comSt9ACC.setSpan(StyleSpan(Typeface.ITALIC), start, comSt9ACC.length, exExFlag)
        comSt9ACC.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt9ACC.length,exExFlag)

        val bdSt8ACC = SpannableString("- மதுஸூதனா")
        bdSt8ACC.setSpan(AbsoluteSizeSpan(14, true), start, bdSt8ACC.length, exExFlag)
        bdSt8ACC.setSpan(StyleSpan(Typeface.BOLD), start, bdSt8ACC.length, exExFlag)
        bdSt8ACC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt8ACC.length, exExFlag)

        val comSt10ACC = SpannableString("\n(மோதிர+கட்டை விரல்)-வலது காது")
        comSt10ACC.setSpan(AbsoluteSizeSpan(13,true),start,comSt10ACC.length,exExFlag)
        comSt10ACC.setSpan(StyleSpan(Typeface.ITALIC), start, comSt10ACC.length, exExFlag)
        comSt10ACC.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt10ACC.length,exExFlag)

        val bdSt9ACC = SpannableString("- த்ரிவிக்ரமா")
        bdSt9ACC.setSpan(AbsoluteSizeSpan(14, true), start, bdSt9ACC.length, exExFlag)
        bdSt9ACC.setSpan(StyleSpan(Typeface.BOLD), start, bdSt9ACC.length, exExFlag)
        bdSt9ACC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt9ACC.length, exExFlag)

        val comSt11ACC = SpannableString("\n(மோதிர+கட்டை விரல்)-இடது காது")
        comSt11ACC.setSpan(AbsoluteSizeSpan(13,true),start,comSt11ACC.length,exExFlag)
        comSt11ACC.setSpan(StyleSpan(Typeface.ITALIC), start, comSt11ACC.length, exExFlag)
        comSt11ACC.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt11ACC.length,exExFlag)

        val bdSt10ACC = SpannableString("- வாமனா")
        bdSt10ACC.setSpan(AbsoluteSizeSpan(14, true), start, bdSt10ACC.length, exExFlag)
        bdSt10ACC.setSpan(StyleSpan(Typeface.BOLD), start, bdSt10ACC.length, exExFlag)
        bdSt10ACC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt10ACC.length, exExFlag)

        val comSt12ACC = SpannableString("\n(வலது உள்ளங்கை)-மார்பு")
        comSt12ACC.setSpan(AbsoluteSizeSpan(13,true),start,comSt12ACC.length,exExFlag)
        comSt12ACC.setSpan(StyleSpan(Typeface.ITALIC), start, comSt12ACC.length, exExFlag)
        comSt12ACC.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt12ACC.length,exExFlag)

        val bdSt11ACC = SpannableString("- ஸ்ரீதரா")
        bdSt11ACC.setSpan(AbsoluteSizeSpan(14, true), start, bdSt11ACC.length, exExFlag)
        bdSt11ACC.setSpan(StyleSpan(Typeface.BOLD), start, bdSt11ACC.length, exExFlag)
        bdSt11ACC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt11ACC.length, exExFlag)

        val comSt13ACC = SpannableString("\n(ஐந்து விரல் நுனி)-முன் தலை")
        comSt13ACC.setSpan(AbsoluteSizeSpan(13,true),start,comSt13ACC.length,exExFlag)
        comSt13ACC.setSpan(StyleSpan(Typeface.ITALIC), start, comSt13ACC.length, exExFlag)
        comSt13ACC.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt13ACC.length,exExFlag)

        val bdSt12ACC = SpannableString("- ஹ்ருஷீகேஷா")
        bdSt12ACC.setSpan(AbsoluteSizeSpan(14, true), start, bdSt12ACC.length, exExFlag)
        bdSt12ACC.setSpan(StyleSpan(Typeface.BOLD), start, bdSt12ACC.length, exExFlag)
        bdSt12ACC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt12ACC.length, exExFlag)

        val comSt14ACC = SpannableString("\n(ஐந்து விரல் நுனி)-வலது தோள்")
        comSt14ACC.setSpan(AbsoluteSizeSpan(13,true),start,comSt14ACC.length,exExFlag)
        comSt14ACC.setSpan(StyleSpan(Typeface.ITALIC), start, comSt14ACC.length, exExFlag)
        comSt14ACC.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt14ACC.length,exExFlag)

        val bdSt13ACC = SpannableString("- பத்மநாபா")
        bdSt13ACC.setSpan(AbsoluteSizeSpan(14, true), start, bdSt13ACC.length, exExFlag)
        bdSt13ACC.setSpan(StyleSpan(Typeface.BOLD), start, bdSt13ACC.length, exExFlag)
        bdSt13ACC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt13ACC.length, exExFlag)

        val comSt15ACC = SpannableString("\n(ஐந்து விரல் நுனி)-இடது தோள்")
        comSt15ACC.setSpan(AbsoluteSizeSpan(13,true),start,comSt15ACC.length,exExFlag)
        comSt15ACC.setSpan(StyleSpan(Typeface.ITALIC), start, comSt15ACC.length, exExFlag)
        comSt15ACC.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt15ACC.length,exExFlag)

        val bdSt14ACC = SpannableString("- தாமோதரா\n")
        bdSt14ACC.setSpan(AbsoluteSizeSpan(14, true), start, bdSt14ACC.length, exExFlag)
        bdSt14ACC.setSpan(StyleSpan(Typeface.BOLD), start, bdSt14ACC.length, exExFlag)
        bdSt14ACC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt14ACC.length, exExFlag)
        //==============================================================================================================

        val hdSt2GM = SpannableString("கணேச ப்ரார்த்தனை")
        hdSt2GM.setSpan(AbsoluteSizeSpan(14, true), start, hdSt2GM.length, exExFlag)
        hdSt2GM.setSpan(StyleSpan(Typeface.BOLD), start, hdSt2GM.length, exExFlag)
        hdSt2GM.setSpan(UnderlineSpan(), start, hdSt2GM.length, exExFlag)
        hdSt2GM.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start,  hdSt2GM.length, exExFlag)

        val comSt16GM = SpannableString("\n(இரண்டு கைவிரல்களையும் மடித்துக் கொண்டு, தலையின் இரு பொட்டிலும் ஐந்து முறை " +
                "குட்டிக் கொள்ளவும்)")
        comSt16GM.setSpan(AbsoluteSizeSpan(13,true),start,comSt16GM.length,exExFlag)
        comSt16GM.setSpan(StyleSpan(Typeface.ITALIC), start, comSt16GM.length, exExFlag)
        comSt16GM.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt16GM.length,exExFlag)

        val bdSt15GM = SpannableString("\nசுக்லாம் பரதரம் விஷ்ணும்\n   சசிவர்ணம் சதுர்புஜம் |\nப்ரஸன்ன வதனம் த்யாயேத்\n   " +
                "ஸர்வ விக்நோப சாந்தயே ||\n")
        bdSt15GM.setSpan(AbsoluteSizeSpan(14, true), start, bdSt15GM.length, exExFlag)
        bdSt15GM.setSpan(StyleSpan(Typeface.BOLD), start, bdSt15GM.length, exExFlag)
        bdSt15GM.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt15GM.length, exExFlag)
        //==============================================================================================================
        val hdSt3PM = SpannableString("ப்ராணாயாமம்")
        hdSt3PM.setSpan(AbsoluteSizeSpan(14, true), start, hdSt3PM.length, exExFlag)
        hdSt3PM.setSpan(StyleSpan(Typeface.BOLD), start, hdSt3PM.length, exExFlag)
        hdSt3PM.setSpan(UnderlineSpan(), start, hdSt3PM.length, exExFlag)
        hdSt3PM.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start,  hdSt3PM.length, exExFlag)

        val hdSt3PMA = SpannableString("ப்ராணாயாமம்\n")
        hdSt3PMA.setSpan(AbsoluteSizeSpan(14, true), start, hdSt3PMA.length, exExFlag)
        hdSt3PMA.setSpan(StyleSpan(Typeface.BOLD), start, hdSt3PMA.length, exExFlag)
        hdSt3PMA.setSpan(UnderlineSpan(), start, hdSt3PMA.length, exExFlag)
        hdSt3PMA.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start,  hdSt3PMA.length, exExFlag)

        val comSt17PM = SpannableString("\n(வலது கை கட்டை விரலால் வலது மூக்கை மேல்புறமாக மூடி இடநாசியால் மூச்சை " +
                "உள்ளிழுத்து பின் வலது மோதிர மற்றும் சுண்டு ஆகிய விரலால் இடது மூக்கை மேல் பறமாக மூடி இம்மந்திரத்தை கூறவும்)\n")
        comSt17PM.setSpan(AbsoluteSizeSpan(13,true),start,comSt17PM.length,exExFlag)
        comSt17PM.setSpan(StyleSpan(Typeface.ITALIC), start, comSt17PM.length, exExFlag)
        comSt17PM.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt17PM.length,exExFlag)

        val bdSt16PM = SpannableString("\nஓம் பூ: ஓம்புவா:   ஓம் ஸுவா: ஓம் மஹ: ஓம் ஜன: ஓம் தப:   ஓம் ஸத்யம் " +
                "ஓம் தத்ஸவிதுர் வரேண்யம்    பர்கோ தேவஸ்ய தீமஹி | தியோ யோந: ப்ரசோதயாத் |   ஓம் ஆபோ ஜ்யோதீரஸோ " +
                "\nஅம்ருதம் ப்ரம்ம பூர்புவஸ்வரோம் ||")
        bdSt16PM.setSpan(AbsoluteSizeSpan(14, true), start, bdSt16PM.length, exExFlag)
        bdSt16PM.setSpan(StyleSpan(Typeface.BOLD), start, bdSt16PM.length, exExFlag)
        bdSt16PM.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt16PM.length, exExFlag)

        val comSt18PM = SpannableString("\n(வலது கையால் வலது காதை தொடடு)-")
        comSt18PM.setSpan(AbsoluteSizeSpan(13,true),start,comSt18PM.length,exExFlag)
        comSt18PM.setSpan(StyleSpan(Typeface.ITALIC), start, comSt18PM.length, exExFlag)
        comSt18PM.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt18PM.length,exExFlag)

        val bdSt17PM = SpannableString("\nஓம்  ஓம்  ஓம் ||\n")
        bdSt17PM.setSpan(AbsoluteSizeSpan(14, true), start, bdSt17PM.length, exExFlag)
        bdSt17PM.setSpan(StyleSpan(Typeface.BOLD), start, bdSt17PM.length, exExFlag)
        bdSt17PM.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt17PM.length, exExFlag)
        //==============================================================================================================

        val bdSt16PMA = SpannableString("\nஓம் பூ: ஓம்புவா:   ஓம் ஸுவா: ஓம் மஹ: ஓம் ஜன: ஓம் தப:   ஓம் ஸத்யம் " +
                "ஓம் தத்ஸவிதுர் வரேண்யம்    பர்கோ தேவஸ்ய தீமஹி | தியோ யோந: ப்ரசோதயாத் |   ஓம் ஆபோ ஜ்யோதீரஸோ " +
                "\nஅம்ருதம் ப்ரம்ம பூர்புவஸ்வரோம் ||")
        bdSt16PMA.setSpan(AbsoluteSizeSpan(14, true), start, bdSt16PMA.length, exExFlag)
        bdSt16PMA.setSpan(StyleSpan(Typeface.BOLD), start, bdSt16PMA.length, exExFlag)
        bdSt16PMA.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt16PMA.length, exExFlag)

        val comSt18PMA = SpannableString("\n(வலது கையால் வலது காதை தொடடு)-")
        comSt18PMA.setSpan(AbsoluteSizeSpan(13,true),start,comSt18PMA.length,exExFlag)
        comSt18PMA.setSpan(StyleSpan(Typeface.ITALIC), start, comSt18PMA.length, exExFlag)
        comSt18PMA.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt18PMA.length,exExFlag)

        val bdSt17PMA = SpannableString("\nஓம்  ஓம்  ஓம் ||\n")
        bdSt17PMA.setSpan(AbsoluteSizeSpan(14, true), start, bdSt17PMA.length, exExFlag)
        bdSt17PMA.setSpan(StyleSpan(Typeface.BOLD), start, bdSt17PMA.length, exExFlag)
        bdSt17PMA.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt17PMA.length, exExFlag)
        //==============================================================================================================

        val hdSt4SANG = SpannableString("ஸங்கல்பம்")
        hdSt4SANG.setSpan(AbsoluteSizeSpan(14, true), start, hdSt4SANG.length, exExFlag)
        hdSt4SANG.setSpan(StyleSpan(Typeface.BOLD), start, hdSt4SANG.length, exExFlag)
        hdSt4SANG.setSpan(UnderlineSpan(), start, hdSt4SANG.length, exExFlag)
        hdSt4SANG.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start,  hdSt4SANG.length, exExFlag)

        val hdSt4SANGA = SpannableString("\nஸங்கல்பம்")
        hdSt4SANGA.setSpan(AbsoluteSizeSpan(14, true), start, hdSt4SANGA.length, exExFlag)
        hdSt4SANGA.setSpan(StyleSpan(Typeface.BOLD), start, hdSt4SANGA.length, exExFlag)
        hdSt4SANGA.setSpan(UnderlineSpan(), start, hdSt4SANGA.length, exExFlag)
        hdSt4SANGA.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start,  hdSt4SANGA.length, exExFlag)

        val comSt19SANG = SpannableString("\n(வலது தொடையின் மீது இடது கையை மேற்புறமாக வைத்துக் கொண்டு, அதன் மேல் " +
                "வலது கையை வைத்து மூடினாட்போல் வைத்து)\n")
        comSt19SANG.setSpan(AbsoluteSizeSpan(13,true),start,comSt19SANG.length,exExFlag)
        comSt19SANG.setSpan(StyleSpan(Typeface.ITALIC), start, comSt19SANG.length, exExFlag)
        comSt19SANG.setSpan(ForegroundColorSpan(Color.DKGRAY),start,comSt19SANG.length,exExFlag)

        val bdSt18ASAN = SpannableString("\n   அத்ய பூர்வோக்த ஏவங்குண விசேஷண விசிஷ்டாயாம் அஸ்யாம் சுபதிதௌ மமோபாத்த " +
                "ஸமஸ்த துரிதஷயத் வாரா ஸ்ரீபரமேச்வர ப்ரீத்யர்த்தம் TYPEOFSANDYA உபாஸிஷ்யே ||")
        val regexReplace1 = """(TYPEOFSANDYA)""".toRegex()
        val bdSt18SANG = SpannableString(bdSt18ASAN.replace(regexReplace1, sandyaType))
        bdSt18SANG.setSpan(AbsoluteSizeSpan(14, true), start, bdSt18SANG.length, exExFlag)
        bdSt18SANG.setSpan(StyleSpan(Typeface.BOLD), start, bdSt18SANG.length, exExFlag)
        bdSt18SANG.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt18SANG.length, exExFlag)
        //==============================================================================================================
        val comSt2 = SpannableString("\n(உத்தரணியில் ஜலம் எடுத்து வலது கை மோதிர விரலால் அதில் ஓம் என்று எழுதி நெற்றியில் " +
                "இட்டுக் கொள்ளவும்)\n")
        comSt2.setSpan(AbsoluteSizeSpan(13, true), start, comSt2.length, exExFlag)
        comSt2.setSpan(StyleSpan(Typeface.ITALIC), start, comSt2.length, exExFlag)
        comSt2.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt2.length, exExFlag)

        val bdSt1 = SpannableString("ஓம் ஸ்ரீஹரிஹ்ருஷீகேசாய நம: ||\n")
        bdSt1.setSpan(AbsoluteSizeSpan(14, true), start, bdSt1.length, exExFlag)
        bdSt1.setSpan(StyleSpan(Typeface.BOLD), start, bdSt1.length, exExFlag)
        bdSt1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt1.length, exExFlag)

        val hdSt2 = SpannableString("மார்ஜனம்\n")
        hdSt2.setSpan(AbsoluteSizeSpan(14, true), start, hdSt2.length, exExFlag)
        hdSt2.setSpan(StyleSpan(Typeface.BOLD), start, hdSt2.length, exExFlag)
        hdSt2.setSpan(UnderlineSpan(), start, hdSt2.length, exExFlag)
        hdSt2.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, hdSt2.length, exExFlag)

        val comSt3 = SpannableString("(முன் தலையை தொட்டு) - ")
        comSt3.setSpan(AbsoluteSizeSpan(13, true), start, comSt3.length, exExFlag)
        comSt3.setSpan(StyleSpan(Typeface.ITALIC), start, comSt3.length, exExFlag)
        comSt3.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt3.length, exExFlag)

        val bdSt2 = SpannableString("ஆபோஹிஷ்டேத்யாதி திஸ்ருணாம்\nசிந்து த்வீப ரிஷி:|\n")
        bdSt2.setSpan(AbsoluteSizeSpan(14, true), start, bdSt2.length, exExFlag)
        bdSt2.setSpan(StyleSpan(Typeface.BOLD), start, bdSt2.length, exExFlag)
        bdSt2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt2.length, exExFlag)

        val comSt4 = SpannableString("(மூக்கை தொட்டு) - ")
        comSt4.setSpan(AbsoluteSizeSpan(13, true), start, comSt4.length, exExFlag)
        comSt4.setSpan(StyleSpan(Typeface.ITALIC), start, comSt4.length, exExFlag)
        comSt4.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt4.length, exExFlag)

        val bdSt3 = SpannableString("காயத்ரீச் சந்த:|\n")
        bdSt3.setSpan(AbsoluteSizeSpan(14, true), start, bdSt3.length, exExFlag)
        bdSt3.setSpan(StyleSpan(Typeface.BOLD), start, bdSt3.length, exExFlag)
        bdSt3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt3.length, exExFlag)

        val comSt5 = SpannableString("(மார்பை தொட்டு) -")
        comSt5.setSpan(AbsoluteSizeSpan(13, true), start, comSt5.length, exExFlag)
        comSt5.setSpan(StyleSpan(Typeface.ITALIC), start, comSt5.length, exExFlag)
        comSt5.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt5.length, exExFlag)

        val bdSt4 = SpannableString("ஆபோ தேவதா:| மார்ஜனே வினியோக: ||\n")
        bdSt4.setSpan(AbsoluteSizeSpan(14, true), start, bdSt4.length, exExFlag)
        bdSt4.setSpan(StyleSpan(Typeface.BOLD), start, bdSt4.length, exExFlag)
        bdSt4.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt4.length, exExFlag)
//======================================================================================================================
        val comSt1PRO = SpannableString("(ஜலத்தை ப்ரோக்ஷணம் செய்து கொள்ளவும்)\n")
        comSt1PRO.setSpan(AbsoluteSizeSpan(13, true), start, comSt1PRO.length, exExFlag)
        comSt1PRO.setSpan(StyleSpan(Typeface.ITALIC), start, comSt1PRO.length, exExFlag)
        comSt1PRO.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt1PRO.length, exExFlag)

        val bdSt1PRO = SpannableString("ஓம் ஆபோ ஹிஷ்டா மயோபுவ:\nதான ஊர்ஜே ததாதன |\nமஹேரணாய சக்ஷஸே ||" +
                "\nயோவஸ் சிவதமோ ரஸ:\nதஸ்ய பாஜயதேஹந: |\nஉசதீரிவ மாதர: ||\nதஸ்மா அரங்கமாமவ:")
        bdSt1PRO.setSpan(AbsoluteSizeSpan(14, true), start, bdSt1PRO.length, exExFlag)
        bdSt1PRO.setSpan(StyleSpan(Typeface.BOLD), start, bdSt1PRO.length, exExFlag)
        bdSt1PRO.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt1PRO.length, exExFlag)

        val bdSt1PROA = SpannableString("ஓம் ஆபோ ஹிஷ்டா மயோபுவ:\nதான ஊர்ஜே ததாதன |\nமஹேரணாய சக்ஷஸே ||" +
                "\nயோவஸ் சிவதமோ ரஸ:\nதஸ்ய பாஜயதேஹந: |\nஉசதீரிவ மாதர: ||\nதஸ்மா அரங்கமாமவ:")
        bdSt1PROA.setSpan(AbsoluteSizeSpan(14, true), start, bdSt1PROA.length, exExFlag)
        bdSt1PROA.setSpan(StyleSpan(Typeface.BOLD), start, bdSt1PROA.length, exExFlag)
        bdSt1PROA.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt1PROA.length, exExFlag)

        val comSt2PRO = SpannableString("\n(இரு பாதங்களின் மீது ஜலம் தெளித்துக் கொள்ளவும்)- \n")
        comSt2PRO.setSpan(AbsoluteSizeSpan(13, true), start, comSt2PRO.length, exExFlag)
        comSt2PRO.setSpan(StyleSpan(Typeface.ITALIC), start, comSt2PRO.length, exExFlag)
        comSt2PRO.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt2PRO.length, exExFlag)

        val bdSt2PRO = SpannableString("யஸ்ய க்ஷயாய ஜின்வத |\nஆபோ ஜனயதா சந: ||\n")
        bdSt2PRO.setSpan(AbsoluteSizeSpan(14, true), start, bdSt2PRO.length, exExFlag)
        bdSt2PRO.setSpan(StyleSpan(Typeface.BOLD), start, bdSt2PRO.length, exExFlag)
        bdSt2PRO.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt2PRO.length, exExFlag)
//======================================================================================================================
        val hdSt1PV = SpannableString("\nபாபவிஸர்ஜனம்\n")
        hdSt1PV.setSpan(AbsoluteSizeSpan(14, true), start, hdSt1PV.length, exExFlag)
        hdSt1PV.setSpan(StyleSpan(Typeface.BOLD), start, hdSt1PV.length, exExFlag)
        hdSt1PV.setSpan(UnderlineSpan(), start, hdSt1PV.length, exExFlag)
        hdSt1PV.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, hdSt1PV.length, exExFlag)

        val comSt1PV = SpannableString("(சிரஸைத் தொட்டு)-")
        comSt1PV.setSpan(AbsoluteSizeSpan(13, true), start, comSt1PV.length, exExFlag)
        comSt1PV.setSpan(StyleSpan(Typeface.ITALIC), start, comSt1PV.length, exExFlag)
        comSt1PV.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt1PV.length, exExFlag)

        val bdSt1PV = SpannableString("த்ருபதாதிவேதி மஹா மந்த்ரஸ்ய\nத்ருபத புத்ர: கோகில ராஜரிஷி: |\n")
        bdSt1PV.setSpan(AbsoluteSizeSpan(14, true), start, bdSt1PV.length, exExFlag)
        bdSt1PV.setSpan(StyleSpan(Typeface.BOLD), start, bdSt1PV.length, exExFlag)
        bdSt1PV.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt1PV.length, exExFlag)

        val comSt2PV = SpannableString("(நுனிமூக்கைத் தொட்டு)-")
        comSt2PV.setSpan(AbsoluteSizeSpan(13, true), start, comSt2PV.length, exExFlag)
        comSt2PV.setSpan(StyleSpan(Typeface.ITALIC), start, comSt2PV.length, exExFlag)
        comSt2PV.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt2PV.length, exExFlag)

        val bdSt2PV = SpannableString("அனுஷ்டுப்ச்சந்த: |\n")
        bdSt2PV.setSpan(AbsoluteSizeSpan(14, true), start, bdSt2PV.length, exExFlag)
        bdSt2PV.setSpan(StyleSpan(Typeface.BOLD), start, bdSt2PV.length, exExFlag)
        bdSt2PV.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt2PV.length, exExFlag)

        val comSt3PV = SpannableString("(மார்பைத் தொட்டு)-")
        comSt3PV.setSpan(AbsoluteSizeSpan(13, true), start, comSt3PV.length, exExFlag)
        comSt3PV.setSpan(StyleSpan(Typeface.ITALIC), start, comSt3PV.length, exExFlag)
        comSt3PV.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt3PV.length, exExFlag)

        val bdSt3PV = SpannableString("த்ருபதா தேவதா: |\nபாபவிஸர்ஜனே வினியோக: ||\n")
        bdSt3PV.setSpan(AbsoluteSizeSpan(14, true), start, bdSt3PV.length, exExFlag)
        bdSt3PV.setSpan(StyleSpan(Typeface.BOLD), start, bdSt3PV.length, exExFlag)
        bdSt3PV.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt3PV.length, exExFlag)
//=====================================================================================================================
        val comSt6 = SpannableString("(வலது கையில் ஒரு உத்தரணி ஜலம் விட்டுக் கொண்டு இம்மந்திரத்தைச் சொல்லி, மூக்கு " +
                "நுனிக்கு அந்த ஜலத்தைக் கொண்டு வந்து முகர்ந்த பின் அதை கீழே விடவும்)\n")
        comSt6.setSpan(AbsoluteSizeSpan(13, true), start, comSt6.length, exExFlag)
        comSt6.setSpan(StyleSpan(Typeface.ITALIC), start, comSt6.length, exExFlag)
        comSt6.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt6.length, exExFlag)

        val bdSt5 = SpannableString("ஓம் த்ருபதாதிவ முமுசான:\nஸ்வின்னஸ் ஸ்நாதோ மலாதிவ |\nபூதம் பவித்ரேணேவாஜ்யம்\n" +
                "ஆபச் சுந்தந்து மைனஸ: ||\n")
        bdSt5.setSpan(AbsoluteSizeSpan(14, true), start, bdSt5.length, exExFlag)
        bdSt5.setSpan(StyleSpan(Typeface.BOLD), start, bdSt5.length, exExFlag)
        bdSt5.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt5.length, exExFlag)

        val hdSt3 = SpannableString("\nப்ராசனம்\n")
        hdSt3.setSpan(AbsoluteSizeSpan(14, true), start, hdSt3.length, exExFlag)
        hdSt3.setSpan(StyleSpan(Typeface.BOLD), start, hdSt3.length, exExFlag)
        hdSt3.setSpan(UnderlineSpan(), start, hdSt3.length, exExFlag)
        hdSt3.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, hdSt3.length, exExFlag)

        val comSt7 = SpannableString("(வலது கையில் ஜலம் விட்டுக் கொண்டு மந்திரம் சொல்லி உட்கொள்ளவும்)\n")
        comSt7.setSpan(AbsoluteSizeSpan(13, true), start, comSt7.length, exExFlag)
        comSt7.setSpan(StyleSpan(Typeface.ITALIC), start, comSt7.length, exExFlag)
        comSt7.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt7.length, exExFlag)

        val bdSt6A = SpannableString("ஸூர்யஸ்ச மாமன்யுஸ்ச \nமன்யுபதஸ்ச மன்யு க்ருதேப்ய: |\nபாபேப்யோ ரஷந்தாம் | \nயத் ராத்ர்யா " +
                "பாபமகாரிஷம் |\nமனஸா வாசா ஹஸ்தாப்யாம் \nபத்ப்யாம் உதரேண சிஸ்நா\nராத்ரிஸ்தத் அவலும்பது \nயத்கிஞ்ச துரிதம் மயி |\nஇதமஹம் " +
                "மாமம்ருத யோநௌ | \nஸூர்யே ஜயாதிஷி ஜூஹோமி ஸ்வாஹா ||\n")
        bdSt6A.setSpan(AbsoluteSizeSpan(14, true), start, bdSt6A.length, exExFlag)
        bdSt6A.setSpan(StyleSpan(Typeface.BOLD), start, bdSt6A.length, exExFlag)
        bdSt6A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt6A.length, exExFlag)

        val bdSt6B = SpannableString("ஆபா புனந்து ப்ருதிவீம் | ப்ருதிவீ பூதா புனாதுமாம் |\nப்ரம்ம பூதா புனாது மாம் | யதுச்சிஷ்டம் " +
                "அபோஜ்யம் |\nயத்வா துஸ்சரிதம் மம | ஸர்வம் புனந்து மாமாப: |\nஅஸதாஞ்ச ப்ரதிக்ரஹக்கு ஸ்வாஹா ||\n")
        bdSt6B.setSpan(AbsoluteSizeSpan(14, true), start, bdSt6B.length, exExFlag)
        bdSt6B.setSpan(StyleSpan(Typeface.BOLD), start, bdSt6B.length, exExFlag)
        bdSt6B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt6B.length, exExFlag)

        val bdSt6C = SpannableString("அக்னிஸ்ச மாமன்யுஸ்ச \nமன்யுபதயஸ்ய மன்யுக்ருதேப்யா |\nபாபேப்யோ ரக்ஷந்தாம் |\nயதன்னா " +
                "பாபமகாரிஷம் |\nமனஸா வாசா ஹஸ்தாப்யாம் |\nபத்ப்யாம் உதரேண சிஸ்நா |\nஅஹஸ்தத் அவலும்பது |\nயத்கிஞ்ச துரிதம் மயி |" +
                "\nஇதமஹம் மாமம்ருதயோநௌ |\nஸத்யே ஜ்யோதிஷி ஜூஹோமிஸ்வாஹா ||\n")
        bdSt6C.setSpan(AbsoluteSizeSpan(14, true), start, bdSt6C.length, exExFlag)
        bdSt6C.setSpan(StyleSpan(Typeface.BOLD), start, bdSt6C.length, exExFlag)
        bdSt6C.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt6C.length, exExFlag)

        val hdSt4 = SpannableString("புனர்மார்ஜனம்\n")
        hdSt4.setSpan(AbsoluteSizeSpan(14, true), start, hdSt4.length, exExFlag)
        hdSt4.setSpan(StyleSpan(Typeface.BOLD), start, hdSt4.length, exExFlag)
        hdSt4.setSpan(UnderlineSpan(), start, hdSt4.length, exExFlag)
        hdSt4.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, hdSt4.length, exExFlag)

        val hdSt5 = SpannableString("\nஆவர்த்தனம்\n")
        hdSt5.setSpan(AbsoluteSizeSpan(14, true), start, hdSt5.length, exExFlag)
        hdSt5.setSpan(StyleSpan(Typeface.BOLD), start, hdSt5.length, exExFlag)
        hdSt5.setSpan(UnderlineSpan(), start, hdSt5.length, exExFlag)
        hdSt5.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, hdSt5.length, exExFlag)

        val comSt8 = SpannableString("(முன்தலையை தொட்டு)-")
        comSt8.setSpan(AbsoluteSizeSpan(13, true), start, comSt8.length, exExFlag)
        comSt8.setSpan(StyleSpan(Typeface.ITALIC), start, comSt8.length, exExFlag)
        comSt8.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt8.length, exExFlag)

        val bdSt7 = SpannableString("ஸூமித்ரியான இத்யஸ்யமந்த்ரஸ்ய வருணரிஷி: |\n")
        bdSt7.setSpan(AbsoluteSizeSpan(14, true), start, bdSt7.length, exExFlag)
        bdSt7.setSpan(StyleSpan(Typeface.BOLD), start, bdSt7.length, exExFlag)
        bdSt7.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt7.length, exExFlag)

        val comSt9 = SpannableString("(மூக்கை தொட்டு)\n")
        comSt9.setSpan(AbsoluteSizeSpan(13, true), start, comSt9.length, exExFlag)
        comSt9.setSpan(StyleSpan(Typeface.ITALIC), start, comSt9.length, exExFlag)
        comSt9.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt9.length, exExFlag)

        val bdSt8 = SpannableString("த்ரிஷ்டுப்ச் சந்த: |\n")
        bdSt8.setSpan(AbsoluteSizeSpan(14, true), start, bdSt8.length, exExFlag)
        bdSt8.setSpan(StyleSpan(Typeface.BOLD), start, bdSt8.length, exExFlag)
        bdSt8.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt8.length, exExFlag)

        val comSt10 = SpannableString("(மார்பைத் தொட்டு)-")
        comSt10.setSpan(AbsoluteSizeSpan(13, true), start, comSt10.length, exExFlag)
        comSt10.setSpan(StyleSpan(Typeface.ITALIC), start, comSt10.length, exExFlag)
        comSt10.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt10.length, exExFlag)

        val bdSt9 = SpannableString("ஸோமோ தேவதா | ஆவர்தனே விநியோக: ||\n")
        bdSt9.setSpan(AbsoluteSizeSpan(14, true), start, bdSt9.length, exExFlag)
        bdSt9.setSpan(StyleSpan(Typeface.BOLD), start, bdSt9.length, exExFlag)
        bdSt9.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt9.length, exExFlag)

        val comSt11 = SpannableString("\n(இடது கையினால் உத்தரிணியில் ஜலம் எடுத்து வலது கை மோதிர விரலால் ஜலத்தைப் " +
                "பிரதரக்ஷரதஷக்ணமாக சுற்றவும்)-")
        comSt11.setSpan(AbsoluteSizeSpan(13, true), start, comSt11.length, exExFlag)
        comSt11.setSpan(StyleSpan(Typeface.ITALIC), start, comSt11.length, exExFlag)
        comSt11.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt11.length, exExFlag)

        val bdSt10 = SpannableString("ஸூமித்ரியான ஆப ஓஷதயஸ்ஸந்து\n")
        bdSt10.setSpan(AbsoluteSizeSpan(14, true), start, bdSt10.length, exExFlag)
        bdSt10.setSpan(StyleSpan(Typeface.BOLD), start, bdSt10.length, exExFlag)
        bdSt10.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt10.length, exExFlag)

        val comSt12 = SpannableString("(மேற்படி ஜலத்தைப் கையில் விட்டு மந்திரத்தைச் சொல்லி பூமியில் விடவும்)-")
        comSt12.setSpan(AbsoluteSizeSpan(13, true), start, comSt12.length, exExFlag)
        comSt12.setSpan(StyleSpan(Typeface.ITALIC), start, comSt12.length, exExFlag)
        comSt12.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt12.length, exExFlag)

        val bdSt11 = SpannableString("துர்மித்ரியாஸ் தஸ்மைஸந்து |\nயோஸ்மான் த்வேஷ்டி\nயஞ்ச வயம் த்விஷ்ம: ||\n")
        bdSt11.setSpan(AbsoluteSizeSpan(14, true), start, bdSt11.length, exExFlag)
        bdSt11.setSpan(StyleSpan(Typeface.BOLD), start, bdSt11.length, exExFlag)
        bdSt11.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt11.length, exExFlag)

        val hdSt9 = SpannableString("\nப்ரோக்ஷணம்\n")
        hdSt9.setSpan(AbsoluteSizeSpan(14, true), start, hdSt9.length, exExFlag)
        hdSt9.setSpan(StyleSpan(Typeface.BOLD), start, hdSt9.length, exExFlag)
        hdSt9.setSpan(UnderlineSpan(), start, hdSt9.length, exExFlag)
        hdSt9.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start,  hdSt9.length, exExFlag)

        val comSt13 = SpannableString("(ஜலத்தை ப்ரோக்ஷித்துக் கொள்ளவும்)\n")
        comSt13.setSpan(AbsoluteSizeSpan(13, true), start, comSt13.length, exExFlag)
        comSt13.setSpan(StyleSpan(Typeface.ITALIC), start, comSt13.length, exExFlag)
        comSt13.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt13.length, exExFlag)

        val bdSt12 = SpannableString("\nஇதமாப: ப்ரவஹத யத்கிஞ்ச துரிதம் மயி |\nயத்வாஹம் அபிதுத்ரோஹ யத்வாசேப உதான்ருதம் ||\n")
        bdSt12.setSpan(AbsoluteSizeSpan(14, true), start, bdSt12.length, exExFlag)
        bdSt12.setSpan(StyleSpan(Typeface.BOLD), start, bdSt12.length, exExFlag)
        bdSt12.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt12.length, exExFlag)

        val hdSt10 = SpannableString("\nஅர்க்ய ப்ரதானம்\n")
        hdSt10.setSpan(AbsoluteSizeSpan(14, true), start, hdSt10.length, exExFlag)
        hdSt10.setSpan(StyleSpan(Typeface.BOLD), start, hdSt10.length, exExFlag)
        hdSt10.setSpan(UnderlineSpan(), start, hdSt10.length, exExFlag)
        hdSt10.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start,  hdSt10.length, exExFlag)

        val comSt14 = SpannableString("(முன்தலையை தொட்டு)-")
        comSt14.setSpan(AbsoluteSizeSpan(13, true), start, comSt14.length, exExFlag)
        comSt14.setSpan(StyleSpan(Typeface.ITALIC), start, comSt14.length, exExFlag)
        comSt14.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt14.length, exExFlag)

        val bdSt13 = SpannableString("அர்க்யப்ரதான மஹாமந்த்ரஸ்ய\nவிஸ்வாமித்ரோ பகவான் ரிஷி:|\n")
        bdSt13.setSpan(AbsoluteSizeSpan(14, true), start, bdSt13.length, exExFlag)
        bdSt13.setSpan(StyleSpan(Typeface.BOLD), start, bdSt13.length, exExFlag)
        bdSt13.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt13.length, exExFlag)

        val comSt15 = SpannableString("(மூக்கை தொட்டு)-")
        comSt15.setSpan(AbsoluteSizeSpan(13, true), start, comSt15.length, exExFlag)
        comSt15.setSpan(StyleSpan(Typeface.ITALIC), start, comSt15.length, exExFlag)
        comSt15.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt15.length, exExFlag)

        val bdSt14 = SpannableString("தேவீ காயத்ரீச் சந்த: |\n")
        bdSt14.setSpan(AbsoluteSizeSpan(14, true), start, bdSt14.length, exExFlag)
        bdSt14.setSpan(StyleSpan(Typeface.BOLD), start, bdSt14.length, exExFlag)
        bdSt14.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt14.length, exExFlag)

        val comSt16 = SpannableString("(மார்பைத் தொட்டு)-")
        comSt16.setSpan(AbsoluteSizeSpan(13, true), start, comSt16.length, exExFlag)
        comSt16.setSpan(StyleSpan(Typeface.ITALIC), start, comSt16.length, exExFlag)
        comSt16.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt16.length, exExFlag)

        val bdSt15 = SpannableString("ஸவிதா பரமாத்மா தேவதா |\nஅர்க்யப்ரதானே வினியோக: ||\n")
        bdSt15.setSpan(AbsoluteSizeSpan(14, true), start, bdSt15.length, exExFlag)
        bdSt15.setSpan(StyleSpan(Typeface.BOLD), start, bdSt15.length, exExFlag)
        bdSt15.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt15.length, exExFlag)

        val hdSt11 = SpannableString("\nத்யானம்\n")
        hdSt11.setSpan(AbsoluteSizeSpan(14, true), start, hdSt11.length, exExFlag)
        hdSt11.setSpan(StyleSpan(Typeface.BOLD), start, hdSt11.length, exExFlag)
        hdSt11.setSpan(UnderlineSpan(), start, hdSt11.length, exExFlag)
        hdSt11.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start,  hdSt11.length, exExFlag)

        val comSt17 = SpannableString("(இரு கைகளையும் கூப்பிக் கொண்டு)\n")
        comSt17.setSpan(AbsoluteSizeSpan(13, true), start, comSt17.length, exExFlag)
        comSt17.setSpan(StyleSpan(Typeface.ITALIC), start, comSt17.length, exExFlag)
        comSt17.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt17.length, exExFlag)

        val bdSt16 = SpannableString("\nவேதஸாரம் பரஞ்ஜ்யோதிர் மூலபூதம் பராத்பரம்|\nஹ்ருதிஸ்தம் ஸர்வபூதஸ்தம்\nமண்டலாந்தர்வ்யவஸ்திதம் ||" +
                "\nவஜ்ராயுத ஸஹஸ்ரஸ்ய\nஸத்ருத் ஸந்தான காரணம் |\nசிந்தயேத் பரமாத்மானம்\nஅபஊர்த்வம் விநிக்ஷிபேத் ||")
        bdSt16.setSpan(AbsoluteSizeSpan(14, true), start, bdSt16.length, exExFlag)
        bdSt16.setSpan(StyleSpan(Typeface.BOLD), start, bdSt16.length, exExFlag)
        bdSt16.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt16.length, exExFlag)

        val comSt18A = SpannableString("\n(இரு கைகளையும் ஒன்று சேர்த்து குழிவாக வைத்து அதில் நீரை எடுத்து இரு கட்டை விரல்களையும் " +
                "பிரித்து வைத்துக் கொண்டு ௸ காயத்ரீமந்திரத்தைச் சொல்லி எழுந்து நின்று குதிகால்கள் கீழே படாமல் கைகளை உயரே தூக்கியவண்ணம் " +
                "கிழக்கு திசை நோக்கி மூன்று அர்க்யம் விடவேண்டும்.)\n")
        comSt18A.setSpan(AbsoluteSizeSpan(13, true), start, comSt18A.length, exExFlag)
        comSt18A.setSpan(StyleSpan(Typeface.ITALIC), start, comSt18A.length, exExFlag)
        comSt18A.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt18A.length, exExFlag)

        val comSt18B = SpannableString("\n(இரு கைகளையும் ஒன்று சேர்த்து குழிவாக வைத்து அதில் நீரை எடுத்து இரு கட்டை விரல்களையும் " +
                "பிரித்து வைத்துக் கொண்டு ௸ காயத்ரீமந்திரத்தைச் சொல்லி கைகளை உயரே தூக்கியவண்ணம் கிழக்கு திசை நோக்கி இரண்டு அர்க்யம் விடவேண்டும்.)\n")
        comSt18B.setSpan(AbsoluteSizeSpan(13, true), start, comSt18B.length, exExFlag)
        comSt18B.setSpan(StyleSpan(Typeface.ITALIC), start, comSt18B.length, exExFlag)
        comSt18B.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt18B.length, exExFlag)

        val comSt18C = SpannableString("\n(இரு கைகளையும் ஒன்று சேர்த்து குழிவாக வைத்து அதில் நீரை எடுத்து இரு கட்டை விரல்களையும் " +
                "பிரித்து வைத்துக் கொண்டு ௸ காயத்ரீமந்திரத்தைச் சொல்லி கைகளை உயரே தூக்கியவண்ணம் மேற்கு திசை நோக்கி மூன்று அர்க்யம் விடவேண்டும்.)\n")
        comSt18C.setSpan(AbsoluteSizeSpan(13, true), start, comSt18C.length, exExFlag)
        comSt18C.setSpan(StyleSpan(Typeface.ITALIC), start, comSt18C.length, exExFlag)
        comSt18C.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt18C.length, exExFlag)

        val bdSt17 = SpannableString("ஓம்: பூர்புவஸ்வ: \n    தத்ஸவிதுர் வரேண்யம் \nபர்கோ தேவஸ்ய தீமஹி \n    தீயோ யோந: ப்ரசோதயாத் ||")
        bdSt17.setSpan(AbsoluteSizeSpan(14, true), start, bdSt17.length, exExFlag)
        bdSt17.setSpan(StyleSpan(Typeface.BOLD), start, bdSt17.length, exExFlag)
        bdSt17.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt17.length, exExFlag)

        val bdSt18 = SpannableString("\nமமோபாத்த ஸமஸ்த துரிதஷயத்வாரா\nஸ்ரீபரமேச்வர ப்ரீத்யர்த்தம்")
        bdSt18.setSpan(AbsoluteSizeSpan(14, true), start, bdSt18.length, exExFlag)
        bdSt18.setSpan(StyleSpan(Typeface.BOLD), start, bdSt18.length, exExFlag)
        bdSt18.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt18.length, exExFlag)

        val bdSt19A = SpannableString("\nப்ராதஸ்ஸந்த்யாவந்தன")
        bdSt19A.setSpan(AbsoluteSizeSpan(14, true), start, bdSt19A.length, exExFlag)
        bdSt19A.setSpan(StyleSpan(Typeface.BOLD), start, bdSt19A.length, exExFlag)
        bdSt19A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt19A.length, exExFlag)

        val bdSt19B = SpannableString("\nமாத்யாதன்ன்ஹிக")
        bdSt19B.setSpan(AbsoluteSizeSpan(14, true), start, bdSt19B.length, exExFlag)
        bdSt19B.setSpan(StyleSpan(Typeface.BOLD), start, bdSt19B.length, exExFlag)
        bdSt19B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt19B.length, exExFlag)

        val bdSt19C = SpannableString("\nஸாயம் ஸந்த்யாவந்தன")
        bdSt19C.setSpan(AbsoluteSizeSpan(14, true), start, bdSt19C.length, exExFlag)
        bdSt19C.setSpan(StyleSpan(Typeface.BOLD), start, bdSt19C.length, exExFlag)
        bdSt19C.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt19C.length, exExFlag)

        val bdSt20 = SpannableString(" காலாதீத தோஷப்ராயச்சித்தார்க்யம் கரிஷ்யே ||")
        bdSt20.setSpan(AbsoluteSizeSpan(14, true), start, bdSt20.length, exExFlag)
        bdSt20.setSpan(StyleSpan(Typeface.BOLD), start, bdSt20.length, exExFlag)
        bdSt20.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt20.length, exExFlag)

        val hdSt12 = SpannableString("\nப்ராயச்சித்தார்க்யம்\n")
        hdSt12.setSpan(AbsoluteSizeSpan(14, true), start, hdSt12.length, exExFlag)
        hdSt12.setSpan(StyleSpan(Typeface.BOLD), start, hdSt12.length, exExFlag)
        hdSt12.setSpan(UnderlineSpan(), start, hdSt12.length, exExFlag)
        hdSt12.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start,  hdSt12.length, exExFlag)

        val comSt19 = SpannableString("(ஒரு முறை அர்க்யம் விடவேண்டும்)\n")
        comSt19.setSpan(AbsoluteSizeSpan(13, true), start, comSt19.length, exExFlag)
        comSt19.setSpan(StyleSpan(Typeface.ITALIC), start, comSt19.length, exExFlag)
        comSt19.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt19.length, exExFlag)

        val bdSt21 = SpannableString("ஓம் பூர்புவஸ் ஸ்வ:\nதத்ஸதுவிதுர் வரேண்யம் பர்கோ\nதேவஸ்ய தீமஹி தியோ யோந: ப்ரசோதயாத் ||\n")
        bdSt21.setSpan(AbsoluteSizeSpan(14, true), start, bdSt21.length, exExFlag)
        bdSt21.setSpan(StyleSpan(Typeface.BOLD), start, bdSt21.length, exExFlag)
        bdSt21.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt21.length, exExFlag)

        val hdSt13 = SpannableString("\nஸந்த்யாதேவி பிரார்த்தனை\n")
        hdSt13.setSpan(AbsoluteSizeSpan(14, true), start, hdSt13.length, exExFlag)
        hdSt13.setSpan(StyleSpan(Typeface.BOLD), start, hdSt13.length, exExFlag)
        hdSt13.setSpan(UnderlineSpan(), start, hdSt13.length, exExFlag)
        hdSt13.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start,  hdSt13.length, exExFlag)

        val comSt20 = SpannableString("(ஜலத்தை இரு கைகளாலும்  தொட்டுக் கொண்டு மந்திர முடிவில் இரு கைகளையும் மார்பில் வைத்துக் கொள்ளவும்)\n")
        comSt20.setSpan(AbsoluteSizeSpan(13, true), start, comSt20.length, exExFlag)
        comSt20.setSpan(StyleSpan(Typeface.ITALIC), start, comSt20.length, exExFlag)
        comSt20.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt20.length, exExFlag)

        val bdSt22 = SpannableString("உத்திஷ்ட தேவி \n   கந்தவ்யம் புனராகமனாய ச |\nப்ரஸீத தேவி ஸந்துஷ்டா \n   ப்ரவிச்ய ஹ்ருதயம் மம ||\n")
        bdSt22.setSpan(AbsoluteSizeSpan(14, true), start, bdSt22.length, exExFlag)
        bdSt22.setSpan(StyleSpan(Typeface.BOLD), start, bdSt22.length, exExFlag)
        bdSt22.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt22.length, exExFlag)

        val comSt21 = SpannableString("(தன்னைத் தானே ப்ரதக்ஷிணம் செய்து கொண்டு ஜலத்தை பூமியில் விட்டபடியே ஒரு சுற்று சுற்றவேண்டும்)-")
        comSt21.setSpan(AbsoluteSizeSpan(13, true), start, comSt21.length, exExFlag)
        comSt21.setSpan(StyleSpan(Typeface.ITALIC), start, comSt21.length, exExFlag)
        comSt21.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt21.length, exExFlag)

        val bdSt23 = SpannableString("ஓம் பூர்புவஸ்ஸூவ: ||\n")
        bdSt23.setSpan(AbsoluteSizeSpan(14, true), start, bdSt23.length, exExFlag)
        bdSt23.setSpan(StyleSpan(Typeface.BOLD), start, bdSt23.length, exExFlag)
        bdSt23.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt23.length, exExFlag)

        val hdSt14 = SpannableString("\nஐக்ய அனுஸந்தானம்\n")
        hdSt14.setSpan(AbsoluteSizeSpan(14, true), start, hdSt14.length, exExFlag)
        hdSt14.setSpan(StyleSpan(Typeface.BOLD), start, hdSt14.length, exExFlag)
        hdSt14.setSpan(UnderlineSpan(), start, hdSt14.length, exExFlag)
        hdSt14.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start,  hdSt14.length, exExFlag)

        val comSt22 = SpannableString("(இரு கைகளையும் கூப்பி சூரியயனை நோக்கி ப்ரார்த்திக்க வேண்டும்)\n")
        comSt22.setSpan(AbsoluteSizeSpan(13, true), start, comSt22.length, exExFlag)
        comSt22.setSpan(StyleSpan(Typeface.ITALIC), start, comSt22.length, exExFlag)
        comSt22.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt22.length, exExFlag)

        val bdSt24 = SpannableString("அஸாவாதித்யோ ப்ரம்ஹ|\nபரம்ஹைவ ஸத்யம்|\nபரம்மைவாஹம்|\nஅஹம் ப்ரம்ஹாஸ்மி ||")
        bdSt24.setSpan(AbsoluteSizeSpan(14, true), start, bdSt24.length, exExFlag)
        bdSt24.setSpan(StyleSpan(Typeface.BOLD), start, bdSt24.length, exExFlag)
        bdSt24.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt24.length, exExFlag)

        val hdSt15 = SpannableString("\nதேவதர்ப்பணம்\n\n(நவக்ரஹகேசவாதி தேவ தர்ப்பணம்\n")
        hdSt15.setSpan(AbsoluteSizeSpan(14, true), start, hdSt15.length, exExFlag)
        hdSt15.setSpan(StyleSpan(Typeface.BOLD), start, hdSt15.length, exExFlag)
        hdSt15.setSpan(UnderlineSpan(), start, hdSt15.length, exExFlag)
        hdSt15.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start,  hdSt15.length, exExFlag)

        val comSt23 = SpannableString("(வலது உள்ளங்கையை நேராக கீழ்முகமாகத் தொங்கவிட்டு இடது கையினால் உத்தரணியில் " +
                "ஜலம் எடுத்து ஒவ்வொரு தரமாக ஜலத்தை வலது கையில் விட்டு கீழே விடவேண்டும்)\n")
        comSt23.setSpan(AbsoluteSizeSpan(13, true), start, comSt23.length, exExFlag)
        comSt23.setSpan(StyleSpan(Typeface.ITALIC), start, comSt23.length, exExFlag)
        comSt23.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt23.length, exExFlag)

        val bdSt25 = SpannableString("\nஓம் ப்ரம்மணே நம: |\n" +
                "   ஓம் அக்னயே நம: |\n" +
                "ஓம் ப்ருதிவ்யை நம: |\n" +
                "   ஓம் ஓஷதிப்யோ நம: |\n" +
                "ஓம் வாசே நம: |\n" +
                "   ஓம் வாசஸ்பதயே நம: |\n" +
                "ஓம் விஷ்ணவே நம: |\n" +
                "   ஓம் மஹத்ப்யோ நம: |\n" +
                "ஓம் அதப்யோ நம: |\n" +
                "   ஓம் அபாம் பதயே நம: |\n" +
                "ஓம் வருணாய நம: |\n" +
                "   ஓம் மஹதே நம: |\n" +
                "மஹதே கரோமி |\n" +
                "   ஆதித்யம் தர்ப்பயாமி\n" +
                "ஸோமம் தர்ப்பயாமி\n" +
                "   அங்காரகம் தர்ப்பயாமி\n" +
                "புதம் தர்ப்பயாமி\n" +
                "   பிருஹஸ்பதிம் தர்ப்பயாமி\n" +
                "பகவந்தம்சுக்ரம் தர்ப்பயாமி\n" +
                "   சநைஸ்சரம் தர்ப்பயாமி\n" +
                "ராஹூம் தர்ப்பயாமி\n" +
                "   கேதும் தர்ப்பயாமி\n" +
                "கேசவம் தர்ப்பயாமி\n" +
                "   நாராயணம் தர்ப்பயாமி\n" +
                "மாதவம் தர்ப்பயாமி\n" +
                "   கோவிந்தம் தர்ப்பயாமி\n" +
                "விஷ்ணும் தர்ப்பயாமி\n" +
                "   மதுஸூதனம் தர்ப்பயாமி\n" +
                "த்ரிவிக்ரமம் தர்ப்பயாமி\n" +
                "   வாமனம் தர்ப்பயாமி\n" +
                "ஸ்ரீதரம் தர்ப்பயாமி\n" +
                "   ஹ்ருஷீகேசம் தர்ப்பயாமி\n" +
                "பத்மநாபம் தர்ப்பயாமி\n" +
                "   தாமோதரம் தர்ப்பயாமி\n" +
                "ஸங்கர்ஷணம் தர்ப்பயாமி\n" +
                "   வாஸூதேவம் தர்ப்பயாமி\n" +
                "ப்ரத்யும்நம் தர்ப்பயாமி\n" +
                "   அநிருத்தம் தர்ப்பயாமி\n" +
                "புருஷோத்தமம் தர்ப்பயாமி\n" +
                "   அதோக்ஷஜம்  தர்ப்பயாமி\n" +
                "நாரஸிம்ஹம் தர்ப்பயாமி\n" +
                "   அச்யுதம் தர்ப்பயாமி\n" +
                "ஜனார்த்தனம் தர்ப்பயாமி\n" +
                "   உபேந்த்ரம் தர்ப்பயாமி\n" +
                "ஸ்ரீ ஹரீம் தர்ப்பயாமி\n" +
                "   ஸ்ரீ கிருஷ்ணம் தர்ப்பயாமி|\n" +
                "தர்ப்பயாமி|| தர்ப்பயாமி ||")
        bdSt25.setSpan(AbsoluteSizeSpan(14, true), start, bdSt25.length, exExFlag)
        bdSt25.setSpan(StyleSpan(Typeface.BOLD), start, bdSt25.length, exExFlag)
        bdSt25.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt25.length, exExFlag)

        val hdSt16 = SpannableString("\nவந்தன ஜபம்\n")
        hdSt16.setSpan(AbsoluteSizeSpan(14, true), start, hdSt16.length, exExFlag)
        hdSt16.setSpan(StyleSpan(Typeface.BOLD), start, hdSt16.length, exExFlag)
        hdSt16.setSpan(UnderlineSpan(), start, hdSt16.length, exExFlag)
        hdSt16.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start,  hdSt16.length, exExFlag)

        val comSt24A = SpannableString("(காலையில் கிழக்குமுகமாக செய்ய வேண்டும். மேல் வஸ்திரத்தை யஞ்ஜோபவீதம் போல் இடது தோளில் போட்டுக் " +
                "கொள்ளவும் = 1/2 உத்தரணி ஜலத்தினால் ஜபத்திற்கு உட்காரும் இடத்தை புரோக்ஷித்து அதன் மேல் ஆஸனம் போட்டுக் கொண்டு அமரவும்)")
        comSt24A.setSpan(AbsoluteSizeSpan(13, true), start, comSt24A.length, exExFlag)
        comSt24A.setSpan(StyleSpan(Typeface.ITALIC), start, comSt24A.length, exExFlag)
        comSt24A.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt24A.length, exExFlag)

        val comSt24B = SpannableString("(மாலையில் மேற்கு முகமாக செய்ய வேண்டும். மேல் வஸ்திரத்தை யஞ்ஜோபவீதம் போல் இடது தோளில் போட்டுக் " +
                "கொள்ளவும் = 1/2 உத்தரணி ஜலத்தினால் ஜபத்திற்கு உட்காரும் இடத்தை புரோக்ஷித்து அதன் மேல் ஆஸனம் போட்டுக் கொண்டு அமரவும்)")
        comSt24B.setSpan(AbsoluteSizeSpan(13, true), start, comSt24B.length, exExFlag)
        comSt24B.setSpan(StyleSpan(Typeface.ITALIC), start, comSt24B.length, exExFlag)
        comSt24B.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt24B.length, exExFlag)

        val bdSt26 = SpannableString("\nஓம் பூர் புவஸ்ஸுவ: |\n")
        bdSt26.setSpan(AbsoluteSizeSpan(14, true), start, bdSt26.length, exExFlag)
        bdSt26.setSpan(StyleSpan(Typeface.BOLD), start, bdSt26.length, exExFlag)
        bdSt26.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt26.length, exExFlag)

        val comSt25 = SpannableString("\n(முன் தலையை தொட்டு)-")
        comSt25.setSpan(AbsoluteSizeSpan(13, true), start, comSt25.length, exExFlag)
        comSt25.setSpan(StyleSpan(Typeface.ITALIC), start, comSt25.length, exExFlag)
        comSt25.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt25.length, exExFlag)

        val bdSt27 = SpannableString("அஸ்ய ஸ்ரீ ஸாயம் ஸந்த்யா வந்தன\nமஹா மந்த்ரஸ்ய ஸாந்தீபனிர் \nபகவான் ரிஷி: |\n")
        bdSt27.setSpan(AbsoluteSizeSpan(14, true), start, bdSt27.length, exExFlag)
        bdSt27.setSpan(StyleSpan(Typeface.BOLD), start, bdSt27.length, exExFlag)
        bdSt27.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt27.length, exExFlag)

        val comSt26 = SpannableString("(மூக்கை தொட்டு)-")
        comSt26.setSpan(AbsoluteSizeSpan(13, true), start, comSt26.length, exExFlag)
        comSt26.setSpan(StyleSpan(Typeface.ITALIC), start, comSt26.length, exExFlag)
        comSt26.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt26.length, exExFlag)

        val bdSt28 = SpannableString("அனுஷ்டுப் ச்சந்த: |\n")
        bdSt28.setSpan(AbsoluteSizeSpan(14, true), start, bdSt28.length, exExFlag)
        bdSt28.setSpan(StyleSpan(Typeface.BOLD), start, bdSt28.length, exExFlag)
        bdSt28.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt28.length, exExFlag)

        val comSt27 = SpannableString("(மார்பைத் தொட்டு)-")
        comSt27.setSpan(AbsoluteSizeSpan(13, true), start, comSt27.length, exExFlag)
        comSt27.setSpan(StyleSpan(Typeface.ITALIC), start, comSt27.length, exExFlag)
        comSt27.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt27.length, exExFlag)

        val bdSt29 = SpannableString("ஸந்த்யா ரூபிணீ காயத்ரீ தேவதா ||\n")
        bdSt29.setSpan(AbsoluteSizeSpan(14, true), start, bdSt29.length, exExFlag)
        bdSt29.setSpan(StyleSpan(Typeface.BOLD), start, bdSt29.length, exExFlag)
        bdSt29.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt29.length, exExFlag)

        val comSt28 = SpannableString("(வலது மார்பைத் தொட்டு)-")
        comSt28.setSpan(AbsoluteSizeSpan(13, true), start, comSt28.length, exExFlag)
        comSt28.setSpan(StyleSpan(Typeface.ITALIC), start, comSt28.length, exExFlag)
        comSt28.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt28.length, exExFlag)

        val bdSt30 = SpannableString("அம் பீஜம் |\n")
        bdSt30.setSpan(AbsoluteSizeSpan(14, true), start, bdSt30.length, exExFlag)
        bdSt30.setSpan(StyleSpan(Typeface.BOLD), start, bdSt30.length, exExFlag)
        bdSt30.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt30.length, exExFlag)

        val comSt29 = SpannableString("(இடது மார்பைத் தொட்டு)-")
        comSt29.setSpan(AbsoluteSizeSpan(13, true), start, comSt29.length, exExFlag)
        comSt29.setSpan(StyleSpan(Typeface.ITALIC), start, comSt29.length, exExFlag)
        comSt29.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt29.length, exExFlag)

        val bdSt31 = SpannableString("உம் சக்தி: |\n")
        bdSt31.setSpan(AbsoluteSizeSpan(14, true), start, bdSt31.length, exExFlag)
        bdSt31.setSpan(StyleSpan(Typeface.BOLD), start, bdSt31.length, exExFlag)
        bdSt31.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt31.length, exExFlag)

        val comSt30 = SpannableString("(நடு மார்பைத் தொட்டு)-")
        comSt30.setSpan(AbsoluteSizeSpan(13, true), start, comSt30.length, exExFlag)
        comSt30.setSpan(StyleSpan(Typeface.ITALIC), start, comSt30.length, exExFlag)
        comSt30.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt30.length, exExFlag)

        val bdSt32 = SpannableString("மம் கீலகம்|")
        bdSt32.setSpan(AbsoluteSizeSpan(14, true), start, bdSt32.length, exExFlag)
        bdSt32.setSpan(StyleSpan(Typeface.BOLD), start, bdSt32.length, exExFlag)
        bdSt32.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt32.length, exExFlag)

        val comSt31 = SpannableString("\n(கை கூப்பி)-")
        comSt31.setSpan(AbsoluteSizeSpan(13, true), start, comSt31.length, exExFlag)
        comSt31.setSpan(StyleSpan(Typeface.ITALIC), start, comSt31.length, exExFlag)
        comSt31.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt31.length, exExFlag)

        val bdSt33 = SpannableString("மம ஸகல பாப க்ஷயார்த்தே \nஜபே வினியோக: ||")
        bdSt33.setSpan(AbsoluteSizeSpan(14, true), start, bdSt33.length, exExFlag)
        bdSt33.setSpan(StyleSpan(Typeface.BOLD), start, bdSt33.length, exExFlag)
        bdSt33.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt33.length, exExFlag)

        val hdSt17 = SpannableString("\nகரந்யாஸம்\n")
        hdSt17.setSpan(AbsoluteSizeSpan(14, true), start, hdSt17.length, exExFlag)
        hdSt17.setSpan(StyleSpan(Typeface.BOLD), start, hdSt17.length, exExFlag)
        hdSt17.setSpan(UnderlineSpan(), start, hdSt17.length, exExFlag)
        hdSt17.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start,  hdSt17.length, exExFlag)

        val comSt32 = SpannableString("(இரு கைகளிலும் - ஆள்காட்டி விரலால் கட்டை விரல்களை ஸ்பரிசித்தல்)-")
        comSt32.setSpan(AbsoluteSizeSpan(13, true), start, comSt32.length, exExFlag)
        comSt32.setSpan(StyleSpan(Typeface.ITALIC), start, comSt32.length, exExFlag)
        comSt32.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt32.length, exExFlag)

        val bdSt34 = SpannableString("அம் ஐம் அங்குஷ்டாப்யாம் நம: |\n")
        bdSt34.setSpan(AbsoluteSizeSpan(14, true), start, bdSt34.length, exExFlag)
        bdSt34.setSpan(StyleSpan(Typeface.BOLD), start, bdSt34.length, exExFlag)
        bdSt34.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt34.length, exExFlag)

        val comSt33 = SpannableString("(இரு கைகளிலும் - கட்டை விரலால் ஆள்காட்டி விரல்களை ஸ்பரிசித்தல்)-")
        comSt33.setSpan(AbsoluteSizeSpan(13, true), start, comSt33.length, exExFlag)
        comSt33.setSpan(StyleSpan(Typeface.ITALIC), start, comSt33.length, exExFlag)
        comSt33.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt33.length, exExFlag)

        val bdSt35 = SpannableString("உம் க்லீம் தர்ஜனீப்யாம் நம: |\n")
        bdSt35.setSpan(AbsoluteSizeSpan(14, true), start, bdSt35.length, exExFlag)
        bdSt35.setSpan(StyleSpan(Typeface.BOLD), start, bdSt35.length, exExFlag)
        bdSt35.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt35.length, exExFlag)

        val comSt34 = SpannableString("(இரு கைகளிலும் - கட்டை விரலால் நடு விரல்களை ஸ்பரிசித்தல்)-")
        comSt34.setSpan(AbsoluteSizeSpan(13, true), start, comSt34.length, exExFlag)
        comSt34.setSpan(StyleSpan(Typeface.ITALIC), start, comSt34.length, exExFlag)
        comSt34.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt34.length, exExFlag)

        val bdSt36 = SpannableString("மம் ஸௌ: மத்யமாப்யாம் நம: |\n")
        bdSt36.setSpan(AbsoluteSizeSpan(14, true), start, bdSt36.length, exExFlag)
        bdSt36.setSpan(StyleSpan(Typeface.BOLD), start, bdSt36.length, exExFlag)
        bdSt36.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt36.length, exExFlag)

        val comSt35 = SpannableString("(இரு கைகளிலும் - கட்டை விரலால் மோதிர விரல்களை ஸ்பரிசித்தல்)-")
        comSt35.setSpan(AbsoluteSizeSpan(13, true), start, comSt35.length, exExFlag)
        comSt35.setSpan(StyleSpan(Typeface.ITALIC), start, comSt35.length, exExFlag)
        comSt35.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt35.length, exExFlag)

        val bdSt37 = SpannableString("அம் ஐம் அநாமிகாப்யாம் நம: |\n")
        bdSt37.setSpan(AbsoluteSizeSpan(14, true), start, bdSt37.length, exExFlag)
        bdSt37.setSpan(StyleSpan(Typeface.BOLD), start, bdSt37.length, exExFlag)
        bdSt37.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt37.length, exExFlag)

        val comSt36 = SpannableString("(இரு கைகளிலும் - கட்டை விரலால் சுண்டு விரல்களை ஸ்பரிசித்தல்)-")
        comSt36.setSpan(AbsoluteSizeSpan(13, true), start, comSt36.length, exExFlag)
        comSt36.setSpan(StyleSpan(Typeface.ITALIC), start, comSt36.length, exExFlag)
        comSt36.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt36.length, exExFlag)

        val bdSt38 = SpannableString("உம் க்லீம் கனிஷ்டிகாப்யாம் நம: |\n")
        bdSt38.setSpan(AbsoluteSizeSpan(14, true), start, bdSt38.length, exExFlag)
        bdSt38.setSpan(StyleSpan(Typeface.BOLD), start, bdSt38.length, exExFlag)
        bdSt38.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt38.length, exExFlag)

        val comSt37 = SpannableString("(இரு கைகளையும் உள் மற்றும் வெளிபுறங்களில் ஸ்பரிசித்தல்)-")
        comSt37.setSpan(AbsoluteSizeSpan(13, true), start, comSt37.length, exExFlag)
        comSt37.setSpan(StyleSpan(Typeface.ITALIC), start, comSt37.length, exExFlag)
        comSt37.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt37.length, exExFlag)

        val bdSt39 = SpannableString("மம் ஸௌ: கரதல கரப்ருஷ்டாப்யாம் நம: |\n")
        bdSt39.setSpan(AbsoluteSizeSpan(14, true), start, bdSt39.length, exExFlag)
        bdSt39.setSpan(StyleSpan(Typeface.BOLD), start, bdSt39.length, exExFlag)
        bdSt39.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt39.length, exExFlag)

        val hdSt18 = SpannableString("\nஹ்ருதயாதி ந்யாஸம்\n")
        hdSt18.setSpan(AbsoluteSizeSpan(14, true), start, hdSt18.length, exExFlag)
        hdSt18.setSpan(StyleSpan(Typeface.BOLD), start, hdSt18.length, exExFlag)
        hdSt18.setSpan(UnderlineSpan(), start, hdSt18.length, exExFlag)
        hdSt18.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start,  hdSt18.length, exExFlag)

        val comSt38 = SpannableString("(மார்பைத் தொட்டு)-")
        comSt38.setSpan(AbsoluteSizeSpan(13, true), start, comSt38.length, exExFlag)
        comSt38.setSpan(StyleSpan(Typeface.ITALIC), start, comSt38.length, exExFlag)
        comSt38.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt38.length, exExFlag)

        val bdSt40 = SpannableString("அம் ஐம் ஹருதயாய நம: |\n")
        bdSt40.setSpan(AbsoluteSizeSpan(14, true), start, bdSt40.length, exExFlag)
        bdSt40.setSpan(StyleSpan(Typeface.BOLD), start, bdSt40.length, exExFlag)
        bdSt40.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt40.length, exExFlag)

        val bdSt40A = SpannableString("அம் ஐம் ஹருதயாய நம: |\n")
        bdSt40A.setSpan(AbsoluteSizeSpan(14, true), start, bdSt40A.length, exExFlag)
        bdSt40A.setSpan(StyleSpan(Typeface.BOLD), start, bdSt40A.length, exExFlag)
        bdSt40A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt40A.length, exExFlag)


        val comSt39 = SpannableString("(முன் தலையைத் தொட்டு)-")
        comSt39.setSpan(AbsoluteSizeSpan(13, true), start, comSt39.length, exExFlag)
        comSt39.setSpan(StyleSpan(Typeface.ITALIC), start, comSt39.length, exExFlag)
        comSt39.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt39.length, exExFlag)

        val bdSt41 = SpannableString("உம் க்லீம் சிரஸே ஸ்ஙாஹா |\n")
        bdSt41.setSpan(AbsoluteSizeSpan(14, true), start, bdSt41.length, exExFlag)
        bdSt41.setSpan(StyleSpan(Typeface.BOLD), start, bdSt41.length, exExFlag)
        bdSt41.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt41.length, exExFlag)

        val bdSt41A = SpannableString("உம் க்லீம் சிரஸே ஸ்ஙாஹா |\n")
        bdSt41A.setSpan(AbsoluteSizeSpan(14, true), start, bdSt41A.length, exExFlag)
        bdSt41A.setSpan(StyleSpan(Typeface.BOLD), start, bdSt41A.length, exExFlag)
        bdSt41A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt41A.length, exExFlag)

        val comSt40 = SpannableString("(பின் தலையைத் தொட்டு)-")
        comSt40.setSpan(AbsoluteSizeSpan(13, true), start, comSt40.length, exExFlag)
        comSt40.setSpan(StyleSpan(Typeface.ITALIC), start, comSt40.length, exExFlag)
        comSt40.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt40.length, exExFlag)

        val bdSt42 = SpannableString("மம் ஸௌ: சிகாயை வஷட் |\n")
        bdSt42.setSpan(AbsoluteSizeSpan(14, true), start, bdSt42.length, exExFlag)
        bdSt42.setSpan(StyleSpan(Typeface.BOLD), start, bdSt42.length, exExFlag)
        bdSt42.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt42.length, exExFlag)

        val bdSt42A = SpannableString("மம் ஸௌ: சிகாயை வஷட் |\n")
        bdSt42A.setSpan(AbsoluteSizeSpan(14, true), start, bdSt42A.length, exExFlag)
        bdSt42A.setSpan(StyleSpan(Typeface.BOLD), start, bdSt42A.length, exExFlag)
        bdSt42A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt42A.length, exExFlag)


        val comSt41 = SpannableString("(இரு தோள்களையும் இரு கைகளால் தொட்டு)-")
        comSt41.setSpan(AbsoluteSizeSpan(13, true), start, comSt41.length, exExFlag)
        comSt41.setSpan(StyleSpan(Typeface.ITALIC), start, comSt41.length, exExFlag)
        comSt41.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt41.length, exExFlag)

        val bdSt43 = SpannableString("அம் ஐம் கவசாய ஹூம் |\n")
        bdSt43.setSpan(AbsoluteSizeSpan(14, true), start, bdSt43.length, exExFlag)
        bdSt43.setSpan(StyleSpan(Typeface.BOLD), start, bdSt43.length, exExFlag)
        bdSt43.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt43.length, exExFlag)

        val bdSt43A = SpannableString("அம் ஐம் கவசாய ஹூம் |\n")
        bdSt43A.setSpan(AbsoluteSizeSpan(14, true), start, bdSt43A.length, exExFlag)
        bdSt43A.setSpan(StyleSpan(Typeface.BOLD), start, bdSt43A.length, exExFlag)
        bdSt43A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt43A.length, exExFlag)


        val comSt42 = SpannableString("(மூன்று கண்களை மூன்று விரல்களால் தொட்டு)-")
        comSt42.setSpan(AbsoluteSizeSpan(13, true), start, comSt42.length, exExFlag)
        comSt42.setSpan(StyleSpan(Typeface.ITALIC), start, comSt42.length, exExFlag)
        comSt42.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt42.length, exExFlag)

        val bdSt44 = SpannableString("உம் க்லீம் நேத்ர த்ரயாய வௌஷட் |\n")
        bdSt44.setSpan(AbsoluteSizeSpan(14, true), start, bdSt44.length, exExFlag)
        bdSt44.setSpan(StyleSpan(Typeface.BOLD), start, bdSt44.length, exExFlag)
        bdSt44.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt44.length, exExFlag)

        val bdSt44A = SpannableString("உம் க்லீம் நேத்ர த்ரயாய வௌஷட் |\n")
        bdSt44A.setSpan(AbsoluteSizeSpan(14, true), start, bdSt44A.length, exExFlag)
        bdSt44A.setSpan(StyleSpan(Typeface.BOLD), start, bdSt44A.length, exExFlag)
        bdSt44A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt44A.length, exExFlag)


        val comSt43 = SpannableString("(வலது கை விரல்களைச் சொடுக்கிய வண்ணம் தலையை வலமாகச் சுற்றவும்)-")
        comSt43.setSpan(AbsoluteSizeSpan(13, true), start, comSt43.length, exExFlag)
        comSt43.setSpan(StyleSpan(Typeface.ITALIC), start, comSt43.length, exExFlag)
        comSt43.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt43.length, exExFlag)

        val bdSt45 = SpannableString("மம் ஸௌ: மஸ்த்ராய பட் |\n")
        bdSt45.setSpan(AbsoluteSizeSpan(14, true), start, bdSt45.length, exExFlag)
        bdSt45.setSpan(StyleSpan(Typeface.BOLD), start, bdSt45.length, exExFlag)
        bdSt45.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt45.length, exExFlag)

        val bdSt45A = SpannableString("மம் ஸௌ: மஸ்த்ராய பட் |\n")
        bdSt45A.setSpan(AbsoluteSizeSpan(14, true), start, bdSt45A.length, exExFlag)
        bdSt45A.setSpan(StyleSpan(Typeface.BOLD), start, bdSt45A.length, exExFlag)
        bdSt45A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt45A.length, exExFlag)

        val comSt44 = SpannableString("(வலது கை விரல்களைச் சொடுக்கிய வண்ணம் தலையை வலமாகச் சுற்றி இடது கையில் தட்டவும்)-")
        comSt44.setSpan(AbsoluteSizeSpan(13, true), start, comSt44.length, exExFlag)
        comSt44.setSpan(StyleSpan(Typeface.ITALIC), start, comSt44.length, exExFlag)
        comSt44.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt44.length, exExFlag)

        val bdSt46 = SpannableString("பூர்புவஸ் ஸ்வரோம் இதி திக்பந்த: ||\n")
        bdSt46.setSpan(AbsoluteSizeSpan(14, true), start, bdSt46.length, exExFlag)
        bdSt46.setSpan(StyleSpan(Typeface.BOLD), start, bdSt46.length, exExFlag)
        bdSt46.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt46.length, exExFlag)

        val hdSt19 = SpannableString("\nத்யானம்\n")
        hdSt19.setSpan(AbsoluteSizeSpan(14, true), start, hdSt19.length, exExFlag)
        hdSt19.setSpan(StyleSpan(Typeface.BOLD), start, hdSt19.length, exExFlag)
        hdSt19.setSpan(UnderlineSpan(), start, hdSt19.length, exExFlag)
        hdSt19.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start,  hdSt19.length, exExFlag)

        val comSt45 = SpannableString("(இருகைகளையும் கூப்பி)\n")
        comSt45.setSpan(AbsoluteSizeSpan(13, true), start, comSt45.length, exExFlag)
        comSt45.setSpan(StyleSpan(Typeface.ITALIC), start, comSt45.length, exExFlag)
        comSt45.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt45.length, exExFlag)

        val bdSt47 = SpannableString("\nஓம் ஹருத்பத்ம கர்ணிகாமத்யே\nசுத்த தீபசிகாக்ருதிம்|\n" +
                "        ஓம் அங்குஷ்டமாத்ராம் அமலாம்\nத்யாயேத் ஓங்கார்ரூபிணீம் ||\n" +
                "        ஓம் க்ருத்வாஸ்ந்த்யாம் அபித்யாயேத்\nநீலக்ரீவாம் ஸூ சோபனாம் |\n" +
                "        வரதாபய ஹஸ்தாம் தாம்\nத்ரிணேத்ராம் சந்த்ரசேகராம்||\n" +
                "        ப்ரணவம் பரமாத்மானம்\nஜப்த்வா பக்தி ஸமன்வித:|\n" +
                "        ஸ்வாத்மநா தாம்பித்யாயேத்\nதண்டவத் ப்ரணமேத்புவி||\n" +
                "        அஹோமாயே ப்ரம்ஹரூபே\nத்வயே ஸந்த்யே ஸரஸ்வதி|\n" +
                "        அஜரேஹமாயே சைவ\nபிரம்மயோனி நமோஸ்துதே ||\n" +
                "        ப்ராதராரஞ்ஜிதே தேவி\nருங்மயே பிரம்மரூபிணி ||\n" +
                "        யஜூர்வேதமயே சுத்தே\nமத்யான்னே ருத்ர்ரூபிணி |\n" +
                "        ஸாயம் ஸாம்மயே க்ருஷ்ணே\nஸந்த்யே விஷ்ணு ஸ்வரூபிணி |\n" +
                "        மயா க்ருதான்யசேஷாணி\nபாபானி ப்ரணுதாசு மே ||\n" +
                "        பத்ப்யாம் கராப்யாம் சக்ஷூர்ப்யாம்\nஜிஹ்வோபஸ்தேந்த்ரியாதிபி:|\n" +
                "        க்ருதானி யானி பாபானி\nபஸ்மஸாத்குரு தானி மே:||\n" +
                "        ஸந்த்யேதேவி ஜகத்வந்த்யே\nதிவ்யஸந்த்யே நமோஸ்துதே |\n" +
                "        ஸத்வாம் ஸந்த்யாம் அபித்யாயே\nஸர்வாபீஷ்டம் ப்ரயச்சமே||\n")
        bdSt47.setSpan(AbsoluteSizeSpan(14, true), start, bdSt47.length, exExFlag)
        bdSt47.setSpan(StyleSpan(Typeface.BOLD), start, bdSt47.length, exExFlag)
        bdSt47.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt47.length, exExFlag)

        val hdSt20 = SpannableString("\nபஞ்ச பூஜை\n")
        hdSt20.setSpan(AbsoluteSizeSpan(14, true), start, hdSt20.length, exExFlag)
        hdSt20.setSpan(StyleSpan(Typeface.BOLD), start, hdSt20.length, exExFlag)
        hdSt20.setSpan(UnderlineSpan(), start, hdSt20.length, exExFlag)
        hdSt20.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start,  hdSt20.length, exExFlag)

        val comSt46 = SpannableString("(இரு கட்டை விரலால் இரு சுண்டு விரல்களை ஸ்பரிசித்தல்)-")
        comSt46.setSpan(AbsoluteSizeSpan(13, true), start, comSt46.length, exExFlag)
        comSt46.setSpan(StyleSpan(Typeface.ITALIC), start, comSt46.length, exExFlag)
        comSt46.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt46.length, exExFlag)

        val bdSt48 = SpannableString("லம் பிருதிவ்யாத்மனே கந்தான் தாரயாமி|\n")
        bdSt48.setSpan(AbsoluteSizeSpan(14, true), start, bdSt48.length, exExFlag)
        bdSt48.setSpan(StyleSpan(Typeface.BOLD), start, bdSt48.length, exExFlag)
        bdSt48.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt48.length, exExFlag)

        val bdSt48A = SpannableString("லம் பிருதிவ்யாத்மனே கந்தான் தாரயாமி|\n")
        bdSt48A.setSpan(AbsoluteSizeSpan(14, true), start, bdSt48A.length, exExFlag)
        bdSt48A.setSpan(StyleSpan(Typeface.BOLD), start, bdSt48A.length, exExFlag)
        bdSt48A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt48A.length, exExFlag)

        val comSt47 = SpannableString("(இரு ஆள்காட்டி விரல்களால் இரு கட்டை விரல்களை ஸ்பரிசித்தல்)-")
        comSt47.setSpan(AbsoluteSizeSpan(13, true), start, comSt47.length, exExFlag)
        comSt47.setSpan(StyleSpan(Typeface.ITALIC), start, comSt47.length, exExFlag)
        comSt47.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt47.length, exExFlag)

        val bdSt49 = SpannableString("ஹம் ஆகாசாத்மனே புஷ்பாணி ஸமர்ப்பயாமி|\n")
        bdSt49.setSpan(AbsoluteSizeSpan(14, true), start, bdSt49.length, exExFlag)
        bdSt49.setSpan(StyleSpan(Typeface.BOLD), start, bdSt49.length, exExFlag)
        bdSt49.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt49.length, exExFlag)

        val bdSt49A = SpannableString("ஹம் ஆகாசாத்மனே புஷ்பாணி ஸமர்ப்பயாமி|\n")
        bdSt49A.setSpan(AbsoluteSizeSpan(14, true), start, bdSt49A.length, exExFlag)
        bdSt49A.setSpan(StyleSpan(Typeface.BOLD), start, bdSt49A.length, exExFlag)
        bdSt49A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt49A.length, exExFlag)

        val comSt48 = SpannableString("(இரு கட்டை விரல்களால் இரு ஆள்காட்டி விரல்களை ஸ்பரிசித்தல்)-")
        comSt48.setSpan(AbsoluteSizeSpan(13, true), start, comSt48.length, exExFlag)
        comSt48.setSpan(StyleSpan(Typeface.ITALIC), start, comSt48.length, exExFlag)
        comSt48.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt48.length, exExFlag)

        val bdSt50 = SpannableString("யம் வாய்வாத்மனே தூபம் ஆக்ராபயாமி |\n")
        bdSt50.setSpan(AbsoluteSizeSpan(14, true), start, bdSt50.length, exExFlag)
        bdSt50.setSpan(StyleSpan(Typeface.BOLD), start, bdSt50.length, exExFlag)
        bdSt50.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt50.length, exExFlag)

        val bdSt50A = SpannableString("யம் வாய்வாத்மனே தூபம் ஆக்ராபயாமி |\n")
        bdSt50A.setSpan(AbsoluteSizeSpan(14, true), start, bdSt50A.length, exExFlag)
        bdSt50A.setSpan(StyleSpan(Typeface.BOLD), start, bdSt50A.length, exExFlag)
        bdSt50A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt50A.length, exExFlag)

        val comSt49 = SpannableString("(இரு கட்டை விரல்களால் இரு நடு விரல்களை ஸ்பரிசித்தல்)-")
        comSt49.setSpan(AbsoluteSizeSpan(13, true), start, comSt49.length, exExFlag)
        comSt49.setSpan(StyleSpan(Typeface.ITALIC), start, comSt49.length, exExFlag)
        comSt49.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt49.length, exExFlag)

        val bdSt51 = SpannableString("ரம் வன்ஹ்யாத்மனே தீபம் தர்சயாமி |\n")
        bdSt51.setSpan(AbsoluteSizeSpan(14, true), start, bdSt51.length, exExFlag)
        bdSt51.setSpan(StyleSpan(Typeface.BOLD), start, bdSt51.length, exExFlag)
        bdSt51.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt51.length, exExFlag)

        val bdSt51A = SpannableString("ரம் வன்ஹ்யாத்மனே தீபம் தர்சயாமி |\n")
        bdSt51A.setSpan(AbsoluteSizeSpan(14, true), start, bdSt51A.length, exExFlag)
        bdSt51A.setSpan(StyleSpan(Typeface.BOLD), start, bdSt51A.length, exExFlag)
        bdSt51A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt51A.length, exExFlag)

        val comSt50 = SpannableString("(இரு கட்டை விரல்களால் மோதிர விரல்களை ஸ்பரிசித்தல்)-")
        comSt50.setSpan(AbsoluteSizeSpan(13, true), start, comSt50.length, exExFlag)
        comSt50.setSpan(StyleSpan(Typeface.ITALIC), start, comSt50.length, exExFlag)
        comSt50.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt50.length, exExFlag)

        val bdSt52 = SpannableString("வம் அம்ருதாத்மனே திவ்யாம்ருத மஹா நைவேத்யம் நிவேதயாமி |\n")
        bdSt52.setSpan(AbsoluteSizeSpan(14, true), start, bdSt52.length, exExFlag)
        bdSt52.setSpan(StyleSpan(Typeface.BOLD), start, bdSt52.length, exExFlag)
        bdSt52.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt52.length, exExFlag)

        val bdSt52A = SpannableString("வம் அம்ருதாத்மனே திவ்யாம்ருத மஹா நைவேத்யம் நிவேதயாமி |\n")
        bdSt52A.setSpan(AbsoluteSizeSpan(14, true), start, bdSt52A.length, exExFlag)
        bdSt52A.setSpan(StyleSpan(Typeface.BOLD), start, bdSt52A.length, exExFlag)
        bdSt52A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt52A.length, exExFlag)

        val comSt51 = SpannableString("(இரு கைகளை கூப்பி)-")
        comSt51.setSpan(AbsoluteSizeSpan(13, true), start, comSt51.length, exExFlag)
        comSt51.setSpan(StyleSpan(Typeface.ITALIC), start, comSt51.length, exExFlag)
        comSt51.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt51.length, exExFlag)

        val bdSt53 = SpannableString("ஸம் ஸர்வாத்மனே ஸமஸ்த ராஜோபசாரான் தேவோபசாரான் ஸமர்ப்பயாமி ||\n")
        bdSt53.setSpan(AbsoluteSizeSpan(14, true), start, bdSt53.length, exExFlag)
        bdSt53.setSpan(StyleSpan(Typeface.BOLD), start, bdSt53.length, exExFlag)
        bdSt53.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt53.length, exExFlag)

        val bdSt53A = SpannableString("ஸம் ஸர்வாத்மனே ஸமஸ்த ராஜோபசாரான் தேவோபசாரான் ஸமர்ப்பயாமி ||\n")
        bdSt53A.setSpan(AbsoluteSizeSpan(14, true), start, bdSt53A.length, exExFlag)
        bdSt53A.setSpan(StyleSpan(Typeface.BOLD), start, bdSt53A.length, exExFlag)
        bdSt53A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt53A.length, exExFlag)

        val hdSt21 = SpannableString("\nமூலமந்திரம்\n")
        hdSt21.setSpan(AbsoluteSizeSpan(14, true), start, hdSt21.length, exExFlag)
        hdSt21.setSpan(StyleSpan(Typeface.BOLD), start, hdSt21.length, exExFlag)
        hdSt21.setSpan(UnderlineSpan(), start, hdSt21.length, exExFlag)
        hdSt21.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start,  hdSt21.length, exExFlag)

        val comSt52 = SpannableString("(இம்மந்திரத்தை 16 தரமாவது உச்சரிக்க வேண்டும்)\n")
        comSt52.setSpan(AbsoluteSizeSpan(13, true), start, comSt52.length, exExFlag)
        comSt52.setSpan(StyleSpan(Typeface.ITALIC), start, comSt52.length, exExFlag)
        comSt52.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt52.length, exExFlag)

        val bdSt54 = SpannableString("\n 1.ஓம் அம் ஐம் உம் க்லீம் மம் ஸௌ:\n" +
                " 2.ஓம் அம் ஐம் உம் க்லீம் மம் ஸௌ:\n" +
                " 3.ஓம் அம் ஐம் உம் க்லீம் மம் ஸௌ:\n" +
                " 4.ஓம் அம் ஐம் உம் க்லீம் மம் ஸௌ:\n" +
                " 5.ஓம் அம் ஐம் உம் க்லீம் மம் ஸௌ:\n" +
                " 6.ஓம் அம் ஐம் உம் க்லீம் மம் ஸௌ:\n" +
                " 7.ஓம் அம் ஐம் உம் க்லீம் மம் ஸௌ:\n" +
                " 8.ஓம் அம் ஐம் உம் க்லீம் மம் ஸௌ:\n" +
                " 9.ஓம் அம் ஐம் உம் க்லீம் மம் ஸௌ:\n" +
                "10.ஓம் அம் ஐம் உம் க்லீம் மம் ஸௌ:\n" +
                "11.ஓம் அம் ஐம் உம் க்லீம் மம் ஸௌ:\n" +
                "12.ஓம் அம் ஐம் உம் க்லீம் மம் ஸௌ:\n" +
                "13.ஓம் அம் ஐம் உம் க்லீம் மம் ஸௌ:\n" +
                "14.ஓம் அம் ஐம் உம் க்லீம் மம் ஸௌ:\n" +
                "15.ஓம் அம் ஐம் உம் க்லீம் மம் ஸௌ:\n" +
                "16.ஓம் அம் ஐம் உம் க்லீம் மம் ஸௌ:\n")
        bdSt54.setSpan(AbsoluteSizeSpan(14, true), start, bdSt54.length, exExFlag)
        bdSt54.setSpan(StyleSpan(Typeface.BOLD), start, bdSt54.length, exExFlag)
        bdSt54.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt54.length, exExFlag)

        val hdSt22 = SpannableString("\nஹ்ருதயாதி ந்யாஸம்\n")
        hdSt22.setSpan(AbsoluteSizeSpan(14, true), start, hdSt22.length, exExFlag)
        hdSt22.setSpan(StyleSpan(Typeface.BOLD), start, hdSt22.length, exExFlag)
        hdSt22.setSpan(UnderlineSpan(), start, hdSt22.length, exExFlag)
        hdSt22.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start,  hdSt22.length, exExFlag)

        val comSt53 = SpannableString("(வலது கை விரல்களைச் சொடுக்கிய வண்ணம் தலையை இடமாகச் சுற்றி இடது கையில் தட்டவும்)")
        comSt53.setSpan(AbsoluteSizeSpan(13, true), start, comSt53.length, exExFlag)
        comSt53.setSpan(StyleSpan(Typeface.ITALIC), start, comSt53.length, exExFlag)
        comSt53.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt53.length, exExFlag)

        val bdSt55 = SpannableString("\nபூர் புவஸ்வரோம் இதி திக் விமோக : ||\n")
        bdSt55.setSpan(AbsoluteSizeSpan(14, true), start, bdSt55.length, exExFlag)
        bdSt55.setSpan(StyleSpan(Typeface.BOLD), start, bdSt55.length, exExFlag)
        bdSt55.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt55.length, exExFlag)

        val hdSt23 = SpannableString("\nஹ்ருதயாதி ந்யாஸம்\n")
        hdSt23.setSpan(AbsoluteSizeSpan(14, true), start, hdSt23.length, exExFlag)
        hdSt23.setSpan(StyleSpan(Typeface.BOLD), start, hdSt23.length, exExFlag)
        hdSt23.setSpan(UnderlineSpan(), start, hdSt23.length, exExFlag)
        hdSt23.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start,  hdSt23.length, exExFlag)

        val comSt54 = SpannableString("(வலது கை விரல்களைச் சொடுக்கிய வண்ணம் தலையை இடமாகச் சுற்றி இடது கையில் தட்டவும்)-")
        comSt54.setSpan(AbsoluteSizeSpan(13, true), start, comSt54.length, exExFlag)
        comSt54.setSpan(StyleSpan(Typeface.ITALIC), start, comSt54.length, exExFlag)
        comSt54.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt54.length, exExFlag)

        val bdSt56 = SpannableString("பூர்புவஸ் ஸ்வரோம் இதி திக் விமோக : ||\n")
        bdSt56.setSpan(AbsoluteSizeSpan(14, true), start, bdSt56.length, exExFlag)
        bdSt56.setSpan(StyleSpan(Typeface.BOLD), start, bdSt56.length, exExFlag)
        bdSt56.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt56.length, exExFlag)

        val hdSt19A = SpannableString("\nத்யானம்\n")
        hdSt19A.setSpan(AbsoluteSizeSpan(14, true), start, hdSt19A.length, exExFlag)
        hdSt19A.setSpan(StyleSpan(Typeface.BOLD), start, hdSt19A.length, exExFlag)
        hdSt19A.setSpan(UnderlineSpan(), start, hdSt19A.length, exExFlag)
        hdSt19A.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start,  hdSt19A.length, exExFlag)

        val comSt31A = SpannableString("(இருகைகளையும் கூப்பி)-")
        comSt31A.setSpan(AbsoluteSizeSpan(13, true), start, comSt31A.length, exExFlag)
        comSt31A.setSpan(StyleSpan(Typeface.ITALIC), start, comSt31A.length, exExFlag)
        comSt31A.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt31A.length, exExFlag)

        val bdSt57 = SpannableString("ஸந்த்யேதேவி ஜகத்வந்த்யே\nதிவ்யஸந்த்யே நமோஸ்துதே |\nஸத்வாம் ஸந்த்யாம் அபித்யாயே" +
                "\nஸர்வாபீஷ்டம் ப்ரயச்ச மே||\n")
        bdSt57.setSpan(AbsoluteSizeSpan(14, true), start, bdSt57.length, exExFlag)
        bdSt57.setSpan(StyleSpan(Typeface.BOLD), start, bdSt57.length, exExFlag)
        bdSt57.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt57.length, exExFlag)

        val hdSt20A = SpannableString("\nபஞ்ச பூஜை\n")
        hdSt20A.setSpan(AbsoluteSizeSpan(14, true), start, hdSt20A.length, exExFlag)
        hdSt20A.setSpan(StyleSpan(Typeface.BOLD), start, hdSt20A.length, exExFlag)
        hdSt20A.setSpan(UnderlineSpan(), start, hdSt20A.length, exExFlag)
        hdSt20A.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start,  hdSt20A.length, exExFlag)

        val hdSt24 = SpannableString("\nஜபஸமர்ப்பணம்\n")
        hdSt24.setSpan(AbsoluteSizeSpan(14, true), start, hdSt24.length, exExFlag)
        hdSt24.setSpan(StyleSpan(Typeface.BOLD), start, hdSt24.length, exExFlag)
        hdSt24.setSpan(UnderlineSpan(), start, hdSt24.length, exExFlag)
        hdSt24.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start,  hdSt24.length, exExFlag)

        val comSt58 = SpannableString("(ஒரு உத்தரணி ஜலம் வலது கையில் விட்டுக் கீழே விடவும்)\n")
        comSt58.setSpan(AbsoluteSizeSpan(13, true), start, comSt58.length, exExFlag)
        comSt58.setSpan(StyleSpan(Typeface.ITALIC), start, comSt58.length, exExFlag)
        comSt58.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt58.length, exExFlag)

        val bdSt58 = SpannableString("\nஓம் தத்ஸத்|| ப்ரம்மார்ப்பணமஸ்து||")
        bdSt58.setSpan(AbsoluteSizeSpan(14, true), start, bdSt58.length, exExFlag)
        bdSt58.setSpan(StyleSpan(Typeface.BOLD), start, bdSt58.length, exExFlag)
        bdSt58.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt58.length, exExFlag)

        val comSt59 = SpannableString("\n(வந்தன ஜபம் முற்றிற்று ||)\n")
        comSt59.setSpan(AbsoluteSizeSpan(13, true), start, comSt59.length, exExFlag)
        comSt59.setSpan(StyleSpan(Typeface.ITALIC), start, comSt59.length, exExFlag)
        comSt59.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt59.length, exExFlag)

        val hdSt5B = SpannableString("\nஅபிவாதனம்")
        hdSt5B.setSpan(AbsoluteSizeSpan(14, true), start, hdSt5B.length, exExFlag)
        hdSt5B.setSpan(StyleSpan(Typeface.BOLD), start, hdSt5B.length, exExFlag)
        hdSt5B.setSpan(UnderlineSpan(), start, hdSt5B.length, exExFlag)
        hdSt5B.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start,  hdSt5B.length, exExFlag)

        val bdSt20A = SpannableString("\n   அபிவாதயே yourPravaras ப்ரவரான்வித: yourGothram கோத்ர: காத்யாயன ஸூத்ர: " +
                "ஸ்ரீஶுக்ல யஜூர் வேத காண்வஶாகாத்யாயீ ஸ்ரீ yourName ஶர்மா நாமாஹம் அஹம் அஸ்மி போ:|\n")
        val regexReplace2 = """(yourPravaras)""".toRegex()
        val bdSt20B = SpannableString(bdSt20A.replace(regexReplace2, pravarasYour))
        val regexReplace3 = """(yourGothram)""".toRegex()
        val bdSt20C = SpannableString(bdSt20B.replace(regexReplace3, gothramYour))
        val regexReplace4 = """(yourName)""".toRegex()
        val bdSt20F1 = SpannableString(bdSt20C.replace(regexReplace4, nameYour))
        bdSt20F1.setSpan(AbsoluteSizeSpan(14, true), start, bdSt20F1.length, exExFlag)
        bdSt20F1.setSpan(StyleSpan(Typeface.BOLD), start, bdSt20F1.length, exExFlag)
        bdSt20F1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start,  bdSt20F1.length, exExFlag)

        val hdSt25 = SpannableString("\n(முற்றும்)\n")
        hdSt25.setSpan(AbsoluteSizeSpan(14, true), start, hdSt25.length, exExFlag)
        hdSt25.setSpan(StyleSpan(Typeface.BOLD), start, hdSt25.length, exExFlag)
        hdSt25.setSpan(UnderlineSpan(), start, hdSt25.length, exExFlag)
        hdSt25.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start,  hdSt25.length, exExFlag)

        val hdSt25A = SpannableString("\nஆசமனம்\n")
        hdSt25A.setSpan(AbsoluteSizeSpan(14, true), start, hdSt25A.length, exExFlag)
        hdSt25A.setSpan(StyleSpan(Typeface.BOLD), start, hdSt25A.length, exExFlag)
        hdSt25A.setSpan(UnderlineSpan(), start, hdSt25A.length, exExFlag)
        hdSt25A.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start,  hdSt25A.length, exExFlag)

        val hdSt25B = SpannableString("\nஆசமனம்\n")
        hdSt25B.setSpan(AbsoluteSizeSpan(14, true), start, hdSt25B.length, exExFlag)
        hdSt25B.setSpan(StyleSpan(Typeface.BOLD), start, hdSt25B.length, exExFlag)
        hdSt25B.setSpan(UnderlineSpan(), start, hdSt25B.length, exExFlag)
        hdSt25B.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start,  hdSt25B.length, exExFlag)

        val hdSt25C = SpannableString("\nஆசமனம்\n")
        hdSt25C.setSpan(AbsoluteSizeSpan(14, true), start, hdSt25C.length, exExFlag)
        hdSt25C.setSpan(StyleSpan(Typeface.BOLD), start, hdSt25C.length, exExFlag)
        hdSt25C.setSpan(UnderlineSpan(), start, hdSt25C.length, exExFlag)
        hdSt25C.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start,  hdSt25C.length, exExFlag)

        val hdSt25D = SpannableString("\nஆசமனம்\n")
        hdSt25D.setSpan(AbsoluteSizeSpan(14, true), start, hdSt25D.length, exExFlag)
        hdSt25D.setSpan(StyleSpan(Typeface.BOLD), start, hdSt25D.length, exExFlag)
        hdSt25D.setSpan(UnderlineSpan(), start, hdSt25D.length, exExFlag)
        hdSt25D.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start,  hdSt25D.length, exExFlag)

        val sandya_combination = SpannableStringBuilder()
        sandya_combination.append(hdSt1, bdSt0)
        if (sandyaType.equals("ப்ராத்தஸ்ந்தியா",true)) {
            sandya_combination.append(comSt1A) }
        else if (sandyaType.equals("மாத்யாநிஹம்",true)) {
            sandya_combination.append(comSt1B) }
        else {
            sandya_combination.append(comSt1C)
        }
        //ப்ரோக்ஷணம்
        sandya_combination.append(hdSt2AC)
        sandya_combination.append(comSt2AC, bdSt1AC, comSt3AC, bdSt2AC, comSt4AC, bdSt3AC, comSt5AC, bdSt4AC, comSt6AC, bdSt5AC,
            comSt7AC, bdSt6AC, comSt8AC, bdSt7AC, comSt9AC, bdSt8AC, comSt10AC, bdSt9AC, comSt11AC, bdSt10AC, comSt12AC,
            bdSt11AC, comSt13AC, bdSt12AC, comSt14AC, bdSt13AC, comSt15AC, bdSt14AC)
        sandya_combination.append(hdSt2GM, comSt16GM, bdSt15GM)
        //ப்ராணாயாமம்
        sandya_combination.append(hdSt3PM, comSt17PM, bdSt16PM, comSt18PM, bdSt17PM)
        //ஸங்கல்பம்
        sandya_combination.append(hdSt4SANG, comSt19SANG, bdSt18SANG)
        sandya_combination.append(comSt2, bdSt1, hdSt2, comSt3, bdSt2, comSt4, bdSt3, comSt5, bdSt4)
        //ப்ரோக்ஷணம்
        sandya_combination.append(hdSt25A, comSt1PRO, bdSt1PRO, comSt2PRO, bdSt2PRO)
        //பாபவிஸர்ஜனம்
        sandya_combination.append(hdSt1PV, comSt1PV, bdSt1PV, comSt2PV, bdSt2PV, comSt3PV, bdSt3PV, comSt6,bdSt5)
        //ப்ராசனம்
        sandya_combination.append(hdSt3, comSt7)
        if (sandyaType.equals("ப்ராத்தஸ்ந்தியா",true)) {
            sandya_combination.append(bdSt6A) }
        else if (sandyaType.equals("மாத்யாநிஹம்",true)) {
            sandya_combination.append(bdSt6B) }
        else {
            sandya_combination.append(bdSt6C)
        }
        //ஆசமனம்
        sandya_combination.append(hdSt25B, comSt2ACA, bdSt1ACA, comSt3ACA, bdSt2ACA, comSt4ACA, bdSt3ACA, comSt5ACA, bdSt4ACA,
            comSt6ACA, bdSt5ACA, comSt7ACA, bdSt6ACA, comSt8ACA, bdSt7ACA, comSt9ACA, bdSt8ACA, comSt10ACA, bdSt9ACA,
            comSt11ACA, bdSt10ACA, comSt12ACA, bdSt11ACA, comSt13ACA, bdSt12ACA, comSt14ACA, bdSt13ACA, comSt15ACA, bdSt14ACA)
        sandya_combination.append(hdSt4, comSt13, bdSt1PROA, hdSt5, comSt8, bdSt7, comSt9, bdSt8, comSt10, bdSt9, comSt11, bdSt10, comSt12, bdSt11)
        sandya_combination.append(hdSt9, comSt13, bdSt12)
        sandya_combination.append(hdSt10, comSt14, bdSt13, comSt15, bdSt14, comSt16, bdSt15)
        sandya_combination.append(hdSt11, comSt17, bdSt16)
        if (sandyaType.equals("ப்ராத்தஸ்ந்தியா",true)) {
            sandya_combination.append(comSt18A)
        }else if (sandyaType.equals("மாத்யாநிஹம்",true)) {
            sandya_combination.append(comSt18B)
        }else {
            sandya_combination.append(comSt18C)
        }
        sandya_combination.append(bdSt17)
        //ப்ராணாயாமம்
        sandya_combination.append(hdSt3PMA, comSt17PM, bdSt16PMA, comSt18PMA, bdSt17PMA)
        //ஸங்கல்பம்
        sandya_combination.append(hdSt4SANGA, comSt19SANG, bdSt18)
        if (sandyaType.equals("ப்ராத்தஸ்ந்தியா",true)) {
            sandya_combination.append(bdSt19A)
        }else if (sandyaType.equals("மாத்யாநிஹம்",true)) {
            sandya_combination.append(bdSt19B)
        }else {
            sandya_combination.append(bdSt19C)
        }
        sandya_combination.append(bdSt20, hdSt12, comSt19, bdSt21)
        sandya_combination.append(hdSt13, comSt20, bdSt22, comSt21, bdSt23)
        sandya_combination.append(hdSt14, comSt22, bdSt24)
        //ஆசமனம்
        sandya_combination.append(hdSt25C, comSt2ACC, bdSt1ACC, comSt3ACC, bdSt2ACC, comSt4ACC, bdSt3ACC, comSt5ACC, bdSt4ACC, comSt6ACC,
            bdSt5ACC, comSt7ACC, bdSt6ACC, comSt8ACC, bdSt7ACC, comSt9ACC, bdSt8ACC, comSt10ACC, bdSt9ACC, comSt11ACC, bdSt10ACC,
            comSt12ACC, bdSt11ACC, comSt13ACC, bdSt12ACC, comSt14ACC, bdSt13ACC, comSt15ACC, bdSt14ACC)
        sandya_combination.append(hdSt15, comSt23, bdSt25)
        //ஆசமனம்
        sandya_combination.append(hdSt25D, comSt2ACB, bdSt1ACB, comSt3ACB, bdSt2ACB, comSt4ACB, bdSt3ACB, comSt5ACB, bdSt4ACB, comSt6ACB,
            bdSt5ACB, comSt7ACB, bdSt6ACB, comSt8ACB, bdSt7ACB, comSt9ACB, bdSt8ACB, comSt10ACB, bdSt9ACB, comSt11ACB, bdSt10ACB,
            comSt12ACB, bdSt11ACB, comSt13ACB, bdSt12ACB, comSt14ACB, bdSt13ACB, comSt15ACB, bdSt14ACB)

        if (sandyaType.equals("ப்ராத்தஸ்ந்தியா",true)) {
            sandya_combination.append(hdSt16, comSt24A, bdSt26, comSt25, bdSt27, comSt26, bdSt28, comSt27, bdSt29, comSt28, bdSt30, comSt29,
                bdSt31, comSt30, bdSt32, comSt31, bdSt33, hdSt17, comSt32, bdSt34, comSt33, bdSt35, comSt34, bdSt36, comSt35, bdSt37,
                comSt36, bdSt38, comSt37, bdSt39, hdSt18, comSt38, bdSt40, comSt39, bdSt41, comSt40, bdSt42, comSt41, bdSt43, comSt42,
                bdSt44, comSt43, bdSt45, comSt44, bdSt46, hdSt19, comSt45, bdSt47, hdSt20, comSt46, bdSt48, comSt47, bdSt49, comSt48,
                bdSt50, comSt49, bdSt51, comSt50, bdSt52, comSt51, bdSt53, hdSt21, comSt52, bdSt54, hdSt22, comSt38, bdSt40A, comSt39,
                bdSt41A, comSt40, bdSt42A, comSt41, bdSt43A, comSt42, bdSt44A, comSt43, bdSt45A, comSt53, bdSt55, hdSt19A, comSt31A, bdSt57,
                hdSt20A, comSt46, bdSt48A, comSt47, bdSt49A, comSt48, bdSt50A, comSt49, bdSt51A, comSt50, bdSt52A, comSt51, bdSt53A,
                hdSt24, comSt58, bdSt58, comSt59,
                //அபிவாதனம்
                hdSt5B, bdSt20F1, hdSt25)
        }
        if (sandyaType.equals("ஸாயம்ஸந்தியா",true)) {

            sandya_combination.append(hdSt16, comSt24A, bdSt26, comSt25, bdSt27, comSt26, bdSt28, comSt27, bdSt29, comSt28, bdSt30, comSt29,
                bdSt31, comSt30, bdSt32, comSt31, bdSt33, hdSt17, comSt32, bdSt34, comSt33, bdSt35, comSt34, bdSt36, comSt35, bdSt37,
                comSt36, bdSt38, comSt37, bdSt39, hdSt18, comSt38, bdSt40, comSt39, bdSt41, comSt40, bdSt42, comSt41, bdSt43, comSt42,
                bdSt44, comSt43, bdSt45, comSt44, bdSt46, hdSt19, comSt45, bdSt47, hdSt20, comSt46, bdSt48, comSt47, bdSt49, comSt48,
                bdSt50, comSt49, bdSt51, comSt50, bdSt52, comSt51, bdSt53, hdSt21, comSt52, bdSt54, hdSt22, comSt38, bdSt40A, comSt39,
                bdSt41A, comSt40, bdSt42A, comSt41, bdSt43A, comSt42, bdSt44A, comSt43, bdSt45A, comSt53, bdSt55, hdSt19A, comSt31A, bdSt57,
                hdSt20A, comSt46, bdSt48A, comSt47, bdSt49A, comSt48, bdSt50A, comSt49, bdSt51A, comSt50, bdSt52A, comSt51, bdSt53A,
                hdSt24, comSt58, bdSt58, comSt59,
                //அபிவாதனம்
                hdSt5B, bdSt20F1, hdSt25)
        }
        sandya_combination.append("\n")
        binding.sandyaVandanamTextView.text = sandya_combination

        @TargetApi(Build.VERSION_CODES.KITKAT)
        class MyPrintDocumentAdapter(private var context: Context) : PrintDocumentAdapter() {
            private var pageHeight: Int = 0
            private var pageWidth: Int = 0
            var myPdfDocument: PdfDocument? = null

            override fun onLayout(
                oldAttributes: PrintAttributes,
                newAttributes: PrintAttributes,
                cancellationSignal: CancellationSignal,
                callback: LayoutResultCallback,
                metadata: Bundle
            ) {
                myPdfDocument = PrintedPdfDocument(context, newAttributes)
                pageHeight = (newAttributes.mediaSize!!.heightMils - 60) / 1000 * 72
                pageWidth = (newAttributes.mediaSize!!.widthMils - 40) / 1000 * 72

                if (cancellationSignal.isCanceled) {
                    callback.onLayoutCancelled()
                    return
                }
                if (totalpages > 0) {
                    val builder = PrintDocumentInfo.Builder("$heading.pdf")
                        .setContentType(PrintDocumentInfo.CONTENT_TYPE_DOCUMENT)
                        .setPageCount(totalpages)

                    val info = builder.build()
                    callback.onLayoutFinished(info, true)
                } else {
                    callback.onLayoutFailed("Page count is zero.")
                }
            }

            private fun pageInRange(pageRanges: Array<PageRange>, page: Int): Boolean {
                for (i in pageRanges.indices) {
                    if (page >= pageRanges[i].start && page <= pageRanges[i].end)
                        return true
                }
                return false
            }


            private fun drawPage(page: PdfDocument.Page, pagnumber: Int) {
                var pagnumber = pagnumber
                val canvas = page.canvas

                pagnumber++ // Make sure page numbers start at 1

                //  val titleBaseLine = 72
                //  val leftMargin = 54
                val paint = Paint()
                paint.color = Color.BLACK
                paint.textSize = 40f
                val pageInfo = page.info

                val logo = BitmapFactory.decodeResource(context.resources, R.drawable.mediumlogo75px)
                val bground = BitmapFactory.decodeResource(context.resources, R.drawable.yvkr)
                canvas.drawBitmap(logo, (pageInfo.pageWidth / 12 - logo.width / 6).toFloat(), 0f, paint)
                canvas.drawBitmap(bground, (pageInfo.pageWidth / 2 - bground.width / 2).toFloat(), (pageInfo.pageHeight/2- bground.height/2).toFloat(), paint)
                paint.textSize = 14f

                //   val toScale = (bm!!.width / pageWidth).toDouble()
                val mTextPaint = TextPaint()

                pageOneText = sandya_combination.subSequence(startPos1, endPos1)
                pageTwoText = sandya_combination.subSequence(startPos2, endPos2)
                pageThreeText = sandya_combination.subSequence(startPos3, endPos3)
                pageFourText = sandya_combination.subSequence(startPos4, endPos4)
                pageFiveText = sandya_combination.subSequence(startPos5, endPos5)
                pageSixText = sandya_combination.subSequence(startPos6, endPos6)
                pageSevenText = sandya_combination.subSequence(startPos7, endPos7)
                pageEightText = sandya_combination.subSequence(startPos8, endPos8)
                pageNineText = sandya_combination.subSequence(startPos9, endPos9)
                pageTenText = sandya_combination.subSequence(startPos10, endPos10)
                pageElevenText = sandya_combination.subSequence(startPos11, endPos11)
                pageTwelveText = sandya_combination.subSequence(startPos12, endPos12)
                pageThirteenText = sandya_combination.subSequence(startPos13, endPos13)
                pageFourteenText = sandya_combination.subSequence(startPos14, endPos14)
                pageFifteenText = sandya_combination.subSequence(startPos15, endPos15)
                pageSixteenText = sandya_combination.subSequence(startPos16, endPos16)
                pageSeventeenText = sandya_combination.subSequence(startPos17, endPos17)

                val footerText1 = SpannableString(
                    "$heading (Page No. $pagnumber of $totalpages)"
                )
                footerText1.setSpan(AbsoluteSizeSpan(13, true), start, footerText1.length, exExFlag)
                footerText1.setSpan(StyleSpan(Typeface.ITALIC), start, footerText1.length, exExFlag)
                footerText1.setSpan(ForegroundColorSpan(Color.RED), start, footerText1.length, exExFlag)
                val footerText =footerText1.toString()

                if (pagnumber == 1 && totalpages >= 1) {
                    val mTextLayout1 = StaticLayout(pageOneText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout1.draw(canvas)
                    paint.textSize = 14f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 2 && totalpages >= 2) {
                    val mTextLayout2 = StaticLayout(pageTwoText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout2.draw(canvas)
                    paint.textSize = 14f
                    paint.colorFilter
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 3 && totalpages >= 3) {
                    val mTextLayout3 = StaticLayout(pageThreeText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout3.draw(canvas)
                    paint.textSize = 14f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 4 && totalpages >= 4) {
                    val mTextLayout4 = StaticLayout(pageFourText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout4.draw(canvas)
                    paint.textSize = 14f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 5 && totalpages >= 5) {
                    val mTextLayout5 = StaticLayout(pageFiveText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout5.draw(canvas)
                    paint.textSize = 14f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 6 && totalpages >= 6) {
                    val mTextLayout6 = StaticLayout(pageSixText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout6.draw(canvas)
                    paint.textSize = 14f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 7 && totalpages >= 7) {
                    val mTextLayout7 = StaticLayout(pageSevenText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout7.draw(canvas)
                    paint.textSize = 14f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 8 && totalpages >= 8) {
                    val mTextLayout8 = StaticLayout(pageEightText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout8.draw(canvas)
                    paint.textSize = 14f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 9 && totalpages >= 9) {
                    val mTextLayout9 = StaticLayout(pageNineText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout9.draw(canvas)
                    paint.textSize = 14f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 10 && totalpages >= 10) {
                    val mTextLayout10 = StaticLayout(pageTenText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout10.draw(canvas)
                    paint.textSize = 14f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 11 && totalpages >= 11) {
                    val mTextLayout11 = StaticLayout(pageElevenText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout11.draw(canvas)
                    paint.textSize = 14f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 12 && totalpages >= 12) {
                    val mTextLayout12 = StaticLayout(pageTwelveText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout12.draw(canvas)
                    paint.textSize = 14f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 13 && totalpages >= 13) {
                    val mTextLayout13 = StaticLayout(pageThirteenText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout13.draw(canvas)
                    paint.textSize = 14f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 14 && totalpages >= 14) {
                    val mTextLayout14 = StaticLayout(pageFourteenText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout14.draw(canvas)
                    paint.textSize = 14f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 15 && totalpages >= 15) {
                    val mTextLayout15 = StaticLayout(pageFifteenText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout15.draw(canvas)
                    paint.textSize = 14f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 16 && totalpages >= 16) {
                    val mTextLayout16 = StaticLayout(pageSixteenText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout16.draw(canvas)
                    paint.textSize = 14f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 17 && totalpages >= 17) {
                    val mTextLayout17 = StaticLayout(pageSeventeenText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout17.draw(canvas)
                    paint.textSize = 14f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }

            }


            override fun onWrite(
                pageRanges: Array<PageRange>,
                destination: ParcelFileDescriptor,
                cancellationSignal: CancellationSignal,
                callback: WriteResultCallback
            ) {
                for (i in 0 until totalpages) {
                    if (pageInRange(pageRanges, i)) {
                        val newPage = PdfDocument.PageInfo.Builder(pageWidth, pageHeight, i).create()

                        val page = myPdfDocument!!.startPage(newPage)

                        if (cancellationSignal.isCanceled) {
                            callback.onWriteCancelled()
                            myPdfDocument!!.close()
                            myPdfDocument = null
                            return
                        }
                        drawPage(page, i)
                        myPdfDocument!!.finishPage(page)
                    }
                }

                try {
                    myPdfDocument!!.writeTo(FileOutputStream(destination.fileDescriptor))
                } catch (e: IOException) {
                    callback.onWriteFailed(e.toString())
                    return
                } finally {
                    myPdfDocument!!.close()
                    myPdfDocument = null
                    System.err.println("FINISHED!!")
                }

                callback.onWriteFinished(pageRanges)
            }
        }

        binding.printButton.setOnClickListener {
            val mTLineCount = binding.sandyaVandanamTextView.lineCount
            println("mTLineCount : $mTLineCount")
            val totalChar = binding.sandyaVandanamTextView.length()
            val testTotalChar = totalChar.toString()
            println("totalChar : $totalChar")
            val pagesTotal = ((mTLineCount/50 + 0.99) / 0.99 ) * 1 //(Math.round(mTLineCount.toDouble() / 30.toDouble()))
            totalpages = pagesTotal.toInt()
            println("totalpages : $totalpages")
            if (totalpages == 1) {
                startPos1 = binding.sandyaVandanamTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    endPos1 = binding.sandyaVandanamTextView.layout.getLineEnd(50)
                } else {
                    endPos1 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount - 1)
                }
                //   pageOneText = binding.sandyaVandanamTextView.text.toString().substring(startPos1, endPos1)
            }
            if (totalpages == 2) {
                startPos1 = binding.sandyaVandanamTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    endPos1 = binding.sandyaVandanamTextView.layout.getLineEnd(50)
                } else {
                    endPos1 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                }
                //     pageOneText = binding.sandyaVandanamTextView.text.toString().substring(startPos1, endPos1)
                if (mTLineCount in 51..100) {
                    startPos2 = binding.sandyaVandanamTextView.layout.getLineStart(51)
                    endPos2 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos2 = binding.sandyaVandanamTextView.layout.getLineStart(51)
                    endPos2 = binding.sandyaVandanamTextView.layout.getLineEnd(100)
                }
                //      pageTwoText = binding.sandyaVandanamTextView.text.toString().substring(startPos2, endPos2)
            }
            if (totalpages == 3) {
                startPos1 = binding.sandyaVandanamTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    endPos1 = binding.sandyaVandanamTextView.layout.getLineEnd(50)
                } else {
                    endPos1 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                }
                pageOneText = binding.sandyaVandanamTextView.text.toString().substring(startPos1, endPos1)
                if (mTLineCount in 51..100) {
                    startPos2 = binding.sandyaVandanamTextView.layout.getLineStart(51)
                    endPos2 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos2 = binding.sandyaVandanamTextView.layout.getLineStart(51)
                    endPos2 = binding.sandyaVandanamTextView.layout.getLineEnd(100)
                }
                //    pageTwoText = binding.sandyaVandanamTextView.text.toString().substring(startPos2, endPos2)
                if (mTLineCount in 101..150) {
                    startPos3 = binding.sandyaVandanamTextView.layout.getLineStart(101)
                    endPos3 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos3 = binding.sandyaVandanamTextView.layout.getLineStart(101)
                    endPos3 = binding.sandyaVandanamTextView.layout.getLineEnd(150)
                }
                //    pageThreeText = binding.sandyaVandanamTextView.text.toString().substring(startPos3, endPos3)
            }
            if (totalpages == 4) {
                startPos1 = binding.sandyaVandanamTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    endPos1 = binding.sandyaVandanamTextView.layout.getLineEnd(50)
                } else {
                    endPos1 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                }
                //   pageOneText = binding.sandyaVandanamTextView.text.toString().substring(startPos1, endPos1)
                if (mTLineCount in 51..100) {
                    startPos2 = binding.sandyaVandanamTextView.layout.getLineStart(51)
                    endPos2 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos2 = binding.sandyaVandanamTextView.layout.getLineStart(51)
                    endPos2 = binding.sandyaVandanamTextView.layout.getLineEnd(100)
                }
                //    pageTwoText = binding.sandyaVandanamTextView.text.toString().substring(startPos2, endPos2)
                if (mTLineCount in 101..150) {
                    startPos3 = binding.sandyaVandanamTextView.layout.getLineStart(101)
                    endPos3 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos3 = binding.sandyaVandanamTextView.layout.getLineStart(101)
                    endPos3 = binding.sandyaVandanamTextView.layout.getLineEnd(150)
                }
                //    pageThreeText = binding.sandyaVandanamTextView.text.toString().substring(startPos3, endPos3)
                if (mTLineCount in 151..200) {
                    startPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(151)
                    endPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(151)
                    endPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(200)
                }
                //    pageFourText = binding.sandyaVandanamTextView.text.toString().substring(startPos4, endPos4)
            }
            if (totalpages == 5) {
                startPos1 = binding.sandyaVandanamTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    endPos1 = binding.sandyaVandanamTextView.layout.getLineEnd(50)
                } else {
                    endPos1 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                }
                //   pageOneText = binding.sandyaVandanamTextView.text.toString().substring(startPos1, endPos1)
                if (mTLineCount in 51..100) {
                    startPos2 = binding.sandyaVandanamTextView.layout.getLineStart(51)
                    endPos2 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos2 = binding.sandyaVandanamTextView.layout.getLineStart(51)
                    endPos2 = binding.sandyaVandanamTextView.layout.getLineEnd(100)
                }
                //    pageTwoText = binding.sandyaVandanamTextView.text.toString().substring(startPos2, endPos2)
                if (mTLineCount in 101..150) {
                    startPos3 = binding.sandyaVandanamTextView.layout.getLineStart(101)
                    endPos3 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos3 = binding.sandyaVandanamTextView.layout.getLineStart(101)
                    endPos3 = binding.sandyaVandanamTextView.layout.getLineEnd(150)
                }
                //    pageThreeText = binding.sandyaVandanamTextView.text.toString().substring(startPos3, endPos3)
                if (mTLineCount in 151..200) {
                    startPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(151)
                    endPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(151)
                    endPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(200)
                }
                //    pageFourText = binding.sandyaVandanamTextView.text.toString().substring(startPos4, endPos4)
                if (mTLineCount in 201..250) {
                    startPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(201)
                    endPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(201)
                    endPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(250)
                }
                //    pageFiveText = binding.sandyaVandanamTextView.text.toString().substring(startPos5, endPos5)
            }

            if (totalpages == 6) {
                startPos1 = binding.sandyaVandanamTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    endPos1 = binding.sandyaVandanamTextView.layout.getLineEnd(50)
                } else {
                    endPos1 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                }
                //    pageOneText = binding.sandyaVandanamTextView.text.toString().substring(startPos1, endPos1)
                if (mTLineCount in 51..100) {
                    startPos2 = binding.sandyaVandanamTextView.layout.getLineStart(51)
                    endPos2 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos2 = binding.sandyaVandanamTextView.layout.getLineStart(51)
                    endPos2 = binding.sandyaVandanamTextView.layout.getLineEnd(100)
                }
                //    pageTwoText = binding.sandyaVandanamTextView.text.toString().substring(startPos2, endPos2)
                if (mTLineCount in 101..150) {
                    startPos3 = binding.sandyaVandanamTextView.layout.getLineStart(101)
                    endPos3 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos3 = binding.sandyaVandanamTextView.layout.getLineStart(101)
                    endPos3 = binding.sandyaVandanamTextView.layout.getLineEnd(150)
                }
                //    pageThreeText = binding.sandyaVandanamTextView.text.toString().substring(startPos3, endPos3)
                if (mTLineCount in 151..200) {
                    startPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(151)
                    endPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(151)
                    endPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(200)
                }
                //    pageFourText = binding.sandyaVandanamTextView.text.toString().substring(startPos4, endPos4)
                if (mTLineCount in 201..250) {
                    startPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(201)
                    endPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(201)
                    endPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(250)
                }
                //    pageFiveText = binding.sandyaVandanamTextView.text.toString().substring(startPos5, endPos5)
                if (mTLineCount in 251..300) {
                    startPos6 = binding.sandyaVandanamTextView.layout.getLineStart(251)
                    endPos6 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos6 = binding.sandyaVandanamTextView.layout.getLineStart(251)
                    endPos6 = binding.sandyaVandanamTextView.layout.getLineEnd(300)
                }
                //    pageSixText = binding.sandyaVandanamTextView.text.toString().substring(startPos6, endPos6)
            }
            if (totalpages == 7) {
                startPos1 = binding.sandyaVandanamTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    endPos1 = binding.sandyaVandanamTextView.layout.getLineEnd(50)
                } else {
                    endPos1 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                }
                //    pageOneText = binding.sandyaVandanamTextView.text.toString().substring(startPos1, endPos1)
                if (mTLineCount in 51..100) {
                    startPos2 = binding.sandyaVandanamTextView.layout.getLineStart(51)
                    endPos2 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos2 = binding.sandyaVandanamTextView.layout.getLineStart(51)
                    endPos2 = binding.sandyaVandanamTextView.layout.getLineEnd(100)
                }
                //    pageTwoText = binding.sandyaVandanamTextView.text.toString().substring(startPos2, endPos2)
                if (mTLineCount in 101..150) {
                    startPos3 = binding.sandyaVandanamTextView.layout.getLineStart(101)
                    endPos3 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos3 = binding.sandyaVandanamTextView.layout.getLineStart(101)
                    endPos3 = binding.sandyaVandanamTextView.layout.getLineEnd(150)
                }
                //     pageThreeText = binding.sandyaVandanamTextView.text.toString().substring(startPos3, endPos3)
                if (mTLineCount in 151..200) {
                    startPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(151)
                    endPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(151)
                    endPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(200)
                }
                //    pageFourText = binding.sandyaVandanamTextView.text.toString().substring(startPos4, endPos4)
                if (mTLineCount in 201..250) {
                    startPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(201)
                    endPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(201)
                    endPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(250)
                }
                //    pageFiveText = binding.sandyaVandanamTextView.text.toString().substring(startPos5, endPos5)
                if (mTLineCount in 251..300) {
                    startPos6 = binding.sandyaVandanamTextView.layout.getLineStart(251)
                    endPos6 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos6 = binding.sandyaVandanamTextView.layout.getLineStart(251)
                    endPos6 = binding.sandyaVandanamTextView.layout.getLineEnd(300)
                }
                //    pageSixText = binding.sandyaVandanamTextView.text.toString().substring(startPos6, endPos6)
                if (mTLineCount in 301..350) {
                    startPos7 = binding.sandyaVandanamTextView.layout.getLineStart(301)
                    endPos7 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos7 = binding.sandyaVandanamTextView.layout.getLineStart(301)
                    endPos7 = binding.sandyaVandanamTextView.layout.getLineEnd(350)
                }
                //    pageSevenText = binding.sandyaVandanamTextView.text.toString().substring(startPos7, endPos7)
            }
            if (totalpages == 8) {
                startPos1 = binding.sandyaVandanamTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    endPos1 = binding.sandyaVandanamTextView.layout.getLineEnd(50)
                } else {
                    endPos1 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                }
                //    pageOneText = binding.sandyaVandanamTextView.text.toString().substring(startPos1, endPos1)
                if (mTLineCount in 51..100) {
                    startPos2 = binding.sandyaVandanamTextView.layout.getLineStart(51)
                    endPos2 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos2 = binding.sandyaVandanamTextView.layout.getLineStart(51)
                    endPos2 = binding.sandyaVandanamTextView.layout.getLineEnd(100)
                }
                //    pageTwoText = binding.sandyaVandanamTextView.text.toString().substring(startPos2, endPos2)
                if (mTLineCount in 101..150) {
                    startPos3 = binding.sandyaVandanamTextView.layout.getLineStart(101)
                    endPos3 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos3 = binding.sandyaVandanamTextView.layout.getLineStart(101)
                    endPos3 = binding.sandyaVandanamTextView.layout.getLineEnd(150)
                }
                //    pageThreeText = binding.sandyaVandanamTextView.text.toString().substring(startPos3, endPos3)
                if (mTLineCount in 151..200) {
                    startPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(151)
                    endPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(151)
                    endPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(200)
                }
                //    pageFourText = binding.sandyaVandanamTextView.text.toString().substring(startPos4, endPos4)
                if (mTLineCount in 201..250) {
                    startPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(201)
                    endPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(201)
                    endPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(250)
                }
                //    pageFiveText = binding.sandyaVandanamTextView.text.toString().substring(startPos5, endPos5)
                if (mTLineCount in 251..300) {
                    startPos6 = binding.sandyaVandanamTextView.layout.getLineStart(251)
                    endPos6 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos6 = binding.sandyaVandanamTextView.layout.getLineStart(251)
                    endPos6 = binding.sandyaVandanamTextView.layout.getLineEnd(300)
                }
                //    pageSixText = binding.sandyaVandanamTextView.text.toString().substring(startPos6, endPos6)
                if (mTLineCount in 301..350) {
                    startPos7 = binding.sandyaVandanamTextView.layout.getLineStart(301)
                    endPos7 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos7 = binding.sandyaVandanamTextView.layout.getLineStart(301)
                    endPos7 = binding.sandyaVandanamTextView.layout.getLineEnd(350)
                }
                println("startPos7 : $startPos7")
                println("endPos7 : $endPos7")
                //    pageSevenText = binding.sandyaVandanamTextView.text.toString().substring(startPos7, endPos7)

                if (mTLineCount in 351..400) {
                    startPos8 = binding.sandyaVandanamTextView.layout.getLineStart(351)
                    endPos8 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                    println("endPos8 : $endPos8")
                } else {
                    startPos8 = binding.sandyaVandanamTextView.layout.getLineStart(351)
                    endPos8 = binding.sandyaVandanamTextView.layout.getLineEnd(400)
                    println("endPos82 : $endPos8")
                }
                println("startPos8 : $startPos8")
                println("endPos8F : $endPos8")
                //    pageEightText = binding.sandyaVandanamTextView.text.toString().substring(startPos8, endPos8)
            }

            if (totalpages == 9) {
                startPos1 = binding.sandyaVandanamTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    endPos1 = binding.sandyaVandanamTextView.layout.getLineEnd(50)
                } else {
                    endPos1 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                }
                //     pageOneText = binding.sandyaVandanamTextView.text.toString().substring(startPos1, endPos1)
                if (mTLineCount in 51..100) {
                    startPos2 = binding.sandyaVandanamTextView.layout.getLineStart(51)
                    endPos2 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos2 = binding.sandyaVandanamTextView.layout.getLineStart(51)
                    endPos2 = binding.sandyaVandanamTextView.layout.getLineEnd(100)
                }
                //     pageTwoText = binding.sandyaVandanamTextView.text.toString().substring(startPos2, endPos2)
                if (mTLineCount in 101..150) {
                    startPos3 = binding.sandyaVandanamTextView.layout.getLineStart(101)
                    endPos3 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos3 = binding.sandyaVandanamTextView.layout.getLineStart(101)
                    endPos3 = binding.sandyaVandanamTextView.layout.getLineEnd(150)
                }
                //    pageThreeText = binding.sandyaVandanamTextView.text.toString().substring(startPos3, endPos3)
                if (mTLineCount in 151..200) {
                    startPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(151)
                    endPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(151)
                    endPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(200)
                }
                //    pageFourText = binding.sandyaVandanamTextView.text.toString().substring(startPos4, endPos4)
                if (mTLineCount in 201..250) {
                    startPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(201)
                    endPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(201)
                    endPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(250)
                }
                //    pageFiveText = binding.sandyaVandanamTextView.text.toString().substring(startPos5, endPos5)
                if (mTLineCount in 251..300) {
                    startPos6 = binding.sandyaVandanamTextView.layout.getLineStart(251)
                    endPos6 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos6 = binding.sandyaVandanamTextView.layout.getLineStart(251)
                    endPos6 = binding.sandyaVandanamTextView.layout.getLineEnd(300)
                }
                //    pageSixText = binding.sandyaVandanamTextView.text.toString().substring(startPos6, endPos6)
                if (mTLineCount in 301..350) {
                    startPos7 = binding.sandyaVandanamTextView.layout.getLineStart(301)
                    endPos7 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos7 = binding.sandyaVandanamTextView.layout.getLineStart(301)
                    endPos7 = binding.sandyaVandanamTextView.layout.getLineEnd(350)
                }
                //     pageSevenText = binding.sandyaVandanamTextView.text.toString().substring(startPos7, endPos7)
                if (mTLineCount in 351..400) {
                    startPos8 = binding.sandyaVandanamTextView.layout.getLineStart(351)
                    endPos8 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos8 = binding.sandyaVandanamTextView.layout.getLineStart(351)
                    endPos8 = binding.sandyaVandanamTextView.layout.getLineEnd(400)
                }
                //     pageEightText = binding.sandyaVandanamTextView.text.toString().substring(startPos8, endPos8)
                if (mTLineCount in 401..450) {
                    startPos9 = binding.sandyaVandanamTextView.layout.getLineStart(401)
                    endPos9 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos9 = binding.sandyaVandanamTextView.layout.getLineStart(401)
                    endPos9 = binding.sandyaVandanamTextView.layout.getLineEnd(450)
                }
                //     pageNineText = binding.sandyaVandanamTextView.text.toString().substring(startPos9, endPos9)
            }
            if (totalpages == 10) {
                startPos1 = binding.sandyaVandanamTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    endPos1 = binding.sandyaVandanamTextView.layout.getLineEnd(50)
                } else {
                    endPos1 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                }
                //      pageOneText = binding.sandyaVandanamTextView.text.toString().substring(startPos1, endPos1)
                if (mTLineCount in 51..100) {
                    startPos2 = binding.sandyaVandanamTextView.layout.getLineStart(51)
                    endPos2 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos2 = binding.sandyaVandanamTextView.layout.getLineStart(51)
                    endPos2 = binding.sandyaVandanamTextView.layout.getLineEnd(100)
                }
                //     pageTwoText = binding.sandyaVandanamTextView.text.toString().substring(startPos2, endPos2)
                if (mTLineCount in 101..150) {
                    startPos3 = binding.sandyaVandanamTextView.layout.getLineStart(101)
                    endPos3 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos3 = binding.sandyaVandanamTextView.layout.getLineStart(101)
                    endPos3 = binding.sandyaVandanamTextView.layout.getLineEnd(150)
                }
                //    pageThreeText = binding.sandyaVandanamTextView.text.toString().substring(startPos3, endPos3)
                if (mTLineCount in 151..200) {
                    startPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(151)
                    endPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(151)
                    endPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(200)
                }
                //    pageFourText = binding.sandyaVandanamTextView.text.toString().substring(startPos4, endPos4)
                if (mTLineCount in 201..250) {
                    startPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(201)
                    endPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(201)
                    endPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(250)
                }
                //    pageFiveText = binding.sandyaVandanamTextView.text.toString().substring(startPos5, endPos5)
                if (mTLineCount in 251..300) {
                    startPos6 = binding.sandyaVandanamTextView.layout.getLineStart(251)
                    endPos6 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos6 = binding.sandyaVandanamTextView.layout.getLineStart(251)
                    endPos6 = binding.sandyaVandanamTextView.layout.getLineEnd(300)
                }
                //    pageSixText = binding.sandyaVandanamTextView.text.toString().substring(startPos6, endPos6)
                if (mTLineCount in 301..350) {
                    startPos7 = binding.sandyaVandanamTextView.layout.getLineStart(301)
                    endPos7 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos7 = binding.sandyaVandanamTextView.layout.getLineStart(301)
                    endPos7 = binding.sandyaVandanamTextView.layout.getLineEnd(350)
                }
                //    pageSevenText = binding.sandyaVandanamTextView.text.toString().substring(startPos7, endPos7)
                if (mTLineCount in 351..400) {
                    startPos8 = binding.sandyaVandanamTextView.layout.getLineStart(351)
                    endPos8 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos8 = binding.sandyaVandanamTextView.layout.getLineStart(351)
                    endPos8 = binding.sandyaVandanamTextView.layout.getLineEnd(400)
                }
                //    pageEightText = binding.sandyaVandanamTextView.text.toString().substring(startPos8, endPos8)
                if (mTLineCount in 401..450) {
                    startPos9 = binding.sandyaVandanamTextView.layout.getLineStart(401)
                    endPos9 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos9 = binding.sandyaVandanamTextView.layout.getLineStart(401)
                    endPos9 = binding.sandyaVandanamTextView.layout.getLineEnd(450)
                }
                //    pageNineText = binding.sandyaVandanamTextView.text.toString().substring(startPos9, endPos9)
                if (mTLineCount  in 451..500) {
                    startPos10 = binding.sandyaVandanamTextView.layout.getLineStart(451)
                    endPos10 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos10 = binding.sandyaVandanamTextView.layout.getLineStart(451)
                    endPos10 = binding.sandyaVandanamTextView.layout.getLineEnd(500)
                }
                //    pageTenText = binding.sandyaVandanamTextView.text.toString().substring(startPos10, endPos10)
            }
            if (totalpages == 11) {
                startPos1 = binding.sandyaVandanamTextView.layout.getLineStart(0)
                if (mTLineCount  >= 50) {
                    endPos1 = binding.sandyaVandanamTextView.layout.getLineEnd(50)
                } else {
                    endPos1 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                }
                //    pageOneText = binding.sandyaVandanamTextView.text.toString().substring(startPos1, endPos1)
                if (mTLineCount  in 51..100) {
                    startPos2 = binding.sandyaVandanamTextView.layout.getLineStart(51)
                    endPos2 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos2 = binding.sandyaVandanamTextView.layout.getLineStart(51)
                    endPos2 = binding.sandyaVandanamTextView.layout.getLineEnd(100)
                }
                //    pageTwoText = binding.sandyaVandanamTextView.text.toString().substring(startPos2, endPos2)
                if (mTLineCount  in 101..150) {
                    startPos3 = binding.sandyaVandanamTextView.layout.getLineStart(101)
                    endPos3 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos3 = binding.sandyaVandanamTextView.layout.getLineStart(101)
                    endPos3 = binding.sandyaVandanamTextView.layout.getLineEnd(150)
                }
                //    pageThreeText = binding.sandyaVandanamTextView.text.toString().substring(startPos3, endPos3)
                if (mTLineCount  in 151..200) {
                    startPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(151)
                    endPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(151)
                    endPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(200)
                }
                //    pageFourText = binding.sandyaVandanamTextView.text.toString().substring(startPos4, endPos4)
                if (mTLineCount  in 201..250) {
                    startPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(201)
                    endPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(201)
                    endPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(250)
                }
                //    pageFiveText = binding.sandyaVandanamTextView.text.toString().substring(startPos5, endPos5)
                if (mTLineCount  in 251..300) {
                    startPos6 = binding.sandyaVandanamTextView.layout.getLineStart(251)
                    endPos6 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos6 = binding.sandyaVandanamTextView.layout.getLineStart(251)
                    endPos6 = binding.sandyaVandanamTextView.layout.getLineEnd(300)
                }
                //    pageSixText = binding.sandyaVandanamTextView.text.toString().substring(startPos6, endPos6)
                if (mTLineCount  in 301..350) {
                    startPos7 = binding.sandyaVandanamTextView.layout.getLineStart(301)
                    endPos7 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos7 = binding.sandyaVandanamTextView.layout.getLineStart(301)
                    endPos7 = binding.sandyaVandanamTextView.layout.getLineEnd(350)
                }
                //    pageSevenText = binding.sandyaVandanamTextView.text.toString().substring(startPos7, endPos7)
                if (mTLineCount in 351..400) {
                    startPos8 = binding.sandyaVandanamTextView.layout.getLineStart(351)
                    endPos8 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos8 = binding.sandyaVandanamTextView.layout.getLineStart(351)
                    endPos8 = binding.sandyaVandanamTextView.layout.getLineEnd(400)
                }
                //     pageEightText = binding.sandyaVandanamTextView.text.toString().substring(startPos8, endPos8)
                if (mTLineCount  in 401..450) {
                    startPos9 = binding.sandyaVandanamTextView.layout.getLineStart(401)
                    endPos9 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos9 = binding.sandyaVandanamTextView.layout.getLineStart(401)
                    endPos9 = binding.sandyaVandanamTextView.layout.getLineEnd(450)
                }
                //    pageNineText = binding.sandyaVandanamTextView.text.toString().substring(startPos9, endPos9)
                if (mTLineCount  in 451..500) {
                    startPos10 = binding.sandyaVandanamTextView.layout.getLineStart(451)
                    endPos10 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos10 = binding.sandyaVandanamTextView.layout.getLineStart(451)
                    endPos10 = binding.sandyaVandanamTextView.layout.getLineEnd(500)
                }
                //     pageTenText = binding.sandyaVandanamTextView.text.toString().substring(startPos10, endPos10)
                if (mTLineCount  in 501..550) {
                    startPos11 = binding.sandyaVandanamTextView.layout.getLineStart(501)
                    endPos11 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos11 = binding.sandyaVandanamTextView.layout.getLineStart(501)
                    endPos11 = binding.sandyaVandanamTextView.layout.getLineEnd(550)
                }
                //    pageElevenText = binding.sandyaVandanamTextView.text.toString().substring(startPos11, endPos11)
            }
            if (totalpages == 12) {
                startPos1 = binding.sandyaVandanamTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    endPos1 = binding.sandyaVandanamTextView.layout.getLineEnd(50)
                } else {
                    endPos1 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                }
                //     pageOneText = binding.sandyaVandanamTextView.text.toString().substring(startPos1, endPos1)
                if (mTLineCount  in 51..100) {
                    startPos2 = binding.sandyaVandanamTextView.layout.getLineStart(51)
                    endPos2 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos2 = binding.sandyaVandanamTextView.layout.getLineStart(51)
                    endPos2 = binding.sandyaVandanamTextView.layout.getLineEnd(100)
                }
                //     pageTwoText = binding.sandyaVandanamTextView.text.toString().substring(startPos2, endPos2)
                if (mTLineCount  in 101..150) {
                    startPos3 = binding.sandyaVandanamTextView.layout.getLineStart(101)
                    endPos3 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos3 = binding.sandyaVandanamTextView.layout.getLineStart(101)
                    endPos3 = binding.sandyaVandanamTextView.layout.getLineEnd(150)
                }
                //     pageThreeText = binding.sandyaVandanamTextView.text.toString().substring(startPos3, endPos3)
                if (mTLineCount  in 151..200) {
                    startPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(151)
                    endPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(151)
                    endPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(200)
                }
                //    pageFourText = binding.sandyaVandanamTextView.text.toString().substring(startPos4, endPos4)
                if (mTLineCount  in 201..250) {
                    startPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(201)
                    endPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(201)
                    endPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(250)
                }
                //    pageFiveText = binding.sandyaVandanamTextView.text.toString().substring(startPos5, endPos5)
                if (mTLineCount  in 251..300) {
                    startPos6 = binding.sandyaVandanamTextView.layout.getLineStart(251)
                    endPos6 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos6 = binding.sandyaVandanamTextView.layout.getLineStart(251)
                    endPos6 = binding.sandyaVandanamTextView.layout.getLineEnd(300)
                }
                //    pageSixText = binding.sandyaVandanamTextView.text.toString().substring(startPos6, endPos6)
                if (mTLineCount  in 301..350) {
                    startPos7 = binding.sandyaVandanamTextView.layout.getLineStart(301)
                    endPos7 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos7 = binding.sandyaVandanamTextView.layout.getLineStart(301)
                    endPos7 = binding.sandyaVandanamTextView.layout.getLineEnd(350)
                }
                //    pageSevenText = binding.sandyaVandanamTextView.text.toString().substring(startPos7, endPos7)
                if (mTLineCount in 351..400) {
                    startPos8 = binding.sandyaVandanamTextView.layout.getLineStart(351)
                    endPos8 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos8 = binding.sandyaVandanamTextView.layout.getLineStart(351)
                    endPos8 = binding.sandyaVandanamTextView.layout.getLineEnd(400)
                }
                //    pageEightText = binding.sandyaVandanamTextView.text.toString().substring(startPos8, endPos8)
                if (mTLineCount  in 401..450) {
                    startPos9 = binding.sandyaVandanamTextView.layout.getLineStart(401)
                    endPos9 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos9 = binding.sandyaVandanamTextView.layout.getLineStart(401)
                    endPos9 = binding.sandyaVandanamTextView.layout.getLineEnd(450)
                }
                //    pageNineText = binding.sandyaVandanamTextView.text.toString().substring(startPos9, endPos9)
                if (mTLineCount  in 451..500) {
                    startPos10 = binding.sandyaVandanamTextView.layout.getLineStart(451)
                    endPos10 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos10 = binding.sandyaVandanamTextView.layout.getLineStart(451)
                    endPos10 = binding.sandyaVandanamTextView.layout.getLineEnd(500)
                }
                //    pageTenText = binding.sandyaVandanamTextView.text.toString().substring(startPos10, endPos10)
                if (mTLineCount  in 501..550) {
                    startPos11 = binding.sandyaVandanamTextView.layout.getLineStart(501)
                    endPos11 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos11 = binding.sandyaVandanamTextView.layout.getLineStart(501)
                    endPos11 = binding.sandyaVandanamTextView.layout.getLineEnd(550)
                }
                //    pageElevenText = binding.sandyaVandanamTextView.text.toString().substring(startPos11, endPos11)
                if (mTLineCount  in 551..600) {
                    startPos12 = binding.sandyaVandanamTextView.layout.getLineStart(551)
                    endPos12 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos12 = binding.sandyaVandanamTextView.layout.getLineStart(551)
                    endPos12 = binding.sandyaVandanamTextView.layout.getLineEnd(600)
                }
                //    pageTwelveText = binding.sandyaVandanamTextView.text.toString().substring(startPos12, endPos12)
            }
            if (totalpages == 13) {
                startPos1 = binding.sandyaVandanamTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    endPos1 = binding.sandyaVandanamTextView.layout.getLineEnd(50)
                } else {
                    endPos1 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                }
                //     pageOneText = binding.sandyaVandanamTextView.text.toString().substring(startPos1, endPos1)
                if (mTLineCount  in 51..100) {
                    startPos2 = binding.sandyaVandanamTextView.layout.getLineStart(51)
                    endPos2 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos2 = binding.sandyaVandanamTextView.layout.getLineStart(51)
                    endPos2 = binding.sandyaVandanamTextView.layout.getLineEnd(100)
                }
                //    pageTwoText = binding.sandyaVandanamTextView.text.toString().substring(startPos2, endPos2)
                if (mTLineCount  in 101..150) {
                    startPos3 = binding.sandyaVandanamTextView.layout.getLineStart(101)
                    endPos3 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos3 = binding.sandyaVandanamTextView.layout.getLineStart(101)
                    endPos3 = binding.sandyaVandanamTextView.layout.getLineEnd(150)
                }
                //    pageThreeText = binding.sandyaVandanamTextView.text.toString().substring(startPos3, endPos3)
                if (mTLineCount  in 151..200) {
                    startPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(151)
                    endPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(151)
                    endPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(200)
                }
                //    pageFourText = binding.sandyaVandanamTextView.text.toString().substring(startPos4, endPos4)
                if (mTLineCount  in 201..250) {
                    startPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(201)
                    endPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(201)
                    endPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(250)
                }
                //    pageFiveText = binding.sandyaVandanamTextView.text.toString().substring(startPos5, endPos5)
                if (mTLineCount  in 251..300) {
                    startPos6 = binding.sandyaVandanamTextView.layout.getLineStart(251)
                    endPos6 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos6 = binding.sandyaVandanamTextView.layout.getLineStart(251)
                    endPos6 = binding.sandyaVandanamTextView.layout.getLineEnd(300)
                }
                //    pageSixText = binding.sandyaVandanamTextView.text.toString().substring(startPos6, endPos6)
                if (mTLineCount  in 301..350) {
                    startPos7 = binding.sandyaVandanamTextView.layout.getLineStart(301)
                    endPos7 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos7 = binding.sandyaVandanamTextView.layout.getLineStart(301)
                    endPos7 = binding.sandyaVandanamTextView.layout.getLineEnd(350)
                }
                //    pageSevenText = binding.sandyaVandanamTextView.text.toString().substring(startPos7, endPos7)
                if (mTLineCount in 351..400) {
                    startPos8 = binding.sandyaVandanamTextView.layout.getLineStart(351)
                    endPos8 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos8 = binding.sandyaVandanamTextView.layout.getLineStart(351)
                    endPos8 = binding.sandyaVandanamTextView.layout.getLineEnd(400)
                }
                //    pageEightText = binding.sandyaVandanamTextView.text.toString().substring(startPos8, endPos8)
                if (mTLineCount  in 401..450) {
                    startPos9 = binding.sandyaVandanamTextView.layout.getLineStart(401)
                    endPos9 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos9 = binding.sandyaVandanamTextView.layout.getLineStart(401)
                    endPos9 = binding.sandyaVandanamTextView.layout.getLineEnd(450)
                }
                //    pageNineText = binding.sandyaVandanamTextView.text.toString().substring(startPos9, endPos9)
                if (mTLineCount in 451..500) {
                    startPos10 = binding.sandyaVandanamTextView.layout.getLineStart(451)
                    endPos10 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos10 = binding.sandyaVandanamTextView.layout.getLineStart(451)
                    endPos10 = binding.sandyaVandanamTextView.layout.getLineEnd(500)
                }
                //    pageTenText = binding.sandyaVandanamTextView.text.toString().substring(startPos10, endPos10)
                if (mTLineCount in 501..550) {
                    startPos11 = binding.sandyaVandanamTextView.layout.getLineStart(501)
                    endPos11 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos11 = binding.sandyaVandanamTextView.layout.getLineStart(501)
                    endPos11 = binding.sandyaVandanamTextView.layout.getLineEnd(550)
                }
                //    pageElevenText = binding.sandyaVandanamTextView.text.toString().substring(startPos11, endPos11)
                if (mTLineCount in 551..600) {
                    startPos12 = binding.sandyaVandanamTextView.layout.getLineStart(551)
                    endPos12 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos12 = binding.sandyaVandanamTextView.layout.getLineStart(551)
                    endPos12 = binding.sandyaVandanamTextView.layout.getLineEnd(600)
                }
                //    pageTwelveText = binding.sandyaVandanamTextView.text.toString().substring(startPos12, endPos12)
                if (mTLineCount in 601..650) {
                    startPos13 = binding.sandyaVandanamTextView.layout.getLineStart(601)
                    endPos13 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos13 = binding.sandyaVandanamTextView.layout.getLineStart(601)
                    endPos13 = binding.sandyaVandanamTextView.layout.getLineEnd(650)
                }
                //    pageThirteenText = binding.sandyaVandanamTextView.text.toString().substring(startPos13, endPos13)
            }
            if (totalpages == 14) {
                startPos1 = binding.sandyaVandanamTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    endPos1 = binding.sandyaVandanamTextView.layout.getLineEnd(50)
                } else {
                    endPos1 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                }
                //    pageOneText = binding.sandyaVandanamTextView.text.toString().substring(startPos1, endPos1)
                if (mTLineCount in 51..100) {
                    startPos2 = binding.sandyaVandanamTextView.layout.getLineStart(51)
                    endPos2 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos2 = binding.sandyaVandanamTextView.layout.getLineStart(51)
                    endPos2 = binding.sandyaVandanamTextView.layout.getLineEnd(100)
                }
                //    pageTwoText = binding.sandyaVandanamTextView.text.toString().substring(startPos2, endPos2)
                if (mTLineCount in 101..150) {
                    startPos3 = binding.sandyaVandanamTextView.layout.getLineStart(101)
                    endPos3 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos3 = binding.sandyaVandanamTextView.layout.getLineStart(101)
                    endPos3 = binding.sandyaVandanamTextView.layout.getLineEnd(150)
                }
                //    pageThreeText = binding.sandyaVandanamTextView.text.toString().substring(startPos3, endPos3)
                if (mTLineCount in 151..200) {
                    startPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(151)
                    endPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(151)
                    endPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(200)
                }
                //    pageFourText = binding.sandyaVandanamTextView.text.toString().substring(startPos4, endPos4)
                if (mTLineCount in 201..250) {
                    startPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(201)
                    endPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(201)
                    endPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(250)
                }
                //    pageFiveText = binding.sandyaVandanamTextView.text.toString().substring(startPos5, endPos5)
                if (mTLineCount in 251..300) {
                    startPos6 = binding.sandyaVandanamTextView.layout.getLineStart(251)
                    endPos6 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos6 = binding.sandyaVandanamTextView.layout.getLineStart(251)
                    endPos6 = binding.sandyaVandanamTextView.layout.getLineEnd(300)
                }
                //    pageSixText = binding.sandyaVandanamTextView.text.toString().substring(startPos6, endPos6)
                if (mTLineCount in 301..350) {
                    startPos7 = binding.sandyaVandanamTextView.layout.getLineStart(301)
                    endPos7 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos7 = binding.sandyaVandanamTextView.layout.getLineStart(301)
                    endPos7 = binding.sandyaVandanamTextView.layout.getLineEnd(350)
                }
                //    pageSevenText = binding.sandyaVandanamTextView.text.toString().substring(startPos7, endPos7)
                if (mTLineCount in 351..400) {
                    startPos8 = binding.sandyaVandanamTextView.layout.getLineStart(351)
                    endPos8 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos8 = binding.sandyaVandanamTextView.layout.getLineStart(351)
                    endPos8 = binding.sandyaVandanamTextView.layout.getLineEnd(400)
                }
                //    pageEightText = binding.sandyaVandanamTextView.text.toString().substring(startPos8, endPos8)
                if (mTLineCount in 401..450) {
                    startPos9 = binding.sandyaVandanamTextView.layout.getLineStart(401)
                    endPos9 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos9 = binding.sandyaVandanamTextView.layout.getLineStart(401)
                    endPos9 = binding.sandyaVandanamTextView.layout.getLineEnd(450)
                }
                //    pageNineText = binding.sandyaVandanamTextView.text.toString().substring(startPos9, endPos9)
                if (mTLineCount in 451..500) {
                    startPos10 = binding.sandyaVandanamTextView.layout.getLineStart(451)
                    endPos10 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos10 = binding.sandyaVandanamTextView.layout.getLineStart(451)
                    endPos10 = binding.sandyaVandanamTextView.layout.getLineEnd(500)
                }
                //    pageTenText = binding.sandyaVandanamTextView.text.toString().substring(startPos10, endPos10)
                if (mTLineCount in 501..550) {
                    startPos11 = binding.sandyaVandanamTextView.layout.getLineStart(501)
                    endPos11 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos11 = binding.sandyaVandanamTextView.layout.getLineStart(501)
                    endPos11 = binding.sandyaVandanamTextView.layout.getLineEnd(550)
                }
                //    pageElevenText = binding.sandyaVandanamTextView.text.toString().substring(startPos11, endPos11)
                if (mTLineCount in 551..600) {
                    startPos12 = binding.sandyaVandanamTextView.layout.getLineStart(551)
                    endPos12 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos12 = binding.sandyaVandanamTextView.layout.getLineStart(551)
                    endPos12 = binding.sandyaVandanamTextView.layout.getLineEnd(600)
                }
                //    pageTwelveText = binding.sandyaVandanamTextView.text.toString().substring(startPos12, endPos12)
                if (mTLineCount in 601..650) {
                    startPos13 = binding.sandyaVandanamTextView.layout.getLineStart(601)
                    endPos13 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos13 = binding.sandyaVandanamTextView.layout.getLineStart(601)
                    endPos13 = binding.sandyaVandanamTextView.layout.getLineEnd(650)
                }
                //    pageThirteenText = binding.sandyaVandanamTextView.text.toString().substring(startPos13, endPos13)
                if (mTLineCount in 651..700) {
                    startPos14 = binding.sandyaVandanamTextView.layout.getLineStart(651)
                    endPos14 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos14 = binding.sandyaVandanamTextView.layout.getLineStart(651)
                    endPos14 = binding.sandyaVandanamTextView.layout.getLineEnd(700)
                }
                //    pageFourteenText = binding.sandyaVandanamTextView.text.toString().substring(startPos14, endPos14)
            }
            if (totalpages == 15) {
                startPos1 = binding.sandyaVandanamTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    endPos1 = binding.sandyaVandanamTextView.layout.getLineEnd(50)
                } else {
                    endPos1 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                }
                //    pageOneText = binding.sandyaVandanamTextView.text.toString().substring(startPos1, endPos1)
                if (mTLineCount in 51..100) {
                    startPos2 = binding.sandyaVandanamTextView.layout.getLineStart(51)
                    endPos2 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos2 = binding.sandyaVandanamTextView.layout.getLineStart(51)
                    endPos2 = binding.sandyaVandanamTextView.layout.getLineEnd(100)
                }
                //    pageTwoText = binding.sandyaVandanamTextView.text.toString().substring(startPos2, endPos2)
                if (mTLineCount in 101..150) {
                    startPos3 = binding.sandyaVandanamTextView.layout.getLineStart(101)
                    endPos3 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos3 = binding.sandyaVandanamTextView.layout.getLineStart(101)
                    endPos3 = binding.sandyaVandanamTextView.layout.getLineEnd(150)
                }
                //    pageThreeText = binding.sandyaVandanamTextView.text.toString().substring(startPos3, endPos3)
                if (mTLineCount in 151..200) {
                    startPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(151)
                    endPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(151)
                    endPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(200)
                }
                //     pageFourText = binding.sandyaVandanamTextView.text.toString().substring(startPos4, endPos4)
                if (mTLineCount in 201..250) {
                    startPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(201)
                    endPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(201)
                    endPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(250)
                }
                //    pageFiveText = binding.sandyaVandanamTextView.text.toString().substring(startPos5, endPos5)
                if (mTLineCount in 251..300) {
                    startPos6 = binding.sandyaVandanamTextView.layout.getLineStart(251)
                    endPos6 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos6 = binding.sandyaVandanamTextView.layout.getLineStart(251)
                    endPos6 = binding.sandyaVandanamTextView.layout.getLineEnd(300)
                }
                //    pageSixText = binding.sandyaVandanamTextView.text.toString().substring(startPos6, endPos6)
                if (mTLineCount in 301..350) {
                    startPos7 = binding.sandyaVandanamTextView.layout.getLineStart(301)
                    endPos7 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos7 = binding.sandyaVandanamTextView.layout.getLineStart(301)
                    endPos7 = binding.sandyaVandanamTextView.layout.getLineEnd(350)
                }
                //     pageSevenText = binding.sandyaVandanamTextView.text.toString().substring(startPos7, endPos7)
                if (mTLineCount in 351..400) {
                    startPos8 = binding.sandyaVandanamTextView.layout.getLineStart(351)
                    endPos8 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos8 = binding.sandyaVandanamTextView.layout.getLineStart(351)
                    endPos8 = binding.sandyaVandanamTextView.layout.getLineEnd(400)
                }
                //    pageEightText = binding.sandyaVandanamTextView.text.toString().substring(startPos8, endPos8)
                if (mTLineCount in 401..450) {
                    startPos9 = binding.sandyaVandanamTextView.layout.getLineStart(401)
                    endPos9 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos9 = binding.sandyaVandanamTextView.layout.getLineStart(401)
                    endPos9 = binding.sandyaVandanamTextView.layout.getLineEnd(450)
                }
                //    pageNineText = binding.sandyaVandanamTextView.text.toString().substring(startPos9, endPos9)
                if (mTLineCount in 451..500) {
                    startPos10 = binding.sandyaVandanamTextView.layout.getLineStart(451)
                    endPos10 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos10 = binding.sandyaVandanamTextView.layout.getLineStart(451)
                    endPos10 = binding.sandyaVandanamTextView.layout.getLineEnd(500)
                }
                //    pageTenText = binding.sandyaVandanamTextView.text.toString().substring(startPos10, endPos10)
                if (mTLineCount in 501..550) {
                    startPos11 = binding.sandyaVandanamTextView.layout.getLineStart(501)
                    endPos11 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos11 = binding.sandyaVandanamTextView.layout.getLineStart(501)
                    endPos11 = binding.sandyaVandanamTextView.layout.getLineEnd(550)
                }
                //    pageElevenText = binding.sandyaVandanamTextView.text.toString().substring(startPos11, endPos11)
                if (mTLineCount in 551..600) {
                    startPos12 = binding.sandyaVandanamTextView.layout.getLineStart(551)
                    endPos12 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos12 = binding.sandyaVandanamTextView.layout.getLineStart(551)
                    endPos12 = binding.sandyaVandanamTextView.layout.getLineEnd(600)
                }
                //    pageTwelveText = binding.sandyaVandanamTextView.text.toString().substring(startPos12, endPos12)
                if (mTLineCount in 601..650) {
                    startPos13 = binding.sandyaVandanamTextView.layout.getLineStart(601)
                    endPos13 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos13 = binding.sandyaVandanamTextView.layout.getLineStart(601)
                    endPos13 = binding.sandyaVandanamTextView.layout.getLineEnd(650)
                }
                //    pageThirteenText = binding.sandyaVandanamTextView.text.toString().substring(startPos13, endPos13)
                if (mTLineCount in 651..700) {
                    startPos14 = binding.sandyaVandanamTextView.layout.getLineStart(651)
                    endPos14 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos14 = binding.sandyaVandanamTextView.layout.getLineStart(651)
                    endPos14 = binding.sandyaVandanamTextView.layout.getLineEnd(700)
                }
                //    pageFourteenText = binding.sandyaVandanamTextView.text.toString().substring(startPos14, endPos14)
                if (mTLineCount in 701..750) {
                    startPos15 = binding.sandyaVandanamTextView.layout.getLineStart(701)
                    endPos15 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos15 = binding.sandyaVandanamTextView.layout.getLineStart(701)
                    endPos15 = binding.sandyaVandanamTextView.layout.getLineEnd(750)
                }
                //    pageFifteenText = binding.sandyaVandanamTextView.text.toString().substring(startPos15, endPos15)
            }
            if (totalpages == 16) {
                startPos1 = binding.sandyaVandanamTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    endPos1 = binding.sandyaVandanamTextView.layout.getLineEnd(50)
                } else {
                    endPos1 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                }
                //   pageOneText = binding.sandyaVandanamTextView.text.toString().substring(startPos1, endPos1)
                if (mTLineCount in 51..100) {
                    startPos2 = binding.sandyaVandanamTextView.layout.getLineStart(51)
                    endPos2 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos2 = binding.sandyaVandanamTextView.layout.getLineStart(51)
                    endPos2 = binding.sandyaVandanamTextView.layout.getLineEnd(100)
                }
                //    pageTwoText = binding.sandyaVandanamTextView.text.toString().substring(startPos2, endPos2)
                if (mTLineCount in 101..150) {
                    startPos3 = binding.sandyaVandanamTextView.layout.getLineStart(101)
                    endPos3 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos3 = binding.sandyaVandanamTextView.layout.getLineStart(101)
                    endPos3 = binding.sandyaVandanamTextView.layout.getLineEnd(150)
                }
                //    pageThreeText = binding.sandyaVandanamTextView.text.toString().substring(startPos3, endPos3)
                if (mTLineCount in 151..200) {
                    startPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(151)
                    endPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(151)
                    endPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(200)
                }
                //    pageFourText = binding.sandyaVandanamTextView.text.toString().substring(startPos4, endPos4)
                if (mTLineCount in 201..250) {
                    startPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(201)
                    endPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(201)
                    endPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(250)
                }
                //    pageFiveText = binding.sandyaVandanamTextView.text.toString().substring(startPos5, endPos5)
                if (mTLineCount in 251..300) {
                    startPos6 = binding.sandyaVandanamTextView.layout.getLineStart(251)
                    endPos6 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos6 = binding.sandyaVandanamTextView.layout.getLineStart(251)
                    endPos6 = binding.sandyaVandanamTextView.layout.getLineEnd(300)
                }
                //    pageSixText = binding.sandyaVandanamTextView.text.toString().substring(startPos6, endPos6)
                if (mTLineCount in 301..350) {
                    startPos7 = binding.sandyaVandanamTextView.layout.getLineStart(301)
                    endPos7 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos7 = binding.sandyaVandanamTextView.layout.getLineStart(301)
                    endPos7 = binding.sandyaVandanamTextView.layout.getLineEnd(350)
                }
                //    pageSevenText = binding.sandyaVandanamTextView.text.toString().substring(startPos7, endPos7)
                if (mTLineCount in 351..400) {
                    startPos8 = binding.sandyaVandanamTextView.layout.getLineStart(351)
                    endPos8 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos8 = binding.sandyaVandanamTextView.layout.getLineStart(351)
                    endPos8 = binding.sandyaVandanamTextView.layout.getLineEnd(400)
                }
                //    pageEightText = binding.sandyaVandanamTextView.text.toString().substring(startPos8, endPos8)
                if (mTLineCount in 401..450) {
                    startPos9 = binding.sandyaVandanamTextView.layout.getLineStart(401)
                    endPos9 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos9 = binding.sandyaVandanamTextView.layout.getLineStart(401)
                    endPos9 = binding.sandyaVandanamTextView.layout.getLineEnd(450)
                }
                //    pageNineText = binding.sandyaVandanamTextView.text.toString().substring(startPos9, endPos9)
                if (mTLineCount in 451..500) {
                    startPos10 = binding.sandyaVandanamTextView.layout.getLineStart(451)
                    endPos10 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos10 = binding.sandyaVandanamTextView.layout.getLineStart(451)
                    endPos10 = binding.sandyaVandanamTextView.layout.getLineEnd(500)
                }
                //    pageTenText = binding.sandyaVandanamTextView.text.toString().substring(startPos10, endPos10)
                if (mTLineCount in 501..550) {
                    startPos11 = binding.sandyaVandanamTextView.layout.getLineStart(501)
                    endPos11 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos11 = binding.sandyaVandanamTextView.layout.getLineStart(501)
                    endPos11 = binding.sandyaVandanamTextView.layout.getLineEnd(550)
                }
                //    pageElevenText = binding.sandyaVandanamTextView.text.toString().substring(startPos11, endPos11)
                if (mTLineCount in 551..600) {
                    startPos12 = binding.sandyaVandanamTextView.layout.getLineStart(551)
                    endPos12 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos12 = binding.sandyaVandanamTextView.layout.getLineStart(551)
                    endPos12 = binding.sandyaVandanamTextView.layout.getLineEnd(600)
                }
                //    pageTwelveText = binding.sandyaVandanamTextView.text.toString().substring(startPos12, endPos12)
                if (mTLineCount in 601..650) {
                    startPos13 = binding.sandyaVandanamTextView.layout.getLineStart(601)
                    endPos13 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos13 = binding.sandyaVandanamTextView.layout.getLineStart(601)
                    endPos13 = binding.sandyaVandanamTextView.layout.getLineEnd(650)
                }
                //    pageThirteenText = binding.sandyaVandanamTextView.text.toString().substring(startPos13, endPos13)
                if (mTLineCount in 651..700) {
                    startPos14 = binding.sandyaVandanamTextView.layout.getLineStart(651)
                    endPos14 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos14 = binding.sandyaVandanamTextView.layout.getLineStart(651)
                    endPos14 = binding.sandyaVandanamTextView.layout.getLineEnd(700)
                }
                //    pageFourteenText = binding.sandyaVandanamTextView.text.toString().substring(startPos14, endPos14)
                if (mTLineCount in 701..750) {
                    startPos15 = binding.sandyaVandanamTextView.layout.getLineStart(701)
                    endPos15 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos15 = binding.sandyaVandanamTextView.layout.getLineStart(701)
                    endPos15 = binding.sandyaVandanamTextView.layout.getLineEnd(750)
                }
                //    pageFifteenText = binding.sandyaVandanamTextView.text.toString().substring(startPos15, endPos15)
                if (mTLineCount in 751..800) {
                    startPos16 = binding.sandyaVandanamTextView.layout.getLineStart(751)
                    endPos16 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos16 = binding.sandyaVandanamTextView.layout.getLineStart(751)
                    endPos16 = binding.sandyaVandanamTextView.layout.getLineEnd(800)
                }
                //    pageSixteenText = binding.sandyaVandanamTextView.text.toString().substring(startPos16, endPos16)
            }
            if (totalpages == 17) {
                startPos1 = binding.sandyaVandanamTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    endPos1 = binding.sandyaVandanamTextView.layout.getLineEnd(50)
                } else {
                    endPos1 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                }
                //    pageOneText = binding.sandyaVandanamTextView.text.toString().substring(startPos1, endPos1)
                if (mTLineCount in 51..100) {
                    startPos2 = binding.sandyaVandanamTextView.layout.getLineStart(51)
                    endPos2 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos2 = binding.sandyaVandanamTextView.layout.getLineStart(51)
                    endPos2 = binding.sandyaVandanamTextView.layout.getLineEnd(100)
                }
                //    pageTwoText = binding.sandyaVandanamTextView.text.toString().substring(startPos2, endPos2)
                if (mTLineCount in 101..150) {
                    startPos3 = binding.sandyaVandanamTextView.layout.getLineStart(101)
                    endPos3 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos3 = binding.sandyaVandanamTextView.layout.getLineStart(101)
                    endPos3 = binding.sandyaVandanamTextView.layout.getLineEnd(150)
                }
                //    pageThreeText = binding.sandyaVandanamTextView.text.toString().substring(startPos3, endPos3)
                if (mTLineCount in 151..200) {
                    startPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(151)
                    endPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(151)
                    endPos4 = binding.sandyaVandanamTextView.layout.getLineEnd(200)
                }
                //    pageFourText = binding.sandyaVandanamTextView.text.toString().substring(startPos4, endPos4)
                if (mTLineCount in 201..250) {
                    startPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(201)
                    endPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(201)
                    endPos5 = binding.sandyaVandanamTextView.layout.getLineEnd(250)
                }
                //    pageFiveText = binding.sandyaVandanamTextView.text.toString().substring(startPos5, endPos5)
                if (mTLineCount in 251..300) {
                    startPos6 = binding.sandyaVandanamTextView.layout.getLineStart(251)
                    endPos6 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos6 = binding.sandyaVandanamTextView.layout.getLineStart(251)
                    endPos6 = binding.sandyaVandanamTextView.layout.getLineEnd(300)
                }
                //    pageSixText = binding.sandyaVandanamTextView.text.toString().substring(startPos6, endPos6)
                if (mTLineCount in 301..350) {
                    startPos7 = binding.sandyaVandanamTextView.layout.getLineStart(301)
                    endPos7 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos7 = binding.sandyaVandanamTextView.layout.getLineStart(301)
                    endPos7 = binding.sandyaVandanamTextView.layout.getLineEnd(350)
                }
                //    pageSevenText = binding.sandyaVandanamTextView.text.toString().substring(startPos7, endPos7)
                if (mTLineCount in 351..400) {
                    startPos8 = binding.sandyaVandanamTextView.layout.getLineStart(351)
                    endPos8 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos8 = binding.sandyaVandanamTextView.layout.getLineStart(351)
                    endPos8 = binding.sandyaVandanamTextView.layout.getLineEnd(400)
                }
                //    pageEightText = binding.sandyaVandanamTextView.text.toString().substring(startPos8, endPos8)
                if (mTLineCount in 401..450) {
                    startPos9 = binding.sandyaVandanamTextView.layout.getLineStart(401)
                    endPos9 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos9 = binding.sandyaVandanamTextView.layout.getLineStart(401)
                    endPos9 = binding.sandyaVandanamTextView.layout.getLineEnd(450)
                }
                //    pageNineText = binding.sandyaVandanamTextView.text.toString().substring(startPos9, endPos9)
                if (mTLineCount in 451..500) {
                    startPos10 = binding.sandyaVandanamTextView.layout.getLineStart(451)
                    endPos10 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos10 = binding.sandyaVandanamTextView.layout.getLineStart(451)
                    endPos10 = binding.sandyaVandanamTextView.layout.getLineEnd(500)
                }
                //    pageTenText = binding.sandyaVandanamTextView.text.toString().substring(startPos10, endPos10)
                if (mTLineCount in 501..550) {
                    startPos11 = binding.sandyaVandanamTextView.layout.getLineStart(501)
                    endPos11 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos11 = binding.sandyaVandanamTextView.layout.getLineStart(501)
                    endPos11 = binding.sandyaVandanamTextView.layout.getLineEnd(550)
                }
                //    pageElevenText = binding.sandyaVandanamTextView.text.toString().substring(startPos11, endPos11)
                if (mTLineCount in 551..600) {
                    startPos12 = binding.sandyaVandanamTextView.layout.getLineStart(551)
                    endPos12 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos12 = binding.sandyaVandanamTextView.layout.getLineStart(551)
                    endPos12 = binding.sandyaVandanamTextView.layout.getLineEnd(600)
                }
                //    pageTwelveText = binding.sandyaVandanamTextView.text.toString().substring(startPos12, endPos12)
                if (mTLineCount in 601..650) {
                    startPos13 = binding.sandyaVandanamTextView.layout.getLineStart(601)
                    endPos13 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos13 = binding.sandyaVandanamTextView.layout.getLineStart(601)
                    endPos13 = binding.sandyaVandanamTextView.layout.getLineEnd(650)
                }
                //    pageThirteenText = binding.sandyaVandanamTextView.text.toString().substring(startPos13, endPos13)
                if (mTLineCount in 651..700) {
                    startPos14 = binding.sandyaVandanamTextView.layout.getLineStart(651)
                    endPos14 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos14 = binding.sandyaVandanamTextView.layout.getLineStart(651)
                    endPos14 = binding.sandyaVandanamTextView.layout.getLineEnd(700)
                }
                //    pageFourteenText = binding.sandyaVandanamTextView.text.toString().substring(startPos14, endPos14)
                if (mTLineCount in 701..750) {
                    startPos15 = binding.sandyaVandanamTextView.layout.getLineStart(701)
                    endPos15 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos15 = binding.sandyaVandanamTextView.layout.getLineStart(701)
                    endPos15 = binding.sandyaVandanamTextView.layout.getLineEnd(750)
                }
                //     pageFifteenText = binding.sandyaVandanamTextView.text.toString().substring(startPos15, endPos15)
                if (mTLineCount in 751..800) {
                    startPos16 = binding.sandyaVandanamTextView.layout.getLineStart(751)
                    endPos16 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos16 = binding.sandyaVandanamTextView.layout.getLineStart(751)
                    endPos16 = binding.sandyaVandanamTextView.layout.getLineEnd(800)
                }
                //    pageSixteenText = binding.sandyaVandanamTextView.text.toString().substring(startPos16, endPos16)
                if (mTLineCount in 801..850) {
                    startPos17 = binding.sandyaVandanamTextView.layout.getLineStart(801)
                    endPos17 = binding.sandyaVandanamTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos17 = binding.sandyaVandanamTextView.layout.getLineStart(801)
                    endPos17 = binding.sandyaVandanamTextView.layout.getLineEnd(850)
                }
                //    pageSeventeenText = binding.sandyaVandanamTextView.text.toString().substring(startPos17, endPos17)
            }
            val printManager = this.getSystemService(Context.PRINT_SERVICE) as PrintManager
            val jobName = this.getString(R.string.app_name) + "-$heading"
            println("jobName : $jobName")
            printManager.print(jobName, MyPrintDocumentAdapter(this), null)
        }
    }
}
