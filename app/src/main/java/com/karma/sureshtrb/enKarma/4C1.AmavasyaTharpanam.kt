package com.karma.sureshtrb.enKarma

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.pdf.PdfDocument
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.*
import android.print.*
import android.print.pdf.PrintedPdfDocument
import android.text.*
import android.text.method.ScrollingMovementMethod
import android.text.style.*
import android.view.ViewTreeObserver
import android.view.animation.LinearInterpolator
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.karma.sureshtrb.enKarma.databinding.ActivityAmavasyaTharpanamBinding
import java.io.FileOutputStream
import java.io.IOException
import kotlin.math.ceil
import kotlin.math.min

class AmavasyaTharpanam : AppCompatActivity() {

    // Data for multi-page printing (dynamic allocation now)
    var totalPages: Int = 1
    var pageBoundaries = mutableListOf<Pair<Int, Int>>() // Store page boundaries dynamically

    // Media controls
    private lateinit var mediaPlayer: MediaPlayer
    private var paused = false
    private val handler = Handler(Looper.getMainLooper())
    private lateinit var runnable: Runnable
    private var totalScrollHeight = 0
    private lateinit var binding: ActivityAmavasyaTharpanamBinding
    private val Amava_combination = SpannableStringBuilder()
    // Helper: Extension properties for MediaPlayer
    private val MediaPlayer.seconds: Int get() = this.duration / 1000
    private val MediaPlayer.currentSeconds: Int get() = this.currentPosition / 1000

    @SuppressLint("ResourceType")
    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAmavasyaTharpanamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupMediaControls()

        binding.btnPlay.isEnabled = true
        binding.buttonPausePlay.isEnabled = false
        binding.btnStop.isEnabled = false

        val printBtn = findViewById<Button>(R.id.printButton)
        val intent = intent
        val dateTdy: String = intent.getStringExtra("Naal").orEmpty()
        val place: String = intent.getStringExtra("Idam").orEmpty()
        val varusham: String = intent.getStringExtra("TamilYear").orEmpty()
        val ayyanamm: String = intent.getStringExtra("Ayanamm").orEmpty()
        val kalam: String = intent.getStringExtra("KAALAM").orEmpty()
        val rasee: String = intent.getStringExtra("RASEEE").orEmpty()
        val baksham: String = intent.getStringExtra("BAKKSHAMM").orEmpty()
        val todThithi: String = intent.getStringExtra("TODAYSTHITHI").orEmpty()
        val kizhamai: String = intent.getStringExtra("KIZHAMAAII").orEmpty()
        val nachathirm: String = intent.getStringExtra("NAKSM").orEmpty()
        val yog: String = intent.getStringExtra("YGM").orEmpty()
        val kar: String = intent.getStringExtra("KRNM").orEmpty()

        val yrNamee: String = intent.getStringExtra("Peyar").orEmpty()
        val yrFNamee: String = intent.getStringExtra("Appa").orEmpty()
        val yrGFNamee: String = intent.getStringExtra("Thatha").orEmpty()
        val yrGGFNamee: String = intent.getStringExtra("Kollu").orEmpty()
        val yrGGGFNamee: String = intent.getStringExtra("Yellu").orEmpty()
        val MFNamee: String = intent.getStringExtra("AmmaAppa").orEmpty()
        val MGFNamee: String = intent.getStringExtra("AmmaThatha").orEmpty()
        val mGGFNamee: String = intent.getStringExtra("AmmaKolluThatha").orEmpty()

        supportActionBar?.apply {
            setHomeAsUpIndicator(R.drawable.home)
            setDisplayHomeAsUpEnabled(true)
            subtitle = "$todThithi தர்ப்பணம்"
            setDisplayShowHomeEnabled(true)
            setLogo(R.drawable.karma)
            setDisplayUseLogoEnabled(true)
        }

        val exExFlag = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE

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

