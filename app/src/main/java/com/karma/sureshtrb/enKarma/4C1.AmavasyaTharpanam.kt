@file:Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")

package com.karma.sureshtrb.enKarma

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.app.AlertDialog
import android.content.Context
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
import android.text.style.*
import android.widget.Button
import androidx.lifecycle.lifecycleScope
//import kotlinx.android.synthetic.main.activity_amavasya_tharpanam.*
import com.karma.sureshtrb.enKarma.databinding.ActivityAmavasyaTharpanamBinding
import java.io.FileOutputStream
import java.io.IOException
import android.app.AlertDialog.Builder
import android.app.ProgressDialog


class AmavasyaTharpanam : AppCompatActivity() {

    var totalpages: Int = 1
    var pageOneText: CharSequence? =null
    var pageTwoText: CharSequence? = null
    var pageThreeText: CharSequence? = null
    var pageFourText: CharSequence? = null
    var pageFiveText: CharSequence? = null
    var pageSixText: CharSequence? = null
    var pageSevenText: CharSequence? = null
    var pageEightText: CharSequence? = null
    var pageNineText: CharSequence? = null
    var pageTenText: CharSequence? = null
    var pageElevenText: CharSequence? = null
    var pageTwelveText: CharSequence? = null
    var pageThirteenText: CharSequence? = null
    var pageFourteenText: CharSequence? = null
    var pageFifteenText: CharSequence? = null
    var pageSixteenText: CharSequence? = null
    var pageSeventeenText: CharSequence? = null

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

