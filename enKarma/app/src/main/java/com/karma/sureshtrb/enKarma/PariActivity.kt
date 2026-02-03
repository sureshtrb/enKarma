package com.karma.sureshtrb.enKarma

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.os.Build
import android.os.Bundle
import android.os.CancellationSignal
import android.os.ParcelFileDescriptor
import android.print.PrintAttributes
import android.print.PrintDocumentAdapter
import android.print.PrintManager
import android.text.Html
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.karma.sureshtrb.enKarma.databinding.ActivityPariBinding
import java.io.FileOutputStream
import java.io.IOException
import android.print.PrintDocumentInfo
import android.print.PageRange

class PariActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPariBinding
    private val totalPages = 1

    @SuppressLint("SetTextI18n", "RestrictedApi")
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPariBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.apply {
            setHomeAsUpIndicator(R.drawable.home)
            setDisplayHomeAsUpEnabled(true)
            subtitle = "Pariseshanam / பரிசேஷணம்"
            setDisplayShowHomeEnabled(true)
            setLogo(R.drawable.karma)
            setDisplayUseLogoEnabled(true)
        }

        val headerHtml = """
            <b><u><h2><font color='#5a00b3'>ஆபோஜனம்</font></h2></u>
            <font color='#8f8f8f'><i>{உணவு பரிமாறியப்பின் நெய் விட்டவுடன் வலது கையை குழிவாக வைத்துக்கொன்டு ஜலம் ஊற்றிக்கொண்டு இலையை மூன்றுமுறை வலமாக சுற்றி அருந்தவும்}</i></font>
            <b><h4><font color='#0000ec'>ஓம் பூர் புவஸ்வ: தத்ஸவிதுர் வரேண்யம் பர்கோ தேவஸ்ய தீமஹி தியோயோ ந: ப்ரசோதயாத்</font></h4></b>
            <b><h4><font color='#0000ec'>ஸத்யம் த்வர்தேன</font></h4></b><font color='#8f8f8f'><i>-(பகல்)</i></font>
            <b><h4><font color='#0000ec'>ருதம் த்வாஸத்யேன</font></h4></b><font color='#8f8f8f'><i>-(இரவு)</i></font><br /><br />
            <font color='#8f8f8f'><i>{ஒவ்வொரு பருக்கையாக ஒவ்வொரு மந்திரம் சொல்லு பல் படாமல் வாயில் போட்டு முழுங்கவும்}</i></font>
            <b><h4><font color='#0000ec'>பரிஷந்சாமி தேவ சவிதா ப்ரஸுவா அம்ருதோபஸ்தரநமஸி<br />
            ஓம் ப்ராணாயஸ்வா:<br />
            ஓம் அபானாயஸ்வா:<br />
            ஓம் வ்யானாயஸ்வா:<br />
            ஓம் உதானாயஸ்வா:<br />
            ஓம் ஸமாநாயஸ்வா:<br />
            சசேதஶ ஸுகாத்மணேஸ்வாஹா:<br />
            ப்ரும்மநேஸ்வா:<br />
            ஓம் ப்ரம்ஹநிமாத்மா அம்ருதத்வாயா</font></h4>
            <font color='#8f8f8f'><i>{இடது கையால் ஜலம் தொட்டு மார்பைத் தொடவும்}</i></font>
            <u><h2><font color='#5a00b3'>உத்தரா போஜனம்</font></h2></u>
            <font color='#8f8f8f'><i>{உணவுண்டவுடன் வலது கையை குழிவாக வைத்துக்கொன்டு ஜலம் ஊற்றிக்கொண்டு சிறிது அருந்தி இலையை மூன்றுமுறை இடமாகச் சுற்றி உடன் எழுந்திருக்கவும்}</i></font>
            <b><h4><font color='#0000ec'>அமிர்த பிதா நமஸி ரௌரவே அபுண்யயநிலயே பத்மாத்புத நிவாஸினாம் அர்திணாம் உதகம் தத்தம் அக்ஷ்யம் உபதிஷ்டது அன்னதாதா ஸுகீபவ:</font></h4></b>
            <i><h2><font color='#9d6262'>முற்றும்</font></h2></i>
        """.trimIndent()

        binding.pariTextView.text = Html.fromHtml(headerHtml, Html.FROM_HTML_MODE_LEGACY)

        binding.printButton.setOnClickListener {
            val printManager = getSystemService(Context.PRINT_SERVICE) as PrintManager
            val jobName = getString(R.string.app_name) + " பரிசேஷணம்"
            printManager.print(
                jobName,
                MyPrintDocumentAdapter(this, binding.pariTextView.text.toString()),
                null
            )
            Toast.makeText(this, "Printing started", Toast.LENGTH_SHORT).show()
        }
    }

    inner class MyPrintDocumentAdapter(
        private val context: Context,
        private val documentText: String
    ) : PrintDocumentAdapter() {

        private var pdfDocument: PdfDocument? = null
        private var pageHeight: Int = 0
        private var pageWidth: Int = 0

        override fun onLayout(
            oldAttributes: PrintAttributes?,
            newAttributes: PrintAttributes,
            cancellationSignal: CancellationSignal?,
            callback: LayoutResultCallback?,
            extras: Bundle?
        ) {
            pdfDocument = PdfDocument()

            pageWidth = newAttributes.mediaSize?.widthMils?.times(72)?.div(1000) ?: 0
            pageHeight = newAttributes.mediaSize?.heightMils?.times(72)?.div(1000) ?: 0

            if (cancellationSignal?.isCanceled == true) {
                callback?.onLayoutCancelled()
                return
            }

            val info = PrintDocumentInfo.Builder("பரிசேஷணம்.pdf")
                .setContentType(PrintDocumentInfo.CONTENT_TYPE_DOCUMENT)
                .setPageCount(totalPages)
                .build()

            callback?.onLayoutFinished(info, true)
        }

        override fun onWrite(
            pages: Array<PageRange>,
            destination: ParcelFileDescriptor,
            cancellationSignal: CancellationSignal,
            callback: WriteResultCallback
        ) {
            val pageInfo = PdfDocument.PageInfo.Builder(pageWidth, pageHeight, 1).create()
            val page = pdfDocument?.startPage(pageInfo)

            page?.canvas?.let { canvas ->
                val textPaint = TextPaint()
                textPaint.color = Color.BLACK
                textPaint.textSize = 14f

                val staticLayout = StaticLayout.Builder.obtain(documentText, 0, documentText.length, textPaint, pageWidth)
                    .setAlignment(Layout.Alignment.ALIGN_NORMAL)
                    .setLineSpacing(0f, 1f)
                    .setIncludePad(false)
                    .build()

                canvas.save()
                canvas.translate(10f, 10f)
                staticLayout.draw(canvas)
                canvas.restore()
            }

            pdfDocument?.finishPage(page)

            try {
                pdfDocument?.writeTo(FileOutputStream(destination.fileDescriptor))
            } catch (e: IOException) {
                callback.onWriteFailed(e.toString())
                return
            } finally {
                pdfDocument?.close()
                pdfDocument = null
            }

            callback.onWriteFinished(arrayOf(PageRange.ALL_PAGES))
        }
    }
}
