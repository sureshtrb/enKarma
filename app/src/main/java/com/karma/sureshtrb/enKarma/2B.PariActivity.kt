package com.sureshtrb.enKarma

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.pdf.PdfDocument
import android.graphics.pdf.PdfDocument.PageInfo
import android.os.Build
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
import androidx.core.content.ContextCompat
import com.sureshtrb.enKarma.databinding.ActivityPariBinding
import java.io.FileOutputStream
import java.io.IOException
import java.io.OutputStream

class PariActivity : AppCompatActivity() {

    @SuppressLint("WrongViewCast")
    private lateinit var binding: ActivityPariBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPariBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.apply {
            setHomeAsUpIndicator(R.drawable.home)
            setDisplayHomeAsUpEnabled(true)
            subtitle = "Pariseshanam / பரிசேஷணம்"
            setDisplayShowHomeEnabled(true)
            setLogo(R.drawable.karma)
            setDisplayUseLogoEnabled(true)
        }

        val headerRow = HtmlCompat.fromHtml(
            "<b><h2><font color='#5a00b3'>ஆபோஜனம்</font></h2></b>" +
                    "<i><font color='#8f8f8f'>{உணவு பரிமாறியப்பின் நெய் விட்டவுடன்...}</font></i>",
            HtmlCompat.FROM_HTML_MODE_LEGACY
        )

        binding.pariTextView.text = headerRow

        class MyPrintDocumentAdapter(private val context: Context) : PrintDocumentAdapter() {
            private var pageHeight: Int = 0
            private var pageWidth: Int = 0
            private var myPdfDocument: PdfDocument? = null
            private var totalPages = 1

            private fun drawPage(page: PdfDocument.Page, pageNumber: Int) {
                val canvas = page.canvas
                val paint = Paint().apply {
                    color = if (pageNumber % 2 == 0) Color.RED else Color.GREEN
                    textSize = 10f
                }

                val textPaint = TextPaint()

                val text = "பரிசேஷணம் PAGE - ${pageNumber + 1} / $totalPages"
                val textLayout = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    StaticLayout.Builder.obtain(text, 0, text.length, textPaint, canvas.width)
                        .setAlignment(Layout.Alignment.ALIGN_NORMAL)
                        .setLineSpacing(0.0f, 1.0f)
                        .setIncludePad(false)
                        .build()
                } else {
                    StaticLayout(text, textPaint, canvas.width, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false)
                }

                val contentLayout = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    StaticLayout.Builder.obtain(headerRow, 0, headerRow.length, textPaint, canvas.width)
                        .setAlignment(Layout.Alignment.ALIGN_CENTER)
                        .setLineSpacing(0.0f, 1.0f)
                        .setIncludePad(true)
                        .build()
                } else {
                    StaticLayout(headerRow, textPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, true)
                }

                canvas.save()
                contentLayout.draw(canvas)
                textLayout.draw(canvas)
                canvas.restore()
            }

            override fun onLayout(
                oldAttributes: PrintAttributes, newAttributes: PrintAttributes,
                cancellationSignal: CancellationSignal, callback: LayoutResultCallback, metadata: Bundle
            ) {
                myPdfDocument = PrintedPdfDocument(context, newAttributes)
                pageHeight = (newAttributes.mediaSize?.heightMils ?: 0) / 1000 * 72
                pageWidth = (newAttributes.mediaSize?.widthMils ?: 0) / 1000 * 72

                if (cancellationSignal.isCanceled) {
                    callback.onLayoutCancelled()
                    myPdfDocument?.close()
                    myPdfDocument = null
                    return
                }

                val info = PrintDocumentInfo.Builder("பரிசேஷணம்.pdf")
                    .setContentType(PrintDocumentInfo.CONTENT_TYPE_DOCUMENT)
                    .setPageCount(totalPages)
                    .build()

                callback.onLayoutFinished(info, true)
            }

            override fun onWrite(
                pageRanges: Array<PageRange>, destination: ParcelFileDescriptor,
                cancellationSignal: CancellationSignal, callback: WriteResultCallback
            ) {
                for (i in 0 until totalPages) {
                    if (pageRanges.any { i in it.start..it.end }) {
                        val pageInfo = PageInfo.Builder(pageWidth, pageHeight, i).create()
                        val page = myPdfDocument?.startPage(pageInfo)

                        if (cancellationSignal.isCanceled) {
                            callback.onWriteCancelled()
                            myPdfDocument?.close()
                            myPdfDocument = null
                            return
                        }

                        page?.let { drawPage(it, i) }
                        myPdfDocument?.finishPage(page)
                    }
                }

                try {
                    myPdfDocument?.writeTo(FileOutputStream(destination.fileDescriptor) as OutputStream?)
                } catch (e: IOException) {
                    callback.onWriteFailed(e.toString())
                    return
                } finally {
                    myPdfDocument?.close()
                    myPdfDocument = null
                }

                callback.onWriteFinished(pageRanges)
            }
        }

        val btnPrint = findViewById<Button>(R.id.printButton)
        btnPrint.setOnClickListener {
            val printManager = getSystemService(PRINT_SERVICE) as PrintManager
            val jobName = getString(R.string.app_name) + " பரிசேஷணம்"
            printManager.print(jobName, MyPrintDocumentAdapter(this), null)
        }
    }
}