    @SuppressLint("ResourceType")
    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    private lateinit var binding: ActivityAmavasyaTharpanamBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_amavasya_tharpanam)
        binding = ActivityAmavasyaTharpanamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val printBtn = findViewById<Button>(R.id.printButton)

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

        val yrNamee: String = intent.getStringExtra("Peyar").toString()
        val yrFNamee: String = intent.getStringExtra("Appa").toString()
        val yrGFNamee: String = intent.getStringExtra("Thatha").toString()
        val yrGGFNamee: String = intent.getStringExtra("Kollu").toString()
        val yrGGGFNamee: String = intent.getStringExtra("Yellu").toString()
        val MFNamee: String = intent.getStringExtra("AmmaAppa").toString()
        val MGFNamee: String = intent.getStringExtra("AmmaThatha").toString()
        val MGGFNamee: String = intent.getStringExtra("AmmaKolluThatha").toString()

        supportActionBar!!.setHomeAsUpIndicator(R.drawable.home)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.subtitle = todThithi + " தர்ப்பணம்"//"அமாவாஸய தர்ப்பணம்"
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setLogo(R.drawable.karma)
        supportActionBar!!.setDisplayUseLogoEnabled(true)

        val exExFlag = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        //  var incIncFlag = Spanned.SPAN_INCLUSIVE_INCLUSIVE
        val start: Int = 0

        val bdSt20A = SpannableString("\nsThithi தர்ப்பணம் dateToday (கர்த்தா - yourName)\n")
        val regexReplace2 = """(sThithi)""".toRegex()
        val bdSt20B = SpannableString(bdSt20A.replace(regexReplace2, todThithi))
        val regexReplace3 = """(dateToday)""".toRegex()
        val bdSt20C = SpannableString(bdSt20B.replace(regexReplace3, dateTdy))
        val regexReplace4 = """(yourName)""".toRegex()
        val heading = SpannableString(bdSt20C.replace(regexReplace4, yrNamee))
        heading.setSpan(AbsoluteSizeSpan(16, true), start, heading.length, exExFlag)
        heading.setSpan(StyleSpan(Typeface.BOLD), start, heading.length, exExFlag)
        heading.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, heading.length, exExFlag)

        val Heading1 = SpannableString("ஆசமனம்\n")
        Heading1.setSpan(AbsoluteSizeSpan(16, true), start, Heading1.length, exExFlag)
        Heading1.setSpan(StyleSpan(Typeface.BOLD), start, Heading1.length, exExFlag)
        Heading1.setSpan(UnderlineSpan(), start, Heading1.length, exExFlag)
        Heading1.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, Heading1.length, exExFlag)

        val Comment1 = SpannableString(
            "\n ஒவ்வொரு உத்தரிணி ஜலம் எடுத்து வலது கையில் விட்டு ஒவ்வொரு மந்திரத்துக்கும் " +
                    "உட்கொள்ளவும் "
        )
        Comment1.setSpan(AbsoluteSizeSpan(13, true), start, Comment1.length, exExFlag)
        Comment1.setSpan(StyleSpan(Typeface.ITALIC), start, Comment1.length, exExFlag)
        Comment1.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment1.length, exExFlag)

        val Body1 = SpannableString("- \nஓம் அச்யுதாய நம: |  ஓம் அனந்தாய நம: |  ஓம் கோவிந்தாய நம: ||")
        Body1.setSpan(AbsoluteSizeSpan(14, true), start, Body1.length, exExFlag)
        Body1.setSpan(StyleSpan(Typeface.BOLD), start, Body1.length, exExFlag)
        Body1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body1.length, exExFlag)

        val Comment2 = SpannableString("\n ஒரு உத்தரிணி ஜலம் எடுத்து வலது கையில் விட்டு கீழே விடவும் ")
        Comment2.setSpan(AbsoluteSizeSpan(13, true), start, Comment2.length, exExFlag)
        Comment2.setSpan(StyleSpan(Typeface.ITALIC), start, Comment2.length, exExFlag)
        Comment2.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment2.length, exExFlag)

        val Body2 = SpannableString("- அபஉபஸ்ப்ருஸ்ய ||\n")
        Body2.setSpan(AbsoluteSizeSpan(14, true), start, Body2.length, exExFlag)
        Body2.setSpan(StyleSpan(Typeface.BOLD), start, Body2.length, exExFlag)
        Body2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body2.length, exExFlag)

        val Comment3 = SpannableString(
            "\nவலது கட்டை விரலால் வாயை துடைத்துக் கொள்ளவும்\n விரல்களால் அங்கங்களை " +
                    "தொடவும் \nநடு மற்றும் மோதிர விரல்   வலது கன்னம்"
        )
        Comment3.setSpan(AbsoluteSizeSpan(13, true), start, Comment3.length, exExFlag)
        Comment3.setSpan(StyleSpan(Typeface.ITALIC), start, Comment3.length, exExFlag)
        Comment3.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment3.length, exExFlag)

        val Body3 = SpannableString("- கேசவா")
        Body3.setSpan(AbsoluteSizeSpan(14, true), start, Body3.length, exExFlag)
        Body3.setSpan(StyleSpan(Typeface.BOLD), start, Body3.length, exExFlag)
        Body3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body3.length, exExFlag)

        val Comment4 = SpannableString("\n நடு மற்றும் மோதிர விரல்   இடது கன்னம்")
        Comment4.setSpan(AbsoluteSizeSpan(13, true), start, Comment4.length, exExFlag)
        Comment4.setSpan(StyleSpan(Typeface.ITALIC), start, Comment4.length, exExFlag)
        Comment4.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment4.length, exExFlag)

        val Body4 = SpannableString("- நாராயணா")
        Body4.setSpan(AbsoluteSizeSpan(14, true), start, Body4.length, exExFlag)
        Body4.setSpan(StyleSpan(Typeface.BOLD), start, Body4.length, exExFlag)
        Body4.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body4.length, exExFlag)

        val Comment5 = SpannableString("\n ஆள்காட்டி மற்றும் கட்டை விரல்   வலது மூக்கு")
        Comment5.setSpan(AbsoluteSizeSpan(13, true), start, Comment5.length, exExFlag)
        Comment5.setSpan(StyleSpan(Typeface.ITALIC), start, Comment5.length, exExFlag)
        Comment5.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment5.length, exExFlag)

        val Body5 = SpannableString("- மாதவா")
        Body5.setSpan(AbsoluteSizeSpan(14, true), start, Body5.length, exExFlag)
        Body5.setSpan(StyleSpan(Typeface.BOLD), start, Body5.length, exExFlag)
        Body5.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body5.length, exExFlag)

        val Comment6 = SpannableString("\n ஆள்காட்டி மற்றும் கட்டை விரல்    இடது மூக்கு")
        Comment6.setSpan(AbsoluteSizeSpan(13, true), start, Comment6.length, exExFlag)
        Comment6.setSpan(StyleSpan(Typeface.ITALIC), start, Comment6.length, exExFlag)
        Comment6.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment6.length, exExFlag)

        val Body6 = SpannableString("- கோவிந்தா")
        Body6.setSpan(AbsoluteSizeSpan(14, true), start, Body6.length, exExFlag)
        Body6.setSpan(StyleSpan(Typeface.BOLD), start, Body6.length, exExFlag)
        Body6.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body6.length, exExFlag)

        val Comment7 = SpannableString("\n நடு மற்றும் கட்டை விரல்    வலது கண்")
        Comment7.setSpan(AbsoluteSizeSpan(13, true), start, Comment7.length, exExFlag)
        Comment7.setSpan(StyleSpan(Typeface.ITALIC), start, Comment7.length, exExFlag)
        Comment7.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment7.length, exExFlag)

        val Body7 = SpannableString("- விஷ்ணு")
        Body7.setSpan(AbsoluteSizeSpan(14, true), start, Body7.length, exExFlag)
        Body7.setSpan(StyleSpan(Typeface.BOLD), start, Body7.length, exExFlag)
        Body7.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body7.length, exExFlag)

        val Comment8 = SpannableString("\n நடு மற்றும் கட்டை விரல்    இடது கண்")
        Comment8.setSpan(AbsoluteSizeSpan(13, true), start, Comment8.length, exExFlag)
        Comment8.setSpan(StyleSpan(Typeface.ITALIC), start, Comment8.length, exExFlag)
        Comment8.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment8.length, exExFlag)

        val Body8 = SpannableString("- மதுஸூதனா")
        Body8.setSpan(AbsoluteSizeSpan(14, true), start, Body8.length, exExFlag)
        Body8.setSpan(StyleSpan(Typeface.BOLD), start, Body8.length, exExFlag)
        Body8.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body8.length, exExFlag)

        val Comment9 = SpannableString("\n மோதிர மற்றும் கட்டை விரல்    வலது காது")
        Comment9.setSpan(AbsoluteSizeSpan(13, true), start, Comment9.length, exExFlag)
        Comment9.setSpan(StyleSpan(Typeface.ITALIC), start, Comment9.length, exExFlag)
        Comment9.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment9.length, exExFlag)

        val Body9 = SpannableString("- த்ரிவிக்ரமா")
        Body9.setSpan(AbsoluteSizeSpan(14, true), start, Body9.length, exExFlag)
        Body9.setSpan(StyleSpan(Typeface.BOLD), start, Body9.length, exExFlag)
        Body9.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body9.length, exExFlag)

        val Comment10 = SpannableString("\n மோதிர மற்றும் கட்டை விரல்     இடது காது")
        Comment10.setSpan(AbsoluteSizeSpan(13, true), start, Comment10.length, exExFlag)
        Comment10.setSpan(StyleSpan(Typeface.ITALIC), start, Comment10.length, exExFlag)
        Comment10.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment10.length, exExFlag)

        val Body10 = SpannableString("- வாமனா")
        Body10.setSpan(AbsoluteSizeSpan(14, true), start, Body10.length, exExFlag)
        Body10.setSpan(StyleSpan(Typeface.BOLD), start, Body10.length, exExFlag)
        Body10.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body10.length, exExFlag)

        val Comment11 = SpannableString("\n வலது உள்ளங்கை     மார்பு")
        Comment11.setSpan(AbsoluteSizeSpan(13, true), start, Comment11.length, exExFlag)
        Comment11.setSpan(StyleSpan(Typeface.ITALIC), start, Comment11.length, exExFlag)
        Comment11.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment11.length, exExFlag)

        val Body11 = SpannableString("- ஸ்ரீதரா")
        Body11.setSpan(AbsoluteSizeSpan(14, true), start, Body11.length, exExFlag)
        Body11.setSpan(StyleSpan(Typeface.BOLD), start, Body11.length, exExFlag)
        Body11.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body11.length, exExFlag)

        val Comment12 = SpannableString("\n ஐந்து விரல் நுனி     முன் தலை")
        Comment12.setSpan(AbsoluteSizeSpan(13, true), start, Comment12.length, exExFlag)
        Comment12.setSpan(StyleSpan(Typeface.ITALIC), start, Comment12.length, exExFlag)
        Comment12.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment12.length, exExFlag)

        val Body12 = SpannableString("- ஹ்ருஷீகேஷா")
        Body12.setSpan(AbsoluteSizeSpan(14, true), start, Body12.length, exExFlag)
        Body12.setSpan(StyleSpan(Typeface.BOLD), start, Body12.length, exExFlag)
        Body12.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body12.length, exExFlag)

        val Comment13 = SpannableString("\n ஐந்து விரல் நுனி     வலது தோள்")
        Comment13.setSpan(AbsoluteSizeSpan(13, true), start, Comment13.length, exExFlag)
        Comment13.setSpan(StyleSpan(Typeface.ITALIC), start, Comment13.length, exExFlag)
        Comment13.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment13.length, exExFlag)

        val Body13 = SpannableString("- பத்மநாபா")
        Body13.setSpan(AbsoluteSizeSpan(14, true), start, Body13.length, exExFlag)
        Body13.setSpan(StyleSpan(Typeface.BOLD), start, Body13.length, exExFlag)
        Body13.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body13.length, exExFlag)

        val Comment14 = SpannableString("\n ஐந்து விரல் நுனி     இடது தோள்")
        Comment14.setSpan(AbsoluteSizeSpan(13, true), start, Comment14.length, exExFlag)
        Comment14.setSpan(StyleSpan(Typeface.ITALIC), start, Comment14.length, exExFlag)
        Comment14.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment14.length, exExFlag)

        val Body14 = SpannableString("- தாமோதரா\n")
        Body14.setSpan(AbsoluteSizeSpan(14, true), start, Body14.length, exExFlag)
        Body14.setSpan(StyleSpan(Typeface.BOLD), start, Body14.length, exExFlag)
        Body14.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body14.length, exExFlag)
        //==============================================================================================================
        val Comment15A = SpannableString(
            "\n இஃது அமாவாசையன்று மாத்யான்ஹிக காலத்தில் மாத்யான்ஹிக, ப்ரம்ஹயக்ஞ, தேவரிஷி பித்ரு தர்ப்பணங்களை யதாவத் முடித்துக் கொண்டு செய்ய வேண்டிய கர்மா.)\n" +
                    "    இதற்கு இரண்டு 7, 5, 3 பில் ஒத்தப்படையில் உள்ள மடித்த கூர்ச்சம், 3 பில் பவித்ரம் ஒன்று கொஞ்சம் எள்,"
        )
        Comment15A.setSpan(AbsoluteSizeSpan(13, true), start, Comment15A.length, exExFlag)
        Comment15A.setSpan(StyleSpan(Typeface.ITALIC), start, Comment15A.length, exExFlag)
        Comment15A.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment15A.length, exExFlag)

        val Comment15B = SpannableString("\n இஃது அமாவாசையன்று மாத்யான்ஹிக காலத்தில் மாத்யான்ஹிக, ப்ரம்ஹயக்ஞ, தேவரிஷி பித்ரு தர்ப்பணங்களை யதாவத் முடித்துக் கொண்டு செய்ய வேண்டிய கர்மா.)\n      " +
                "இதற்கு இரண்டு 7, 5, 3 பில்  ஒத்தப்படையில் உள்ள  மடித்த கூர்ச்சம், 3 பில் பவித்ரம் ஒன்று கொஞ்சம் எள்ளும், சிறிது அரிசி,")
        Comment15B.setSpan(AbsoluteSizeSpan(13, true), start, Comment15B.length, exExFlag)
        Comment15B.setSpan(StyleSpan(Typeface.ITALIC), start, Comment15B.length, exExFlag)
        Comment15B.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment15B.length, exExFlag)


        val Comment15C = SpannableString(
            " சொம்பு, பஞ்சபாத்ரத்தில் தீர்த்தம் தேவை.\n" +
                    "    கிழக்கு முகமாக ஆசனத்தில் அமர்ந்து அமைதியாக நிறுத்தி நிதானமாக, பித்ரு தேவதைகளை மனதில் தியானித்து " +
                    "கீழ்க்கூறிய பிரகாரம் தர்ப்பணம் செய்ய வேண்டும்.\nமூன்று பில் பவித்ரம் தரித்து \n"
        )
        Comment15C.setSpan(AbsoluteSizeSpan(13, true), start, Comment15C.length, exExFlag)
        Comment15C.setSpan(StyleSpan(Typeface.ITALIC), start, Comment15C.length, exExFlag)
        Comment15C.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment15C.length, exExFlag)

        val Body15 = SpannableString("தர்பேஷு ஆசீன:")
        Body15.setSpan(AbsoluteSizeSpan(14, true), start, Body15.length, exExFlag)
        Body15.setSpan(StyleSpan(Typeface.BOLD), start, Body15.length, exExFlag)
        Body15.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body15.length, exExFlag)

        val Comment16 = SpannableString(" என்று சொல்லி 3 கட்டை தர்பங்களை ஆசனமாகவும்\n")
        Comment16.setSpan(AbsoluteSizeSpan(13, true), start, Comment16.length, exExFlag)
        Comment16.setSpan(StyleSpan(Typeface.ITALIC), start, Comment16.length, exExFlag)
        Comment16.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment16.length, exExFlag)

        val Body16 = SpannableString("தர்பான் தாரயமாண:")
        Body16.setSpan(AbsoluteSizeSpan(14, true), start, Body16.length, exExFlag)
        Body16.setSpan(StyleSpan(Typeface.BOLD), start, Body16.length, exExFlag)
        Body16.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body16.length, exExFlag)

        val Comment17 = SpannableString(
            "  என்று சொல்லி 3 கட்டை தர்பங்களை பவித்ரத்துடன் கையிலிடுக்கிக் கொண்டும், " +
                    "சங்கல்பம் செய்ய வேண்டும்.\n"
        )
        Comment17.setSpan(AbsoluteSizeSpan(13, true), start, Comment17.length, exExFlag)
        Comment17.setSpan(StyleSpan(Typeface.ITALIC), start, Comment17.length, exExFlag)
        Comment17.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment17.length, exExFlag)

        val Heading2 = SpannableString("\nசங்கல்பம்\n")
        Heading2.setSpan(AbsoluteSizeSpan(16, true), start, Heading2.length, exExFlag)
        Heading2.setSpan(StyleSpan(Typeface.BOLD), start, Heading2.length, exExFlag)
        Heading2.setSpan(UnderlineSpan(), start, Heading2.length, exExFlag)
        Heading2.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, Heading2.length, exExFlag)

        val Body17 = SpannableString(
            "ஓம் சுக்லாம்பரதரம் விஷ்ணும்\n" +
                    "        சசிவர்ணம் சதுர்புஜம்\n" +
                    "    ப்ரஸன்ன வதனம் த்யாயேத்\n" +
                    "        ஸர்வ விக்ன உபசாந்தயே"
        )
        Body17.setSpan(AbsoluteSizeSpan(14, true), start, Body17.length, exExFlag)
        Body17.setSpan(StyleSpan(Typeface.BOLD), start, Body17.length, exExFlag)
        Body17.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body17.length, exExFlag)

        val Comment18 = SpannableString("\nமுன் தலையில் கை வைத்துக் கொண்டு\n ")
        Comment18.setSpan(AbsoluteSizeSpan(13, true), start, Comment18.length, exExFlag)
        Comment18.setSpan(StyleSpan(Typeface.ITALIC), start, Comment18.length, exExFlag)
        Comment18.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment18.length, exExFlag)

        val Body18 = SpannableString("ஓம் ப்ரணவஸ்ய - பரப்ரும்மரிஷி:")
        Body18.setSpan(AbsoluteSizeSpan(14, true), start, Body18.length, exExFlag)
        Body18.setSpan(StyleSpan(Typeface.BOLD), start, Body18.length, exExFlag)
        Body18.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body18.length, exExFlag)

        val Comment19 = SpannableString("\n நுனிமூக்கில் கை வைத்துக் கொண்டு \n")
        Comment19.setSpan(AbsoluteSizeSpan(13, true), start, Comment19.length, exExFlag)
        Comment19.setSpan(StyleSpan(Typeface.ITALIC), start, Comment19.length, exExFlag)
        Comment19.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment19.length, exExFlag)

        val Body19 = SpannableString("தேவீ காயத்ரீச் சந்த:")
        Body19.setSpan(AbsoluteSizeSpan(14, true), start, Body19.length, exExFlag)
        Body19.setSpan(StyleSpan(Typeface.BOLD), start, Body19.length, exExFlag)
        Body19.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body19.length, exExFlag)

        val Comment20 = SpannableString("\nஹ்ருதயத்தில் கை வைத்துக் கொண்டு \n")
        Comment20.setSpan(AbsoluteSizeSpan(13, true), start, Comment20.length, exExFlag)
        Comment20.setSpan(StyleSpan(Typeface.ITALIC), start, Comment20.length, exExFlag)
        Comment20.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment20.length, exExFlag)

        val Body20 = SpannableString("ஸவிதா பரமாத்மா தேவதா")
        Body20.setSpan(AbsoluteSizeSpan(14, true), start, Body20.length, exExFlag)
        Body20.setSpan(StyleSpan(Typeface.BOLD), start, Body20.length, exExFlag)
        Body20.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body20.length, exExFlag)

        val Comment21 = SpannableString("\n(கைகளை உள் வாங்கவும்) - ")
        Comment21.setSpan(AbsoluteSizeSpan(13, true), start, Comment21.length, exExFlag)
        Comment21.setSpan(StyleSpan(Typeface.ITALIC), start, Comment21.length, exExFlag)
        Comment21.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment21.length, exExFlag)

        val Body21 = SpannableString("ப்ராணாயாமே விநியோக:\n")
        Body21.setSpan(AbsoluteSizeSpan(14, true), start, Body21.length, exExFlag)
        Body21.setSpan(StyleSpan(Typeface.BOLD), start, Body21.length, exExFlag)
        Body21.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body21.length, exExFlag)

        val Comment22 = SpannableString("\nப்ராணாயாமம்  செய்ய வேண்டும்")
        Comment22.setSpan(AbsoluteSizeSpan(13, true), start, Comment22.length, exExFlag)
        Comment22.setSpan(StyleSpan(Typeface.ITALIC), start, Comment22.length, exExFlag)
        Comment22.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment22.length, exExFlag)

        val Body22 = SpannableString(
            "\nஓம் பூ: ஓம் புவ: ஓம் சுவ: ஓம் மஹ:\n" +
                    "        ஓம் ஜந: ஓம் தப: ஓம் ஸத்யம் \nதத்ஸவிதுர் வரேண்யம்\n" +
                    "        பர்கோ தேவஸ்ய \nதீமஹி தியோயோ ந:  ப்ரசோதயாத்\nஓம் ஆப: ஜ்யோதீரஸ: \nஅம்ருதம் ப்ரம்ஹ பூர்புவஸ்வரோம்\n" +
                    "    \nஓம் அபவித்ர: பவித்ரோவா ஸர்வாவஸ்தாம் கதோபிவா யஸ்மரேத் புண்டரீகாக்ஷ்ம் ஸபாஹ்யாப்யந்தர: சுசி:\n" +
                    "    மானஸம் வாசிகம் பாபம் கர்மனா ஸமுபார்ஜிதம் ஸ்ரீராம ஸ்மரணேநைவ வ்யபோஹதி நஸம்சய:\n" +
                    "    ஸ்ரீராம ராமராம  திதிர்விஷ்ணு: ததாவார: நக்ஷத்ரம் விஷ்ணுரேவச யோகஸ்ச கரணம் சைவ ஸர்வம் விஷ்ணுமயம் ஜகத்\n" +
                    "    ஸ்ரீகோவிந்த கோவிந்தகோவிந்த அத்ய ஸ்ரீ பகவத: மஹாபுருஷஸ்ய விஷ்ணோ: ஆக்ஞயா ப்ரவர்த்தமானஸ்ய\n" +
                    "            \nஆத்ய ப்ரம்ஹண:"
        )
        Body22.setSpan(AbsoluteSizeSpan(14, true), start, Body22.length, exExFlag)
        Body22.setSpan(StyleSpan(Typeface.BOLD), start, Body22.length, exExFlag)
        Body22.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body22.length, exExFlag)

        val Comment23 = SpannableString(" \nஆதி ப்ரும்மாவிலிருந்து from 1st Brahma’s life")
        Comment23.setSpan(AbsoluteSizeSpan(13, true), start, Comment23.length, exExFlag)
        Comment23.setSpan(StyleSpan(Typeface.ITALIC), start, Comment23.length, exExFlag)
        Comment23.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment23.length, exExFlag)

        val Body23 = SpannableString("\nத்விதீயே பரார்த்தே")
        Body23.setSpan(AbsoluteSizeSpan(14, true), start, Body23.length, exExFlag)
        Body23.setSpan(StyleSpan(Typeface.BOLD), start, Body23.length, exExFlag)
        Body23.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body23.length, exExFlag)

        val Comment24 = SpannableString("\nBrahma’s 2nd Parardha. 1 Parardha = 50 Brahma years")
        Comment24.setSpan(AbsoluteSizeSpan(13, true), start, Comment24.length, exExFlag)
        Comment24.setSpan(StyleSpan(Typeface.ITALIC), start, Comment24.length, exExFlag)
        Comment24.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment24.length, exExFlag)

        val Body24 = SpannableString("\nஸ்வேத வராஹ கல்பே")
        Body24.setSpan(AbsoluteSizeSpan(14, true), start, Body24.length, exExFlag)
        Body24.setSpan(StyleSpan(Typeface.BOLD), start, Body24.length, exExFlag)
        Body24.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body24.length, exExFlag)

        val Comment25 = SpannableString("\nfirst of the thirty Kalpas- Matsya Purana\n")
        Comment25.setSpan(AbsoluteSizeSpan(13, true), start, Comment25.length, exExFlag)
        Comment25.setSpan(StyleSpan(Typeface.ITALIC), start, Comment25.length, exExFlag)
        Comment25.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment25.length, exExFlag)

        val Body25 = SpannableString("\nவைவஸ்வத மன்வந்தரே")
        Body25.setSpan(AbsoluteSizeSpan(14, true), start, Body25.length, exExFlag)
        Body25.setSpan(StyleSpan(Typeface.BOLD), start, Body25.length, exExFlag)
        Body25.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body25.length, exExFlag)

        val Comment26 = SpannableString("\n14 manvantras = 1 Kalpa, now 7th - Vaivasvata")
        Comment26.setSpan(AbsoluteSizeSpan(13, true), start, Comment26.length, exExFlag)
        Comment26.setSpan(StyleSpan(Typeface.ITALIC), start, Comment26.length, exExFlag)
        Comment26.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment26.length, exExFlag)

        val Body26 = SpannableString("\nஅஷ்டா விம்சதிதமே")
        Body26.setSpan(AbsoluteSizeSpan(14, true), start, Body26.length, exExFlag)
        Body26.setSpan(StyleSpan(Typeface.BOLD), start, Body26.length, exExFlag)
        Body26.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body26.length, exExFlag)

        val Comment27 = SpannableString("\n 18,000 Kalpas completed")
        Comment27.setSpan(AbsoluteSizeSpan(13, true), start, Comment27.length, exExFlag)
        Comment27.setSpan(StyleSpan(Typeface.ITALIC), start, Comment27.length, exExFlag)
        Comment27.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment27.length, exExFlag)

        val Body27 = SpannableString("\nகலியுகே ப்ரதமேபாதே")
        Body27.setSpan(AbsoluteSizeSpan(14, true), start, Body27.length, exExFlag)
        Body27.setSpan(StyleSpan(Typeface.BOLD), start, Body27.length, exExFlag)
        Body27.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body27.length, exExFlag)

        val Comment28 = SpannableString("\nfirst quarter of the Kaliyuga")
        Comment28.setSpan(AbsoluteSizeSpan(13, true), start, Comment28.length, exExFlag)
        Comment28.setSpan(StyleSpan(Typeface.ITALIC), start, Comment28.length, exExFlag)
        Comment28.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment28.length, exExFlag)

        val Body28 =
            SpannableString("\nஜம்பூத்வீபே பாரதவர்ஷே பரதகண்டே மேரோ: தக்ஷிணேபார்ச்வே சகாப்தே அஸ்மின் வர்த்தமானே")
        Body28.setSpan(AbsoluteSizeSpan(14, true), start, Body28.length, exExFlag)
        Body28.setSpan(StyleSpan(Typeface.BOLD), start, Body28.length, exExFlag)
        Body28.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body28.length, exExFlag)

        val Comment29 = SpannableString("\ngeographical area of our motherland")
        Comment29.setSpan(AbsoluteSizeSpan(13, true), start, Comment29.length, exExFlag)
        Comment29.setSpan(StyleSpan(Typeface.ITALIC), start, Comment29.length, exExFlag)
        Comment29.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment29.length, exExFlag)

        val Body29AA =
            SpannableString("\nவ்யவஹாரிகே ப்ரபவாதீநாம் ஷஷ்ட்யா: ஸம்வத்ஸராணாம் மத்யே ஸ்ரீtamilYear நாம ஸம்வத்ஸரே")
        val regexReplace6 = """(tamilYear)""".toRegex()
        val Body29 = SpannableString(Body29AA.replace(regexReplace6, Varusham))
        Body29.setSpan(AbsoluteSizeSpan(14, true), start, Body29.length, exExFlag)
        Body29.setSpan(StyleSpan(Typeface.BOLD), start, Body29.length, exExFlag)
        Body29.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body29.length, exExFlag)

        val Comment30 = SpannableString("\nspecifies the year")
        Comment30.setSpan(AbsoluteSizeSpan(13, true), start, Comment30.length, exExFlag)
        Comment30.setSpan(StyleSpan(Typeface.ITALIC), start, Comment30.length, exExFlag)
        Comment30.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment30.length, exExFlag)

        val Body30AA = SpannableString("\nsunPosition")
        val regexReplace7 = """(sunPosition)""".toRegex()
        val Body30 = SpannableString(Body30AA.replace(regexReplace7, ayyanamm))
        Body30.setSpan(AbsoluteSizeSpan(14, true), start, Body30.length, exExFlag)
        Body30.setSpan(StyleSpan(Typeface.BOLD), start, Body30.length, exExFlag)
        Body30.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body30.length, exExFlag)

        val Comment31 =
            SpannableString("\nUttarayana, roughly January to June and Dakshinayana,[roughly July to December")
        Comment31.setSpan(AbsoluteSizeSpan(13, true), start, Comment31.length, exExFlag)
        Comment31.setSpan(StyleSpan(Typeface.ITALIC), start, Comment31.length, exExFlag)
        Comment31.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment31.length, exExFlag)

        val Body31AA = SpannableString("\nseason ருதௌ")
        val regexReplace8 = """(season)""".toRegex()
        val Body31 = SpannableString(Body31AA.replace(regexReplace8, kalam))
        Body31.setSpan(AbsoluteSizeSpan(14, true), start, Body31.length, exExFlag)
        Body31.setSpan(StyleSpan(Typeface.BOLD), start, Body31.length, exExFlag)
        Body31.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body31.length, exExFlag)

        val Comment32 = SpannableString("\nseason of the year, Vasanta/ Greeshma/ Varsha/ Sharat/ Hemanta/ Shishira")
        Comment32.setSpan(AbsoluteSizeSpan(13, true), start, Comment32.length, exExFlag)
        Comment32.setSpan(StyleSpan(Typeface.ITALIC), start, Comment32.length, exExFlag)
        Comment32.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment32.length, exExFlag)

        val Body32AA = SpannableString("\nsunRasi மாஸே")
        val regexReplace9 = """(sunRasi)""".toRegex()
        val Body32 = SpannableString(Body32AA.replace(regexReplace9, rasee))
        Body32.setSpan(AbsoluteSizeSpan(14, true), start, Body32.length, exExFlag)
        Body32.setSpan(StyleSpan(Typeface.BOLD), start, Body32.length, exExFlag)
        Body32.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body32.length, exExFlag)

        val Comment33 = SpannableString(
            "\n12 months -Mesha, Vrushabha, Mithuna, Kataka, Simha, Kanya, Tula, " +
                    "Vrichika, Dhanur, Makara, Kumbha, and Meena)"
        )
        Comment33.setSpan(AbsoluteSizeSpan(13, true), start, Comment33.length, exExFlag)
        Comment33.setSpan(StyleSpan(Typeface.ITALIC), start, Comment33.length, exExFlag)
        Comment33.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment33.length, exExFlag)

        val Body33AA = SpannableString("\nmoonPosition பக்ஷே")
        val regexReplace10 = """(moonPosition)""".toRegex()
        val Body33 = SpannableString(Body33AA.replace(regexReplace10, baksham))
        Body33.setSpan(AbsoluteSizeSpan(14, true), start, Body33.length, exExFlag)
        Body33.setSpan(StyleSpan(Typeface.BOLD), start, Body33.length, exExFlag)
        Body33.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body33.length, exExFlag)

        val Comment34 =
            SpannableString("\nShukla Paksham after amavasya to pournami  Krishna Paksham after pournami to amavasya")
        Comment34.setSpan(AbsoluteSizeSpan(13, true), start, Comment34.length, exExFlag)
        Comment34.setSpan(StyleSpan(Typeface.ITALIC), start, Comment34.length, exExFlag)
        Comment34.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment34.length, exExFlag)

        val Body34AA = SpannableString("\nThithiயாம் புண்யதிதௌ")
        val regexReplace11 = """(Thithi)""".toRegex()
        val Body34 = SpannableString(Body34AA.replace(regexReplace11, todThithi))
        Body34.setSpan(AbsoluteSizeSpan(14, true), start, Body34.length, exExFlag)
        Body34.setSpan(StyleSpan(Typeface.BOLD), start, Body34.length, exExFlag)
        Body34.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body34.length, exExFlag)

        val Comment35 = SpannableString("\n15 tithis and repeats")
        Comment35.setSpan(AbsoluteSizeSpan(13, true), start, Comment35.length, exExFlag)
        Comment35.setSpan(StyleSpan(Typeface.ITALIC), start, Comment35.length, exExFlag)
        Comment35.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment35.length, exExFlag)

        val Body35AA = SpannableString("\nweekDay வாஸாயுக்தாயாம்")
        val regexReplace12 = """(weekDay)""".toRegex()
        val Body35 = SpannableString(Body35AA.replace(regexReplace12, kizhamai))
        Body35.setSpan(AbsoluteSizeSpan(14, true), start, Body35.length, exExFlag)
        Body35.setSpan(StyleSpan(Typeface.BOLD), start, Body35.length, exExFlag)
        Body35.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body35.length, exExFlag)

        val Comment36 = SpannableString(
            "\nSunday-பாநு, Monday-இந்து, Tuesday-பௌம, Wednesday-ஸௌம்ய, " +
                    "Thursday-குரு, Friday-ப்ருகு, Saturday-ஸ்திர"
        )
        Comment36.setSpan(AbsoluteSizeSpan(13, true), start, Comment36.length, exExFlag)
        Comment36.setSpan(StyleSpan(Typeface.ITALIC), start, Comment36.length, exExFlag)
        Comment36.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment36.length, exExFlag)

        val Body36AA = SpannableString("\nnatchatram நக்ஷ்த்ரயுக்தாயாம்")
        val regexReplace13 = """(natchatram)""".toRegex()
        val Body36 = SpannableString(Body36AA.replace(regexReplace13, nachathirm))
        Body36.setSpan(AbsoluteSizeSpan(14, true), start, Body36.length, exExFlag)
        Body36.setSpan(StyleSpan(Typeface.BOLD), start, Body36.length, exExFlag)
        Body36.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body36.length, exExFlag)

        val Comment37 = SpannableString("\n27 nakshatras")
        Comment37.setSpan(AbsoluteSizeSpan(13, true), start, Comment37.length, exExFlag)
        Comment37.setSpan(StyleSpan(Typeface.ITALIC), start, Comment37.length, exExFlag)
        Comment37.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment37.length, exExFlag)

        val Body37AAA =
            SpannableString("\nYogam நாமயோக Karana கரண ஏவங்குண விசேஷேண விசிஷ்டாயாம் அஸ்யாம் Thithiயாம் புண்யதிதௌ")
        val regexReplace14 = """(Yogam)""".toRegex()
        val Body37AA = SpannableString(Body37AAA.replace(regexReplace14, yog))
        val regexReplace15 = """(Karana)""".toRegex()
        val Body37A = SpannableString(Body37AA.replace(regexReplace15, kar))
        val regexReplace16 = """(Thithi)""".toRegex()
        val Body37 = SpannableString(Body37A.replace(regexReplace16, todThithi))
        Body37.setSpan(AbsoluteSizeSpan(14, true), start, Body37.length, exExFlag)
        Body37.setSpan(StyleSpan(Typeface.BOLD), start, Body37.length, exExFlag)
        Body37.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body37.length, exExFlag)

        val Comment38A = SpannableString("\nபூணூலை ")
        Comment38A.setSpan(AbsoluteSizeSpan(13, true), start, Comment38A.length, exExFlag)
        Comment38A.setSpan(StyleSpan(Typeface.ITALIC), start, Comment38A.length, exExFlag)
        Comment38A.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment38A.length, exExFlag)

        val RedComment1 = SpannableString("அபஸவ்யம்")
        RedComment1.setSpan(AbsoluteSizeSpan(13, true), start, RedComment1.length, exExFlag)
        RedComment1.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, RedComment1.length, exExFlag)
        RedComment1.setSpan(ForegroundColorSpan(Color.RED), start, RedComment1.length, exExFlag)

        val Comment38B = SpannableString(" செய்து கொண்டு தெற்குமுகமாக [முகம் மட்டுமாவது] இருந்து கூறவும்)")
        Comment38B.setSpan(AbsoluteSizeSpan(13, true), start, Comment38B.length, exExFlag)
        Comment38B.setSpan(StyleSpan(Typeface.ITALIC), start, Comment38B.length, exExFlag)
        Comment38B.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment38B.length, exExFlag)

        val Body38A = SpannableString("\n yourGothram கோத்ராணாம் அஸ்மத் ")
        val regexReplace17 = """(yourGothram)""".toRegex()
        val Body38 = SpannableString(Body38A.replace(regexReplace17, urGothram))
        Body38.setSpan(AbsoluteSizeSpan(14, true), start, Body38.length, exExFlag)
        Body38.setSpan(StyleSpan(Typeface.BOLD), start, Body38.length, exExFlag)
        Body38.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body38.length, exExFlag)

        val MBody38A = SpannableString("\n\n motherSideGothram கோத்ராணாம் அஸ்மத் ")
        val MregexReplace17 = """(motherSideGothram)""".toRegex()
        val MBody38 = SpannableString(MBody38A.replace(MregexReplace17, MGothram))
        MBody38.setSpan(AbsoluteSizeSpan(14, true), start, MBody38.length, exExFlag)
        MBody38.setSpan(StyleSpan(Typeface.BOLD), start, MBody38.length, exExFlag)
        MBody38.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody38.length, exExFlag)

        val Sabathneek1 = SpannableString("ஸபத்நீகானாம் ")
        Sabathneek1.setSpan(AbsoluteSizeSpan(14, true), start, Sabathneek1.length, exExFlag)
        Sabathneek1.setSpan(StyleSpan(Typeface.BOLD), start, Sabathneek1.length, exExFlag)
        Sabathneek1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Sabathneek1.length, exExFlag)

        val MSabathneek1 = SpannableString("ஸபத்நீக ")
        MSabathneek1.setSpan(AbsoluteSizeSpan(14, true), start, MSabathneek1.length, exExFlag)
        MSabathneek1.setSpan(StyleSpan(Typeface.BOLD), start, MSabathneek1.length, exExFlag)
        MSabathneek1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MSabathneek1.length, exExFlag)

        val Body39 = SpannableString("பித்ரு ")
        Body39.setSpan(AbsoluteSizeSpan(14, true), start, Body39.length, exExFlag)
        Body39.setSpan(StyleSpan(Typeface.BOLD), start, Body39.length, exExFlag)
        Body39.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body39.length, exExFlag)

        val Body39A = SpannableString("ப்ரபிதாமஹ வ்ருத்தப்ரபிதாமஹாநாம் ")
        Body39A.setSpan(AbsoluteSizeSpan(14, true), start, Body39A.length, exExFlag)
        Body39A.setSpan(StyleSpan(Typeface.BOLD), start, Body39A.length, exExFlag)
        Body39A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body39A.length, exExFlag)

        val Body39B = SpannableString("பிதாமஹ ப்ரபிதாமஹாநாம் ")
        Body39B.setSpan(AbsoluteSizeSpan(14, true), start, Body39B.length, exExFlag)
        Body39B.setSpan(StyleSpan(Typeface.BOLD), start, Body39B.length, exExFlag)
        Body39B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body39B.length, exExFlag)

        val Body40A = SpannableString("yourFatherName, ")
        val regexReplace18 = """(yourFatherName)""".toRegex()
        val Body40 = SpannableString(Body40A.replace(regexReplace18, yrFNamee))
        Body40.setSpan(AbsoluteSizeSpan(14, true), start, Body40.length, exExFlag)
        Body40.setSpan(StyleSpan(Typeface.BOLD), start, Body40.length, exExFlag)
        Body40.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body40.length, exExFlag)


        val Body41AA = SpannableString("yourGrandFatherName, yourGreatGrandFatherName ")
        val regexReplace19 = """(yourGrandFatherName)""".toRegex()
        val Body41A = SpannableString(Body41AA.replace(regexReplace19, yrGFNamee))
        val regexReplace20 = """(yourGreatGrandFatherName)""".toRegex()
        val Body41 = SpannableString(Body41A.replace(regexReplace20, yrGGFNamee))
        Body41.setSpan(AbsoluteSizeSpan(14, true), start, Body41.length, exExFlag)
        Body41.setSpan(StyleSpan(Typeface.BOLD), start, Body41.length, exExFlag)
        Body41.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body41.length, exExFlag)

        val Body41BBB = SpannableString("yourGreatGrandFatherName, yourGreatGreatGrandFatherName ")
        val regexReplace21 = """(yourGreatGrandFatherName)""".toRegex()
        val Body41BB = SpannableString(Body41BBB.replace(regexReplace21, yrGGFNamee))
        val regexReplace22 = """(yourGreatGreatGrandFatherName)""".toRegex()
        val Body41B = SpannableString(Body41BB.replace(regexReplace22, yrGGGFNamee))
        Body41B.setSpan(AbsoluteSizeSpan(14, true), start, Body41B.length, exExFlag)
        Body41B.setSpan(StyleSpan(Typeface.BOLD), start, Body41B.length, exExFlag)
        Body41B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body41B.length, exExFlag)

        val MBody41BBB = SpannableString(
            "மாதாமஹ, ப்ரமாதாமஹ, வ்ருத்தப்ரமாதாமஹாநாம் motherFather, motherGrandFather, " +
                    "motherGreatGrandFather சர்மணாம் வஸூருத்ர ஆதித்ய ஸ்வரூபாணாம் உபயவம்ச பித்ருணாம் அக்ஷ்ய த்ருப்த்யர்த்தம் " +
                    "Thithi புண்யகாலே அஸ்மத்"
        )
        val MregexReplace21 = """(motherFather)""".toRegex()
        val MBody41BB = SpannableString(MBody41BBB.replace(MregexReplace21, MFNamee))
        val MregexReplace22 = """(motherGrandFather)""".toRegex()
        val MBody41BA = SpannableString(MBody41BB.replace(MregexReplace22, MGFNamee))
        val MregexReplace22A = """(motherGreatGrandFather)""".toRegex()
        val MBody41BAB = SpannableString(MBody41BA.replace(MregexReplace22A, MGGFNamee))
        val MregexReplace22AB = """(Thithi)""".toRegex()
        val MBody41B = SpannableString(MBody41BAB.replace(MregexReplace22AB, todThithi))
        MBody41B.setSpan(AbsoluteSizeSpan(14, true), start, MBody41B.length, exExFlag)
        MBody41B.setSpan(StyleSpan(Typeface.BOLD), start, MBody41B.length, exExFlag)
        MBody41B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody41B.length, exExFlag)

        val Body42 = SpannableString("சர்மணாம் வஸூருத்ர ஆதித்யஸ்வரூபாணாம் அக்ஷ்ய த்ருப்த்யர்த்தம்")
        Body42.setSpan(AbsoluteSizeSpan(14, true), start, Body42.length, exExFlag)
        Body42.setSpan(StyleSpan(Typeface.BOLD), start, Body42.length, exExFlag)
        Body42.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body42.length, exExFlag)

        val Body43A = SpannableString(" Thithi புண்யகாலே அஸ்மத்")
        val regexReplace23 = """(Thithi)""".toRegex()
        val Body43 = SpannableString(Body43A.replace(regexReplace23, todThithi))
        Body43.setSpan(AbsoluteSizeSpan(14, true), start, Body43.length, exExFlag)
        Body43.setSpan(StyleSpan(Typeface.BOLD), start, Body43.length, exExFlag)
        Body43.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body43.length, exExFlag)

        val Body44 = SpannableString(" வர்கைக ")
        Body44.setSpan(AbsoluteSizeSpan(14, true), start, Body44.length, exExFlag)
        Body44.setSpan(StyleSpan(Typeface.BOLD), start, Body44.length, exExFlag)
        Body44.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body44.length, exExFlag)

        val MBody44 = SpannableString(" வர்கத்வய ")
        MBody44.setSpan(AbsoluteSizeSpan(14, true), start, MBody44.length, exExFlag)
        MBody44.setSpan(StyleSpan(Typeface.BOLD), start, MBody44.length, exExFlag)
        MBody44.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody44.length, exExFlag)

        val Body45 = SpannableString("பித்ரூனு உத்திச்ய தர்சச்ராத்தம் திலதர்ப்பண ரூபணே அத்ய கர்ஷ்யே ")
        Body45.setSpan(AbsoluteSizeSpan(14, true), start, Body45.length, exExFlag)
        Body45.setSpan(StyleSpan(Typeface.BOLD), start, Body45.length, exExFlag)
        Body45.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body45.length, exExFlag)

        val Comment39 = SpannableString("\n கையில் உள்ள தர்பங்களை போட்டுவிட்டு கிழக்கு முகமாக திருப்பி பூணுலை ")
        Comment39.setSpan(AbsoluteSizeSpan(13, true), start, Comment39.length, exExFlag)
        Comment39.setSpan(StyleSpan(Typeface.ITALIC), start, Comment39.length, exExFlag)
        Comment39.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment39.length, exExFlag)

        val GreenComment1 = SpannableString("ஸவ்யம்")
        GreenComment1.setSpan(AbsoluteSizeSpan(14, true), start, GreenComment1.length, exExFlag)
        GreenComment1.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, GreenComment1.length, exExFlag)
        GreenComment1.setSpan(ForegroundColorSpan(Color.GREEN), start, GreenComment1.length, exExFlag)

        val Comment40 = SpannableString(
            " செய்து கொண்டு கையை ஜலத்தால் அலம்பவும். தனக்கு எதிரில் ஒரு தாம்பாளத்தில் " +
                    "கொஞ்சம் கட்டை தர்பங்களை கிழக்கு மேற்காக பரப்பி அதன்மேல் தெற்கு நுனியாக"
        )
        Comment40.setSpan(AbsoluteSizeSpan(13, true), start, Comment40.length, exExFlag)
        Comment40.setSpan(StyleSpan(Typeface.ITALIC), start, Comment40.length, exExFlag)
        Comment40.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment40.length, exExFlag)

        val MComment40 = SpannableString(" இரண்டு ")
        MComment40.setSpan(AbsoluteSizeSpan(13, true), start, MComment40.length, exExFlag)
        MComment40.setSpan(StyleSpan(Typeface.ITALIC), start, MComment40.length, exExFlag)
        MComment40.setSpan(ForegroundColorSpan(Color.DKGRAY), start, MComment40.length, exExFlag)

        val Comment41 = SpannableString(" கூர்ச்ச(ம்)ங்களை வைத்து அதன் மேல் கட்டை தர்பங்கள் கொஞ்சம் போட்டு பூணூலை ")
        Comment41.setSpan(AbsoluteSizeSpan(13, true), start, Comment41.length, exExFlag)
        Comment41.setSpan(StyleSpan(Typeface.ITALIC), start, Comment41.length, exExFlag)
        Comment41.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment41.length, exExFlag)

        val RedComment2 = SpannableString("அபஸவ்யம்")
        RedComment2.setSpan(AbsoluteSizeSpan(13, true), start, RedComment2.length, exExFlag)
        RedComment2.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, RedComment2.length, exExFlag)
        RedComment2.setSpan(ForegroundColorSpan(Color.RED), start, RedComment2.length, exExFlag)

        val Comment41A = SpannableString(" செய்து கொண்டு")
        Comment41A.setSpan(AbsoluteSizeSpan(13, true), start, Comment41A.length, exExFlag)
        Comment41A.setSpan(StyleSpan(Typeface.ITALIC), start, Comment41A.length, exExFlag)
        Comment41A.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment41A.length, exExFlag)

        val Comment41B = SpannableString(" எள்ளை")
        Comment41B.setSpan(AbsoluteSizeSpan(13, true), start, Comment41B.length, exExFlag)
        Comment41B.setSpan(StyleSpan(Typeface.ITALIC), start, Comment41B.length, exExFlag)
        Comment41B.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment41B.length, exExFlag)

        val Comment41C = SpannableString(" எள்ளும், சிறிது அரிசியையும்")
        Comment41C.setSpan(AbsoluteSizeSpan(13, true), start, Comment41C.length, exExFlag)
        Comment41C.setSpan(StyleSpan(Typeface.ITALIC), start, Comment41C.length, exExFlag)
        Comment41C.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment41C.length, exExFlag)

        val Comment41D = SpannableString(" எடுத்துக் கொண்டு ஆவாஹநாதி தர்ப்பணம் செய்யவும்\n")
        Comment41D.setSpan(AbsoluteSizeSpan(13, true), start, Comment41D.length, exExFlag)
        Comment41D.setSpan(StyleSpan(Typeface.ITALIC), start, Comment41D.length, exExFlag)
        Comment41D.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment41D.length, exExFlag)

        val Heading3 = SpannableString("\nஆவாஹனம்-ஆஸனம்\n")
        Heading3.setSpan(AbsoluteSizeSpan(16, true), start, Heading3.length, exExFlag)
        Heading3.setSpan(StyleSpan(Typeface.BOLD), start, Heading3.length, exExFlag)
        Heading3.setSpan(UnderlineSpan(), start, Heading3.length, exExFlag)
        Heading3.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, Heading3.length, exExFlag)

        val Comment42 = SpannableString("பூணல்  ")
        Comment42.setSpan(AbsoluteSizeSpan(13, true), start, Comment42.length, exExFlag)
        Comment42.setSpan(StyleSpan(Typeface.ITALIC), start, Comment42.length, exExFlag)
        Comment42.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment42.length, exExFlag)

        val RedComment3 = SpannableString("அபஸவ்யம்")
        RedComment3.setSpan(AbsoluteSizeSpan(13, true), start, RedComment3.length, exExFlag)
        RedComment3.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, RedComment3.length, exExFlag)
        RedComment3.setSpan(ForegroundColorSpan(Color.RED), start, RedComment3.length, exExFlag)

        val Comment42A = SpannableString("\n(மந்திரம்: ")
        Comment42A.setSpan(AbsoluteSizeSpan(13, true), start, Comment42A.length, exExFlag)
        Comment42A.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, Comment42A.length, exExFlag)
        Comment42A.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, Comment42A.length, exExFlag)

        val MComment42A = SpannableString("மேலண்டை ")
        MComment42A.setSpan(AbsoluteSizeSpan(13, true), start, MComment42A.length, exExFlag)
        MComment42A.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, MComment42A.length, exExFlag)
        MComment42A.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, MComment42A.length, exExFlag)

        val Comment42B = SpannableString("கூர்ச்சம்: பிதாவர்கம்)")
        Comment42B.setSpan(AbsoluteSizeSpan(13, true), start, Comment42B.length, exExFlag)
        Comment42B.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, Comment42B.length, exExFlag)
        Comment42B.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, Comment42B.length, exExFlag)

        val Body46A = SpannableString(
            "\nஓம் உசந்தஸ்த்வா நிதீமஹி உசந்த: ஸமீதீமஹி உசந்நு உசத: ஆவஹ பித்ருன் ஹவிஷே " +
                    "அத்தவே yourGothram கோத்ரான் அஸ்மத்"
        )
        val regexReplace24 = """(yourGothram)""".toRegex()
        val Body46 = SpannableString(Body46A.replace(regexReplace24, urGothram))
        Body46.setSpan(AbsoluteSizeSpan(14, true), start, Body46.length, exExFlag)
        Body46.setSpan(StyleSpan(Typeface.BOLD), start, Body46.length, exExFlag)
        Body46.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body46.length, exExFlag)

        val MBody46A = SpannableString(
            "\nஓம் உசந்தஸ்த்வா நிதீமஹி உசந்த: ஸமீதீமஹி உசந்நு உசத: ஆவஹ பித்ருன்னு ஹவிஷே " +
                    "அத்தவே motherSideGothram கோத்ரான் அஸ்மத்"
        )
        val MregexReplace24 = """(motherSideGothram)""".toRegex()
        val MBody46 = SpannableString(MBody46A.replace(MregexReplace24, MGothram))
        MBody46.setSpan(AbsoluteSizeSpan(14, true), start, MBody46.length, exExFlag)
        MBody46.setSpan(StyleSpan(Typeface.BOLD), start, MBody46.length, exExFlag)
        MBody46.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody46.length, exExFlag)

        val Sabathneek2 = SpannableString(" ஸபத்நீகானாம் ")
        Sabathneek2.setSpan(AbsoluteSizeSpan(14, true), start, Sabathneek2.length, exExFlag)
        Sabathneek2.setSpan(StyleSpan(Typeface.BOLD), start, Sabathneek2.length, exExFlag)
        Sabathneek2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Sabathneek2.length, exExFlag)

        val MSabathneek2 = SpannableString(" ஸபத்நீகானாம் ")
        MSabathneek2.setSpan(AbsoluteSizeSpan(14, true), start, MSabathneek2.length, exExFlag)
        MSabathneek2.setSpan(StyleSpan(Typeface.BOLD), start, MSabathneek2.length, exExFlag)
        MSabathneek2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MSabathneek2.length, exExFlag)

        val Body47 = SpannableString("பித்ரு ")
        Body47.setSpan(AbsoluteSizeSpan(14, true), start, Body47.length, exExFlag)
        Body47.setSpan(StyleSpan(Typeface.BOLD), start, Body47.length, exExFlag)
        Body47.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body47.length, exExFlag)

        val Body48A = SpannableString("ப்ரபிதாமஹ வ்ருத்தப்ரபிதாமஹாநாம் ")
        Body48A.setSpan(AbsoluteSizeSpan(14, true), start, Body48A.length, exExFlag)
        Body48A.setSpan(StyleSpan(Typeface.BOLD), start, Body48A.length, exExFlag)
        Body48A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body48A.length, exExFlag)

        val Body48B = SpannableString("பிதாமஹ ப்ரபிதாமஹாநாம் ")
        Body48B.setSpan(AbsoluteSizeSpan(14, true), start, Body48B.length, exExFlag)
        Body48B.setSpan(StyleSpan(Typeface.BOLD), start, Body48B.length, exExFlag)
        Body48B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body48B.length, exExFlag)

        val Body49A = SpannableString("yourFatherName, ")
        val regexReplace25 = """(yourFatherName)""".toRegex()
        val Body49 = SpannableString(Body49A.replace(regexReplace25, yrFNamee))
        Body49.setSpan(AbsoluteSizeSpan(14, true), start, Body49.length, exExFlag)
        Body49.setSpan(StyleSpan(Typeface.BOLD), start, Body49.length, exExFlag)
        Body49.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body49.length, exExFlag)

        val Body50AA = SpannableString("yourGrandFatherName, yourGreatGrandFatherName ")
        val regexReplace26 = """(yourGrandFatherName)""".toRegex()
        val Body50A = SpannableString(Body50AA.replace(regexReplace26, yrGFNamee))
        val regexReplace27 = """(yourGreatGrandFatherName)""".toRegex()
        val Body50 = SpannableString(Body50A.replace(regexReplace27, yrGGFNamee))
        Body50.setSpan(AbsoluteSizeSpan(14, true), start, Body50.length, exExFlag)
        Body50.setSpan(StyleSpan(Typeface.BOLD), start, Body50.length, exExFlag)
        Body50.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body50.length, exExFlag)

        val Body51BBB = SpannableString("yourGreatGrandFatherName, yourGreatGreatGrandFatherName ")
        val regexReplace28 = """(yourGreatGrandFatherName)""".toRegex()
        val Body51BB = SpannableString(Body51BBB.replace(regexReplace28, yrGGFNamee))
        val regexReplace29 = """(yourGreatGreatGrandFatherName)""".toRegex()
        val Body51B = SpannableString(Body51BB.replace(regexReplace29, yrGGGFNamee))
        Body51B.setSpan(AbsoluteSizeSpan(14, true), start, Body51B.length, exExFlag)
        Body51B.setSpan(StyleSpan(Typeface.BOLD), start, Body51B.length, exExFlag)
        Body51B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body51B.length, exExFlag)

        val MBody51BBBB = SpannableString(
            "மாதாமஹ ப்ரமாதாமஹ வ்ருத்த ப்ரமாதாமஹான் motherFather, motherGrandFather, " +
                    "motherGreatGrandFather சர்மணாம் வஸூருத்ர ஆதித்ய ஸ்வரூபான் அஸ்மின்கூர்ச்சே ஆவாஹயாமி அவகீர்யா"
        )
        val MregexReplace28 = """(motherFather)""".toRegex()
        val MBody51BBB = SpannableString(MBody51BBBB.replace(MregexReplace28, MFNamee))
        val MregexReplace29 = """(motherGrandFather)""".toRegex()
        val MBody51BB = SpannableString(MBody51BBB.replace(MregexReplace29, MGFNamee))
        val MregexReplace29A = """(motherGreatGrandFather)""".toRegex()
        val MBody51B = SpannableString(MBody51BB.replace(MregexReplace29A, MGGFNamee))
        MBody51B.setSpan(AbsoluteSizeSpan(14, true), start, MBody51B.length, exExFlag)
        MBody51B.setSpan(StyleSpan(Typeface.BOLD), start, MBody51B.length, exExFlag)
        MBody51B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody51B.length, exExFlag)

        val MBody51CCCC = SpannableString(
            "மாதாமஹ ப்ரமாதாமஹ வ்ருத்த ப்ரமாதாமஹாணாம் motherFather , motherGrandFather ," +
                    " motherGreatGrandFather சர்மணாம் வஸூருத்ர ஆதித்ய ஸ்வரூபாணாம் அஸ்மின்கூர்ச்சே இதமாஸனம்"
        )
        val MCregexReplace28 = """(motherFather)""".toRegex()
        val MBody51CCC = SpannableString(MBody51CCCC.replace(MCregexReplace28, MFNamee))
        val MCregexReplace29 = """(motherGrandFather)""".toRegex()
        val MBody51CC = SpannableString(MBody51CCC.replace(MCregexReplace29, MGFNamee))
        val MCregexReplace29A = """(motherGreatGrandFather)""".toRegex()
        val MBody51C = SpannableString(MBody51CC.replace(MCregexReplace29A, MGGFNamee))
        MBody51C.setSpan(AbsoluteSizeSpan(14, true), start, MBody51C.length, exExFlag)
        MBody51C.setSpan(StyleSpan(Typeface.BOLD), start, MBody51C.length, exExFlag)
        MBody51C.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody51C.length, exExFlag)

        val Body52 = SpannableString("சர்மணாம்  வஸூருத்ர ஆதித்ய ஸ்வரூபான் அஸ்மின்கூர்ச்சே ஆவாஹயாமி\nஅவகீர்யா")
        Body52.setSpan(AbsoluteSizeSpan(14, true), start, Body52.length, exExFlag)
        Body52.setSpan(StyleSpan(Typeface.BOLD), start, Body52.length, exExFlag)
        Body52.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body52.length, exExFlag)

        val Comment43 = SpannableString("\nஎன்று எள்ளை")
        Comment43.setSpan(AbsoluteSizeSpan(13, true), start, Comment43.length, exExFlag)
        Comment43.setSpan(StyleSpan(Typeface.ITALIC), start, Comment43.length, exExFlag)
        Comment43.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment43.length, exExFlag)

        val Comment43x = SpannableString("\nஎன்று எள்ளை")
        Comment43x.setSpan(AbsoluteSizeSpan(13, true), start, Comment43x.length, exExFlag)
        Comment43x.setSpan(StyleSpan(Typeface.ITALIC), start, Comment43x.length, exExFlag)
        Comment43x.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment43x.length, exExFlag)

        val Comment44 = SpannableString("\nஎன்று எள்ளும், சிறிது அரிசியையும்")
        Comment44.setSpan(AbsoluteSizeSpan(13, true), start, Comment44.length, exExFlag)
        Comment44.setSpan(StyleSpan(Typeface.ITALIC), start, Comment44.length, exExFlag)
        Comment44.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment44.length, exExFlag)

        val Comment44x = SpannableString("\nஎன்று எள்ளும், சிறிது அரிசியையும்")
        Comment44x.setSpan(AbsoluteSizeSpan(13, true), start, Comment44x.length, exExFlag)
        Comment44x.setSpan(StyleSpan(Typeface.ITALIC), start, Comment44x.length, exExFlag)
        Comment44x.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment44x.length, exExFlag)

        val Comment45 = SpannableString(" போடவும்")
        Comment45.setSpan(AbsoluteSizeSpan(13, true), start, Comment45.length, exExFlag)
        Comment45.setSpan(StyleSpan(Typeface.ITALIC), start, Comment45.length, exExFlag)
        Comment45.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment45.length, exExFlag)

        val Comment45x = SpannableString(" போடவும்")
        Comment45x.setSpan(AbsoluteSizeSpan(13, true), start, Comment45x.length, exExFlag)
        Comment45x.setSpan(StyleSpan(Typeface.ITALIC), start, Comment45x.length, exExFlag)
        Comment45x.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment45x.length, exExFlag)

        val Heading4 = SpannableString("\nஆஸனமந்திரம்\n")
        Heading4.setSpan(AbsoluteSizeSpan(16, true), start, Heading4.length, exExFlag)
        Heading4.setSpan(StyleSpan(Typeface.BOLD), start, Heading4.length, exExFlag)
        Heading4.setSpan(UnderlineSpan(), start, Heading4.length, exExFlag)
        Heading4.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, Heading4.length, exExFlag)

        val MComment43 = SpannableString("\nஎன்று எள்ளை")
        MComment43.setSpan(AbsoluteSizeSpan(13, true), start, MComment43.length, exExFlag)
        MComment43.setSpan(StyleSpan(Typeface.ITALIC), start, MComment43.length, exExFlag)
        MComment43.setSpan(ForegroundColorSpan(Color.DKGRAY), start, MComment43.length, exExFlag)

        val MComment44 = SpannableString("\nஎள்ளும், சிறிது அரிசியையும்்")
        MComment44.setSpan(AbsoluteSizeSpan(13, true), start, MComment44.length, exExFlag)
        MComment44.setSpan(StyleSpan(Typeface.ITALIC), start, MComment44.length, exExFlag)
        MComment44.setSpan(ForegroundColorSpan(Color.DKGRAY), start, MComment44.length, exExFlag)

        val MComment45 = SpannableString(" போடவும்)")
        MComment45.setSpan(AbsoluteSizeSpan(13, true), start, MComment45.length, exExFlag)
        MComment45.setSpan(StyleSpan(Typeface.ITALIC), start, MComment45.length, exExFlag)
        MComment45.setSpan(ForegroundColorSpan(Color.DKGRAY), start, MComment45.length, exExFlag)

        val MHeading4 = SpannableString("\nஆஸனமந்திரம்\n")
        MHeading4.setSpan(AbsoluteSizeSpan(16, true), start, MHeading4.length, exExFlag)
        MHeading4.setSpan(StyleSpan(Typeface.BOLD), start, MHeading4.length, exExFlag)
        MHeading4.setSpan(UnderlineSpan(), start, MHeading4.length, exExFlag)
        MHeading4.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, MHeading4.length, exExFlag)

        val Comment46 = SpannableString("\nமூன்று கட்டை தர்பங்களை எடுத்துக்கொண்டு")
        Comment46.setSpan(AbsoluteSizeSpan(13, true), start, Comment46.length, exExFlag)
        Comment46.setSpan(StyleSpan(Typeface.ITALIC), start, Comment46.length, exExFlag)
        Comment46.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment46.length, exExFlag)

        val MComment46 = SpannableString("\nமூன்று கட்டை தர்பங்களை எடுத்துக்கொண்டு")
        MComment46.setSpan(AbsoluteSizeSpan(13, true), start, MComment46.length, exExFlag)
        MComment46.setSpan(StyleSpan(Typeface.ITALIC), start, MComment46.length, exExFlag)
        MComment46.setSpan(ForegroundColorSpan(Color.DKGRAY), start, MComment46.length, exExFlag)

        val MComment46A = SpannableString("\nமூன்று கட்டை தர்பங்களை எடுத்துக்கொண்டு)")
        MComment46A.setSpan(AbsoluteSizeSpan(13, true), start, MComment46A.length, exExFlag)
        MComment46A.setSpan(StyleSpan(Typeface.ITALIC), start, MComment46A.length, exExFlag)
        MComment46A.setSpan(ForegroundColorSpan(Color.DKGRAY), start, MComment46A.length, exExFlag)

        val MComment46B = SpannableString("\nஎன்று கட்டை தர்பங்களை போடவும்")
        MComment46B.setSpan(AbsoluteSizeSpan(13, true), start, MComment46B.length, exExFlag)
        MComment46B.setSpan(StyleSpan(Typeface.ITALIC), start, MComment46B.length, exExFlag)
        MComment46B.setSpan(ForegroundColorSpan(Color.DKGRAY), start, MComment46B.length, exExFlag)

        val MComment46x = SpannableString("\nஎன்று கட்டை தர்பங்களை போடவும்)")
        MComment46x.setSpan(AbsoluteSizeSpan(13, true), start, MComment46x.length, exExFlag)
        MComment46x.setSpan(StyleSpan(Typeface.ITALIC), start, MComment46x.length, exExFlag)
        MComment46x.setSpan(ForegroundColorSpan(Color.DKGRAY), start, MComment46x.length, exExFlag)


        val Body53A = SpannableString(
            "\nஓம் ஆயந்துந: பிதர: ஸோம்யாஸ: அக்னிஷ்வாத்தா: பதிபி: தேவயாநை: " +
                    "\nஅஸ்மின்யக்ஞே ஸ்வதயாமதந்த: அதிப்ருவந்து தேவந்து அஸ்மான் yourGothram கோத்ராணாம் அஸ்மத்"
        )
        val regexReplace30 = """(yourGothram)""".toRegex()
        val Body53 = SpannableString(Body53A.replace(regexReplace30, urGothram))
        Body53.setSpan(AbsoluteSizeSpan(14, true), start, Body53.length, exExFlag)
        Body53.setSpan(StyleSpan(Typeface.BOLD), start, Body53.length, exExFlag)
        Body53.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body53.length, exExFlag)

        val Sabathneek3 = SpannableString("ஸபத்நீகானாம் ")
        Sabathneek3.setSpan(AbsoluteSizeSpan(14, true), start, Sabathneek3.length, exExFlag)
        Sabathneek3.setSpan(StyleSpan(Typeface.BOLD), start, Sabathneek3.length, exExFlag)
        Sabathneek3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Sabathneek3.length, exExFlag)

        val MBody53A = SpannableString(
            "\nஓம் ஆயந்துந: பிதர: ஸோம்யாஸ: அக்னிஷ்வாத்தா: பதிபி: தேவயாநை: " +
                    "\nஅஸ்மின்யக்ஞே ஸ்வதயாமதந்த: அதிப்ருவந்து தேவந்து அஸ்மான் motherSideGothram கோத்ராணாம் அஸ்மத்"
        )
        val MregexReplace30 = """(motherSideGothram)""".toRegex()
        val MBody53 = SpannableString(MBody53A.replace(MregexReplace30, MGothram))
        MBody53.setSpan(AbsoluteSizeSpan(14, true), start, MBody53.length, exExFlag)
        MBody53.setSpan(StyleSpan(Typeface.BOLD), start, MBody53.length, exExFlag)
        MBody53.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody53.length, exExFlag)

        val MSabathneek3 = SpannableString("ஸபத்நீக ")
        MSabathneek3.setSpan(AbsoluteSizeSpan(14, true), start, MSabathneek3.length, exExFlag)
        MSabathneek3.setSpan(StyleSpan(Typeface.BOLD), start, MSabathneek3.length, exExFlag)
        MSabathneek3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MSabathneek3.length, exExFlag)

        val Body54 = SpannableString("பித்ரு ")
        Body54.setSpan(AbsoluteSizeSpan(14, true), start, Body54.length, exExFlag)
        Body54.setSpan(StyleSpan(Typeface.BOLD), start, Body54.length, exExFlag)
        Body54.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body54.length, exExFlag)

        val Body55 = SpannableString("ப்ரபிதாமஹ வ்ருத்தப்ரபிதாமஹாநாம் ")
        Body55.setSpan(AbsoluteSizeSpan(14, true), start, Body55.length, exExFlag)
        Body55.setSpan(StyleSpan(Typeface.BOLD), start, Body55.length, exExFlag)
        Body55.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body55.length, exExFlag)

        val MBody55 = SpannableString("ப்ரபிதாமஹ வ்ருத்தப்ரபிதாமஹாநாம் ")
        MBody55.setSpan(AbsoluteSizeSpan(14, true), start, MBody55.length, exExFlag)
        MBody55.setSpan(StyleSpan(Typeface.BOLD), start, MBody55.length, exExFlag)
        MBody55.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody55.length, exExFlag)

        val Body56 = SpannableString("பிதாமஹ ப்ரபிதாமஹாநாம் ")
        Body56.setSpan(AbsoluteSizeSpan(14, true), start, Body56.length, exExFlag)
        Body56.setSpan(StyleSpan(Typeface.BOLD), start, Body56.length, exExFlag)
        Body56.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body56.length, exExFlag)

        val MBody56 = SpannableString("பிதாமஹ ப்ரபிதாமஹாநாம் ")
        MBody56.setSpan(AbsoluteSizeSpan(14, true), start, MBody56.length, exExFlag)
        MBody56.setSpan(StyleSpan(Typeface.BOLD), start, MBody56.length, exExFlag)
        MBody56.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody56.length, exExFlag)

        val Body57A = SpannableString("yourFatherName, ")
        val regexReplace31 = """(yourFatherName)""".toRegex()
        val Body57 = SpannableString(Body57A.replace(regexReplace31, yrFNamee))
        Body57.setSpan(AbsoluteSizeSpan(14, true), start, Body57.length, exExFlag)
        Body57.setSpan(StyleSpan(Typeface.BOLD), start, Body57.length, exExFlag)
        Body57.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body57.length, exExFlag)

        val MBody57A = SpannableString("yourFatherName, ")
        val regexReplaceM31 = """(yourFatherName)""".toRegex()
        val MBody57 = SpannableString(MBody57A.replace(regexReplaceM31, yrFNamee))
        MBody57.setSpan(AbsoluteSizeSpan(14, true), start, MBody57.length, exExFlag)
        MBody57.setSpan(StyleSpan(Typeface.BOLD), start, MBody57.length, exExFlag)
        MBody57.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody57.length, exExFlag)

        val Body58AA = SpannableString("yourGrandFatherName, yourGreatGrandFatherName ")
        val regexReplace32 = """(yourGrandFatherName)""".toRegex()
        val Body58A = SpannableString(Body58AA.replace(regexReplace32, yrGFNamee))
        val regexReplace33 = """(yourGreatGrandFatherName)""".toRegex()
        val Body58 = SpannableString(Body58A.replace(regexReplace33, yrGGFNamee))
        Body58.setSpan(AbsoluteSizeSpan(14, true), start, Body58.length, exExFlag)
        Body58.setSpan(StyleSpan(Typeface.BOLD), start, Body58.length, exExFlag)
        Body58.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body58.length, exExFlag)

        val MBody58AA = SpannableString("yourGrandFatherName, yourGreatGrandFatherName ")
        val regexReplaceM32 = """(yourGrandFatherName)""".toRegex()
        val MBody58A = SpannableString(MBody58AA.replace(regexReplaceM32, yrGFNamee))
        val regexReplaceM33 = """(yourGreatGrandFatherName)""".toRegex()
        val MBody58 = SpannableString(MBody58A.replace(regexReplaceM33, yrGGFNamee))
        MBody58.setSpan(AbsoluteSizeSpan(14, true), start, MBody58.length, exExFlag)
        MBody58.setSpan(StyleSpan(Typeface.BOLD), start, MBody58.length, exExFlag)
        MBody58.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody58.length, exExFlag)

        val Body59BBB = SpannableString("yourGreatGrandFatherName, yourGreatGreatGrandFatherName ")
        val regexReplace34 = """(yourGreatGrandFatherName)""".toRegex()
        val Body59BB = SpannableString(Body59BBB.replace(regexReplace34, yrGGFNamee))
        val regexReplace35 = """(yourGreatGreatGrandFatherName)""".toRegex()
        val Body59B = SpannableString(Body59BB.replace(regexReplace35, yrGGGFNamee))
        Body59B.setSpan(AbsoluteSizeSpan(14, true), start, Body59B.length, exExFlag)
        Body59B.setSpan(StyleSpan(Typeface.BOLD), start, Body59B.length, exExFlag)
        Body59B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body59B.length, exExFlag)

        val MBody59BBB = SpannableString("yourGreatGrandFatherName, yourGreatGreatGrandFatherName ")
        val regexReplaceM34 = """(yourGreatGrandFatherName)""".toRegex()
        val MBody59BB = SpannableString(MBody59BBB.replace(regexReplaceM34, yrGGFNamee))
        val regexReplaceM35 = """(yourGreatGreatGrandFatherName)""".toRegex()
        val MBody59B = SpannableString(MBody59BB.replace(regexReplaceM35, yrGGGFNamee))
        MBody59B.setSpan(AbsoluteSizeSpan(14, true), start, MBody59B.length, exExFlag)
        MBody59B.setSpan(StyleSpan(Typeface.BOLD), start, MBody59B.length, exExFlag)
        MBody59B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody59B.length, exExFlag)

        val Body60 = SpannableString("சர்மணாம் வஸூருத்ர ஆதித்ய ஸ்வரூபாணாம் அஸ்மின்கூர்ச்சே இதமாஸனம்")
        Body60.setSpan(AbsoluteSizeSpan(14, true), start, Body60.length, exExFlag)
        Body60.setSpan(StyleSpan(Typeface.BOLD), start, Body60.length, exExFlag)
        Body60.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body60.length, exExFlag)

        val Comment47 = SpannableString("\nஎன்று கட்டை தர்பங்களை போடவும்")
        Comment47.setSpan(AbsoluteSizeSpan(13, true), start, Comment47.length, exExFlag)
        Comment47.setSpan(StyleSpan(Typeface.ITALIC), start, Comment47.length, exExFlag)
        Comment47.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment47.length, exExFlag)

        val Body61 = SpannableString("\nகந்தாதி ஸகலாராதனை: ஸ்வர்ச்சிதம்")
        Body61.setSpan(AbsoluteSizeSpan(14, true), start, Body61.length, exExFlag)
        Body61.setSpan(StyleSpan(Typeface.BOLD), start, Body61.length, exExFlag)
        Body61.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body61.length, exExFlag)

        val MBody61 = SpannableString("\nகந்தாதி ஸகலாராதனை: ஸ்வர்ச்சிதம்")
        MBody61.setSpan(AbsoluteSizeSpan(14, true), start, MBody61.length, exExFlag)
        MBody61.setSpan(StyleSpan(Typeface.BOLD), start, MBody61.length, exExFlag)
        MBody61.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody61.length, exExFlag)

        val Comment48 = SpannableString("\nஎன்று எள்ளை")
        Comment48.setSpan(AbsoluteSizeSpan(13, true), start, Comment48.length, exExFlag)
        Comment48.setSpan(StyleSpan(Typeface.ITALIC), start, Comment48.length, exExFlag)
        Comment48.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment48.length, exExFlag)

        val Comment48x = SpannableString("\nஎன்று எள்ளை")
        Comment48x.setSpan(AbsoluteSizeSpan(13, true), start, Comment48x.length, exExFlag)
        Comment48x.setSpan(StyleSpan(Typeface.ITALIC), start, Comment48x.length, exExFlag)
        Comment48x.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment48x.length, exExFlag)

        val Comment49 = SpannableString("\nஎன்று எள்ளும், சிறிது அரிசியையும்")
        Comment49.setSpan(AbsoluteSizeSpan(13, true), start, Comment49.length, exExFlag)
        Comment49.setSpan(StyleSpan(Typeface.ITALIC), start, Comment49.length, exExFlag)
        Comment49.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment49.length, exExFlag)

        val Comment49x = SpannableString("\nஎன்று எள்ளும், சிறிது அரிசியையும்")
        Comment49x.setSpan(AbsoluteSizeSpan(13, true), start, Comment49x.length, exExFlag)
        Comment49x.setSpan(StyleSpan(Typeface.ITALIC), start, Comment49x.length, exExFlag)
        Comment49x.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment49x.length, exExFlag)

        val Comment50 = SpannableString(" போடவும்)")
        Comment50.setSpan(AbsoluteSizeSpan(13, true), start, Comment50.length, exExFlag)
        Comment50.setSpan(StyleSpan(Typeface.ITALIC), start, Comment50.length, exExFlag)
        Comment50.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment50.length, exExFlag)

        val Comment50x = SpannableString("யும் போடவும்)")
        Comment50x.setSpan(AbsoluteSizeSpan(13, true), start, Comment50x.length, exExFlag)
        Comment50x.setSpan(StyleSpan(Typeface.ITALIC), start, Comment50x.length, exExFlag)
        Comment50x.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment50x.length, exExFlag)

        val MSComment42A = SpannableString("\n(மந்திரம்: ")
        MSComment42A.setSpan(AbsoluteSizeSpan(13, true), start, MSComment42A.length, exExFlag)
        MSComment42A.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, MSComment42A.length, exExFlag)
        MSComment42A.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, MSComment42A.length, exExFlag)

        val MSEComment42A = SpannableString("கீழ்")
        MSEComment42A.setSpan(AbsoluteSizeSpan(13, true), start, MSEComment42A.length, exExFlag)
        MSEComment42A.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, MSEComment42A.length, exExFlag)
        MSEComment42A.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, MSEComment42A.length, exExFlag)

        val MComment42B = SpannableString("கூர்ச்சம்: மாதாமஹவர்கம்)")
        MComment42B.setSpan(AbsoluteSizeSpan(13, true), start, MComment42B.length, exExFlag)
        MComment42B.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, MComment42B.length, exExFlag)
        MComment42B.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, MComment42B.length, exExFlag)

        val MComment42C = SpannableString("\nஆவாஹனம்")
        MComment42C.setSpan(AbsoluteSizeSpan(16, true), start, MComment42C.length, exExFlag)
        MComment42C.setSpan(StyleSpan(Typeface.BOLD), start, MComment42C.length, exExFlag)
        MComment42C.setSpan(UnderlineSpan(), start, MComment42C.length, exExFlag)
        MComment42C.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, MComment42C.length, exExFlag)

        val MComment42D = SpannableString("\nஆவாஹனம்")
        MComment42D.setSpan(AbsoluteSizeSpan(16, true), start, MComment42D.length, exExFlag)
        MComment42D.setSpan(StyleSpan(Typeface.BOLD), start, MComment42D.length, exExFlag)
        MComment42D.setSpan(UnderlineSpan(), start, MComment42D.length, exExFlag)
        MComment42D.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, MComment42D.length, exExFlag)