        val guruVndnmHd = SpannableString("\nகுரு வந்தனம்")
        guruVndnmHd.setSpan(AbsoluteSizeSpan(16, true), start, guruVndnmHd.length, exExFlag)
        guruVndnmHd.setSpan(StyleSpan(Typeface.BOLD), start, guruVndnmHd.length, exExFlag)
        guruVndnmHd.setSpan(UnderlineSpan(), start, guruVndnmHd.length, exExFlag)
        guruVndnmHd.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, guruVndnmHd.length, exExFlag)

        val guruVndnm = SpannableString("\nஓம் வந்தேஹம் மங்களாத்மானம் பாஸ்வந்தம் வேதவிக்ரஹம் |\n" +
                "   யாக்ஞவல்க்யம் முனிஶ்ரேஷ்டம் ஜிஷ்ணும் ஹரிஹரப்ரபம் |\n" +
                "ஜிதேந்த்ரியம் ஜிதக்ரோதம் ஸதா த்யானபராயணம் |\n" +
                "   ஆனந்தநிலயம் வந்தே யோகாநந்த முனீஶ்வரம் ||\n" +
                "ப்ரணம்யாத்யம் தினமணிம் யோகீஶ்வர ஶிரோமணிம் |\n" +
                "   ஸர்வக்ஞம் யாக்ஞவல்க்யம் தச்சிஷ்யம் காத்யாயநம் முநிம் ||\n" +
                "வேதாந்தவேத்யம் சகலாத வர்த்யம் தயாஸ்துதா ஸிந்து அனந்த ரூபம் |\n" +
                "   ஸ்ரீயாக்யவல்க்யம் பரிபூர்ண சந்த்ரம் ஸ்ரீமத் குரும் நித்யமஹம் நமாமி ||\n" +
                "ஓம் ஸ்ரீயோகீஸ்வர யாக்யவல்க்ய சத்குருப்யோ நம: ||\n" +
                "    சர்வ கண்வகாத்யாயினி மஹரிஷிப்யோ நம: ||\n" +
                "        அஸ்மத் குரு சரணாரவிந்தாப்யாந் நம: ||")
        guruVndnm.setSpan(AbsoluteSizeSpan(14, true), start, guruVndnm.length, exExFlag)
        guruVndnm.setSpan(StyleSpan(Typeface.BOLD), start, guruVndnm.length, exExFlag)
        guruVndnm.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, guruVndnm.length, exExFlag)

        val shuklaKanvasaka1 = SpannableString("\n\nசுக்லயஜூர்வேத காண்வஸாகா sThithi தர்ப்பணம்")
        val regexShuklaKanvasaka1 = """(sThithi)""".toRegex()
        val shuklaKanvasaka = SpannableString(shuklaKanvasaka1.replace(regexShuklaKanvasaka1, todThithi))
        shuklaKanvasaka.setSpan(AbsoluteSizeSpan(14, true), start, shuklaKanvasaka.length, exExFlag)
        shuklaKanvasaka.setSpan(StyleSpan(Typeface.BOLD), start, shuklaKanvasaka.length, exExFlag)
        shuklaKanvasaka.setSpan(UnderlineSpan(), start, shuklaKanvasaka.length, exExFlag)
        shuklaKanvasaka.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, shuklaKanvasaka.length, exExFlag)

        val Comment15A = SpannableString("\n இஃது அமாவாசையன்று மாத்யான்ஹிக காலத்தில் மாத்யான்ஹிக, " +
                "ப்ரம்ஹயக்ஞ, தேவரிஷி பித்ரு தர்ப்பணங்களை யதாவத் முடித்துக் கொண்டு செய்ய வேண்டிய கர்மா.) இதற்கு இரண்டு " +
                "7, 5, 3 பில் ஒத்தப்படையில் உள்ள மடித்த கூர்ச்சம், 3 பில் பவித்ரம் ஒன்று கொஞ்சம் எள்,")
        Comment15A.setSpan(AbsoluteSizeSpan(11, true), start, Comment15A.length, exExFlag)
        Comment15A.setSpan(StyleSpan(Typeface.ITALIC), start, Comment15A.length, exExFlag)
        Comment15A.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment15A.length, exExFlag)

        val Comment15B = SpannableString("\n இஃது அமாவாசையன்று மாத்யான்ஹிக காலத்தில் மாத்யான்ஹிக, " +
                "ப்ரம்ஹயக்ஞ, தேவரிஷி பித்ரு தர்ப்பணங்களை யதாவத் முடித்துக் கொண்டு செய்ய வேண்டிய கர்மா.)\n      " +
                "இதற்கு இரண்டு 7, 5, 3 பில்  ஒத்தப்படையில் உள்ள  மடித்த கூர்ச்சம், 3 பில் பவித்ரம் ஒன்று கொஞ்சம் " +
                "எள்ளும், சிறிது அரிசி,")
        Comment15B.setSpan(AbsoluteSizeSpan(11, true), start, Comment15B.length, exExFlag)
        Comment15B.setSpan(StyleSpan(Typeface.ITALIC), start, Comment15B.length, exExFlag)
        Comment15B.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment15B.length, exExFlag)

        val comment15C = SpannableString(" சொம்பு, பஞ்சபாத்ரத்தில் தீர்த்தம் தேவை. கிழக்கு முகமாக ஆசனத்தில் " +
                "அமர்ந்து அமைதியாக நிறுத்தி நிதானமாக, பித்ரு தேவதைகளை மனதில் தியானித்து " +
                "கீழ்க்கூறிய பிரகாரம் தர்ப்பணம் செய்ய வேண்டும்.")
        comment15C.setSpan(AbsoluteSizeSpan(11, true), start, comment15C.length, exExFlag)
        comment15C.setSpan(StyleSpan(Typeface.ITALIC), start, comment15C.length, exExFlag)
        comment15C.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comment15C.length, exExFlag)

        val Heading1 = SpannableString("\n\nஆசமனம்\n")
        Heading1.setSpan(AbsoluteSizeSpan(16, true), start, Heading1.length, exExFlag)
        Heading1.setSpan(StyleSpan(Typeface.BOLD), start, Heading1.length, exExFlag)
        Heading1.setSpan(UnderlineSpan(), start, Heading1.length, exExFlag)
        Heading1.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, Heading1.length, exExFlag)

        val Comment1 = SpannableString("\n ஒவ்வொரு உத்தரிணி ஜலம் எடுத்து வலது கையில் விட்டு ஒவ்வொரு மந்திரத்துக்கும் " +
                "உட்கொள்ளவும் ")
        Comment1.setSpan(AbsoluteSizeSpan(11, true), start, Comment1.length, exExFlag)
        Comment1.setSpan(StyleSpan(Typeface.ITALIC), start, Comment1.length, exExFlag)
        Comment1.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment1.length, exExFlag)

        val Body1 = SpannableString("- \nஓம் அச்யுதாய நம: |  ஓம் அனந்தாய நம: |  ஓம் கோவிந்தாய நம: ||")
        Body1.setSpan(AbsoluteSizeSpan(14, true), start, Body1.length, exExFlag)
        Body1.setSpan(StyleSpan(Typeface.BOLD), start, Body1.length, exExFlag)
        Body1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body1.length, exExFlag)

        val comment2 = SpannableString("\n ஒரு உத்தரிணி ஜலம் எடுத்து வலது கையில் விட்டு கீழே விடவும் ")
        comment2.setSpan(AbsoluteSizeSpan(11, true), start, comment2.length, exExFlag)
        comment2.setSpan(StyleSpan(Typeface.ITALIC), start, comment2.length, exExFlag)
        comment2.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comment2.length, exExFlag)

        val Body2 = SpannableString("- அபஉபஸ்ப்ருஸ்ய ||\n")
        Body2.setSpan(AbsoluteSizeSpan(14, true), start, Body2.length, exExFlag)
        Body2.setSpan(StyleSpan(Typeface.BOLD), start, Body2.length, exExFlag)
        Body2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body2.length, exExFlag)

        val comment3 = SpannableString("\nவலது கட்டை விரலால் வாயை துடைத்துக் கொள்ளவும்\n விரல்களால் அங்கங்களை " +
                "தொடவும் \nநடு மற்றும் மோதிர விரல்   வலது கன்னம்")
        comment3.setSpan(AbsoluteSizeSpan(11, true), start, comment3.length, exExFlag)
        comment3.setSpan(StyleSpan(Typeface.ITALIC), start, comment3.length, exExFlag)
        comment3.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comment3.length, exExFlag)

        val body3 = SpannableString("- கேசவா")
        body3.setSpan(AbsoluteSizeSpan(14, true), start, body3.length, exExFlag)
        body3.setSpan(StyleSpan(Typeface.BOLD), start, body3.length, exExFlag)
        body3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, body3.length, exExFlag)

        val comment4 = SpannableString("\n நடு மற்றும் மோதிர விரல்   இடது கன்னம்")
        comment4.setSpan(AbsoluteSizeSpan(11, true), start, comment4.length, exExFlag)
        comment4.setSpan(StyleSpan(Typeface.ITALIC), start, comment4.length, exExFlag)
        comment4.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comment4.length, exExFlag)

        val Body4 = SpannableString("- நாராயணா")
        Body4.setSpan(AbsoluteSizeSpan(14, true), start, Body4.length, exExFlag)
        Body4.setSpan(StyleSpan(Typeface.BOLD), start, Body4.length, exExFlag)
        Body4.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body4.length, exExFlag)

        val Comment5 = SpannableString("\n ஆள்காட்டி மற்றும் கட்டை விரல்   வலது மூக்கு")
        Comment5.setSpan(AbsoluteSizeSpan(11, true), start, Comment5.length, exExFlag)
        Comment5.setSpan(StyleSpan(Typeface.ITALIC), start, Comment5.length, exExFlag)
        Comment5.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment5.length, exExFlag)

        val Body5 = SpannableString("- மாதவா")
        Body5.setSpan(AbsoluteSizeSpan(14, true), start, Body5.length, exExFlag)
        Body5.setSpan(StyleSpan(Typeface.BOLD), start, Body5.length, exExFlag)
        Body5.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body5.length, exExFlag)

        val Comment6 = SpannableString("\n ஆள்காட்டி மற்றும் கட்டை விரல்    இடது மூக்கு")
        Comment6.setSpan(AbsoluteSizeSpan(11, true), start, Comment6.length, exExFlag)
        Comment6.setSpan(StyleSpan(Typeface.ITALIC), start, Comment6.length, exExFlag)
        Comment6.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment6.length, exExFlag)

        val Body6 = SpannableString("- கோவிந்தா")
        Body6.setSpan(AbsoluteSizeSpan(14, true), start, Body6.length, exExFlag)
        Body6.setSpan(StyleSpan(Typeface.BOLD), start, Body6.length, exExFlag)
        Body6.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body6.length, exExFlag)

        val Comment7 = SpannableString("\n நடு மற்றும் கட்டை விரல்    வலது கண்")
        Comment7.setSpan(AbsoluteSizeSpan(11, true), start, Comment7.length, exExFlag)
        Comment7.setSpan(StyleSpan(Typeface.ITALIC), start, Comment7.length, exExFlag)
        Comment7.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment7.length, exExFlag)

        val Body7 = SpannableString("- விஷ்ணு")
        Body7.setSpan(AbsoluteSizeSpan(14, true), start, Body7.length, exExFlag)
        Body7.setSpan(StyleSpan(Typeface.BOLD), start, Body7.length, exExFlag)
        Body7.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body7.length, exExFlag)

        val Comment8 = SpannableString("\n நடு மற்றும் கட்டை விரல்    இடது கண்")
        Comment8.setSpan(AbsoluteSizeSpan(11, true), start, Comment8.length, exExFlag)
        Comment8.setSpan(StyleSpan(Typeface.ITALIC), start, Comment8.length, exExFlag)
        Comment8.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment8.length, exExFlag)

        val Body8 = SpannableString("- மதுஸூதனா")
        Body8.setSpan(AbsoluteSizeSpan(14, true), start, Body8.length, exExFlag)
        Body8.setSpan(StyleSpan(Typeface.BOLD), start, Body8.length, exExFlag)
        Body8.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body8.length, exExFlag)

        val Comment9 = SpannableString("\n மோதிர மற்றும் கட்டை விரல்    வலது காது")
        Comment9.setSpan(AbsoluteSizeSpan(11, true), start, Comment9.length, exExFlag)
        Comment9.setSpan(StyleSpan(Typeface.ITALIC), start, Comment9.length, exExFlag)
        Comment9.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment9.length, exExFlag)

        val Body9 = SpannableString("- த்ரிவிக்ரமா")
        Body9.setSpan(AbsoluteSizeSpan(14, true), start, Body9.length, exExFlag)
        Body9.setSpan(StyleSpan(Typeface.BOLD), start, Body9.length, exExFlag)
        Body9.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body9.length, exExFlag)

        val Comment10 = SpannableString("\n மோதிர மற்றும் கட்டை விரல்     இடது காது")
        Comment10.setSpan(AbsoluteSizeSpan(11, true), start, Comment10.length, exExFlag)
        Comment10.setSpan(StyleSpan(Typeface.ITALIC), start, Comment10.length, exExFlag)
        Comment10.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment10.length, exExFlag)

        val Body10 = SpannableString("- வாமனா")
        Body10.setSpan(AbsoluteSizeSpan(14, true), start, Body10.length, exExFlag)
        Body10.setSpan(StyleSpan(Typeface.BOLD), start, Body10.length, exExFlag)
        Body10.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body10.length, exExFlag)

        val Comment11 = SpannableString("\n வலது உள்ளங்கை     மார்பு")
        Comment11.setSpan(AbsoluteSizeSpan(11, true), start, Comment11.length, exExFlag)
        Comment11.setSpan(StyleSpan(Typeface.ITALIC), start, Comment11.length, exExFlag)
        Comment11.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment11.length, exExFlag)

        val Body11 = SpannableString("- ஸ்ரீதரா")
        Body11.setSpan(AbsoluteSizeSpan(14, true), start, Body11.length, exExFlag)
        Body11.setSpan(StyleSpan(Typeface.BOLD), start, Body11.length, exExFlag)
        Body11.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body11.length, exExFlag)

        val Comment12 = SpannableString("\n ஐந்து விரல் நுனி     முன் தலை")
        Comment12.setSpan(AbsoluteSizeSpan(11, true), start, Comment12.length, exExFlag)
        Comment12.setSpan(StyleSpan(Typeface.ITALIC), start, Comment12.length, exExFlag)
        Comment12.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment12.length, exExFlag)

        val Body12 = SpannableString("- ஹ்ருஷீகேஷா")
        Body12.setSpan(AbsoluteSizeSpan(14, true), start, Body12.length, exExFlag)
        Body12.setSpan(StyleSpan(Typeface.BOLD), start, Body12.length, exExFlag)
        Body12.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body12.length, exExFlag)

        val comment13 = SpannableString("\n ஐந்து விரல் நுனி     வலது தோள்")
        comment13.setSpan(AbsoluteSizeSpan(11, true), start, comment13.length, exExFlag)
        comment13.setSpan(StyleSpan(Typeface.ITALIC), start, comment13.length, exExFlag)
        comment13.setSpan(ForegroundColorSpan(Color.DKGRAY), start, comment13.length, exExFlag)

        val Body13 = SpannableString("- பத்மநாபா")
        Body13.setSpan(AbsoluteSizeSpan(14, true), start, Body13.length, exExFlag)
        Body13.setSpan(StyleSpan(Typeface.BOLD), start, Body13.length, exExFlag)
        Body13.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body13.length, exExFlag)

        val Comment14 = SpannableString("\n ஐந்து விரல் நுனி     இடது தோள்")
        Comment14.setSpan(AbsoluteSizeSpan(11, true), start, Comment14.length, exExFlag)
        Comment14.setSpan(StyleSpan(Typeface.ITALIC), start, Comment14.length, exExFlag)
        Comment14.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment14.length, exExFlag)

        val Body14 = SpannableString("- தாமோதரா\n")
        Body14.setSpan(AbsoluteSizeSpan(14, true), start, Body14.length, exExFlag)
        Body14.setSpan(StyleSpan(Typeface.BOLD), start, Body14.length, exExFlag)
        Body14.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body14.length, exExFlag)
        //==============================================================================================================
        val pavithraTharanam = SpannableString("\nபவித்ர தாரண மந்திரம்")
        pavithraTharanam.setSpan(AbsoluteSizeSpan(16, true), start, pavithraTharanam.length, exExFlag)
        pavithraTharanam.setSpan(StyleSpan(Typeface.BOLD), start, pavithraTharanam.length, exExFlag)
        pavithraTharanam.setSpan(UnderlineSpan(), start, pavithraTharanam.length, exExFlag)
        pavithraTharanam.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, pavithraTharanam.length, exExFlag)

        val pavThaMntram = SpannableString("\n  தீர்காயுஸ்வா யபளாஹா யவஸ்ச்சாது சுக்ல ஜாஸ்த்வாயாதா ஸா ஆதோஜீவ ஸரதஸ்ச்சதம் | " +
                "பவித்ர தாரணம் ||")
        pavThaMntram.setSpan(AbsoluteSizeSpan(14, true), start, pavThaMntram.length, exExFlag)
        pavThaMntram.setSpan(StyleSpan(Typeface.BOLD), start, pavThaMntram.length, exExFlag)
        pavThaMntram.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, pavThaMntram.length, exExFlag)

        val tharbeshuAsinaha = SpannableString(" - (பவித்திரத்தை மோதிர விரலில் அணிந்து கொள்ளவும்)\n")
        tharbeshuAsinaha.setSpan(AbsoluteSizeSpan(11, true), start, tharbeshuAsinaha.length, exExFlag)
        tharbeshuAsinaha.setSpan(StyleSpan(Typeface.ITALIC), start, tharbeshuAsinaha.length, exExFlag)
        tharbeshuAsinaha.setSpan(ForegroundColorSpan(Color.DKGRAY), start, tharbeshuAsinaha.length, exExFlag)

        val Body15 = SpannableString("தர்பேஷு ஆசீன:")
        Body15.setSpan(AbsoluteSizeSpan(14, true), start, Body15.length, exExFlag)
        Body15.setSpan(StyleSpan(Typeface.BOLD), start, Body15.length, exExFlag)
        Body15.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body15.length, exExFlag)

        val Comment16 = SpannableString(" என்று சொல்லி 2/3 கட்டை தர்பங்களை ஆசனமாகவும்\n")
        Comment16.setSpan(AbsoluteSizeSpan(11, true), start, Comment16.length, exExFlag)
        Comment16.setSpan(StyleSpan(Typeface.ITALIC), start, Comment16.length, exExFlag)
        Comment16.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment16.length, exExFlag)

        val Body16 = SpannableString("தர்பான் தாரயமாண:")
        Body16.setSpan(AbsoluteSizeSpan(14, true), start, Body16.length, exExFlag)
        Body16.setSpan(StyleSpan(Typeface.BOLD), start, Body16.length, exExFlag)
        Body16.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body16.length, exExFlag)

        val Comment17 = SpannableString("  என்று சொல்லி 2/3 கட்டை தர்பங்களை பவித்ரத்துடன் கையிலிடுக்கிக் கொண்டும், " +
                "சங்கல்பம் செய்ய வேண்டும்.\n")
        Comment17.setSpan(AbsoluteSizeSpan(11, true), start, Comment17.length, exExFlag)
        Comment17.setSpan(StyleSpan(Typeface.ITALIC), start, Comment17.length, exExFlag)
        Comment17.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment17.length, exExFlag)

        val Heading2 = SpannableString("\nசங்கல்பம்\n")
        Heading2.setSpan(AbsoluteSizeSpan(16, true), start, Heading2.length, exExFlag)
        Heading2.setSpan(StyleSpan(Typeface.BOLD), start, Heading2.length, exExFlag)
        Heading2.setSpan(UnderlineSpan(), start, Heading2.length, exExFlag)
        Heading2.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, Heading2.length, exExFlag)

        val Body17 = SpannableString("ஓம் சுக்லாம்பரதரம் விஷ்ணும் சசிவர்ணம் சதுர்புஜம்\n" +
                " ப்ரஸன்ன வதனம் த்யாயேத் ஸர்வ விக்ன உபசாந்தயே")
        Body17.setSpan(AbsoluteSizeSpan(14, true), start, Body17.length, exExFlag)
        Body17.setSpan(StyleSpan(Typeface.BOLD), start, Body17.length, exExFlag)
        Body17.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body17.length, exExFlag)

        val Comment18 = SpannableString("\nமுன் தலையில் கை வைத்துக் கொண்டு - ")
        Comment18.setSpan(AbsoluteSizeSpan(11, true), start, Comment18.length, exExFlag)
        Comment18.setSpan(StyleSpan(Typeface.ITALIC), start, Comment18.length, exExFlag)
        Comment18.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment18.length, exExFlag)

        val Body18 = SpannableString("ஓம் ப்ரணவஸ்ய - பரப்ரும்மரிஷி:")
        Body18.setSpan(AbsoluteSizeSpan(14, true), start, Body18.length, exExFlag)
        Body18.setSpan(StyleSpan(Typeface.BOLD), start, Body18.length, exExFlag)
        Body18.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body18.length, exExFlag)

        val Comment19 = SpannableString("\n நுனிமூக்கில் கை வைத்துக் கொண்டு - ")
        Comment19.setSpan(AbsoluteSizeSpan(11, true), start, Comment19.length, exExFlag)
        Comment19.setSpan(StyleSpan(Typeface.ITALIC), start, Comment19.length, exExFlag)
        Comment19.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment19.length, exExFlag)

        val Body19 = SpannableString("தேவீ காயத்ரீச் சந்த:")
        Body19.setSpan(AbsoluteSizeSpan(14, true), start, Body19.length, exExFlag)
        Body19.setSpan(StyleSpan(Typeface.BOLD), start, Body19.length, exExFlag)
        Body19.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body19.length, exExFlag)

        val Comment20 = SpannableString("\nஹ்ருதயத்தில் கை வைத்துக் கொண்டு - ")
        Comment20.setSpan(AbsoluteSizeSpan(11, true), start, Comment20.length, exExFlag)
        Comment20.setSpan(StyleSpan(Typeface.ITALIC), start, Comment20.length, exExFlag)
        Comment20.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment20.length, exExFlag)

        val Body20 = SpannableString("ஸவிதா பரமாத்மா தேவதா ")
        Body20.setSpan(AbsoluteSizeSpan(14, true), start, Body20.length, exExFlag)
        Body20.setSpan(StyleSpan(Typeface.BOLD), start, Body20.length, exExFlag)
        Body20.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body20.length, exExFlag)

        val Comment21 = SpannableString("\n(கைகளை உள் மடிக்கவும்) - ")
        Comment21.setSpan(AbsoluteSizeSpan(11, true), start, Comment21.length, exExFlag)
        Comment21.setSpan(StyleSpan(Typeface.ITALIC), start, Comment21.length, exExFlag)
        Comment21.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment21.length, exExFlag)

        val Body21 = SpannableString("ஓம் பூ: ப்ராணாயாமே விநியோக:\n")
        Body21.setSpan(AbsoluteSizeSpan(14, true), start, Body21.length, exExFlag)
        Body21.setSpan(StyleSpan(Typeface.BOLD), start, Body21.length, exExFlag)
        Body21.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body21.length, exExFlag)

        val Comment22 = SpannableString("\nப்ராணாயாமம்  செய்ய வேண்டும் - (வலது கை கட்டை விரலால் வலது மூக்கை ம" +
                "ேல்புறமாக மூடி இடதுநாசியால் மூச்சை உள்ளிழுக்கும்போது ஓம் பூ: ஓம்புவா: ஓம் ஸுவா: ஓம் மஹ: ஓம் ஜன:ஓம் தப: ஓம் " +
                "ஸத்யம் என்று மனதிற்குள் கூறிக்கொண்டு பின் இரு மூக்கையும் மூடிக்கொண்டு மனதிற்குள் காயத்ரீயை சொல்லி பிறகு வலது " +
                "மோதிர மற்றும் சுண்டு ஆகிய விரலால் இடது மூக்கை மேல் பறமாக மூடி வாய்வழியாக ஓம் ஆபோ ஜ்யோதீரஸோ அம்ருதம் ப்ரம்ம " +
                "பூர்புவஸ்வரோம் || என்று இம்மந்திரத்தை கூறவும்)")
        Comment22.setSpan(AbsoluteSizeSpan(11, true), start, Comment22.length, exExFlag)
        Comment22.setSpan(StyleSpan(Typeface.ITALIC), start, Comment22.length, exExFlag)
        Comment22.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment22.length, exExFlag)

        val Body22 = SpannableString("\nஓம் பூ: ஓம் புவ: ஓம் சுவ: ஓம் மஹ: ஓம் ஜந: ஓம் தப: ஓம் ஸத்யம் தத்ஸவிதுர் வரேண்யம் " +
                "பர்கோ தேவஸ்ய தீமஹி தியோயோ ந: ப்ரசோதயாத் ஓம் ஆப: ஜ்யோதீரஸ: அம்ருதம் ப்ரம்ஹ பூர்புவஸ்வரோம்" +
                "\nஓம்    ஓம்    ஓம் \n___________________________________________________\n")
        Body22.setSpan(AbsoluteSizeSpan(14, true), start, Body22.length, exExFlag)
        Body22.setSpan(StyleSpan(Typeface.BOLD), start, Body22.length, exExFlag)
        Body22.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")),start,Body22.length,exExFlag)

        val addnlNotes1 = SpannableString("\nவருஷம் :")
        addnlNotes1.setSpan(AbsoluteSizeSpan(11, true), start, addnlNotes1.length, exExFlag)
        addnlNotes1.setSpan(StyleSpan(Typeface.ITALIC), start, addnlNotes1.length, exExFlag)
        addnlNotes1.setSpan(ForegroundColorSpan(Color.DKGRAY), start, addnlNotes1.length, exExFlag)

        val AddnlString1x = SpannableString("tamilYear")
        val regexAddnlStrg1 = """(tamilYear)""".toRegex()
        val AddnlString1 = SpannableString(AddnlString1x.replace(regexAddnlStrg1, varusham))
        AddnlString1.setSpan(AbsoluteSizeSpan(14, true), start, AddnlString1.length, exExFlag)
        AddnlString1.setSpan(StyleSpan(Typeface.BOLD), start, AddnlString1.length, exExFlag)
        AddnlString1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, AddnlString1.length, exExFlag)

        val addnlNotes2 = SpannableString("\nருது :")
        addnlNotes2.setSpan(AbsoluteSizeSpan(11, true), start, addnlNotes2.length, exExFlag)
        addnlNotes2.setSpan(StyleSpan(Typeface.ITALIC), start, addnlNotes2.length, exExFlag)
        addnlNotes2.setSpan(ForegroundColorSpan(Color.DKGRAY), start, addnlNotes2.length, exExFlag)

        val AddnlString2x = SpannableString("season")
        val regexAddnlStrg2 = """(season)""".toRegex()
        val AddnlString2 = SpannableString(AddnlString2x.replace(regexAddnlStrg2, kalam))
        AddnlString2.setSpan(AbsoluteSizeSpan(14, true), start, AddnlString2.length, exExFlag)
        AddnlString2.setSpan(StyleSpan(Typeface.BOLD), start, AddnlString2.length, exExFlag)
        AddnlString2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")),start,AddnlString2.length,exExFlag)

        val addnlNotes3 = SpannableString("\nமாசம் :")
        addnlNotes3.setSpan(AbsoluteSizeSpan(11, true), start, addnlNotes3.length, exExFlag)
        addnlNotes3.setSpan(StyleSpan(Typeface.ITALIC), start, addnlNotes3.length, exExFlag)
        addnlNotes3.setSpan(ForegroundColorSpan(Color.DKGRAY), start, addnlNotes3.length, exExFlag)

        val AddnlString3x = SpannableString("sunRasi")
        val regexAddnlStrg3 = """(sunRasi)""".toRegex()
        val AddnlString3 = SpannableString(AddnlString3x.replace(regexAddnlStrg3, rasee))
        AddnlString3.setSpan(AbsoluteSizeSpan(14, true), start, AddnlString3.length, exExFlag)
        AddnlString3.setSpan(StyleSpan(Typeface.BOLD), start, AddnlString3.length, exExFlag)
        AddnlString3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")),start,AddnlString3.length,exExFlag)

        val addnlNotes4 = SpannableString("\nபக்ஷ்ம் :")
        addnlNotes4.setSpan(AbsoluteSizeSpan(11, true), start, addnlNotes4.length, exExFlag)
        addnlNotes4.setSpan(StyleSpan(Typeface.ITALIC), start, addnlNotes4.length, exExFlag)
        addnlNotes4.setSpan(ForegroundColorSpan(Color.DKGRAY), start, addnlNotes4.length, exExFlag)

        val AddnlString4x = SpannableString("moonPosition")
        val regexAddnlStrg4 = """(moonPosition)""".toRegex()
        val AddnlString4 = SpannableString(AddnlString4x.replace(regexAddnlStrg4, baksham))
        AddnlString4.setSpan(AbsoluteSizeSpan(14, true), start, AddnlString4.length, exExFlag)
        AddnlString4.setSpan(StyleSpan(Typeface.BOLD), start, AddnlString4.length, exExFlag)
        AddnlString4.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")),start,AddnlString4.length,exExFlag)

        val addnlNotes5 = SpannableString("\nதிதி :")
        addnlNotes5.setSpan(AbsoluteSizeSpan(11, true), start, addnlNotes5.length, exExFlag)
        addnlNotes5.setSpan(StyleSpan(Typeface.ITALIC), start, addnlNotes5.length, exExFlag)
        addnlNotes5.setSpan(ForegroundColorSpan(Color.DKGRAY), start, addnlNotes5.length, exExFlag)

        val AddnlString5x = SpannableString("Thithi")
        val regexAddnlStrg5 = """(Thithi)""".toRegex()
        val AddnlString5 = SpannableString(AddnlString5x.replace(regexAddnlStrg5, todThithi))
        AddnlString5.setSpan(AbsoluteSizeSpan(14, true), start, AddnlString5.length, exExFlag)
        AddnlString5.setSpan(StyleSpan(Typeface.BOLD), start, AddnlString5.length, exExFlag)
        AddnlString5.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")),start,AddnlString5.length,exExFlag)

        val addnlNotes6 = SpannableString("\nவாரம் :")
        addnlNotes6.setSpan(AbsoluteSizeSpan(11, true), start, addnlNotes6.length, exExFlag)
        addnlNotes6.setSpan(StyleSpan(Typeface.ITALIC), start, addnlNotes6.length, exExFlag)
        addnlNotes6.setSpan(ForegroundColorSpan(Color.DKGRAY), start, addnlNotes6.length, exExFlag)

        val AddnlString6x = SpannableString("weekDay")
        val regexAddnlStrg6 = """(weekDay)""".toRegex()
        val AddnlString6 = SpannableString(AddnlString6x.replace(regexAddnlStrg6, kizhamai))
        AddnlString6.setSpan(AbsoluteSizeSpan(14, true), start, AddnlString6.length, exExFlag)
        AddnlString6.setSpan(StyleSpan(Typeface.BOLD), start, AddnlString6.length, exExFlag)
        AddnlString6.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")),start,AddnlString6.length,exExFlag)

        val addnlNotes7 = SpannableString("\nநக்ஷ்ட்திரம் :")
        addnlNotes7.setSpan(AbsoluteSizeSpan(11, true), start, addnlNotes7.length, exExFlag)
        addnlNotes7.setSpan(StyleSpan(Typeface.ITALIC), start, addnlNotes7.length, exExFlag)
        addnlNotes7.setSpan(ForegroundColorSpan(Color.DKGRAY), start, addnlNotes7.length, exExFlag)

        val AddnlString7x = SpannableString("natchatram\n\n______________________________________________________________\n\n")
        val regexAddnlStrg7 = """(natchatram)""".toRegex()
        val AddnlString7 = SpannableString(AddnlString7x.replace(regexAddnlStrg7, nachathirm))
        AddnlString7.setSpan(AbsoluteSizeSpan(14, true), start, AddnlString7.length, exExFlag)
        AddnlString7.setSpan(StyleSpan(Typeface.BOLD), start, AddnlString7.length, exExFlag)
        AddnlString7.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")),start,AddnlString7.length,exExFlag)

        val AddnlString8 = SpannableString("\nமமோபாத்த ஸமஸ்த துரித ஷயத்வாரா ஸ்ரீபரமேச்வர ப்ரீத்யர்த்தம் \nஓம் அபவித்ர: " +
                "பவித்ரோவா ஸர்வாவஸ்தாம் கதோபிவா \nயஸ்மரேத் புண்டரீகாக்ஷ்ம் ஸபாஹ்யாப்யந்தர: சுசி:\n" +
                "  மானஸம் வாசிகம் பாபம் கர்மனா ஸமுபார்ஜிதம் ஸ்ரீராம ஸ்மரணேநைவ வ்யபோஹதி நஸம்சய: ஸ்ரீராம ராமராம  திதிர்விஷ்ணு: " +
                "ததாவார: நக்ஷத்ரம் விஷ்ணுரேவச யோகஸ்ச கரணம் சைவ ஸர்வம் விஷ்ணுமயம் ஜகத் ஸ்ரீஹரி கோவிந்த கோவிந்தகோவிந்த அத்ய " +
                "ஸ்ரீ பகவத: மஹாபுருஷஸ்ய விஷ்ணோ: ஆக்ஞயா ப்ரவர்த்தமானஸ்ய \n\nஆத்ய ப்ரம்ஹண:")
        AddnlString8.setSpan(AbsoluteSizeSpan(14, true), start, AddnlString8.length, exExFlag)
        AddnlString8.setSpan(StyleSpan(Typeface.BOLD), start, AddnlString8.length, exExFlag)
        AddnlString8.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")),start,AddnlString8.length,exExFlag)

        val Comment23 = SpannableString(" - (ஆதி ப்ரும்மாவிலிருந்து from 1st Brahma’s life)")
        Comment23.setSpan(AbsoluteSizeSpan(11, true), start, Comment23.length, exExFlag)
        Comment23.setSpan(StyleSpan(Typeface.ITALIC), start, Comment23.length, exExFlag)
        Comment23.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment23.length, exExFlag)

        val Body23 = SpannableString("\nத்விதீயே பரார்த்தே")
        Body23.setSpan(AbsoluteSizeSpan(14, true), start, Body23.length, exExFlag)
        Body23.setSpan(StyleSpan(Typeface.BOLD), start, Body23.length, exExFlag)
        Body23.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body23.length, exExFlag)

        val Comment24 = SpannableString(" - (Brahma’s 2nd Parardha. 1 Parardha = 50 Brahma years)")
        Comment24.setSpan(AbsoluteSizeSpan(11, true), start, Comment24.length, exExFlag)
        Comment24.setSpan(StyleSpan(Typeface.ITALIC), start, Comment24.length, exExFlag)
        Comment24.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment24.length, exExFlag)

        val Body24 = SpannableString("\nஸ்வேத வராஹ கல்பே")
        Body24.setSpan(AbsoluteSizeSpan(14, true), start, Body24.length, exExFlag)
        Body24.setSpan(StyleSpan(Typeface.BOLD), start, Body24.length, exExFlag)
        Body24.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body24.length, exExFlag)

        val Comment25 = SpannableString(" - (first of the thirty Kalpas- Matsya Purana)")
        Comment25.setSpan(AbsoluteSizeSpan(11, true), start, Comment25.length, exExFlag)
        Comment25.setSpan(StyleSpan(Typeface.ITALIC), start, Comment25.length, exExFlag)
        Comment25.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment25.length, exExFlag)

        val Body25 = SpannableString("\nவைவஸ்வத மன்வந்தரே")
        Body25.setSpan(AbsoluteSizeSpan(14, true), start, Body25.length, exExFlag)
        Body25.setSpan(StyleSpan(Typeface.BOLD), start, Body25.length, exExFlag)
        Body25.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body25.length, exExFlag)

        val Comment26 = SpannableString(" - (14 manvantras = 1 Kalpa, now 7th - Vaivasvata)")
        Comment26.setSpan(AbsoluteSizeSpan(11, true), start, Comment26.length, exExFlag)
        Comment26.setSpan(StyleSpan(Typeface.ITALIC), start, Comment26.length, exExFlag)
        Comment26.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment26.length, exExFlag)

        val Body26 = SpannableString("\nஅஷ்டா விம்சதிதமே")
        Body26.setSpan(AbsoluteSizeSpan(14, true), start, Body26.length, exExFlag)
        Body26.setSpan(StyleSpan(Typeface.BOLD), start, Body26.length, exExFlag)
        Body26.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body26.length, exExFlag)

        val Comment27 = SpannableString(" - (18,000 Kalpas completed)")
        Comment27.setSpan(AbsoluteSizeSpan(11, true), start, Comment27.length, exExFlag)
        Comment27.setSpan(StyleSpan(Typeface.ITALIC), start, Comment27.length, exExFlag)
        Comment27.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment27.length, exExFlag)

        val Body27 = SpannableString("\nகலியுகே ப்ரதமேபாதே")
        Body27.setSpan(AbsoluteSizeSpan(14, true), start, Body27.length, exExFlag)
        Body27.setSpan(StyleSpan(Typeface.BOLD), start, Body27.length, exExFlag)
        Body27.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body27.length, exExFlag)

        val Comment28 = SpannableString(" - (first quarter of the Kaliyuga)")
        Comment28.setSpan(AbsoluteSizeSpan(11, true), start, Comment28.length, exExFlag)
        Comment28.setSpan(StyleSpan(Typeface.ITALIC), start, Comment28.length, exExFlag)
        Comment28.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment28.length, exExFlag)

        val Body28 = SpannableString("\nஜம்பூத்வீபே பாரதவர்ஷே பரதகண்டே மேரோ: தக்ஷிணேபார்ச்வே சகாப்தே அஸ்மின் வர்த்தமானே")
        Body28.setSpan(AbsoluteSizeSpan(14, true), start, Body28.length, exExFlag)
        Body28.setSpan(StyleSpan(Typeface.BOLD), start, Body28.length, exExFlag)
        Body28.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body28.length, exExFlag)

        val Comment29 = SpannableString(" - (geographical area of our motherland)")
        Comment29.setSpan(AbsoluteSizeSpan(11, true), start, Comment29.length, exExFlag)
        Comment29.setSpan(StyleSpan(Typeface.ITALIC), start, Comment29.length, exExFlag)
        Comment29.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment29.length, exExFlag)

        val Body29AA = SpannableString("\nவ்யவஹாரிகே ப்ரபவாதீநாம் ஷஷ்ட்யா: ஸம்வத்ஸராணாம் மத்யே tamilYear நாம ஸம்வத்ஸரே")
        val regexReplace6 = """(tamilYear)""".toRegex()
        val Body29 = SpannableString(Body29AA.replace(regexReplace6, varusham))
        Body29.setSpan(AbsoluteSizeSpan(14, true), start, Body29.length, exExFlag)
        Body29.setSpan(StyleSpan(Typeface.BOLD), start, Body29.length, exExFlag)
        Body29.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body29.length, exExFlag)

        val Comment30 = SpannableString(" - (specifies the year)")
        Comment30.setSpan(AbsoluteSizeSpan(11, true), start, Comment30.length, exExFlag)
        Comment30.setSpan(StyleSpan(Typeface.ITALIC), start, Comment30.length, exExFlag)
        Comment30.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment30.length, exExFlag)

        val Body30AA = SpannableString("\nsunPosition")
        val regexReplace7 = """(sunPosition)""".toRegex()
        val Body30 = SpannableString(Body30AA.replace(regexReplace7, ayyanamm))
        Body30.setSpan(AbsoluteSizeSpan(14, true), start, Body30.length, exExFlag)
        Body30.setSpan(StyleSpan(Typeface.BOLD), start, Body30.length, exExFlag)
        Body30.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body30.length, exExFlag)

        val Comment31 = SpannableString(" - (Uttarayana, roughly January to June and Dakshinayana,[roughly July to December)")
        Comment31.setSpan(AbsoluteSizeSpan(11, true), start, Comment31.length, exExFlag)
        Comment31.setSpan(StyleSpan(Typeface.ITALIC), start, Comment31.length, exExFlag)
        Comment31.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment31.length, exExFlag)

        val Body31AA = SpannableString("\nseason ருதௌ")
        val regexReplace8 = """(season)""".toRegex()
        val Body31 = SpannableString(Body31AA.replace(regexReplace8, kalam))
        Body31.setSpan(AbsoluteSizeSpan(14, true), start, Body31.length, exExFlag)
        Body31.setSpan(StyleSpan(Typeface.BOLD), start, Body31.length, exExFlag)
        Body31.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body31.length, exExFlag)

        val Comment32 = SpannableString(" - (Season of the year, Vasanta/ Greeshma/ Varsha/ Sharat/ Hemanta/ Shishira)")
        Comment32.setSpan(AbsoluteSizeSpan(11, true), start, Comment32.length, exExFlag)
        Comment32.setSpan(StyleSpan(Typeface.ITALIC), start, Comment32.length, exExFlag)
        Comment32.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment32.length, exExFlag)

        val Body32AA = SpannableString("\nsunRasi மாஸே")
        val regexReplace9 = """(sunRasi)""".toRegex()
        val Body32 = SpannableString(Body32AA.replace(regexReplace9, rasee))
        Body32.setSpan(AbsoluteSizeSpan(14, true), start, Body32.length, exExFlag)
        Body32.setSpan(StyleSpan(Typeface.BOLD), start, Body32.length, exExFlag)
        Body32.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body32.length, exExFlag)

        val Comment33 = SpannableString(" - (12 months -Mesha, Vrushabha, Mithuna, Kataka, Simha, Kanya, Tula, " +
                "Vrichika, Dhanur, Makara, Kumbha, and Meena)")
        Comment33.setSpan(AbsoluteSizeSpan(11, true), start, Comment33.length, exExFlag)
        Comment33.setSpan(StyleSpan(Typeface.ITALIC), start, Comment33.length, exExFlag)
        Comment33.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment33.length, exExFlag)

        val Body33AA = SpannableString("\n moonPosition பக்ஷே")
        val regexReplace10 = """(moonPosition)""".toRegex()
        val Body33 = SpannableString(Body33AA.replace(regexReplace10, baksham))
        Body33.setSpan(AbsoluteSizeSpan(14, true), start, Body33.length, exExFlag)
        Body33.setSpan(StyleSpan(Typeface.BOLD), start, Body33.length, exExFlag)
        Body33.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body33.length, exExFlag)

        val Comment34 = SpannableString(" - (Shukla Paksham after amavasya to pournami  Krishna Paksham after pournami to amavasya)")
        Comment34.setSpan(AbsoluteSizeSpan(11, true), start, Comment34.length, exExFlag)
        Comment34.setSpan(StyleSpan(Typeface.ITALIC), start, Comment34.length, exExFlag)
        Comment34.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment34.length, exExFlag)

        val Body34AA = SpannableString("\nஅத்ய Thithiயாம் புண்யதிதௌ")
        val regexReplace11 = """(Thithi)""".toRegex()
        val Body34 = SpannableString(Body34AA.replace(regexReplace11, todThithi))
        Body34.setSpan(AbsoluteSizeSpan(14, true), start, Body34.length, exExFlag)
        Body34.setSpan(StyleSpan(Typeface.BOLD), start, Body34.length, exExFlag)
        Body34.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body34.length, exExFlag)

        val Comment35 = SpannableString(" - (15 tithis and repeats)")
        Comment35.setSpan(AbsoluteSizeSpan(11, true), start, Comment35.length, exExFlag)
        Comment35.setSpan(StyleSpan(Typeface.ITALIC), start, Comment35.length, exExFlag)
        Comment35.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment35.length, exExFlag)

        val Body35AA = SpannableString("\n வாஸரஹ weekDayவாஸர யுக்தாயாம்")
        val regexReplace12 = """(weekDay)""".toRegex()
        val Body35 = SpannableString(Body35AA.replace(regexReplace12, kizhamai))
        Body35.setSpan(AbsoluteSizeSpan(14, true), start, Body35.length, exExFlag)
        Body35.setSpan(StyleSpan(Typeface.BOLD), start, Body35.length, exExFlag)
        Body35.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body35.length, exExFlag)

        val Comment36 = SpannableString(" - (Sunday-பாநு, Monday-இந்து, Tuesday-பௌம, Wednesday-ஸௌம்ய, " +
                "Thursday-குரு, Friday-ப்ருகு, Saturday-ஸ்திர)")
        Comment36.setSpan(AbsoluteSizeSpan(11, true), start, Comment36.length, exExFlag)
        Comment36.setSpan(StyleSpan(Typeface.ITALIC), start, Comment36.length, exExFlag)
        Comment36.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment36.length, exExFlag)

        val Body36AA = SpannableString("\nnatchatram நக்ஷ்த்ர யுக்தாயாம்")
        val regexReplace13 = """(natchatram)""".toRegex()
        val Body36 = SpannableString(Body36AA.replace(regexReplace13, nachathirm))
        Body36.setSpan(AbsoluteSizeSpan(14, true), start, Body36.length, exExFlag)
        Body36.setSpan(StyleSpan(Typeface.BOLD), start, Body36.length, exExFlag)
        Body36.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body36.length, exExFlag)

        val Comment37 = SpannableString(" - (27 nakshatras)")
        Comment37.setSpan(AbsoluteSizeSpan(11, true), start, Comment37.length, exExFlag)
        Comment37.setSpan(StyleSpan(Typeface.ITALIC), start, Comment37.length, exExFlag)
        Comment37.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment37.length, exExFlag)

        val Body37AAA = SpannableString("\nYogam நாமயோக Karana கரண ஏவங்குண விசேஷேண விசிஷ்டாயாம் அஸ்யாம் Thithiயாம் புண்யதிதௌ")
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
        Comment38A.setSpan(AbsoluteSizeSpan(11, true), start, Comment38A.length, exExFlag)
        Comment38A.setSpan(StyleSpan(Typeface.ITALIC), start, Comment38A.length, exExFlag)
        Comment38A.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment38A.length, exExFlag)

        val RedComment1 = SpannableString("அபஸவ்யம்")
        RedComment1.setSpan(AbsoluteSizeSpan(13, true), start, RedComment1.length, exExFlag)
        RedComment1.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, RedComment1.length, exExFlag)
        RedComment1.setSpan(ForegroundColorSpan(Color.RED), start, RedComment1.length, exExFlag)

        val Comment38B = SpannableString(" செய்து கொண்டு தெற்குமுகமாக [முகம் மட்டுமாவது] இருந்து கூறவும்)")
        Comment38B.setSpan(AbsoluteSizeSpan(11, true), start, Comment38B.length, exExFlag)
        Comment38B.setSpan(StyleSpan(Typeface.ITALIC), start, Comment38B.length, exExFlag)
        Comment38B.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment38B.length, exExFlag)

        val Body38A = SpannableString("\n yourGothram கோத்ராணாம் அஸ்மத் ")
        val regexReplace17 = """(yourGothram)""".toRegex()
        val Body38 = SpannableString(Body38A.replace(regexReplace17, urGothram))
        Body38.setSpan(AbsoluteSizeSpan(14, true), start, Body38.length, exExFlag)
        Body38.setSpan(StyleSpan(Typeface.BOLD), start, Body38.length, exExFlag)
        Body38.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body38.length, exExFlag)

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

        val Sabathneek1 = SpannableString("ஸபத்நீகானாம் ")
        Sabathneek1.setSpan(AbsoluteSizeSpan(14, true), start, Sabathneek1.length, exExFlag)
        Sabathneek1.setSpan(StyleSpan(Typeface.BOLD), start, Sabathneek1.length, exExFlag)
        Sabathneek1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Sabathneek1.length, exExFlag)

        val MBody38A = SpannableString("\n\n motherSideGothram கோத்ராணாம் அஸ்மத் ")
        val MregexReplace17 = """(motherSideGothram)""".toRegex()
        val MBody38 = SpannableString(MBody38A.replace(MregexReplace17, mGothram))
        MBody38.setSpan(AbsoluteSizeSpan(14, true), start, MBody38.length, exExFlag)
        MBody38.setSpan(StyleSpan(Typeface.BOLD), start, MBody38.length, exExFlag)
        MBody38.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody38.length, exExFlag)

        val MSabathneek1 = SpannableString("ஸபத்நீகானாம் ")
        MSabathneek1.setSpan(AbsoluteSizeSpan(14, true), start, MSabathneek1.length, exExFlag)
        MSabathneek1.setSpan(StyleSpan(Typeface.BOLD), start, MSabathneek1.length, exExFlag)
        MSabathneek1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MSabathneek1.length, exExFlag)

        val MBody41BBB = SpannableString("மாதாமஹ, ப்ரமாதாமஹ, வ்ருத்தப்ரமாதாமஹாநாம் motherFather, motherGrandFather, " +
                "motherGreatGrandFather சர்மணாம் வஸூருத்ர ஆதித்ய ஸ்வரூபாணாம் உபயவம்ச பித்ருணாம் அக்ஷ்ய த்ருப்த்யர்த்தம் " +
                "\nThithi புண்யகாலே அஸ்மத் ")
        val MregexReplace21 = """(motherFather)""".toRegex()
        val MBody41BB = SpannableString(MBody41BBB.replace(MregexReplace21, MFNamee))
        val MregexReplace22 = """(motherGrandFather)""".toRegex()
        val MBody41BA = SpannableString(MBody41BB.replace(MregexReplace22, MGFNamee))
        val MregexReplace22A = """(motherGreatGrandFather)""".toRegex()
        val MBody41BAB = SpannableString(MBody41BA.replace(MregexReplace22A, mGGFNamee))
        val MregexReplace22AB = """(Thithi)""".toRegex()
        val MBody41B = SpannableString(MBody41BAB.replace(MregexReplace22AB, todThithi))
        MBody41B.setSpan(AbsoluteSizeSpan(14, true), start, MBody41B.length, exExFlag)
        MBody41B.setSpan(StyleSpan(Typeface.BOLD), start, MBody41B.length, exExFlag)
        MBody41B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody41B.length, exExFlag)

        val Body42 = SpannableString("சர்மணாம் வஸூருத்ர ஆதித்ய ஸ்வரூபாணாம் உபயவம்ச பித்ருணாம் ")
        Body42.setSpan(AbsoluteSizeSpan(14, true), start, Body42.length, exExFlag)
        Body42.setSpan(StyleSpan(Typeface.BOLD), start, Body42.length, exExFlag)
        Body42.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body42.length, exExFlag)

        val Body43A = SpannableString("அக்ஷ்ய த்ருப்த்யர்த்தம் Thithi புண்யகாலே அஸ்மத் ")
        val regexReplace23 = """(Thithi)""".toRegex()
        val Body43 = SpannableString(Body43A.replace(regexReplace23, todThithi))
        Body43.setSpan(AbsoluteSizeSpan(14, true), start, Body43.length, exExFlag)
        Body43.setSpan(StyleSpan(Typeface.BOLD), start, Body43.length, exExFlag)
        Body43.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body43.length, exExFlag)

        val Body44 = SpannableString("வர்கைக ")
        Body44.setSpan(AbsoluteSizeSpan(14, true), start, Body44.length, exExFlag)
        Body44.setSpan(StyleSpan(Typeface.BOLD), start, Body44.length, exExFlag)
        Body44.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body44.length, exExFlag)

        val MBody44 = SpannableString("வர்கத்வய ")
        MBody44.setSpan(AbsoluteSizeSpan(14, true), start, MBody44.length, exExFlag)
        MBody44.setSpan(StyleSpan(Typeface.BOLD), start, MBody44.length, exExFlag)
        MBody44.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody44.length, exExFlag)

        val Body45 = SpannableString("பித்ரூனு உத்திச்ய தர்சச்ராத்தம் திலதர்ப்பண ரூபணே அத்ய கர்ஷ்யே ")
        Body45.setSpan(AbsoluteSizeSpan(14, true), start, Body45.length, exExFlag)
        Body45.setSpan(StyleSpan(Typeface.BOLD), start, Body45.length, exExFlag)
        Body45.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body45.length, exExFlag)

        val Comment39 = SpannableString("\n(கையில் உள்ள தர்பங்களை போட்டுவிட்டு கிழக்கு முகமாக திருப்பி பூணுலை ")
        Comment39.setSpan(AbsoluteSizeSpan(11, true), start, Comment39.length, exExFlag)
        Comment39.setSpan(StyleSpan(Typeface.ITALIC), start, Comment39.length, exExFlag)
        Comment39.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment39.length, exExFlag)

        val GreenComment1 = SpannableString("ஸவ்யம் ")
        GreenComment1.setSpan(AbsoluteSizeSpan(14, true), start, GreenComment1.length, exExFlag)
        GreenComment1.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, GreenComment1.length, exExFlag)
        GreenComment1.setSpan(ForegroundColorSpan(Color.GREEN), start, GreenComment1.length, exExFlag)

        val Comment40 = SpannableString("செய்து கொண்டு கையை ஜலத்தால் அலம்பவும். தனக்கு எதிரில் ஒரு தாம்பாளத்தில் " +
                "கொஞ்சம் கட்டை தர்பங்களை கிழக்கு மேற்காக பரப்பி அதன்மேல் தெற்கு நுனியாக")
        Comment40.setSpan(AbsoluteSizeSpan(11, true), start, Comment40.length, exExFlag)
        Comment40.setSpan(StyleSpan(Typeface.ITALIC), start, Comment40.length, exExFlag)
        Comment40.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment40.length, exExFlag)

        val MComment40 = SpannableString(" இரண்டு ")
        MComment40.setSpan(AbsoluteSizeSpan(11, true), start, MComment40.length, exExFlag)
        MComment40.setSpan(StyleSpan(Typeface.ITALIC), start, MComment40.length, exExFlag)
        MComment40.setSpan(ForegroundColorSpan(Color.DKGRAY), start, MComment40.length, exExFlag)

        val Comment41 = SpannableString(" கூர்ச்ச(ம்)ங்களை வைத்து அதன் மேல் கட்டை தர்பங்கள் கொஞ்சம் போட்டு பூணூலை ")
        Comment41.setSpan(AbsoluteSizeSpan(11, true), start, Comment41.length, exExFlag)
        Comment41.setSpan(StyleSpan(Typeface.ITALIC), start, Comment41.length, exExFlag)
        Comment41.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment41.length, exExFlag)

        val RedComment2 = SpannableString("அபஸவ்யம் ")
        RedComment2.setSpan(AbsoluteSizeSpan(13, true), start, RedComment2.length, exExFlag)
        RedComment2.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, RedComment2.length, exExFlag)
        RedComment2.setSpan(ForegroundColorSpan(Color.RED), start, RedComment2.length, exExFlag)

        val Comment41A = SpannableString("செய்து கொண்டு")
        Comment41A.setSpan(AbsoluteSizeSpan(11, true), start, Comment41A.length, exExFlag)
        Comment41A.setSpan(StyleSpan(Typeface.ITALIC), start, Comment41A.length, exExFlag)
        Comment41A.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment41A.length, exExFlag)

        val Comment41B = SpannableString(" எள்ளை")
        Comment41B.setSpan(AbsoluteSizeSpan(11, true), start, Comment41B.length, exExFlag)
        Comment41B.setSpan(StyleSpan(Typeface.ITALIC), start, Comment41B.length, exExFlag)
        Comment41B.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment41B.length, exExFlag)

        val Comment41C = SpannableString(" எள்ளும், சிறிது அரிசியையும்")
        Comment41C.setSpan(AbsoluteSizeSpan(11, true), start, Comment41C.length, exExFlag)
        Comment41C.setSpan(StyleSpan(Typeface.ITALIC), start, Comment41C.length, exExFlag)
        Comment41C.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment41C.length, exExFlag)

        val Comment41D = SpannableString(" எடுத்துக் கொண்டு ஆவாஹநாதி தர்ப்பணம் செய்யவும்\n")
        Comment41D.setSpan(AbsoluteSizeSpan(11, true), start, Comment41D.length, exExFlag)
        Comment41D.setSpan(StyleSpan(Typeface.ITALIC), start, Comment41D.length, exExFlag)
        Comment41D.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment41D.length, exExFlag)

        val Heading3 = SpannableString("\nஆவாஹனம்-ஆஸனம்\n")
        Heading3.setSpan(AbsoluteSizeSpan(16, true), start, Heading3.length, exExFlag)
        Heading3.setSpan(StyleSpan(Typeface.BOLD), start, Heading3.length, exExFlag)
        Heading3.setSpan(UnderlineSpan(), start, Heading3.length, exExFlag)
        Heading3.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, Heading3.length, exExFlag)

        val Comment42 = SpannableString("பூணல்  ")
        Comment42.setSpan(AbsoluteSizeSpan(11, true), start, Comment42.length, exExFlag)
        Comment42.setSpan(StyleSpan(Typeface.ITALIC), start, Comment42.length, exExFlag)
        Comment42.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment42.length, exExFlag)

        val RedComment3 = SpannableString("அபஸவ்யம் ")
        RedComment3.setSpan(AbsoluteSizeSpan(13, true), start, RedComment3.length, exExFlag)
        RedComment3.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, RedComment3.length, exExFlag)
        RedComment3.setSpan(ForegroundColorSpan(Color.RED), start, RedComment3.length, exExFlag)

        val Comment42A = SpannableString("\n(மந்திரம்: ")
        Comment42A.setSpan(AbsoluteSizeSpan(11, true), start, Comment42A.length, exExFlag)
        Comment42A.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, Comment42A.length, exExFlag)
        Comment42A.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, Comment42A.length, exExFlag)

        val MComment42A = SpannableString("மேலண்டை ")
        MComment42A.setSpan(AbsoluteSizeSpan(11, true), start, MComment42A.length, exExFlag)
        MComment42A.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, MComment42A.length, exExFlag)
        MComment42A.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, MComment42A.length, exExFlag)

        val Comment42BOne = SpannableString("(ஒற்றை) கூர்ச்சம்: பிதாவர்கம்)")
        Comment42BOne.setSpan(AbsoluteSizeSpan(11, true), start, Comment42BOne.length, exExFlag)
        Comment42BOne.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, Comment42BOne.length, exExFlag)
        Comment42BOne.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, Comment42BOne.length, exExFlag)

        val Comment42B = SpannableString("கூர்ச்சம்: பிதாவர்கம்)")
        Comment42B.setSpan(AbsoluteSizeSpan(11, true), start, Comment42B.length, exExFlag)
        Comment42B.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, Comment42B.length, exExFlag)
        Comment42B.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, Comment42B.length, exExFlag)

        val Body46A = SpannableString("\nஓம் உசந்தஸ்த்வா நிதீமஹி உசந்த: ஸமீதீமஹி உசந்நு உசத: ஆவஹ " +
                "பித்ருன் ஹவிஷே அத்தவே yourGothram கோத்ரான் அஸ்மத் ")
        val regexReplace24 = """(yourGothram)""".toRegex()
        val Body46 = SpannableString(Body46A.replace(regexReplace24, urGothram))
        Body46.setSpan(AbsoluteSizeSpan(14, true), start, Body46.length, exExFlag)
        Body46.setSpan(StyleSpan(Typeface.BOLD), start, Body46.length, exExFlag)
        Body46.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body46.length, exExFlag)

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

        val MBody51BBBB = SpannableString("மாதாமஹ ப்ரமாதாமஹ வ்ருத்த ப்ரமாதாமஹான் motherFather, " +
                "motherGrandFather, motherGreatGrandFather சர்மணாம் வஸூருத்ர ஆதித்ய ஸ்வரூபான் அஸ்மின்கூர்ச்சே ஆவாஹயாமி \nஅவகீர்யா")
        val MregexReplace28 = """(motherFather)""".toRegex()
        val MBody51BBB = SpannableString(MBody51BBBB.replace(MregexReplace28, MFNamee))
        val MregexReplace29 = """(motherGrandFather)""".toRegex()
        val MBody51BB = SpannableString(MBody51BBB.replace(MregexReplace29, MGFNamee))
        val MregexReplace29A = """(motherGreatGrandFather)""".toRegex()
        val MBody51B = SpannableString(MBody51BB.replace(MregexReplace29A, mGGFNamee))
        MBody51B.setSpan(AbsoluteSizeSpan(14, true), start, MBody51B.length, exExFlag)
        MBody51B.setSpan(StyleSpan(Typeface.BOLD), start, MBody51B.length, exExFlag)
        MBody51B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")),start,MBody51B.length,exExFlag)

        val Body52 = SpannableString("சர்மணாம்  வஸூருத்ர ஆதித்ய ஸ்வரூபான் ")
        Body52.setSpan(AbsoluteSizeSpan(14, true), start, Body52.length, exExFlag)
        Body52.setSpan(StyleSpan(Typeface.BOLD), start, Body52.length, exExFlag)
        Body52.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body52.length, exExFlag)

        val MSabathneek2 = SpannableString(" ஸபத்நீகானாம் ")
        MSabathneek2.setSpan(AbsoluteSizeSpan(14, true), start, MSabathneek2.length, exExFlag)
        MSabathneek2.setSpan(StyleSpan(Typeface.BOLD), start, MSabathneek2.length, exExFlag)
        MSabathneek2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MSabathneek2.length, exExFlag)

        val Body52Add = SpannableString(" அஸ்மின்கூர்ச்சே ஆவாஹயாமி\nஅவகீர்யா")
        Body52Add.setSpan(AbsoluteSizeSpan(14, true), start, Body52Add.length, exExFlag)
        Body52Add.setSpan(StyleSpan(Typeface.BOLD), start, Body52Add.length, exExFlag)
        Body52Add.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body52Add.length, exExFlag)

        val MBody51CCCC = SpannableString("மாதாமஹ ப்ரமாதாமஹ வ்ருத்த ப்ரமாதாமஹாணாம் motherFather, " +
                "motherGrandFather, motherGreatGrandFather சர்மணாம் வஸூருத்ர ஆதித்ய ஸ்வரூபாணாம் அஸ்மின்கூர்ச்சே இதமாஸனம்")
        val miCregexRep28 = """(motherFather)""".toRegex()
        val MBody51CCC = SpannableString(MBody51CCCC.replace(miCregexRep28, MFNamee))
        val MCregexReplace29 = """(motherGrandFather)""".toRegex()
        val MBody51CC = SpannableString(MBody51CCC.replace(MCregexReplace29, MGFNamee))
        val MCregexReplace29A = """(motherGreatGrandFather)""".toRegex()
        val MBody51C = SpannableString(MBody51CC.replace(MCregexReplace29A, mGGFNamee))
        MBody51C.setSpan(AbsoluteSizeSpan(14, true), start, MBody51C.length, exExFlag)
        MBody51C.setSpan(StyleSpan(Typeface.BOLD), start, MBody51C.length, exExFlag)
        MBody51C.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody51C.length, exExFlag)

        val Comment43 = SpannableString("\nஎன்று எள்ளை கூர்சத்தின் மீது")
        Comment43.setSpan(AbsoluteSizeSpan(11, true), start, Comment43.length, exExFlag)
        Comment43.setSpan(StyleSpan(Typeface.ITALIC), start, Comment43.length, exExFlag)
        Comment43.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment43.length, exExFlag)

        val Comment44 = SpannableString("\nஎன்று எள்ளும், சிறிது அரிசியையும் கூர்சத்தின் மீது")
        Comment44.setSpan(AbsoluteSizeSpan(11, true), start, Comment44.length, exExFlag)
        Comment44.setSpan(StyleSpan(Typeface.ITALIC), start, Comment44.length, exExFlag)
        Comment44.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment44.length, exExFlag)

        val Comment45 = SpannableString(" போடவும்")
        Comment45.setSpan(AbsoluteSizeSpan(11, true), start, Comment45.length, exExFlag)
        Comment45.setSpan(StyleSpan(Typeface.ITALIC), start, Comment45.length, exExFlag)
        Comment45.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment45.length, exExFlag)

        val Comment45x = SpannableString(" போடவும்")
        Comment45x.setSpan(AbsoluteSizeSpan(11, true), start, Comment45x.length, exExFlag)
        Comment45x.setSpan(StyleSpan(Typeface.ITALIC), start, Comment45x.length, exExFlag)
        Comment45x.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment45x.length, exExFlag)

        val Heading4 = SpannableString("\nஆஸனமந்திரம்\n")
        Heading4.setSpan(AbsoluteSizeSpan(16, true), start, Heading4.length, exExFlag)
        Heading4.setSpan(StyleSpan(Typeface.BOLD), start, Heading4.length, exExFlag)
        Heading4.setSpan(UnderlineSpan(), start, Heading4.length, exExFlag)
        Heading4.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, Heading4.length, exExFlag)

        val MComment43 = SpannableString("\nஎன்று எள்ளை கூர்சத்தின் மீது" )
        MComment43.setSpan(AbsoluteSizeSpan(11, true), start, MComment43.length, exExFlag)
        MComment43.setSpan(StyleSpan(Typeface.ITALIC), start, MComment43.length, exExFlag)
        MComment43.setSpan(ForegroundColorSpan(Color.DKGRAY), start, MComment43.length, exExFlag)

        val MComment44 = SpannableString("\nஎள்ளும், சிறிது அரிசியையும்் கூர்சத்தின் மீது")
        MComment44.setSpan(AbsoluteSizeSpan(11, true), start, MComment44.length, exExFlag)
        MComment44.setSpan(StyleSpan(Typeface.ITALIC), start, MComment44.length, exExFlag)
        MComment44.setSpan(ForegroundColorSpan(Color.DKGRAY), start, MComment44.length, exExFlag)

        val MComment45 = SpannableString(" போடவும்)")
        MComment45.setSpan(AbsoluteSizeSpan(11, true), start, MComment45.length, exExFlag)
        MComment45.setSpan(StyleSpan(Typeface.ITALIC), start, MComment45.length, exExFlag)
        MComment45.setSpan(ForegroundColorSpan(Color.DKGRAY), start, MComment45.length, exExFlag)

        val MHeading4 = SpannableString("\nஆஸனமந்திரம்\n")
        MHeading4.setSpan(AbsoluteSizeSpan(16, true), start, MHeading4.length, exExFlag)
        MHeading4.setSpan(StyleSpan(Typeface.BOLD), start, MHeading4.length, exExFlag)
        MHeading4.setSpan(UnderlineSpan(), start, MHeading4.length, exExFlag)
        MHeading4.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, MHeading4.length, exExFlag)

        val Comment46 = SpannableString("\nஇரண்டு / மூன்று கட்டை தர்பங்களை எடுத்துக்கொண்டு")
        Comment46.setSpan(AbsoluteSizeSpan(11, true), start, Comment46.length, exExFlag)
        Comment46.setSpan(StyleSpan(Typeface.ITALIC), start, Comment46.length, exExFlag)
        Comment46.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment46.length, exExFlag)

        val MComment46 = SpannableString("\nஇரண்டு / மூன்று கட்டை தர்பங்களை எடுத்துக்கொண்டு")
        MComment46.setSpan(AbsoluteSizeSpan(11, true), start, MComment46.length, exExFlag)
        MComment46.setSpan(StyleSpan(Typeface.ITALIC), start, MComment46.length, exExFlag)
        MComment46.setSpan(ForegroundColorSpan(Color.DKGRAY), start, MComment46.length, exExFlag)

        val MComment46A = SpannableString("\nஇரண்டு / மூன்று கட்டை தர்பங்களை எடுத்துக்கொண்டு)")
        MComment46A.setSpan(AbsoluteSizeSpan(11, true), start, MComment46A.length, exExFlag)
        MComment46A.setSpan(StyleSpan(Typeface.ITALIC), start, MComment46A.length, exExFlag)
        MComment46A.setSpan(ForegroundColorSpan(Color.DKGRAY), start, MComment46A.length, exExFlag)

        val MComment46B = SpannableString("\nஎன்று கட்டை தர்பங்களை கூர்சத்தின் மீது போடவும்")
        MComment46B.setSpan(AbsoluteSizeSpan(11, true), start, MComment46B.length, exExFlag)
        MComment46B.setSpan(StyleSpan(Typeface.ITALIC), start, MComment46B.length, exExFlag)
        MComment46B.setSpan(ForegroundColorSpan(Color.DKGRAY), start, MComment46B.length, exExFlag)

        val MComment46x = SpannableString("\nஎன்று கட்டை தர்பங்களை கூர்சத்தின் மீது போடவும்)")
        MComment46x.setSpan(AbsoluteSizeSpan(11, true), start, MComment46x.length, exExFlag)
        MComment46x.setSpan(StyleSpan(Typeface.ITALIC), start, MComment46x.length, exExFlag)
        MComment46x.setSpan(ForegroundColorSpan(Color.DKGRAY), start, MComment46x.length, exExFlag)


        val Body53A = SpannableString("\nஓம் ஆயந்துந: பிதர: ஸோம்யாஸ: அக்னிஷ்வாத்தா: பதிபி: தேவயாநை: " +
                "\nஅஸ்மின்யக்ஞே ஸ்வதயாமதந்த: அதிப்ருவந்து தேவந்து அஸ்மான் yourGothram கோத்ராணாம் அஸ்மத் ")
        val regexReplace30 = """(yourGothram)""".toRegex()
        val Body53 = SpannableString(Body53A.replace(regexReplace30, urGothram))
        Body53.setSpan(AbsoluteSizeSpan(14, true), start, Body53.length, exExFlag)
        Body53.setSpan(StyleSpan(Typeface.BOLD), start, Body53.length, exExFlag)
        Body53.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body53.length, exExFlag)

        val MBody53A = SpannableString("\nஓம் ஆயந்துந: பிதர: ஸோம்யாஸ: அக்னிஷ்வாத்தா: பதிபி: தேவயாநை: " +
                "அஸ்மின்யக்ஞே ஸ்வதயாமதந்த: அதிப்ருவந்து தேவந்து அஸ்மான் motherSideGothram கோத்ராணாம் அஸ்மத் ")
        val MregexReplace30 = """(motherSideGothram)""".toRegex()
        val MBody53 = SpannableString(MBody53A.replace(MregexReplace30, mGothram))
        MBody53.setSpan(AbsoluteSizeSpan(14, true), start, MBody53.length, exExFlag)
        MBody53.setSpan(StyleSpan(Typeface.BOLD), start, MBody53.length, exExFlag)
        MBody53.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody53.length,exExFlag)

        val MSabathneek3 = SpannableString("ஸபத்நீகானாம் ")
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

        val Body60 = SpannableString("சர்மணாம் வஸூருத்ர ஆதித்ய ஸ்வரூபாணாம் ")
        Body60.setSpan(AbsoluteSizeSpan(14, true), start, Body60.length, exExFlag)
        Body60.setSpan(StyleSpan(Typeface.BOLD), start, Body60.length, exExFlag)
        Body60.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body60.length, exExFlag)

        val Sabathneek3 = SpannableString(" ஸபத்நீகானாம் ")
        Sabathneek3.setSpan(AbsoluteSizeSpan(14, true), start, Sabathneek3.length, exExFlag)
        Sabathneek3.setSpan(StyleSpan(Typeface.BOLD), start, Sabathneek3.length, exExFlag)
        Sabathneek3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Sabathneek3.length, exExFlag)

        val Body60Addnl = SpannableString(" அஸ்மின்கூர்ச்சே இதமாஸனம் ")
        Body60Addnl.setSpan(AbsoluteSizeSpan(14, true), start, Body60Addnl.length, exExFlag)
        Body60Addnl.setSpan(StyleSpan(Typeface.BOLD), start, Body60Addnl.length, exExFlag)
        Body60Addnl.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body60Addnl.length, exExFlag)

        val Comment47 = SpannableString("\nஎன்று கட்டை தர்பங்களை கூர்சத்தின் மீது போடவும்")
        Comment47.setSpan(AbsoluteSizeSpan(11, true), start, Comment47.length, exExFlag)
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
        Comment48.setSpan(AbsoluteSizeSpan(11, true), start, Comment48.length, exExFlag)
        Comment48.setSpan(StyleSpan(Typeface.ITALIC), start, Comment48.length, exExFlag)
        Comment48.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment48.length, exExFlag)

        val Comment48x = SpannableString("\nஎன்று எள்ளை")
        Comment48x.setSpan(AbsoluteSizeSpan(11, true), start, Comment48x.length, exExFlag)
        Comment48x.setSpan(StyleSpan(Typeface.ITALIC), start, Comment48x.length, exExFlag)
        Comment48x.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment48x.length, exExFlag)

        val Comment49 = SpannableString("\nஎன்று எள்ளும், சிறிது அரிசியையும்")
        Comment49.setSpan(AbsoluteSizeSpan(11, true), start, Comment49.length, exExFlag)
        Comment49.setSpan(StyleSpan(Typeface.ITALIC), start, Comment49.length, exExFlag)
        Comment49.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment49.length, exExFlag)

        val Comment49x = SpannableString("\nஎன்று எள்ளும், சிறிது அரிசியையும்")
        Comment49x.setSpan(AbsoluteSizeSpan(11, true), start, Comment49x.length, exExFlag)
        Comment49x.setSpan(StyleSpan(Typeface.ITALIC), start, Comment49x.length, exExFlag)
        Comment49x.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment49x.length, exExFlag)

        val Comment50 = SpannableString(" கூர்சத்தின் மீது போடவும்)")
        Comment50.setSpan(AbsoluteSizeSpan(11, true), start, Comment50.length, exExFlag)
        Comment50.setSpan(StyleSpan(Typeface.ITALIC), start, Comment50.length, exExFlag)
        Comment50.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment50.length, exExFlag)

        val Comment50x = SpannableString("யும் கூர்சத்தின் மீது போடவும்)")
        Comment50x.setSpan(AbsoluteSizeSpan(11, true), start, Comment50x.length, exExFlag)
        Comment50x.setSpan(StyleSpan(Typeface.ITALIC), start, Comment50x.length, exExFlag)
        Comment50x.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment50x.length, exExFlag)

        val MSComment42A = SpannableString("\n(மந்திரம்: ")
        MSComment42A.setSpan(AbsoluteSizeSpan(16, true), start, MSComment42A.length, exExFlag)
        MSComment42A.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, MSComment42A.length, exExFlag)
        MSComment42A.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, MSComment42A.length, exExFlag)

        val MSEComment42A = SpannableString("கீழ்")
        MSEComment42A.setSpan(AbsoluteSizeSpan(16, true), start, MSEComment42A.length, exExFlag)
        MSEComment42A.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, MSEComment42A.length, exExFlag)
        MSEComment42A.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, MSEComment42A.length, exExFlag)

        val MComment42B = SpannableString("கூர்ச்சம்: மாதாமஹவர்கம்)")
        MComment42B.setSpan(AbsoluteSizeSpan(16, true), start, MComment42B.length, exExFlag)
        MComment42B.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, MComment42B.length, exExFlag)
        MComment42B.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")),start,MComment42B.length,exExFlag )

        val MComment42C = SpannableString("\nஆவாஹனம்")
        MComment42C.setSpan(AbsoluteSizeSpan(16, true), start, MComment42C.length, exExFlag)
        MComment42C.setSpan(StyleSpan(Typeface.BOLD), start, MComment42C.length, exExFlag)
        MComment42C.setSpan(UnderlineSpan(), start, MComment42C.length, exExFlag)
        MComment42C.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")),start, MComment42C.length,exExFlag)

        val MBody46A = SpannableString("\nஓம் உசந்தஸ்த்வா நிதீமஹி உசந்த: ஸமீதீமஹி உசந்நு உசத: ஆவஹ பித்ருன்னு ஹவிஷே அத்தவே motherSideGothram கோத்ரான் அஸ்மத் ")
        val MregexReplace24 = """(motherSideGothram)""".toRegex()
        val MBody46 = SpannableString(MBody46A.replace(MregexReplace24, mGothram))
        MBody46.setSpan(AbsoluteSizeSpan(14, true), start, MBody46.length, exExFlag)
        MBody46.setSpan(StyleSpan(Typeface.BOLD), start, MBody46.length, exExFlag)
        MBody46.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")),start, MBody46.length,exExFlag)

        val Sabathneek2 = SpannableString("ஸபத்நீகானாம் ")
        Sabathneek2.setSpan(AbsoluteSizeSpan(14, true), start, Sabathneek2.length, exExFlag)
        Sabathneek2.setSpan(StyleSpan(Typeface.BOLD), start, Sabathneek2.length, exExFlag)
        Sabathneek2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")),start,Sabathneek2.length,exExFlag)

        val Comment43x = SpannableString("\nஎன்று எள்ளை")
        Comment43x.setSpan(AbsoluteSizeSpan(11, true), start, Comment43x.length, exExFlag)
        Comment43x.setSpan(StyleSpan(Typeface.ITALIC), start, Comment43x.length, exExFlag)
        Comment43x.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment43x.length, exExFlag)

        val Comment44x = SpannableString("\nஎன்று எள்ளும், சிறிது அரிசியையும்")
        Comment44x.setSpan(AbsoluteSizeSpan(11, true), start, Comment44x.length, exExFlag)
        Comment44x.setSpan(StyleSpan(Typeface.ITALIC), start, Comment44x.length, exExFlag)
        Comment44x.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment44x.length, exExFlag)

        val MComment42D = SpannableString("\nஆவாஹனம்")
        MComment42D.setSpan(AbsoluteSizeSpan(16, true), start, MComment42D.length, exExFlag)
        MComment42D.setSpan(StyleSpan(Typeface.BOLD), start, MComment42D.length, exExFlag)
        MComment42D.setSpan(UnderlineSpan(), start, MComment42D.length, exExFlag)
        MComment42D.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, MComment42D.length, exExFlag)

