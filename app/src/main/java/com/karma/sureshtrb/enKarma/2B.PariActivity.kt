package com.karma.sureshtrb.enKarma

//import kotlinx.android.synthetic.main.activity_pari.*
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.graphics.pdf.PdfDocument.PageInfo
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
import android.text.StaticLayout
import android.text.TextPaint
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import com.karma.sureshtrb.enKarma.databinding.ActivityPariBinding
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream

class PariActivity : AppCompatActivity() {

    @SuppressLint("WrongViewCast")
    private lateinit var binding: ActivityPariBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_pari)
        binding = ActivityPariBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //    supportActionBar!!.title = "back"
        supportActionBar!!.setHomeAsUpIndicator(R.drawable.home)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.subtitle = "Pariseshanam / பரிசேஷணம்"
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setLogo(R.drawable.karma)
        supportActionBar!!.setDisplayUseLogoEnabled(true)

        val headerRow = HtmlCompat.fromHtml("<b><b><b><b><u><h2><font color='#5a00b3'>ஆபோஜனம்</font></h2></u>" +
                "<font color='#8f8f8f'><i>{உணவு பரிமாறியப்பின் நெய் விட்டவுடன் வலது கையை குழிவாக " +
                "வைத்துக்கொன்டு ஜலம் ஊற்றிக்கொண்டு இலையை மூன்றுமுறை வலமாக சுற்றி அருந்தவும்)</i></font>" +
                "<b><h4><font color='#0000ec'>ஓம் பூர் புவஸ்வ: தத்ஸவிதுர் வரேண்யம் பர்கோ தேவஸ்ய தீமஹி தியோயோ ந: ப்ரசோதயாத்</font></h4</b>" +
                "<b><h4><font color='#0000ec'>ஸத்யம் த்வர்தேன</font></h4></b><font color='#8f8f8f'><i>-(பகல்)</i></font>" +
                "<b><h4><font color='#0000ec'>ருதம் த்வாஸத்யேன</font></h4></b><font color='#8f8f8f'><i>-(இரவு)</i></font><br /><br />" +
                "<font color='#8f8f8f'><i>{ஒவ்வொரு பருக்கையாக ஒவ்வொரு மந்திரம் சொல்லு பல் படாமல் வாயில் போட்டு முழுங்கவும்)</i></font>" +
                "<b><h4><font color='#0000ec'>பரிஷந்சாமி தேவ சவிதா ப்ரஸுவா அம்ருதோபஸ்தரநமஸி<br />" +
                "ஓம் ப்ராணாயஸ்வா:<br />" +
                "ஓம் அபானாயஸ்வா:<br />" +
                "ஓம் வ்யானாயஸ்வா:<br />" +
                "ஓம் உதானாயஸ்வா:<br />" +
                "ஓம் ஸமாநாயஸ்வா:<br />" +
                "சசேதஶ ஸுகாத்மணேஸ்வாஹா:<br />" +
                "ப்ரும்மநேஸ்வா:<br />" +
                "ஓம் ப்ரம்ஹநிமாத்மா அம்ருதத்வாயா</font></h4>" +
                "<font color='#8f8f8f'><i>{இடது கையால் ஜலம் தொட்டு மார்பைத் தொடவும்)</i></font>" +
                "<u><h2><font color='#5a00b3'>உத்தரா போஜனம்</font></h2></u>" +
                "<font color='#8f8f8f'><i>{உணவுண்டவுடன் வலது கையை குழிவாக வைத்துக்கொன்டு ஜலம் ஊற்றிக்கொண்டு சிறிது அருந்தி இலையை மூன்றுமுறை இடமாகச் சுற்றி உடன் எழுந்திருக்கவும்)</i></font>" +
                "<b><h4><font color='#0000ec'>அமிர்த பிதா நமஸி ரௌரவே அபுண்யயநிலயே பத்மாத்புத நிவாஸினாம் அர்திணாம் உதகம் தத்தம் அக்ஷ்யம் உபதிஷ்டது அன்னதாதா ஸுகீபவ:</font></h4></b>" +
                "<i><h2><font color='#9d6262'>முற்றும்</font></h2></i>", HtmlCompat.FROM_HTML_MODE_LEGACY) // and <i>italic</i> stuff")
        val pariCombination = headerRow
        binding.pariTextView.text = pariCombination

        class MyPrintDocumentAdapter(private var context: Context) : PrintDocumentAdapter() {
            private var pageHeight: Int = 0
            private var pageWidth: Int = 0
            private var myPdfDocument: PdfDocument? = null
            private var totalpages:Int = 1

            private fun drawPage(page: PdfDocument.Page,
                                 pagenumber: Int) {
                var pagenum = pagenumber
                val canvas = page.canvas

                pagenum++ // Make sure page numbers start at 1

                val paint = Paint()
                paint.color = Color.RED
                paint.textSize = 10f
                val mTextPaint =  TextPaint()
                // Updated StaticLayout creation using Builder
                val text = "பரிசேஷணம் PAGE - $pagenum / $totalpages" // Using string template
                val mTextLayout1 = StaticLayout.Builder
                    .obtain(text, 0, text.length, mTextPaint, canvas.width) // Provide start and end indices
                    .setAlignment(Layout.Alignment.ALIGN_NORMAL)
                    .setLineSpacing(0.0f, 1.0f) // spacingadd, spacingmult
                    .setIncludePad(false)
                    .build()
                paint.textSize = 14f
                val mTextLayout = StaticLayout.Builder
                    .obtain(pariCombination, 0, pariCombination.length, mTextPaint, canvas.width) // Provide start and end indices
                    .setAlignment(Layout.Alignment.ALIGN_CENTER)
                    .setLineSpacing(0.0f, 1.0f) // spacingadd, spacingmult
                    .setIncludePad(true)
                    .build()


                canvas.save()

                // canvas.translate(textX, textY);
                //   canvas.drawText(pariCombination.toString(), leftMargin.toFloat(), (titleBaseLine + 35).toFloat(), paint)
                mTextLayout.draw(canvas)
                mTextLayout1.draw(canvas)
                canvas.restore()

                if (pagenum % 2 == 0)
                    paint.color = Color.RED
                else
                    paint.color = Color.GREEN
              //  val pageInfo = page.info
                //  canvas.drawCircle((pageInfo.pageWidth / 2).toFloat(), (pageInfo.pageHeight / 2).toFloat(), 150f, paint)
            }
            private fun pageInRange(pageRanges: Array<PageRange>, page: Int): Boolean {
                for (i in pageRanges.indices) {
                    if (page >= pageRanges[i].start && page <= pageRanges[i].end)
                        return true
                }
                return false
            }
            override fun onLayout(oldAttributes: PrintAttributes,
                                  newAttributes: PrintAttributes,
                                  cancellationSignal: CancellationSignal,
                                  callback:
                                  LayoutResultCallback,
                                  metadata: Bundle) {
                myPdfDocument = PrintedPdfDocument(context, newAttributes)

                val height = newAttributes.mediaSize!!.heightMils
                val width = newAttributes.mediaSize!!.heightMils

                height.let {
                    pageHeight = it / 1000 * 72
                    println("pageHeight : $pageHeight")
                }
                width.let {
                    this.pageWidth = it / 1300 * 72
                    println("pageWidth : ${this.pageWidth}")
                }
                if (cancellationSignal.isCanceled) {
                    callback.onLayoutCancelled()
                    (this.myPdfDocument as PrintedPdfDocument).close()
                    this.myPdfDocument = null
                    return
                }
                if (totalpages > 0) {
                    val builder =
                        PrintDocumentInfo.Builder("பரிசேஷணம்.pdf").setContentType(
                            PrintDocumentInfo.CONTENT_TYPE_DOCUMENT)
                            .setPageCount(totalpages)

                    val info = builder.build()
                    callback.onLayoutFinished(info, true)
                } else {
                    callback.onLayoutFailed("Page count is zero.")
                }
            }

            override fun onWrite(pageRanges: Array<PageRange>,
                                 destination: ParcelFileDescriptor,
                                 cancellationSignal: CancellationSignal,
                                 callback:
                                 WriteResultCallback) {
                for (i in 0 until totalpages) {
                    if (pageInRange(pageRanges, i)) {
                        val newPage = PageInfo.Builder(this.pageWidth, pageHeight, i).create()
                        val page = this.myPdfDocument?.startPage(newPage)

                        if (cancellationSignal.isCanceled) {
                            callback.onWriteCancelled()
                            this.myPdfDocument?.close()
                            this.myPdfDocument = null
                            return
                        }
                        page.let {
                            it?.let { it1 -> drawPage(it1, i) }
                        }
                        this.myPdfDocument?.finishPage(page)
                    }
                }
                try {
                    this.myPdfDocument?.writeTo(FileOutputStream(destination.fileDescriptor) as OutputStream?)
                } catch (e: IOException) {
                    callback.onWriteFailed(e.toString())
                    return
                } finally {
                    this.myPdfDocument?.close()
                    this.myPdfDocument = null
                }
                callback.onWriteFinished(pageRanges)
            }
        }
        val btnPrint = findViewById<Button>(R.id.printButton)
        btnPrint.setOnClickListener{

            val printManager = this
                .getSystemService(PRINT_SERVICE) as PrintManager

            val jobName = this.getString(R.string.app_name) + " பரிசேஷணம்"
            println("jobName : $jobName")
            printManager.print(jobName, MyPrintDocumentAdapter(this), null)
        }
    }
}