//**************************************************************************************************************

        val Heading5 = SpannableString("\n\nபித்ருவர்கம் - பிதாவர்க்கம்")
        Heading5.setSpan(AbsoluteSizeSpan(16, true), start, Heading5.length, exExFlag)
        Heading5.setSpan(StyleSpan(Typeface.BOLD), start, Heading5.length, exExFlag)
        Heading5.setSpan(UnderlineSpan(), start, Heading5.length, exExFlag)
        Heading5.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, Heading5.length, exExFlag)

        val Body62A = SpannableString(
            "\n1.a.   ஓம் உதீரதாம் அவரே உத்பராஸ: உந்மத்யமா: பிதர: ஸோம்யாஸ: அஸூம்யஈயு: " +
                    "அவ்ருகா: ருதக்ஞா: தேநோவந்து பிதரோஹவேஷூ yourGothram கோத்ர: அஸ்மத் "
        )
        val regexReplace36 = """(yourGothram)""".toRegex()
        val Body62 = SpannableString(Body62A.replace(regexReplace36, urGothram))
        Body62.setSpan(AbsoluteSizeSpan(14, true), start, Body62.length, exExFlag)
        Body62.setSpan(StyleSpan(Typeface.BOLD), start, Body62.length, exExFlag)
        Body62.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body62.length, exExFlag)

        val Sabathneek4 = SpannableString("ஸபத்நீக:")
        Sabathneek4.setSpan(AbsoluteSizeSpan(14, true), start, Sabathneek4.length, exExFlag)
        Sabathneek4.setSpan(StyleSpan(Typeface.BOLD), start, Sabathneek4.length, exExFlag)
        Sabathneek4.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Sabathneek4.length, exExFlag)

        val Body63 = SpannableString(" பிதா")
        Body63.setSpan(AbsoluteSizeSpan(14, true), start, Body63.length, exExFlag)
        Body63.setSpan(StyleSpan(Typeface.BOLD), start, Body63.length, exExFlag)
        Body63.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body63.length, exExFlag)

        val Body64AA = SpannableString(
            " yourFatherName சர்மா வஸூரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                    "\n1.b.   ஓம் அங்கீரஸோந: பிதரோ நவக்வா: அதர்வாண: ப்ருகவ: ஸோம்யாஸ: தேஷாம்வயம் ஸூமதௌ யக்ஞியாநாம் அபிபத்ரே " +
                    "ஸௌமனஸே ஸ்யாம yourGothram கோத்ர: அஸ்மத்"
        )
        val regexReplace37 = """(yourFatherName)""".toRegex()
        val Body64A = SpannableString(Body64AA.replace(regexReplace37, yrFNamee))
        val regexReplace38 = """(yourGothram)""".toRegex()
        val Body64 = SpannableString(Body64A.replace(regexReplace38, urGothram))
        Body64.setSpan(AbsoluteSizeSpan(14, true), start, Body64.length, exExFlag)
        Body64.setSpan(StyleSpan(Typeface.BOLD), start, Body64.length, exExFlag)
        Body64.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body64.length, exExFlag)

        val Sabathneek5 = SpannableString(" ஸபத்நீக:")
        Sabathneek5.setSpan(AbsoluteSizeSpan(14, true), start, Sabathneek5.length, exExFlag)
        Sabathneek5.setSpan(StyleSpan(Typeface.BOLD), start, Sabathneek5.length, exExFlag)
        Sabathneek5.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Sabathneek5.length, exExFlag)

        val Body65 = SpannableString(" பிதா")
        Body65.setSpan(AbsoluteSizeSpan(14, true), start, Body65.length, exExFlag)
        Body65.setSpan(StyleSpan(Typeface.BOLD), start, Body65.length, exExFlag)
        Body65.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body65.length, exExFlag)

        val Body66AA = SpannableString(
            " yourFatherName சர்மா வஸூரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                    "\n1.c.   ஓம் ஆயந்துந: பிதர: ஸோம்யாஸ: அக்னிஷ்வாத்தா: பதிபி: தேவயானை: அஸ்மின் யக்ஞே ஸ்வதயா மதந்த: அதிப்ருவந்து " +
                    "தேவந்து அஸ்மான் yourGothram கோத்ர: அஸ்மத் "
        )
        val regexReplace39 = """(yourFatherName)""".toRegex()
        val Body66A = SpannableString(Body66AA.replace(regexReplace39, yrFNamee))
        val regexReplace40 = """(yourGothram)""".toRegex()
        val Body66 = SpannableString(Body66A.replace(regexReplace40, urGothram))
        Body66.setSpan(AbsoluteSizeSpan(14, true), start, Body66.length, exExFlag)
        Body66.setSpan(StyleSpan(Typeface.BOLD), start, Body66.length, exExFlag)
        Body66.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body66.length, exExFlag)

        val Sabathneek6 = SpannableString("ஸபத்நீக:")
        Sabathneek6.setSpan(AbsoluteSizeSpan(14, true), start, Sabathneek6.length, exExFlag)
        Sabathneek6.setSpan(StyleSpan(Typeface.BOLD), start, Sabathneek6.length, exExFlag)
        Sabathneek6.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Sabathneek6.length, exExFlag)

        val Body67 = SpannableString(" பிதா")
        Body67.setSpan(AbsoluteSizeSpan(14, true), start, Body67.length, exExFlag)
        Body67.setSpan(StyleSpan(Typeface.BOLD), start, Body67.length, exExFlag)
        Body67.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body67.length, exExFlag)

        val Body68A = SpannableString(" yourFatherName சர்மா வஸூரூப: ஸ்வதாநம: த்ருப்யதாம்.")
        val regexReplace41 = """(yourFatherName)""".toRegex()
        val Body68 = SpannableString(Body68A.replace(regexReplace41, yrFNamee))
        Body68.setSpan(AbsoluteSizeSpan(14, true), start, Body68.length, exExFlag)
        Body68.setSpan(StyleSpan(Typeface.BOLD), start, Body68.length, exExFlag)
        Body68.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body68.length, exExFlag)

        val Body69A = SpannableString(
            "\n\n2.a.    ஓம் ஊர்ஜம் வஹந்தி: அம்ருதம்க்ருதம் பய:கீலாலம் பரிஸ்ருதம் ஸ்வதாஸ்த " +
                    "தர்பயதமே பித்ருன் yourGothram கோத்ர: அஸ்மத்"
        )
        val regexReplace42 = """(yourGothram)""".toRegex()
        val Body69 = SpannableString(Body69A.replace(regexReplace42, urGothram))
        Body69.setSpan(AbsoluteSizeSpan(14, true), start, Body69.length, exExFlag)
        Body69.setSpan(StyleSpan(Typeface.BOLD), start, Body69.length, exExFlag)
        Body69.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body69.length, exExFlag)

        val Sabathneek7 = SpannableString(" ஸபத்நீக: ")
        Sabathneek7.setSpan(AbsoluteSizeSpan(14, true), start, Sabathneek7.length, exExFlag)
        Sabathneek7.setSpan(StyleSpan(Typeface.BOLD), start, Sabathneek7.length, exExFlag)
        Sabathneek7.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Sabathneek7.length, exExFlag)

        val Body70A = SpannableString(" பிதாமஹ: ")
        Body70A.setSpan(AbsoluteSizeSpan(14, true), start, Body70A.length, exExFlag)
        Body70A.setSpan(StyleSpan(Typeface.BOLD), start, Body70A.length, exExFlag)
        Body70A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body70A.length, exExFlag)

        val Body70B = SpannableString(" ப்ரபிதாமஹான்னு: ")
        Body70B.setSpan(AbsoluteSizeSpan(14, true), start, Body70B.length, exExFlag)
        Body70B.setSpan(StyleSpan(Typeface.BOLD), start, Body70B.length, exExFlag)
        Body70B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body70B.length, exExFlag)

        val Body71AA = SpannableString(
            "yourGrandFatherName சர்மா ருத்ரரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                    "\n2.b.   ஓம் பித்ருப்ய: ஸ்வாதாயிப்ய: ஸ்வாதாநம: பிதாமஹேப்ய: ஸ்வதாயிப்ய: ஸ்வதாநம: ப்ரபிதாமஹேப்ய: ஸ்வதாயிப்ய: " +
                    "ஸ்வாதாநம: yourGothram கோத்ர: அஸ்மத்"
        )
        val regexReplace43 = """(yourGrandFatherName)""".toRegex()
        val Body71A = SpannableString(Body71AA.replace(regexReplace43, yrGFNamee))
        val regexReplace44 = """(yourGothram)""".toRegex()
        val Body71 = SpannableString(Body71A.replace(regexReplace44, urGothram))
        Body71.setSpan(AbsoluteSizeSpan(14, true), start, Body71.length, exExFlag)
        Body71.setSpan(StyleSpan(Typeface.BOLD), start, Body71.length, exExFlag)
        Body71.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body71.length, exExFlag)

        val Body72AA = SpannableString(
            "yourGreatGrandFatherName சர்மா ருத்ரரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                    "\n2.b.   ஓம் பித்ருப்ய: ஸ்வாதாயிப்ய: ஸ்வாதாநம: பிதாமஹேப்ய: ஸ்வதாயிப்ய: ஸ்வதாநம: ப்ரபிதாமஹேப்ய: ஸ்வதாயிப்ய: " +
                    "ஸ்வாதாநம: yourGothram கோத்ர: அஸ்மத்"
        )
        val regexReplace45 = """(yourGreatGrandFatherName)""".toRegex()
        val Body72A = SpannableString(Body72AA.replace(regexReplace45, yrGGFNamee))
        val regexReplace46 = """(yourGothram)""".toRegex()
        val Body72 = SpannableString(Body72A.replace(regexReplace46, urGothram))
        Body72.setSpan(AbsoluteSizeSpan(14, true), start, Body72.length, exExFlag)
        Body72.setSpan(StyleSpan(Typeface.BOLD), start, Body72.length, exExFlag)
        Body72.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body72.length, exExFlag)

        val Sabathneek8 = SpannableString(" ஸபத்நீக: ")
        Sabathneek8.setSpan(AbsoluteSizeSpan(14, true), start, Sabathneek8.length, exExFlag)
        Sabathneek8.setSpan(StyleSpan(Typeface.BOLD), start, Sabathneek8.length, exExFlag)
        Sabathneek8.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Sabathneek8.length, exExFlag)

        val Body73A = SpannableString(" பிதாமஹ: ")
        Body73A.setSpan(AbsoluteSizeSpan(14, true), start, Body73A.length, exExFlag)
        Body73A.setSpan(StyleSpan(Typeface.BOLD), start, Body73A.length, exExFlag)
        Body73A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body73A.length, exExFlag)

        val Body73B = SpannableString(" ப்ரபிதாமஹான்னு: ")
        Body73B.setSpan(AbsoluteSizeSpan(14, true), start, Body73B.length, exExFlag)
        Body73B.setSpan(StyleSpan(Typeface.BOLD), start, Body73B.length, exExFlag)
        Body73B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body73B.length, exExFlag)

        val Body74AA = SpannableString(
            "yourGrandFatherName சர்மா ருத்ரரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                    "\n2.c.   ஓம் யேசேஹபிதர: யேசநேஹ யாங்குச்ச வித்மயான் ஊசன ப்ரவித்ம த்வம்வேத்த யதிதே ஜாதவேத: ஸ்வதாபி: யக்ஞம் " +
                    "ஸூக்ருதம் ஜூஷஸ்வ yourGothram கோத்ர: அஸ்மத்"
        )
        val regexReplace47 = """(yourGrandFatherName)""".toRegex()
        val Body74A = SpannableString(Body74AA.replace(regexReplace47, yrGFNamee))
        val regexReplace48 = """(yourGothram)""".toRegex()
        val Body74 = SpannableString(Body74A.replace(regexReplace48, urGothram))
        Body74.setSpan(AbsoluteSizeSpan(14, true), start, Body74.length, exExFlag)
        Body74.setSpan(StyleSpan(Typeface.BOLD), start, Body74.length, exExFlag)
        Body74.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body74.length, exExFlag)

        val Body75AA = SpannableString(
            "yourGreatGrandFatherName சர்மா ருத்ரரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                    "\n2.c.   ஓம் யேசேஹபிதர: யேசநேஹ யாங்குச்ச வித்மயான் ஊசன ப்ரவித்ம த்வம்வேத்த யதிதே ஜாதவேத: ஸ்வதாபி: யக்ஞம் " +
                    "ஸூக்ருதம் ஜூஷஸ்வ yourGothram கோத்ர: அஸ்மத்"
        )
        val regexReplace49 = """(yourGreatGrandFatherName)""".toRegex()
        val Body75A = SpannableString(Body75AA.replace(regexReplace49, yrGGFNamee))
        val regexReplace50 = """(yourGothram)""".toRegex()
        val Body75 = SpannableString(Body75A.replace(regexReplace50, urGothram))
        Body75.setSpan(AbsoluteSizeSpan(14, true), start, Body75.length, exExFlag)
        Body75.setSpan(StyleSpan(Typeface.BOLD), start, Body75.length, exExFlag)
        Body75.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body75.length, exExFlag)

        val Sabathneek9 = SpannableString(" ஸபத்நீக: ")
        Sabathneek9.setSpan(AbsoluteSizeSpan(14, true), start, Sabathneek9.length, exExFlag)
        Sabathneek9.setSpan(StyleSpan(Typeface.BOLD), start, Sabathneek9.length, exExFlag)
        Sabathneek9.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Sabathneek9.length, exExFlag)

        val Body76A = SpannableString(" பிதாமஹ: ")
        Body76A.setSpan(AbsoluteSizeSpan(14, true), start, Body76A.length, exExFlag)
        Body76A.setSpan(StyleSpan(Typeface.BOLD), start, Body76A.length, exExFlag)
        Body76A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body76A.length, exExFlag)

        val Body76B = SpannableString(" ப்ரபிதாமஹான்னு: ")
        Body76B.setSpan(AbsoluteSizeSpan(14, true), start, Body76B.length, exExFlag)
        Body76B.setSpan(StyleSpan(Typeface.BOLD), start, Body76B.length, exExFlag)
        Body76B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body76B.length, exExFlag)

        val Body77AA = SpannableString(
            "yourGrandFatherName சர்மா ருத்ரரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                    "\n3.a.    ஓம் மதுவாதா: ருதாயதே மதுக்ஷரந்தி ஸிந்தவ: மாத்வீர்ந: ஸந்து ஓஷதீ: yourGothram கோத்ர: அஸ்மத்"
        )
        val regexReplace51 = """(yourGrandFatherName)""".toRegex()
        val Body77A = SpannableString(Body77AA.replace(regexReplace51, yrGFNamee))
        val regexReplace52 = """(yourGothram)""".toRegex()
        val Body77 = SpannableString(Body77A.replace(regexReplace52, urGothram))
        Body77.setSpan(AbsoluteSizeSpan(14, true), start, Body77.length, exExFlag)
        Body77.setSpan(StyleSpan(Typeface.BOLD), start, Body77.length, exExFlag)
        Body77.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body77.length, exExFlag)

        val Body78AA = SpannableString(
            "yourGreatGrandFatherName சர்மா ருத்ரரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                    "\n3.a.    ஓம் மதுவாதா: ருதாயதே மதுக்ஷரந்தி ஸிந்தவ: மாத்வீர்ந: ஸந்து ஓஷதீ: yourGothram கோத்ர: அஸ்மத்"
        )
        val regexReplace53 = """(yourGreatGrandFatherName)""".toRegex()
        val Body78A = SpannableString(Body78AA.replace(regexReplace53, yrGGFNamee))
        val regexReplace54 = """(yourGothram)""".toRegex()
        val Body78 = SpannableString(Body78A.replace(regexReplace54, urGothram))
        Body78.setSpan(AbsoluteSizeSpan(14, true), start, Body78.length, exExFlag)
        Body78.setSpan(StyleSpan(Typeface.BOLD), start, Body78.length, exExFlag)
        Body78.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body78.length, exExFlag)

        val Sabathneek10 = SpannableString(" ஸபத்நீக: ")
        Sabathneek10.setSpan(AbsoluteSizeSpan(14, true), start, Sabathneek10.length, exExFlag)
        Sabathneek10.setSpan(StyleSpan(Typeface.BOLD), start, Sabathneek10.length, exExFlag)
        Sabathneek10.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Sabathneek10.length, exExFlag)

        val Body79A = SpannableString(" ப்ரபிதாமஹான்னு: ")
        Body79A.setSpan(AbsoluteSizeSpan(14, true), start, Body79A.length, exExFlag)
        Body79A.setSpan(StyleSpan(Typeface.BOLD), start, Body79A.length, exExFlag)
        Body79A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body79A.length, exExFlag)

        val Body79B = SpannableString(" வ்ருத்தப்ரபிதாமஹ: ")
        Body79B.setSpan(AbsoluteSizeSpan(14, true), start, Body79B.length, exExFlag)
        Body79B.setSpan(StyleSpan(Typeface.BOLD), start, Body79B.length, exExFlag)
        Body79B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body79B.length, exExFlag)

        val Body80AA = SpannableString(
            "yourGreatGrandFatherName சர்மா ஆதித்யரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                    "\n3.b.  ஓம் மதுநக்தம் உதோஷஸ: மதுமத் பார்த்தீவம் ரஜ: மதுத்யௌ: அஸ்துந: பிதா yourGothram கோத்ர: அஸ்மத்"
        )
        val regexReplace55 = """(yourGreatGrandFatherName)""".toRegex()
        val Body80A = SpannableString(Body80AA.replace(regexReplace55, yrGGFNamee))
        val regexReplace56 = """(yourGothram)""".toRegex()
        val Body80 = SpannableString(Body80A.replace(regexReplace56, urGothram))
        Body80.setSpan(AbsoluteSizeSpan(14, true), start, Body80.length, exExFlag)
        Body80.setSpan(StyleSpan(Typeface.BOLD), start, Body80.length, exExFlag)
        Body80.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body80.length, exExFlag)

        val Body81AA = SpannableString(
            "yourGreatGreatGrandFatherName சர்மா ஆதித்யரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                    "\n3.b.  ஓம் மதுநக்தம் உதோஷஸ: மதுமத் பார்த்தீவம் ரஜ: மதுத்யௌ: அஸ்துந: பிதா yourGothram கோத்ர: அஸ்மத்"
        )
        val regexReplace57 = """(yourGreatGreatGrandFatherName)""".toRegex()
        val Body81A = SpannableString(Body81AA.replace(regexReplace57, yrGGGFNamee))
        val regexReplace58 = """(yourGothram)""".toRegex()
        val Body81 = SpannableString(Body81A.replace(regexReplace58, urGothram))
        Body81.setSpan(AbsoluteSizeSpan(14, true), start, Body81.length, exExFlag)
        Body81.setSpan(StyleSpan(Typeface.BOLD), start, Body81.length, exExFlag)
        Body81.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body81.length, exExFlag)

        val Sabathneek11 = SpannableString(" ஸபத்நீக: ")
        Sabathneek11.setSpan(AbsoluteSizeSpan(14, true), start, Sabathneek11.length, exExFlag)
        Sabathneek11.setSpan(StyleSpan(Typeface.BOLD), start, Sabathneek11.length, exExFlag)
        Sabathneek11.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Sabathneek11.length, exExFlag)

        val Body82A = SpannableString(" ப்ரபிதாமஹான்னு: ")
        Body82A.setSpan(AbsoluteSizeSpan(14, true), start, Body82A.length, exExFlag)
        Body82A.setSpan(StyleSpan(Typeface.BOLD), start, Body82A.length, exExFlag)
        Body82A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body82A.length, exExFlag)

        val Body82B = SpannableString(" வ்ருத்தப்ரபிதாமஹ: ")
        Body82B.setSpan(AbsoluteSizeSpan(14, true), start, Body82B.length, exExFlag)
        Body82B.setSpan(StyleSpan(Typeface.BOLD), start, Body82B.length, exExFlag)
        Body82B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body82B.length, exExFlag)

        val Body83AA = SpannableString(
            "yourGreatGrandFatherName சர்மா ஆதித்யரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                    "\n3.c.  ஓம் மதுமாந்த: வநஸ்பதி: மதுமாந் அஸ்துஸூர்ய: மாத்வீர்காவ: பவந்துந: yourGothram கோத்ர: அஸ்மத்"
        )
        val regexReplace59 = """(yourGreatGrandFatherName)""".toRegex()
        val Body83A = SpannableString(Body83AA.replace(regexReplace59, yrGGFNamee))
        val regexReplace60 = """(yourGothram)""".toRegex()
        val Body83 = SpannableString(Body83A.replace(regexReplace60, urGothram))
        Body83.setSpan(AbsoluteSizeSpan(14, true), start, Body83.length, exExFlag)
        Body83.setSpan(StyleSpan(Typeface.BOLD), start, Body83.length, exExFlag)
        Body83.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body83.length, exExFlag)

        val Body84AA = SpannableString(
            "yourGreatGreatGrandFatherName சர்மா ஆதித்யரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                    "\n3.c.  ஓம் மதுமாந்த: வநஸ்பதி: மதுமாந் அஸ்துஸூர்ய: மாத்வீர்காவ: பவந்துந: yourGothram கோத்ர: அஸ்மத்"
        )
        val regexReplace61 = """(yourGreatGreatGrandFatherName)""".toRegex()
        val Body84A = SpannableString(Body84AA.replace(regexReplace61, yrGGGFNamee))
        val regexReplace62 = """(yourGothram)""".toRegex()
        val Body84 = SpannableString(Body84A.replace(regexReplace62, urGothram))
        Body84.setSpan(AbsoluteSizeSpan(14, true), start, Body84.length, exExFlag)
        Body84.setSpan(StyleSpan(Typeface.BOLD), start, Body84.length, exExFlag)
        Body84.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body84.length, exExFlag)

        val Sabathneek12 = SpannableString(" ஸபத்நீக: ")
        Sabathneek12.setSpan(AbsoluteSizeSpan(14, true), start, Sabathneek12.length, exExFlag)
        Sabathneek12.setSpan(StyleSpan(Typeface.BOLD), start, Sabathneek12.length, exExFlag)
        Sabathneek12.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Sabathneek12.length, exExFlag)

        val Body85A = SpannableString(" ப்ரபிதாமஹான்னு: ")
        Body85A.setSpan(AbsoluteSizeSpan(14, true), start, Body85A.length, exExFlag)
        Body85A.setSpan(StyleSpan(Typeface.BOLD), start, Body85A.length, exExFlag)
        Body85A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body85A.length, exExFlag)

        val Body85B = SpannableString(" வ்ருத்தப்ரபிதாமஹ: ")
        Body85B.setSpan(AbsoluteSizeSpan(14, true), start, Body85B.length, exExFlag)
        Body85B.setSpan(StyleSpan(Typeface.BOLD), start, Body85B.length, exExFlag)
        Body85B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body85B.length, exExFlag)

        val Body86A =
            SpannableString("yourGreatGrandFatherName சர்மா ஆதித்யரூப: ஸ்வதாநம: த்ருப்யதாம்.\nத்ருப்யத்வம்     த்ருப்யத்வம்     த்ருப்யத்வம்")
        val regexReplace63 = """(yourGreatGrandFatherName)""".toRegex()
        val Body86 = SpannableString(Body86A.replace(regexReplace63, yrGGFNamee))
        Body86.setSpan(AbsoluteSizeSpan(14, true), start, Body86.length, exExFlag)
        Body86.setSpan(StyleSpan(Typeface.BOLD), start, Body86.length, exExFlag)
        Body86.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body86.length, exExFlag)

        val Body87B =
            SpannableString("yourGreatGreatGrandFatherName சர்மா ஆதித்யரூப: ஸ்வதாநம: த்ருப்யதாம்.\nத்ருப்யத்வம்     த்ருப்யத்வம்     த்ருப்யத்வம்")
        val regexReplace64 = """(yourGreatGreatGrandFatherName)""".toRegex()
        val Body87 = SpannableString(Body87B.replace(regexReplace64, yrGGGFNamee))
        Body87.setSpan(AbsoluteSizeSpan(14, true), start, Body87.length, exExFlag)
        Body87.setSpan(StyleSpan(Typeface.BOLD), start, Body87.length, exExFlag)
        Body87.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body87.length, exExFlag)