//**************************************************************************************************************

        val Heading5 = SpannableString("\n\nபித்ருவர்கம் - பிதாவர்க்கம் \n(மேல் கூர்ச்சம்)")
        Heading5.setSpan(AbsoluteSizeSpan(16, true), start, Heading5.length, exExFlag)
        Heading5.setSpan(StyleSpan(Typeface.BOLD), start, Heading5.length, exExFlag)
        Heading5.setSpan(UnderlineSpan(), start, Heading5.length, exExFlag)
        Heading5.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, Heading5.length, exExFlag)

        val Heading5Add = SpannableString("\n\nபித்ருவர்கம் - பிதாவர்க்கம் ")
        Heading5Add.setSpan(AbsoluteSizeSpan(16, true), start, Heading5Add.length, exExFlag)
        Heading5Add.setSpan(StyleSpan(Typeface.BOLD), start, Heading5Add.length, exExFlag)
        Heading5Add.setSpan(UnderlineSpan(), start, Heading5Add.length, exExFlag)
        Heading5Add.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, Heading5Add.length, exExFlag)

        val Body62A = SpannableString("\n1.a.   ஓம் உதீரதாம் அவரே உத்பராஸ: உந்மத்யமா: பிதர: ஸோம்யாஸ: அஸூம்யஈயு: " +
                "அவ்ருகா: ருதக்ஞா: தேநோவந்து பிதரோஹவேஷூ yourGothram கோத்ர: அஸ்மத் பிதா ")
        val regexReplace36 = """(yourGothram)""".toRegex()
        val Body62 = SpannableString(Body62A.replace(regexReplace36, urGothram))
        Body62.setSpan(AbsoluteSizeSpan(14, true), start, Body62.length, exExFlag)
        Body62.setSpan(StyleSpan(Typeface.BOLD), start, Body62.length, exExFlag)
        Body62.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body62.length, exExFlag)

        val Body63New = SpannableString(" yourFatherName சர்மா வஸூரூப: ")
        val regexReplace37 = """(yourFatherName)""".toRegex()
        val Body63 = SpannableString(Body63New.replace(regexReplace37, yrFNamee))
        Body63.setSpan(AbsoluteSizeSpan(14, true), start, Body63.length, exExFlag)
        Body63.setSpan(StyleSpan(Typeface.BOLD), start, Body63.length, exExFlag)
        Body63.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body63.length, exExFlag)

        val Sabathneek4 = SpannableString("ஸபத்நீக:")
        Sabathneek4.setSpan(AbsoluteSizeSpan(14, true), start, Sabathneek4.length, exExFlag)
        Sabathneek4.setSpan(StyleSpan(Typeface.BOLD), start, Sabathneek4.length, exExFlag)
        Sabathneek4.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Sabathneek4.length, exExFlag)

        val Body64AA = SpannableString("  ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\n1.b.   ஓம் அங்கீரஸோந: பிதரோ நவக்வா: அதர்வாண: ப்ருகவ: ஸோம்யாஸ: தேஷாம்வயம் ஸூமதௌ யக்ஞியாநாம் அபிபத்ரே " +
                "ஸௌமனஸே ஸ்யாம yourGothram கோத்ர: அஸ்மத் பிதா ")
        val regexReplace38 = """(yourGothram)""".toRegex()
        val Body64 = SpannableString(Body64AA.replace(regexReplace38, urGothram))
        Body64.setSpan(AbsoluteSizeSpan(14, true), start, Body64.length, exExFlag)
        Body64.setSpan(StyleSpan(Typeface.BOLD), start, Body64.length, exExFlag)
        Body64.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body64.length, exExFlag)

        val Body65New = SpannableString(" yourFatherName சர்மா வஸூரூப: ")
        val regexReplace39 = """(yourFatherName)""".toRegex()
        val Body65 = SpannableString(Body65New.replace(regexReplace39, yrFNamee))
        Body65.setSpan(AbsoluteSizeSpan(14, true), start, Body65.length, exExFlag)
        Body65.setSpan(StyleSpan(Typeface.BOLD), start, Body65.length, exExFlag)
        Body65.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body65.length, exExFlag)

        val Sabathneek5 = SpannableString("ஸபத்நீக: ")
        Sabathneek5.setSpan(AbsoluteSizeSpan(14, true), start, Sabathneek5.length, exExFlag)
        Sabathneek5.setSpan(StyleSpan(Typeface.BOLD), start, Sabathneek5.length, exExFlag)
        Sabathneek5.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Sabathneek5.length, exExFlag)

        val Body66AA = SpannableString("  ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\n1.c.   ஓம் ஆயந்துந: பிதர: ஸோம்யாஸ: அக்னிஷ்வாத்தா: பதிபி: தேவயானை: அஸ்மின் யக்ஞே ஸ்வதயா மதந்த: அதிப்ருவந்து " +
                "தேவந்து அஸ்மான் yourGothram கோத்ர: அஸ்மத் பிதா ")
        val regexReplace40 = """(yourGothram)""".toRegex()
        val Body66 = SpannableString(Body66AA.replace(regexReplace40, urGothram))
        Body66.setSpan(AbsoluteSizeSpan(14, true), start, Body66.length, exExFlag)
        Body66.setSpan(StyleSpan(Typeface.BOLD), start, Body66.length, exExFlag)
        Body66.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body66.length, exExFlag)

        val Body67New = SpannableString("yourFatherName சர்மா வஸூரூப: ")
        val regexReplace41 = """(yourFatherName)""".toRegex()
        val Body67 = SpannableString(Body67New.replace(regexReplace41, yrFNamee))
        Body67.setSpan(AbsoluteSizeSpan(14, true), start, Body67.length, exExFlag)
        Body67.setSpan(StyleSpan(Typeface.BOLD), start, Body67.length, exExFlag)
        Body67.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body67.length, exExFlag)

        val Sabathneek6 = SpannableString("ஸபத்நீக: ")
        Sabathneek6.setSpan(AbsoluteSizeSpan(14, true), start, Sabathneek6.length, exExFlag)
        Sabathneek6.setSpan(StyleSpan(Typeface.BOLD), start, Sabathneek6.length, exExFlag)
        Sabathneek6.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Sabathneek6.length, exExFlag)

        val Body68 = SpannableString("ஸ்வதாநம: த்ருப்யதாம்.")
        Body68.setSpan(AbsoluteSizeSpan(14, true), start, Body68.length, exExFlag)
        Body68.setSpan(StyleSpan(Typeface.BOLD), start, Body68.length, exExFlag)
        Body68.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body68.length, exExFlag)

        val Body69A = SpannableString("\n\n2.a.    ஓம் ஊர்ஜம் வஹந்தி: அம்ருதம்க்ருதம் பய:கீலாலம் பரிஸ்ருதம் ஸ்வதாஸ்த " +
                "தர்பயதமே பித்ருன் yourGothram கோத்ர: அஸ்மத் ")
        val regexReplace42 = """(yourGothram)""".toRegex()
        val Body69 = SpannableString(Body69A.replace(regexReplace42, urGothram))
        Body69.setSpan(AbsoluteSizeSpan(14, true), start, Body69.length, exExFlag)
        Body69.setSpan(StyleSpan(Typeface.BOLD), start, Body69.length, exExFlag)
        Body69.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body69.length, exExFlag)

        val Body70ANew = SpannableString(" பிதாமஹ: yourGrandFatherName சர்மா ருத்ரரூப: ")
        val regexReplace43 = """(yourGrandFatherName)""".toRegex()
        val Body70A = SpannableString(Body70ANew.replace(regexReplace43, yrGFNamee))
        Body70A.setSpan(AbsoluteSizeSpan(14, true), start, Body70A.length, exExFlag)
        Body70A.setSpan(StyleSpan(Typeface.BOLD), start, Body70A.length, exExFlag)
        Body70A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body70A.length, exExFlag)

        val Body70BNew = SpannableString(" ப்ரபிதாமஹ: yourGreatGrandFatherName சர்மா ருத்ரரூப: ")
        val regexReplace45 = """(yourGreatGrandFatherName)""".toRegex()
        val Body70B = SpannableString(Body70BNew.replace(regexReplace45, yrGGFNamee))
        Body70B.setSpan(AbsoluteSizeSpan(14, true), start, Body70B.length, exExFlag)
        Body70B.setSpan(StyleSpan(Typeface.BOLD), start, Body70B.length, exExFlag)
        Body70B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body70B.length, exExFlag)

        val Sabathneek7 = SpannableString("ஸபத்நீக: ")
        Sabathneek7.setSpan(AbsoluteSizeSpan(14, true), start, Sabathneek7.length, exExFlag)
        Sabathneek7.setSpan(StyleSpan(Typeface.BOLD), start, Sabathneek7.length, exExFlag)
        Sabathneek7.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Sabathneek7.length, exExFlag)

        val Body71AA = SpannableString("ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\n2.b.   ஓம் பித்ருப்ய: ஸ்வாதாயிப்ய: ஸ்வாதாநம: பிதாமஹேப்ய: ஸ்வதாயிப்ய: ஸ்வதாநம: ப்ரபிதாமஹேப்ய: ஸ்வதாயிப்ய: " +
                "ஸ்வாதாநம: yourGothram கோத்ர: அஸ்மத் பிதாமஹ: yourGrandFatherName சர்மா ருத்ரரூப: ")
        val regexReplace44 = """(yourGothram)""".toRegex()
        val Body71A = SpannableString(Body71AA.replace(regexReplace44, urGothram))
        val regexReplace47 = """(yourGrandFatherName)""".toRegex()
        val Body71 = SpannableString(Body71A.replace(regexReplace47, yrGFNamee))
        Body71.setSpan(AbsoluteSizeSpan(14, true), start, Body71.length, exExFlag)
        Body71.setSpan(StyleSpan(Typeface.BOLD), start, Body71.length, exExFlag)
        Body71.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body71.length, exExFlag)

        val Body72AA = SpannableString(" ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\n2.b.   ஓம் பித்ருப்ய: ஸ்வாதாயிப்ய: ஸ்வாதாநம: பிதாமஹேப்ய: ஸ்வதாயிப்ய: ஸ்வதாநம: ப்ரபிதாமஹேப்ய: ஸ்வதாயிப்ய: " +
                "ஸ்வாதாநம: yourGothram கோத்ர: அஸ்மத் ப்ரபிதாமஹ: yourGreatGrandFatherName சர்மா ருத்ரரூப: ")
        val regexReplace46 = """(yourGothram)""".toRegex()
        val Body72A = SpannableString(Body72AA.replace(regexReplace46, urGothram))
        val regexReplace47New = """(yourGrandFatherName)""".toRegex()
        val Body72 = SpannableString(Body72A.replace(regexReplace47New, yrGGFNamee))
        Body72.setSpan(AbsoluteSizeSpan(14, true), start, Body72.length, exExFlag)
        Body72.setSpan(StyleSpan(Typeface.BOLD), start, Body72.length, exExFlag)
        Body72.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body72.length, exExFlag)

        val Sabathneek8 = SpannableString("ஸபத்நீக: ")
        Sabathneek8.setSpan(AbsoluteSizeSpan(14, true), start, Sabathneek8.length, exExFlag)
        Sabathneek8.setSpan(StyleSpan(Typeface.BOLD), start, Sabathneek8.length, exExFlag)
        Sabathneek8.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Sabathneek8.length, exExFlag)
        /*
                val Body73A = SpannableString(" பிதாமஹ: ")
                Body73A.setSpan(AbsoluteSizeSpan(14, true), start, Body73A.length, exExFlag)
                Body73A.setSpan(StyleSpan(Typeface.BOLD), start, Body73A.length, exExFlag)
                Body73A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body73A.length, exExFlag)

                val Body73B = SpannableString(" ப்ரபிதாமஹான்னு: ")
                Body73B.setSpan(AbsoluteSizeSpan(14, true), start, Body73B.length, exExFlag)
                Body73B.setSpan(StyleSpan(Typeface.BOLD), start, Body73B.length, exExFlag)
                Body73B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body73B.length, exExFlag)

            val Body74AA = SpannableString("yourGrandFatherName சர்மா ருத்ரரூப: ")

            Body74.setSpan(AbsoluteSizeSpan(14, true), start, Body74.length, exExFlag)
            Body74.setSpan(StyleSpan(Typeface.BOLD), start, Body74.length, exExFlag)
            Body74.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body74.length, exExFlag)
        */

        val Body74AA = SpannableString(" ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\n2.c.   ஓம் யேசேஹபிதர: யேசநேஹ யாங்குச்ச வித்மயான் ஊசன ப்ரவித்ம த்வம்வேத்த யதிதே ஜாதவேத: ஸ்வதாபி: யக்ஞம் " +
                "ஸூக்ருதம் ஜூஷஸ்வ yourGothram கோத்ர: அஸ்மத் பிதாமஹ: yourGrandFatherName சர்மா ருத்ரரூப: ")
        val regexReplace48 = """(yourGothram)""".toRegex()
        val Body74A = SpannableString(Body74AA.replace(regexReplace48, urGothram))
        val regexReplace51 = """(yourGrandFatherName)""".toRegex()
        val Body74 = SpannableString(Body74A.replace(regexReplace51, yrGFNamee))
        Body74.setSpan(AbsoluteSizeSpan(14, true), start, Body74.length, exExFlag)
        Body74.setSpan(StyleSpan(Typeface.BOLD), start, Body74.length, exExFlag)
        Body74.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body74.length, exExFlag)

        val Body75AA = SpannableString(" ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\n2.c.   ஓம் யேசேஹபிதர: யேசநேஹ யாங்குச்ச வித்மயான் ஊசன ப்ரவித்ம த்வம்வேத்த யதிதே ஜாதவேத: ஸ்வதாபி: யக்ஞம் " +
                "ஸூக்ருதம் ஜூஷஸ்வ yourGothram கோத்ர: அஸ்மத் ப்ரபிதாமஹ: yourGreatGrandFatherName சர்மா ருத்ரரூப: ")
        val regexReplace48x = """(yourGothram)""".toRegex()
        val Body75A = SpannableString(Body75AA.replace(regexReplace48x, urGothram))
        val regexReplace49 = """(yourGreatGrandFatherName)""".toRegex()
        val Body75 = SpannableString(Body75A.replace(regexReplace49, yrGGFNamee))
        Body75.setSpan(AbsoluteSizeSpan(14, true), start, Body75.length, exExFlag)
        Body75.setSpan(StyleSpan(Typeface.BOLD), start, Body75.length, exExFlag)
        Body75.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body75.length, exExFlag)

        val Sabathneek9 = SpannableString("ஸபத்நீக: ")
        Sabathneek9.setSpan(AbsoluteSizeSpan(14, true), start, Sabathneek9.length, exExFlag)
        Sabathneek9.setSpan(StyleSpan(Typeface.BOLD), start, Sabathneek9.length, exExFlag)
        Sabathneek9.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Sabathneek9.length, exExFlag)
        /*
           val Body75AANew = SpannableString(" ஸ்வதாநம: த்ருப்யதாம்.\n" +
                   "\n2.c.   ஓம் யேசேஹபிதர: யேசநேஹ யாங்குச்ச வித்மயான் ஊசன ப்ரவித்ம த்வம்வேத்த யதிதே ஜாதவேத: ஸ்வதாபி: யக்ஞம் " +
                   "ஸூக்ருதம் ஜூஷஸ்வ yourGothram கோத்ர: அஸ்மத் ")
           val regexReplace50New = """(yourGothram)""".toRegex()
           val Body75New = SpannableString(Body75AANew.replace(regexReplace50New, urGothram))
           Body75New.setSpan(AbsoluteSizeSpan(14, true), start, Body75New.length, exExFlag)
           Body75New.setSpan(StyleSpan(Typeface.BOLD), start, Body75New.length, exExFlag)
           Body75New.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body75New.length, exExFlag)

           val Sabathneek9New = SpannableString("ஸபத்நீக:")
           Sabathneek9New.setSpan(AbsoluteSizeSpan(14, true), start, Sabathneek9New.length, exExFlag)
           Sabathneek9New.setSpan(StyleSpan(Typeface.BOLD), start, Sabathneek9New.length, exExFlag)
           Sabathneek9New.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Sabathneek9New.length, exExFlag)

           val Body76A = SpannableString(" பிதாமஹ: ")
               Body76A.setSpan(AbsoluteSizeSpan(14, true), start, Body76A.length, exExFlag)
               Body76A.setSpan(StyleSpan(Typeface.BOLD), start, Body76A.length, exExFlag)
               Body76A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body76A.length, exExFlag)

               val Body76B = SpannableString(" ப்ரபிதாமஹான்னு: ")
               Body76B.setSpan(AbsoluteSizeSpan(14, true), start, Body76B.length, exExFlag)
               Body76B.setSpan(StyleSpan(Typeface.BOLD), start, Body76B.length, exExFlag)
               Body76B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body76B.length, exExFlag)
       */
        val Body77AA = SpannableString(" ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\n3.a.    ஓம் மதுவாதா: ருதாயதே மதுக்ஷரந்தி ஸிந்தவ: மாத்வீர்ந: ஸந்து ஓஷதீ: " +
                "yourGothram கோத்ர: அஸ்மத் ப்ரபிதாமஹ: yourGreatGrandFatherName சர்மா ஆதித்யரூப: ")
        val regexReplace52 = """(yourGothram)""".toRegex()
        val Body77A = SpannableString(Body77AA.replace(regexReplace52, urGothram))
        val regexReplace53 = """(yourGreatGrandFatherName)""".toRegex()
        val Body77 = SpannableString(Body77A.replace(regexReplace53, yrGGFNamee))
        Body77.setSpan(AbsoluteSizeSpan(14, true), start, Body77.length, exExFlag)
        Body77.setSpan(StyleSpan(Typeface.BOLD), start, Body77.length, exExFlag)
        Body77.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body77.length, exExFlag)

        val Body78AA = SpannableString(" ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\n3.a.    ஓம் மதுவாதா: ருதாயதே மதுக்ஷரந்தி ஸிந்தவ: மாத்வீர்ந: ஸந்து ஓஷதீ: yourGothram கோத்ர: " +
                "அஸ்மத் வ்ருத்தப்ரபிதாமஹ: yourGreatGreatGrandFatherName சர்மா ஆதித்யரூப: ")
        val regexReplace54 = """(yourGothram)""".toRegex()
        val Body78A = SpannableString(Body78AA.replace(regexReplace54, urGothram))
        val regexReplace55 = """(yourGreatGrandFatherName)""".toRegex()
        val Body78 = SpannableString(Body78A.replace(regexReplace55, yrGGFNamee))
        Body78.setSpan(AbsoluteSizeSpan(14, true), start, Body78.length, exExFlag)
        Body78.setSpan(StyleSpan(Typeface.BOLD), start, Body78.length, exExFlag)
        Body78.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body78.length, exExFlag)

        val Sabathneek10 = SpannableString("ஸபத்நீக: ")
        Sabathneek10.setSpan(AbsoluteSizeSpan(14, true), start, Sabathneek10.length, exExFlag)
        Sabathneek10.setSpan(StyleSpan(Typeface.BOLD), start, Sabathneek10.length, exExFlag)
        Sabathneek10.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Sabathneek10.length, exExFlag)

        val Body80AA = SpannableString(" ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\n3.b.  ஓம் மதுநக்தம் உதோஷஸ: மதுமத் பார்த்தீவம் ரஜ: மதுத்யௌ: அஸ்துந: பிதா yourGothram கோத்ர: அஸ்மத் ப்ரபிதாமஹ: yourGreatGrandFatherName சர்மா ஆதித்யரூப: ")
        val regexReplace52New = """(yourGothram)""".toRegex()
        val Body80A = SpannableString(Body80AA.replace(regexReplace52New, urGothram))
        val regexReplace53New = """(yourGreatGrandFatherName)""".toRegex()
        val Body80 = SpannableString(Body80A.replace(regexReplace53New, yrGGFNamee))
        Body80.setSpan(AbsoluteSizeSpan(14, true), start, Body80.length, exExFlag)
        Body80.setSpan(StyleSpan(Typeface.BOLD), start, Body80.length, exExFlag)
        Body80.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body80.length, exExFlag)

        val Body81AA = SpannableString("ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\n3.b.  ஓம் மதுநக்தம் உதோஷஸ: மதுமத் பார்த்தீவம் ரஜ: மதுத்யௌ: அஸ்துந: பிதா yourGothram கோத்ர: அஸ்மத் வ்ருத்தப்ரபிதாமஹ: yourGreatGreatGrandFatherName சர்மா ஆதித்யரூப: ")
        val regexReplace57 = """(yourGothram)""".toRegex()
        val Body81A = SpannableString(Body81AA.replace(regexReplace57, urGothram))
        val regexReplace58 = """(yourGreatGreatGrandFatherName)""".toRegex()
        val Body81 = SpannableString(Body81A.replace(regexReplace58, yrGGGFNamee))
        Body81.setSpan(AbsoluteSizeSpan(14, true), start, Body81.length, exExFlag)
        Body81.setSpan(StyleSpan(Typeface.BOLD), start, Body81.length, exExFlag)
        Body81.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body81.length, exExFlag)

        val Sabathneek11 = SpannableString("ஸபத்நீக: ")
        Sabathneek11.setSpan(AbsoluteSizeSpan(14, true), start, Sabathneek11.length, exExFlag)
        Sabathneek11.setSpan(StyleSpan(Typeface.BOLD), start, Sabathneek11.length, exExFlag)
        Sabathneek11.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Sabathneek11.length, exExFlag)

        val Body83AA = SpannableString(" ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\n3.c.  ஓம் மதுமாந்த: வநஸ்பதி: மதுமாந் அஸ்துஸூர்ய: மாத்வீர்காவ: பவந்துந: yourGothram கோத்ர: அஸ்மத் ப்ரபிதாமஹ: yourGreatGrandFatherName சர்மா ஆதித்யரூப: ")
        val regexReplace59 = """(yourGothram)""".toRegex()
        val Body83A = SpannableString(Body83AA.replace(regexReplace59, urGothram))
        val regexReplace60 = """(yourGreatGrandFatherName)""".toRegex()
        val Body83 = SpannableString(Body83A.replace(regexReplace60, yrGGFNamee))
        Body83.setSpan(AbsoluteSizeSpan(14, true), start, Body83.length, exExFlag)
        Body83.setSpan(StyleSpan(Typeface.BOLD), start, Body83.length, exExFlag)
        Body83.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body83.length, exExFlag)

        val Body84AA = SpannableString(" ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\n3.c.  ஓம் மதுமாந்த: வநஸ்பதி: மதுமாந் அஸ்துஸூர்ய: மாத்வீர்காவ: பவந்துந: yourGothram கோத்ர: அஸ்மத் வ்ருத்தப்ரபிதாமஹ: yourGreatGreatGrandFatherName சர்மா ஆதித்யரூப: ")
        val regexReplace61 = """(yourGothram)""".toRegex()
        val Body84A = SpannableString(Body84AA.replace(regexReplace61, urGothram))
        val regexReplace62 = """(yourGreatGreatGrandFatherName)""".toRegex()
        val Body84 = SpannableString(Body84A.replace(regexReplace62, yrGGGFNamee))
        Body84.setSpan(AbsoluteSizeSpan(14, true), start, Body84.length, exExFlag)
        Body84.setSpan(StyleSpan(Typeface.BOLD), start, Body84.length, exExFlag)
        Body84.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body84.length, exExFlag)

        val Sabathneek12 = SpannableString("ஸபத்நீக: ")
        Sabathneek12.setSpan(AbsoluteSizeSpan(14, true), start, Sabathneek12.length, exExFlag)
        Sabathneek12.setSpan(StyleSpan(Typeface.BOLD), start, Sabathneek12.length, exExFlag)
        Sabathneek12.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Sabathneek12.length, exExFlag)

        val Body86 = SpannableString(" ஸ்வதாநம: த்ருப்யதாம்.\nத்ருப்யத்வம்     த்ருப்யத்வம்     த்ருப்யத்வம்")
        Body86.setSpan(AbsoluteSizeSpan(14, true), start, Body86.length, exExFlag)
        Body86.setSpan(StyleSpan(Typeface.BOLD), start, Body86.length, exExFlag)
        Body86.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body86.length, exExFlag)
