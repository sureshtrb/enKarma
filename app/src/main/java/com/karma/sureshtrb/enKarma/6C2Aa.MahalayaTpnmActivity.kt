package com.karma.sureshtrb.enKarma

import android.annotation.TargetApi
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
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
//import kotlinx.android.synthetic.main.activity_mahalaya_tpnm.*
import com.karma.sureshtrb.enKarma.databinding.ActivityMahalayaTpnmBinding
import java.io.FileOutputStream
import java.io.IOException
import android.view.MenuInflater
import com.karma.sureshtrb.enKarma.databinding.ActivityDeceasedListBinding

var todThithi:String = ""
var dateTdy:String = ""
var Idam:String = ""
var Varusham:String = ""
var ayyanamm:String = ""
var kalam:String = ""
var rasee:String = ""
var baksham:String = ""
var kizhamai:String = ""
var nachathirm:String = ""
var yog:String = ""
var kar:String = ""
var yrNamee:String = ""
var yrFNamee:String = ""
var yrGFNamee:String = ""
var yrGGFNamee:String = ""
var yrGGGFNamee:String = ""
var MFNamee:String = ""
var MGFNamee:String = ""
var MGGFNamee:String = ""
var noOfDays:String = ""
var amName: String = ""
var apAmmaName: String = ""
var apPattiName: String = ""
var apKolluPattiName: String = ""
var amAmmaName: String = ""
var amPattiName: String = ""
var amKolluPattiName: String = ""
var gtOne: String = ""
var gtTwo: String = ""
var gtThree: String = ""
var gtFour: String = ""
var gtFive: String = ""
var gtSix: String = ""
var gtSeven: String = ""
var gtEight: String = ""
var gtNine: String = ""
var gtTen: String = ""
var gtEleven: String = ""
var gtTwelve: String = ""
var gtThirteen: String = ""
var gtFourteen: String = ""
var gtFifteen: String = ""
var reOne: String = ""
var reTwo: String = ""
var reThree: String = ""
var reFour: String = ""
var reFive: String = ""
var reSix: String = ""
var reSeven: String = ""
var reEight: String =  ""
var reNine: String = ""
var reTen: String = ""
var reEleven: String = ""
var reTwelve: String = ""
var reThirteen: String = ""
var reFourteen: String = ""
var reFifteen: String = ""
var bOne: String = ""
var bTwo: String = ""
var bThree: String = ""
var bFour: String = ""
var bFive: String = ""
var bSix: String = ""
var bSeven: String = ""
var bEight: String = ""
var bNine: String = ""
var bTen: String = ""
var bEleven: String = ""
var bTwelve: String = ""
var bThirteen: String = ""
var bFourteen: String = ""
var bFifteen: String = ""
var nOne: String = ""
var nTwo: String = ""
var nThree: String =  ""
var nFour: String = ""
var nFive: String = ""
var nSix: String = ""
var nSeven: String =  ""
var nEight: String =  ""
var nNine: String = ""
var nTen: String =  ""
var nEleven: String = ""
var nTwelve: String =  ""
var nThirteen: String =  ""
var nFourteen: String =  ""
var nFifteen: String = ""
var maha_combination = SpannableStringBuilder()

var mheading = SpannableString("")
var mHeading1 = SpannableString("")
var mComment1 = SpannableString("")
var mBody1 = SpannableString("")

var mComment2 = SpannableString("")
var mBody2 = SpannableString("")
var mComment3 = SpannableString("")
var mBody3 = SpannableString("")
var mComment4 = SpannableString("")
var mBody4 = SpannableString("")
var mComment5 = SpannableString("")
var mBody5 = SpannableString("")
var mComment6 = SpannableString("")
var mBody6 = SpannableString("")
var mComment7 = SpannableString("")
var mBody7 = SpannableString("")
var mComment8 = SpannableString("")
var mBody8 = SpannableString("")
var mComment9 = SpannableString("")
var mBody9 = SpannableString("")
var mComment10 = SpannableString("")
var mBody10 = SpannableString("")
var mComment11 = SpannableString("")
var mBody11 = SpannableString("")
var mComment12 = SpannableString("")
var mBody12 = SpannableString("")
var mComment13 = SpannableString("")
var mBody13 = SpannableString("")
var mComment14 = SpannableString("")
var mBody14 = SpannableString("")
var mComment15A = SpannableString("")
var mComment15B = SpannableString("")
var mComment15C = SpannableString("")
var mComment15D = SpannableString("")
var mComment15E = SpannableString("")
var mComment15F = SpannableString("")
var mBody15 = SpannableString("")
var mComment16 = SpannableString("")
var mBody16 = SpannableString("")
var mComment17 = SpannableString("")
var mHeading2 = SpannableString("")
var mBody17 = SpannableString("")
var mComment18 = SpannableString("")
var mBody18 = SpannableString("")
var mComment19 = SpannableString("")
var mBody19 = SpannableString("")
var mComment20 = SpannableString("")
var mBody20 = SpannableString("")
var mComment21 = SpannableString("")
var mBody21 = SpannableString("")
var mComment22 = SpannableString("")
var mBody22 = SpannableString("")
var mComment23 = SpannableString("")
var mBody23 = SpannableString("")
var mComment24 = SpannableString("")
var mBody24 = SpannableString("")
var mComment25 = SpannableString("")
var mBody25 = SpannableString("")
var mComment26 = SpannableString("")
var mBody26 = SpannableString("")
var mComment27 = SpannableString("")
var mBody27 = SpannableString("")
var mComment28 = SpannableString("")
var mBody28 = SpannableString("")
var mComment29 = SpannableString("")
var mBody29 = SpannableString("")
var mComment30 = SpannableString("")
var mBody30 = SpannableString("")
var mComment31 = SpannableString("")
var mBody31 = SpannableString("")
var mComment32 = SpannableString("")
var mBody32 = SpannableString("")
var mComment33 = SpannableString("")
var mBody33 = SpannableString("")
var mComment34 = SpannableString("")
var mBody34 = SpannableString("")
var mComment35 = SpannableString("")
var mBody35 = SpannableString("")
var mComment36 = SpannableString("")
var mBody36 = SpannableString("")
var mComment37 = SpannableString("")
var mBody37 = SpannableString("")
var mComment38A = SpannableString("")
var mRedComment1 = SpannableString("")
var mComment38B = SpannableString("")
var mBody38 = SpannableString("")
var mBody381 = SpannableString("")
var mBody39 = SpannableString("")
var mBody39B = SpannableString("")
var mBody40 = SpannableString("")
var mBody41 = SpannableString("")
var mBody39A = SpannableString("")
var mBody41B = SpannableString("")
var mBody42 = SpannableString("")
var mBody39FM = SpannableString("")
var mMBody38 = SpannableString("")
var mMBody38b = SpannableString("")
var mMBody41B = SpannableString("")
var mMBody41Bc = SpannableString("")
var mBody42Z = SpannableString("")
var mBody42ZA = SpannableString("")
var mBody42ZB = SpannableString("")
var mComment39 = SpannableString("")
var mGreenComment1 = SpannableString("")
var mComment40 = SpannableString("")
var mComment40Two = SpannableString("")
var mComment40Three = SpannableString("")
var mComment41 = SpannableString("")
var mRedComment2 = SpannableString("")
var mComment41A = SpannableString("")
var mComment41C = SpannableString("")
var mComment41D = SpannableString("")
var mHeading3 = SpannableString("")

var mComment42 = SpannableString("")
var mRedComment3 = SpannableString("")
var mComment42A = SpannableString("")
var mBody46 = SpannableString("")
var mBody48A = SpannableString("")
var mBody48B = SpannableString("")
var mBody49 = SpannableString("")
var mBody50 = SpannableString("")
var mBody51B = SpannableString("")
var mBody52 = SpannableString("")
var mComment43 = SpannableString("")
var mComment43A = SpannableString("")
var mComment44 = SpannableString("")
var mComment44A = SpannableString("")
var mComment45 = SpannableString("")
var mComment45A = SpannableString("")
var mHeading4 = SpannableString("")
var mComment46 = SpannableString("")
var mComment46A = SpannableString("")
var mBody53 = SpannableString("")
var mBody56 = SpannableString("")
var mBody55 = SpannableString("")
var mBody57 = SpannableString("")
var mBody58 = SpannableString("")
var mBody59B = SpannableString("")
var mBody60 = SpannableString("")
var mComment47 = SpannableString("")
var mComment47A = SpannableString("")
var mComment47B = SpannableString("")
var mBody61 = SpannableString("")
var mComment48 = SpannableString("")
var mComment49 = SpannableString("")
var mComment50 = SpannableString("")
var mComment48A = SpannableString("")
var mComment49A = SpannableString("")
var mComment50A = SpannableString("")
var mComment48B = SpannableString("")
var mComment49B = SpannableString("")
var mComment50B = SpannableString("")
var mComment48C = SpannableString("")
var mComment49C = SpannableString("")
var mComment50C = SpannableString("")
var mComment49D = SpannableString("")
var mComment50D = SpannableString("")
var mComment48E = SpannableString("")
var mComment49E = SpannableString("")
var mComment50E = SpannableString("")
var mComment42Middle = SpannableString("")
var mMBody46 = SpannableString("")
var mMBody51B = SpannableString("")
var mMHeading4 = SpannableString("")
var mMComment46 = SpannableString("")
var mMBody53 = SpannableString("")
var mMBody51C1 = SpannableString("")
var mMBody61 = SpannableString("")
var mComment42AP = SpannableString("")
var mBody46P = SpannableString("")
var mHeading4P = SpannableString("")
var mBody46PAS = SpannableString("")
var mBody61P = SpannableString("")
var mComment42AP1 = SpannableString("")
var mHeading4P1 = SpannableString("")
var mComment42AP2A = SpannableString("")
var mComment42AP2B = SpannableString("")
var mHeading5 = SpannableString("")
var mBody62 = SpannableString("")
var mBody64 = SpannableString("")
var mBody66 = SpannableString("")
var mBody68 = SpannableString("")
var mBody69 = SpannableString("")
var mBody70A = SpannableString("")
var mBody70B = SpannableString("")
var mBody71 = SpannableString("")
var mBody72 = SpannableString("")
var mBody73A = SpannableString("")
var mBody73B = SpannableString("")
var mBody74 = SpannableString("")
var mBody75 = SpannableString("")
var mBody76A = SpannableString("")
var mBody76B = SpannableString("")
var mBody77 = SpannableString("")
var mBody78 = SpannableString("")
var mBody79A = SpannableString("")
var mBody79B = SpannableString("")
var mBody80 = SpannableString("")
var mBody81 = SpannableString("")
var mBody82A = SpannableString("")
var mBody82B = SpannableString("")
var mBody83 = SpannableString("")
var mBody84 = SpannableString("")
var mBody85A = SpannableString("")
var mBody85B = SpannableString("")
var mBody86 = SpannableString("")
var mBody87 = SpannableString("")
var mBody62P = SpannableString("")
var mBody62P2 = SpannableString("")
var mBody62P3 = SpannableString("")
var mMHeading5mG = SpannableString("")
var mMBody62 = SpannableString("")
var mMBody63 = SpannableString("")
var mMBody64 = SpannableString("")
var mMBody66 = SpannableString("")
var mMBody68 = SpannableString("")
var mMBody69 = SpannableString("")
var mMBody71 = SpannableString("")
var mMBody72 = SpannableString("")
var mMBody74 = SpannableString("")
var mMBody75 = SpannableString("")
var mMBody62M = SpannableString("")
var mMBody63M = SpannableString("")
var mMBody64M = SpannableString("")
var mMBody66M = SpannableString("")
var mMBody68M = SpannableString("")
var mMBody69M = SpannableString("")
var mMBody71M = SpannableString("")
var mMBody72M = SpannableString("")
var mMBody74M = SpannableString("")
var mMBody75M = SpannableString("")
var mHeading5P = SpannableString("")
var personHead = SpannableString("")
var strAdditionP1 = SpannableString("")
var strAdditionP1P = SpannableString("")
var strAdditionP1ab = SpannableString("")
var strAdditionP1ac = SpannableString("")
var strAdditionP2 = SpannableString("")
var strAdditionP2P = SpannableString("")
var strAdditionP2bb = SpannableString("")
var strAdditionP2bc = SpannableString("")
var strAdditionP3 = SpannableString("")
var strAdditionP3P = SpannableString("")
var strAdditionP3cb = SpannableString("")
var strAdditionP3cc = SpannableString("")
var strAdditionP4 = SpannableString("")
var strAdditionP4db = SpannableString("")
var strAdditionP4dc = SpannableString("")
var strAdditionP5 = SpannableString("")
var strAdditionP5eb = SpannableString("")
var strAdditionP5ec = SpannableString("")
var strAdditionP6 = SpannableString("")
var strAdditionP6fb = SpannableString("")
var strAdditionP6fc = SpannableString("")
var strAdditionP7 = SpannableString("")
var strAdditionP7gb = SpannableString("")
var strAdditionP7gc = SpannableString("")
var strAdditionP8 = SpannableString("")
var strAdditionP8hb = SpannableString("")
var strAdditionP8hc = SpannableString("")
var strAdditionP9 = SpannableString("")
var strAdditionP9ib = SpannableString("")
var strAdditionP9ic = SpannableString("")
var strAdditionP10 = SpannableString("")
var strAdditionP10jb = SpannableString("")
var strAdditionP10jc = SpannableString("")
var strAdditionP11 = SpannableString("")
var strAdditionP11kb = SpannableString("")
var strAdditionP11kc = SpannableString("")
var strAdditionP12 = SpannableString("")
var strAdditionP12lb = SpannableString("")
var strAdditionP12lc = SpannableString("")
var strAdditionP13 = SpannableString("")
var strAdditionP13mb = SpannableString("")
var strAdditionP13mc = SpannableString("")
var strAdditionP14 = SpannableString("")
var strAdditionP14nb = SpannableString("")
var strAdditionP14nc = SpannableString("")
var strAdditionP15 = SpannableString("")
var strAdditionP15ob = SpannableString("")
var strAdditionP15oc = SpannableString("")
var strAdditionNO1 = SpannableString("")
var strAdditionNO2 = SpannableString("")
var strAdditionNO3 = SpannableString("")
var strAdditionNO1B = SpannableString("")
var strAdditionNO2B = SpannableString("")
var strAdditionNO3B = SpannableString("")
var strAdditionNO1C = SpannableString("")
var strAdditionNO2C = SpannableString("")
var strAdditionNO3C = SpannableString("")
var strAdditionNO1D = SpannableString("")
var strAdditionNO2D = SpannableString("")
var strAdditionNO3D = SpannableString("")
var strAdditionNO1E = SpannableString("")
var strAdditionNO2E = SpannableString("")
var strAdditionNO3E = SpannableString("")
var strAdditionNO1F = SpannableString("")
var strAdditionNO2F = SpannableString("")
var strAdditionNO3F = SpannableString("")
var strAdditionNO1G = SpannableString("")
var strAdditionNO2G = SpannableString("")
var strAdditionNO3G = SpannableString("")
var strAdditionNO1H = SpannableString("")
var strAdditionNO2H = SpannableString("")
var strAdditionNO3H = SpannableString("")
var strAdditionNO1I = SpannableString("")
var strAdditionNO2I = SpannableString("")
var strAdditionNO3I = SpannableString("")
var strAdditionNO1J = SpannableString("")
var strAdditionNO2J = SpannableString("")
var strAdditionNO3J = SpannableString("")
var strAdditionNO1K = SpannableString("")
var strAdditionNO2K = SpannableString("")
var strAdditionNO3K = SpannableString("")
var strAdditionNO1L = SpannableString("")
var strAdditionNO2L = SpannableString("")
var strAdditionNO3L = SpannableString("")
var strAdditionNO1M = SpannableString("")
var strAdditionNO2M = SpannableString("")
var strAdditionNO3M = SpannableString("")
var strAdditionNO1N = SpannableString("")
var strAdditionNO2N = SpannableString("")
var strAdditionNO3N = SpannableString("")
var strAdditionNO1O = SpannableString("")
var strAdditionNO2O = SpannableString("")
var strAdditionNO3O = SpannableString("")
var strAdditionP1zM = SpannableString("")
var strAdditionP1zMB = SpannableString("")
var strAdditionP1zMC = SpannableString("")
var strAdditionP2zM = SpannableString("")
var strAdditionP2zMB = SpannableString("")
var strAdditionP2zMC = SpannableString("")
var strAdditionP3zM = SpannableString("")
var strAdditionP3zMB = SpannableString("")
var strAdditionP3zMC = SpannableString("")
var strAdditionP4zM = SpannableString("")
var strAdditionP4zMB = SpannableString("")
var strAdditionP4zMC = SpannableString("")
var strAdditionP5zM = SpannableString("")
var strAdditionP5zMB = SpannableString("")
var strAdditionP5zMC = SpannableString("")
var strAdditionP6zM = SpannableString("")
var strAdditionP6zMB = SpannableString("")
var strAdditionP6zMC = SpannableString("")
var strAdditionP7zM = SpannableString("")
var strAdditionP7zMB = SpannableString("")
var strAdditionP7zMC = SpannableString("")
var strAdditionP8zM = SpannableString("")
var strAdditionP8zMB = SpannableString("")
var strAdditionP8zMC = SpannableString("")
var strAdditionP9zM = SpannableString("")
var strAdditionP9zMB = SpannableString("")
var strAdditionP9zMC = SpannableString("")
var strAdditionP10zM = SpannableString("")
var strAdditionP10zMB = SpannableString("")
var strAdditionP10zMC = SpannableString("")
var strAdditionP11zM = SpannableString("")
var strAdditionP11zMB = SpannableString("")
var strAdditionP11zMC = SpannableString("")
var strAdditionP12zM = SpannableString("")
var strAdditionP12zMB = SpannableString("")
var strAdditionP12zMC = SpannableString("")
var strAdditionP13zM = SpannableString("")
var strAdditionP13zMB = SpannableString("")
var strAdditionP13zMC = SpannableString("")
var strAdditionP14zM = SpannableString("")
var strAdditionP14zMB = SpannableString("")
var strAdditionP14zMC = SpannableString("")
var strAdditionP15zM = SpannableString("")
var strAdditionP15zMB = SpannableString("")
var strAdditionP15zMC = SpannableString("")
var strAdditionP1aA1 = SpannableString("")
var strAdditionP1aA2 = SpannableString("")
var strAdditionP1aA3 = SpannableString("")
var strAdditionP1aB1 = SpannableString("")
var strAdditionP1aB2 = SpannableString("")
var strAdditionP1aB3 = SpannableString("")
var strAdditionP1aC1 = SpannableString("")
var strAdditionP1aC2 = SpannableString("")
var strAdditionP1aC3 = SpannableString("")
var strAdditionP1aD1 = SpannableString("")
var strAdditionP1aD2 = SpannableString("")
var strAdditionP1aD3 = SpannableString("")
var strAdditionP1aE1 = SpannableString("")
var strAdditionP1aE2 = SpannableString("")
var strAdditionP1aE3 = SpannableString("")
var strAdditionP1aF1 = SpannableString("")
var strAdditionP1aF2 = SpannableString("")
var strAdditionP1aF3 = SpannableString("")
var strAdditionP1aG1 = SpannableString("")
var strAdditionP1aG2 = SpannableString("")
var strAdditionP1aG3 = SpannableString("")
var strAdditionP1aH1 = SpannableString("")
var strAdditionP1aH2 = SpannableString("")
var strAdditionP1aH3 = SpannableString("")
var strAdditionP1aI1 = SpannableString("")
var strAdditionP1aI2 = SpannableString("")
var strAdditionP1aI3 = SpannableString("")
var strAdditionP1aJ1 = SpannableString("")
var strAdditionP1aJ2 = SpannableString("")
var strAdditionP1aJ3 = SpannableString("")
var strAdditionP1aK1 = SpannableString("")
var strAdditionP1aK2 = SpannableString("")
var strAdditionP1aK3 = SpannableString("")
var strAdditionP1aL1 = SpannableString("")
var strAdditionP1aL2 = SpannableString("")
var strAdditionP1aL3 = SpannableString("")
var strAdditionP1aM1 = SpannableString("")
var strAdditionP1aM2 = SpannableString("")
var strAdditionP1aM3 = SpannableString("")
var strAdditionP1aN1 = SpannableString("")
var strAdditionP1aN2 = SpannableString("")
var strAdditionP1aN3 = SpannableString("")
var strAdditionP1aO1 = SpannableString("")
var strAdditionP1aO2 = SpannableString("")
var strAdditionP1aO3 = SpannableString("")
var strAdditionP1zA = SpannableString("")
var strAdditionP1zB = SpannableString("")
var strAdditionP1zC = SpannableString("")
var strAdditionP2zA = SpannableString("")
var strAdditionP2zB = SpannableString("")
var strAdditionP2zC = SpannableString("")
var strAdditionP3zA = SpannableString("")
var strAdditionP3zB = SpannableString("")
var strAdditionP3zC = SpannableString("")
var strAdditionP4zA = SpannableString("")
var strAdditionP4zB = SpannableString("")
var strAdditionP4zC = SpannableString("")
var strAdditionP5zA = SpannableString("")
var strAdditionP5zB = SpannableString("")
var strAdditionP5zC = SpannableString("")
var strAdditionP6zA = SpannableString("")
var strAdditionP6zB = SpannableString("")
var strAdditionP6zC = SpannableString("")
var strAdditionP7zA = SpannableString("")
var strAdditionP7zB = SpannableString("")
var strAdditionP7zC = SpannableString("")
var strAdditionP8zA = SpannableString("")
var strAdditionP8zB = SpannableString("")
var strAdditionP8zC = SpannableString("")
var strAdditionP9zA = SpannableString("")
var strAdditionP9zB = SpannableString("")
var strAdditionP9zC = SpannableString("")
var strAdditionP10zA = SpannableString("")
var strAdditionP10zB = SpannableString("")
var strAdditionP10zC = SpannableString("")
var strAdditionP11zA = SpannableString("")
var strAdditionP11zB = SpannableString("")
var strAdditionP11zC = SpannableString("")
var strAdditionP12zA = SpannableString("")
var strAdditionP12zB = SpannableString("")
var strAdditionP12zC = SpannableString("")
var strAdditionP13zA = SpannableString("")
var strAdditionP13zB = SpannableString("")
var strAdditionP13zC = SpannableString("")
var strAdditionP14zA = SpannableString("")
var strAdditionP14zB = SpannableString("")
var strAdditionP14zC = SpannableString("")
var strAdditionP15zA = SpannableString("")
var strAdditionP15zB = SpannableString("")
var strAdditionP15zC = SpannableString("")
var strAdditionP1bA1 = SpannableString("")
var strAdditionP1bA2 = SpannableString("")
var strAdditionP1bA3 = SpannableString("")
var strAdditionP1bB1 = SpannableString("")
var strAdditionP1bB2 = SpannableString("")
var strAdditionP1bB3 = SpannableString("")
var strAdditionP1bC1 = SpannableString("")
var strAdditionP1bC2 = SpannableString("")
var strAdditionP1bC3 = SpannableString("")
var strAdditionP1bD1 = SpannableString("")
var strAdditionP1bD2 = SpannableString("")
var strAdditionP1bD3 = SpannableString("")
var strAdditionP1bE1 = SpannableString("")
var strAdditionP1bE2 = SpannableString("")
var strAdditionP1bE3 = SpannableString("")
var strAdditionP1bF1 = SpannableString("")
var strAdditionP1bF2 = SpannableString("")
var strAdditionP1bF3 = SpannableString("")
var strAdditionP1bG1 = SpannableString("")
var strAdditionP1bG2 = SpannableString("")
var strAdditionP1bG3 = SpannableString("")
var strAdditionP1bH1 = SpannableString("")
var strAdditionP1bH2 = SpannableString("")
var strAdditionP1bH3 = SpannableString("")
var strAdditionP1bI1 = SpannableString("")
var strAdditionP1bI2 = SpannableString("")
var strAdditionP1bI3 = SpannableString("")
var strAdditionP1bJ1 = SpannableString("")
var strAdditionP1bJ2 = SpannableString("")
var strAdditionP1bJ3 = SpannableString("")
var strAdditionP1bK1 = SpannableString("")
var strAdditionP1bK2 = SpannableString("")
var strAdditionP1bK3 = SpannableString("")
var strAdditionP1bL1 = SpannableString("")
var strAdditionP1bL2 = SpannableString("")
var strAdditionP1bL3 = SpannableString("")
var strAdditionP1bM1 = SpannableString("")
var strAdditionP1bM2 = SpannableString("")
var strAdditionP1bM3 = SpannableString("")
var strAdditionP1bN1 = SpannableString("")
var strAdditionP1bN2 = SpannableString("")
var strAdditionP1bN3 = SpannableString("")
var strAdditionP1bO1 = SpannableString("")
var strAdditionP1bO2 = SpannableString("")
var strAdditionP1bO3 = SpannableString("")
var strAdditionP1cA1 = SpannableString("")
var strAdditionP1cA2 = SpannableString("")
var strAdditionP1cA3 = SpannableString("")
var strAdditionP1cB1 = SpannableString("")
var strAdditionP1cB2 = SpannableString("")
var strAdditionP1cB3 = SpannableString("")
var strAdditionP1cC1 = SpannableString("")
var strAdditionP1cC2 = SpannableString("")
var strAdditionP1cC3 = SpannableString("")
var strAdditionP1cD1 = SpannableString("")
var strAdditionP1cD2 = SpannableString("")
var strAdditionP1cD3 = SpannableString("")
var strAdditionP1cE1 = SpannableString("")
var strAdditionP1cE2 = SpannableString("")
var strAdditionP1cE3 = SpannableString("")
var strAdditionP1cF1 = SpannableString("")
var strAdditionP1cF2 = SpannableString("")
var strAdditionP1cF3 = SpannableString("")
var strAdditionP1cG1 = SpannableString("")
var strAdditionP1cG2 = SpannableString("")
var strAdditionP1cG3 = SpannableString("")
var strAdditionP1cH1 = SpannableString("")
var strAdditionP1cH2 = SpannableString("")
var strAdditionP1cH3 = SpannableString("")
var strAdditionP1cI1 = SpannableString("")
var strAdditionP1cI2 = SpannableString("")
var strAdditionP1cI3 = SpannableString("")
var strAdditionP1cJ1 = SpannableString("")
var strAdditionP1cJ2 = SpannableString("")
var strAdditionP1cJ3 = SpannableString("")
var strAdditionP1cK1 = SpannableString("")
var strAdditionP1cK2 = SpannableString("")
var strAdditionP1cK3 = SpannableString("")
var strAdditionP1cL1 = SpannableString("")
var strAdditionP1cL2 = SpannableString("")
var strAdditionP1cL3 = SpannableString("")
var strAdditionP1cM1 = SpannableString("")
var strAdditionP1cM2 = SpannableString("")
var strAdditionP1cM3 = SpannableString("")
var strAdditionP1cN1 = SpannableString("")
var strAdditionP1cN2 = SpannableString("")
var strAdditionP1cN3 = SpannableString("")
var strAdditionP1cO1 = SpannableString("")
var strAdditionP1cO2 = SpannableString("")
var strAdditionP1cO3 = SpannableString("")
var space = SpannableString("")
var mBody87P1 = SpannableString("")
var mBody87P2 = SpannableString("")
var mBody87P3 = SpannableString("")
var mComment51 = SpannableString("")
var mBody88 = SpannableString("")
var mComment51a = SpannableString("")
var mGreenComment2 = SpannableString("")
var mComment52 = SpannableString("")
var mBody89 = SpannableString("")
var mRedComment4 = SpannableString("")
var mComment53 = SpannableString("")
var mComment54 = SpannableString("")
var mComment54a = SpannableString("")
var mComment55 = SpannableString("")
var mComment55A = SpannableString("")
var mBody90 = SpannableString("")
var mBody90P = SpannableString("")
var mComment55BP = SpannableString("")
var mComment55B = SpannableString("")
var mBody90P2 = SpannableString("")
var mComment55C = SpannableString("")
var mComment56 = SpannableString("")
var mComment57 = SpannableString("")
var mComment58 = SpannableString("")
var mComment57A = SpannableString("")
var mComment58A = SpannableString("")
var mBody91 = SpannableString("")
var mComment55DP = SpannableString("")
var mComment55D = SpannableString("")
var mMBody91P = SpannableString("")
var mMBody91 = SpannableString("")
var mComment55EP = SpannableString("")
var mComment55E = SpannableString("")
var mMBody91A = SpannableString("")
var mGreenComment3 = SpannableString("")
var mBody92 = SpannableString("")
var mVARGAI1A = SpannableString("")
var mVARGAI1B = SpannableString("")
var mBody93 = SpannableString("")
var mComment59 = SpannableString("")
var mBody94 = SpannableString("")
var mComment60 = SpannableString("")
var mBody95 = SpannableString("")
var mComment61 = SpannableString("")
var mBody96 = SpannableString("")
var mVARGAI2A = SpannableString("")
var mVARGAI1BP = SpannableString("")
var mBody97 = SpannableString("")
var mComment62 = SpannableString("")
var mHeading6 = SpannableString("")
var mRedComment5 = SpannableString("")
var mComment63 = SpannableString("")
var Comment64 = SpannableString("")
var MComment64 = SpannableString("")
var mComment65 = SpannableString("")
var mBody98 = SpannableString("")
var mBody98A = SpannableString("")
var mBody99A = SpannableString("")
var mBody99B = SpannableString("")
var mMComment64AP = SpannableString("")
var mBody98PA = SpannableString("")
var mBody98PMB = SpannableString("")
var mBody98PB = SpannableString("")
var mBody98PC = SpannableString("")
var mMComment64A = SpannableString("")
var mMBody98 = SpannableString("")
var mComment66 = SpannableString("")
var mBody100 = SpannableString("")
var mComment67 = SpannableString("")
var mGreenComment4 = SpannableString("")
var mComment68 = SpannableString("")
var mBody101 = SpannableString("")
var mComment69 = SpannableString("")
var mBody102 = SpannableString("")
var mComment70 = SpannableString("")
var mBody103 = SpannableString("")
var mBody103B = SpannableString("")
var mBody103A = SpannableString("")
var mVARGAI3A = SpannableString("")
var mVARGAI1BP2 = SpannableString("")
var mBody104 = SpannableString("")
var mComment71 = SpannableString("")
var mBody105 = SpannableString("")
var mRedComment6 = SpannableString("")
var mComment72 = SpannableString("")
var mComment73 = SpannableString("")
var mComment74 = SpannableString("")
var mComment75 = SpannableString("")
var mComment76 = SpannableString("")
var mBody106 = SpannableString("")
var mBody107Big = SpannableString("")
var mBody108 = SpannableString("")
var mGreenComment5 = SpannableString("")
var mComment77 = SpannableString("")
var mHeading7 = SpannableString("")

class MahalayaTpnmActivity : AppCompatActivity() {

    var mtotalpages: Int = 1
    var mpageOneText: CharSequence? =null
    var mpageTwoText: CharSequence? = null
    var mpageThreeText: CharSequence? = null
    var mpageFourText: CharSequence? = null
    var mpageFiveText: CharSequence? = null
    var mpageSixText: CharSequence? = null
    var mpageSevenText: CharSequence? = null
    var mpageEightText: CharSequence? = null
    var mpageNineText: CharSequence? = null
    var mpageTenText: CharSequence? = null
    var mpageElevenText: CharSequence? = null
    var mpageTwelveText: CharSequence? = null
    var mpageThirteenText: CharSequence? = null
    var mpageFourteenText: CharSequence? = null
    var mpageFifteenText: CharSequence? = null
    var mpageSixteenText: CharSequence? = null
    var mpageSeventeenText: CharSequence? = null

    var mstartPos1 = 0
    var mstartPos2 = 0
    var mstartPos3 = 0
    var mstartPos4 = 0
    var mstartPos5 = 0
    var mstartPos6 = 0
    var mstartPos7 = 0
    var mstartPos8 = 0
    var mstartPos9 = 0
    var mstartPos10 = 0
    var mstartPos11 = 0
    var mstartPos12 = 0
    var mstartPos13 = 0
    var mstartPos14 = 0
    var mstartPos15 = 0
    var mstartPos16 = 0
    var mstartPos17 = 0
    var mendPos1 = 0
    var mendPos2 = 0
    var mendPos3 = 0
    var mendPos4 = 0
    var mendPos5 = 0
    var mendPos6 = 0
    var mendPos7 = 0
    var mendPos8 = 0
    var mendPos9 = 0
    var mendPos10 = 0
    var mendPos11 = 0
    var mendPos12 = 0
    var mendPos13 = 0
    var mendPos14 = 0
    var mendPos15 = 0
    var mendPos16 = 0
    var mendPos17 = 0


    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    private lateinit var binding: ActivityMahalayaTpnmBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_mahalaya_tpnm)
        binding = ActivityMahalayaTpnmBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        val printBtn = findViewById<Button>(R.id.printButton)

        val intent = intent
        val dTdy: String = intent.getStringExtra("Naal") ?: ""
        dateTdy = dTdy
        val pl: String = intent.getStringExtra("Idam") ?: ""
        Idam = pl
        val Vm: String = intent.getStringExtra("TamilYear") ?: ""
        Varusham = Vm
        val AYM: String = intent.getStringExtra("Ayanamm") ?: ""
        ayyanamm = AYM
        val km: String = intent.getStringExtra("KAALAM") ?: ""
        kalam = km
        val rse: String = intent.getStringExtra("RASEEE") ?: ""
        rasee = rse
        val bm: String = intent.getStringExtra("BAKKSHAMM") ?: ""
        baksham = bm
        val tyThithi: String = intent.getStringExtra("TODAYSTHITHI") ?: ""
        todThithi = tyThithi
        val kzi: String = intent.getStringExtra("KIZHAMAAII") ?: ""
        kizhamai = kzi
        val nm: String = intent.getStringExtra("NAKSM") ?: ""
        nachathirm = nm
        val yg: String = intent.getStringExtra("YGM") ?: ""
        yog = yg
        val kr: String = intent.getStringExtra("KRNM") ?: ""
        kar = kr

        val yN: String = intent.getStringExtra("Peyar") ?: ""
        yrNamee = yN
        val yFN: String = intent.getStringExtra("Appa") ?: ""
        yrFNamee = yFN
        val yGFN: String = intent.getStringExtra("Thatha") ?: ""
        yrGFNamee = yGFN
        val yGGFN: String = intent.getStringExtra("Kollu") ?: ""
        yrGGFNamee = yGGFN
        val yGGGFN: String = intent.getStringExtra("Yellu") ?: ""
        yrGGGFNamee = yGGGFN
        val mFN: String = intent.getStringExtra("AmmaAppa") ?: ""
        MFNamee = mFN
        val mGFN: String = intent.getStringExtra("AmmaThatha") ?: ""
        MGFNamee = mGFN
        val mGGFN: String = intent.getStringExtra("AmmaKolluThatha") ?: ""
        MGGFNamee = mGGFN
        val nD: String = intent.getStringExtra("howManyDays") ?: ""
        noOfDays = nD

        amName = intent.getStringExtra("ammaName") ?: ""
        apAmmaName = intent.getStringExtra("appaAmmaName") ?: ""
        apPattiName = intent.getStringExtra("appaPattiName") ?: ""
        apKolluPattiName = intent.getStringExtra("appaKolluPattiName") ?: ""
        amAmmaName = intent.getStringExtra("ammaAmmaName") ?: ""
        amPattiName = intent.getStringExtra("ammaPattiName") ?: ""
        amKolluPattiName = intent.getStringExtra("ammaKolluPattiName") ?: ""

        nOne = intent.getStringExtra("N1") ?: ""
        nTwo = intent.getStringExtra("N2") ?: ""
        nThree = intent.getStringExtra("N3") ?: ""
        nFour = intent.getStringExtra("N4") ?: ""
        nFive = intent.getStringExtra("N5") ?: ""
        nSix = intent.getStringExtra("N6") ?: ""
        nSeven = intent.getStringExtra("N7") ?: ""
        nEight = intent.getStringExtra("N8") ?: ""
        nNine = intent.getStringExtra("N9") ?: ""
        nTen = intent.getStringExtra("N10") ?: ""
        nEleven = intent.getStringExtra("N11") ?: ""
        nTwelve = intent.getStringExtra("N12") ?: ""
        nThirteen = intent.getStringExtra("N13") ?: ""
        nFourteen = intent.getStringExtra("N14") ?: ""
        nFifteen = intent.getStringExtra("N15") ?: ""

        val b1 = intent.getStringExtra("B1") ?: ""
        if(Gndr1 == "ஆண்") { if (b1 == "Elder (மூத்த)") { bOne = "ஜேஷ்ட" } else if (b1 == "Younger (இளைய)") { bOne = "கனிஷ்ட" } else{ bOne = " "} }
        val b2 = intent.getStringExtra("B2") ?: ""
        if(Gndr2 == "ஆண்") { if (b2 == "Elder (மூத்த)") { bTwo = "ஜேஷ்ட" } else  if (b2 == "Younger (இளைய)") { bTwo = "கனிஷ்ட" } else{ bTwo = " "}}
        val b3 = intent.getStringExtra("B3") ?: ""
        if(Gndr3 == "ஆண்") { if (b3 == "Elder (மூத்த)") { bThree = "ஜேஷ்ட" } else if (b3 == "Younger (இளைய)") { bThree = "கனிஷ்ட" } else{ bThree = " "}}
        val b4 = intent.getStringExtra("B4") ?: ""
        if(Gndr4 == "ஆண்") { if (b4 == "Elder (மூத்த)") { bFour = "ஜேஷ்ட" } else if (b4 == "Younger (இளைய)") { bFour = "கனிஷ்ட" } else{ bFour = " "}}
        val b5 = intent.getStringExtra("B5") ?: ""
        if(Gndr5 == "ஆண்") { if (b5 == "Elder (மூத்த)") { bFive = "ஜேஷ்ட" } else if (b5 == "Younger (இளைய)") { bFive = "கனிஷ்ட" } else{ bFive = " "}}
        val b6 = intent.getStringExtra("B6") ?: ""
        if(Gndr6 == "ஆண்") { if (b6 == "Elder (மூத்த)") { bSix = "ஜேஷ்ட" } else if (b6 == "Younger (இளைய)") { bSix = "கனிஷ்ட" } else{ bSix = " "}}
        val b7 = intent.getStringExtra("B7") ?: ""
        if(Gndr7 == "ஆண்") { if (b7 == "Elder (மூத்த)") { bSeven = "ஜேஷ்ட" } else if (b7 == "Younger (இளைய)") { bSeven = "கனிஷ்ட" } else{ bSeven = " "}}
        val b8 = intent.getStringExtra("B8") ?: ""
        if(Gndr8 == "ஆண்") { if (b8 == "Elder (மூத்த)") { bEight = "ஜேஷ்ட" } else if (b8 == "Younger (இளைய)") { bEight = "கனிஷ்ட" } else{ bEight = " "}}
        val b9 = intent.getStringExtra("B9") ?: ""
        if(Gndr9 == "ஆண்") { if (b9 == "Elder (மூத்த)") { bNine = "ஜேஷ்ட" } else if (b9 == "Younger (இளைய)") { bNine = "கனிஷ்ட" } else{ bNine = " "}}
        val b10 = intent.getStringExtra("B10") ?: ""
        if(Gndr10 == "ஆண்") { if (b10 == "Elder (மூத்த)") { bTen = "ஜேஷ்ட" } else if (b10 == "Younger (இளைய)") { bTen = "கனிஷ்ட" } else{ bTen = " "}}
        val b11 = intent.getStringExtra("B11") ?: ""
        if(Gndr11 == "ஆண்") { if (b11 == "Elder (மூத்த)") { bEleven = "ஜேஷ்ட" } else if (b11 == "Younger (இளைய)") { bEleven = "கனிஷ்ட" } else{ bEleven = " "}}
        val b12 = intent.getStringExtra("B12") ?: ""
        if(Gndr12 == "ஆண்") { if (b12 == "Elder (மூத்த)") { bTwelve = "ஜேஷ்ட" } else if (b12 == "Younger (இளைய)") { bTwelve = "கனிஷ்ட" } else{ bTwelve = " "}}
        val b13 = intent.getStringExtra("B13") ?: ""
        if(Gndr13 == "ஆண்") { if (b13 == "Elder (மூத்த)") { bThirteen = "ஜேஷ்ட" } else if (b13 == "Younger (இளைய)") { bThirteen = "கனிஷ்ட" } else{ bThirteen = " "}}
        val b14 = intent.getStringExtra("B14") ?: ""
        if(Gndr14 == "ஆண்") { if (b14 == "Elder (மூத்த)") { bFourteen = "ஜேஷ்ட" } else if (b14 == "Younger (இளைய)") { bFourteen = "கனிஷ்ட" } else{ bFourteen = " "}}
        val b15 = intent.getStringExtra("B15") ?: ""
        if(Gndr15 == "ஆண்") { if (b15 == "Elder (மூத்த)") { bFifteen = "ஜேஷ்ட" } else if (b15 == "Younger (இளைய)") { bFifteen = "கனிஷ்ட" } else{ bFifteen = " "}}

        gtOne = intent.getStringExtra("G1") ?: ""
        gtTwo = intent.getStringExtra("G2") ?: ""
        gtThree = intent.getStringExtra("G3") ?: ""
        gtFour = intent.getStringExtra("G4") ?: ""
        gtFive = intent.getStringExtra("G5") ?: ""
        gtSix = intent.getStringExtra("G6") ?: ""
        gtSeven = intent.getStringExtra("G7") ?: ""
        gtEight = intent.getStringExtra("G8") ?: ""
        gtNine = intent.getStringExtra("G9") ?: ""
        gtTen = intent.getStringExtra("G10") ?: ""
        gtEleven = intent.getStringExtra("G11") ?: ""
        gtTwelve = intent.getStringExtra("G12") ?: ""
        gtThirteen = intent.getStringExtra("G13") ?: ""
        gtFourteen = intent.getStringExtra("G14") ?: ""
        gtFifteen = intent.getStringExtra("G15") ?: ""

        reOne = intent.getStringExtra("R1") ?: ""
        reTwo = intent.getStringExtra("R2") ?: ""
        reThree = intent.getStringExtra("R3") ?: ""
        reFour = intent.getStringExtra("R4") ?: ""
        reFive = intent.getStringExtra("R5") ?: ""
        reSix = intent.getStringExtra("R6") ?: ""
        reSeven = intent.getStringExtra("R7") ?: ""
        reEight = intent.getStringExtra("R8") ?: ""
        reNine = intent.getStringExtra("R9") ?: ""
        reTen = intent.getStringExtra("R10") ?: ""
        reEleven = intent.getStringExtra("R11") ?: ""
        reTwelve = intent.getStringExtra("R12") ?: ""
        reThirteen = intent.getStringExtra("R13") ?: ""
        reFourteen = intent.getStringExtra("R14") ?: ""
        reFifteen = intent.getStringExtra("R15") ?: ""

        val Gndr1 = intent.getStringExtra("gdr1") ?: ""
        val Gndr2 = intent.getStringExtra("gdr2") ?: ""
        val Gndr3 = intent.getStringExtra("gdr3") ?: ""
        val Gndr4 = intent.getStringExtra("gdr4") ?: ""
        val Gndr5 = intent.getStringExtra("gdr5") ?: ""
        val Gndr6 = intent.getStringExtra("gdr6") ?: ""
        val Gndr7 = intent.getStringExtra("gdr7") ?: ""
        val Gndr8 = intent.getStringExtra("gdr8") ?: ""
        val Gndr9 = intent.getStringExtra("gdr9") ?: ""
        val Gndr10 = intent.getStringExtra("gdr10") ?: ""
        val Gndr11 = intent.getStringExtra("gdr11") ?: ""
        val Gndr12 = intent.getStringExtra("gdr12") ?: ""
        val Gndr13 = intent.getStringExtra("gdr13") ?: ""
        val Gndr14 = intent.getStringExtra("gdr14") ?: ""
        val Gndr15 = intent.getStringExtra("gdr15") ?: ""
        println("Maha-nOne : $nOne")
        println("Maha-nFifteen : $nFifteen")
        println("Maha-gtOne : $gtOne")
        println("Maha-gtFifteen : $gtFifteen")
        println("Maha-bOne : $bOne")
        println("Maha-bFifteen : $bFifteen")
        println("Maha-Gndr1 : $Gndr1")
        println("Maha-Gndr15 : $Gndr15")
        println("Maha-reOne : $reOne")
        println("Maha-reFifteen : $reFifteen")

        println("Maha-amName : $amName")
        println("Maha-apAmmaName : $apAmmaName")
        println("Maha-apPattiName : $apPattiName")
        println("Maha-apKolluPattiName : $apKolluPattiName")
        println("Maha-amAmmaName : $amAmmaName")
        println("Maha-amPattiName : $amPattiName")
        println("Maha-amKolluPattiName : $amKolluPattiName")
        println("Maha-dateTdy : $dateTdy")
        println("Maha-Idam : $Idam")
        println("Maha-Varusham : $Varusham")
        println("Maha-ayyanamm : $ayyanamm")
        println("Maha-kalam : $kalam")
        println("Maha-rasee : $rasee")
        println("Maha-baksham : $baksham")
        println("Maha-todThithi : $todThithi")
        println("Maha-kizhamai : $kizhamai")
        println("Maha-nachathirm : $nachathirm")
        println("Maha-yog : $yog")
        println("Maha-kar : $kar")
        println("Maha-yrNamee : $yrNamee")
        println("Maha-yrFNamee : $yrFNamee")
        println("Maha-yrGFNamee : $yrGFNamee")
        println("Maha-yrGGFNamee : $yrGGFNamee")
        println("Maha-yrGGGFNamee : $yrGGGFNamee")
        println("Maha-MFNamee : $MFNamee")
        println("Maha-MGFNamee : $MGFNamee")
        println("Maha-MGGFNamee : $MGGFNamee")
        println("Maha-noOfDays : $noOfDays")

        supportActionBar!!.setHomeAsUpIndicator(R.drawable.home)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.subtitle =  " மஹாளய தர்ப்பணம்"
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setLogo(R.drawable.karma)
        supportActionBar!!.setDisplayUseLogoEnabled(true)

        trial()
        bottomPithruKoorcham()
        executeData()
        binding.MahalayaTPNMTextView.text = maha_combination

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
                if (mtotalpages > 0) {
                    val builder = PrintDocumentInfo.Builder("$mheading.pdf")
                        .setContentType(PrintDocumentInfo.CONTENT_TYPE_DOCUMENT)
                        .setPageCount(mtotalpages)

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
             //   val bground = BitmapFactory.decodeResource(context.resources, R.drawable.yvkr)
                canvas.drawBitmap(logo, (pageInfo.pageWidth / 12 - logo.width / 6).toFloat(), 0f, paint)
              //  canvas.drawBitmap(bground, (pageInfo.pageWidth / 2 - bground.width / 2).toFloat(), (pageInfo.pageHeight/2- bground.height/2).toFloat(), paint)
                paint.textSize = 15f

                //   val toScale = (bm!!.width / pageWidth).toDouble()
                val mTextPaint = TextPaint()

                mpageOneText = maha_combination.subSequence(mstartPos1, mendPos1)
                mpageTwoText = maha_combination.subSequence(mstartPos2, mendPos2)
                mpageThreeText = maha_combination.subSequence(mstartPos3, mendPos3)
                mpageFourText = maha_combination.subSequence(mstartPos4, mendPos4)
                mpageFiveText = maha_combination.subSequence(mstartPos5, mendPos5)
                mpageSixText = maha_combination.subSequence(mstartPos6, mendPos6)
                mpageSevenText = maha_combination.subSequence(mstartPos7, mendPos7)
                mpageEightText = maha_combination.subSequence(mstartPos8, mendPos8)
                mpageNineText = maha_combination.subSequence(mstartPos9, mendPos9)
                mpageTenText = maha_combination.subSequence(mstartPos10, mendPos10)
                mpageElevenText = maha_combination.subSequence(mstartPos11, mendPos11)
                mpageTwelveText = maha_combination.subSequence(mstartPos12, mendPos12)
                mpageThirteenText = maha_combination.subSequence(mstartPos13, mendPos13)
                mpageFourteenText = maha_combination.subSequence(mstartPos14, mendPos14)
                mpageFifteenText = maha_combination.subSequence(mstartPos15, mendPos15)
                mpageSixteenText = maha_combination.subSequence(mstartPos16, mendPos16)
                mpageSeventeenText = maha_combination.subSequence(mstartPos17, mendPos17)

                val footerText1 = SpannableString(
                    "$mheading (Page No. $pagnumber of $mtotalpages)"
                )
                val exExFlag = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                val start: Int = 0
                footerText1.setSpan(AbsoluteSizeSpan(8, true), start, footerText1.length, exExFlag)
                footerText1.setSpan(StyleSpan(Typeface.ITALIC), start, footerText1.length, exExFlag)
                footerText1.setSpan(ForegroundColorSpan(Color.RED), start, footerText1.length, exExFlag)
                val footerText =footerText1.toString()

                if (pagnumber == 1 && mtotalpages >= 1) {
                    val mTextLayout1 = StaticLayout(mpageOneText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout1.draw(canvas)
                    paint.textSize = 14f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 2 && mtotalpages >= 2) {
                    val mTextLayout2 = StaticLayout(mpageTwoText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout2.draw(canvas)
                    paint.textSize = 14f
                    paint.colorFilter
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 3 && mtotalpages >= 3) {
                    val mTextLayout3 = StaticLayout(mpageThreeText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout3.draw(canvas)
                    paint.textSize = 14f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 4 && mtotalpages >= 4) {
                    val mTextLayout4 = StaticLayout(mpageFourText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout4.draw(canvas)
                    paint.textSize = 14f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 5 && mtotalpages >= 5) {
                    val mTextLayout5 = StaticLayout(mpageFiveText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout5.draw(canvas)
                    paint.textSize = 14f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 6 && mtotalpages >= 6) {
                    val mTextLayout6 = StaticLayout(mpageSixText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout6.draw(canvas)
                    paint.textSize = 14f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 7 && mtotalpages >= 7) {
                    val mTextLayout7 = StaticLayout(mpageSevenText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout7.draw(canvas)
                    paint.textSize = 14f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 8 && mtotalpages >= 8) {
                    val mTextLayout8 = StaticLayout(mpageEightText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout8.draw(canvas)
                    paint.textSize = 14f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 9 && mtotalpages >= 9) {
                    val mTextLayout9 = StaticLayout(mpageNineText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout9.draw(canvas)
                    paint.textSize = 14f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 10 && mtotalpages >= 10) {
                    val mTextLayout10 = StaticLayout(mpageTenText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout10.draw(canvas)
                    paint.textSize = 14f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 11 && mtotalpages >= 11) {
                    val mTextLayout11 = StaticLayout(mpageElevenText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout11.draw(canvas)
                    paint.textSize = 14f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 12 && mtotalpages >= 12) {
                    val mTextLayout12 = StaticLayout(mpageTwelveText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout12.draw(canvas)
                    paint.textSize = 14f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 13 && mtotalpages >= 13) {
                    val mTextLayout13 = StaticLayout(mpageThirteenText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout13.draw(canvas)
                    paint.textSize = 14f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 14 && mtotalpages >= 14) {
                    val mTextLayout14 = StaticLayout(mpageFourteenText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout14.draw(canvas)
                    paint.textSize = 14f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 15 && mtotalpages >= 15) {
                    val mTextLayout15 = StaticLayout(mpageFifteenText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout15.draw(canvas)
                    paint.textSize = 14f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 16 && mtotalpages >= 16) {
                    val mTextLayout16 = StaticLayout(mpageSixteenText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
                    mTextLayout16.draw(canvas)
                    paint.textSize = 14f
                    canvas.drawText(footerText, (pageInfo.pageWidth / 3 - footerText.length).toFloat(), (pageInfo.pageHeight).toFloat(), paint)
                }
                if (pagnumber == 17 && mtotalpages >= 17) {
                    val mTextLayout17 = StaticLayout(mpageSeventeenText, mTextPaint, canvas.width, Layout.Alignment.ALIGN_CENTER, 1.0f, 1.0f, true)
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
                for (i in 0 until mtotalpages) {
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
            val mTLineCount = binding.MahalayaTPNMTextView.lineCount
            println("mTLineCount : $mTLineCount")
            val totalChar = binding.MahalayaTPNMTextView.length()
            val testTotalChar = totalChar.toString()
            println("totalChar : $totalChar")
            val pagesTotal = ((mTLineCount/50 + 0.99) / 0.99 ) * 1 //(Math.round(mTLineCount.toDouble() / 30.toDouble()))
            mtotalpages = pagesTotal.toInt()
            println("mtotalpages : $mtotalpages")
            if (mtotalpages == 1) {
                mstartPos1 = binding.MahalayaTPNMTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    mendPos1 = binding.MahalayaTPNMTextView.layout.getLineEnd(50)
                } else {
                    mendPos1 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount - 1)
                }
                //   mpageOneText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos1, mendPos1)
            }
            if (mtotalpages == 2) {
                mstartPos1 = binding.MahalayaTPNMTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    mendPos1 = binding.MahalayaTPNMTextView.layout.getLineEnd(50)
                } else {
                    mendPos1 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                }
                //     mpageOneText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos1, mendPos1)
                if (mTLineCount in 51..100) {
                    mstartPos2 = binding.MahalayaTPNMTextView.layout.getLineStart(51)
                    mendPos2 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos2 = binding.MahalayaTPNMTextView.layout.getLineStart(51)
                    mendPos2 = binding.MahalayaTPNMTextView.layout.getLineEnd(100)
                }
                //      mpageTwoText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos2, mendPos2)
            }
            if (mtotalpages == 3) {
                mstartPos1 = binding.MahalayaTPNMTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    mendPos1 = binding.MahalayaTPNMTextView.layout.getLineEnd(50)
                } else {
                    mendPos1 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                }
                mpageOneText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos1, mendPos1)
                if (mTLineCount in 51..100) {
                    mstartPos2 = binding.MahalayaTPNMTextView.layout.getLineStart(51)
                    mendPos2 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos2 = binding.MahalayaTPNMTextView.layout.getLineStart(51)
                    mendPos2 = binding.MahalayaTPNMTextView.layout.getLineEnd(100)
                }
                //    mpageTwoText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos2, mendPos2)
                if (mTLineCount in 101..150) {
                    mstartPos3 = binding.MahalayaTPNMTextView.layout.getLineStart(101)
                    mendPos3 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos3 = binding.MahalayaTPNMTextView.layout.getLineStart(101)
                    mendPos3 = binding.MahalayaTPNMTextView.layout.getLineEnd(150)
                }
                //    mpageThreeText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos3, mendPos3)
            }
            if (mtotalpages == 4) {
                mstartPos1 = binding.MahalayaTPNMTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    mendPos1 = binding.MahalayaTPNMTextView.layout.getLineEnd(50)
                } else {
                    mendPos1 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                }
                //   mpageOneText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos1, mendPos1)
                if (mTLineCount in 51..100) {
                    mstartPos2 = binding.MahalayaTPNMTextView.layout.getLineStart(51)
                    mendPos2 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos2 = binding.MahalayaTPNMTextView.layout.getLineStart(51)
                    mendPos2 = binding.MahalayaTPNMTextView.layout.getLineEnd(100)
                }
                //    mpageTwoText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos2, mendPos2)
                if (mTLineCount in 101..150) {
                    mstartPos3 = binding.MahalayaTPNMTextView.layout.getLineStart(101)
                    mendPos3 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos3 = binding.MahalayaTPNMTextView.layout.getLineStart(101)
                    mendPos3 = binding.MahalayaTPNMTextView.layout.getLineEnd(150)
                }
                //    mpageThreeText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos3, mendPos3)
                if (mTLineCount in 151..200) {
                    mstartPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(151)
                    mendPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(151)
                    mendPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(200)
                }
                //    mpageFourText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos4, mendPos4)
            }
            if (mtotalpages == 5) {
                mstartPos1 = binding.MahalayaTPNMTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    mendPos1 = binding.MahalayaTPNMTextView.layout.getLineEnd(50)
                } else {
                    mendPos1 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                }
                //   mpageOneText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos1, mendPos1)
                if (mTLineCount in 51..100) {
                    mstartPos2 = binding.MahalayaTPNMTextView.layout.getLineStart(51)
                    mendPos2 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos2 = binding.MahalayaTPNMTextView.layout.getLineStart(51)
                    mendPos2 = binding.MahalayaTPNMTextView.layout.getLineEnd(100)
                }
                //    mpageTwoText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos2, mendPos2)
                if (mTLineCount in 101..150) {
                    mstartPos3 = binding.MahalayaTPNMTextView.layout.getLineStart(101)
                    mendPos3 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos3 = binding.MahalayaTPNMTextView.layout.getLineStart(101)
                    mendPos3 = binding.MahalayaTPNMTextView.layout.getLineEnd(150)
                }
                //    mpageThreeText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos3, mendPos3)
                if (mTLineCount in 151..200) {
                    mstartPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(151)
                    mendPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(151)
                    mendPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(200)
                }
                //    mpageFourText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos4, mendPos4)
                if (mTLineCount in 201..250) {
                    mstartPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(201)
                    mendPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(201)
                    mendPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(250)
                }
                //    mpageFiveText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos5, mendPos5)
            }

            if (mtotalpages == 6) {
                mstartPos1 = binding.MahalayaTPNMTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    mendPos1 = binding.MahalayaTPNMTextView.layout.getLineEnd(50)
                } else {
                    mendPos1 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                }
                //    mpageOneText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos1, mendPos1)
                if (mTLineCount in 51..100) {
                    mstartPos2 = binding.MahalayaTPNMTextView.layout.getLineStart(51)
                    mendPos2 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos2 = binding.MahalayaTPNMTextView.layout.getLineStart(51)
                    mendPos2 = binding.MahalayaTPNMTextView.layout.getLineEnd(100)
                }
                //    mpageTwoText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos2, mendPos2)
                if (mTLineCount in 101..150) {
                    mstartPos3 = binding.MahalayaTPNMTextView.layout.getLineStart(101)
                    mendPos3 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos3 = binding.MahalayaTPNMTextView.layout.getLineStart(101)
                    mendPos3 = binding.MahalayaTPNMTextView.layout.getLineEnd(150)
                }
                //    mpageThreeText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos3, mendPos3)
                if (mTLineCount in 151..200) {
                    mstartPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(151)
                    mendPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(151)
                    mendPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(200)
                }
                //    mpageFourText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos4, mendPos4)
                if (mTLineCount in 201..250) {
                    mstartPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(201)
                    mendPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(201)
                    mendPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(250)
                }
                //    mpageFiveText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos5, mendPos5)
                if (mTLineCount in 251..300) {
                    mstartPos6 = binding.MahalayaTPNMTextView.layout.getLineStart(251)
                    mendPos6 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos6 = binding.MahalayaTPNMTextView.layout.getLineStart(251)
                    mendPos6 = binding.MahalayaTPNMTextView.layout.getLineEnd(300)
                }
                //    mpageSixText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos6, mendPos6)
            }
            if (mtotalpages == 7) {
                mstartPos1 = binding.MahalayaTPNMTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    mendPos1 = binding.MahalayaTPNMTextView.layout.getLineEnd(50)
                } else {
                    mendPos1 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                }
                //    mpageOneText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos1, mendPos1)
                if (mTLineCount in 51..100) {
                    mstartPos2 = binding.MahalayaTPNMTextView.layout.getLineStart(51)
                    mendPos2 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos2 = binding.MahalayaTPNMTextView.layout.getLineStart(51)
                    mendPos2 = binding.MahalayaTPNMTextView.layout.getLineEnd(100)
                }
                //    mpageTwoText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos2, mendPos2)
                if (mTLineCount in 101..150) {
                    mstartPos3 = binding.MahalayaTPNMTextView.layout.getLineStart(101)
                    mendPos3 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos3 = binding.MahalayaTPNMTextView.layout.getLineStart(101)
                    mendPos3 = binding.MahalayaTPNMTextView.layout.getLineEnd(150)
                }
                //     mpageThreeText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos3, mendPos3)
                if (mTLineCount in 151..200) {
                    mstartPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(151)
                    mendPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(151)
                    mendPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(200)
                }
                //    mpageFourText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos4, mendPos4)
                if (mTLineCount in 201..250) {
                    mstartPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(201)
                    mendPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(201)
                    mendPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(250)
                }
                //    mpageFiveText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos5, mendPos5)
                if (mTLineCount in 251..300) {
                    mstartPos6 = binding.MahalayaTPNMTextView.layout.getLineStart(251)
                    mendPos6 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos6 = binding.MahalayaTPNMTextView.layout.getLineStart(251)
                    mendPos6 = binding.MahalayaTPNMTextView.layout.getLineEnd(300)
                }
                //    mpageSixText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos6, mendPos6)
                if (mTLineCount in 301..350) {
                    mstartPos7 = binding.MahalayaTPNMTextView.layout.getLineStart(301)
                    mendPos7 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos7 = binding.MahalayaTPNMTextView.layout.getLineStart(301)
                    mendPos7 = binding.MahalayaTPNMTextView.layout.getLineEnd(350)
                }
                //    mpageSevenText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos7, mendPos7)
            }
            if (mtotalpages == 8) {
                mstartPos1 = binding.MahalayaTPNMTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    mendPos1 = binding.MahalayaTPNMTextView.layout.getLineEnd(50)
                } else {
                    mendPos1 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                }
                //    mpageOneText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos1, mendPos1)
                if (mTLineCount in 51..100) {
                    mstartPos2 = binding.MahalayaTPNMTextView.layout.getLineStart(51)
                    mendPos2 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos2 = binding.MahalayaTPNMTextView.layout.getLineStart(51)
                    mendPos2 = binding.MahalayaTPNMTextView.layout.getLineEnd(100)
                }
                //    mpageTwoText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos2, mendPos2)
                if (mTLineCount in 101..150) {
                    mstartPos3 = binding.MahalayaTPNMTextView.layout.getLineStart(101)
                    mendPos3 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos3 = binding.MahalayaTPNMTextView.layout.getLineStart(101)
                    mendPos3 = binding.MahalayaTPNMTextView.layout.getLineEnd(150)
                }
                //    mpageThreeText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos3, mendPos3)
                if (mTLineCount in 151..200) {
                    mstartPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(151)
                    mendPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(151)
                    mendPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(200)
                }
                //    mpageFourText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos4, mendPos4)
                if (mTLineCount in 201..250) {
                    mstartPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(201)
                    mendPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(201)
                    mendPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(250)
                }
                //    mpageFiveText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos5, mendPos5)
                if (mTLineCount in 251..300) {
                    mstartPos6 = binding.MahalayaTPNMTextView.layout.getLineStart(251)
                    mendPos6 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos6 = binding.MahalayaTPNMTextView.layout.getLineStart(251)
                    mendPos6 = binding.MahalayaTPNMTextView.layout.getLineEnd(300)
                }
                //    mpageSixText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos6, mendPos6)
                if (mTLineCount in 301..350) {
                    mstartPos7 = binding.MahalayaTPNMTextView.layout.getLineStart(301)
                    mendPos7 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos7 = binding.MahalayaTPNMTextView.layout.getLineStart(301)
                    mendPos7 = binding.MahalayaTPNMTextView.layout.getLineEnd(350)
                }
                println("mstartPos7 : $mstartPos7")
                println("mendPos7 : $mendPos7")
                //    mpageSevenText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos7, mendPos7)

                if (mTLineCount in 351..400) {
                    mstartPos8 = binding.MahalayaTPNMTextView.layout.getLineStart(351)
                    mendPos8 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                    println("mendPos8 : $mendPos8")
                } else {
                    mstartPos8 = binding.MahalayaTPNMTextView.layout.getLineStart(351)
                    mendPos8 = binding.MahalayaTPNMTextView.layout.getLineEnd(400)
                    println("endPos82 : $mendPos8")
                }
                println("mstartPos8 : $mstartPos8")
                println("endPos8F : $mendPos8")
                //    mpageEightText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos8, mendPos8)
            }

            if (mtotalpages == 9) {
                mstartPos1 = binding.MahalayaTPNMTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    mendPos1 = binding.MahalayaTPNMTextView.layout.getLineEnd(50)
                } else {
                    mendPos1 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                }
                //     mpageOneText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos1, mendPos1)
                if (mTLineCount in 51..100) {
                    mstartPos2 = binding.MahalayaTPNMTextView.layout.getLineStart(51)
                    mendPos2 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos2 = binding.MahalayaTPNMTextView.layout.getLineStart(51)
                    mendPos2 = binding.MahalayaTPNMTextView.layout.getLineEnd(100)
                }
                //     mpageTwoText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos2, mendPos2)
                if (mTLineCount in 101..150) {
                    mstartPos3 = binding.MahalayaTPNMTextView.layout.getLineStart(101)
                    mendPos3 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos3 = binding.MahalayaTPNMTextView.layout.getLineStart(101)
                    mendPos3 = binding.MahalayaTPNMTextView.layout.getLineEnd(150)
                }
                //    mpageThreeText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos3, mendPos3)
                if (mTLineCount in 151..200) {
                    mstartPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(151)
                    mendPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(151)
                    mendPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(200)
                }
                //    mpageFourText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos4, mendPos4)
                if (mTLineCount in 201..250) {
                    mstartPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(201)
                    mendPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(201)
                    mendPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(250)
                }
                //    mpageFiveText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos5, mendPos5)
                if (mTLineCount in 251..300) {
                    mstartPos6 = binding.MahalayaTPNMTextView.layout.getLineStart(251)
                    mendPos6 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos6 = binding.MahalayaTPNMTextView.layout.getLineStart(251)
                    mendPos6 = binding.MahalayaTPNMTextView.layout.getLineEnd(300)
                }
                //    mpageSixText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos6, mendPos6)
                if (mTLineCount in 301..350) {
                    mstartPos7 = binding.MahalayaTPNMTextView.layout.getLineStart(301)
                    mendPos7 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos7 = binding.MahalayaTPNMTextView.layout.getLineStart(301)
                    mendPos7 = binding.MahalayaTPNMTextView.layout.getLineEnd(350)
                }
                //     mpageSevenText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos7, mendPos7)
                if (mTLineCount in 351..400) {
                    mstartPos8 = binding.MahalayaTPNMTextView.layout.getLineStart(351)
                    mendPos8 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos8 = binding.MahalayaTPNMTextView.layout.getLineStart(351)
                    mendPos8 = binding.MahalayaTPNMTextView.layout.getLineEnd(400)
                }
                //     mpageEightText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos8, mendPos8)
                if (mTLineCount in 401..450) {
                    mstartPos9 = binding.MahalayaTPNMTextView.layout.getLineStart(401)
                    mendPos9 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos9 = binding.MahalayaTPNMTextView.layout.getLineStart(401)
                    mendPos9 = binding.MahalayaTPNMTextView.layout.getLineEnd(450)
                }
                //     mpageNineText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos9, mendPos9)
            }
            if (mtotalpages == 10) {
                mstartPos1 = binding.MahalayaTPNMTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    mendPos1 = binding.MahalayaTPNMTextView.layout.getLineEnd(50)
                } else {
                    mendPos1 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                }
                //      mpageOneText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos1, mendPos1)
                if (mTLineCount in 51..100) {
                    mstartPos2 = binding.MahalayaTPNMTextView.layout.getLineStart(51)
                    mendPos2 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos2 = binding.MahalayaTPNMTextView.layout.getLineStart(51)
                    mendPos2 = binding.MahalayaTPNMTextView.layout.getLineEnd(100)
                }
                //     mpageTwoText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos2, mendPos2)
                if (mTLineCount in 101..150) {
                    mstartPos3 = binding.MahalayaTPNMTextView.layout.getLineStart(101)
                    mendPos3 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos3 = binding.MahalayaTPNMTextView.layout.getLineStart(101)
                    mendPos3 = binding.MahalayaTPNMTextView.layout.getLineEnd(150)
                }
                //    mpageThreeText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos3, mendPos3)
                if (mTLineCount in 151..200) {
                    mstartPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(151)
                    mendPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(151)
                    mendPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(200)
                }
                //    mpageFourText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos4, mendPos4)
                if (mTLineCount in 201..250) {
                    mstartPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(201)
                    mendPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(201)
                    mendPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(250)
                }
                //    mpageFiveText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos5, mendPos5)
                if (mTLineCount in 251..300) {
                    mstartPos6 = binding.MahalayaTPNMTextView.layout.getLineStart(251)
                    mendPos6 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos6 = binding.MahalayaTPNMTextView.layout.getLineStart(251)
                    mendPos6 = binding.MahalayaTPNMTextView.layout.getLineEnd(300)
                }
                //    mpageSixText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos6, mendPos6)
                if (mTLineCount in 301..350) {
                    mstartPos7 = binding.MahalayaTPNMTextView.layout.getLineStart(301)
                    mendPos7 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos7 = binding.MahalayaTPNMTextView.layout.getLineStart(301)
                    mendPos7 = binding.MahalayaTPNMTextView.layout.getLineEnd(350)
                }
                //    mpageSevenText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos7, mendPos7)
                if (mTLineCount in 351..400) {
                    mstartPos8 = binding.MahalayaTPNMTextView.layout.getLineStart(351)
                    mendPos8 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos8 = binding.MahalayaTPNMTextView.layout.getLineStart(351)
                    mendPos8 = binding.MahalayaTPNMTextView.layout.getLineEnd(400)
                }
                //    mpageEightText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos8, mendPos8)
                if (mTLineCount in 401..450) {
                    mstartPos9 = binding.MahalayaTPNMTextView.layout.getLineStart(401)
                    mendPos9 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos9 = binding.MahalayaTPNMTextView.layout.getLineStart(401)
                    mendPos9 = binding.MahalayaTPNMTextView.layout.getLineEnd(450)
                }
                //    mpageNineText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos9, mendPos9)
                if (mTLineCount  in 451..500) {
                    mstartPos10 = binding.MahalayaTPNMTextView.layout.getLineStart(451)
                    mendPos10 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos10 = binding.MahalayaTPNMTextView.layout.getLineStart(451)
                    mendPos10 = binding.MahalayaTPNMTextView.layout.getLineEnd(500)
                }
                //    mpageTenText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos10, mendPos10)
            }
            if (mtotalpages == 11) {
                mstartPos1 = binding.MahalayaTPNMTextView.layout.getLineStart(0)
                if (mTLineCount  >= 50) {
                    mendPos1 = binding.MahalayaTPNMTextView.layout.getLineEnd(50)
                } else {
                    mendPos1 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                }
                //    mpageOneText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos1, mendPos1)
                if (mTLineCount  in 51..100) {
                    mstartPos2 = binding.MahalayaTPNMTextView.layout.getLineStart(51)
                    mendPos2 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos2 = binding.MahalayaTPNMTextView.layout.getLineStart(51)
                    mendPos2 = binding.MahalayaTPNMTextView.layout.getLineEnd(100)
                }
                //    mpageTwoText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos2, mendPos2)
                if (mTLineCount  in 101..150) {
                    mstartPos3 = binding.MahalayaTPNMTextView.layout.getLineStart(101)
                    mendPos3 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos3 = binding.MahalayaTPNMTextView.layout.getLineStart(101)
                    mendPos3 = binding.MahalayaTPNMTextView.layout.getLineEnd(150)
                }
                //    mpageThreeText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos3, mendPos3)
                if (mTLineCount  in 151..200) {
                    mstartPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(151)
                    mendPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(151)
                    mendPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(200)
                }
                //    mpageFourText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos4, mendPos4)
                if (mTLineCount  in 201..250) {
                    mstartPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(201)
                    mendPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(201)
                    mendPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(250)
                }
                //    mpageFiveText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos5, mendPos5)
                if (mTLineCount  in 251..300) {
                    mstartPos6 = binding.MahalayaTPNMTextView.layout.getLineStart(251)
                    mendPos6 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos6 = binding.MahalayaTPNMTextView.layout.getLineStart(251)
                    mendPos6 = binding.MahalayaTPNMTextView.layout.getLineEnd(300)
                }
                //    mpageSixText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos6, mendPos6)
                if (mTLineCount  in 301..350) {
                    mstartPos7 = binding.MahalayaTPNMTextView.layout.getLineStart(301)
                    mendPos7 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos7 = binding.MahalayaTPNMTextView.layout.getLineStart(301)
                    mendPos7 = binding.MahalayaTPNMTextView.layout.getLineEnd(350)
                }
                //    mpageSevenText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos7, mendPos7)
                if (mTLineCount in 351..400) {
                    mstartPos8 = binding.MahalayaTPNMTextView.layout.getLineStart(351)
                    mendPos8 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos8 = binding.MahalayaTPNMTextView.layout.getLineStart(351)
                    mendPos8 = binding.MahalayaTPNMTextView.layout.getLineEnd(400)
                }
                //     mpageEightText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos8, mendPos8)
                if (mTLineCount  in 401..450) {
                    mstartPos9 = binding.MahalayaTPNMTextView.layout.getLineStart(401)
                    mendPos9 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos9 = binding.MahalayaTPNMTextView.layout.getLineStart(401)
                    mendPos9 = binding.MahalayaTPNMTextView.layout.getLineEnd(450)
                }
                //    mpageNineText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos9, mendPos9)
                if (mTLineCount  in 451..500) {
                    mstartPos10 = binding.MahalayaTPNMTextView.layout.getLineStart(451)
                    mendPos10 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos10 = binding.MahalayaTPNMTextView.layout.getLineStart(451)
                    mendPos10 = binding.MahalayaTPNMTextView.layout.getLineEnd(500)
                }
                //     mpageTenText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos10, mendPos10)
                if (mTLineCount  in 501..550) {
                    mstartPos11 = binding.MahalayaTPNMTextView.layout.getLineStart(501)
                    mendPos11 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos11 = binding.MahalayaTPNMTextView.layout.getLineStart(501)
                    mendPos11 = binding.MahalayaTPNMTextView.layout.getLineEnd(550)
                }
                //    mpageElevenText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos11, mendPos11)
            }
            if (mtotalpages == 12) {
                mstartPos1 = binding.MahalayaTPNMTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    mendPos1 = binding.MahalayaTPNMTextView.layout.getLineEnd(50)
                } else {
                    mendPos1 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                }
                //     mpageOneText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos1, mendPos1)
                if (mTLineCount  in 51..100) {
                    mstartPos2 = binding.MahalayaTPNMTextView.layout.getLineStart(51)
                    mendPos2 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos2 = binding.MahalayaTPNMTextView.layout.getLineStart(51)
                    mendPos2 = binding.MahalayaTPNMTextView.layout.getLineEnd(100)
                }
                //     mpageTwoText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos2, mendPos2)
                if (mTLineCount  in 101..150) {
                    mstartPos3 = binding.MahalayaTPNMTextView.layout.getLineStart(101)
                    mendPos3 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos3 = binding.MahalayaTPNMTextView.layout.getLineStart(101)
                    mendPos3 = binding.MahalayaTPNMTextView.layout.getLineEnd(150)
                }
                //     mpageThreeText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos3, mendPos3)
                if (mTLineCount  in 151..200) {
                    mstartPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(151)
                    mendPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(151)
                    mendPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(200)
                }
                //    mpageFourText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos4, mendPos4)
                if (mTLineCount  in 201..250) {
                    mstartPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(201)
                    mendPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(201)
                    mendPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(250)
                }
                //    mpageFiveText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos5, mendPos5)
                if (mTLineCount  in 251..300) {
                    mstartPos6 = binding.MahalayaTPNMTextView.layout.getLineStart(251)
                    mendPos6 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos6 = binding.MahalayaTPNMTextView.layout.getLineStart(251)
                    mendPos6 = binding.MahalayaTPNMTextView.layout.getLineEnd(300)
                }
                //    mpageSixText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos6, mendPos6)
                if (mTLineCount  in 301..350) {
                    mstartPos7 = binding.MahalayaTPNMTextView.layout.getLineStart(301)
                    mendPos7 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos7 = binding.MahalayaTPNMTextView.layout.getLineStart(301)
                    mendPos7 = binding.MahalayaTPNMTextView.layout.getLineEnd(350)
                }
                //    mpageSevenText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos7, mendPos7)
                if (mTLineCount in 351..400) {
                    mstartPos8 = binding.MahalayaTPNMTextView.layout.getLineStart(351)
                    mendPos8 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos8 = binding.MahalayaTPNMTextView.layout.getLineStart(351)
                    mendPos8 = binding.MahalayaTPNMTextView.layout.getLineEnd(400)
                }
                //    mpageEightText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos8, mendPos8)
                if (mTLineCount  in 401..450) {
                    mstartPos9 = binding.MahalayaTPNMTextView.layout.getLineStart(401)
                    mendPos9 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos9 = binding.MahalayaTPNMTextView.layout.getLineStart(401)
                    mendPos9 = binding.MahalayaTPNMTextView.layout.getLineEnd(450)
                }
                //    mpageNineText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos9, mendPos9)
                if (mTLineCount  in 451..500) {
                    mstartPos10 = binding.MahalayaTPNMTextView.layout.getLineStart(451)
                    mendPos10 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos10 = binding.MahalayaTPNMTextView.layout.getLineStart(451)
                    mendPos10 = binding.MahalayaTPNMTextView.layout.getLineEnd(500)
                }
                //    mpageTenText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos10, mendPos10)
                if (mTLineCount  in 501..550) {
                    mstartPos11 = binding.MahalayaTPNMTextView.layout.getLineStart(501)
                    mendPos11 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos11 = binding.MahalayaTPNMTextView.layout.getLineStart(501)
                    mendPos11 = binding.MahalayaTPNMTextView.layout.getLineEnd(550)
                }
                //    mpageElevenText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos11, mendPos11)
                if (mTLineCount  in 551..600) {
                    mstartPos12 = binding.MahalayaTPNMTextView.layout.getLineStart(551)
                    mendPos12 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos12 = binding.MahalayaTPNMTextView.layout.getLineStart(551)
                    mendPos12 = binding.MahalayaTPNMTextView.layout.getLineEnd(600)
                }
                //    mpageTwelveText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos12, mendPos12)
            }
            if (mtotalpages == 13) {
                mstartPos1 = binding.MahalayaTPNMTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    mendPos1 = binding.MahalayaTPNMTextView.layout.getLineEnd(50)
                } else {
                    mendPos1 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                }
                //     mpageOneText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos1, mendPos1)
                if (mTLineCount  in 51..100) {
                    mstartPos2 = binding.MahalayaTPNMTextView.layout.getLineStart(51)
                    mendPos2 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos2 = binding.MahalayaTPNMTextView.layout.getLineStart(51)
                    mendPos2 = binding.MahalayaTPNMTextView.layout.getLineEnd(100)
                }
                //    mpageTwoText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos2, mendPos2)
                if (mTLineCount  in 101..150) {
                    mstartPos3 = binding.MahalayaTPNMTextView.layout.getLineStart(101)
                    mendPos3 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos3 = binding.MahalayaTPNMTextView.layout.getLineStart(101)
                    mendPos3 = binding.MahalayaTPNMTextView.layout.getLineEnd(150)
                }
                //    mpageThreeText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos3, mendPos3)
                if (mTLineCount  in 151..200) {
                    mstartPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(151)
                    mendPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(151)
                    mendPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(200)
                }
                //    mpageFourText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos4, mendPos4)
                if (mTLineCount  in 201..250) {
                    mstartPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(201)
                    mendPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(201)
                    mendPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(250)
                }
                //    mpageFiveText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos5, mendPos5)
                if (mTLineCount  in 251..300) {
                    mstartPos6 = binding.MahalayaTPNMTextView.layout.getLineStart(251)
                    mendPos6 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos6 = binding.MahalayaTPNMTextView.layout.getLineStart(251)
                    mendPos6 = binding.MahalayaTPNMTextView.layout.getLineEnd(300)
                }
                //    mpageSixText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos6, mendPos6)
                if (mTLineCount  in 301..350) {
                    mstartPos7 = binding.MahalayaTPNMTextView.layout.getLineStart(301)
                    mendPos7 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos7 = binding.MahalayaTPNMTextView.layout.getLineStart(301)
                    mendPos7 = binding.MahalayaTPNMTextView.layout.getLineEnd(350)
                }
                //    mpageSevenText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos7, mendPos7)
                if (mTLineCount in 351..400) {
                    mstartPos8 = binding.MahalayaTPNMTextView.layout.getLineStart(351)
                    mendPos8 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos8 = binding.MahalayaTPNMTextView.layout.getLineStart(351)
                    mendPos8 = binding.MahalayaTPNMTextView.layout.getLineEnd(400)
                }
                //    mpageEightText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos8, mendPos8)
                if (mTLineCount  in 401..450) {
                    mstartPos9 = binding.MahalayaTPNMTextView.layout.getLineStart(401)
                    mendPos9 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos9 = binding.MahalayaTPNMTextView.layout.getLineStart(401)
                    mendPos9 = binding.MahalayaTPNMTextView.layout.getLineEnd(450)
                }
                //    mpageNineText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos9, mendPos9)
                if (mTLineCount in 451..500) {
                    mstartPos10 = binding.MahalayaTPNMTextView.layout.getLineStart(451)
                    mendPos10 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos10 = binding.MahalayaTPNMTextView.layout.getLineStart(451)
                    mendPos10 = binding.MahalayaTPNMTextView.layout.getLineEnd(500)
                }
                //    mpageTenText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos10, mendPos10)
                if (mTLineCount in 501..550) {
                    mstartPos11 = binding.MahalayaTPNMTextView.layout.getLineStart(501)
                    mendPos11 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos11 = binding.MahalayaTPNMTextView.layout.getLineStart(501)
                    mendPos11 = binding.MahalayaTPNMTextView.layout.getLineEnd(550)
                }
                //    mpageElevenText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos11, mendPos11)
                if (mTLineCount in 551..600) {
                    mstartPos12 = binding.MahalayaTPNMTextView.layout.getLineStart(551)
                    mendPos12 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos12 = binding.MahalayaTPNMTextView.layout.getLineStart(551)
                    mendPos12 = binding.MahalayaTPNMTextView.layout.getLineEnd(600)
                }
                //    mpageTwelveText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos12, mendPos12)
                if (mTLineCount in 601..650) {
                    mstartPos13 = binding.MahalayaTPNMTextView.layout.getLineStart(601)
                    mendPos13 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos13 = binding.MahalayaTPNMTextView.layout.getLineStart(601)
                    mendPos13 = binding.MahalayaTPNMTextView.layout.getLineEnd(650)
                }
                //    mpageThirteenText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos13, mendPos13)
            }
            if (mtotalpages == 14) {
                mstartPos1 = binding.MahalayaTPNMTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    mendPos1 = binding.MahalayaTPNMTextView.layout.getLineEnd(50)
                } else {
                    mendPos1 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                }
                //    mpageOneText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos1, mendPos1)
                if (mTLineCount in 51..100) {
                    mstartPos2 = binding.MahalayaTPNMTextView.layout.getLineStart(51)
                    mendPos2 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos2 = binding.MahalayaTPNMTextView.layout.getLineStart(51)
                    mendPos2 = binding.MahalayaTPNMTextView.layout.getLineEnd(100)
                }
                //    mpageTwoText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos2, mendPos2)
                if (mTLineCount in 101..150) {
                    mstartPos3 = binding.MahalayaTPNMTextView.layout.getLineStart(101)
                    mendPos3 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos3 = binding.MahalayaTPNMTextView.layout.getLineStart(101)
                    mendPos3 = binding.MahalayaTPNMTextView.layout.getLineEnd(150)
                }
                //    mpageThreeText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos3, mendPos3)
                if (mTLineCount in 151..200) {
                    mstartPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(151)
                    mendPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(151)
                    mendPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(200)
                }
                //    mpageFourText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos4, mendPos4)
                if (mTLineCount in 201..250) {
                    mstartPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(201)
                    mendPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(201)
                    mendPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(250)
                }
                //    mpageFiveText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos5, mendPos5)
                if (mTLineCount in 251..300) {
                    mstartPos6 = binding.MahalayaTPNMTextView.layout.getLineStart(251)
                    mendPos6 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos6 = binding.MahalayaTPNMTextView.layout.getLineStart(251)
                    mendPos6 = binding.MahalayaTPNMTextView.layout.getLineEnd(300)
                }
                //    mpageSixText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos6, mendPos6)
                if (mTLineCount in 301..350) {
                    mstartPos7 = binding.MahalayaTPNMTextView.layout.getLineStart(301)
                    mendPos7 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos7 = binding.MahalayaTPNMTextView.layout.getLineStart(301)
                    mendPos7 = binding.MahalayaTPNMTextView.layout.getLineEnd(350)
                }
                //    mpageSevenText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos7, mendPos7)
                if (mTLineCount in 351..400) {
                    mstartPos8 = binding.MahalayaTPNMTextView.layout.getLineStart(351)
                    mendPos8 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos8 = binding.MahalayaTPNMTextView.layout.getLineStart(351)
                    mendPos8 = binding.MahalayaTPNMTextView.layout.getLineEnd(400)
                }
                //    mpageEightText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos8, mendPos8)
                if (mTLineCount in 401..450) {
                    mstartPos9 = binding.MahalayaTPNMTextView.layout.getLineStart(401)
                    mendPos9 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos9 = binding.MahalayaTPNMTextView.layout.getLineStart(401)
                    mendPos9 = binding.MahalayaTPNMTextView.layout.getLineEnd(450)
                }
                //    mpageNineText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos9, mendPos9)
                if (mTLineCount in 451..500) {
                    mstartPos10 = binding.MahalayaTPNMTextView.layout.getLineStart(451)
                    mendPos10 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos10 = binding.MahalayaTPNMTextView.layout.getLineStart(451)
                    mendPos10 = binding.MahalayaTPNMTextView.layout.getLineEnd(500)
                }
                //    mpageTenText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos10, mendPos10)
                if (mTLineCount in 501..550) {
                    mstartPos11 = binding.MahalayaTPNMTextView.layout.getLineStart(501)
                    mendPos11 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos11 = binding.MahalayaTPNMTextView.layout.getLineStart(501)
                    mendPos11 = binding.MahalayaTPNMTextView.layout.getLineEnd(550)
                }
                //    mpageElevenText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos11, mendPos11)
                if (mTLineCount in 551..600) {
                    mstartPos12 = binding.MahalayaTPNMTextView.layout.getLineStart(551)
                    mendPos12 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos12 = binding.MahalayaTPNMTextView.layout.getLineStart(551)
                    mendPos12 = binding.MahalayaTPNMTextView.layout.getLineEnd(600)
                }
                //    mpageTwelveText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos12, mendPos12)
                if (mTLineCount in 601..650) {
                    mstartPos13 = binding.MahalayaTPNMTextView.layout.getLineStart(601)
                    mendPos13 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos13 = binding.MahalayaTPNMTextView.layout.getLineStart(601)
                    mendPos13 = binding.MahalayaTPNMTextView.layout.getLineEnd(650)
                }
                //    mpageThirteenText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos13, mendPos13)
                if (mTLineCount in 651..700) {
                    mstartPos14 = binding.MahalayaTPNMTextView.layout.getLineStart(651)
                    mendPos14 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos14 = binding.MahalayaTPNMTextView.layout.getLineStart(651)
                    mendPos14 = binding.MahalayaTPNMTextView.layout.getLineEnd(700)
                }
                //    mpageFourteenText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos14, mendPos14)
            }
            if (mtotalpages == 15) {
                mstartPos1 = binding.MahalayaTPNMTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    mendPos1 = binding.MahalayaTPNMTextView.layout.getLineEnd(50)
                } else {
                    mendPos1 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                }
                //    mpageOneText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos1, mendPos1)
                if (mTLineCount in 51..100) {
                    mstartPos2 = binding.MahalayaTPNMTextView.layout.getLineStart(51)
                    mendPos2 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos2 = binding.MahalayaTPNMTextView.layout.getLineStart(51)
                    mendPos2 = binding.MahalayaTPNMTextView.layout.getLineEnd(100)
                }
                //    mpageTwoText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos2, mendPos2)
                if (mTLineCount in 101..150) {
                    mstartPos3 = binding.MahalayaTPNMTextView.layout.getLineStart(101)
                    mendPos3 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos3 = binding.MahalayaTPNMTextView.layout.getLineStart(101)
                    mendPos3 = binding.MahalayaTPNMTextView.layout.getLineEnd(150)
                }
                //    mpageThreeText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos3, mendPos3)
                if (mTLineCount in 151..200) {
                    mstartPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(151)
                    mendPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(151)
                    mendPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(200)
                }
                //     mpageFourText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos4, mendPos4)
                if (mTLineCount in 201..250) {
                    mstartPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(201)
                    mendPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(201)
                    mendPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(250)
                }
                //    mpageFiveText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos5, mendPos5)
                if (mTLineCount in 251..300) {
                    mstartPos6 = binding.MahalayaTPNMTextView.layout.getLineStart(251)
                    mendPos6 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos6 = binding.MahalayaTPNMTextView.layout.getLineStart(251)
                    mendPos6 = binding.MahalayaTPNMTextView.layout.getLineEnd(300)
                }
                //    mpageSixText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos6, mendPos6)
                if (mTLineCount in 301..350) {
                    mstartPos7 = binding.MahalayaTPNMTextView.layout.getLineStart(301)
                    mendPos7 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos7 = binding.MahalayaTPNMTextView.layout.getLineStart(301)
                    mendPos7 = binding.MahalayaTPNMTextView.layout.getLineEnd(350)
                }
                //     mpageSevenText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos7, mendPos7)
                if (mTLineCount in 351..400) {
                    mstartPos8 = binding.MahalayaTPNMTextView.layout.getLineStart(351)
                    mendPos8 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos8 = binding.MahalayaTPNMTextView.layout.getLineStart(351)
                    mendPos8 = binding.MahalayaTPNMTextView.layout.getLineEnd(400)
                }
                //    mpageEightText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos8, mendPos8)
                if (mTLineCount in 401..450) {
                    mstartPos9 = binding.MahalayaTPNMTextView.layout.getLineStart(401)
                    mendPos9 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos9 = binding.MahalayaTPNMTextView.layout.getLineStart(401)
                    mendPos9 = binding.MahalayaTPNMTextView.layout.getLineEnd(450)
                }
                //    mpageNineText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos9, mendPos9)
                if (mTLineCount in 451..500) {
                    mstartPos10 = binding.MahalayaTPNMTextView.layout.getLineStart(451)
                    mendPos10 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos10 = binding.MahalayaTPNMTextView.layout.getLineStart(451)
                    mendPos10 = binding.MahalayaTPNMTextView.layout.getLineEnd(500)
                }
                //    mpageTenText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos10, mendPos10)
                if (mTLineCount in 501..550) {
                    mstartPos11 = binding.MahalayaTPNMTextView.layout.getLineStart(501)
                    mendPos11 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos11 = binding.MahalayaTPNMTextView.layout.getLineStart(501)
                    mendPos11 = binding.MahalayaTPNMTextView.layout.getLineEnd(550)
                }
                //    mpageElevenText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos11, mendPos11)
                if (mTLineCount in 551..600) {
                    mstartPos12 = binding.MahalayaTPNMTextView.layout.getLineStart(551)
                    mendPos12 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos12 = binding.MahalayaTPNMTextView.layout.getLineStart(551)
                    mendPos12 = binding.MahalayaTPNMTextView.layout.getLineEnd(600)
                }
                //    mpageTwelveText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos12, mendPos12)
                if (mTLineCount in 601..650) {
                    mstartPos13 = binding.MahalayaTPNMTextView.layout.getLineStart(601)
                    mendPos13 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos13 = binding.MahalayaTPNMTextView.layout.getLineStart(601)
                    mendPos13 = binding.MahalayaTPNMTextView.layout.getLineEnd(650)
                }
                //    mpageThirteenText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos13, mendPos13)
                if (mTLineCount in 651..700) {
                    mstartPos14 = binding.MahalayaTPNMTextView.layout.getLineStart(651)
                    mendPos14 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos14 = binding.MahalayaTPNMTextView.layout.getLineStart(651)
                    mendPos14 = binding.MahalayaTPNMTextView.layout.getLineEnd(700)
                }
                //    mpageFourteenText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos14, mendPos14)
                if (mTLineCount in 701..750) {
                    mstartPos15 = binding.MahalayaTPNMTextView.layout.getLineStart(701)
                    mendPos15 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos15 = binding.MahalayaTPNMTextView.layout.getLineStart(701)
                    mendPos15 = binding.MahalayaTPNMTextView.layout.getLineEnd(750)
                }
                //    mpageFifteenText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos15, mendPos15)
            }
            if (mtotalpages == 16) {
                mstartPos1 = binding.MahalayaTPNMTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    mendPos1 = binding.MahalayaTPNMTextView.layout.getLineEnd(50)
                } else {
                    mendPos1 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                }
                //   mpageOneText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos1, mendPos1)
                if (mTLineCount in 51..100) {
                    mstartPos2 = binding.MahalayaTPNMTextView.layout.getLineStart(51)
                    mendPos2 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos2 = binding.MahalayaTPNMTextView.layout.getLineStart(51)
                    mendPos2 = binding.MahalayaTPNMTextView.layout.getLineEnd(100)
                }
                //    mpageTwoText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos2, mendPos2)
                if (mTLineCount in 101..150) {
                    mstartPos3 = binding.MahalayaTPNMTextView.layout.getLineStart(101)
                    mendPos3 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos3 = binding.MahalayaTPNMTextView.layout.getLineStart(101)
                    mendPos3 = binding.MahalayaTPNMTextView.layout.getLineEnd(150)
                }
                //    mpageThreeText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos3, mendPos3)
                if (mTLineCount in 151..200) {
                    mstartPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(151)
                    mendPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(151)
                    mendPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(200)
                }
                //    mpageFourText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos4, mendPos4)
                if (mTLineCount in 201..250) {
                    mstartPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(201)
                    mendPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(201)
                    mendPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(250)
                }
                //    mpageFiveText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos5, mendPos5)
                if (mTLineCount in 251..300) {
                    mstartPos6 = binding.MahalayaTPNMTextView.layout.getLineStart(251)
                    mendPos6 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos6 = binding.MahalayaTPNMTextView.layout.getLineStart(251)
                    mendPos6 = binding.MahalayaTPNMTextView.layout.getLineEnd(300)
                }
                //    mpageSixText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos6, mendPos6)
                if (mTLineCount in 301..350) {
                    mstartPos7 = binding.MahalayaTPNMTextView.layout.getLineStart(301)
                    mendPos7 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos7 = binding.MahalayaTPNMTextView.layout.getLineStart(301)
                    mendPos7 = binding.MahalayaTPNMTextView.layout.getLineEnd(350)
                }
                //    mpageSevenText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos7, mendPos7)
                if (mTLineCount in 351..400) {
                    mstartPos8 = binding.MahalayaTPNMTextView.layout.getLineStart(351)
                    mendPos8 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos8 = binding.MahalayaTPNMTextView.layout.getLineStart(351)
                    mendPos8 = binding.MahalayaTPNMTextView.layout.getLineEnd(400)
                }
                //    mpageEightText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos8, mendPos8)
                if (mTLineCount in 401..450) {
                    mstartPos9 = binding.MahalayaTPNMTextView.layout.getLineStart(401)
                    mendPos9 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos9 = binding.MahalayaTPNMTextView.layout.getLineStart(401)
                    mendPos9 = binding.MahalayaTPNMTextView.layout.getLineEnd(450)
                }
                //    mpageNineText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos9, mendPos9)
                if (mTLineCount in 451..500) {
                    mstartPos10 = binding.MahalayaTPNMTextView.layout.getLineStart(451)
                    mendPos10 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos10 = binding.MahalayaTPNMTextView.layout.getLineStart(451)
                    mendPos10 = binding.MahalayaTPNMTextView.layout.getLineEnd(500)
                }
                //    mpageTenText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos10, mendPos10)
                if (mTLineCount in 501..550) {
                    mstartPos11 = binding.MahalayaTPNMTextView.layout.getLineStart(501)
                    mendPos11 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos11 = binding.MahalayaTPNMTextView.layout.getLineStart(501)
                    mendPos11 = binding.MahalayaTPNMTextView.layout.getLineEnd(550)
                }
                //    mpageElevenText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos11, mendPos11)
                if (mTLineCount in 551..600) {
                    mstartPos12 = binding.MahalayaTPNMTextView.layout.getLineStart(551)
                    mendPos12 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos12 = binding.MahalayaTPNMTextView.layout.getLineStart(551)
                    mendPos12 = binding.MahalayaTPNMTextView.layout.getLineEnd(600)
                }
                //    mpageTwelveText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos12, mendPos12)
                if (mTLineCount in 601..650) {
                    mstartPos13 = binding.MahalayaTPNMTextView.layout.getLineStart(601)
                    mendPos13 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos13 = binding.MahalayaTPNMTextView.layout.getLineStart(601)
                    mendPos13 = binding.MahalayaTPNMTextView.layout.getLineEnd(650)
                }
                //    mpageThirteenText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos13, mendPos13)
                if (mTLineCount in 651..700) {
                    mstartPos14 = binding.MahalayaTPNMTextView.layout.getLineStart(651)
                    mendPos14 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos14 = binding.MahalayaTPNMTextView.layout.getLineStart(651)
                    mendPos14 = binding.MahalayaTPNMTextView.layout.getLineEnd(700)
                }
                //    mpageFourteenText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos14, mendPos14)
                if (mTLineCount in 701..750) {
                    mstartPos15 = binding.MahalayaTPNMTextView.layout.getLineStart(701)
                    mendPos15 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos15 = binding.MahalayaTPNMTextView.layout.getLineStart(701)
                    mendPos15 = binding.MahalayaTPNMTextView.layout.getLineEnd(750)
                }
                //    mpageFifteenText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos15, mendPos15)
                if (mTLineCount in 751..800) {
                    mstartPos16 = binding.MahalayaTPNMTextView.layout.getLineStart(751)
                    mendPos16 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos16 = binding.MahalayaTPNMTextView.layout.getLineStart(751)
                    mendPos16 = binding.MahalayaTPNMTextView.layout.getLineEnd(800)
                }
                //    mpageSixteenText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos16, mendPos16)
            }
            if (mtotalpages == 17) {
                mstartPos1 = binding.MahalayaTPNMTextView.layout.getLineStart(0)
                if (mTLineCount >= 50) {
                    mendPos1 = binding.MahalayaTPNMTextView.layout.getLineEnd(50)
                } else {
                    mendPos1 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                }
                //    mpageOneText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos1, mendPos1)
                if (mTLineCount in 51..100) {
                    mstartPos2 = binding.MahalayaTPNMTextView.layout.getLineStart(51)
                    mendPos2 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos2 = binding.MahalayaTPNMTextView.layout.getLineStart(51)
                    mendPos2 = binding.MahalayaTPNMTextView.layout.getLineEnd(100)
                }
                //    mpageTwoText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos2, mendPos2)
                if (mTLineCount in 101..150) {
                    mstartPos3 = binding.MahalayaTPNMTextView.layout.getLineStart(101)
                    mendPos3 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos3 = binding.MahalayaTPNMTextView.layout.getLineStart(101)
                    mendPos3 = binding.MahalayaTPNMTextView.layout.getLineEnd(150)
                }
                //    mpageThreeText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos3, mendPos3)
                if (mTLineCount in 151..200) {
                    mstartPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(151)
                    mendPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(151)
                    mendPos4 = binding.MahalayaTPNMTextView.layout.getLineEnd(200)
                }
                //    mpageFourText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos4, mendPos4)
                if (mTLineCount in 201..250) {
                    mstartPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(201)
                    mendPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(201)
                    mendPos5 = binding.MahalayaTPNMTextView.layout.getLineEnd(250)
                }
                //    mpageFiveText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos5, mendPos5)
                if (mTLineCount in 251..300) {
                    mstartPos6 = binding.MahalayaTPNMTextView.layout.getLineStart(251)
                    mendPos6 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos6 = binding.MahalayaTPNMTextView.layout.getLineStart(251)
                    mendPos6 = binding.MahalayaTPNMTextView.layout.getLineEnd(300)
                }
                //    mpageSixText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos6, mendPos6)
                if (mTLineCount in 301..350) {
                    mstartPos7 = binding.MahalayaTPNMTextView.layout.getLineStart(301)
                    mendPos7 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos7 = binding.MahalayaTPNMTextView.layout.getLineStart(301)
                    mendPos7 = binding.MahalayaTPNMTextView.layout.getLineEnd(350)
                }
                //    mpageSevenText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos7, mendPos7)
                if (mTLineCount in 351..400) {
                    mstartPos8 = binding.MahalayaTPNMTextView.layout.getLineStart(351)
                    mendPos8 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos8 = binding.MahalayaTPNMTextView.layout.getLineStart(351)
                    mendPos8 = binding.MahalayaTPNMTextView.layout.getLineEnd(400)
                }
                //    mpageEightText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos8, mendPos8)
                if (mTLineCount in 401..450) {
                    mstartPos9 = binding.MahalayaTPNMTextView.layout.getLineStart(401)
                    mendPos9 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos9 = binding.MahalayaTPNMTextView.layout.getLineStart(401)
                    mendPos9 = binding.MahalayaTPNMTextView.layout.getLineEnd(450)
                }
                //    mpageNineText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos9, mendPos9)
                if (mTLineCount in 451..500) {
                    mstartPos10 = binding.MahalayaTPNMTextView.layout.getLineStart(451)
                    mendPos10 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos10 = binding.MahalayaTPNMTextView.layout.getLineStart(451)
                    mendPos10 = binding.MahalayaTPNMTextView.layout.getLineEnd(500)
                }
                //    mpageTenText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos10, mendPos10)
                if (mTLineCount in 501..550) {
                    mstartPos11 = binding.MahalayaTPNMTextView.layout.getLineStart(501)
                    mendPos11 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos11 = binding.MahalayaTPNMTextView.layout.getLineStart(501)
                    mendPos11 = binding.MahalayaTPNMTextView.layout.getLineEnd(550)
                }
                //    mpageElevenText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos11, mendPos11)
                if (mTLineCount in 551..600) {
                    mstartPos12 = binding.MahalayaTPNMTextView.layout.getLineStart(551)
                    mendPos12 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos12 = binding.MahalayaTPNMTextView.layout.getLineStart(551)
                    mendPos12 = binding.MahalayaTPNMTextView.layout.getLineEnd(600)
                }
                //    mpageTwelveText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos12, mendPos12)
                if (mTLineCount in 601..650) {
                    mstartPos13 = binding.MahalayaTPNMTextView.layout.getLineStart(601)
                    mendPos13 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos13 = binding.MahalayaTPNMTextView.layout.getLineStart(601)
                    mendPos13 = binding.MahalayaTPNMTextView.layout.getLineEnd(650)
                }
                //    mpageThirteenText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos13, mendPos13)
                if (mTLineCount in 651..700) {
                    mstartPos14 = binding.MahalayaTPNMTextView.layout.getLineStart(651)
                    mendPos14 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos14 = binding.MahalayaTPNMTextView.layout.getLineStart(651)
                    mendPos14 = binding.MahalayaTPNMTextView.layout.getLineEnd(700)
                }
                //    mpageFourteenText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos14, mendPos14)
                if (mTLineCount in 701..750) {
                    mstartPos15 = binding.MahalayaTPNMTextView.layout.getLineStart(701)
                    mendPos15 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos15 = binding.MahalayaTPNMTextView.layout.getLineStart(701)
                    mendPos15 = binding.MahalayaTPNMTextView.layout.getLineEnd(750)
                }
                //     mpageFifteenText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos15, mendPos15)
                if (mTLineCount in 751..800) {
                    mstartPos16 = binding.MahalayaTPNMTextView.layout.getLineStart(751)
                    mendPos16 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos16 = binding.MahalayaTPNMTextView.layout.getLineStart(751)
                    mendPos16 = binding.MahalayaTPNMTextView.layout.getLineEnd(800)
                }
                //    mpageSixteenText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos16, mendPos16)
                if (mTLineCount in 801..850) {
                    mstartPos17 = binding.MahalayaTPNMTextView.layout.getLineStart(801)
                    mendPos17 = binding.MahalayaTPNMTextView.layout.getLineEnd(mTLineCount-1)
                } else {
                    mstartPos17 = binding.MahalayaTPNMTextView.layout.getLineStart(801)
                    mendPos17 = binding.MahalayaTPNMTextView.layout.getLineEnd(850)
                }
                //    mpageSeventeenText = binding.MahalayaTPNMTextView.text.toString().substring(mstartPos17, mendPos17)
            }
            val printManager = this.getSystemService(Context.PRINT_SERVICE) as PrintManager
            val jobName = this.getString(R.string.app_name) + "-$mheading"
            println("jobName : $jobName")
            printManager.print(jobName, MyPrintDocumentAdapter(this), null)
        }
    }
}


fun trial() {

    val exExFlag = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
    val start: Int = 0

    val bdSt20A = SpannableString("\nமஹாளய தர்ப்பணம் dateToday கர்த்தா - yourName")
    val regexReplace3 = """(dateToday)""".toRegex()
    val bdSt20C = SpannableString(bdSt20A.replace(regexReplace3, dateTdy))
    val regexReplace4 = """(yourName)""".toRegex()
    mheading = SpannableString(bdSt20C.replace(regexReplace4, yrNamee))
    mheading.setSpan(AbsoluteSizeSpan(16, true), start, mheading.length, exExFlag)
    mheading.setSpan(StyleSpan(Typeface.BOLD), start, mheading.length, exExFlag)
    mheading.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, mheading.length, exExFlag)

    mHeading1 = SpannableString("\nஆசமனம்\n")
    mHeading1.setSpan(AbsoluteSizeSpan(16, true), start, mHeading1.length, exExFlag)
    mHeading1.setSpan(StyleSpan(Typeface.BOLD), start, mHeading1.length, exExFlag)
    mHeading1.setSpan(UnderlineSpan(), start, mHeading1.length, exExFlag)
    mHeading1.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, mHeading1.length, exExFlag)

    mComment1 = SpannableString(
        "\nஒவ்வொரு உத்தரிணி ஜலம் எடுத்து வலது கையில் விட்டு ஒவ்வொரு மந்திரத்துக்கும் உட்கொள்ளவும்"
    )
    mComment1.setSpan(AbsoluteSizeSpan(13, true), start, mComment1.length, exExFlag)
    mComment1.setSpan(StyleSpan(Typeface.ITALIC), start, mComment1.length, exExFlag)
    mComment1.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment1.length, exExFlag)

    mBody1 = SpannableString("\nஓம் அச்யுதாய நம: |  ஓம் அனந்தாய நம: |  ஓம் கோவிந்தாய நம: ||")
    mBody1.setSpan(AbsoluteSizeSpan(14, true), start, mBody1.length, exExFlag)
    mBody1.setSpan(StyleSpan(Typeface.BOLD), start, mBody1.length, exExFlag)
    mBody1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody1.length, exExFlag)

    mComment2 = SpannableString("\nஒரு உத்தரிணி ஜலம் எடுத்து வலது கையில் விட்டு கீழே விடவும்")
    mComment2.setSpan(AbsoluteSizeSpan(13, true), start, mComment2.length, exExFlag)
    mComment2.setSpan(StyleSpan(Typeface.ITALIC), start, mComment2.length, exExFlag)
    mComment2.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment2.length, exExFlag)

    mBody2 = SpannableString(" - அபஉபஸ்ப்ருஸ்ய ||\n")
    mBody2.setSpan(AbsoluteSizeSpan(14, true), start, mBody2.length, exExFlag)
    mBody2.setSpan(StyleSpan(Typeface.BOLD), start, mBody2.length, exExFlag)
    mBody2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody2.length, exExFlag)

    mComment3 = SpannableString(
        " வலது கட்டை விரலால் வாயை துடைத்துக் கொள்ளவும் \n விரல்களால் அங்கங்களை தொடவும் \n நடு மற்றும் மோதிர விரல் வலது கன்னம்"
    )
    mComment3.setSpan(AbsoluteSizeSpan(13, true), start, mComment3.length, exExFlag)
    mComment3.setSpan(StyleSpan(Typeface.ITALIC), start, mComment3.length, exExFlag)
    mComment3.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment3.length, exExFlag)

    mBody3 = SpannableString("- கேசவா")
    mBody3.setSpan(AbsoluteSizeSpan(14, true), start, mBody3.length, exExFlag)
    mBody3.setSpan(StyleSpan(Typeface.BOLD), start, mBody3.length, exExFlag)
    mBody3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody3.length, exExFlag)

    mComment4 = SpannableString("\n நடு மற்றும் மோதிர விரல் - இடது கன்னம்")
    mComment4.setSpan(AbsoluteSizeSpan(13, true), start, mComment4.length, exExFlag)
    mComment4.setSpan(StyleSpan(Typeface.ITALIC), start, mComment4.length, exExFlag)
    mComment4.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment4.length, exExFlag)

    mBody4 = SpannableString("- நாராயணா")
    mBody4.setSpan(AbsoluteSizeSpan(14, true), start, mBody4.length, exExFlag)
    mBody4.setSpan(StyleSpan(Typeface.BOLD), start, mBody4.length, exExFlag)
    mBody4.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody4.length, exExFlag)

    mComment5 = SpannableString("\n ஆள்காட்டி மற்றும் கட்டை விரல் - வலது மூக்கு")
    mComment5.setSpan(AbsoluteSizeSpan(13, true), start, mComment5.length, exExFlag)
    mComment5.setSpan(StyleSpan(Typeface.ITALIC), start, mComment5.length, exExFlag)
    mComment5.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment5.length, exExFlag)

    mBody5 = SpannableString("- மாதவா")
    mBody5.setSpan(AbsoluteSizeSpan(14, true), start, mBody5.length, exExFlag)
    mBody5.setSpan(StyleSpan(Typeface.BOLD), start, mBody5.length, exExFlag)
    mBody5.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody5.length, exExFlag)

    mComment6 = SpannableString("\n ஆள்காட்டி மற்றும் கட்டை விரல் - இடது மூக்கு")
    mComment6.setSpan(AbsoluteSizeSpan(13, true), start, mComment6.length, exExFlag)
    mComment6.setSpan(StyleSpan(Typeface.ITALIC), start, mComment6.length, exExFlag)
    mComment6.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment6.length, exExFlag)

    mBody6 = SpannableString("- கோவிந்தா")
    mBody6.setSpan(AbsoluteSizeSpan(14, true), start, mBody6.length, exExFlag)
    mBody6.setSpan(StyleSpan(Typeface.BOLD), start, mBody6.length, exExFlag)
    mBody6.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody6.length, exExFlag)

    mComment7 = SpannableString("\n நடு மற்றும் கட்டை விரல் - வலது கண்")
    mComment7.setSpan(AbsoluteSizeSpan(13, true), start, mComment7.length, exExFlag)
    mComment7.setSpan(StyleSpan(Typeface.ITALIC), start, mComment7.length, exExFlag)
    mComment7.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment7.length, exExFlag)

    mBody7 = SpannableString("- விஷ்ணு")
    mBody7.setSpan(AbsoluteSizeSpan(14, true), start, mBody7.length, exExFlag)
    mBody7.setSpan(StyleSpan(Typeface.BOLD), start, mBody7.length, exExFlag)
    mBody7.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody7.length, exExFlag)

    mComment8 = SpannableString("\n நடு மற்றும் கட்டை விரல் - இடது கண்")
    mComment8.setSpan(AbsoluteSizeSpan(13, true), start, mComment8.length, exExFlag)
    mComment8.setSpan(StyleSpan(Typeface.ITALIC), start, mComment8.length, exExFlag)
    mComment8.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment8.length, exExFlag)

    mBody8 = SpannableString("- மதுஸூதனா")
    mBody8.setSpan(AbsoluteSizeSpan(14, true), start, mBody8.length, exExFlag)
    mBody8.setSpan(StyleSpan(Typeface.BOLD), start, mBody8.length, exExFlag)
    mBody8.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody8.length, exExFlag)

    mComment9 = SpannableString("\n மோதிர மற்றும் கட்டை விரல் - வலது காது")
    mComment9.setSpan(AbsoluteSizeSpan(13, true), start, mComment9.length, exExFlag)
    mComment9.setSpan(StyleSpan(Typeface.ITALIC), start, mComment9.length, exExFlag)
    mComment9.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment9.length, exExFlag)

    mBody9 = SpannableString("- த்ரிவிக்ரமா")
    mBody9.setSpan(AbsoluteSizeSpan(14, true), start, mBody9.length, exExFlag)
    mBody9.setSpan(StyleSpan(Typeface.BOLD), start, mBody9.length, exExFlag)
    mBody9.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody9.length, exExFlag)

    mComment10 = SpannableString("\n மோதிர மற்றும் கட்டை விரல் - இடது காது")
    mComment10.setSpan(AbsoluteSizeSpan(13, true), start, mComment10.length, exExFlag)
    mComment10.setSpan(StyleSpan(Typeface.ITALIC), start, mComment10.length, exExFlag)
    mComment10.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment10.length, exExFlag)

    mBody10 = SpannableString("- வாமனா")
    mBody10.setSpan(AbsoluteSizeSpan(14, true), start, mBody10.length, exExFlag)
    mBody10.setSpan(StyleSpan(Typeface.BOLD), start, mBody10.length, exExFlag)
    mBody10.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody10.length, exExFlag)

    mComment11 = SpannableString("\n வலது உள்ளங்கை - மார்பு")
    mComment11.setSpan(AbsoluteSizeSpan(13, true), start, mComment11.length, exExFlag)
    mComment11.setSpan(StyleSpan(Typeface.ITALIC), start, mComment11.length, exExFlag)
    mComment11.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment11.length, exExFlag)

    mBody11 = SpannableString("- ஸ்ரீதரா")
    mBody11.setSpan(AbsoluteSizeSpan(14, true), start, mBody11.length, exExFlag)
    mBody11.setSpan(StyleSpan(Typeface.BOLD), start, mBody11.length, exExFlag)
    mBody11.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody11.length, exExFlag)

    mComment12 = SpannableString("\n ஐந்து விரல் நுனி - முன் தலை")
    mComment12.setSpan(AbsoluteSizeSpan(13, true), start, mComment12.length, exExFlag)
    mComment12.setSpan(StyleSpan(Typeface.ITALIC), start, mComment12.length, exExFlag)
    mComment12.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment12.length, exExFlag)

    mBody12 = SpannableString("- ஹ்ருஷீகேஷா")
    mBody12.setSpan(AbsoluteSizeSpan(14, true), start, mBody12.length, exExFlag)
    mBody12.setSpan(StyleSpan(Typeface.BOLD), start, mBody12.length, exExFlag)
    mBody12.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody12.length, exExFlag)

    mComment13 = SpannableString("\n ஐந்து விரல் நுனி - வலது தோள்")
    mComment13.setSpan(AbsoluteSizeSpan(13, true), start, mComment13.length, exExFlag)
    mComment13.setSpan(StyleSpan(Typeface.ITALIC), start, mComment13.length, exExFlag)
    mComment13.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment13.length, exExFlag)

    mBody13 = SpannableString("- பத்மநாபா")
    mBody13.setSpan(AbsoluteSizeSpan(14, true), start, mBody13.length, exExFlag)
    mBody13.setSpan(StyleSpan(Typeface.BOLD), start, mBody13.length, exExFlag)
    mBody13.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody13.length, exExFlag)

    mComment14 = SpannableString("\n ஐந்து விரல் நுனி - இடது தோள்")
    mComment14.setSpan(AbsoluteSizeSpan(13, true), start, mComment14.length, exExFlag)
    mComment14.setSpan(StyleSpan(Typeface.ITALIC), start, mComment14.length, exExFlag)
    mComment14.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment14.length, exExFlag)

    mBody14 = SpannableString("- தாமோதரா\n")
    mBody14.setSpan(AbsoluteSizeSpan(14, true), start, mBody14.length, exExFlag)
    mBody14.setSpan(StyleSpan(Typeface.BOLD), start, mBody14.length, exExFlag)
    mBody14.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody14.length, exExFlag)

    mComment15A = SpannableString(
        "\n இஃது மஹாளயதினத்தன்று மாத்யான்ஹிக காலத்தில் மாத்யான்ஹிக, ப்ரம்ஹயக்ஞ, " +
                "தேவரிஷி பித்ரு தர்ப்பணங்களை யதாவத் முடித்துக் கொண்டு செய்ய வேண்டிய கர்மா.  \n  இதற்கு"
    )
    mComment15A.setSpan(AbsoluteSizeSpan(13, true), start, mComment15A.length, exExFlag)
    mComment15A.setSpan(StyleSpan(Typeface.ITALIC), start, mComment15A.length, exExFlag)
    mComment15A.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment15A.length, exExFlag)

    mComment15B = SpannableString(" இரண்டு")
    mComment15B.setSpan(AbsoluteSizeSpan(13, true), start, mComment15B.length, exExFlag)
    mComment15B.setSpan(StyleSpan(Typeface.ITALIC), start, mComment15B.length, exExFlag)
    mComment15B.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment15B.length, exExFlag)

    mComment15C = SpannableString(" மூன்று")
    mComment15C.setSpan(AbsoluteSizeSpan(13, true), start, mComment15C.length, exExFlag)
    mComment15C.setSpan(StyleSpan(Typeface.ITALIC), start, mComment15C.length, exExFlag)
    mComment15C.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment15C.length, exExFlag)

    mComment15D =
        SpannableString(" 7, 5, 3 பில்  ஒத்தப்படையில் உள்ள  மடித்த கூர்ச்சம், 3 பில் பவித்ரம் ஒன்று கொஞ்சம் எள்ளும்,")
    mComment15D.setSpan(AbsoluteSizeSpan(13, true), start, mComment15D.length, exExFlag)
    mComment15D.setSpan(StyleSpan(Typeface.ITALIC), start, mComment15D.length, exExFlag)
    mComment15D.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment15D.length, exExFlag)

    mComment15E = SpannableString(" 7, 5, 3 பில்  ஒத்தப்படையில் உள்ள  மடித்த கூர்ச்சம், 3 பில் பவித்ரம் ஒன்று கொஞ்சம் " +
            "எள்ளும், சிறிது அரிசியும்,")
    mComment15E.setSpan(AbsoluteSizeSpan(13, true), start, mComment15E.length, exExFlag)
    mComment15E.setSpan(StyleSpan(Typeface.ITALIC), start, mComment15E.length, exExFlag)
    mComment15E.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment15E.length, exExFlag)

    mComment15F = SpannableString(
        " சொம்பு, பஞ்சபாத்ரத்தில் தீர்த்தம் தேவை. \n" +
                "    கிழக்கு முகமாக ஆசனத்தில் அமர்ந்து அமைதியாக நிறுத்தி நிதானமாக, பித்ரு தேவதைகளை மனதில் தியானித்து " +
                "கீழ்க்கூறிய பிரகாரம் தர்ப்பணம் செய்ய வேண்டும்.\nமூன்று பில் பவித்ரம் தரித்து-\n"
    )
    mComment15F.setSpan(AbsoluteSizeSpan(13, true), start, mComment15F.length, exExFlag)
    mComment15F.setSpan(StyleSpan(Typeface.ITALIC), start, mComment15F.length, exExFlag)
    mComment15F.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment15F.length, exExFlag)

    mBody15 = SpannableString("தர்பேஷு ஆசீன:")
    mBody15.setSpan(AbsoluteSizeSpan(14, true), start, mBody15.length, exExFlag)
    mBody15.setSpan(StyleSpan(Typeface.BOLD), start, mBody15.length, exExFlag)
    mBody15.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody15.length, exExFlag)

    mComment16 = SpannableString(" \n- என்று சொல்லி 3 கட்டை தர்பங்களை ஆசனமாகவும்\n")
    mComment16.setSpan(AbsoluteSizeSpan(13, true), start, mComment16.length, exExFlag)
    mComment16.setSpan(StyleSpan(Typeface.ITALIC), start, mComment16.length, exExFlag)
    mComment16.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment16.length, exExFlag)

    mBody16 = SpannableString("தர்பான் தாரயமாண:")
    mBody16.setSpan(AbsoluteSizeSpan(14, true), start, mBody16.length, exExFlag)
    mBody16.setSpan(StyleSpan(Typeface.BOLD), start, mBody16.length, exExFlag)
    mBody16.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody16.length, exExFlag)

    mComment17 = SpannableString(
        " \n- என்று சொல்லி 3 கட்டை தர்பங்களை பவித்ரத்துடன் கையிலிடுக்கிக் கொண்டும், " +
                "சங்கல்பம் செய்ய வேண்டும்.\n"
    )
    mComment17.setSpan(AbsoluteSizeSpan(13, true), start, mComment17.length, exExFlag)
    mComment17.setSpan(StyleSpan(Typeface.ITALIC), start, mComment17.length, exExFlag)
    mComment17.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment17.length, exExFlag)

    mHeading2 = SpannableString("சங்கல்பம்\n")
    mHeading2.setSpan(AbsoluteSizeSpan(16, true), start, mHeading2.length, exExFlag)
    mHeading2.setSpan(StyleSpan(Typeface.BOLD), start, mHeading2.length, exExFlag)
    mHeading2.setSpan(UnderlineSpan(), start, mHeading2.length, exExFlag)
    mHeading2.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, mHeading2.length, exExFlag)

    mBody17 = SpannableString("  ஓம் சுக்லாம்பரதரம் விஷ்ணும் சசிவர்ணம் சதுர்புஜம் \n        ப்ரஸன்ன வதனம் த்யாயேத் ஸர்வ விக்ன உபசாந்தயே")
    mBody17.setSpan(AbsoluteSizeSpan(14, true), start, mBody17.length, exExFlag)
    mBody17.setSpan(StyleSpan(Typeface.BOLD), start, mBody17.length, exExFlag)
    mBody17.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody17.length, exExFlag)

    mComment18 = SpannableString("\n     முன் தலையில் கை வைத்துக் கொண்டு-\n")
    mComment18.setSpan(AbsoluteSizeSpan(13, true), start, mComment18.length, exExFlag)
    mComment18.setSpan(StyleSpan(Typeface.ITALIC), start, mComment18.length, exExFlag)
    mComment18.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment18.length, exExFlag)

    mBody18 = SpannableString("ஓம் ப்ரணவஸ்ய - பரப்ரும்மரிஷி:")
    mBody18.setSpan(AbsoluteSizeSpan(14, true), start, mBody18.length, exExFlag)
    mBody18.setSpan(StyleSpan(Typeface.BOLD), start, mBody18.length, exExFlag)
    mBody18.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody18.length, exExFlag)

    mComment19 = SpannableString("\n நுனிமூக்கில் கை வைத்துக் கொண்டு-\n")
    mComment19.setSpan(AbsoluteSizeSpan(13, true), start, mComment19.length, exExFlag)
    mComment19.setSpan(StyleSpan(Typeface.ITALIC), start, mComment19.length, exExFlag)
    mComment19.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment19.length, exExFlag)

    mBody19 = SpannableString("தேவீ காயத்ரீச் சந்த:")
    mBody19.setSpan(AbsoluteSizeSpan(14, true), start, mBody19.length, exExFlag)
    mBody19.setSpan(StyleSpan(Typeface.BOLD), start, mBody19.length, exExFlag)
    mBody19.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody19.length, exExFlag)

    mComment20 = SpannableString("\n ஹ்ருதயத்தில் கை வைத்துக் கொண்டு-\n")
    mComment20.setSpan(AbsoluteSizeSpan(13, true), start, mComment20.length, exExFlag)
    mComment20.setSpan(StyleSpan(Typeface.ITALIC), start, mComment20.length, exExFlag)
    mComment20.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment20.length, exExFlag)

    mBody20 = SpannableString("ஸவிதா பரமாத்மா தேவதா")
    mBody20.setSpan(AbsoluteSizeSpan(14, true), start, mBody20.length, exExFlag)
    mBody20.setSpan(StyleSpan(Typeface.BOLD), start, mBody20.length, exExFlag)
    mBody20.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody20.length, exExFlag)

    mComment21 = SpannableString("\n கைகளை உள் வாங்கவும்-\n")
    mComment21.setSpan(AbsoluteSizeSpan(13, true), start, mComment21.length, exExFlag)
    mComment21.setSpan(StyleSpan(Typeface.ITALIC), start, mComment21.length, exExFlag)
    mComment21.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment21.length, exExFlag)

    mBody21 = SpannableString("ப்ராணாயாமே விநியோக:\n")
    mBody21.setSpan(AbsoluteSizeSpan(14, true), start, mBody21.length, exExFlag)
    mBody21.setSpan(StyleSpan(Typeface.BOLD), start, mBody21.length, exExFlag)
    mBody21.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody21.length, exExFlag)

    mComment22 = SpannableString("  ப்ராணாயாமம்  செய்ய வேண்டும் ")
    mComment22.setSpan(AbsoluteSizeSpan(13, true), start, mComment22.length, exExFlag)
    mComment22.setSpan(StyleSpan(Typeface.ITALIC), start, mComment22.length, exExFlag)
    mComment22.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment22.length, exExFlag)

    mBody22 = SpannableString(
        "\n   ஓம் பூ: ஓம் புவ: ஓம் சுவ: ஓம் மஹ: ஓம் ஜந: ஓம் தப: ஓம் ஸத்யம் \nதத்ஸவிதுர் வரேண்யம் பர்கோ தேவஸ்ய தீமஹி தியோயோ ந:  ப்ரசோதயாத் ஓம் ஆப: ஜ்யோதீரஸ: அம்ருதம் ப்ரம்ஹ பூர்புவஸ்வரோம்\n" +
                "    ஓம் அபவித்ர: பவித்ரோவா ஸர்வாவஸ்தாம் கதோபிவா யஸ்மரேத் புண்டரீகாக்ஷ்ம் ஸபாஹ்யாப்யந்தர: சுசி:\n" +
                "    மானஸம் வாசிகம் பாபம் கர்மனா ஸமுபார்ஜிதம் ஸ்ரீராம ஸ்மரணேநைவ வ்யபோஹதி நஸம்சய:\n" +
                "    ஸ்ரீராம ராமராம  திதிர்விஷ்ணு: ததாவார: நக்ஷத்ரம் விஷ்ணுரேவச யோகஸ்ச கரணம் சைவ ஸர்வம் விஷ்ணுமயம் ஜகத்\n" +
                "    ஸ்ரீகோவிந்த கோவிந்தகோவிந்த அத்ய ஸ்ரீ பகவத: மஹாபுருஷஸ்ய விஷ்ணோ: ஆக்ஞயா ப்ரவர்த்தமானஸ்ய \n\n  ஆத்ய ப்ரம்ஹண:"
    )
    mBody22.setSpan(AbsoluteSizeSpan(14, true), start, mBody22.length, exExFlag)
    mBody22.setSpan(StyleSpan(Typeface.BOLD), start, mBody22.length, exExFlag)
    mBody22.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody22.length, exExFlag)

    mComment23 = SpannableString(" \n- ஆதி ப்ரும்மாவிலிருந்து from 1st Brahma’s life ")
    mComment23.setSpan(AbsoluteSizeSpan(13, true), start, mComment23.length, exExFlag)
    mComment23.setSpan(StyleSpan(Typeface.ITALIC), start, mComment23.length, exExFlag)
    mComment23.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment23.length, exExFlag)

    mBody23 = SpannableString("\n  த்விதீயே பரார்த்தே")
    mBody23.setSpan(AbsoluteSizeSpan(14, true), start, mBody23.length, exExFlag)
    mBody23.setSpan(StyleSpan(Typeface.BOLD), start, mBody23.length, exExFlag)
    mBody23.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody23.length, exExFlag)

    mComment24 = SpannableString(" \n- Brahma’s 2nd Parardha. 1 Parardha = 50 Brahma years ")
    mComment24.setSpan(AbsoluteSizeSpan(13, true), start, mComment24.length, exExFlag)
    mComment24.setSpan(StyleSpan(Typeface.ITALIC), start, mComment24.length, exExFlag)
    mComment24.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment24.length, exExFlag)

    mBody24 = SpannableString("\n  ஸ்வேத வராஹ கல்பே")
    mBody24.setSpan(AbsoluteSizeSpan(14, true), start, mBody24.length, exExFlag)
    mBody24.setSpan(StyleSpan(Typeface.BOLD), start, mBody24.length, exExFlag)
    mBody24.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody24.length, exExFlag)

    mComment25 = SpannableString(" \n- first of the thirty Kalpas- Matsya Purana ")
    mComment25.setSpan(AbsoluteSizeSpan(13, true), start, mComment25.length, exExFlag)
    mComment25.setSpan(StyleSpan(Typeface.ITALIC), start, mComment25.length, exExFlag)
    mComment25.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment25.length, exExFlag)

    mBody25 = SpannableString("\n  வைவஸ்வத மன்வந்தரே")
    mBody25.setSpan(AbsoluteSizeSpan(14, true), start, mBody25.length, exExFlag)
    mBody25.setSpan(StyleSpan(Typeface.BOLD), start, mBody25.length, exExFlag)
    mBody25.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody25.length, exExFlag)

    mComment26 = SpannableString(" \n- 14 manvantras = 1 Kalpa, now 7th - Vaivasvata)")
    mComment26.setSpan(AbsoluteSizeSpan(13, true), start, mComment26.length, exExFlag)
    mComment26.setSpan(StyleSpan(Typeface.ITALIC), start, mComment26.length, exExFlag)
    mComment26.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment26.length, exExFlag)

    mBody26 = SpannableString("\n  அஷ்டா விம்சதிதமே")
    mBody26.setSpan(AbsoluteSizeSpan(14, true), start, mBody26.length, exExFlag)
    mBody26.setSpan(StyleSpan(Typeface.BOLD), start, mBody26.length, exExFlag)
    mBody26.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody26.length, exExFlag)

    mComment27 = SpannableString(" \n-(18,000 Kalpas completed)")
    mComment27.setSpan(AbsoluteSizeSpan(13, true), start, mComment27.length, exExFlag)
    mComment27.setSpan(StyleSpan(Typeface.ITALIC), start, mComment27.length, exExFlag)
    mComment27.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment27.length, exExFlag)

    mBody27 = SpannableString("\n  கலியுகே ப்ரதமேபாதே")
    mBody27.setSpan(AbsoluteSizeSpan(14, true), start, mBody27.length, exExFlag)
    mBody27.setSpan(StyleSpan(Typeface.BOLD), start, mBody27.length, exExFlag)
    mBody27.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody27.length, exExFlag)

    mComment28 = SpannableString(" \n-(first quarter of the Kaliyuga)")
    mComment28.setSpan(AbsoluteSizeSpan(13, true), start, mComment28.length, exExFlag)
    mComment28.setSpan(StyleSpan(Typeface.ITALIC), start, mComment28.length, exExFlag)
    mComment28.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment28.length, exExFlag)

    mBody28 = SpannableString("\n  ஜம்பூத்வீபே பாரதவர்ஷே பரதகண்டே மேரோ: தக்ஷிணேபார்ச்வே சகாப்தே அஸ்மின் வர்த்தமானே")
    mBody28.setSpan(AbsoluteSizeSpan(14, true), start, mBody28.length, exExFlag)
    mBody28.setSpan(StyleSpan(Typeface.BOLD), start, mBody28.length, exExFlag)
    mBody28.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody28.length, exExFlag)

    mComment29 = SpannableString(" \n-(geographical area of our motherland)")
    mComment29.setSpan(AbsoluteSizeSpan(13, true), start, mComment29.length, exExFlag)
    mComment29.setSpan(StyleSpan(Typeface.ITALIC), start, mComment29.length, exExFlag)
    mComment29.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment29.length, exExFlag)

    val Body29AA = SpannableString("\n  வ்யவஹாரிகே ப்ரபவாதீநாம் ஷஷ்ட்யா: ஸம்வத்ஸராணாம் மத்யே ஸ்ரீtamilYear நாம ஸம்வத்ஸரே")
    val regexReplace6 = """(tamilYear)""".toRegex()
    mBody29 = SpannableString(Body29AA.replace(regexReplace6, Varusham))
    mBody29.setSpan(AbsoluteSizeSpan(14, true), start, mBody29.length, exExFlag)
    mBody29.setSpan(StyleSpan(Typeface.BOLD), start, mBody29.length, exExFlag)
    mBody29.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody29.length, exExFlag)

    mComment30 = SpannableString(" \n-(specifies the year)")
    mComment30.setSpan(AbsoluteSizeSpan(13, true), start, mComment30.length, exExFlag)
    mComment30.setSpan(StyleSpan(Typeface.ITALIC), start, mComment30.length, exExFlag)
    mComment30.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment30.length, exExFlag)

    val Body30AA = SpannableString("\n  sunPosition")
    val regexReplace7 = """(sunPosition)""".toRegex()
    mBody30 = SpannableString(Body30AA.replace(regexReplace7, ayyanamm))
    mBody30.setSpan(AbsoluteSizeSpan(14, true), start, mBody30.length, exExFlag)
    mBody30.setSpan(StyleSpan(Typeface.BOLD), start, mBody30.length, exExFlag)
    mBody30.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody30.length, exExFlag)

    mComment31 = SpannableString(" \n-(Uttarayana [roughly January to June] and Dakshinayana [roughly July to December])")
    mComment31.setSpan(AbsoluteSizeSpan(13, true), start, mComment31.length, exExFlag)
    mComment31.setSpan(StyleSpan(Typeface.ITALIC), start, mComment31.length, exExFlag)
    mComment31.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment31.length, exExFlag)

    val Body31AA = SpannableString("\n  season ருதௌ")
    val regexReplace8 = """(season)""".toRegex()
    mBody31 = SpannableString(Body31AA.replace(regexReplace8, kalam))
    mBody31.setSpan(AbsoluteSizeSpan(14, true), start, mBody31.length, exExFlag)
    mBody31.setSpan(StyleSpan(Typeface.BOLD), start, mBody31.length, exExFlag)
    mBody31.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody31.length, exExFlag)

    mComment32 = SpannableString(" \n-(season of the year, Vasanta/ Greeshma/ Varsha/ Sharat/ Hemanta/ Shishira)")
    mComment32.setSpan(AbsoluteSizeSpan(13, true), start, mComment32.length, exExFlag)
    mComment32.setSpan(StyleSpan(Typeface.ITALIC), start, mComment32.length, exExFlag)
    mComment32.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment32.length, exExFlag)

    val Body32AA = SpannableString("\n  sunRasi மாஸே")
    val regexReplace9 = """(sunRasi)""".toRegex()
    mBody32 = SpannableString(Body32AA.replace(regexReplace9, rasee))
    mBody32.setSpan(AbsoluteSizeSpan(14, true), start, mBody32.length, exExFlag)
    mBody32.setSpan(StyleSpan(Typeface.BOLD), start, mBody32.length, exExFlag)
    mBody32.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody32.length, exExFlag)

    mComment33 = SpannableString(
        " \n-(12 months - Mesha, Vrushabha, Mithuna, Kataka, Simha, Kanya, Tula, " +
                "Vrichika, Dhanur, Makara, Kumbha, and Meena)"
    )
    mComment33.setSpan(AbsoluteSizeSpan(13, true), start, mComment33.length, exExFlag)
    mComment33.setSpan(StyleSpan(Typeface.ITALIC), start, mComment33.length, exExFlag)
    mComment33.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment33.length, exExFlag)

    val Body33AA = SpannableString("\n  moonPosition பக்ஷே")
    val regexReplace10 = """(moonPosition)""".toRegex()
    mBody33 = SpannableString(Body33AA.replace(regexReplace10, baksham))
    mBody33.setSpan(AbsoluteSizeSpan(14, true), start, mBody33.length, exExFlag)
    mBody33.setSpan(StyleSpan(Typeface.BOLD), start, mBody33.length, exExFlag)
    mBody33.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody33.length, exExFlag)

    mComment34 = SpannableString(" \n-(Shukla - day after amavasya to pournami/ Krishna - day after pournami to amavasya)")
    mComment34.setSpan(AbsoluteSizeSpan(13, true), start, mComment34.length, exExFlag)
    mComment34.setSpan(StyleSpan(Typeface.ITALIC), start, mComment34.length, exExFlag)
    mComment34.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment34.length, exExFlag)

    val Body34AA = SpannableString("\n  Thithiயாம் புண்யதிதௌ")
    val regexReplace11 = """(Thithi)""".toRegex()
    mBody34 = SpannableString(Body34AA.replace(regexReplace11, todThithi))
    mBody34.setSpan(AbsoluteSizeSpan(14, true), start, mBody34.length, exExFlag)
    mBody34.setSpan(StyleSpan(Typeface.BOLD), start, mBody34.length, exExFlag)
    mBody34.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody34.length, exExFlag)

    mComment35 = SpannableString(" \n-(15 tithis and repeats)")
    mComment35.setSpan(AbsoluteSizeSpan(13, true), start, mComment35.length, exExFlag)
    mComment35.setSpan(StyleSpan(Typeface.ITALIC), start, mComment35.length, exExFlag)
    mComment35.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment35.length, exExFlag)

    val Body35AA = SpannableString("\n  weekDay வாஸரயுக்தாயாம்")
    val regexReplace12 = """(weekDay)""".toRegex()
    mBody35 = SpannableString(Body35AA.replace(regexReplace12, kizhamai))
    mBody35.setSpan(AbsoluteSizeSpan(14, true), start, mBody35.length, exExFlag)
    mBody35.setSpan(StyleSpan(Typeface.BOLD), start, mBody35.length, exExFlag)
    mBody35.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody35.length, exExFlag)

    mComment36 = SpannableString(
        " \n-(Sunday-Bhanu, Monday-Indu, Tuesday-Bhauma, Wednesday-Sowmya, " +
                "Thursday-Guru, Friday-ப்ருகு, Saturday-Sthira)"
    )
    mComment36.setSpan(AbsoluteSizeSpan(13, true), start, mComment36.length, exExFlag)
    mComment36.setSpan(StyleSpan(Typeface.ITALIC), start, mComment36.length, exExFlag)
    mComment36.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment36.length, exExFlag)

    val Body36AA = SpannableString("\n  natchatram நக்ஷ்த்ரயுக்தாயாம்")
    val regexReplace13 = """(natchatram)""".toRegex()
    mBody36 = SpannableString(Body36AA.replace(regexReplace13, nachathirm))
    mBody36.setSpan(AbsoluteSizeSpan(14, true), start, mBody36.length, exExFlag)
    mBody36.setSpan(StyleSpan(Typeface.BOLD), start, mBody36.length, exExFlag)
    mBody36.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody36.length, exExFlag)

    mComment37 = SpannableString(" \n- (27 nakshatras)")
    mComment37.setSpan(AbsoluteSizeSpan(13, true), start, mComment37.length, exExFlag)
    mComment37.setSpan(StyleSpan(Typeface.ITALIC), start, mComment37.length, exExFlag)
    mComment37.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment37.length, exExFlag)

    val Body37AAA =
        SpannableString("\n  Yogam நாமயோக Karana கரணயுக்தாயாம் ஏவங்குண விசேஷேண விசிஷ்டாயாம் அஸ்யாம் Thithiயாம் புண்யதிதௌ")
    val regexReplace14 = """(Yogam)""".toRegex()
    val Body37AA = SpannableString(Body37AAA.replace(regexReplace14, yog))
    val regexReplace15 = """(Karana)""".toRegex()
    val Body37A = SpannableString(Body37AA.replace(regexReplace15, kar))
    val regexReplace16 = """(Thithi)""".toRegex()
    mBody37 = SpannableString(Body37A.replace(regexReplace16, todThithi))
    mBody37.setSpan(AbsoluteSizeSpan(14, true), start, mBody37.length, exExFlag)
    mBody37.setSpan(StyleSpan(Typeface.BOLD), start, mBody37.length, exExFlag)
    mBody37.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody37.length, exExFlag)

    mComment38A = SpannableString("\nபூணூலை ")
    mComment38A.setSpan(AbsoluteSizeSpan(13, true), start, mComment38A.length, exExFlag)
    mComment38A.setSpan(StyleSpan(Typeface.ITALIC), start, mComment38A.length, exExFlag)
    mComment38A.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment38A.length, exExFlag)

    mRedComment1 = SpannableString(" அபஸவ்யம் ")
    mRedComment1.setSpan(AbsoluteSizeSpan(13, true), start, mRedComment1.length, exExFlag)
    mRedComment1.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, mRedComment1.length, exExFlag)
    mRedComment1.setSpan(ForegroundColorSpan(Color.RED), start, mRedComment1.length, exExFlag)

    mComment38B = SpannableString(" செய்து கொண்டு தெற்குமுகமாக, முகம் மட்டுமாவது, இருந்து கூறவும்)")
    mComment38B.setSpan(AbsoluteSizeSpan(13, true), start, mComment38B.length, exExFlag)
    mComment38B.setSpan(StyleSpan(Typeface.ITALIC), start, mComment38B.length, exExFlag)
    mComment38B.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment38B.length, exExFlag)

    val Body38A = SpannableString("\n yourGothram கோத்ராணாம் அஸ்மத் ")
    val regexReplace17 = """(yourGothram)""".toRegex()
    mBody38 = SpannableString(Body38A.replace(regexReplace17, urGothram))
    mBody38.setSpan(AbsoluteSizeSpan(14, true), start, mBody38.length, exExFlag)
    mBody38.setSpan(StyleSpan(Typeface.BOLD), start, mBody38.length, exExFlag)
    mBody38.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody38.length, exExFlag)

    val Body38A1 = SpannableString("\n  yourGothram கோத்ராணாம் அஸ்மத் ")
    val regexReplace171 = """(yourGothram)""".toRegex()
    mBody381 = SpannableString(Body38A1.replace(regexReplace171, urGothram))
    mBody381.setSpan(AbsoluteSizeSpan(14, true), start, mBody381.length, exExFlag)
    mBody381.setSpan(StyleSpan(Typeface.BOLD), start, mBody381.length, exExFlag)
    mBody381.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody381.length, exExFlag)

    mBody39 = SpannableString("பித்ரு ")
    mBody39.setSpan(AbsoluteSizeSpan(14, true), start, mBody39.length, exExFlag)
    mBody39.setSpan(StyleSpan(Typeface.BOLD), start, mBody39.length, exExFlag)
    mBody39.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody39.length, exExFlag)

    mBody39B = SpannableString("பிதாமஹ ப்ரபிதாமஹாநாம் ")
    mBody39B.setSpan(AbsoluteSizeSpan(14, true), start, mBody39B.length, exExFlag)
    mBody39B.setSpan(StyleSpan(Typeface.BOLD), start, mBody39B.length, exExFlag)
    mBody39B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody39B.length, exExFlag)

    val Body40A = SpannableString("yourFatherName, ")
    val regexReplace18 = """(yourFatherName)""".toRegex()
    mBody40 = SpannableString(Body40A.replace(regexReplace18, yrFNamee))
    mBody40.setSpan(AbsoluteSizeSpan(14, true), start, mBody40.length, exExFlag)
    mBody40.setSpan(StyleSpan(Typeface.BOLD), start, mBody40.length, exExFlag)
    mBody40.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody40.length, exExFlag)

    val Body41AA = SpannableString("yourGrandFatherName, yourGreatGrandFatherName ")
    val regexReplace19 = """(yourGrandFatherName)""".toRegex()
    val Body41A = SpannableString(Body41AA.replace(regexReplace19, yrGFNamee))
    val regexReplace20 = """(yourGreatGrandFatherName)""".toRegex()
    mBody41 = SpannableString(Body41A.replace(regexReplace20, yrGGFNamee))
    mBody41.setSpan(AbsoluteSizeSpan(14, true), start, mBody41.length, exExFlag)
    mBody41.setSpan(StyleSpan(Typeface.BOLD), start, mBody41.length, exExFlag)
    mBody41.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody41.length, exExFlag)

    mBody39A = SpannableString("ப்ரபிதாமஹ வ்ருத்தப்ரபிதாமஹாநாம் ")
    mBody39A.setSpan(AbsoluteSizeSpan(14, true), start, mBody39A.length, exExFlag)
    mBody39A.setSpan(StyleSpan(Typeface.BOLD), start, mBody39A.length, exExFlag)
    mBody39A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody39A.length, exExFlag)

    val Body41BBB = SpannableString("yourGreatGrandFatherName, yourGreatGreatGrandFatherName ")
    val regexReplace21 = """(yourGreatGrandFatherName)""".toRegex()
    val Body41BB = SpannableString(Body41BBB.replace(regexReplace21, yrGGFNamee))
    val regexReplace22 = """(yourGreatGreatGrandFatherName)""".toRegex()
    mBody41B = SpannableString(Body41BB.replace(regexReplace22, yrGGGFNamee))
    mBody41B.setSpan(AbsoluteSizeSpan(14, true), start, mBody41B.length, exExFlag)
    mBody41B.setSpan(StyleSpan(Typeface.BOLD), start, mBody41B.length, exExFlag)
    mBody41B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody41B.length, exExFlag)

    mBody42 = SpannableString("சர்மணாம் வஸூருத்ர ஆதித்யஸ்வரூபாணாம் அக்ஷ்ய த்ருப்த்யர்த்தம்")
    mBody42.setSpan(AbsoluteSizeSpan(14, true), start, mBody42.length, exExFlag)
    mBody42.setSpan(StyleSpan(Typeface.BOLD), start, mBody42.length, exExFlag)
    mBody42.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody42.length, exExFlag)

    val Body39FM4 = SpannableString(
        "\n\n  yourGothram கோத்ராணாம் அஸ்மத் மாத்ரு, பிதாமஹி, ப்ரபிதாமஹினாம் yourMotherName, yourFatherMotherName, " +
                "yourFatherGrandMotherName நாமதேயாணாம் வசுருத்ர ஆதித்ய ஸ்வரூபானாம்"
    )
    val regexReplaceFM4 = """(yourGothram)""".toRegex()
    val Body39FM3 = SpannableString(Body39FM4.replace(regexReplaceFM4, urGothram))
    val regexReplaceFM3 = """(yourMotherName)""".toRegex()
    val Body39FM2 = SpannableString(Body39FM3.replace(regexReplaceFM3, amName))
    val regexReplaceFM2 = """(yourFatherMotherName)""".toRegex()
    val Body39FM1 = SpannableString(Body39FM2.replace(regexReplaceFM2, apAmmaName))
    val regexReplaceFM1 = """(yourFatherGrandMotherName)""".toRegex()
    mBody39FM = SpannableString(Body39FM1.replace(regexReplaceFM1, apPattiName))
    mBody39FM.setSpan(AbsoluteSizeSpan(14, true), start, mBody39FM.length, exExFlag)
    mBody39FM.setSpan(StyleSpan(Typeface.BOLD), start, mBody39FM.length, exExFlag)
    mBody39FM.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody39FM.length, exExFlag)

    val MBody38A = SpannableString("\n\n  motherSideGothram கோத்ராணாம் அஸ்மத் ")
    val MregexReplace17 = """(motherSideGothram)""".toRegex()
    mMBody38 = SpannableString(MBody38A.replace(MregexReplace17, MGothram))
    mMBody38.setSpan(AbsoluteSizeSpan(14, true), start, mMBody38.length, exExFlag)
    mMBody38.setSpan(StyleSpan(Typeface.BOLD), start, mMBody38.length, exExFlag)
    mMBody38.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mMBody38.length, exExFlag)

    val MBody38Ab = SpannableString("\n\n  motherSideGothram கோத்ராணாம் அஸ்மத் ")
    val MregexReplace17b = """(motherSideGothram)""".toRegex()
    mMBody38b = SpannableString(MBody38Ab.replace(MregexReplace17b, MGothram))
    mMBody38b.setSpan(AbsoluteSizeSpan(14, true), start, mMBody38b.length, exExFlag)
    mMBody38b.setSpan(StyleSpan(Typeface.BOLD), start, mMBody38b.length, exExFlag)
    mMBody38b.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mMBody38b.length, exExFlag)

    val MBody41BBB = SpannableString(
        "மாதாமஹ, ப்ரமாதாமஹ, வ்ருத்தப்ரமாதாமஹாநாம் motherFather, motherGrandFather, " +
                "motherGreatGrandFather சர்மணாம் வஸூருத்ர ஆதித்ய ஸ்வரூபாணாம் உபயவம்ச பித்ருணாம் அக்ஷ்ய த்ருப்த்யர்த்தம் "
    )
    val MregexReplace21 = """(motherFather)""".toRegex()
    val MBody41BB = SpannableString(MBody41BBB.replace(MregexReplace21, MFNamee))
    val MregexReplace22 = """(motherGrandFather)""".toRegex()
    val MBody41BA = SpannableString(MBody41BB.replace(MregexReplace22, MGFNamee))
    val MregexReplace22A = """(motherGreatGrandFather)""".toRegex()
    mMBody41B = SpannableString(MBody41BA.replace(MregexReplace22A, MGGFNamee))
    mMBody41B.setSpan(AbsoluteSizeSpan(14, true), start, mMBody41B.length, exExFlag)
    mMBody41B.setSpan(StyleSpan(Typeface.BOLD), start, mMBody41B.length, exExFlag)
    mMBody41B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mMBody41B.length, exExFlag)

    val MBody41BBBc = SpannableString(
        "மாதாமஹி, ப்ரமாதாமஹி, வ்ருத்தப் ப்ரமாதாமஹினாம் motherMother, motherGrandMother, " +
                "motherGreatGrandMother, நாமதேயாணாம் வசுருத்ர ஆதித்ய ஸ்வரூபானாம் அக்ஷ்ய த்ருப்த்யர்த்தம்"
    )
    val MregexReplace21c = """(motherMother)""".toRegex()
    val MBody41BBc = SpannableString(MBody41BBBc.replace(MregexReplace21c, amAmmaName))
    val MregexReplace22c = """(motherGrandMother)""".toRegex()
    val MBody41BAc = SpannableString(MBody41BBc.replace(MregexReplace22c, amPattiName))
    val MregexReplace22Ac = """(motherGreatGrandMother)""".toRegex()
    val MBody41BABc = SpannableString(MBody41BAc.replace(MregexReplace22Ac, amKolluPattiName))
    val MregexReplace22ABc = """(Thithi)""".toRegex()
    mMBody41Bc = SpannableString(MBody41BABc.replace(MregexReplace22ABc, todThithi))
    mMBody41Bc.setSpan(AbsoluteSizeSpan(14, true), start, mMBody41Bc.length, exExFlag)
    mMBody41Bc.setSpan(StyleSpan(Typeface.BOLD), start, mMBody41Bc.length, exExFlag)
    mMBody41Bc.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mMBody41Bc.length, exExFlag)

    mBody42Z = SpannableString(
        "\n\n  உபயவம்சே பவானாம் பித்ருவ்ய மாதுலாதி ஞாத அக்ஞாதானாம் தத்தத் கோத்ராணாம் " +
                "தத்தத் சர்மணாம் வசு வசுரூபானாம் ஸர்வேஷாம் காருண்ய பித்ரூனாம் ச அக்ஷ்ய த்ருப்த்யர்த்தம் கன்யா கதே ஸவிதரி ஆஷாட்யாதி " +
                "பஞ்சமாபர பக்ஷ மஹாளய புண்யகாலே"
    )
    mBody42Z.setSpan(AbsoluteSizeSpan(14, true), start, mBody42Z.length, exExFlag)
    mBody42Z.setSpan(StyleSpan(Typeface.BOLD), start, mBody42Z.length, exExFlag)
    mBody42Z.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody42Z.length, exExFlag)

    mBody42ZA = SpannableString(" பக்க்ஷிய மஹாளயச்ரார்த்தம் திலதர்ப்பண ரூபேண அத்ய கரிஷ்யே")
    mBody42ZA.setSpan(AbsoluteSizeSpan(14, true), start, mBody42ZA.length, exExFlag)
    mBody42ZA.setSpan(StyleSpan(Typeface.BOLD), start, mBody42ZA.length, exExFlag)
    mBody42ZA.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody42ZA.length, exExFlag)

    mBody42ZB = SpannableString("ஸக்ருத் மஹாளயச்ரார்த்தம் திலதர்ப்பண ரூபேண அத்ய கரிஷ்யே")
    mBody42ZB.setSpan(AbsoluteSizeSpan(14, true), start, mBody42ZB.length, exExFlag)
    mBody42ZB.setSpan(StyleSpan(Typeface.BOLD), start, mBody42ZB.length, exExFlag)
    mBody42ZB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody42ZB.length, exExFlag)

    mComment39 = SpannableString("\n- கையில் உள்ள தர்பங்களை போட்டுவிட்டு கிழக்கு முகமாக திரும்பி பூணல் ")
    mComment39.setSpan(AbsoluteSizeSpan(13, true), start, mComment39.length, exExFlag)
    mComment39.setSpan(StyleSpan(Typeface.ITALIC), start, mComment39.length, exExFlag)
    mComment39.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment39.length, exExFlag)

    mGreenComment1 = SpannableString(" ஸவ்யம் ")
    mGreenComment1.setSpan(AbsoluteSizeSpan(13, true), start, mGreenComment1.length, exExFlag)
    mGreenComment1.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, mGreenComment1.length, exExFlag)
    mGreenComment1.setSpan(ForegroundColorSpan(Color.GREEN), start, mGreenComment1.length, exExFlag)

    mComment40 = SpannableString(
        " செய்து கொண்டு கையை ஜலத்தால் அலம்பவும். \nதனக்கு எதிரில் ஒரு தாம்பாளத்தில் " +
                "கொஞ்சம் கட்டை தர்பங்களை கிழக்கு மேற்காக பரப்பி \nஅதன்மேல் தெற்கு நுனியாக"
    )
    mComment40.setSpan(AbsoluteSizeSpan(13, true), start, mComment40.length, exExFlag)
    mComment40.setSpan(StyleSpan(Typeface.ITALIC), start, mComment40.length, exExFlag)
    mComment40.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment40.length, exExFlag)

    mComment40Two = SpannableString(" இரண்டு")
    mComment40Two.setSpan(AbsoluteSizeSpan(13, true), start, mComment40Two.length, exExFlag)
    mComment40Two.setSpan(StyleSpan(Typeface.ITALIC), start, mComment40Two.length, exExFlag)
    mComment40Two.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment40Two.length, exExFlag)

    mComment40Three = SpannableString(" மூன்று")
    mComment40Three.setSpan(AbsoluteSizeSpan(13, true), start, mComment40Three.length, exExFlag)
    mComment40Three.setSpan(StyleSpan(Typeface.ITALIC), start, mComment40Three.length, exExFlag)
    mComment40Three.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment40Three.length, exExFlag)

    mComment41 = SpannableString(" கூர்ச்சங்களை வைத்து \nஅதன் மேல் கட்டை தர்பங்கள் கொஞ்சம் போட்டு பூணூலை ")
    mComment41.setSpan(AbsoluteSizeSpan(13, true), start, mComment41.length, exExFlag)
    mComment41.setSpan(StyleSpan(Typeface.ITALIC), start, mComment41.length, exExFlag)
    mComment41.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment41.length, exExFlag)

    mRedComment2 = SpannableString(" அபஸவ்யம் ")
    mRedComment2.setSpan(AbsoluteSizeSpan(13, true), start, mRedComment2.length, exExFlag)
    mRedComment2.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, mRedComment2.length, exExFlag)
    mRedComment2.setSpan(ForegroundColorSpan(Color.RED), start, mRedComment2.length, exExFlag)

    mComment41A = SpannableString(" செய்து கொண்டு \nஎள்ளை")
    mComment41A.setSpan(AbsoluteSizeSpan(13, true), start, mComment41A.length, exExFlag)
    mComment41A.setSpan(StyleSpan(Typeface.ITALIC), start, mComment41A.length, exExFlag)
    mComment41A.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment41A.length, exExFlag)

    mComment41C = SpannableString("செய்து கொண்டு \nஎள்ளும், சிறிது அரிசியையும்")
    mComment41C.setSpan(AbsoluteSizeSpan(13, true), start, mComment41C.length, exExFlag)
    mComment41C.setSpan(StyleSpan(Typeface.ITALIC), start, mComment41C.length, exExFlag)
    mComment41C.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment41C.length, exExFlag)

    mComment41D = SpannableString(" எடுத்துக் கொண்டு \nஆவாஹநாதி தர்ப்பணம் செய்யவும்\n")
    mComment41D.setSpan(AbsoluteSizeSpan(13, true), start, mComment41D.length, exExFlag)
    mComment41D.setSpan(StyleSpan(Typeface.ITALIC), start, mComment41D.length, exExFlag)
    mComment41D.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment41D.length, exExFlag)

    mHeading3 = SpannableString("ஆவாஹனம்-ஆஸனம்\n")
    mHeading3.setSpan(AbsoluteSizeSpan(16, true), start, mHeading3.length, exExFlag)
    mHeading3.setSpan(StyleSpan(Typeface.BOLD), start, mHeading3.length, exExFlag)
    mHeading3.setSpan(UnderlineSpan(), start, mHeading3.length, exExFlag)
    mHeading3.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, mHeading3.length, exExFlag)

    mComment42 = SpannableString("பூணல் - ")
    mComment42.setSpan(AbsoluteSizeSpan(13, true), start, mComment42.length, exExFlag)
    mComment42.setSpan(StyleSpan(Typeface.ITALIC), start, mComment42.length, exExFlag)
    mComment42.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment42.length, exExFlag)

    mRedComment3 = SpannableString("அபஸவ்யம் ")
    mRedComment3.setSpan(AbsoluteSizeSpan(13, true), start, mRedComment3.length, exExFlag)
    mRedComment3.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, mRedComment3.length, exExFlag)
    mRedComment3.setSpan(ForegroundColorSpan(Color.RED), start, mRedComment3.length, exExFlag)

    mComment42A = SpannableString("\nமந்திரம்: மேலண்டைகூர்ச்சம் : பிதாவர்கம்")
    mComment42A.setSpan(AbsoluteSizeSpan(13, true), start, mComment42A.length, exExFlag)
    mComment42A.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, mComment42A.length, exExFlag)
    mComment42A.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, mComment42A.length, exExFlag)

    val Body46A = SpannableString(
        "\nஓம் உசந்தஸ்த்வா நிதீமஹி உசந்த: ஸமீதீமஹி உசந்நு உசத: ஆவஹ பித்ருன் ஹவிஷே " +
                "அத்தவே yourGothram கோத்ரான் அஸ்மத் பித்ரு "
    )
    val regexReplace24 = """(yourGothram)""".toRegex()
    mBody46 = SpannableString(Body46A.replace(regexReplace24, urGothram))
    mBody46.setSpan(AbsoluteSizeSpan(14, true), start, mBody46.length, exExFlag)
    mBody46.setSpan(StyleSpan(Typeface.BOLD), start, mBody46.length, exExFlag)
    mBody46.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody46.length, exExFlag)

    mBody48A = SpannableString("ப்ரபிதாமஹ வ்ருத்தப்ரபிதாமஹாநாம் ")
    mBody48A.setSpan(AbsoluteSizeSpan(14, true), start, mBody48A.length, exExFlag)
    mBody48A.setSpan(StyleSpan(Typeface.BOLD), start, mBody48A.length, exExFlag)
    mBody48A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody48A.length, exExFlag)

    mBody48B = SpannableString("பிதாமஹ ப்ரபிதாமஹாநாம் ")
    mBody48B.setSpan(AbsoluteSizeSpan(14, true), start, mBody48B.length, exExFlag)
    mBody48B.setSpan(StyleSpan(Typeface.BOLD), start, mBody48B.length, exExFlag)
    mBody48B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody48B.length, exExFlag)

    val Body49A = SpannableString("yourFatherName, ")
    val regexReplace25 = """(yourFatherName)""".toRegex()
    mBody49 = SpannableString(Body49A.replace(regexReplace25, yrFNamee))
    mBody49.setSpan(AbsoluteSizeSpan(14, true), start, mBody49.length, exExFlag)
    mBody49.setSpan(StyleSpan(Typeface.BOLD), start, mBody49.length, exExFlag)
    mBody49.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody49.length, exExFlag)

    val Body50AA = SpannableString("yourGrandFatherName, yourGreatGrandFatherName ")
    val regexReplace26 = """(yourGrandFatherName)""".toRegex()
    val Body50A = SpannableString(Body50AA.replace(regexReplace26, yrGFNamee))
    val regexReplace27 = """(yourGreatGrandFatherName)""".toRegex()
    mBody50 = SpannableString(Body50A.replace(regexReplace27, yrGGFNamee))
    mBody50.setSpan(AbsoluteSizeSpan(14, true), start, mBody50.length, exExFlag)
    mBody50.setSpan(StyleSpan(Typeface.BOLD), start, mBody50.length, exExFlag)
    mBody50.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody50.length, exExFlag)

    val Body51BBB = SpannableString("yourGreatGrandFatherName, yourGreatGreatGrandFatherName ")
    val regexReplace28 = """(yourGreatGrandFatherName)""".toRegex()
    val Body51BB = SpannableString(Body51BBB.replace(regexReplace28, yrGGFNamee))
    val regexReplace29 = """(yourGreatGreatGrandFatherName)""".toRegex()
    mBody51B = SpannableString(Body51BB.replace(regexReplace29, yrGGGFNamee))
    mBody51B.setSpan(AbsoluteSizeSpan(14, true), start, mBody51B.length, exExFlag)
    mBody51B.setSpan(StyleSpan(Typeface.BOLD), start, mBody51B.length, exExFlag)
    mBody51B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody51B.length, exExFlag)

    mBody52 = SpannableString("சர்மணாம்  வஸூருத்ர ஆதித்ய ஸ்வரூபான் அஸ்மின்கூர்ச்சே ஆவாஹயாமி\nஅவகீர்யா\n")
    mBody52.setSpan(AbsoluteSizeSpan(14, true), start, mBody52.length, exExFlag)
    mBody52.setSpan(StyleSpan(Typeface.BOLD), start, mBody52.length, exExFlag)
    mBody52.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody52.length, exExFlag)

    mComment43 = SpannableString("- என்று எள்ளை")
    mComment43.setSpan(AbsoluteSizeSpan(13, true), start, mComment43.length, exExFlag)
    mComment43.setSpan(StyleSpan(Typeface.ITALIC), start, mComment43.length, exExFlag)
    mComment43.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment43.length, exExFlag)

    mComment43A = SpannableString("- என்று எள்ளை")
    mComment43A.setSpan(AbsoluteSizeSpan(13, true), start, mComment43A.length, exExFlag)
    mComment43A.setSpan(StyleSpan(Typeface.ITALIC), start, mComment43A.length, exExFlag)
    mComment43A.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment43A.length, exExFlag)

    mComment44 = SpannableString("- என்று எள்ளும், சிறிது அரிசியையும்")
    mComment44.setSpan(AbsoluteSizeSpan(13, true), start, mComment44.length, exExFlag)
    mComment44.setSpan(StyleSpan(Typeface.ITALIC), start, mComment44.length, exExFlag)
    mComment44.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment44.length, exExFlag)

    mComment44A = SpannableString(" - என்று எள்ளும், சிறிது அரிசியையும்")
    mComment44A.setSpan(AbsoluteSizeSpan(13, true), start, mComment44A.length, exExFlag)
    mComment44A.setSpan(StyleSpan(Typeface.ITALIC), start, mComment44A.length, exExFlag)
    mComment44A.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment44A.length, exExFlag)

    mComment45 = SpannableString(" போடவும்")
    mComment45.setSpan(AbsoluteSizeSpan(13, true), start, mComment45.length, exExFlag)
    mComment45.setSpan(StyleSpan(Typeface.ITALIC), start, mComment45.length, exExFlag)
    mComment45.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment45.length, exExFlag)

    mComment45A = SpannableString(" போடவும்")
    mComment45A.setSpan(AbsoluteSizeSpan(13, true), start, mComment45A.length, exExFlag)
    mComment45A.setSpan(StyleSpan(Typeface.ITALIC), start, mComment45A.length, exExFlag)
    mComment45A.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment45A.length, exExFlag)

    mHeading4 = SpannableString("\nஆஸனமந்திரம்\n")
    mHeading4.setSpan(AbsoluteSizeSpan(16, true), start, mHeading4.length, exExFlag)
    mHeading4.setSpan(StyleSpan(Typeface.BOLD), start, mHeading4.length, exExFlag)
    mHeading4.setSpan(UnderlineSpan(), start, mHeading4.length, exExFlag)
    mHeading4.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, mHeading4.length, exExFlag)

    mComment46 = SpannableString("மூன்று கட்டை தர்பங்களை எடுத்துக்கொண்டு")
    mComment46.setSpan(AbsoluteSizeSpan(13, true), start, mComment46.length, exExFlag)
    mComment46.setSpan(StyleSpan(Typeface.ITALIC), start, mComment46.length, exExFlag)
    mComment46.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment46.length, exExFlag)

    mComment46A = SpannableString("மூன்று கட்டை தர்பங்களை எடுத்துக்கொண்டு")
    mComment46A.setSpan(AbsoluteSizeSpan(13, true), start, mComment46A.length, exExFlag)
    mComment46A.setSpan(StyleSpan(Typeface.ITALIC), start, mComment46A.length, exExFlag)
    mComment46A.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment46A.length, exExFlag)

    val Body53A = SpannableString(
        "\nஓம் ஆயந்துந: பிதர: ஸோம்யாஸ: அக்னிஷ்வாத்தா: பதிபி: தேவயாநை: " +
                "\nஅஸ்மின்யக்ஞே ஸ்வதயாமதந்த: அதிப்ருவந்து தேவந்து அஸ்மான் yourGothram கோத்ராணாம் அஸ்மத் பித்ரு"
    )
    val regexReplace30 = """(yourGothram)""".toRegex()
    mBody53 = SpannableString(Body53A.replace(regexReplace30, urGothram))
    mBody53.setSpan(AbsoluteSizeSpan(14, true), start, mBody53.length, exExFlag)
    mBody53.setSpan(StyleSpan(Typeface.BOLD), start, mBody53.length, exExFlag)
    mBody53.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody53.length, exExFlag)

    mBody56 = SpannableString("பிதாமஹ ப்ரபிதாமஹாநாம் ")
    mBody56.setSpan(AbsoluteSizeSpan(14, true), start, mBody56.length, exExFlag)
    mBody56.setSpan(StyleSpan(Typeface.BOLD), start, mBody56.length, exExFlag)
    mBody56.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody56.length, exExFlag)

    mBody55 = SpannableString("ப்ரபிதாமஹ வ்ருத்தப்ரபிதாமஹாநாம் ")
    mBody55.setSpan(AbsoluteSizeSpan(14, true), start, mBody55.length, exExFlag)
    mBody55.setSpan(StyleSpan(Typeface.BOLD), start, mBody55.length, exExFlag)
    mBody55.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody55.length, exExFlag)

    val Body57A = SpannableString("yourFatherName, ")
    val regexReplace31 = """(yourFatherName)""".toRegex()
    mBody57 = SpannableString(Body57A.replace(regexReplace31, yrFNamee))
    mBody57.setSpan(AbsoluteSizeSpan(14, true), start, mBody57.length, exExFlag)
    mBody57.setSpan(StyleSpan(Typeface.BOLD), start, mBody57.length, exExFlag)
    mBody57.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody57.length, exExFlag)

    val Body58AA = SpannableString("yourGrandFatherName, yourGreatGrandFatherName ")
    val regexReplace32 = """(yourGrandFatherName)""".toRegex()
    val Body58A = SpannableString(Body58AA.replace(regexReplace32, yrGFNamee))
    val regexReplace33 = """(yourGreatGrandFatherName)""".toRegex()
    mBody58 = SpannableString(Body58A.replace(regexReplace33, yrGGFNamee))
    mBody58.setSpan(AbsoluteSizeSpan(14, true), start, mBody58.length, exExFlag)
    mBody58.setSpan(StyleSpan(Typeface.BOLD), start, mBody58.length, exExFlag)
    mBody58.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody58.length, exExFlag)

    val Body59BBB = SpannableString("yourGreatGrandFatherName, yourGreatGreatGrandFatherName ")
    val regexReplace34 = """(yourGreatGrandFatherName)""".toRegex()
    val Body59BB = SpannableString(Body59BBB.replace(regexReplace34, yrGGFNamee))
    val regexReplace35 = """(yourGreatGreatGrandFatherName)""".toRegex()
    mBody59B = SpannableString(Body59BB.replace(regexReplace35, yrGGGFNamee))
    mBody59B.setSpan(AbsoluteSizeSpan(14, true), start, mBody59B.length, exExFlag)
    mBody59B.setSpan(StyleSpan(Typeface.BOLD), start, mBody59B.length, exExFlag)
    mBody59B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody59B.length, exExFlag)

    mBody60 = SpannableString("சர்மணாம் வஸூருத்ர ஆதித்ய ஸ்வரூபாணாம் அஸ்மின்கூர்ச்சே இதமாஸனம்")
    mBody60.setSpan(AbsoluteSizeSpan(14, true), start, mBody60.length, exExFlag)
    mBody60.setSpan(StyleSpan(Typeface.BOLD), start, mBody60.length, exExFlag)
    mBody60.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody60.length, exExFlag)

    mComment47 = SpannableString("\n என்று கட்டை தர்பங்களை போடவும்")
    mComment47.setSpan(AbsoluteSizeSpan(13, true), start, mComment47.length, exExFlag)
    mComment47.setSpan(StyleSpan(Typeface.ITALIC), start, mComment47.length, exExFlag)
    mComment47.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment47.length, exExFlag)

    mComment47A = SpannableString("\n என்று கட்டை தர்பங்களை போடவும்")
    mComment47A.setSpan(AbsoluteSizeSpan(13, true), start, mComment47A.length, exExFlag)
    mComment47A.setSpan(StyleSpan(Typeface.ITALIC), start, mComment47A.length, exExFlag)
    mComment47A.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment47A.length, exExFlag)

    mComment47B = SpannableString("\n என்று கட்டை தர்பங்களை போடவும்")
    mComment47B.setSpan(AbsoluteSizeSpan(13, true), start, mComment47B.length, exExFlag)
    mComment47B.setSpan(StyleSpan(Typeface.ITALIC), start, mComment47B.length, exExFlag)
    mComment47B.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment47B.length, exExFlag)

    mBody61 = SpannableString("\nகந்தாதி ஸகலாராதனை: ஸ்வர்ச்சிதம்\n")
    mBody61.setSpan(AbsoluteSizeSpan(14, true), start, mBody61.length, exExFlag)
    mBody61.setSpan(StyleSpan(Typeface.BOLD), start, mBody61.length, exExFlag)
    mBody61.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody61.length, exExFlag)

    mComment48 = SpannableString("\n என்று எள்ளை")
    mComment48.setSpan(AbsoluteSizeSpan(13, true), start, mComment48.length, exExFlag)
    mComment48.setSpan(StyleSpan(Typeface.ITALIC), start, mComment48.length, exExFlag)
    mComment48.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment48.length, exExFlag)

    mComment48A = SpannableString("\n என்று எள்ளை")
    mComment48A.setSpan(AbsoluteSizeSpan(13, true), start, mComment48A.length, exExFlag)
    mComment48A.setSpan(StyleSpan(Typeface.ITALIC), start, mComment48A.length, exExFlag)
    mComment48A.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment48A.length, exExFlag)

    mComment48B = SpannableString("\n என்று எள்ளை")
    mComment48B.setSpan(AbsoluteSizeSpan(13, true), start, mComment48B.length, exExFlag)
    mComment48B.setSpan(StyleSpan(Typeface.ITALIC), start, mComment48B.length, exExFlag)
    mComment48B.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment48B.length, exExFlag)

    mComment48C = SpannableString("\n என்று எள்ளை")
    mComment48C.setSpan(AbsoluteSizeSpan(13, true), start, mComment48C.length, exExFlag)
    mComment48C.setSpan(StyleSpan(Typeface.ITALIC), start, mComment48C.length, exExFlag)
    mComment48C.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment48C.length, exExFlag)

    mComment48E = SpannableString("\n என்று எள்ளை")
    mComment48E.setSpan(AbsoluteSizeSpan(13, true), start, mComment48E.length, exExFlag)
    mComment48E.setSpan(StyleSpan(Typeface.ITALIC), start, mComment48E.length, exExFlag)
    mComment48E.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment48E.length, exExFlag)

    mComment49 = SpannableString("\n என்று எள்ளும், சிறிது அரிசியையும்")
    mComment49.setSpan(AbsoluteSizeSpan(13, true), start, mComment49.length, exExFlag)
    mComment49.setSpan(StyleSpan(Typeface.ITALIC), start, mComment49.length, exExFlag)
    mComment49.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment49.length, exExFlag)

    mComment49A = SpannableString("\n என்று எள்ளும், சிறிது அரிசியையும்")
    mComment49A.setSpan(AbsoluteSizeSpan(13, true), start, mComment49A.length, exExFlag)
    mComment49A.setSpan(StyleSpan(Typeface.ITALIC), start, mComment49A.length, exExFlag)
    mComment49A.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment49A.length, exExFlag)

    mComment49B = SpannableString("\n என்று எள்ளும், சிறிது அரிசியையும்")
    mComment49B.setSpan(AbsoluteSizeSpan(13, true), start, mComment49B.length, exExFlag)
    mComment49B.setSpan(StyleSpan(Typeface.ITALIC), start, mComment49B.length, exExFlag)
    mComment49B.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment49B.length, exExFlag)

    mComment49C = SpannableString("\n என்று எள்ளும், சிறிது அரிசியையும்")
    mComment49C.setSpan(AbsoluteSizeSpan(13, true), start, mComment49C.length, exExFlag)
    mComment49C.setSpan(StyleSpan(Typeface.ITALIC), start, mComment49C.length, exExFlag)
    mComment49C.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment49C.length, exExFlag)

    mComment49D = SpannableString("\n என்று கூறும்போது எள்ளும், சிறிது அரிசியையும்")
    mComment49D.setSpan(AbsoluteSizeSpan(13, true), start, mComment49D.length, exExFlag)
    mComment49D.setSpan(StyleSpan(Typeface.ITALIC), start, mComment49D.length, exExFlag)
    mComment49D.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment49D.length, exExFlag)

    mComment49E = SpannableString("\n என்று எள்ளும், சிறிது அரிசியையும்")
    mComment49E.setSpan(AbsoluteSizeSpan(13, true), start, mComment49E.length, exExFlag)
    mComment49E.setSpan(StyleSpan(Typeface.ITALIC), start, mComment49E.length, exExFlag)
    mComment49E.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment49E.length, exExFlag)

    mComment50 = SpannableString(" போடவும் ")
    mComment50.setSpan(AbsoluteSizeSpan(13, true), start, mComment50.length, exExFlag)
    mComment50.setSpan(StyleSpan(Typeface.ITALIC), start, mComment50.length, exExFlag)
    mComment50.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment50.length, exExFlag)

    mComment50A = SpannableString(" போடவும் ")
    mComment50A.setSpan(AbsoluteSizeSpan(13, true), start, mComment50A.length, exExFlag)
    mComment50A.setSpan(StyleSpan(Typeface.ITALIC), start, mComment50A.length, exExFlag)
    mComment50A.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment50A.length, exExFlag)

    mComment50B = SpannableString(" போடவும் ")
    mComment50B.setSpan(AbsoluteSizeSpan(13, true), start, mComment50B.length, exExFlag)
    mComment50B.setSpan(StyleSpan(Typeface.ITALIC), start, mComment50B.length, exExFlag)
    mComment50B.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment50B.length, exExFlag)

    mComment50C = SpannableString(" போடவும் ")
    mComment50C.setSpan(AbsoluteSizeSpan(13, true), start, mComment50C.length, exExFlag)
    mComment50C.setSpan(StyleSpan(Typeface.ITALIC), start, mComment50C.length, exExFlag)
    mComment50C.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment50C.length, exExFlag)

    mComment50D = SpannableString(" போடவும்)")
    mComment50D.setSpan(AbsoluteSizeSpan(13, true), start, mComment50D.length, exExFlag)
    mComment50D.setSpan(StyleSpan(Typeface.ITALIC), start, mComment50D.length, exExFlag)
    mComment50D.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment50D.length, exExFlag)

    mComment50E = SpannableString(" போடவும்)")
    mComment50E.setSpan(AbsoluteSizeSpan(13, true), start, mComment50E.length, exExFlag)
    mComment50E.setSpan(StyleSpan(Typeface.ITALIC), start, mComment50E.length, exExFlag)
    mComment50E.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment50E.length, exExFlag)

    mComment42Middle = SpannableString("\n(மந்திரம்: நடுகூர்ச்சம்-மாதாமஹவர்கம்)\n   ஆவாஹன மந்திரம்")
    mComment42Middle.setSpan(AbsoluteSizeSpan(13, true), start, mComment42Middle.length, exExFlag)
    mComment42Middle.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, mComment42Middle.length, exExFlag)
    mComment42Middle.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, mComment42Middle.length, exExFlag)

    val MBody46A = SpannableString(
        "\nஓம் உசந்தஸ்த்வா நிதீமஹி உசந்த: ஸமீதீமஹி உசந்நு உசத: ஆவஹ பித்ருன்னு ஹவிஷே " +
                "அத்தவே motherSideGothram கோத்ரான் அஸ்மத்"
    )
    val MregexReplace24 = """(motherSideGothram)""".toRegex()
    mMBody46 = SpannableString(MBody46A.replace(MregexReplace24, MGothram))
    mMBody46.setSpan(AbsoluteSizeSpan(14, true), start, mMBody46.length, exExFlag)
    mMBody46.setSpan(StyleSpan(Typeface.BOLD), start, mMBody46.length, exExFlag)
    mMBody46.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mMBody46.length, exExFlag)

    val MBody51BBBB = SpannableString(
        "மாதாமஹ ப்ரமாதாமஹ வ்ருத்த ப்ரமாதாமஹான் motherFather, motherGrandFather, " +
                "motherGreatGrandFather சர்மணாம் வஸூருத்ர ஆதித்ய ஸ்வரூபான் அஸ்மின்கூர்ச்சே ஆவாஹயாமி அவகீர்யா"
    )
    val MregexReplace28 = """(motherFather)""".toRegex()
    val MBody51BBB = SpannableString(MBody51BBBB.replace(MregexReplace28, MFNamee))
    val MregexReplace29 = """(motherGrandFather)""".toRegex()
    val MBody51BB = SpannableString(MBody51BBB.replace(MregexReplace29, MGFNamee))
    val MregexReplace29A = """(motherGreatGrandFather)""".toRegex()
    mMBody51B = SpannableString(MBody51BB.replace(MregexReplace29A, MGGFNamee))
    mMBody51B.setSpan(AbsoluteSizeSpan(14, true), start, mMBody51B.length, exExFlag)
    mMBody51B.setSpan(StyleSpan(Typeface.BOLD), start, mMBody51B.length, exExFlag)
    mMBody51B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mMBody51B.length, exExFlag)

    mMHeading4 = SpannableString("\nஆஸனமந்திரம்\n")
    mMHeading4.setSpan(AbsoluteSizeSpan(16, true), start, mMHeading4.length, exExFlag)
    mMHeading4.setSpan(StyleSpan(Typeface.BOLD), start, mMHeading4.length, exExFlag)
    mMHeading4.setSpan(UnderlineSpan(), start, mMHeading4.length, exExFlag)
    mMHeading4.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, mMHeading4.length, exExFlag)

    mMComment46 = SpannableString("மூன்று கட்டை தர்பங்களை எடுத்துக்கொண்டு")
    mMComment46.setSpan(AbsoluteSizeSpan(13, true), start, mMComment46.length, exExFlag)
    mMComment46.setSpan(StyleSpan(Typeface.ITALIC), start, mMComment46.length, exExFlag)
    mMComment46.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mMComment46.length, exExFlag)

    val MBody53A = SpannableString(
        "\nஓம் ஆயந்துந: பிதர: ஸோம்யாஸ: அக்னிஷ்வாத்தா: பதிபி: தேவயாநை: " +
                "\nஅஸ்மின்யக்ஞே ஸ்வதயாமதந்த: அதிப்ருவந்து தேவந்து அஸ்மான் motherSideGothram கோத்ராணாம் அஸ்மத்"
    )
    val MregexReplace30 = """(motherSideGothram)""".toRegex()
    mMBody53 = SpannableString(MBody53A.replace(MregexReplace30, MGothram))
    mMBody53.setSpan(AbsoluteSizeSpan(14, true), start, mMBody53.length, exExFlag)
    mMBody53.setSpan(StyleSpan(Typeface.BOLD), start, mMBody53.length, exExFlag)
    mMBody53.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mMBody53.length, exExFlag)

    val MBody51CCCC1 = SpannableString(
        "மாதாமஹ ப்ரமாதாமஹ வ்ருத்த ப்ரமாதாமஹாணாம் motherFather , motherGrandFather ," +
                " motherGreatGrandFather சர்மணாம் வஸூருத்ர ஆதித்ய ஸ்வரூபாணாம் அஸ்மின்கூர்ச்சே இதமாஸனம்"
    )
    val MCregexReplace281 = """(motherFather)""".toRegex()
    val MBody51CCC1 = SpannableString(MBody51CCCC1.replace(MCregexReplace281, MFNamee))
    val MCregexReplace291 = """(motherGrandFather)""".toRegex()
    val MBody51CC1 = SpannableString(MBody51CCC1.replace(MCregexReplace291, MGFNamee))
    val MCregexReplace29A1 = """(motherGreatGrandFather)""".toRegex()
    mMBody51C1 = SpannableString(MBody51CC1.replace(MCregexReplace29A1, MGGFNamee))
    mMBody51C1.setSpan(AbsoluteSizeSpan(14, true), start, mMBody51C1.length, exExFlag)
    mMBody51C1.setSpan(StyleSpan(Typeface.BOLD), start, mMBody51C1.length, exExFlag)
    mMBody51C1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mMBody51C1.length, exExFlag)

    mMBody61 = SpannableString("\nகந்தாதி ஸகலாராதனை: ஸ்வர்ச்சிதம்")
    mMBody61.setSpan(AbsoluteSizeSpan(14, true), start, mMBody61.length, exExFlag)
    mMBody61.setSpan(StyleSpan(Typeface.BOLD), start, mMBody61.length, exExFlag)
    mMBody61.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mMBody61.length, exExFlag)

    mComment42AP = SpannableString("\nமந்திரம்: கீழ்கூர்ச்சம்-பித்ருவர்கம்\n   ஆவாஹன மந்திரம்")
    mComment42AP.setSpan(AbsoluteSizeSpan(16, true), start, mComment42AP.length, exExFlag)
    mComment42AP.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, mComment42AP.length, exExFlag)
    mComment42AP.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, mComment42AP.length, exExFlag)

    mBody46P = SpannableString(
        "\nஓம் உசந்தஸ்த்வா நிதீமஹி உசந்த: ஸமீதீமஹி உசந்நு உசத: ஆவஹ பித்ருன்னு ஹவிஷே அத்தவே " +
                "உபயவம்சே பவானு பித்ருவ்ய மாதுளாஹி ஞாத அக்ஞாதானு தத்தத் கோத்ராணு தத்தது சர்மணாம் வசுவசுரூபானு சர்வாணு காருண்ய " +
                "பிந்ருதுனு அஸ்வின் கூர்ச்சே ஆவாஹயாமி \nஅவகீர்யா"
    )
    mBody46P.setSpan(AbsoluteSizeSpan(14, true), start, mBody46P.length, exExFlag)
    mBody46P.setSpan(StyleSpan(Typeface.BOLD), start, mBody46P.length, exExFlag)
    mBody46P.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody46P.length, exExFlag)

    mHeading4P = SpannableString("\nஆஸனமந்திரம்\n")
    mHeading4P.setSpan(AbsoluteSizeSpan(16, true), start, mHeading4P.length, exExFlag)
    mHeading4P.setSpan(StyleSpan(Typeface.BOLD), start, mHeading4P.length, exExFlag)
    mHeading4P.setSpan(UnderlineSpan(), start, mHeading4P.length, exExFlag)
    mHeading4P.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, mHeading4P.length, exExFlag)

    mBody46PAS = SpannableString(
        "\n   ஓம் ஆயந்துந: பிதர: ஸோம்யாஸ: அக்னிஷ்வாத்தா: பதிபி: தேவயானை: அஸ்மின்யக்ஞே " +
                "ஸ்வதயாமதந்த: அதிப்ருவந்து தேவந்து அஸ்மான் உபயவம்சே பவானாம் பிருத்வ்ய மாதுளாஹி ஞாத அக்ஞாதானாம் தத்தத் கோத்ராணாம் " +
                "தத்தத் சர்மணாம் வசு வசுரூபானாம் சர்வேஷாம் காருண்ய பித்ருனாம் அஸ்வின் கூர்சே இதமாசனம்"
    )
    mBody46PAS.setSpan(AbsoluteSizeSpan(14, true), start, mBody46PAS.length, exExFlag)
    mBody46PAS.setSpan(StyleSpan(Typeface.BOLD), start, mBody46PAS.length, exExFlag)
    mBody46PAS.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody46PAS.length, exExFlag)

    mBody61P = SpannableString("\nகந்தாதி ஸகலாராதனை: ஸ்வர்ச்சிதம்")
    mBody61P.setSpan(AbsoluteSizeSpan(14, true), start, mBody61P.length, exExFlag)
    mBody61P.setSpan(StyleSpan(Typeface.BOLD), start, mBody61P.length, exExFlag)
    mBody61P.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody61P.length, exExFlag)

    mComment42AP1 = SpannableString("\n\n கீழ்வரும் மந்திரங்களை கூறி")
    mComment42AP1.setSpan(AbsoluteSizeSpan(13, true), start, mComment42AP1.length, exExFlag)
    mComment42AP1.setSpan(StyleSpan(Typeface.ITALIC), start, mComment42AP1.length, exExFlag)
    mComment42AP1.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment42AP1.length, exExFlag)

    mHeading4P1 = SpannableString(" த்ருப்யதாம் / த்ருப்யத்வம் ")
    mHeading4P1.setSpan(AbsoluteSizeSpan(13, true), start, mHeading4P1.length, exExFlag)
    mHeading4P1.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, mHeading4P1.length, exExFlag)
    mHeading4P1.setSpan(ForegroundColorSpan(Color.BLACK), start, mHeading4P1.length, exExFlag)

    mComment42AP2A = SpannableString("என்று கூறும்போது எள்ளை")
    mComment42AP2A.setSpan(AbsoluteSizeSpan(13, true), start, mComment42AP2A.length, exExFlag)
    mComment42AP2A.setSpan(StyleSpan(Typeface.ITALIC), start, mComment42AP2A.length, exExFlag)
    mComment42AP2A.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment42AP2A.length, exExFlag)

    mComment42AP2B =
        SpannableString(" கையில் வைத்துக்கொண்டு சிறிது சிறிதாக ஜலமுடன் கட்டை விரல் வழியாக கூர்ச்சத்தின் மேல் விடவும்")
    mComment42AP2B.setSpan(AbsoluteSizeSpan(13, true), start, mComment42AP2B.length, exExFlag)
    mComment42AP2B.setSpan(StyleSpan(Typeface.ITALIC), start, mComment42AP2B.length, exExFlag)
    mComment42AP2B.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment42AP2B.length, exExFlag)

    mHeading5 = SpannableString("\n\nபிதாவர்க்கம் (மேல்கூர்ச்சம்)")
    mHeading5.setSpan(AbsoluteSizeSpan(16, true), start, mHeading5.length, exExFlag)
    mHeading5.setSpan(StyleSpan(Typeface.BOLD), start, mHeading5.length, exExFlag)
    mHeading5.setSpan(UnderlineSpan(), start, mHeading5.length, exExFlag)
    mHeading5.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, mHeading5.length, exExFlag)

    val Body62A = SpannableString(
        "\n1.a.   ஓம் உதீரதாம் அவரே உத்பராஸ: உந்மத்யமா: பிதர: ஸோம்யாஸ: அஸூம்யஈயு: " +
                "அவ்ருகா: ருதக்ஞா: தேநோவந்து பிதரோஹவேஷூ yourGothram கோத்ர: அஸ்மத் பிதா"
    )
    val regexReplace36 = """(yourGothram)""".toRegex()
    mBody62 = SpannableString(Body62A.replace(regexReplace36, urGothram))
    mBody62.setSpan(AbsoluteSizeSpan(14, true), start, mBody62.length, exExFlag)
    mBody62.setSpan(StyleSpan(Typeface.BOLD), start, mBody62.length, exExFlag)
    mBody62.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody62.length, exExFlag)

    val Body64AA = SpannableString(
        " yourFatherName சர்மா வஸூரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\n1.b. ஓம் அங்கீரஸோந: பிதரோ நவக்வா: அதர்வாண: ப்ருகவ: ஸோம்யாஸ: தேஷாம்வயம் ஸூமதௌ யக்ஞியாநாம் அபிபத்ரே " +
                "ஸௌமனஸே ஸ்யாம yourGothram கோத்ர: அஸ்மத் பிதா"
    )
    val regexReplace37 = """(yourFatherName)""".toRegex()
    val Body64A = SpannableString(Body64AA.replace(regexReplace37, yrFNamee))
    val regexReplace38 = """(yourGothram)""".toRegex()
    mBody64 = SpannableString(Body64A.replace(regexReplace38, urGothram))
    mBody64.setSpan(AbsoluteSizeSpan(14, true), start, mBody64.length, exExFlag)
    mBody64.setSpan(StyleSpan(Typeface.BOLD), start, mBody64.length, exExFlag)
    mBody64.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody64.length, exExFlag)

    val Body66AA = SpannableString(
        " yourFatherName சர்மா வஸூரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\n1.c.   ஓம் ஆயந்துந: பிதர: ஸோம்யாஸ: அக்னிஷ்வாத்தா: பதிபி: தேவயானை: அஸ்மின் யக்ஞே ஸ்வதயா மதந்த: அதிப்ருவந்து " +
                "தேவந்து அஸ்மான் yourGothram கோத்ர: அஸ்மத் பிதா"
    )
    val regexReplace39 = """(yourFatherName)""".toRegex()
    val Body66A = SpannableString(Body66AA.replace(regexReplace39, yrFNamee))
    val regexReplace40 = """(yourGothram)""".toRegex()
    mBody66 = SpannableString(Body66A.replace(regexReplace40, urGothram))
    mBody66.setSpan(AbsoluteSizeSpan(14, true), start, mBody66.length, exExFlag)
    mBody66.setSpan(StyleSpan(Typeface.BOLD), start, mBody66.length, exExFlag)
    mBody66.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody66.length, exExFlag)

    val Body68A = SpannableString(" yourFatherName சர்மா வஸூரூப: ஸ்வதாநம: த்ருப்யதாம்.\n")
    val regexReplace41 = """(yourFatherName)""".toRegex()
    mBody68 = SpannableString(Body68A.replace(regexReplace41, yrFNamee))
    mBody68.setSpan(AbsoluteSizeSpan(14, true), start, mBody68.length, exExFlag)
    mBody68.setSpan(StyleSpan(Typeface.BOLD), start, mBody68.length, exExFlag)
    mBody68.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody68.length, exExFlag)

    val Body69A = SpannableString(
        "\n2.a.    ஓம் ஊர்ஜம் வஹந்தி: அம்ருதம்க்ருதம் பய:கீலாலம் பரிஸ்ருதம் ஸ்வதாஸ்த " +
                "தர்பயதமே பித்ருன் yourGothram கோத்ர: அஸ்மத்"
    )
    val regexReplace42 = """(yourGothram)""".toRegex()
    mBody69 = SpannableString(Body69A.replace(regexReplace42, urGothram))
    mBody69.setSpan(AbsoluteSizeSpan(14, true), start, mBody69.length, exExFlag)
    mBody69.setSpan(StyleSpan(Typeface.BOLD), start, mBody69.length, exExFlag)
    mBody69.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody69.length, exExFlag)

    mBody70A = SpannableString(" பிதாமஹ: ")
    mBody70A.setSpan(AbsoluteSizeSpan(14, true), start, mBody70A.length, exExFlag)
    mBody70A.setSpan(StyleSpan(Typeface.BOLD), start, mBody70A.length, exExFlag)
    mBody70A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody70A.length, exExFlag)

    mBody70B = SpannableString(" ப்ரபிதாமஹான்னு: ")
    mBody70B.setSpan(AbsoluteSizeSpan(14, true), start, mBody70B.length, exExFlag)
    mBody70B.setSpan(StyleSpan(Typeface.BOLD), start, mBody70B.length, exExFlag)
    mBody70B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody70B.length, exExFlag)

    val Body71AA = SpannableString(
        "yourGrandFatherName சர்மா ருத்ரரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\n2.b.   ஓம் பித்ருப்ய: ஸ்வாதாயிப்ய: ஸ்வாதாநம: பிதாமஹேப்ய: ஸ்வதாயிப்ய: ஸ்வதாநம: ப்ரபிதாமஹேப்ய: ஸ்வதாயிப்ய: " +
                "ஸ்வாதாநம: yourGothram கோத்ர: அஸ்மத்"
    )
    val regexReplace43 = """(yourGrandFatherName)""".toRegex()
    val Body71A = SpannableString(Body71AA.replace(regexReplace43, yrGFNamee))
    val regexReplace44 = """(yourGothram)""".toRegex()
    mBody71 = SpannableString(Body71A.replace(regexReplace44, urGothram))
    mBody71.setSpan(AbsoluteSizeSpan(14, true), start, mBody71.length, exExFlag)
    mBody71.setSpan(StyleSpan(Typeface.BOLD), start, mBody71.length, exExFlag)
    mBody71.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody71.length, exExFlag)

    val Body72AA = SpannableString(
        "yourGreatGrandFatherName சர்மா ருத்ரரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\n2.b.   ஓம் பித்ருப்ய: ஸ்வாதாயிப்ய: ஸ்வாதாநம: பிதாமஹேப்ய: ஸ்வதாயிப்ய: ஸ்வதாநம: ப்ரபிதாமஹேப்ய: ஸ்வதாயிப்ய: " +
                "ஸ்வாதாநம: yourGothram கோத்ர: அஸ்மத்"
    )
    val regexReplace45 = """(yourGreatGrandFatherName)""".toRegex()
    val Body72A = SpannableString(Body72AA.replace(regexReplace45, yrGGFNamee))
    val regexReplace46 = """(yourGothram)""".toRegex()
    mBody72 = SpannableString(Body72A.replace(regexReplace46, urGothram))
    mBody72.setSpan(AbsoluteSizeSpan(14, true), start, mBody72.length, exExFlag)
    mBody72.setSpan(StyleSpan(Typeface.BOLD), start, mBody72.length, exExFlag)
    mBody72.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody72.length, exExFlag)

    mBody73A = SpannableString(" பிதாமஹ: ")
    mBody73A.setSpan(AbsoluteSizeSpan(14, true), start, mBody73A.length, exExFlag)
    mBody73A.setSpan(StyleSpan(Typeface.BOLD), start, mBody73A.length, exExFlag)
    mBody73A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody73A.length, exExFlag)

    mBody73B = SpannableString(" ப்ரபிதாமஹான்னு: ")
    mBody73B.setSpan(AbsoluteSizeSpan(14, true), start, mBody73B.length, exExFlag)
    mBody73B.setSpan(StyleSpan(Typeface.BOLD), start, mBody73B.length, exExFlag)
    mBody73B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody73B.length, exExFlag)

    val Body74AA = SpannableString(
        "yourGrandFatherName சர்மா ருத்ரரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\n2.c.   ஓம் யேசேஹபிதர: யேசநேஹ யாங்குச்ச வித்மயான் ஊசன ப்ரவித்ம த்வம்வேத்த யதிதே ஜாதவேத: ஸ்வதாபி: யக்ஞம் " +
                "ஸூக்ருதம் ஜூஷஸ்வ yourGothram கோத்ர: அஸ்மத்"
    )
    val regexReplace47 = """(yourGrandFatherName)""".toRegex()
    val Body74A = SpannableString(Body74AA.replace(regexReplace47, yrGFNamee))
    val regexReplace48 = """(yourGothram)""".toRegex()
    mBody74 = SpannableString(Body74A.replace(regexReplace48, urGothram))
    mBody74.setSpan(AbsoluteSizeSpan(14, true), start, mBody74.length, exExFlag)
    mBody74.setSpan(StyleSpan(Typeface.BOLD), start, mBody74.length, exExFlag)
    mBody74.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody74.length, exExFlag)

    val Body75AA = SpannableString(
        "yourGreatGrandFatherName சர்மா ருத்ரரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\n2.c.   ஓம் யேசேஹபிதர: யேசநேஹ யாங்குச்ச வித்மயான் ஊசன ப்ரவித்ம த்வம்வேத்த யதிதே ஜாதவேத: ஸ்வதாபி: யக்ஞம் " +
                "ஸூக்ருதம் ஜூஷஸ்வ yourGothram கோத்ர: அஸ்மத்"
    )
    val regexReplace49 = """(yourGreatGrandFatherName)""".toRegex()
    val Body75A = SpannableString(Body75AA.replace(regexReplace49, yrGGFNamee))
    val regexReplace50 = """(yourGothram)""".toRegex()
    mBody75 = SpannableString(Body75A.replace(regexReplace50, urGothram))
    mBody75.setSpan(AbsoluteSizeSpan(14, true), start, mBody75.length, exExFlag)
    mBody75.setSpan(StyleSpan(Typeface.BOLD), start, mBody75.length, exExFlag)
    mBody75.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody75.length, exExFlag)

    mBody76A = SpannableString(" பிதாமஹ: ")
    mBody76A.setSpan(AbsoluteSizeSpan(14, true), start, mBody76A.length, exExFlag)
    mBody76A.setSpan(StyleSpan(Typeface.BOLD), start, mBody76A.length, exExFlag)
    mBody76A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody76A.length, exExFlag)

    mBody76B = SpannableString(" ப்ரபிதாமஹான்னு: ")
    mBody76B.setSpan(AbsoluteSizeSpan(14, true), start, mBody76B.length, exExFlag)
    mBody76B.setSpan(StyleSpan(Typeface.BOLD), start, mBody76B.length, exExFlag)
    mBody76B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody76B.length, exExFlag)

    val Body77AA = SpannableString(
        "yourGrandFatherName சர்மா ருத்ரரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\n3.a.    ஓம் மதுவாதா: ருதாயதே மதுக்ஷரந்தி ஸிந்தவ: மாத்வீர்ந: ஸந்து ஓஷதீ: yourGothram கோத்ர: அஸ்மத்"
    )
    val regexReplace51 = """(yourGrandFatherName)""".toRegex()
    val Body77A = SpannableString(Body77AA.replace(regexReplace51, yrGFNamee))
    val regexReplace52 = """(yourGothram)""".toRegex()
    mBody77 = SpannableString(Body77A.replace(regexReplace52, urGothram))
    mBody77.setSpan(AbsoluteSizeSpan(14, true), start, mBody77.length, exExFlag)
    mBody77.setSpan(StyleSpan(Typeface.BOLD), start, mBody77.length, exExFlag)
    mBody77.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody77.length, exExFlag)

    val Body78AA = SpannableString(
        "yourGreatGrandFatherName சர்மா ஆதித்யரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\n3.a.    ஓம் மதுவாதா: ருதாயதே மதுக்ஷரந்தி ஸிந்தவ: மாத்வீர்ந: ஸந்து ஓஷதீ: yourGothram கோத்ர: அஸ்மத்"
    )
    val regexReplace53 = """(yourGreatGrandFatherName)""".toRegex()
    val Body78A = SpannableString(Body78AA.replace(regexReplace53, yrGGFNamee))
    val regexReplace54 = """(yourGothram)""".toRegex()
    mBody78 = SpannableString(Body78A.replace(regexReplace54, urGothram))
    mBody78.setSpan(AbsoluteSizeSpan(14, true), start, mBody78.length, exExFlag)
    mBody78.setSpan(StyleSpan(Typeface.BOLD), start, mBody78.length, exExFlag)
    mBody78.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody78.length, exExFlag)

    mBody79A = SpannableString(" ப்ரபிதாமஹான்னு: ")
    mBody79A.setSpan(AbsoluteSizeSpan(14, true), start, mBody79A.length, exExFlag)
    mBody79A.setSpan(StyleSpan(Typeface.BOLD), start, mBody79A.length, exExFlag)
    mBody79A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody79A.length, exExFlag)

    mBody79B = SpannableString(" வ்ருத்தப்ரபிதாமஹ: ")
    mBody79B.setSpan(AbsoluteSizeSpan(14, true), start, mBody79B.length, exExFlag)
    mBody79B.setSpan(StyleSpan(Typeface.BOLD), start, mBody79B.length, exExFlag)
    mBody79B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody79B.length, exExFlag)

    val Body80AA = SpannableString(
        "yourGreatGrandFatherName சர்மா ஆதித்யரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\n3.b.  ஓம் மதுநக்தம் உதோஷஸ: மதுமத் பார்த்தீவம் ரஜ: மதுத்யௌ: அஸ்துந: பிதா yourGothram கோத்ர: அஸ்மத்"
    )
    val regexReplace55 = """(yourGreatGrandFatherName)""".toRegex()
    val Body80A = SpannableString(Body80AA.replace(regexReplace55, yrGGFNamee))
    val regexReplace56 = """(yourGothram)""".toRegex()
    mBody80 = SpannableString(Body80A.replace(regexReplace56, urGothram))
    mBody80.setSpan(AbsoluteSizeSpan(14, true), start, mBody80.length, exExFlag)
    mBody80.setSpan(StyleSpan(Typeface.BOLD), start, mBody80.length, exExFlag)
    mBody80.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody80.length, exExFlag)

    val Body81AA = SpannableString(
        "yourGreatGreatGrandFatherName சர்மா ஆதித்யரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\n3.b.  ஓம் மதுநக்தம் உதோஷஸ: மதுமத் பார்த்தீவம் ரஜ: மதுத்யௌ: அஸ்துந: பிதா yourGothram கோத்ர: அஸ்மத்"
    )
    val regexReplace57 = """(yourGreatGreatGrandFatherName)""".toRegex()
    val Body81A = SpannableString(Body81AA.replace(regexReplace57, yrGGGFNamee))
    val regexReplace58 = """(yourGothram)""".toRegex()
    mBody81 = SpannableString(Body81A.replace(regexReplace58, urGothram))
    mBody81.setSpan(AbsoluteSizeSpan(14, true), start, mBody81.length, exExFlag)
    mBody81.setSpan(StyleSpan(Typeface.BOLD), start, mBody81.length, exExFlag)
    mBody81.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody81.length, exExFlag)

    mBody82A = SpannableString(" ப்ரபிதாமஹான்னு: ")
    mBody82A.setSpan(AbsoluteSizeSpan(14, true), start, mBody82A.length, exExFlag)
    mBody82A.setSpan(StyleSpan(Typeface.BOLD), start, mBody82A.length, exExFlag)
    mBody82A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody82A.length, exExFlag)

    mBody82B = SpannableString(" வ்ருத்தப்ரபிதாமஹ: ")
    mBody82B.setSpan(AbsoluteSizeSpan(14, true), start, mBody82B.length, exExFlag)
    mBody82B.setSpan(StyleSpan(Typeface.BOLD), start, mBody82B.length, exExFlag)
    mBody82B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody82B.length, exExFlag)

    val Body83AA = SpannableString(
        "yourGreatGrandFatherName சர்மா ஆதித்யரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\n3.c.  ஓம் மதுமாந்த: வநஸ்பதி: மதுமாந் அஸ்துஸூர்ய: மாத்வீர்காவ: பவந்துந: yourGothram கோத்ர: அஸ்மத்"
    )
    val regexReplace59 = """(yourGreatGrandFatherName)""".toRegex()
    val Body83A = SpannableString(Body83AA.replace(regexReplace59, yrGGFNamee))
    val regexReplace60 = """(yourGothram)""".toRegex()
    mBody83 = SpannableString(Body83A.replace(regexReplace60, urGothram))
    mBody83.setSpan(AbsoluteSizeSpan(14, true), start, mBody83.length, exExFlag)
    mBody83.setSpan(StyleSpan(Typeface.BOLD), start, mBody83.length, exExFlag)
    mBody83.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody83.length, exExFlag)

    val Body84AA = SpannableString(
        "yourGreatGreatGrandFatherName சர்மா ஆதித்யரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\n3.c.  ஓம் மதுமாந்த: வநஸ்பதி: மதுமாந் அஸ்துஸூர்ய: மாத்வீர்காவ: பவந்துந: yourGothram கோத்ர: அஸ்மத்"
    )
    val regexReplace61 = """(yourGreatGreatGrandFatherName)""".toRegex()
    val Body84A = SpannableString(Body84AA.replace(regexReplace61, yrGGGFNamee))
    val regexReplace62 = """(yourGothram)""".toRegex()
    mBody84 = SpannableString(Body84A.replace(regexReplace62, urGothram))
    mBody84.setSpan(AbsoluteSizeSpan(14, true), start, mBody84.length, exExFlag)
    mBody84.setSpan(StyleSpan(Typeface.BOLD), start, mBody84.length, exExFlag)
    mBody84.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody84.length, exExFlag)

    mBody85A = SpannableString(" ப்ரபிதாமஹான்னு: ")
    mBody85A.setSpan(AbsoluteSizeSpan(14, true), start, mBody85A.length, exExFlag)
    mBody85A.setSpan(StyleSpan(Typeface.BOLD), start, mBody85A.length, exExFlag)
    mBody85A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody85A.length, exExFlag)

    mBody85B = SpannableString(" வ்ருத்தப்ரபிதாமஹ: ")
    mBody85B.setSpan(AbsoluteSizeSpan(14, true), start, mBody85B.length, exExFlag)
    mBody85B.setSpan(StyleSpan(Typeface.BOLD), start, mBody85B.length, exExFlag)
    mBody85B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody85B.length, exExFlag)

    val Body86A =
        SpannableString("yourGreatGrandFatherName சர்மா ஆதித்யரூப: ஸ்வதாநம: த்ருப்யதாம்.\nத்ருப்யத்வம்     த்ருப்யத்வம்     த்ருப்யத்வம்")
    val regexReplace63 = """(yourGreatGrandFatherName)""".toRegex()
    mBody86 = SpannableString(Body86A.replace(regexReplace63, yrGGFNamee))
    mBody86.setSpan(AbsoluteSizeSpan(14, true), start, mBody86.length, exExFlag)
    mBody86.setSpan(StyleSpan(Typeface.BOLD), start, mBody86.length, exExFlag)
    mBody86.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody86.length, exExFlag)

    val Body87B =
        SpannableString("yourGreatGreatGrandFatherName சர்மா ஆதித்யரூப: ஸ்வதாநம: த்ருப்யதாம்.\nத்ருப்யத்வம்     த்ருப்யத்வம்     த்ருப்யத்வம்\n")
    val regexReplace64 = """(yourGreatGreatGrandFatherName)""".toRegex()
    mBody87 = SpannableString(Body87B.replace(regexReplace64, yrGGGFNamee))
    mBody87.setSpan(AbsoluteSizeSpan(14, true), start, mBody87.length, exExFlag)
    mBody87.setSpan(StyleSpan(Typeface.BOLD), start, mBody87.length, exExFlag)
    mBody87.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody87.length, exExFlag)

    val Body62AP1 = SpannableString(
        "\n\n4.a.   ஓம் உதீரதாம் அவரே உத்பராஸ: உந்மத்யமா: பிதர: ஸோம்யாஸ: அஸூம்யஈயு:" +
                " அவ்ருகா: ருதக்ஞா: தேநோவந்து பிதரோஹவேஷூ yourGothram கோத்ர: அஸ்மத் மாதா yourMotherName நாமதேயா வஸூரூப: " +
                "ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\n4.b.   ஓம் அங்கீரஸோந: பிதரோ நவக்வா: அதர்வாண: ப்ருகவ: ஸோம்யாஸ: தேஷாம்வயம் ஸூமதௌ யக்ஞியாநாம் அபிபத்ரே " +
                "ஸௌமனஸே ஸ்யாம yourGothram கோத்ர அஸ்மத் மாதா yourMotherName நாமதேயா வஸூரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\n4.c.   ஓம் ஆயந்துந: பிதர: ஸோம்யாஸ: அக்னிஷ்வாத்தா: பதிபி: தேவயானை: அஸ்மின் யக்ஞே ஸ்வதயா மதந்த: அதிப்ருவந்து " +
                "தேவந்து அஸ்மான் yourGothram கோத்ர அஸ்மத் மாதா yourMotherName நாமதேயா வஸூரூப: ஸ்வதாநம: த்ருப்யதாம்.\n"
    )
    val regexReplace36P1 = """(yourGothram)""".toRegex()
    val Body62P1 = SpannableString(Body62AP1.replace(regexReplace36P1, urGothram))
    val regexReplace36P = """(yourMotherName)""".toRegex()
    mBody62P = SpannableString(Body62P1.replace(regexReplace36P, amName))
    mBody62P.setSpan(AbsoluteSizeSpan(14, true), start, mBody62P.length, exExFlag)
    mBody62P.setSpan(StyleSpan(Typeface.BOLD), start, mBody62P.length, exExFlag)
    mBody62P.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody62P.length, exExFlag)

    val Body62AP2 = SpannableString(
        "\n5.a.    ஓம் ஊர்ஜம் வஹந்தி: அம்ருதம்க்ருதம் பய:கீலாலம் பரிஸ்ருதம் ஸ்வதாஸ்த " +
                "தர்பயதமே பித்ருன் yourGothram கோத்ர: அஸ்மத் பிதாமஹி yourFatherMotherName நாமதேயா ருத்ரரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\n5.b.   ஓம் பித்ருப்ய: ஸ்வாதாயிப்ய: ஸ்வாதாநம: பிதாமஹேப்ய: ஸ்வதாயிப்ய: ஸ்வதாநம: ப்ரபிதாமஹேப்ய: ஸ்வதாயிப்ய: " +
                "ஸ்வாதாநம: yourGothram கோத்ர அஸ்மத் பிதாமஹி yourFatherMotherName நாமதேயா ருத்ரரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\n5.c.   ஓம் யேசேஹபிதர: யேசநேஹ யாங்குச்ச வித்மயான் ஊசன ப்ரவித்ம த்வம்வேத்த யதிதே ஜாதவேத: ஸ்வதாபி: யக்ஞம் " +
                "ஸூக்ருதம் ஜூஷஸ்வ yourGothram கோத்ர அஸ்மத் பிதாமஹி yourFatherMotherName நாமதேயா ருத்ரரூப: ஸ்வதாநம: த்ருப்யதாம்\n."
    )
    val regexReplace36P2 = """(yourGothram)""".toRegex()
    val Body62P2a = SpannableString(Body62AP2.replace(regexReplace36P2, urGothram))
    val regexReplace36Pa = """(yourFatherMotherName)""".toRegex()
    mBody62P2 = SpannableString(Body62P2a.replace(regexReplace36Pa, apAmmaName))
    mBody62P2.setSpan(AbsoluteSizeSpan(14, true), start, mBody62P2.length, exExFlag)
    mBody62P2.setSpan(StyleSpan(Typeface.BOLD), start, mBody62P2.length, exExFlag)
    mBody62P2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody62P2.length, exExFlag)

    val Body62AP3 = SpannableString(
        "\n6.a.    ஓம் மதுவாதா: ருதாயதே மதுக்ஷரந்தி ஸிந்தவ: மாத்வீர்ந: ஸந்து ஓஷதீ: " +
                "yourGothram கோத்ர அஸ்மத்  ப்ரபிதாமஹி yourFatherGrandMotherName நாமதேயா ஆதித்யரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\n6.b.      ஓம் மதுநக்தம் உதோஷஸ: மதுமத் பார்த்தீவம் ரஜ: மதுத்யௌ: அஸ்துந: பிதா yourGothram கோத்ர அஸ்மத்" +
                "ப்ரபிதாமஹி yourFatherGrandMotherName நாமதேயா ஆதித்யரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\n6.c.      ஓம் மதுமாந்த: வநஸ்பதி: மதுமாந் அஸ்துஸூர்ய: மாத்வீர்காவ: பவந்துந: yourGothram கோத்ர அஸ்மத் " +
                "ப்ரபிதாமஹி yourFatherGrandMotherName நாமதேயா ஆதித்யரூப: ஸ்வதாநம: த்ருப்யதாம்.\n\nத்ருப்யத்வம்     த்ருப்யத்வம்     த்ருப்யத்வம்\n"
    )
    val regexReplace36P3 = """(yourGothram)""".toRegex()
    val Body62P3a = SpannableString(Body62AP3.replace(regexReplace36P3, urGothram))
    val regexReplace36P3a = """(yourFatherGrandMotherName)""".toRegex()
    mBody62P3 = SpannableString(Body62P3a.replace(regexReplace36P3a, apPattiName))
    mBody62P3.setSpan(AbsoluteSizeSpan(14, true), start, mBody62P3.length, exExFlag)
    mBody62P3.setSpan(StyleSpan(Typeface.BOLD), start, mBody62P3.length, exExFlag)
    mBody62P3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody62P3.length, exExFlag)

    mMHeading5mG = SpannableString("\nநடுகூர்ச்சம் - மாதாமஹவர்கம்")
    mMHeading5mG.setSpan(AbsoluteSizeSpan(14, true), start, mMHeading5mG.length, exExFlag)
    mMHeading5mG.setSpan(StyleSpan(Typeface.BOLD), start, mMHeading5mG.length, exExFlag)
    mMHeading5mG.setSpan(UnderlineSpan(), start, mMHeading5mG.length, exExFlag)
    mMHeading5mG.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, mMHeading5mG.length, exExFlag)

    val MBody62A = SpannableString(
        "\nI.a.   ஓம் உதீரதாம் அவரே உத்பராஸ: உந்மத்யமா: பிதர: ஸோம்யாஸ: அஸூம்யஈயு: " +
                "அவ்ருகா: ருதக்ஞா: தேநோவந்து பிதரோஹவேஷூ motherSideGothram கோத்ர: அஸ்மத் "
    )
    val MregexReplace36 = """(motherSideGothram)""".toRegex()
    mMBody62 = SpannableString(MBody62A.replace(MregexReplace36, MGothram))
    mMBody62.setSpan(AbsoluteSizeSpan(14, true), start, mMBody62.length, exExFlag)
    mMBody62.setSpan(StyleSpan(Typeface.BOLD), start, mMBody62.length, exExFlag)
    mMBody62.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mMBody62.length, exExFlag)

    val MBody63AA = SpannableString(
        " மாதாமஹ: motherFather  சர்மா வஸூரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\nI.b.  ஓம் அங்கீரஸோந: பிநரோ நவக்வா: அதர்வாண: ப்ருகவ: ஸோம்யாஸ: தேஷாம்வயம் ஸூமதௌ யக்ஞியாநாம் அபிபத்ரே " +
                "ஸௌமனஸே ஸ்யாம motherSideGothram கோத்ர: அஸ்மத்"
    )
    val MregexMFN = """(motherFather)""".toRegex()
    val MBody63A = SpannableString(MBody63AA.replace(MregexMFN, MFNamee))
    val MregexGothram = """(motherSideGothram)""".toRegex()
    mMBody63 = SpannableString(MBody63A.replace(MregexGothram, MGothram))
    mMBody63.setSpan(AbsoluteSizeSpan(14, true), start, mMBody63.length, exExFlag)
    mMBody63.setSpan(StyleSpan(Typeface.BOLD), start, mMBody63.length, exExFlag)
    mMBody63.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mMBody63.length, exExFlag)

    val MBody64AA = SpannableString(
        "மாதாமஹ: motherFather  சர்மா வஸூரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\nI.c.  ஓம் ஆயந்துந: பிதர: ஸோம்யாஸ: அக்னிஷ்வாத்தா: பதிபி: தேவயானை: அஸ்மின்யக்ஞே ஸ்வதயாமதந்த: " +
                "அதிப்ருவந்து தேவந்து அஸ்மான் motherSideGothram கோத்ர: அஸ்மத்"
    )
    val MregexReplace37 = """(motherFather)""".toRegex()
    val MBody64A = SpannableString(MBody64AA.replace(MregexReplace37, MFNamee))
    val MregexReplace38 = """(motherSideGothram)""".toRegex()
    mMBody64 = SpannableString(MBody64A.replace(MregexReplace38, MGothram))
    mMBody64.setSpan(AbsoluteSizeSpan(14, true), start, mMBody64.length, exExFlag)
    mMBody64.setSpan(StyleSpan(Typeface.BOLD), start, mMBody64.length, exExFlag)
    mMBody64.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mMBody64.length, exExFlag)

    val MBody66AA = SpannableString(
        " மாதாமஹ: motherFather  சர்மா வஸூரூப: ஸ்வதாநம: த்ருப்யதாம். \n\nII.a. ஓம் " +
                "ஊர்ஜம்வஹந்தீ: அம்ருதம் க்ருதம் பய:கீலாலம் பரிஸ்ருதம் ஸ்வதாஸ்த தர்பயதமே பித்ரூன் motherSideGothram கோத்ர: அஸ்மத்"
    )
    val MregexReplace39 = """(motherFather)""".toRegex()
    val MBody66A = SpannableString(MBody66AA.replace(MregexReplace39, MFNamee))
    val MregexReplace40 = """(motherSideGothram)""".toRegex()
    mMBody66 = SpannableString(MBody66A.replace(MregexReplace40, MGothram))
    mMBody66.setSpan(AbsoluteSizeSpan(14, true), start, mMBody66.length, exExFlag)
    mMBody66.setSpan(StyleSpan(Typeface.BOLD), start, mMBody66.length, exExFlag)
    mMBody66.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mMBody66.length, exExFlag)

    val MBody68AA = SpannableString(
        "ப்ரமாதாமஹ: motherGrandFather சர்மா ருத்ரரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\nII.b. ஓம் பித்ருப்ய: ஸ்வாதாயிப்ய: ஸ்வதாநம: பிதாமஹேப்ய: ஸ்வதாயிப்ய: ஸ்வதாநம: ப்ரபிதாமஹேப்ய: ஸ்வதாயிப்ய: " +
                "ஸ்வதாநம: motherSideGothram கோத்ர: அஸ்மத்"
    )
    val MregexReplace41 = """(motherGrandFather)""".toRegex()
    val MBody68A = SpannableString(MBody68AA.replace(MregexReplace41, MGFNamee))
    val M2regexReplace40 = """(motherSideGothram)""".toRegex()
    mMBody68 = SpannableString(MBody68A.replace(M2regexReplace40, MGothram))
    mMBody68.setSpan(AbsoluteSizeSpan(14, true), start, mMBody68.length, exExFlag)
    mMBody68.setSpan(StyleSpan(Typeface.BOLD), start, mMBody68.length, exExFlag)
    mMBody68.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mMBody68.length, exExFlag)

    val MBody69AA = SpannableString(
        "ப்ரமாதாமஹ: motherGrandFather சர்மா  ருத்ரரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\nII.c. யேசேஹபிதர: யேசநேஹ யாங்குச்ச வித்மயான் ஊசந ப்ரவித்ம த்வம்வேத்த யதிதேஜாதவேத: ஸ்வதாபி: யக்ஞம் " +
                "ஸூக்ருதம் ஜூஷஸ்வ motherSideGothram கோத்ர: அஸ்மத்"
    )
    val M2regexReplace41 = """(motherGrandFather)""".toRegex()
    val MBody69A = SpannableString(MBody69AA.replace(M2regexReplace41, MGFNamee))
    val M3regexReplace40 = """(motherSideGothram)""".toRegex()
    mMBody69 = SpannableString(MBody69A.replace(M3regexReplace40, MGothram))
    mMBody69.setSpan(AbsoluteSizeSpan(14, true), start, mMBody69.length, exExFlag)
    mMBody69.setSpan(StyleSpan(Typeface.BOLD), start, mMBody69.length, exExFlag)
    mMBody69.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mMBody69.length, exExFlag)

    val MBody71AA = SpannableString(
        "ப்ரமாதாமஹ: motherGrandFather சர்மா ருத்ரரூப: ஸ்வதாநம: த்ருப்யதாம். \n\nIII.a.    " +
                "ஓம் மதுவாதா: ருதாயதே மதுக்ஷரந்தி ஸிந்தவ: மாத்வீர்ந: ஸந்து ஓஷதீ: motherSideGothram கோத்ர: அஸ்மத்"
    )
    val MregexReplace43 = """(motherGrandFather)""".toRegex()
    val MBody71A = SpannableString(MBody71AA.replace(MregexReplace43, MGFNamee))
    val MregexReplace44 = """(motherSideGothram)""".toRegex()
    mMBody71 = SpannableString(MBody71A.replace(MregexReplace44, MGothram))
    mMBody71.setSpan(AbsoluteSizeSpan(14, true), start, mMBody71.length, exExFlag)
    mMBody71.setSpan(StyleSpan(Typeface.BOLD), start, mMBody71.length, exExFlag)
    mMBody71.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mMBody71.length, exExFlag)

    val MBody72AA = SpannableString(
        "வ்ருத்தப்ரமாதாமஹ: motherGreatGrandFather சர்மா ஆதித்யரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\nIII.b.    ஓம் மதுநக்தம் உதோஷஸ: மதுமத் பார்த்திவம் ரஜ: மதுத்யௌ: அஸ்துந: பிதா  motherSideGothram கோத்ர: அஸ்மத்"
    )
    val MregexReplace45 = """(motherGreatGrandFather)""".toRegex()
    val MBody72A = SpannableString(MBody72AA.replace(MregexReplace45, MGGFNamee))
    val MregexReplace46 = """(motherSideGothram)""".toRegex()
    mMBody72 = SpannableString(MBody72A.replace(MregexReplace46, MGothram))
    mMBody72.setSpan(AbsoluteSizeSpan(14, true), start, mMBody72.length, exExFlag)
    mMBody72.setSpan(StyleSpan(Typeface.BOLD), start, mMBody72.length, exExFlag)
    mMBody72.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mMBody72.length, exExFlag)

    val MBody74AA = SpannableString(
        "வ்ருத்தப்ரமாதாமஹ: motherGreatGrandFather சர்மா ஆதித்யரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\nIII.c.    ஓம் மதுமாந்த: வநஸ்பதி: மதுமாந் அஸ்துஸூர்ய: மாத்வீர் காவோபவந்துந: motherSideGothram கோத்ர: அஸ்மத்"
    )
    val MregexReplace47 = """(motherGreatGrandFather)""".toRegex()
    val MBody74A = SpannableString(MBody74AA.replace(MregexReplace47, MGGFNamee))
    val MregexReplace48 = """(motherSideGothram)""".toRegex()
    mMBody74 = SpannableString(MBody74A.replace(MregexReplace48, MGothram))
    mMBody74.setSpan(AbsoluteSizeSpan(14, true), start, mMBody74.length, exExFlag)
    mMBody74.setSpan(StyleSpan(Typeface.BOLD), start, mMBody74.length, exExFlag)
    mMBody74.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mMBody74.length, exExFlag)

    val MBody75A = SpannableString(
        "வ்ருத்தப்ரமாதாமஹ: motherGreatGrandFather சர்மா ஆதித்யரூப: ஸ்வதாநம: த்ருப்யதாம்.\n\n" +
                "    த்ருப்யத்வம்     த்ருப்யத்வம்     த்ருப்யத்வம்\n"
    )
    val MregexReplace49 = """(motherGreatGrandFather)""".toRegex()
    mMBody75 = SpannableString(MBody75A.replace(MregexReplace49, MGGFNamee))
    mMBody75.setSpan(AbsoluteSizeSpan(14, true), start, mMBody75.length, exExFlag)
    mMBody75.setSpan(StyleSpan(Typeface.BOLD), start, mMBody75.length, exExFlag)
    mMBody75.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mMBody75.length, exExFlag)

    val MBody62AM = SpannableString(
        "\nIV.a.     ஓம் உதீரதாம் அவரே உத்பராஸ: உந்மத்யமா: பிதர: ஸோம்யாஸ: அஸூம்யஈயு: " +
                "அவ்ருகா: ருதக்ஞா: தேநோவந்து பிதரோஹவேஷூ motherSideGothram கோத்ர அஸ்மத்"
    )
    val MregexReplace36M = """(motherSideGothram)""".toRegex()
    mMBody62M = SpannableString(MBody62AM.replace(MregexReplace36M, MGothram))
    mMBody62M.setSpan(AbsoluteSizeSpan(14, true), start, mMBody62M.length, exExFlag)
    mMBody62M.setSpan(StyleSpan(Typeface.BOLD), start, mMBody62M.length, exExFlag)
    mMBody62M.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mMBody62M.length, exExFlag)

    val MBody63AAM = SpannableString(
        " மாதாமஹி motherMother  நாமதேயா வஸூரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\nIV.b.     ஓம் அங்கீரஸோந: பிநரோ நவக்வா: அதர்வாண: ப்ருகவ: ஸோம்யாஸ: தேஷாம்வயம் ஸூமதௌ யக்ஞியாநாம் " +
                "அபிபத்ரே ஸௌமனஸே ஸ்யாம motherSideGothram கோத்ர அஸ்மத்"
    )
    val MregexMFNM = """(motherMother)""".toRegex()
    val MBody63AM = SpannableString(MBody63AAM.replace(MregexMFNM, amAmmaName))
    val MregexGothramM = """(motherSideGothram)""".toRegex()
    mMBody63M = SpannableString(MBody63AM.replace(MregexGothramM, MGothram))
    mMBody63M.setSpan(AbsoluteSizeSpan(14, true), start, mMBody63M.length, exExFlag)
    mMBody63M.setSpan(StyleSpan(Typeface.BOLD), start, mMBody63M.length, exExFlag)
    mMBody63M.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mMBody63M.length, exExFlag)

    val MBody64AAM = SpannableString(
        "மாதாமஹி motherMother  நாமதேயா வஸூரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\nIV.c.     ஓம் ஆயந்துந: பிதர: ஸோம்யாஸ: அக்னிஷ்வாத்தா: பதிபி: தேவயானை: அஸ்மின்யக்ஞே ஸ்வதயாமதந்த: " +
                "அதிப்ருவந்து தேவந்து அஸ்மான் motherSideGothram கோத்ர அஸ்மத்"
    )
    val MregexReplace37M = """(motherMother)""".toRegex()
    val MBody64AM = SpannableString(MBody64AAM.replace(MregexReplace37M, amAmmaName))
    val MregexReplace38M = """(motherSideGothram)""".toRegex()
    mMBody64M = SpannableString(MBody64AM.replace(MregexReplace38M, MGothram))
    mMBody64M.setSpan(AbsoluteSizeSpan(14, true), start, mMBody64M.length, exExFlag)
    mMBody64M.setSpan(StyleSpan(Typeface.BOLD), start, mMBody64M.length, exExFlag)
    mMBody64M.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mMBody64M.length, exExFlag)

    val MBody66AAM = SpannableString(
        " மாதாமஹி motherMother  நாமதேயா வஸூரூப: ஸ்வதாநம: த்ருப்யதாம். \n\nV.a.      " +
                "ஓம் ஊர்ஜம்வஹந்தீ: அம்ருதம் க்ருதம் பய:கீலாலம் பரிஸ்ருதம் ஸ்வதாஸ்த தர்பயதமே பித்ரூன் motherSideGothram கோத்ர அஸ்மத்"
    )
    val MregexReplace39M = """(motherMother)""".toRegex()
    val MBody66AM = SpannableString(MBody66AAM.replace(MregexReplace39M, amAmmaName))
    val MregexReplace40M = """(motherSideGothram)""".toRegex()
    mMBody66M = SpannableString(MBody66AM.replace(MregexReplace40M, MGothram))
    mMBody66M.setSpan(AbsoluteSizeSpan(14, true), start, mMBody66M.length, exExFlag)
    mMBody66M.setSpan(StyleSpan(Typeface.BOLD), start, mMBody66M.length, exExFlag)
    mMBody66M.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mMBody66M.length, exExFlag)

    val MBody68AAM = SpannableString(
        "ப்ரமாதாமஹி motherGrandMother நாமதேயா ருத்ரரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\nV.b.      ஓம் பித்ருப்ய: ஸ்வாதாயிப்ய: ஸ்வதாநம: பிதாமஹேப்ய: ஸ்வதாயிப்ய: ஸ்வதாநம: ப்ரபிதாமஹேப்ய: ஸ்வதாயிப்ய: " +
                "ஸ்வதாநம: motherSideGothram கோத்ர அஸ்மத்"
    )
    val MregexReplace41M = """(motherGrandMother)""".toRegex()
    val MBody68AM = SpannableString(MBody68AAM.replace(MregexReplace41M, amPattiName))
    val M2regexReplace40M = """(motherSideGothram)""".toRegex()
    mMBody68M = SpannableString(MBody68AM.replace(M2regexReplace40M, MGothram))
    mMBody68M.setSpan(AbsoluteSizeSpan(14, true), start, mMBody68M.length, exExFlag)
    mMBody68M.setSpan(StyleSpan(Typeface.BOLD), start, mMBody68M.length, exExFlag)
    mMBody68M.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mMBody68M.length, exExFlag)

    val MBody69AAM = SpannableString(
        "ப்ரமாதாமஹி motherGrandMother நாமதேயா  ருத்ரரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\nV.c.      யேசேஹபிதர: யேசநேஹ யாங்குச்ச வித்மயான் ஊசந ப்ரவித்ம த்வம்வேத்த யதிதேஜாதவேத: ஸ்வதாபி: யக்ஞம் " +
                "ஸூக்ருதம் ஜூஷஸ்வ motherSideGothram கோத்ர அஸ்மத்"
    )
    val M2regexReplace41M = """(motherGrandMother)""".toRegex()
    val MBody69AM = SpannableString(MBody69AAM.replace(M2regexReplace41M, amPattiName))
    val M3regexReplace40M = """(motherSideGothram)""".toRegex()
    mMBody69M = SpannableString(MBody69AM.replace(M3regexReplace40M, MGothram))
    mMBody69M.setSpan(AbsoluteSizeSpan(14, true), start, mMBody69M.length, exExFlag)
    mMBody69M.setSpan(StyleSpan(Typeface.BOLD), start, mMBody69M.length, exExFlag)
    mMBody69M.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mMBody69M.length, exExFlag)

    val MBody71AAM = SpannableString(
        "ப்ரமாதாமஹி motherGrandMother நாமதேயா ருத்ரரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\nVI.a.    ஓம் மதுவாதா: ருதாயதே மதுக்ஷரந்தி ஸிந்தவ: மாத்வீர்ந: ஸந்து ஓஷதீ: motherSideGothram கோத்ர அஸ்மத்"
    )
    val MregexReplace43M = """(motherGrandMother)""".toRegex()
    val MBody71AM = SpannableString(MBody71AAM.replace(MregexReplace43M, amPattiName))
    val MregexReplace44M = """(motherSideGothram)""".toRegex()
    mMBody71M = SpannableString(MBody71AM.replace(MregexReplace44M, MGothram))
    mMBody71M.setSpan(AbsoluteSizeSpan(14, true), start, mMBody71M.length, exExFlag)
    mMBody71M.setSpan(StyleSpan(Typeface.BOLD), start, mMBody71M.length, exExFlag)
    mMBody71M.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mMBody71M.length, exExFlag)

    val MBody72AAM = SpannableString(
        "வ்ருத்தப்ரமாதாமஹி motherGreatGrandMother நாமதேயா ஆதித்யரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\nVI.b.    ஓம் மதுநக்தம் உதோஷஸ: மதுமத் பார்த்திவம் ரஜ: மதுத்யௌ: அஸ்துந: பிதா  motherSideGothram கோத்ர அஸ்மத்"
    )
    val MregexReplace45M = """(motherGreatGrandMother)""".toRegex()
    val MBody72AM = SpannableString(MBody72AAM.replace(MregexReplace45M, amKolluPattiName))
    val MregexReplace46M = """(motherSideGothram)""".toRegex()
    mMBody72M = SpannableString(MBody72AM.replace(MregexReplace46M, MGothram))
    mMBody72M.setSpan(AbsoluteSizeSpan(14, true), start, mMBody72M.length, exExFlag)
    mMBody72M.setSpan(StyleSpan(Typeface.BOLD), start, mMBody72M.length, exExFlag)
    mMBody72M.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mMBody72M.length, exExFlag)

    val MBody74AAM = SpannableString(
        "வ்ருத்தப்ரமாதாமஹி motherGreatGrandMother நாமதேயா ஆதித்யரூப: ஸ்வதாநம: த்ருப்யதாம்.\n" +
                "\nVI.c.    ஓம் மதுமாந்த: வநஸ்பதி: மதுமாந் அஸ்துஸூர்ய: மாத்வீர் காவோபவந்துந: motherSideGothram கோத்ர அஸ்மத்"
    )
    val MregexReplace47M = """(motherGreatGrandMother)""".toRegex()
    val MBody74AM = SpannableString(MBody74AAM.replace(MregexReplace47M, amKolluPattiName))
    val MregexReplace48M = """(motherSideGothram)""".toRegex()
    mMBody74M = SpannableString(MBody74AM.replace(MregexReplace48M, MGothram))
    mMBody74M.setSpan(AbsoluteSizeSpan(14, true), start, mMBody74M.length, exExFlag)
    mMBody74M.setSpan(StyleSpan(Typeface.BOLD), start, mMBody74M.length, exExFlag)
    mMBody74M.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mMBody74M.length, exExFlag)

    val MBody75AM = SpannableString(
        "வ்ருத்தப்ரமாதாமஹி motherGreatGrandMother நாமதேயா ஆதித்யரூப: ஸ்வதாநம: த்ருப்யதாம்.\n\n" +
                "    த்ருப்யத்வம்     த்ருப்யத்வம்     த்ருப்யத்வம்\n"
    )
    val MregexReplace49M = """(motherGreatGrandMother)""".toRegex()
    mMBody75M = SpannableString(MBody75AM.replace(MregexReplace49M, amKolluPattiName))
    mMBody75M.setSpan(AbsoluteSizeSpan(14, true), start, mMBody75M.length, exExFlag)
    mMBody75M.setSpan(StyleSpan(Typeface.BOLD), start, mMBody75M.length, exExFlag)
    mMBody75M.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mMBody75M.length, exExFlag)
}
fun bottomPithruKoorcham(){
    val exExFlag = Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
    val start: Int = 0
    mHeading5P = SpannableString("\nகீழ்கூர்ச்சம்-பித்ருவர்கம்  ")
    mHeading5P.setSpan(AbsoluteSizeSpan(14, true), start, mHeading5P.length, exExFlag)
    mHeading5P.setSpan(StyleSpan(Typeface.BOLD), start, mHeading5P.length, exExFlag)
    mHeading5P.setSpan(UnderlineSpan(), start, mHeading5P.length, exExFlag)
    mHeading5P.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, mHeading5P.length, exExFlag)

    personHead = SpannableString("(விசேஷ தர்ப்பணம்)")
    personHead.setSpan(AbsoluteSizeSpan(14, true), start, personHead.length, exExFlag)
    personHead.setSpan(StyleSpan(Typeface.BOLD), start, personHead.length, exExFlag)
    personHead.setSpan(UnderlineSpan(), start, personHead.length, exExFlag)
    personHead.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, personHead.length, exExFlag)

    strAdditionP1 = SpannableString("\nA.")
    strAdditionP1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1.length, exExFlag)
    strAdditionP1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1.length, exExFlag)
    strAdditionP1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1.length, exExFlag)

    strAdditionP1ab = SpannableString("\nA.")
    strAdditionP1ab.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1ab.length, exExFlag)
    strAdditionP1ab.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1ab.length, exExFlag)
    strAdditionP1ab.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1ab.length, exExFlag)

    strAdditionP1ac = SpannableString("\nA.")
    strAdditionP1ac.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1ac.length, exExFlag)
    strAdditionP1ac.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1ac.length, exExFlag)
    strAdditionP1ac.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1ac.length, exExFlag)

    strAdditionP2 = SpannableString("\nB.")
    strAdditionP2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP2.length, exExFlag)
    strAdditionP2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP2.length, exExFlag)
    strAdditionP2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP2.length, exExFlag)

    strAdditionP2P = SpannableString("\nB.")
    strAdditionP2P.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP2P.length, exExFlag)
    strAdditionP2P.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP2P.length, exExFlag)
    strAdditionP2P.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP2P.length, exExFlag)

    strAdditionP2bb = SpannableString("\nB.")
    strAdditionP2bb.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP2bb.length, exExFlag)
    strAdditionP2bb.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP2bb.length, exExFlag)
    strAdditionP2bb.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP2bb.length, exExFlag)

    strAdditionP2bc = SpannableString("\nB.")
    strAdditionP2bc.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP2bc.length, exExFlag)
    strAdditionP2bc.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP2bc.length, exExFlag)
    strAdditionP2bc.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP2bc.length, exExFlag)

    strAdditionP3 = SpannableString("\nC.")
    strAdditionP3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP3.length, exExFlag)
    strAdditionP3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP3.length, exExFlag)
    strAdditionP3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP3.length, exExFlag)

    strAdditionP3P = SpannableString("\nC.")
    strAdditionP3P.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP3P.length, exExFlag)
    strAdditionP3P.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP3P.length, exExFlag)
    strAdditionP3P.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP3P.length, exExFlag)

    strAdditionP3cb = SpannableString("\nC.")
    strAdditionP3cb.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP3cb.length, exExFlag)
    strAdditionP3cb.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP3cb.length, exExFlag)
    strAdditionP3cb.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP3cb.length, exExFlag)

    strAdditionP3cc = SpannableString("\nC.")
    strAdditionP3cc.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP3cc.length, exExFlag)
    strAdditionP3cc.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP3cc.length, exExFlag)
    strAdditionP3cc.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP3cc.length, exExFlag)

    strAdditionP4 = SpannableString("\nD.")
    strAdditionP4.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP4.length, exExFlag)
    strAdditionP4.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP4.length, exExFlag)
    strAdditionP4.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP4.length, exExFlag)

    strAdditionP4db = SpannableString("\nD.")
    strAdditionP4db.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP4db.length, exExFlag)
    strAdditionP4db.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP4db.length, exExFlag)
    strAdditionP4db.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP4db.length, exExFlag)

    strAdditionP4dc = SpannableString("\nD.")
    strAdditionP4dc.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP4dc.length, exExFlag)
    strAdditionP4dc.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP4dc.length, exExFlag)
    strAdditionP4dc.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP4dc.length, exExFlag)

    strAdditionP5 = SpannableString("\nE.")
    strAdditionP5.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP5.length, exExFlag)
    strAdditionP5.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP5.length, exExFlag)
    strAdditionP5.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP5.length, exExFlag)

    strAdditionP5eb = SpannableString("\nE.")
    strAdditionP5eb.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP5eb.length, exExFlag)
    strAdditionP5eb.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP5eb.length, exExFlag)
    strAdditionP5eb.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP5eb.length, exExFlag)

    strAdditionP5ec = SpannableString("\nE.")
    strAdditionP5ec.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP5ec.length, exExFlag)
    strAdditionP5ec.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP5ec.length, exExFlag)
    strAdditionP5ec.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP5ec.length, exExFlag)

    strAdditionP6 = SpannableString("\nF.")
    strAdditionP6.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP6.length, exExFlag)
    strAdditionP6.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP6.length, exExFlag)
    strAdditionP6.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP6.length, exExFlag)

    strAdditionP6fb = SpannableString("\nF.")
    strAdditionP6fb.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP6fb.length, exExFlag)
    strAdditionP6fb.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP6fb.length, exExFlag)
    strAdditionP6fb.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP6fb.length, exExFlag)

    strAdditionP6fc = SpannableString("\nF.")
    strAdditionP6fc.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP6fc.length, exExFlag)
    strAdditionP6fc.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP6fc.length, exExFlag)
    strAdditionP6fc.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP6fc.length, exExFlag)

    strAdditionP7 = SpannableString("\nG.")
    strAdditionP7.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP7.length, exExFlag)
    strAdditionP7.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP7.length, exExFlag)
    strAdditionP7.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP7.length, exExFlag)

    strAdditionP7gb = SpannableString("\nG.")
    strAdditionP7gb.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP7gb.length, exExFlag)
    strAdditionP7gb.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP7gb.length, exExFlag)
    strAdditionP7gb.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP7gb.length, exExFlag)

    strAdditionP7gc = SpannableString("\nG.")
    strAdditionP7gc.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP7gc.length, exExFlag)
    strAdditionP7gc.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP7gc.length, exExFlag)
    strAdditionP7gc.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP7gc.length, exExFlag)

    strAdditionP8 = SpannableString("\nH.")
    strAdditionP8.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP8.length, exExFlag)
    strAdditionP8.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP8.length, exExFlag)
    strAdditionP8.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP8.length, exExFlag)

    strAdditionP8hb = SpannableString("\nH.")
    strAdditionP8hb.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP8hb.length, exExFlag)
    strAdditionP8hb.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP8hb.length, exExFlag)
    strAdditionP8hb.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP8hb.length, exExFlag)

    strAdditionP8hc = SpannableString("\nH.")
    strAdditionP8hc.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP8hc.length, exExFlag)
    strAdditionP8hc.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP8hc.length, exExFlag)
    strAdditionP8hc.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP8hc.length, exExFlag)

    strAdditionP9 = SpannableString("\nI.")
    strAdditionP9.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP9.length, exExFlag)
    strAdditionP9.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP9.length, exExFlag)
    strAdditionP9.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP9.length, exExFlag)

    strAdditionP9ib = SpannableString("\nI.")
    strAdditionP9ib.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP9ib.length, exExFlag)
    strAdditionP9ib.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP9ib.length, exExFlag)
    strAdditionP9ib.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP9ib.length, exExFlag)

    strAdditionP9ic = SpannableString("\nI.")
    strAdditionP9ic.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP9ic.length, exExFlag)
    strAdditionP9ic.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP9ic.length, exExFlag)
    strAdditionP9ic.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP9ic.length, exExFlag)

    strAdditionP10 = SpannableString("\nJ.")
    strAdditionP10.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP10.length, exExFlag)
    strAdditionP10.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP10.length, exExFlag)
    strAdditionP10.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP10.length, exExFlag)

    strAdditionP10jb = SpannableString("\nJ.")
    strAdditionP10jb.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP10jb.length, exExFlag)
    strAdditionP10jb.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP10jb.length, exExFlag)
    strAdditionP10jb.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP10jb.length, exExFlag)

    strAdditionP10jc = SpannableString("\nJ.")
    strAdditionP10jc.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP10jc.length, exExFlag)
    strAdditionP10jc.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP10jc.length, exExFlag)
    strAdditionP10jc.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP10jc.length, exExFlag)

    strAdditionP11 = SpannableString("\nK.")
    strAdditionP11.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP11.length, exExFlag)
    strAdditionP11.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP11.length, exExFlag)
    strAdditionP11.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP11.length, exExFlag)

    strAdditionP11kb = SpannableString("\nK.")
    strAdditionP11kb.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP11kb.length, exExFlag)
    strAdditionP11kb.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP11kb.length, exExFlag)
    strAdditionP11kb.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP11kb.length, exExFlag)

    strAdditionP11kc = SpannableString("\nK.")
    strAdditionP11kc.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP11kc.length, exExFlag)
    strAdditionP11kc.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP11kc.length, exExFlag)
    strAdditionP11kc.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP11kc.length, exExFlag)

    strAdditionP12 = SpannableString("\nL.")
    strAdditionP12.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP12.length, exExFlag)
    strAdditionP12.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP12.length, exExFlag)
    strAdditionP12.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP12.length, exExFlag)

    strAdditionP12lb = SpannableString("\nL.")
    strAdditionP12lb.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP12lb.length, exExFlag)
    strAdditionP12lb.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP12lb.length, exExFlag)
    strAdditionP12lb.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP12lb.length, exExFlag)

    strAdditionP12lc = SpannableString("\nL.")
    strAdditionP12lc.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP12lc.length, exExFlag)
    strAdditionP12lc.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP12lc.length, exExFlag)
    strAdditionP12lc.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP12lc.length, exExFlag)

    strAdditionP13 = SpannableString("\nM.")
    strAdditionP13.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP13.length, exExFlag)
    strAdditionP13.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP13.length, exExFlag)
    strAdditionP13.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP13.length, exExFlag)

    strAdditionP13mb = SpannableString("\nM.")
    strAdditionP13mb.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP13mb.length, exExFlag)
    strAdditionP13mb.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP13mb.length, exExFlag)
    strAdditionP13mb.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP13mb.length, exExFlag)

    strAdditionP13mc = SpannableString("\nM.")
    strAdditionP13mc.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP13mc.length, exExFlag)
    strAdditionP13mc.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP13mc.length, exExFlag)
    strAdditionP13mc.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP13mc.length, exExFlag)

    strAdditionP14 = SpannableString("\nN.")
    strAdditionP14.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP14.length, exExFlag)
    strAdditionP14.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP14.length, exExFlag)
    strAdditionP14.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP14.length, exExFlag)

    strAdditionP14nb = SpannableString("\nN.")
    strAdditionP14nb.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP14nb.length, exExFlag)
    strAdditionP14nb.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP14nb.length, exExFlag)
    strAdditionP14nb.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP14nb.length, exExFlag)

    strAdditionP14nc = SpannableString("\nN.")
    strAdditionP14nc.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP14nc.length, exExFlag)
    strAdditionP14nc.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP14nc.length, exExFlag)
    strAdditionP14nc.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP14nc.length, exExFlag)

    strAdditionP15 = SpannableString("\nO.")
    strAdditionP15.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP15.length, exExFlag)
    strAdditionP15.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP15.length, exExFlag)
    strAdditionP15.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP15.length, exExFlag)

    strAdditionP15ob = SpannableString("\nO.")
    strAdditionP15ob.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP15ob.length, exExFlag)
    strAdditionP15ob.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP15ob.length, exExFlag)
    strAdditionP15ob.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP15ob.length, exExFlag)

    strAdditionP15oc = SpannableString("\nO.")
    strAdditionP15oc.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP15oc.length, exExFlag)
    strAdditionP15oc.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP15oc.length, exExFlag)
    strAdditionP15oc.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP15oc.length, exExFlag)

    strAdditionP1P = SpannableString("\nA.")
    strAdditionP1P.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1P.length, exExFlag)
    strAdditionP1P.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1P.length, exExFlag)
    strAdditionP1P.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1P.length, exExFlag)

    strAdditionNO1 = SpannableString(" 1.")
    strAdditionNO1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO1.length, exExFlag)
    strAdditionNO1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO1.length, exExFlag)
    strAdditionNO1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO1.length, exExFlag)

    strAdditionNO1B = SpannableString(" 1.")
    strAdditionNO1B.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO1B.length, exExFlag)
    strAdditionNO1B.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO1B.length, exExFlag)
    strAdditionNO1B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO1B.length, exExFlag)

    strAdditionNO1C = SpannableString(" 1.")
    strAdditionNO1C.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO1C.length, exExFlag)
    strAdditionNO1C.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO1C.length, exExFlag)
    strAdditionNO1C.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO1C.length, exExFlag)

    strAdditionNO1D = SpannableString(" 1.")
    strAdditionNO1D.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO1D.length, exExFlag)
    strAdditionNO1D.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO1D.length, exExFlag)
    strAdditionNO1D.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO1D.length, exExFlag)

    strAdditionNO1E = SpannableString(" 1.")
    strAdditionNO1E.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO1E.length, exExFlag)
    strAdditionNO1E.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO1E.length, exExFlag)
    strAdditionNO1E.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO1E.length, exExFlag)

    strAdditionNO1F = SpannableString(" 1.")
    strAdditionNO1F.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO1F.length, exExFlag)
    strAdditionNO1F.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO1F.length, exExFlag)
    strAdditionNO1F.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO1F.length, exExFlag)

    strAdditionNO1G = SpannableString(" 1.")
    strAdditionNO1G.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO1G.length, exExFlag)
    strAdditionNO1G.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO1G.length, exExFlag)
    strAdditionNO1G.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO1G.length, exExFlag)

    strAdditionNO1H = SpannableString(" 1.")
    strAdditionNO1H.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO1H.length, exExFlag)
    strAdditionNO1H.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO1H.length, exExFlag)
    strAdditionNO1H.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO1H.length, exExFlag)

    strAdditionNO1I = SpannableString(" 1.")
    strAdditionNO1I.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO1I.length, exExFlag)
    strAdditionNO1I.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO1I.length, exExFlag)
    strAdditionNO1I.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO1I.length, exExFlag)

    strAdditionNO1J = SpannableString(" 1.")
    strAdditionNO1J.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO1J.length, exExFlag)
    strAdditionNO1J.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO1J.length, exExFlag)
    strAdditionNO1J.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO1J.length, exExFlag)

    strAdditionNO1K = SpannableString(" 1.")
    strAdditionNO1K.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO1K.length, exExFlag)
    strAdditionNO1K.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO1K.length, exExFlag)
    strAdditionNO1K.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO1K.length, exExFlag)

    strAdditionNO1L = SpannableString(" 1.")
    strAdditionNO1L.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO1L.length, exExFlag)
    strAdditionNO1L.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO1L.length, exExFlag)
    strAdditionNO1L.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO1L.length, exExFlag)

    strAdditionNO1M = SpannableString(" 1.")
    strAdditionNO1M.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO1M.length, exExFlag)
    strAdditionNO1M.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO1M.length, exExFlag)
    strAdditionNO1M.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO1M.length, exExFlag)

    strAdditionNO1N = SpannableString(" 1.")
    strAdditionNO1N.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO1N.length, exExFlag)
    strAdditionNO1N.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO1N.length, exExFlag)
    strAdditionNO1N.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO1N.length, exExFlag)

    strAdditionNO1O = SpannableString(" 1.")
    strAdditionNO1O.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO1O.length, exExFlag)
    strAdditionNO1O.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO1O.length, exExFlag)
    strAdditionNO1O.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO1O.length, exExFlag)

    strAdditionNO2 = SpannableString(" 2.")
    strAdditionNO2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO2.length, exExFlag)
    strAdditionNO2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO2.length, exExFlag)
    strAdditionNO2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO2.length, exExFlag)

    strAdditionNO2B = SpannableString(" 2.")
    strAdditionNO2B.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO2B.length, exExFlag)
    strAdditionNO2B.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO2B.length, exExFlag)
    strAdditionNO2B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO2B.length, exExFlag)

    strAdditionNO2C = SpannableString(" 2.")
    strAdditionNO2C.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO2C.length, exExFlag)
    strAdditionNO2C.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO2C.length, exExFlag)
    strAdditionNO2C.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO2C.length, exExFlag)

    strAdditionNO2D = SpannableString(" 2.")
    strAdditionNO2D.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO2D.length, exExFlag)
    strAdditionNO2D.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO2D.length, exExFlag)
    strAdditionNO2D.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO2D.length, exExFlag)

    strAdditionNO2E = SpannableString(" 2.")
    strAdditionNO2E.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO2E.length, exExFlag)
    strAdditionNO2E.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO2E.length, exExFlag)
    strAdditionNO2E.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO2E.length, exExFlag)

    strAdditionNO2F = SpannableString(" 2.")
    strAdditionNO2F.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO2F.length, exExFlag)
    strAdditionNO2F.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO2F.length, exExFlag)
    strAdditionNO2F.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO2F.length, exExFlag)

    strAdditionNO2G = SpannableString(" 2.")
    strAdditionNO2G.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO2G.length, exExFlag)
    strAdditionNO2G.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO2G.length, exExFlag)
    strAdditionNO2G.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO2G.length, exExFlag)

    strAdditionNO2H = SpannableString(" 2.")
    strAdditionNO2H.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO2H.length, exExFlag)
    strAdditionNO2H.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO2H.length, exExFlag)
    strAdditionNO2H.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO2H.length, exExFlag)

    strAdditionNO2I = SpannableString(" 2.")
    strAdditionNO2I.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO2I.length, exExFlag)
    strAdditionNO2I.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO2I.length, exExFlag)
    strAdditionNO2I.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO2I.length, exExFlag)

    strAdditionNO2J = SpannableString(" 2.")
    strAdditionNO2J.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO2J.length, exExFlag)
    strAdditionNO2J.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO2J.length, exExFlag)
    strAdditionNO2J.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO2J.length, exExFlag)

    strAdditionNO2K = SpannableString(" 2.")
    strAdditionNO2K.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO2K.length, exExFlag)
    strAdditionNO2K.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO2K.length, exExFlag)
    strAdditionNO2K.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO2K.length, exExFlag)

    strAdditionNO2L = SpannableString(" 2.")
    strAdditionNO2L.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO2L.length, exExFlag)
    strAdditionNO2L.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO2L.length, exExFlag)
    strAdditionNO2L.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO2L.length, exExFlag)

    strAdditionNO2M = SpannableString(" 2.")
    strAdditionNO2M.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO2M.length, exExFlag)
    strAdditionNO2M.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO2M.length, exExFlag)
    strAdditionNO2M.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO2M.length, exExFlag)

    strAdditionNO2N = SpannableString(" 2.")
    strAdditionNO2N.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO2N.length, exExFlag)
    strAdditionNO2N.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO2N.length, exExFlag)
    strAdditionNO2N.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO2N.length, exExFlag)

    strAdditionNO2O = SpannableString(" 2.")
    strAdditionNO2O.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO2O.length, exExFlag)
    strAdditionNO2O.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO2O.length, exExFlag)
    strAdditionNO2O.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO2O.length, exExFlag)

    strAdditionNO3 = SpannableString(" 3.")
    strAdditionNO3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO3.length, exExFlag)
    strAdditionNO3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO3.length, exExFlag)
    strAdditionNO3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO3.length, exExFlag)

    strAdditionNO3B = SpannableString(" 3.")
    strAdditionNO3B.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO3B.length, exExFlag)
    strAdditionNO3B.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO3B.length, exExFlag)
    strAdditionNO3B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO3B.length, exExFlag)

    strAdditionNO3C = SpannableString(" 3.")
    strAdditionNO3C.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO3C.length, exExFlag)
    strAdditionNO3C.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO3C.length, exExFlag)
    strAdditionNO3C.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO3C.length, exExFlag)

    strAdditionNO3D = SpannableString(" 3.")
    strAdditionNO3D.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO3D.length, exExFlag)
    strAdditionNO3D.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO3D.length, exExFlag)
    strAdditionNO3D.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO3D.length, exExFlag)

    strAdditionNO3E = SpannableString(" 3.")
    strAdditionNO3E.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO3E.length, exExFlag)
    strAdditionNO3E.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO3E.length, exExFlag)
    strAdditionNO3E.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO3E.length, exExFlag)

    strAdditionNO3F = SpannableString(" 3.")
    strAdditionNO3F.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO3F.length, exExFlag)
    strAdditionNO3F.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO3F.length, exExFlag)
    strAdditionNO3F.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO3F.length, exExFlag)

    strAdditionNO3G = SpannableString(" 3.")
    strAdditionNO3G.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO3G.length, exExFlag)
    strAdditionNO3G.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO3G.length, exExFlag)
    strAdditionNO3G.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO3G.length, exExFlag)

    strAdditionNO3H = SpannableString(" 3.")
    strAdditionNO3H.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO3H.length, exExFlag)
    strAdditionNO3H.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO3H.length, exExFlag)
    strAdditionNO3H.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO3H.length, exExFlag)

    strAdditionNO3I = SpannableString(" 3.")
    strAdditionNO3I.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO3I.length, exExFlag)
    strAdditionNO3I.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO3I.length, exExFlag)
    strAdditionNO3I.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO3I.length, exExFlag)

    strAdditionNO3J = SpannableString(" 3.")
    strAdditionNO3J.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO3J.length, exExFlag)
    strAdditionNO3J.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO3J.length, exExFlag)
    strAdditionNO3J.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO3J.length, exExFlag)

    strAdditionNO3K = SpannableString(" 3.")
    strAdditionNO3K.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO3K.length, exExFlag)
    strAdditionNO3K.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO3K.length, exExFlag)
    strAdditionNO3K.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO3K.length, exExFlag)

    strAdditionNO3L = SpannableString(" 3.")
    strAdditionNO3L.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO3L.length, exExFlag)
    strAdditionNO3L.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO3L.length, exExFlag)
    strAdditionNO3L.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO3L.length, exExFlag)

    strAdditionNO3M = SpannableString(" 3.")
    strAdditionNO3M.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO3M.length, exExFlag)
    strAdditionNO3M.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO3M.length, exExFlag)
    strAdditionNO3M.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO3M.length, exExFlag)

    strAdditionNO3N = SpannableString(" 3.")
    strAdditionNO3N.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO3N.length, exExFlag)
    strAdditionNO3N.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO3N.length, exExFlag)
    strAdditionNO3N.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO3N.length, exExFlag)

    strAdditionNO3O = SpannableString(" 3.")
    strAdditionNO3O.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionNO3O.length, exExFlag)
    strAdditionNO3O.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionNO3O.length, exExFlag)
    strAdditionNO3O.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionNO3O.length, exExFlag)

    val strAdditionP1z4 = SpannableString(" NEWPERSONGOTHRAM1 கோத்ரா அஸ்மத் BORNORDER1 NEWRELATION1 NEWNAME1")
    val regexReplaceNP4 = """(NEWPERSONGOTHRAM1)""".toRegex()
    val strAdditionP1z3 = SpannableString(strAdditionP1z4.replace(regexReplaceNP4, gtOne))
    val regexReplaceNP3 = """(NEWRELATION1)""".toRegex()
    val strAdditionP1z2 = SpannableString(strAdditionP1z3.replace(regexReplaceNP3, reOne))
    val regexReplaceNP2 = """(NEWNAME1)""".toRegex()
    val strAdditionP1z1 = SpannableString(strAdditionP1z2.replace(regexReplaceNP2, nOne))
    val regexReplaceNP1 = """(BORNORDER1)""".toRegex()
    strAdditionP1zM = SpannableString(strAdditionP1z1.replace(regexReplaceNP1, bOne))
    strAdditionP1zM.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1zM.length, exExFlag)
    strAdditionP1zM.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1zM.length, exExFlag)
    strAdditionP1zM.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1zM.length, exExFlag)

    val strAdditionP1z4B = SpannableString(" NEWPERSONGOTHRAM1 கோத்ரா அஸ்மத் BORNORDER1 NEWRELATION1 NEWNAME1")
    val regexReplaceNP4B = """(NEWPERSONGOTHRAM1)""".toRegex()
    val strAdditionP1z3B = SpannableString(strAdditionP1z4B.replace(regexReplaceNP4B, gtOne))
    val regexReplaceNP3B = """(NEWRELATION1)""".toRegex()
    val strAdditionP1z2B = SpannableString(strAdditionP1z3B.replace(regexReplaceNP3B, reOne))
    val regexReplaceNP2B = """(NEWNAME1)""".toRegex()
    val strAdditionP1z1B = SpannableString(strAdditionP1z2B.replace(regexReplaceNP2B, nOne))
    val regexReplaceNP1B = """(BORNORDER1)""".toRegex()
    strAdditionP1zMB = SpannableString(strAdditionP1z1B.replace(regexReplaceNP1B, bOne))
    strAdditionP1zMB.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1zMB.length, exExFlag)
    strAdditionP1zMB.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1zMB.length, exExFlag)
    strAdditionP1zMB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1zMB.length, exExFlag)

    val strAdditionP1z4C = SpannableString(" NEWPERSONGOTHRAM1 கோத்ரா அஸ்மத் BORNORDER1 NEWRELATION1 NEWNAME1")
    val regexReplaceNP4C = """(NEWPERSONGOTHRAM1)""".toRegex()
    val strAdditionP1z3C = SpannableString(strAdditionP1z4C.replace(regexReplaceNP4C, gtOne))
    val regexReplaceNP3C = """(NEWRELATION1)""".toRegex()
    val strAdditionP1z2C = SpannableString(strAdditionP1z3C.replace(regexReplaceNP3C, reOne))
    val regexReplaceNP2C = """(NEWNAME1)""".toRegex()
    val strAdditionP1z1C = SpannableString(strAdditionP1z2C.replace(regexReplaceNP2C, nOne))
    val regexReplaceNP1C = """(BORNORDER1)""".toRegex()
    strAdditionP1zMC = SpannableString(strAdditionP1z1C.replace(regexReplaceNP1C, bOne))
    strAdditionP1zMC.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1zMC.length, exExFlag)
    strAdditionP1zMC.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1zMC.length, exExFlag)
    strAdditionP1zMC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1zMC.length, exExFlag)

    val strAdditionP1z42 = SpannableString(" NEWPERSONGOTHRAM2 கோத்ரா அஸ்மத் BORNORDER2 NEWRELATION2 NEWNAME2")
    val regexReplaceNP42 = """(NEWPERSONGOTHRAM2)""".toRegex()
    val strAdditionP1z32 = SpannableString(strAdditionP1z42.replace(regexReplaceNP42, gtTwo))
    val regexReplaceNP32 = """(NEWRELATION2)""".toRegex()
    val strAdditionP1z22 = SpannableString(strAdditionP1z32.replace(regexReplaceNP32, reTwo))
    val regexReplaceNP22 = """(NEWNAME2)""".toRegex()
    val strAdditionP1z12 = SpannableString(strAdditionP1z22.replace(regexReplaceNP22, nTwo))
    val regexReplaceNP12 = """(BORNORDER2)""".toRegex()
    strAdditionP2zM = SpannableString(strAdditionP1z12.replace(regexReplaceNP12, bTwo))
    strAdditionP2zM.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP2zM.length, exExFlag)
    strAdditionP2zM.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP2zM.length, exExFlag)
    strAdditionP2zM.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP2zM.length, exExFlag)

    val strAdditionP1z42B = SpannableString(" NEWPERSONGOTHRAM2 கோத்ரா அஸ்மத் BORNORDER2 NEWRELATION2 NEWNAME2")
    val regexReplaceNP42B = """(NEWPERSONGOTHRAM2)""".toRegex()
    val strAdditionP1z32B = SpannableString(strAdditionP1z42B.replace(regexReplaceNP42B, gtTwo))
    val regexReplaceNP32B = """(NEWRELATION2)""".toRegex()
    val strAdditionP1z22B = SpannableString(strAdditionP1z32B.replace(regexReplaceNP32B, reTwo))
    val regexReplaceNP22B = """(NEWNAME2)""".toRegex()
    val strAdditionP1z12B = SpannableString(strAdditionP1z22B.replace(regexReplaceNP22B, nTwo))
    val regexReplaceNP12B = """(BORNORDER2)""".toRegex()
    strAdditionP2zMB = SpannableString(strAdditionP1z12B.replace(regexReplaceNP12B, bTwo))
    strAdditionP2zMB.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP2zMB.length, exExFlag)
    strAdditionP2zMB.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP2zMB.length, exExFlag)
    strAdditionP2zMB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP2zMB.length, exExFlag)

    val strAdditionP1z42C = SpannableString(" NEWPERSONGOTHRAM2 கோத்ரா அஸ்மத் BORNORDER2 NEWRELATION2 NEWNAME2")
    val regexReplaceNP42C = """(NEWPERSONGOTHRAM2)""".toRegex()
    val strAdditionP1z32C = SpannableString(strAdditionP1z42C.replace(regexReplaceNP42C, gtTwo))
    val regexReplaceNP32C = """(NEWRELATION2)""".toRegex()
    val strAdditionP1z22C = SpannableString(strAdditionP1z32C.replace(regexReplaceNP32C, reTwo))
    val regexReplaceNP22C = """(NEWNAME2)""".toRegex()
    val strAdditionP1z12C = SpannableString(strAdditionP1z22C.replace(regexReplaceNP22C, nTwo))
    val regexReplaceNP12C = """(BORNORDER2)""".toRegex()
    strAdditionP2zMC = SpannableString(strAdditionP1z12C.replace(regexReplaceNP12C, bTwo))
    strAdditionP2zMC.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP2zMC.length, exExFlag)
    strAdditionP2zMC.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP2zMC.length, exExFlag)
    strAdditionP2zMC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP2zMC.length, exExFlag)

    val strAdditionP1z43 = SpannableString(" NEWPERSONGOTHRAM3 கோத்ரா அஸ்மத் BORNORDER3 NEWRELATION3 NEWNAME3")
    val regexReplaceNP43 = """(NEWPERSONGOTHRAM3)""".toRegex()
    val strAdditionP1z33 = SpannableString(strAdditionP1z43.replace(regexReplaceNP43, gtThree))
    val regexReplaceNP33 = """(NEWRELATION3)""".toRegex()
    val strAdditionP1z23 = SpannableString(strAdditionP1z33.replace(regexReplaceNP33, reThree))
    val regexReplaceNP23 = """(NEWNAME3)""".toRegex()
    val strAdditionP1z13 = SpannableString(strAdditionP1z23.replace(regexReplaceNP23, nThree))
    val regexReplaceNP13 = """(BORNORDER3)""".toRegex()
    strAdditionP3zM = SpannableString(strAdditionP1z13.replace(regexReplaceNP13, bThree))
    strAdditionP3zM.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP3zM.length, exExFlag)
    strAdditionP3zM.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP3zM.length, exExFlag)
    strAdditionP3zM.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP3zM.length, exExFlag)

    val strAdditionP1z43B = SpannableString(" NEWPERSONGOTHRAM3 கோத்ரா அஸ்மத் BORNORDER3 NEWRELATION3 NEWNAME3")
    val regexReplaceNP43B = """(NEWPERSONGOTHRAM3)""".toRegex()
    val strAdditionP1z33B = SpannableString(strAdditionP1z43B.replace(regexReplaceNP43B, gtThree))
    val regexReplaceNP33B = """(NEWRELATION3)""".toRegex()
    val strAdditionP1z23B = SpannableString(strAdditionP1z33B.replace(regexReplaceNP33B, reThree))
    val regexReplaceNP23B = """(NEWNAME3)""".toRegex()
    val strAdditionP1z13B = SpannableString(strAdditionP1z23B.replace(regexReplaceNP23B, nThree))
    val regexReplaceNP13B = """(BORNORDER3)""".toRegex()
    strAdditionP3zMB = SpannableString(strAdditionP1z13B.replace(regexReplaceNP13B, bThree))
    strAdditionP3zMB.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP3zMB.length, exExFlag)
    strAdditionP3zMB.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP3zMB.length, exExFlag)
    strAdditionP3zMB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP3zMB.length, exExFlag)

    val strAdditionP1z43C = SpannableString(" NEWPERSONGOTHRAM3 கோத்ரா அஸ்மத் BORNORDER3 NEWRELATION3 NEWNAME3")
    val regexReplaceNP43C = """(NEWPERSONGOTHRAM3)""".toRegex()
    val strAdditionP1z33C = SpannableString(strAdditionP1z43C.replace(regexReplaceNP43C, gtThree))
    val regexReplaceNP33C = """(NEWRELATION3)""".toRegex()
    val strAdditionP1z23C = SpannableString(strAdditionP1z33C.replace(regexReplaceNP33C, reThree))
    val regexReplaceNP23C = """(NEWNAME3)""".toRegex()
    val strAdditionP1z13C = SpannableString(strAdditionP1z23C.replace(regexReplaceNP23C, nThree))
    val regexReplaceNP13C = """(BORNORDER3)""".toRegex()
    strAdditionP3zMC = SpannableString(strAdditionP1z13C.replace(regexReplaceNP13C, bThree))
    strAdditionP3zMC.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP3zMC.length, exExFlag)
    strAdditionP3zMC.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP3zMC.length, exExFlag)
    strAdditionP3zMC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP3zMC.length, exExFlag)

    val strAdditionP1z44 = SpannableString(" NEWPERSONGOTHRAM4 கோத்ரா அஸ்மத் BORNORDER4 NEWRELATION4 NEWNAME4")
    val regexReplaceNP44 = """(NEWPERSONGOTHRAM4)""".toRegex()
    val strAdditionP1z34 = SpannableString(strAdditionP1z44.replace(regexReplaceNP44, gtFour))
    val regexReplaceNP34 = """(NEWRELATION4)""".toRegex()
    val strAdditionP1z24 = SpannableString(strAdditionP1z34.replace(regexReplaceNP34, reFour))
    val regexReplaceNP24 = """(NEWNAME4)""".toRegex()
    val strAdditionP1z14 = SpannableString(strAdditionP1z24.replace(regexReplaceNP24, nFour))
    val regexReplaceNP14 = """(BORNORDER4)""".toRegex()
    strAdditionP4zM = SpannableString(strAdditionP1z14.replace(regexReplaceNP14, bFour))
    strAdditionP4zM.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP4zM.length, exExFlag)
    strAdditionP4zM.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP4zM.length, exExFlag)
    strAdditionP4zM.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP4zM.length, exExFlag)

    val strAdditionP1z44B = SpannableString(" NEWPERSONGOTHRAM4 கோத்ரா அஸ்மத் BORNORDER4 NEWRELATION4 NEWNAME4")
    val regexReplaceNP44B = """(NEWPERSONGOTHRAM4)""".toRegex()
    val strAdditionP1z34B = SpannableString(strAdditionP1z44B.replace(regexReplaceNP44B, gtFour))
    val regexReplaceNP34B = """(NEWRELATION4)""".toRegex()
    val strAdditionP1z24B = SpannableString(strAdditionP1z34B.replace(regexReplaceNP34B, reFour))
    val regexReplaceNP24B = """(NEWNAME4)""".toRegex()
    val strAdditionP1z14B = SpannableString(strAdditionP1z24B.replace(regexReplaceNP24B, nFour))
    val regexReplaceNP14B = """(BORNORDER4)""".toRegex()
    strAdditionP4zMB = SpannableString(strAdditionP1z14B.replace(regexReplaceNP14B, bFour))
    strAdditionP4zMB.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP4zMB.length, exExFlag)
    strAdditionP4zMB.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP4zMB.length, exExFlag)
    strAdditionP4zMB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP4zMB.length, exExFlag)

    val strAdditionP1z44C = SpannableString(" NEWPERSONGOTHRAM4 கோத்ரா அஸ்மத் BORNORDER4 NEWRELATION4 NEWNAME4")
    val regexReplaceNP44C = """(NEWPERSONGOTHRAM4)""".toRegex()
    val strAdditionP1z34C = SpannableString(strAdditionP1z44C.replace(regexReplaceNP44C, gtFour))
    val regexReplaceNP34C = """(NEWRELATION4)""".toRegex()
    val strAdditionP1z24C = SpannableString(strAdditionP1z34C.replace(regexReplaceNP34C, reFour))
    val regexReplaceNP24C = """(NEWNAME4)""".toRegex()
    val strAdditionP1z14C = SpannableString(strAdditionP1z24C.replace(regexReplaceNP24C, nFour))
    val regexReplaceNP14C = """(BORNORDER4)""".toRegex()
    strAdditionP4zMC = SpannableString(strAdditionP1z14C.replace(regexReplaceNP14C, bFour))
    strAdditionP4zMC.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP4zMC.length, exExFlag)
    strAdditionP4zMC.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP4zMC.length, exExFlag)
    strAdditionP4zMC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP4zMC.length, exExFlag)

    val strAdditionP1z45 = SpannableString(" NEWPERSONGOTHRAM5 கோத்ரா அஸ்மத் BORNORDER5 NEWRELATION5 NEWNAME5")
    val regexReplaceNP45 = """(NEWPERSONGOTHRAM5)""".toRegex()
    val strAdditionP1z35 = SpannableString(strAdditionP1z45.replace(regexReplaceNP45, gtFive))
    val regexReplaceNP35 = """(NEWRELATION5)""".toRegex()
    val strAdditionP1z25 = SpannableString(strAdditionP1z35.replace(regexReplaceNP35, reFive))
    val regexReplaceNP25 = """(NEWNAME5)""".toRegex()
    val strAdditionP1z15 = SpannableString(strAdditionP1z25.replace(regexReplaceNP25, nFive))
    val regexReplaceNP15 = """(BORNORDER5)""".toRegex()
    strAdditionP5zM = SpannableString(strAdditionP1z15.replace(regexReplaceNP15, bFive))
    strAdditionP5zM.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP5zM.length, exExFlag)
    strAdditionP5zM.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP5zM.length, exExFlag)
    strAdditionP5zM.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP5zM.length, exExFlag)

    val strAdditionP1z45B = SpannableString(" NEWPERSONGOTHRAM5 கோத்ரா அஸ்மத் BORNORDER5 NEWRELATION5 NEWNAME5")
    val regexReplaceNP45B = """(NEWPERSONGOTHRAM5)""".toRegex()
    val strAdditionP1z35B = SpannableString(strAdditionP1z45B.replace(regexReplaceNP45B, gtFive))
    val regexReplaceNP35B = """(NEWRELATION5)""".toRegex()
    val strAdditionP1z25B = SpannableString(strAdditionP1z35B.replace(regexReplaceNP35B, reFive))
    val regexReplaceNP25B = """(NEWNAME5)""".toRegex()
    val strAdditionP1z15B = SpannableString(strAdditionP1z25B.replace(regexReplaceNP25B, nFive))
    val regexReplaceNP15B = """(BORNORDER5)""".toRegex()
    strAdditionP5zMB = SpannableString(strAdditionP1z15B.replace(regexReplaceNP15B, bFive))
    strAdditionP5zMB.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP5zMB.length, exExFlag)
    strAdditionP5zMB.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP5zMB.length, exExFlag)
    strAdditionP5zMB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP5zMB.length, exExFlag)

    val strAdditionP1z45C = SpannableString(" NEWPERSONGOTHRAM5 கோத்ரா அஸ்மத் BORNORDER5 NEWRELATION5 NEWNAME5")
    val regexReplaceNP45C = """(NEWPERSONGOTHRAM5)""".toRegex()
    val strAdditionP1z35C = SpannableString(strAdditionP1z45C.replace(regexReplaceNP45C, gtFive))
    val regexReplaceNP35C = """(NEWRELATION5)""".toRegex()
    val strAdditionP1z25C = SpannableString(strAdditionP1z35C.replace(regexReplaceNP35C, reFive))
    val regexReplaceNP25C = """(NEWNAME5)""".toRegex()
    val strAdditionP1z15C = SpannableString(strAdditionP1z25C.replace(regexReplaceNP25C, nFive))
    val regexReplaceNP15C = """(BORNORDER5)""".toRegex()
    strAdditionP5zMC = SpannableString(strAdditionP1z15C.replace(regexReplaceNP15C, bFive))
    strAdditionP5zMC.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP5zMC.length, exExFlag)
    strAdditionP5zMC.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP5zMC.length, exExFlag)
    strAdditionP5zMC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP5zMC.length, exExFlag)

    val strAdditionP1z46 = SpannableString(" NEWPERSONGOTHRAM6 கோத்ரா அஸ்மத் BORNORDER6 NEWRELATION6 NEWNAME6")
    val regexReplaceNP46 = """(NEWPERSONGOTHRAM6)""".toRegex()
    val strAdditionP1z36 = SpannableString(strAdditionP1z46.replace(regexReplaceNP46, gtSix))
    val regexReplaceNP36 = """(NEWRELATION6)""".toRegex()
    val strAdditionP1z26 = SpannableString(strAdditionP1z36.replace(regexReplaceNP36, reSix))
    val regexReplaceNP26 = """(NEWNAME6)""".toRegex()
    val strAdditionP1z16 = SpannableString(strAdditionP1z26.replace(regexReplaceNP26, nSix))
    val regexReplaceNP16 = """(BORNORDER6)""".toRegex()
    strAdditionP6zM = SpannableString(strAdditionP1z16.replace(regexReplaceNP16, bSix))
    strAdditionP6zM.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP6zM.length, exExFlag)
    strAdditionP6zM.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP6zM.length, exExFlag)
    strAdditionP6zM.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP6zM.length, exExFlag)

    val strAdditionP1z46B = SpannableString(" NEWPERSONGOTHRAM6 கோத்ரா அஸ்மத் BORNORDER6 NEWRELATION6 NEWNAME6")
    val regexReplaceNP46B = """(NEWPERSONGOTHRAM6)""".toRegex()
    val strAdditionP1z36B = SpannableString(strAdditionP1z46B.replace(regexReplaceNP46B, gtSix))
    val regexReplaceNP36B = """(NEWRELATION6)""".toRegex()
    val strAdditionP1z26B = SpannableString(strAdditionP1z36B.replace(regexReplaceNP36B, reSix))
    val regexReplaceNP26B = """(NEWNAME6)""".toRegex()
    val strAdditionP1z16B = SpannableString(strAdditionP1z26B.replace(regexReplaceNP26B, nSix))
    val regexReplaceNP16B = """(BORNORDER6)""".toRegex()
    strAdditionP6zMB = SpannableString(strAdditionP1z16B.replace(regexReplaceNP16B, bSix))
    strAdditionP6zMB.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP6zMB.length, exExFlag)
    strAdditionP6zMB.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP6zMB.length, exExFlag)
    strAdditionP6zMB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP6zMB.length, exExFlag)

    val strAdditionP1z46C = SpannableString(" NEWPERSONGOTHRAM6 கோத்ரா அஸ்மத் BORNORDER6 NEWRELATION6 NEWNAME6")
    val regexReplaceNP46C = """(NEWPERSONGOTHRAM6)""".toRegex()
    val strAdditionP1z36C = SpannableString(strAdditionP1z46C.replace(regexReplaceNP46C, gtSix))
    val regexReplaceNP36C = """(NEWRELATION6)""".toRegex()
    val strAdditionP1z26C = SpannableString(strAdditionP1z36C.replace(regexReplaceNP36C, reSix))
    val regexReplaceNP26C = """(NEWNAME6)""".toRegex()
    val strAdditionP1z16C = SpannableString(strAdditionP1z26C.replace(regexReplaceNP26C, nSix))
    val regexReplaceNP16C = """(BORNORDER6)""".toRegex()
    strAdditionP6zMC = SpannableString(strAdditionP1z16C.replace(regexReplaceNP16C, bSix))
    strAdditionP6zMC.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP6zMC.length, exExFlag)
    strAdditionP6zMC.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP6zMC.length, exExFlag)
    strAdditionP6zMC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP6zMC.length, exExFlag)

    val strAdditionP1z47 = SpannableString(" NEWPERSONGOTHRAM7 கோத்ரா அஸ்மத் BORNORDER7 NEWRELATION7 NEWNAME7")
    val regexReplaceNP47 = """(NEWPERSONGOTHRAM7)""".toRegex()
    val strAdditionP1z37 = SpannableString(strAdditionP1z47.replace(regexReplaceNP47, gtSeven))
    val regexReplaceNP37 = """(NEWRELATION7)""".toRegex()
    val strAdditionP1z27 = SpannableString(strAdditionP1z37.replace(regexReplaceNP37, reSeven))
    val regexReplaceNP27 = """(NEWNAME7)""".toRegex()
    val strAdditionP1z17 = SpannableString(strAdditionP1z27.replace(regexReplaceNP27, nSeven))
    val regexReplaceNP17 = """(BORNORDER7)""".toRegex()
    strAdditionP7zM = SpannableString(strAdditionP1z17.replace(regexReplaceNP17, bSeven))
    strAdditionP7zM.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP7zM.length, exExFlag)
    strAdditionP7zM.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP7zM.length, exExFlag)
    strAdditionP7zM.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP7zM.length, exExFlag)

    val strAdditionP1z47B = SpannableString(" NEWPERSONGOTHRAM7 கோத்ரா அஸ்மத் BORNORDER7 NEWRELATION7 NEWNAME7")
    val regexReplaceNP47B = """(NEWPERSONGOTHRAM7)""".toRegex()
    val strAdditionP1z37B = SpannableString(strAdditionP1z47B.replace(regexReplaceNP47B, gtSeven))
    val regexReplaceNP37B = """(NEWRELATION7)""".toRegex()
    val strAdditionP1z27B = SpannableString(strAdditionP1z37B.replace(regexReplaceNP37B, reSeven))
    val regexReplaceNP27B = """(NEWNAME7)""".toRegex()
    val strAdditionP1z17B = SpannableString(strAdditionP1z27B.replace(regexReplaceNP27B, nSeven))
    val regexReplaceNP17B = """(BORNORDER7)""".toRegex()
    strAdditionP7zMB = SpannableString(strAdditionP1z17B.replace(regexReplaceNP17B, bSeven))
    strAdditionP7zMB.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP7zMB.length, exExFlag)
    strAdditionP7zMB.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP7zMB.length, exExFlag)
    strAdditionP7zMB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP7zMB.length, exExFlag)

    val strAdditionP1z47C = SpannableString(" NEWPERSONGOTHRAM7 கோத்ரா அஸ்மத் BORNORDER7 NEWRELATION7 NEWNAME7")
    val regexReplaceNP47C = """(NEWPERSONGOTHRAM7)""".toRegex()
    val strAdditionP1z37C = SpannableString(strAdditionP1z47C.replace(regexReplaceNP47C, gtSeven))
    val regexReplaceNP37C = """(NEWRELATION7)""".toRegex()
    val strAdditionP1z27C = SpannableString(strAdditionP1z37C.replace(regexReplaceNP37C, reSeven))
    val regexReplaceNP27C = """(NEWNAME7)""".toRegex()
    val strAdditionP1z17C = SpannableString(strAdditionP1z27C.replace(regexReplaceNP27C, nSeven))
    val regexReplaceNP17C = """(BORNORDER7)""".toRegex()
    strAdditionP7zMC = SpannableString(strAdditionP1z17C.replace(regexReplaceNP17C, bSeven))
    strAdditionP7zMC.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP7zMC.length, exExFlag)
    strAdditionP7zMC.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP7zMC.length, exExFlag)
    strAdditionP7zMC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP7zMC.length, exExFlag)

    val strAdditionP1z48 = SpannableString(" NEWPERSONGOTHRAM8 கோத்ரா அஸ்மத் BORNORDER8 NEWRELATION8 NEWNAME8")
    val regexReplaceNP48 = """(NEWPERSONGOTHRAM8)""".toRegex()
    val strAdditionP1z38 = SpannableString(strAdditionP1z48.replace(regexReplaceNP48, gtEight))
    val regexReplaceNP38 = """(NEWRELATION8)""".toRegex()
    val strAdditionP1z28 = SpannableString(strAdditionP1z38.replace(regexReplaceNP38, reEight))
    val regexReplaceNP28 = """(NEWNAME8)""".toRegex()
    val strAdditionP1z18 = SpannableString(strAdditionP1z28.replace(regexReplaceNP28, nEight))
    val regexReplaceNP18 = """(BORNORDER8)""".toRegex()
    strAdditionP8zM = SpannableString(strAdditionP1z18.replace(regexReplaceNP18, bEight))
    strAdditionP8zM.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP8zM.length, exExFlag)
    strAdditionP8zM.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP8zM.length, exExFlag)
    strAdditionP8zM.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP8zM.length, exExFlag)

    val strAdditionP1z48B = SpannableString(" NEWPERSONGOTHRAM8 கோத்ரா அஸ்மத் BORNORDER8 NEWRELATION8 NEWNAME8")
    val regexReplaceNP48B = """(NEWPERSONGOTHRAM8)""".toRegex()
    val strAdditionP1z38B = SpannableString(strAdditionP1z48B.replace(regexReplaceNP48B, gtEight))
    val regexReplaceNP38B = """(NEWRELATION8)""".toRegex()
    val strAdditionP1z28B = SpannableString(strAdditionP1z38B.replace(regexReplaceNP38B, reEight))
    val regexReplaceNP28B = """(NEWNAME8)""".toRegex()
    val strAdditionP1z18B = SpannableString(strAdditionP1z28B.replace(regexReplaceNP28B, nEight))
    val regexReplaceNP18B = """(BORNORDER8)""".toRegex()
    strAdditionP8zMB = SpannableString(strAdditionP1z18B.replace(regexReplaceNP18B, bEight))
    strAdditionP8zMB.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP8zMB.length, exExFlag)
    strAdditionP8zMB.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP8zMB.length, exExFlag)
    strAdditionP8zMB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP8zMB.length, exExFlag)

    val strAdditionP1z48C = SpannableString(" NEWPERSONGOTHRAM8 கோத்ரா அஸ்மத் BORNORDER8 NEWRELATION8 NEWNAME8")
    val regexReplaceNP48C = """(NEWPERSONGOTHRAM8)""".toRegex()
    val strAdditionP1z38C = SpannableString(strAdditionP1z48C.replace(regexReplaceNP48C, gtEight))
    val regexReplaceNP38C = """(NEWRELATION8)""".toRegex()
    val strAdditionP1z28C = SpannableString(strAdditionP1z38C.replace(regexReplaceNP38C, reEight))
    val regexReplaceNP28C = """(NEWNAME8)""".toRegex()
    val strAdditionP1z18C = SpannableString(strAdditionP1z28C.replace(regexReplaceNP28C, nEight))
    val regexReplaceNP18C = """(BORNORDER8)""".toRegex()
    strAdditionP8zMC = SpannableString(strAdditionP1z18C.replace(regexReplaceNP18C, bEight))
    strAdditionP8zMC.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP8zMC.length, exExFlag)
    strAdditionP8zMC.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP8zMC.length, exExFlag)
    strAdditionP8zMC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP8zMC.length, exExFlag)

    val strAdditionP1z49 = SpannableString(" NEWPERSONGOTHRAM9 கோத்ரா அஸ்மத் BORNORDER9 NEWRELATION9 NEWNAME9")
    val regexReplaceNP49 = """(NEWPERSONGOTHRAM9)""".toRegex()
    val strAdditionP1z39 = SpannableString(strAdditionP1z49.replace(regexReplaceNP49, gtNine))
    val regexReplaceNP39 = """(NEWRELATION9)""".toRegex()
    val strAdditionP1z29 = SpannableString(strAdditionP1z39.replace(regexReplaceNP39, reNine))
    val regexReplaceNP29 = """(NEWNAME9)""".toRegex()
    val strAdditionP1z19 = SpannableString(strAdditionP1z29.replace(regexReplaceNP29, nNine))
    val regexReplaceNP19 = """(BORNORDER9)""".toRegex()
    strAdditionP9zM = SpannableString(strAdditionP1z19.replace(regexReplaceNP19, bNine))
    strAdditionP9zM.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP9zM.length, exExFlag)
    strAdditionP9zM.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP9zM.length, exExFlag)
    strAdditionP9zM.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP9zM.length, exExFlag)

    val strAdditionP1z49B = SpannableString(" NEWPERSONGOTHRAM9 கோத்ரா அஸ்மத் BORNORDER9 NEWRELATION9 NEWNAME9")
    val regexReplaceNP49B = """(NEWPERSONGOTHRAM9)""".toRegex()
    val strAdditionP1z39B = SpannableString(strAdditionP1z49B.replace(regexReplaceNP49B, gtNine))
    val regexReplaceNP39B = """(NEWRELATION9)""".toRegex()
    val strAdditionP1z29B = SpannableString(strAdditionP1z39B.replace(regexReplaceNP39B, reNine))
    val regexReplaceNP29B = """(NEWNAME9)""".toRegex()
    val strAdditionP1z19B = SpannableString(strAdditionP1z29B.replace(regexReplaceNP29B, nNine))
    val regexReplaceNP19B = """(BORNORDER9)""".toRegex()
    strAdditionP9zMB = SpannableString(strAdditionP1z19B.replace(regexReplaceNP19B, bNine))
    strAdditionP9zMB.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP9zMB.length, exExFlag)
    strAdditionP9zMB.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP9zMB.length, exExFlag)
    strAdditionP9zMB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP9zMB.length, exExFlag)

    val strAdditionP1z49C = SpannableString(" NEWPERSONGOTHRAM9 கோத்ரா அஸ்மத் BORNORDER9 NEWRELATION9 NEWNAME9")
    val regexReplaceNP49C = """(NEWPERSONGOTHRAM9)""".toRegex()
    val strAdditionP1z39C = SpannableString(strAdditionP1z49C.replace(regexReplaceNP49C, gtNine))
    val regexReplaceNP39C = """(NEWRELATION9)""".toRegex()
    val strAdditionP1z29C = SpannableString(strAdditionP1z39C.replace(regexReplaceNP39C, reNine))
    val regexReplaceNP29C = """(NEWNAME9)""".toRegex()
    val strAdditionP1z19C = SpannableString(strAdditionP1z29C.replace(regexReplaceNP29C, nNine))
    val regexReplaceNP19C = """(BORNORDER9)""".toRegex()
    strAdditionP9zMC = SpannableString(strAdditionP1z19C.replace(regexReplaceNP19C, bNine))
    strAdditionP9zMC.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP9zMC.length, exExFlag)
    strAdditionP9zMC.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP9zMC.length, exExFlag)
    strAdditionP9zMC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP9zMC.length, exExFlag)

    val strAdditionP1z410 = SpannableString(" NEWPERSONGOTHRAM10 கோத்ரா அஸ்மத் BORNORDER10 NEWRELATION10 NEWNAME10")
    val regexReplaceNP410 = """(NEWPERSONGOTHRAM10)""".toRegex()
    val strAdditionP1z310 = SpannableString(strAdditionP1z410.replace(regexReplaceNP410, gtTen))
    val regexReplaceNP310 = """(NEWRELATION10)""".toRegex()
    val strAdditionP1z210 = SpannableString(strAdditionP1z310.replace(regexReplaceNP310, reTen))
    val regexReplaceNP210 = """(NEWNAME10)""".toRegex()
    val strAdditionP1z110 = SpannableString(strAdditionP1z210.replace(regexReplaceNP210, nTen))
    val regexReplaceNP110 = """(BORNORDER10)""".toRegex()
    strAdditionP10zM = SpannableString(strAdditionP1z110.replace(regexReplaceNP110, bTen))
    strAdditionP10zM.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP10zM.length, exExFlag)
    strAdditionP10zM.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP10zM.length, exExFlag)
    strAdditionP10zM.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP10zM.length, exExFlag)

    val strAdditionP1z410B = SpannableString(" NEWPERSONGOTHRAM10 கோத்ரா அஸ்மத் BORNORDER10 NEWRELATION10 NEWNAME10")
    val regexReplaceNP410B = """(NEWPERSONGOTHRAM10)""".toRegex()
    val strAdditionP1z310B = SpannableString(strAdditionP1z410B.replace(regexReplaceNP410B, gtTen))
    val regexReplaceNP310B = """(NEWRELATION10)""".toRegex()
    val strAdditionP1z210B = SpannableString(strAdditionP1z310B.replace(regexReplaceNP310B, reTen))
    val regexReplaceNP210B = """(NEWNAME10)""".toRegex()
    val strAdditionP1z110B = SpannableString(strAdditionP1z210B.replace(regexReplaceNP210B, nTen))
    val regexReplaceNP110B = """(BORNORDER10)""".toRegex()
    strAdditionP10zMB = SpannableString(strAdditionP1z110B.replace(regexReplaceNP110B, bTen))
    strAdditionP10zMB.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP10zMB.length, exExFlag)
    strAdditionP10zMB.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP10zMB.length, exExFlag)
    strAdditionP10zMB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP10zMB.length, exExFlag)

    val strAdditionP1z410C = SpannableString(" NEWPERSONGOTHRAM10 கோத்ரா அஸ்மத் BORNORDER10 NEWRELATION10 NEWNAME10")
    val regexReplaceNP410C = """(NEWPERSONGOTHRAM10)""".toRegex()
    val strAdditionP1z310C = SpannableString(strAdditionP1z410C.replace(regexReplaceNP410C, gtTen))
    val regexReplaceNP310C = """(NEWRELATION10)""".toRegex()
    val strAdditionP1z210C = SpannableString(strAdditionP1z310C.replace(regexReplaceNP310C, reTen))
    val regexReplaceNP210C = """(NEWNAME10)""".toRegex()
    val strAdditionP1z110C = SpannableString(strAdditionP1z210C.replace(regexReplaceNP210C, nTen))
    val regexReplaceNP110C = """(BORNORDER10)""".toRegex()
    strAdditionP10zMC = SpannableString(strAdditionP1z110C.replace(regexReplaceNP110C, bTen))
    strAdditionP10zMC.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP10zMC.length, exExFlag)
    strAdditionP10zMC.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP10zMC.length, exExFlag)
    strAdditionP10zMC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP10zMC.length, exExFlag)

    val strAdditionP1z411 = SpannableString(" NEWPERSONGOTHRAM11 கோத்ரா அஸ்மத் BORNORDER11 NEWRELATION11 NEWNAME11")
    val regexReplaceNP411 = """(NEWPERSONGOTHRAM11)""".toRegex()
    val strAdditionP1z311 = SpannableString(strAdditionP1z411.replace(regexReplaceNP411, gtEleven))
    val regexReplaceNP311 = """(NEWRELATION11)""".toRegex()
    val strAdditionP1z211 = SpannableString(strAdditionP1z311.replace(regexReplaceNP311, reEleven))
    val regexReplaceNP211 = """(NEWNAME11)""".toRegex()
    val strAdditionP1z111 = SpannableString(strAdditionP1z211.replace(regexReplaceNP211, nEleven))
    val regexReplaceNP111 = """(BORNORDER11)""".toRegex()
    strAdditionP11zM = SpannableString(strAdditionP1z111.replace(regexReplaceNP111, bEleven))
    strAdditionP11zM.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP11zM.length, exExFlag)
    strAdditionP11zM.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP11zM.length, exExFlag)
    strAdditionP11zM.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP11zM.length, exExFlag)

    val strAdditionP1z411B = SpannableString(" NEWPERSONGOTHRAM11 கோத்ரா அஸ்மத் BORNORDER11 NEWRELATION11 NEWNAME11")
    val regexReplaceNP411B = """(NEWPERSONGOTHRAM11)""".toRegex()
    val strAdditionP1z311B = SpannableString(strAdditionP1z411B.replace(regexReplaceNP411B, gtEleven))
    val regexReplaceNP311B = """(NEWRELATION11)""".toRegex()
    val strAdditionP1z211B = SpannableString(strAdditionP1z311B.replace(regexReplaceNP311B, reEleven))
    val regexReplaceNP211B = """(NEWNAME11)""".toRegex()
    val strAdditionP1z111B = SpannableString(strAdditionP1z211B.replace(regexReplaceNP211B, nEleven))
    val regexReplaceNP111B = """(BORNORDER11)""".toRegex()
    strAdditionP11zMB = SpannableString(strAdditionP1z111B.replace(regexReplaceNP111B, bEleven))
    strAdditionP11zMB.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP11zMB.length, exExFlag)
    strAdditionP11zMB.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP11zMB.length, exExFlag)
    strAdditionP11zMB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP11zMB.length, exExFlag)

    val strAdditionP1z411C = SpannableString(" NEWPERSONGOTHRAM11 கோத்ரா அஸ்மத் BORNORDER11 NEWRELATION11 NEWNAME11")
    val regexReplaceNP411C = """(NEWPERSONGOTHRAM11)""".toRegex()
    val strAdditionP1z311C = SpannableString(strAdditionP1z411C.replace(regexReplaceNP411C, gtEleven))
    val regexReplaceNP311C = """(NEWRELATION11)""".toRegex()
    val strAdditionP1z211C = SpannableString(strAdditionP1z311C.replace(regexReplaceNP311C, reEleven))
    val regexReplaceNP211C = """(NEWNAME11)""".toRegex()
    val strAdditionP1z111C = SpannableString(strAdditionP1z211C.replace(regexReplaceNP211C, nEleven))
    val regexReplaceNP111C = """(BORNORDER11)""".toRegex()
    strAdditionP11zMC = SpannableString(strAdditionP1z111C.replace(regexReplaceNP111C, bEleven))
    strAdditionP11zMC.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP11zMC.length, exExFlag)
    strAdditionP11zMC.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP11zMC.length, exExFlag)
    strAdditionP11zMC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP11zMC.length, exExFlag)

    val strAdditionP1z412 = SpannableString(" NEWPERSONGOTHRAM12 கோத்ரா அஸ்மத் BORNORDER12 NEWRELATION12 NEWNAME12")
    val regexReplaceNP412 = """(NEWPERSONGOTHRAM12)""".toRegex()
    val strAdditionP1z312 = SpannableString(strAdditionP1z412.replace(regexReplaceNP412, gtTwelve))
    val regexReplaceNP312 = """(NEWRELATION12)""".toRegex()
    val strAdditionP1z212 = SpannableString(strAdditionP1z312.replace(regexReplaceNP312, reTwelve))
    val regexReplaceNP212 = """(NEWNAME12)""".toRegex()
    val strAdditionP1z112 = SpannableString(strAdditionP1z212.replace(regexReplaceNP212, nTwelve))
    val regexReplaceNP112 = """(BORNORDER12)""".toRegex()
    strAdditionP12zM = SpannableString(strAdditionP1z112.replace(regexReplaceNP112, bTwelve))
    strAdditionP12zM.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP12zM.length, exExFlag)
    strAdditionP12zM.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP12zM.length, exExFlag)
    strAdditionP12zM.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP12zM.length, exExFlag)

    val strAdditionP1z412B = SpannableString(" NEWPERSONGOTHRAM12 கோத்ரா அஸ்மத் BORNORDER12 NEWRELATION12 NEWNAME12")
    val regexReplaceNP412B = """(NEWPERSONGOTHRAM12)""".toRegex()
    val strAdditionP1z312B = SpannableString(strAdditionP1z412B.replace(regexReplaceNP412B, gtTwelve))
    val regexReplaceNP312B = """(NEWRELATION12)""".toRegex()
    val strAdditionP1z212B = SpannableString(strAdditionP1z312B.replace(regexReplaceNP312B, reTwelve))
    val regexReplaceNP212B = """(NEWNAME12)""".toRegex()
    val strAdditionP1z112B = SpannableString(strAdditionP1z212B.replace(regexReplaceNP212B, nTwelve))
    val regexReplaceNP112B = """(BORNORDER12)""".toRegex()
    strAdditionP12zMB = SpannableString(strAdditionP1z112B.replace(regexReplaceNP112B, bTwelve))
    strAdditionP12zMB.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP12zMB.length, exExFlag)
    strAdditionP12zMB.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP12zMB.length, exExFlag)
    strAdditionP12zMB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP12zMB.length, exExFlag)

    val strAdditionP1z412C = SpannableString(" NEWPERSONGOTHRAM12 கோத்ரா அஸ்மத் BORNORDER12 NEWRELATION12 NEWNAME12")
    val regexReplaceNP412C = """(NEWPERSONGOTHRAM12)""".toRegex()
    val strAdditionP1z312C = SpannableString(strAdditionP1z412C.replace(regexReplaceNP412C, gtTwelve))
    val regexReplaceNP312C = """(NEWRELATION12)""".toRegex()
    val strAdditionP1z212C = SpannableString(strAdditionP1z312C.replace(regexReplaceNP312C, reTwelve))
    val regexReplaceNP212C = """(NEWNAME12)""".toRegex()
    val strAdditionP1z112C = SpannableString(strAdditionP1z212C.replace(regexReplaceNP212C, nTwelve))
    val regexReplaceNP112C = """(BORNORDER12)""".toRegex()
    strAdditionP12zMC = SpannableString(strAdditionP1z112C.replace(regexReplaceNP112C, bTwelve))
    strAdditionP12zMC.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP12zMC.length, exExFlag)
    strAdditionP12zMC.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP12zMC.length, exExFlag)
    strAdditionP12zMC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP12zMC.length, exExFlag)

    val strAdditionP1z413 = SpannableString(" NEWPERSONGOTHRAM13 கோத்ரா அஸ்மத் BORNORDER13 NEWRELATION13 NEWNAME13")
    val regexReplaceNP413 = """(NEWPERSONGOTHRAM13)""".toRegex()
    val strAdditionP1z313 = SpannableString(strAdditionP1z413.replace(regexReplaceNP413, gtThirteen))
    val regexReplaceNP313 = """(NEWRELATION13)""".toRegex()
    val strAdditionP1z213 = SpannableString(strAdditionP1z313.replace(regexReplaceNP313, reThirteen))
    val regexReplaceNP213 = """(NEWNAME13)""".toRegex()
    val strAdditionP1z113 = SpannableString(strAdditionP1z213.replace(regexReplaceNP213, nThirteen))
    val regexReplaceNP113 = """(BORNORDER13)""".toRegex()
    strAdditionP13zM = SpannableString(strAdditionP1z113.replace(regexReplaceNP113, bThirteen))
    strAdditionP13zM.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP13zM.length, exExFlag)
    strAdditionP13zM.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP13zM.length, exExFlag)
    strAdditionP13zM.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP13zM.length, exExFlag)

    val strAdditionP1z413B = SpannableString(" NEWPERSONGOTHRAM13 கோத்ரா அஸ்மத் BORNORDER13 NEWRELATION13 NEWNAME13")
    val regexReplaceNP413B = """(NEWPERSONGOTHRAM13)""".toRegex()
    val strAdditionP1z313B = SpannableString(strAdditionP1z413B.replace(regexReplaceNP413B, gtThirteen))
    val regexReplaceNP313B = """(NEWRELATION13)""".toRegex()
    val strAdditionP1z213B = SpannableString(strAdditionP1z313B.replace(regexReplaceNP313B, reThirteen))
    val regexReplaceNP213B = """(NEWNAME13)""".toRegex()
    val strAdditionP1z113B = SpannableString(strAdditionP1z213B.replace(regexReplaceNP213B, nThirteen))
    val regexReplaceNP113B = """(BORNORDER13)""".toRegex()
    strAdditionP13zMB = SpannableString(strAdditionP1z113B.replace(regexReplaceNP113B, bThirteen))
    strAdditionP13zMB.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP13zMB.length, exExFlag)
    strAdditionP13zMB.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP13zMB.length, exExFlag)
    strAdditionP13zMB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP13zMB.length, exExFlag)

    val strAdditionP1z413C = SpannableString(" NEWPERSONGOTHRAM13 கோத்ரா அஸ்மத் BORNORDER13 NEWRELATION13 NEWNAME13")
    val regexReplaceNP413C = """(NEWPERSONGOTHRAM13)""".toRegex()
    val strAdditionP1z313C = SpannableString(strAdditionP1z413C.replace(regexReplaceNP413C, gtThirteen))
    val regexReplaceNP313C = """(NEWRELATION13)""".toRegex()
    val strAdditionP1z213C = SpannableString(strAdditionP1z313C.replace(regexReplaceNP313C, reThirteen))
    val regexReplaceNP213C = """(NEWNAME13)""".toRegex()
    val strAdditionP1z113C = SpannableString(strAdditionP1z213C.replace(regexReplaceNP213C, nThirteen))
    val regexReplaceNP113C = """(BORNORDER13)""".toRegex()
    strAdditionP13zMC = SpannableString(strAdditionP1z113C.replace(regexReplaceNP113C, bThirteen))
    strAdditionP13zMC.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP13zMC.length, exExFlag)
    strAdditionP13zMC.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP13zMC.length, exExFlag)
    strAdditionP13zMC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP13zMC.length, exExFlag)

    val strAdditionP1z414 = SpannableString(" NEWPERSONGOTHRAM14 கோத்ரா அஸ்மத் BORNORDER14 NEWRELATION14 NEWNAME14")
    val regexReplaceNP414 = """(NEWPERSONGOTHRAM14)""".toRegex()
    val strAdditionP1z314 = SpannableString(strAdditionP1z414.replace(regexReplaceNP414, gtFourteen))
    val regexReplaceNP314 = """(NEWRELATION14)""".toRegex()
    val strAdditionP1z214 = SpannableString(strAdditionP1z314.replace(regexReplaceNP314, reFourteen))
    val regexReplaceNP214 = """(NEWNAME14)""".toRegex()
    val strAdditionP1z114 = SpannableString(strAdditionP1z214.replace(regexReplaceNP214, nFourteen))
    val regexReplaceNP114 = """(BORNORDER14)""".toRegex()
    strAdditionP14zM = SpannableString(strAdditionP1z114.replace(regexReplaceNP114, bFourteen))
    strAdditionP14zM.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP14zM.length, exExFlag)
    strAdditionP14zM.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP14zM.length, exExFlag)
    strAdditionP14zM.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP14zM.length, exExFlag)

    val strAdditionP1z414B = SpannableString(" NEWPERSONGOTHRAM14 கோத்ரா அஸ்மத் BORNORDER14 NEWRELATION14 NEWNAME14")
    val regexReplaceNP414B = """(NEWPERSONGOTHRAM14)""".toRegex()
    val strAdditionP1z314B = SpannableString(strAdditionP1z414B.replace(regexReplaceNP414B, gtFourteen))
    val regexReplaceNP314B = """(NEWRELATION14)""".toRegex()
    val strAdditionP1z214B = SpannableString(strAdditionP1z314B.replace(regexReplaceNP314B, reFourteen))
    val regexReplaceNP214B = """(NEWNAME14)""".toRegex()
    val strAdditionP1z114B = SpannableString(strAdditionP1z214B.replace(regexReplaceNP214B, nFourteen))
    val regexReplaceNP114B = """(BORNORDER14)""".toRegex()
    strAdditionP14zMB = SpannableString(strAdditionP1z114B.replace(regexReplaceNP114B, bFourteen))
    strAdditionP14zMB.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP14zMB.length, exExFlag)
    strAdditionP14zMB.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP14zMB.length, exExFlag)
    strAdditionP14zMB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP14zMB.length, exExFlag)

    val strAdditionP1z414C = SpannableString(" NEWPERSONGOTHRAM14 கோத்ரா அஸ்மத் BORNORDER14 NEWRELATION14 NEWNAME14")
    val regexReplaceNP414C = """(NEWPERSONGOTHRAM14)""".toRegex()
    val strAdditionP1z314C = SpannableString(strAdditionP1z414C.replace(regexReplaceNP414C, gtFourteen))
    val regexReplaceNP314C = """(NEWRELATION14)""".toRegex()
    val strAdditionP1z214C = SpannableString(strAdditionP1z314C.replace(regexReplaceNP314C, reFourteen))
    val regexReplaceNP214C = """(NEWNAME14)""".toRegex()
    val strAdditionP1z114C = SpannableString(strAdditionP1z214C.replace(regexReplaceNP214C, nFourteen))
    val regexReplaceNP114C = """(BORNORDER14)""".toRegex()
    strAdditionP14zMC = SpannableString(strAdditionP1z114C.replace(regexReplaceNP114C, bFourteen))
    strAdditionP14zMC.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP14zMC.length, exExFlag)
    strAdditionP14zMC.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP14zMC.length, exExFlag)
    strAdditionP14zMC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP14zMC.length, exExFlag)

    val strAdditionP1z415 = SpannableString(" NEWPERSONGOTHRAM15 கோத்ரா அஸ்மத் BORNORDER15 NEWRELATION15 NEWNAME15")
    val regexReplaceNP415 = """(NEWPERSONGOTHRAM15)""".toRegex()
    val strAdditionP1z315 = SpannableString(strAdditionP1z415.replace(regexReplaceNP415, gtFifteen))
    val regexReplaceNP315 = """(NEWRELATION15)""".toRegex()
    val strAdditionP1z215 = SpannableString(strAdditionP1z315.replace(regexReplaceNP315, reFifteen))
    val regexReplaceNP215 = """(NEWNAME15)""".toRegex()
    val strAdditionP1z115 = SpannableString(strAdditionP1z215.replace(regexReplaceNP215, nFifteen))
    val regexReplaceNP115 = """(BORNORDER15)""".toRegex()
    strAdditionP15zM = SpannableString(strAdditionP1z115.replace(regexReplaceNP115, bFifteen))
    strAdditionP15zM.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP15zM.length, exExFlag)
    strAdditionP15zM.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP15zM.length, exExFlag)
    strAdditionP15zM.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP15zM.length, exExFlag)

    val strAdditionP1z415B = SpannableString(" NEWPERSONGOTHRAM15 கோத்ரா அஸ்மத் BORNORDER15 NEWRELATION15 NEWNAME15")
    val regexReplaceNP415B = """(NEWPERSONGOTHRAM15)""".toRegex()
    val strAdditionP1z315B = SpannableString(strAdditionP1z415B.replace(regexReplaceNP415B, gtFifteen))
    val regexReplaceNP315B = """(NEWRELATION15)""".toRegex()
    val strAdditionP1z215B = SpannableString(strAdditionP1z315B.replace(regexReplaceNP315B, reFifteen))
    val regexReplaceNP215B = """(NEWNAME15)""".toRegex()
    val strAdditionP1z115B = SpannableString(strAdditionP1z215B.replace(regexReplaceNP215B, nFifteen))
    val regexReplaceNP115B = """(BORNORDER15)""".toRegex()
    strAdditionP15zMB = SpannableString(strAdditionP1z115B.replace(regexReplaceNP115B, bFifteen))
    strAdditionP15zMB.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP15zMB.length, exExFlag)
    strAdditionP15zMB.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP15zMB.length, exExFlag)
    strAdditionP15zMB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP15zMB.length, exExFlag)

    val strAdditionP1z415C = SpannableString(" NEWPERSONGOTHRAM15 கோத்ரா அஸ்மத் BORNORDER15 NEWRELATION15 NEWNAME15")
    val regexReplaceNP415C = """(NEWPERSONGOTHRAM15)""".toRegex()
    val strAdditionP1z315C = SpannableString(strAdditionP1z415C.replace(regexReplaceNP415C, gtFifteen))
    val regexReplaceNP315C = """(NEWRELATION15)""".toRegex()
    val strAdditionP1z215C = SpannableString(strAdditionP1z315C.replace(regexReplaceNP315C, reFifteen))
    val regexReplaceNP215C = """(NEWNAME15)""".toRegex()
    val strAdditionP1z115C = SpannableString(strAdditionP1z215C.replace(regexReplaceNP215C, nFifteen))
    val regexReplaceNP115C = """(BORNORDER15)""".toRegex()
    strAdditionP15zMC = SpannableString(strAdditionP1z115C.replace(regexReplaceNP115C, bFifteen))
    strAdditionP15zMC.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP15zMC.length, exExFlag)
    strAdditionP15zMC.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP15zMC.length, exExFlag)
    strAdditionP15zMC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP15zMC.length, exExFlag)

    strAdditionP1aA1 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aA1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aA1.length, exExFlag)
    strAdditionP1aA1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aA1.length, exExFlag)
    strAdditionP1aA1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aA1.length, exExFlag)

    strAdditionP1aA2 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aA2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aA2.length, exExFlag)
    strAdditionP1aA2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aA2.length, exExFlag)
    strAdditionP1aA2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aA2.length, exExFlag)

    strAdditionP1aA3 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aA3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aA3.length, exExFlag)
    strAdditionP1aA3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aA3.length, exExFlag)
    strAdditionP1aA3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aA3.length, exExFlag)

    strAdditionP1aB1 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aB1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aB1.length, exExFlag)
    strAdditionP1aB1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aB1.length, exExFlag)
    strAdditionP1aB1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aB1.length, exExFlag)

    strAdditionP1aB2 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aB2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aB2.length, exExFlag)
    strAdditionP1aB2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aB2.length, exExFlag)
    strAdditionP1aB2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aB2.length, exExFlag)

    strAdditionP1aC1 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aC1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aC1.length, exExFlag)
    strAdditionP1aC1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aC1.length, exExFlag)
    strAdditionP1aC1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aC1.length, exExFlag)

    strAdditionP1aC2 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aC2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aC2.length, exExFlag)
    strAdditionP1aC2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aC2.length, exExFlag)
    strAdditionP1aC2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aC2.length, exExFlag)

    strAdditionP1aC3 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aC3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aC3.length, exExFlag)
    strAdditionP1aC3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aC3.length, exExFlag)
    strAdditionP1aC3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aC3.length, exExFlag)

    strAdditionP1aD1 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aD1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aD1.length, exExFlag)
    strAdditionP1aD1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aD1.length, exExFlag)
    strAdditionP1aD1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aD1.length, exExFlag)

    strAdditionP1aD2 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aD2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aD2.length, exExFlag)
    strAdditionP1aD2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aD2.length, exExFlag)
    strAdditionP1aD2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aD2.length, exExFlag)

    strAdditionP1aD3 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aD3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aD3.length, exExFlag)
    strAdditionP1aD3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aD3.length, exExFlag)
    strAdditionP1aD3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aD3.length, exExFlag)

    strAdditionP1aE1 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aE1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aE1.length, exExFlag)
    strAdditionP1aE1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aE1.length, exExFlag)
    strAdditionP1aE1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aE1.length, exExFlag)

    strAdditionP1aE2 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aE2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aE2.length, exExFlag)
    strAdditionP1aE2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aE2.length, exExFlag)
    strAdditionP1aE2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aE2.length, exExFlag)

    strAdditionP1aE3 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aE3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aE3.length, exExFlag)
    strAdditionP1aE3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aE3.length, exExFlag)
    strAdditionP1aE3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aE3.length, exExFlag)

    strAdditionP1aF1 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aF1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aF1.length, exExFlag)
    strAdditionP1aF1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aF1.length, exExFlag)
    strAdditionP1aF1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aF1.length, exExFlag)

    strAdditionP1aF2 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aF2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aF2.length, exExFlag)
    strAdditionP1aF2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aF2.length, exExFlag)
    strAdditionP1aF2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aF2.length, exExFlag)

    strAdditionP1aF3 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aF3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aF3.length, exExFlag)
    strAdditionP1aF3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aF3.length, exExFlag)
    strAdditionP1aF3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aF3.length, exExFlag)

    strAdditionP1aG1 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aG1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aG1.length, exExFlag)
    strAdditionP1aG1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aG1.length, exExFlag)
    strAdditionP1aG1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aG1.length, exExFlag)

    strAdditionP1aG2 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aG2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aG2.length, exExFlag)
    strAdditionP1aG2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aG2.length, exExFlag)
    strAdditionP1aG2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aG2.length, exExFlag)

    strAdditionP1aG3 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aG3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aG3.length, exExFlag)
    strAdditionP1aG3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aG3.length, exExFlag)
    strAdditionP1aG3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aG3.length, exExFlag)

    strAdditionP1aH1 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aH1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aH1.length, exExFlag)
    strAdditionP1aH1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aH1.length, exExFlag)
    strAdditionP1aH1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aH1.length, exExFlag)

    strAdditionP1aH2 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aH2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aH2.length, exExFlag)
    strAdditionP1aH2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aH2.length, exExFlag)
    strAdditionP1aH2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aH2.length, exExFlag)

    strAdditionP1aH3 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aH3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aH3.length, exExFlag)
    strAdditionP1aH3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aH3.length, exExFlag)
    strAdditionP1aH3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aH3.length, exExFlag)

    strAdditionP1aI1 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aI1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aI1.length, exExFlag)
    strAdditionP1aI1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aI1.length, exExFlag)
    strAdditionP1aI1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aI1.length, exExFlag)

    strAdditionP1aI2 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aI2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aI2.length, exExFlag)
    strAdditionP1aI2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aI2.length, exExFlag)
    strAdditionP1aI2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aI2.length, exExFlag)

    strAdditionP1aI3 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aI3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aI3.length, exExFlag)
    strAdditionP1aI3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aI3.length, exExFlag)
    strAdditionP1aI3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aI3.length, exExFlag)

    strAdditionP1aJ1 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aJ1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aJ1.length, exExFlag)
    strAdditionP1aJ1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aJ1.length, exExFlag)
    strAdditionP1aJ1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aJ1.length, exExFlag)

    strAdditionP1aJ2 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aJ2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aJ2.length, exExFlag)
    strAdditionP1aJ2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aJ2.length, exExFlag)
    strAdditionP1aJ2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aJ2.length, exExFlag)

    strAdditionP1aJ3 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aJ3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aJ3.length, exExFlag)
    strAdditionP1aJ3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aJ3.length, exExFlag)
    strAdditionP1aJ3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aJ3.length, exExFlag)

    strAdditionP1aK1 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aK1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aK1.length, exExFlag)
    strAdditionP1aK1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aK1.length, exExFlag)
    strAdditionP1aK1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aK1.length, exExFlag)

    strAdditionP1aK2 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aK2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aK2.length, exExFlag)
    strAdditionP1aK2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aK2.length, exExFlag)
    strAdditionP1aK2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aK2.length, exExFlag)

    strAdditionP1aK3 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aK3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aK3.length, exExFlag)
    strAdditionP1aK3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aK3.length, exExFlag)
    strAdditionP1aK3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aK3.length, exExFlag)

    strAdditionP1aL1 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aL1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aL1.length, exExFlag)
    strAdditionP1aL1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aL1.length, exExFlag)
    strAdditionP1aL1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aL1.length, exExFlag)

    strAdditionP1aL2 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aL2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aL2.length, exExFlag)
    strAdditionP1aL2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aL2.length, exExFlag)
    strAdditionP1aL2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aL2.length, exExFlag)

    strAdditionP1aL3 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aL3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aL3.length, exExFlag)
    strAdditionP1aL3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aL3.length, exExFlag)
    strAdditionP1aL3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aL3.length, exExFlag)

    strAdditionP1aM1 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aM1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aM1.length, exExFlag)
    strAdditionP1aM1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aM1.length, exExFlag)
    strAdditionP1aM1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aM1.length, exExFlag)

    strAdditionP1aM2 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aM2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aM2.length, exExFlag)
    strAdditionP1aM2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aM2.length, exExFlag)
    strAdditionP1aM2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aM2.length, exExFlag)

    strAdditionP1aM3 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aM3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aM3.length, exExFlag)
    strAdditionP1aM3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aM3.length, exExFlag)
    strAdditionP1aM3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aM3.length, exExFlag)

    strAdditionP1aN1 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aN1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aN1.length, exExFlag)
    strAdditionP1aN1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aN1.length, exExFlag)
    strAdditionP1aN1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aN1.length, exExFlag)

    strAdditionP1aN2 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aN2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aN2.length, exExFlag)
    strAdditionP1aN2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aN2.length, exExFlag)
    strAdditionP1aN2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aN2.length, exExFlag)

    strAdditionP1aN3 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aN3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aN3.length, exExFlag)
    strAdditionP1aN3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aN3.length, exExFlag)
    strAdditionP1aN3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aN3.length, exExFlag)

    strAdditionP1aO1 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aO1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aO1.length, exExFlag)
    strAdditionP1aO1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aO1.length, exExFlag)
    strAdditionP1aO1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aO1.length, exExFlag)

    strAdditionP1aO2 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aO2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aO2.length, exExFlag)
    strAdditionP1aO2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aO2.length, exExFlag)
    strAdditionP1aO2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aO2.length, exExFlag)

    strAdditionP1aO3 = SpannableString(" சர்மா வஸுரூப")
    strAdditionP1aO3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1aO3.length, exExFlag)
    strAdditionP1aO3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1aO3.length, exExFlag)
    strAdditionP1aO3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1aO3.length, exExFlag)

    val strAdditionP1x3A = SpannableString(" NEWPERSONGOTHRAM1 கோத்ரா அஸ்மத் NEWRELATION1 NEWNAME1")
    val regexReplaceNPx3A = """(NEWPERSONGOTHRAM1)""".toRegex()
    val strAdditionP1x2A = SpannableString(strAdditionP1x3A.replace(regexReplaceNPx3A, gtOne))
    val regexReplaceNPx2A = """(NEWRELATION1)""".toRegex()
    val strAdditionP1x1A = SpannableString(strAdditionP1x2A.replace(regexReplaceNPx2A, reOne))
    val regexReplaceNPx1A = """(NEWNAME1)""".toRegex()
    strAdditionP1zA = SpannableString(strAdditionP1x1A.replace(regexReplaceNPx1A, nOne))
    strAdditionP1zA.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1zA.length, exExFlag)
    strAdditionP1zA.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1zA.length, exExFlag)
    strAdditionP1zA.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1zA.length, exExFlag)

    val strAdditionP1x3B = SpannableString(" NEWPERSONGOTHRAM1 கோத்ரா அஸ்மத் NEWRELATION1 NEWNAME1")
    val regexReplaceNPx3B = """(NEWPERSONGOTHRAM1)""".toRegex()
    val strAdditionP1x2B = SpannableString(strAdditionP1x3B.replace(regexReplaceNPx3B, gtOne))
    val regexReplaceNPx2B = """(NEWRELATION1)""".toRegex()
    val strAdditionP1x1B = SpannableString(strAdditionP1x2B.replace(regexReplaceNPx2B, reOne))
    val regexReplaceNPx1B = """(NEWNAME1)""".toRegex()
    strAdditionP1zB = SpannableString(strAdditionP1x1B.replace(regexReplaceNPx1B, nOne))
    strAdditionP1zB.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1zB.length, exExFlag)
    strAdditionP1zB.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1zB.length, exExFlag)
    strAdditionP1zB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1zB.length, exExFlag)

    val strAdditionP1x3C = SpannableString(" NEWPERSONGOTHRAM1 கோத்ரா அஸ்மத் NEWRELATION1 NEWNAME1")
    val regexReplaceNPx3C = """(NEWPERSONGOTHRAM1)""".toRegex()
    val strAdditionP1x2C = SpannableString(strAdditionP1x3C.replace(regexReplaceNPx3C, gtOne))
    val regexReplaceNPx2C = """(NEWRELATION1)""".toRegex()
    val strAdditionP1x1C = SpannableString(strAdditionP1x2C.replace(regexReplaceNPx2C, reOne))
    val regexReplaceNPx1C = """(NEWNAME1)""".toRegex()
    strAdditionP1zC = SpannableString(strAdditionP1x1C.replace(regexReplaceNPx1C, nOne))
    strAdditionP1zC.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1zC.length, exExFlag)
    strAdditionP1zC.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1zC.length, exExFlag)
    strAdditionP1zC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1zC.length, exExFlag)

    val strAdditionP1x32A = SpannableString(" NEWPERSONGOTHRAM2 கோத்ரா அஸ்மத் NEWRELATION2 NEWNAME2")
    val regexReplaceNx32A = """(NEWPERSONGOTHRAM2)""".toRegex()
    val strAdditionP1x22A = SpannableString(strAdditionP1x32A.replace(regexReplaceNx32A, gtTwo))
    val regexReplaceNx22A = """(NEWRELATION2)""".toRegex()
    val strAdditionP1x12A = SpannableString(strAdditionP1x22A.replace(regexReplaceNx22A, reTwo))
    val regexReplaceNx12A = """(NEWNAME2)""".toRegex()
    strAdditionP2zA = SpannableString(strAdditionP1x12A.replace(regexReplaceNx12A, nTwo))
    strAdditionP2zA.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP2zA.length, exExFlag)
    strAdditionP2zA.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP2zA.length, exExFlag)
    strAdditionP2zA.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP2zA.length, exExFlag)

    val strAdditionP1x32B = SpannableString(" NEWPERSONGOTHRAM2 கோத்ரா அஸ்மத் NEWRELATION2 NEWNAME2")
    val regexReplaceNx32B = """(NEWPERSONGOTHRAM2)""".toRegex()
    val strAdditionP1x22B = SpannableString(strAdditionP1x32B.replace(regexReplaceNx32B, gtTwo))
    val regexReplaceNx22B = """(NEWRELATION2)""".toRegex()
    val strAdditionP1x12B = SpannableString(strAdditionP1x22B.replace(regexReplaceNx22B, reTwo))
    val regexReplaceNx12B = """(NEWNAME2)""".toRegex()
    strAdditionP2zB = SpannableString(strAdditionP1x12B.replace(regexReplaceNx12B, nTwo))
    strAdditionP2zB.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP2zB.length, exExFlag)
    strAdditionP2zB.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP2zB.length, exExFlag)
    strAdditionP2zB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP2zB.length, exExFlag)

    val strAdditionP1x32C = SpannableString(" NEWPERSONGOTHRAM2 கோத்ரா அஸ்மத் NEWRELATION2 NEWNAME2")
    val regexReplaceNx32C = """(NEWPERSONGOTHRAM2)""".toRegex()
    val strAdditionP1x22C = SpannableString(strAdditionP1x32C.replace(regexReplaceNx32C, gtTwo))
    val regexReplaceNx22C = """(NEWRELATION2)""".toRegex()
    val strAdditionP1x12C = SpannableString(strAdditionP1x22C.replace(regexReplaceNx22C, reTwo))
    val regexReplaceNx12C = """(NEWNAME2)""".toRegex()
    strAdditionP2zC = SpannableString(strAdditionP1x12C.replace(regexReplaceNx12C, nTwo))
    strAdditionP2zC.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP2zC.length, exExFlag)
    strAdditionP2zC.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP2zC.length, exExFlag)
    strAdditionP2zC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP2zC.length, exExFlag)

    val strAdditionP1x33A = SpannableString(" NEWPERSONGOTHRAM3 கோத்ரா அஸ்மத் NEWRELATION3 NEWNAME3")
    val regexReplaceNx33A = """(NEWPERSONGOTHRAM3)""".toRegex()
    val strAdditionP1x23A = SpannableString(strAdditionP1x33A.replace(regexReplaceNx33A, gtThree))
    val regexReplaceNx23A = """(NEWRELATION3)""".toRegex()
    val strAdditionP1x13A = SpannableString(strAdditionP1x23A.replace(regexReplaceNx23A, reThree))
    val regexReplaceNx13A = """(NEWNAME3)""".toRegex()
    strAdditionP3zA = SpannableString(strAdditionP1x13A.replace(regexReplaceNx13A, nThree))
    strAdditionP3zA.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP3zA.length, exExFlag)
    strAdditionP3zA.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP3zA.length, exExFlag)
    strAdditionP3zA.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP3zA.length, exExFlag)

    val strAdditionP1x33B = SpannableString(" NEWPERSONGOTHRAM3 கோத்ரா அஸ்மத் NEWRELATION3 NEWNAME3")
    val regexReplaceNx33B = """(NEWPERSONGOTHRAM3)""".toRegex()
    val strAdditionP1x23B = SpannableString(strAdditionP1x33B.replace(regexReplaceNx33B, gtThree))
    val regexReplaceNx23B = """(NEWRELATION3)""".toRegex()
    val strAdditionP1x13B = SpannableString(strAdditionP1x23B.replace(regexReplaceNx23B, reThree))
    val regexReplaceNx13B = """(NEWNAME3)""".toRegex()
    strAdditionP3zB = SpannableString(strAdditionP1x13B.replace(regexReplaceNx13B, nThree))
    strAdditionP3zB.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP3zB.length, exExFlag)
    strAdditionP3zB.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP3zB.length, exExFlag)
    strAdditionP3zB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP3zB.length, exExFlag)

    val strAdditionP1x33C = SpannableString(" NEWPERSONGOTHRAM3 கோத்ரா அஸ்மத் NEWRELATION3 NEWNAME3")
    val regexReplaceNx33C = """(NEWPERSONGOTHRAM3)""".toRegex()
    val strAdditionP1x23C = SpannableString(strAdditionP1x33C.replace(regexReplaceNx33C, gtThree))
    val regexReplaceNx23C = """(NEWRELATION3)""".toRegex()
    val strAdditionP1x13C = SpannableString(strAdditionP1x23C.replace(regexReplaceNx23C, reThree))
    val regexReplaceNx13C = """(NEWNAME3)""".toRegex()
    strAdditionP3zC = SpannableString(strAdditionP1x13C.replace(regexReplaceNx13C, nThree))
    strAdditionP3zC.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP3zC.length, exExFlag)
    strAdditionP3zC.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP3zC.length, exExFlag)
    strAdditionP3zC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP3zC.length, exExFlag)

    val strAdditionP1x34A = SpannableString(" NEWPERSONGOTHRAM4 கோத்ரா அஸ்மத் NEWRELATION4 NEWNAME4")
    val regexReplaceNx34A = """(NEWPERSONGOTHRAM4)""".toRegex()
    val strAdditionP1x24A = SpannableString(strAdditionP1x34A.replace(regexReplaceNx34A, gtFour))
    val regexReplaceNx24A = """(NEWRELATION4)""".toRegex()
    val strAdditionP1x14A = SpannableString(strAdditionP1x24A.replace(regexReplaceNx24A, reFour))
    val regexReplaceNx14A = """(NEWNAME4)""".toRegex()
    strAdditionP4zA = SpannableString(strAdditionP1x14A.replace(regexReplaceNx14A, nFour))
    strAdditionP4zA.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP4zA.length, exExFlag)
    strAdditionP4zA.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP4zA.length, exExFlag)
    strAdditionP4zA.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP4zA.length, exExFlag)

    val strAdditionP1x34B = SpannableString(" NEWPERSONGOTHRAM4 கோத்ரா அஸ்மத் NEWRELATION4 NEWNAME4")
    val regexReplaceNx34B = """(NEWPERSONGOTHRAM4)""".toRegex()
    val strAdditionP1x24B = SpannableString(strAdditionP1x34B.replace(regexReplaceNx34B, gtFour))
    val regexReplaceNx24B = """(NEWRELATION4)""".toRegex()
    val strAdditionP1x14B = SpannableString(strAdditionP1x24B.replace(regexReplaceNx24B, reFour))
    val regexReplaceNx14B = """(NEWNAME4)""".toRegex()
    strAdditionP4zB = SpannableString(strAdditionP1x14B.replace(regexReplaceNx14B, nFour))
    strAdditionP4zB.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP4zB.length, exExFlag)
    strAdditionP4zB.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP4zB.length, exExFlag)
    strAdditionP4zB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP4zB.length, exExFlag)

    val strAdditionP1x34C = SpannableString(" NEWPERSONGOTHRAM4 கோத்ரா அஸ்மத் NEWRELATION4 NEWNAME4")
    val regexReplaceNx34C = """(NEWPERSONGOTHRAM4)""".toRegex()
    val strAdditionP1x24C = SpannableString(strAdditionP1x34C.replace(regexReplaceNx34C, gtFour))
    val regexReplaceNx24C = """(NEWRELATION4)""".toRegex()
    val strAdditionP1x14C = SpannableString(strAdditionP1x24C.replace(regexReplaceNx24C, reFour))
    val regexReplaceNx14C = """(NEWNAME4)""".toRegex()
    strAdditionP4zC = SpannableString(strAdditionP1x14C.replace(regexReplaceNx14C, nFour))
    strAdditionP4zC.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP4zC.length, exExFlag)
    strAdditionP4zC.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP4zC.length, exExFlag)
    strAdditionP4zC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP4zC.length, exExFlag)

    val strAdditionP1x35A = SpannableString(" NEWPERSONGOTHRAM5 கோத்ரா அஸ்மத் NEWRELATION5 NEWNAME5")
    val regexReplaceNx35A = """(NEWPERSONGOTHRAM5)""".toRegex()
    val strAdditionP1x25A = SpannableString(strAdditionP1x35A.replace(regexReplaceNx35A, gtFive))
    val regexReplaceNx25A = """(NEWRELATION5)""".toRegex()
    val strAdditionP1x15A = SpannableString(strAdditionP1x25A.replace(regexReplaceNx25A, reFive))
    val regexReplaceNx15A = """(NEWNAME5)""".toRegex()
    strAdditionP5zA = SpannableString(strAdditionP1x15A.replace(regexReplaceNx15A, nFive))
    strAdditionP5zA.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP5zA.length, exExFlag)
    strAdditionP5zA.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP5zA.length, exExFlag)
    strAdditionP5zA.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP5zA.length, exExFlag)

    val strAdditionP1x35B = SpannableString(" NEWPERSONGOTHRAM5 கோத்ரா அஸ்மத் NEWRELATION5 NEWNAME5")
    val regexReplaceNx35B = """(NEWPERSONGOTHRAM5)""".toRegex()
    val strAdditionP1x25B = SpannableString(strAdditionP1x35B.replace(regexReplaceNx35B, gtFive))
    val regexReplaceNx25B = """(NEWRELATION5)""".toRegex()
    val strAdditionP1x15B = SpannableString(strAdditionP1x25B.replace(regexReplaceNx25B, reFive))
    val regexReplaceNx15B = """(NEWNAME5)""".toRegex()
    strAdditionP5zB = SpannableString(strAdditionP1x15B.replace(regexReplaceNx15B, nFive))
    strAdditionP5zB.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP5zB.length, exExFlag)
    strAdditionP5zB.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP5zB.length, exExFlag)
    strAdditionP5zB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP5zB.length, exExFlag)

    val strAdditionP1x35C = SpannableString(" NEWPERSONGOTHRAM5 கோத்ரா அஸ்மத் NEWRELATION5 NEWNAME5")
    val regexReplaceNx35C = """(NEWPERSONGOTHRAM5)""".toRegex()
    val strAdditionP1x25C = SpannableString(strAdditionP1x35C.replace(regexReplaceNx35C, gtFive))
    val regexReplaceNx25C = """(NEWRELATION5)""".toRegex()
    val strAdditionP1x15C = SpannableString(strAdditionP1x25C.replace(regexReplaceNx25C, reFive))
    val regexReplaceNx15C = """(NEWNAME5)""".toRegex()
    strAdditionP5zC = SpannableString(strAdditionP1x15C.replace(regexReplaceNx15C, nFive))
    strAdditionP5zC.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP5zC.length, exExFlag)
    strAdditionP5zC.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP5zC.length, exExFlag)
    strAdditionP5zC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP5zC.length, exExFlag)

    val strAdditionP1x36A = SpannableString(" NEWPERSONGOTHRAM6 கோத்ரா அஸ்மத் NEWRELATION6 NEWNAME6")
    val regexReplaceNx36A = """(NEWPERSONGOTHRAM6)""".toRegex()
    val strAdditionP1x26A = SpannableString(strAdditionP1x36A.replace(regexReplaceNx36A, gtSix))
    val regexReplaceNx26A = """(NEWRELATION6)""".toRegex()
    val strAdditionP1x16A = SpannableString(strAdditionP1x26A.replace(regexReplaceNx26A, reSix))
    val regexReplaceNx16A = """(NEWNAME6)""".toRegex()
    strAdditionP6zA = SpannableString(strAdditionP1x16A.replace(regexReplaceNx16A, nSix))
    strAdditionP6zA.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP6zA.length, exExFlag)
    strAdditionP6zA.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP6zA.length, exExFlag)
    strAdditionP6zA.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP6zA.length, exExFlag)

    val strAdditionP1x36B = SpannableString(" NEWPERSONGOTHRAM6 கோத்ரா அஸ்மத் NEWRELATION6 NEWNAME6")
    val regexReplaceNx36B = """(NEWPERSONGOTHRAM6)""".toRegex()
    val strAdditionP1x26B = SpannableString(strAdditionP1x36B.replace(regexReplaceNx36B, gtSix))
    val regexReplaceNx26B = """(NEWRELATION6)""".toRegex()
    val strAdditionP1x16B = SpannableString(strAdditionP1x26B.replace(regexReplaceNx26B, reSix))
    val regexReplaceNx16B = """(NEWNAME6)""".toRegex()
    strAdditionP6zB = SpannableString(strAdditionP1x16B.replace(regexReplaceNx16B, nSix))
    strAdditionP6zB.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP6zB.length, exExFlag)
    strAdditionP6zB.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP6zB.length, exExFlag)
    strAdditionP6zB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP6zB.length, exExFlag)

    val strAdditionP1x36C = SpannableString(" NEWPERSONGOTHRAM6 கோத்ரா அஸ்மத் NEWRELATION6 NEWNAME6")
    val regexReplaceNx36C = """(NEWPERSONGOTHRAM6)""".toRegex()
    val strAdditionP1x26C = SpannableString(strAdditionP1x36C.replace(regexReplaceNx36C, gtSix))
    val regexReplaceNx26C = """(NEWRELATION6)""".toRegex()
    val strAdditionP1x16C = SpannableString(strAdditionP1x26C.replace(regexReplaceNx26C, reSix))
    val regexReplaceNx16C = """(NEWNAME6)""".toRegex()
    strAdditionP6zC = SpannableString(strAdditionP1x16C.replace(regexReplaceNx16C, nSix))
    strAdditionP6zC.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP6zC.length, exExFlag)
    strAdditionP6zC.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP6zC.length, exExFlag)
    strAdditionP6zC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP6zC.length, exExFlag)

    val strAdditionP1x37A = SpannableString(" NEWPERSONGOTHRAM7 கோத்ரா அஸ்மத் NEWRELATION7 NEWNAME7")
    val regexReplaceNx37A = """(NEWPERSONGOTHRAM7)""".toRegex()
    val strAdditionP1x27A = SpannableString(strAdditionP1x37A.replace(regexReplaceNx37A, gtSeven))
    val regexReplaceNx27A = """(NEWRELATION7)""".toRegex()
    val strAdditionP1x17A = SpannableString(strAdditionP1x27A.replace(regexReplaceNx27A, reSeven))
    val regexReplaceNx17A = """(NEWNAME7)""".toRegex()
    strAdditionP7zA = SpannableString(strAdditionP1x17A.replace(regexReplaceNx17A, nSeven))
    strAdditionP7zA.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP7zA.length, exExFlag)
    strAdditionP7zA.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP7zA.length, exExFlag)
    strAdditionP7zA.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP7zA.length, exExFlag)

    val strAdditionP1x37B = SpannableString(" NEWPERSONGOTHRAM7 கோத்ரா அஸ்மத் NEWRELATION7 NEWNAME7")
    val regexReplaceNx37B = """(NEWPERSONGOTHRAM7)""".toRegex()
    val strAdditionP1x27B = SpannableString(strAdditionP1x37B.replace(regexReplaceNx37B, gtSeven))
    val regexReplaceNx27B = """(NEWRELATION7)""".toRegex()
    val strAdditionP1x17B = SpannableString(strAdditionP1x27B.replace(regexReplaceNx27B, reSeven))
    val regexReplaceNx17B = """(NEWNAME7)""".toRegex()
    strAdditionP7zB = SpannableString(strAdditionP1x17B.replace(regexReplaceNx17B, nSeven))
    strAdditionP7zB.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP7zB.length, exExFlag)
    strAdditionP7zB.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP7zB.length, exExFlag)
    strAdditionP7zB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP7zB.length, exExFlag)

    val strAdditionP1x37C = SpannableString(" NEWPERSONGOTHRAM7 கோத்ரா அஸ்மத் NEWRELATION7 NEWNAME7")
    val regexReplaceNx37C = """(NEWPERSONGOTHRAM7)""".toRegex()
    val strAdditionP1x27C = SpannableString(strAdditionP1x37C.replace(regexReplaceNx37C, gtSeven))
    val regexReplaceNx27C = """(NEWRELATION7)""".toRegex()
    val strAdditionP1x17C = SpannableString(strAdditionP1x27C.replace(regexReplaceNx27C, reSeven))
    val regexReplaceNx17C = """(NEWNAME7)""".toRegex()
    strAdditionP7zC = SpannableString(strAdditionP1x17C.replace(regexReplaceNx17C, nSeven))
    strAdditionP7zC.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP7zC.length, exExFlag)
    strAdditionP7zC.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP7zC.length, exExFlag)
    strAdditionP7zC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP7zC.length, exExFlag)

    val strAdditionP1x38A = SpannableString(" NEWPERSONGOTHRAM8 கோத்ரா அஸ்மத் NEWRELATION8 NEWNAME8")
    val regexReplaceNx38A = """(NEWPERSONGOTHRAM8)""".toRegex()
    val strAdditionP1x28A = SpannableString(strAdditionP1x38A.replace(regexReplaceNx38A, gtEight))
    val regexReplaceNx28A = """(NEWRELATION8)""".toRegex()
    val strAdditionP1x18A = SpannableString(strAdditionP1x28A.replace(regexReplaceNx28A, reEight))
    val regexReplaceNx18A = """(NEWNAME8)""".toRegex()
    strAdditionP8zA = SpannableString(strAdditionP1x18A.replace(regexReplaceNx18A, nEight))
    strAdditionP8zA.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP8zA.length, exExFlag)
    strAdditionP8zA.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP8zA.length, exExFlag)
    strAdditionP8zA.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP8zA.length, exExFlag)

    val strAdditionP1x38B = SpannableString(" NEWPERSONGOTHRAM8 கோத்ரா அஸ்மத் NEWRELATION8 NEWNAME8")
    val regexReplaceNx38B = """(NEWPERSONGOTHRAM8)""".toRegex()
    val strAdditionP1x28B = SpannableString(strAdditionP1x38B.replace(regexReplaceNx38B, gtEight))
    val regexReplaceNx28B = """(NEWRELATION8)""".toRegex()
    val strAdditionP1x18B = SpannableString(strAdditionP1x28B.replace(regexReplaceNx28B, reEight))
    val regexReplaceNx18B = """(NEWNAME8)""".toRegex()
    strAdditionP8zB = SpannableString(strAdditionP1x18B.replace(regexReplaceNx18B, nEight))
    strAdditionP8zB.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP8zB.length, exExFlag)
    strAdditionP8zB.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP8zB.length, exExFlag)
    strAdditionP8zB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP8zB.length, exExFlag)

    val strAdditionP1x38C = SpannableString(" NEWPERSONGOTHRAM8 கோத்ரா அஸ்மத் NEWRELATION8 NEWNAME8")
    val regexReplaceNx38C = """(NEWPERSONGOTHRAM8)""".toRegex()
    val strAdditionP1x28C = SpannableString(strAdditionP1x38C.replace(regexReplaceNx38C, gtEight))
    val regexReplaceNx28C = """(NEWRELATION8)""".toRegex()
    val strAdditionP1x18C = SpannableString(strAdditionP1x28C.replace(regexReplaceNx28C, reEight))
    val regexReplaceNx18C = """(NEWNAME8)""".toRegex()
    strAdditionP8zC = SpannableString(strAdditionP1x18C.replace(regexReplaceNx18C, nEight))
    strAdditionP8zC.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP8zC.length, exExFlag)
    strAdditionP8zC.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP8zC.length, exExFlag)
    strAdditionP8zC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP8zC.length, exExFlag)

    val strAdditionP1x39A = SpannableString(" NEWPERSONGOTHRAM9 கோத்ரா அஸ்மத் NEWRELATION9 NEWNAME9")
    val regexReplaceNx39A = """(NEWPERSONGOTHRAM9)""".toRegex()
    val strAdditionP1x29A = SpannableString(strAdditionP1x39A.replace(regexReplaceNx39A, gtNine))
    val regexReplaceNx29A = """(NEWRELATION9)""".toRegex()
    val strAdditionP1x19A = SpannableString(strAdditionP1x29A.replace(regexReplaceNx29A, reNine))
    val regexReplaceNx19A = """(NEWNAME9)""".toRegex()
    strAdditionP9zA = SpannableString(strAdditionP1x19A.replace(regexReplaceNx19A, nNine))
    strAdditionP9zA.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP9zA.length, exExFlag)
    strAdditionP9zA.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP9zA.length, exExFlag)
    strAdditionP9zA.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP9zA.length, exExFlag)

    val strAdditionP1x39B = SpannableString(" NEWPERSONGOTHRAM9 கோத்ரா அஸ்மத் NEWRELATION9 NEWNAME9")
    val regexReplaceNx39B = """(NEWPERSONGOTHRAM9)""".toRegex()
    val strAdditionP1x29B = SpannableString(strAdditionP1x39B.replace(regexReplaceNx39B, gtNine))
    val regexReplaceNx29B = """(NEWRELATION9)""".toRegex()
    val strAdditionP1x19B = SpannableString(strAdditionP1x29B.replace(regexReplaceNx29B, reNine))
    val regexReplaceNx19B = """(NEWNAME9)""".toRegex()
    strAdditionP9zB = SpannableString(strAdditionP1x19B.replace(regexReplaceNx19B, nNine))
    strAdditionP9zB.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP9zB.length, exExFlag)
    strAdditionP9zB.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP9zB.length, exExFlag)
    strAdditionP9zB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP9zB.length, exExFlag)

    val strAdditionP1x39C = SpannableString(" NEWPERSONGOTHRAM9 கோத்ரா அஸ்மத் NEWRELATION9 NEWNAME9")
    val regexReplaceNx39C = """(NEWPERSONGOTHRAM9)""".toRegex()
    val strAdditionP1x29C = SpannableString(strAdditionP1x39C.replace(regexReplaceNx39C, gtNine))
    val regexReplaceNx29C = """(NEWRELATION9)""".toRegex()
    val strAdditionP1x19C = SpannableString(strAdditionP1x29C.replace(regexReplaceNx29C, reNine))
    val regexReplaceNx19C = """(NEWNAME9)""".toRegex()
    strAdditionP9zC = SpannableString(strAdditionP1x19C.replace(regexReplaceNx19C, nNine))
    strAdditionP9zC.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP9zC.length, exExFlag)
    strAdditionP9zC.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP9zC.length, exExFlag)
    strAdditionP9zC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP9zC.length, exExFlag)

    val strAdditionP1x310A = SpannableString(" NEWPERSONGOTHRAM10 கோத்ரா அஸ்மத் NEWRELATION10 NEWNAME10")
    val regexReplaceNx310A = """(NEWPERSONGOTHRAM10)""".toRegex()
    val strAdditionP1x210A = SpannableString(strAdditionP1x310A.replace(regexReplaceNx310A, gtTen))
    val regexReplaceNx210A = """(NEWRELATION10)""".toRegex()
    val strAdditionP1x110A = SpannableString(strAdditionP1x210A.replace(regexReplaceNx210A, reTen))
    val regexReplaceNx110A = """(NEWNAME10)""".toRegex()
    strAdditionP10zA = SpannableString(strAdditionP1x110A.replace(regexReplaceNx110A, nTen))
    strAdditionP10zA.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP10zA.length, exExFlag)
    strAdditionP10zA.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP10zA.length, exExFlag)
    strAdditionP10zA.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP10zA.length, exExFlag)

    val strAdditionP1x310B = SpannableString(" NEWPERSONGOTHRAM10 கோத்ரா அஸ்மத் NEWRELATION10 NEWNAME10")
    val regexReplaceNx310B = """(NEWPERSONGOTHRAM10)""".toRegex()
    val strAdditionP1x210B = SpannableString(strAdditionP1x310B.replace(regexReplaceNx310B, gtTen))
    val regexReplaceNx210B = """(NEWRELATION10)""".toRegex()
    val strAdditionP1x110B = SpannableString(strAdditionP1x210B.replace(regexReplaceNx210B, reTen))
    val regexReplaceNx110B = """(NEWNAME10)""".toRegex()
    strAdditionP10zB = SpannableString(strAdditionP1x110B.replace(regexReplaceNx110B, nTen))
    strAdditionP10zB.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP10zB.length, exExFlag)
    strAdditionP10zB.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP10zB.length, exExFlag)
    strAdditionP10zB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP10zB.length, exExFlag)

    val strAdditionP1x310C = SpannableString(" NEWPERSONGOTHRAM10 கோத்ரா அஸ்மத் NEWRELATION10 NEWNAME10")
    val regexReplaceNx310C = """(NEWPERSONGOTHRAM10)""".toRegex()
    val strAdditionP1x210C = SpannableString(strAdditionP1x310C.replace(regexReplaceNx310C, gtTen))
    val regexReplaceNx210C = """(NEWRELATION10)""".toRegex()
    val strAdditionP1x110C = SpannableString(strAdditionP1x210C.replace(regexReplaceNx210C, reTen))
    val regexReplaceNx110C = """(NEWNAME10)""".toRegex()
    strAdditionP10zC = SpannableString(strAdditionP1x110C.replace(regexReplaceNx110C, nTen))
    strAdditionP10zC.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP10zC.length, exExFlag)
    strAdditionP10zC.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP10zC.length, exExFlag)
    strAdditionP10zC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP10zC.length, exExFlag)

    val strAdditionP1x311A = SpannableString(" NEWPERSONGOTHRAM11 கோத்ரா அஸ்மத் NEWRELATION11 NEWNAME11")
    val regexReplaceNx311A = """(NEWPERSONGOTHRAM11)""".toRegex()
    val strAdditionP1x211A = SpannableString(strAdditionP1x311A.replace(regexReplaceNx311A, gtEleven))
    val regexReplaceNx211A = """(NEWRELATION11)""".toRegex()
    val strAdditionP1x111A = SpannableString(strAdditionP1x211A.replace(regexReplaceNx211A, reEleven))
    val regexReplaceNx111A = """(NEWNAME11)""".toRegex()
    strAdditionP11zA = SpannableString(strAdditionP1x111A.replace(regexReplaceNx111A, nEleven))
    strAdditionP11zA.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP11zA.length, exExFlag)
    strAdditionP11zA.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP11zA.length, exExFlag)
    strAdditionP11zA.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP11zA.length, exExFlag)

    val strAdditionP1x311B = SpannableString(" NEWPERSONGOTHRAM11 கோத்ரா அஸ்மத் NEWRELATION11 NEWNAME11")
    val regexReplaceNx311B = """(NEWPERSONGOTHRAM11)""".toRegex()
    val strAdditionP1x211B = SpannableString(strAdditionP1x311B.replace(regexReplaceNx311B, gtEleven))
    val regexReplaceNx211B = """(NEWRELATION11)""".toRegex()
    val strAdditionP1x111B = SpannableString(strAdditionP1x211B.replace(regexReplaceNx211B, reEleven))
    val regexReplaceNx111B = """(NEWNAME11)""".toRegex()
    strAdditionP11zB = SpannableString(strAdditionP1x111B.replace(regexReplaceNx111B, nEleven))
    strAdditionP11zB.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP11zB.length, exExFlag)
    strAdditionP11zB.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP11zB.length, exExFlag)
    strAdditionP11zB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP11zB.length, exExFlag)

    val strAdditionP1x311C = SpannableString(" NEWPERSONGOTHRAM11 கோத்ரா அஸ்மத் NEWRELATION11 NEWNAME11")
    val regexReplaceNx311C = """(NEWPERSONGOTHRAM11)""".toRegex()
    val strAdditionP1x211C = SpannableString(strAdditionP1x311C.replace(regexReplaceNx311C, gtEleven))
    val regexReplaceNx211C = """(NEWRELATION11)""".toRegex()
    val strAdditionP1x111C = SpannableString(strAdditionP1x211C.replace(regexReplaceNx211C, reEleven))
    val regexReplaceNx111C = """(NEWNAME11)""".toRegex()
    strAdditionP11zC = SpannableString(strAdditionP1x111C.replace(regexReplaceNx111C, nEleven))
    strAdditionP11zC.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP11zC.length, exExFlag)
    strAdditionP11zC.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP11zC.length, exExFlag)
    strAdditionP11zC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP11zC.length, exExFlag)

    val strAdditionP1x312A = SpannableString(" NEWPERSONGOTHRAM12 கோத்ரா அஸ்மத் NEWRELATION12 NEWNAME12")
    val regexReplaceNx312A = """(NEWPERSONGOTHRAM12)""".toRegex()
    val strAdditionP1x212A = SpannableString(strAdditionP1x312A.replace(regexReplaceNx312A, gtTwelve))
    val regexReplaceNx212A = """(NEWRELATION12)""".toRegex()
    val strAdditionP1x112A = SpannableString(strAdditionP1x212A.replace(regexReplaceNx212A, reTwelve))
    val regexReplaceNx112A = """(NEWNAME12)""".toRegex()
    strAdditionP12zA = SpannableString(strAdditionP1x112A.replace(regexReplaceNx112A, nTwelve))
    strAdditionP12zA.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP12zA.length, exExFlag)
    strAdditionP12zA.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP12zA.length, exExFlag)
    strAdditionP12zA.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP12zA.length, exExFlag)

    val strAdditionP1x312B = SpannableString(" NEWPERSONGOTHRAM12 கோத்ரா அஸ்மத் NEWRELATION12 NEWNAME12")
    val regexReplaceNx312B = """(NEWPERSONGOTHRAM12)""".toRegex()
    val strAdditionP1x212B = SpannableString(strAdditionP1x312B.replace(regexReplaceNx312B, gtTwelve))
    val regexReplaceNx212B = """(NEWRELATION12)""".toRegex()
    val strAdditionP1x112B = SpannableString(strAdditionP1x212B.replace(regexReplaceNx212B, reTwelve))
    val regexReplaceNx112B = """(NEWNAME12)""".toRegex()
    strAdditionP12zB = SpannableString(strAdditionP1x112B.replace(regexReplaceNx112B, nTwelve))
    strAdditionP12zB.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP12zB.length, exExFlag)
    strAdditionP12zB.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP12zB.length, exExFlag)
    strAdditionP12zB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP12zB.length, exExFlag)

    val strAdditionP1x312C = SpannableString(" NEWPERSONGOTHRAM12 கோத்ரா அஸ்மத் NEWRELATION12 NEWNAME12")
    val regexReplaceNx312C = """(NEWPERSONGOTHRAM12)""".toRegex()
    val strAdditionP1x212C = SpannableString(strAdditionP1x312C.replace(regexReplaceNx312C, gtTwelve))
    val regexReplaceNx212C = """(NEWRELATION12)""".toRegex()
    val strAdditionP1x112C = SpannableString(strAdditionP1x212C.replace(regexReplaceNx212C, reTwelve))
    val regexReplaceNx112C = """(NEWNAME12)""".toRegex()
    strAdditionP12zC = SpannableString(strAdditionP1x112C.replace(regexReplaceNx112C, nTwelve))
    strAdditionP12zC.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP12zC.length, exExFlag)
    strAdditionP12zC.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP12zC.length, exExFlag)
    strAdditionP12zC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP12zC.length, exExFlag)

    val strAdditionP1x313A = SpannableString(" NEWPERSONGOTHRAM13 கோத்ரா அஸ்மத் NEWRELATION13 NEWNAME13")
    val regexReplaceNx313A = """(NEWPERSONGOTHRAM13)""".toRegex()
    val strAdditionP1x213A = SpannableString(strAdditionP1x313A.replace(regexReplaceNx313A, gtThirteen))
    val regexReplaceNx213A = """(NEWRELATION13)""".toRegex()
    val strAdditionP1x113A = SpannableString(strAdditionP1x213A.replace(regexReplaceNx213A, reThirteen))
    val regexReplaceNx113A = """(NEWNAME13)""".toRegex()
    strAdditionP13zA = SpannableString(strAdditionP1x113A.replace(regexReplaceNx113A, nThirteen))
    strAdditionP13zA.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP13zA.length, exExFlag)
    strAdditionP13zA.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP13zA.length, exExFlag)
    strAdditionP13zA.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP13zA.length, exExFlag)

    val strAdditionP1x313B = SpannableString(" NEWPERSONGOTHRAM13 கோத்ரா அஸ்மத் NEWRELATION13 NEWNAME13")
    val regexReplaceNx313B = """(NEWPERSONGOTHRAM13)""".toRegex()
    val strAdditionP1x213B = SpannableString(strAdditionP1x313B.replace(regexReplaceNx313B, gtThirteen))
    val regexReplaceNx213B = """(NEWRELATION13)""".toRegex()
    val strAdditionP1x113B = SpannableString(strAdditionP1x213B.replace(regexReplaceNx213B, reThirteen))
    val regexReplaceNx113B = """(NEWNAME13)""".toRegex()
    strAdditionP13zB = SpannableString(strAdditionP1x113B.replace(regexReplaceNx113B, nThirteen))
    strAdditionP13zB.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP13zB.length, exExFlag)
    strAdditionP13zB.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP13zB.length, exExFlag)
    strAdditionP13zB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP13zB.length, exExFlag)

    val strAdditionP1x313C = SpannableString(" NEWPERSONGOTHRAM13 கோத்ரா அஸ்மத் NEWRELATION13 NEWNAME13")
    val regexReplaceNx313C = """(NEWPERSONGOTHRAM13)""".toRegex()
    val strAdditionP1x213C = SpannableString(strAdditionP1x313C.replace(regexReplaceNx313C, gtThirteen))
    val regexReplaceNx213C = """(NEWRELATION13)""".toRegex()
    val strAdditionP1x113C = SpannableString(strAdditionP1x213C.replace(regexReplaceNx213C, reThirteen))
    val regexReplaceNx113C = """(NEWNAME13)""".toRegex()
    strAdditionP13zC = SpannableString(strAdditionP1x113C.replace(regexReplaceNx113C, nThirteen))
    strAdditionP13zC.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP13zC.length, exExFlag)
    strAdditionP13zC.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP13zC.length, exExFlag)
    strAdditionP13zC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP13zC.length, exExFlag)

    val strAdditionP1x314A = SpannableString(" NEWPERSONGOTHRAM14 கோத்ரா அஸ்மத் NEWRELATION14 NEWNAME14")
    val regexReplaceNx314A = """(NEWPERSONGOTHRAM14)""".toRegex()
    val strAdditionP1x214A = SpannableString(strAdditionP1x314A.replace(regexReplaceNx314A, gtFourteen))
    val regexReplaceNx214A = """(NEWRELATION14)""".toRegex()
    val strAdditionP1x114A = SpannableString(strAdditionP1x214A.replace(regexReplaceNx214A, reFourteen))
    val regexReplaceNx114A = """(NEWNAME14)""".toRegex()
    strAdditionP14zA = SpannableString(strAdditionP1x114A.replace(regexReplaceNx114A, nFourteen))
    strAdditionP14zA.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP14zA.length, exExFlag)
    strAdditionP14zA.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP14zA.length, exExFlag)
    strAdditionP14zA.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP14zA.length, exExFlag)

    val strAdditionP1x314B = SpannableString(" NEWPERSONGOTHRAM14 கோத்ரா அஸ்மத் NEWRELATION14 NEWNAME14")
    val regexReplaceNx314B = """(NEWPERSONGOTHRAM14)""".toRegex()
    val strAdditionP1x214B = SpannableString(strAdditionP1x314B.replace(regexReplaceNx314B, gtFourteen))
    val regexReplaceNx214B = """(NEWRELATION14)""".toRegex()
    val strAdditionP1x114B = SpannableString(strAdditionP1x214B.replace(regexReplaceNx214B, reFourteen))
    val regexReplaceNx114B = """(NEWNAME14)""".toRegex()
    strAdditionP14zB = SpannableString(strAdditionP1x114B.replace(regexReplaceNx114B, nFourteen))
    strAdditionP14zB.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP14zB.length, exExFlag)
    strAdditionP14zB.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP14zB.length, exExFlag)
    strAdditionP14zB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP14zB.length, exExFlag)

    val strAdditionP1x314C = SpannableString(" NEWPERSONGOTHRAM14 கோத்ரா அஸ்மத் NEWRELATION14 NEWNAME14")
    val regexReplaceNx314C = """(NEWPERSONGOTHRAM14)""".toRegex()
    val strAdditionP1x214C = SpannableString(strAdditionP1x314C.replace(regexReplaceNx314C, gtFourteen))
    val regexReplaceNx214C = """(NEWRELATION14)""".toRegex()
    val strAdditionP1x114C = SpannableString(strAdditionP1x214C.replace(regexReplaceNx214C, reFourteen))
    val regexReplaceNx114C = """(NEWNAME14)""".toRegex()
    strAdditionP14zC = SpannableString(strAdditionP1x114C.replace(regexReplaceNx114C, nFourteen))
    strAdditionP14zC.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP14zC.length, exExFlag)
    strAdditionP14zC.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP14zC.length, exExFlag)
    strAdditionP14zC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP14zC.length, exExFlag)

    val strAdditionP1x315A = SpannableString(" NEWPERSONGOTHRAM15 கோத்ரா அஸ்மத் NEWRELATION15 NEWNAME15")
    val regexReplaceNx315A = """(NEWPERSONGOTHRAM15)""".toRegex()
    val strAdditionP1x215A = SpannableString(strAdditionP1x315A.replace(regexReplaceNx315A, gtFifteen))
    val regexReplaceNx215A = """(NEWRELATION15)""".toRegex()
    val strAdditionP1x115A = SpannableString(strAdditionP1x215A.replace(regexReplaceNx215A, reFifteen))
    val regexReplaceNx115A = """(NEWNAME15)""".toRegex()
    strAdditionP15zA = SpannableString(strAdditionP1x115A.replace(regexReplaceNx115A, nFifteen))
    strAdditionP15zA.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP15zA.length, exExFlag)
    strAdditionP15zA.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP15zA.length, exExFlag)
    strAdditionP15zA.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP15zA.length, exExFlag)

    val strAdditionP1x315B = SpannableString(" NEWPERSONGOTHRAM15 கோத்ரா அஸ்மத் NEWRELATION15 NEWNAME15")
    val regexReplaceNx315B = """(NEWPERSONGOTHRAM15)""".toRegex()
    val strAdditionP1x215B = SpannableString(strAdditionP1x315B.replace(regexReplaceNx315B, gtFifteen))
    val regexReplaceNx215B = """(NEWRELATION15)""".toRegex()
    val strAdditionP1x115B = SpannableString(strAdditionP1x215B.replace(regexReplaceNx215B, reFifteen))
    val regexReplaceNx115B = """(NEWNAME15)""".toRegex()
    strAdditionP15zB = SpannableString(strAdditionP1x115B.replace(regexReplaceNx115B, nFifteen))
    strAdditionP15zB.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP15zB.length, exExFlag)
    strAdditionP15zB.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP15zB.length, exExFlag)
    strAdditionP15zB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP15zB.length, exExFlag)

    val strAdditionP1x315C = SpannableString(" NEWPERSONGOTHRAM15 கோத்ரா அஸ்மத் NEWRELATION15 NEWNAME15")
    val regexReplaceNx315C = """(NEWPERSONGOTHRAM15)""".toRegex()
    val strAdditionP1x215C = SpannableString(strAdditionP1x315C.replace(regexReplaceNx315C, gtFifteen))
    val regexReplaceNx215C = """(NEWRELATION15)""".toRegex()
    val strAdditionP1x115C = SpannableString(strAdditionP1x215C.replace(regexReplaceNx215C, reFifteen))
    val regexReplaceNx115C = """(NEWNAME15)""".toRegex()
    strAdditionP15zC = SpannableString(strAdditionP1x115C.replace(regexReplaceNx115C, nFifteen))
    strAdditionP15zC.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP15zC.length, exExFlag)
    strAdditionP15zC.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP15zC.length, exExFlag)
    strAdditionP15zC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP15zC.length, exExFlag)

    strAdditionP1bA1 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bA1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bA1.length, exExFlag)
    strAdditionP1bA1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bA1.length, exExFlag)
    strAdditionP1bA1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bA1.length, exExFlag)

    strAdditionP1bA2 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bA2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bA2.length, exExFlag)
    strAdditionP1bA2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bA2.length, exExFlag)
    strAdditionP1bA2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bA2.length, exExFlag)

    strAdditionP1bA3 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bA3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bA3.length, exExFlag)
    strAdditionP1bA3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bA3.length, exExFlag)
    strAdditionP1bA3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bA3.length, exExFlag)

    strAdditionP1bB1 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bB1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bB1.length, exExFlag)
    strAdditionP1bB1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bB1.length, exExFlag)
    strAdditionP1bB1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bB1.length, exExFlag)

    strAdditionP1bB2 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bB2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bB2.length, exExFlag)
    strAdditionP1bB2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bB2.length, exExFlag)
    strAdditionP1bB2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bB2.length, exExFlag)

    strAdditionP1bB3 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bB3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bB3.length, exExFlag)
    strAdditionP1bB3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bB3.length, exExFlag)
    strAdditionP1bB3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bB3.length, exExFlag)

    strAdditionP1bC1 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bC1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bC1.length, exExFlag)
    strAdditionP1bC1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bC1.length, exExFlag)
    strAdditionP1bC1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bC1.length, exExFlag)

    strAdditionP1bC2 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bC2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bC2.length, exExFlag)
    strAdditionP1bC2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bC2.length, exExFlag)
    strAdditionP1bC2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bC2.length, exExFlag)

    strAdditionP1bC3 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bC3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bC3.length, exExFlag)
    strAdditionP1bC3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bC3.length, exExFlag)
    strAdditionP1bC3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bC3.length, exExFlag)

    strAdditionP1bD1 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bD1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bD1.length, exExFlag)
    strAdditionP1bD1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bD1.length, exExFlag)
    strAdditionP1bD1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bD1.length, exExFlag)

    strAdditionP1bD2 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bD2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bD2.length, exExFlag)
    strAdditionP1bD2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bD2.length, exExFlag)
    strAdditionP1bD2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bD2.length, exExFlag)

    strAdditionP1bD3 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bD3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bD3.length, exExFlag)
    strAdditionP1bD3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bD3.length, exExFlag)
    strAdditionP1bD3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bD3.length, exExFlag)

    strAdditionP1bE1 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bE1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bE1.length, exExFlag)
    strAdditionP1bE1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bE1.length, exExFlag)
    strAdditionP1bE1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bE1.length, exExFlag)

    strAdditionP1bE2 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bE2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bE2.length, exExFlag)
    strAdditionP1bE2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bE2.length, exExFlag)
    strAdditionP1bE2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bE2.length, exExFlag)

    strAdditionP1bE3 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bE3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bE3.length, exExFlag)
    strAdditionP1bE3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bE3.length, exExFlag)
    strAdditionP1bE3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bE3.length, exExFlag)

    strAdditionP1bF1 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bF1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bF1.length, exExFlag)
    strAdditionP1bF1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bF1.length, exExFlag)
    strAdditionP1bF1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bF1.length, exExFlag)

    strAdditionP1bF2 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bF2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bF2.length, exExFlag)
    strAdditionP1bF2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bF2.length, exExFlag)
    strAdditionP1bF2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bF2.length, exExFlag)

    strAdditionP1bF3 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bF3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bF3.length, exExFlag)
    strAdditionP1bF3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bF3.length, exExFlag)
    strAdditionP1bF3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bF3.length, exExFlag)

    strAdditionP1bG1 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bG1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bG1.length, exExFlag)
    strAdditionP1bG1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bG1.length, exExFlag)
    strAdditionP1bG1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bG1.length, exExFlag)

    strAdditionP1bG2 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bG2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bG2.length, exExFlag)
    strAdditionP1bG2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bG2.length, exExFlag)
    strAdditionP1bG2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bG2.length, exExFlag)

    strAdditionP1bG3 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bG3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bG3.length, exExFlag)
    strAdditionP1bG3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bG3.length, exExFlag)
    strAdditionP1bG3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bG3.length, exExFlag)

    strAdditionP1bH1 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bH1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bH1.length, exExFlag)
    strAdditionP1bH1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bH1.length, exExFlag)
    strAdditionP1bH1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bH1.length, exExFlag)

    strAdditionP1bH2 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bH2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bH2.length, exExFlag)
    strAdditionP1bH2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bH2.length, exExFlag)
    strAdditionP1bH2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bH2.length, exExFlag)

    strAdditionP1bH3 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bH3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bH3.length, exExFlag)
    strAdditionP1bH3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bH3.length, exExFlag)
    strAdditionP1bH3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bH3.length, exExFlag)

    strAdditionP1bI1 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bI1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bI1.length, exExFlag)
    strAdditionP1bI1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bI1.length, exExFlag)
    strAdditionP1bI1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bI1.length, exExFlag)

    strAdditionP1bI2 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bI2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bI2.length, exExFlag)
    strAdditionP1bI2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bI2.length, exExFlag)
    strAdditionP1bI2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bI2.length, exExFlag)

    strAdditionP1bI3 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bI3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bI3.length, exExFlag)
    strAdditionP1bI3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bI3.length, exExFlag)
    strAdditionP1bI3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bI3.length, exExFlag)

    strAdditionP1bJ1 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bJ1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bJ1.length, exExFlag)
    strAdditionP1bJ1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bJ1.length, exExFlag)
    strAdditionP1bJ1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bJ1.length, exExFlag)

    strAdditionP1bJ2 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bJ2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bJ2.length, exExFlag)
    strAdditionP1bJ2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bJ2.length, exExFlag)
    strAdditionP1bJ2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bJ2.length, exExFlag)

    strAdditionP1bJ3 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bJ3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bJ3.length, exExFlag)
    strAdditionP1bJ3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bJ3.length, exExFlag)
    strAdditionP1bJ3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bJ3.length, exExFlag)

    strAdditionP1bK1 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bK1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bK1.length, exExFlag)
    strAdditionP1bK1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bK1.length, exExFlag)
    strAdditionP1bK1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bK1.length, exExFlag)

    strAdditionP1bK2 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bK2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bK2.length, exExFlag)
    strAdditionP1bK2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bK2.length, exExFlag)
    strAdditionP1bK2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bK2.length, exExFlag)

    strAdditionP1bK3 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bK3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bK3.length, exExFlag)
    strAdditionP1bK3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bK3.length, exExFlag)
    strAdditionP1bK3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bK3.length, exExFlag)

    strAdditionP1bL1 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bL1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bL1.length, exExFlag)
    strAdditionP1bL1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bL1.length, exExFlag)
    strAdditionP1bL1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bL1.length, exExFlag)

    strAdditionP1bL2 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bL2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bL2.length, exExFlag)
    strAdditionP1bL2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bL2.length, exExFlag)
    strAdditionP1bL2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bL2.length, exExFlag)

    strAdditionP1bL3 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bL3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bL3.length, exExFlag)
    strAdditionP1bL3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bL3.length, exExFlag)
    strAdditionP1bL3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bL3.length, exExFlag)

    strAdditionP1bM1 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bM1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bM1.length, exExFlag)
    strAdditionP1bM1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bM1.length, exExFlag)
    strAdditionP1bM1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bM1.length, exExFlag)

    strAdditionP1bM2 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bM2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bM2.length, exExFlag)
    strAdditionP1bM2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bM2.length, exExFlag)
    strAdditionP1bM2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bM2.length, exExFlag)

    strAdditionP1bM3 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bM3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bM3.length, exExFlag)
    strAdditionP1bM3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bM3.length, exExFlag)
    strAdditionP1bM3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bM3.length, exExFlag)

    strAdditionP1bN1 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bN1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bN1.length, exExFlag)
    strAdditionP1bN1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bN1.length, exExFlag)
    strAdditionP1bN1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bN1.length, exExFlag)

    strAdditionP1bN2 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bN2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bN2.length, exExFlag)
    strAdditionP1bN2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bN2.length, exExFlag)
    strAdditionP1bN2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bN2.length, exExFlag)

    strAdditionP1bN3 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bN3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bN3.length, exExFlag)
    strAdditionP1bN3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bN3.length, exExFlag)
    strAdditionP1bN3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bN3.length, exExFlag)

    strAdditionP1bO1 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bO1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bO1.length, exExFlag)
    strAdditionP1bO1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bO1.length, exExFlag)
    strAdditionP1bO1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bO1.length, exExFlag)

    strAdditionP1bO2 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bO2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bO2.length, exExFlag)
    strAdditionP1bO2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bO2.length, exExFlag)
    strAdditionP1bO2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bO2.length, exExFlag)

    strAdditionP1bO3 = SpannableString(" நாமதேயா வஸுரூப")
    strAdditionP1bO3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1bO3.length, exExFlag)
    strAdditionP1bO3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1bO3.length, exExFlag)
    strAdditionP1bO3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1bO3.length, exExFlag)

    strAdditionP1cA1 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cA1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cA1.length, exExFlag)
    strAdditionP1cA1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cA1.length, exExFlag)
    strAdditionP1cA1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cA1.length, exExFlag)

    strAdditionP1cA2 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cA2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cA2.length, exExFlag)
    strAdditionP1cA2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cA2.length, exExFlag)
    strAdditionP1cA2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cA2.length, exExFlag)

    strAdditionP1cA3 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cA3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cA3.length, exExFlag)
    strAdditionP1cA3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cA3.length, exExFlag)
    strAdditionP1cA3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cA3.length, exExFlag)

    strAdditionP1cB1 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cB1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cB1.length, exExFlag)
    strAdditionP1cB1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cB1.length, exExFlag)
    strAdditionP1cB1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cB1.length, exExFlag)

    strAdditionP1cB2 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cB2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cB2.length, exExFlag)
    strAdditionP1cB2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cB2.length, exExFlag)
    strAdditionP1cB2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cB2.length, exExFlag)

    strAdditionP1cB3 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cB3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cB3.length, exExFlag)
    strAdditionP1cB3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cB3.length, exExFlag)
    strAdditionP1cB3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cB3.length, exExFlag)

    strAdditionP1cC1 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cC1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cC1.length, exExFlag)
    strAdditionP1cC1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cC1.length, exExFlag)
    strAdditionP1cC1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cC1.length, exExFlag)

    strAdditionP1cC2 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cC2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cC2.length, exExFlag)
    strAdditionP1cC2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cC2.length, exExFlag)
    strAdditionP1cC2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cC2.length, exExFlag)

    strAdditionP1cC3 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cC3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cC3.length, exExFlag)
    strAdditionP1cC3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cC3.length, exExFlag)
    strAdditionP1cC3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cC3.length, exExFlag)

    strAdditionP1cD1 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cD1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cD1.length, exExFlag)
    strAdditionP1cD1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cD1.length, exExFlag)
    strAdditionP1cD1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cD1.length, exExFlag)

    strAdditionP1cD2 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cD2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cD2.length, exExFlag)
    strAdditionP1cD2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cD2.length, exExFlag)
    strAdditionP1cD2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cD2.length, exExFlag)

    strAdditionP1cD3 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cD3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cD3.length, exExFlag)
    strAdditionP1cD3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cD3.length, exExFlag)
    strAdditionP1cD3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cD3.length, exExFlag)

    strAdditionP1cE1 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cE1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cE1.length, exExFlag)
    strAdditionP1cE1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cE1.length, exExFlag)
    strAdditionP1cE1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cE1.length, exExFlag)

    strAdditionP1cE2 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cE2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cE2.length, exExFlag)
    strAdditionP1cE2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cE2.length, exExFlag)
    strAdditionP1cE2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cE2.length, exExFlag)

    strAdditionP1cE3 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cE3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cE3.length, exExFlag)
    strAdditionP1cE3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cE3.length, exExFlag)
    strAdditionP1cE3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cE3.length, exExFlag)

    strAdditionP1cF1 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cF1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cF1.length, exExFlag)
    strAdditionP1cF1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cF1.length, exExFlag)
    strAdditionP1cF1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cF1.length, exExFlag)

    strAdditionP1cF2 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cF2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cF2.length, exExFlag)
    strAdditionP1cF2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cF2.length, exExFlag)
    strAdditionP1cF2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cF2.length, exExFlag)

    strAdditionP1cF3 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cF3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cF3.length, exExFlag)
    strAdditionP1cF3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cF3.length, exExFlag)
    strAdditionP1cF3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cF3.length, exExFlag)

    strAdditionP1cG1 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cG1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cG1.length, exExFlag)
    strAdditionP1cG1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cG1.length, exExFlag)
    strAdditionP1cG1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cG1.length, exExFlag)

    strAdditionP1cG2 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cG2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cG2.length, exExFlag)
    strAdditionP1cG2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cG2.length, exExFlag)
    strAdditionP1cG2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cG2.length, exExFlag)

    strAdditionP1cG3 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cG3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cG3.length, exExFlag)
    strAdditionP1cG3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cG3.length, exExFlag)
    strAdditionP1cG3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cG3.length, exExFlag)

    strAdditionP1cH1 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cH1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cH1.length, exExFlag)
    strAdditionP1cH1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cH1.length, exExFlag)
    strAdditionP1cH1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cH1.length, exExFlag)

    strAdditionP1cH2 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cH2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cH2.length, exExFlag)
    strAdditionP1cH2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cH2.length, exExFlag)
    strAdditionP1cH2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cH2.length, exExFlag)

    strAdditionP1cH3 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cH3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cH3.length, exExFlag)
    strAdditionP1cH3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cH3.length, exExFlag)
    strAdditionP1cH3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cH3.length, exExFlag)

    strAdditionP1cI1 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cI1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cI1.length, exExFlag)
    strAdditionP1cI1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cI1.length, exExFlag)
    strAdditionP1cI1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cI1.length, exExFlag)

    strAdditionP1cI2 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cI2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cI2.length, exExFlag)
    strAdditionP1cI2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cI2.length, exExFlag)
    strAdditionP1cI2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cI2.length, exExFlag)

    strAdditionP1cI3 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cI3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cI3.length, exExFlag)
    strAdditionP1cI3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cI3.length, exExFlag)
    strAdditionP1cI3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cI3.length, exExFlag)

    strAdditionP1cJ1 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cJ1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cJ1.length, exExFlag)
    strAdditionP1cJ1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cJ1.length, exExFlag)
    strAdditionP1cJ1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cJ1.length, exExFlag)

    strAdditionP1cJ2 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cJ2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cJ2.length, exExFlag)
    strAdditionP1cJ2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cJ2.length, exExFlag)
    strAdditionP1cJ2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cJ2.length, exExFlag)

    strAdditionP1cJ3 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cJ3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cJ3.length, exExFlag)
    strAdditionP1cJ3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cJ3.length, exExFlag)
    strAdditionP1cJ3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cJ3.length, exExFlag)

    strAdditionP1cK1 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cK1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cK1.length, exExFlag)
    strAdditionP1cK1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cK1.length, exExFlag)
    strAdditionP1cK1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cK1.length, exExFlag)

    strAdditionP1cK2 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cK2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cK2.length, exExFlag)
    strAdditionP1cK2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cK2.length, exExFlag)
    strAdditionP1cK2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cK2.length, exExFlag)

    strAdditionP1cK3 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cK3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cK3.length, exExFlag)
    strAdditionP1cK3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cK3.length, exExFlag)
    strAdditionP1cK3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cK3.length, exExFlag)

    strAdditionP1cL1 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cL1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cL1.length, exExFlag)
    strAdditionP1cL1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cL1.length, exExFlag)
    strAdditionP1cL1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cL1.length, exExFlag)

    strAdditionP1cL2 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cL2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cL2.length, exExFlag)
    strAdditionP1cL2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cL2.length, exExFlag)
    strAdditionP1cL2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cL2.length, exExFlag)

    strAdditionP1cL3 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cL3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cL3.length, exExFlag)
    strAdditionP1cL3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cL3.length, exExFlag)
    strAdditionP1cL3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cL3.length, exExFlag)

    strAdditionP1cM1 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cM1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cM1.length, exExFlag)
    strAdditionP1cM1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cM1.length, exExFlag)
    strAdditionP1cM1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cM1.length, exExFlag)

    strAdditionP1cM2 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cM2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cM2.length, exExFlag)
    strAdditionP1cM2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cM2.length, exExFlag)
    strAdditionP1cM2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cM2.length, exExFlag)

    strAdditionP1cM3 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cM3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cM3.length, exExFlag)
    strAdditionP1cM3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cM3.length, exExFlag)
    strAdditionP1cM3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cM3.length, exExFlag)

    strAdditionP1cN1 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cN1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cN1.length, exExFlag)
    strAdditionP1cN1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cN1.length, exExFlag)
    strAdditionP1cN1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cN1.length, exExFlag)

    strAdditionP1cN2 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cN2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cN2.length, exExFlag)
    strAdditionP1cN2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cN2.length, exExFlag)
    strAdditionP1cN2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cN2.length, exExFlag)

    strAdditionP1cN3 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cN3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cN3.length, exExFlag)
    strAdditionP1cN3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cN3.length, exExFlag)
    strAdditionP1cN3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cN3.length, exExFlag)

    strAdditionP1cO1 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cO1.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cO1.length, exExFlag)
    strAdditionP1cO1.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cO1.length, exExFlag)
    strAdditionP1cO1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cO1.length, exExFlag)

    strAdditionP1cO2 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cO2.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cO2.length, exExFlag)
    strAdditionP1cO2.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cO2.length, exExFlag)
    strAdditionP1cO2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cO2.length, exExFlag)

    strAdditionP1cO3 = SpannableString(" ஸ்வதா நமஸ்த் த்ருப்யதாம்")
    strAdditionP1cO3.setSpan(AbsoluteSizeSpan(14, true), start, strAdditionP1cO3.length, exExFlag)
    strAdditionP1cO3.setSpan(StyleSpan(Typeface.BOLD), start, strAdditionP1cO3.length, exExFlag)
    strAdditionP1cO3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, strAdditionP1cO3.length, exExFlag)

    space = SpannableString("\n")

    mBody87P1 = SpannableString("   ஓம் உதீரதாம் அவரே உத்பராஸ: உந்மத்யமா: பிதர: ஸோம்யாஸ: அஸூம்யஈயு: அவ்ருகா: " +
            "ருதக்ஞா: தேநோவந்து பிதரோஹவேஷூ உபயவம்சே பவானாம் பித்ருவ்ய மாதுலாதி ஞாத அக்ஞாதானாம் தத்தத் கோத்ரா: " +
            "தத்தத் சர்மாண: வஸுவஸு ஸ்வரூபா: பித்ருவ்ய மாதுலாதி வர்க்கத்வய அவசிஷ்டா: ஸர்வே காருணிக பித்ர: ஸ்வதா நமஸ்த்ருப்யந்தாம்\n")
    mBody87P1.setSpan(AbsoluteSizeSpan(14, true), start, mBody87P1.length, exExFlag)
    mBody87P1.setSpan(StyleSpan(Typeface.BOLD), start, mBody87P1.length, exExFlag)
    mBody87P1.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody87P1.length, exExFlag)

    mBody87P2 = SpannableString("   ஓம் அங்கீரஸோந: பிதரோ நவக்வா: அதர்வாண: ப்ருகவ: ஸோம்யாஸ: தேஷாம்வயம் ஸூமதௌ யக்ஞியாநாம் " +
            "அபிபத்ரே ஸௌமனஸே ஸ்யாம உபயவம்சே பவானாம் பித்ருவ்ய மாதுலாதி ஞாத அக்ஞாதானாம் தத்தத் கோத்ரா: தத்தத் சர்மாண: வஸுவஸு ஸ்வரூபா: " +
            "பித்ருவ்ய மாதுலாதி வர்க்கத்வய அவசிஷ்டா: ஸர்வே காருணிக பித்ர: ஸ்வதா நமஸ்த்ருப்யந்தாம்\n")
    mBody87P2.setSpan(AbsoluteSizeSpan(14, true), start, mBody87P2.length, exExFlag)
    mBody87P2.setSpan(StyleSpan(Typeface.BOLD), start, mBody87P2.length, exExFlag)
    mBody87P2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody87P2.length, exExFlag)

    mBody87P3 = SpannableString("   ஓம் ஆயந்துந: பிதர: ஸோம்யாஸ: அக்னிஷ்வாத்தா: பதிபி: தேவயானை: அஸ்மின் யக்ஞே ஸ்வதயா மதந்த: " +
            "அதிப்ருவந்து தேவந்து அஸ்மான் உபயவம்சே பவானாம் பித்ருவ்ய மாதுலாதி ஞாத அக்ஞாதானாம் தத்தத் கோத்ரா: தத்தத் சர்மாண: " +
            "வஸுவஸு ஸ்வரூபா: பித்ருவ்ய மாதுலாதி வர்க்கத்வய அவசிஷ்டா: ஸர்வே காருணிக பித்ர: ஸ்வதா நமஸ்த்ருப்யந்தாம்்\n\nத்ருப்யத்வம்     " +
            "த்ருப்யத்வம்     த்ருப்யத்வம் \n")
    mBody87P3.setSpan(AbsoluteSizeSpan(14, true), start, mBody87P3.length, exExFlag)
    mBody87P3.setSpan(StyleSpan(Typeface.BOLD), start, mBody87P3.length, exExFlag)
    mBody87P3.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody87P3.length, exExFlag)

    mComment51 = SpannableString("\n வடக்கு நோக்கி கீழ்வரும் மந்திரங்களை கூறவும் ")
    mComment51.setSpan(AbsoluteSizeSpan(13, true), start, mComment51.length, exExFlag)
    mComment51.setSpan(StyleSpan(Typeface.ITALIC), start, mComment51.length, exExFlag)
    mComment51.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment51.length, exExFlag)

    mBody88 = SpannableString("\nஓம் அத்ரபிதர: மாதயத்வம் யாதாபாகம் ஆவ்ருஷாயத்வம் அமீமதந்த பிதர: யதாபாகம் ஆவ்ருஷாயிஷத\n\n")
    mBody88.setSpan(AbsoluteSizeSpan(14, true), start, mBody88.length, exExFlag)
    mBody88.setSpan(StyleSpan(Typeface.BOLD), start, mBody88.length, exExFlag)
    mBody88.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody88.length, exExFlag)

    mComment51a = SpannableString("\nபூணல்  ")
    mComment51a.setSpan(AbsoluteSizeSpan(13, true), start, mComment51a.length, exExFlag)
    mComment51a.setSpan(StyleSpan(Typeface.ITALIC), start, mComment51a.length, exExFlag)
    mComment51a.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment51a.length, exExFlag)

    mGreenComment2 = SpannableString(" ஸவ்யம் ")
    mGreenComment2.setSpan(AbsoluteSizeSpan(13, true), start, mGreenComment2.length, exExFlag)
    mGreenComment2.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, mGreenComment2.length, exExFlag)
    mGreenComment2.setSpan(ForegroundColorSpan(Color.GREEN), start, mGreenComment2.length, exExFlag)


    mComment52 = SpannableString("   கிழக்கு நோக்கி பித்ருக்களை ப்ரார்த்தனை செய்து கொண்டு கீழ்வரும் மந்திரங்களை கூறவும்")
    mComment52.setSpan(AbsoluteSizeSpan(13, true), start, mComment52.length, exExFlag)
    mComment52.setSpan(StyleSpan(Typeface.ITALIC), start, mComment52.length, exExFlag)
    mComment52.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment52.length, exExFlag)

    mBody89 = SpannableString("\nஓம் நமோவ: பிதர: ஸூஷ்மாய நமோவ: பிதர: தபஸே நமோவ: பிதர: " +
                "யஜ்ஜீவம் தஸ்மை நமோவ: பிதர: ரஸாய நமோவ: பிதர: கோராய மன்யவே ஸ்வதாயைவ: பிதரோ நம:\n")
    mBody89.setSpan(AbsoluteSizeSpan(14, true), start, mBody89.length, exExFlag)
    mBody89.setSpan(StyleSpan(Typeface.BOLD), start, mBody89.length, exExFlag)
    mBody89.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody89.length, exExFlag)

    mRedComment4 = SpannableString("அபஸவ்யம் ")
    mRedComment4.setSpan(AbsoluteSizeSpan(13, true), start, mRedComment4.length, exExFlag)
    mRedComment4.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, mRedComment4.length, exExFlag)
    mRedComment4.setSpan(ForegroundColorSpan(Color.RED), start, mRedComment4.length, exExFlag)

    mComment53 = SpannableString("\n  கட்டதர்பங்களை எடுத்துக்கொண்டு மந்திரம் சொல்லி")
    mComment53.setSpan(AbsoluteSizeSpan(13, true), start, mComment53.length, exExFlag)
    mComment53.setSpan(StyleSpan(Typeface.ITALIC), start, mComment53.length, exExFlag)
    mComment53.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment53.length, exExFlag)

    mComment54 = SpannableString(" இரண்டு ")
    mComment54.setSpan(AbsoluteSizeSpan(13, true), start, mComment54.length, exExFlag)
    mComment54.setSpan(StyleSpan(Typeface.ITALIC), start, mComment54.length, exExFlag)
    mComment54.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment54.length, exExFlag)

    mComment54a = SpannableString(" மூன்று ")
    mComment54a.setSpan(AbsoluteSizeSpan(13, true), start, mComment54a.length, exExFlag)
    mComment54a.setSpan(StyleSpan(Typeface.ITALIC), start, mComment54a.length, exExFlag)
    mComment54a.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment54a.length, exExFlag)

    mComment55 = SpannableString("கூர்ச்சத்தின் மீது வைக்கவும்")
    mComment55.setSpan(AbsoluteSizeSpan(13, true), start, mComment55.length, exExFlag)
    mComment55.setSpan(StyleSpan(Typeface.ITALIC), start, mComment55.length, exExFlag)
    mComment55.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment55.length, exExFlag)

    mComment55A = SpannableString("\nமேல் கூர்ச்சம்")
    mComment55A.setSpan(AbsoluteSizeSpan(13, true), start, mComment55A.length, exExFlag)
    mComment55A.setSpan(StyleSpan(Typeface.ITALIC), start, mComment55A.length, exExFlag)
    mComment55A.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, mComment55A.length, exExFlag)

    mBody90 = SpannableString("\nஓம் ஏதத்வ: பிதரோவாஸ: க்ருஹான்ன: பிதரோதத்த: உதாயுஷா ஸ்வாயுஷா உத்பர்ஜந்யஸ்ய " +
                "தாமபி: உதஸ்தாம் அம்ருதாம் அநு\n")
    mBody90.setSpan(AbsoluteSizeSpan(14, true), start, mBody90.length, exExFlag)
    mBody90.setSpan(StyleSpan(Typeface.BOLD), start, mBody90.length, exExFlag)
    mBody90.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody90.length, exExFlag)

    mBody90P = SpannableString("\nஓம் ஏதத்வ: பிதரோவாஸ: க்ருஹான்ன: பிதரோதத்த: உதாயுஷா ஸ்வாயுஷா உத்பர்ஜந்யஸ்ய " +
                "தாமபி: உதஸ்தாம் அம்ருதாம் அநு\n")
    mBody90P.setSpan(AbsoluteSizeSpan(14, true), start, mBody90P.length, exExFlag)
    mBody90P.setSpan(StyleSpan(Typeface.BOLD), start, mBody90P.length, exExFlag)
    mBody90P.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody90P.length, exExFlag)

    mComment55BP = SpannableString("\n நடு கூர்ச்சம் ")
    mComment55BP.setSpan(AbsoluteSizeSpan(13, true), start, mComment55BP.length, exExFlag)
    mComment55BP.setSpan(StyleSpan(Typeface.ITALIC), start, mComment55BP.length, exExFlag)
    mComment55BP.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, mComment55BP.length, exExFlag)

    mComment55B = SpannableString("\n கீழ் கூர்ச்சம் ")
    mComment55B.setSpan(AbsoluteSizeSpan(13, true), start, mComment55B.length, exExFlag)
    mComment55B.setSpan(StyleSpan(Typeface.ITALIC), start, mComment55B.length, exExFlag)
    mComment55B.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, mComment55B.length, exExFlag)

    mBody90P2 = SpannableString("\nஓம் ஏதத்வ: பிதரோவாஸ: க்ருஹான்ன: பிதரோதத்த: உதாயுஷா ஸ்வாயுஷா உத்பர்ஜந்யஸ்ய " +
                "தாமபி: உதஸ்தாம் அம்ருதாம் அநு\n")
    mBody90P2.setSpan(AbsoluteSizeSpan(14, true), start, mBody90P2.length, exExFlag)
    mBody90P2.setSpan(StyleSpan(Typeface.BOLD), start, mBody90P2.length, exExFlag)
    mBody90P2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody90P2.length, exExFlag)

    mComment55C = SpannableString("\n  மேல்கூர்ச்சத்திற்கு")
    mComment55C.setSpan(AbsoluteSizeSpan(13, true), start, mComment55C.length, exExFlag)
    mComment55C.setSpan(StyleSpan(Typeface.ITALIC), start, mComment55C.length, exExFlag)
    mComment55C.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, mComment55C.length, exExFlag)

    mComment56 = SpannableString("\n கீழ் வரும் மந்திரம் கூறி எள்ளை")
    mComment56.setSpan(AbsoluteSizeSpan(13, true), start, mComment56.length, exExFlag)
    mComment56.setSpan(StyleSpan(Typeface.ITALIC), start, mComment56.length, exExFlag)
    mComment56.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment56.length, exExFlag)

    mComment57 = SpannableString("\nகீழ் வரும் மந்திரம் கூறி எள்ளும், சிறிது அரிசியையும்")
    mComment57.setSpan(AbsoluteSizeSpan(13, true), start, mComment57.length, exExFlag)
    mComment57.setSpan(StyleSpan(Typeface.ITALIC), start, mComment57.length, exExFlag)
    mComment57.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment57.length, exExFlag)

    mComment57A = SpannableString("\n இரண்டு கூர்ச்சத்திற்கும் கீழ் வரும் மந்திரம் கூறி எள்ளும், சிறிது அரிசியையும்")
    mComment57A.setSpan(AbsoluteSizeSpan(13, true), start, mComment57A.length, exExFlag)
    mComment57A.setSpan(StyleSpan(Typeface.ITALIC), start, mComment57A.length, exExFlag)
    mComment57A.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment57A.length, exExFlag)

    mComment58 = SpannableString(" ஜலமும் விடவும் ")
    mComment58.setSpan(AbsoluteSizeSpan(13, true), start, mComment58.length, exExFlag)
    mComment58.setSpan(StyleSpan(Typeface.ITALIC), start, mComment58.length, exExFlag)
    mComment58.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment58.length, exExFlag)

    mComment58A = SpannableString("யும் ஜலமும் விடவும் ")
    mComment58A.setSpan(AbsoluteSizeSpan(13, true), start, mComment58A.length, exExFlag)
    mComment58A.setSpan(StyleSpan(Typeface.ITALIC), start, mComment58A.length, exExFlag)
    mComment58A.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment58A.length, exExFlag)

    mBody91 = SpannableString("\nஓம் ஊர்ஜம்வஹந்தீ: அம்ருதம்க்ருதம்பய: கீலாலம் பரிஸ்ருதம் ஸ்வதாஸ்த தர்ப்பயதமே பித்ரூன்" +
                "\nத்ருப்யத்வம்     த்ருப்யத்வம்     த்ருப்யத்வம்\n")
    mBody91.setSpan(AbsoluteSizeSpan(14, true), start, mBody91.length, exExFlag)
    mBody91.setSpan(StyleSpan(Typeface.BOLD), start, mBody91.length, exExFlag)
    mBody91.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody91.length, exExFlag)

    mComment55DP = SpannableString("\n  நடுகூர்ச்சத்திற்கு ")
    mComment55DP.setSpan(AbsoluteSizeSpan(13, true), start, mComment55DP.length, exExFlag)
    mComment55DP.setSpan(StyleSpan(Typeface.ITALIC), start, mComment55DP.length, exExFlag)
    mComment55DP.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, mComment55DP.length, exExFlag)

    mComment55D = SpannableString("\n  கீழ்கூர்ச்சத்திற்கு ")
    mComment55D.setSpan(AbsoluteSizeSpan(13, true), start, mComment55D.length, exExFlag)
    mComment55D.setSpan(StyleSpan(Typeface.ITALIC), start, mComment55D.length, exExFlag)
    mComment55D.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, mComment55D.length, exExFlag)

    mMBody91P = SpannableString("\nஓம் ஊர்ஜம்வஹந்தீ: அம்ருதம்க்ருதம்பய: கீலாலம் பரிஸ்ருதம் ஸ்வதாஸ்த தர்ப்பயதமே பித்ரூன்" +
                "\nத்ருப்யத்வம்     த்ருப்யத்வம்     த்ருப்யத்வம்\n")
    mMBody91P.setSpan(AbsoluteSizeSpan(14, true), start, mMBody91P.length, exExFlag)
    mMBody91P.setSpan(StyleSpan(Typeface.BOLD), start, mMBody91P.length, exExFlag)
    mMBody91P.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mMBody91P.length, exExFlag)

    mMBody91 = SpannableString("\nஓம் ஊர்ஜம்வஹந்தீ: அம்ருதம்க்ருதம்பய: கீலாலம் பரிஸ்ருதம் ஸ்வதாஸ்த தர்ப்பயதமே பித்ரூன்" +
                "\nத்ருப்யத்வம்     த்ருப்யத்வம்     த்ருப்யத்வம்\n")
    mMBody91.setSpan(AbsoluteSizeSpan(14, true), start, mMBody91.length, exExFlag)
    mMBody91.setSpan(StyleSpan(Typeface.BOLD), start, mMBody91.length, exExFlag)
    mMBody91.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mMBody91.length, exExFlag)

    mComment55EP = SpannableString("\n  மூன்று கூர்ச்சத்திற்கு எள்ளை")
    mComment55EP.setSpan(AbsoluteSizeSpan(13, true), start, mComment55EP.length, exExFlag)
    mComment55EP.setSpan(StyleSpan(Typeface.ITALIC), start, mComment55EP.length, exExFlag)
    mComment55EP.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment55EP.length, exExFlag)

    mComment55E = SpannableString("\n" +
            "  இரண்டு கூர்ச்சத்திற்கும் கீழ் வரும் மந்திரம் கூறி எள்ளும்,")
    mComment55E.setSpan(AbsoluteSizeSpan(13, true), start, mComment55E.length, exExFlag)
    mComment55E.setSpan(StyleSpan(Typeface.ITALIC), start, mComment55E.length, exExFlag)
    mComment55E.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment55E.length, exExFlag)

    mMBody91A = SpannableString("\n\nஆப்ரம்ஹ ஸ்தம்ப பர்யந்தம் தேவரிஷி பித்ருமானவா: த்ருப்யந்து பிதர: ஸர்வே மாத்ரு மாதாமஹாதய: " +
                "அதீதகுல கோடீநாம் ஸப்தத்வீப நிவாஸிநாம் ஆப்ரம்ஹ புவனாந் லோகான் " +
            "\nஇதமஸ்து திலோதகம் " +
            "\n        இதமஸ்து திலோதகம் " +
            "\n                இதமஸ்து திலோதகம்")
    mMBody91A.setSpan(AbsoluteSizeSpan(14, true), start, mMBody91A.length, exExFlag)
    mMBody91A.setSpan(StyleSpan(Typeface.BOLD), start, mMBody91A.length, exExFlag)
    mMBody91A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mMBody91A.length, exExFlag)

    mGreenComment3 = SpannableString(" ஸவ்யம் ")
    mGreenComment3.setSpan(AbsoluteSizeSpan(13, true), start, mGreenComment3.length, exExFlag)
    mGreenComment3.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, mGreenComment3.length, exExFlag)
    mGreenComment3.setSpan(ForegroundColorSpan(Color.GREEN), start, mGreenComment3.length, exExFlag)

    mBody92 = SpannableString("\nமமோ பார்த்த சமஸ்த துரித க்ஷயத்வாரா ஸ்ரீ பரமேஸ்வர ப்ரீத்யர்த்தம் வாஜே வாஜே அவத இதி மந்த்ரேன ஸகாருண்யக ")
    mBody92.setSpan(AbsoluteSizeSpan(14, true), start, mBody92.length, exExFlag)
    mBody92.setSpan(StyleSpan(Typeface.BOLD), start, mBody92.length, exExFlag)
    mBody92.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody92.length, exExFlag)

    mVARGAI1A = SpannableString(" வர்கைக ")
    mVARGAI1A.setSpan(AbsoluteSizeSpan(14, true), start, mVARGAI1A.length, exExFlag)
    mVARGAI1A.setSpan(StyleSpan(Typeface.BOLD), start, mVARGAI1A.length, exExFlag)
    mVARGAI1A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mVARGAI1A.length, exExFlag)

    mVARGAI1B = SpannableString(" வர்கத்வய ")
    mVARGAI1B.setSpan(AbsoluteSizeSpan(14, true), start, mVARGAI1B.length, exExFlag)
    mVARGAI1B.setSpan(StyleSpan(Typeface.BOLD), start, mVARGAI1B.length, exExFlag)
    mVARGAI1B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mVARGAI1B.length, exExFlag)

    mBody93 = SpannableString(" பித்ரு விசர்ஜனம் கரிஷ்யே  \nஅபஉபஸ்ய்ருஸ்ய")
    mBody93.setSpan(AbsoluteSizeSpan(14, true), start, mBody93.length, exExFlag)
    mBody93.setSpan(StyleSpan(Typeface.BOLD), start, mBody93.length, exExFlag)
    mBody93.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody93.length, exExFlag)

    mComment59 = SpannableString("\n என்று ஜலத்தை தொடவும்\n\nநெற்றியில் கை வைத்துக் கொண்டு\n ")
    mComment59.setSpan(AbsoluteSizeSpan(13, true), start, mComment59.length, exExFlag)
    mComment59.setSpan(StyleSpan(Typeface.ITALIC), start, mComment59.length, exExFlag)
    mComment59.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment59.length, exExFlag)

    mBody94 = SpannableString("வாஜே வாஜே அவத இத்யஸ்ய மந்த்ரஸ்ய  வஸிஷ்டரிஷி:")
    mBody94.setSpan(AbsoluteSizeSpan(14, true), start, mBody94.length, exExFlag)
    mBody94.setSpan(StyleSpan(Typeface.BOLD), start, mBody94.length, exExFlag)
    mBody94.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody94.length, exExFlag)

    mComment60 = SpannableString("\n(மூக்கு நுனியை தொட்டுக்கொண்டு)\n ")
    mComment60.setSpan(AbsoluteSizeSpan(13, true), start, mComment60.length, exExFlag)
    mComment60.setSpan(StyleSpan(Typeface.ITALIC), start, mComment60.length, exExFlag)
    mComment60.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment60.length, exExFlag)

    mBody95 = SpannableString("த்ருஷ்டுப்சந்த:")
    mBody95.setSpan(AbsoluteSizeSpan(14, true), start, mBody95.length, exExFlag)
    mBody95.setSpan(StyleSpan(Typeface.BOLD), start, mBody95.length, exExFlag)
    mBody95.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody95.length, exExFlag)

    mComment61 = SpannableString("\n(ஹிருதயத்தைத் தொட்டுக்கொண்டு)\n")
    mComment61.setSpan(AbsoluteSizeSpan(13, true), start, mComment61.length, exExFlag)
    mComment61.setSpan(StyleSpan(Typeface.ITALIC), start, mComment61.length, exExFlag)
    mComment61.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment61.length, exExFlag)

    mBody96 = SpannableString("வாஜிநோ தேவதா ஆவாஹித ஸகாருண்யக")
    mBody96.setSpan(AbsoluteSizeSpan(14, true), start, mBody96.length, exExFlag)
    mBody96.setSpan(StyleSpan(Typeface.BOLD), start, mBody96.length, exExFlag)
    mBody96.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody96.length, exExFlag)

    mVARGAI2A = SpannableString(" வர்கைக ")
    mVARGAI2A.setSpan(AbsoluteSizeSpan(14, true), start, mVARGAI2A.length, exExFlag)
    mVARGAI2A.setSpan(StyleSpan(Typeface.BOLD), start, mVARGAI2A.length, exExFlag)
    mVARGAI2A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mVARGAI2A.length, exExFlag)

    mVARGAI1BP = SpannableString(" வர்கத்வய ")
    mVARGAI1BP.setSpan(AbsoluteSizeSpan(14, true), start, mVARGAI1BP.length, exExFlag)
    mVARGAI1BP.setSpan(StyleSpan(Typeface.BOLD), start, mVARGAI1BP.length, exExFlag)
    mVARGAI1BP.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mVARGAI1BP.length, exExFlag)

    mBody97 = SpannableString("பித்ரு விஸர்ஜனே வினியோக:")
    mBody97.setSpan(AbsoluteSizeSpan(14, true), start, mBody97.length, exExFlag)
    mBody97.setSpan(StyleSpan(Typeface.BOLD), start, mBody97.length, exExFlag)
    mBody97.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody97.length, exExFlag)

    mComment62 = SpannableString("\n என்று கைகளை உள்வாங்கவும்\n")
    mComment62.setSpan(AbsoluteSizeSpan(13, true), start, mComment62.length, exExFlag)
    mComment62.setSpan(StyleSpan(Typeface.ITALIC), start, mComment62.length, exExFlag)
    mComment62.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment62.length, exExFlag)

    mHeading6 = SpannableString("\nவிஸர்ஜனம்\n")
    mHeading6.setSpan(AbsoluteSizeSpan(16, true), start, mHeading6.length, exExFlag)
    mHeading6.setSpan(StyleSpan(Typeface.BOLD), start, mHeading6.length, exExFlag)
    mHeading6.setSpan(UnderlineSpan(), start, mHeading6.length, exExFlag)
    mHeading6.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, mHeading6.length, exExFlag)

    mRedComment5 = SpannableString("அபஸவ்யம் ")
    mRedComment5.setSpan(AbsoluteSizeSpan(13, true), start, mRedComment5.length, exExFlag)
    mRedComment5.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, mRedComment5.length, exExFlag)
    mRedComment5.setSpan(ForegroundColorSpan(Color.RED), start, mRedComment5.length, exExFlag)


    mComment63 = SpannableString("\n கீழ் வரும் மந்திரம் கூறி எள்ளை")
    mComment63.setSpan(AbsoluteSizeSpan(13, true), start, mComment63.length, exExFlag)
    mComment63.setSpan(StyleSpan(Typeface.ITALIC), start, mComment63.length, exExFlag)
    mComment63.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment63.length, exExFlag)

    Comment64 = SpannableString("\nகீழ் வரும் மந்திரம் கூறி எள்ளும், சிறிது அரிசியையும்")
    Comment64.setSpan(AbsoluteSizeSpan(13, true), start, Comment64.length, exExFlag)
    Comment64.setSpan(StyleSpan(Typeface.ITALIC), start, Comment64.length, exExFlag)
    Comment64.setSpan(ForegroundColorSpan(Color.DKGRAY), start, Comment64.length, exExFlag)

    MComment64 = SpannableString(" மேல் கூர்ச்சத்தில் ")
    MComment64.setSpan(AbsoluteSizeSpan(13, true), start, MComment64.length, exExFlag)
    MComment64.setSpan(StyleSpan(Typeface.ITALIC), start, MComment64.length, exExFlag)
    MComment64.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, MComment64.length, exExFlag)

    mComment65 = SpannableString("போடவும்")
    mComment65.setSpan(AbsoluteSizeSpan(13, true), start, mComment65.length, exExFlag)
    mComment65.setSpan(StyleSpan(Typeface.ITALIC), start, mComment65.length, exExFlag)
    mComment65.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment65.length, exExFlag)

    mBody98 = SpannableString("\nஓம் உத்திஷ்டந்து அஸ்மத் ")
    mBody98.setSpan(AbsoluteSizeSpan(14, true), start, mBody98.length, exExFlag)
    mBody98.setSpan(StyleSpan(Typeface.BOLD), start, mBody98.length, exExFlag)
    mBody98.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody98.length, exExFlag)

    mBody98A = SpannableString("ஸபத்நீக")
    mBody98A.setSpan(AbsoluteSizeSpan(14, true), start, mBody98A.length, exExFlag)
    mBody98A.setSpan(StyleSpan(Typeface.BOLD), start, mBody98A.length, exExFlag)
    mBody98A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody98A.length, exExFlag)

    mBody99A = SpannableString(" பித்ரு பிதாமஹ ப்ரபிதாமஹ:")
    mBody99A.setSpan(AbsoluteSizeSpan(14, true), start, mBody99A.length, exExFlag)
    mBody99A.setSpan(StyleSpan(Typeface.BOLD), start, mBody99A.length, exExFlag)
    mBody99A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody99A.length, exExFlag)

    mBody99B = SpannableString(" பித்ரு ப்ரபிதாமஹ: வ்ருத்தப்ரபிதாமஹ:")
    mBody99B.setSpan(AbsoluteSizeSpan(14, true), start, mBody99B.length, exExFlag)
    mBody99B.setSpan(StyleSpan(Typeface.BOLD), start, mBody99B.length, exExFlag)
    mBody99B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody99B.length, exExFlag)

    mMComment64AP = SpannableString("\n நடு கூர்ச்சத்தில் ")
    mMComment64AP.setSpan(AbsoluteSizeSpan(13, true), start, mMComment64AP.length, exExFlag)
    mMComment64AP.setSpan(StyleSpan(Typeface.ITALIC), start, mMComment64AP.length, exExFlag)
    mMComment64AP.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, mMComment64AP.length, exExFlag)

    mBody98PA = SpannableString("\nஓம் உத்திஷ்டந்து அஸ்மத் ")
    mBody98PA.setSpan(AbsoluteSizeSpan(14, true), start, mBody98PA.length, exExFlag)
    mBody98PA.setSpan(StyleSpan(Typeface.BOLD), start, mBody98PA.length, exExFlag)
    mBody98PA.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody98PA.length, exExFlag)

    mBody98PMB = SpannableString("ஸபத்நீக")
    mBody98PMB.setSpan(AbsoluteSizeSpan(14, true), start, mBody98PMB.length, exExFlag)
    mBody98PMB.setSpan(StyleSpan(Typeface.BOLD), start, mBody98PMB.length, exExFlag)
    mBody98PMB.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody98PMB.length, exExFlag)

    mBody98PC = SpannableString(" மாதாமஹ ப்ரமாதாமஹ வ்ருத்தப்ரமாதாமஹ:")
    mBody98PC.setSpan(AbsoluteSizeSpan(14, true), start, mBody98PC.length, exExFlag)
    mBody98PC.setSpan(StyleSpan(Typeface.BOLD), start, mBody98PC.length, exExFlag)
    mBody98PC.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody98PC.length, exExFlag)

    mMComment64A = SpannableString("\n கீழ் கூர்ச்சத்தில் ")
    mMComment64A.setSpan(AbsoluteSizeSpan(13, true), start, mMComment64A.length, exExFlag)
    mMComment64A.setSpan(StyleSpan(Typeface.ITALIC), start, mMComment64A.length, exExFlag)
    mMComment64A.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, mMComment64A.length, exExFlag)

    mMBody98 = SpannableString("\n ஓம் உத்திஷ்டந்து அஸ்மத் ஸர்வே காருண்ய  பிதர:||")
    mMBody98.setSpan(AbsoluteSizeSpan(14, true), start, mMBody98.length, exExFlag)
    mMBody98.setSpan(StyleSpan(Typeface.BOLD), start, mMBody98.length, exExFlag)
    mMBody98.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mMBody98.length, exExFlag)

    mComment66 = SpannableString("\n கீழ்வரும் மந்திரங்களை சொல்லி கட்டை தர்பத்தை கூர்சங்களின் மேல் வைத்து தொட்டுக் கொண்டு \n")
    mComment66.setSpan(AbsoluteSizeSpan(13, true), start, mComment66.length, exExFlag)
    mComment66.setSpan(StyleSpan(Typeface.ITALIC), start, mComment66.length, exExFlag)
    mComment66.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment66.length, exExFlag)

    mBody100 = SpannableString("\nஓம் வாஜே வாஜே அவதவாஜிந: நோதனேஷூ விப்ரா: அம்ருதா: ருதக்ஞா: அஸ்யமத்வ: பிபத " +
                "மாதயத்வம் த்ருப்தாயாத பதிபி: தேவயானை:")
    mBody100.setSpan(AbsoluteSizeSpan(14, true), start, mBody100.length, exExFlag)
    mBody100.setSpan(StyleSpan(Typeface.BOLD), start, mBody100.length, exExFlag)
    mBody100.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody100.length, exExFlag)

    mComment67 = SpannableString("\n எழுந்து")
    mComment67.setSpan(AbsoluteSizeSpan(13, true), start, mComment67.length, exExFlag)
    mComment67.setSpan(StyleSpan(Typeface.ITALIC), start, mComment67.length, exExFlag)
    mComment67.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment67.length, exExFlag)

    mGreenComment4 = SpannableString(" ஸவ்யம் ")
    mGreenComment4.setSpan(AbsoluteSizeSpan(13, true), start, mGreenComment4.length, exExFlag)
    mGreenComment4.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, mGreenComment4.length, exExFlag)
    mGreenComment4.setSpan(ForegroundColorSpan(Color.GREEN), start, mGreenComment4.length, exExFlag)

    mComment68 = SpannableString("செய்து கொண்டு கீழ்வரும் மந்திரங்களை கூறி மூன்று ப்ரதட்சனம் செய்யவும்")
    mComment68.setSpan(AbsoluteSizeSpan(13, true), start, mComment68.length, exExFlag)
    mComment68.setSpan(StyleSpan(Typeface.ITALIC), start, mComment68.length, exExFlag)
    mComment68.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment68.length, exExFlag)

    mBody101 = SpannableString("\nஓம் ஆமாவாஜஸ்ய ப்ரஸவ: ஜகம்யாத் ஏமே த்யாவா ப்ருதிவீ விஸ்வருபே ஆமாகந்தம் பிதரா " +
                "மாதரா யுவம் ஆமாஸோம: அம்ருதத்வாய கம்யாத்\n" +
                "    \nஓம் தேவதாப்ய: பித்ருப்யச்ச மஹாயோகிப்ய: ஏவச நமஸ்வதாயை ஸ்வாஹாயை நித்யமேவ நமோநம:")
    mBody101.setSpan(AbsoluteSizeSpan(14, true), start, mBody101.length, exExFlag)
    mBody101.setSpan(StyleSpan(Typeface.BOLD), start, mBody101.length, exExFlag)
    mBody101.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody101.length, exExFlag)

    mComment69 = SpannableString(" \nஎன்று நமஸ்கரிக்கவும்")
    mComment69.setSpan(AbsoluteSizeSpan(13, true), start, mComment69.length, exExFlag)
    mComment69.setSpan(StyleSpan(Typeface.ITALIC), start, mComment69.length, exExFlag)
    mComment69.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment69.length, exExFlag)

    val Body102AAA = SpannableString("\nஅபிவாதயே yourPravaras ப்ரவரான்வித: yourGothram கோத்ர:  காத்யாயன ஸூத்ர: " +
                "ஸ்ரீஶுக்ல யஜூர் வேத காண்வஶாகாத்யாயீ ஸ்ரீ yourName ஶர்மா நாமாஹம் அஸ்மி போ:")
    val regexReplace65 = """(yourPravaras)""".toRegex()
    val Body102AA = SpannableString(Body102AAA.replace(regexReplace65, urPravaras))
    val regexReplace66 = """(yourGothram)""".toRegex()
    val Body102A = SpannableString(Body102AA.replace(regexReplace66, urGothram))
    val regexReplace67 = """(yourName)""".toRegex()
    mBody102 = SpannableString(Body102A.replace(regexReplace67, yrNamee))
    mBody102.setSpan(AbsoluteSizeSpan(14, true), start, mBody102.length, exExFlag)
    mBody102.setSpan(StyleSpan(Typeface.BOLD), start, mBody102.length, exExFlag)
    mBody102.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody102.length, exExFlag)

    mComment70 = SpannableString(" \nஉட்கார்ந்து கொண்டு\n")
    mComment70.setSpan(AbsoluteSizeSpan(13, true), start, mComment70.length, exExFlag)
    mComment70.setSpan(StyleSpan(Typeface.ITALIC), start, mComment70.length, exExFlag)
    mComment70.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment70.length, exExFlag)

    mBody103 = SpannableString("\nமயாக்ருதமிதம் ")
    mBody103.setSpan(AbsoluteSizeSpan(14, true), start, mBody103.length, exExFlag)
    mBody103.setSpan(StyleSpan(Typeface.BOLD), start, mBody103.length, exExFlag)
    mBody103.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody103.length, exExFlag)

    mBody103B = SpannableString("பக்க்ஷிய மஹாளய புண்யகால ப்ரயுக்த அஸ்மது ஸகாருண்யக")
    mBody103B.setSpan(AbsoluteSizeSpan(14, true), start, mBody103B.length, exExFlag)
    mBody103B.setSpan(StyleSpan(Typeface.BOLD), start, mBody103B.length, exExFlag)
    mBody103B.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody103B.length, exExFlag)

    mVARGAI3A = SpannableString(" வர்கைக ")
    mVARGAI3A.setSpan(AbsoluteSizeSpan(14, true), start, mVARGAI3A.length, exExFlag)
    mVARGAI3A.setSpan(StyleSpan(Typeface.BOLD), start, mVARGAI3A.length, exExFlag)
    mVARGAI3A.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mVARGAI3A.length, exExFlag)

    mVARGAI1BP2 = SpannableString(" வர்கத்வய ")
    mVARGAI1BP2.setSpan(AbsoluteSizeSpan(14, true), start, mVARGAI1BP2.length, exExFlag)
    mVARGAI1BP2.setSpan(StyleSpan(Typeface.BOLD), start, mVARGAI1BP2.length, exExFlag)
    mVARGAI1BP2.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mVARGAI1BP2.length, exExFlag)

    mBody104 = SpannableString("பித்ரூன் உத்திச்ய திலதர்ப்பணாக்யம் கர்ம ஸர்வம் " +
            "\nஸ்ரீ கிருஷ்ணார்ப்பணமஸ்து " +
            "\n      ஸ்ரீ வாஸூதேவார்ப்பணமஸ்து " +
            "\n            தத்ஸது ப்ரும்மார்ப்பணமஸ்து")
    mBody104.setSpan(AbsoluteSizeSpan(14, true), start, mBody104.length, exExFlag)
    mBody104.setSpan(StyleSpan(Typeface.BOLD), start, mBody104.length, exExFlag)
    mBody104.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody104.length, exExFlag)

    mComment71 = SpannableString(" \n என்று நேராக வலது கையால் ஜலம் விடவும்\n")
    mComment71.setSpan(AbsoluteSizeSpan(13, true), start, mComment71.length, exExFlag)
    mComment71.setSpan(StyleSpan(Typeface.ITALIC), start, mComment71.length, exExFlag)
    mComment71.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment71.length, exExFlag)

    mBody105 = SpannableString("\nகாயேனவாசா மனஸேந்த்ரியைர்வா புத்யாத்மனாவா ப்ரக்ருதே: ஸ்வபாவாத் கரோமியத்யத் " +
                "ஸகலம் பரஸ்மை நாராயணாயேதி ஸமர்ப்பயாமி ஸ்ரீமந் நாராயண ஸ்ரீ நாராயண நாராயண நாராயண நாராயண நாராயண நாராயண " +
                "நாராயண நாராயண நாராயண நாராயண நாராயண \nப்ராயச்சித்தாநி அசேஷாணி தப: கர்ம ஆத்மகாநிவை யாநி தேஷாம் அசேஷாணாம் " +
                "க்ருஷ்ணானுஸ்மரணம் பரம்  ஸ்ரீகிருஷ்ண ஸ்ரீகிருஷ்ண ஸ்ரீகிருஷ்ண ஸ்ரீகிருஷ்ண ஸ்ரீகிருஷ்ண ஸ்ரீகிருஷ்ண ஸ்ரீகிருஷ்ண ஸ்ரீகிருஷ்ண " +
                "ஸ்ரீகிருஷ்ண ஸ்ரீகிருஷ்ண ஸ்ரீகிருஷ்ண ஸ்ரீகிருஷ்ண")
    mBody105.setSpan(AbsoluteSizeSpan(14, true), start, mBody105.length, exExFlag)
    mBody105.setSpan(StyleSpan(Typeface.BOLD), start, mBody105.length, exExFlag)
    mBody105.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody105.length, exExFlag)

    mRedComment6 = SpannableString("\n\n(அபஸவ்யம் ")
    mRedComment6.setSpan(AbsoluteSizeSpan(13, true), start, mRedComment6.length, exExFlag)
    mRedComment6.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, mRedComment6.length, exExFlag)
    mRedComment6.setSpan(ForegroundColorSpan(Color.RED), start, mRedComment6.length, exExFlag)


    mComment72 = SpannableString("செய்து கொண்டு\n")
    mComment72.setSpan(AbsoluteSizeSpan(13, true), start, mComment72.length, exExFlag)
    mComment72.setSpan(StyleSpan(Typeface.ITALIC), start, mComment72.length, exExFlag)
    mComment72.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment72.length, exExFlag)

    mComment73 = SpannableString(" இரண்டு ")
    mComment73.setSpan(AbsoluteSizeSpan(13, true), start, mComment73.length, exExFlag)
    mComment73.setSpan(StyleSpan(Typeface.ITALIC), start, mComment73.length, exExFlag)
    mComment73.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment73.length, exExFlag)

    mComment74 = SpannableString("கூர்ச்சங்களை பிரித்து தெற்கு நுனியாக வைத்துக் கொண்டு, மீதி எல்லா எள்ளையும்")
    mComment74.setSpan(AbsoluteSizeSpan(13, true), start, mComment74.length, exExFlag)
    mComment74.setSpan(StyleSpan(Typeface.ITALIC), start, mComment74.length, exExFlag)
    mComment74.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment74.length, exExFlag)

    mComment75 = SpannableString("கூர்ச்சங்களை பிரித்து தெற்கு நுனியாக வைத்துக் கொண்டு, மீதி எல்லா எள்ளையும், அரிசியையும்")
    mComment75.setSpan(AbsoluteSizeSpan(13, true), start, mComment75.length, exExFlag)
    mComment75.setSpan(StyleSpan(Typeface.ITALIC), start, mComment75.length, exExFlag)
    mComment75.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment75.length, exExFlag)

    mComment76 = SpannableString(" கையில் சேர்த்து ஜலம் விட்டபடியே பூமியில் போடவும்")
    mComment76.setSpan(AbsoluteSizeSpan(13, true), start, mComment76.length, exExFlag)
    mComment76.setSpan(StyleSpan(Typeface.ITALIC), start, mComment76.length, exExFlag)
    mComment76.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment76.length, exExFlag)

    mBody106 = SpannableString("\nயேஷாம் நமாதா")
    mBody106.setSpan(AbsoluteSizeSpan(14, true), start, mBody106.length, exExFlag)
    mBody106.setSpan(StyleSpan(Typeface.BOLD), start, mBody106.length, exExFlag)
    mBody106.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody106.length, exExFlag)

    mBody107Big = SpannableString(" நபிதா ")
    mBody107Big.setSpan(AbsoluteSizeSpan(20, true), start, mBody107Big.length, exExFlag)
    mBody107Big.setSpan(StyleSpan(Typeface.BOLD), start, mBody107Big.length, exExFlag)
    mBody107Big.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody107Big.length, exExFlag)

    mBody108 = SpannableString("நப்ராதா: நாந்யகோத்ரிண: தேஸர்வே த்ருப்திமாயாந்து மயோத்ஸ்ருஷ்டை: குசோதகை:\n" +
                " த்ருப்யத்வம்  த்ருப்யத்வம்  த்ருப்யத்வம்")
    mBody108.setSpan(AbsoluteSizeSpan(14, true), start, mBody108.length, exExFlag)
    mBody108.setSpan(StyleSpan(Typeface.BOLD), start, mBody108.length, exExFlag)
    mBody108.setSpan(ForegroundColorSpan(Color.parseColor("#0000ee")), start, mBody108.length, exExFlag)

    mGreenComment5 = SpannableString("\nஸவ்யம் ")
    mGreenComment5.setSpan(AbsoluteSizeSpan(13, true), start, mGreenComment5.length, exExFlag)
    mGreenComment5.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start, mGreenComment5.length, exExFlag)
    mGreenComment5.setSpan(ForegroundColorSpan(Color.GREEN), start, mGreenComment5.length, exExFlag)

    mComment77 = SpannableString("\n என்று சொல்லி பவித்ரத்தை அவிழ்த்து போடவும்\n\n ஆசமனம் செய்து வீபூதி இட்டுக் " +
                "கொண்டு மறுபடி ஆசமனம் செய்யவும்")
    mComment77.setSpan(AbsoluteSizeSpan(13, true), start, mComment77.length, exExFlag)
    mComment77.setSpan(StyleSpan(Typeface.ITALIC), start, mComment77.length, exExFlag)
    mComment77.setSpan(ForegroundColorSpan(Color.DKGRAY), start, mComment77.length, exExFlag)

    mHeading7 = SpannableString("\nமுற்றும்\n")
    mHeading7.setSpan(AbsoluteSizeSpan(16, true), start, mHeading7.length, exExFlag)
    mHeading7.setSpan(StyleSpan(Typeface.BOLD), start, mHeading7.length, exExFlag)
    mHeading7.setSpan(UnderlineSpan(), start, mHeading7.length, exExFlag)
    mHeading7.setSpan(ForegroundColorSpan(Color.parseColor("#8b008b")), start, mHeading7.length, exExFlag)
}
fun executeData(){
    maha_combination.append(mHeading1, mComment1, mBody1, mComment2, mBody2, mComment3, mBody3, mComment4, mBody4, mComment5,
        mBody5, mComment6, mBody6, mComment7, mBody7, mComment8, mBody8, mComment9, mBody9, mComment10, mBody10, mComment11, mBody11,
        mComment12, mBody12, mComment13, mBody13, mComment14, mBody14, mComment15A)
    if (MFatherLive == "Living") { maha_combination.append(mComment15B) } else maha_combination.append(mComment15C)
    if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { maha_combination.append(mComment15E) }else maha_combination.append(mComment15D)
    maha_combination.append(mComment15F, mBody15, mComment16, mBody16, mComment17)
    maha_combination.append(mHeading2, mBody17, mComment18, mBody18, mComment19, mBody19, mComment20, mBody20, mComment21, mBody21)
    maha_combination.append(mComment22, mBody22, mComment23, mBody23, mComment24, mBody24, mComment25, mBody25, mComment26, mBody26,
        mComment27, mBody27, mComment28, mBody28, mComment29, mBody29, mComment30, mBody30, mComment31, mBody31, mComment32, mBody32,
        mComment33, mBody33, mComment34, mBody34, mComment35, mBody35, mComment36, mBody36, mComment37, mBody37, mComment38A,
        mRedComment1, mComment38B, mBody38, mBody39)
    if (yrGFatherLive == "Deceased") { maha_combination.append(mBody39B, mBody40, mBody41) } else { maha_combination.append(mBody39A, mBody40, mBody41B) }
    maha_combination.append(mBody42)
    if (yrGFatherLive == "Deceased" && motherLive == "Deceased" && fatherMotherLive == "Deceased") { maha_combination.append(mBody39FM) }
    if (MFatherLive == "Living") { maha_combination.append(mBody42Z)
        if (noOfDaysTpnm == "15days") { maha_combination.append(mBody42ZA) }else { maha_combination.append(mBody42ZB) }
        maha_combination.append(mComment39, mGreenComment1, mComment40, mComment40Two, mComment41, mRedComment2)
        if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { maha_combination.append(mComment41C) }else maha_combination.append(mComment41A)
        maha_combination.append(mComment41D, mHeading3, mComment42, mRedComment3, mComment42A, mBody46)
        if (yrGFatherLive == "Deceased") { maha_combination.append(mBody48B) } else { maha_combination.append(mBody48A) }
        maha_combination.append(mBody49)
        if (yrGFatherLive == "Deceased") { maha_combination.append(mBody50) } else { maha_combination.append(mBody51B) }
        maha_combination.append(mBody52)
        if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { maha_combination.append(mComment44) }else maha_combination.append(mComment43)
        maha_combination.append(mComment45, mHeading4, mComment46, mBody53)
        if (yrGFatherLive == "Deceased") { maha_combination.append(mBody56) } else { maha_combination.append(mBody55) }
        maha_combination.append(mBody57)
        if (yrGFatherLive == "Deceased") { maha_combination.append(mBody58) } else { maha_combination.append(mBody59B) }
        maha_combination.append(mBody60, mComment47, mBody61)
        if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { maha_combination.append(mComment49) }else maha_combination.append(mComment48)
        maha_combination.append(mComment50, mComment42AP, mBody46P)
        if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { maha_combination.append(mComment49A) }else maha_combination.append(mComment48A)
        maha_combination.append(mComment50, mHeading4P, mComment46, mBody46PAS, mComment47, mBody61)
        if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { maha_combination.append(mComment49B) }else maha_combination.append(mComment48B)
        maha_combination.append(mComment50, mComment42AP1, mHeading4P1, mComment42AP2A, mComment42AP2B, mHeading5)
        maha_combination.append(mBody62, mBody64, mBody66, mBody68, mBody69)
        if (yrGFatherLive == "Deceased") {
            maha_combination.append(mBody70A, mBody71, mBody73A, mBody74, mBody76A, mBody77, mBody79A, mBody80, mBody82A, mBody83, mBody85A, mBody86) } else {
            maha_combination.append(mBody70B, mBody72, mBody73B, mBody75, mBody76B, mBody78, mBody79B, mBody81, mBody82B, mBody84, mBody85B, mBody87) }
        if ((yrGFatherLive == "Deceased") && (motherLive == "Deceased") && (fatherMotherLive == "Deceased")) { maha_combination.append(mBody62P, mBody62P2, mBody62P3) }
        maha_combination.append(mHeading5P, personHead)
        if (nOne != "") { maha_combination.append(strAdditionP1, strAdditionNO1)
            if (Gndr1 == "ஆண்") { maha_combination.append(strAdditionP1zM, strAdditionP1aA1) } else { maha_combination.append(strAdditionP1zA, strAdditionP1bA1) }
            maha_combination.append(strAdditionP1cA1, strAdditionP1ab, strAdditionNO2)
            if (Gndr1 == "ஆண்") { maha_combination.append(strAdditionP1zMB, strAdditionP1aA2) } else { maha_combination.append(strAdditionP1zB, strAdditionP1bA2) }
            maha_combination.append(strAdditionP1cA2, strAdditionP1ac, strAdditionNO3)
            if (Gndr1 == "ஆண்") { maha_combination.append(strAdditionP1zMC, strAdditionP1aA3) } else { maha_combination.append(strAdditionP1zC, strAdditionP1bA3) }
            maha_combination.append(strAdditionP1cA3, space)
        }
        if (nTwo != "") { maha_combination.append(strAdditionP2, strAdditionNO1B)
            if (Gndr2 == "ஆண்") { maha_combination.append(strAdditionP2zM, strAdditionP1aB1) } else { maha_combination.append(strAdditionP2zA, strAdditionP1bB1) }
            maha_combination.append(strAdditionP1cB1, strAdditionP2bb, strAdditionNO2B)
            if (Gndr2 == "ஆண்") { maha_combination.append(strAdditionP2zMB, strAdditionP1aB2) } else { maha_combination.append(strAdditionP2zB, strAdditionP1bB2) }
            maha_combination.append(strAdditionP1cB2, strAdditionP2bc, strAdditionNO3B)
            if (Gndr2 == "ஆண்") { maha_combination.append(strAdditionP2zMC, strAdditionP1aB3) } else { maha_combination.append(strAdditionP2zC, strAdditionP1bB3) }
            maha_combination.append(strAdditionP1cB3, space)
        }
        if (nThree != "") { maha_combination.append(strAdditionP3, strAdditionNO1C)
            if (Gndr3 == "ஆண்") { maha_combination.append(strAdditionP3zM, strAdditionP1aC1)} else { maha_combination.append(strAdditionP3zA, strAdditionP1bC1)}
            maha_combination.append(strAdditionP1cC1, strAdditionP3cb, strAdditionNO2C)
            if (Gndr3 == "ஆண்") { maha_combination.append(strAdditionP3zMB, strAdditionP1aC2) } else { maha_combination.append(strAdditionP3zB, strAdditionP1bC2)}
            maha_combination.append(strAdditionP1cC2, strAdditionP3cc, strAdditionNO3C)
            if (Gndr3 == "ஆண்") { maha_combination.append(strAdditionP3zMC, strAdditionP1aC3) } else { maha_combination.append(strAdditionP3zC, strAdditionP1bC3) }
            maha_combination.append(strAdditionP1cC3, space)
        }
        if (nFour != "") { maha_combination.append(strAdditionP4, strAdditionNO1D)
            if (Gndr4 == "ஆண்") { maha_combination.append(strAdditionP4zM, strAdditionP1aD1) } else { maha_combination.append(strAdditionP4zA, strAdditionP1bD1) }
            maha_combination.append(strAdditionP1cD1, strAdditionP4db, strAdditionNO2D)
            if (Gndr4 == "ஆண்") { maha_combination.append(strAdditionP4zMB, strAdditionP1aD2) } else { maha_combination.append(strAdditionP4zB, strAdditionP1bD2) }
            maha_combination.append(strAdditionP1cD2, strAdditionP4dc, strAdditionNO3D)
            if (Gndr4 == "ஆண்") { maha_combination.append(strAdditionP4zMC, strAdditionP1aD3) } else { maha_combination.append(strAdditionP4zC, strAdditionP1bD3) }
            maha_combination.append(strAdditionP1cD3, space)
        }
        if (nFive != "") { maha_combination.append(strAdditionP5, strAdditionNO1E)
            if (Gndr5 == "ஆண்") { maha_combination.append(strAdditionP5zM, strAdditionP1aE1) } else { maha_combination.append(strAdditionP5zA, strAdditionP1bE1) }
            maha_combination.append(strAdditionP1cE1, strAdditionP5eb, strAdditionNO2E)
            if (Gndr5 == "ஆண்") { maha_combination.append(strAdditionP5zMB, strAdditionP1aE2) } else { maha_combination.append(strAdditionP5zB, strAdditionP1bE2) }
            maha_combination.append(strAdditionP1cE2, strAdditionP5ec, strAdditionNO3E)
            if (Gndr5 == "ஆண்") { maha_combination.append(strAdditionP5zMC, strAdditionP1aE3) } else { maha_combination.append(strAdditionP5zC, strAdditionP1bE3) }
            maha_combination.append(strAdditionP1cE3, space)
        }
        if (nSix != "") { maha_combination.append(strAdditionP6, strAdditionNO1F)
            if (Gndr6 == "ஆண்") { maha_combination.append(strAdditionP6zM, strAdditionP1aF1) } else { maha_combination.append(strAdditionP6zA, strAdditionP1bF1) }
            maha_combination.append(strAdditionP1cF1, strAdditionP6fb, strAdditionNO2F)
            if (Gndr6 == "ஆண்") { maha_combination.append(strAdditionP6zMB, strAdditionP1aF2) } else { maha_combination.append(strAdditionP6zB, strAdditionP1bF2) }
            maha_combination.append(strAdditionP1cF2, strAdditionP6fc, strAdditionNO3F)
            if (Gndr6 == "ஆண்") { maha_combination.append(strAdditionP6zMC, strAdditionP1aF3) } else { maha_combination.append(strAdditionP6zC, strAdditionP1bF3) }
            maha_combination.append(strAdditionP1cF3, space)
        }
        if (nSeven != "") { maha_combination.append(strAdditionP7, strAdditionNO1G)
            if (Gndr7 == "ஆண்") { maha_combination.append(strAdditionP7zM, strAdditionP1aG1) } else { maha_combination.append(strAdditionP7zA, strAdditionP1bG1) }
            maha_combination.append(strAdditionP1cG1, strAdditionP7gb, strAdditionNO2G)
            if (Gndr7 == "ஆண்") { maha_combination.append(strAdditionP7zMB, strAdditionP1aG2) } else { maha_combination.append(strAdditionP7zB, strAdditionP1bG2) }
            maha_combination.append(strAdditionP1cG2, strAdditionP7gc, strAdditionNO3G)
            if (Gndr7 == "ஆண்") { maha_combination.append(strAdditionP7zMC, strAdditionP1aG3) } else { maha_combination.append(strAdditionP7zC, strAdditionP1bG3) }
            maha_combination.append(strAdditionP1cG3, space)
        }
        if (nEight != "") { maha_combination.append(strAdditionP8, strAdditionNO1H)
            if (Gndr8 == "ஆண்") { maha_combination.append(strAdditionP8zM, strAdditionP1aH1) } else { maha_combination.append(strAdditionP8zA, strAdditionP1bH1) }
            maha_combination.append(strAdditionP1cH1, strAdditionP8hb, strAdditionNO2H)
            if (Gndr8 == "ஆண்") { maha_combination.append(strAdditionP8zMB, strAdditionP1aH2) } else { maha_combination.append(strAdditionP8zB, strAdditionP1bH2) }
            maha_combination.append(strAdditionP1cH2, strAdditionP8hc, strAdditionNO3H)
            if (Gndr8 == "ஆண்") { maha_combination.append(strAdditionP8zMC, strAdditionP1aH3) } else { maha_combination.append(strAdditionP8zC, strAdditionP1bH3) }
            maha_combination.append(strAdditionP1cH3, space)
        }
        if (nNine != "") { maha_combination.append(strAdditionP9, strAdditionNO1I)
            if (Gndr9 == "ஆண்") { maha_combination.append(strAdditionP9zM, strAdditionP1aI1) } else { maha_combination.append(strAdditionP9zA, strAdditionP1bI1) }
            maha_combination.append(strAdditionP1cI1, strAdditionP9ib, strAdditionNO2I)
            if (Gndr9 == "ஆண்") { maha_combination.append(strAdditionP9zMB, strAdditionP1aI2) } else { maha_combination.append(strAdditionP9zB, strAdditionP1bI2) }
            maha_combination.append(strAdditionP1cI2, strAdditionP9ic, strAdditionNO3I)
            if (Gndr9 == "ஆண்") { maha_combination.append(strAdditionP9zMC, strAdditionP1aI3) } else { maha_combination.append(strAdditionP9zC, strAdditionP1bI3) }
            maha_combination.append(strAdditionP1cI3, space)
        }
        if (nTen != "") { maha_combination.append(strAdditionP10, strAdditionNO1J)
            if (Gndr10 == "ஆண்") { maha_combination.append(strAdditionP10zM, strAdditionP1aJ1) } else { maha_combination.append(strAdditionP10zA, strAdditionP1bJ1) }
            maha_combination.append(strAdditionP1cJ1, strAdditionP10jb, strAdditionNO2J)
            if (Gndr10 == "ஆண்") { maha_combination.append(strAdditionP10zMB, strAdditionP1aJ2) } else { maha_combination.append(strAdditionP10zB, strAdditionP1bJ2) }
            maha_combination.append(strAdditionP1cJ2, strAdditionP10jc, strAdditionNO3J)
            if (Gndr10 == "ஆண்") { maha_combination.append(strAdditionP10zMC, strAdditionP1aJ3) } else { maha_combination.append(strAdditionP10zC, strAdditionP1bJ3) }
            maha_combination.append(strAdditionP1cJ3, space)
        }
        if (nEleven != "") { maha_combination.append(strAdditionP11, strAdditionNO1K)
            if (Gndr11 == "ஆண்") { maha_combination.append(strAdditionP11zM, strAdditionP1aK1) } else { maha_combination.append(strAdditionP11zA, strAdditionP1bK1) }
            maha_combination.append(strAdditionP1cK1, strAdditionP11kb, strAdditionNO2K)
            if (Gndr11 == "ஆண்") { maha_combination.append(strAdditionP11zMB, strAdditionP1aK2) } else { maha_combination.append(strAdditionP11zB, strAdditionP1bK2) }
            maha_combination.append(strAdditionP1cK2, strAdditionP11kc, strAdditionNO3K)
            if (Gndr11 == "ஆண்") { maha_combination.append(strAdditionP11zMC, strAdditionP1aK3) } else { maha_combination.append(strAdditionP11zC, strAdditionP1bK3) }
            maha_combination.append(strAdditionP1cK3, space)
        }
        if (nTwelve != "") { maha_combination.append(strAdditionP12, strAdditionNO1L)
            if (Gndr12 == "ஆண்") { maha_combination.append(strAdditionP12zM, strAdditionP1aL1) } else { maha_combination.append(strAdditionP12zA, strAdditionP1bL1) }
            maha_combination.append(strAdditionP1cL1, strAdditionP12lb, strAdditionNO2L)
            if (Gndr12 == "ஆண்") { maha_combination.append(strAdditionP12zMB, strAdditionP1aL2) } else { maha_combination.append(strAdditionP12zB, strAdditionP1bL2) }
            maha_combination.append(strAdditionP1cL2, strAdditionP12lc, strAdditionNO3L)
            if (Gndr12 == "ஆண்") { maha_combination.append(strAdditionP12zMC, strAdditionP1aL3) } else { maha_combination.append(strAdditionP12zC, strAdditionP1bL3) }
            maha_combination.append(strAdditionP1cL3, space)
        }
        if (nThirteen != "") { maha_combination.append(strAdditionP13, strAdditionNO1M)
            if (Gndr13 == "ஆண்") { maha_combination.append(strAdditionP13zM, strAdditionP1aM1) } else { maha_combination.append(strAdditionP13zA, strAdditionP1bM1) }
            maha_combination.append(strAdditionP1cM1, strAdditionP13mb, strAdditionNO2M)
            if (Gndr13 == "ஆண்") { maha_combination.append(strAdditionP13zMB, strAdditionP1aM2) } else { maha_combination.append(strAdditionP13zB, strAdditionP1bM2) }
            maha_combination.append(strAdditionP1cM2, strAdditionP13mc, strAdditionNO3M)
            if (Gndr13 == "ஆண்") { maha_combination.append(strAdditionP13zMC, strAdditionP1aM3) } else { maha_combination.append(strAdditionP13zC, strAdditionP1bM3) }
            maha_combination.append(strAdditionP1cM3, space)
        }
        if (nFourteen != "") { maha_combination.append(strAdditionP14, strAdditionNO1N)
            if (Gndr14 == "ஆண்") { maha_combination.append(strAdditionP14zM, strAdditionP1aN1) } else { maha_combination.append(strAdditionP14zA, strAdditionP1bN1) }
            maha_combination.append(strAdditionP1cN1, strAdditionP14nb, strAdditionNO2N)
            if (Gndr14 == "ஆண்") { maha_combination.append(strAdditionP14zMB, strAdditionP1aN2) } else { maha_combination.append(strAdditionP14zB, strAdditionP1bN2) }
            maha_combination.append(strAdditionP1cN2, strAdditionP14nc, strAdditionNO3N)
            if (Gndr14 == "ஆண்") { maha_combination.append(strAdditionP14zMC, strAdditionP1aN3) } else { maha_combination.append(strAdditionP14zC, strAdditionP1bN3) }
            maha_combination.append(strAdditionP1cN3, space)
        }
        if (nFifteen != "") { maha_combination.append(strAdditionP15, strAdditionNO1O)
            if (Gndr15 == "ஆண்") { maha_combination.append(strAdditionP15zM, strAdditionP1aO1) } else { maha_combination.append(strAdditionP15zA, strAdditionP1bO1) }
            maha_combination.append(strAdditionP1cO1, strAdditionP15ob, strAdditionNO2O)
            if (Gndr15 == "ஆண்") { maha_combination.append(strAdditionP15zMB, strAdditionP1aO2) } else { maha_combination.append(strAdditionP15zB, strAdditionP1bO2) }
            maha_combination.append(strAdditionP1cO2, strAdditionP15oc, strAdditionNO3O)
            if (Gndr15 == "ஆண்") { maha_combination.append(strAdditionP15zMC, strAdditionP1aO3) } else { maha_combination.append(strAdditionP15zC, strAdditionP1bO3) }
            maha_combination.append(strAdditionP1cO3, space)
        }
        maha_combination.append(
            strAdditionP1, mBody87P1, strAdditionP2, mBody87P2, strAdditionP3, mBody87P3, mComment51, mBody88, mComment51a,
            mGreenComment2, mComment52, mBody89, mRedComment4, mComment53)
        if (MFatherLive == "Deceased") { maha_combination.append(mComment54a) } else { maha_combination.append(mComment54) }
        maha_combination.append(mComment55, mComment55A, mBody90, mComment55B, mBody90P, mComment55C, mComment56)
        if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { maha_combination.append(mComment57) }else maha_combination.append(mComment56)
        maha_combination.append(mComment58, mBody91, mComment55D, mMBody91)
        if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { maha_combination.append(mComment57A) }else maha_combination.append(mComment55E)
        maha_combination.append(
            mComment58, mMBody91A, mGreenComment3, mBody92, mVARGAI1A, mBody93, mComment59, mBody94, mComment60,
            mBody95, mComment61, mBody96, mVARGAI2A, mBody97, mComment62, mHeading6, mRedComment5)
        if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { maha_combination.append(Comment64) }else maha_combination.append(mComment63)
        maha_combination.append(MComment64, mComment65, mBody98)
        if (yrGFatherLive == "Deceased") { maha_combination.append(mBody99A) } else { maha_combination.append(mBody99B) }
        maha_combination.append(mMComment64A, mMBody98, mComment66, mBody100, mComment67, mGreenComment4, mComment68, mBody101, mComment69, mBody102, mComment70, mBody103)
        maha_combination.append(mBody103B, mVARGAI3A, mBody104, mComment71, mBody105, mRedComment6, mComment72, mComment73)
        if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { maha_combination.append(mComment75) }else maha_combination.append(mComment74)
        maha_combination.append(mComment76, mBody106, mBody107Big, mBody108, mGreenComment5, mComment77, mHeading7)
    } else {
        //Motherside Gents SANGALPAM
        maha_combination.append(mMBody38, mMBody41B)
        //Motherside Ladies SANGALPAM
        if (motherMotherLive == "Deceased") { maha_combination.append(mMBody38b, mMBody41Bc) }
        //Pithru - SANGALPAM
        maha_combination.append(mBody42Z)
        if (noOfDaysTpnm == "15days") { maha_combination.append(mBody42ZA) }else { maha_combination.append(mBody42ZB) }
        maha_combination.append(mComment39, mGreenComment1, mComment40, mComment40Three, mComment41, mRedComment2)
        if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { maha_combination.append(mComment41C) } else maha_combination.append(mComment41A)
        maha_combination.append(mComment41D, mHeading3, mComment42, mRedComment3)
//Fatherside Gents - ஆவாஹனம்-ஆஸனம்
        maha_combination.append(mComment42A, mBody46)
        if (yrGFatherLive == "Deceased") { maha_combination.append(mBody48B) } else {
            if (motherLive == "Deceased" && fatherMotherLive == "Deceased"){ maha_combination.append(mBody98PMB) }
             maha_combination.append(mBody48A) }
        maha_combination.append(mBody49)
        if (yrGFatherLive == "Deceased") { maha_combination.append(mBody50) } else { maha_combination.append(mBody51B) }
        maha_combination.append(mBody52)
        if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { maha_combination.append(mComment44A) } else maha_combination.append(mComment43A)
        maha_combination.append(mComment45A, mHeading4, mComment46, mBody53)
        if (yrGFatherLive == "Deceased") { maha_combination.append(mBody56) } else { maha_combination.append(mBody55) }
        maha_combination.append(mBody57)
        if (yrGFatherLive == "Deceased") { maha_combination.append(mBody58) } else { maha_combination.append(mBody59B) }
        maha_combination.append(mBody60, mComment47, mBody61)
        if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { maha_combination.append(mComment49A) } else maha_combination.append(mComment48A)
        maha_combination.append(mComment50A)
//Motherside Gents - ஆவாஹனம்-ஆஸனம்
        maha_combination.append(mComment42Middle, mMBody46, mMBody51B)
        if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { maha_combination.append(mComment49) } else maha_combination.append(mComment48)
        maha_combination.append(mComment50, mMHeading4, mMComment46, mMBody53, mMBody51C1, mComment47B, mMBody61)
        if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { maha_combination.append(mComment49B) } else maha_combination.append(mComment48B)
        maha_combination.append(mComment50B)
        maha_combination.append(mComment42AP, mBody46P)
        if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { maha_combination.append(mComment49C) }else maha_combination.append(mComment48C)
        maha_combination.append(mComment50C)
        maha_combination.append(mHeading4P, mComment46A, mBody46PAS, mComment47A, mBody61P)
        if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { maha_combination.append(mComment49E) }else maha_combination.append(mComment48E)
        maha_combination.append(mComment50E, mComment42AP1, mHeading4P1)
        if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { maha_combination.append(mComment49D) }else maha_combination.append(mComment42AP2A)
        maha_combination.append(mComment42AP2B)
//Tharpanam- Father - 1,2,3.a.b.c
        maha_combination.append(mHeading5, mBody62, mBody64, mBody66, mBody68, mBody69)
        if (yrGFatherLive == "Deceased") { maha_combination.append(mBody70A, mBody71, mBody73A, mBody74, mBody76A, mBody77, mBody79A, mBody80, mBody82A, mBody83, mBody85A, mBody86)
        } else { maha_combination.append(mBody70B, mBody72, mBody73B, mBody75, mBody79B, mBody81, mBody82B, mBody76B, mBody78, mBody79B, mBody81, mBody82B, mBody84, mBody85B, mBody87) }

        if (yrGFatherLive == "Deceased" && motherLive == "Deceased" && fatherMotherLive == "Deceased") {
            maha_combination.append(mBody62P, mBody62P2, mBody62P3) }
//Tharpanam- MotherFather - I, II & III.a.b.c
        maha_combination.append(mMHeading5mG, mMBody62, mMBody63, mMBody64, mMBody66, mMBody68, mMBody69, mMBody71, mMBody72, mMBody74, mMBody75)
//Tharpanam- MotherMother - IV.a.b.c
        if (motherMotherLive == "Deceased") {
            maha_combination.append(mMBody62M, mMBody63M, mMBody64M, mMBody66M, mMBody68M, mMBody69M, mMBody71M, mMBody72M, mMBody74M, mMBody75M) }
        maha_combination.append(mHeading5P, personHead)
        if (nOne != "") { maha_combination.append(strAdditionP1, strAdditionNO1)
            if (Gndr1 == "ஆண்") { maha_combination.append(strAdditionP1zM, strAdditionP1aA1) } else { maha_combination.append(strAdditionP1zA, strAdditionP1bA1) }
            maha_combination.append(strAdditionP1cA1, strAdditionP1ab, strAdditionNO2)
            if (Gndr1 == "ஆண்") { maha_combination.append(strAdditionP1zMB, strAdditionP1aA2) } else { maha_combination.append(strAdditionP1zB, strAdditionP1bA2) }
            maha_combination.append(strAdditionP1cA2, strAdditionP1ac, strAdditionNO3)
            if (Gndr1 == "ஆண்") { maha_combination.append(strAdditionP1zMC, strAdditionP1aA3) } else { maha_combination.append(strAdditionP1zC, strAdditionP1bA3) }
            maha_combination.append(strAdditionP1cA3, space)
        }
        if (nTwo != "") { maha_combination.append(strAdditionP2, strAdditionNO1B)
            if (Gndr2 == "ஆண்") { maha_combination.append(strAdditionP2zM, strAdditionP1aB1) } else { maha_combination.append(strAdditionP2zA, strAdditionP1bB1) }
            maha_combination.append(strAdditionP1cB1, strAdditionP2bb, strAdditionNO2B)
            if (Gndr2 == "ஆண்") { maha_combination.append(strAdditionP2zMB, strAdditionP1aB2) } else { maha_combination.append(strAdditionP2zB, strAdditionP1bB2) }
            maha_combination.append(strAdditionP1cB2, strAdditionP2bc, strAdditionNO3B)
            if (Gndr2 == "ஆண்") { maha_combination.append(strAdditionP2zMC, strAdditionP1aB3) } else { maha_combination.append(strAdditionP2zC, strAdditionP1bB3) }
            maha_combination.append(strAdditionP1cB3, space)
        }
        if (nThree != "") { maha_combination.append(strAdditionP3, strAdditionNO1C)
            if (Gndr3 == "ஆண்") { maha_combination.append(strAdditionP3zM, strAdditionP1aC1)} else { maha_combination.append(strAdditionP3zA, strAdditionP1bC1)}
            maha_combination.append(strAdditionP1cC1, strAdditionP3cb, strAdditionNO2C)
            if (Gndr3 == "ஆண்") { maha_combination.append(strAdditionP3zMB, strAdditionP1aC2) } else { maha_combination.append(strAdditionP3zB, strAdditionP1bC2)}
            maha_combination.append(strAdditionP1cC2, strAdditionP3cc, strAdditionNO3C)
            if (Gndr3 == "ஆண்") { maha_combination.append(strAdditionP3zMC, strAdditionP1aC3) } else { maha_combination.append(strAdditionP3zC, strAdditionP1bC3) }
            maha_combination.append(strAdditionP1cC3, space)
        }
        if (nFour != "") { maha_combination.append(strAdditionP4, strAdditionNO1D)
            if (Gndr4 == "ஆண்") { maha_combination.append(strAdditionP4zM, strAdditionP1aD1) } else { maha_combination.append(strAdditionP4zA, strAdditionP1bD1) }
            maha_combination.append(strAdditionP1cD1, strAdditionP4db, strAdditionNO2D)
            if (Gndr4 == "ஆண்") { maha_combination.append(strAdditionP4zMB, strAdditionP1aD2) } else { maha_combination.append(strAdditionP4zB, strAdditionP1bD2) }
            maha_combination.append(strAdditionP1cD2, strAdditionP4dc, strAdditionNO3D)
            if (Gndr4 == "ஆண்") { maha_combination.append(strAdditionP4zMC, strAdditionP1aD3) } else { maha_combination.append(strAdditionP4zC, strAdditionP1bD3) }
            maha_combination.append(strAdditionP1cD3, space)
        }
        if (nFive != "") { maha_combination.append(strAdditionP5, strAdditionNO1E)
            if (Gndr5 == "ஆண்") { maha_combination.append(strAdditionP5zM, strAdditionP1aE1) } else { maha_combination.append(strAdditionP5zA, strAdditionP1bE1) }
            maha_combination.append(strAdditionP1cE1, strAdditionP5eb, strAdditionNO2E)
            if (Gndr5 == "ஆண்") { maha_combination.append(strAdditionP5zMB, strAdditionP1aE2) } else { maha_combination.append(strAdditionP5zB, strAdditionP1bE2) }
            maha_combination.append(strAdditionP1cE2, strAdditionP5ec, strAdditionNO3E)
            if (Gndr5 == "ஆண்") { maha_combination.append(strAdditionP5zMC, strAdditionP1aE3) } else { maha_combination.append(strAdditionP5zC, strAdditionP1bE3) }
            maha_combination.append(strAdditionP1cE3, space)
        }
        if (nSix != "") { maha_combination.append(strAdditionP6, strAdditionNO1F)
            if (Gndr6 == "ஆண்") { maha_combination.append(strAdditionP6zM, strAdditionP1aF1) } else { maha_combination.append(strAdditionP6zA, strAdditionP1bF1) }
            maha_combination.append(strAdditionP1cF1, strAdditionP6fb, strAdditionNO2F)
            if (Gndr6 == "ஆண்") { maha_combination.append(strAdditionP6zMB, strAdditionP1aF2) } else { maha_combination.append(strAdditionP6zB, strAdditionP1bF2) }
            maha_combination.append(strAdditionP1cF2, strAdditionP6fc, strAdditionNO3F)
            if (Gndr6 == "ஆண்") { maha_combination.append(strAdditionP6zMC, strAdditionP1aF3) } else { maha_combination.append(strAdditionP6zC, strAdditionP1bF3) }
            maha_combination.append(strAdditionP1cF3, space)
        }
        if (nSeven != "") { maha_combination.append(strAdditionP7, strAdditionNO1G)
            if (Gndr7 == "ஆண்") { maha_combination.append(strAdditionP7zM, strAdditionP1aG1) } else { maha_combination.append(strAdditionP7zA, strAdditionP1bG1) }
            maha_combination.append(strAdditionP1cG1, strAdditionP7gb, strAdditionNO2G)
            if (Gndr7 == "ஆண்") { maha_combination.append(strAdditionP7zMB, strAdditionP1aG2) } else { maha_combination.append(strAdditionP7zB, strAdditionP1bG2) }
            maha_combination.append(strAdditionP1cG2, strAdditionP7gc, strAdditionNO3G)
            if (Gndr7 == "ஆண்") { maha_combination.append(strAdditionP7zMC, strAdditionP1aG3) } else { maha_combination.append(strAdditionP7zC, strAdditionP1bG3) }
            maha_combination.append(strAdditionP1cG3, space)
        }
        if (nEight != "") { maha_combination.append(strAdditionP8, strAdditionNO1H)
            if (Gndr8 == "ஆண்") { maha_combination.append(strAdditionP8zM, strAdditionP1aH1) } else { maha_combination.append(strAdditionP8zA, strAdditionP1bH1) }
            maha_combination.append(strAdditionP1cH1, strAdditionP8hb, strAdditionNO2H)
            if (Gndr8 == "ஆண்") { maha_combination.append(strAdditionP8zMB, strAdditionP1aH2) } else { maha_combination.append(strAdditionP8zB, strAdditionP1bH2) }
            maha_combination.append(strAdditionP1cH2, strAdditionP8hc, strAdditionNO3H)
            if (Gndr8 == "ஆண்") { maha_combination.append(strAdditionP8zMC, strAdditionP1aH3) } else { maha_combination.append(strAdditionP8zC, strAdditionP1bH3) }
            maha_combination.append(strAdditionP1cH3, space)
        }
        if (nNine != "") { maha_combination.append(strAdditionP9, strAdditionNO1I)
            if (Gndr9 == "ஆண்") { maha_combination.append(strAdditionP9zM, strAdditionP1aI1) } else { maha_combination.append(strAdditionP9zA, strAdditionP1bI1) }
            maha_combination.append(strAdditionP1cI1, strAdditionP9ib, strAdditionNO2I)
            if (Gndr9 == "ஆண்") { maha_combination.append(strAdditionP9zMB, strAdditionP1aI2) } else { maha_combination.append(strAdditionP9zB, strAdditionP1bI2) }
            maha_combination.append(strAdditionP1cI2, strAdditionP9ic, strAdditionNO3I)
            if (Gndr9 == "ஆண்") { maha_combination.append(strAdditionP9zMC, strAdditionP1aI3) } else { maha_combination.append(strAdditionP9zC, strAdditionP1bI3) }
            maha_combination.append(strAdditionP1cI3, space)
        }
        if (nTen != "") { maha_combination.append(strAdditionP10, strAdditionNO1J)
            if (Gndr10 == "ஆண்") { maha_combination.append(strAdditionP10zM, strAdditionP1aJ1) } else { maha_combination.append(strAdditionP10zA, strAdditionP1bJ1) }
            maha_combination.append(strAdditionP1cJ1, strAdditionP10jb, strAdditionNO2J)
            if (Gndr10 == "ஆண்") { maha_combination.append(strAdditionP10zMB, strAdditionP1aJ2) } else { maha_combination.append(strAdditionP10zB, strAdditionP1bJ2) }
            maha_combination.append(strAdditionP1cJ2, strAdditionP10jc, strAdditionNO3J)
            if (Gndr10 == "ஆண்") { maha_combination.append(strAdditionP10zMC, strAdditionP1aJ3) } else { maha_combination.append(strAdditionP10zC, strAdditionP1bJ3) }
            maha_combination.append(strAdditionP1cJ3, space)
        }
        if (nEleven != "") { maha_combination.append(strAdditionP11, strAdditionNO1K)
            if (Gndr11 == "ஆண்") { maha_combination.append(strAdditionP11zM, strAdditionP1aK1) } else { maha_combination.append(strAdditionP11zA, strAdditionP1bK1) }
            maha_combination.append(strAdditionP1cK1, strAdditionP11kb, strAdditionNO2K)
            if (Gndr11 == "ஆண்") { maha_combination.append(strAdditionP11zMB, strAdditionP1aK2) } else { maha_combination.append(strAdditionP11zB, strAdditionP1bK2) }
            maha_combination.append(strAdditionP1cK2, strAdditionP11kc, strAdditionNO3K)
            if (Gndr11 == "ஆண்") { maha_combination.append(strAdditionP11zMC, strAdditionP1aK3) } else { maha_combination.append(strAdditionP11zC, strAdditionP1bK3) }
            maha_combination.append(strAdditionP1cK3, space)
        }
        if (nTwelve != "") { maha_combination.append(strAdditionP12, strAdditionNO1L)
            if (Gndr12 == "ஆண்") { maha_combination.append(strAdditionP12zM, strAdditionP1aL1) } else { maha_combination.append(strAdditionP12zA, strAdditionP1bL1) }
            maha_combination.append(strAdditionP1cL1, strAdditionP12lb, strAdditionNO2L)
            if (Gndr12 == "ஆண்") { maha_combination.append(strAdditionP12zMB, strAdditionP1aL2) } else { maha_combination.append(strAdditionP12zB, strAdditionP1bL2) }
            maha_combination.append(strAdditionP1cL2, strAdditionP12lc, strAdditionNO3L)
            if (Gndr12 == "ஆண்") { maha_combination.append(strAdditionP12zMC, strAdditionP1aL3) } else { maha_combination.append(strAdditionP12zC, strAdditionP1bL3) }
            maha_combination.append(strAdditionP1cL3, space)
        }
        if (nThirteen != "") { maha_combination.append(strAdditionP13, strAdditionNO1M)
            if (Gndr13 == "ஆண்") { maha_combination.append(strAdditionP13zM, strAdditionP1aM1) } else { maha_combination.append(strAdditionP13zA, strAdditionP1bM1) }
            maha_combination.append(strAdditionP1cM1, strAdditionP13mb, strAdditionNO2M)
            if (Gndr13 == "ஆண்") { maha_combination.append(strAdditionP13zMB, strAdditionP1aM2) } else { maha_combination.append(strAdditionP13zB, strAdditionP1bM2) }
            maha_combination.append(strAdditionP1cM2, strAdditionP13mc, strAdditionNO3M)
            if (Gndr13 == "ஆண்") { maha_combination.append(strAdditionP13zMC, strAdditionP1aM3) } else { maha_combination.append(strAdditionP13zC, strAdditionP1bM3) }
            maha_combination.append(strAdditionP1cM3, space)
        }
        if (nFourteen != "") { maha_combination.append(strAdditionP14, strAdditionNO1N)
            if (Gndr14 == "ஆண்") { maha_combination.append(strAdditionP14zM, strAdditionP1aN1) } else { maha_combination.append(strAdditionP14zA, strAdditionP1bN1) }
            maha_combination.append(strAdditionP1cN1, strAdditionP14nb, strAdditionNO2N)
            if (Gndr14 == "ஆண்") { maha_combination.append(strAdditionP14zMB, strAdditionP1aN2) } else { maha_combination.append(strAdditionP14zB, strAdditionP1bN2) }
            maha_combination.append(strAdditionP1cN2, strAdditionP14nc, strAdditionNO3N)
            if (Gndr14 == "ஆண்") { maha_combination.append(strAdditionP14zMC, strAdditionP1aN3) } else { maha_combination.append(strAdditionP14zC, strAdditionP1bN3) }
            maha_combination.append(strAdditionP1cN3, space)
        }
        if (nFifteen != "") { maha_combination.append(strAdditionP15, strAdditionNO1O)
            if (Gndr15 == "ஆண்") { maha_combination.append(strAdditionP15zM, strAdditionP1aO1) } else { maha_combination.append(strAdditionP15zA, strAdditionP1bO1) }
            maha_combination.append(strAdditionP1cO1, strAdditionP15ob, strAdditionNO2O)
            if (Gndr15 == "ஆண்") { maha_combination.append(strAdditionP15zMB, strAdditionP1aO2) } else { maha_combination.append(strAdditionP15zB, strAdditionP1bO2) }
            maha_combination.append(strAdditionP1cO2, strAdditionP15oc, strAdditionNO3O)
            if (Gndr15 == "ஆண்") { maha_combination.append(strAdditionP15zMC, strAdditionP1aO3) } else { maha_combination.append(strAdditionP15zC, strAdditionP1bO3) }
            maha_combination.append(strAdditionP1cO3, space)
        }
        maha_combination.append(strAdditionP1P, mBody87P1, strAdditionP2P, mBody87P2, strAdditionP3P, mBody87P3, mComment51, mBody88,
            mComment51a, mGreenComment2, mComment52, mBody89, mRedComment4, mComment53)
        if (MFatherLive == "Deceased") { maha_combination.append(mComment54a) } else { maha_combination.append(mComment54) }
        maha_combination.append(mComment55, mComment55A, mBody90, mComment55BP, mBody90P, mComment55B, mBody90P2, mComment55C)
        if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { maha_combination.append(mComment57) }else maha_combination.append(mComment56)
        maha_combination.append(mComment58, mBody91, mComment55DP, mMBody91P, mComment55D, mMBody91)
        if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { maha_combination.append(mComment57A) }else maha_combination.append(mComment55EP)
        maha_combination.append(mComment58A, mMBody91A, mGreenComment3, mBody92, mVARGAI1B, mBody93, mComment59, mBody94, mComment60,
            mBody95, mComment61, mBody96, mVARGAI1BP, mBody97, mComment62, mHeading6, mRedComment5)
        if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { maha_combination.append(Comment64) }else maha_combination.append(mComment63)
        maha_combination.append(MComment64, mComment65, mBody98)
        if (motherLive == "Deceased" && fatherMotherLive == "Deceased"){ maha_combination.append(mBody98A)}
        if (yrGFatherLive == "Deceased") { maha_combination.append(mBody99A) } else { maha_combination.append(mBody99B) }
        maha_combination.append(mMComment64AP, mBody98PA)
        if (motherMotherLive == "Deceased"){ maha_combination.append(mBody98PB)}
        maha_combination.append(mBody98PC, mMComment64A, mMBody98, mComment66, mBody100, mComment67, mGreenComment4, mComment68, mBody101, mComment69, mBody102, mComment70, mBody103)
        if (noOfDaysTpnm == "15days") { maha_combination.append(mBody103B) }else { maha_combination.append(mBody103A) }
        maha_combination.append(mVARGAI1BP2, mBody104, mComment71, mBody105, mRedComment6, mComment72, mComment73)
        if (kizhamai == "பௌம" || kizhamai == "ப்ருகு") { maha_combination.append(mComment75) }else maha_combination.append(mComment74)
        maha_combination.append(mComment76, mBody106, mBody107Big, mBody108, mGreenComment5, mComment77, mHeading7)
    }
    maha_combination.append("\n\n")
}