//***************************************************************************************************

        val MHeading5 = SpannableString("\n\nகீழ்கூர்ச்சம் : மாதாமஹவர்கம்\n")
        MHeading5.setSpan(AbsoluteSizeSpan(16, true), start, MHeading5.length, exExFlag)
        MHeading5.setSpan(StyleSpan(Typeface.BOLD), start, MHeading5.length, exExFlag)
        MHeading5.setSpan(UnderlineSpan(), start, MHeading5.length, exExFlag)
        MHeading5.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, MHeading5.length, exExFlag)

        val MBody62A = SpannableString(
            "\nI.a.   ஓம் உதீரதாம் அவரே உத்பராஸ: உந்மத்யமா: பிதர: ஸோம்யாஸ: அஸூம்யஈயு: " +
                    "அவ்ருகா: ருதக்ஞா: தேநோவந்து பிதரோஹவேஷூ motherSideGothram கோத்ர: அஸ்மத் "
        )
        val MregexReplace36 = """(motherSideGothram)""".toRegex()
        val MBody62 = SpannableString(MBody62A.replace(MregexReplace36, MGothram))
        MBody62.setSpan(AbsoluteSizeSpan(14, true), start, MBody62.length, exExFlag)
        MBody62.setSpan(StyleSpan(Typeface.BOLD), start, MBody62.length, exExFlag)
        MBody62.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody62.length, exExFlag)

        val MSabathneek4 = SpannableString("ஸபத்நீக:")
        MSabathneek4.setSpan(AbsoluteSizeSpan(14, true), start, MSabathneek4.length, exExFlag)
        MSabathneek4.setSpan(StyleSpan(Typeface.BOLD), start, MSabathneek4.length, exExFlag)
        MSabathneek4.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MSabathneek4.length, exExFlag)

        val MBody63AA = SpannableString(
            " மாதாமஹ: motherFather  சர்மா வஸூரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                    "\nI.b.  ஓம் அங்கீரஸோந: பிநரோ நவக்வா: அதர்வாண: ப்ருகவ: ஸோம்யாஸ: தேஷாம்வயம் ஸூமதௌ யக்ஞியாநாம் அபிபத்ரே " +
                    "ஸௌமனஸே ஸ்யாம motherSideGothram கோத்ர: அஸ்மத்"
        )
        val MregexMFN = """(motherFather)""".toRegex()
        val MBody63A = SpannableString(MBody63AA.replace(MregexMFN, MFNamee))
        val MregexGothram = """(motherSideGothram)""".toRegex()
        val MBody63 = SpannableString(MBody63A.replace(MregexGothram, MGothram))
        MBody63.setSpan(AbsoluteSizeSpan(14, true), start, MBody63.length, exExFlag)
        MBody63.setSpan(StyleSpan(Typeface.BOLD), start, MBody63.length, exExFlag)
        MBody63.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody63.length, exExFlag)

        val MSabathneek5 = SpannableString("ஸபத்நீக:")
        MSabathneek5.setSpan(AbsoluteSizeSpan(14, true), start, MSabathneek5.length, exExFlag)
        MSabathneek5.setSpan(StyleSpan(Typeface.BOLD), start, MSabathneek5.length, exExFlag)
        MSabathneek5.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MSabathneek5.length, exExFlag)

        val MBody64AA = SpannableString(
            "மாதாமஹ: motherFather  சர்மா வஸூரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                    "    \nI.c.  ஓம் ஆயந்துந: பிதர: ஸோம்யாஸ: அக்னிஷ்வாத்தா: பதிபி: தேவயானை: அஸ்மின்யக்ஞே ஸ்வதயாமதந்த: " +
                    "அதிப்ருவந்து தேவந்து அஸ்மான் motherSideGothram கோத்ர: அஸ்மத்"
        )
        val MregexReplace37 = """(motherFather)""".toRegex()
        val MBody64A = SpannableString(MBody64AA.replace(MregexReplace37, MFNamee))
        val MregexReplace38 = """(motherSideGothram)""".toRegex()
        val MBody64 = SpannableString(MBody64A.replace(MregexReplace38, MGothram))
        MBody64.setSpan(AbsoluteSizeSpan(14, true), start, MBody64.length, exExFlag)
        MBody64.setSpan(StyleSpan(Typeface.BOLD), start, MBody64.length, exExFlag)
        MBody64.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody64.length, exExFlag)

        val M2Sabathneek5 = SpannableString("ஸபத்நீக:")
        M2Sabathneek5.setSpan(AbsoluteSizeSpan(14, true), start, M2Sabathneek5.length, exExFlag)
        M2Sabathneek5.setSpan(StyleSpan(Typeface.BOLD), start, M2Sabathneek5.length, exExFlag)
        M2Sabathneek5.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, M2Sabathneek5.length, exExFlag)

        val MBody66AA = SpannableString(
            " மாதாமஹ: motherFather  சர்மா வஸூரூப: ஸ்வதாநம: த்ருப்யதாம். \n\nII.a. ஓம் " +
                    "ஊர்ஜம்வஹந்தீ: அம்ருதம் க்ருதம் பய:கீலாலம் பரிஸ்ருதம் ஸ்வதாஸ்த தர்பயதமே பித்ரூன் motherSideGothram கோத்ர: அஸ்மத்"
        )
        val MregexReplace39 = """(motherFather)""".toRegex()
        val MBody66A = SpannableString(MBody66AA.replace(MregexReplace39, MFNamee))
        val MregexReplace40 = """(motherSideGothram)""".toRegex()
        val MBody66 = SpannableString(MBody66A.replace(MregexReplace40, MGothram))
        MBody66.setSpan(AbsoluteSizeSpan(14, true), start, MBody66.length, exExFlag)
        MBody66.setSpan(StyleSpan(Typeface.BOLD), start, MBody66.length, exExFlag)
        MBody66.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody66.length, exExFlag)

        val MSabathneek6 = SpannableString("ஸபத்நீக:")
        MSabathneek6.setSpan(AbsoluteSizeSpan(14, true), start, MSabathneek6.length, exExFlag)
        MSabathneek6.setSpan(StyleSpan(Typeface.BOLD), start, MSabathneek6.length, exExFlag)
        MSabathneek6.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MSabathneek6.length, exExFlag)

        val MBody68AA = SpannableString(
            "ப்ரமாதாமஹ: motherGrandFather சர்மா ருத்ரரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                    "    \nII.b. ஓம் பித்ருப்ய: ஸ்வாதாயிப்ய: ஸ்வதாநம: பிதாமஹேப்ய: ஸ்வதாயிப்ய: ஸ்வதாநம: ப்ரபிதாமஹேப்ய: ஸ்வதாயிப்ய: " +
                    "ஸ்வதாநம: motherSideGothram கோத்ர: அஸ்மத்"
        )
        val MregexReplace41 = """(motherGrandFather)""".toRegex()
        val MBody68A = SpannableString(MBody68AA.replace(MregexReplace41, MGFNamee))
        val M2regexReplace40 = """(motherSideGothram)""".toRegex()
        val MBody68 = SpannableString(MBody68A.replace(M2regexReplace40, MGothram))
        MBody68.setSpan(AbsoluteSizeSpan(14, true), start, MBody68.length, exExFlag)
        MBody68.setSpan(StyleSpan(Typeface.BOLD), start, MBody68.length, exExFlag)
        MBody68.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody68.length, exExFlag)

        val MSabathneek7 = SpannableString(" ஸபத்நீக: ")
        MSabathneek7.setSpan(AbsoluteSizeSpan(14, true), start, MSabathneek7.length, exExFlag)
        MSabathneek7.setSpan(StyleSpan(Typeface.BOLD), start, MSabathneek7.length, exExFlag)
        MSabathneek7.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MSabathneek7.length, exExFlag)

        val MBody69AA = SpannableString(
            "ப்ரமாதாமஹ: motherGrandFather சர்மா  ருத்ரரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                    "    \nII.c. யேசேஹபிதர: யேசநேஹ யாங்குச்ச வித்மயான் ஊசந ப்ரவித்ம த்வம்வேத்த யதிதேஜாதவேத: ஸ்வதாபி: யக்ஞம் " +
                    "ஸூக்ருதம் ஜூஷஸ்வ motherSideGothram கோத்ர: அஸ்மத்"
        )
        val M2regexReplace41 = """(motherGrandFather)""".toRegex()
        val MBody69A = SpannableString(MBody69AA.replace(M2regexReplace41, MGFNamee))
        val M3regexReplace40 = """(motherSideGothram)""".toRegex()
        val MBody69 = SpannableString(MBody69A.replace(M3regexReplace40, MGothram))
        MBody69.setSpan(AbsoluteSizeSpan(14, true), start, MBody69.length, exExFlag)
        MBody69.setSpan(StyleSpan(Typeface.BOLD), start, MBody69.length, exExFlag)
        MBody69.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody69.length, exExFlag)

        val MSabathneek8 = SpannableString(" ஸபத்நீக: ")
        MSabathneek8.setSpan(AbsoluteSizeSpan(14, true), start, MSabathneek8.length, exExFlag)
        MSabathneek8.setSpan(StyleSpan(Typeface.BOLD), start, MSabathneek8.length, exExFlag)
        MSabathneek8.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MSabathneek8.length, exExFlag)

        val MBody71AA = SpannableString(
            "ப்ரமாதாமஹ: motherGrandFather சர்மா ருத்ரரூப: ஸ்வதாநம: த்ருப்யதாம். \n\nIII.a.    " +
                    "ஓம் மதுவாதா: ருதாயதே மதுக்ஷரந்தி ஸிந்தவ: மாத்வீர்ந: ஸந்து ஓஷதீ: motherSideGothram கோத்ர: அஸ்மத்"
        )
        val MregexReplace43 = """(motherGrandFather)""".toRegex()
        val MBody71A = SpannableString(MBody71AA.replace(MregexReplace43, MGFNamee))
        val MregexReplace44 = """(motherSideGothram)""".toRegex()
        val MBody71 = SpannableString(MBody71A.replace(MregexReplace44, MGothram))
        MBody71.setSpan(AbsoluteSizeSpan(14, true), start, MBody71.length, exExFlag)
        MBody71.setSpan(StyleSpan(Typeface.BOLD), start, MBody71.length, exExFlag)
        MBody71.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody71.length, exExFlag)

        val MSabathneek9 = SpannableString(" ஸபத்நீக: ")
        MSabathneek9.setSpan(AbsoluteSizeSpan(14, true), start, MSabathneek9.length, exExFlag)
        MSabathneek9.setSpan(StyleSpan(Typeface.BOLD), start, MSabathneek9.length, exExFlag)
        MSabathneek9.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MSabathneek9.length, exExFlag)

        val MBody72AA = SpannableString(
            "வ்ருத்தப்ரமாதாமஹ: motherGreatGrandFather சர்மா ஆதித்யரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                    "\nIII.b.    ஓம் மதுநக்தம் உதோஷஸ: மதுமத் பார்த்திவம் ரஜ: மதுத்யௌ: அஸ்துந: பிதா  motherSideGothram கோத்ர: அஸ்மத்"
        )
        val MregexReplace45 = """(motherGreatGrandFather)""".toRegex()
        val MBody72A = SpannableString(MBody72AA.replace(MregexReplace45, MGGFNamee))
        val MregexReplace46 = """(motherSideGothram)""".toRegex()
        val MBody72 = SpannableString(MBody72A.replace(MregexReplace46, MGothram))
        MBody72.setSpan(AbsoluteSizeSpan(14, true), start, MBody72.length, exExFlag)
        MBody72.setSpan(StyleSpan(Typeface.BOLD), start, MBody72.length, exExFlag)
        MBody72.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody72.length, exExFlag)

        val MSabathneek10 = SpannableString(" ஸபத்நீக: ")
        MSabathneek10.setSpan(AbsoluteSizeSpan(14, true), start, MSabathneek10.length, exExFlag)
        MSabathneek10.setSpan(StyleSpan(Typeface.BOLD), start, MSabathneek10.length, exExFlag)
        MSabathneek10.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MSabathneek10.length, exExFlag)

        val MBody74AA = SpannableString(
            "வ்ருத்தப்ரமாதாமஹ: motherGreatGrandFather சர்மா ஆதித்யரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                    "    \nIII.c.    ஓம் மதுமாந்த: வநஸ்பதி: மதுமாந் அஸ்துஸூர்ய: மாத்வீர் காவோபவந்துந: motherSideGothram கோத்ர: அஸ்மத்"
        )
        val MregexReplace47 = """(motherGreatGrandFather)""".toRegex()
        val MBody74A = SpannableString(MBody74AA.replace(MregexReplace47, MGGFNamee))
        val MregexReplace48 = """(motherSideGothram)""".toRegex()
        val MBody74 = SpannableString(MBody74A.replace(MregexReplace48, MGothram))
        MBody74.setSpan(AbsoluteSizeSpan(14, true), start, MBody74.length, exExFlag)
        MBody74.setSpan(StyleSpan(Typeface.BOLD), start, MBody74.length, exExFlag)
        MBody74.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody74.length, exExFlag)

        val MSabathneek11 = SpannableString(" ஸபத்நீக: ")
        MSabathneek11.setSpan(AbsoluteSizeSpan(14, true), start, MSabathneek11.length, exExFlag)
        MSabathneek11.setSpan(StyleSpan(Typeface.BOLD), start, MSabathneek11.length, exExFlag)
        MSabathneek11.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MSabathneek11.length, exExFlag)

        val MBody75A = SpannableString(
            "வ்ருத்தப்ரமாதாமஹ: motherGreatGrandFather சர்மா ஆதித்யரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                    "    த்ருப்யத்வம்     த்ருப்யத்வம்     த்ருப்யத்வம் \n\n"
        )
        val MregexReplace49 = """(motherGreatGrandFather)""".toRegex()
        val MBody75 = SpannableString(MBody75A.replace(MregexReplace49, MGGFNamee))
        MBody75.setSpan(AbsoluteSizeSpan(14, true), start, MBody75.length, exExFlag)
        MBody75.setSpan(StyleSpan(Typeface.BOLD), start, MBody75.length, exExFlag)
        MBody75.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody75.length, exExFlag)