//***************************************************************************************************

        val MHeading5 = SpannableString("\n\nகீழ்கூர்ச்சம் : மாதாமஹவர்கம்\n")
        MHeading5.setSpan(AbsoluteSizeSpan(16, true), start, MHeading5.length, exExFlag)
        MHeading5.setSpan(StyleSpan(Typeface.BOLD), start, MHeading5.length, exExFlag)
        MHeading5.setSpan(UnderlineSpan(), start, MHeading5.length, exExFlag)
        MHeading5.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, MHeading5.length, exExFlag)

        val MBody62A = SpannableString("\nI.a.   ஓம் உதீரதாம் அவரே உத்பராஸ: உந்மத்யமா: பிதர: ஸோம்யாஸ: அஸூம்யஈயு: " +
                "அவ்ருகா: ருதக்ஞா: தேநோவந்து பிதரோஹவேஷூ motherSideGothram கோத்ர: அஸ்மத் ")
        val MregexReplace36 = """(motherSideGothram)""".toRegex()
        val MBody62 = SpannableString(MBody62A.replace(MregexReplace36, mGothram))
        MBody62.setSpan(AbsoluteSizeSpan(14, true), start, MBody62.length, exExFlag)
        MBody62.setSpan(StyleSpan(Typeface.BOLD), start, MBody62.length, exExFlag)
        MBody62.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody62.length, exExFlag)

        val MSabathneek4 = SpannableString("ஸபத்நீக:")
        MSabathneek4.setSpan(AbsoluteSizeSpan(14, true), start, MSabathneek4.length, exExFlag)
        MSabathneek4.setSpan(StyleSpan(Typeface.BOLD), start, MSabathneek4.length, exExFlag)
        MSabathneek4.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MSabathneek4.length, exExFlag)

        val MBody63AA = SpannableString(" மாதாமஹ: motherFather  சர்மா வஸூரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\nI.b.  ஓம் அங்கீரஸோந: பிநரோ நவக்வா: அதர்வாண: ப்ருகவ: ஸோம்யாஸ: தேஷாம்வயம் ஸூமதௌ யக்ஞியாநாம் அபிபத்ரே " +
                "ஸௌமனஸே ஸ்யாம motherSideGothram கோத்ர: அஸ்மத் ")
        val MregexMFN = """(motherFather)""".toRegex()
        val MBody63A = SpannableString(MBody63AA.replace(MregexMFN, MFNamee))
        val MregexGothram = """(motherSideGothram)""".toRegex()
        val MBody63 = SpannableString(MBody63A.replace(MregexGothram, mGothram))
        MBody63.setSpan(AbsoluteSizeSpan(14, true), start, MBody63.length, exExFlag)
        MBody63.setSpan(StyleSpan(Typeface.BOLD), start, MBody63.length, exExFlag)
        MBody63.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody63.length, exExFlag)

        val MSabathneek5 = SpannableString("ஸபத்நீக:")
        MSabathneek5.setSpan(AbsoluteSizeSpan(14, true), start, MSabathneek5.length, exExFlag)
        MSabathneek5.setSpan(StyleSpan(Typeface.BOLD), start, MSabathneek5.length, exExFlag)
        MSabathneek5.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MSabathneek5.length, exExFlag)

        val MBody64AA = SpannableString(" மாதாமஹ: motherFather  சர்மா வஸூரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "    \nI.c.  ஓம் ஆயந்துந: பிதர: ஸோம்யாஸ: அக்னிஷ்வாத்தா: பதிபி: தேவயானை: அஸ்மின்யக்ஞே ஸ்வதயாமதந்த: " +
                "அதிப்ருவந்து தேவந்து அஸ்மான் motherSideGothram கோத்ர: அஸ்மத் ")
        val MregexReplace37 = """(motherFather)""".toRegex()
        val MBody64A = SpannableString(MBody64AA.replace(MregexReplace37, MFNamee))
        val MregexReplace38 = """(motherSideGothram)""".toRegex()
        val MBody64 = SpannableString(MBody64A.replace(MregexReplace38, mGothram))
        MBody64.setSpan(AbsoluteSizeSpan(14, true), start, MBody64.length, exExFlag)
        MBody64.setSpan(StyleSpan(Typeface.BOLD), start, MBody64.length, exExFlag)
        MBody64.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody64.length, exExFlag)

        val M2Sabathneek5 = SpannableString("ஸபத்நீக:")
        M2Sabathneek5.setSpan(AbsoluteSizeSpan(14, true), start, M2Sabathneek5.length, exExFlag)
        M2Sabathneek5.setSpan(StyleSpan(Typeface.BOLD), start, M2Sabathneek5.length, exExFlag)
        M2Sabathneek5.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, M2Sabathneek5.length, exExFlag)

        val MBody66AA = SpannableString(" மாதாமஹ: motherFather  சர்மா வஸூரூப: ஸ்வதாநம: த்ருப்யதாம். \n\nII.a. ஓம் " +
                "ஊர்ஜம்வஹந்தீ: அம்ருதம் க்ருதம் பய:கீலாலம் பரிஸ்ருதம் ஸ்வதாஸ்த தர்பயதமே பித்ரூன் motherSideGothram கோத்ர: அஸ்மத் ")
        val MregexReplace39 = """(motherFather)""".toRegex()
        val MBody66A = SpannableString(MBody66AA.replace(MregexReplace39, MFNamee))
        val MregexReplace40 = """(motherSideGothram)""".toRegex()
        val MBody66 = SpannableString(MBody66A.replace(MregexReplace40, mGothram))
        MBody66.setSpan(AbsoluteSizeSpan(14, true), start, MBody66.length, exExFlag)
        MBody66.setSpan(StyleSpan(Typeface.BOLD), start, MBody66.length, exExFlag)
        MBody66.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody66.length, exExFlag)

        val MSabathneek6 = SpannableString("ஸபத்நீக:")
        MSabathneek6.setSpan(AbsoluteSizeSpan(14, true), start, MSabathneek6.length, exExFlag)
        MSabathneek6.setSpan(StyleSpan(Typeface.BOLD), start, MSabathneek6.length, exExFlag)
        MSabathneek6.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MSabathneek6.length, exExFlag)

        val MBody68AA = SpannableString(" ப்ரமாதாமஹ: motherGrandFather சர்மா ருத்ரரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "    \nII.b. ஓம் பித்ருப்ய: ஸ்வாதாயிப்ய: ஸ்வதாநம: பிதாமஹேப்ய: ஸ்வதாயிப்ய: ஸ்வதாநம: ப்ரபிதாமஹேப்ய: ஸ்வதாயிப்ய: " +
                "ஸ்வதாநம: motherSideGothram கோத்ர: அஸ்மத் ")
        val MregexReplace41 = """(motherGrandFather)""".toRegex()
        val MBody68A = SpannableString(MBody68AA.replace(MregexReplace41, MGFNamee))
        val M2regexReplace40 = """(motherSideGothram)""".toRegex()
        val MBody68 = SpannableString(MBody68A.replace(M2regexReplace40, mGothram))
        MBody68.setSpan(AbsoluteSizeSpan(14, true), start, MBody68.length, exExFlag)
        MBody68.setSpan(StyleSpan(Typeface.BOLD), start, MBody68.length, exExFlag)
        MBody68.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody68.length, exExFlag)

        val MSabathneek7 = SpannableString("ஸபத்நீக:")
        MSabathneek7.setSpan(AbsoluteSizeSpan(14, true), start, MSabathneek7.length, exExFlag)
        MSabathneek7.setSpan(StyleSpan(Typeface.BOLD), start, MSabathneek7.length, exExFlag)
        MSabathneek7.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MSabathneek7.length, exExFlag)

        val MBody69AA = SpannableString(" ப்ரமாதாமஹ: motherGrandFather சர்மா  ருத்ரரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "    \nII.c. யேசேஹபிதர: யேசநேஹ யாங்குச்ச வித்மயான் ஊசந ப்ரவித்ம த்வம்வேத்த யதிதேஜாதவேத: ஸ்வதாபி: யக்ஞம் " +
                "ஸூக்ருதம் ஜூஷஸ்வ motherSideGothram கோத்ர: அஸ்மத் ")
        val M2regexReplace41 = """(motherGrandFather)""".toRegex()
        val MBody69A = SpannableString(MBody69AA.replace(M2regexReplace41, MGFNamee))
        val M3regexReplace40 = """(motherSideGothram)""".toRegex()
        val MBody69 = SpannableString(MBody69A.replace(M3regexReplace40, mGothram))
        MBody69.setSpan(AbsoluteSizeSpan(14, true), start, MBody69.length, exExFlag)
        MBody69.setSpan(StyleSpan(Typeface.BOLD), start, MBody69.length, exExFlag)
        MBody69.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody69.length, exExFlag)

        val MSabathneek8 = SpannableString("ஸபத்நீக:")
        MSabathneek8.setSpan(AbsoluteSizeSpan(14, true), start, MSabathneek8.length, exExFlag)
        MSabathneek8.setSpan(StyleSpan(Typeface.BOLD), start, MSabathneek8.length, exExFlag)
        MSabathneek8.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MSabathneek8.length, exExFlag)

        val MBody71AA = SpannableString(" ப்ரமாதாமஹ: motherGrandFather சர்மா ருத்ரரூப: ஸ்வதாநம: த்ருப்யதாம். \n\nIII.a.    " +
                "ஓம் மதுவாதா: ருதாயதே மதுக்ஷரந்தி ஸிந்தவ: மாத்வீர்ந: ஸந்து ஓஷதீ: motherSideGothram கோத்ர: அஸ்மத் ")
        val MregexReplace43 = """(motherGrandFather)""".toRegex()
        val MBody71A = SpannableString(MBody71AA.replace(MregexReplace43, MGFNamee))
        val MregexReplace44 = """(motherSideGothram)""".toRegex()
        val MBody71 = SpannableString(MBody71A.replace(MregexReplace44, mGothram))
        MBody71.setSpan(AbsoluteSizeSpan(14, true), start, MBody71.length, exExFlag)
        MBody71.setSpan(StyleSpan(Typeface.BOLD), start, MBody71.length, exExFlag)
        MBody71.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody71.length, exExFlag)

        val MSabathneek9 = SpannableString("ஸபத்நீக:")
        MSabathneek9.setSpan(AbsoluteSizeSpan(14, true), start, MSabathneek9.length, exExFlag)
        MSabathneek9.setSpan(StyleSpan(Typeface.BOLD), start, MSabathneek9.length, exExFlag)
        MSabathneek9.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MSabathneek9.length, exExFlag)

        val MBody72AA = SpannableString(" வ்ருத்தப்ரமாதாமஹ: motherGreatGrandFather சர்மா ஆதித்யரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\nIII.b.    ஓம் மதுநக்தம் உதோஷஸ: மதுமத் பார்த்திவம் ரஜ: மதுத்யௌ: அஸ்துந: பிதா  motherSideGothram கோத்ர: அஸ்மத் ")
        val MregexReplace45 = """(motherGreatGrandFather)""".toRegex()
        val MBody72A = SpannableString(MBody72AA.replace(MregexReplace45, mGGFNamee))
        val MregexReplace46 = """(motherSideGothram)""".toRegex()
        val MBody72 = SpannableString(MBody72A.replace(MregexReplace46, mGothram))
        MBody72.setSpan(AbsoluteSizeSpan(14, true), start, MBody72.length, exExFlag)
        MBody72.setSpan(StyleSpan(Typeface.BOLD), start, MBody72.length, exExFlag)
        MBody72.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody72.length, exExFlag)

        val MSabathneek10 = SpannableString("ஸபத்நீக:")
        MSabathneek10.setSpan(AbsoluteSizeSpan(14, true), start, MSabathneek10.length, exExFlag)
        MSabathneek10.setSpan(StyleSpan(Typeface.BOLD), start, MSabathneek10.length, exExFlag)
        MSabathneek10.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MSabathneek10.length, exExFlag)

        val MBody74AA = SpannableString(" வ்ருத்தப்ரமாதாமஹ: motherGreatGrandFather சர்மா ஆதித்யரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "    \nIII.c.    ஓம் மதுமாந்த: வநஸ்பதி: மதுமாந் அஸ்துஸூர்ய: மாத்வீர் காவோபவந்துந: motherSideGothram கோத்ர: அஸ்மத் ")
        val MregexReplace47 = """(motherGreatGrandFather)""".toRegex()
        val MBody74A = SpannableString(MBody74AA.replace(MregexReplace47, mGGFNamee))
        val MregexReplace48 = """(motherSideGothram)""".toRegex()
        val MBody74 = SpannableString(MBody74A.replace(MregexReplace48, mGothram))
        MBody74.setSpan(AbsoluteSizeSpan(14, true), start, MBody74.length, exExFlag)
        MBody74.setSpan(StyleSpan(Typeface.BOLD), start, MBody74.length, exExFlag)
        MBody74.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody74.length, exExFlag)

        val MSabathneek11 = SpannableString("ஸபத்நீக:")
        MSabathneek11.setSpan(AbsoluteSizeSpan(14, true), start, MSabathneek11.length, exExFlag)
        MSabathneek11.setSpan(StyleSpan(Typeface.BOLD), start, MSabathneek11.length, exExFlag)
        MSabathneek11.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MSabathneek11.length, exExFlag)

        val MBody75A = SpannableString(" வ்ருத்தப்ரமாதாமஹ: motherGreatGrandFather சர்மா ஆதித்யரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "    த்ருப்யத்வம்     த்ருப்யத்வம்     த்ருப்யத்வம் \n\n")
        val MregexReplace49 = """(motherGreatGrandFather)""".toRegex()
        val MBody75 = SpannableString(MBody75A.replace(MregexReplace49, mGGFNamee))
        MBody75.setSpan(AbsoluteSizeSpan(14, true), start, MBody75.length, exExFlag)
        MBody75.setSpan(StyleSpan(Typeface.BOLD), start, MBody75.length, exExFlag)
        MBody75.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody75.length, exExFlag)
