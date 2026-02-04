package com.karma.sureshtrb.enKarma

//import com.tjeannin.apprate.AppRate

//import kotlinx.android.synthetic.main.activity_gayathri_japam.*
//import android.annotation.TargetApi
//import android.os.Build
//import androidx.annotation.RequiresApi
//import kotlin.div
//import kotlin.text.toFloat
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.pdf.PdfDocument
import android.os.Bundle
import android.os.CancellationSignal
import android.os.ParcelFileDescriptor
import android.print.PageRange
import android.print.PrintAttributes
import android.print.PrintDocumentAdapter
import android.print.PrintDocumentInfo
import android.print.PrintManager
import android.print.pdf.PrintedPdfDocument
import android.text.Layout
import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.StaticLayout
import android.text.TextPaint
import android.text.style.AbsoluteSizeSpan
import android.text.style.ForegroundColorSpan
import android.text.style.ImageSpan
import android.text.style.StyleSpan
import android.text.style.UnderlineSpan
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.karma.sureshtrb.enKarma.databinding.ActivityGayathriJapamBinding
import java.io.FileOutputStream
import java.io.IOException
import kotlin.toString

class GayathriJapamActivity : AppCompatActivity() {

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
  
  private fun applySpans(text: String, size: Int, style: Int, color: Int, underline: Boolean = false): SpannableString {
    val spannableString = SpannableString(text)
    spannableString.setSpan(AbsoluteSizeSpan(size, true), 0, spannableString.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    spannableString.setSpan(StyleSpan(style), 0, spannableString.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    spannableString.setSpan(ForegroundColorSpan(color), 0, spannableString.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    if (underline) {
      spannableString.setSpan(UnderlineSpan(), 0, spannableString.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    }
    return spannableString
  }

   @SuppressLint("WrongViewCast")
   private lateinit var binding: ActivityGayathriJapamBinding
    override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      // setContentView(R.layout.activity_gayathri_japam)
      binding = ActivityGayathriJapamBinding.inflate(layoutInflater)
      setContentView(binding.root)
      /*
     AppRate(this)
       .setShowIfAppHasCrashed(false)
       .setMinDaysUntilPrompt(7)
       .setMinLaunchesUntilPrompt(20)
       .init()
*/
      val printBtn = findViewById<Button>(R.id.printButton)

      supportActionBar!!.setHomeAsUpIndicator(R.drawable.home)
      supportActionBar!!.setDisplayHomeAsUpEnabled(true)
      supportActionBar!!.subtitle = "Gayathri Japam / காயத்ரீ ஜபம்"
      supportActionBar!!.setDisplayShowHomeEnabled(true)
      supportActionBar!!.setLogo(R.drawable.karma)
      supportActionBar!!.setDisplayUseLogoEnabled(true)

      val intent = intent

      val sandyaType: String = intent.getStringExtra("sandhi").toString()
      val pravarasYour: String = intent.getStringExtra("pravaras").toString()
      val gothramYour: String = intent.getStringExtra("gothram").toString()
      val nameYour: String = intent.getStringExtra("name").toString()

      val exExFlag = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
      //  var incIncFlag = Spanned.SPAN_INCLUSIVE_INCLUSIVE
      val start: Int = 0

      val heading = SpannableString("$sandyaType - $nameYour)\n")

      // Usage:
      val comSt1 = applySpans("(காயத்ரீ ஜபத்தை காலை/மதியம்-கிழக்கு; மாலை-மேற்கு)\n", 10, Typeface.ITALIC, Color.DKGRAY)
      val hdSt1 = applySpans("ஆசமனம்\n", 16, Typeface.BOLD, Color.parseColor("#8b008b"), true)
      val comSt2 = applySpans("\n(ஒவ்வொரு உத்தரிணி ஜலம் எடுத்து வலது கையில் விட்டு ஒவ்வொரு மந்திரத்துக்கும் உட்கொள்ளவும்)", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt1 = applySpans("- ஓம் அச்யுதாய நம: |  ஓம் அனந்தாய நம: |  ஓம் கோவிந்தாய நம: ||", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt3 = applySpans("\n(ஒரு உத்தரிணி ஜலம் எடுத்து வலது கையில் விட்டு கீழே விடவும்)", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt2 = applySpans("- அபஉபஸ்ப்ருஸ்ய ||\n", 12, Typeface.BOLD, Color.parseColor("#0000ee"))


      val comSt4 =
        SpannableString("\n(வலது கட்டை விரலால் வாயை துடைத்துக் கொள்ளவும்)\n(விரல்களால் அங்கங்களை தொடவும்)\n(நடு+மோதிர விரல்)-வலது கன்னம்")
      comSt4.setSpan(AbsoluteSizeSpan(10, true), start, comSt4.length, exExFlag)
      comSt4.setSpan(StyleSpan(Typeface.ITALIC), start, comSt4.length, exExFlag)
      comSt4.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt4.length, exExFlag)

      val bdSt3 = SpannableString("- கேசவா")
      bdSt3.setSpan(AbsoluteSizeSpan(12, true), start, bdSt3.length, exExFlag)
      bdSt3.setSpan(StyleSpan(Typeface.BOLD), start, bdSt3.length, exExFlag)
      bdSt3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt3.length, exExFlag)

      val comSt5 = SpannableString("\n(நடு+மோதிர விரல்)-இடது கன்னம்")
      comSt5.setSpan(AbsoluteSizeSpan(10, true), start, comSt5.length, exExFlag)
      comSt5.setSpan(StyleSpan(Typeface.ITALIC), start, comSt5.length, exExFlag)
      comSt5.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt5.length, exExFlag)

      val bdSt4 = SpannableString("- நாராயணா")
      bdSt4.setSpan(AbsoluteSizeSpan(12, true), start, bdSt4.length, exExFlag)
      bdSt4.setSpan(StyleSpan(Typeface.BOLD), start, bdSt4.length, exExFlag)
      bdSt4.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt4.length, exExFlag)

      val comSt6 = SpannableString("\n(ஆள்காட்டி+கட்டை விரல்)-வலது மூக்கு")
      comSt6.setSpan(AbsoluteSizeSpan(10, true), start, comSt6.length, exExFlag)
      comSt6.setSpan(StyleSpan(Typeface.ITALIC), start, comSt6.length, exExFlag)
      comSt6.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt6.length, exExFlag)

      val bdSt5 = SpannableString("- மாதவா")
      bdSt5.setSpan(AbsoluteSizeSpan(12, true), start, bdSt5.length, exExFlag)
      bdSt5.setSpan(StyleSpan(Typeface.BOLD), start, bdSt5.length, exExFlag)
      bdSt5.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt5.length, exExFlag)

      val comSt7 = SpannableString("\n(ஆள்காட்டி+கட்டை விரல்)-இடது மூக்கு")
      comSt7.setSpan(AbsoluteSizeSpan(10, true), start, comSt7.length, exExFlag)
      comSt7.setSpan(StyleSpan(Typeface.ITALIC), start, comSt7.length, exExFlag)
      comSt7.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt7.length, exExFlag)