//***************************************************************************************************

        val Comment51 = SpannableString("\nவடக்கு நோக்கி கீழ்வரும் மந்திரங்களை கூறவும்")
        Comment51.setSpan(AbsoluteSizeSpan(13, true), start, Comment51.length, exExFlag)
        Comment51.setSpan(StyleSpan(Typeface.ITALIC), start, Comment51.length, exExFlag)
        Comment51.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment51.length, exExFlag)

        val Body88 =
            SpannableString("\nஓம் அத்ரபிதர: மாதயத்வம் யாதாபாகம் ஆவ்ருஷாயத்வம் அமீமதந்த பிதர: யதாபாகம் ஆவ்ருஷாயிஷத\n\n")
        Body88.setSpan(AbsoluteSizeSpan(14, true), start, Body88.length, exExFlag)
        Body88.setSpan(StyleSpan(Typeface.BOLD), start, Body88.length, exExFlag)
        Body88.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body88.length, exExFlag)

        val GreenComment2 = SpannableString("ஸவ்யம்")
        GreenComment2.setSpan(AbsoluteSizeSpan(14, true), start, GreenComment2.length, exExFlag)
        GreenComment2.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, GreenComment2.length, exExFlag)
        GreenComment2.setSpan(ForegroundColorSpan(Color.GREEN), start, GreenComment2.length, exExFlag)

        val Comment52 =
            SpannableString(" \n  கிழக்கு நோக்கி பித்ருக்களை ப்ரார்த்தனை செய்து கொண்டு கீழ்வரும் மந்திரங்களை கூறவும்")
        Comment52.setSpan(AbsoluteSizeSpan(13, true), start, Comment52.length, exExFlag)
        Comment52.setSpan(StyleSpan(Typeface.ITALIC), start, Comment52.length, exExFlag)
        Comment52.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment52.length, exExFlag)

        val Body89 = SpannableString(
            "\nஓம் நமோவ: பிதர: \nஸூஷ்மாய நமோவ: பிதர: \nதபஸே நமோவ: பிதர: " +
                    "\nயஜ்ஜீவம் தஸ்மை நமோவ: பிதர: \nரஸாய நமோவ: பிதர: \nகோராய மன்யவே ஸ்வதாயைவ: பிதரோ நம:\n"
        )
        Body89.setSpan(AbsoluteSizeSpan(14, true), start, Body89.length, exExFlag)
        Body89.setSpan(StyleSpan(Typeface.BOLD), start, Body89.length, exExFlag)
        Body89.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body89.length, exExFlag)

        val RedComment4 = SpannableString("அபஸவ்யம்\n")
        RedComment4.setSpan(AbsoluteSizeSpan(13, true), start, RedComment4.length, exExFlag)
        RedComment4.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, RedComment4.length, exExFlag)
        RedComment4.setSpan(ForegroundColorSpan(Color.RED), start, RedComment4.length, exExFlag)


        val Comment53 = SpannableString(" \n கட்டதர்பங்களை எடுத்துக்கொண்டு மந்திரம் சொல்லி")
        Comment53.setSpan(AbsoluteSizeSpan(13, true), start, Comment53.length, exExFlag)
        Comment53.setSpan(StyleSpan(Typeface.ITALIC), start, Comment53.length, exExFlag)
        Comment53.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment53.length, exExFlag)

        val Comment54 = SpannableString(" இரண்டு ")
        Comment54.setSpan(AbsoluteSizeSpan(13, true), start, Comment54.length, exExFlag)
        Comment54.setSpan(StyleSpan(Typeface.ITALIC), start, Comment54.length, exExFlag)
        Comment54.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment54.length, exExFlag)

        val Comment55 = SpannableString("கூர்ச்சத்தின் மீது வைக்கவும்")
        Comment55.setSpan(AbsoluteSizeSpan(13, true), start, Comment55.length, exExFlag)
        Comment55.setSpan(StyleSpan(Typeface.ITALIC), start, Comment55.length, exExFlag)
        Comment55.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment55.length, exExFlag)

        val Comment55A = SpannableString("\n(மேல் கூர்ச்சம்)")
        Comment55A.setSpan(AbsoluteSizeSpan(13, true), start, Comment55A.length, exExFlag)
        Comment55A.setSpan(StyleSpan(Typeface.ITALIC), start, Comment55A.length, exExFlag)
        Comment55A.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, Comment55A.length, exExFlag)

        val Body90 = SpannableString(
            "\nஓம் ஏதத்வ: பிதரோவாஸ: க்ருஹான்ன: பிதரோதத்த: உதாயுஷா ஸ்வாயுஷா உத்பர்ஜந்யஸ்ய " +
                    "தாமபி: உதஸ்தாம் அம்ருதாம் அநு\n"
        )
        Body90.setSpan(AbsoluteSizeSpan(14, true), start, Body90.length, exExFlag)
        Body90.setSpan(StyleSpan(Typeface.BOLD), start, Body90.length, exExFlag)
        Body90.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body90.length, exExFlag)

        val Comment55B = SpannableString("\n(கீழ் கூர்ச்சம்)")
        Comment55B.setSpan(AbsoluteSizeSpan(13, true), start, Comment55B.length, exExFlag)
        Comment55B.setSpan(StyleSpan(Typeface.ITALIC), start, Comment55B.length, exExFlag)
        Comment55B.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, Comment55B.length, exExFlag)

        val MBody90 = SpannableString(
            "\nஓம் ஏதத்வ: பிதரோவாஸ: க்ருஹான்ன: பிதரோதத்த: உதாயுஷா ஸ்வாயுஷா உத்பர்ஜந்யஸ்ய " +
                    "தாமபி: உதஸ்தாம் அம்ருதாம் அநு\n"
        )
        MBody90.setSpan(AbsoluteSizeSpan(14, true), start, MBody90.length, exExFlag)
        MBody90.setSpan(StyleSpan(Typeface.BOLD), start, MBody90.length, exExFlag)
        MBody90.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody90.length, exExFlag)

        val Comment55C = SpannableString("\n (மேல்கூர்ச்சத்திற்கு")
        Comment55C.setSpan(AbsoluteSizeSpan(13, true), start, Comment55C.length, exExFlag)
        Comment55C.setSpan(StyleSpan(Typeface.ITALIC), start, Comment55C.length, exExFlag)
        Comment55C.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, Comment55C.length, exExFlag)

        val Comment56 = SpannableString("\n கீழ் வரும் மந்திரம் கூறி எள்ளை")
        Comment56.setSpan(AbsoluteSizeSpan(13, true), start, Comment56.length, exExFlag)
        Comment56.setSpan(StyleSpan(Typeface.ITALIC), start, Comment56.length, exExFlag)
        Comment56.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment56.length, exExFlag)

        val Comment56A = SpannableString("\n கீழ் வரும் மந்திரம் கூறி எள்ளும்")
        Comment56A.setSpan(AbsoluteSizeSpan(13, true), start, Comment56A.length, exExFlag)
        Comment56A.setSpan(StyleSpan(Typeface.ITALIC), start, Comment56A.length, exExFlag)
        Comment56A.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment56A.length, exExFlag)

        val Comment57 = SpannableString("\n கீழ் வரும் மந்திரம் கூறி எள்ளும், சிறிது அரிசியையும்")
        Comment57.setSpan(AbsoluteSizeSpan(13, true), start, Comment57.length, exExFlag)
        Comment57.setSpan(StyleSpan(Typeface.ITALIC), start, Comment57.length, exExFlag)
        Comment57.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment57.length, exExFlag)

        val Comment57A = SpannableString("\n கீழ் வரும் மந்திரம் கூறி எள்ளும், சிறிது அரிசியையும்")
        Comment57A.setSpan(AbsoluteSizeSpan(13, true), start, Comment57A.length, exExFlag)
        Comment57A.setSpan(StyleSpan(Typeface.ITALIC), start, Comment57A.length, exExFlag)
        Comment57A.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment57A.length, exExFlag)

        val Comment57B = SpannableString("\nஇரண்டு கூர்ச்சத்திற்கும் எள்ளும், சிறிது அரிசியையும்")
        Comment57B.setSpan(AbsoluteSizeSpan(13, true), start, Comment57B.length, exExFlag)
        Comment57B.setSpan(StyleSpan(Typeface.ITALIC), start, Comment57B.length, exExFlag)
        Comment57B.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment57B.length, exExFlag)

        val Comment58 = SpannableString(" ஜலமும் விடவும்")
        Comment58.setSpan(AbsoluteSizeSpan(13, true), start, Comment58.length, exExFlag)
        Comment58.setSpan(StyleSpan(Typeface.ITALIC), start, Comment58.length, exExFlag)
        Comment58.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment58.length, exExFlag)

        val Comment58A = SpannableString(" ஜலமும் விடவும்")
        Comment58A.setSpan(AbsoluteSizeSpan(13, true), start, Comment58A.length, exExFlag)
        Comment58A.setSpan(StyleSpan(Typeface.ITALIC), start, Comment58A.length, exExFlag)
        Comment58A.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment58A.length, exExFlag)

        val Comment58B = SpannableString(" ஜலமும் விடவும்")
        Comment58B.setSpan(AbsoluteSizeSpan(13, true), start, Comment58B.length, exExFlag)
        Comment58B.setSpan(StyleSpan(Typeface.ITALIC), start, Comment58B.length, exExFlag)
        Comment58B.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment58B.length, exExFlag)

        val Body91 = SpannableString(
            "\nஓம் ஊர்ஜம்வஹந்தீ: அம்ருதம்க்ருதம்பய: கீலாலம் பரிஸ்ருதம் ஸ்வதாஸ்த தர்ப்பயதமே பித்ரூன்" +
                    "\nத்ருப்யத்வம்     த்ருப்யத்வம்     த்ருப்யத்வம்\n"
        )
        Body91.setSpan(AbsoluteSizeSpan(14, true), start, Body91.length, exExFlag)
        Body91.setSpan(StyleSpan(Typeface.BOLD), start, Body91.length, exExFlag)
        Body91.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body91.length, exExFlag)

        val Comment55D = SpannableString("\n கீழ்கூர்ச்சத்திற்கு")
        Comment55D.setSpan(AbsoluteSizeSpan(13, true), start, Comment55D.length, exExFlag)
        Comment55D.setSpan(StyleSpan(Typeface.ITALIC), start, Comment55D.length, exExFlag)
        Comment55D.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, Comment55D.length, exExFlag)

        val MBody91 = SpannableString(
            "\nஓம் ஊர்ஜம்வஹந்தீ: அம்ருதம்க்ருதம்பய: கீலாலம் பரிஸ்ருதம் ஸ்வதாஸ்த தர்ப்பயதமே பித்ரூன்" +
                    "\nத்ருப்யத்வம்     த்ருப்யத்வம்     த்ருப்யத்வம்\n"
        )
        MBody91.setSpan(AbsoluteSizeSpan(14, true), start, MBody91.length, exExFlag)
        MBody91.setSpan(StyleSpan(Typeface.BOLD), start, MBody91.length, exExFlag)
        MBody91.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody91.length, exExFlag)

        val Comment55E = SpannableString("\n இரண்டு கூர்ச்சத்திற்கும் எள்ளை")
        Comment55E.setSpan(AbsoluteSizeSpan(13, true), start, Comment55E.length, exExFlag)
        Comment55E.setSpan(StyleSpan(Typeface.ITALIC), start, Comment55E.length, exExFlag)
        Comment55E.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment55E.length, exExFlag)

        val MBody91A = SpannableString(
            "\n\nஆப்ரம்ஹ ஸ்தம்ப பர்யந்தம் தேவரிஷி பித்ருமானவா: த்ருப்யந்து பிதர: ஸர்வே மாத்ரு மாதாமஹாதய: " +
                    "அதீதகுல கோடீநாம் ஸப்தத்வீப நிவாஸிநாம் ஆப்ரம்ஹ புவனாந் லோகான் \nஇதமஸ்து திலோதகம் \n    இதமஸ்து திலோதகம் " +
                    "\n     இதமஸ்து திலோதகம்\n"
        )
        MBody91A.setSpan(AbsoluteSizeSpan(14, true), start, MBody91A.length, exExFlag)
        MBody91A.setSpan(StyleSpan(Typeface.BOLD), start, MBody91A.length, exExFlag)
        MBody91A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody91A.length, exExFlag)

        val GreenComment3 = SpannableString("ஸவ்யம் ")
        GreenComment3.setSpan(AbsoluteSizeSpan(14, true), start, GreenComment3.length, exExFlag)
        GreenComment3.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, GreenComment3.length, exExFlag)
        GreenComment3.setSpan(ForegroundColorSpan(Color.GREEN), start, GreenComment3.length, exExFlag)

        val Body92 =
            SpannableString("\nமமோ பார்த்த சமஸ்த துரித க்ஷயத்வாரா ஸ்ரீ பரமேஸ்வர ப்ரீத்யர்த்தம்\nவாஜே வாஜே அவத இதி மந்த்ரேன\n")
        Body92.setSpan(AbsoluteSizeSpan(14, true), start, Body92.length, exExFlag)
        Body92.setSpan(StyleSpan(Typeface.BOLD), start, Body92.length, exExFlag)
        Body92.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body92.length, exExFlag)

        val VARGAI1A = SpannableString(" வர்கைக ")
        VARGAI1A.setSpan(AbsoluteSizeSpan(14, true), start, VARGAI1A.length, exExFlag)
        VARGAI1A.setSpan(StyleSpan(Typeface.BOLD), start, VARGAI1A.length, exExFlag)
        VARGAI1A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, VARGAI1A.length, exExFlag)

        val VARGAI1B = SpannableString(" வர்கத்வய ")
        VARGAI1B.setSpan(AbsoluteSizeSpan(14, true), start, VARGAI1B.length, exExFlag)
        VARGAI1B.setSpan(StyleSpan(Typeface.BOLD), start, VARGAI1B.length, exExFlag)
        VARGAI1B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, VARGAI1B.length, exExFlag)

        val Body93 = SpannableString(" பித்ரு விசர்ஜனம் கரிஷ்யே  \nஅபஉபஸ்ய்ருஸ்ய")
        Body93.setSpan(AbsoluteSizeSpan(14, true), start, Body93.length, exExFlag)
        Body93.setSpan(StyleSpan(Typeface.BOLD), start, Body93.length, exExFlag)
        Body93.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body93.length, exExFlag)

        val Comment59 = SpannableString(" \nஎன்று ஜலத்தை தொடவும்\n\nநெற்றியில் கை வைத்துக் கொண்டு: ")
        Comment59.setSpan(AbsoluteSizeSpan(13, true), start, Comment59.length, exExFlag)
        Comment59.setSpan(StyleSpan(Typeface.ITALIC), start, Comment59.length, exExFlag)
        Comment59.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment59.length, exExFlag)

        val Body94 = SpannableString("வாஜே வாஜே அவத இத்யஸ்ய மந்த்ரஸ்ய  வஸிஷ்டரிஷி:")
        Body94.setSpan(AbsoluteSizeSpan(14, true), start, Body94.length, exExFlag)
        Body94.setSpan(StyleSpan(Typeface.BOLD), start, Body94.length, exExFlag)
        Body94.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body94.length, exExFlag)

        val Comment60 = SpannableString("\nமூக்கு நுனியை தொட்டுக்கொண்டு: ")
        Comment60.setSpan(AbsoluteSizeSpan(13, true), start, Comment60.length, exExFlag)
        Comment60.setSpan(StyleSpan(Typeface.ITALIC), start, Comment60.length, exExFlag)
        Comment60.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment60.length, exExFlag)

        val Body95 = SpannableString("த்ருஷ்டுப்சந்த:")
        Body95.setSpan(AbsoluteSizeSpan(14, true), start, Body95.length, exExFlag)
        Body95.setSpan(StyleSpan(Typeface.BOLD), start, Body95.length, exExFlag)
        Body95.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body95.length, exExFlag)

        val Comment61 = SpannableString("\nஹிருதயத்தைத் தொட்டுக்கொண்டு: ")
        Comment61.setSpan(AbsoluteSizeSpan(13, true), start, Comment61.length, exExFlag)
        Comment61.setSpan(StyleSpan(Typeface.ITALIC), start, Comment61.length, exExFlag)
        Comment61.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment61.length, exExFlag)

        val Body96 = SpannableString("வாஜிநோ தேவதா ஆவாஹித")
        Body96.setSpan(AbsoluteSizeSpan(14, true), start, Body96.length, exExFlag)
        Body96.setSpan(StyleSpan(Typeface.BOLD), start, Body96.length, exExFlag)
        Body96.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body96.length, exExFlag)

        val VARGAI2A = SpannableString(" வர்கைக ")
        VARGAI2A.setSpan(AbsoluteSizeSpan(14, true), start, VARGAI2A.length, exExFlag)
        VARGAI2A.setSpan(StyleSpan(Typeface.BOLD), start, VARGAI2A.length, exExFlag)
        VARGAI2A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, VARGAI2A.length, exExFlag)

        val VARGAI2B = SpannableString(" வர்கத்வய ")
        VARGAI2B.setSpan(AbsoluteSizeSpan(14, true), start, VARGAI2B.length, exExFlag)
        VARGAI2B.setSpan(StyleSpan(Typeface.BOLD), start, VARGAI2B.length, exExFlag)
        VARGAI2B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, VARGAI2B.length, exExFlag)

        val Body97 = SpannableString("பித்ரு விஸர்ஜனே வினியோக:")
        Body97.setSpan(AbsoluteSizeSpan(14, true), start, Body97.length, exExFlag)
        Body97.setSpan(StyleSpan(Typeface.BOLD), start, Body97.length, exExFlag)
        Body97.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body97.length, exExFlag)

        val Comment62 = SpannableString(" \nஎன்று கைகளை உள்வாங்கவும்\n")
        Comment62.setSpan(AbsoluteSizeSpan(13, true), start, Comment62.length, exExFlag)
        Comment62.setSpan(StyleSpan(Typeface.ITALIC), start, Comment62.length, exExFlag)
        Comment62.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment62.length, exExFlag)

        val Heading6 = SpannableString("\nவிஸர்ஜனம்\n")
        Heading6.setSpan(AbsoluteSizeSpan(16, true), start, Heading6.length, exExFlag)
        Heading6.setSpan(StyleSpan(Typeface.BOLD), start, Heading6.length, exExFlag)
        Heading6.setSpan(UnderlineSpan(), start, Heading6.length, exExFlag)
        Heading6.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, Heading6.length, exExFlag)

        val RedComment5 = SpannableString("அபஸவ்யம்")
        RedComment5.setSpan(AbsoluteSizeSpan(13, true), start, RedComment5.length, exExFlag)
        RedComment5.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, RedComment5.length, exExFlag)
        RedComment5.setSpan(ForegroundColorSpan(Color.RED), start, RedComment5.length, exExFlag)

        val Comment63 = SpannableString("\nகீழ் வரும் மந்திரம் கூறி எள்ளை")
        Comment63.setSpan(AbsoluteSizeSpan(13, true), start, Comment63.length, exExFlag)
        Comment63.setSpan(StyleSpan(Typeface.ITALIC), start, Comment63.length, exExFlag)
        Comment63.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment63.length, exExFlag)

        val Comment64 = SpannableString("\nகீழ் வரும் மந்திரம் கூறி எள்ளும், சிறிது அரிசியையும்")
        Comment64.setSpan(AbsoluteSizeSpan(13, true), start, Comment64.length, exExFlag)
        Comment64.setSpan(StyleSpan(Typeface.ITALIC), start, Comment64.length, exExFlag)
        Comment64.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment64.length, exExFlag)

        val MComment64 = SpannableString("\nகீழ் வரும் மந்திரம் கூறி எள்ளும், சிறிது அரிசியையும் கூர்ச்சத்தில் ")
        MComment64.setSpan(AbsoluteSizeSpan(13, true), start, MComment64.length, exExFlag)
        MComment64.setSpan(StyleSpan(Typeface.ITALIC), start, MComment64.length, exExFlag)
        MComment64.setSpan(ForegroundColorSpan(Color.DKGRAY), start, MComment64.length, exExFlag)

        val Comment65 = SpannableString("போடவும்")
        Comment65.setSpan(AbsoluteSizeSpan(13, true), start, Comment65.length, exExFlag)
        Comment65.setSpan(StyleSpan(Typeface.ITALIC), start, Comment65.length, exExFlag)
        Comment65.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment65.length, exExFlag)

        val Body98 = SpannableString("\nஓம் உத்திஷ்டந்து அஸ்மத் ")
        Body98.setSpan(AbsoluteSizeSpan(14, true), start, Body98.length, exExFlag)
        Body98.setSpan(StyleSpan(Typeface.BOLD), start, Body98.length, exExFlag)
        Body98.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body98.length, exExFlag)

        val Sabathneek13 = SpannableString(" ஸபத்நீக:")
        Sabathneek13.setSpan(AbsoluteSizeSpan(14, true), start, Sabathneek13.length, exExFlag)
        Sabathneek13.setSpan(StyleSpan(Typeface.BOLD), start, Sabathneek13.length, exExFlag)
        Sabathneek13.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Sabathneek13.length, exExFlag)

        val Body99A = SpannableString(" பித்ரு பிதாமஹ ப்ரபிதாமஹ:")
        Body99A.setSpan(AbsoluteSizeSpan(14, true), start, Body99A.length, exExFlag)
        Body99A.setSpan(StyleSpan(Typeface.BOLD), start, Body99A.length, exExFlag)
        Body99A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body99A.length, exExFlag)

        val Body99B = SpannableString(" பித்ரு ப்ரபிதாமஹ: வ்ருத்தப்ரபிதாமஹ:")
        Body99B.setSpan(AbsoluteSizeSpan(14, true), start, Body99B.length, exExFlag)
        Body99B.setSpan(StyleSpan(Typeface.BOLD), start, Body99B.length, exExFlag)
        Body99B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body99B.length, exExFlag)

        val MComment64A = SpannableString("\n கீழ் கூர்ச்சத்தில் ")
        MComment64A.setSpan(AbsoluteSizeSpan(13, true), start, MComment64A.length, exExFlag)
        MComment64A.setSpan(StyleSpan(Typeface.ITALIC), start, MComment64A.length, exExFlag)
        MComment64A.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, MComment64A.length, exExFlag)

        val MBody98 = SpannableString("\nஓம் உத்திஷ்டந்து அஸ்மத் ")
        MBody98.setSpan(AbsoluteSizeSpan(14, true), start, MBody98.length, exExFlag)
        MBody98.setSpan(StyleSpan(Typeface.BOLD), start, MBody98.length, exExFlag)
        MBody98.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody98.length, exExFlag)

        val Sabathneek13A = SpannableString(" ஸபத்நீக:")
        Sabathneek13A.setSpan(AbsoluteSizeSpan(14, true), start, Sabathneek13A.length, exExFlag)
        Sabathneek13A.setSpan(StyleSpan(Typeface.BOLD), start, Sabathneek13A.length, exExFlag)
        Sabathneek13A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Sabathneek13A.length, exExFlag)

        val MBody98A = SpannableString("\nமாதாமஹ ப்ரமாதாமஹ வ்ருத்தப்ரமாதாமஹா:")
        MBody98A.setSpan(AbsoluteSizeSpan(14, true), start, MBody98A.length, exExFlag)
        MBody98A.setSpan(StyleSpan(Typeface.BOLD), start, MBody98A.length, exExFlag)
        MBody98A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody98A.length, exExFlag)


        val Comment66 = SpannableString("\nகீழ்வரும் மந்திரங்களை சொல்லி கட்டை தர்பத்தை கூர்ச்ச(ம்)ங்களின் மேல் வைத்து தொட்டுக் கொண்டு")
        Comment66.setSpan(AbsoluteSizeSpan(13, true), start, Comment66.length, exExFlag)
        Comment66.setSpan(StyleSpan(Typeface.ITALIC), start, Comment66.length, exExFlag)
        Comment66.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment66.length, exExFlag)

        val Body100 = SpannableString("ஓம் வாஜே வாஜே அவதவாஜிந: நோதனேஷூ விப்ரா: அம்ருதா: ருதக்ஞா: அஸ்யமத்வ: பிபத " +
                    "மாதயத்வம் த்ருப்தாயாத பதிபி: தேவயானை:")
        Body100.setSpan(AbsoluteSizeSpan(14, true), start, Body100.length, exExFlag)
        Body100.setSpan(StyleSpan(Typeface.BOLD), start, Body100.length, exExFlag)
        Body100.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body100.length, exExFlag)

        val Comment67 = SpannableString("\nஎழுந்து ")
        Comment67.setSpan(AbsoluteSizeSpan(13, true), start, Comment67.length, exExFlag)
        Comment67.setSpan(StyleSpan(Typeface.ITALIC), start, Comment67.length, exExFlag)
        Comment67.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment67.length, exExFlag)

        val GreenComment4 = SpannableString("ஸவ்யம்")
        GreenComment4.setSpan(AbsoluteSizeSpan(14, true), start, GreenComment4.length, exExFlag)
        GreenComment4.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, GreenComment4.length, exExFlag)
        GreenComment4.setSpan(ForegroundColorSpan(Color.GREEN), start, GreenComment4.length, exExFlag)

        val Comment68 = SpannableString(" செய்து கொண்டு கீழ்வரும் மந்திரங்களை கூறி மூன்று ப்ரதட்சனம் செய்யவும்")
        Comment68.setSpan(AbsoluteSizeSpan(13, true), start, Comment68.length, exExFlag)
        Comment68.setSpan(StyleSpan(Typeface.ITALIC), start, Comment68.length, exExFlag)
        Comment68.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment68.length, exExFlag)

        val Body101 = SpannableString("\nஓம் ஆமாவாஜஸ்ய ப்ரஸவ: ஜகம்யாத் ஏமே த்யாவா ப்ருதிவீ விஸ்வருபே ஆமாகந்தம் பிதரா " +
                    "மாதரா யுவம் ஆமாஸோம: அம்ருதத்வாய கம்யாத்\n" +
                    "    \nஓம் தேவதாப்ய: பித்ருப்யச்ச மஹாயோகிப்ய: ஏவச நமஸ்வதாயை ஸ்வாஹாயை நித்யமேவ நமோநம:")
        Body101.setSpan(AbsoluteSizeSpan(14, true), start, Body101.length, exExFlag)
        Body101.setSpan(StyleSpan(Typeface.BOLD), start, Body101.length, exExFlag)
        Body101.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body101.length, exExFlag)

        val Comment69 = SpannableString(" \nஎன்று நமஸ்கரிக்கவும்")
        Comment69.setSpan(AbsoluteSizeSpan(13, true), start, Comment69.length, exExFlag)
        Comment69.setSpan(StyleSpan(Typeface.ITALIC), start, Comment69.length, exExFlag)
        Comment69.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment69.length, exExFlag)

        val Body102AAA = SpannableString("\nஅபிவாதயே yourPravaras ப்ரவரான்வித: yourGothram கோத்ர:  காத்யாயன ஸூத்ர: " +
                    "ஸ்ரீஶுக்ல யஜூர் வேத காண்வஶாகாத்யாயீ ஸ்ரீ yourName ஶர்மா நாமாஹம் அஸ்மி போ:")
        val regexReplace65 = """(yourPravaras)""".toRegex()
        val Body102AA = SpannableString(Body102AAA.replace(regexReplace65, urPravaras))
        val regexReplace66 = """(yourGothram)""".toRegex()
        val Body102A = SpannableString(Body102AA.replace(regexReplace66, urGothram))
        val regexReplace67 = """(yourName)""".toRegex()
        val Body102 = SpannableString(Body102A.replace(regexReplace67, yrNamee))
        Body102.setSpan(AbsoluteSizeSpan(14, true), start, Body102.length, exExFlag)
        Body102.setSpan(StyleSpan(Typeface.BOLD), start, Body102.length, exExFlag)
        Body102.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body102.length, exExFlag)

        val Comment70 = SpannableString(" \nஉட்கார்ந்து கொண்டு\n")
        Comment70.setSpan(AbsoluteSizeSpan(13, true), start, Comment70.length, exExFlag)
        Comment70.setSpan(StyleSpan(Typeface.ITALIC), start, Comment70.length, exExFlag)
        Comment70.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment70.length, exExFlag)

        val Body103A = SpannableString("\nமயாக்ருதமிதம் Thithi புண்யகால ப்ரயுக்த அஸ்மது")
        val regexReplace68 = """(Thithi)""".toRegex()
        val Body103 = SpannableString(Body103A.replace(regexReplace68, todThithi))
        Body103.setSpan(AbsoluteSizeSpan(14, true), start, Body103.length, exExFlag)
        Body103.setSpan(StyleSpan(Typeface.BOLD), start, Body103.length, exExFlag)
        Body103.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body103.length, exExFlag)

        val VARGAI3A = SpannableString(" வர்கைக ")
        VARGAI3A.setSpan(AbsoluteSizeSpan(14, true), start, VARGAI3A.length, exExFlag)
        VARGAI3A.setSpan(StyleSpan(Typeface.BOLD), start, VARGAI3A.length, exExFlag)
        VARGAI3A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, VARGAI3A.length, exExFlag)

        val VARGAI3B = SpannableString(" வர்கத்வய ")
        VARGAI3B.setSpan(AbsoluteSizeSpan(14, true), start, VARGAI3B.length, exExFlag)
        VARGAI3B.setSpan(StyleSpan(Typeface.BOLD), start, VARGAI3B.length, exExFlag)
        VARGAI3B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, VARGAI3B.length, exExFlag)

        val Body104 = SpannableString("பித்ரூன் உத்திச்ய திலதர்ப்பணாக்யம் கர்ம ஸர்வம் \nஸ்ரீ கிருஷ்ணார்ப்பணமஸ்து " +
                    "\nஸ்ரீ வாஸூதேவார்ப்பணமஸ்து \nதத்ஸது ப்ரும்மார்ப்பணமஸ்து")
        Body104.setSpan(AbsoluteSizeSpan(14, true), start, Body104.length, exExFlag)
        Body104.setSpan(StyleSpan(Typeface.BOLD), start, Body104.length, exExFlag)
        Body104.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body104.length, exExFlag)

        val Comment71 = SpannableString(" \nஎன்று நேராக வலது கையால் ஜலம் விடவும்\n")
        Comment71.setSpan(AbsoluteSizeSpan(13, true), start, Comment71.length, exExFlag)
        Comment71.setSpan(StyleSpan(Typeface.ITALIC), start, Comment71.length, exExFlag)
        Comment71.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment71.length, exExFlag)

        val Body105 = SpannableString("\nகாயேனவாசா மனஸேந்த்ரியைர்வா புத்யாத்மனாவா ப்ரக்ருதே: ஸ்வபாவாத் கரோமியத்யத் " +
                    "ஸகலம் பரஸ்மை நாராயணாயேதி ஸமர்ப்பயாமி\nஸ்ரீமந் நாராயண ஸ்ரீ \nநாராயண நாராயண நாராயண நாராயண நாராயண நாராயண " +
                    "நாராயண நாராயண நாராயண நாராயண நாராயண \n\nப்ராயச்சித்தாநி அசேஷாணி தப: கர்ம ஆத்மகாநிவை யாநி தேஷாம் அசேஷாணாம் " +
                    "க்ருஷ்ணானுஸ்மரணம் பரம்\nஸ்ரீகிருஷ்ண ஸ்ரீகிருஷ்ண ஸ்ரீகிருஷ்ண ஸ்ரீகிருஷ்ண ஸ்ரீகிருஷ்ண ஸ்ரீகிருஷ்ண ஸ்ரீகிருஷ்ண ஸ்ரீ ிருஷ்ண " +
                    "ஸ்ரீகிருஷ்ண ஸ்ரீகிருஷ்ண ஸ்ரீகிருஷ்ண ஸ்ரீகிருஷ்ண")
        Body105.setSpan(AbsoluteSizeSpan(14, true), start, Body105.length, exExFlag)
        Body105.setSpan(StyleSpan(Typeface.BOLD), start, Body105.length, exExFlag)
        Body105.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body105.length, exExFlag)

        val RedComment6 = SpannableString("\n\nஅபஸவ்யம்")
        RedComment6.setSpan(AbsoluteSizeSpan(13, true), start, RedComment6.length, exExFlag)
        RedComment6.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, RedComment6.length, exExFlag)
        RedComment6.setSpan(ForegroundColorSpan(Color.RED), start, RedComment6.length, exExFlag)

        val Comment72 = SpannableString(" செய்து கொண்டு\n")
        Comment72.setSpan(AbsoluteSizeSpan(13, true), start, Comment72.length, exExFlag)
        Comment72.setSpan(StyleSpan(Typeface.ITALIC), start, Comment72.length, exExFlag)
        Comment72.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment72.length, exExFlag)

        val Comment73 = SpannableString(" இரண்டு ")
        Comment73.setSpan(AbsoluteSizeSpan(13, true), start, Comment73.length, exExFlag)
        Comment73.setSpan(StyleSpan(Typeface.ITALIC), start, Comment73.length, exExFlag)
        Comment73.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment73.length, exExFlag)

        val Comment74 = SpannableString("கூர்ச்சங்களை பிரித்து தெற்கு நுனியாக வைத்துக் கொண்டு, மீதி எல்லா எள்ளையும்")
        Comment74.setSpan(AbsoluteSizeSpan(13, true), start, Comment74.length, exExFlag)
        Comment74.setSpan(StyleSpan(Typeface.ITALIC), start, Comment74.length, exExFlag)
        Comment74.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment74.length, exExFlag)

        val Comment75 = SpannableString("கூர்ச்சங்களை பிரித்து தெற்கு நுனியாக வைத்துக் கொண்டு, மீதி எல்லா எள்ளையும், அரிசியையும்")
        Comment75.setSpan(AbsoluteSizeSpan(13, true), start, Comment75.length, exExFlag)
        Comment75.setSpan(StyleSpan(Typeface.ITALIC), start, Comment75.length, exExFlag)
        Comment75.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment75.length, exExFlag)

        val Comment76 = SpannableString(" கையில் சேர்த்து ஜலம் விட்டபடியே பூமியில் போடவும்")
        Comment76.setSpan(AbsoluteSizeSpan(13, true), start, Comment76.length, exExFlag)
        Comment76.setSpan(StyleSpan(Typeface.ITALIC), start, Comment76.length, exExFlag)
        Comment76.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment76.length, exExFlag)

        val Body106 = SpannableString("\nயேஷாம் நமாதா")
        Body106.setSpan(AbsoluteSizeSpan(14, true), start, Body106.length, exExFlag)
        Body106.setSpan(StyleSpan(Typeface.BOLD), start, Body106.length, exExFlag)
        Body106.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body106.length, exExFlag)

        val Body107Big = SpannableString(" நபிதா ")
        Body107Big.setSpan(AbsoluteSizeSpan(20, true), start, Body107Big.length, exExFlag)
        Body107Big.setSpan(StyleSpan(Typeface.BOLD), start, Body107Big.length, exExFlag)
        Body107Big.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body107Big.length, exExFlag)

        val Body108 = SpannableString("நப்ராதா: நாந்யகோத்ரிண: தேஸர்வே த்ருப்திமாயாந்து மயோத்ஸ்ருஷ்டை: குசோதகை:\n" +
                    " த்ருப்யத்வம்  த்ருப்யத்வம்  த்ருப்யத்வம்")
        Body108.setSpan(AbsoluteSizeSpan(14, true), start, Body108.length, exExFlag)
        Body108.setSpan(StyleSpan(Typeface.BOLD), start, Body108.length, exExFlag)
        Body108.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body108.length, exExFlag)

        val GreenComment5 = SpannableString("\nஸவ்யம்")
        GreenComment5.setSpan(AbsoluteSizeSpan(14, true), start, GreenComment5.length, exExFlag)
        GreenComment5.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, GreenComment5.length, exExFlag)
        GreenComment5.setSpan(ForegroundColorSpan(Color.GREEN), start, GreenComment5.length, exExFlag)

        val Comment77 = SpannableString("\nஎன்று சொல்லி பவித்ரத்தை அவிழ்த்து போடவும்\n\nஆசமனம் செய்து வீபூதி இட்டுக் " +
                    "கொண்டு மறுபடி ஆசமனம் செய்யவும்")
        Comment77.setSpan(AbsoluteSizeSpan(13, true), start, Comment77.length, exExFlag)
        Comment77.setSpan(StyleSpan(Typeface.ITALIC), start, Comment77.length, exExFlag)
        Comment77.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment77.length, exExFlag)

        val Heading7 = SpannableString("\nமுற்றும்\n")
        Heading7.setSpan(AbsoluteSizeSpan(16, true), start, Heading7.length, exExFlag)
        Heading7.setSpan(StyleSpan(Typeface.BOLD), start, Heading7.length, exExFlag)
        Heading7.setSpan(UnderlineSpan(), start, Heading7.length, exExFlag)
        Heading7.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, Heading7.length, exExFlag)


        val Amava_combination = SpannableStringBuilder()

        Amava_combination.append(heading, Heading1, Comment1, Body1, Comment2, Body2, Comment3, Body3, Comment4, Body4, Comment5,
            Body5, Comment6, Body6, Comment7, Body7, Comment8, Body8, Comment9, Body9, Comment10, Body10, Comment11, Body11,
            Comment12, Body12, Comment13, Body13, Comment14, Body14)
        if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { Amava_combination.append(Comment15B) }else Amava_combination.append(Comment15A)
        Amava_combination.append(Comment15C, Body15, Comment16, Body16, Comment17)
        Amava_combination.append(Heading2, Body17, Comment18, Body18, Comment19, Body19, Comment20, Body20, Comment21, Body21)
        Amava_combination.append(Comment22, Body22, Comment23, Body23, Comment24, Body24, Comment25, Body25, Comment26, Body26,
            Comment27, Body27, Comment28, Body28, Comment29, Body29, Comment30, Body30, Comment31, Body31, Comment32,
            Body32, Comment33, Body33, Comment34, Body34, Comment35, Body35, Comment36, Body36, Comment37, Body37)
        Amava_combination.append(Comment38A, RedComment1, Comment38B, Body38)
        if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(Sabathneek1) }
        Amava_combination.append(Body39)
        if (yrGFatherLive == "Deceased") { Amava_combination.append(Body39B, Body40, Body41) } else { Amava_combination.append(Body39A, Body40, Body41B) }
        Amava_combination.append(Body42)


        if (MFatherLive == "Living") {
            Amava_combination.append(Body43, Body44, Body45, Comment39, GreenComment1, Comment40, Comment41, RedComment2, Comment41A)
            if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { Amava_combination.append(Comment41C) }else Amava_combination.append(Comment41B)
            Amava_combination.append(Comment41D, Heading3, Comment42, RedComment3, Comment42A, Comment42B, Body46)
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(Sabathneek2) }
            Amava_combination.append(Body47)
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body48B, Body49, Body50) } else { Amava_combination.append(Body48A, Body49, Body51B) }
            Amava_combination.append(Body52)
            if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { Amava_combination.append(Comment44) }else Amava_combination.append(Comment43)
            Amava_combination.append(Comment45)
            Amava_combination.append(Heading4, Comment46, Body53)
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(Sabathneek3) }
            Amava_combination.append(Body54)
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body56, Body57, Body58) } else { Amava_combination.append(Body55, Body57, Body59B) }
            Amava_combination.append(Body60, Comment47, Body61)
            if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { Amava_combination.append(Comment49) }else Amava_combination.append(Comment48)
            Amava_combination.append(Comment50)
            Amava_combination.append(Heading5, Body62)
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(Sabathneek4) }
            Amava_combination.append(Body63, Body64)
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(Sabathneek5) }
            Amava_combination.append(Body65, Body66)
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(Sabathneek6) }
            Amava_combination.append(Body67, Body68)
            Amava_combination.append(Body69)
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(Sabathneek7) }
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body70A) } else { Amava_combination.append(Body70B) }
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body71) } else { Amava_combination.append(Body72) }
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(Sabathneek8) }
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body73A) } else { Amava_combination.append(Body73B) }
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body74) } else { Amava_combination.append(Body75) }
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(Sabathneek9) }
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body76A) } else { Amava_combination.append(Body76B) }
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body77) } else { Amava_combination.append(Body78) }
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(Sabathneek10) }
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body79A) } else { Amava_combination.append(Body79B) }
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body80) } else { Amava_combination.append(Body81) }
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(Sabathneek11) }
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body82A) } else { Amava_combination.append(Body82B) }
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body83) } else { Amava_combination.append(Body84) }
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(Sabathneek12) }
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body85A) } else { Amava_combination.append(Body85B) }
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body86) } else { Amava_combination.append(Body87) }
            Amava_combination.append(Comment51, Body88, GreenComment2, Comment52, Body89, RedComment4, Comment53)
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Comment54) }
            Amava_combination.append(Comment55, Body90, Comment56, Comment57, Comment58, Body91, GreenComment3, Body92)
            if (MFatherLive == "Deceased") { Amava_combination.append(VARGAI1B) } else { Amava_combination.append(VARGAI1A) }
            Amava_combination.append(Body93, Comment59, Body94, Comment60, Body95, Comment61, Body96)
            if (MFatherLive == "Deceased") { Amava_combination.append(VARGAI2B) } else { Amava_combination.append(VARGAI2A) }
            Amava_combination.append(Body97, Comment62)
            Amava_combination.append(Heading6, RedComment5)
            if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { Amava_combination.append(Comment64) }else Amava_combination.append(Comment63)
            Amava_combination.append(Comment65, Body98)
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(Sabathneek13) }
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body99A) } else { Amava_combination.append(Body99B) }
            Amava_combination.append(Comment66, Body100, Comment67, GreenComment4, Comment68, Body101, Comment69, Body102, Comment70, Body103)
            if (MFatherLive == "Deceased") { Amava_combination.append(VARGAI3B) } else { Amava_combination.append(VARGAI3A) }
            Amava_combination.append(Body104, Comment71, Body105, RedComment6, Comment72)
            if (MFatherLive == "Deceased") { Amava_combination.append(Comment73) }
            if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { Amava_combination.append(Comment75) }else Amava_combination.append(Comment74)
            Amava_combination.append(Comment76, Body106, Body107Big, Body108, GreenComment5, Comment77, Heading7)

        } else {

            Amava_combination.append(MBody38)
            if (motherLive == "Deceased" && motherMotherLive == "Deceased") { Amava_combination.append(MSabathneek1) }
            Amava_combination.append(MBody41B, MBody44, Body45, Comment39, GreenComment1, Comment40, MComment40, Comment41, RedComment2, Comment41A)
            if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { Amava_combination.append(Comment41C) }else Amava_combination.append(Comment41B)
            Amava_combination.append(Comment41D, Heading3, Comment42, RedComment3, Comment42A, MComment42A, Comment42B, MComment42D, Body46)
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(Sabathneek2) }
            Amava_combination.append(Body47)
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body48B, Body49, Body50) } else { Amava_combination.append(Body48A, Body49, Body51B) }
            Amava_combination.append(Body52)
            if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { Amava_combination.append(Comment44) }else Amava_combination.append(Comment43)
            Amava_combination.append(Comment45)
            Amava_combination.append(Heading4, Comment46, Body53)
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(Sabathneek3) }
            Amava_combination.append(Body54)
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body56, Body57, Body58) } else { Amava_combination.append(Body55, Body57, Body59B) }
            Amava_combination.append(Body60, Comment47, Body61)
            if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { Amava_combination.append(Comment49) }else Amava_combination.append(Comment48)
            Amava_combination.append(Comment50, MSComment42A, MSEComment42A, MComment42B, MComment42C, MBody46)
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(MSabathneek2) }
            Amava_combination.append(MBody51B)
            if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { Amava_combination.append(Comment44x) }else Amava_combination.append(Comment43x)
            Amava_combination.append(Comment45x)
            Amava_combination.append(MHeading4, MComment46A, MBody53)
            if (motherMotherLive == "Deceased" && MFatherLive == "Deceased") { Amava_combination.append(MSabathneek3) }
            Amava_combination.append(MBody51C, MComment46x, MBody61)
            if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { Amava_combination.append(Comment49x) }else Amava_combination.append(Comment48x)
            Amava_combination.append(Comment50x)