//***************************************************************************************************
        val Comment54N = SpannableString("\n(இரண்டு கூர்ச்சத்திற்கும், கீழ்கூர்ச்சத்திலிருந்து மேல்கூர்ச்சம் வரை (இரண்டிலும் விழுமாறு) கீழ் வரும் மந்திரம் கூறி எள்ளும்")
        Comment54N.setSpan(AbsoluteSizeSpan(11, true), start, Comment54N.length, exExFlag)
        Comment54N.setSpan(StyleSpan(Typeface.ITALIC), start, Comment54N.length, exExFlag)
        Comment54N.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment54N.length, exExFlag)

        val Comment54NAdd = SpannableString("\n(கூர்ச்சத்திற்கு கீழிலிருந்து மேல் வரை கீழ் வரும் மந்திரம் கூறி எள்ளும்")
        Comment54NAdd.setSpan(AbsoluteSizeSpan(11, true), start, Comment54NAdd.length, exExFlag)
        Comment54NAdd.setSpan(StyleSpan(Typeface.ITALIC), start, Comment54NAdd.length, exExFlag)
        Comment54NAdd.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment54NAdd.length, exExFlag)

        val Comment54Ne = SpannableString(", அரிசியுடன்")
        Comment54Ne.setSpan(AbsoluteSizeSpan(11, true), start, Comment54Ne.length, exExFlag)
        Comment54Ne.setSpan(StyleSpan(Typeface.ITALIC), start, Comment54Ne.length, exExFlag)
        Comment54Ne.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment54Ne.length, exExFlag)

        val Comment54New = SpannableString(" ஜலமும் விடவும்)")
        Comment54New.setSpan(AbsoluteSizeSpan(11, true), start, Comment54New.length, exExFlag)
        Comment54New.setSpan(StyleSpan(Typeface.ITALIC), start, Comment54New.length, exExFlag)
        Comment54New.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment54New.length, exExFlag)

        val MBody91A = SpannableString("\n\nஆப்ரம்ஹ ஸ்தம்ப பர்யந்தம் தேவரிஷி பித்ருமானவா: த்ருப்யந்து பிதர: ஸர்வே மாத்ரு மாதா மஹாதய: " +
                "அதீதகுல கோடீநாம் ஸப்தத்வீப நிவாஸிநாம் ஆப்ரம்ஹ புவனாந் லோகான் \nஇதமஸ்து திலோதகம் \n       இதமஸ்து திலோதகம் " +
                "\n             இதமஸ்து திலோதகம்\n")
        MBody91A.setSpan(AbsoluteSizeSpan(14, true), start, MBody91A.length, exExFlag)
        MBody91A.setSpan(StyleSpan(Typeface.BOLD), start, MBody91A.length, exExFlag)
        MBody91A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody91A.length, exExFlag)

        val Comment54New2 = SpannableString("\nமீண்டும் அதேபோல் - இரண்டு கூர்ச்சத்திற்கும், கீழ்கூர்ச்சத்திலிருந்து மேல்கூர்ச்சம் வரை (இரண்டிலும் விழுமாறு) கீழ் வரும் மந்திரம் கூறி எள்ளும்")
        Comment54New2.setSpan(AbsoluteSizeSpan(11, true), start, Comment54New2.length, exExFlag)
        Comment54New2.setSpan(StyleSpan(Typeface.ITALIC), start, Comment54New2.length, exExFlag)
        Comment54New2.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment54New2.length, exExFlag)

        val Comment54New2Add = SpannableString("\nகூர்ச்சத்திற்கு கீழிலிருந்து மேல் வரை கீழ் வரும் மந்திரம் கூறி எள்ளும்")
        Comment54New2Add.setSpan(AbsoluteSizeSpan(11, true), start, Comment54New2Add.length, exExFlag)
        Comment54New2Add.setSpan(StyleSpan(Typeface.ITALIC), start, Comment54New2Add.length, exExFlag)
        Comment54New2Add.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment54New2Add.length, exExFlag)

        val Comment54Ne2 = SpannableString(", அரிசியுடன்")
        Comment54Ne2.setSpan(AbsoluteSizeSpan(11, true), start, Comment54Ne2.length, exExFlag)
        Comment54Ne2.setSpan(StyleSpan(Typeface.ITALIC), start, Comment54Ne2.length, exExFlag)
        Comment54Ne2.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment54Ne2.length, exExFlag)

        val Comment54New3 = SpannableString(" ஜலமும் விடவும்)")
        Comment54New3.setSpan(AbsoluteSizeSpan(11, true), start, Comment54New3.length, exExFlag)
        Comment54New3.setSpan(StyleSpan(Typeface.ITALIC), start, Comment54New3.length, exExFlag)
        Comment54New3.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment54New3.length, exExFlag)

        val MBody91Again = SpannableString("\n ஏகேஜாஸ்மது குலேஜாதா: அபுஜா: கோத்ரஜாம்ருதா: தே க்ருநந்து மயாதத்தம்  \nஇதமஸ்து திலோதகம் \n        இதமஸ்து திலோதகம் \n             இதமஸ்து திலோதகம்\n")
        MBody91Again.setSpan(AbsoluteSizeSpan(14, true), start, MBody91Again.length, exExFlag)
        MBody91Again.setSpan(StyleSpan(Typeface.BOLD), start, MBody91Again.length, exExFlag)
        MBody91Again.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody91Again.length, exExFlag)

        val Comment51 = SpannableString("\nவடக்கு நோக்கி கீழ்வரும் மந்திரங்களை கூறவும்")
        Comment51.setSpan(AbsoluteSizeSpan(11, true), start, Comment51.length, exExFlag)
        Comment51.setSpan(StyleSpan(Typeface.ITALIC), start, Comment51.length, exExFlag)
        Comment51.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment51.length, exExFlag)

        val Body88 = SpannableString("\nஓம் அத்ரபிதர: மாதயத்வம் யாதாபாகம் ஆவ்ருஷா யத்வம் அமீமதந்த பிதர: யதாபாகம் ஆவ்ருஷா யிஷத\n\n")
        Body88.setSpan(AbsoluteSizeSpan(14, true), start, Body88.length, exExFlag)
        Body88.setSpan(StyleSpan(Typeface.BOLD), start, Body88.length, exExFlag)
        Body88.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body88.length, exExFlag)

        val GreenComment2 = SpannableString("(ஸவ்யம்)")
        GreenComment2.setSpan(AbsoluteSizeSpan(14, true), start, GreenComment2.length, exExFlag)
        GreenComment2.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, GreenComment2.length, exExFlag)
        GreenComment2.setSpan(ForegroundColorSpan(Color.GREEN), start, GreenComment2.length, exExFlag)

        val Comment52 = SpannableString(" -  கிழக்கு நோக்கி பித்ருக்களை ப்ரார்த்தனை செய்து கொண்டு கீழ்வரும் மந்திரங்களை கூறவும்")
        Comment52.setSpan(AbsoluteSizeSpan(11, true), start, Comment52.length, exExFlag)
        Comment52.setSpan(StyleSpan(Typeface.ITALIC), start, Comment52.length, exExFlag)
        Comment52.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment52.length, exExFlag)

        val Body89 = SpannableString("\nஓம் நமோவ: பிதர: ஸூஷ்மாய நமோவ: பிதர: தபஸே நமோவ: பிதர: " +
                "\nயஜ்ஜீவம் தஸ்மை நமோவ: பிதர: ரஸாய நமோவ: பிதர: கோராய மன்யவே ஸ்வதாயைவ: பிதரோ நம:\n")
        Body89.setSpan(AbsoluteSizeSpan(14, true), start, Body89.length, exExFlag)
        Body89.setSpan(StyleSpan(Typeface.BOLD), start, Body89.length, exExFlag)
        Body89.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body89.length, exExFlag)

        val RedComment4 = SpannableString("(அபஸவ்யம்)")
        RedComment4.setSpan(AbsoluteSizeSpan(13, true), start, RedComment4.length, exExFlag)
        RedComment4.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, RedComment4.length, exExFlag)
        RedComment4.setSpan(ForegroundColorSpan(Color.RED), start, RedComment4.length, exExFlag)

        val Comment53 = SpannableString(" - கட்டதர்பங்களை எடுத்துக்கொண்டு மந்திரம் சொல்லி")
        Comment53.setSpan(AbsoluteSizeSpan(11, true), start, Comment53.length, exExFlag)
        Comment53.setSpan(StyleSpan(Typeface.ITALIC), start, Comment53.length, exExFlag)
        Comment53.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment53.length, exExFlag)

        val Comment54 = SpannableString(" இரண்டு ")
        Comment54.setSpan(AbsoluteSizeSpan(11, true), start, Comment54.length, exExFlag)
        Comment54.setSpan(StyleSpan(Typeface.ITALIC), start, Comment54.length, exExFlag)
        Comment54.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment54.length, exExFlag)

        val Comment55 = SpannableString("கூர்ச்சத்தின் மீது வைக்கவும்")
        Comment55.setSpan(AbsoluteSizeSpan(11, true), start, Comment55.length, exExFlag)
        Comment55.setSpan(StyleSpan(Typeface.ITALIC), start, Comment55.length, exExFlag)
        Comment55.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment55.length, exExFlag)

        val Body90 = SpannableString("\nஓம் ஏதத்வ: பிதரோவாஸ: க்ருஹான்ன: பிதரோதத்த: உதாயுஷா ஸ்வாயுஷா உத்பர்ஜந்யஸ்ய " +
                "தாமபி: உதஸ்தாம் அம்ருதாம் அநு\n")
        Body90.setSpan(AbsoluteSizeSpan(14, true), start, Body90.length, exExFlag)
        Body90.setSpan(StyleSpan(Typeface.BOLD), start, Body90.length, exExFlag)
        Body90.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body90.length, exExFlag)

        val Comment56 = SpannableString("\n (மேல்கூர்ச்சத்திற்கு கீழ் வரும் மந்திரம் கூறி எள்ளுடன், சிறிது அரிசியையும் சேர்த்து ஜலம் விடவும்")
        Comment56.setSpan(AbsoluteSizeSpan(11, true), start, Comment56.length, exExFlag)
        Comment56.setSpan(StyleSpan(Typeface.ITALIC), start, Comment56.length, exExFlag)
        Comment56.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, Comment56.length, exExFlag)

        val Comment55C = SpannableString("\n (மேல்கூர்ச்சத்திற்கு கீழ் வரும் மந்திரம் கூறி எள்ளும், ஜலமும் விடவும்")
        Comment55C.setSpan(AbsoluteSizeSpan(11, true), start, Comment55C.length, exExFlag)
        Comment55C.setSpan(StyleSpan(Typeface.ITALIC), start, Comment55C.length, exExFlag)
        Comment55C.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, Comment55C.length, exExFlag)

        val Comment56Addnl = SpannableString("\n (கூர்ச்சத்திற்கு கீழ் வரும் மந்திரம் கூறி எள்ளுடன், சிறிது அரிசியையும் சேர்த்து ஜலம் விடவும்")
        Comment56Addnl.setSpan(AbsoluteSizeSpan(11, true), start, Comment56Addnl.length, exExFlag)
        Comment56Addnl.setSpan(StyleSpan(Typeface.ITALIC), start, Comment56Addnl.length, exExFlag)
        Comment56Addnl.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, Comment56Addnl.length, exExFlag)

        val Comment55CAddnl = SpannableString("\n (கூர்ச்சத்திற்கு கீழ் வரும் மந்திரம் கூறி எள்ளும், ஜலமும் விடவும்")
        Comment55CAddnl.setSpan(AbsoluteSizeSpan(11, true), start, Comment55CAddnl.length, exExFlag)
        Comment55CAddnl.setSpan(StyleSpan(Typeface.ITALIC), start, Comment55CAddnl.length, exExFlag)
        Comment55CAddnl.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, Comment55CAddnl.length, exExFlag)

        val Body91 = SpannableString("\nஓம் ஊர்ஜம்வஹந்தீ: அம்ருதம்க்ருதம்பய: கீலாலம் பரிஸ்ருதம் ஸ்வதாஸ்த தர்ப்பயதமே பித்ரூன்" +
                "\nத்ருப்யத்வம்     த்ருப்யத்வம்     த்ருப்யத்வம்\n")
        Body91.setSpan(AbsoluteSizeSpan(14, true), start, Body91.length, exExFlag)
        Body91.setSpan(StyleSpan(Typeface.BOLD), start, Body91.length, exExFlag)
        Body91.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body91.length, exExFlag)

        val Comment55B = SpannableString("\n(கீழ் கூர்ச்சம - கீழ் வரும் மந்திரம் கூறி எள்ளுடன், சிறிது அரிசியையும் சேர்த்து ஜலம் விடவும்்)")
        Comment55B.setSpan(AbsoluteSizeSpan(11, true), start, Comment55B.length, exExFlag)
        Comment55B.setSpan(StyleSpan(Typeface.ITALIC), start, Comment55B.length, exExFlag)
        Comment55B.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, Comment55B.length, exExFlag)

        val Comment57 = SpannableString("\n(கீழ் கூர்ச்சம - கீழ் வரும் மந்திரம் கூறி எள்ளும், ஜலமும் விடவும்)")
        Comment57.setSpan(AbsoluteSizeSpan(11, true), start, Comment57.length, exExFlag)
        Comment57.setSpan(StyleSpan(Typeface.ITALIC), start, Comment57.length, exExFlag)
        Comment57.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, Comment57.length, exExFlag)

        val MBody91 = SpannableString("\nஓம் ஊர்ஜம்வஹந்தீ: அம்ருதம்க்ருதம்பய: கீலாலம் பரிஸ்ருதம் ஸ்வதாஸ்த தர்ப்பயதமே பித்ரூன்" +
                "\nத்ருப்யத்வம்     த்ருப்யத்வம்     த்ருப்யத்வம்\n")
        MBody91.setSpan(AbsoluteSizeSpan(14, true), start, MBody91.length, exExFlag)
        MBody91.setSpan(StyleSpan(Typeface.BOLD), start, MBody91.length, exExFlag)
        MBody91.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody91.length, exExFlag)

        val Comment67 = SpannableString("\n(எழுந்து ")
        Comment67.setSpan(AbsoluteSizeSpan(11, true), start, Comment67.length, exExFlag)
        Comment67.setSpan(StyleSpan(Typeface.ITALIC), start, Comment67.length, exExFlag)
        Comment67.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment67.length, exExFlag)

        val GreenComment3 = SpannableString("ஸவ்யம்")
        GreenComment3.setSpan(AbsoluteSizeSpan(14, true), start, GreenComment3.length, exExFlag)
        GreenComment3.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, GreenComment3.length, exExFlag)
        GreenComment3.setSpan(ForegroundColorSpan(Color.GREEN), start, GreenComment3.length, exExFlag)

        val Comment68 = SpannableString(" செய்து கொண்டு கீழ்வரும் மந்திரங்களை கூறி மூன்று ப்ரதட்சனம் செய்யவும்")
        Comment68.setSpan(AbsoluteSizeSpan(11, true), start, Comment68.length, exExFlag)
        Comment68.setSpan(StyleSpan(Typeface.ITALIC), start, Comment68.length, exExFlag)
        Comment68.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment68.length, exExFlag)

        val Body101 = SpannableString("\nஓம் ஆமாவாஜஸ்ய ப்ரஸவ: ஜகம்யாத் ஏமே த்யாவா ப்ருதிவீ விஸ்வருபே ஆமாகந்தம் பிதரா " +
                "மாதரா யுவம் ஆமாஸோம: அம்ருதத்வாய கம்யாத்\n\nஓம் தேவதாப்ய: பித்ருப்யச்ச மஹாயோகிப்ய: ஏவச நமஸ்வதாயை ஸ்வாஹாயை நித்யமேவ நமோநம:")
        Body101.setSpan(AbsoluteSizeSpan(14, true), start, Body101.length, exExFlag)
        Body101.setSpan(StyleSpan(Typeface.BOLD), start, Body101.length, exExFlag)
        Body101.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body101.length, exExFlag)

        val Comment69 = SpannableString(" \nஎன்று நமஸ்கரிக்கவும்")
        Comment69.setSpan(AbsoluteSizeSpan(11, true), start, Comment69.length, exExFlag)
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
        Comment70.setSpan(AbsoluteSizeSpan(11, true), start, Comment70.length, exExFlag)
        Comment70.setSpan(StyleSpan(Typeface.ITALIC), start, Comment70.length, exExFlag)
        Comment70.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment70.length, exExFlag)

        val Body101N5 = SpannableString("\nமமோ பார்த்த சமஸ்த துரித க்ஷயத்வாரா ஸ்ரீ பரமேஸ்வர ப்ரீத்யர்த்தம்\nவாஜே வாஜே அவத இதி மந்த்ரேன ")
        Body101N5.setSpan(AbsoluteSizeSpan(14, true), start, Body101N5.length, exExFlag)
        Body101N5.setSpan(StyleSpan(Typeface.BOLD), start, Body101N5.length, exExFlag)
        Body101N5.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body101N5.length, exExFlag)

        val VARGAI1B = SpannableString(" வர்கத்வய ")
        VARGAI1B.setSpan(AbsoluteSizeSpan(14, true), start, VARGAI1B.length, exExFlag)
        VARGAI1B.setSpan(StyleSpan(Typeface.BOLD), start, VARGAI1B.length, exExFlag)
        VARGAI1B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, VARGAI1B.length, exExFlag)

        val VARGAI1A = SpannableString(" வர்கைக ")
        VARGAI1A.setSpan(AbsoluteSizeSpan(14, true), start, VARGAI1A.length, exExFlag)
        VARGAI1A.setSpan(StyleSpan(Typeface.BOLD), start, VARGAI1A.length, exExFlag)
        VARGAI1A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, VARGAI1A.length, exExFlag)

        val Body93 = SpannableString(" பித்ரு விசர்ஜனம் கரிஷ்யே  \nஅபஉபஸ்ய்ருஸ்ய")
        Body93.setSpan(AbsoluteSizeSpan(14, true), start, Body93.length, exExFlag)
        Body93.setSpan(StyleSpan(Typeface.BOLD), start, Body93.length, exExFlag)
        Body93.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body93.length, exExFlag)

        val Comment59 = SpannableString(" \nஎன்று ஜலத்தை தொடவும்\n\nநெற்றியில் கை வைத்துக் கொண்டு: ")
        Comment59.setSpan(AbsoluteSizeSpan(11, true), start, Comment59.length, exExFlag)
        Comment59.setSpan(StyleSpan(Typeface.ITALIC), start, Comment59.length, exExFlag)
        Comment59.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment59.length, exExFlag)

        val Body94 = SpannableString("வாஜே வாஜே அவத இத்யஸ்ய மந்த்ரஸ்ய  வஸிஷ்டரிஷி:")
        Body94.setSpan(AbsoluteSizeSpan(14, true), start, Body94.length, exExFlag)
        Body94.setSpan(StyleSpan(Typeface.BOLD), start, Body94.length, exExFlag)
        Body94.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body94.length, exExFlag)

        val Comment60 = SpannableString("\nமூக்கு நுனியை தொட்டுக்கொண்டு: ")
        Comment60.setSpan(AbsoluteSizeSpan(11, true), start, Comment60.length, exExFlag)
        Comment60.setSpan(StyleSpan(Typeface.ITALIC), start, Comment60.length, exExFlag)
        Comment60.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment60.length, exExFlag)

        val Body95 = SpannableString("த்ருஷ்டுப்சந்த:")
        Body95.setSpan(AbsoluteSizeSpan(14, true), start, Body95.length, exExFlag)
        Body95.setSpan(StyleSpan(Typeface.BOLD), start, Body95.length, exExFlag)
        Body95.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body95.length, exExFlag)

        val Comment61 = SpannableString("\nஹிருதயத்தைத் தொட்டுக்கொண்டு: ")
        Comment61.setSpan(AbsoluteSizeSpan(11, true), start, Comment61.length, exExFlag)
        Comment61.setSpan(StyleSpan(Typeface.ITALIC), start, Comment61.length, exExFlag)
        Comment61.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment61.length, exExFlag)

        val Body96 = SpannableString("வாஜிநோ தேவதா ஆவாஹித")
        Body96.setSpan(AbsoluteSizeSpan(14, true), start, Body96.length, exExFlag)
        Body96.setSpan(StyleSpan(Typeface.BOLD), start, Body96.length, exExFlag)
        Body96.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body96.length, exExFlag)

        val VARGAI2B = SpannableString(" வர்கத்வய ")
        VARGAI2B.setSpan(AbsoluteSizeSpan(14, true), start, VARGAI2B.length, exExFlag)
        VARGAI2B.setSpan(StyleSpan(Typeface.BOLD), start, VARGAI2B.length, exExFlag)
        VARGAI2B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, VARGAI2B.length, exExFlag)

        val VARGAI2A = SpannableString(" வர்கைக ")
        VARGAI2A.setSpan(AbsoluteSizeSpan(14, true), start, VARGAI2A.length, exExFlag)
        VARGAI2A.setSpan(StyleSpan(Typeface.BOLD), start, VARGAI2A.length, exExFlag)
        VARGAI2A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, VARGAI2A.length, exExFlag)

        val Body97 = SpannableString("பித்ரு கூர்ச்ச விஸர்ஜனே வினியோக:")
        Body97.setSpan(AbsoluteSizeSpan(14, true), start, Body97.length, exExFlag)
        Body97.setSpan(StyleSpan(Typeface.BOLD), start, Body97.length, exExFlag)
        Body97.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body97.length, exExFlag)

        val Comment62 = SpannableString(" - என்று கைகளை உள்வாங்கவும்\n")
        Comment62.setSpan(AbsoluteSizeSpan(11, true), start, Comment62.length, exExFlag)
        Comment62.setSpan(StyleSpan(Typeface.ITALIC), start, Comment62.length, exExFlag)
        Comment62.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment62.length, exExFlag)

        val Heading6 = SpannableString("\nவிஸர்ஜனம்\n")
        Heading6.setSpan(AbsoluteSizeSpan(16, true), start, Heading6.length, exExFlag)
        Heading6.setSpan(StyleSpan(Typeface.BOLD), start, Heading6.length, exExFlag)
        Heading6.setSpan(UnderlineSpan(), start, Heading6.length, exExFlag)
        Heading6.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, Heading6.length, exExFlag)

        val RedComment5 = SpannableString("(அபஸவ்யம்)")
        RedComment5.setSpan(AbsoluteSizeSpan(13, true), start, RedComment5.length, exExFlag)
        RedComment5.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, RedComment5.length, exExFlag)
        RedComment5.setSpan(ForegroundColorSpan(Color.RED), start, RedComment5.length, exExFlag)

        val Body98 = SpannableString("\nஓம் உத்திஷ்டந்து அஸ்மத் ")
        Body98.setSpan(AbsoluteSizeSpan(14, true), start, Body98.length, exExFlag)
        Body98.setSpan(StyleSpan(Typeface.BOLD), start, Body98.length, exExFlag)
        Body98.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body98.length, exExFlag)

        val Sabathneek13 = SpannableString(" ஸபத்நீக: ")
        Sabathneek13.setSpan(AbsoluteSizeSpan(14, true), start, Sabathneek13.length, exExFlag)
        Sabathneek13.setSpan(StyleSpan(Typeface.BOLD), start, Sabathneek13.length, exExFlag)
        Sabathneek13.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Sabathneek13.length, exExFlag)

        val Body99A = SpannableString("பித்ரு பிதாமஹ ப்ரபிதாமஹ:")
        Body99A.setSpan(AbsoluteSizeSpan(14, true), start, Body99A.length, exExFlag)
        Body99A.setSpan(StyleSpan(Typeface.BOLD), start, Body99A.length, exExFlag)
        Body99A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body99A.length, exExFlag)

        val Body99B = SpannableString("பித்ரு ப்ரபிதாமஹ: வ்ருத்தப்ரபிதாமஹ:")
        Body99B.setSpan(AbsoluteSizeSpan(14, true), start, Body99B.length, exExFlag)
        Body99B.setSpan(StyleSpan(Typeface.BOLD), start, Body99B.length, exExFlag)
        Body99B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body99B.length, exExFlag)

        val Comment56AN = SpannableString(" -(என்று மேல் கூர்ச்சத்தில் எள்ளையும் அரிசியையும் போடவும்)")
        Comment56AN.setSpan(AbsoluteSizeSpan(11, true), start, Comment56AN.length, exExFlag)
        Comment56AN.setSpan(StyleSpan(Typeface.ITALIC), start, Comment56AN.length, exExFlag)
        Comment56AN.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment56AN.length, exExFlag)

        val Comment56ANe = SpannableString(" -(என்று மேல் கூர்ச்சத்தில் எள்ளை போடவும்)")
        Comment56ANe.setSpan(AbsoluteSizeSpan(11, true), start, Comment56ANe.length, exExFlag)
        Comment56ANe.setSpan(StyleSpan(Typeface.ITALIC), start, Comment56ANe.length, exExFlag)
        Comment56ANe.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment56ANe.length, exExFlag)

        val Comment56ANNew = SpannableString(" -(என்று மேல் கூர்ச்சத்தில் எள்ளையும் அரிசியையும் போடவும்)")
        Comment56ANNew.setSpan(AbsoluteSizeSpan(11, true), start, Comment56ANNew.length, exExFlag)
        Comment56ANNew.setSpan(StyleSpan(Typeface.ITALIC), start, Comment56ANNew.length, exExFlag)
        Comment56ANNew.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment56ANNew.length, exExFlag)

        val Comment56ANeAddnl = SpannableString(" -(என்று மேல் கூர்ச்சத்தில் எள்ளை போடவும்)")
        Comment56ANeAddnl.setSpan(AbsoluteSizeSpan(11, true), start, Comment56ANeAddnl.length, exExFlag)
        Comment56ANeAddnl.setSpan(StyleSpan(Typeface.ITALIC), start, Comment56ANeAddnl.length, exExFlag)
        Comment56ANeAddnl.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment56ANeAddnl.length, exExFlag)

        val MBody98 = SpannableString("\nஓம் உத்திஷ்டந்து அஸ்மத் ")
        MBody98.setSpan(AbsoluteSizeSpan(14, true), start, MBody98.length, exExFlag)
        MBody98.setSpan(StyleSpan(Typeface.BOLD), start, MBody98.length, exExFlag)
        MBody98.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody98.length, exExFlag)

        val Sabathneek13A = SpannableString("ஸபத்நீக: ")
        Sabathneek13A.setSpan(AbsoluteSizeSpan(14, true), start, Sabathneek13A.length, exExFlag)
        Sabathneek13A.setSpan(StyleSpan(Typeface.BOLD), start, Sabathneek13A.length, exExFlag)
        Sabathneek13A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Sabathneek13A.length, exExFlag)

        val MBody98A = SpannableString("மாதாமஹ ப்ரமாதாமஹ வ்ருத்தப்ரமாதாமஹா:")
        MBody98A.setSpan(AbsoluteSizeSpan(14, true), start, MBody98A.length, exExFlag)
        MBody98A.setSpan(StyleSpan(Typeface.BOLD), start, MBody98A.length, exExFlag)
        MBody98A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody98A.length, exExFlag)

        val Comment56ANe1 = SpannableString(" - (என்று கீழ் கூர்ச்சத்தில் எள்ளையும் அரிசியையும் போடவும்)")
        Comment56ANe1.setSpan(AbsoluteSizeSpan(11, true), start, Comment56ANe1.length, exExFlag)
        Comment56ANe1.setSpan(StyleSpan(Typeface.ITALIC), start, Comment56ANe1.length, exExFlag)
        Comment56ANe1.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment56ANe1.length, exExFlag)

        val Comment56ANew = SpannableString(" - (என்று கீழ் கூர்ச்சத்தில் எள்ளை போடவும்)")
        Comment56ANew.setSpan(AbsoluteSizeSpan(11, true), start, Comment56ANew.length, exExFlag)
        Comment56ANew.setSpan(StyleSpan(Typeface.ITALIC), start, Comment56ANew.length, exExFlag)
        Comment56ANew.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment56ANew.length, exExFlag)

        val Comment66 = SpannableString("\n\n(கீழ்வரும் மந்திரங்களை சொல்லி கட்டை தர்பத்தை கூர்ச்சங்களின் மேல் வைத்து தொட்டுக் கொண்டு) - ")
        Comment66.setSpan(AbsoluteSizeSpan(11, true), start, Comment66.length, exExFlag)
        Comment66.setSpan(StyleSpan(Typeface.ITALIC), start, Comment66.length, exExFlag)
        Comment66.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment66.length, exExFlag)

        val Body100 = SpannableString("அஸ்மாத்து கூர்ச்சாது யதாஸ்தானம் ப்ரதிஷ்டாபயாமி \nஓம் வாஜே வாஜே அவதவாஜிந: நோதனேஷூ விப்ரா: அம்ருதா: ருதக்ஞா: அஸ்யமத்வ: பிபத " +
                "மாதயத்வம் த்ருப்தாயாத பதிபி: தேவயானை:")
        Body100.setSpan(AbsoluteSizeSpan(14, true), start, Body100.length, exExFlag)
        Body100.setSpan(StyleSpan(Typeface.BOLD), start, Body100.length, exExFlag)
        Body100.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body100.length, exExFlag)

        val RedComment6 = SpannableString("\n\n(அபஸவ்யம்) - ")
        RedComment6.setSpan(AbsoluteSizeSpan(13, true), start, RedComment6.length, exExFlag)
        RedComment6.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, RedComment6.length, exExFlag)
        RedComment6.setSpan(ForegroundColorSpan(Color.RED), start, RedComment6.length, exExFlag)

        val Comment72 = SpannableString(" செய்து கொண்டு\n")
        Comment72.setSpan(AbsoluteSizeSpan(11, true), start, Comment72.length, exExFlag)
        Comment72.setSpan(StyleSpan(Typeface.ITALIC), start, Comment72.length, exExFlag)
        Comment72.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment72.length, exExFlag)

        val Comment73 = SpannableString(" இரண்டு ")
        Comment73.setSpan(AbsoluteSizeSpan(11, true), start, Comment73.length, exExFlag)
        Comment73.setSpan(StyleSpan(Typeface.ITALIC), start, Comment73.length, exExFlag)
        Comment73.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment73.length, exExFlag)

        val Comment74 = SpannableString("கூர்ச்சங்களை பிரித்து தெற்கு நுனியாக வைத்துக் கொண்டு, மீதி எல்லா எள்ளையும்")
        Comment74.setSpan(AbsoluteSizeSpan(11, true), start, Comment74.length, exExFlag)
        Comment74.setSpan(StyleSpan(Typeface.ITALIC), start, Comment74.length, exExFlag)
        Comment74.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment74.length, exExFlag)

        val Comment75 = SpannableString("கூர்ச்சங்களை பிரித்து தெற்கு நுனியாக வைத்துக் கொண்டு, மீதி எல்லா எள்ளையும், அரிசியையும்")
        Comment75.setSpan(AbsoluteSizeSpan(11, true), start, Comment75.length, exExFlag)
        Comment75.setSpan(StyleSpan(Typeface.ITALIC), start, Comment75.length, exExFlag)
        Comment75.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment75.length, exExFlag)

        val Comment76 = SpannableString(" கையில் சேர்த்து ஜலம் விட்டபடியே பூமியில் போடவும்")
        Comment76.setSpan(AbsoluteSizeSpan(11, true), start, Comment76.length, exExFlag)
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

        val Body108 = SpannableString("நப்ராதா: நாந்யகோத்ரிண: தேஸர்வே த்ருப்திமாயாந்து\n" +
                "    மயோத்ஸ்ருஷ்டை: குசோதகை:\n" +
                "            மயோத்ஸ்ருஷ்டை: குசோதகை:\n" +
                "                  மயோத்ஸ்ருஷ்டை: குசோதகை:\n")
        Body108.setSpan(AbsoluteSizeSpan(14, true), start, Body108.length, exExFlag)
        Body108.setSpan(StyleSpan(Typeface.BOLD), start, Body108.length, exExFlag)
        Body108.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body108.length, exExFlag)

        val GreenComment4 = SpannableString("\n(ஸவ்யம்) - ")
        GreenComment4.setSpan(AbsoluteSizeSpan(14, true), start, GreenComment4.length, exExFlag)
        GreenComment4.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, GreenComment4.length, exExFlag)
        GreenComment4.setSpan(ForegroundColorSpan(Color.GREEN), start, GreenComment4.length, exExFlag)

        val Comment71 = SpannableString(" (கீழ்வரும் மந்திரம் சொல்லி நேராக வலது கையால் ஜலம் விடவும்)\n")
        Comment71.setSpan(AbsoluteSizeSpan(11, true), start, Comment71.length, exExFlag)
        Comment71.setSpan(StyleSpan(Typeface.ITALIC), start, Comment71.length, exExFlag)
        Comment71.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment71.length, exExFlag)

        val Body103A = SpannableString("\nமந்த்ரஹீனம் க்ரியாஹீனம் பக்திஹீனம் ஜனார்தனா ஜன்மயா விகிதம்கர்ம பரிபூர்ணம் ததஸ்துதே\n" +
                "மயாக்கிருதமிதம் அஸ்மது உபயவம்ஸ பித்ருணாம் அக்ஷ்ய்ய த்ருப்த்யர்த்தம் Thithi புண்யகால திலதர்ப்பணார்க்யம் கர்ம ஸர்வம் " +
                "\nஸ்ரீ கிருஷ்ணார்ப்பணமஸ்து \n     வாஸூதேவார்ப்பணமஸ்து \n          தத்ஸத் ப்ரும்மார்ப்பணமஸ்து\n    காயேனவாசா மனஸேந்த்ரியைர்வா " +
                "புத்யாத்மனாவா ப்ரக்ருதே: ஸ்வபாவாத் கரோமியத்யத் ஸகலம் பரஸ்மை நாராயணாயேதி ஸமர்ப்பயாமி\nஸ்ரீமந் நாராயணா ஸ்ரீ நாராயண " +
                "நாராயண நாராயண நாராயண நாராயண நாராயண நாராயண நாராயண நாராயண நாராயண நாராயண \nப்ராயச்சித்தாநி அசேஷாணி தப: " +
                "கர்ம ஆத்மகாநிவை யாநி தேஷாம் அசேஷாணாம் க்ருஷ்ணானுஸ்மரணம் பரம்\nஸ்ரீ கிருஷ்ண ஸ்ரீ கிருஷ்ண ஸ்ரீ கிருஷ்ண ஸ்ரீ கிருஷ்ண " +
                "ஸ்ரீ கிருஷ்ண ஸ்ரீ கிருஷ்ண ஸ்ரீ கிருஷ்ண ஸ்ரீ கிருஷ்ண ஸ்ரீ கிருஷ்ண ஸ்ரீ கிருஷ்ண ஸ்ரீ கிருஷ்ண ஸ்ரீ கிருஷ்ணாய நம:")
        val regexReplace68 = """(Thithi)""".toRegex()
        val Body103 = SpannableString(Body103A.replace(regexReplace68, todThithi))
        Body103.setSpan(AbsoluteSizeSpan(14, true), start, Body103.length, exExFlag)
        Body103.setSpan(StyleSpan(Typeface.BOLD), start, Body103.length, exExFlag)
        Body103.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body103.length, exExFlag)

        val Comment56A = SpannableString("\n (பவித்திரத்தை அவிழ்த்து காதில் சொருகிக் கொண்டு ஆசமனம் செய்து பவித்ரத்தை பிரித்து " +
                "போட்டுவிட்டு மறுபடி ஆசமனம் செய்யவும்)\nவீபூதியை குழைத்து இட்டுக் கொண்டு மறுபடி ஆசமனம் செய்யவும்")
        Comment56A.setSpan(AbsoluteSizeSpan(11, true), start, Comment56A.length, exExFlag)
        Comment56A.setSpan(StyleSpan(Typeface.ITALIC), start, Comment56A.length, exExFlag)
        Comment56A.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment56A.length, exExFlag)

        val Heading7 = SpannableString("\nமுற்றும்\n")
        Heading7.setSpan(AbsoluteSizeSpan(16, true), start, Heading7.length, exExFlag)
        Heading7.setSpan(StyleSpan(Typeface.BOLD), start, Heading7.length, exExFlag)
        Heading7.setSpan(UnderlineSpan(), start, Heading7.length, exExFlag)
        Heading7.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, Heading7.length, exExFlag)





        /*
            val Comment57B = SpannableString("\n - மேல்கூர்ச்சத்திற்கு எள்ளும், சிறிது அரிசியையும் சேர்த்து ஜலமும் விடவும")
            Comment57B.setSpan(AbsoluteSizeSpan(13, true), start, Comment57B.length, exExFlag)
            Comment57B.setSpan(StyleSpan(Typeface.ITALIC), start, Comment57B.length, exExFlag)
            Comment57B.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment57B.length, exExFlag)

            val Body92 = SpannableString("\nமமோ பார்த்த சமஸ்த துரித க்ஷயத்வாரா ஸ்ரீ பரமேஸ்வர ப்ரீத்யர்த்தம்\nவாஜே வாஜே அவத இதி மந்த்ரேன\n")
            Body92.setSpan(AbsoluteSizeSpan(14, true), start, Body92.length, exExFlag)
            Body92.setSpan(StyleSpan(Typeface.BOLD), start, Body92.length, exExFlag)
            Body92.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, Body92.length, exExFlag)

            val Comment58 = SpannableString(" ஜலமும் விடவும்")
            Comment58.setSpan(AbsoluteSizeSpan(13, true), start, Comment58.length, exExFlag)
            Comment58.setSpan(StyleSpan(Typeface.ITALIC), start, Comment58.length, exExFlag)
            Comment58.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment58.length, exExFlag)

            val Comment55A = SpannableString("\n(மேல் கூர்ச்சம்)")
                Comment55A.setSpan(AbsoluteSizeSpan(13, true), start, Comment55A.length, exExFlag)
                Comment55A.setSpan(StyleSpan(Typeface.ITALIC), start, Comment55A.length, exExFlag)
                Comment55A.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, Comment55A.length, exExFlag)


                val MBody90 = SpannableString("\nஓம் ஏதத்வ: பிதரோவாஸ: க்ருஹான்ன: பிதரோதத்த: உதாயுஷா ஸ்வாயுஷா உத்பர்ஜந்யஸ்ய " +
                            "தாமபி: உதஸ்தாம் அம்ருதாம் அநு\n")
                MBody90.setSpan(AbsoluteSizeSpan(14, true), start, MBody90.length, exExFlag)
                MBody90.setSpan(StyleSpan(Typeface.BOLD), start, MBody90.length, exExFlag)
                MBody90.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, MBody90.length, exExFlag)

            val Comment57A = SpannableString("\n கீழ் வரும் மந்திரம் கூறி எள்ளும், சிறிது அரிசியையும் சேர்த்து")
                Comment57A.setSpan(AbsoluteSizeSpan(13, true), start, Comment57A.length, exExFlag)
                Comment57A.setSpan(StyleSpan(Typeface.ITALIC), start, Comment57A.length, exExFlag)
                Comment57A.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment57A.length, exExFlag)

                val Comment58A = SpannableString(" ஜலமும் விடவும்")
                Comment58A.setSpan(AbsoluteSizeSpan(13, true), start, Comment58A.length, exExFlag)
                Comment58A.setSpan(StyleSpan(Typeface.ITALIC), start, Comment58A.length, exExFlag)
                Comment58A.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment58A.length, exExFlag)

                val Comment58B = SpannableString(" ஜலமும் விடவும்")
                Comment58B.setSpan(AbsoluteSizeSpan(13, true), start, Comment58B.length, exExFlag)
                Comment58B.setSpan(StyleSpan(Typeface.ITALIC), start, Comment58B.length, exExFlag)
                Comment58B.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment58B.length, exExFlag)

                val Comment55D = SpannableString("\n கீழ்கூர்ச்சத்திற்கு")
                Comment55D.setSpan(AbsoluteSizeSpan(13, true), start, Comment55D.length, exExFlag)
                Comment55D.setSpan(StyleSpan(Typeface.ITALIC), start, Comment55D.length, exExFlag)
                Comment55D.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, Comment55D.length, exExFlag)

                val Comment55E = SpannableString("\n இரண்டு கூர்ச்சத்திற்கும் எள்ளை")
                Comment55E.setSpan(AbsoluteSizeSpan(13, true), start, Comment55E.length, exExFlag)
                Comment55E.setSpan(StyleSpan(Typeface.ITALIC), start, Comment55E.length, exExFlag)
                Comment55E.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment55E.length, exExFlag)


                val Comment63 = SpannableString("\nகீழ் வரும் மந்திரம் கூறி எள்ளை கூர்ச்சத்தில் போடவும்")
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

                val MComment64A = SpannableString("\n கீழ் கூர்ச்சத்தில் ")
                MComment64A.setSpan(AbsoluteSizeSpan(13, true), start, MComment64A.length, exExFlag)
                MComment64A.setSpan(StyleSpan(Typeface.ITALIC), start, MComment64A.length, exExFlag)
                MComment64A.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, MComment64A.length, exExFlag)



                val Body104 = SpannableString(
                    "பித்ரூன் உத்திச்ய திலதர்ப்பணாக்யம் கர்ம ஸர்வம் \nஸ்ரீ கிருஷ்ணார்ப்பணமஸ்து " +
                            "\nஸ்ரீ வாஸூதேவார்ப்பணமஸ்து \nதத்ஸது ப்ரும்மார்ப்பணமஸ்து"
                )
                Body104.setSpan(AbsoluteSizeSpan(14, true), start, Body104.length, exExFlag)
                Body104.setSpan(StyleSpan(Typeface.BOLD), start, Body104.length, exExFlag)
                Body104.setSpan(
                    ForegroundColorSpan(Color.parseColor("#0000ee")),
                    start,
                    Body104.length,
                    exExFlag
                )


                val Body105 = SpannableString(
                    "\nகாயேனவாசா மனஸேந்த்ரியைர்வா புத்யாத்மனாவா ப்ரக்ருதே: ஸ்வபாவாத் கரோமியத்யத் " +
                            "ஸகலம் பரஸ்மை நாராயணாயேதி ஸமர்ப்பயாமி\nஸ்ரீமந் நாராயண ஸ்ரீ \nநாராயண நாராயண நாராயண நாராயண நாராயண நாராயண " +
                            "நாராயண நாராயண நாராயண நாராயண நாராயண \n\nப்ராயச்சித்தாநி அசேஷாணி தப: கர்ம ஆத்மகாநிவை யாநி தேஷாம் அசேஷாணாம் " +
                            "க்ருஷ்ணானுஸ்மரணம் பரம்\nஸ்ரீகிருஷ்ண ஸ்ரீகிருஷ்ண ஸ்ரீகிருஷ்ண ஸ்ரீகிருஷ்ண ஸ்ரீகிருஷ்ண ஸ்ரீகிருஷ்ண ஸ்ரீகிருஷ்ண ஸ்ரீ ிருஷ்ண " +
                            "ஸ்ரீகிருஷ்ண ஸ்ரீகிருஷ்ண ஸ்ரீகிருஷ்ண ஸ்ரீகிருஷ்ண"
                )
                Body105.setSpan(AbsoluteSizeSpan(14, true), start, Body105.length, exExFlag)
                Body105.setSpan(StyleSpan(Typeface.BOLD), start, Body105.length, exExFlag)
                Body105.setSpan(
                    ForegroundColorSpan(Color.parseColor("#0000ee")),
                    start,
                    Body105.length,
                    exExFlag
                )


                val GreenComment5 = SpannableString("\nஸவ்யம்")
                GreenComment5.setSpan(AbsoluteSizeSpan(14, true), start, GreenComment5.length, exExFlag)
                GreenComment5.setSpan(
                    StyleSpan(Typeface.BOLD_ITALIC),
                    start,
                    GreenComment5.length,
                    exExFlag
                )
                GreenComment5.setSpan(
                    ForegroundColorSpan(Color.GREEN),
                    start,
                    GreenComment5.length,
                    exExFlag
                )

                val Comment77 = SpannableString(
                    "\nஎன்று சொல்லி பவித்ரத்தை அவிழ்த்து போடவும்\n\nஆசமனம் செய்து வீபூதி இட்டுக் " +
                            "கொண்டு மறுபடி ஆசமனம் செய்யவும்"
                )
                Comment77.setSpan(AbsoluteSizeSpan(13, true), start, Comment77.length, exExFlag)
                Comment77.setSpan(StyleSpan(Typeface.ITALIC), start, Comment77.length, exExFlag)
                Comment77.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment77.length, exExFlag)
        */



        Amava_combination.append(heading, guruVndnmHd, guruVndnm, shuklaKanvasaka)
        if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { Amava_combination.append(Comment15B) }else {Amava_combination.append(Comment15A)}
        Amava_combination.append(comment15C, Heading1, Comment1, Body1, comment2, Body2, comment3, body3, comment4, Body4, Comment5,
            Body5, Comment6, Body6, Comment7, Body7, Comment8, Body8, Comment9, Body9, Comment10, Body10, Comment11, Body11, Comment12,
            Body12, comment13, Body13, Comment14, Body14)
        Amava_combination.append(pavithraTharanam, pavThaMntram, tharbeshuAsinaha, Body15, Comment16, Body16, Comment17)
        Amava_combination.append(Heading2, Body17, Comment18, Body18, Comment19, Body19, Comment20, Body20, Comment21, Body21)
        Amava_combination.append(Comment22, Body22, addnlNotes1, AddnlString1, addnlNotes2, AddnlString2, addnlNotes3, AddnlString3,
            addnlNotes4, AddnlString4, addnlNotes5, AddnlString5, addnlNotes6, AddnlString6, addnlNotes7, AddnlString7, AddnlString8,
            Comment23, Body23, Comment24, Body24, Comment25, Body25, Comment26, Body26, Comment27, Body27, Comment28, Body28, Comment29,
            Body29, Comment30, Body30, Comment31, Body31, Comment32, Body32, Comment33, Body33, Comment34, Body34, Comment35, Body35,
            Comment36, Body36, Comment37, Body37)
        Amava_combination.append(Comment38A, RedComment1, Comment38B, Body38)
        Amava_combination.append(Body39)
        if (yrGFatherLive == "Deceased") { Amava_combination.append(Body39B, Body40, Body41) } else { Amava_combination.append(
            Body39A, Body40, Body41B
        ) }
        Amava_combination.append(Body42)
        if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(
            Sabathneek1
        ) }
        if (mFatherLive == "Living") {
            Amava_combination.append(
                Body43,
                Body44,
                Body45,
                Comment39,
                GreenComment1,
                Comment40,
                Comment41,
                RedComment2,
                Comment41A
            )
            if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { Amava_combination.append(Comment41C) }else Amava_combination.append(
                Comment41B
            )
            Amava_combination.append(
                Comment41D,
                Heading3,
                Comment42,
                RedComment3,
                Comment42BOne,
                Comment42B,
                Body46, Body47
            )
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body48B, Body49, Body50) } else { Amava_combination.append(
                Body48A,
                Body49,
                Body51B
            ) }
            Amava_combination.append(Body52)
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(
                Sabathneek2
            ) }
            Amava_combination.append(Body52Add)
            if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { Amava_combination.append(Comment44) }else Amava_combination.append(
                Comment43
            )
            Amava_combination.append(Comment45)
            Amava_combination.append(Heading4, Comment46, Body53, Body54)
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body56, Body57, Body58) } else { Amava_combination.append(
                Body55, Body57, Body59B
            ) }
            Amava_combination.append(Body60)
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(
                Sabathneek3
            ) }
            Amava_combination.append( Body60Addnl, Comment47, Body61)
            if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { Amava_combination.append(Comment49) }else Amava_combination.append(
                Comment48
            )
            Amava_combination.append(Comment50)

            Amava_combination.append(Heading5Add, Body62, Body63)
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(
                Sabathneek4
            ) }
            Amava_combination.append(Body64, Body65)
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(
                Sabathneek5
            ) }
            Amava_combination.append(Body66, Body67)
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(
                Sabathneek6
            ) }
            Amava_combination.append(Body68, Body69)
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body70A) } else { Amava_combination.append(
                Body70B
            ) }
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(
                Sabathneek7
            ) }
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body71) } else { Amava_combination.append(
                Body72
            ) }
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(
                Sabathneek8
            ) }
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body74) } else { Amava_combination.append(
                Body75
            ) }
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(
                Sabathneek9
            ) }
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body77) } else { Amava_combination.append(
                Body78
            ) }
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(
                Sabathneek10
            ) }
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body80) } else { Amava_combination.append(
                Body81
            ) }
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(
                Sabathneek11
            ) }
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body83) } else { Amava_combination.append(
                Body84
            ) }
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(
                Sabathneek12
            ) }
            Amava_combination.append(Body86, Comment54NAdd)
            if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { Amava_combination.append(Comment54Ne, Comment54New) }else Amava_combination.append(
                Comment54New
            )
            Amava_combination.append(MBody91A, Comment54New2Add)
            if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { Amava_combination.append(Comment54Ne2, Comment54New3) }else Amava_combination.append(
                Comment54New3
            )
            Amava_combination.append(MBody91Again, Comment51, Body88,
                GreenComment2,
                Comment52,
                Body89,
                RedComment4,
                Comment53, Comment55, Body90
            )
            if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { Amava_combination.append(Comment56Addnl) }else Amava_combination.append(
                Comment55CAddnl
            )
            Amava_combination.append(Body91, Comment67, GreenComment3, Comment68, Body101, Comment69, Body102, Comment70, Body101N5,
                VARGAI1A, Body93, Comment59, Body94, Comment60, Body95, Comment61, Body96, VARGAI2A, Body97, Comment62,
                Heading6, RedComment5, Body98)
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(
                Sabathneek13
            ) }
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body99A) } else { Amava_combination.append(
                Body99B
            ) }
            if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { Amava_combination.append(Comment56ANNew) }else Amava_combination.append(
                Comment56ANeAddnl
            )
            Amava_combination.append(Comment66, Body100, RedComment6, Comment72)
            if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { Amava_combination.append(Comment75) }else Amava_combination.append(
                Comment74
            )
            Amava_combination.append(Comment76, Body106, Body107Big, Body108, GreenComment4, Comment71,
                Body103, Comment56A, Heading7)

        } else {
            Amava_combination.append(MBody38)
            if (motherLive == "Deceased" && motherMotherLive == "Deceased") { Amava_combination.append(
                MSabathneek1
            ) }
            Amava_combination.append(MBody41B, MBody44, Body45, Comment39, GreenComment1, Comment40, MComment40, Comment41, RedComment2, Comment41A)
            if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { Amava_combination.append(Comment41C) }else Amava_combination.append(
                Comment41B
            )
            Amava_combination.append(Comment41D, Heading3, Comment42, RedComment3, Comment42A, MComment42A, Comment42B, MComment42D, Body46)
            Amava_combination.append(Body47)
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body48B, Body49, Body50) } else { Amava_combination.append(
                Body48A, Body49, Body51B
            ) }
            Amava_combination.append(Body52)
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(
                Sabathneek2
            ) }
            Amava_combination.append(Body52Add)
            if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { Amava_combination.append(Comment44) }else Amava_combination.append(
                Comment43
            )
            Amava_combination.append(Comment45)
            Amava_combination.append(Heading4, Comment46, Body53)
            Amava_combination.append(Body54)
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body56, Body57, Body58) } else { Amava_combination.append(
                Body55, Body57, Body59B
            ) }
            Amava_combination.append(Body60)
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(
                Sabathneek3
            ) }
            Amava_combination.append(Body60Addnl)
            Amava_combination.append(Comment47, Body61)
            if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { Amava_combination.append(Comment49) }else Amava_combination.append(
                Comment48
            )
            Amava_combination.append(Comment50, MSComment42A, MSEComment42A, MComment42B, MComment42C, MBody46)
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(
                MSabathneek2
            ) }
            Amava_combination.append(MBody51B)
            if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { Amava_combination.append(Comment44x) }else Amava_combination.append(
                Comment43x
            )
            Amava_combination.append(Comment45x)
            Amava_combination.append(MHeading4, MComment46A, MBody53)
            if (motherMotherLive == "Deceased" && mFatherLive == "Deceased") { Amava_combination.append(
                MSabathneek3
            ) }
            Amava_combination.append(MBody51C, MComment46x, MBody61)
            if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { Amava_combination.append(Comment49x) }else Amava_combination.append(
                Comment48x
            )
            Amava_combination.append(Comment50x)