      val bdSt6 = SpannableString("- கோவிந்தா")
      bdSt6.setSpan(AbsoluteSizeSpan(12, true), start, bdSt6.length, exExFlag)
      bdSt6.setSpan(StyleSpan(Typeface.BOLD), start, bdSt6.length, exExFlag)
      bdSt6.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt6.length, exExFlag)

      val comSt8 = SpannableString("\n(நடு+கட்டை விரல்)-வலது கண்")
      comSt8.setSpan(AbsoluteSizeSpan(10, true), start, comSt8.length, exExFlag)
      comSt8.setSpan(StyleSpan(Typeface.ITALIC), start, comSt8.length, exExFlag)
      comSt8.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt8.length, exExFlag)

      val bdSt7 = SpannableString("- விஷ்ணு")
      bdSt7.setSpan(AbsoluteSizeSpan(12, true), start, bdSt7.length, exExFlag)
      bdSt7.setSpan(StyleSpan(Typeface.BOLD), start, bdSt7.length, exExFlag)
      bdSt7.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt7.length, exExFlag)

      val comSt9 = SpannableString("\n(நடு+கட்டை விரல்)-இடது கண்")
      comSt9.setSpan(AbsoluteSizeSpan(10, true), start, comSt9.length, exExFlag)
      comSt9.setSpan(StyleSpan(Typeface.ITALIC), start, comSt9.length, exExFlag)
      comSt9.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt9.length, exExFlag)

      val bdSt8 = SpannableString("- மதுஸூதனா")
      bdSt8.setSpan(AbsoluteSizeSpan(12, true), start, bdSt8.length, exExFlag)
      bdSt8.setSpan(StyleSpan(Typeface.BOLD), start, bdSt8.length, exExFlag)
      bdSt8.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt8.length, exExFlag)

      val comSt10 = SpannableString("\n(மோதிர+கட்டை விரல்)-வலது காது")
      comSt10.setSpan(AbsoluteSizeSpan(10, true), start, comSt10.length, exExFlag)
      comSt10.setSpan(StyleSpan(Typeface.ITALIC), start, comSt10.length, exExFlag)
      comSt10.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt10.length, exExFlag)

      val bdSt9 = SpannableString("- த்ரிவிக்ரமா")
      bdSt9.setSpan(AbsoluteSizeSpan(12, true), start, bdSt9.length, exExFlag)
      bdSt9.setSpan(StyleSpan(Typeface.BOLD), start, bdSt9.length, exExFlag)
      bdSt9.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, bdSt9.length, exExFlag)

      val comSt11 = SpannableString("\n(மோதிர+கட்டை விரல்)-இடது காது")
      comSt11.setSpan(AbsoluteSizeSpan(10, true), start, comSt11.length, exExFlag)
      comSt11.setSpan(StyleSpan(Typeface.ITALIC), start, comSt11.length, exExFlag)
      comSt11.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt11.length, exExFlag)

      val bdSt10 = SpannableString("- வாமனா")
      bdSt10.setSpan(AbsoluteSizeSpan(12, true), start, bdSt10.length, exExFlag)
      bdSt10.setSpan(StyleSpan(Typeface.BOLD), start, bdSt10.length, exExFlag)
      bdSt10.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt10.length,
        exExFlag
      )

      val comSt12 = SpannableString("\n(வலது உள்ளங்கை)-மார்பு")
      comSt12.setSpan(AbsoluteSizeSpan(10, true), start, comSt12.length, exExFlag)
      comSt12.setSpan(StyleSpan(Typeface.ITALIC), start, comSt12.length, exExFlag)
      comSt12.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt12.length, exExFlag)

      val bdSt11 = SpannableString("- ஸ்ரீதரா")
      bdSt11.setSpan(AbsoluteSizeSpan(12, true), start, bdSt11.length, exExFlag)
      bdSt11.setSpan(StyleSpan(Typeface.BOLD), start, bdSt11.length, exExFlag)
      bdSt11.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt11.length,
        exExFlag
      )

      val comSt13 = SpannableString("\n(ஐந்து விரல் நுனி)-முன் தலை")
      comSt13.setSpan(AbsoluteSizeSpan(10, true), start, comSt13.length, exExFlag)
      comSt13.setSpan(StyleSpan(Typeface.ITALIC), start, comSt13.length, exExFlag)
      comSt13.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt13.length, exExFlag)

      val bdSt12 = SpannableString("- ஹ்ருஷீகேஷா")
      bdSt12.setSpan(AbsoluteSizeSpan(12, true), start, bdSt12.length, exExFlag)
      bdSt12.setSpan(StyleSpan(Typeface.BOLD), start, bdSt12.length, exExFlag)
      bdSt12.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt12.length,
        exExFlag
      )

      val comSt14 = SpannableString("\n(ஐந்து விரல் நுனி)-வலது தோள்")
      comSt14.setSpan(AbsoluteSizeSpan(10, true), start, comSt14.length, exExFlag)
      comSt14.setSpan(StyleSpan(Typeface.ITALIC), start, comSt14.length, exExFlag)
      comSt14.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt14.length, exExFlag)

      val bdSt13 = SpannableString("- பத்மநாபா")
      bdSt13.setSpan(AbsoluteSizeSpan(12, true), start, bdSt13.length, exExFlag)
      bdSt13.setSpan(StyleSpan(Typeface.BOLD), start, bdSt13.length, exExFlag)
      bdSt13.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt13.length,
        exExFlag
      )

      val comSt15 = SpannableString("\n(ஐந்து விரல் நுனி)-இடது தோள்")
      comSt15.setSpan(AbsoluteSizeSpan(10, true), start, comSt15.length, exExFlag)
      comSt15.setSpan(StyleSpan(Typeface.ITALIC), start, comSt15.length, exExFlag)
      comSt15.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt15.length, exExFlag)

      val bdSt14 = SpannableString("- தாமோதரா\n")
      bdSt14.setSpan(AbsoluteSizeSpan(12, true), start, bdSt14.length, exExFlag)
      bdSt14.setSpan(StyleSpan(Typeface.BOLD), start, bdSt14.length, exExFlag)
      bdSt14.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt14.length,
        exExFlag
      )

      val hdSt2 = SpannableString("\nகணேச ப்ரார்த்தனை")
      hdSt2.setSpan(AbsoluteSizeSpan(16, true), start, hdSt2.length, exExFlag)
      hdSt2.setSpan(StyleSpan(Typeface.BOLD), start, hdSt2.length, exExFlag)
      hdSt2.setSpan(UnderlineSpan(), start, hdSt2.length, exExFlag)
      hdSt2.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, hdSt2.length, exExFlag)

      val comSt16 =
        SpannableString("\n(இரண்டு கைவிரல்களையும் மடித்துக் கொண்டு, தலையின் இரு பொட்டிலும் ஐந்து முறை குட்டிக் கொள்ளவும்)")
      comSt16.setSpan(AbsoluteSizeSpan(10, true), start, comSt16.length, exExFlag)
      comSt16.setSpan(StyleSpan(Typeface.ITALIC), start, comSt16.length, exExFlag)
      comSt16.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt16.length, exExFlag)

      val bdSt15 =
        SpannableString("\nசுக்லாம் பரதரம் விஷ்ணும்\n   சசிவர்ணம் சதுர்புஜம் |\nப்ரஸன்ன வதனம் த்யாயேத்\n   ஸர்வ விக்நோப சாந்தயே ||\n")
      bdSt15.setSpan(AbsoluteSizeSpan(12, true), start, bdSt15.length, exExFlag)
      bdSt15.setSpan(StyleSpan(Typeface.BOLD), start, bdSt15.length, exExFlag)
      bdSt15.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt15.length,
        exExFlag
      )

      val hdSt3 = SpannableString("\nப்ராணாயாமம்")
      hdSt3.setSpan(AbsoluteSizeSpan(16, true), start, hdSt3.length, exExFlag)
      hdSt3.setSpan(StyleSpan(Typeface.BOLD), start, hdSt3.length, exExFlag)
      hdSt3.setSpan(UnderlineSpan(), start, hdSt3.length, exExFlag)
      hdSt3.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, hdSt3.length, exExFlag)

      val comSt17 =
        SpannableString("\n(வலது கை கட்டை விரலால் வலது மூக்கை மேல்புறமாக மூடி இடநாசியால் மூச்சை உள்ளிழுத்து பின் வலது மோதிர மற்றும் சுண்டு ஆகிய விரலால் இடது மூக்கை மேல் பறமாக மூடி இம்மந்திரத்தை கூறவும்)\n")
      comSt17.setSpan(AbsoluteSizeSpan(10, true), start, comSt17.length, exExFlag)
      comSt17.setSpan(StyleSpan(Typeface.ITALIC), start, comSt17.length, exExFlag)
      comSt17.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt17.length, exExFlag)

      val comSt17Ten =
        SpannableString("\n(வலது கை கட்டை விரலால் வலது மூக்கை மேல்புறமாக மூடி இடநாசியால் மூச்சை உள்ளிழுத்து பின் வலது மோதிர மற்றும் சுண்டு ஆகிய விரலால் இடது மூக்கை மேல் பறமாக மூடி இம்மந்திரத்தை 10 முறை கூறவும்)\n")
      comSt17Ten.setSpan(AbsoluteSizeSpan(10, true), start, comSt17Ten.length, exExFlag)
      comSt17Ten.setSpan(StyleSpan(Typeface.ITALIC), start, comSt17Ten.length, exExFlag)
      comSt17Ten.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt17Ten.length, exExFlag)

      val bdSt16 =
        SpannableString("\nஓம் பூ: ஓம்புவா:\n   ஓம் ஸுவா: ஓம் மஹ: \nஓம் ஜன: ஓம் தப:\n   ஓம் ஸத்யம் ஓம் தத்ஸவிதுர் வரேண்யம் \n   பர்கோ தேவஸ்ய தீமஹி | \nதியோ யோந: ப்ரசோதயாத் |\n   ஓம் ஆபோ ஜ்யோதீரஸோ \nஅம்ருதம் ப்ரம்ம பூர்புவஸ்வரோம் ||")
      bdSt16.setSpan(AbsoluteSizeSpan(12, true), start, bdSt16.length, exExFlag)
      bdSt16.setSpan(StyleSpan(Typeface.BOLD), start, bdSt16.length, exExFlag)
      bdSt16.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt16.length,
        exExFlag
      )

      val comSt18 = SpannableString("\n(வலது கையால் வலது காதை தொடடு)-")
      comSt18.setSpan(AbsoluteSizeSpan(10, true), start, comSt18.length, exExFlag)
      comSt18.setSpan(StyleSpan(Typeface.ITALIC), start, comSt18.length, exExFlag)
      comSt18.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt18.length, exExFlag)

      val bdSt17 = SpannableString("\nஓம்  ஓம்  ஓம் ||\n")
      bdSt17.setSpan(AbsoluteSizeSpan(12, true), start, bdSt17.length, exExFlag)
      bdSt17.setSpan(StyleSpan(Typeface.BOLD), start, bdSt17.length, exExFlag)
      bdSt17.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt17.length,
        exExFlag
      )

      val hdSt4 = SpannableString("\nஸங்கல்பம்")
      hdSt4.setSpan(AbsoluteSizeSpan(16, true), start, hdSt4.length, exExFlag)
      hdSt4.setSpan(StyleSpan(Typeface.BOLD), start, hdSt4.length, exExFlag)
      hdSt4.setSpan(UnderlineSpan(), start, hdSt4.length, exExFlag)
      hdSt4.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, hdSt4.length, exExFlag)

      val comSt19 =
        SpannableString("\n(வலது தொடையின் மீது இடது கையை மேற்புறமாக வைத்துக் கொண்டு, அதன் மேல் வலது கையை வைத்து மூடினாட்போல் வைத்து)")
      comSt19.setSpan(AbsoluteSizeSpan(10, true), start, comSt19.length, exExFlag)
      comSt19.setSpan(StyleSpan(Typeface.ITALIC), start, comSt19.length, exExFlag)
      comSt19.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt19.length, exExFlag)

      val bdSt18A =
        SpannableString("\n   மமோபாத்த ஸமஸ்த துரிதஷயத் வாரா ஸ்ரீபரமேச்வர ப்ரீத்யர்த்தம் TYPEOFSANDYA காயத்ரீ மஹாமந்த்ர ஜபம் கரிஷ்யே ||\n அப உப ஸ்ப்ருச்ய ||")
      val regexReplace1 = """(TYPEOFSANDYA)""".toRegex()
      val bdSt18 = SpannableString(bdSt18A.replace(regexReplace1, sandyaType))
      bdSt18.setSpan(AbsoluteSizeSpan(12, true), start, bdSt18.length, exExFlag)
      bdSt18.setSpan(StyleSpan(Typeface.BOLD), start, bdSt18.length, exExFlag)
      bdSt18.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt18.length,
        exExFlag
      )

      val comSt20 =
        SpannableString("-(ஜலத்தால் கைகளை துடைத்துக் கொள்ளவும்)\n\n (எழுந்து நின்று கைகூப்பி ப்ராத்தித்து நமஸ்கரிக்கவும்)\n")
      comSt20.setSpan(AbsoluteSizeSpan(10, true), start, comSt20.length, exExFlag)
      comSt20.setSpan(StyleSpan(Typeface.ITALIC), start, comSt20.length, exExFlag)
      comSt20.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt20.length, exExFlag)

      val bdSt19 =
        SpannableString("   ஆப்ரம்ம லோகாத் ஆசேஷாத்\nஆலோகாலோகபர்வதாத் |\n   யே வஸந்தி த்விஜா தேவா: \nதேப்யோ நித்யம் நமோ நம: ||\nநமோ ப்ரம்மண்ய தேவாய \nகோப்ராம்மண ஹிதாய ச |\nஜகத்திதாய க்ருஷ்ணாய \nகோவிந்தாய நமோ நம: ||\n")
      bdSt19.setSpan(AbsoluteSizeSpan(12, true), start, bdSt19.length, exExFlag)
      bdSt19.setSpan(StyleSpan(Typeface.BOLD), start, bdSt19.length, exExFlag)
      bdSt19.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt19.length,
        exExFlag
      )

      val hdSt5 = SpannableString("\nஅபிவாதனம்")
      hdSt5.setSpan(AbsoluteSizeSpan(16, true), start, hdSt5.length, exExFlag)
      hdSt5.setSpan(StyleSpan(Typeface.BOLD), start, hdSt5.length, exExFlag)
      hdSt5.setSpan(UnderlineSpan(), start, hdSt5.length, exExFlag)
      hdSt5.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, hdSt5.length, exExFlag)

      val hdSt5A = SpannableString("\nஅபிவாதனம்")
      hdSt5A.setSpan(AbsoluteSizeSpan(16, true), start, hdSt5A.length, exExFlag)
      hdSt5A.setSpan(StyleSpan(Typeface.BOLD), start, hdSt5A.length, exExFlag)
      hdSt5A.setSpan(UnderlineSpan(), start, hdSt5A.length, exExFlag)
      hdSt5A.setSpan(
        ForegroundColorSpan(Color.parseColor("#8b008b")),
        start,
        hdSt5A.length,
        exExFlag
      )

      val hdSt5B = SpannableString("\nஅபிவாதனம்")
      hdSt5B.setSpan(AbsoluteSizeSpan(16, true), start, hdSt5B.length, exExFlag)
      hdSt5B.setSpan(StyleSpan(Typeface.BOLD), start, hdSt5B.length, exExFlag)
      hdSt5B.setSpan(UnderlineSpan(), start, hdSt5B.length, exExFlag)
      hdSt5B.setSpan(
        ForegroundColorSpan(Color.parseColor("#8b008b")),
        start,
        hdSt5B.length,
        exExFlag
      )

      val bdSt20A =
        SpannableString("\n   அபிவாதயே yourPravaras ப்ரவரான்வித: yourGothram கோத்ர: காத்யாயன ஸூத்ர: ஸ்ரீஶுக்ல யஜூர் வேத காண்வஶாகாத்யாயீ ஸ்ரீ yourName ஶர்மா நாமாஹம் அஹம் அஸ்மி போ:|\n")
      val regexReplace2 = """(yourPravaras)""".toRegex()
      val bdSt20B = SpannableString(bdSt20A.replace(regexReplace2, pravarasYour))
      val regexReplace3 = """(yourGothram)""".toRegex()
      val bdSt20C = SpannableString(bdSt20B.replace(regexReplace3, gothramYour))
      val regexReplace4 = """(yourName)""".toRegex()
      val bdSt20 = SpannableString(bdSt20C.replace(regexReplace4, nameYour))
      bdSt20.setSpan(AbsoluteSizeSpan(12, true), start, bdSt20.length, exExFlag)
      bdSt20.setSpan(StyleSpan(Typeface.BOLD), start, bdSt20.length, exExFlag)
      bdSt20.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt20.length,
        exExFlag
      )

      val bdSt20D =
        SpannableString("\n   அபிவாதயே yourPravaras ப்ரவரான்வித: yourGothram கோத்ர: காத்யாயன ஸூத்ர: ஸ்ரீஶுக்ல யஜூர் வேத காண்வஶாகாத்யாயீ ஸ்ரீ yourName ஶர்மா நாமாஹம் அஹம் அஸ்மி போ:|\n")
      val regexReplace5 = """(yourPravaras)""".toRegex()
      val bdSt20E = SpannableString(bdSt20D.replace(regexReplace5, pravarasYour))
      val regexReplace6 = """(yourGothram)""".toRegex()
      val bdSt20F = SpannableString(bdSt20E.replace(regexReplace6, gothramYour))
      val regexReplace7 = """(yourName)""".toRegex()
      val bdSt20G = SpannableString(bdSt20F.replace(regexReplace7, nameYour))
      bdSt20G.setSpan(AbsoluteSizeSpan(12, true), start, bdSt20G.length, exExFlag)
      bdSt20G.setSpan(StyleSpan(Typeface.BOLD), start, bdSt20G.length, exExFlag)
      bdSt20G.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt20G.length,
        exExFlag
      )

      val bdSt20H =
        SpannableString("\n   அபிவாதயே yourPravaras ப்ரவரான்வித: yourGothram கோத்ர: காத்யாயன ஸூத்ர: ஸ்ரீஶுக்ல யஜூர் வேத காண்வஶாகாத்யாயீ ஸ்ரீ yourName ஶர்மா நாமாஹம் அஹம் அஸ்மி போ:|\n")
      val regexReplace8 = """(yourPravaras)""".toRegex()
      val bdSt20I = SpannableString(bdSt20H.replace(regexReplace8, pravarasYour))
      val regexReplace9 = """(yourGothram)""".toRegex()
      val bdSt20J = SpannableString(bdSt20I.replace(regexReplace9, gothramYour))
      val regexReplace10 = """(yourName)""".toRegex()
      val bdSt20K = SpannableString(bdSt20J.replace(regexReplace10, nameYour))
      bdSt20K.setSpan(AbsoluteSizeSpan(12, true), start, bdSt20K.length, exExFlag)
      bdSt20K.setSpan(StyleSpan(Typeface.BOLD), start, bdSt20K.length, exExFlag)
      bdSt20K.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt20K.length,
        exExFlag
      )

      val hdSt6 = SpannableString("\nஆஸனமந்திரம்")
      hdSt6.setSpan(AbsoluteSizeSpan(16, true), start, hdSt6.length, exExFlag)
      hdSt6.setSpan(StyleSpan(Typeface.BOLD), start, hdSt6.length, exExFlag)
      hdSt6.setSpan(UnderlineSpan(), start, hdSt6.length, exExFlag)
      hdSt6.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, hdSt6.length, exExFlag)

      val comSt21 = SpannableString("\nமுன் தலையைத் தொட்டு- ")
      comSt21.setSpan(AbsoluteSizeSpan(10, true), start, comSt21.length, exExFlag)
      comSt21.setSpan(StyleSpan(Typeface.ITALIC), start, comSt21.length, exExFlag)
      comSt21.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt21.length, exExFlag)

      val bdSt21 = SpannableString("ஆஸன மந்த்ரஸ்யப்ருதிவ்யா மேருப்ருஷ்ட ரிஷி: |")
      bdSt21.setSpan(AbsoluteSizeSpan(12, true), start, bdSt21.length, exExFlag)
      bdSt21.setSpan(StyleSpan(Typeface.BOLD), start, bdSt21.length, exExFlag)
      bdSt21.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt21.length,
        exExFlag
      )

      val comSt22 = SpannableString("\nமூக்கைத் தொட்டு-  ")
      comSt22.setSpan(AbsoluteSizeSpan(10, true), start, comSt22.length, exExFlag)
      comSt22.setSpan(StyleSpan(Typeface.ITALIC), start, comSt22.length, exExFlag)
      comSt22.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt22.length, exExFlag)

      val bdSt22 = SpannableString("ஸூதலம் ச்சந்த: |")
      bdSt22.setSpan(AbsoluteSizeSpan(12, true), start, bdSt22.length, exExFlag)
      bdSt22.setSpan(StyleSpan(Typeface.BOLD), start, bdSt22.length, exExFlag)
      bdSt22.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt22.length,
        exExFlag
      )

      val comSt23 = SpannableString("\nமார்பைத் தொட்டு- ")
      comSt23.setSpan(AbsoluteSizeSpan(10, true), start, comSt23.length, exExFlag)
      comSt23.setSpan(StyleSpan(Typeface.ITALIC), start, comSt23.length, exExFlag)
      comSt23.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt23.length, exExFlag)

      val bdSt23 = SpannableString("கூர்மரூபீ நாராயணோ தேவதா |")
      bdSt23.setSpan(AbsoluteSizeSpan(12, true), start, bdSt23.length, exExFlag)
      bdSt23.setSpan(StyleSpan(Typeface.BOLD), start, bdSt23.length, exExFlag)
      bdSt23.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt23.length,
        exExFlag
      )

      val comSt24 = SpannableString("\nகைகளை உள்வாங்கவும்- ")
      comSt24.setSpan(AbsoluteSizeSpan(10, true), start, comSt24.length, exExFlag)
      comSt24.setSpan(StyleSpan(Typeface.ITALIC), start, comSt24.length, exExFlag)
      comSt24.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt24.length, exExFlag)

      val bdSt24 = SpannableString("ஆஸனே வினியோக: ||")
      bdSt24.setSpan(AbsoluteSizeSpan(12, true), start, bdSt24.length, exExFlag)
      bdSt24.setSpan(StyleSpan(Typeface.BOLD), start, bdSt24.length, exExFlag)
      bdSt24.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt24.length,
        exExFlag
      )

      val comSt25 = SpannableString("\nகை கூப்பி- \n")
      comSt25.setSpan(AbsoluteSizeSpan(10, true), start, comSt25.length, exExFlag)
      comSt25.setSpan(StyleSpan(Typeface.ITALIC), start, comSt25.length, exExFlag)
      comSt25.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt25.length, exExFlag)

      val bdSt25 = SpannableString(
        "கூர்மாஸனாய நம: அனந்தாஸனாய நம: பத்மாஸனாய நம: \nகருடாஸனாய நம:ஸிம்மாஸனாய நம: ||   " +
                "\nப்ருத்வி த்வயா த்ருதா  \nலோகா தேவி த்வம் விஷ்ணுநா த்ருதா |\nத்வஞ்ச தாரயமாம் தேவி பவித்ரம் குரு சாஸனம்||\n" +
                "ஓம் பூர்புவஸ்ஸுவ: ஸுகாஸனம் ||\nஉக்ரபூதபிசாசாத்யா யே ச வை பூமிதாரகா:|\nஏதேஷாம் அவிரோதேன ஜபகர்ம ஸமாரபே|| \nஅபஸர்பந்து தே பூதா" +
                "யே பூதா பூமி ஸம்ஸ்திதா:|\nயே பூதா விக்னகர்த்தாரஸ் \nதே கச்சந்து சிவாக்ஞயா ||"
      )
      bdSt25.setSpan(AbsoluteSizeSpan(12, true), start, bdSt25.length, exExFlag)
      bdSt25.setSpan(StyleSpan(Typeface.BOLD), start, bdSt25.length, exExFlag)
      bdSt25.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt25.length,
        exExFlag
      )

      val comSt26 =
        SpannableString("-கையை சொடுக்கிய படியே தலையைச் சுற்றி கையைத் தட்டவும்\nகை கூப்பி- ")
      comSt26.setSpan(AbsoluteSizeSpan(10, true), start, comSt26.length, exExFlag)
      comSt26.setSpan(StyleSpan(Typeface.ITALIC), start, comSt26.length, exExFlag)
      comSt26.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt26.length, exExFlag)

      val bdSt26 = SpannableString("ஓம் சார்ங்காய சக்ராய சராய ஸுதர்சனாய அஸ்த்ராய பட் ||\n")
      bdSt26.setSpan(AbsoluteSizeSpan(12, true), start, bdSt26.length, exExFlag)
      bdSt26.setSpan(StyleSpan(Typeface.BOLD), start, bdSt26.length, exExFlag)
      bdSt26.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt26.length,
        exExFlag
      )

      val hdSt3A = SpannableString("\nப்ராணாயாமம்")
      hdSt3A.setSpan(AbsoluteSizeSpan(16, true), start, hdSt3A.length, exExFlag)
      hdSt3A.setSpan(StyleSpan(Typeface.BOLD), start, hdSt3A.length, exExFlag)
      hdSt3A.setSpan(UnderlineSpan(), start, hdSt3A.length, exExFlag)
      hdSt3A.setSpan(
        ForegroundColorSpan(Color.parseColor("#8b008b")),
        start,
        hdSt3A.length,
        exExFlag
      )

      val bdSt27 = SpannableString("ப்ரணவஸ்ய பரப்ரம்ஹ ரிஷி: |")
      bdSt27.setSpan(AbsoluteSizeSpan(12, true), start, bdSt27.length, exExFlag)
      bdSt27.setSpan(StyleSpan(Typeface.BOLD), start, bdSt27.length, exExFlag)
      bdSt27.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt27.length,
        exExFlag
      )

      val bdSt28 = SpannableString("பதேவீ காயத்ரீச்சந்த: |")
      bdSt28.setSpan(AbsoluteSizeSpan(12, true), start, bdSt28.length, exExFlag)
      bdSt28.setSpan(StyleSpan(Typeface.BOLD), start, bdSt28.length, exExFlag)
      bdSt28.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt28.length,
        exExFlag
      )

      val bdSt29 = SpannableString("தஸவிதா பரமாத்மா தேவதா||")
      bdSt29.setSpan(AbsoluteSizeSpan(12, true), start, bdSt29.length, exExFlag)
      bdSt29.setSpan(StyleSpan(Typeface.BOLD), start, bdSt29.length, exExFlag)
      bdSt29.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt29.length,
        exExFlag
      )

      val bdSt30 =
        SpannableString("பூராதி ஸப்தவ்யாஹ்ருதீனாம் அத்ரிப்ருகு குத்ஸ வஸிஷ்ட கௌதம காச்யப ஆங்கிரஸா ரிஷய: |")
      bdSt30.setSpan(AbsoluteSizeSpan(12, true), start, bdSt30.length, exExFlag)
      bdSt30.setSpan(StyleSpan(Typeface.BOLD), start, bdSt30.length, exExFlag)
      bdSt30.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt30.length,
        exExFlag
      )

      val bdSt31 =
        SpannableString("காயத்ரீ உஷ்ணிக் அனுஷ்டுப் ப்ருஹதீ பங்க்தி த்ரிஷ்டுப் ஜகத்யஸ் ச்சந்தாம்ஸி |")
      bdSt31.setSpan(AbsoluteSizeSpan(12, true), start, bdSt31.length, exExFlag)
      bdSt31.setSpan(StyleSpan(Typeface.BOLD), start, bdSt31.length, exExFlag)
      bdSt31.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt31.length,
        exExFlag
      )

      val bdSt32 = SpannableString("அக்னி வாயு அர்க்க வாகீச வருண இந்த்ர விச்வே தேவா தேவதா: ||")
      bdSt32.setSpan(AbsoluteSizeSpan(12, true), start, bdSt32.length, exExFlag)
      bdSt32.setSpan(StyleSpan(Typeface.BOLD), start, bdSt32.length, exExFlag)
      bdSt32.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt32.length,
        exExFlag
      )

      val bdSt33 = SpannableString("தத்ஸவிதுரிதி மஹாமந்த்ரஸ்ய விச்வாமித்ரோ பகவான் ரிஷி: ||")
      bdSt33.setSpan(AbsoluteSizeSpan(12, true), start, bdSt33.length, exExFlag)
      bdSt33.setSpan(StyleSpan(Typeface.BOLD), start, bdSt33.length, exExFlag)
      bdSt33.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt33.length,
        exExFlag
      )

      val bdSt34 = SpannableString("தேவீ காயத்ரீச்சந்த:|")
      bdSt34.setSpan(AbsoluteSizeSpan(12, true), start, bdSt34.length, exExFlag)
      bdSt34.setSpan(StyleSpan(Typeface.BOLD), start, bdSt34.length, exExFlag)
      bdSt34.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt34.length,
        exExFlag
      )

      val bdSt35 = SpannableString("ஸவிதா பரமாத்மா தேவதா ||")
      bdSt35.setSpan(AbsoluteSizeSpan(12, true), start, bdSt35.length, exExFlag)
      bdSt35.setSpan(StyleSpan(Typeface.BOLD), start, bdSt35.length, exExFlag)
      bdSt35.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt35.length,
        exExFlag
      )

      val bdSt36 = SpannableString("ஆபோ ஜ்யோதிரிதி மந்த்ரஸ்ய ப்ரஜாபதிர் ரிஷி: |")
      bdSt36.setSpan(AbsoluteSizeSpan(12, true), start, bdSt36.length, exExFlag)
      bdSt36.setSpan(StyleSpan(Typeface.BOLD), start, bdSt36.length, exExFlag)
      bdSt36.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt36.length,
        exExFlag
      )

      val bdSt37 = SpannableString("த்விபதா காயத்ரீச்சந்த: |")
      bdSt37.setSpan(AbsoluteSizeSpan(12, true), start, bdSt37.length, exExFlag)
      bdSt37.setSpan(StyleSpan(Typeface.BOLD), start, bdSt37.length, exExFlag)
      bdSt37.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt37.length,
        exExFlag
      )

      val bdSt38 = SpannableString("ப்ரம்மாக்னிவாயுஸுர்யா தேவதா: ||")
      bdSt38.setSpan(AbsoluteSizeSpan(12, true), start, bdSt38.length, exExFlag)
      bdSt38.setSpan(StyleSpan(Typeface.BOLD), start, bdSt38.length, exExFlag)
      bdSt38.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt38.length,
        exExFlag
      )

      val bdSt39 = SpannableString("ஸர்வேஷாம் ப்ராணாயாமே வினியோக: ||")
      bdSt39.setSpan(AbsoluteSizeSpan(12, true), start, bdSt39.length, exExFlag)
      bdSt39.setSpan(StyleSpan(Typeface.BOLD), start, bdSt39.length, exExFlag)
      bdSt39.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt39.length,
        exExFlag
      )

      val hdSt3B = SpannableString("\n\nப்ராணாயாமம்")
      hdSt3B.setSpan(AbsoluteSizeSpan(16, true), start, hdSt3B.length, exExFlag)
      hdSt3B.setSpan(StyleSpan(Typeface.BOLD), start, hdSt3B.length, exExFlag)
      hdSt3B.setSpan(UnderlineSpan(), start, hdSt3B.length, exExFlag)
      hdSt3B.setSpan(
        ForegroundColorSpan(Color.parseColor("#8b008b")),
        start,
        hdSt3B.length,
        exExFlag
      )

      val bdSt16A =
        SpannableString("\nஓம் பூ: ஓம்புவா:\n   ஓம் ஸுவா: ஓம் மஹ: \nஓம் ஜன: ஓம் தப:\n   ஓம் ஸத்யம் ஓம் தத்ஸவிதுர் வரேண்யம் \n   பர்கோ தேவஸ்ய தீமஹி | \nதியோ யோந: ப்ரசோதயாத் |\n   ஓம் ஆபோ ஜ்யோதீரஸோ \nஅம்ருதம் ப்ரம்ம பூர்புவஸ்வரோம் ||\n")
      bdSt16A.setSpan(AbsoluteSizeSpan(12, true), start, bdSt16A.length, exExFlag)
      bdSt16A.setSpan(StyleSpan(Typeface.BOLD), start, bdSt16A.length, exExFlag)
      bdSt16A.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt16A.length,
        exExFlag
      )

      val hdSt7 = SpannableString("\nஆவாஹனம்")
      hdSt7.setSpan(AbsoluteSizeSpan(16, true), start, hdSt7.length, exExFlag)
      hdSt7.setSpan(StyleSpan(Typeface.BOLD), start, hdSt7.length, exExFlag)
      hdSt7.setSpan(UnderlineSpan(), start, hdSt7.length, exExFlag)
      hdSt7.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, hdSt7.length, exExFlag)

      val bdSt40 = SpannableString("ஆயாத்விதி மந்த்ரஸ்ய வாமதேவ ரிஷி: |")
      bdSt40.setSpan(AbsoluteSizeSpan(12, true), start, bdSt40.length, exExFlag)
      bdSt40.setSpan(StyleSpan(Typeface.BOLD), start, bdSt40.length, exExFlag)
      bdSt40.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt40.length,
        exExFlag
      )

      val bdSt41 = SpannableString("அனுஷ்டுப்ச் சந்த: |")
      bdSt41.setSpan(AbsoluteSizeSpan(12, true), start, bdSt41.length, exExFlag)
      bdSt41.setSpan(StyleSpan(Typeface.BOLD), start, bdSt41.length, exExFlag)
      bdSt41.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt41.length,
        exExFlag
      )

      val bdSt42 = SpannableString("காயத்ரீ தேவதா |")
      bdSt42.setSpan(AbsoluteSizeSpan(12, true), start, bdSt42.length, exExFlag)
      bdSt42.setSpan(StyleSpan(Typeface.BOLD), start, bdSt42.length, exExFlag)
      bdSt42.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt42.length,
        exExFlag
      )

      val bdSt43 = SpannableString(
        "ஆவாஹனே வினியோக: ||\n" +
                "ஓம் ஆயாதுவரதாதேவி \nஅக்ஷரம் ப்ரம்மஸம்மிதம் |\n" +
                "   காயத்ரீம் ச்சந்தஸாம் மாதா \nஇதம் ப்ரம்ம ஜுஷஸ்வந: ||\n" +
                "தேஜோஸி தேஜோ மயிதேஹி \nவீர்யமஸி வீர்யம் மயிதேஹி\n" +
                "   பலமஸி பலம் மயிதேஹி \nஓஜோஸ்யோஜோ மயிதேஹி |\n" +
                "மன்யுரஸி மன்யும் மயிதேஹி \nஸஹோஸி ஸஹோ மயிதேஹி ||\n" +
                "   ஓஜோஸி-ஸஹோஸி- \nபலமஸி-ப்ராஜோஸி- \nதேவாநாம் தாமநாமாஸி- \nவிச்வமஸி-விச்வாயு: \nஸர்வமஸி ஸரவாயுரபிபூரோம் ||\n" +
                "காயத்ரீம் ஆவாஹயாமி |\n ஸாவித்ரீம் ஆவாஹயாமி |\n" +
                "   ஸரஸ்வதீம் ஆவாஹயாமி |\nச்சந்தர்ஷிம் ஆவாஹயாமி |\n" +
                "ச்ரியம் ஆவாஹயாமி |\nபலம் ஆவாஹயாமி ||"
      )
      bdSt43.setSpan(AbsoluteSizeSpan(12, true), start, bdSt43.length, exExFlag)
      bdSt43.setSpan(StyleSpan(Typeface.BOLD), start, bdSt43.length, exExFlag)
      bdSt43.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt43.length,
        exExFlag
      )

      val bdSt44 = SpannableString("காயத்ர்யா: விச்வாமித்ரோ பகவான் ரிஷி: |")
      bdSt44.setSpan(AbsoluteSizeSpan(12, true), start, bdSt44.length, exExFlag)
      bdSt44.setSpan(StyleSpan(Typeface.BOLD), start, bdSt44.length, exExFlag)
      bdSt44.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt44.length,
        exExFlag
      )

      val comSt27 = SpannableString("\nவாயின் மேற்புறத்தை தொட்டு- ")
      comSt27.setSpan(AbsoluteSizeSpan(10, true), start, comSt27.length, exExFlag)
      comSt27.setSpan(StyleSpan(Typeface.ITALIC), start, comSt27.length, exExFlag)
      comSt27.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt27.length, exExFlag)

      val bdSt45 = SpannableString("அக்னிர் முகம |")
      bdSt45.setSpan(AbsoluteSizeSpan(12, true), start, bdSt45.length, exExFlag)
      bdSt45.setSpan(StyleSpan(Typeface.BOLD), start, bdSt45.length, exExFlag)
      bdSt45.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt45.length,
        exExFlag
      )

      val bdSt46 = SpannableString("ப்ரம்மா சிர: |")
      bdSt46.setSpan(AbsoluteSizeSpan(12, true), start, bdSt46.length, exExFlag)
      bdSt46.setSpan(StyleSpan(Typeface.BOLD), start, bdSt46.length, exExFlag)
      bdSt46.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt46.length,
        exExFlag
      )

      val bdSt47 = SpannableString("விஷ்ணுர் ஹ்ருதயம் |")
      bdSt47.setSpan(AbsoluteSizeSpan(12, true), start, bdSt47.length, exExFlag)
      bdSt47.setSpan(StyleSpan(Typeface.BOLD), start, bdSt47.length, exExFlag)
      bdSt47.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt47.length,
        exExFlag
      )

      val comSt28 = SpannableString("\nஇரு தோள்களைத் தொட்டு- ")
      comSt28.setSpan(AbsoluteSizeSpan(10, true), start, comSt28.length, exExFlag)
      comSt28.setSpan(StyleSpan(Typeface.ITALIC), start, comSt28.length, exExFlag)
      comSt28.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt28.length, exExFlag)

      val bdSt48 = SpannableString("ருத்ர: கவசம் |")
      bdSt48.setSpan(AbsoluteSizeSpan(12, true), start, bdSt48.length, exExFlag)
      bdSt48.setSpan(StyleSpan(Typeface.BOLD), start, bdSt48.length, exExFlag)
      bdSt48.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt48.length,
        exExFlag
      )

      val comSt29 = SpannableString("\nபின்தலையைத் தொட்டு- ")
      comSt29.setSpan(AbsoluteSizeSpan(10, true), start, comSt29.length, exExFlag)
      comSt29.setSpan(StyleSpan(Typeface.ITALIC), start, comSt29.length, exExFlag)
      comSt29.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt29.length, exExFlag)

      val bdSt49 = SpannableString("ஆப: புச்சம் ||")
      bdSt49.setSpan(AbsoluteSizeSpan(12, true), start, bdSt49.length, exExFlag)
      bdSt49.setSpan(StyleSpan(Typeface.BOLD), start, bdSt49.length, exExFlag)
      bdSt49.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt49.length,
        exExFlag
      )

      val comSt30 = SpannableString("\nகை கூப்பிச் சொல்லவம்- ")
      comSt30.setSpan(AbsoluteSizeSpan(10, true), start, comSt30.length, exExFlag)
      comSt30.setSpan(StyleSpan(Typeface.ITALIC), start, comSt30.length, exExFlag)
      comSt30.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt30.length, exExFlag)

      val bdSt50 = SpannableString("ஸாங்க்யாயனஸ கோத்ரம் |\n சக்ஷூ: பிங்காக்ஷம் ||")
      bdSt50.setSpan(AbsoluteSizeSpan(12, true), start, bdSt50.length, exExFlag)
      bdSt50.setSpan(StyleSpan(Typeface.BOLD), start, bdSt50.length, exExFlag)
      bdSt50.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt50.length,
        exExFlag
      )

      val bdSt51A = SpannableString("ரக்தம் வர்ணம் கர்மஞானே வினியோக:|")
      bdSt51A.setSpan(AbsoluteSizeSpan(12, true), start, bdSt51A.length, exExFlag)
      bdSt51A.setSpan(StyleSpan(Typeface.BOLD), start, bdSt51A.length, exExFlag)
      bdSt51A.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt51A.length,
        exExFlag
      )

      val bdSt51B = SpannableString("ச்வேதம் வர்ணம் ஆத்மஞானே வினியோக: |")
      bdSt51B.setSpan(AbsoluteSizeSpan(12, true), start, bdSt51B.length, exExFlag)
      bdSt51B.setSpan(StyleSpan(Typeface.BOLD), start, bdSt51B.length, exExFlag)
      bdSt51B.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt51B.length,
        exExFlag
      )

      val bdSt51C = SpannableString("சக்ருஷ்ணம் வர்ணம் மோக்ஷஞானே வினியோக: |")
      bdSt51C.setSpan(AbsoluteSizeSpan(12, true), start, bdSt51C.length, exExFlag)
      bdSt51C.setSpan(StyleSpan(Typeface.BOLD), start, bdSt51C.length, exExFlag)
      bdSt51C.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt51C.length,
        exExFlag
      )

      val hdSt8 = SpannableString("\n\nகரந்யாஸம்")
      hdSt8.setSpan(AbsoluteSizeSpan(16, true), start, hdSt8.length, exExFlag)
      hdSt8.setSpan(StyleSpan(Typeface.BOLD), start, hdSt8.length, exExFlag)
      hdSt8.setSpan(UnderlineSpan(), start, hdSt8.length, exExFlag)
      hdSt8.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, hdSt8.length, exExFlag)

      val comSt31 = SpannableString("\nஆள்காட்டி விரல்களால் இருகட்டை விரல்களை வருடவும்- ")
      comSt31.setSpan(AbsoluteSizeSpan(10, true), start, comSt31.length, exExFlag)
      comSt31.setSpan(StyleSpan(Typeface.ITALIC), start, comSt31.length, exExFlag)
      comSt31.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt31.length, exExFlag)

      val bdSt52 = SpannableString("ஓம் தத்ஸவிதுர் பிரம்மாத்மனே அங்குஷ்டாப்யாம் நம: |")
      bdSt52.setSpan(AbsoluteSizeSpan(12, true), start, bdSt52.length, exExFlag)
      bdSt52.setSpan(StyleSpan(Typeface.BOLD), start, bdSt52.length, exExFlag)
      bdSt52.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt52.length,
        exExFlag
      )

      val comSt32 = SpannableString("\nகட்டை விரல்களால் ஆள்காட்டி விரல்களை வருடவும்- ")
      comSt32.setSpan(AbsoluteSizeSpan(10, true), start, comSt32.length, exExFlag)
      comSt32.setSpan(StyleSpan(Typeface.ITALIC), start, comSt32.length, exExFlag)
      comSt32.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt32.length, exExFlag)

      val bdSt53 = SpannableString("வரேண்யம் விஷ்ண்வாத்மனே தர்ஜனீப்யாம் நம: |")
      bdSt53.setSpan(AbsoluteSizeSpan(12, true), start, bdSt53.length, exExFlag)
      bdSt53.setSpan(StyleSpan(Typeface.BOLD), start, bdSt53.length, exExFlag)
      bdSt53.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt53.length,
        exExFlag
      )

      val comSt33Missg = SpannableString("\nகட்டை விரல்களால் நடு விரல்களை வருடவும்- ")
      comSt33Missg.setSpan(AbsoluteSizeSpan(10, true), start, comSt33Missg.length, exExFlag)
      comSt33Missg.setSpan(StyleSpan(Typeface.ITALIC), start, comSt33Missg.length, exExFlag)
      comSt33Missg.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt33Missg.length, exExFlag)

      val bdSt54Missg = SpannableString("பர்கோ தேவஸ்ய ருத்ராத்மனே மத்யமாப்யாம் நம: |")
      bdSt54Missg.setSpan(AbsoluteSizeSpan(12, true), start, bdSt54Missg.length, exExFlag)
      bdSt54Missg.setSpan(StyleSpan(Typeface.BOLD), start, bdSt54Missg.length, exExFlag)
      bdSt54Missg.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt54Missg.length,
        exExFlag
      )

      val comSt33 = SpannableString("\nகட்டை விரல்களால் சுண்டு விரல்களை வருடவும்- ")
      comSt33.setSpan(AbsoluteSizeSpan(10, true), start, comSt33.length, exExFlag)
      comSt33.setSpan(StyleSpan(Typeface.ITALIC), start, comSt33.length, exExFlag)
      comSt33.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt33.length, exExFlag)

      val bdSt54 = SpannableString("தியோயோந: ஸதாசிவாத்மனே கநிஷ்டிகாப்யாம் நம: |")
      bdSt54.setSpan(AbsoluteSizeSpan(12, true), start, bdSt54.length, exExFlag)
      bdSt54.setSpan(StyleSpan(Typeface.BOLD), start, bdSt54.length, exExFlag)
      bdSt54.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt54.length,
        exExFlag
      )

      val comSt34 = SpannableString("\nஇருகைகளின் உட்புறம், வெளிப்புறம் இரண்டையும் தடவவும்- ")
      comSt34.setSpan(AbsoluteSizeSpan(10, true), start, comSt34.length, exExFlag)
      comSt34.setSpan(StyleSpan(Typeface.ITALIC), start, comSt34.length, exExFlag)
      comSt34.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt34.length, exExFlag)

      val bdSt55 = SpannableString("ப்ரசோதயாத் ஸர்வாத்மனே கரதலகரப்ருஷ்டாப்யாம் நம: |")
      bdSt55.setSpan(AbsoluteSizeSpan(12, true), start, bdSt55.length, exExFlag)
      bdSt55.setSpan(StyleSpan(Typeface.BOLD), start, bdSt55.length, exExFlag)
      bdSt55.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt55.length,
        exExFlag
      )

      val hdSt9 = SpannableString("\n\nஅங்கந்யாஸம்")
      hdSt9.setSpan(AbsoluteSizeSpan(16, true), start, hdSt9.length, exExFlag)
      hdSt9.setSpan(StyleSpan(Typeface.BOLD), start, hdSt9.length, exExFlag)
      hdSt9.setSpan(UnderlineSpan(), start, hdSt9.length, exExFlag)
      hdSt9.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, hdSt9.length, exExFlag)

      val bdSt56 = SpannableString("ஓம் தத்ஸவிதுர் பிரம்மாத்மனே ஹ்ருதயாய நம: |")
      bdSt56.setSpan(AbsoluteSizeSpan(12, true), start, bdSt56.length, exExFlag)
      bdSt56.setSpan(StyleSpan(Typeface.BOLD), start, bdSt56.length, exExFlag)
      bdSt56.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt56.length,
        exExFlag
      )

      val bdSt56A = SpannableString("ஓம் தத்ஸவிதுர் பிரம்மாத்மனே ஹ்ருதயாய நம: |")
      bdSt56A.setSpan(AbsoluteSizeSpan(12, true), start, bdSt56A.length, exExFlag)
      bdSt56A.setSpan(StyleSpan(Typeface.BOLD), start, bdSt56A.length, exExFlag)
      bdSt56A.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt56A.length,
        exExFlag
      )

      val bdSt57 = SpannableString("வரேண்யம் விஷ்ண்வாத்மனே சிரஸே ஸ்வாஹா |")
      bdSt57.setSpan(AbsoluteSizeSpan(12, true), start, bdSt57.length, exExFlag)
      bdSt57.setSpan(StyleSpan(Typeface.BOLD), start, bdSt57.length, exExFlag)
      bdSt57.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt57.length,
        exExFlag
      )

      val bdSt57A = SpannableString("வரேண்யம் விஷ்ண்வாத்மனே சிரஸே ஸ்வாஹா |")
      bdSt57A.setSpan(AbsoluteSizeSpan(12, true), start, bdSt57A.length, exExFlag)
      bdSt57A.setSpan(StyleSpan(Typeface.BOLD), start, bdSt57A.length, exExFlag)
      bdSt57A.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt57A.length,
        exExFlag
      )

      val comSt35 = SpannableString("\nபின் தலையைத் தொட்டு- ")
      comSt35.setSpan(AbsoluteSizeSpan(10, true), start, comSt35.length, exExFlag)
      comSt35.setSpan(StyleSpan(Typeface.ITALIC), start, comSt35.length, exExFlag)
      comSt35.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt35.length, exExFlag)

      val bdSt58 = SpannableString("பர்கோ தேவஸ்ய ருத்ராத்மனே சிகாயை வஷட் |")
      bdSt58.setSpan(AbsoluteSizeSpan(12, true), start, bdSt58.length, exExFlag)
      bdSt58.setSpan(StyleSpan(Typeface.BOLD), start, bdSt58.length, exExFlag)
      bdSt58.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt58.length,
        exExFlag
      )

      val bdSt58A = SpannableString("பர்கோ தேவஸ்ய ருத்ராத்மனே சிகாயை வஷட் |")
      bdSt58A.setSpan(AbsoluteSizeSpan(12, true), start, bdSt58A.length, exExFlag)
      bdSt58A.setSpan(StyleSpan(Typeface.BOLD), start, bdSt58A.length, exExFlag)
      bdSt58A.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt58A.length,
        exExFlag
      )

      val comSt36 = SpannableString("\nஇரு தோள்களைத் தொட்டு- ")
      comSt36.setSpan(AbsoluteSizeSpan(10, true), start, comSt36.length, exExFlag)
      comSt36.setSpan(StyleSpan(Typeface.ITALIC), start, comSt36.length, exExFlag)
      comSt36.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt36.length, exExFlag)

      val bdSt59 = SpannableString("தீமஹி ஈச்வராத்மனே கவசாய ஹூம் |")
      bdSt59.setSpan(AbsoluteSizeSpan(12, true), start, bdSt59.length, exExFlag)
      bdSt59.setSpan(StyleSpan(Typeface.BOLD), start, bdSt59.length, exExFlag)
      bdSt59.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt59.length,
        exExFlag
      )

      val bdSt59A = SpannableString("தீமஹி ஈச்வராத்மனே கவசாய ஹூம் |")
      bdSt59A.setSpan(AbsoluteSizeSpan(12, true), start, bdSt59A.length, exExFlag)
      bdSt59A.setSpan(StyleSpan(Typeface.BOLD), start, bdSt59A.length, exExFlag)
      bdSt59A.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt59A.length,
        exExFlag
      )

      val comSt37 = SpannableString("\nமூன்று கண்களைத் தொட்டு- ")
      comSt37.setSpan(AbsoluteSizeSpan(10, true), start, comSt37.length, exExFlag)
      comSt37.setSpan(StyleSpan(Typeface.ITALIC), start, comSt37.length, exExFlag)
      comSt37.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt37.length, exExFlag)

      val bdSt60 = SpannableString("தியோயோந: ஸதாசிவாத்மனே நேத்ரத்யாய வௌஷட் |")
      bdSt60.setSpan(AbsoluteSizeSpan(12, true), start, bdSt60.length, exExFlag)
      bdSt60.setSpan(StyleSpan(Typeface.BOLD), start, bdSt60.length, exExFlag)
      bdSt60.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt60.length,
        exExFlag
      )

      val bdSt60A = SpannableString("தியோயோந: ஸதாசிவாத்மனே நேத்ரத்யாய வௌஷட் |")
      bdSt60A.setSpan(AbsoluteSizeSpan(12, true), start, bdSt60A.length, exExFlag)
      bdSt60A.setSpan(StyleSpan(Typeface.BOLD), start, bdSt60A.length, exExFlag)
      bdSt60A.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt60A.length,
        exExFlag
      )

      val comSt38 =
        SpannableString("\nவலது கையை சொடுக்கிக் கொண்டே தலையை வலமாகச் சுற்றி இடக்கையில் தட்டவும்- ")
      comSt38.setSpan(AbsoluteSizeSpan(10, true), start, comSt38.length, exExFlag)
      comSt38.setSpan(StyleSpan(Typeface.ITALIC), start, comSt38.length, exExFlag)
      comSt38.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt38.length, exExFlag)

      val bdSt61 = SpannableString("ப்ரசோதயாத் ஸர்வாத்மனே அஸ்த்ராய ப்பட் |")
      bdSt61.setSpan(AbsoluteSizeSpan(12, true), start, bdSt61.length, exExFlag)
      bdSt61.setSpan(StyleSpan(Typeface.BOLD), start, bdSt61.length, exExFlag)
      bdSt61.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt61.length,
        exExFlag
      )

      val comSt39 =
        SpannableString("\nவலது கையை சொடுக்கிக் கொண்டே தலையை வலமாகச் சுற்றி இடக்கையில் தட்டவும்- ")
      comSt39.setSpan(AbsoluteSizeSpan(10, true), start, comSt39.length, exExFlag)
      comSt39.setSpan(StyleSpan(Typeface.ITALIC), start, comSt39.length, exExFlag)
      comSt39.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt39.length, exExFlag)

      val bdSt62 = SpannableString("பூர்புவஸ்ஸ்வரோம் இதி திக்பந்த: ||")
      bdSt62.setSpan(AbsoluteSizeSpan(12, true), start, bdSt62.length, exExFlag)
      bdSt62.setSpan(StyleSpan(Typeface.BOLD), start, bdSt62.length, exExFlag)
      bdSt62.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt62.length,
        exExFlag
      )

      val hdSt10 = SpannableString("\n\nத்யானம்")
      hdSt10.setSpan(AbsoluteSizeSpan(16, true), start, hdSt10.length, exExFlag)
      hdSt10.setSpan(StyleSpan(Typeface.BOLD), start, hdSt10.length, exExFlag)
      hdSt10.setSpan(UnderlineSpan(), start, hdSt10.length, exExFlag)
      hdSt10.setSpan(
        ForegroundColorSpan(Color.parseColor("#8b008b")),
        start,
        hdSt10.length,
        exExFlag
      )

      val hdSt10A = SpannableString("\n\nத்யானம்")
      hdSt10A.setSpan(AbsoluteSizeSpan(16, true), start, hdSt10A.length, exExFlag)
      hdSt10A.setSpan(StyleSpan(Typeface.BOLD), start, hdSt10A.length, exExFlag)
      hdSt10A.setSpan(UnderlineSpan(), start, hdSt10A.length, exExFlag)
      hdSt10A.setSpan(
        ForegroundColorSpan(Color.parseColor("#8b008b")),
        start,
        hdSt10A.length,
        exExFlag
      )

      val comSt40 = SpannableString("\nகைகூப்பி- ")
      comSt40.setSpan(AbsoluteSizeSpan(10, true), start, comSt40.length, exExFlag)
      comSt40.setSpan(StyleSpan(Typeface.ITALIC), start, comSt40.length, exExFlag)
      comSt40.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt40.length, exExFlag)

      val bdSt63 = SpannableString(
        "முக்தாவித்ரும ஹேமநீல தவளச்\n" +
                "   சாயையர் முகைஸ் த்ரீக்ஷணை:\n" +
                "யுக்தாம் இந்துகலா நிபத்தமகுடாம்\n" +
                "   தத்வார்த்த வர்ணாத்மிகாம் |\n" +
                "காயத்ரீம் வரதாபயாங்குச கசா:\n" +
                "   சுப்ரம் கபாலம் கதாம்\n" +
                "சங்கம் சக்ரம் அதாரவிந்தயுகளம்\n" +
                "   ஹஸ்தைர் வஹந்தீம் பஜே ||"
      )
      bdSt63.setSpan(AbsoluteSizeSpan(12, true), start, bdSt63.length, exExFlag)
      bdSt63.setSpan(StyleSpan(Typeface.BOLD), start, bdSt63.length, exExFlag)
      bdSt63.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt63.length,
        exExFlag
      )

      val hdSt11 = SpannableString("\n\nபஞ்சபூஜை")
      hdSt11.setSpan(AbsoluteSizeSpan(16, true), start, hdSt11.length, exExFlag)
      hdSt11.setSpan(StyleSpan(Typeface.BOLD), start, hdSt11.length, exExFlag)
      hdSt11.setSpan(UnderlineSpan(), start, hdSt11.length, exExFlag)
      hdSt11.setSpan(
        ForegroundColorSpan(Color.parseColor("#8b008b")),
        start,
        hdSt11.length,
        exExFlag
      )

      val hdSt11A = SpannableString("\n\nபஞ்சபூஜை")
      hdSt11A.setSpan(AbsoluteSizeSpan(16, true), start, hdSt11A.length, exExFlag)
      hdSt11A.setSpan(StyleSpan(Typeface.BOLD), start, hdSt11A.length, exExFlag)
      hdSt11A.setSpan(UnderlineSpan(), start, hdSt11A.length, exExFlag)
      hdSt11A.setSpan(
        ForegroundColorSpan(Color.parseColor("#8b008b")),
        start,
        hdSt11A.length,
        exExFlag
      )

      val comSt41 = SpannableString("\nகட்டை விரல்களால் சுண்டு விரல்களை வருடவும்- ")
      comSt41.setSpan(AbsoluteSizeSpan(10, true), start, comSt41.length, exExFlag)
      comSt41.setSpan(StyleSpan(Typeface.ITALIC), start, comSt41.length, exExFlag)
      comSt41.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt41.length, exExFlag)

      val bdSt64 = SpannableString("லம் ப்ருதிவ்யாத்மனே கந்தான் தாரயாமி |")
      bdSt64.setSpan(AbsoluteSizeSpan(12, true), start, bdSt64.length, exExFlag)
      bdSt64.setSpan(StyleSpan(Typeface.BOLD), start, bdSt64.length, exExFlag)
      bdSt64.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt64.length,
        exExFlag
      )

      val comSt42 = SpannableString("\nஆள்காட்டி விரல்களால் கட்டை விரல்களை வருடவும்- ")
      comSt42.setSpan(AbsoluteSizeSpan(10, true), start, comSt42.length, exExFlag)
      comSt42.setSpan(StyleSpan(Typeface.ITALIC), start, comSt42.length, exExFlag)
      comSt42.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt42.length, exExFlag)

      val bdSt65 = SpannableString("ஹம் ஆகாசாத்மனே புஷ்பாணி ஸமர்ப்பயாமி |")
      bdSt65.setSpan(AbsoluteSizeSpan(12, true), start, bdSt65.length, exExFlag)
      bdSt65.setSpan(StyleSpan(Typeface.BOLD), start, bdSt65.length, exExFlag)
      bdSt65.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt65.length,
        exExFlag
      )

      val comSt43 = SpannableString("\nகட்டை விரல்களால் ஆள்காட்டி விரல்களை வருடவும்- ")
      comSt43.setSpan(AbsoluteSizeSpan(10, true), start, comSt43.length, exExFlag)
      comSt43.setSpan(StyleSpan(Typeface.ITALIC), start, comSt43.length, exExFlag)
      comSt43.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt43.length, exExFlag)

      val bdSt66 = SpannableString("யம் வாய்வாத்மனே தூபம் ஆக்ராபயாமி |")
      bdSt66.setSpan(AbsoluteSizeSpan(12, true), start, bdSt66.length, exExFlag)
      bdSt66.setSpan(StyleSpan(Typeface.BOLD), start, bdSt66.length, exExFlag)
      bdSt66.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt66.length,
        exExFlag
      )

      val comSt44 = SpannableString("\nகட்டை விரல்களால் நடு விரல்களை வருடவும்- ")
      comSt44.setSpan(AbsoluteSizeSpan(10, true), start, comSt44.length, exExFlag)
      comSt44.setSpan(StyleSpan(Typeface.ITALIC), start, comSt44.length, exExFlag)
      comSt44.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt44.length, exExFlag)

      val bdSt67 = SpannableString("ரம் வன்யாத்மனே தீபம் தர்ஸயாமி |")
      bdSt67.setSpan(AbsoluteSizeSpan(12, true), start, bdSt67.length, exExFlag)
      bdSt67.setSpan(StyleSpan(Typeface.BOLD), start, bdSt67.length, exExFlag)
      bdSt67.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt67.length,
        exExFlag
      )

      val comSt45 = SpannableString("\nகட்டை விரல்களால் மோதிர விரல்களை வருடவும்- ")
      comSt45.setSpan(AbsoluteSizeSpan(10, true), start, comSt45.length, exExFlag)
      comSt45.setSpan(StyleSpan(Typeface.ITALIC), start, comSt45.length, exExFlag)
      comSt45.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt45.length, exExFlag)

      val bdSt68 = SpannableString("வம் அம்ருதாத்மனே திவ்யாம்ருதம் மஹாநைவேத்யம் நிவேதயாமி |")
      bdSt68.setSpan(AbsoluteSizeSpan(12, true), start, bdSt68.length, exExFlag)
      bdSt68.setSpan(StyleSpan(Typeface.BOLD), start, bdSt68.length, exExFlag)
      bdSt68.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt68.length,
        exExFlag
      )

      val bdSt69 = SpannableString("ஸம் ஸர்வாத்மனே ஸமஸ்த ராஜோபசாரான் தேவோபசாரான் ஸமர்ப்பயாமி ||")
      bdSt69.setSpan(AbsoluteSizeSpan(12, true), start, bdSt69.length, exExFlag)
      bdSt69.setSpan(StyleSpan(Typeface.BOLD), start, bdSt69.length, exExFlag)
      bdSt69.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt69.length,
        exExFlag
      )

      val hdSt12 = SpannableString("\n\nகாயத்ரீ மஹாமந்த்ர ஜபம்")
      hdSt12.setSpan(AbsoluteSizeSpan(16, true), start, hdSt12.length, exExFlag)
      hdSt12.setSpan(StyleSpan(Typeface.BOLD), start, hdSt12.length, exExFlag)
      hdSt12.setSpan(UnderlineSpan(), start, hdSt12.length, exExFlag)
      hdSt12.setSpan(
        ForegroundColorSpan(Color.parseColor("#8b008b")),
        start,
        hdSt12.length,
        exExFlag
      )

      val comSt46 = SpannableString(
        "\n(காயத்ரீ மந்த்ரத்தை ஜபிக்கும் முறை: கீழே பிரிக்கப்பட்டுள்ளபடி ப்ரணவம் - வ்யாஹ்ருதிகள் - 3 பாதங்கள் ஆக ஐந்து விபாகமாக காயத்ரீ மஹாமந்த்ரத்தை எப்போதும் ஜபிக்க வேண்டும்.\n" +
                " இவ்வாறு ஜபிக்கப்படும் காயத்ரியானது மஹாபாபங்கையும் போக்கவல்லது. தவிர காலையில் செய்யும் காயத்ரீ ஜபத்தை மட்டும் எழுந்து நின்றுதான் செய்யவேண்டும். ஜபம் செய்யும்போது இருகைகளையும் ஒன்று சேர்த்து, மேல்\n" +
                " வேஷ்டிக்குள் மறைத்துக்கொண்டு வலது கைவிரல்களின் ரேகைகளில் மட்டும் எண்ணுதல் வேண்டும். காலையில் இரு கைகளையும் நெற்றி மட்டத்திலும், மதியம் மார்பு மட்டத்திலும், மாலையில் தொப்புள் மட்டத்திலும்\n" +
                " வைத்துக்கொண்டு காயத்ரீ ஜபத்தை செய்ய வேண்டும். ௸ காயத்ரீ மந்த்ரத்தை ஒவ்வொரு வேளையும் 108 தரம் செய்வது உத்தமம்)"
      )
      comSt46.setSpan(AbsoluteSizeSpan(10, true), start, comSt46.length, exExFlag)
      comSt46.setSpan(StyleSpan(Typeface.ITALIC), start, comSt46.length, exExFlag)
      comSt46.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt46.length, exExFlag)

      val bdSt70 = SpannableString(
        "\nஓம் | பூர்புவஸ்ஸ்வ: |\n" +
                "    தத்ஸதுவிர் வரேண்யம் |\n" +
                "பர்கோ தேவஸ்ய தீமஹி |\n" +
                "    தியோயோந: ப்சோதயாத் ||"
      )
      bdSt70.setSpan(AbsoluteSizeSpan(12, true), start, bdSt70.length, exExFlag)
      bdSt70.setSpan(StyleSpan(Typeface.BOLD), start, bdSt70.length, exExFlag)
      bdSt70.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt70.length,
        exExFlag
      )

      val bdSt16B =
        SpannableString("\nஓம் பூ: ஓம்புவா:\n   ஓம் ஸுவா: ஓம் மஹ: \nஓம் ஜன: ஓம் தப:\n   ஓம் ஸத்யம் ஓம் தத்ஸவிதுர் வரேண்யம் \n   பர்கோ தேவஸ்ய தீமஹி | \nதியோ யோந: ப்ரசோதயாத் |\n   ஓம் ஆபோ ஜ்யோதீரஸோ \nஅம்ருதம் ப்ரம்ம பூர்புவஸ்வரோம் ||")
      bdSt16B.setSpan(AbsoluteSizeSpan(12, true), start, bdSt16B.length, exExFlag)
      bdSt16B.setSpan(StyleSpan(Typeface.BOLD), start, bdSt16B.length, exExFlag)
      bdSt16B.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt16B.length,
        exExFlag
      )

      val bdSt17A = SpannableString("\nஓம்  ஓம்  ஓம் ||\n")
      bdSt17A.setSpan(AbsoluteSizeSpan(12, true), start, bdSt17A.length, exExFlag)
      bdSt17A.setSpan(StyleSpan(Typeface.BOLD), start, bdSt17A.length, exExFlag)
      bdSt17A.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt17A.length,
        exExFlag
      )

      val hdSt13 = SpannableString("\n\nப்ரணாயாமம்")
      hdSt13.setSpan(AbsoluteSizeSpan(16, true), start, hdSt13.length, exExFlag)
      hdSt13.setSpan(StyleSpan(Typeface.BOLD), start, hdSt13.length, exExFlag)
      hdSt13.setSpan(UnderlineSpan(), start, hdSt13.length, exExFlag)
      hdSt13.setSpan(
        ForegroundColorSpan(Color.parseColor("#8b008b")),
        start,
        hdSt13.length,
        exExFlag
      )

      val hdSt9A = SpannableString("\n\nஅங்கந்யாஸம்")
      hdSt9A.setSpan(AbsoluteSizeSpan(16, true), start, hdSt9A.length, exExFlag)
      hdSt9A.setSpan(StyleSpan(Typeface.BOLD), start, hdSt9A.length, exExFlag)
      hdSt9A.setSpan(UnderlineSpan(), start, hdSt9A.length, exExFlag)
      hdSt9A.setSpan(
        ForegroundColorSpan(Color.parseColor("#8b008b")),
        start,
        hdSt9A.length,
        exExFlag
      )

      val comSt38Add =
        SpannableString("\nவலது கையை சொடுக்கிக் கொண்டே தலையை வலமாகச் சுற்றி இடக்கையில் தட்டவும்- ")
      comSt38Add.setSpan(AbsoluteSizeSpan(10, true), start, comSt38Add.length, exExFlag)
      comSt38Add.setSpan(StyleSpan(Typeface.ITALIC), start, comSt38Add.length, exExFlag)
      comSt38Add.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt38Add.length, exExFlag)

      val bdSt61Add = SpannableString("ப்ரசோதயாத் ஸர்வாத்மனே அஸ்த்ராய ப்பட் |")
      bdSt61Add.setSpan(AbsoluteSizeSpan(12, true), start, bdSt61Add.length, exExFlag)
      bdSt61Add.setSpan(StyleSpan(Typeface.BOLD), start, bdSt61Add.length, exExFlag)
      bdSt61Add.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt61Add.length,
        exExFlag
      )

      val comSt47 =
        SpannableString("\nவலது கையை சொடுக்கிக் கொண்டே இடமாகத் நலையைச் சுற்றி இடக்கையில் தட்டவும்- ")
      comSt47.setSpan(AbsoluteSizeSpan(10, true), start, comSt47.length, exExFlag)
      comSt47.setSpan(StyleSpan(Typeface.ITALIC), start, comSt47.length, exExFlag)
      comSt47.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt47.length, exExFlag)

      val bdSt71 = SpannableString("பூர் புவஸ்ஸ்வரோம் - இதி திக்விமோக: ||")
      bdSt71.setSpan(AbsoluteSizeSpan(12, true), start, bdSt71.length, exExFlag)
      bdSt71.setSpan(StyleSpan(Typeface.BOLD), start, bdSt71.length, exExFlag)
      bdSt71.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt71.length,
        exExFlag
      )

      val bdSt72 = SpannableString(
        "முக்தாவித்ரும ஹேமநீல தவளச் சாயையர் முகைஸ் த்ரீக்ஷணை:\n" +
                "  யுக்தாம் இந்துகலா நிபத்தமகுடாம் தத்வார்த்த வர்ணாத்மிகாம் |\n" +
                "காயத்ரீம் வரதாபயாங்குச கசா: சுப்ரம் கபாலம் கதாம்\n" +
                "   சங்கம் சக்ரம் அதாரவிந்தயுகளம் ஹஸ்தைர் வஹந்தீம் பஜே ||"
      )
      bdSt72.setSpan(AbsoluteSizeSpan(12, true), start, bdSt72.length, exExFlag)
      bdSt72.setSpan(StyleSpan(Typeface.BOLD), start, bdSt72.length, exExFlag)
      bdSt72.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt72.length,
        exExFlag
      )

      val bdSt73 = SpannableString("லம் ப்ருதிவ்யாத்மனே கந்தான் தாரயாமி |")
      bdSt73.setSpan(AbsoluteSizeSpan(12, true), start, bdSt73.length, exExFlag)
      bdSt73.setSpan(StyleSpan(Typeface.BOLD), start, bdSt73.length, exExFlag)
      bdSt73.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt73.length,
        exExFlag
      )

      val bdSt74 = SpannableString("ஹம் ஆகாசாத்மனே புஷ்பாணி ஸமர்ப்பயாமி |")
      bdSt74.setSpan(AbsoluteSizeSpan(12, true), start, bdSt74.length, exExFlag)
      bdSt74.setSpan(StyleSpan(Typeface.BOLD), start, bdSt74.length, exExFlag)
      bdSt74.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt74.length,
        exExFlag
      )

      val bdSt75 = SpannableString("யம் வாய்வாத்மனே தூபம் ஆக்ராபயாமி |")
      bdSt75.setSpan(AbsoluteSizeSpan(12, true), start, bdSt75.length, exExFlag)
      bdSt75.setSpan(StyleSpan(Typeface.BOLD), start, bdSt75.length, exExFlag)
      bdSt75.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt75.length,
        exExFlag
      )

      val bdSt76 = SpannableString("ரம் வன்யாத்மனே தீபம் தர்ஸயாமி |")
      bdSt76.setSpan(AbsoluteSizeSpan(12, true), start, bdSt76.length, exExFlag)
      bdSt76.setSpan(StyleSpan(Typeface.BOLD), start, bdSt76.length, exExFlag)
      bdSt76.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt76.length,
        exExFlag
      )

      val bdSt77 = SpannableString("வம் அம்ருதாத்மனே திவ்யாம்ருதம் மஹாநைவேத்யம் நிவேதயாமி |")
      bdSt77.setSpan(AbsoluteSizeSpan(12, true), start, bdSt77.length, exExFlag)
      bdSt77.setSpan(StyleSpan(Typeface.BOLD), start, bdSt77.length, exExFlag)
      bdSt77.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt77.length,
        exExFlag
      )

      val bdSt78 = SpannableString("ஸம் ஸர்வாத்மனே ஸமஸ்த ராஜோபசாரான் தேவோபசாரான் ஸமர்ப்பயாமி ||")
      bdSt78.setSpan(AbsoluteSizeSpan(12, true), start, bdSt78.length, exExFlag)
      bdSt78.setSpan(StyleSpan(Typeface.BOLD), start, bdSt78.length, exExFlag)
      bdSt78.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt78.length,
        exExFlag
      )

      val hdSt14 = SpannableString("\nஉபஸ்தானம்")
      hdSt14.setSpan(AbsoluteSizeSpan(16, true), start, hdSt14.length, exExFlag)
      hdSt14.setSpan(StyleSpan(Typeface.BOLD), start, hdSt14.length, exExFlag)
      hdSt14.setSpan(UnderlineSpan(), start, hdSt14.length, exExFlag)
      hdSt14.setSpan(
        ForegroundColorSpan(Color.parseColor("#8b008b")),
        start,
        hdSt14.length,
        exExFlag
      )

      val comSt48 = SpannableString("\nஎழுந்து நின்று சூரியனை நோக்கி கை கூப்பி- ")
      comSt48.setSpan(AbsoluteSizeSpan(10, true), start, comSt48.length, exExFlag)
      comSt48.setSpan(StyleSpan(Typeface.ITALIC), start, comSt48.length, exExFlag)
      comSt48.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt48.length, exExFlag)

      val bdSt79A = SpannableString(
        "\nTYPEOFSANDYA காயத்ர்யுபஸ்தானம் கரிஷ்யே |\n" +
                " ஓம்-உத்தமே சிகரே தேவி \n   பூம்யாம் பர்வத மூர்த்தனி\n" +
                "    ப்ராம்மணேப்யோ ஹ்யனுக்ஞாதா \n   கச்ச தேவி யதாஸுகம் ||\n" +
                " விச்வதஸ் சக்ஷுருத விச்வதோமுகோ \n   விச்வதோ பாஹுருத விச்வதஸ்பாத் |\n" +
                "    ஸம்பாஹுப்யாம் தமதி ஸம்பத்ரைர் \n   த்யாவாபூமீ ஜனயன் தேவ ஏக: ||\n" +
                " தஸ்யா உபஸ்தானம் காயத்ர்யஸ்யேகபதீ \n   த்விபதீ த்ரிபதீ சதுஷ்பத்யபதஸி நஹி\n" +
                "    பத்யஸே நமஸ்தே துரீயாய தர்சதாய \n   பதாய பரோரஜஸே ஸாவதோமா ப்ராபதிதி ||\n அப உப ஸ்ப்ருச்ய ||"
      )
      val bdSt79 = SpannableString(bdSt79A.replace(regexReplace1, sandyaType))
      bdSt79.setSpan(AbsoluteSizeSpan(12, true), start, bdSt79.length, exExFlag)
      bdSt79.setSpan(StyleSpan(Typeface.BOLD), start, bdSt79.length, exExFlag)
      bdSt79.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt79.length,
        exExFlag
      )

      val comSt49 = SpannableString(
        "\nஒவ்வொரு நாளும் மாத்யான்னிக அனுஷ்டானத்தின் போது, இரண்டு கைகளின் விரல்களை வருணபாசம்- என்ற முறையில் கோர்த்து வைத்துக் கொண்டு, \n" +
                "விரல்களின் இடைவெளி வழியாக சூரியனை தரிசிக்க வேண்டும். அப்பொது சொல்ல வேண்டிய மந்த்ரங்கள் கீழ்வருமாறு:\n"
      )
      comSt49.setSpan(AbsoluteSizeSpan(10, true), start, comSt49.length, exExFlag)
      comSt49.setSpan(StyleSpan(Typeface.ITALIC), start, comSt49.length, exExFlag)
      comSt49.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt49.length, exExFlag)

      val comSt49A = SpannableString(" வருணபாசம் ")
      comSt49A.setSpan(AbsoluteSizeSpan(10, true), start, comSt49A.length, exExFlag)
      comSt49A.setSpan(StyleSpan(Typeface.ITALIC), start, comSt49A.length, exExFlag)
      comSt49A.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt49A.length, exExFlag)

      val varuna = BitmapFactory.decodeResource(resources, R.drawable.varunabasammudra)
      comSt49A.setSpan(ImageSpan(this, varuna), 9, 10, Spannable.SPAN_INCLUSIVE_INCLUSIVE)

      val comSt49B = SpannableString(
        "\nஎன்ற முறையில் கோர்த்து வைத்துக் கொண்டு, " +
                "விரல்களின் இடைவெளி வழியாக சூரியனை தரிசிக்க வேண்டும். அப்பொது சொல்ல வேண்டிய மந்த்ரங்கள் கீழ்வருமாறு:\n"
      )
      comSt49B.setSpan(AbsoluteSizeSpan(10, true), start, comSt49B.length, exExFlag)
      comSt49B.setSpan(StyleSpan(Typeface.ITALIC), start, comSt49B.length, exExFlag)
      comSt49B.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt49B.length, exExFlag)

      val hdSt15 = SpannableString("\nசூர்ய ப்ரார்த்தனை\n")
      hdSt15.setSpan(AbsoluteSizeSpan(16, true), start, hdSt15.length, exExFlag)
      hdSt15.setSpan(StyleSpan(Typeface.BOLD), start, hdSt15.length, exExFlag)
      hdSt15.setSpan(UnderlineSpan(), start, hdSt15.length, exExFlag)
      hdSt15.setSpan(
        ForegroundColorSpan(Color.parseColor("#8b008b")),
        start,
        hdSt15.length,
        exExFlag
      )

      val bdSt80 = SpannableString(
        "\nஉத்வயம் தமஸ ஸ்பரிஸ்வ: \n   பச்யந்த உத்தரம் |\n" +
                "    தேவம் தேவத்ரா சூர்யமகன்ம \n   ஜ்யோ திருத்தமம் ||\n" +
                " உதுத்யம் ஜாதவேதஸம் தேவம் \n   வஹந்தி கேதவ: |\n" +
                "    த்ருசே விச்வாய சூர்யம் ||\n" +
                " சித்ரம் தேவாநாமுதகாத் அனீகம் \n   சக்ஷுர் மித்ரஸ்ய வருணஸ்யாக்னே: |\n" +
                "    ஆப்ரா த்யாவாப்ருதிவீ அந்தரிக்ஷக்கு \n   ஸூர்ய ஆத்மா ஜகதஸ்தஸ்துஷஸ்ச |\n" +
                " தச்சக்ஷுசர் தேவஹிதம் \n   புரஸ்தாச்சுக்ரமுச்சரத் |\n" +
                "    பச்யேம சரதஸ்சதஞ் ஜீவேம \n   சரதஸ்சதக்கு ச்ருணுயாமசரதஸ்சதம் ||\n"
      )
      bdSt80.setSpan(AbsoluteSizeSpan(12, true), start, bdSt80.length, exExFlag)
      bdSt80.setSpan(StyleSpan(Typeface.BOLD), start, bdSt80.length, exExFlag)
      bdSt80.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt80.length,
        exExFlag
      )

      val comSt50 = SpannableString(" - என்று நமஸ்கரிக்கவும்")
      comSt50.setSpan(AbsoluteSizeSpan(10, true), start, comSt50.length, exExFlag)
      comSt50.setSpan(StyleSpan(Typeface.ITALIC), start, comSt50.length, exExFlag)
      comSt50.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt50.length, exExFlag)

      val hdSt16 = SpannableString("\n\nதிக் தேவதா ப்ரார்த்தனை")
      hdSt16.setSpan(AbsoluteSizeSpan(16, true), start, hdSt16.length, exExFlag)
      hdSt16.setSpan(StyleSpan(Typeface.BOLD), start, hdSt16.length, exExFlag)
      hdSt16.setSpan(UnderlineSpan(), start, hdSt16.length, exExFlag)
      hdSt16.setSpan(
        ForegroundColorSpan(Color.parseColor("#8b008b")),
        start,
        hdSt16.length,
        exExFlag
      )

      val comSt51 = SpannableString("\nகிழக்கு நோக்கி- ")
      comSt51.setSpan(AbsoluteSizeSpan(10, true), start, comSt51.length, exExFlag)
      comSt51.setSpan(StyleSpan(Typeface.ITALIC), start, comSt51.length, exExFlag)
      comSt51.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt51.length, exExFlag)

      val bdSt81 = SpannableString("ஓம் ப்ராச்யை திசே நம: |\n இந்த்ராய நம: |")
      bdSt81.setSpan(AbsoluteSizeSpan(12, true), start, bdSt81.length, exExFlag)
      bdSt81.setSpan(StyleSpan(Typeface.BOLD), start, bdSt81.length, exExFlag)
      bdSt81.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt81.length,
        exExFlag
      )

      val comSt52 = SpannableString("\nதென்கிழக்கு நோக்கி- ")
      comSt52.setSpan(AbsoluteSizeSpan(10, true), start, comSt52.length, exExFlag)
      comSt52.setSpan(StyleSpan(Typeface.ITALIC), start, comSt52.length, exExFlag)
      comSt52.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt52.length, exExFlag)

      val bdSt82 = SpannableString("ஓம் ஆக்னேய்யை திசே நம: |\n அக்னயே நம: |")
      bdSt82.setSpan(AbsoluteSizeSpan(12, true), start, bdSt82.length, exExFlag)
      bdSt82.setSpan(StyleSpan(Typeface.BOLD), start, bdSt82.length, exExFlag)
      bdSt82.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt82.length,
        exExFlag
      )

      val comSt53 = SpannableString("\nதெற்கு நோக்கி- ")
      comSt53.setSpan(AbsoluteSizeSpan(10, true), start, comSt53.length, exExFlag)
      comSt53.setSpan(StyleSpan(Typeface.ITALIC), start, comSt53.length, exExFlag)
      comSt53.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt53.length, exExFlag)

      val bdSt83 = SpannableString("ஓம் தக்ஷிணாயை திசே நம: |\n யமாய நம: |")
      bdSt83.setSpan(AbsoluteSizeSpan(12, true), start, bdSt83.length, exExFlag)
      bdSt83.setSpan(StyleSpan(Typeface.BOLD), start, bdSt83.length, exExFlag)
      bdSt83.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt83.length,
        exExFlag
      )

      val comSt54 = SpannableString("\nதென்மேற்கு நோக்கி- ")
      comSt54.setSpan(AbsoluteSizeSpan(10, true), start, comSt54.length, exExFlag)
      comSt54.setSpan(StyleSpan(Typeface.ITALIC), start, comSt54.length, exExFlag)
      comSt54.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt54.length, exExFlag)

      val bdSt84 = SpannableString("ஓம் நைர்ருத்யை திசே நம: |\n நிர்ருதயே நம: |")
      bdSt84.setSpan(AbsoluteSizeSpan(12, true), start, bdSt84.length, exExFlag)
      bdSt84.setSpan(StyleSpan(Typeface.BOLD), start, bdSt84.length, exExFlag)
      bdSt84.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt84.length,
        exExFlag
      )

      val comSt55 = SpannableString("\nமேற்கு நோக்கி- ")
      comSt55.setSpan(AbsoluteSizeSpan(10, true), start, comSt55.length, exExFlag)
      comSt55.setSpan(StyleSpan(Typeface.ITALIC), start, comSt55.length, exExFlag)
      comSt55.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt55.length, exExFlag)

      val bdSt85 = SpannableString("ஓம் ப்ரதீச்யை திசே நம: |\n வருணாய நம: |")
      bdSt85.setSpan(AbsoluteSizeSpan(12, true), start, bdSt85.length, exExFlag)
      bdSt85.setSpan(StyleSpan(Typeface.BOLD), start, bdSt85.length, exExFlag)
      bdSt85.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt85.length,
        exExFlag
      )

      val comSt56 = SpannableString("\nவடமேற்கு நோக்கி- ")
      comSt56.setSpan(AbsoluteSizeSpan(10, true), start, comSt56.length, exExFlag)
      comSt56.setSpan(StyleSpan(Typeface.ITALIC), start, comSt56.length, exExFlag)
      comSt56.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt56.length, exExFlag)

      val bdSt86 = SpannableString("ஓம் வாயவ்யை திசே நம: |\n வாயவே நம: |")
      bdSt86.setSpan(AbsoluteSizeSpan(12, true), start, bdSt86.length, exExFlag)
      bdSt86.setSpan(StyleSpan(Typeface.BOLD), start, bdSt86.length, exExFlag)
      bdSt86.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt86.length,
        exExFlag
      )

      val comSt57 = SpannableString("\nவடக்கு நோக்கி- ")
      comSt57.setSpan(AbsoluteSizeSpan(10, true), start, comSt57.length, exExFlag)
      comSt57.setSpan(StyleSpan(Typeface.ITALIC), start, comSt57.length, exExFlag)
      comSt57.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt57.length, exExFlag)

      val bdSt87 = SpannableString("ஓம் உதீச்யை திசே நம: |\n ஸோமாய நம: |")
      bdSt87.setSpan(AbsoluteSizeSpan(12, true), start, bdSt87.length, exExFlag)
      bdSt87.setSpan(StyleSpan(Typeface.BOLD), start, bdSt87.length, exExFlag)
      bdSt87.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt87.length,
        exExFlag
      )

      val comSt58 = SpannableString("\nவடகிழக்கு நோக்கி- ")
      comSt58.setSpan(AbsoluteSizeSpan(10, true), start, comSt58.length, exExFlag)
      comSt58.setSpan(StyleSpan(Typeface.ITALIC), start, comSt58.length, exExFlag)
      comSt58.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt58.length, exExFlag)

      val bdSt88 = SpannableString("ஓம் ஐசான்யை திசே நம: |\n ஈசாநாய நம: |")
      bdSt88.setSpan(AbsoluteSizeSpan(12, true), start, bdSt88.length, exExFlag)
      bdSt88.setSpan(StyleSpan(Typeface.BOLD), start, bdSt88.length, exExFlag)
      bdSt88.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt88.length,
        exExFlag
      )

      val comSt59 = SpannableString("\nமேல் நோக்கி- ")
      comSt59.setSpan(AbsoluteSizeSpan(10, true), start, comSt59.length, exExFlag)
      comSt59.setSpan(StyleSpan(Typeface.ITALIC), start, comSt59.length, exExFlag)
      comSt59.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt59.length, exExFlag)

      val bdSt89 = SpannableString("ஓம் ஊர்த்வாயை திசே நம: |\n பிரம்மணே நம: |")
      bdSt89.setSpan(AbsoluteSizeSpan(12, true), start, bdSt89.length, exExFlag)
      bdSt89.setSpan(StyleSpan(Typeface.BOLD), start, bdSt89.length, exExFlag)
      bdSt89.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt89.length,
        exExFlag
      )

      val comSt60 = SpannableString("\nகீழ் நோக்கி- ")
      comSt60.setSpan(AbsoluteSizeSpan(10, true), start, comSt60.length, exExFlag)
      comSt60.setSpan(StyleSpan(Typeface.ITALIC), start, comSt60.length, exExFlag)
      comSt60.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt60.length, exExFlag)

      val bdSt90 = SpannableString("ஓம் அதராயை திசே நம: |\n அனந்தாய நம: |")
      bdSt90.setSpan(AbsoluteSizeSpan(12, true), start, bdSt90.length, exExFlag)
      bdSt90.setSpan(StyleSpan(Typeface.BOLD), start, bdSt90.length, exExFlag)
      bdSt90.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt90.length,
        exExFlag
      )

      val comSt61 = SpannableString("\nநேர்முகமாக நோக்கி- ")
      comSt61.setSpan(AbsoluteSizeSpan(10, true), start, comSt61.length, exExFlag)
      comSt61.setSpan(StyleSpan(Typeface.ITALIC), start, comSt61.length, exExFlag)
      comSt61.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt61.length, exExFlag)

      val bdSt91 = SpannableString("ஓம் அவாச்யை திசே நம: |\n அந்தரிக்ஷாய நம: |")
      bdSt91.setSpan(AbsoluteSizeSpan(12, true), start, bdSt91.length, exExFlag)
      bdSt91.setSpan(StyleSpan(Typeface.BOLD), start, bdSt91.length, exExFlag)
      bdSt91.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt91.length,
        exExFlag
      )

      val comSt62 = SpannableString("\nபூமியை நோக்கி- ")
      comSt62.setSpan(AbsoluteSizeSpan(10, true), start, comSt62.length, exExFlag)
      comSt62.setSpan(StyleSpan(Typeface.ITALIC), start, comSt62.length, exExFlag)
      comSt62.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt62.length, exExFlag)

      val bdSt92 = SpannableString("பூம்யை நம: |")
      bdSt92.setSpan(AbsoluteSizeSpan(12, true), start, bdSt92.length, exExFlag)
      bdSt92.setSpan(StyleSpan(Typeface.BOLD), start, bdSt92.length, exExFlag)
      bdSt92.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt92.length,
        exExFlag
      )

      val comSt63 = SpannableString("\nநேர்முகமாக- ")
      comSt63.setSpan(AbsoluteSizeSpan(10, true), start, comSt63.length, exExFlag)
      comSt63.setSpan(StyleSpan(Typeface.ITALIC), start, comSt63.length, exExFlag)
      comSt63.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt63.length, exExFlag)

      val bdSt93 =
        SpannableString("ஸந்த்யாயை நம: |\n காயத்ர்யை நம: |\nஸாவித்ர்யை நம: | ஸரஸ்வத்யை நம: |")
      bdSt93.setSpan(AbsoluteSizeSpan(12, true), start, bdSt93.length, exExFlag)
      bdSt93.setSpan(StyleSpan(Typeface.BOLD), start, bdSt93.length, exExFlag)
      bdSt93.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt93.length,
        exExFlag
      )

      val hdSt17 = SpannableString("\n\nகாமோஷீத் - மஹாமந்த்ரம்")
      hdSt17.setSpan(AbsoluteSizeSpan(16, true), start, hdSt17.length, exExFlag)
      hdSt17.setSpan(StyleSpan(Typeface.BOLD), start, hdSt17.length, exExFlag)
      hdSt17.setSpan(UnderlineSpan(), start, hdSt17.length, exExFlag)
      hdSt17.setSpan(
        ForegroundColorSpan(Color.parseColor("#8b008b")),
        start,
        hdSt17.length,
        exExFlag
      )

      val comSt64 = SpannableString("\nஸூரியனை நோக்கி கைகூப்பி- ")
      comSt64.setSpan(AbsoluteSizeSpan(10, true), start, comSt64.length, exExFlag)
      comSt64.setSpan(StyleSpan(Typeface.ITALIC), start, comSt64.length, exExFlag)
      comSt64.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt64.length, exExFlag)

      val bdSt94 = SpannableString("காமோஸகாரிஷீத் | மன்யுரகாரிஷீத் |\n    ஓம் நமோ நம: ||")
      bdSt94.setSpan(AbsoluteSizeSpan(12, true), start, bdSt94.length, exExFlag)
      bdSt94.setSpan(StyleSpan(Typeface.BOLD), start, bdSt94.length, exExFlag)
      bdSt94.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt94.length,
        exExFlag
      )

      val hdSt18 = SpannableString("\n\nஸூர்ய வந்தனம்")
      hdSt18.setSpan(AbsoluteSizeSpan(16, true), start, hdSt18.length, exExFlag)
      hdSt18.setSpan(StyleSpan(Typeface.BOLD), start, hdSt18.length, exExFlag)
      hdSt18.setSpan(UnderlineSpan(), start, hdSt18.length, exExFlag)
      hdSt18.setSpan(
        ForegroundColorSpan(Color.parseColor("#8b008b")),
        start,
        hdSt18.length,
        exExFlag
      )

      val bdSt95 = SpannableString(
        "\nஓம் நமஸ் ஸவித்ரே ஜகதேக சக்ஷூஷே\n" +
                "   ஜகத் ப்ரஸூதி ஸ்திதி நாச ஹேதவே |\n" +
                "்ரயீமயாய த்ரிகுணாத்ம தாரிணே\n" +
                "   விரிஞ்சி நாராயண சங்கராத்மனே ||\n" +
                "த்யேயஸ் ஸதா ஸவித்ரு மண்டல மத்யவர்த்தீ நாராயண:\n" +
                "   ஸரஸிஜான ஸன்னிவிஷ்ட: கேயூரவான் மகரகுண்டல\n" +
                "வான் | கிரீடீ ஹாரீ ஹிரண்மயவபு: த்ருத சங்கசக்ர: |\n" +
                "   சங்கசக்ர கதாபாணே த்வாரகா நிலயாச்யுத |\n" +
                "கோவிந்த! புண்டரீகாக்ஷ! ரக்ஷமாம் சரணாகதம் ||\n" +
                "   ரக்ஷமாம் சரணாகதம் ஓம் நம இதி ||\n    ஓம் நமோ நம: ||"
      )
      bdSt95.setSpan(AbsoluteSizeSpan(12, true), start, bdSt95.length, exExFlag)
      bdSt95.setSpan(StyleSpan(Typeface.BOLD), start, bdSt95.length, exExFlag)
      bdSt95.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt95.length,
        exExFlag
      )

      val hdSt19 = SpannableString("\n\nயம வந்தனம்")
      hdSt19.setSpan(AbsoluteSizeSpan(16, true), start, hdSt19.length, exExFlag)
      hdSt19.setSpan(StyleSpan(Typeface.BOLD), start, hdSt19.length, exExFlag)
      hdSt19.setSpan(UnderlineSpan(), start, hdSt19.length, exExFlag)
      hdSt19.setSpan(
        ForegroundColorSpan(Color.parseColor("#8b008b")),
        start,
        hdSt19.length,
        exExFlag
      )

      val bdSt96 = SpannableString(
        "யமாய தர்மராஜாய ம்ருத்யவே சாந்தகாய ச |\n" +
                "    வைவஸ்வதாய காலாய ஸர்வபூதக்ஷயாய ச ||\n" +
                " ஔதும்பராய தத்நாய நீலாய பரமேஷ்டிநே |\n" +
                "    வ்ருகோதராய சித்ராய சித்ரகுப்தாய வை நம: ||\n" +
                " சித்ரகுப்தாய வை நம ஓம் நம இதி ||"
      )
      bdSt96.setSpan(AbsoluteSizeSpan(12, true), start, bdSt96.length, exExFlag)
      bdSt96.setSpan(StyleSpan(Typeface.BOLD), start, bdSt96.length, exExFlag)
      bdSt96.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt96.length,
        exExFlag
      )

      val hdSt20 = SpannableString("\n\nஹரிஹர வந்தனம்")
      hdSt20.setSpan(AbsoluteSizeSpan(16, true), start, hdSt20.length, exExFlag)
      hdSt20.setSpan(StyleSpan(Typeface.BOLD), start, hdSt20.length, exExFlag)
      hdSt20.setSpan(UnderlineSpan(), start, hdSt20.length, exExFlag)
      hdSt20.setSpan(
        ForegroundColorSpan(Color.parseColor("#8b008b")),
        start,
        hdSt20.length,
        exExFlag
      )

      val bdSt97 = SpannableString(
        "ருதகும் ஸத்யம் பரம் ப்ரம்ஹ புருஷம் க்ருஷ்ண பிங்களம் |\n" +
                "    ஊர்த்வரேதம் விரூபாக்ஷம் விச்வரூபாய வை நமோ நம:\n" +
                " விச்வரூபாய வை நம ஓம் நம இதி ||"
      )
      bdSt97.setSpan(AbsoluteSizeSpan(12, true), start, bdSt97.length, exExFlag)
      bdSt97.setSpan(StyleSpan(Typeface.BOLD), start, bdSt97.length, exExFlag)
      bdSt97.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt97.length,
        exExFlag
      )

      val hdSt21 = SpannableString("\n\nசூர்ய ப்ரார்த்தனை")
      hdSt21.setSpan(AbsoluteSizeSpan(16, true), start, hdSt21.length, exExFlag)
      hdSt21.setSpan(StyleSpan(Typeface.BOLD), start, hdSt21.length, exExFlag)
      hdSt21.setSpan(UnderlineSpan(), start, hdSt21.length, exExFlag)
      hdSt21.setSpan(
        ForegroundColorSpan(Color.parseColor("#8b008b")),
        start,
        hdSt21.length,
        exExFlag
      )

      val bdSt98 = SpannableString(
        "ஆகாசாத் பதிதம் தோயம் யதாகச்சதி ஸாகரம் |\n" +
                "    ஸர்வதேவ நமஸ்கார: கேசவம் ப்ரதி கச்சதி |\n" +
                " கேசவம் ப்ரதி கச்சதி ஓம் நம இதி ||\n" +
                "    பாபோஹம் பாகர்மாஹம் பாபாத்மா பாபஸம்பவ: |\n" +
                " த்ராஹிமாம் க்ருபயா தேவ சரணாகதவத்ஸல ||\n" +
                "    சரணாகதவத்ஸல ஓம் நம இதி ||\n"
      )
      bdSt98.setSpan(AbsoluteSizeSpan(12, true), start, bdSt98.length, exExFlag)
      bdSt98.setSpan(StyleSpan(Typeface.BOLD), start, bdSt98.length, exExFlag)
      bdSt98.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt98.length,
        exExFlag
      )

      val hdSt22 = SpannableString("\n\nஜபஸமர்ப்பணம்")
      hdSt22.setSpan(AbsoluteSizeSpan(16, true), start, hdSt22.length, exExFlag)
      hdSt22.setSpan(StyleSpan(Typeface.BOLD), start, hdSt22.length, exExFlag)
      hdSt22.setSpan(UnderlineSpan(), start, hdSt22.length, exExFlag)
      hdSt22.setSpan(
        ForegroundColorSpan(Color.parseColor("#8b008b")),
        start,
        hdSt22.length,
        exExFlag
      )

      val comSt65 =
        SpannableString("\nவலது கையில் ஒவ்வொரு உத்தரணி ஜலத்தை விட்டுக் கொண்டு, பூமியில் விடவும்- ")
      comSt65.setSpan(AbsoluteSizeSpan(10, true), start, comSt65.length, exExFlag)
      comSt65.setSpan(StyleSpan(Typeface.ITALIC), start, comSt65.length, exExFlag)
      comSt65.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt65.length, exExFlag)

      val bdSt99A = SpannableString(
        "\nமயாக்ருதமிதம் TYPEOFSANDYA \nகாயத்ரீ ஜபாக்யம் கர்ம ஸர்வம் \nஸ்ரீ க்ருணார்ப்பணமஸ்து |\n" +
                "    வாஸுதேவார்ப்பணமஸ்து |\n" +
                " ஓம் தத்ஸத் பிரம்மார்ப்பணமஸ்து ||\n" +
                " காயேனவாசா மனஸேந்த்ரியைர்வா\n" +
                "    புத்த்யாத்மனாவா ப்ரக்ருதேஸ் ஸ்வபாவாத் |\n" +
                " கரோமி யத்யத் ஸகலம் பரஸ்மை\n" +
                "    நாராயணாயேதி ஸமர்ப்பயாமி ||\n" +
                "நாராயணா நாராயணா நாராயணா நாராயணா\nநாராயணா நாராயணா நாராயணா நாராயணா\nநாராயணா நாராயணா நாராயணா நாராயணா\n" +
                " ப்ராயஸ்சித்தான்யசேஷாணி தபகர்மாத்மகானி வை |\n" +
                "    யானி தேஷாம் அசேஷாணாம\n" +
                " க்ருஷ்ணானுஸ்மரணம் பரம் ||\n" +
                "ஸ்ரீக்ருஷ்ண ஸ்ரீக்ருஷ்ண ஸ்ரீக்ருஷ்ண\nஸ்ரீக்ருஷ்ண ஸ்ரீக்ருஷ்ண ஸ்ரீக்ருஷ்ண\nஸ்ரீக்ருஷ்ண ஸ்ரீக்ருஷ்ண ஸ்ரீக்ருஷ்ண\nஸ்ரீக்ருஷ்ண ஸ்ரீக்ருஷ்ண ஸ்ரீக்ருஷ்ண"
      )
      val bdSt99 = SpannableString(bdSt99A.replace(regexReplace1, sandyaType))
      bdSt99.setSpan(AbsoluteSizeSpan(12, true), start, bdSt99.length, exExFlag)
      bdSt99.setSpan(StyleSpan(Typeface.BOLD), start, bdSt99.length, exExFlag)
      bdSt99.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt99.length,
        exExFlag
      )

      val comSt66 = SpannableString("\nஜபம் செய்ய உட்கார்ந்த இடத்தில் லேசாக ஜலம் தெளிக்கவும்- ")
      comSt66.setSpan(AbsoluteSizeSpan(10, true), start, comSt66.length, exExFlag)
      comSt66.setSpan(StyleSpan(Typeface.ITALIC), start, comSt66.length, exExFlag)
      comSt66.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt66.length, exExFlag)

      val bdSt100 =
        SpannableString("\nபூர் புவஸ்ஸுவ: |\n    புண்டரீகாக்ஷாய நம: ||\n   ஓம் விச்வானி தேவஸவிதர் \n   துரிதானி பராஸுவ |\nயத்பத்ரம் தன்ன ஆஸுவ ||")
      bdSt100.setSpan(AbsoluteSizeSpan(12, true), start, bdSt100.length, exExFlag)
      bdSt100.setSpan(StyleSpan(Typeface.BOLD), start, bdSt100.length, exExFlag)
      bdSt100.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt100.length,
        exExFlag
      )

      val comSt67 = SpannableString(
        "\n(மோதிர விரலால் பூமியைத் தொட்டு நெற்றியில் இட்டுக் கொள்ளவும்)\n\nஜபம் செய்த இடத்தை, " +
                "ஜலம் தெளித்து நெற்றியில் இட்டுக் கொள்ள வேண்டும் என்பதைச் சொல்லும் சுலோகம் இது:-"
      )
      comSt67.setSpan(AbsoluteSizeSpan(10, true), start, comSt67.length, exExFlag)
      comSt67.setSpan(StyleSpan(Typeface.ITALIC), start, comSt67.length, exExFlag)
      comSt67.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comSt67.length, exExFlag)

      val bdSt101 =
        SpannableString("அப்ரோக்ஷிதே ஜபஸ்தானே \n   சுக்ரோ ஹரதித்ஜ்ஜபம் |\n    தன் மூலே ம்ருத்திகாம் \n   குர்யால்லலாடே திலகாக்ருதிம் ||")
      bdSt101.setSpan(AbsoluteSizeSpan(12, true), start, bdSt101.length, exExFlag)
      bdSt101.setSpan(StyleSpan(Typeface.BOLD), start, bdSt101.length, exExFlag)
      bdSt101.setSpan(
        ForegroundColorSpan(Color.parseColor("#0000ee")),
        start,
        bdSt101.length,
        exExFlag
      )

      val hdSt23 = SpannableString("\n\nமுற்றும்\n\n\n")
      hdSt23.setSpan(AbsoluteSizeSpan(16, true), start, hdSt23.length, exExFlag)
      hdSt23.setSpan(StyleSpan(Typeface.BOLD), start, hdSt23.length, exExFlag)
      hdSt23.setSpan(UnderlineSpan(), start, hdSt23.length, exExFlag)
      hdSt23.setSpan(
        ForegroundColorSpan(Color.parseColor("#8b008b")),
        start,
        hdSt23.length,
        exExFlag
      )

      val gayathriCombination = SpannableStringBuilder()
      gayathriCombination.append(
        hdSt1,
        comSt1,
        comSt2,
        bdSt1,
        comSt3,
        bdSt2,
        comSt4,
        bdSt3,
        comSt5,
        bdSt4,
        comSt6,
        bdSt5
      )
      gayathriCombination.append(
        comSt7,
        bdSt6,
        comSt8,
        bdSt7,
        comSt9,
        bdSt8,
        comSt10,
        bdSt9,
        comSt11,
        bdSt10,
        comSt12,
        bdSt11
      )
      gayathriCombination.append(
        comSt13,
        bdSt12,
        comSt14,
        bdSt13,
        comSt15,
        bdSt14,
        hdSt2,
        comSt16,
        bdSt15,
        hdSt3,
        comSt17
      )
      gayathriCombination.append(
        bdSt16,
        comSt18,
        bdSt17,
        hdSt4,
        comSt19,
        bdSt18,
        comSt20,
        bdSt19,
        hdSt5,
        bdSt20,
        hdSt6,
        comSt21,
        bdSt21
      )
      gayathriCombination.append(
        comSt22,
        bdSt22,
        comSt23,
        bdSt23,
        comSt24,
        bdSt24,
        comSt25,
        bdSt25,
        comSt26,
        bdSt26,
        hdSt3A
      )
      gayathriCombination.append(
        comSt21,
        bdSt27,
        comSt22,
        bdSt28,
        comSt23,
        bdSt29,
        comSt21,
        bdSt30,
        comSt22,
        bdSt31,
        comSt23,
        bdSt32
      )
      gayathriCombination.append(
        comSt21,
        bdSt33,
        comSt22,
        bdSt34,
        comSt23,
        bdSt35,
        comSt21,
        bdSt36,
        comSt22,
        bdSt37,
        comSt23,
        bdSt38
      )
      gayathriCombination.append(
        comSt25,
        bdSt39,
        hdSt3B,
        comSt17Ten,
        bdSt16A,
        hdSt7,
        comSt21,
        bdSt40,
        comSt22,
        bdSt41,
        comSt23,
        bdSt42
      )
      gayathriCombination.append(
        comSt25,
        bdSt43,
        comSt21,
        bdSt44,
        comSt22,
        bdSt34,
        comSt23,
        bdSt35,
        comSt27,
        bdSt45,
        comSt21,
        bdSt46
      )
      gayathriCombination.append(
        comSt23,
        bdSt47,
        comSt28,
        bdSt48,
        comSt29,
        bdSt49,
        comSt30,
        bdSt50
      )
      if (sandyaType.equals("ப்ராத்தஸ்ந்தியா", true)) {
        gayathriCombination.append(bdSt51A)
      } else if (sandyaType.equals("மாத்யாநிஹம்", true)) {
        gayathriCombination.append(bdSt51B)
      } else {
        gayathriCombination.append(bdSt51C)
      }
      gayathriCombination.append(
        hdSt8,
        comSt31,
        bdSt52,
        comSt32,
        bdSt53,
        comSt33Missg,
        bdSt54Missg,
        comSt33,
        bdSt54,
        comSt34,
        bdSt55,
        hdSt9,
        comSt23,
        bdSt56
      )
      gayathriCombination.append(
        comSt21,
        bdSt57,
        comSt35,
        bdSt58,
        comSt36,
        bdSt59,
        comSt37,
        bdSt60,
        comSt38,
        bdSt61,
        comSt39,
        bdSt62
      )
      gayathriCombination.append(
        hdSt10,
        comSt40,
        bdSt63,
        hdSt11,
        comSt41,
        bdSt64,
        comSt42,
        bdSt65,
        comSt43,
        bdSt66,
        comSt44,
        bdSt67
      )
      gayathriCombination.append(
        comSt45,
        bdSt68,
        comSt25,
        bdSt69,
        hdSt12,
        comSt46,
        bdSt70,
        hdSt13,
        comSt17,
        bdSt16B,
        comSt18,
        bdSt17A
      )
      gayathriCombination.append(
        hdSt9A,
        comSt23,
        bdSt56A,
        comSt21,
        bdSt57A,
        comSt35,
        bdSt58A,
        comSt36,
        bdSt59A,
        comSt37,
        bdSt60A,
        comSt38Add,
        bdSt61Add,
        comSt47
      )
      gayathriCombination.append(
        bdSt71,
        hdSt10A,
        comSt25,
        bdSt72,
        hdSt11A,
        comSt41,
        bdSt73,
        comSt42,
        bdSt74,
        comSt43,
        bdSt75,
        comSt44
      )
      gayathriCombination.append(
        bdSt76,
        comSt45,
        bdSt77,
        comSt25,
        bdSt78,
        "\n",
        hdSt14,
        comSt48,
        bdSt79,
        comSt49,
        comSt49A,
        comSt49B,
        hdSt15,
        bdSt80,
        hdSt5A
      )
      gayathriCombination.append(
        bdSt20K,
        comSt50,
        hdSt16,
        comSt51,
        bdSt81,
        comSt52,
        bdSt82,
        comSt53,
        bdSt83,
        comSt54,
        bdSt84,
        comSt55,
        bdSt85
      )
      gayathriCombination.append(
        comSt56,
        bdSt86,
        comSt57,
        bdSt87,
        comSt58,
        bdSt88,
        comSt59,
        bdSt89,
        comSt60,
        bdSt90,
        comSt61,
        bdSt91,
        comSt62
      )
      gayathriCombination.append(
        bdSt92,
        comSt63,
        bdSt93,
        hdSt17,
        comSt64,
        bdSt94,
        hdSt18,
        bdSt95,
        hdSt19,
        comSt53,
        bdSt96,
        hdSt20,
        comSt57
      )
      gayathriCombination.append(
        bdSt97,
        hdSt21,
        comSt64,
        bdSt98,
        hdSt5B,
        bdSt20G,
        comSt50,
        hdSt22,
        comSt65,
        bdSt99,
        comSt66,
        bdSt100,
        comSt67,
        bdSt101,
        hdSt23
      )

      gayathriCombination.append("\n")
      binding.gayathrijapamTextView.text = gayathriCombination
    
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
        // var pagnumber = pagnumber
         val canvas = page.canvas
         // Page numbers start at 1, but list indices start at 0
         val pageIndex = pagnumber - 1
         
       //  pagnumber++ // Make sure page numbers start at 1

         //  val titleBaseLine = 72
         //  val leftMargin = 54
         val paint = Paint()
      //   paint.color = Color.BLACK
       //  paint.textSize = 40f
       //  val pageInfo = page.info

         val logo = BitmapFactory.decodeResource(context.resources, R.drawable.mediumlogo75px)
         val bground = BitmapFactory.decodeResource(context.resources, R.drawable.yvkr)
         val pageInfo = page.info
         canvas.drawBitmap(logo, (pageInfo.pageWidth / 12 - logo.width / 6).toFloat(), 0f, paint)
         canvas.drawBitmap(bground, (pageInfo.pageWidth / 2 - bground.width / 2).toFloat(), (pageInfo.pageHeight/2- bground.height/2).toFloat(), paint)
        // paint.textSize = 14f

         //   val toScale = (bm!!.width / pageWidth).toDouble()
         val mTextPaint = TextPaint()

         val pageTexts = listOf(
           gayathriCombination.subSequence(startPos1, endPos1),
           gayathriCombination.subSequence(startPos2, endPos2),
           gayathriCombination.subSequence(startPos3, endPos3),
           gayathriCombination.subSequence(startPos4, endPos4),
           gayathriCombination.subSequence(startPos5, endPos5),
           gayathriCombination.subSequence(startPos6, endPos6),
           gayathriCombination.subSequence(startPos7, endPos7),
           gayathriCombination.subSequence(startPos8, endPos8),
           gayathriCombination.subSequence(startPos9, endPos9),
           gayathriCombination.subSequence(startPos10, endPos10),
           gayathriCombination.subSequence(startPos11, endPos11),
           gayathriCombination.subSequence(startPos12, endPos12),
           gayathriCombination.subSequence(startPos13, endPos13),
           gayathriCombination.subSequence(startPos14, endPos14),
           gayathriCombination.subSequence(startPos15, endPos15),
           gayathriCombination.subSequence(startPos16, endPos16),
           gayathriCombination.subSequence(startPos17, endPos17)
         )

         if (pageIndex in 0 until pageTexts.size) {
    val pageText = pageTexts[pageIndex]
    val mTextLayout = StaticLayout.Builder
        .obtain(pageText, 0, pageText.length, mTextPaint, canvas.width)
        .setAlignment(Layout.Alignment.ALIGN_CENTER)
        .setLineSpacing(1.0f, 1.0f)
        .setIncludePad(true)
        .build()
    mTextLayout.draw(canvas)

           val footerText = SpannableString("$heading (Page No. $pagnumber of $totalpages)")
         footerText.setSpan(AbsoluteSizeSpan(10, true), 0, footerText.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
         footerText.setSpan(StyleSpan(Typeface.ITALIC), 0, footerText.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
         footerText.setSpan(ForegroundColorSpan(Color.RED), 0, footerText.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        // val footerText = footerText.toString()

           paint.textSize = 10f
           canvas.drawText(footerText.toString(), (pageInfo.pageWidth / 3 - footerText.length).toFloat(), pageInfo.pageHeight.toFloat(), paint)
      /*   if (pagnumber == 1 && totalpages >= 1) {
           val mTextLayout1 = StaticLayout(pageOneText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
           mTextLayout1.draw(canvas)
           paint.textSize = 10f
           canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
         }
         if (pagnumber == 2 && totalpages >= 2) {
           val mTextLayout2 = StaticLayout(pageTwoText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
           mTextLayout2.draw(canvas)
           paint.textSize = 10f
           paint.colorFilter
           canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
         }
         if (pagnumber == 3 && totalpages >= 3) {
           val mTextLayout3 = StaticLayout(pageThreeText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
           mTextLayout3.draw(canvas)
           paint.textSize = 10f
           canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
         }
         if (pagnumber == 4 && totalpages >= 4) {
           val mTextLayout4 = StaticLayout(pageFourText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
           mTextLayout4.draw(canvas)
           paint.textSize = 10f
           canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
         }
         if (pagnumber == 5 && totalpages >= 5) {
           val mTextLayout5 = StaticLayout(pageFiveText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
           mTextLayout5.draw(canvas)
           paint.textSize = 10f
           canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
         }
         if (pagnumber == 6 && totalpages >= 6) {
           val mTextLayout6 = StaticLayout(pageSixText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
           mTextLayout6.draw(canvas)
           paint.textSize = 10f
           canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
         }
         if (pagnumber == 7 && totalpages >= 7) {
           val mTextLayout7 = StaticLayout(pageSevenText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
           mTextLayout7.draw(canvas)
           paint.textSize = 10f
           canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
         }
         if (pagnumber == 8 && totalpages >= 8) {
           val mTextLayout8 = StaticLayout(pageEightText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
           mTextLayout8.draw(canvas)
           paint.textSize = 10f
           canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
         }
         if (pagnumber == 9 && totalpages >= 9) {
           val mTextLayout9 = StaticLayout(pageNineText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
           mTextLayout9.draw(canvas)
           paint.textSize = 10f
           canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
         }
         if (pagnumber == 10 && totalpages >= 10) {
           val mTextLayout10 = StaticLayout(pageTenText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
           mTextLayout10.draw(canvas)
           paint.textSize = 10f
           canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
         }
         if (pagnumber == 11 && totalpages >= 11) {
           val mTextLayout11 = StaticLayout(pageElevenText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
           mTextLayout11.draw(canvas)
           paint.textSize = 10f
           canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
         }
         if (pagnumber == 12 && totalpages >= 12) {
           val mTextLayout12 = StaticLayout(pageTwelveText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
           mTextLayout12.draw(canvas)
           paint.textSize = 10f
           canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
         }
         if (pagnumber == 13 && totalpages >= 13) {
           val mTextLayout13 = StaticLayout(pageThirteenText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
           mTextLayout13.draw(canvas)
           paint.textSize = 10f
           canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
         }
         if (pagnumber == 14 && totalpages >= 14) {
           val mTextLayout14 = StaticLayout(pageFourteenText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
           mTextLayout14.draw(canvas)
           paint.textSize = 10f
           canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
         }
         if (pagnumber == 15 && totalpages >= 15) {
           val mTextLayout15 = StaticLayout(pageFifteenText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
           mTextLayout15.draw(canvas)
           paint.textSize = 10f
           canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
         }
         if (pagnumber == 16 && totalpages >= 16) {
           val mTextLayout16 = StaticLayout(pageSixteenText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
           mTextLayout16.draw(canvas)
           paint.textSize = 10f
           canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
         }
         if (pagnumber == 17 && totalpages >= 17) {
           val mTextLayout17 = StaticLayout(pageSeventeenText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
           mTextLayout17.draw(canvas)
           paint.textSize = 10f
           canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
         }*/

       }}

         override fun onWrite(
           pageRanges: Array<PageRange>,
           destination: ParcelFileDescriptor,
           cancellationSignal: CancellationSignal?,
           callback: WriteResultCallback
         ) {
           try {
             myPdfDocument?.let { pdfDocument ->
               for (i in 0 until totalpages) {
                 if (pageInRange(pageRanges, i)) {
                   if (cancellationSignal?.isCanceled == true) {
                     callback.onWriteCancelled()
                     pdfDocument.close()
                     myPdfDocument = null
                     return
                   }

                   val newPage = PdfDocument.PageInfo.Builder(pageWidth, pageHeight, i).create()
                   val page = pdfDocument.startPage(newPage)
                   drawPage(page, i)
                   pdfDocument.finishPage(page)
                 }
               }

               pdfDocument.writeTo(FileOutputStream(destination.fileDescriptor))
             }
           } catch (e: IOException) {
             callback.onWriteFailed(e.toString())
             return
           } finally {
             myPdfDocument?.close()
             myPdfDocument = null
           }

           callback.onWriteFinished(pageRanges)
         

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
       val mTLineCount = binding.gayathrijapamTextView.lineCount
       println("mTLineCount : $mTLineCount")
       val totalChar = binding.gayathrijapamTextView.length()
      // val testTotalChar = totalChar.toString()
       println("totalChar : $totalChar")
       totalpages = ((mTLineCount / 50 + 0.99) / 0.99).toInt() // Calculate total pages
       println("totalpages : $totalpages")

       val pageTexts = mutableListOf<String>()
       val startPositions = mutableListOf<Int>()
       val endPositions = mutableListOf<Int>()
       
       for (page in 0 until totalpages) {
         val startLine = page * 50
         val endLine = minOf(startLine + 50, mTLineCount - 1) // Ensure endLine is within bounds

         val startPos = binding.gayathrijapamTextView.layout.getLineStart(startLine)
         val endPos = binding.gayathrijapamTextView.layout.getLineEnd(endLine)

         startPositions.add(startPos)
         endPositions.add(endPos)
         pageTexts.add(binding.gayathrijapamTextView.text.toString().substring(startPos, endPos))
       
       /*
       if (totalpages == 1) {
         startPos1 = binding.gayathrijapamTextView.layout.getLineStart(0)
         if (mTLineCount >= 50) {
           endPos1 = binding.gayathrijapamTextView.layout.getLineEnd(50)
         } else {
           endPos1 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount - 1)
         }
         //   pageOneText = binding.gayathrijapamTextView.text.toString().substring(startPos1, endPos1)
       }
       if (totalpages == 2) {
         startPos1 = binding.gayathrijapamTextView.layout.getLineStart(0)
         if (mTLineCount >= 50) {
           endPos1 = binding.gayathrijapamTextView.layout.getLineEnd(50)
         } else {
           endPos1 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         }
         //     pageOneText = binding.gayathrijapamTextView.text.toString().substring(startPos1, endPos1)
         if (mTLineCount in 51..100) {
           startPos2 = binding.gayathrijapamTextView.layout.getLineStart(51)
           endPos2 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos2 = binding.gayathrijapamTextView.layout.getLineStart(51)
           endPos2 = binding.gayathrijapamTextView.layout.getLineEnd(100)
         }
         //      pageTwoText = binding.gayathrijapamTextView.text.toString().substring(startPos2, endPos2)
       }
       if (totalpages == 3) {
         startPos1 = binding.gayathrijapamTextView.layout.getLineStart(0)
         if (mTLineCount >= 50) {
           endPos1 = binding.gayathrijapamTextView.layout.getLineEnd(50)
         } else {
           endPos1 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         }
         pageOneText = binding.gayathrijapamTextView.text.toString().substring(startPos1, endPos1)
         if (mTLineCount in 51..100) {
           startPos2 = binding.gayathrijapamTextView.layout.getLineStart(51)
           endPos2 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos2 = binding.gayathrijapamTextView.layout.getLineStart(51)
           endPos2 = binding.gayathrijapamTextView.layout.getLineEnd(100)
         }
         //    pageTwoText = binding.gayathrijapamTextView.text.toString().substring(startPos2, endPos2)
         if (mTLineCount in 101..150) {
           startPos3 = binding.gayathrijapamTextView.layout.getLineStart(101)
           endPos3 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos3 = binding.gayathrijapamTextView.layout.getLineStart(101)
           endPos3 = binding.gayathrijapamTextView.layout.getLineEnd(150)
         }
         //    pageThreeText = binding.gayathrijapamTextView.text.toString().substring(startPos3, endPos3)
       }
       if (totalpages == 4) {
         startPos1 = binding.gayathrijapamTextView.layout.getLineStart(0)
         if (mTLineCount >= 50) {
           endPos1 = binding.gayathrijapamTextView.layout.getLineEnd(50)
         } else {
           endPos1 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         }
         //   pageOneText = binding.gayathrijapamTextView.text.toString().substring(startPos1, endPos1)
         if (mTLineCount in 51..100) {
           startPos2 = binding.gayathrijapamTextView.layout.getLineStart(51)
           endPos2 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos2 = binding.gayathrijapamTextView.layout.getLineStart(51)
           endPos2 = binding.gayathrijapamTextView.layout.getLineEnd(100)
         }
         //    pageTwoText = binding.gayathrijapamTextView.text.toString().substring(startPos2, endPos2)
         if (mTLineCount in 101..150) {
           startPos3 = binding.gayathrijapamTextView.layout.getLineStart(101)
           endPos3 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos3 = binding.gayathrijapamTextView.layout.getLineStart(101)
           endPos3 = binding.gayathrijapamTextView.layout.getLineEnd(150)
         }
         //    pageThreeText = binding.gayathrijapamTextView.text.toString().substring(startPos3, endPos3)
         if (mTLineCount in 151..200) {
           startPos4 = binding.gayathrijapamTextView.layout.getLineEnd(151)
           endPos4 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos4 = binding.gayathrijapamTextView.layout.getLineEnd(151)
           endPos4 = binding.gayathrijapamTextView.layout.getLineEnd(200)
         }
         //    pageFourText = binding.gayathrijapamTextView.text.toString().substring(startPos4, endPos4)
       }
       if (totalpages == 5) {
         startPos1 = binding.gayathrijapamTextView.layout.getLineStart(0)
         if (mTLineCount >= 50) {
           endPos1 = binding.gayathrijapamTextView.layout.getLineEnd(50)
         } else {
           endPos1 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         }
         //   pageOneText = binding.gayathrijapamTextView.text.toString().substring(startPos1, endPos1)
         if (mTLineCount in 51..100) {
           startPos2 = binding.gayathrijapamTextView.layout.getLineStart(51)
           endPos2 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos2 = binding.gayathrijapamTextView.layout.getLineStart(51)
           endPos2 = binding.gayathrijapamTextView.layout.getLineEnd(100)
         }
         //    pageTwoText = binding.gayathrijapamTextView.text.toString().substring(startPos2, endPos2)
         if (mTLineCount in 101..150) {
           startPos3 = binding.gayathrijapamTextView.layout.getLineStart(101)
           endPos3 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos3 = binding.gayathrijapamTextView.layout.getLineStart(101)
           endPos3 = binding.gayathrijapamTextView.layout.getLineEnd(150)
         }
         //    pageThreeText = binding.gayathrijapamTextView.text.toString().substring(startPos3, endPos3)
         if (mTLineCount in 151..200) {
           startPos4 = binding.gayathrijapamTextView.layout.getLineEnd(151)
           endPos4 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos4 = binding.gayathrijapamTextView.layout.getLineEnd(151)
           endPos4 = binding.gayathrijapamTextView.layout.getLineEnd(200)
         }
         //    pageFourText = binding.gayathrijapamTextView.text.toString().substring(startPos4, endPos4)
         if (mTLineCount in 201..250) {
           startPos5 = binding.gayathrijapamTextView.layout.getLineEnd(201)
           endPos5 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos5 = binding.gayathrijapamTextView.layout.getLineEnd(201)
           endPos5 = binding.gayathrijapamTextView.layout.getLineEnd(250)
         }
         //    pageFiveText = binding.gayathrijapamTextView.text.toString().substring(startPos5, endPos5)
       }

       if (totalpages == 6) {
         startPos1 = binding.gayathrijapamTextView.layout.getLineStart(0)
         if (mTLineCount >= 50) {
           endPos1 = binding.gayathrijapamTextView.layout.getLineEnd(50)
         } else {
           endPos1 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         }
         //    pageOneText = binding.gayathrijapamTextView.text.toString().substring(startPos1, endPos1)
         if (mTLineCount in 51..100) {
           startPos2 = binding.gayathrijapamTextView.layout.getLineStart(51)
           endPos2 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos2 = binding.gayathrijapamTextView.layout.getLineStart(51)
           endPos2 = binding.gayathrijapamTextView.layout.getLineEnd(100)
         }
         //    pageTwoText = binding.gayathrijapamTextView.text.toString().substring(startPos2, endPos2)
         if (mTLineCount in 101..150) {
           startPos3 = binding.gayathrijapamTextView.layout.getLineStart(101)
           endPos3 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos3 = binding.gayathrijapamTextView.layout.getLineStart(101)
           endPos3 = binding.gayathrijapamTextView.layout.getLineEnd(150)
         }
         //    pageThreeText = binding.gayathrijapamTextView.text.toString().substring(startPos3, endPos3)
         if (mTLineCount in 151..200) {
           startPos4 = binding.gayathrijapamTextView.layout.getLineEnd(151)
           endPos4 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos4 = binding.gayathrijapamTextView.layout.getLineEnd(151)
           endPos4 = binding.gayathrijapamTextView.layout.getLineEnd(200)
         }
         //    pageFourText = binding.gayathrijapamTextView.text.toString().substring(startPos4, endPos4)
         if (mTLineCount in 201..250) {
           startPos5 = binding.gayathrijapamTextView.layout.getLineEnd(201)
           endPos5 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos5 = binding.gayathrijapamTextView.layout.getLineEnd(201)
           endPos5 = binding.gayathrijapamTextView.layout.getLineEnd(250)
         }
         //    pageFiveText = binding.gayathrijapamTextView.text.toString().substring(startPos5, endPos5)
         if (mTLineCount in 251..300) {
           startPos6 = binding.gayathrijapamTextView.layout.getLineStart(251)
           endPos6 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos6 = binding.gayathrijapamTextView.layout.getLineStart(251)
           endPos6 = binding.gayathrijapamTextView.layout.getLineEnd(300)
         }
         //    pageSixText = binding.gayathrijapamTextView.text.toString().substring(startPos6, endPos6)
       }
       if (totalpages == 7) {
         startPos1 = binding.gayathrijapamTextView.layout.getLineStart(0)
         if (mTLineCount >= 50) {
           endPos1 = binding.gayathrijapamTextView.layout.getLineEnd(50)
         } else {
           endPos1 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         }
         //    pageOneText = binding.gayathrijapamTextView.text.toString().substring(startPos1, endPos1)
         if (mTLineCount in 51..100) {
           startPos2 = binding.gayathrijapamTextView.layout.getLineStart(51)
           endPos2 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos2 = binding.gayathrijapamTextView.layout.getLineStart(51)
           endPos2 = binding.gayathrijapamTextView.layout.getLineEnd(100)
         }
         //    pageTwoText = binding.gayathrijapamTextView.text.toString().substring(startPos2, endPos2)
         if (mTLineCount in 101..150) {
           startPos3 = binding.gayathrijapamTextView.layout.getLineStart(101)
           endPos3 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos3 = binding.gayathrijapamTextView.layout.getLineStart(101)
           endPos3 = binding.gayathrijapamTextView.layout.getLineEnd(150)
         }
         //     pageThreeText = binding.gayathrijapamTextView.text.toString().substring(startPos3, endPos3)
         if (mTLineCount in 151..200) {
           startPos4 = binding.gayathrijapamTextView.layout.getLineEnd(151)
           endPos4 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos4 = binding.gayathrijapamTextView.layout.getLineEnd(151)
           endPos4 = binding.gayathrijapamTextView.layout.getLineEnd(200)
         }
         //    pageFourText = binding.gayathrijapamTextView.text.toString().substring(startPos4, endPos4)
         if (mTLineCount in 201..250) {
           startPos5 = binding.gayathrijapamTextView.layout.getLineEnd(201)
           endPos5 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos5 = binding.gayathrijapamTextView.layout.getLineEnd(201)
           endPos5 = binding.gayathrijapamTextView.layout.getLineEnd(250)
         }
         //    pageFiveText = binding.gayathrijapamTextView.text.toString().substring(startPos5, endPos5)
         if (mTLineCount in 251..300) {
           startPos6 = binding.gayathrijapamTextView.layout.getLineStart(251)
           endPos6 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos6 = binding.gayathrijapamTextView.layout.getLineStart(251)
           endPos6 = binding.gayathrijapamTextView.layout.getLineEnd(300)
         }
         //    pageSixText = binding.gayathrijapamTextView.text.toString().substring(startPos6, endPos6)
         if (mTLineCount in 301..350) {
           startPos7 = binding.gayathrijapamTextView.layout.getLineStart(301)
           endPos7 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos7 = binding.gayathrijapamTextView.layout.getLineStart(301)
           endPos7 = binding.gayathrijapamTextView.layout.getLineEnd(350)
         }
         //    pageSevenText = binding.gayathrijapamTextView.text.toString().substring(startPos7, endPos7)
       }
       if (totalpages == 8) {
         startPos1 = binding.gayathrijapamTextView.layout.getLineStart(0)
         if (mTLineCount >= 50) {
           endPos1 = binding.gayathrijapamTextView.layout.getLineEnd(50)
         } else {
           endPos1 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         }
         //    pageOneText = binding.gayathrijapamTextView.text.toString().substring(startPos1, endPos1)
         if (mTLineCount in 51..100) {
           startPos2 = binding.gayathrijapamTextView.layout.getLineStart(51)
           endPos2 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos2 = binding.gayathrijapamTextView.layout.getLineStart(51)
           endPos2 = binding.gayathrijapamTextView.layout.getLineEnd(100)
         }
         //    pageTwoText = binding.gayathrijapamTextView.text.toString().substring(startPos2, endPos2)
         if (mTLineCount in 101..150) {
           startPos3 = binding.gayathrijapamTextView.layout.getLineStart(101)
           endPos3 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos3 = binding.gayathrijapamTextView.layout.getLineStart(101)
           endPos3 = binding.gayathrijapamTextView.layout.getLineEnd(150)
         }
         //    pageThreeText = binding.gayathrijapamTextView.text.toString().substring(startPos3, endPos3)
         if (mTLineCount in 151..200) {
           startPos4 = binding.gayathrijapamTextView.layout.getLineEnd(151)
           endPos4 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos4 = binding.gayathrijapamTextView.layout.getLineEnd(151)
           endPos4 = binding.gayathrijapamTextView.layout.getLineEnd(200)
         }
         //    pageFourText = binding.gayathrijapamTextView.text.toString().substring(startPos4, endPos4)
         if (mTLineCount in 201..250) {
           startPos5 = binding.gayathrijapamTextView.layout.getLineEnd(201)
           endPos5 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos5 = binding.gayathrijapamTextView.layout.getLineEnd(201)
           endPos5 = binding.gayathrijapamTextView.layout.getLineEnd(250)
         }
         //    pageFiveText = binding.gayathrijapamTextView.text.toString().substring(startPos5, endPos5)
         if (mTLineCount in 251..300) {
           startPos6 = binding.gayathrijapamTextView.layout.getLineStart(251)
           endPos6 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos6 = binding.gayathrijapamTextView.layout.getLineStart(251)
           endPos6 = binding.gayathrijapamTextView.layout.getLineEnd(300)
         }
         //    pageSixText = binding.gayathrijapamTextView.text.toString().substring(startPos6, endPos6)
         if (mTLineCount in 301..350) {
           startPos7 = binding.gayathrijapamTextView.layout.getLineStart(301)
           endPos7 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos7 = binding.gayathrijapamTextView.layout.getLineStart(301)
           endPos7 = binding.gayathrijapamTextView.layout.getLineEnd(350)
         }
         println("startPos7 : $startPos7")
         println("endPos7 : $endPos7")
         //    pageSevenText = binding.gayathrijapamTextView.text.toString().substring(startPos7, endPos7)

         if (mTLineCount in 351..400) {
           startPos8 = binding.gayathrijapamTextView.layout.getLineStart(351)
           endPos8 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
           println("endPos8 : $endPos8")
         } else {
           startPos8 = binding.gayathrijapamTextView.layout.getLineStart(351)
           endPos8 = binding.gayathrijapamTextView.layout.getLineEnd(400)
           println("endPos82 : $endPos8")
         }
         println("startPos8 : $startPos8")
         println("endPos8F : $endPos8")
         //    pageEightText = binding.gayathrijapamTextView.text.toString().substring(startPos8, endPos8)
       }

       if (totalpages == 9) {
         startPos1 = binding.gayathrijapamTextView.layout.getLineStart(0)
         if (mTLineCount >= 50) {
           endPos1 = binding.gayathrijapamTextView.layout.getLineEnd(50)
         } else {
           endPos1 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         }
         //     pageOneText = binding.gayathrijapamTextView.text.toString().substring(startPos1, endPos1)
         if (mTLineCount in 51..100) {
           startPos2 = binding.gayathrijapamTextView.layout.getLineStart(51)
           endPos2 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos2 = binding.gayathrijapamTextView.layout.getLineStart(51)
           endPos2 = binding.gayathrijapamTextView.layout.getLineEnd(100)
         }
         //     pageTwoText = binding.gayathrijapamTextView.text.toString().substring(startPos2, endPos2)
         if (mTLineCount in 101..150) {
           startPos3 = binding.gayathrijapamTextView.layout.getLineStart(101)
           endPos3 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos3 = binding.gayathrijapamTextView.layout.getLineStart(101)
           endPos3 = binding.gayathrijapamTextView.layout.getLineEnd(150)
         }
         //    pageThreeText = binding.gayathrijapamTextView.text.toString().substring(startPos3, endPos3)
         if (mTLineCount in 151..200) {
           startPos4 = binding.gayathrijapamTextView.layout.getLineEnd(151)
           endPos4 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos4 = binding.gayathrijapamTextView.layout.getLineEnd(151)
           endPos4 = binding.gayathrijapamTextView.layout.getLineEnd(200)
         }
         //    pageFourText = binding.gayathrijapamTextView.text.toString().substring(startPos4, endPos4)
         if (mTLineCount in 201..250) {
           startPos5 = binding.gayathrijapamTextView.layout.getLineEnd(201)
           endPos5 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos5 = binding.gayathrijapamTextView.layout.getLineEnd(201)
           endPos5 = binding.gayathrijapamTextView.layout.getLineEnd(250)
         }
         //    pageFiveText = binding.gayathrijapamTextView.text.toString().substring(startPos5, endPos5)
         if (mTLineCount in 251..300) {
           startPos6 = binding.gayathrijapamTextView.layout.getLineStart(251)
           endPos6 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos6 = binding.gayathrijapamTextView.layout.getLineStart(251)
           endPos6 = binding.gayathrijapamTextView.layout.getLineEnd(300)
         }
         //    pageSixText = binding.gayathrijapamTextView.text.toString().substring(startPos6, endPos6)
         if (mTLineCount in 301..350) {
           startPos7 = binding.gayathrijapamTextView.layout.getLineStart(301)
           endPos7 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos7 = binding.gayathrijapamTextView.layout.getLineStart(301)
           endPos7 = binding.gayathrijapamTextView.layout.getLineEnd(350)
         }
         //     pageSevenText = binding.gayathrijapamTextView.text.toString().substring(startPos7, endPos7)
         if (mTLineCount in 351..400) {
           startPos8 = binding.gayathrijapamTextView.layout.getLineStart(351)
           endPos8 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos8 = binding.gayathrijapamTextView.layout.getLineStart(351)
           endPos8 = binding.gayathrijapamTextView.layout.getLineEnd(400)
         }
         //     pageEightText = binding.gayathrijapamTextView.text.toString().substring(startPos8, endPos8)
         if (mTLineCount in 401..450) {
           startPos9 = binding.gayathrijapamTextView.layout.getLineStart(401)
           endPos9 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos9 = binding.gayathrijapamTextView.layout.getLineStart(401)
           endPos9 = binding.gayathrijapamTextView.layout.getLineEnd(450)
         }
         //     pageNineText = binding.gayathrijapamTextView.text.toString().substring(startPos9, endPos9)
       }
       if (totalpages == 10) {
         startPos1 = binding.gayathrijapamTextView.layout.getLineStart(0)
         if (mTLineCount >= 50) {
           endPos1 = binding.gayathrijapamTextView.layout.getLineEnd(50)
         } else {
           endPos1 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         }
         //      pageOneText = binding.gayathrijapamTextView.text.toString().substring(startPos1, endPos1)
         if (mTLineCount in 51..100) {
           startPos2 = binding.gayathrijapamTextView.layout.getLineStart(51)
           endPos2 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos2 = binding.gayathrijapamTextView.layout.getLineStart(51)
           endPos2 = binding.gayathrijapamTextView.layout.getLineEnd(100)
         }
         //     pageTwoText = binding.gayathrijapamTextView.text.toString().substring(startPos2, endPos2)
         if (mTLineCount in 101..150) {
           startPos3 = binding.gayathrijapamTextView.layout.getLineStart(101)
           endPos3 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos3 = binding.gayathrijapamTextView.layout.getLineStart(101)
           endPos3 = binding.gayathrijapamTextView.layout.getLineEnd(150)
         }
         //    pageThreeText = binding.gayathrijapamTextView.text.toString().substring(startPos3, endPos3)
         if (mTLineCount in 151..200) {
           startPos4 = binding.gayathrijapamTextView.layout.getLineEnd(151)
           endPos4 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos4 = binding.gayathrijapamTextView.layout.getLineEnd(151)
           endPos4 = binding.gayathrijapamTextView.layout.getLineEnd(200)
         }
         //    pageFourText = binding.gayathrijapamTextView.text.toString().substring(startPos4, endPos4)
         if (mTLineCount in 201..250) {
           startPos5 = binding.gayathrijapamTextView.layout.getLineEnd(201)
           endPos5 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos5 = binding.gayathrijapamTextView.layout.getLineEnd(201)
           endPos5 = binding.gayathrijapamTextView.layout.getLineEnd(250)
         }
         //    pageFiveText = binding.gayathrijapamTextView.text.toString().substring(startPos5, endPos5)
         if (mTLineCount in 251..300) {
           startPos6 = binding.gayathrijapamTextView.layout.getLineStart(251)
           endPos6 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos6 = binding.gayathrijapamTextView.layout.getLineStart(251)
           endPos6 = binding.gayathrijapamTextView.layout.getLineEnd(300)
         }
         //    pageSixText = binding.gayathrijapamTextView.text.toString().substring(startPos6, endPos6)
         if (mTLineCount in 301..350) {
           startPos7 = binding.gayathrijapamTextView.layout.getLineStart(301)
           endPos7 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos7 = binding.gayathrijapamTextView.layout.getLineStart(301)
           endPos7 = binding.gayathrijapamTextView.layout.getLineEnd(350)
         }
         //    pageSevenText = binding.gayathrijapamTextView.text.toString().substring(startPos7, endPos7)
         if (mTLineCount in 351..400) {
           startPos8 = binding.gayathrijapamTextView.layout.getLineStart(351)
           endPos8 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos8 = binding.gayathrijapamTextView.layout.getLineStart(351)
           endPos8 = binding.gayathrijapamTextView.layout.getLineEnd(400)
         }
         //    pageEightText = binding.gayathrijapamTextView.text.toString().substring(startPos8, endPos8)
         if (mTLineCount in 401..450) {
           startPos9 = binding.gayathrijapamTextView.layout.getLineStart(401)
           endPos9 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos9 = binding.gayathrijapamTextView.layout.getLineStart(401)
           endPos9 = binding.gayathrijapamTextView.layout.getLineEnd(450)
         }
         //    pageNineText = binding.gayathrijapamTextView.text.toString().substring(startPos9, endPos9)
         if (mTLineCount  in 451..500) {
           startPos10 = binding.gayathrijapamTextView.layout.getLineStart(451)
           endPos10 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos10 = binding.gayathrijapamTextView.layout.getLineStart(451)
           endPos10 = binding.gayathrijapamTextView.layout.getLineEnd(500)
         }
         //    pageTenText = binding.gayathrijapamTextView.text.toString().substring(startPos10, endPos10)
       }
       if (totalpages == 11) {
         startPos1 = binding.gayathrijapamTextView.layout.getLineStart(0)
         if (mTLineCount  >= 50) {
           endPos1 = binding.gayathrijapamTextView.layout.getLineEnd(50)
         } else {
           endPos1 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         }
         //    pageOneText = binding.gayathrijapamTextView.text.toString().substring(startPos1, endPos1)
         if (mTLineCount  in 51..100) {
           startPos2 = binding.gayathrijapamTextView.layout.getLineStart(51)
           endPos2 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos2 = binding.gayathrijapamTextView.layout.getLineStart(51)
           endPos2 = binding.gayathrijapamTextView.layout.getLineEnd(100)
         }
         //    pageTwoText = binding.gayathrijapamTextView.text.toString().substring(startPos2, endPos2)
         if (mTLineCount  in 101..150) {
           startPos3 = binding.gayathrijapamTextView.layout.getLineStart(101)
           endPos3 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos3 = binding.gayathrijapamTextView.layout.getLineStart(101)
           endPos3 = binding.gayathrijapamTextView.layout.getLineEnd(150)
         }
         //    pageThreeText = binding.gayathrijapamTextView.text.toString().substring(startPos3, endPos3)
         if (mTLineCount  in 151..200) {
           startPos4 = binding.gayathrijapamTextView.layout.getLineEnd(151)
           endPos4 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos4 = binding.gayathrijapamTextView.layout.getLineEnd(151)
           endPos4 = binding.gayathrijapamTextView.layout.getLineEnd(200)
         }
         //    pageFourText = binding.gayathrijapamTextView.text.toString().substring(startPos4, endPos4)
         if (mTLineCount  in 201..250) {
           startPos5 = binding.gayathrijapamTextView.layout.getLineEnd(201)
           endPos5 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos5 = binding.gayathrijapamTextView.layout.getLineEnd(201)
           endPos5 = binding.gayathrijapamTextView.layout.getLineEnd(250)
         }
         //    pageFiveText = binding.gayathrijapamTextView.text.toString().substring(startPos5, endPos5)
         if (mTLineCount  in 251..300) {
           startPos6 = binding.gayathrijapamTextView.layout.getLineStart(251)
           endPos6 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos6 = binding.gayathrijapamTextView.layout.getLineStart(251)
           endPos6 = binding.gayathrijapamTextView.layout.getLineEnd(300)
         }
         //    pageSixText = binding.gayathrijapamTextView.text.toString().substring(startPos6, endPos6)
         if (mTLineCount  in 301..350) {
           startPos7 = binding.gayathrijapamTextView.layout.getLineStart(301)
           endPos7 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos7 = binding.gayathrijapamTextView.layout.getLineStart(301)
           endPos7 = binding.gayathrijapamTextView.layout.getLineEnd(350)
         }
         //    pageSevenText = binding.gayathrijapamTextView.text.toString().substring(startPos7, endPos7)
         if (mTLineCount in 351..400) {
           startPos8 = binding.gayathrijapamTextView.layout.getLineStart(351)
           endPos8 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos8 = binding.gayathrijapamTextView.layout.getLineStart(351)
           endPos8 = binding.gayathrijapamTextView.layout.getLineEnd(400)
         }
         //     pageEightText = binding.gayathrijapamTextView.text.toString().substring(startPos8, endPos8)
         if (mTLineCount  in 401..450) {
           startPos9 = binding.gayathrijapamTextView.layout.getLineStart(401)
           endPos9 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos9 = binding.gayathrijapamTextView.layout.getLineStart(401)
           endPos9 = binding.gayathrijapamTextView.layout.getLineEnd(450)
         }
         //    pageNineText = binding.gayathrijapamTextView.text.toString().substring(startPos9, endPos9)
         if (mTLineCount  in 451..500) {
           startPos10 = binding.gayathrijapamTextView.layout.getLineStart(451)
           endPos10 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos10 = binding.gayathrijapamTextView.layout.getLineStart(451)
           endPos10 = binding.gayathrijapamTextView.layout.getLineEnd(500)
         }
         //     pageTenText = binding.gayathrijapamTextView.text.toString().substring(startPos10, endPos10)
         if (mTLineCount  in 501..550) {
           startPos11 = binding.gayathrijapamTextView.layout.getLineStart(501)
           endPos11 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos11 = binding.gayathrijapamTextView.layout.getLineStart(501)
           endPos11 = binding.gayathrijapamTextView.layout.getLineEnd(550)
         }
         //    pageElevenText = binding.gayathrijapamTextView.text.toString().substring(startPos11, endPos11)
       }
       if (totalpages == 12) {
         startPos1 = binding.gayathrijapamTextView.layout.getLineStart(0)
         if (mTLineCount >= 50) {
           endPos1 = binding.gayathrijapamTextView.layout.getLineEnd(50)
         } else {
           endPos1 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         }
         //     pageOneText = binding.gayathrijapamTextView.text.toString().substring(startPos1, endPos1)
         if (mTLineCount  in 51..100) {
           startPos2 = binding.gayathrijapamTextView.layout.getLineStart(51)
           endPos2 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos2 = binding.gayathrijapamTextView.layout.getLineStart(51)
           endPos2 = binding.gayathrijapamTextView.layout.getLineEnd(100)
         }
         //     pageTwoText = binding.gayathrijapamTextView.text.toString().substring(startPos2, endPos2)
         if (mTLineCount  in 101..150) {
           startPos3 = binding.gayathrijapamTextView.layout.getLineStart(101)
           endPos3 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos3 = binding.gayathrijapamTextView.layout.getLineStart(101)
           endPos3 = binding.gayathrijapamTextView.layout.getLineEnd(150)
         }
         //     pageThreeText = binding.gayathrijapamTextView.text.toString().substring(startPos3, endPos3)
         if (mTLineCount  in 151..200) {
           startPos4 = binding.gayathrijapamTextView.layout.getLineEnd(151)
           endPos4 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos4 = binding.gayathrijapamTextView.layout.getLineEnd(151)
           endPos4 = binding.gayathrijapamTextView.layout.getLineEnd(200)
         }
         //    pageFourText = binding.gayathrijapamTextView.text.toString().substring(startPos4, endPos4)
         if (mTLineCount  in 201..250) {
           startPos5 = binding.gayathrijapamTextView.layout.getLineEnd(201)
           endPos5 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos5 = binding.gayathrijapamTextView.layout.getLineEnd(201)
           endPos5 = binding.gayathrijapamTextView.layout.getLineEnd(250)
         }
         //    pageFiveText = binding.gayathrijapamTextView.text.toString().substring(startPos5, endPos5)
         if (mTLineCount  in 251..300) {
           startPos6 = binding.gayathrijapamTextView.layout.getLineStart(251)
           endPos6 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos6 = binding.gayathrijapamTextView.layout.getLineStart(251)
           endPos6 = binding.gayathrijapamTextView.layout.getLineEnd(300)
         }
         //    pageSixText = binding.gayathrijapamTextView.text.toString().substring(startPos6, endPos6)
         if (mTLineCount  in 301..350) {
           startPos7 = binding.gayathrijapamTextView.layout.getLineStart(301)
           endPos7 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos7 = binding.gayathrijapamTextView.layout.getLineStart(301)
           endPos7 = binding.gayathrijapamTextView.layout.getLineEnd(350)
         }
         //    pageSevenText = binding.gayathrijapamTextView.text.toString().substring(startPos7, endPos7)
         if (mTLineCount in 351..400) {
           startPos8 = binding.gayathrijapamTextView.layout.getLineStart(351)
           endPos8 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos8 = binding.gayathrijapamTextView.layout.getLineStart(351)
           endPos8 = binding.gayathrijapamTextView.layout.getLineEnd(400)
         }
         //    pageEightText = binding.gayathrijapamTextView.text.toString().substring(startPos8, endPos8)
         if (mTLineCount  in 401..450) {
           startPos9 = binding.gayathrijapamTextView.layout.getLineStart(401)
           endPos9 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos9 = binding.gayathrijapamTextView.layout.getLineStart(401)
           endPos9 = binding.gayathrijapamTextView.layout.getLineEnd(450)
         }
         //    pageNineText = binding.gayathrijapamTextView.text.toString().substring(startPos9, endPos9)
         if (mTLineCount  in 451..500) {
           startPos10 = binding.gayathrijapamTextView.layout.getLineStart(451)
           endPos10 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos10 = binding.gayathrijapamTextView.layout.getLineStart(451)
           endPos10 = binding.gayathrijapamTextView.layout.getLineEnd(500)
         }
         //    pageTenText = binding.gayathrijapamTextView.text.toString().substring(startPos10, endPos10)
         if (mTLineCount  in 501..550) {
           startPos11 = binding.gayathrijapamTextView.layout.getLineStart(501)
           endPos11 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos11 = binding.gayathrijapamTextView.layout.getLineStart(501)
           endPos11 = binding.gayathrijapamTextView.layout.getLineEnd(550)
         }
         //    pageElevenText = binding.gayathrijapamTextView.text.toString().substring(startPos11, endPos11)
         if (mTLineCount  in 551..600) {
           startPos12 = binding.gayathrijapamTextView.layout.getLineStart(551)
           endPos12 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos12 = binding.gayathrijapamTextView.layout.getLineStart(551)
           endPos12 = binding.gayathrijapamTextView.layout.getLineEnd(600)
         }
         //    pageTwelveText = binding.gayathrijapamTextView.text.toString().substring(startPos12, endPos12)
       }
       if (totalpages == 13) {
         startPos1 = binding.gayathrijapamTextView.layout.getLineStart(0)
         if (mTLineCount >= 50) {
           endPos1 = binding.gayathrijapamTextView.layout.getLineEnd(50)
         } else {
           endPos1 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         }
         //     pageOneText = binding.gayathrijapamTextView.text.toString().substring(startPos1, endPos1)
         if (mTLineCount  in 51..100) {
           startPos2 = binding.gayathrijapamTextView.layout.getLineStart(51)
           endPos2 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos2 = binding.gayathrijapamTextView.layout.getLineStart(51)
           endPos2 = binding.gayathrijapamTextView.layout.getLineEnd(100)
         }
         //    pageTwoText = binding.gayathrijapamTextView.text.toString().substring(startPos2, endPos2)
         if (mTLineCount  in 101..150) {
           startPos3 = binding.gayathrijapamTextView.layout.getLineStart(101)
           endPos3 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos3 = binding.gayathrijapamTextView.layout.getLineStart(101)
           endPos3 = binding.gayathrijapamTextView.layout.getLineEnd(150)
         }
         //    pageThreeText = binding.gayathrijapamTextView.text.toString().substring(startPos3, endPos3)
         if (mTLineCount  in 151..200) {
           startPos4 = binding.gayathrijapamTextView.layout.getLineEnd(151)
           endPos4 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos4 = binding.gayathrijapamTextView.layout.getLineEnd(151)
           endPos4 = binding.gayathrijapamTextView.layout.getLineEnd(200)
         }
         //    pageFourText = binding.gayathrijapamTextView.text.toString().substring(startPos4, endPos4)
         if (mTLineCount  in 201..250) {
           startPos5 = binding.gayathrijapamTextView.layout.getLineEnd(201)
           endPos5 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos5 = binding.gayathrijapamTextView.layout.getLineEnd(201)
           endPos5 = binding.gayathrijapamTextView.layout.getLineEnd(250)
         }
         //    pageFiveText = binding.gayathrijapamTextView.text.toString().substring(startPos5, endPos5)
         if (mTLineCount  in 251..300) {
           startPos6 = binding.gayathrijapamTextView.layout.getLineStart(251)
           endPos6 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos6 = binding.gayathrijapamTextView.layout.getLineStart(251)
           endPos6 = binding.gayathrijapamTextView.layout.getLineEnd(300)
         }
         //    pageSixText = binding.gayathrijapamTextView.text.toString().substring(startPos6, endPos6)
         if (mTLineCount  in 301..350) {
           startPos7 = binding.gayathrijapamTextView.layout.getLineStart(301)
           endPos7 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos7 = binding.gayathrijapamTextView.layout.getLineStart(301)
           endPos7 = binding.gayathrijapamTextView.layout.getLineEnd(350)
         }
         //    pageSevenText = binding.gayathrijapamTextView.text.toString().substring(startPos7, endPos7)
         if (mTLineCount in 351..400) {
           startPos8 = binding.gayathrijapamTextView.layout.getLineStart(351)
           endPos8 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos8 = binding.gayathrijapamTextView.layout.getLineStart(351)
           endPos8 = binding.gayathrijapamTextView.layout.getLineEnd(400)
         }
         //    pageEightText = binding.gayathrijapamTextView.text.toString().substring(startPos8, endPos8)
         if (mTLineCount  in 401..450) {
           startPos9 = binding.gayathrijapamTextView.layout.getLineStart(401)
           endPos9 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos9 = binding.gayathrijapamTextView.layout.getLineStart(401)
           endPos9 = binding.gayathrijapamTextView.layout.getLineEnd(450)
         }
         //    pageNineText = binding.gayathrijapamTextView.text.toString().substring(startPos9, endPos9)
         if (mTLineCount in 451..500) {
           startPos10 = binding.gayathrijapamTextView.layout.getLineStart(451)
           endPos10 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos10 = binding.gayathrijapamTextView.layout.getLineStart(451)
           endPos10 = binding.gayathrijapamTextView.layout.getLineEnd(500)
         }
         //    pageTenText = binding.gayathrijapamTextView.text.toString().substring(startPos10, endPos10)
         if (mTLineCount in 501..550) {
           startPos11 = binding.gayathrijapamTextView.layout.getLineStart(501)
           endPos11 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos11 = binding.gayathrijapamTextView.layout.getLineStart(501)
           endPos11 = binding.gayathrijapamTextView.layout.getLineEnd(550)
         }
         //    pageElevenText = binding.gayathrijapamTextView.text.toString().substring(startPos11, endPos11)
         if (mTLineCount in 551..600) {
           startPos12 = binding.gayathrijapamTextView.layout.getLineStart(551)
           endPos12 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos12 = binding.gayathrijapamTextView.layout.getLineStart(551)
           endPos12 = binding.gayathrijapamTextView.layout.getLineEnd(600)
         }
         //    pageTwelveText = binding.gayathrijapamTextView.text.toString().substring(startPos12, endPos12)
         if (mTLineCount in 601..650) {
           startPos13 = binding.gayathrijapamTextView.layout.getLineStart(601)
           endPos13 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos13 = binding.gayathrijapamTextView.layout.getLineStart(601)
           endPos13 = binding.gayathrijapamTextView.layout.getLineEnd(650)
         }
         //    pageThirteenText = binding.gayathrijapamTextView.text.toString().substring(startPos13, endPos13)
       }
       if (totalpages == 14) {
         startPos1 = binding.gayathrijapamTextView.layout.getLineStart(0)
         if (mTLineCount >= 50) {
           endPos1 = binding.gayathrijapamTextView.layout.getLineEnd(50)
         } else {
           endPos1 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         }
         //    pageOneText = binding.gayathrijapamTextView.text.toString().substring(startPos1, endPos1)
         if (mTLineCount in 51..100) {
           startPos2 = binding.gayathrijapamTextView.layout.getLineStart(51)
           endPos2 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos2 = binding.gayathrijapamTextView.layout.getLineStart(51)
           endPos2 = binding.gayathrijapamTextView.layout.getLineEnd(100)
         }
         //    pageTwoText = binding.gayathrijapamTextView.text.toString().substring(startPos2, endPos2)
         if (mTLineCount in 101..150) {
           startPos3 = binding.gayathrijapamTextView.layout.getLineStart(101)
           endPos3 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos3 = binding.gayathrijapamTextView.layout.getLineStart(101)
           endPos3 = binding.gayathrijapamTextView.layout.getLineEnd(150)
         }
         //    pageThreeText = binding.gayathrijapamTextView.text.toString().substring(startPos3, endPos3)
         if (mTLineCount in 151..200) {
           startPos4 = binding.gayathrijapamTextView.layout.getLineEnd(151)
           endPos4 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos4 = binding.gayathrijapamTextView.layout.getLineEnd(151)
           endPos4 = binding.gayathrijapamTextView.layout.getLineEnd(200)
         }
         //    pageFourText = binding.gayathrijapamTextView.text.toString().substring(startPos4, endPos4)
         if (mTLineCount in 201..250) {
           startPos5 = binding.gayathrijapamTextView.layout.getLineEnd(201)
           endPos5 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos5 = binding.gayathrijapamTextView.layout.getLineEnd(201)
           endPos5 = binding.gayathrijapamTextView.layout.getLineEnd(250)
         }
         //    pageFiveText = binding.gayathrijapamTextView.text.toString().substring(startPos5, endPos5)
         if (mTLineCount in 251..300) {
           startPos6 = binding.gayathrijapamTextView.layout.getLineStart(251)
           endPos6 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos6 = binding.gayathrijapamTextView.layout.getLineStart(251)
           endPos6 = binding.gayathrijapamTextView.layout.getLineEnd(300)
         }
         //    pageSixText = binding.gayathrijapamTextView.text.toString().substring(startPos6, endPos6)
         if (mTLineCount in 301..350) {
           startPos7 = binding.gayathrijapamTextView.layout.getLineStart(301)
           endPos7 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos7 = binding.gayathrijapamTextView.layout.getLineStart(301)
           endPos7 = binding.gayathrijapamTextView.layout.getLineEnd(350)
         }
         //    pageSevenText = binding.gayathrijapamTextView.text.toString().substring(startPos7, endPos7)
         if (mTLineCount in 351..400) {
           startPos8 = binding.gayathrijapamTextView.layout.getLineStart(351)
           endPos8 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos8 = binding.gayathrijapamTextView.layout.getLineStart(351)
           endPos8 = binding.gayathrijapamTextView.layout.getLineEnd(400)
         }
         //    pageEightText = binding.gayathrijapamTextView.text.toString().substring(startPos8, endPos8)
         if (mTLineCount in 401..450) {
           startPos9 = binding.gayathrijapamTextView.layout.getLineStart(401)
           endPos9 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos9 = binding.gayathrijapamTextView.layout.getLineStart(401)
           endPos9 = binding.gayathrijapamTextView.layout.getLineEnd(450)
         }
         //    pageNineText = binding.gayathrijapamTextView.text.toString().substring(startPos9, endPos9)
         if (mTLineCount in 451..500) {
           startPos10 = binding.gayathrijapamTextView.layout.getLineStart(451)
           endPos10 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos10 = binding.gayathrijapamTextView.layout.getLineStart(451)
           endPos10 = binding.gayathrijapamTextView.layout.getLineEnd(500)
         }
         //    pageTenText = binding.gayathrijapamTextView.text.toString().substring(startPos10, endPos10)
         if (mTLineCount in 501..550) {
           startPos11 = binding.gayathrijapamTextView.layout.getLineStart(501)
           endPos11 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos11 = binding.gayathrijapamTextView.layout.getLineStart(501)
           endPos11 = binding.gayathrijapamTextView.layout.getLineEnd(550)
         }
         //    pageElevenText = binding.gayathrijapamTextView.text.toString().substring(startPos11, endPos11)
         if (mTLineCount in 551..600) {
           startPos12 = binding.gayathrijapamTextView.layout.getLineStart(551)
           endPos12 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos12 = binding.gayathrijapamTextView.layout.getLineStart(551)
           endPos12 = binding.gayathrijapamTextView.layout.getLineEnd(600)
         }
         //    pageTwelveText = binding.gayathrijapamTextView.text.toString().substring(startPos12, endPos12)
         if (mTLineCount in 601..650) {
           startPos13 = binding.gayathrijapamTextView.layout.getLineStart(601)
           endPos13 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos13 = binding.gayathrijapamTextView.layout.getLineStart(601)
           endPos13 = binding.gayathrijapamTextView.layout.getLineEnd(650)
         }
         //    pageThirteenText = binding.gayathrijapamTextView.text.toString().substring(startPos13, endPos13)
         if (mTLineCount in 651..700) {
           startPos14 = binding.gayathrijapamTextView.layout.getLineStart(651)
           endPos14 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos14 = binding.gayathrijapamTextView.layout.getLineStart(651)
           endPos14 = binding.gayathrijapamTextView.layout.getLineEnd(700)
         }
         //    pageFourteenText = binding.gayathrijapamTextView.text.toString().substring(startPos14, endPos14)
       }
       if (totalpages == 15) {
         startPos1 = binding.gayathrijapamTextView.layout.getLineStart(0)
         if (mTLineCount >= 50) {
           endPos1 = binding.gayathrijapamTextView.layout.getLineEnd(50)
         } else {
           endPos1 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         }
         //    pageOneText = binding.gayathrijapamTextView.text.toString().substring(startPos1, endPos1)
         if (mTLineCount in 51..100) {
           startPos2 = binding.gayathrijapamTextView.layout.getLineStart(51)
           endPos2 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos2 = binding.gayathrijapamTextView.layout.getLineStart(51)
           endPos2 = binding.gayathrijapamTextView.layout.getLineEnd(100)
         }
         //    pageTwoText = binding.gayathrijapamTextView.text.toString().substring(startPos2, endPos2)
         if (mTLineCount in 101..150) {
           startPos3 = binding.gayathrijapamTextView.layout.getLineStart(101)
           endPos3 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos3 = binding.gayathrijapamTextView.layout.getLineStart(101)
           endPos3 = binding.gayathrijapamTextView.layout.getLineEnd(150)
         }
         //    pageThreeText = binding.gayathrijapamTextView.text.toString().substring(startPos3, endPos3)
         if (mTLineCount in 151..200) {
           startPos4 = binding.gayathrijapamTextView.layout.getLineEnd(151)
           endPos4 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos4 = binding.gayathrijapamTextView.layout.getLineEnd(151)
           endPos4 = binding.gayathrijapamTextView.layout.getLineEnd(200)
         }
         //     pageFourText = binding.gayathrijapamTextView.text.toString().substring(startPos4, endPos4)
         if (mTLineCount in 201..250) {
           startPos5 = binding.gayathrijapamTextView.layout.getLineEnd(201)
           endPos5 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos5 = binding.gayathrijapamTextView.layout.getLineEnd(201)
           endPos5 = binding.gayathrijapamTextView.layout.getLineEnd(250)
         }
         //    pageFiveText = binding.gayathrijapamTextView.text.toString().substring(startPos5, endPos5)
         if (mTLineCount in 251..300) {
           startPos6 = binding.gayathrijapamTextView.layout.getLineStart(251)
           endPos6 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos6 = binding.gayathrijapamTextView.layout.getLineStart(251)
           endPos6 = binding.gayathrijapamTextView.layout.getLineEnd(300)
         }
         //    pageSixText = binding.gayathrijapamTextView.text.toString().substring(startPos6, endPos6)
         if (mTLineCount in 301..350) {
           startPos7 = binding.gayathrijapamTextView.layout.getLineStart(301)
           endPos7 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos7 = binding.gayathrijapamTextView.layout.getLineStart(301)
           endPos7 = binding.gayathrijapamTextView.layout.getLineEnd(350)
         }
         //     pageSevenText = binding.gayathrijapamTextView.text.toString().substring(startPos7, endPos7)
         if (mTLineCount in 351..400) {
           startPos8 = binding.gayathrijapamTextView.layout.getLineStart(351)
           endPos8 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos8 = binding.gayathrijapamTextView.layout.getLineStart(351)
           endPos8 = binding.gayathrijapamTextView.layout.getLineEnd(400)
         }
         //    pageEightText = binding.gayathrijapamTextView.text.toString().substring(startPos8, endPos8)
         if (mTLineCount in 401..450) {
           startPos9 = binding.gayathrijapamTextView.layout.getLineStart(401)
           endPos9 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos9 = binding.gayathrijapamTextView.layout.getLineStart(401)
           endPos9 = binding.gayathrijapamTextView.layout.getLineEnd(450)
         }
         //    pageNineText = binding.gayathrijapamTextView.text.toString().substring(startPos9, endPos9)
         if (mTLineCount in 451..500) {
           startPos10 = binding.gayathrijapamTextView.layout.getLineStart(451)
           endPos10 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos10 = binding.gayathrijapamTextView.layout.getLineStart(451)
           endPos10 = binding.gayathrijapamTextView.layout.getLineEnd(500)
         }
         //    pageTenText = binding.gayathrijapamTextView.text.toString().substring(startPos10, endPos10)
         if (mTLineCount in 501..550) {
           startPos11 = binding.gayathrijapamTextView.layout.getLineStart(501)
           endPos11 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos11 = binding.gayathrijapamTextView.layout.getLineStart(501)
           endPos11 = binding.gayathrijapamTextView.layout.getLineEnd(550)
         }
         //    pageElevenText = binding.gayathrijapamTextView.text.toString().substring(startPos11, endPos11)
         if (mTLineCount in 551..600) {
           startPos12 = binding.gayathrijapamTextView.layout.getLineStart(551)
           endPos12 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos12 = binding.gayathrijapamTextView.layout.getLineStart(551)
           endPos12 = binding.gayathrijapamTextView.layout.getLineEnd(600)
         }
         //    pageTwelveText = binding.gayathrijapamTextView.text.toString().substring(startPos12, endPos12)
         if (mTLineCount in 601..650) {
           startPos13 = binding.gayathrijapamTextView.layout.getLineStart(601)
           endPos13 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos13 = binding.gayathrijapamTextView.layout.getLineStart(601)
           endPos13 = binding.gayathrijapamTextView.layout.getLineEnd(650)
         }
         //    pageThirteenText = binding.gayathrijapamTextView.text.toString().substring(startPos13, endPos13)
         if (mTLineCount in 651..700) {
           startPos14 = binding.gayathrijapamTextView.layout.getLineStart(651)
           endPos14 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos14 = binding.gayathrijapamTextView.layout.getLineStart(651)
           endPos14 = binding.gayathrijapamTextView.layout.getLineEnd(700)
         }
         //    pageFourteenText = binding.gayathrijapamTextView.text.toString().substring(startPos14, endPos14)
         if (mTLineCount in 701..750) {
           startPos15 = binding.gayathrijapamTextView.layout.getLineStart(701)
           endPos15 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos15 = binding.gayathrijapamTextView.layout.getLineStart(701)
           endPos15 = binding.gayathrijapamTextView.layout.getLineEnd(750)
         }
         //    pageFifteenText = binding.gayathrijapamTextView.text.toString().substring(startPos15, endPos15)
       }
       if (totalpages == 16) {
         startPos1 = binding.gayathrijapamTextView.layout.getLineStart(0)
         if (mTLineCount >= 50) {
           endPos1 = binding.gayathrijapamTextView.layout.getLineEnd(50)
         } else {
           endPos1 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         }
         //   pageOneText = binding.gayathrijapamTextView.text.toString().substring(startPos1, endPos1)
         if (mTLineCount in 51..100) {
           startPos2 = binding.gayathrijapamTextView.layout.getLineStart(51)
           endPos2 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos2 = binding.gayathrijapamTextView.layout.getLineStart(51)
           endPos2 = binding.gayathrijapamTextView.layout.getLineEnd(100)
         }
         //    pageTwoText = binding.gayathrijapamTextView.text.toString().substring(startPos2, endPos2)
         if (mTLineCount in 101..150) {
           startPos3 = binding.gayathrijapamTextView.layout.getLineStart(101)
           endPos3 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos3 = binding.gayathrijapamTextView.layout.getLineStart(101)
           endPos3 = binding.gayathrijapamTextView.layout.getLineEnd(150)
         }
         //    pageThreeText = binding.gayathrijapamTextView.text.toString().substring(startPos3, endPos3)
         if (mTLineCount in 151..200) {
           startPos4 = binding.gayathrijapamTextView.layout.getLineEnd(151)
           endPos4 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos4 = binding.gayathrijapamTextView.layout.getLineEnd(151)
           endPos4 = binding.gayathrijapamTextView.layout.getLineEnd(200)
         }
         //    pageFourText = binding.gayathrijapamTextView.text.toString().substring(startPos4, endPos4)
         if (mTLineCount in 201..250) {
           startPos5 = binding.gayathrijapamTextView.layout.getLineEnd(201)
           endPos5 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos5 = binding.gayathrijapamTextView.layout.getLineEnd(201)
           endPos5 = binding.gayathrijapamTextView.layout.getLineEnd(250)
         }
         //    pageFiveText = binding.gayathrijapamTextView.text.toString().substring(startPos5, endPos5)
         if (mTLineCount in 251..300) {
           startPos6 = binding.gayathrijapamTextView.layout.getLineStart(251)
           endPos6 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos6 = binding.gayathrijapamTextView.layout.getLineStart(251)
           endPos6 = binding.gayathrijapamTextView.layout.getLineEnd(300)
         }
         //    pageSixText = binding.gayathrijapamTextView.text.toString().substring(startPos6, endPos6)
         if (mTLineCount in 301..350) {
           startPos7 = binding.gayathrijapamTextView.layout.getLineStart(301)
           endPos7 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos7 = binding.gayathrijapamTextView.layout.getLineStart(301)
           endPos7 = binding.gayathrijapamTextView.layout.getLineEnd(350)
         }
         //    pageSevenText = binding.gayathrijapamTextView.text.toString().substring(startPos7, endPos7)
         if (mTLineCount in 351..400) {
           startPos8 = binding.gayathrijapamTextView.layout.getLineStart(351)
           endPos8 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos8 = binding.gayathrijapamTextView.layout.getLineStart(351)
           endPos8 = binding.gayathrijapamTextView.layout.getLineEnd(400)
         }
         //    pageEightText = binding.gayathrijapamTextView.text.toString().substring(startPos8, endPos8)
         if (mTLineCount in 401..450) {
           startPos9 = binding.gayathrijapamTextView.layout.getLineStart(401)
           endPos9 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos9 = binding.gayathrijapamTextView.layout.getLineStart(401)
           endPos9 = binding.gayathrijapamTextView.layout.getLineEnd(450)
         }
         //    pageNineText = binding.gayathrijapamTextView.text.toString().substring(startPos9, endPos9)
         if (mTLineCount in 451..500) {
           startPos10 = binding.gayathrijapamTextView.layout.getLineStart(451)
           endPos10 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos10 = binding.gayathrijapamTextView.layout.getLineStart(451)
           endPos10 = binding.gayathrijapamTextView.layout.getLineEnd(500)
         }
         //    pageTenText = binding.gayathrijapamTextView.text.toString().substring(startPos10, endPos10)
         if (mTLineCount in 501..550) {
           startPos11 = binding.gayathrijapamTextView.layout.getLineStart(501)
           endPos11 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos11 = binding.gayathrijapamTextView.layout.getLineStart(501)
           endPos11 = binding.gayathrijapamTextView.layout.getLineEnd(550)
         }
         //    pageElevenText = binding.gayathrijapamTextView.text.toString().substring(startPos11, endPos11)
         if (mTLineCount in 551..600) {
           startPos12 = binding.gayathrijapamTextView.layout.getLineStart(551)
           endPos12 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos12 = binding.gayathrijapamTextView.layout.getLineStart(551)
           endPos12 = binding.gayathrijapamTextView.layout.getLineEnd(600)
         }
         //    pageTwelveText = binding.gayathrijapamTextView.text.toString().substring(startPos12, endPos12)
         if (mTLineCount in 601..650) {
           startPos13 = binding.gayathrijapamTextView.layout.getLineStart(601)
           endPos13 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos13 = binding.gayathrijapamTextView.layout.getLineStart(601)
           endPos13 = binding.gayathrijapamTextView.layout.getLineEnd(650)
         }
         //    pageThirteenText = binding.gayathrijapamTextView.text.toString().substring(startPos13, endPos13)
         if (mTLineCount in 651..700) {
           startPos14 = binding.gayathrijapamTextView.layout.getLineStart(651)
           endPos14 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos14 = binding.gayathrijapamTextView.layout.getLineStart(651)
           endPos14 = binding.gayathrijapamTextView.layout.getLineEnd(700)
         }
         //    pageFourteenText = binding.gayathrijapamTextView.text.toString().substring(startPos14, endPos14)
         if (mTLineCount in 701..750) {
           startPos15 = binding.gayathrijapamTextView.layout.getLineStart(701)
           endPos15 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos15 = binding.gayathrijapamTextView.layout.getLineStart(701)
           endPos15 = binding.gayathrijapamTextView.layout.getLineEnd(750)
         }
         //    pageFifteenText = binding.gayathrijapamTextView.text.toString().substring(startPos15, endPos15)
         if (mTLineCount in 751..800) {
           startPos16 = binding.gayathrijapamTextView.layout.getLineStart(751)
           endPos16 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos16 = binding.gayathrijapamTextView.layout.getLineStart(751)
           endPos16 = binding.gayathrijapamTextView.layout.getLineEnd(800)
         }
         //    pageSixteenText = binding.gayathrijapamTextView.text.toString().substring(startPos16, endPos16)
       }
       if (totalpages == 17) {
         startPos1 = binding.gayathrijapamTextView.layout.getLineStart(0)
         if (mTLineCount >= 50) {
           endPos1 = binding.gayathrijapamTextView.layout.getLineEnd(50)
         } else {
           endPos1 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         }
         //    pageOneText = binding.gayathrijapamTextView.text.toString().substring(startPos1, endPos1)
         if (mTLineCount in 51..100) {
           startPos2 = binding.gayathrijapamTextView.layout.getLineStart(51)
           endPos2 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos2 = binding.gayathrijapamTextView.layout.getLineStart(51)
           endPos2 = binding.gayathrijapamTextView.layout.getLineEnd(100)
         }
         //    pageTwoText = binding.gayathrijapamTextView.text.toString().substring(startPos2, endPos2)
         if (mTLineCount in 101..150) {
           startPos3 = binding.gayathrijapamTextView.layout.getLineStart(101)
           endPos3 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos3 = binding.gayathrijapamTextView.layout.getLineStart(101)
           endPos3 = binding.gayathrijapamTextView.layout.getLineEnd(150)
         }
         //    pageThreeText = binding.gayathrijapamTextView.text.toString().substring(startPos3, endPos3)
         if (mTLineCount in 151..200) {
           startPos4 = binding.gayathrijapamTextView.layout.getLineEnd(151)
           endPos4 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos4 = binding.gayathrijapamTextView.layout.getLineEnd(151)
           endPos4 = binding.gayathrijapamTextView.layout.getLineEnd(200)
         }
         //    pageFourText = binding.gayathrijapamTextView.text.toString().substring(startPos4, endPos4)
         if (mTLineCount in 201..250) {
           startPos5 = binding.gayathrijapamTextView.layout.getLineEnd(201)
           endPos5 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos5 = binding.gayathrijapamTextView.layout.getLineEnd(201)
           endPos5 = binding.gayathrijapamTextView.layout.getLineEnd(250)
         }
         //    pageFiveText = binding.gayathrijapamTextView.text.toString().substring(startPos5, endPos5)
         if (mTLineCount in 251..300) {
           startPos6 = binding.gayathrijapamTextView.layout.getLineStart(251)
           endPos6 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos6 = binding.gayathrijapamTextView.layout.getLineStart(251)
           endPos6 = binding.gayathrijapamTextView.layout.getLineEnd(300)
         }
         //    pageSixText = binding.gayathrijapamTextView.text.toString().substring(startPos6, endPos6)
         if (mTLineCount in 301..350) {
           startPos7 = binding.gayathrijapamTextView.layout.getLineStart(301)
           endPos7 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos7 = binding.gayathrijapamTextView.layout.getLineStart(301)
           endPos7 = binding.gayathrijapamTextView.layout.getLineEnd(350)
         }
         //    pageSevenText = binding.gayathrijapamTextView.text.toString().substring(startPos7, endPos7)
         if (mTLineCount in 351..400) {
           startPos8 = binding.gayathrijapamTextView.layout.getLineStart(351)
           endPos8 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos8 = binding.gayathrijapamTextView.layout.getLineStart(351)
           endPos8 = binding.gayathrijapamTextView.layout.getLineEnd(400)
         }
         //    pageEightText = binding.gayathrijapamTextView.text.toString().substring(startPos8, endPos8)
         if (mTLineCount in 401..450) {
           startPos9 = binding.gayathrijapamTextView.layout.getLineStart(401)
           endPos9 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos9 = binding.gayathrijapamTextView.layout.getLineStart(401)
           endPos9 = binding.gayathrijapamTextView.layout.getLineEnd(450)
         }
         //    pageNineText = binding.gayathrijapamTextView.text.toString().substring(startPos9, endPos9)
         if (mTLineCount in 451..500) {
           startPos10 = binding.gayathrijapamTextView.layout.getLineStart(451)
           endPos10 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos10 = binding.gayathrijapamTextView.layout.getLineStart(451)
           endPos10 = binding.gayathrijapamTextView.layout.getLineEnd(500)
         }
         //    pageTenText = binding.gayathrijapamTextView.text.toString().substring(startPos10, endPos10)
         if (mTLineCount in 501..550) {
           startPos11 = binding.gayathrijapamTextView.layout.getLineStart(501)
           endPos11 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos11 = binding.gayathrijapamTextView.layout.getLineStart(501)
           endPos11 = binding.gayathrijapamTextView.layout.getLineEnd(550)
         }
         //    pageElevenText = binding.gayathrijapamTextView.text.toString().substring(startPos11, endPos11)
         if (mTLineCount in 551..600) {
           startPos12 = binding.gayathrijapamTextView.layout.getLineStart(551)
           endPos12 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos12 = binding.gayathrijapamTextView.layout.getLineStart(551)
           endPos12 = binding.gayathrijapamTextView.layout.getLineEnd(600)
         }
         //    pageTwelveText = binding.gayathrijapamTextView.text.toString().substring(startPos12, endPos12)
         if (mTLineCount in 601..650) {
           startPos13 = binding.gayathrijapamTextView.layout.getLineStart(601)
           endPos13 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos13 = binding.gayathrijapamTextView.layout.getLineStart(601)
           endPos13 = binding.gayathrijapamTextView.layout.getLineEnd(650)
         }
         //    pageThirteenText = binding.gayathrijapamTextView.text.toString().substring(startPos13, endPos13)
         if (mTLineCount in 651..700) {
           startPos14 = binding.gayathrijapamTextView.layout.getLineStart(651)
           endPos14 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos14 = binding.gayathrijapamTextView.layout.getLineStart(651)
           endPos14 = binding.gayathrijapamTextView.layout.getLineEnd(700)
         }
         //    pageFourteenText = binding.gayathrijapamTextView.text.toString().substring(startPos14, endPos14)
         if (mTLineCount in 701..750) {
           startPos15 = binding.gayathrijapamTextView.layout.getLineStart(701)
           endPos15 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos15 = binding.gayathrijapamTextView.layout.getLineStart(701)
           endPos15 = binding.gayathrijapamTextView.layout.getLineEnd(750)
         }
         //     pageFifteenText = binding.gayathrijapamTextView.text.toString().substring(startPos15, endPos15)
         if (mTLineCount in 751..800) {
           startPos16 = binding.gayathrijapamTextView.layout.getLineStart(751)
           endPos16 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos16 = binding.gayathrijapamTextView.layout.getLineStart(751)
           endPos16 = binding.gayathrijapamTextView.layout.getLineEnd(800)
         }
         //    pageSixteenText = binding.gayathrijapamTextView.text.toString().substring(startPos16, endPos16)
         if (mTLineCount in 801..850) {
           startPos17 = binding.gayathrijapamTextView.layout.getLineStart(801)
           endPos17 = binding.gayathrijapamTextView.layout.getLineEnd(mTLineCount-1)
         } else {
           startPos17 = binding.gayathrijapamTextView.layout.getLineStart(801)
           endPos17 = binding.gayathrijapamTextView.layout.getLineEnd(850)
         }
         //    pageSeventeenText = binding.gayathrijapamTextView.text.toString().substring(startPos17, endPos17)
      */
       }
       val printManager = this.getSystemService(PRINT_SERVICE) as PrintManager
       val jobName = this.getString(R.string.app_name) + "-$heading"
       println("jobName : $jobName")
       printManager.print(jobName, MyPrintDocumentAdapter(this), null)
     }
  }


}