//*******************************************************
            Amava_combination.append(Heading5, Body62)
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(Sabathneek4) }
            Amava_combination.append(Body63, Body64)
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(Sabathneek5) }
            Amava_combination.append(Body65, Body66)
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(Sabathneek6) }
            Amava_combination.append(Body67, Body68)
            Amava_combination.append(Body69)
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(Sabathneek7) }
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body70A) } else { Amava_combination.append(Body70B) }
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body71) } else { Amava_combination.append(Body72) }
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(Sabathneek8) }
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body73A) } else { Amava_combination.append(Body73B) }
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body74) } else { Amava_combination.append(Body75) }
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(Sabathneek9) }
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body76A) } else { Amava_combination.append(Body76B) }
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body77) } else { Amava_combination.append(Body78) }
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(Sabathneek10) }
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body79A) } else { Amava_combination.append(Body79B) }
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body80) } else { Amava_combination.append(Body81) }
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(Sabathneek11) }
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body82A) } else { Amava_combination.append(Body82B) }
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body83) } else { Amava_combination.append(Body84) }
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(Sabathneek12) }
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body85A) } else { Amava_combination.append(Body85B) }
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body86) } else { Amava_combination.append(Body87) }
//*******************************************************************************************************
            Amava_combination.append(MHeading5, MBody62)
            if (motherLive == "Deceased" && motherMotherLive == "Deceased") { Amava_combination.append(MSabathneek4) }
            Amava_combination.append(MBody63)
            if (motherLive == "Deceased" && motherMotherLive == "Deceased") { Amava_combination.append(MSabathneek5) }
            Amava_combination.append(MBody64)
            if (motherLive == "Deceased" && motherMotherLive == "Deceased") { Amava_combination.append(M2Sabathneek5) }
            Amava_combination.append(MBody66)
            if (motherLive == "Deceased" && motherMotherLive == "Deceased") { Amava_combination.append(MSabathneek6) }
            Amava_combination.append(MBody68)
            if (motherLive == "Deceased" && motherMotherLive == "Deceased") { Amava_combination.append(MSabathneek7) }
            Amava_combination.append(MBody69)
            if (motherLive == "Deceased" && motherMotherLive == "Deceased") { Amava_combination.append(MSabathneek8) }
            Amava_combination.append(MBody71)
            if (motherLive == "Deceased" && motherMotherLive == "Deceased") { Amava_combination.append(MSabathneek9) }
            Amava_combination.append(MBody72)
            if (motherLive == "Deceased" && motherMotherLive == "Deceased") { Amava_combination.append(MSabathneek10) }
            Amava_combination.append(MBody74)
            if (motherLive == "Deceased" && motherMotherLive == "Deceased") { Amava_combination.append(MSabathneek11) }
            Amava_combination.append(MBody75)