//*******************************************************
            Amava_combination.append(Heading5, Body62)
            Amava_combination.append(Body63)
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(
                Sabathneek4
            ) }
            Amava_combination.append(Body64, Body65)
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(
                Sabathneek5
            ) }
            Amava_combination.append(Body66, Body67)
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(
                Sabathneek6
            ) }
            Amava_combination.append(Body68)
            Amava_combination.append(Body69)
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body70A) } else { Amava_combination.append(
                Body70B
            ) }
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(
                Sabathneek7
            ) }
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body71) } else { Amava_combination.append(
                Body72
            ) }
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(
                Sabathneek8
            ) }
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body74) } else { Amava_combination.append(Body75
            ) }
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(
                Sabathneek9
            ) }
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body77) } else { Amava_combination.append(
                Body78
            ) }
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(
                Sabathneek10
            ) }
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body80) } else { Amava_combination.append(
                Body81
            ) }
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(
                Sabathneek11
            ) }
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body83) } else { Amava_combination.append(
                Body84
            ) }
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(
                Sabathneek12
            ) }
            Amava_combination.append(Body86)
//*******************************************************************************************************
            Amava_combination.append(MHeading5, MBody62)
            if (motherLive == "Deceased" && motherMotherLive == "Deceased") { Amava_combination.append(
                MSabathneek4
            ) }
            Amava_combination.append(MBody63)
            if (motherLive == "Deceased" && motherMotherLive == "Deceased") { Amava_combination.append(
                MSabathneek5
            ) }
            Amava_combination.append(MBody64)
            if (motherLive == "Deceased" && motherMotherLive == "Deceased") { Amava_combination.append(
                M2Sabathneek5
            ) }
            Amava_combination.append(MBody66)
            if (motherLive == "Deceased" && motherMotherLive == "Deceased") { Amava_combination.append(
                MSabathneek6
            ) }
            Amava_combination.append(MBody68)
            if (motherLive == "Deceased" && motherMotherLive == "Deceased") { Amava_combination.append(
                MSabathneek7
            ) }
            Amava_combination.append(MBody69)
            if (motherLive == "Deceased" && motherMotherLive == "Deceased") { Amava_combination.append(
                MSabathneek8
            ) }
            Amava_combination.append(MBody71)
            if (motherLive == "Deceased" && motherMotherLive == "Deceased") { Amava_combination.append(
                MSabathneek9
            ) }
            Amava_combination.append(MBody72)
            if (motherLive == "Deceased" && motherMotherLive == "Deceased") { Amava_combination.append(
                MSabathneek10
            ) }
            Amava_combination.append(MBody74)
            if (motherLive == "Deceased" && motherMotherLive == "Deceased") { Amava_combination.append(
                MSabathneek11
            ) }
            Amava_combination.append(MBody75, Comment54N)
