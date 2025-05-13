package com.karma.sureshtrb.enKarma

//import kotlinx.android.synthetic.main.activity_about.*
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.text.style.UnderlineSpan
import androidx.appcompat.app.AppCompatActivity
import com.karma.sureshtrb.enKarma.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    var exExFlag = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
    var incIncFlag = Spanned.SPAN_INCLUSIVE_INCLUSIVE
    var start: Int = 0
    private lateinit var binding: ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            //setContentView(R.layout.activity_about)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.setHomeAsUpIndicator(R.drawable.home)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.subtitle = "குறிப்பு"
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setLogo(R.drawable.karma)
        supportActionBar!!.setDisplayUseLogoEnabled(true)

        val ahdSt1 = SpannableString("\n" +
                "\n" +
                "\n" +
                "\n             ABOUT\n")
        ahdSt1.setSpan(AbsoluteSizeSpan(20, true), start, ahdSt1.length, exExFlag)
        ahdSt1.setSpan(StyleSpan(Typeface.BOLD), start, ahdSt1.length, exExFlag)
        ahdSt1.setSpan(UnderlineSpan(), 17, ahdSt1.length, exExFlag)
        ahdSt1.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, ahdSt1.length, exExFlag)

        val astr1 = SpannableString("     This app is specific to Sukla Yajur Veda division " +
                "\n\n     This is a guide for those who are unable to have a Guru \n  (Vadiyar) nearby to carryout their Nithya Karma / Tharpanam \n  on the occurances.\n " +
                "\n     (If your family Guru is reacheable your should follow their instructions only.) ")
        astr1.setSpan(AbsoluteSizeSpan(10, true), start, astr1.length, exExFlag)
        astr1.setSpan(StyleSpan(Typeface.ITALIC), start, astr1.length, exExFlag)
        astr1.setSpan(ForegroundColorSpan(Color.GRAY), start, astr1.length, exExFlag)

        val astr2 = SpannableString("\n\n\n\n     Notes:\n\n")
        astr2.setSpan(AbsoluteSizeSpan(10, true), start, astr2.length, exExFlag)
        astr2.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, astr2.length, exExFlag)
        astr2.setSpan(UnderlineSpan(), 9, astr2.length, exExFlag)
        astr2.setSpan(ForegroundColorSpan(Color.BLACK), start, astr2.length, exExFlag)

        val astr3 = SpannableString("\n     While doing Tharpanam please note the following:" +
                "\n\n     =  Only who's father is deceased are eligible \n" +
                "     The app is prepared under the guidance of")
        astr3.setSpan(AbsoluteSizeSpan(10, true), start, astr3.length, exExFlag)
        astr3.setSpan(StyleSpan(Typeface.ITALIC), start, astr3.length, exExFlag)
        astr3.setSpan(ForegroundColorSpan(Color.GRAY), start, astr3.length, exExFlag)

        val abdSt0 = SpannableString(" " +
                "\n\n   *   Sri Srinivas Sastrigal, " +
                "\n         Porur, Chennai, India" +
                "\n\n   *   Sri P.V.Pattabirama Sastrigal, \n" +
                "           Old Pallavaram, Chennai, India" +
                "\n\n   *   Sri Srinivasn Sastrigal, \n" +
                "           Old Pallavaram, Chennai, India " +
                "\n\n   *   Reference: " +
                "\n         SUKLA YAJUR VEDA KANVASAGA SANDYAVANTHANAM\n")
        abdSt0.setSpan(AbsoluteSizeSpan(12, true), start, abdSt0.length, exExFlag)
        abdSt0.setSpan(StyleSpan(Typeface.BOLD), start, abdSt0.length, exExFlag)
        abdSt0.setSpan(ForegroundColorSpan(Color.BLUE), start, abdSt0.length, exExFlag)

        val about_combination = SpannableStringBuilder()
        about_combination.append(ahdSt1, astr1, astr2, astr3, abdSt0)
        binding.aboutTextView.text = about_combination
    }
}