//*************************************************************************
            Amava_combination.append(Comment51, Body88, GreenComment2, Comment52, Body89, RedComment4, Comment53, Comment54, Comment55)
            Amava_combination.append(Comment55A, Body90, Comment55B, MBody90, Comment55C)
            if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { Amava_combination.append(Comment57) }else Amava_combination.append(Comment56)
            Amava_combination.append(Comment58, Body91, Comment55D)
            if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { Amava_combination.append(Comment57A) }else Amava_combination.append(Comment56A)
            Amava_combination.append(Comment58A, MBody91)
            if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { Amava_combination.append(Comment57B) }else Amava_combination.append(Comment55E)
            Amava_combination.append(Comment58B, MBody91A, GreenComment3, Body92, VARGAI1B, Body93, Comment59, Body94, Comment60, Body95, Comment61, Body96, VARGAI2B)
            Amava_combination.append(Body97, Comment62)
            Amava_combination.append(Heading6, RedComment5)
            if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { Amava_combination.append(Comment64) }else Amava_combination.append(Comment63)
            Amava_combination.append(MComment64, Comment65, Body98)
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(Sabathneek13) }
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body99A) } else { Amava_combination.append(Body99B) }
            Amava_combination.append(MComment64A, MBody98)
            if (motherLive == "Deceased" && motherMotherLive == "Deceased") { Amava_combination.append(Sabathneek13A) }
            Amava_combination.append(MBody98A, Comment66, Body100, Comment67, GreenComment4, Comment68, Body101, Body102, Comment69, Comment70, Body103)
            if (MFatherLive == "Deceased") { Amava_combination.append(VARGAI3B) } else { Amava_combination.append(VARGAI3A) }
            Amava_combination.append(Body104, Comment71, Body105, RedComment6, Comment72)
            if (MFatherLive == "Deceased") { Amava_combination.append(Comment73) }
            if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { Amava_combination.append(Comment75) }else Amava_combination.append(Comment74)
            Amava_combination.append(Comment76, Body106, Body107Big, Body108, GreenComment5, Comment77, Heading7) }

        Amava_combination.append("\n\n")
        this.binding.AmavasyaTPNMTextView.text = Amava_combination

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

                pageOneText = Amava_combination.subSequence(startPos1, endPos1)
                pageTwoText = Amava_combination.subSequence(startPos2, endPos2)
                pageThreeText = Amava_combination.subSequence(startPos3, endPos3)
                pageFourText = Amava_combination.subSequence(startPos4, endPos4)
                pageFiveText = Amava_combination.subSequence(startPos5, endPos5)
                pageSixText = Amava_combination.subSequence(startPos6, endPos6)
                pageSevenText = Amava_combination.subSequence(startPos7, endPos7)
                pageEightText = Amava_combination.subSequence(startPos8, endPos8)
                pageNineText = Amava_combination.subSequence(startPos9, endPos9)
                pageTenText = Amava_combination.subSequence(startPos10, endPos10)
                pageElevenText = Amava_combination.subSequence(startPos11, endPos11)
                pageTwelveText = Amava_combination.subSequence(startPos12, endPos12)
                pageThirteenText = Amava_combination.subSequence(startPos13, endPos13)
                pageFourteenText = Amava_combination.subSequence(startPos14, endPos14)
                pageFifteenText = Amava_combination.subSequence(startPos15, endPos15)
                pageSixteenText = Amava_combination.subSequence(startPos16, endPos16)
                pageSeventeenText = Amava_combination.subSequence(startPos17, endPos17)

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
                    paint.textSize = 13f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 2 && totalpages >= 2) {
                    val mTextLayout2 = StaticLayout(pageTwoText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout2.draw(canvas)
                    paint.textSize = 13f
                    paint.colorFilter
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 3 && totalpages >= 3) {
                    val mTextLayout3 = StaticLayout(pageThreeText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout3.draw(canvas)
                    paint.textSize = 13f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 4 && totalpages >= 4) {
                    val mTextLayout4 = StaticLayout(pageFourText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout4.draw(canvas)
                    paint.textSize = 13f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 5 && totalpages >= 5) {
                    val mTextLayout5 = StaticLayout(pageFiveText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout5.draw(canvas)
                    paint.textSize = 13f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 6 && totalpages >= 6) {
                    val mTextLayout6 = StaticLayout(pageSixText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout6.draw(canvas)
                    paint.textSize = 13f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 7 && totalpages >= 7) {
                    val mTextLayout7 = StaticLayout(pageSevenText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout7.draw(canvas)
                    paint.textSize = 13f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 8 && totalpages >= 8) {
                    val mTextLayout8 = StaticLayout(pageEightText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout8.draw(canvas)
                    paint.textSize = 13f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 9 && totalpages >= 9) {
                    val mTextLayout9 = StaticLayout(pageNineText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout9.draw(canvas)
                    paint.textSize = 13f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 10 && totalpages >= 10) {
                    val mTextLayout10 = StaticLayout(pageTenText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout10.draw(canvas)
                    paint.textSize = 13f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 11 && totalpages >= 11) {
                    val mTextLayout11 = StaticLayout(pageElevenText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout11.draw(canvas)
                    paint.textSize = 13f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 12 && totalpages >= 12) {
                    val mTextLayout12 = StaticLayout(pageTwelveText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout12.draw(canvas)
                    paint.textSize = 13f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 13 && totalpages >= 13) {
                    val mTextLayout13 = StaticLayout(pageThirteenText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout13.draw(canvas)
                    paint.textSize = 13f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 14 && totalpages >= 14) {
                    val mTextLayout14 = StaticLayout(pageFourteenText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout14.draw(canvas)
                    paint.textSize = 13f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 15 && totalpages >= 15) {
                    val mTextLayout15 = StaticLayout(pageFifteenText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout15.draw(canvas)
                    paint.textSize = 13f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 16 && totalpages >= 16) {
                    val mTextLayout16 = StaticLayout(pageSixteenText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout16.draw(canvas)
                    paint.textSize = 13f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 17 && totalpages >= 17) {
                    val mTextLayout17 = StaticLayout(pageSeventeenText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout17.draw(canvas)
                    paint.textSize = 13f
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

        printBtn.setOnClickListener {
            val mTLineCount = binding.AmavasyaTPNMTextView.lineCount
            println("mTLineCount : $mTLineCount")
            val totalChar = binding.AmavasyaTPNMTextView.length()
            val testTotalChar = totalChar.toString()
            println("totalChar : $totalChar")
            val pagesTotal = ((mTLineCount/50 + 0.99) / 0.99 ) * 1 //(Math.round(mTLineCount.toDouble() / 30.toDouble()))
            totalpages = pagesTotal.toInt()
            println("totalpages : $totalpages")
            if (totalpages == 1) {
                startPos1 = binding.AmavasyaTPNMTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    endPos1 = binding.AmavasyaTPNMTextView.layout.getLineEnd(50)
                } else {
                    endPos1 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount - 1)
                }
                //   pageOneText = AmavasyaTPNMTextView.text.toString().substring(startPos1, endPos1)
            }
            if (totalpages == 2) {
                startPos1 = binding.AmavasyaTPNMTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    endPos1 = binding.AmavasyaTPNMTextView.layout.getLineEnd(50)
                } else {
                    endPos1 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                }
                //     pageOneText = AmavasyaTPNMTextView.text.toString().substring(startPos1, endPos1)
                if (mTLineCount in 51..100) {
                    startPos2 = binding.AmavasyaTPNMTextView.layout.getLineStart(51)
                    endPos2 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos2 = binding.AmavasyaTPNMTextView.layout.getLineStart(51)
                    endPos2 = binding.AmavasyaTPNMTextView.layout.getLineEnd(100)
                }
                //      pageTwoText = AmavasyaTPNMTextView.text.toString().substring(startPos2, endPos2)
            }

            if (totalpages == 3) {
                startPos1 = binding.AmavasyaTPNMTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    endPos1 = binding.AmavasyaTPNMTextView.layout.getLineEnd(50)
                } else {
                    endPos1 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                }
                pageOneText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos1, endPos1)
                if (mTLineCount in 51..100) {
                    startPos2 = binding.AmavasyaTPNMTextView.layout.getLineStart(51)
                    endPos2 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos2 = binding.AmavasyaTPNMTextView.layout.getLineStart(51)
                    endPos2 = binding.AmavasyaTPNMTextView.layout.getLineEnd(100)
                }
                //    pageTwoText = AmavasyaTPNMTextView.text.toString().substring(startPos2, endPos2)
                if (mTLineCount in 101..150) {
                    startPos3 = binding.AmavasyaTPNMTextView.layout.getLineStart(101)
                    endPos3 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos3 = binding.AmavasyaTPNMTextView.layout.getLineStart(101)
                    endPos3 = binding.AmavasyaTPNMTextView.layout.getLineEnd(150)
                }
                //    pageThreeText = AmavasyaTPNMTextView.text.toString().substring(startPos3, endPos3)
            }
            if (totalpages == 4) {
                startPos1 = binding.AmavasyaTPNMTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    endPos1 = binding.AmavasyaTPNMTextView.layout.getLineEnd(50)
                } else {
                    endPos1 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                }
                //   pageOneText = AmavasyaTPNMTextView.text.toString().substring(startPos1, endPos1)
                if (mTLineCount in 51..100) {
                    startPos2 = binding.AmavasyaTPNMTextView.layout.getLineStart(51)
                    endPos2 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos2 = binding.AmavasyaTPNMTextView.layout.getLineStart(51)
                    endPos2 = binding.AmavasyaTPNMTextView.layout.getLineEnd(100)
                }
                //    pageTwoText = AmavasyaTPNMTextView.text.toString().substring(startPos2, endPos2)
                if (mTLineCount in 101..150) {
                    startPos3 = binding.AmavasyaTPNMTextView.layout.getLineStart(101)
                    endPos3 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos3 = binding.AmavasyaTPNMTextView.layout.getLineStart(101)
                    endPos3 = binding.AmavasyaTPNMTextView.layout.getLineEnd(150)
                }
                //    pageThreeText = AmavasyaTPNMTextView.text.toString().substring(startPos3, endPos3)
                if (mTLineCount in 151..200) {
                    startPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(151)
                    endPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(151)
                    endPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(200)
                }
                //    pageFourText = AmavasyaTPNMTextView.text.toString().substring(startPos4, endPos4)
            }
            if (totalpages == 5) {
                startPos1 = binding.AmavasyaTPNMTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    endPos1 = binding.AmavasyaTPNMTextView.layout.getLineEnd(50)
                } else {
                    endPos1 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                }
                //   pageOneText = AmavasyaTPNMTextView.text.toString().substring(startPos1, endPos1)
                if (mTLineCount in 51..100) {
                    startPos2 = binding.AmavasyaTPNMTextView.layout.getLineStart(51)
                    endPos2 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos2 = binding.AmavasyaTPNMTextView.layout.getLineStart(51)
                    endPos2 = binding.AmavasyaTPNMTextView.layout.getLineEnd(100)
                }
                //    pageTwoText = AmavasyaTPNMTextView.text.toString().substring(startPos2, endPos2)
                if (mTLineCount in 101..150) {
                    startPos3 = binding.AmavasyaTPNMTextView.layout.getLineStart(101)
                    endPos3 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos3 = binding.AmavasyaTPNMTextView.layout.getLineStart(101)
                    endPos3 = binding.AmavasyaTPNMTextView.layout.getLineEnd(150)
                }
                //    pageThreeText = AmavasyaTPNMTextView.text.toString().substring(startPos3, endPos3)
                if (mTLineCount in 151..200) {
                    startPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(151)
                    endPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(151)
                    endPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(200)
                }
                //    pageFourText = AmavasyaTPNMTextView.text.toString().substring(startPos4, endPos4)
                if (mTLineCount in 201..250) {
                    startPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(201)
                    endPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(201)
                    endPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(250)
                }
                //    pageFiveText = AmavasyaTPNMTextView.text.toString().substring(startPos5, endPos5)
            }

            if (totalpages == 6) {
                startPos1 = binding.AmavasyaTPNMTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    endPos1 = binding.AmavasyaTPNMTextView.layout.getLineEnd(50)
                } else {
                    endPos1 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                }
                //    pageOneText = AmavasyaTPNMTextView.text.toString().substring(startPos1, endPos1)
                if (mTLineCount in 51..100) {
                    startPos2 = binding.AmavasyaTPNMTextView.layout.getLineStart(51)
                    endPos2 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos2 = binding.AmavasyaTPNMTextView.layout.getLineStart(51)
                    endPos2 = binding.AmavasyaTPNMTextView.layout.getLineEnd(100)
                }
                //    pageTwoText = AmavasyaTPNMTextView.text.toString().substring(startPos2, endPos2)
                if (mTLineCount in 101..150) {
                    startPos3 = binding.AmavasyaTPNMTextView.layout.getLineStart(101)
                    endPos3 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos3 = binding.AmavasyaTPNMTextView.layout.getLineStart(101)
                    endPos3 = binding.AmavasyaTPNMTextView.layout.getLineEnd(150)
                }
                //    pageThreeText = AmavasyaTPNMTextView.text.toString().substring(startPos3, endPos3)
                if (mTLineCount in 151..200) {
                    startPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(151)
                    endPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(151)
                    endPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(200)
                }
                //    pageFourText = AmavasyaTPNMTextView.text.toString().substring(startPos4, endPos4)
                if (mTLineCount in 201..250) {
                    startPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(201)
                    endPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(201)
                    endPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(250)
                }
                //    pageFiveText = AmavasyaTPNMTextView.text.toString().substring(startPos5, endPos5)
                if (mTLineCount in 251..300) {
                    startPos6 = binding.AmavasyaTPNMTextView.layout.getLineStart(251)
                    endPos6 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos6 = binding.AmavasyaTPNMTextView.layout.getLineStart(251)
                    endPos6 = binding.AmavasyaTPNMTextView.layout.getLineEnd(300)
                }
                //    pageSixText = AmavasyaTPNMTextView.text.toString().substring(startPos6, endPos6)
            }
            if (totalpages == 7) {
                startPos1 = binding.AmavasyaTPNMTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    endPos1 = binding.AmavasyaTPNMTextView.layout.getLineEnd(50)
                } else {
                    endPos1 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                }
                //    pageOneText = AmavasyaTPNMTextView.text.toString().substring(startPos1, endPos1)
                if (mTLineCount in 51..100) {
                    startPos2 = binding.AmavasyaTPNMTextView.layout.getLineStart(51)
                    endPos2 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos2 = binding.AmavasyaTPNMTextView.layout.getLineStart(51)
                    endPos2 = binding.AmavasyaTPNMTextView.layout.getLineEnd(100)
                }
                //    pageTwoText = AmavasyaTPNMTextView.text.toString().substring(startPos2, endPos2)
                if (mTLineCount in 101..150) {
                    startPos3 = binding.AmavasyaTPNMTextView.layout.getLineStart(101)
                    endPos3 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos3 = binding.AmavasyaTPNMTextView.layout.getLineStart(101)
                    endPos3 = binding.AmavasyaTPNMTextView.layout.getLineEnd(150)
                }
                //     pageThreeText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos3, endPos3)
                if (mTLineCount in 151..200) {
                    startPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(151)
                    endPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(151)
                    endPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(200)
                }
                //    pageFourText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos4, endPos4)
                if (mTLineCount in 201..250) {
                    startPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(201)
                    endPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(201)
                    endPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(250)
                }
                //    pageFiveText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos5, endPos5)
                if (mTLineCount in 251..300) {
                    startPos6 = binding.AmavasyaTPNMTextView.layout.getLineStart(251)
                    endPos6 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos6 = binding.AmavasyaTPNMTextView.layout.getLineStart(251)
                    endPos6 = binding.AmavasyaTPNMTextView.layout.getLineEnd(300)
                }
                //    pageSixText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos6, endPos6)
                if (mTLineCount in 301..350) {
                    startPos7 = binding.AmavasyaTPNMTextView.layout.getLineStart(301)
                    endPos7 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos7 = binding.AmavasyaTPNMTextView.layout.getLineStart(301)
                    endPos7 = binding.AmavasyaTPNMTextView.layout.getLineEnd(350)
                }
                //    pageSevenText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos7, endPos7)
            }
            if (totalpages == 8) {
                startPos1 = binding.AmavasyaTPNMTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    endPos1 = binding.AmavasyaTPNMTextView.layout.getLineEnd(50)
                } else {
                    endPos1 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                }
                //    pageOneText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos1, endPos1)
                if (mTLineCount in 51..100) {
                    startPos2 = binding.AmavasyaTPNMTextView.layout.getLineStart(51)
                    endPos2 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos2 = binding.AmavasyaTPNMTextView.layout.getLineStart(51)
                    endPos2 = binding.AmavasyaTPNMTextView.layout.getLineEnd(100)
                }
                //    pageTwoText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos2, endPos2)
                if (mTLineCount in 101..150) {
                    startPos3 = binding.AmavasyaTPNMTextView.layout.getLineStart(101)
                    endPos3 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos3 = binding.AmavasyaTPNMTextView.layout.getLineStart(101)
                    endPos3 = binding.AmavasyaTPNMTextView.layout.getLineEnd(150)
                }
                //    pageThreeText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos3, endPos3)
                if (mTLineCount in 151..200) {
                    startPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(151)
                    endPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(151)
                    endPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(200)
                }
                //    pageFourText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos4, endPos4)
                if (mTLineCount in 201..250) {
                    startPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(201)
                    endPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(201)
                    endPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(250)
                }
                //    pageFiveText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos5, endPos5)
                if (mTLineCount in 251..300) {
                    startPos6 = binding.AmavasyaTPNMTextView.layout.getLineStart(251)
                    endPos6 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos6 = binding.AmavasyaTPNMTextView.layout.getLineStart(251)
                    endPos6 = binding.AmavasyaTPNMTextView.layout.getLineEnd(300)
                }
                //    pageSixText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos6, endPos6)
                if (mTLineCount in 301..350) {
                    startPos7 = binding.AmavasyaTPNMTextView.layout.getLineStart(301)
                    endPos7 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos7 = binding.AmavasyaTPNMTextView.layout.getLineStart(301)
                    endPos7 = binding.AmavasyaTPNMTextView.layout.getLineEnd(350)
                }
                println("startPos7 : $startPos7")
                println("endPos7 : $endPos7")
                //    pageSevenText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos7, endPos7)

                if (mTLineCount in 351..400) {
                    startPos8 = binding.AmavasyaTPNMTextView.layout.getLineStart(351)
                    endPos8 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                    println("endPos8 : $endPos8")
                } else {
                    startPos8 = binding.AmavasyaTPNMTextView.layout.getLineStart(351)
                    endPos8 = binding.AmavasyaTPNMTextView.layout.getLineEnd(400)
                    println("endPos82 : $endPos8")
                }
                println("startPos8 : $startPos8")
                println("endPos8F : $endPos8")
                //    pageEightText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos8, endPos8)
            }

            if (totalpages == 9) {
                startPos1 = binding.AmavasyaTPNMTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    endPos1 = binding.AmavasyaTPNMTextView.layout.getLineEnd(50)
                } else {
                    endPos1 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                }
                //     pageOneText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos1, endPos1)
                if (mTLineCount in 51..100) {
                    startPos2 = binding.AmavasyaTPNMTextView.layout.getLineStart(51)
                    endPos2 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos2 = binding.AmavasyaTPNMTextView.layout.getLineStart(51)
                    endPos2 = binding.AmavasyaTPNMTextView.layout.getLineEnd(100)
                }
                //     pageTwoText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos2, endPos2)
                if (mTLineCount in 101..150) {
                    startPos3 = binding.AmavasyaTPNMTextView.layout.getLineStart(101)
                    endPos3 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos3 = binding.AmavasyaTPNMTextView.layout.getLineStart(101)
                    endPos3 = binding.AmavasyaTPNMTextView.layout.getLineEnd(150)
                }
                //    pageThreeText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos3, endPos3)
                if (mTLineCount in 151..200) {
                    startPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(151)
                    endPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(151)
                    endPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(200)
                }
                //    pageFourText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos4, endPos4)
                if (mTLineCount in 201..250) {
                    startPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(201)
                    endPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(201)
                    endPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(250)
                }
                //    pageFiveText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos5, endPos5)
                if (mTLineCount in 251..300) {
                    startPos6 = binding.AmavasyaTPNMTextView.layout.getLineStart(251)
                    endPos6 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos6 = binding.AmavasyaTPNMTextView.layout.getLineStart(251)
                    endPos6 = binding.AmavasyaTPNMTextView.layout.getLineEnd(300)
                }
                //    pageSixText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos6, endPos6)
                if (mTLineCount in 301..350) {
                    startPos7 = binding.AmavasyaTPNMTextView.layout.getLineStart(301)
                    endPos7 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos7 = binding.AmavasyaTPNMTextView.layout.getLineStart(301)
                    endPos7 = binding.AmavasyaTPNMTextView.layout.getLineEnd(350)
                }
                //     pageSevenText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos7, endPos7)
                if (mTLineCount in 351..400) {
                    startPos8 = binding.AmavasyaTPNMTextView.layout.getLineStart(351)
                    endPos8 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos8 = binding.AmavasyaTPNMTextView.layout.getLineStart(351)
                    endPos8 = binding.AmavasyaTPNMTextView.layout.getLineEnd(400)
                }
                //     pageEightText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos8, endPos8)
                if (mTLineCount in 401..450) {
                    startPos9 = binding.AmavasyaTPNMTextView.layout.getLineStart(401)
                    endPos9 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos9 = binding.AmavasyaTPNMTextView.layout.getLineStart(401)
                    endPos9 = binding.AmavasyaTPNMTextView.layout.getLineEnd(450)
                }
                //     pageNineText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos9, endPos9)
            }
            if (totalpages == 10) {
                startPos1 = binding.AmavasyaTPNMTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    endPos1 = binding.AmavasyaTPNMTextView.layout.getLineEnd(50)
                } else {
                    endPos1 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                }
                //      pageOneText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos1, endPos1)
                if (mTLineCount in 51..100) {
                    startPos2 = binding.AmavasyaTPNMTextView.layout.getLineStart(51)
                    endPos2 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos2 = binding.AmavasyaTPNMTextView.layout.getLineStart(51)
                    endPos2 = binding.AmavasyaTPNMTextView.layout.getLineEnd(100)
                }
                //     pageTwoText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos2, endPos2)
                if (mTLineCount in 101..150) {
                    startPos3 = binding.AmavasyaTPNMTextView.layout.getLineStart(101)
                    endPos3 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos3 = binding.AmavasyaTPNMTextView.layout.getLineStart(101)
                    endPos3 = binding.AmavasyaTPNMTextView.layout.getLineEnd(150)
                }
                //    pageThreeText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos3, endPos3)
                if (mTLineCount in 151..200) {
                    startPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(151)
                    endPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(151)
                    endPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(200)
                }
                //    pageFourText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos4, endPos4)
                if (mTLineCount in 201..250) {
                    startPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(201)
                    endPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(201)
                    endPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(250)
                }
                //    pageFiveText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos5, endPos5)
                if (mTLineCount in 251..300) {
                    startPos6 = binding.AmavasyaTPNMTextView.layout.getLineStart(251)
                    endPos6 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos6 = binding.AmavasyaTPNMTextView.layout.getLineStart(251)
                    endPos6 = binding.AmavasyaTPNMTextView.layout.getLineEnd(300)
                }
                //    pageSixText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos6, endPos6)
                if (mTLineCount in 301..350) {
                    startPos7 = binding.AmavasyaTPNMTextView.layout.getLineStart(301)
                    endPos7 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos7 = binding.AmavasyaTPNMTextView.layout.getLineStart(301)
                    endPos7 = binding.AmavasyaTPNMTextView.layout.getLineEnd(350)
                }
                //    pageSevenText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos7, endPos7)
                if (mTLineCount in 351..400) {
                    startPos8 = binding.AmavasyaTPNMTextView.layout.getLineStart(351)
                    endPos8 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos8 = binding.AmavasyaTPNMTextView.layout.getLineStart(351)
                    endPos8 = binding.AmavasyaTPNMTextView.layout.getLineEnd(400)
                }
                //    pageEightText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos8, endPos8)
                if (mTLineCount in 401..450) {
                    startPos9 = binding.AmavasyaTPNMTextView.layout.getLineStart(401)
                    endPos9 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos9 = binding.AmavasyaTPNMTextView.layout.getLineStart(401)
                    endPos9 = binding.AmavasyaTPNMTextView.layout.getLineEnd(450)
                }
                //    pageNineText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos9, endPos9)
                if (mTLineCount  in 451..500) {
                    startPos10 = binding.AmavasyaTPNMTextView.layout.getLineStart(451)
                    endPos10 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos10 = binding.AmavasyaTPNMTextView.layout.getLineStart(451)
                    endPos10 = binding.AmavasyaTPNMTextView.layout.getLineEnd(500)
                }
                //    pageTenText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos10, endPos10)
            }
            if (totalpages == 11) {
                startPos1 = binding.AmavasyaTPNMTextView.layout.getLineStart(0)
                if (mTLineCount  >= 50) {
                    endPos1 = binding.AmavasyaTPNMTextView.layout.getLineEnd(50)
                } else {
                    endPos1 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                }
                //    pageOneText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos1, endPos1)
                if (mTLineCount  in 51..100) {
                    startPos2 = binding.AmavasyaTPNMTextView.layout.getLineStart(51)
                    endPos2 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos2 = binding.AmavasyaTPNMTextView.layout.getLineStart(51)
                    endPos2 = binding.AmavasyaTPNMTextView.layout.getLineEnd(100)
                }
                //    pageTwoText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos2, endPos2)
                if (mTLineCount  in 101..150) {
                    startPos3 = binding.AmavasyaTPNMTextView.layout.getLineStart(101)
                    endPos3 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos3 = binding.AmavasyaTPNMTextView.layout.getLineStart(101)
                    endPos3 = binding.AmavasyaTPNMTextView.layout.getLineEnd(150)
                }
                //    pageThreeText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos3, endPos3)
                if (mTLineCount  in 151..200) {
                    startPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(151)
                    endPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(151)
                    endPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(200)
                }
                //    pageFourText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos4, endPos4)
                if (mTLineCount  in 201..250) {
                    startPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(201)
                    endPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(201)
                    endPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(250)
                }
                //    pageFiveText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos5, endPos5)
                if (mTLineCount  in 251..300) {
                    startPos6 = binding.AmavasyaTPNMTextView.layout.getLineStart(251)
                    endPos6 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos6 = binding.AmavasyaTPNMTextView.layout.getLineStart(251)
                    endPos6 = binding.AmavasyaTPNMTextView.layout.getLineEnd(300)
                }
                //    pageSixText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos6, endPos6)
                if (mTLineCount  in 301..350) {
                    startPos7 = binding.AmavasyaTPNMTextView.layout.getLineStart(301)
                    endPos7 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos7 = binding.AmavasyaTPNMTextView.layout.getLineStart(301)
                    endPos7 = binding.AmavasyaTPNMTextView.layout.getLineEnd(350)
                }
                //    pageSevenText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos7, endPos7)
                if (mTLineCount in 351..400) {
                    startPos8 = binding.AmavasyaTPNMTextView.layout.getLineStart(351)
                    endPos8 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos8 = binding.AmavasyaTPNMTextView.layout.getLineStart(351)
                    endPos8 = binding.AmavasyaTPNMTextView.layout.getLineEnd(400)
                }
                //     pageEightText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos8, endPos8)
                if (mTLineCount  in 401..450) {
                    startPos9 = binding.AmavasyaTPNMTextView.layout.getLineStart(401)
                    endPos9 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos9 = binding.AmavasyaTPNMTextView.layout.getLineStart(401)
                    endPos9 = binding.AmavasyaTPNMTextView.layout.getLineEnd(450)
                }
                //    pageNineText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos9, endPos9)
                if (mTLineCount  in 451..500) {
                    startPos10 = binding.AmavasyaTPNMTextView.layout.getLineStart(451)
                    endPos10 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos10 = binding.AmavasyaTPNMTextView.layout.getLineStart(451)
                    endPos10 = binding.AmavasyaTPNMTextView.layout.getLineEnd(500)
                }
                //     pageTenText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos10, endPos10)
                if (mTLineCount  in 501..550) {
                    startPos11 = binding.AmavasyaTPNMTextView.layout.getLineStart(501)
                    endPos11 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos11 = binding.AmavasyaTPNMTextView.layout.getLineStart(501)
                    endPos11 = binding.AmavasyaTPNMTextView.layout.getLineEnd(550)
                }
                //    pageElevenText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos11, endPos11)
            }
            if (totalpages == 12) {
                startPos1 = binding.AmavasyaTPNMTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    endPos1 = binding.AmavasyaTPNMTextView.layout.getLineEnd(50)
                } else {
                    endPos1 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                }
                //     pageOneText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos1, endPos1)
                if (mTLineCount  in 51..100) {
                    startPos2 = binding.AmavasyaTPNMTextView.layout.getLineStart(51)
                    endPos2 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos2 = binding.AmavasyaTPNMTextView.layout.getLineStart(51)
                    endPos2 = binding.AmavasyaTPNMTextView.layout.getLineEnd(100)
                }
                //     pageTwoText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos2, endPos2)
                if (mTLineCount  in 101..150) {
                    startPos3 = binding.AmavasyaTPNMTextView.layout.getLineStart(101)
                    endPos3 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos3 = binding.AmavasyaTPNMTextView.layout.getLineStart(101)
                    endPos3 = binding.AmavasyaTPNMTextView.layout.getLineEnd(150)
                }
                //     pageThreeText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos3, endPos3)
                if (mTLineCount  in 151..200) {
                    startPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(151)
                    endPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(151)
                    endPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(200)
                }
                //    pageFourText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos4, endPos4)
                if (mTLineCount  in 201..250) {
                    startPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(201)
                    endPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(201)
                    endPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(250)
                }
                //    pageFiveText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos5, endPos5)
                if (mTLineCount  in 251..300) {
                    startPos6 = binding.AmavasyaTPNMTextView.layout.getLineStart(251)
                    endPos6 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos6 = binding.AmavasyaTPNMTextView.layout.getLineStart(251)
                    endPos6 = binding.AmavasyaTPNMTextView.layout.getLineEnd(300)
                }
                //    pageSixText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos6, endPos6)
                if (mTLineCount  in 301..350) {
                    startPos7 = binding.AmavasyaTPNMTextView.layout.getLineStart(301)
                    endPos7 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos7 = binding.AmavasyaTPNMTextView.layout.getLineStart(301)
                    endPos7 = binding.AmavasyaTPNMTextView.layout.getLineEnd(350)
                }
                //    pageSevenText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos7, endPos7)
                if (mTLineCount in 351..400) {
                    startPos8 = binding.AmavasyaTPNMTextView.layout.getLineStart(351)
                    endPos8 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos8 = binding.AmavasyaTPNMTextView.layout.getLineStart(351)
                    endPos8 = binding.AmavasyaTPNMTextView.layout.getLineEnd(400)
                }
                //    pageEightText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos8, endPos8)
                if (mTLineCount  in 401..450) {
                    startPos9 = binding.AmavasyaTPNMTextView.layout.getLineStart(401)
                    endPos9 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos9 = binding.AmavasyaTPNMTextView.layout.getLineStart(401)
                    endPos9 = binding.AmavasyaTPNMTextView.layout.getLineEnd(450)
                }
                //    pageNineText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos9, endPos9)
                if (mTLineCount  in 451..500) {
                    startPos10 = binding.AmavasyaTPNMTextView.layout.getLineStart(451)
                    endPos10 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos10 = binding.AmavasyaTPNMTextView.layout.getLineStart(451)
                    endPos10 = binding.AmavasyaTPNMTextView.layout.getLineEnd(500)
                }
                //    pageTenText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos10, endPos10)
                if (mTLineCount  in 501..550) {
                    startPos11 = binding.AmavasyaTPNMTextView.layout.getLineStart(501)
                    endPos11 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos11 = binding.AmavasyaTPNMTextView.layout.getLineStart(501)
                    endPos11 = binding.AmavasyaTPNMTextView.layout.getLineEnd(550)
                }
                //    pageElevenText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos11, endPos11)
                if (mTLineCount  in 551..600) {
                    startPos12 = binding.AmavasyaTPNMTextView.layout.getLineStart(551)
                    endPos12 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos12 = binding.AmavasyaTPNMTextView.layout.getLineStart(551)
                    endPos12 = binding.AmavasyaTPNMTextView.layout.getLineEnd(600)
                }
                //    pageTwelveText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos12, endPos12)
            }
            if (totalpages == 13) {
                startPos1 = binding.AmavasyaTPNMTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    endPos1 = binding.AmavasyaTPNMTextView.layout.getLineEnd(50)
                } else {
                    endPos1 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                }
                //     pageOneText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos1, endPos1)
                if (mTLineCount  in 51..100) {
                    startPos2 = binding.AmavasyaTPNMTextView.layout.getLineStart(51)
                    endPos2 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos2 = binding.AmavasyaTPNMTextView.layout.getLineStart(51)
                    endPos2 = binding.AmavasyaTPNMTextView.layout.getLineEnd(100)
                }
                //    pageTwoText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos2, endPos2)
                if (mTLineCount  in 101..150) {
                    startPos3 = binding.AmavasyaTPNMTextView.layout.getLineStart(101)
                    endPos3 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos3 = binding.AmavasyaTPNMTextView.layout.getLineStart(101)
                    endPos3 = binding.AmavasyaTPNMTextView.layout.getLineEnd(150)
                }
                //    pageThreeText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos3, endPos3)
                if (mTLineCount  in 151..200) {
                    startPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(151)
                    endPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(151)
                    endPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(200)
                }
                //    pageFourText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos4, endPos4)
                if (mTLineCount  in 201..250) {
                    startPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(201)
                    endPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(201)
                    endPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(250)
                }
                //    pageFiveText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos5, endPos5)
                if (mTLineCount  in 251..300) {
                    startPos6 = binding.AmavasyaTPNMTextView.layout.getLineStart(251)
                    endPos6 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos6 = binding.AmavasyaTPNMTextView.layout.getLineStart(251)
                    endPos6 = binding.AmavasyaTPNMTextView.layout.getLineEnd(300)
                }
                //    pageSixText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos6, endPos6)
                if (mTLineCount  in 301..350) {
                    startPos7 = binding.AmavasyaTPNMTextView.layout.getLineStart(301)
                    endPos7 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos7 = binding.AmavasyaTPNMTextView.layout.getLineStart(301)
                    endPos7 = binding.AmavasyaTPNMTextView.layout.getLineEnd(350)
                }
                //    pageSevenText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos7, endPos7)
                if (mTLineCount in 351..400) {
                    startPos8 = binding.AmavasyaTPNMTextView.layout.getLineStart(351)
                    endPos8 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos8 = binding.AmavasyaTPNMTextView.layout.getLineStart(351)
                    endPos8 = binding.AmavasyaTPNMTextView.layout.getLineEnd(400)
                }
                //    pageEightText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos8, endPos8)
                if (mTLineCount  in 401..450) {
                    startPos9 = binding.AmavasyaTPNMTextView.layout.getLineStart(401)
                    endPos9 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos9 = binding.AmavasyaTPNMTextView.layout.getLineStart(401)
                    endPos9 = binding.AmavasyaTPNMTextView.layout.getLineEnd(450)
                }
                //    pageNineText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos9, endPos9)
                if (mTLineCount in 451..500) {
                    startPos10 = binding.AmavasyaTPNMTextView.layout.getLineStart(451)
                    endPos10 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos10 = binding.AmavasyaTPNMTextView.layout.getLineStart(451)
                    endPos10 = binding.AmavasyaTPNMTextView.layout.getLineEnd(500)
                }
                //    pageTenText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos10, endPos10)
                if (mTLineCount in 501..550) {
                    startPos11 = binding.AmavasyaTPNMTextView.layout.getLineStart(501)
                    endPos11 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos11 = binding.AmavasyaTPNMTextView.layout.getLineStart(501)
                    endPos11 = binding.AmavasyaTPNMTextView.layout.getLineEnd(550)
                }
                //    pageElevenText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos11, endPos11)
                if (mTLineCount in 551..600) {
                    startPos12 = binding.AmavasyaTPNMTextView.layout.getLineStart(551)
                    endPos12 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos12 = binding.AmavasyaTPNMTextView.layout.getLineStart(551)
                    endPos12 = binding.AmavasyaTPNMTextView.layout.getLineEnd(600)
                }
                //    pageTwelveText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos12, endPos12)
                if (mTLineCount in 601..650) {
                    startPos13 = binding.AmavasyaTPNMTextView.layout.getLineStart(601)
                    endPos13 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos13 = binding.AmavasyaTPNMTextView.layout.getLineStart(601)
                    endPos13 = binding.AmavasyaTPNMTextView.layout.getLineEnd(650)
                }
                //    pageThirteenText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos13, endPos13)
            }
            if (totalpages == 14) {
                startPos1 = binding.AmavasyaTPNMTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    endPos1 = binding.AmavasyaTPNMTextView.layout.getLineEnd(50)
                } else {
                    endPos1 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                }
                //    pageOneText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos1, endPos1)
                if (mTLineCount in 51..100) {
                    startPos2 = binding.AmavasyaTPNMTextView.layout.getLineStart(51)
                    endPos2 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos2 = binding.AmavasyaTPNMTextView.layout.getLineStart(51)
                    endPos2 = binding.AmavasyaTPNMTextView.layout.getLineEnd(100)
                }
                //    pageTwoText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos2, endPos2)
                if (mTLineCount in 101..150) {
                    startPos3 = binding.AmavasyaTPNMTextView.layout.getLineStart(101)
                    endPos3 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos3 = binding.AmavasyaTPNMTextView.layout.getLineStart(101)
                    endPos3 = binding.AmavasyaTPNMTextView.layout.getLineEnd(150)
                }
                //    pageThreeText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos3, endPos3)
                if (mTLineCount in 151..200) {
                    startPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(151)
                    endPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(151)
                    endPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(200)
                }
                //    pageFourText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos4, endPos4)
                if (mTLineCount in 201..250) {
                    startPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(201)
                    endPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(201)
                    endPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(250)
                }
                //    pageFiveText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos5, endPos5)
                if (mTLineCount in 251..300) {
                    startPos6 = binding.AmavasyaTPNMTextView.layout.getLineStart(251)
                    endPos6 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos6 = binding.AmavasyaTPNMTextView.layout.getLineStart(251)
                    endPos6 = binding.AmavasyaTPNMTextView.layout.getLineEnd(300)
                }
                //    pageSixText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos6, endPos6)
                if (mTLineCount in 301..350) {
                    startPos7 = binding.AmavasyaTPNMTextView.layout.getLineStart(301)
                    endPos7 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos7 = binding.AmavasyaTPNMTextView.layout.getLineStart(301)
                    endPos7 = binding.AmavasyaTPNMTextView.layout.getLineEnd(350)
                }
                //    pageSevenText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos7, endPos7)
                if (mTLineCount in 351..400) {
                    startPos8 = binding.AmavasyaTPNMTextView.layout.getLineStart(351)
                    endPos8 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos8 = binding.AmavasyaTPNMTextView.layout.getLineStart(351)
                    endPos8 = binding.AmavasyaTPNMTextView.layout.getLineEnd(400)
                }
                //    pageEightText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos8, endPos8)
                if (mTLineCount in 401..450) {
                    startPos9 = binding.AmavasyaTPNMTextView.layout.getLineStart(401)
                    endPos9 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos9 = binding.AmavasyaTPNMTextView.layout.getLineStart(401)
                    endPos9 = binding.AmavasyaTPNMTextView.layout.getLineEnd(450)
                }
                //    pageNineText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos9, endPos9)
                if (mTLineCount in 451..500) {
                    startPos10 = binding.AmavasyaTPNMTextView.layout.getLineStart(451)
                    endPos10 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos10 = binding.AmavasyaTPNMTextView.layout.getLineStart(451)
                    endPos10 = binding.AmavasyaTPNMTextView.layout.getLineEnd(500)
                }
                //    pageTenText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos10, endPos10)
                if (mTLineCount in 501..550) {
                    startPos11 = binding.AmavasyaTPNMTextView.layout.getLineStart(501)
                    endPos11 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos11 = binding.AmavasyaTPNMTextView.layout.getLineStart(501)
                    endPos11 = binding.AmavasyaTPNMTextView.layout.getLineEnd(550)
                }
                //    pageElevenText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos11, endPos11)
                if (mTLineCount in 551..600) {
                    startPos12 = binding.AmavasyaTPNMTextView.layout.getLineStart(551)
                    endPos12 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos12 = binding.AmavasyaTPNMTextView.layout.getLineStart(551)
                    endPos12 = binding.AmavasyaTPNMTextView.layout.getLineEnd(600)
                }
                //    pageTwelveText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos12, endPos12)
                if (mTLineCount in 601..650) {
                    startPos13 = binding.AmavasyaTPNMTextView.layout.getLineStart(601)
                    endPos13 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos13 = binding.AmavasyaTPNMTextView.layout.getLineStart(601)
                    endPos13 = binding.AmavasyaTPNMTextView.layout.getLineEnd(650)
                }
                //    pageThirteenText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos13, endPos13)
                if (mTLineCount in 651..700) {
                    startPos14 = binding.AmavasyaTPNMTextView.layout.getLineStart(651)
                    endPos14 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos14 = binding.AmavasyaTPNMTextView.layout.getLineStart(651)
                    endPos14 = binding.AmavasyaTPNMTextView.layout.getLineEnd(700)
                }
                //    pageFourteenText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos14, endPos14)
            }
            if (totalpages == 15) {
                startPos1 = binding.AmavasyaTPNMTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    endPos1 = binding.AmavasyaTPNMTextView.layout.getLineEnd(50)
                } else {
                    endPos1 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                }
                //    pageOneText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos1, endPos1)
                if (mTLineCount in 51..100) {
                    startPos2 = binding.AmavasyaTPNMTextView.layout.getLineStart(51)
                    endPos2 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos2 = binding.AmavasyaTPNMTextView.layout.getLineStart(51)
                    endPos2 = binding.AmavasyaTPNMTextView.layout.getLineEnd(100)
                }
                //    pageTwoText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos2, endPos2)
                if (mTLineCount in 101..150) {
                    startPos3 = binding.AmavasyaTPNMTextView.layout.getLineStart(101)
                    endPos3 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos3 = binding.AmavasyaTPNMTextView.layout.getLineStart(101)
                    endPos3 = binding.AmavasyaTPNMTextView.layout.getLineEnd(150)
                }
                //    pageThreeText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos3, endPos3)
                if (mTLineCount in 151..200) {
                    startPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(151)
                    endPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(151)
                    endPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(200)
                }
                //     pageFourText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos4, endPos4)
                if (mTLineCount in 201..250) {
                    startPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(201)
                    endPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(201)
                    endPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(250)
                }
                //    pageFiveText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos5, endPos5)
                if (mTLineCount in 251..300) {
                    startPos6 = binding.AmavasyaTPNMTextView.layout.getLineStart(251)
                    endPos6 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos6 = binding.AmavasyaTPNMTextView.layout.getLineStart(251)
                    endPos6 = binding.AmavasyaTPNMTextView.layout.getLineEnd(300)
                }
                //    pageSixText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos6, endPos6)
                if (mTLineCount in 301..350) {
                    startPos7 = binding.AmavasyaTPNMTextView.layout.getLineStart(301)
                    endPos7 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos7 = binding.AmavasyaTPNMTextView.layout.getLineStart(301)
                    endPos7 = binding.AmavasyaTPNMTextView.layout.getLineEnd(350)
                }
                //     pageSevenText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos7, endPos7)
                if (mTLineCount in 351..400) {
                    startPos8 = binding.AmavasyaTPNMTextView.layout.getLineStart(351)
                    endPos8 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos8 = binding.AmavasyaTPNMTextView.layout.getLineStart(351)
                    endPos8 = binding.AmavasyaTPNMTextView.layout.getLineEnd(400)
                }
                //    pageEightText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos8, endPos8)
                if (mTLineCount in 401..450) {
                    startPos9 = binding.AmavasyaTPNMTextView.layout.getLineStart(401)
                    endPos9 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos9 = binding.AmavasyaTPNMTextView.layout.getLineStart(401)
                    endPos9 = binding.AmavasyaTPNMTextView.layout.getLineEnd(450)
                }
                //    pageNineText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos9, endPos9)
                if (mTLineCount in 451..500) {
                    startPos10 = binding.AmavasyaTPNMTextView.layout.getLineStart(451)
                    endPos10 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos10 = binding.AmavasyaTPNMTextView.layout.getLineStart(451)
                    endPos10 = binding.AmavasyaTPNMTextView.layout.getLineEnd(500)
                }
                //    pageTenText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos10, endPos10)
                if (mTLineCount in 501..550) {
                    startPos11 = binding.AmavasyaTPNMTextView.layout.getLineStart(501)
                    endPos11 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos11 = binding.AmavasyaTPNMTextView.layout.getLineStart(501)
                    endPos11 = binding.AmavasyaTPNMTextView.layout.getLineEnd(550)
                }
                //    pageElevenText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos11, endPos11)
                if (mTLineCount in 551..600) {
                    startPos12 = binding.AmavasyaTPNMTextView.layout.getLineStart(551)
                    endPos12 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos12 = binding.AmavasyaTPNMTextView.layout.getLineStart(551)
                    endPos12 = binding.AmavasyaTPNMTextView.layout.getLineEnd(600)
                }
                //    pageTwelveText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos12, endPos12)
                if (mTLineCount in 601..650) {
                    startPos13 = binding.AmavasyaTPNMTextView.layout.getLineStart(601)
                    endPos13 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos13 = binding.AmavasyaTPNMTextView.layout.getLineStart(601)
                    endPos13 = binding.AmavasyaTPNMTextView.layout.getLineEnd(650)
                }
                //    pageThirteenText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos13, endPos13)
                if (mTLineCount in 651..700) {
                    startPos14 = binding.AmavasyaTPNMTextView.layout.getLineStart(651)
                    endPos14 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos14 = binding.AmavasyaTPNMTextView.layout.getLineStart(651)
                    endPos14 = binding.AmavasyaTPNMTextView.layout.getLineEnd(700)
                }
                //    pageFourteenText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos14, endPos14)
                if (mTLineCount in 701..750) {
                    startPos15 = binding.AmavasyaTPNMTextView.layout.getLineStart(701)
                    endPos15 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos15 = binding.AmavasyaTPNMTextView.layout.getLineStart(701)
                    endPos15 = binding.AmavasyaTPNMTextView.layout.getLineEnd(750)
                }
                //    pageFifteenText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos15, endPos15)
            }
            if (totalpages == 16) {
                startPos1 = binding.AmavasyaTPNMTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    endPos1 = binding.AmavasyaTPNMTextView.layout.getLineEnd(50)
                } else {
                    endPos1 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                }
                //   pageOneText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos1, endPos1)
                if (mTLineCount in 51..100) {
                    startPos2 = binding.AmavasyaTPNMTextView.layout.getLineStart(51)
                    endPos2 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos2 = binding.AmavasyaTPNMTextView.layout.getLineStart(51)
                    endPos2 = binding.AmavasyaTPNMTextView.layout.getLineEnd(100)
                }
                //    pageTwoText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos2, endPos2)
                if (mTLineCount in 101..150) {
                    startPos3 = binding.AmavasyaTPNMTextView.layout.getLineStart(101)
                    endPos3 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos3 = binding.AmavasyaTPNMTextView.layout.getLineStart(101)
                    endPos3 = binding.AmavasyaTPNMTextView.layout.getLineEnd(150)
                }
                //    pageThreeText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos3, endPos3)
                if (mTLineCount in 151..200) {
                    startPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(151)
                    endPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(151)
                    endPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(200)
                }
                //    pageFourText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos4, endPos4)
                if (mTLineCount in 201..250) {
                    startPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(201)
                    endPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(201)
                    endPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(250)
                }
                //    pageFiveText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos5, endPos5)
                if (mTLineCount in 251..300) {
                    startPos6 = binding.AmavasyaTPNMTextView.layout.getLineStart(251)
                    endPos6 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos6 = binding.AmavasyaTPNMTextView.layout.getLineStart(251)
                    endPos6 = binding.AmavasyaTPNMTextView.layout.getLineEnd(300)
                }
                //    pageSixText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos6, endPos6)
                if (mTLineCount in 301..350) {
                    startPos7 = binding.AmavasyaTPNMTextView.layout.getLineStart(301)
                    endPos7 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos7 = binding.AmavasyaTPNMTextView.layout.getLineStart(301)
                    endPos7 = binding.AmavasyaTPNMTextView.layout.getLineEnd(350)
                }
                //    pageSevenText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos7, endPos7)
                if (mTLineCount in 351..400) {
                    startPos8 = binding.AmavasyaTPNMTextView.layout.getLineStart(351)
                    endPos8 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos8 = binding.AmavasyaTPNMTextView.layout.getLineStart(351)
                    endPos8 = binding.AmavasyaTPNMTextView.layout.getLineEnd(400)
                }
                //    pageEightText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos8, endPos8)
                if (mTLineCount in 401..450) {
                    startPos9 = binding.AmavasyaTPNMTextView.layout.getLineStart(401)
                    endPos9 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos9 = binding.AmavasyaTPNMTextView.layout.getLineStart(401)
                    endPos9 = binding.AmavasyaTPNMTextView.layout.getLineEnd(450)
                }
                //    pageNineText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos9, endPos9)
                if (mTLineCount in 451..500) {
                    startPos10 = binding.AmavasyaTPNMTextView.layout.getLineStart(451)
                    endPos10 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos10 = binding.AmavasyaTPNMTextView.layout.getLineStart(451)
                    endPos10 = binding.AmavasyaTPNMTextView.layout.getLineEnd(500)
                }
                //    pageTenText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos10, endPos10)
                if (mTLineCount in 501..550) {
                    startPos11 = binding.AmavasyaTPNMTextView.layout.getLineStart(501)
                    endPos11 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos11 = binding.AmavasyaTPNMTextView.layout.getLineStart(501)
                    endPos11 = binding.AmavasyaTPNMTextView.layout.getLineEnd(550)
                }
                //    pageElevenText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos11, endPos11)
                if (mTLineCount in 551..600) {
                    startPos12 = binding.AmavasyaTPNMTextView.layout.getLineStart(551)
                    endPos12 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos12 = binding.AmavasyaTPNMTextView.layout.getLineStart(551)
                    endPos12 = binding.AmavasyaTPNMTextView.layout.getLineEnd(600)
                }
                //    pageTwelveText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos12, endPos12)
                if (mTLineCount in 601..650) {
                    startPos13 = binding.AmavasyaTPNMTextView.layout.getLineStart(601)
                    endPos13 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos13 = binding.AmavasyaTPNMTextView.layout.getLineStart(601)
                    endPos13 = binding.AmavasyaTPNMTextView.layout.getLineEnd(650)
                }
                //    pageThirteenText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos13, endPos13)
                if (mTLineCount in 651..700) {
                    startPos14 = binding.AmavasyaTPNMTextView.layout.getLineStart(651)
                    endPos14 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos14 = binding.AmavasyaTPNMTextView.layout.getLineStart(651)
                    endPos14 = binding.AmavasyaTPNMTextView.layout.getLineEnd(700)
                }
                //    pageFourteenText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos14, endPos14)
                if (mTLineCount in 701..750) {
                    startPos15 = binding.AmavasyaTPNMTextView.layout.getLineStart(701)
                    endPos15 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos15 = binding.AmavasyaTPNMTextView.layout.getLineStart(701)
                    endPos15 = binding.AmavasyaTPNMTextView.layout.getLineEnd(750)
                }
                //    pageFifteenText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos15, endPos15)
                if (mTLineCount in 751..800) {
                    startPos16 = binding.AmavasyaTPNMTextView.layout.getLineStart(751)
                    endPos16 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos16 = binding.AmavasyaTPNMTextView.layout.getLineStart(751)
                    endPos16 = binding.AmavasyaTPNMTextView.layout.getLineEnd(800)
                }
                //    pageSixteenText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos16, endPos16)
            }
            if (totalpages == 17) {
                startPos1 = binding.AmavasyaTPNMTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    endPos1 = binding.AmavasyaTPNMTextView.layout.getLineEnd(50)
                } else {
                    endPos1 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                }
                //    pageOneText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos1, endPos1)
                if (mTLineCount in 51..100) {
                    startPos2 = binding.AmavasyaTPNMTextView.layout.getLineStart(51)
                    endPos2 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos2 = binding.AmavasyaTPNMTextView.layout.getLineStart(51)
                    endPos2 = binding.AmavasyaTPNMTextView.layout.getLineEnd(100)
                }
                //    pageTwoText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos2, endPos2)
                if (mTLineCount in 101..150) {
                    startPos3 = binding.AmavasyaTPNMTextView.layout.getLineStart(101)
                    endPos3 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos3 = binding.AmavasyaTPNMTextView.layout.getLineStart(101)
                    endPos3 = binding.AmavasyaTPNMTextView.layout.getLineEnd(150)
                }
                //    pageThreeText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos3, endPos3)
                if (mTLineCount in 151..200) {
                    startPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(151)
                    endPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(151)
                    endPos4 = binding.AmavasyaTPNMTextView.layout.getLineEnd(200)
                }
                //    pageFourText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos4, endPos4)
                if (mTLineCount in 201..250) {
                    startPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(201)
                    endPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(201)
                    endPos5 = binding.AmavasyaTPNMTextView.layout.getLineEnd(250)
                }
                //    pageFiveText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos5, endPos5)
                if (mTLineCount in 251..300) {
                    startPos6 = binding.AmavasyaTPNMTextView.layout.getLineStart(251)
                    endPos6 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos6 = binding.AmavasyaTPNMTextView.layout.getLineStart(251)
                    endPos6 = binding.AmavasyaTPNMTextView.layout.getLineEnd(300)
                }
                //    pageSixText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos6, endPos6)
                if (mTLineCount in 301..350) {
                    startPos7 = binding.AmavasyaTPNMTextView.layout.getLineStart(301)
                    endPos7 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos7 = binding.AmavasyaTPNMTextView.layout.getLineStart(301)
                    endPos7 = binding.AmavasyaTPNMTextView.layout.getLineEnd(350)
                }
                //    pageSevenText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos7, endPos7)
                if (mTLineCount in 351..400) {
                    startPos8 = binding.AmavasyaTPNMTextView.layout.getLineStart(351)
                    endPos8 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos8 = binding.AmavasyaTPNMTextView.layout.getLineStart(351)
                    endPos8 = binding.AmavasyaTPNMTextView.layout.getLineEnd(400)
                }
                //    pageEightText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos8, endPos8)
                if (mTLineCount in 401..450) {
                    startPos9 = binding.AmavasyaTPNMTextView.layout.getLineStart(401)
                    endPos9 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos9 = binding.AmavasyaTPNMTextView.layout.getLineStart(401)
                    endPos9 = binding.AmavasyaTPNMTextView.layout.getLineEnd(450)
                }
                //    pageNineText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos9, endPos9)
                if (mTLineCount in 451..500) {
                    startPos10 = binding.AmavasyaTPNMTextView.layout.getLineStart(451)
                    endPos10 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos10 = binding.AmavasyaTPNMTextView.layout.getLineStart(451)
                    endPos10 = binding.AmavasyaTPNMTextView.layout.getLineEnd(500)
                }
                //    pageTenText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos10, endPos10)
                if (mTLineCount in 501..550) {
                    startPos11 = binding.AmavasyaTPNMTextView.layout.getLineStart(501)
                    endPos11 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos11 = binding.AmavasyaTPNMTextView.layout.getLineStart(501)
                    endPos11 = binding.AmavasyaTPNMTextView.layout.getLineEnd(550)
                }
                //    pageElevenText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos11, endPos11)
                if (mTLineCount in 551..600) {
                    startPos12 = binding.AmavasyaTPNMTextView.layout.getLineStart(551)
                    endPos12 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos12 = binding.AmavasyaTPNMTextView.layout.getLineStart(551)
                    endPos12 = binding.AmavasyaTPNMTextView.layout.getLineEnd(600)
                }
                //    pageTwelveText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos12, endPos12)
                if (mTLineCount in 601..650) {
                    startPos13 = binding.AmavasyaTPNMTextView.layout.getLineStart(601)
                    endPos13 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos13 = binding.AmavasyaTPNMTextView.layout.getLineStart(601)
                    endPos13 = binding.AmavasyaTPNMTextView.layout.getLineEnd(650)
                }
                //    pageThirteenText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos13, endPos13)
                if (mTLineCount in 651..700) {
                    startPos14 = binding.AmavasyaTPNMTextView.layout.getLineStart(651)
                    endPos14 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos14 = binding.AmavasyaTPNMTextView.layout.getLineStart(651)
                    endPos14 = binding.AmavasyaTPNMTextView.layout.getLineEnd(700)
                }
                //    pageFourteenText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos14, endPos14)
                if (mTLineCount in 701..750) {
                    startPos15 = binding.AmavasyaTPNMTextView.layout.getLineStart(701)
                    endPos15 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos15 = binding.AmavasyaTPNMTextView.layout.getLineStart(701)
                    endPos15 = binding.AmavasyaTPNMTextView.layout.getLineEnd(750)
                }
                //     pageFifteenText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos15, endPos15)
                if (mTLineCount in 751..800) {
                    startPos16 = binding.AmavasyaTPNMTextView.layout.getLineStart(751)
                    endPos16 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos16 = binding.AmavasyaTPNMTextView.layout.getLineStart(751)
                    endPos16 = binding.AmavasyaTPNMTextView.layout.getLineEnd(800)
                }
                //    pageSixteenText = binding.AmavasyaTPNMTextView.text.toString().substring(startPos16, endPos16)
                if (mTLineCount in 801..850) {
                    startPos17 = binding.AmavasyaTPNMTextView.layout.getLineStart(801)
                    endPos17 = binding.AmavasyaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    startPos17 = binding.AmavasyaTPNMTextView.layout.getLineStart(801)
                    endPos17 = binding.AmavasyaTPNMTextView.layout.getLineEnd(850)
                }
                //    pageSeventeenText = AmavasyaTPNMTextView.text.toString().substring(startPos17, endPos17)
            }
            val printManager = this.getSystemService(Context.PRINT_SERVICE) as PrintManager
            val jobName = this.getString(R.string.app_name) + "-$heading"
            println("jobName : $jobName")
            printManager.print(jobName, MyPrintDocumentAdapter(this), null)
        }
    }
}