//*************************************************************************
            if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { Amava_combination.append(Comment54Ne, Comment54New) }else Amava_combination.append(
                Comment54New
            )
            Amava_combination.append(MBody91A, Comment54New2)
            if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { Amava_combination.append(Comment54Ne2, Comment54New3) }else Amava_combination.append(
                Comment54New3
            )
            Amava_combination.append(MBody91Again, Comment51, Body88, GreenComment2, Comment52, Body89, RedComment4, Comment53, Comment54, Comment55, Body90)
            if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { Amava_combination.append(Comment56) }else Amava_combination.append(
                Comment55C
            )
            Amava_combination.append(Body91)
            if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { Amava_combination.append(Comment55B) }else Amava_combination.append(
                Comment57
            )
            Amava_combination.append(MBody91, Comment67, GreenComment3, Comment68, Body101, Comment69, Body102, Comment70, Body101N5,
                VARGAI1B, Body93, Comment59, Body94, Comment60, Body95, Comment61, Body96, VARGAI2B, Body97, Comment62,
                Heading6, RedComment5, Body98)
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased" && yrGFatherLive == "Deceased") { Amava_combination.append(
                Sabathneek13
            )}
            if (yrGFatherLive == "Deceased") { Amava_combination.append(Body99A) } else { Amava_combination.append(
                Body99B
            ) }
            if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { Amava_combination.append(Comment56AN) }else Amava_combination.append(
                Comment56ANe)
            Amava_combination.append(MBody98)
            if (motherMotherLive == "Deceased") { Amava_combination.append(
                Sabathneek13A
            ) }
            Amava_combination.append(MBody98A)
            if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { Amava_combination.append(Comment56ANe1) }else Amava_combination.append(
                Comment56ANew)
            Amava_combination.append(Comment66, Body100, RedComment6, Comment72, Comment73)
            if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { Amava_combination.append(Comment75) }else Amava_combination.append(
                Comment74)
            Amava_combination.append(Comment76, Body106, Body107Big, Body108, GreenComment4, Comment71, Body103, Comment56A, Heading7)
        }

        Amava_combination.append("\n\n")
        binding.amavasyaTPNMTextView.text = Amava_combination

        binding.amavasyaTPNMTextView.post {
            val lineCount = binding.amavasyaTPNMTextView.lineCount
            println("No. of Lines : $lineCount")
        }

        printBtn.setOnClickListener {
            val lineCount = binding.amavasyaTPNMTextView.lineCount
            val linesPerPage = 50
            totalPages = ceil(lineCount.toDouble() / linesPerPage).toInt()

            // Build all page boundaries dynamically
            pageBoundaries.clear()
            for (page in 0 until totalPages) {
                val startLine = page * linesPerPage
                val endLine = min(startLine + linesPerPage, lineCount)
                val layout = binding.amavasyaTPNMTextView.layout
                val startPos = layout.getLineStart(startLine)
                val endPos = layout.getLineEnd(endLine - 1)
                pageBoundaries.add(Pair(startPos, endPos))
                println("Page ${page+1} - startPos: $startPos, endPos: $endPos")
            }

            val printManager = getSystemService(Context.PRINT_SERVICE) as? PrintManager
            if (printManager != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                val jobName = getString(R.string.app_name) + "-$heading"
                printManager.print(jobName, MyPrintDocumentAdapter(this, heading, Amava_combination, pageBoundaries, totalPages), null)
            } else {
                Toast.makeText(this, "Print not supported on this device", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Scroll animation on text
    private fun scrText() {
        val scrollView = findViewById<ScrollView>(R.id.root_layout)
        scrollView.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
            override fun onGlobalLayout() {
                scrollView.viewTreeObserver.removeOnGlobalLayoutListener(this)
                val objectAnimator = ObjectAnimator.ofInt(
                    scrollView, "scrollY", scrollView.getChildAt(0).height - scrollView.height
                )
                objectAnimator.duration = (binding.seekBar.max * 1000).toLong()
                objectAnimator.interpolator = LinearInterpolator()
                objectAnimator.start()
            }
        })
    }

    // Media setup (play, pause, stop, seek)
    private fun setupMediaControls() {
        binding.btnPlay.setOnClickListener {
            val audioManager = getSystemService(AUDIO_SERVICE) as AudioManager
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 50, 0)
            if (paused) {
                mediaPlayer.seekTo(mediaPlayer.currentPosition)
                mediaPlayer.start()
                paused = false
            } else {
                scrText()
                mediaPlayer = MediaPlayer.create(this, R.raw.masterdouble)// switch on your state
                mediaPlayer.start()
                binding.amavasyaTPNMTextView.movementMethod = ScrollingMovementMethod()
            }
            mediaPlayer.setOnCompletionListener {
                binding.btnPlay.isEnabled = true
                binding.buttonPausePlay.isEnabled = false
                binding.btnStop.isEnabled = false
            }
            initializeSeekBar()
        }
        binding.buttonPausePlay.setOnClickListener {
            if (::mediaPlayer.isInitialized && mediaPlayer.isPlaying) {
                mediaPlayer.pause()
                paused = true
                binding.btnPlay.isEnabled = true
                binding.buttonPausePlay.isEnabled = false
                binding.btnStop.isEnabled = true
            }
        }
        binding.btnStop.setOnClickListener {
            if (::mediaPlayer.isInitialized && (mediaPlayer.isPlaying || paused)) {
                paused = false
                binding.seekBar.progress = 0
                mediaPlayer.stop()
                mediaPlayer.reset()
                mediaPlayer.release()
                handler.removeCallbacks(runnable)
                binding.btnPlay.isEnabled = true
                binding.buttonPausePlay.isEnabled = false
                binding.btnStop.isEnabled = false
                binding.tvPass.text = ""
                binding.tvDue.text = ""
            }
        }
        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                if (fromUser && ::mediaPlayer.isInitialized) {
                    mediaPlayer.seekTo(progress * 1000)
                }
            }
            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })
    }

    private fun initializeSeekBar() {
        try {
            val duration = mediaPlayer.duration
            binding.seekBar.max = duration / 1000
        } catch (e: IllegalStateException) {}
        runnable = object : Runnable {
            override fun run() {
                if (::mediaPlayer.isInitialized && mediaPlayer.isPlaying) {
                    binding.seekBar.progress = mediaPlayer.currentSeconds
                    val seconds = mediaPlayer.currentSeconds % 60
                    val minutes = mediaPlayer.currentSeconds / 60
                    binding.tvPass.text = String.format("Time Completed - %02d:%02d", minutes, seconds)
                    val diff = mediaPlayer.seconds - mediaPlayer.currentSeconds
                    val dSeconds = diff % 60
                    val dMinutes = diff / 60
                    binding.tvDue.text = String.format("Time to Finish - %02d:%02d", dMinutes, dSeconds)
                    handler.postDelayed(this, 1000)
                }
            }
        }
        handler.postDelayed(runnable, 1000)
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    class MyPrintDocumentAdapter(
        private val context: Context,
        private val heading: SpannableString,
        private val fullText: SpannableStringBuilder,
        private val pageBoundaries: List<Pair<Int, Int>>,
        private val totalPages: Int
    ) : PrintDocumentAdapter() {

        private var pdfDocument: PdfDocument? = null
        private var pageHeight = 0
        private var pageWidth = 0

        override fun onLayout(oldAttributes: PrintAttributes, newAttributes: PrintAttributes,
                              cancellationSignal: CancellationSignal, callback: LayoutResultCallback, metadata: Bundle) {
            pdfDocument = PrintedPdfDocument(context, newAttributes)
            pageHeight = (newAttributes.mediaSize!!.heightMils - 60) / 1000 * 72
            pageWidth = (newAttributes.mediaSize!!.widthMils - 40) / 1000 * 72
            if (cancellationSignal.isCanceled) {
                callback.onLayoutCancelled()
                return
            }
            val builder = PrintDocumentInfo.Builder("$heading.pdf")
                .setContentType(PrintDocumentInfo.CONTENT_TYPE_DOCUMENT)
                .setPageCount(totalPages)
                .build()
            callback.onLayoutFinished(builder, true)
        }

        private fun drawPage(page: PdfDocument.Page, pageNum: Int) {
            val canvas = page.canvas
            val paint = Paint().apply {
                color = Color.BLACK
                textSize = 14f
            }
            // Add images if required
            val logo = BitmapFactory.decodeResource(context.resources, R.drawable.mediumlogo75px)
            val bground = BitmapFactory.decodeResource(context.resources, R.drawable.yvkr)
            canvas.drawBitmap(logo, (canvas.width / 12 - logo.width / 6).toFloat(), 0f, paint)
            canvas.drawBitmap(bground, (canvas.width / 2 - bground.width / 2).toFloat(), (canvas.height / 2 - bground.height / 2).toFloat(), paint)

            // Page content
            val (startPos, endPos) = pageBoundaries[pageNum]
            val pageText = fullText.subSequence(startPos, endPos)
            val mTextPaint = TextPaint()
            val mTextLayout = StaticLayout(pageText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
            mTextLayout.draw(canvas)

            // Footer
            val exExFlag = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            val footerText = SpannableString("$heading (Page No. ${pageNum + 1} of $totalPages)").apply {
                setSpan(AbsoluteSizeSpan(11, true), 0, length, exExFlag)
                setSpan(StyleSpan(Typeface.ITALIC), 0, length, exExFlag)
                setSpan(ForegroundColorSpan(Color.RED), 0, length, exExFlag)
            }
            paint.textSize = 13f
            canvas.drawText(footerText.toString(), (canvas.width / 3).toFloat(), (canvas.height).toFloat(), paint)
        }

        override fun onWrite(pageRanges: Array<PageRange>, destination: ParcelFileDescriptor,
                             cancellationSignal: CancellationSignal, callback: WriteResultCallback) {
            for (i in 0 until totalPages) {
                val range = pageRanges.any { range -> i >= range.start && i <= range.end }
                if (range) {
                    val newPage = PdfDocument.PageInfo.Builder(pageWidth, pageHeight, i).create()
                    val page = pdfDocument!!.startPage(newPage)
                    if (cancellationSignal.isCanceled) {
                        callback.onWriteCancelled()
                        pdfDocument!!.close()
                        pdfDocument = null
                        return
                    }
                    drawPage(page, i)
                    pdfDocument!!.finishPage(page)
                }
            }
            try {
                pdfDocument!!.writeTo(FileOutputStream(destination.fileDescriptor))
            } catch (e: IOException) {
                callback.onWriteFailed(e.toString())
                return
            } finally {
                pdfDocument!!.close()
                pdfDocument = null
            }
            callback.onWriteFinished(pageRanges)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (::mediaPlayer.isInitialized) {
            if (mediaPlayer.isPlaying) mediaPlayer.stop()
            mediaPlayer.release()
        }
        handler.removeCallbacks(runnable)
    }
}