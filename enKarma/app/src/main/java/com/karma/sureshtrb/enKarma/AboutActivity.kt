package com.karma.sureshtrb.enKarma

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

    private lateinit var binding: ActivityAboutBinding

    // Reuse flags to keep behaviour consistent
    private val exExFlag = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
    // private val incIncFlag = Spanned.SPAN_INCLUSIVE_INCLUSIVE // kept for reference if needed

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Safe action bar setup
        supportActionBar?.apply {
            setHomeAsUpIndicator(R.drawable.home)
            setDisplayHomeAsUpEnabled(true)
            subtitle = "குறிப்பு"
            setDisplayShowHomeEnabled(true)
            setLogo(R.drawable.karma)
            setDisplayUseLogoEnabled(true)
        }

        // Header: ABOUT
        val headerText = "ABOUT"
        val header = SpannableString("\n\n\n\n    $headerText\n")
        header.setSpan(AbsoluteSizeSpan(20, true), 0, header.length, exExFlag)
        header.setSpan(StyleSpan(Typeface.BOLD), 0, header.length, exExFlag)
        // underline only the word "ABOUT" (compute start index)
        val aboutStart = header.indexOf(headerText)
        if (aboutStart >= 0) {
            header.setSpan(UnderlineSpan(), aboutStart, aboutStart + headerText.length, exExFlag)
        }
        header.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), 0, header.length, exExFlag)

        // Primary description
        val description =
            SpannableString(
                "     This app is specific to Sukla Yajur Veda division\n\n" +
                        "     This is a guide for those who are unable to have a Guru (Vadiyar) nearby to carry out their Nithya Karma / Tharpanam on the occurrences.\n\n" +
                        "     (If your family Guru is reachable you should follow their instructions only.)\n"
            )
        description.setSpan(AbsoluteSizeSpan(10, true), 0, description.length, exExFlag)
        description.setSpan(StyleSpan(Typeface.ITALIC), 0, description.length, exExFlag)
        description.setSpan(ForegroundColorSpan(Color.GRAY), 0, description.length, exExFlag)

        // Notes heading
        val notesHeading = SpannableString("\n\n\n\n     Notes:\n\n")
        notesHeading.setSpan(AbsoluteSizeSpan(10, true), 0, notesHeading.length, exExFlag)
        notesHeading.setSpan(StyleSpan(Typeface.BOLD_ITALIC), 0, notesHeading.length, exExFlag)
        // underline the word "Notes" (compute index)
        val notesWord = "Notes:"
        val notesIndex = notesHeading.indexOf(notesWord)
        if (notesIndex >= 0) {
            notesHeading.setSpan(UnderlineSpan(), notesIndex, notesIndex + notesWord.length, exExFlag)
        }
        notesHeading.setSpan(ForegroundColorSpan(Color.BLACK), 0, notesHeading.length, exExFlag)

        // Short instruction paragraph
        val instruction =
            SpannableString(
                "\n     While doing Tharpanam please note the following:\n\n" +
                        "     = Only those whose father is deceased are eligible.\n" +
                        "     The app is prepared under the guidance of:\n"
            )
        instruction.setSpan(AbsoluteSizeSpan(10, true), 0, instruction.length, exExFlag)
        instruction.setSpan(StyleSpan(Typeface.ITALIC), 0, instruction.length, exExFlag)
        instruction.setSpan(ForegroundColorSpan(Color.GRAY), 0, instruction.length, exExFlag)

        // Credits / references
        val credits = SpannableString(
            "\n\n   *   Sri Srinivas Sastrigal,\n" +
                    "         Porur, Chennai, India\n\n" +
                    "   *   Sri P.V. Pattabirama Sastrigal,\n" +
                    "         Old Pallavaram, Chennai, India\n\n" +
                    "   *   Sri Srinivasan Sastrigal,\n" +
                    "         Old Pallavaram, Chennai, India\n\n" +
                    "   *   Reference:\n" +
                    "         SUKLA YAJUR VEDA KANVASAGA SANDYAVANTHANAM\n"
        )
        credits.setSpan(AbsoluteSizeSpan(12, true), 0, credits.length, exExFlag)
        credits.setSpan(StyleSpan(Typeface.BOLD), 0, credits.length, exExFlag)
        credits.setSpan(ForegroundColorSpan(Color.BLUE), 0, credits.length, exExFlag)

        // Combine all parts
        val aboutBuilder = SpannableStringBuilder()
        aboutBuilder.append(header)
        aboutBuilder.append(description)
        aboutBuilder.append(notesHeading)
        aboutBuilder.append(instruction)
        aboutBuilder.append(credits)

        // Set composed spannable into TextView
        binding.aboutTextView.text = aboutBuilder
    }
}
