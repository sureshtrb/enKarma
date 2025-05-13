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
      val comSt4 = applySpans("\n(வலது கட்டை விரலால் வாயை துடைத்துக் கொள்ளவும்)\n(விரல்களால் அங்கங்களை தொடவும்)\n(நடு+மோதிர விரல்)-வலது கன்னம்", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt3 = applySpans("- கேசவா", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt5 = applySpans("\n(நடு+மோதிர விரல்)-இடது கன்னம்", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt4 = applySpans("- நாராயணா", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt6 = applySpans("\n(ஆள்காட்டி+கட்டை விரல்)-வலது மூக்கு", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt5 = applySpans("- மாதவா", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt7 = applySpans("\n(ஆள்காட்டி+கட்டை விரல்)-இடது மூக்கு", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt6 = applySpans("- கோவிந்தா", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt8 = applySpans("\n(நடு+கட்டை விரல்)-வலது கண்", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt7 = applySpans("- விஷ்ணு", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt9 = applySpans("\n(நடு+கட்டை விரல்)-இடது கண்", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt8 = applySpans("- மதுஸூதனா", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt10 = applySpans("\n(மோதிர+கட்டை விரல்)-வலது காது", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt9 = applySpans("- த்ரிவிக்ரமா", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt11 = applySpans("\n(மோதிர+கட்டை விரல்)-இடது காது", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt10 = applySpans("- வாமனா", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt12 = applySpans("\n(வலது உள்ளங்கை)-மார்பு",  10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt11 = applySpans("- ஸ்ரீதரா", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt13 = applySpans("\n(ஐந்து விரல் நுனி)-முன் தலை",  10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt12 = applySpans("- ஹ்ருஷீகேஷா", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt14 = applySpans("\n(ஐந்து விரல் நுனி)-வலது தோள்",  10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt13 = applySpans("- பத்மநாபா", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt15 = applySpans("\n(ஐந்து விரல் நுனி)-இடது தோள்",  10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt14 = applySpans("- தாமோதரா\n", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val hdSt2 = applySpans("\nகணேச ப்ரார்த்தனை", 16, Typeface.BOLD, Color.parseColor("#8b008b"))
      hdSt2.setSpan(UnderlineSpan(), 0, hdSt2.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
      val comSt16 = applySpans("\n(இரண்டு கைவிரல்களையும் மடித்துக் கொண்டு, தலையின் இரு பொட்டிலும் ஐந்து முறை குட்டிக் கொள்ளவும்)", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt15 = applySpans("\nசுக்லாம் பரதரம் விஷ்ணும்\n   சசிவர்ணம் சதுர்புஜம் |\nப்ரஸன்ன வதனம் த்யாயேத்\n   ஸர்வ விக்நோப சாந்தயே ||\n", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val hdSt3 = applySpans("\nப்ராணாயாமம்", 16, Typeface.BOLD, Color.parseColor("#8b008b"))
      hdSt3.setSpan(UnderlineSpan(), 0, hdSt3.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
      val comSt17 = applySpans("\n(வலது கை கட்டை விரலால் வலது மூக்கை மேல்புறமாக மூடி இடநாசியால் மூச்சை உள்ளிழுத்து பின் வலது மோதிர மற்றும் சுண்டு ஆகிய விரலால் இடது மூக்கை மேல் பறமாக மூடி இம்மந்திரத்தை கூறவும்)\n", 10, Typeface.ITALIC, Color.DKGRAY)
      val comSt17Ten = applySpans("\n(வலது கை கட்டை விரலால் வலது மூக்கை மேல்புறமாக மூடி இடநாசியால் மூச்சை உள்ளிழுத்து பின் வலது மோதிர மற்றும் சுண்டு ஆகிய விரலால் இடது மூக்கை மேல் பறமாக மூடி இம்மந்திரத்தை 10 முறை கூறவும்)\n", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt16 = applySpans("\nஓம் பூ: ஓம்புவா:\n   ஓம் ஸுவா: ஓம் மஹ: \nஓம் ஜன: ஓம் தப:\n   ஓம் ஸத்யம் ஓம் தத்ஸவிதுர் வரேண்யம் \n   பர்கோ தேவஸ்ய தீமஹி | \nதியோ யோந: ப்ரசோதயாத் |\n   ஓம் ஆபோ ஜ்யோதீரஸோ \nஅம்ருதம் ப்ரம்ம பூர்புவஸ்வரோம் ||", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt18 = applySpans("\n(வலது கையால் வலது காதை தொடடு)-", 10, Typeface.ITALIC, (Color.DKGRAY))
      val bdSt17 = applySpans("\nஓம்  ஓம்  ஓம் ||\n", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val hdSt4 = applySpans("\nஸங்கல்பம்", 16, Typeface.BOLD, Color.parseColor("#8b008b"))
      hdSt4.setSpan(UnderlineSpan(), 0, hdSt4.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
      val comSt19 = applySpans("\n(வலது தொடையின் மீது இடது கையை மேற்புறமாக வைத்துக் கொண்டு, அதன் மேல் வலது கையை வைத்து மூடினாட்போல் வைத்து)", 10, Typeface.ITALIC, Color.DKGRAY)
      val text3 = "\n   மமோபாத்த ஸமஸ்த துரிதஷயத் வாரா ஸ்ரீபரமேச்வர ப்ரீத்யர்த்தம் TYPEOFSANDYA காயத்ரீ மஹாமந்த்ர ஜபம் கரிஷ்யே ||\n அப உப ஸ்ப்ருச்ய ||"
      val replacedText3 = text3.replace("""(TYPEOFSANDYA)""".toRegex(), sandyaType)
      val bdSt18 = applySpans(replacedText3, 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt20 = applySpans("-(ஜலத்தால் கைகளை துடைத்துக் கொள்ளவும்)\n\n (எழுந்து நின்று கைகூப்பி ப்ராத்தித்து நமஸ்கரிக்கவும்)\n", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt19 = applySpans("   ஆப்ரம்ம லோகாத் ஆசேஷாத்\nஆலோகாலோகபர்வதாத் |\n   யே வஸந்தி த்விஜா தேவா: \nதேப்யோ நித்யம் நமோ நம: ||\nநமோ ப்ரம்மண்ய தேவாய \nகோப்ராம்மண ஹிதாய ச |\nஜகத்திதாய க்ருஷ்ணாய \nகோவிந்தாய நமோ நம: ||\n", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val hdSt5 = applySpans("\nஅபிவாதனம்", 16, Typeface.BOLD, Color.parseColor("#8b008b"))
      hdSt5.setSpan(UnderlineSpan(), 0, hdSt5.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
      val hdSt5A = applySpans("\nஅபிவாதனம்", 16, Typeface.BOLD, Color.parseColor("#8b008b"))
      hdSt5A.setSpan(UnderlineSpan(), 0, hdSt5A.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
      val hdSt5B = applySpans("\nஅபிவாதனம்", 16, Typeface.BOLD, Color.parseColor("#8b008b"))
      hdSt5B.setSpan(UnderlineSpan(), 0, hdSt5B.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
      val text0 = "\n   அபிவாதயே yourPravaras ப்ரவரான்வித: yourGothram கோத்ர: காத்யாயன ஸூத்ர: ஸ்ரீஶுக்ல யஜூர் வேத காண்வஶாகாத்யாயீ ஸ்ரீ yourName ஶர்மா நாமாஹம் அஹம் அஸ்மி போ:|\n"
      val replacedText0 = text0
        .replace("""(yourPravaras)""".toRegex(), pravarasYour)
        .replace("""(yourGothram)""".toRegex(), gothramYour)
        .replace("""(yourName)""".toRegex(), nameYour)
      val bdSt20 = applySpans(replacedText0, 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val text = "\n   அபிவாதயே yourPravaras ப்ரவரான்வித: yourGothram கோத்ர: காத்யாயன ஸூத்ர: ஸ்ரீஶுக்ல யஜூர் வேத காண்வஶாகாத்யாயீ ஸ்ரீ yourName ஶர்மா நாமாஹம் அஹம் அஸ்மி போ:|\n"
      val replacedText = text
        .replace("""(yourPravaras)""".toRegex(), pravarasYour)
        .replace("""(yourGothram)""".toRegex(), gothramYour)
        .replace("""(yourName)""".toRegex(), nameYour)
      val bdSt20G = applySpans(replacedText, 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val text1 = "\n   அபிவாதயே yourPravaras ப்ரவரான்வித: yourGothram கோத்ர: காத்யாயன ஸூத்ர: ஸ்ரீஶுக்ல யஜூர் வேத காண்வஶாகாத்யாயீ ஸ்ரீ yourName ஶர்மா நாமாஹம் அஹம் அஸ்மி போ:|\n"
      val replacedText1 = text1
        .replace("""(yourPravaras)""".toRegex(), pravarasYour)
        .replace("""(yourGothram)""".toRegex(), gothramYour)
        .replace("""(yourName)""".toRegex(), nameYour)
      val bdSt20K = applySpans(replacedText1, 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val hdSt6 = applySpans("\nஆஸனமந்திரம்", 16, Typeface.BOLD, Color.parseColor("#8b008b")) // Assuming applySpans doesn't handle UnderlineSpan
      hdSt6.setSpan(UnderlineSpan(), 0, hdSt6.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
      val comSt21 = applySpans("\nமுன் தலையைத் தொட்டு- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt21 = applySpans("ஆஸன மந்த்ரஸ்யப்ருதிவ்யா மேருப்ருஷ்ட ரிஷி: |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt22 = applySpans("\nமூக்கைத் தொட்டு-  ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt22 = applySpans("ஸூதலம் ச்சந்த: |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt23 = applySpans("\nமார்பைத் தொட்டு- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt23 = applySpans("கூர்மரூபீ நாராயணோ தேவதா |",  12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt24 = applySpans("\nகைகளை உள்வாங்கவும்- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt24 = applySpans("ஆஸனே வினியோக: ||",  12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt25 = applySpans("\nகை கூப்பி- \n", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt25 = applySpans("கூர்மாஸனாய நம: அனந்தாஸனாய நம: பத்மாஸனாய நம: \nகருடாஸனாய நம:ஸிம்மாஸனாய நம: ||   " +
                "\nப்ருத்வி த்வயா த்ருதா  \nலோகா தேவி த்வம் விஷ்ணுநா த்ருதா |\nத்வஞ்ச தாரயமாம் தேவி பவித்ரம் குரு சாஸனம்||\n" +
                "ஓம் பூர்புவஸ்ஸுவ: ஸுகாஸனம் ||\nஉக்ரபூதபிசாசாத்யா யே ச வை பூமிதாரகா:|\nஏதேஷாம் அவிரோதேன ஜபகர்ம ஸமாரபே|| \nஅபஸர்பந்து தே பூதா" +
                "யே பூதா பூமி ஸம்ஸ்திதா:|\nயே பூதா விக்னகர்த்தாரஸ் \nதே கச்சந்து சிவாக்ஞயா ||",  12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt26 = applySpans("-கையை சொடுக்கிய படியே தலையைச் சுற்றி கையைத் தட்டவும்\nகை கூப்பி- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt26 = applySpans("ஓம் சார்ங்காய சக்ராய சராய ஸுதர்சனாய அஸ்த்ராய பட் ||\n",  12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val hdSt3A = applySpans("\nப்ராணாயாமம்", 16, Typeface.BOLD, Color.parseColor("#8b008b"))
      hdSt3A.setSpan(UnderlineSpan(), 0, hdSt3A.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
      val bdSt27 = applySpans("ப்ரணவஸ்ய பரப்ரம்ஹ ரிஷி: |",  12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val bdSt28 = applySpans("பதேவீ காயத்ரீச்சந்த: |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val bdSt29 = applySpans("தஸவிதா பரமாத்மா தேவதா||", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val bdSt30 = applySpans("பூராதி ஸப்தவ்யாஹ்ருதீனாம் அத்ரிப்ருகு குத்ஸ வஸிஷ்ட கௌதம காச்யப ஆங்கிரஸா ரிஷய: |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val bdSt31 = applySpans("காயத்ரீ உஷ்ணிக் அனுஷ்டுப் ப்ருஹதீ பங்க்தி த்ரிஷ்டுப் ஜகத்யஸ் ச்சந்தாம்ஸி |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val bdSt32 = applySpans("அக்னி வாயு அர்க்க வாகீச வருண இந்த்ர விச்வே தேவா தேவதா: ||", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val bdSt33 = applySpans("தத்ஸவிதுரிதி மஹாமந்த்ரஸ்ய விச்வாமித்ரோ பகவான் ரிஷி: ||", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val bdSt34 = applySpans("தேவீ காயத்ரீச்சந்த:|", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val bdSt35 = applySpans("ஸவிதா பரமாத்மா தேவதா ||", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val bdSt36 = applySpans("ஆபோ ஜ்யோதிரிதி மந்த்ரஸ்ய ப்ரஜாபதிர் ரிஷி: |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val bdSt37 = applySpans("த்விபதா காயத்ரீச்சந்த: |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val bdSt38 = applySpans("ப்ரம்மாக்னிவாயுஸுர்யா தேவதா: ||", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      bdSt38.setSpan(AbsoluteSizeSpan(12, true), start, bdSt38.length, exExFlag)
      val bdSt39 = applySpans("ஸர்வேஷாம் ப்ராணாயாமே வினியோக: ||", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val hdSt3B = applySpans("\n\nப்ராணாயாமம்", 16, Typeface.BOLD, Color.parseColor("#8b008b"))
      hdSt3B.setSpan(UnderlineSpan(), 0, hdSt3B.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
      val bdSt16A = applySpans("\nஓம் பூ: ஓம்புவா:\n   ஓம் ஸுவா: ஓம் மஹ: \nஓம் ஜன: ஓம் தப:\n   ஓம் ஸத்யம் ஓம் தத்ஸவிதுர் வரேண்யம் \n   பர்கோ தேவஸ்ய தீமஹி | \nதியோ யோந: ப்ரசோதயாத் |\n   ஓம் ஆபோ ஜ்யோதீரஸோ \nஅம்ருதம் ப்ரம்ம பூர்புவஸ்வரோம் ||\n", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val hdSt7 = applySpans("\nஆவாஹனம்", 16, Typeface.BOLD, Color.parseColor("#8b008b"))
      hdSt7.setSpan(UnderlineSpan(), 0, hdSt7.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
      val bdSt40 = applySpans("ஆயாத்விதி மந்த்ரஸ்ய வாமதேவ ரிஷி: |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val bdSt41 = applySpans("அனுஷ்டுப்ச் சந்த: |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val bdSt42 = applySpans("காயத்ரீ தேவதா |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val bdSt43 = applySpans(
        "ஆவாஹனே வினியோக: ||\n" +
                "ஓம் ஆயாதுவரதாதேவி \nஅக்ஷரம் ப்ரம்மஸம்மிதம் |\n" +
                "   காயத்ரீம் ச்சந்தஸாம் மாதா \nஇதம் ப்ரம்ம ஜுஷஸ்வந: ||\n" +
                "தேஜோஸி தேஜோ மயிதேஹி \nவீர்யமஸி வீர்யம் மயிதேஹி\n" +
                "   பலமஸி பலம் மயிதேஹி \nஓஜோஸ்யோஜோ மயிதேஹி |\n" +
                "மன்யுரஸி மன்யும் மயிதேஹி \nஸஹோஸி ஸஹோ மயிதேஹி ||\n" +
                "   ஓஜோஸி-ஸஹோஸி- \nபலமஸி-ப்ராஜோஸி- \nதேவாநாம் தாமநாமாஸி- \nவிச்வமஸி-விச்வாயு: \nஸர்வமஸி ஸரவாயுரபிபூரோம் ||\n" +
                "காயத்ரீம் ஆவாஹயாமி |\n ஸாவித்ரீம் ஆவாஹயாமி |\n" +
                "   ஸரஸ்வதீம் ஆவாஹயாமி |\nச்சந்தர்ஷிம் ஆவாஹயாமி |\n" +
                "ச்ரியம் ஆவாஹயாமி |\nபலம் ஆவாஹயாமி ||", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val bdSt44 = applySpans("காயத்ர்யா: விச்வாமித்ரோ பகவான் ரிஷி: |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt27 = applySpans("\nவாயின் மேற்புறத்தை தொட்டு- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt45 = applySpans("அக்னிர் முகம |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val bdSt46 = applySpans("ப்ரம்மா சிர: |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val bdSt47 = applySpans("விஷ்ணுர் ஹ்ருதயம் |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt28 = applySpans("\nஇரு தோள்களைத் தொட்டு- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt48 = applySpans("ருத்ர: கவசம் |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt29 = applySpans("\nபின்தலையைத் தொட்டு- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt49 = applySpans("ஆப: புச்சம் ||", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt30 = applySpans("\nகை கூப்பிச் சொல்லவம்- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt50 = applySpans("ஸாங்க்யாயனஸ கோத்ரம் |\n சக்ஷூ: பிங்காக்ஷம் ||", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val bdSt51A = applySpans("ரக்தம் வர்ணம் கர்மஞானே வினியோக:|", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val bdSt51B = applySpans("ச்வேதம் வர்ணம் ஆத்மஞானே வினியோக: |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val bdSt51C = applySpans("சக்ருஷ்ணம் வர்ணம் மோக்ஷஞானே வினியோக: |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val hdSt8 = applySpans("\n\nகரந்யாஸம்", 16, Typeface.BOLD, Color.parseColor("#8b008b"))
      hdSt8.setSpan(UnderlineSpan(), 0, hdSt8.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
      val comSt31 = applySpans("\nஆள்காட்டி விரல்களால் இருகட்டை விரல்களை வருடவும்- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt52 = applySpans("ஓம் தத்ஸவிதுர் பிரம்மாத்மனே அங்குஷ்டாப்யாம் நம: |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt32 = applySpans("\nகட்டை விரல்களால் ஆள்காட்டி விரல்களை வருடவும்- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt53 = applySpans("வரேண்யம் விஷ்ண்வாத்மனே தர்ஜனீப்யாம் நம: |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt33Missg = applySpans("\nகட்டை விரல்களால் நடு விரல்களை வருடவும்- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt54Missg = applySpans("பர்கோ தேவஸ்ய ருத்ராத்மனே மத்யமாப்யாம் நம: |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt33 = applySpans("\nகட்டை விரல்களால் சுண்டு விரல்களை வருடவும்- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt54 = applySpans("தியோயோந: ஸதாசிவாத்மனே கநிஷ்டிகாப்யாம் நம: |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt34 = applySpans("\nஇருகைகளின் உட்புறம், வெளிப்புறம் இரண்டையும் தடவவும்- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt55 = applySpans("ப்ரசோதயாத் ஸர்வாத்மனே கரதலகரப்ருஷ்டாப்யாம் நம: |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val hdSt9 = applySpans("\n\nஅங்கந்யாஸம்", 16, Typeface.BOLD, Color.parseColor("#8b008b"))
      hdSt9.setSpan(UnderlineSpan(), 0, hdSt9.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
      val bdSt56 = applySpans("ஓம் தத்ஸவிதுர் பிரம்மாத்மனே ஹ்ருதயாய நம: |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val bdSt56A = applySpans("ஓம் தத்ஸவிதுர் பிரம்மாத்மனே ஹ்ருதயாய நம: |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val bdSt57 = applySpans("வரேண்யம் விஷ்ண்வாத்மனே சிரஸே ஸ்வாஹா |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val bdSt57A = applySpans("வரேண்யம் விஷ்ண்வாத்மனே சிரஸே ஸ்வாஹா |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt35 = applySpans("\nபின் தலையைத் தொட்டு- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt58 = applySpans("பர்கோ தேவஸ்ய ருத்ராத்மனே சிகாயை வஷட் |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val bdSt58A = applySpans("பர்கோ தேவஸ்ய ருத்ராத்மனே சிகாயை வஷட் |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt36 = applySpans("\nஇரு தோள்களைத் தொட்டு- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt59 = applySpans("தீமஹி ஈச்வராத்மனே கவசாய ஹூம் |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val bdSt59A = applySpans("தீமஹி ஈச்வராத்மனே கவசாய ஹூம் |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt37 = applySpans("\nமூன்று கண்களைத் தொட்டு- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt60 = applySpans("தியோயோந: ஸதாசிவாத்மனே நேத்ரத்யாய வௌஷட் |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val bdSt60A = applySpans("தியோயோந: ஸதாசிவாத்மனே நேத்ரத்யாய வௌஷட் |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt38 = applySpans("\nவலது கையை சொடுக்கிக் கொண்டே தலையை வலமாகச் சுற்றி இடக்கையில் தட்டவும்- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt61 = applySpans("ப்ரசோதயாத் ஸர்வாத்மனே அஸ்த்ராய ப்பட் |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt39 = applySpans("\nவலது கையை சொடுக்கிக் கொண்டே தலையை வலமாகச் சுற்றி இடக்கையில் தட்டவும்- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt62 = applySpans("பூர்புவஸ்ஸ்வரோம் இதி திக்பந்த: ||", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val hdSt10 = applySpans("\n\nத்யானம்", 16, Typeface.BOLD, Color.parseColor("#8b008b"))
      hdSt10.setSpan(UnderlineSpan(), 0, hdSt10.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
      val hdSt10A = applySpans("\n\nத்யானம்", 16, Typeface.BOLD, Color.parseColor("#8b008b"))
      hdSt10A.setSpan(UnderlineSpan(), 0, hdSt10A.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
      val comSt40 = applySpans("\nகைகூப்பி- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt63 = applySpans(
        "முக்தாவித்ரும ஹேமநீல தவளச்\n" +
                "   சாயையர் முகைஸ் த்ரீக்ஷணை:\n" +
                "யுக்தாம் இந்துகலா நிபத்தமகுடாம்\n" +
                "   தத்வார்த்த வர்ணாத்மிகாம் |\n" +
                "காயத்ரீம் வரதாபயாங்குச கசா:\n" +
                "   சுப்ரம் கபாலம் கதாம்\n" +
                "சங்கம் சக்ரம் அதாரவிந்தயுகளம்\n" +
                "   ஹஸ்தைர் வஹந்தீம் பஜே ||", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val hdSt11 = applySpans("\n\nபஞ்சபூஜை", 16, Typeface.BOLD, Color.parseColor("#8b008b"))
      hdSt11.setSpan(UnderlineSpan(), 0, hdSt11.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
      val hdSt11A = applySpans("\n\nபஞ்சபூஜை", 16, Typeface.BOLD, Color.parseColor("#8b008b"))
      hdSt11A.setSpan(UnderlineSpan(), 0, hdSt11A.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
      val comSt41 = applySpans("\nகட்டை விரல்களால் சுண்டு விரல்களை வருடவும்- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt64 = applySpans("லம் ப்ருதிவ்யாத்மனே கந்தான் தாரயாமி |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt42 = applySpans("\nஆள்காட்டி விரல்களால் கட்டை விரல்களை வருடவும்- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt65 = applySpans("ஹம் ஆகாசாத்மனே புஷ்பாணி ஸமர்ப்பயாமி |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt43 = applySpans("\nகட்டை விரல்களால் ஆள்காட்டி விரல்களை வருடவும்- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt66 = applySpans("யம் வாய்வாத்மனே தூபம் ஆக்ராபயாமி |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt44 = applySpans("\nகட்டை விரல்களால் நடு விரல்களை வருடவும்- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt67 = applySpans("ரம் வன்யாத்மனே தீபம் தர்ஸயாமி |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt45 = applySpans("\nகட்டை விரல்களால் மோதிர விரல்களை வருடவும்- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt68 = applySpans("வம் அம்ருதாத்மனே திவ்யாம்ருதம் மஹாநைவேத்யம் நிவேதயாமி |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val bdSt69 = applySpans("ஸம் ஸர்வாத்மனே ஸமஸ்த ராஜோபசாரான் தேவோபசாரான் ஸமர்ப்பயாமி ||", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val hdSt12 = applySpans("\n\nகாயத்ரீ மஹாமந்த்ர ஜபம்", 16, Typeface.BOLD, Color.parseColor("#8b008b"))
      hdSt12.setSpan(UnderlineSpan(), 0, hdSt12.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
      val comSt46 = applySpans(
        "\n(காயத்ரீ மந்த்ரத்தை ஜபிக்கும் முறை: கீழே பிரிக்கப்பட்டுள்ளபடி ப்ரணவம் - வ்யாஹ்ருதிகள் - 3 பாதங்கள் ஆக ஐந்து விபாகமாக காயத்ரீ மஹாமந்த்ரத்தை எப்போதும் ஜபிக்க வேண்டும்.\n" +
                " இவ்வாறு ஜபிக்கப்படும் காயத்ரியானது மஹாபாபங்கையும் போக்கவல்லது. தவிர காலையில் செய்யும் காயத்ரீ ஜபத்தை மட்டும் எழுந்து நின்றுதான் செய்யவேண்டும். ஜபம் செய்யும்போது இருகைகளையும் ஒன்று சேர்த்து, மேல்\n" +
                " வேஷ்டிக்குள் மறைத்துக்கொண்டு வலது கைவிரல்களின் ரேகைகளில் மட்டும் எண்ணுதல் வேண்டும். காலையில் இரு கைகளையும் நெற்றி மட்டத்திலும், மதியம் மார்பு மட்டத்திலும், மாலையில் தொப்புள் மட்டத்திலும்\n" +
                " வைத்துக்கொண்டு காயத்ரீ ஜபத்தை செய்ய வேண்டும். ௸ காயத்ரீ மந்த்ரத்தை ஒவ்வொரு வேளையும் 108 தரம் செய்வது உத்தமம்)", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt70 = applySpans(
        "\nஓம் | பூர்புவஸ்ஸ்வ: |\n" +
                "    தத்ஸதுவிர் வரேண்யம் |\n" +
                "பர்கோ தேவஸ்ய தீமஹி |\n" +
                "    தியோயோந: ப்சோதயாத் ||", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val bdSt16B = applySpans("\nஓம் பூ: ஓம்புவா:\n   ஓம் ஸுவா: ஓம் மஹ: \nஓம் ஜன: ஓம் தப:\n   ஓம் ஸத்யம் ஓம் தத்ஸவிதுர் வரேண்யம் \n   பர்கோ தேவஸ்ய தீமஹி | \nதியோ யோந: ப்ரசோதயாத் |\n   ஓம் ஆபோ ஜ்யோதீரஸோ \nஅம்ருதம் ப்ரம்ம பூர்புவஸ்வரோம் ||", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val bdSt17A = applySpans("\nஓம்  ஓம்  ஓம் ||\n", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val hdSt13 = applySpans("\n\nப்ரணாயாமம்", 16, Typeface.BOLD, Color.parseColor("#8b008b"))
      hdSt13.setSpan(UnderlineSpan(), 0, hdSt13.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
      val hdSt9A = applySpans("\n\nஅங்கந்யாஸம்", 16, Typeface.BOLD, Color.parseColor("#8b008b"))
      hdSt9A.setSpan(UnderlineSpan(), 0, hdSt9A.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
      val comSt38Add = applySpans("\nவலது கையை சொடுக்கிக் கொண்டே தலையை வலமாகச் சுற்றி இடக்கையில் தட்டவும்- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt61Add = applySpans("ப்ரசோதயாத் ஸர்வாத்மனே அஸ்த்ராய ப்பட் |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt47 = applySpans("\nவலது கையை சொடுக்கிக் கொண்டே இடமாகத் நலையைச் சுற்றி இடக்கையில் தட்டவும்- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt71 = applySpans("பூர் புவஸ்ஸ்வரோம் - இதி திக்விமோக: ||", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val bdSt72 = applySpans(
        "முக்தாவித்ரும ஹேமநீல தவளச் சாயையர் முகைஸ் த்ரீக்ஷணை:\n" +
                "  யுக்தாம் இந்துகலா நிபத்தமகுடாம் தத்வார்த்த வர்ணாத்மிகாம் |\n" +
                "காயத்ரீம் வரதாபயாங்குச கசா: சுப்ரம் கபாலம் கதாம்\n" +
                "   சங்கம் சக்ரம் அதாரவிந்தயுகளம் ஹஸ்தைர் வஹந்தீம் பஜே ||", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val bdSt73 = applySpans("லம் ப்ருதிவ்யாத்மனே கந்தான் தாரயாமி |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val bdSt74 = applySpans("ஹம் ஆகாசாத்மனே புஷ்பாணி ஸமர்ப்பயாமி |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val bdSt75 = applySpans("யம் வாய்வாத்மனே தூபம் ஆக்ராபயாமி |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val bdSt76 = applySpans("ரம் வன்யாத்மனே தீபம் தர்ஸயாமி |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val bdSt77 = applySpans("வம் அம்ருதாத்மனே திவ்யாம்ருதம் மஹாநைவேத்யம் நிவேதயாமி |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val bdSt78 = applySpans("ஸம் ஸர்வாத்மனே ஸமஸ்த ராஜோபசாரான் தேவோபசாரான் ஸமர்ப்பயாமி ||", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val hdSt14 = applySpans("\nஉபஸ்தானம்", 16, Typeface.BOLD, Color.parseColor("#8b008b"))
      hdSt14.setSpan(UnderlineSpan(), 0, hdSt14.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
      val comSt48 = applySpans("\nஎழுந்து நின்று சூரியனை நோக்கி கை கூப்பி- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val text5 = "\nTYPEOFSANDYA காயத்ர்யுபஸ்தானம் கரிஷ்யே |\n" +
              " ஓம்-உத்தமே சிகரே தேவி \n   பூம்யாம் பர்வத மூர்த்தனி\n" +
              "    ப்ராம்மணேப்யோ ஹ்யனுக்ஞாதா \n   கச்ச தேவி யதாஸுகம் ||\n" +
              " விச்வதஸ் சக்ஷுருத விச்வதோமுகோ \n   விச்வதோ பாஹுருத விச்வதஸ்பாத் |\n" +
              "    ஸம்பாஹுப்யாம் தமதி ஸம்பத்ரைர் \n   த்யாவாபூமீ ஜனயன் தேவ ஏக: ||\n" +
              " தஸ்யா உபஸ்தானம் காயத்ர்யஸ்யேகபதீ \n   த்விபதீ த்ரிபதீ சதுஷ்பத்யபதஸி நஹி\n" +
              "    பத்யஸே நமஸ்தே துரீயாய தர்சதாய \n   பதாய பரோரஜஸே ஸாவதோமா ப்ராபதிதி ||\n அப உப ஸ்ப்ருச்ய ||"
      val replacedText5 = text5.replace("""(TYPEOFSANDYA)""".toRegex(), sandyaType)
      val bdSt79 = applySpans(replacedText5, 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt49 = applySpans("\nஒவ்வொரு நாளும் மாத்யான்னிக அனுஷ்டானத்தின் போது, இரண்டு கைகளின் விரல்களை வருணபாசம்- என்ற முறையில் கோர்த்து வைத்துக் கொண்டு, \n" +
                "விரல்களின் இடைவெளி வழியாக சூரியனை தரிசிக்க வேண்டும். அப்பொது சொல்ல வேண்டிய மந்த்ரங்கள் கீழ்வருமாறு:\n", 10, Typeface.ITALIC, Color.DKGRAY)
      val comSt49A = applySpans(" வருணபாசம் ", 10, Typeface.ITALIC, Color.DKGRAY)
      val varuna = BitmapFactory.decodeResource(resources, R.drawable.varunabasammudra)
      comSt49A.setSpan(ImageSpan(this, varuna), 9, 10, Spannable.SPAN_INCLUSIVE_INCLUSIVE)
      val comSt49B = applySpans(
        "\nஎன்ற முறையில் கோர்த்து வைத்துக் கொண்டு, " +
                "விரல்களின் இடைவெளி வழியாக சூரியனை தரிசிக்க வேண்டும். அப்பொது சொல்ல வேண்டிய மந்த்ரங்கள் கீழ்வருமாறு:\n", 10, Typeface.ITALIC, Color.DKGRAY)
      val hdSt15 = applySpans("\nசூர்ய ப்ரார்த்தனை\n", 16, Typeface.BOLD, Color.parseColor("#8b008b"))
      hdSt15.setSpan(UnderlineSpan(), 0, hdSt15.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
      val bdSt80 = applySpans("\nஉத்வயம் தமஸ ஸ்பரிஸ்வ: \n   பச்யந்த உத்தரம் |\n" +
                "    தேவம் தேவத்ரா சூர்யமகன்ம \n   ஜ்யோ திருத்தமம் ||\n" +
                " உதுத்யம் ஜாதவேதஸம் தேவம் \n   வஹந்தி கேதவ: |\n" +
                "    த்ருசே விச்வாய சூர்யம் ||\n" +
                " சித்ரம் தேவாநாமுதகாத் அனீகம் \n   சக்ஷுர் மித்ரஸ்ய வருணஸ்யாக்னே: |\n" +
                "    ஆப்ரா த்யாவாப்ருதிவீ அந்தரிக்ஷக்கு \n   ஸூர்ய ஆத்மா ஜகதஸ்தஸ்துஷஸ்ச |\n" +
                " தச்சக்ஷுசர் தேவஹிதம் \n   புரஸ்தாச்சுக்ரமுச்சரத் |\n" +
                "    பச்யேம சரதஸ்சதஞ் ஜீவேம \n   சரதஸ்சதக்கு ச்ருணுயாமசரதஸ்சதம் ||\n", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt50 = applySpans(" - என்று நமஸ்கரிக்கவும்", 10, Typeface.ITALIC, Color.DKGRAY)
      val hdSt16 = applySpans("\n\nதிக் தேவதா ப்ரார்த்தனை", 16, Typeface.BOLD, Color.parseColor("#8b008b"))
      hdSt16.setSpan(UnderlineSpan(), 0, hdSt16.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
      val comSt51 = applySpans("\nகிழக்கு நோக்கி- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt81 = applySpans("ஓம் ப்ராச்யை திசே நம: |\n இந்த்ராய நம: |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt52 = applySpans("\nதென்கிழக்கு நோக்கி- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt82 = applySpans("ஓம் ஆக்னேய்யை திசே நம: |\n அக்னயே நம: |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt53 = applySpans("\nதெற்கு நோக்கி- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt83 = applySpans("ஓம் தக்ஷிணாயை திசே நம: |\n யமாய நம: |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt54 = applySpans("\nதென்மேற்கு நோக்கி- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt84 = applySpans("ஓம் நைர்ருத்யை திசே நம: |\n நிர்ருதயே நம: |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt55 = applySpans("\nமேற்கு நோக்கி- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt85 = applySpans("ஓம் ப்ரதீச்யை திசே நம: |\n வருணாய நம: |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt56 = applySpans("\nவடமேற்கு நோக்கி- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt86 = applySpans("ஓம் வாயவ்யை திசே நம: |\n வாயவே நம: |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt57 = applySpans("\nவடக்கு நோக்கி- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt87 = applySpans("ஓம் உதீச்யை திசே நம: |\n ஸோமாய நம: |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt58 = applySpans("\nவடகிழக்கு நோக்கி- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt88 = applySpans("ஓம் ஐசான்யை திசே நம: |\n ஈசாநாய நம: |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt59 = applySpans("\nமேல் நோக்கி- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt89 = applySpans("ஓம் ஊர்த்வாயை திசே நம: |\n பிரம்மணே நம: |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt60 = applySpans("\nகீழ் நோக்கி- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt90 = applySpans("ஓம் அதராயை திசே நம: |\n அனந்தாய நம: |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt61 = applySpans("\nநேர்முகமாக நோக்கி- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt91 = applySpans("ஓம் அவாச்யை திசே நம: |\n அந்தரிக்ஷாய நம: |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt62 = applySpans("\nபூமியை நோக்கி- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt92 = applySpans("பூம்யை நம: |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt63 = applySpans("\nநேர்முகமாக- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt93 = applySpans("ஸந்த்யாயை நம: |\n காயத்ர்யை நம: |\nஸாவித்ர்யை நம: | ஸரஸ்வத்யை நம: |", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val hdSt17 = applySpans("\n\nகாமோஷீத் - மஹாமந்த்ரம்", 16, Typeface.BOLD, Color.parseColor("#8b008b"))
      hdSt17.setSpan(UnderlineSpan(), 0, hdSt17.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
      val comSt64 = applySpans("\nஸூரியனை நோக்கி கைகூப்பி- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt94 = applySpans("காமோஸகாரிஷீத் | மன்யுரகாரிஷீத் |\n    ஓம் நமோ நம: ||", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val hdSt18 = applySpans("\n\nஸூர்ய வந்தனம்", 16, Typeface.BOLD, Color.parseColor("#8b008b"))
      hdSt18.setSpan(UnderlineSpan(), 0, hdSt18.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
      val bdSt95 = applySpans(
        "\nஓம் நமஸ் ஸவித்ரே ஜகதேக சக்ஷூஷே\n" +
                "   ஜகத் ப்ரஸூதி ஸ்திதி நாச ஹேதவே |\n" +
                "்ரயீமயாய த்ரிகுணாத்ம தாரிணே\n" +
                "   விரிஞ்சி நாராயண சங்கராத்மனே ||\n" +
                "த்யேயஸ் ஸதா ஸவித்ரு மண்டல மத்யவர்த்தீ நாராயண:\n" +
                "   ஸரஸிஜான ஸன்னிவிஷ்ட: கேயூரவான் மகரகுண்டல\n" +
                "வான் | கிரீடீ ஹாரீ ஹிரண்மயவபு: த்ருத சங்கசக்ர: |\n" +
                "   சங்கசக்ர கதாபாணே த்வாரகா நிலயாச்யுத |\n" +
                "கோவிந்த! புண்டரீகாக்ஷ! ரக்ஷமாம் சரணாகதம் ||\n" +
                "   ரக்ஷமாம் சரணாகதம் ஓம் நம இதி ||\n    ஓம் நமோ நம: ||", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val hdSt19 = applySpans("\n\nயம வந்தனம்", 16, Typeface.BOLD, Color.parseColor("#8b008b"))
      hdSt19.setSpan(UnderlineSpan(), 0, hdSt19.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
      val bdSt96 = applySpans(
        "யமாய தர்மராஜாய ம்ருத்யவே சாந்தகாய ச |\n" +
                "    வைவஸ்வதாய காலாய ஸர்வபூதக்ஷயாய ச ||\n" +
                " ஔதும்பராய தத்நாய நீலாய பரமேஷ்டிநே |\n" +
                "    வ்ருகோதராய சித்ராய சித்ரகுப்தாய வை நம: ||\n" +
                " சித்ரகுப்தாய வை நம ஓம் நம இதி ||", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val hdSt20 = applySpans("\n\nஹரிஹர வந்தனம்", 16, Typeface.BOLD, Color.parseColor("#8b008b"))
      hdSt20.setSpan(UnderlineSpan(), 0, hdSt20.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
      val bdSt97 = applySpans(
        "ருதகும் ஸத்யம் பரம் ப்ரம்ஹ புருஷம் க்ருஷ்ண பிங்களம் |\n" +
                "    ஊர்த்வரேதம் விரூபாக்ஷம் விச்வரூபாய வை நமோ நம:\n" +
                " விச்வரூபாய வை நம ஓம் நம இதி ||", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val hdSt21 = applySpans("\n\nசூர்ய ப்ரார்த்தனை", 16, Typeface.BOLD, Color.parseColor("#8b008b"))
      hdSt21.setSpan(UnderlineSpan(), 0, hdSt21.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
      val bdSt98 = applySpans(
        "ஆகாசாத் பதிதம் தோயம் யதாகச்சதி ஸாகரம் |\n" +
                "    ஸர்வதேவ நமஸ்கார: கேசவம் ப்ரதி கச்சதி |\n" +
                " கேசவம் ப்ரதி கச்சதி ஓம் நம இதி ||\n" +
                "    பாபோஹம் பாகர்மாஹம் பாபாத்மா பாபஸம்பவ: |\n" +
                " த்ராஹிமாம் க்ருபயா தேவ சரணாகதவத்ஸல ||\n" +
                "    சரணாகதவத்ஸல ஓம் நம இதி ||\n", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val hdSt22 = applySpans("\n\nஜபஸமர்ப்பணம்", 16, Typeface.BOLD, Color.parseColor("#8b008b"))
      hdSt22.setSpan(UnderlineSpan(), 0, hdSt22.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
      val comSt65 = applySpans("\nவலது கையில் ஒவ்வொரு உத்தரணி ஜலத்தை விட்டுக் கொண்டு, பூமியில் விடவும்- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val text6 = "\nமயாக்ருதமிதம் TYPEOFSANDYA \nகாயத்ரீ ஜபாக்யம் கர்ம ஸர்வம் \nஸ்ரீ க்ருணார்ப்பணமஸ்து |\n" +
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
      val replacedText6 = text6.replace("""(TYPEOFSANDYA)""".toRegex(), sandyaType)
      val bdSt99 = applySpans(replacedText6, 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt66 = applySpans("\nஜபம் செய்ய உட்கார்ந்த இடத்தில் லேசாக ஜலம் தெளிக்கவும்- ", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt100 = applySpans("\nபூர் புவஸ்ஸுவ: |\n    புண்டரீகாக்ஷாய நம: ||\n   ஓம் விச்வானி தேவஸவிதர் \n   துரிதானி பராஸுவ |\nயத்பத்ரம் தன்ன ஆஸுவ ||", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val comSt67 = applySpans("\n(மோதிர விரலால் பூமியைத் தொட்டு நெற்றியில் இட்டுக் கொள்ளவும்)\n\nஜபம் செய்த இடத்தை, " +
                "ஜலம் தெளித்து நெற்றியில் இட்டுக் கொள்ள வேண்டும் என்பதைச் சொல்லும் சுலோகம் இது:-", 10, Typeface.ITALIC, Color.DKGRAY)
      val bdSt101 = applySpans("அப்ரோக்ஷிதே ஜபஸ்தானே \n   சுக்ரோ ஹரதித்ஜ்ஜபம் |\n    தன் மூலே ம்ருத்திகாம் \n   குர்யால்லலாடே திலகாக்ருதிம் ||", 12, Typeface.BOLD, Color.parseColor("#0000ee"))
      val hdSt23 = applySpans("\n\nமுற்றும்\n\n\n", 16, Typeface.BOLD, Color.parseColor("#8b008b"))
      hdSt23.setSpan(UnderlineSpan(), 0, hdSt23.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
      val gayathriCombination = SpannableStringBuilder()
      gayathriCombination.append(
        hdSt1, comSt1, comSt2, bdSt1, comSt3, bdSt2, comSt4, bdSt3, comSt5, bdSt4, comSt6, bdSt5)
      gayathriCombination.append(comSt7, bdSt6, comSt8, bdSt7, comSt9, bdSt8, comSt10, bdSt9, comSt11, bdSt10, comSt12, bdSt11)
      gayathriCombination.append(comSt13, bdSt12, comSt14, bdSt13, comSt15, bdSt14, hdSt2, comSt16, bdSt15, hdSt3, comSt17)
      gayathriCombination.append(bdSt16, comSt18, bdSt17, hdSt4, comSt19, bdSt18, comSt20, bdSt19, hdSt5, bdSt20, hdSt6, comSt21, bdSt21)
      gayathriCombination.append(comSt22, bdSt22, comSt23, bdSt23, comSt24, bdSt24, comSt25, bdSt25, comSt26, bdSt26, hdSt3A)
      gayathriCombination.append(comSt21, bdSt27, comSt22, bdSt28, comSt23, bdSt29, comSt21, bdSt30, comSt22, bdSt31, comSt23, bdSt32)
      gayathriCombination.append(comSt21, bdSt33, comSt22, bdSt34, comSt23, bdSt35, comSt21, bdSt36, comSt22, bdSt37, comSt23, bdSt38)
      gayathriCombination.append(comSt25, bdSt39, hdSt3B, comSt17Ten, bdSt16A, hdSt7, comSt21, bdSt40, comSt22, bdSt41, comSt23, bdSt42)
      gayathriCombination.append(comSt25, bdSt43, comSt21, bdSt44, comSt22, bdSt34, comSt23, bdSt35, comSt27, bdSt45, comSt21, bdSt46)
      gayathriCombination.append(comSt23, bdSt47, comSt28, bdSt48, comSt29, bdSt49, comSt30, bdSt50)
      if (sandyaType.equals("ப்ராத்தஸ்ந்தியா", true)) {
        gayathriCombination.append(bdSt51A)
      } else if (sandyaType.equals("மாத்யாநிஹம்", true)) {
        gayathriCombination.append(bdSt51B)
      } else {
        gayathriCombination.append(bdSt51C)
      }
      gayathriCombination.append(hdSt8, comSt31, bdSt52, comSt32, bdSt53, comSt33Missg, bdSt54Missg, comSt33, bdSt54, comSt34, bdSt55, hdSt9, comSt23, bdSt56)
      gayathriCombination.append(comSt21, bdSt57, comSt35, bdSt58, comSt36, bdSt59, comSt37, bdSt60, comSt38, bdSt61, comSt39, bdSt62)
      gayathriCombination.append(hdSt10, comSt40, bdSt63, hdSt11, comSt41, bdSt64, comSt42, bdSt65, comSt43, bdSt66, comSt44, bdSt67)
      gayathriCombination.append(comSt45, bdSt68, comSt25, bdSt69, hdSt12, comSt46, bdSt70, hdSt13, comSt17, bdSt16B, comSt18, bdSt17A)
      gayathriCombination.append(hdSt9A, comSt23, bdSt56A, comSt21, bdSt57A, comSt35, bdSt58A, comSt36, bdSt59A, comSt37, bdSt60A, comSt38Add, bdSt61Add, comSt47)
      gayathriCombination.append(bdSt71, hdSt10A, comSt25, bdSt72, hdSt11A, comSt41, bdSt73, comSt42, bdSt74, comSt43, bdSt75, comSt44)
      gayathriCombination.append(bdSt76, comSt45, bdSt77, comSt25, bdSt78, "\n", hdSt14, comSt48, bdSt79, comSt49, comSt49A, comSt49B, hdSt15, bdSt80, hdSt5A)
      gayathriCombination.append(bdSt20K, comSt50, hdSt16, comSt51, bdSt81, comSt52, bdSt82, comSt53, bdSt83, comSt54, bdSt84, comSt55, bdSt85)
      gayathriCombination.append(comSt56, bdSt86, comSt57, bdSt87, comSt58, bdSt88, comSt59, bdSt89, comSt60, bdSt90, comSt61, bdSt91, comSt62)
      gayathriCombination.append(bdSt92, comSt63, bdSt93, hdSt17, comSt64, bdSt94, hdSt18, bdSt95, hdSt19, comSt53, bdSt96, hdSt20, comSt57)
      gayathriCombination.append(bdSt97, hdSt21, comSt64, bdSt98, hdSt5B, bdSt20G, comSt50, hdSt22, comSt65, bdSt99, comSt66, bdSt100, comSt67, bdSt101, hdSt23)
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
