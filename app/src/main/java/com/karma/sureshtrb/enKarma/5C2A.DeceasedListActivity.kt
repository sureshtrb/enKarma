package com.karma.sureshtrb.enKarma

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.text.Editable
import android.view.View
import android.widget.*
import androidx.core.view.get
//import kotlinx.android.synthetic.main.activity_deceased_list.*
import com.karma.sureshtrb.enKarma.databinding.ActivityDeceasedListBinding


var headRow:String = ""
var name1:String = ""
var name2:String = ""
var name3:String = ""
var name4:String = ""
var name5:String = ""
var name6:String = ""
var name7:String = ""
var name8:String = ""
var name9:String = ""
var name10:String = ""
var name11:String = ""
var name12:String = ""
var name13:String = ""
var name14:String = ""
var name15:String = ""
var BrOr1:String = ""
var BrOr2:String = ""
var BrOr3:String = ""
var BrOr4:String = ""
var BrOr5:String = ""
var BrOr6:String = ""
var BrOr7:String = ""
var BrOr8:String = ""
var BrOr9:String = ""
var BrOr10:String = ""
var BrOr11:String = ""
var BrOr12:String = ""
var BrOr13:String = ""
var BrOr14:String = ""
var BrOr15:String = ""
var Goth1:String = ""
var Goth2:String = ""
var Goth3:String = ""
var Goth4:String = ""
var Goth5:String = ""
var Goth6:String = ""
var Goth7:String = ""
var Goth8:String = ""
var Goth9:String = ""
var Goth10:String = ""
var Goth11:String = ""
var Goth12:String = ""
var Goth13:String = ""
var Goth14:String = ""
var Goth15:String = ""
var Gndr1:String = ""
var Gndr2:String = ""
var Gndr3:String = ""
var Gndr4:String = ""
var Gndr5:String = ""
var Gndr6:String = ""
var Gndr7:String = ""
var Gndr8:String = ""
var Gndr9:String = ""
var Gndr10:String = ""
var Gndr11:String = ""
var Gndr12:String = ""
var Gndr13:String = ""
var Gndr14:String = ""
var Gndr15:String = ""
var RlShp1:String = ""
var RlShp2:String = ""
var RlShp3:String = ""
var RlShp4:String = ""
var RlShp5:String = ""
var RlShp6:String = ""
var RlShp7:String = ""
var RlShp8:String = ""
var RlShp9:String = ""
var RlShp10:String = ""
var RlShp11:String = ""
var RlShp12:String = ""
var RlShp13:String = ""
var RlShp14:String = ""
var RlShp15:String = ""

var personGothram: String = ""
var personRelationShip: String = ""
var personGender: String = ""
var personBirthOrder: String = ""
class DeceasedListActivity : AppCompatActivity() {

    val sharedPrefs: String = ""
    val SHARED_PREFS:String = ""
    private lateinit var binding: ActivityDeceasedListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_deceased_list)
        binding = ActivityDeceasedListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.setHomeAsUpIndicator(R.drawable.home)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.subtitle = "Deceased Names / மறைந்தோர் விபரங்கள்"
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setLogo(R.drawable.karma)
        supportActionBar!!.setDisplayUseLogoEnabled(true)

        val tableRows = findViewById<TableLayout>(R.id.tableLayout)
        val NameEdit = findViewById<EditText>(R.id.name_of_the_person)
        val persGothram = findViewById<Spinner>(R.id.gthrm)
        val persGender = findViewById<Spinner>(R.id.genderOrder)
        val persRelation = findViewById<Spinner>(R.id.relShip)
        val persBirthOrder = findViewById<Spinner>(R.id.birth_Order)
        val savingData = findViewById<Button>(R.id.SaveName)
        val mahTpnmBtn = findViewById<Button>(R.id.MAHTARPANAMBTN)
        val emptyData = findViewById<Button>(R.id.ClearAll)

        val headRow = findViewById<TableRow>(R.id.headRow)
        val firstRow = findViewById<TableRow>(R.id.firstRow)
        val secondRow = findViewById<TableRow>(R.id.secondRow)
        val thirdRow = findViewById<TableRow>(R.id.thirdRow)
        val fourthRow = findViewById<TableRow>(R.id.fourthRow)
        val fifthRow = findViewById<TableRow>(R.id.fifthRow)
        val sixthRow = findViewById<TableRow>(R.id.sixthRow)
        val seventhRow = findViewById<TableRow>(R.id.seventhRow)
        val eighthRow = findViewById<TableRow>(R.id.eighthRow)
        val ninethRow = findViewById<TableRow>(R.id.ninethRow)
        val tenRow = findViewById<TableRow>(R.id.tenRow)
        val elevenRow = findViewById<TableRow>(R.id.elevenRow)
        val twelveRow = findViewById<TableRow>(R.id.twelveRow)
        val thirteenRow = findViewById<TableRow>(R.id.thirteenRow)
        val fourteenRow = findViewById<TableRow>(R.id.fourteenRow)
        val fifteenRow = findViewById<TableRow>(R.id.fifteenRow)
        val name0 = findViewById<TextView>(R.id.Name)
        val nameOne = findViewById<TextView>(R.id.Name1)
        val nameTwo = findViewById<TextView>(R.id.Name2)
        val nameThree = findViewById<TextView>(R.id.Name3)
        val nameFour = findViewById<TextView>(R.id.Name4)
        val nameFive = findViewById<TextView>(R.id.Name5)
        val nameSix = findViewById<TextView>(R.id.Name6)
        val nameSeven = findViewById<TextView>(R.id.Name7)
        val nameEight = findViewById<TextView>(R.id.Name8)
        val nameNine = findViewById<TextView>(R.id.Name9)
        val nameTen = findViewById<TextView>(R.id.Name10)
        val nameEleven = findViewById<TextView>(R.id.Name11)
        val nameTwelve = findViewById<TextView>(R.id.Name12)
        val nameThirteen = findViewById<TextView>(R.id.Name13)
        val nameFourteen = findViewById<TextView>(R.id.Name14)
        val nameFifteen = findViewById<TextView>(R.id.Name15)

        val bthOdr0 = findViewById<TextView>(R.id.BirthOrder)
        val bthOdrOne = findViewById<TextView>(R.id.BirthOrder1)
        val bthOdrTwo = findViewById<TextView>(R.id.BirthOrder2)
        val bthOdrThree = findViewById<TextView>(R.id.BirthOrder3)
        val bthOdrFour = findViewById<TextView>(R.id.BirthOrder4)
        val bthOdrFive = findViewById<TextView>(R.id.BirthOrder5)
        val bthOdrSix = findViewById<TextView>(R.id.BirthOrder6)
        val bthOdrSeven = findViewById<TextView>(R.id.BirthOrder7)
        val bthOdrEight = findViewById<TextView>(R.id.BirthOrder8)
        val bthOdrNine = findViewById<TextView>(R.id.BirthOrder9)
        val bthOdrTen = findViewById<TextView>(R.id.BirthOrder10)
        val bthOdrEleven = findViewById<TextView>(R.id.BirthOrder11)
        val bthOdrTwelve = findViewById<TextView>(R.id.BirthOrder12)
        val bthOdrThirteen = findViewById<TextView>(R.id.BirthOrder13)
        val bthOdrFourteen = findViewById<TextView>(R.id.BirthOrder14)
        val bthOdrFifteen = findViewById<TextView>(R.id.BirthOrder15)

        val gthrm0 = findViewById<TextView>(R.id.gotram)
        val gthrmOne = findViewById<TextView>(R.id.gotram1)
        val gthrmTwo = findViewById<TextView>(R.id.gotram2)
        val gthrmThree = findViewById<TextView>(R.id.gotram3)
        val gthrmFour = findViewById<TextView>(R.id.gotram4)
        val gthrmFive = findViewById<TextView>(R.id.gotram5)
        val gthrmSix = findViewById<TextView>(R.id.gotram6)
        val gthrmSeven = findViewById<TextView>(R.id.gotram7)
        val gthrmEight = findViewById<TextView>(R.id.gotram8)
        val gthrmNine = findViewById<TextView>(R.id.gotram9)
        val gthrmTen = findViewById<TextView>(R.id.gotram10)
        val gthrmEleven = findViewById<TextView>(R.id.gotram11)
        val gthrmTwelve = findViewById<TextView>(R.id.gotram12)
        val gthrmThirteen = findViewById<TextView>(R.id.gotram13)
        val gthrmFourteen = findViewById<TextView>(R.id.gotram14)
        val gthrmFifteen = findViewById<TextView>(R.id.gotram15)

        val relsp0 = findViewById<TextView>(R.id.relationship)
        val relspOne = findViewById<TextView>(R.id.relationship1)
        val relspTwo = findViewById<TextView>(R.id.relationship2)
        val relspThree = findViewById<TextView>(R.id.relationship3)
        val relspFour = findViewById<TextView>(R.id.relationship4)
        val relspFive = findViewById<TextView>(R.id.relationship5)
        val relspSix = findViewById<TextView>(R.id.relationship6)
        val relspSeven = findViewById<TextView>(R.id.relationship7)
        val relspEight = findViewById<TextView>(R.id.relationship8)
        val relspNine = findViewById<TextView>(R.id.relationship9)
        val relspTen = findViewById<TextView>(R.id.relationship10)
        val relspEleven = findViewById<TextView>(R.id.relationship11)
        val relspTwelve = findViewById<TextView>(R.id.relationship12)
        val relspThirteen = findViewById<TextView>(R.id.relationship13)
        val relspFourteen = findViewById<TextView>(R.id.relationship14)
        val relspFifteen = findViewById<TextView>(R.id.relationship15)

        val delete1 = findViewById<ImageButton>(R.id.editRow1)
        val delete2 = findViewById<ImageButton>(R.id.editRow2)
        val delete3 = findViewById<ImageButton>(R.id.editRow3)
        val delete4 = findViewById<ImageButton>(R.id.editRow4)
        val delete5 = findViewById<ImageButton>(R.id.editRow5)
        val delete6 = findViewById<ImageButton>(R.id.editRow6)
        val delete7 = findViewById<ImageButton>(R.id.editRow7)
        val delete8 = findViewById<ImageButton>(R.id.editRow8)
        val delete9 = findViewById<ImageButton>(R.id.editRow9)
        val delete10 = findViewById<ImageButton>(R.id.editRow10)
        val delete11 = findViewById<ImageButton>(R.id.editRow11)
        val delete12 = findViewById<ImageButton>(R.id.editRow12)
        val delete13 = findViewById<ImageButton>(R.id.editRow13)
        val delete14 = findViewById<ImageButton>(R.id.editRow14)
        val delete15 = findViewById<ImageButton>(R.id.editRow15)

        binding.headRow.visibility = View.INVISIBLE
        binding.firstRow.visibility = View.INVISIBLE
        binding.secondRow.visibility = View.INVISIBLE
        binding.thirdRow.visibility = View.INVISIBLE
        binding.fourthRow.visibility = View.INVISIBLE
        binding.fifthRow.visibility = View.INVISIBLE
        binding.sixthRow.visibility = View.INVISIBLE
        binding.seventhRow.visibility = View.INVISIBLE
        binding.eighthRow.visibility = View.INVISIBLE
        binding.ninethRow.visibility = View.INVISIBLE
        binding.tenRow.visibility = View.INVISIBLE
        binding.elevenRow.visibility = View.INVISIBLE
        binding.twelveRow.visibility = View.INVISIBLE
        binding.thirteenRow.visibility = View.INVISIBLE
        binding.fourteenRow.visibility = View.INVISIBLE
        binding.fifteenRow.visibility = View.INVISIBLE


        val intent = intent
        val dateTdy: String = intent.getStringExtra("Naal")?:""
        val place: String = intent.getStringExtra("Idam")?:""
        val Varusham: String = intent.getStringExtra("TamilYear")?:""
        val ayyanamm: String = intent.getStringExtra("Ayanamm")?:""
        val kalam: String = intent.getStringExtra("KAALAM")?:""
        val rasee: String = intent.getStringExtra("RASEEE")?:""
        val baksham: String = intent.getStringExtra("BAKKSHAMM")?:""
        val todThithi: String = intent.getStringExtra("TODAYSTHITHI")?:""
        val kizhamai: String = intent.getStringExtra("KIZHAMAAII")?:""
        val nachathirm: String = intent.getStringExtra("NAKSM")?:""
        val yog: String = intent.getStringExtra("YGM")?:""
        val kar: String = intent.getStringExtra("KRNM")?:""

        val yrNamee: String = intent.getStringExtra("Peyar")?:""
        val yrFNamee: String = intent.getStringExtra("Appa")?:""
        val yrGFNamee: String = intent.getStringExtra("Thatha")?:""
        val yrGGFNamee: String = intent.getStringExtra("Kollu")?:""
        val yrGGGFNamee: String = intent.getStringExtra("Yellu")?:""
        val MFNamee: String = intent.getStringExtra("AmmaAppa")?:""
        val MGFNamee: String = intent.getStringExtra("AmmaThatha")?:""
        val MGGFNamee: String = intent.getStringExtra("AmmaKolluThatha")?:""
        val noOfDays:String =intent.getStringExtra("howManyDays")?:""

        val ammaNamee:String = intent.getStringExtra("ammaName")?:""
        val appaAmmaNamee:String = intent.getStringExtra("appaAmmaName")?:""
        val appaPattiNamee:String = intent.getStringExtra("appaPattiName")?:""
        val appaKolluPattiNamee:String = intent.getStringExtra("appaKolluPattiName")?:""
        val ammaAmmaNamee:String = intent.getStringExtra("ammaAmmaName")?:""
        val ammaPattiNamee:String = intent.getStringExtra("ammaPattiName")?:""
        val ammaKolluPattiNamee:String = intent.getStringExtra("ammaKolluPattiName")?:""

        println("DeceasedPerson-ammaName : $ammaNamee")
        println("DeceasedPerson-appaAmmaName : $appaAmmaNamee")
        println("DeceasedPerson-appaPattiName : $appaPattiNamee")
        println("DeceasedPerson-appaKolluPattiName : $appaKolluPattiNamee")
        println("DeceasedPerson-ammaAmmaName: $ammaAmmaNamee")
        println("DeceasedPerson-ammaAmmaName : $ammaPattiNamee")
        println("DeceasedPerson-ammaKolluPattiName : $ammaKolluPattiNamee")

        println("DeceasedPerson-noOfDays : $noOfDays")
        println("DeceasedPerson-dateTdy : $dateTdy")
        println("DeceasedPerson-place : $place")
        println("DeceasedPerson-Varusham : $Varusham")
        println("DeceasedPerson-ayyanamm : $ayyanamm")
        println("DeceasedPerson-kalam : $kalam")
        println("DeceasedPerson-rasee : $rasee")
        println("DeceasedPerson-baksham : $baksham")
        println("DeceasedPerson-todThithi : $todThithi")
        println("DeceasedPerson-kizhamai : $kizhamai")
        println("DeceasedPerson-nachathirm : $nachathirm")
        println("DeceasedPerson-yog: $yog")
        println("DeceasedPerson-kar : $kar")
        println("DeceasedPerson-FLiveStatus : $fatherLive")
        println("DeceasedPerson-MLiveStatus : $motherLive")
        println("DeceasedPerson-MMLiveSTatus: $motherMotherLive")
        println("DeceasedPerson-FMLiveSTatus : $fatherMotherLive")

        println("DeceasedPerson-yrNamee : $yrNamee")
        println("DeceasedPerson-yrFNamee : $yrFNamee")
        println("DeceasedPerson-yrGFNamee : $yrGFNamee")
        println("DeceasedPerson-yrGGFNamee : $yrGGFNamee")
        println("DeceasedPerson-yrGGGFNamee: $yrGGGFNamee")
        println("DeceasedPerson-MFNamee : $MFNamee")
        println("DeceasedPerson-MGFNamee : $MGFNamee")
        println("DeceasedPerson-MGGFNamee : $MGGFNamee")

        loadData()
        updateViews()
                setupRowLongClickListeners()

        delete1.setOnClickListener{
            nameOne.text = ""
            bthOdrOne.text = ""
            gthrmOne.text = ""
            relspOne.text = ""
            Gndr1=""
            if (nameTwo.text != "") {
                nameOne.text = nameTwo.text
                bthOdrOne.text = bthOdrTwo.text
                gthrmOne.text = gthrmTwo.text
                relspOne.text = relspTwo.text
                Gndr1 = Gndr2
                nameTwo.text = nameThree.text
                bthOdrTwo.text = bthOdrThree.text
                gthrmTwo.text = gthrmThree.text
                relspTwo.text = relspThree.text
                Gndr2 = Gndr3
                nameThree.text = nameFour.text
                bthOdrThree.text = bthOdrFour.text
                gthrmThree.text = gthrmFour.text
                relspThree.text = relspFour.text
                Gndr3 = Gndr4
                nameFour.text = nameFive.text
                bthOdrFour.text = bthOdrFive.text
                gthrmFour.text = gthrmFive.text
                relspFour.text = relspFive.text
                Gndr4 = Gndr5
                Gndr5 = Gndr6
                nameFive.text = nameSix.text
                bthOdrFive.text = bthOdrSix.text
                gthrmFive.text = gthrmSix.text
                relspFive.text = relspSix.text
                Gndr6 = Gndr7
                nameSix.text = nameSeven.text
                bthOdrSix.text = bthOdrSeven.text
                gthrmSix.text = gthrmSeven.text
                relspSix.text = relspSeven.text
                Gndr7 = Gndr8
                nameSeven.text = nameEight.text
                bthOdrSeven.text = bthOdrEight.text
                gthrmSeven.text = gthrmEight.text
                relspSeven.text = relspEight.text
                Gndr8 = Gndr9
                nameEight.text = nameNine.text
                bthOdrEight.text = bthOdrNine.text
                gthrmEight.text = gthrmNine.text
                relspEight.text = relspNine.text
                nameNine.text = nameTen.text
                bthOdrNine.text = bthOdrTen.text
                gthrmNine.text = gthrmTen.text
                relspNine.text = relspTen.text
                Gndr9 = Gndr10
                nameTen.text = nameEleven.text
                bthOdrTen.text = bthOdrEleven.text
                gthrmTen.text = gthrmEleven.text
                relspTen.text = relspEleven.text
                Gndr10 = Gndr11
                nameEleven.text = nameTwelve.text
                bthOdrEleven.text = bthOdrTwelve.text
                gthrmEleven.text = gthrmTwelve.text
                relspEleven.text = relspTwelve.text
                Gndr11 = Gndr12
                nameTwelve.text = nameThirteen.text
                bthOdrTwelve.text = bthOdrThirteen.text
                gthrmTwelve.text = gthrmThirteen.text
                relspTwelve.text = relspThirteen.text
                Gndr12 = Gndr13
                nameThirteen.text = nameFourteen.text
                bthOdrThirteen.text = bthOdrFourteen.text
                gthrmThirteen.text = gthrmFourteen.text
                relspThirteen.text = relspFourteen.text
                Gndr13 = Gndr14
                nameFourteen.text = nameFifteen.text
                bthOdrFourteen.text = bthOdrFifteen.text
                gthrmFourteen.text = gthrmFifteen.text
                relspFourteen.text = relspFifteen.text
                Gndr14 = Gndr15
                Gndr15 = ""
                nameFifteen.text = ""
                bthOdrFifteen.text = ""
                gthrmFifteen.text = ""
                relspFifteen.text = ""
            }
            if (nameOne.text == "") { headRow.visibility = View.INVISIBLE
                firstRow.visibility = View.INVISIBLE
            }else { headRow.visibility = View.VISIBLE
                firstRow.visibility = View.VISIBLE }
            if (nameTwo.text == "") { secondRow.visibility = View.INVISIBLE }else{ secondRow.visibility = View.VISIBLE }
            if (nameThree.text == "") { thirdRow.visibility = View.INVISIBLE }else{ thirdRow.visibility = View.VISIBLE }
            if (nameFour.text == "") { fourthRow.visibility = View.INVISIBLE }else{ fourthRow.visibility = View.VISIBLE }
            if (nameFive.text == "") { fifthRow.visibility = View.INVISIBLE }else{ fifthRow.visibility = View.VISIBLE }
            if (nameSix.text == "") { sixthRow.visibility = View.INVISIBLE }else{ sixthRow.visibility = View.VISIBLE }
            if (nameSeven.text == "") { seventhRow.visibility = View.INVISIBLE }else{ seventhRow.visibility = View.VISIBLE }
            if (nameEight.text == "") { eighthRow.visibility = View.INVISIBLE }else{ eighthRow.visibility = View.VISIBLE }
            if (nameNine.text == "") { ninethRow.visibility = View.INVISIBLE }else{ ninethRow.visibility = View.VISIBLE }
            if (nameTen.text == "") { tenRow.visibility = View.INVISIBLE }else{ tenRow.visibility = View.VISIBLE }
            if (nameEleven.text == "") { elevenRow.visibility = View.INVISIBLE }else{ elevenRow.visibility = View.VISIBLE }
            if (nameTwelve.text == "") { twelveRow.visibility = View.INVISIBLE }else{ twelveRow.visibility = View.VISIBLE }
            if (nameThirteen.text == "") { thirteenRow.visibility = View.INVISIBLE }else{ thirteenRow.visibility = View.VISIBLE }
            if (nameFourteen.text == "") { fourteenRow.visibility = View.INVISIBLE }else{ fourteenRow.visibility = View.VISIBLE }
            if (nameFifteen.text == "") { fifteenRow.visibility = View.INVISIBLE }else{ fifteenRow.visibility = View.VISIBLE }

        }
        delete2.setOnClickListener{
            nameTwo.text = ""
            bthOdrTwo.text = ""
            gthrmTwo.text = ""
            relspTwo.text = ""
            Gndr2=""
            if (nameThree.text != "") {
                nameTwo.text = nameThree.text
                bthOdrTwo.text = bthOdrThree.text
                gthrmTwo.text = gthrmThree.text
                relspTwo.text = relspThree.text
                Gndr2 = Gndr3
                nameThree.text = nameFour.text
                bthOdrThree.text = bthOdrFour.text
                gthrmThree.text = gthrmFour.text
                relspThree.text = relspFour.text
                Gndr3 = Gndr4
                nameFour.text = nameFive.text
                bthOdrFour.text = bthOdrFive.text
                gthrmFour.text = gthrmFive.text
                relspFour.text = relspFive.text
                Gndr4 = Gndr5
                Gndr5 = Gndr6
                nameFive.text = nameSix.text
                bthOdrFive.text = bthOdrSix.text
                gthrmFive.text = gthrmSix.text
                relspFive.text = relspSix.text
                Gndr6 = Gndr7
                nameSix.text = nameSeven.text
                bthOdrSix.text = bthOdrSeven.text
                gthrmSix.text = gthrmSeven.text
                relspSix.text = relspSeven.text
                Gndr7 = Gndr8
                nameSeven.text = nameEight.text
                bthOdrSeven.text = bthOdrEight.text
                gthrmSeven.text = gthrmEight.text
                relspSeven.text = relspEight.text
                Gndr8 = Gndr9
                nameEight.text = nameNine.text
                bthOdrEight.text = bthOdrNine.text
                gthrmEight.text = gthrmNine.text
                relspEight.text = relspNine.text
                nameNine.text = nameTen.text
                bthOdrNine.text = bthOdrTen.text
                gthrmNine.text = gthrmTen.text
                relspNine.text = relspTen.text
                Gndr9 = Gndr10
                nameTen.text = nameEleven.text
                bthOdrTen.text = bthOdrEleven.text
                gthrmTen.text = gthrmEleven.text
                relspTen.text = relspEleven.text
                Gndr10 = Gndr11
                nameEleven.text = nameTwelve.text
                bthOdrEleven.text = bthOdrTwelve.text
                gthrmEleven.text = gthrmTwelve.text
                relspEleven.text = relspTwelve.text
                Gndr11 = Gndr12
                nameTwelve.text = nameThirteen.text
                bthOdrTwelve.text = bthOdrThirteen.text
                gthrmTwelve.text = gthrmThirteen.text
                relspTwelve.text = relspThirteen.text
                Gndr12 = Gndr13
                nameThirteen.text = nameFourteen.text
                bthOdrThirteen.text = bthOdrFourteen.text
                gthrmThirteen.text = gthrmFourteen.text
                relspThirteen.text = relspFourteen.text
                Gndr13 = Gndr14
                nameFourteen.text = nameFifteen.text
                bthOdrFourteen.text = bthOdrFifteen.text
                gthrmFourteen.text = gthrmFifteen.text
                relspFourteen.text = relspFifteen.text
                Gndr14 = Gndr15
                Gndr15 = ""
                nameFifteen.text = ""
                bthOdrFifteen.text = ""
                gthrmFifteen.text = ""
                relspFifteen.text = ""
                binding.editRow15.visibility = View.INVISIBLE
            }
            if (nameTwo.text == "") { secondRow.visibility = View.INVISIBLE }else{ secondRow.visibility = View.VISIBLE }
            if (nameThree.text == "") { thirdRow.visibility = View.INVISIBLE }else{ thirdRow.visibility = View.VISIBLE }
            if (nameFour.text == "") { fourthRow.visibility = View.INVISIBLE }else{ fourthRow.visibility = View.VISIBLE }
            if (nameFive.text == "") { fifthRow.visibility = View.INVISIBLE }else{ fifthRow.visibility = View.VISIBLE }
            if (nameSix.text == "") { sixthRow.visibility = View.INVISIBLE }else{ sixthRow.visibility = View.VISIBLE }
            if (nameSeven.text == "") { seventhRow.visibility = View.INVISIBLE }else{ seventhRow.visibility = View.VISIBLE }
            if (nameEight.text == "") { eighthRow.visibility = View.INVISIBLE }else{ eighthRow.visibility = View.VISIBLE }
            if (nameNine.text == "") { ninethRow.visibility = View.INVISIBLE }else{ ninethRow.visibility = View.VISIBLE }
            if (nameTen.text == "") { tenRow.visibility = View.INVISIBLE }else{ tenRow.visibility = View.VISIBLE }
            if (nameEleven.text == "") { elevenRow.visibility = View.INVISIBLE }else{ elevenRow.visibility = View.VISIBLE }
            if (nameTwelve.text == "") { twelveRow.visibility = View.INVISIBLE }else{ twelveRow.visibility = View.VISIBLE }
            if (nameThirteen.text == "") { thirteenRow.visibility = View.INVISIBLE }else{ thirteenRow.visibility = View.VISIBLE }
            if (nameFourteen.text == "") { fourteenRow.visibility = View.INVISIBLE }else{ fourteenRow.visibility = View.VISIBLE }
            if (nameFifteen.text == "") { fifteenRow.visibility = View.INVISIBLE }else{ fifteenRow.visibility = View.VISIBLE }
        }
        delete3.setOnClickListener{
            nameThree.text = ""
            bthOdrThree.text = ""
            gthrmThree.text = ""
            relspThree.text = ""
            Gndr3=""
            if (nameFour.text != "") {
                nameThree.text = nameFour.text
                bthOdrThree.text = bthOdrFour.text
                gthrmThree.text = gthrmFour.text
                relspThree.text = relspFour.text
                Gndr3 = Gndr4
                nameFour.text = nameFive.text
                bthOdrFour.text = bthOdrFive.text
                gthrmFour.text = gthrmFive.text
                relspFour.text = relspFive.text
                Gndr4 = Gndr5
                Gndr5 = Gndr6
                nameFive.text = nameSix.text
                bthOdrFive.text = bthOdrSix.text
                gthrmFive.text = gthrmSix.text
                relspFive.text = relspSix.text
                Gndr6 = Gndr7
                nameSix.text = nameSeven.text
                bthOdrSix.text = bthOdrSeven.text
                gthrmSix.text = gthrmSeven.text
                relspSix.text = relspSeven.text
                Gndr7 = Gndr8
                nameSeven.text = nameEight.text
                bthOdrSeven.text = bthOdrEight.text
                gthrmSeven.text = gthrmEight.text
                relspSeven.text = relspEight.text
                Gndr8 = Gndr9
                nameEight.text = nameNine.text
                bthOdrEight.text = bthOdrNine.text
                gthrmEight.text = gthrmNine.text
                relspEight.text = relspNine.text
                nameNine.text = nameTen.text
                bthOdrNine.text = bthOdrTen.text
                gthrmNine.text = gthrmTen.text
                relspNine.text = relspTen.text
                Gndr9 = Gndr10
                nameTen.text = nameEleven.text
                bthOdrTen.text = bthOdrEleven.text
                gthrmTen.text = gthrmEleven.text
                relspTen.text = relspEleven.text
                Gndr10 = Gndr11
                nameEleven.text = nameTwelve.text
                bthOdrEleven.text = bthOdrTwelve.text
                gthrmEleven.text = gthrmTwelve.text
                relspEleven.text = relspTwelve.text
                Gndr11 = Gndr12
                nameTwelve.text = nameThirteen.text
                bthOdrTwelve.text = bthOdrThirteen.text
                gthrmTwelve.text = gthrmThirteen.text
                relspTwelve.text = relspThirteen.text
                Gndr12 = Gndr13
                nameThirteen.text = nameFourteen.text
                bthOdrThirteen.text = bthOdrFourteen.text
                gthrmThirteen.text = gthrmFourteen.text
                relspThirteen.text = relspFourteen.text
                Gndr13 = Gndr14
                nameFourteen.text = nameFifteen.text
                bthOdrFourteen.text = bthOdrFifteen.text
                gthrmFourteen.text = gthrmFifteen.text
                relspFourteen.text = relspFifteen.text
                Gndr14 = Gndr15
                Gndr15 = ""
                nameFifteen.text = ""
                bthOdrFifteen.text = ""
                gthrmFifteen.text = ""
                relspFifteen.text = ""
                binding.editRow15.visibility = View.INVISIBLE
            }
            if (nameThree.text == "") { thirdRow.visibility = View.INVISIBLE }else{ thirdRow.visibility = View.VISIBLE }
            if (nameFour.text == "") { fourthRow.visibility = View.INVISIBLE }else{ fourthRow.visibility = View.VISIBLE }
            if (nameFive.text == "") { fifthRow.visibility = View.INVISIBLE }else{ fifthRow.visibility = View.VISIBLE }
            if (nameSix.text == "") { sixthRow.visibility = View.INVISIBLE }else{ sixthRow.visibility = View.VISIBLE }
            if (nameSeven.text == "") { seventhRow.visibility = View.INVISIBLE }else{ seventhRow.visibility = View.VISIBLE }
            if (nameEight.text == "") { eighthRow.visibility = View.INVISIBLE }else{ eighthRow.visibility = View.VISIBLE }
            if (nameNine.text == "") { ninethRow.visibility = View.INVISIBLE }else{ ninethRow.visibility = View.VISIBLE }
            if (nameTen.text == "") { tenRow.visibility = View.INVISIBLE }else{ tenRow.visibility = View.VISIBLE }
            if (nameEleven.text == "") { elevenRow.visibility = View.INVISIBLE }else{ elevenRow.visibility = View.VISIBLE }
            if (nameTwelve.text == "") { twelveRow.visibility = View.INVISIBLE }else{ twelveRow.visibility = View.VISIBLE }
            if (nameThirteen.text == "") { thirteenRow.visibility = View.INVISIBLE }else{ thirteenRow.visibility = View.VISIBLE }
            if (nameFourteen.text == "") { fourteenRow.visibility = View.INVISIBLE }else{ fourteenRow.visibility = View.VISIBLE }
            if (nameFifteen.text == "") { fifteenRow.visibility = View.INVISIBLE }else{ fifteenRow.visibility = View.VISIBLE }
        }
        delete4.setOnClickListener{
            nameFour.text = ""
            bthOdrFour.text = ""
            gthrmFour.text = ""
            relspFour.text = ""
            Gndr4=""
            if (nameFive.text != "") {
                nameFour.text = nameFive.text
                bthOdrFour.text = bthOdrFive.text
                gthrmFour.text = gthrmFive.text
                relspFour.text = relspFive.text
                Gndr4 = Gndr5
                Gndr5 = Gndr6
                nameFive.text = nameSix.text
                bthOdrFive.text = bthOdrSix.text
                gthrmFive.text = gthrmSix.text
                relspFive.text = relspSix.text
                Gndr6 = Gndr7
                nameSix.text = nameSeven.text
                bthOdrSix.text = bthOdrSeven.text
                gthrmSix.text = gthrmSeven.text
                relspSix.text = relspSeven.text
                Gndr7 = Gndr8
                nameSeven.text = nameEight.text
                bthOdrSeven.text = bthOdrEight.text
                gthrmSeven.text = gthrmEight.text
                relspSeven.text = relspEight.text
                Gndr8 = Gndr9
                nameEight.text = nameNine.text
                bthOdrEight.text = bthOdrNine.text
                gthrmEight.text = gthrmNine.text
                relspEight.text = relspNine.text
                nameNine.text = nameTen.text
                bthOdrNine.text = bthOdrTen.text
                gthrmNine.text = gthrmTen.text
                relspNine.text = relspTen.text
                Gndr9 = Gndr10
                nameTen.text = nameEleven.text
                bthOdrTen.text = bthOdrEleven.text
                gthrmTen.text = gthrmEleven.text
                relspTen.text = relspEleven.text
                Gndr10 = Gndr11
                relspEleven.text = ""
                nameEleven.text = nameTwelve.text
                bthOdrEleven.text = bthOdrTwelve.text
                gthrmEleven.text = gthrmTwelve.text
                relspEleven.text = relspTwelve.text
                Gndr11 = Gndr12
                nameTwelve.text = nameThirteen.text
                bthOdrTwelve.text = bthOdrThirteen.text
                gthrmTwelve.text = gthrmThirteen.text
                relspTwelve.text = relspThirteen.text
                Gndr12 = Gndr13
                nameThirteen.text = nameFourteen.text
                bthOdrThirteen.text = bthOdrFourteen.text
                gthrmThirteen.text = gthrmFourteen.text
                relspThirteen.text = relspFourteen.text
                Gndr13 = Gndr14
                nameFourteen.text = nameFifteen.text
                bthOdrFourteen.text = bthOdrFifteen.text
                gthrmFourteen.text = gthrmFifteen.text
                relspFourteen.text = relspFifteen.text
                Gndr14 = Gndr15
                Gndr15 = ""
                nameFifteen.text = ""
                bthOdrFifteen.text = ""
                gthrmFifteen.text = ""
                relspFifteen.text = ""
                binding.editRow15.visibility = View.INVISIBLE
            }
            if (nameFour.text == "") { fourthRow.visibility = View.INVISIBLE }else{ fourthRow.visibility = View.VISIBLE }
            if (nameFive.text == "") { fifthRow.visibility = View.INVISIBLE }else{ fifthRow.visibility = View.VISIBLE }
            if (nameSix.text == "") { sixthRow.visibility = View.INVISIBLE }else{ sixthRow.visibility = View.VISIBLE }
            if (nameSeven.text == "") { seventhRow.visibility = View.INVISIBLE }else{ seventhRow.visibility = View.VISIBLE }
            if (nameEight.text == "") { eighthRow.visibility = View.INVISIBLE }else{ eighthRow.visibility = View.VISIBLE }
            if (nameNine.text == "") { ninethRow.visibility = View.INVISIBLE }else{ ninethRow.visibility = View.VISIBLE }
            if (nameTen.text == "") { tenRow.visibility = View.INVISIBLE }else{ tenRow.visibility = View.VISIBLE }
            if (nameEleven.text == "") { elevenRow.visibility = View.INVISIBLE }else{ elevenRow.visibility = View.VISIBLE }
            if (nameTwelve.text == "") { twelveRow.visibility = View.INVISIBLE }else{ twelveRow.visibility = View.VISIBLE }
            if (nameThirteen.text == "") { thirteenRow.visibility = View.INVISIBLE }else{ thirteenRow.visibility = View.VISIBLE }
            if (nameFourteen.text == "") { fourteenRow.visibility = View.INVISIBLE }else{ fourteenRow.visibility = View.VISIBLE }
            if (nameFifteen.text == "") { fifteenRow.visibility = View.INVISIBLE }else{ fifteenRow.visibility = View.VISIBLE }
        }
        delete5.setOnClickListener{
            nameFive.text = ""
            bthOdrFive.text = ""
            gthrmFive.text = ""
            relspFive.text = ""
            Gndr5=""
            if (nameSix.text != "") {
                Gndr5 = Gndr6
                nameFive.text = nameSix.text
                bthOdrFive.text = bthOdrSix.text
                gthrmFive.text = gthrmSix.text
                relspFive.text = relspSix.text
                Gndr6 = Gndr7
                nameSix.text = nameSeven.text
                bthOdrSix.text = bthOdrSeven.text
                gthrmSix.text = gthrmSeven.text
                relspSix.text = relspSeven.text
                Gndr7 = Gndr8
                nameSeven.text = nameEight.text
                bthOdrSeven.text = bthOdrEight.text
                gthrmSeven.text = gthrmEight.text
                relspSeven.text = relspEight.text
                Gndr8 = Gndr9
                nameEight.text = nameNine.text
                bthOdrEight.text = bthOdrNine.text
                gthrmEight.text = gthrmNine.text
                relspEight.text = relspNine.text
                nameNine.text = nameTen.text
                bthOdrNine.text = bthOdrTen.text
                gthrmNine.text = gthrmTen.text
                relspNine.text = relspTen.text
                Gndr9 = Gndr10
                nameTen.text = nameEleven.text
                bthOdrTen.text = bthOdrEleven.text
                gthrmTen.text = gthrmEleven.text
                relspTen.text = relspEleven.text
                Gndr10 = Gndr11
                nameEleven.text = nameTwelve.text
                bthOdrEleven.text = bthOdrTwelve.text
                gthrmEleven.text = gthrmTwelve.text
                relspEleven.text = relspTwelve.text
                Gndr11 = Gndr12
                nameTwelve.text = nameThirteen.text
                bthOdrTwelve.text = bthOdrThirteen.text
                gthrmTwelve.text = gthrmThirteen.text
                relspTwelve.text = relspThirteen.text
                Gndr12 = Gndr13
                nameThirteen.text = nameFourteen.text
                bthOdrThirteen.text = bthOdrFourteen.text
                gthrmThirteen.text = gthrmFourteen.text
                relspThirteen.text = relspFourteen.text
                Gndr13 = Gndr14
                nameFourteen.text = nameFifteen.text
                bthOdrFourteen.text = bthOdrFifteen.text
                gthrmFourteen.text = gthrmFifteen.text
                relspFourteen.text = relspFifteen.text
                Gndr14 = Gndr15
                Gndr15 = ""
                nameFifteen.text = ""
                bthOdrFifteen.text = ""
                gthrmFifteen.text = ""
                relspFifteen.text = ""
                binding.editRow15.visibility = View.INVISIBLE
            }
            if (nameFive.text == "") { fifthRow.visibility = View.INVISIBLE }else{ fifthRow.visibility = View.VISIBLE }
            if (nameSix.text == "") { sixthRow.visibility = View.INVISIBLE }else{ sixthRow.visibility = View.VISIBLE }
            if (nameSeven.text == "") { seventhRow.visibility = View.INVISIBLE }else{ seventhRow.visibility = View.VISIBLE }
            if (nameEight.text == "") { eighthRow.visibility = View.INVISIBLE }else{ eighthRow.visibility = View.VISIBLE }
            if (nameNine.text == "") { ninethRow.visibility = View.INVISIBLE }else{ ninethRow.visibility = View.VISIBLE }
            if (nameTen.text == "") { tenRow.visibility = View.INVISIBLE }else{ tenRow.visibility = View.VISIBLE }
            if (nameEleven.text == "") { elevenRow.visibility = View.INVISIBLE }else{ elevenRow.visibility = View.VISIBLE }
            if (nameTwelve.text == "") { twelveRow.visibility = View.INVISIBLE }else{ twelveRow.visibility = View.VISIBLE }
            if (nameThirteen.text == "") { thirteenRow.visibility = View.INVISIBLE }else{ thirteenRow.visibility = View.VISIBLE }
            if (nameFourteen.text == "") { fourteenRow.visibility = View.INVISIBLE }else{ fourteenRow.visibility = View.VISIBLE }
            if (nameFifteen.text == "") { fifteenRow.visibility = View.INVISIBLE }else{ fifteenRow.visibility = View.VISIBLE }
        }
        delete6.setOnClickListener{
            nameSix.text = ""
            bthOdrSix.text = ""
            gthrmSix.text = ""
            relspSix.text = ""
            Gndr6=""
            if (nameSeven.text != "") {
                Gndr6 = Gndr7
                nameSix.text = nameSeven.text
                bthOdrSix.text = bthOdrSeven.text
                gthrmSix.text = gthrmSeven.text
                relspSix.text = relspSeven.text
                Gndr7 = Gndr8
                nameSeven.text = nameEight.text
                bthOdrSeven.text = bthOdrEight.text
                gthrmSeven.text = gthrmEight.text
                relspSeven.text = relspEight.text
                Gndr8 = Gndr9
                nameEight.text = nameNine.text
                bthOdrEight.text = bthOdrNine.text
                gthrmEight.text = gthrmNine.text
                relspEight.text = relspNine.text
                nameNine.text = nameTen.text
                bthOdrNine.text = bthOdrTen.text
                gthrmNine.text = gthrmTen.text
                relspNine.text = relspTen.text
                Gndr9 = Gndr10
                nameTen.text = nameEleven.text
                bthOdrTen.text = bthOdrEleven.text
                gthrmTen.text = gthrmEleven.text
                relspTen.text = relspEleven.text
                Gndr10 = Gndr11
                nameEleven.text = nameTwelve.text
                bthOdrEleven.text = bthOdrTwelve.text
                gthrmEleven.text = gthrmTwelve.text
                relspEleven.text = relspTwelve.text
                Gndr11 = Gndr12
                nameTwelve.text = nameThirteen.text
                bthOdrTwelve.text = bthOdrThirteen.text
                gthrmTwelve.text = gthrmThirteen.text
                relspTwelve.text = relspThirteen.text
                Gndr12 = Gndr13
                nameThirteen.text = nameFourteen.text
                bthOdrThirteen.text = bthOdrFourteen.text
                gthrmThirteen.text = gthrmFourteen.text
                relspThirteen.text = relspFourteen.text
                Gndr13 = Gndr14
                nameFourteen.text = nameFifteen.text
                bthOdrFourteen.text = bthOdrFifteen.text
                gthrmFourteen.text = gthrmFifteen.text
                relspFourteen.text = relspFifteen.text
                Gndr14 = Gndr15
                Gndr15 = ""
                nameFifteen.text = ""
                bthOdrFifteen.text = ""
                gthrmFifteen.text = ""
                relspFifteen.text = ""
                binding.editRow15.visibility = View.INVISIBLE
            }
            if (nameSix.text == "") { sixthRow.visibility = View.INVISIBLE }else{ sixthRow.visibility = View.VISIBLE }
            if (nameSeven.text == "") { seventhRow.visibility = View.INVISIBLE }else{ seventhRow.visibility = View.VISIBLE }
            if (nameEight.text == "") { eighthRow.visibility = View.INVISIBLE }else{ eighthRow.visibility = View.VISIBLE }
            if (nameNine.text == "") { ninethRow.visibility = View.INVISIBLE }else{ ninethRow.visibility = View.VISIBLE }
            if (nameTen.text == "") { tenRow.visibility = View.INVISIBLE }else{ tenRow.visibility = View.VISIBLE }
            if (nameEleven.text == "") { elevenRow.visibility = View.INVISIBLE }else{ elevenRow.visibility = View.VISIBLE }
            if (nameTwelve.text == "") { twelveRow.visibility = View.INVISIBLE }else{ twelveRow.visibility = View.VISIBLE }
            if (nameThirteen.text == "") { thirteenRow.visibility = View.INVISIBLE }else{ thirteenRow.visibility = View.VISIBLE }
            if (nameFourteen.text == "") { fourteenRow.visibility = View.INVISIBLE }else{ fourteenRow.visibility = View.VISIBLE }
            if (nameFifteen.text == "") { fifteenRow.visibility = View.INVISIBLE }else{ fifteenRow.visibility = View.VISIBLE }
        }
        delete7.setOnClickListener{
            nameSeven.text = ""
            bthOdrSeven.text = ""
            gthrmSeven.text = ""
            relspSeven.text = ""
            Gndr7=""
            if (nameEight.text != "") {
                Gndr7 = Gndr8
                nameSeven.text = nameEight.text
                bthOdrSeven.text = bthOdrEight.text
                gthrmSeven.text = gthrmEight.text
                relspSeven.text = relspEight.text
                Gndr8 = Gndr9
                nameEight.text = nameNine.text
                bthOdrEight.text = bthOdrNine.text
                gthrmEight.text = gthrmNine.text
                relspEight.text = relspNine.text
                nameNine.text = nameTen.text
                bthOdrNine.text = bthOdrTen.text
                gthrmNine.text = gthrmTen.text
                relspNine.text = relspTen.text
                Gndr9 = Gndr10
                nameTen.text = nameEleven.text
                bthOdrTen.text = bthOdrEleven.text
                gthrmTen.text = gthrmEleven.text
                relspTen.text = relspEleven.text
                Gndr10 = Gndr11
                nameEleven.text = nameTwelve.text
                bthOdrEleven.text = bthOdrTwelve.text
                gthrmEleven.text = gthrmTwelve.text
                relspEleven.text = relspTwelve.text
                Gndr11 = Gndr12
                nameTwelve.text = nameThirteen.text
                bthOdrTwelve.text = bthOdrThirteen.text
                gthrmTwelve.text = gthrmThirteen.text
                relspTwelve.text = relspThirteen.text
                Gndr12 = Gndr13
                nameThirteen.text = nameFourteen.text
                bthOdrThirteen.text = bthOdrFourteen.text
                gthrmThirteen.text = gthrmFourteen.text
                relspThirteen.text = relspFourteen.text
                Gndr13 = Gndr14
                nameFourteen.text = nameFifteen.text
                bthOdrFourteen.text = bthOdrFifteen.text
                gthrmFourteen.text = gthrmFifteen.text
                relspFourteen.text = relspFifteen.text
                Gndr14 = Gndr15
                Gndr15 = ""
                nameFifteen.text = ""
                bthOdrFifteen.text = ""
                gthrmFifteen.text = ""
                relspFifteen.text = ""
                binding.editRow15.visibility = View.INVISIBLE
            }
            if (nameSeven.text == "") { seventhRow.visibility = View.INVISIBLE }else{ seventhRow.visibility = View.VISIBLE }
            if (nameEight.text == "") { eighthRow.visibility = View.INVISIBLE }else{ eighthRow.visibility = View.VISIBLE }
            if (nameNine.text == "") { ninethRow.visibility = View.INVISIBLE }else{ ninethRow.visibility = View.VISIBLE }
            if (nameTen.text == "") { tenRow.visibility = View.INVISIBLE }else{ tenRow.visibility = View.VISIBLE }
            if (nameEleven.text == "") { elevenRow.visibility = View.INVISIBLE }else{ elevenRow.visibility = View.VISIBLE }
            if (nameTwelve.text == "") { twelveRow.visibility = View.INVISIBLE }else{ twelveRow.visibility = View.VISIBLE }
            if (nameThirteen.text == "") { thirteenRow.visibility = View.INVISIBLE }else{ thirteenRow.visibility = View.VISIBLE }
            if (nameFourteen.text == "") { fourteenRow.visibility = View.INVISIBLE }else{ fourteenRow.visibility = View.VISIBLE }
            if (nameFifteen.text == "") { fifteenRow.visibility = View.INVISIBLE }else{ fifteenRow.visibility = View.VISIBLE }
        }
        delete8.setOnClickListener{
            nameEight.text = ""
            bthOdrEight.text = ""
            gthrmEight.text = ""
            Gndr8=""
            relspEight.text = ""
            if (nameNine.text != "") {
                Gndr8 = Gndr9
                nameEight.text = nameNine.text
                bthOdrEight.text = bthOdrNine.text
                gthrmEight.text = gthrmNine.text
                relspEight.text = relspNine.text
                nameNine.text = nameTen.text
                bthOdrNine.text = bthOdrTen.text
                gthrmNine.text = gthrmTen.text
                relspNine.text = relspTen.text
                Gndr9 = Gndr10
                nameTen.text = nameEleven.text
                bthOdrTen.text = bthOdrEleven.text
                gthrmTen.text = gthrmEleven.text
                relspTen.text = relspEleven.text
                Gndr10 = Gndr11
                nameEleven.text = nameTwelve.text
                bthOdrEleven.text = bthOdrTwelve.text
                gthrmEleven.text = gthrmTwelve.text
                relspEleven.text = relspTwelve.text
                Gndr11 = Gndr12
                nameTwelve.text = nameThirteen.text
                bthOdrTwelve.text = bthOdrThirteen.text
                gthrmTwelve.text = gthrmThirteen.text
                relspTwelve.text = relspThirteen.text
                Gndr12 = Gndr13
                nameThirteen.text = nameFourteen.text
                bthOdrThirteen.text = bthOdrFourteen.text
                gthrmThirteen.text = gthrmFourteen.text
                relspThirteen.text = relspFourteen.text
                Gndr13 = Gndr14
                nameFourteen.text = nameFifteen.text
                bthOdrFourteen.text = bthOdrFifteen.text
                gthrmFourteen.text = gthrmFifteen.text
                relspFourteen.text = relspFifteen.text
                Gndr14 = Gndr15
                Gndr15 = ""
                nameFifteen.text = ""
                bthOdrFifteen.text = ""
                gthrmFifteen.text = ""
                relspFifteen.text = ""
                binding.editRow15.visibility = View.INVISIBLE
            }
            if (nameEight.text == "") { eighthRow.visibility = View.INVISIBLE }else{ eighthRow.visibility = View.VISIBLE }
            if (nameNine.text == "") { ninethRow.visibility = View.INVISIBLE }else{ ninethRow.visibility = View.VISIBLE }
            if (nameTen.text == "") { tenRow.visibility = View.INVISIBLE }else{ tenRow.visibility = View.VISIBLE }
            if (nameEleven.text == "") { elevenRow.visibility = View.INVISIBLE }else{ elevenRow.visibility = View.VISIBLE }
            if (nameTwelve.text == "") { twelveRow.visibility = View.INVISIBLE }else{ twelveRow.visibility = View.VISIBLE }
            if (nameThirteen.text == "") { thirteenRow.visibility = View.INVISIBLE }else{ thirteenRow.visibility = View.VISIBLE }
            if (nameFourteen.text == "") { fourteenRow.visibility = View.INVISIBLE }else{ fourteenRow.visibility = View.VISIBLE }
            if (nameFifteen.text == "") { fifteenRow.visibility = View.INVISIBLE }else{ fifteenRow.visibility = View.VISIBLE }
        }
        delete9.setOnClickListener{
            nameNine.text = ""
            bthOdrNine.text = ""
            gthrmNine.text = ""
            relspNine.text = ""
            Gndr9=""
            if (nameTen.text != ""){
                nameNine.text = nameTen.text
                bthOdrNine.text = bthOdrTen.text
                gthrmNine.text = gthrmTen.text
                relspNine.text = relspTen.text
                Gndr9 = Gndr10
                nameTen.text = nameEleven.text
                bthOdrTen.text = bthOdrEleven.text
                gthrmTen.text = gthrmEleven.text
                relspTen.text = relspEleven.text
                Gndr10 = Gndr11
                nameEleven.text = nameTwelve.text
                bthOdrEleven.text = bthOdrTwelve.text
                gthrmEleven.text = gthrmTwelve.text
                relspEleven.text = relspTwelve.text
                Gndr11 = Gndr12
                nameTwelve.text = nameThirteen.text
                bthOdrTwelve.text = bthOdrThirteen.text
                gthrmTwelve.text = gthrmThirteen.text
                relspTwelve.text = relspThirteen.text
                Gndr12 = Gndr13
                nameThirteen.text = nameFourteen.text
                bthOdrThirteen.text = bthOdrFourteen.text
                gthrmThirteen.text = gthrmFourteen.text
                relspThirteen.text = relspFourteen.text
                Gndr13 = Gndr14
                nameFourteen.text = nameFifteen.text
                bthOdrFourteen.text = bthOdrFifteen.text
                gthrmFourteen.text = gthrmFifteen.text
                relspFourteen.text = relspFifteen.text
                Gndr14 = Gndr15
                Gndr15 = ""
                nameFifteen.text = ""
                bthOdrFifteen.text = ""
                gthrmFifteen.text = ""
                relspFifteen.text = ""
                binding.editRow15.visibility = View.INVISIBLE
            }
            if (nameNine.text == "") { ninethRow.visibility = View.INVISIBLE }else{ ninethRow.visibility = View.VISIBLE }
            if (nameTen.text == "") { tenRow.visibility = View.INVISIBLE }else{ tenRow.visibility = View.VISIBLE }
            if (nameEleven.text == "") { elevenRow.visibility = View.INVISIBLE }else{ elevenRow.visibility = View.VISIBLE }
            if (nameTwelve.text == "") { twelveRow.visibility = View.INVISIBLE }else{ twelveRow.visibility = View.VISIBLE }
            if (nameThirteen.text == "") { thirteenRow.visibility = View.INVISIBLE }else{ thirteenRow.visibility = View.VISIBLE }
            if (nameFourteen.text == "") { fourteenRow.visibility = View.INVISIBLE }else{ fourteenRow.visibility = View.VISIBLE }
            if (nameFifteen.text == "") { fifteenRow.visibility = View.INVISIBLE }else{ fifteenRow.visibility = View.VISIBLE }
        }
        delete10.setOnClickListener{
            nameTen.text = ""
            bthOdrTen.text = ""
            gthrmTen.text = ""
            relspTen.text = ""
            Gndr10=""
            if (nameEleven.text != ""){
                nameTen.text = nameEleven.text
                bthOdrTen.text = bthOdrEleven.text
                gthrmTen.text = gthrmEleven.text
                relspTen.text = relspEleven.text
                Gndr10 = Gndr11
                nameEleven.text = nameTwelve.text
                bthOdrEleven.text = bthOdrTwelve.text
                gthrmEleven.text = gthrmTwelve.text
                relspEleven.text = relspTwelve.text
                Gndr11 = Gndr12
                nameTwelve.text = nameThirteen.text
                bthOdrTwelve.text = bthOdrThirteen.text
                gthrmTwelve.text = gthrmThirteen.text
                relspTwelve.text = relspThirteen.text
                Gndr12 = Gndr13
                nameThirteen.text = nameFourteen.text
                bthOdrThirteen.text = bthOdrFourteen.text
                gthrmThirteen.text = gthrmFourteen.text
                relspThirteen.text = relspFourteen.text
                Gndr13 = Gndr14
                nameFourteen.text = nameFifteen.text
                bthOdrFourteen.text = bthOdrFifteen.text
                gthrmFourteen.text = gthrmFifteen.text
                relspFourteen.text = relspFifteen.text
                Gndr14 = Gndr15
                Gndr15 = ""
                nameFifteen.text = ""
                bthOdrFifteen.text = ""
                gthrmFifteen.text = ""
                relspFifteen.text = ""
                binding.editRow15.visibility = View.INVISIBLE
            }
            if (nameTen.text == "") { tenRow.visibility = View.INVISIBLE }else{ tenRow.visibility = View.VISIBLE }
            if (nameEleven.text == "") { elevenRow.visibility = View.INVISIBLE }else{ elevenRow.visibility = View.VISIBLE }
            if (nameTwelve.text == "") { twelveRow.visibility = View.INVISIBLE }else{ twelveRow.visibility = View.VISIBLE }
            if (nameThirteen.text == "") { thirteenRow.visibility = View.INVISIBLE }else{ thirteenRow.visibility = View.VISIBLE }
            if (nameFourteen.text == "") { fourteenRow.visibility = View.INVISIBLE }else{ fourteenRow.visibility = View.VISIBLE }
            if (nameFifteen.text == "") { fifteenRow.visibility = View.INVISIBLE }else{ fifteenRow.visibility = View.VISIBLE }
        }
        delete11.setOnClickListener{
            nameEleven.text = ""
            bthOdrEleven.text = ""
            gthrmEleven.text = ""
            relspEleven.text = ""

            if (nameTwelve.text != ""){
                nameEleven.text = nameTwelve.text
                bthOdrEleven.text = bthOdrTwelve.text
                gthrmEleven.text = gthrmTwelve.text
                relspEleven.text = relspTwelve.text
                Gndr11 = Gndr12
                nameTwelve.text = nameThirteen.text
                bthOdrTwelve.text = bthOdrThirteen.text
                gthrmTwelve.text = gthrmThirteen.text
                relspTwelve.text = relspThirteen.text
                Gndr12 = Gndr13
                nameThirteen.text = nameFourteen.text
                bthOdrThirteen.text = bthOdrFourteen.text
                gthrmThirteen.text = gthrmFourteen.text
                relspThirteen.text = relspFourteen.text
                Gndr13 = Gndr14
                nameFourteen.text = nameFifteen.text
                bthOdrFourteen.text = bthOdrFifteen.text
                gthrmFourteen.text = gthrmFifteen.text
                relspFourteen.text = relspFifteen.text
                Gndr14 = Gndr15
                Gndr15 = ""
                nameFifteen.text = ""
                bthOdrFifteen.text = ""
                gthrmFifteen.text = ""
                relspFifteen.text = ""
                binding.editRow15.visibility = View.INVISIBLE
            }
            if (nameEleven.text == "") { elevenRow.visibility = View.INVISIBLE }else{ elevenRow.visibility = View.VISIBLE }
            if (nameTwelve.text == "") { twelveRow.visibility = View.INVISIBLE }else{ twelveRow.visibility = View.VISIBLE }
            if (nameThirteen.text == "") { thirteenRow.visibility = View.INVISIBLE }else{ thirteenRow.visibility = View.VISIBLE }
            if (nameFourteen.text == "") { fourteenRow.visibility = View.INVISIBLE }else{ fourteenRow.visibility = View.VISIBLE }
            if (nameFifteen.text == "") { fifteenRow.visibility = View.INVISIBLE }else{ fifteenRow.visibility = View.VISIBLE }
        }
        delete12.setOnClickListener{
            nameTwelve.text = ""
            bthOdrTwelve.text = ""
            gthrmTwelve.text = ""
            relspTwelve.text = ""
            Gndr12=""
            if (nameThirteen.text != ""){
                nameTwelve.text = nameThirteen.text
                bthOdrTwelve.text = bthOdrThirteen.text
                gthrmTwelve.text = gthrmThirteen.text
                relspTwelve.text = relspThirteen.text
                Gndr12 = Gndr13
                nameThirteen.text = nameFourteen.text
                bthOdrThirteen.text = bthOdrFourteen.text
                gthrmThirteen.text = gthrmFourteen.text
                relspThirteen.text = relspFourteen.text
                Gndr13 = Gndr14
                nameFourteen.text = nameFifteen.text
                bthOdrFourteen.text = bthOdrFifteen.text
                gthrmFourteen.text = gthrmFifteen.text
                relspFourteen.text = relspFifteen.text
                Gndr14 = Gndr15
                Gndr15 = ""
                nameFifteen.text = ""
                bthOdrFifteen.text = ""
                gthrmFifteen.text = ""
                relspFifteen.text = ""
                binding.editRow15.visibility = View.INVISIBLE
            }
            if (nameTwelve.text == "") { twelveRow.visibility = View.INVISIBLE }else{ twelveRow.visibility = View.VISIBLE }
            if (nameThirteen.text == "") { thirteenRow.visibility = View.INVISIBLE }else{ thirteenRow.visibility = View.VISIBLE }
            if (nameFourteen.text == "") { fourteenRow.visibility = View.INVISIBLE }else{ fourteenRow.visibility = View.VISIBLE }
            if (nameFifteen.text == "") { fifteenRow.visibility = View.INVISIBLE }else{ fifteenRow.visibility = View.VISIBLE }
        }
        delete13.setOnClickListener{
            nameThirteen.text = ""
            bthOdrThirteen.text = ""
            gthrmThirteen.text = ""
            relspThirteen.text = ""
            Gndr13=""
            if (nameFourteen.text != ""){
                nameThirteen.text = nameFourteen.text
                bthOdrThirteen.text = bthOdrFourteen.text
                gthrmThirteen.text = gthrmFourteen.text
                relspThirteen.text = relspFourteen.text
                Gndr13 = Gndr14
                nameFourteen.text = nameFifteen.text
                bthOdrFourteen.text = bthOdrFifteen.text
                gthrmFourteen.text = gthrmFifteen.text
                relspFourteen.text = relspFifteen.text
                Gndr14 = Gndr15
                Gndr15 = ""
                nameFifteen.text = ""
                bthOdrFifteen.text = ""
                gthrmFifteen.text = ""
                relspFifteen.text = ""
                binding.editRow15.visibility = View.INVISIBLE
            }
            if (nameThirteen.text == "") { thirteenRow.visibility = View.INVISIBLE }else{ thirteenRow.visibility = View.VISIBLE }
            if (nameFourteen.text == "") { fourteenRow.visibility = View.INVISIBLE }else{ fourteenRow.visibility = View.VISIBLE }
            if (nameFifteen.text == "") { fifteenRow.visibility = View.INVISIBLE }else{ fifteenRow.visibility = View.VISIBLE }
        }
        delete14.setOnClickListener{
            nameFourteen.text = ""
            bthOdrFourteen.text = ""
            gthrmFourteen.text = ""
            relspFourteen.text = ""
            Gndr14=""
            if (nameFifteen.text != "") {
                nameFourteen.text = nameFifteen.text
                bthOdrFourteen.text = bthOdrFifteen.text
                gthrmFourteen.text = gthrmFifteen.text
                relspFourteen.text = relspFifteen.text
                Gndr14 = Gndr15
                Gndr15 = ""
                nameFifteen.text = ""
                bthOdrFifteen.text = ""
                gthrmFifteen.text = ""
                relspFifteen.text = ""
                binding.editRow15.visibility = View.INVISIBLE
            }
            if (nameFourteen.text == "") { fourteenRow.visibility = View.INVISIBLE }else{ fourteenRow.visibility = View.VISIBLE }
            if (nameFifteen.text == "") { fifteenRow.visibility = View.INVISIBLE }else{ fifteenRow.visibility = View.VISIBLE }
        }
        delete15.setOnClickListener{
            nameFifteen.text = ""
            bthOdrFifteen.text = ""
            gthrmFifteen.text = ""
            relspFifteen.text = ""
            binding.editRow15.visibility = View.INVISIBLE
            if (nameFifteen.text == "") { fifteenRow.visibility = View.INVISIBLE }else{ fifteenRow.visibility = View.VISIBLE }
        }

        if (nameOne.text == "") { headRow.visibility = View.INVISIBLE
            firstRow.visibility = View.INVISIBLE
        }else { headRow.visibility = View.VISIBLE
            firstRow.visibility = View.VISIBLE }
        if (nameTwo.text == "") { secondRow.visibility = View.INVISIBLE }else{ secondRow.visibility = View.VISIBLE }
        if (nameThree.text == "") { thirdRow.visibility = View.INVISIBLE }else{ thirdRow.visibility = View.VISIBLE }
        if (nameFour.text == "") { fourthRow.visibility = View.INVISIBLE }else{ fourthRow.visibility = View.VISIBLE }
        if (nameFive.text == "") { fifthRow.visibility = View.INVISIBLE }else{ fifthRow.visibility = View.VISIBLE }
        if (nameSix.text == "") { sixthRow.visibility = View.INVISIBLE }else{ sixthRow.visibility = View.VISIBLE }
        if (nameSeven.text == "") { seventhRow.visibility = View.INVISIBLE }else{ seventhRow.visibility = View.VISIBLE }
        if (nameEight.text == "") { eighthRow.visibility = View.INVISIBLE }else{ eighthRow.visibility = View.VISIBLE }
        if (nameNine.text == "") { ninethRow.visibility = View.INVISIBLE }else{ ninethRow.visibility = View.VISIBLE }
        if (nameTen.text == "") { tenRow.visibility = View.INVISIBLE }else{ tenRow.visibility = View.VISIBLE }
        if (nameEleven.text == "") { elevenRow.visibility = View.INVISIBLE }else{ elevenRow.visibility = View.VISIBLE }
        if (nameTwelve.text == "") { twelveRow.visibility = View.INVISIBLE }else{ twelveRow.visibility = View.VISIBLE }
        if (nameThirteen.text == "") { thirteenRow.visibility = View.INVISIBLE }else{ thirteenRow.visibility = View.VISIBLE }
        if (nameFourteen.text == "") { fourteenRow.visibility = View.INVISIBLE }else{ fourteenRow.visibility = View.VISIBLE }
        if (nameFifteen.text == "") { fifteenRow.visibility = View.INVISIBLE }else{ fifteenRow.visibility = View.VISIBLE }

        val mySpinner1 = persGender
        val mySpinner2 = persBirthOrder
        val mySpinner3 = persRelation
        val mySpinner4 = persGothram


        val gender_array = arrayOf<String>("Select - Gender", "ஆண்", "பெண்")
        val birthOrder_array1 = arrayOf<String>("Select - Birth Order", "Elder (மூத்த)", "Younger (இளைய)", "பொருந்தாது")
        val birthOrder_array2 = arrayOf<String>("பொருந்தாது")
        val relation_array_Gents = arrayOf<String>("Select - Relationship", "பிள்ளை", "கூடபிறந்த சகோதரர்", "பெரியப்பா or சித்தப்பா", "மாமா", "பெண்வயிற்றுப் பேரப் பிள்ளை",
            "மாப்பிள்ளை", "மருமகன்", "தாயாருடன் பிறந்தவர்கள்", "அத்தான் அம்மாஞ்ஜி", "மைத்துனர்", "ஆச்சாரியன்", "மாமனார்", "அத்திம்பேர்", "அம்மாவழி சித்தப்பா", "அப்பாவழி தாத்தா",
            "அம்மாவழி தாத்தா","அப்பாவழி கொள்ளுதாத்தா", "அம்மாவழி கொள்ளுதாத்தா","அப்பாவழி எள்ளுதாத்தா", "அம்மாவழி எள்ளுதாத்தா", "மனைவியின் சகோதரன்", "சகோதரியின் கணவன்",
            "பெரியப்பா மகன்", "சித்தப்பா மகன்")
        val relation_array_Ladies = arrayOf<String>("Select - Relationship", "ஸம்ஸாரம்", "பெண் குழந்தை", "கூடபிறந்த சகோதரி", "தாயாருடன் பிறந்தவர்கள்", "அத்தை", "மருமகள்",
            "மாமியார்", "அப்பாவழி பாட்டி", "அம்மாவழி பாட்டி", "அப்பாவழி கொள்ளுபாட்டி", "அம்மாவழி கொள்ளுபாட்டி",  "அப்பாவழி எள்ளுபாட்டி", "அம்மாவழி எள்ளுபாட்டி", "பெரியம்மா(தந்தைவழி)", "சித்தி(தந்தைவழி)",
            "சகோதரனின் மனைவி", "மனைவியின் சகோதரி", "தாய்மாமனின் மனைவி", "பெரியப்பா மகனின் மனைவி", "சித்தப்பா மகனின் மனைவி")

        val gothram_array = arrayOf<String>("Select - Gothram", "பாரத்வாஜ", "ஷடமாஷண",
            "ஆத்ரேய", "வாதூல", "ஸ்ரீவத்ஸ", "கௌஶிக", "விஶ்வாமித்ர", "கௌண்டிந்ய", "ஹாரித",
            "மௌத்கல்ய", "சாண்டில்ய", "நைத்ருவகாஶ்யப", "குத்ஸ", "கண்வ", "பராசர", "அகஸ்த்ய",
            "கௌதம", "கர்கி", "பாதராயண", "காஶ்யப", "ஸங்க்ருத்ய")

        val adapter1 = ArrayAdapter(this,android.R.layout.simple_list_item_1,gender_array)
        mySpinner1.adapter = adapter1

        val adapter2A = ArrayAdapter(this,android.R.layout.simple_list_item_1,birthOrder_array1)
        mySpinner2.adapter = adapter2A
        val adapter2B = ArrayAdapter(this,android.R.layout.simple_list_item_1,birthOrder_array2)
        mySpinner2.adapter = adapter2B

        val adapter3G = ArrayAdapter(this, android.R.layout.simple_list_item_1, relation_array_Gents)
        mySpinner3.adapter = adapter3G
        val adapter3L = ArrayAdapter(this, android.R.layout.simple_list_item_1, relation_array_Ladies)
        mySpinner3.adapter = adapter3L


        val adapter4 = ArrayAdapter(this,android.R.layout.simple_list_item_1,gothram_array)
        mySpinner4.adapter = adapter4

        mySpinner1.onItemSelectedListener=object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position1: Int, id: Long) {
                personGender = gender_array[position1]
                println("personGender = $personGender")
                parent?.getItemAtPosition(position1)

                if (gender_array[position1] == "பெண்") {

                    mySpinner3.adapter = adapter3L

                    mySpinner3.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                parent: AdapterView<*>?,
                                view: View?,
                                position3L: Int,
                                id: Long
                            ) {

                                val relS = relation_array_Ladies[position3L]
                                parent?.getItemAtPosition(position3L)

                                if (relS == "ஸம்ஸாரம்") {
                                    personRelationShip = "பத்நீ"
                                }
                                if (relS == "பெண் குழந்தை") {
                                    personRelationShip = "துஹிதா"
                                }
                                if (relS == "கூடபிறந்த சகோதரி") {
                                    personRelationShip = "பகிநீ"
                                }
                                if (relS == "தாயாருடன் பிறந்தவர்கள்") {
                                    personRelationShip = "மாத்ருஷ்வஸா"
                                }
                                if (relS == "அத்தை") {
                                    personRelationShip = "பித்ருஷ்வஸா"
                                }
                                if (relS == "மருமகள்") {
                                    personRelationShip = "ஸ்னுஷா"
                                }
                                if (relS == "அப்பாவழி பாட்டி") {
                                    personRelationShip = "பிதாமஹி"
                                }
                                if (relS == "அம்மாவழி பாட்டி") {
                                    personRelationShip = "மாதாமஹி"
                                }
                                if (relS == "அப்பாவழி கொள்ளுபாட்டி") {
                                    personRelationShip = "ப்ரபிதாமஹி"
                                }
                                if (relS == "அம்மாவழி கொள்ளுபாட்டி") {
                                    personRelationShip = "ப்ரமாதாமஹி"
                                }
                                if (relS == "அப்பாவழி எள்ளுபாட்டி") {
                                    personRelationShip = "வ்ருத்தப்ரபிதாமஹி"
                                }
                                if (relS == "அம்மாவழி எள்ளுபாட்டி") {
                                    personRelationShip = "வ்ருத்தப்ரமாதாமஹி"
                                }
                                if (relS == "பெரியம்மா(தந்தைவழி)") {
                                    personRelationShip = "ஜேஷ்ட ப்ராத்ருபத்னீ"
                                }
                                if (relS == "சித்தி(தந்தைவழி)") {
                                    personRelationShip = "கனிஷ்ட ப்ராத்ருபத்னீ"
                                }
                                if (relS == "சகோதரனின் மனைவி") {
                                    personRelationShip = "ப்ராத்ருஜாயா"
                                }
                                if (relS == "மனைவியின் சகோதரி") {
                                    personRelationShip = "ஸ்யாலி"
                                }
                                if (relS == "தாய்மாமனின் மனைவி") {
                                    personRelationShip = "மாதுலாநி"
                                }
                                if (relS == "பெரியப்பா மகனின் மனைவி") {
                                    personRelationShip = "குளீன ஜேஷ்ட ப்ராத்ருபத்னீ"
                                }
                                if (relS == "சித்தப்பா மகனின் மனைவி") {
                                    personRelationShip = "குளீன கனிஷ்ட ப்ராத்ருபத்னீ"
                                }
                            }
                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }

                        }

                    mySpinner2.adapter = adapter2B
                    mySpinner2.isEnabled = false
                    mySpinner2.isClickable = false
                    mySpinner2.isActivated = false
                    mySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position2: Int, id: Long) {
                                val pBOrder = birthOrder_array2[position2]
                                personBirthOrder = birthOrder_array1[3]
                                println("pBOrder = $pBOrder")
                                println("personBirthOrder = $personBirthOrder")
                                //   parent?.getItemAtPosition(position)
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }

                        }
                } else {

                    mySpinner3.adapter = adapter3G

                    mySpinner3.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position3G: Int, id: Long) {
                                // personRelationShip = relation_array[position3]

                                val pRelSp = relation_array_Gents[position3G]
                                parent?.getItemAtPosition(position3G)

                                if (pRelSp == "பிள்ளை") {
                                    personRelationShip = "ஸூத:"
                                }
                                if (pRelSp == "கூடபிறந்த சகோதரர்") {
                                    personRelationShip = "ப்ராதா"
                                }
                                if (pRelSp == "பெரிய்பா or சித்தப்பா") {
                                    personRelationShip = "பித்ருவ்ய:"
                                }
                                if (pRelSp == "மாமா") {
                                    personBirthOrder = "-"
                                    personRelationShip = "மாதுல:"
                                }
                                if (pRelSp == "பெண்வயிற்றுப் பேரப் பிள்ளை") {
                                    personRelationShip = "தௌஹித்ர:"
                                }
                                if (pRelSp == "மாப்பிள்ளை") {
                                    personRelationShip = "ஜாமாதா:"
                                }
                                if (pRelSp == "மருமகன்") {
                                    personRelationShip = "பாகிநேயக:"
                                }
                                if (pRelSp == "தாயாருடன் பிறந்தவர்கள்") {
                                    personRelationShip = "மாத்ருஷ்வஸா"
                                }
                                if (pRelSp == "அத்தான் அம்மாஞ்ஜி") {
                                    personRelationShip = "பாவுக:"
                                }
                                if (pRelSp == "மைத்துனர்") {
                                    personRelationShip = "ச்சயாலக:"
                                }
                                if (pRelSp == "ஆச்சாரியன்") {
                                    personBirthOrder = "-"
                                    personRelationShip = "குரு"
                                }
                                if (pRelSp == "மாமனார்") {
                                    personBirthOrder = "-"
                                    personRelationShip = "ச்வசுர:"
                                }
                                if (pRelSp == "அத்திம்பேர்") {
                                    personRelationShip = "பாவுக:"
                                }
                                if (pRelSp == "அம்மாவழி சித்தப்பா") {
                                    personRelationShip = "மாத்ருபகினிபதி"
                                }
                                if (pRelSp == "அப்பாவழி தாத்தா") {
                                    personRelationShip = "பிதாமஹ:"
                                }
                                if (pRelSp == "அம்மாவழி தாத்தா") {
                                    personRelationShip = "மாதாமஹ:"
                                }
                                if (pRelSp == "அப்பாவழி கொள்ளுதாத்தா") {
                                    personRelationShip = "ப்ரபிதாமஹ:"
                                }
                                if (pRelSp == "அம்மாவழி கொள்ளுதாத்தா") {
                                    personRelationShip = "ப்ரமாதாமஹ:"
                                }
                                if (pRelSp == "அப்பாவழி எள்ளுதாத்தா") {
                                    personRelationShip = "வ்ருத்தப்ரபிதாமஹ:"
                                }
                                if (pRelSp == "அம்மாவழி எள்ளுதாத்தா") {
                                    personRelationShip = "வ்ருத்தப்ரமாதாமஹ:"
                                }
                                if (pRelSp == "மனைவியின் சகோதரன்") {
                                    personRelationShip = "ஶ்யால:"
                                }
                                if (pRelSp == "சகோதரியின் கணவன்") {
                                    personRelationShip = "ஆவ்ருத்த:"
                                }
                                if (pRelSp == "பெரியப்பா மகன்") {
                                    personRelationShip = "குளீன ஜேஷ்ட ப்ராதா"
                                }
                                if (pRelSp == "சித்தப்பா மகன்") {
                                    personRelationShip = "குளீன கனிஷ்ட ப்ராதா"
                                }
                            }

                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }

                        }
                    mySpinner2.adapter = adapter2A
                    mySpinner2.isEnabled = true
                    mySpinner2.isClickable = true
                    mySpinner2.isActivated = true
                    mySpinner2.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position2: Int, id: Long) {
                                if (personRelationShip == "மாதுல:" || personRelationShip == "மாமா" || personRelationShip == "ச்வசுர:" || personRelationShip == "மாமனார்" || personRelationShip == "குரு" || personRelationShip == "ஆச்சாரியன்"){
                                    personBirthOrder = " "
                                } else {
                                    personBirthOrder = birthOrder_array1[position2]
                                    println("personBirthOrder = $personBirthOrder")
                                    //   parent?.getItemAtPosition(position)
                                }
                            }
                            override fun onNothingSelected(parent: AdapterView<*>?) {
                                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                            }
                        }
                }
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }
                println("personRelationShip = $personRelationShip")


        mySpinner4.onItemSelectedListener=object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position4: Int, id: Long) {
                personGothram = gothram_array[position4]
                println("personGothram = $personGothram")
                parent?.getItemAtPosition(position4)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }

        emptyData.setOnClickListener{
            binding.headRow.visibility = View.INVISIBLE
            binding.firstRow.visibility = View.INVISIBLE
            binding.secondRow.visibility = View.INVISIBLE
            binding.thirdRow.visibility = View.INVISIBLE
            binding.fourthRow.visibility = View.INVISIBLE
            binding.fifthRow.visibility = View.INVISIBLE
            binding.sixthRow.visibility = View.INVISIBLE
            binding.seventhRow.visibility = View.INVISIBLE
            binding.eighthRow.visibility = View.INVISIBLE
            binding.ninethRow.visibility = View.INVISIBLE
            binding.tenRow.visibility = View.INVISIBLE
            binding.elevenRow.visibility = View.INVISIBLE
            binding.twelveRow.visibility = View.INVISIBLE
            binding.thirteenRow.visibility = View.INVISIBLE
            binding.fourteenRow.visibility = View.INVISIBLE
            binding.fifteenRow.visibility = View.INVISIBLE
            binding.Name1.text = ""
            binding.Name2.text = ""
            binding.Name3.text = ""
            binding.Name4.text = ""
            binding.Name5.text = ""
            binding.Name6.text = ""
            binding.Name7.text = ""
            binding.Name8.text = ""
            binding.Name9.text = ""
            binding.Name10.text = ""
            binding.Name11.text = ""
            binding.Name12.text = ""
            binding.Name13.text = ""
            binding.Name14.text = ""
            binding.Name15.text = ""

            binding.BirthOrder1.text = ""
            binding.BirthOrder2.text = ""
            binding.BirthOrder3.text = ""
            binding.BirthOrder4.text = ""
            binding.BirthOrder5.text = ""
            binding.BirthOrder6.text = ""
            binding.BirthOrder7.text = ""
            binding.BirthOrder8.text = ""
            binding.BirthOrder9.text = ""
            binding.BirthOrder10.text = ""
            binding.BirthOrder11.text = ""
            binding.BirthOrder12.text = ""
            binding.BirthOrder13.text = ""
            binding.BirthOrder14.text = ""
            binding.BirthOrder15.text = ""

            binding.relationship1.text = ""
            binding.relationship2.text = ""
            binding.relationship3.text = ""
            binding.relationship4.text = ""
            binding.relationship5.text = ""
            binding.relationship6.text = ""
            binding.relationship7.text = ""
            binding.relationship8.text = ""
            binding.relationship9.text = ""
            binding.relationship10.text = ""
            binding.relationship11.text = ""
            binding.relationship12.text = ""
            binding.relationship13.text = ""
            binding.relationship14.text = ""
            binding.relationship15.text = ""

            binding.gotram1.text = ""
            binding.gotram2.text = ""
            binding.gotram3.text = ""
            binding.gotram4.text = ""
            binding.gotram5.text = ""
            binding.gotram6.text = ""
            binding.gotram7.text = ""
            binding.gotram8.text = ""
            binding.gotram9.text = ""
            binding.gotram10.text = ""
            binding.gotram11.text = ""
            binding.gotram12.text = ""
            binding.gotram13.text = ""
            binding.gotram14.text = ""
            binding.gotram15.text = ""

            Gndr1 = ""
            Gndr2 = ""
            Gndr3 = ""
            Gndr4 = ""
            Gndr5 = ""
            Gndr6 = ""
            Gndr7 = ""
            Gndr8 = ""
            Gndr9 = ""
            Gndr10 = ""
            Gndr11 = ""
            Gndr12 = ""
            Gndr13 = ""
            Gndr14 = ""
            Gndr15 = ""
        }

        mahTpnmBtn.setOnClickListener{
            val intent: Intent = Intent(this, MahalayaTpnmActivity :: class.java)
            intent.putExtra("N1", nameOne.text.toString())
            intent.putExtra("N2", nameTwo.text.toString())
            intent.putExtra("N3", nameThree.text.toString())
            intent.putExtra("N4", nameFour.text.toString())
            intent.putExtra("N5", nameFive.text.toString())
            intent.putExtra("N6", nameSix.text.toString())
            intent.putExtra("N7", nameSeven.text.toString())
            intent.putExtra("N8", nameEight.text.toString())
            intent.putExtra("N9", nameNine.text.toString())
            intent.putExtra("N10", nameTen.text.toString())
            intent.putExtra("N11", nameEleven.text.toString())
            intent.putExtra("N12", nameTwelve.text.toString())
            intent.putExtra("N13", nameThirteen.text.toString())
            intent.putExtra("N14", nameFourteen.text.toString())
            intent.putExtra("N15", nameFifteen.text.toString())

            intent.putExtra("B1", bthOdrOne.text.toString())
            intent.putExtra("B2", bthOdrTwo.text.toString())
            intent.putExtra("B3", bthOdrThree.text.toString())
            intent.putExtra("B4", bthOdrFour.text.toString())
            intent.putExtra("B5", bthOdrFive.text.toString())
            intent.putExtra("B6", bthOdrSix.text.toString())
            intent.putExtra("B7", bthOdrSeven.text.toString())
            intent.putExtra("B8", bthOdrEight.text.toString())
            intent.putExtra("B9", bthOdrNine.text.toString())
            intent.putExtra("B10", bthOdrTen.text.toString())
            intent.putExtra("B11", bthOdrEleven.text.toString())
            intent.putExtra("B12", bthOdrTwelve.text.toString())
            intent.putExtra("B13", bthOdrThirteen.text.toString())
            intent.putExtra("B14", bthOdrFourteen.text.toString())
            intent.putExtra("B15", bthOdrFifteen.text.toString())

            intent.putExtra("G1", gthrmOne.text.toString())
            intent.putExtra("G2", gthrmTwo.text.toString())
            intent.putExtra("G3", gthrmThree.text.toString())
            intent.putExtra("G4", gthrmFour.text.toString())
            intent.putExtra("G5", gthrmFive.text.toString())
            intent.putExtra("G6", gthrmSix.text.toString())
            intent.putExtra("G7", gthrmSeven.text.toString())
            intent.putExtra("G8", gthrmEight.text.toString())
            intent.putExtra("G9", gthrmNine.text.toString())
            intent.putExtra("G10", gthrmTen.text.toString())
            intent.putExtra("G11", gthrmEleven.text.toString())
            intent.putExtra("G12", gthrmTwelve.text.toString())
            intent.putExtra("G13", gthrmThirteen.text.toString())
            intent.putExtra("G14", gthrmFourteen.text.toString())
            intent.putExtra("G15", gthrmFifteen.text.toString())

            intent.putExtra("R1", relspOne.text.toString())
            intent.putExtra("R2", relspTwo.text.toString())
            intent.putExtra("R3", relspThree.text.toString())
            intent.putExtra("R4", relspFour.text.toString())
            intent.putExtra("R5", relspFive.text.toString())
            intent.putExtra("R6", relspSix.text.toString())
            intent.putExtra("R7", relspSeven.text.toString())
            intent.putExtra("R8", relspEight.text.toString())
            intent.putExtra("R9", relspNine.text.toString())
            intent.putExtra("R10", relspTen.text.toString())
            intent.putExtra("R11", relspEleven.text.toString())
            intent.putExtra("R12", relspTwelve.text.toString())
            intent.putExtra("R13", relspThirteen.text.toString())
            intent.putExtra("R14", relspFourteen.text.toString())
            intent.putExtra("R15", relspFifteen.text.toString())

            intent.putExtra("gdr1", Gndr1)
            intent.putExtra("gdr2", Gndr2)
            intent.putExtra("gdr3", Gndr3)
            intent.putExtra("gdr4", Gndr4)
            intent.putExtra("gdr5", Gndr5)
            intent.putExtra("gdr6", Gndr6)
            intent.putExtra("gdr7", Gndr7)
            intent.putExtra("gdr8", Gndr8)
            intent.putExtra("gdr9", Gndr9)
            intent.putExtra("gdr10", Gndr10)
            intent.putExtra("gdr11", Gndr11)
            intent.putExtra("gdr12", Gndr12)
            intent.putExtra("gdr13", Gndr13)
            intent.putExtra("gdr14", Gndr14)
            intent.putExtra("gdr15", Gndr15)

            intent.putExtra("Naal",dateTdy)
            intent.putExtra("Idam",place)
            intent.putExtra("TamilYear", Varusham)
            intent.putExtra("Ayanamm",ayyanamm)
            intent.putExtra("KAALAM",kalam)
            intent.putExtra("RASEEE",rasee)
            intent.putExtra("BAKKSHAMM",baksham)
            intent.putExtra("TODAYSTHITHI",todThithi)
            intent.putExtra("KIZHAMAAII",kizhamai)
            intent.putExtra("NAKSM",nachathirm)
            intent.putExtra("YGM",yog)
            intent.putExtra("KRNM",kar)
            intent.putExtra("Peyar", yrNamee)
            intent.putExtra("Appa", yrFNamee)
            intent.putExtra("Thatha", yrGFNamee)
            intent.putExtra("Kollu", yrGGFNamee)
            intent.putExtra("Yellu", yrGGGFNamee)
            intent.putExtra("AmmaAppa", MFNamee)
            intent.putExtra("AmmaThatha", MGFNamee)
            intent.putExtra("AmmaKolluThatha", MGGFNamee)

            intent.putExtra("ammaName", ammaNamee)
            intent.putExtra("appaAmmaName", appaAmmaNamee)
            intent.putExtra("appaPattiName", appaPattiNamee)
            intent.putExtra("appaKolluPattiName", appaKolluPattiNamee)
            intent.putExtra("ammaAmmaName", ammaAmmaNamee)
            intent.putExtra("ammaPattiName", ammaPattiNamee)
            intent.putExtra("ammaKolluPattiName", ammaKolluPattiNamee)

            startActivity(intent)
            savedData()
        }


        savingData.setOnClickListener {
            if (nameOne.text!!.isEmpty()) {
                headRow.visibility = View.VISIBLE
                firstRow.visibility = View.VISIBLE

                nameOne.text = NameEdit.text.toString()
                bthOdrOne.text = personBirthOrder
                gthrmOne.text = personGothram
                relspOne.text = personRelationShip
                Gndr1 = personGender
            } else if (nameTwo.text.isEmpty()) {
                secondRow.visibility = View.VISIBLE
                nameTwo.text = NameEdit.text.toString()
                bthOdrTwo.text = personBirthOrder
                gthrmTwo.text = personGothram
                relspTwo.text = personRelationShip
                Gndr2 = personGender
            } else if (nameThree.text.isEmpty()) {
                thirdRow.visibility = View.VISIBLE
                nameThree.text = NameEdit.text.toString()
                bthOdrThree.text = personBirthOrder
                gthrmThree.text = personGothram
                relspThree.text = personRelationShip
                Gndr3 = personGender
            }else if (nameFour.text.isEmpty()) {
                fourthRow.visibility = View.VISIBLE
                nameFour.text = NameEdit.text.toString()
                bthOdrFour.text = personBirthOrder
                gthrmFour.text = personGothram
                relspFour.text = personRelationShip
                Gndr4 = personGender
            }else if (nameFive.text.isEmpty()) {
                fifthRow.visibility = View.VISIBLE
                nameFive.text = NameEdit.text.toString()
                bthOdrFive.text = personBirthOrder
                gthrmFive.text = personGothram
                relspFive.text = personRelationShip
                Gndr5 = personGender
            }else if (nameSix.text.isEmpty()) {
                sixthRow.visibility = View.VISIBLE
                nameSix.text = NameEdit.text.toString()
                bthOdrSix.text = personBirthOrder
                gthrmSix.text = personGothram
                relspSix.text = personRelationShip
                Gndr6 = personGender
            }else if (nameSeven.text.isEmpty()) {
                seventhRow.visibility = View.VISIBLE
                nameSeven.text = NameEdit.text.toString()
                bthOdrSeven.text = personBirthOrder
                gthrmSeven.text = personGothram
                relspSeven.text = personRelationShip
                Gndr7 = personGender
            }else if (nameEight.text.isEmpty()) {
                eighthRow.visibility = View.VISIBLE
                nameEight.text = NameEdit.text.toString()
                bthOdrEight.text = personBirthOrder
                gthrmEight.text = personGothram
                relspEight.text = personRelationShip
                Gndr8 = personGender
            }else if (nameNine.text.isEmpty()) {
                ninethRow.visibility = View.VISIBLE
                nameNine.text = NameEdit.text.toString()
                bthOdrNine.text = personBirthOrder
                gthrmNine.text = personGothram
                relspNine.text = personRelationShip
                Gndr9 = personGender
            }else if (nameTen.text.isEmpty()) {
                tenRow.visibility = View.VISIBLE
                nameTen.text = NameEdit.text.toString()
                bthOdrTen.text = personBirthOrder
                gthrmTen.text = personGothram
                relspTen.text = personRelationShip
                Gndr10 = personGender
            }else if (nameEleven.text.isEmpty()) {
                elevenRow.visibility = View.VISIBLE
                nameEleven.text = NameEdit.text.toString()
                bthOdrEleven.text = personBirthOrder
                gthrmEleven.text = personGothram
                relspEleven.text = personRelationShip
                Gndr11 = personGender
            }else if (nameTwelve.text.isEmpty()) {
                twelveRow.visibility = View.VISIBLE
                nameTwelve.text = NameEdit.text.toString()
                bthOdrTwelve.text = personBirthOrder
                gthrmTwelve.text = personGothram
                relspTwelve.text = personRelationShip
                Gndr12 = personGender
            }else if (nameThirteen.text.isEmpty()) {
                thirteenRow.visibility = View.VISIBLE
                nameThirteen.text = NameEdit.text.toString()
                bthOdrThirteen.text = personBirthOrder
                gthrmThirteen.text = personGothram
                relspThirteen.text = personRelationShip
                Gndr13 = personGender
            }else if (nameFourteen.text.isEmpty()) {
                fourteenRow.visibility = View.VISIBLE
                nameFourteen.text = NameEdit.text.toString()
                bthOdrFourteen.text = personBirthOrder
                gthrmFourteen.text = personGothram
                relspFourteen.text = personRelationShip
                Gndr14 = personGender
            }else if (nameFifteen.text.isEmpty()) {
                fifteenRow.visibility = View.VISIBLE
                nameFifteen.text = NameEdit.text.toString()
                bthOdrFifteen.text = personBirthOrder
                gthrmFifteen.text = personGothram
                relspFifteen.text = personRelationShip
                Gndr15 = personGender
                                savedData()
            }
        }
    }
    fun setDefaults(key: String, value: String, context: Context) {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = preferences.edit()
        editor.putString(key, value)
        editor.apply()
    }
    fun getDefaults(key: String, context: Context): Editable {
        val preferences = PreferenceManager.getDefaultSharedPreferences(context)
        return (preferences.getString(key, null)) as Editable
    }

    fun savedData() {
        val sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.putString("N1", binding.Name1.text.toString())
        editor.putString("N2", binding.Name2.text.toString())
        editor.putString("N3", binding.Name3.text.toString())
        editor.putString("N4", binding.Name4.text.toString())
        editor.putString("N5", binding.Name5.text.toString())
        editor.putString("N6", binding.Name6.text.toString())
        editor.putString("N7", binding.Name7.text.toString())
        editor.putString("N8", binding.Name8.text.toString())
        editor.putString("N9", binding.Name9.text.toString())
        editor.putString("N10", binding.Name10.text.toString())
        editor.putString("N11", binding.Name11.text.toString())
        editor.putString("N12", binding.Name12.text.toString())
        editor.putString("N13", binding.Name13.text.toString())
        editor.putString("N14", binding.Name14.text.toString())
        editor.putString("N15", binding.Name15.text.toString())

        editor.putString("B1", binding.BirthOrder1.text.toString())
        editor.putString("B2", binding.BirthOrder2.text.toString())
        editor.putString("B3", binding.BirthOrder3.text.toString())
        editor.putString("B4", binding.BirthOrder4.text.toString())
        editor.putString("B5", binding.BirthOrder5.text.toString())
        editor.putString("B6", binding.BirthOrder6.text.toString())
        editor.putString("B7", binding.BirthOrder7.text.toString())
        editor.putString("B8", binding.BirthOrder8.text.toString())
        editor.putString("B9", binding.BirthOrder9.text.toString())
        editor.putString("B10", binding.BirthOrder10.text.toString())
        editor.putString("B11", binding.BirthOrder11.text.toString())
        editor.putString("B12", binding.BirthOrder12.text.toString())
        editor.putString("B13", binding.BirthOrder13.text.toString())
        editor.putString("B14", binding.BirthOrder14.text.toString())
        editor.putString("B15", binding.BirthOrder15.text.toString())

        editor.putString("G1", binding.gotram1.text.toString())
        editor.putString("G2", binding.gotram2.text.toString())
        editor.putString("G3", binding.gotram3.text.toString())
        editor.putString("G4", binding.gotram4.text.toString())
        editor.putString("G5", binding.gotram5.text.toString())
        editor.putString("G6", binding.gotram6.text.toString())
        editor.putString("G7", binding.gotram7.text.toString())
        editor.putString("G8", binding.gotram8.text.toString())
        editor.putString("G9", binding.gotram9.text.toString())
        editor.putString("G10", binding.gotram10.text.toString())
        editor.putString("G11", binding.gotram11.text.toString())
        editor.putString("G12", binding.gotram12.text.toString())
        editor.putString("G13", binding.gotram13.text.toString())
        editor.putString("G14", binding.gotram14.text.toString())
        editor.putString("G15", binding.gotram15.text.toString())

        editor.putString("R1", binding.relationship1.text.toString())
        editor.putString("R2", binding.relationship2.text.toString())
        editor.putString("R3", binding.relationship3.text.toString())
        editor.putString("R4", binding.relationship4.text.toString())
        editor.putString("R5", binding.relationship5.text.toString())
        editor.putString("R6", binding.relationship6.text.toString())
        editor.putString("R7", binding.relationship7.text.toString())
        editor.putString("R8", binding.relationship8.text.toString())
        editor.putString("R9", binding.relationship9.text.toString())
        editor.putString("R10", binding.relationship10.text.toString())
        editor.putString("R11", binding.relationship11.text.toString())
        editor.putString("R12", binding.relationship12.text.toString())
        editor.putString("R13", binding.relationship13.text.toString())
        editor.putString("R14", binding.relationship14.text.toString())
        editor.putString("R15", binding.relationship15.text.toString())

        editor.putString("gdr1", Gndr1)
        editor.putString("gdr2", Gndr2)
        editor.putString("gdr3", Gndr3)
        editor.putString("gdr4", Gndr4)
        editor.putString("gdr5", Gndr5)
        editor.putString("gdr6", Gndr6)
        editor.putString("gdr7", Gndr7)
        editor.putString("gdr8", Gndr8)
        editor.putString("gdr9", Gndr9)
        editor.putString("gdr10", Gndr10)
        editor.putString("gdr11", Gndr11)
        editor.putString("gdr12", Gndr12)
        editor.putString("gdr13", Gndr13)
        editor.putString("gdr14", Gndr14)
        editor.putString("gdr15", Gndr15)

        editor.apply()
    }
    fun loadData() {
        val sharedPreferences = getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE)
        name1 = sharedPreferences.getString("N1", "")!!
        name2 = sharedPreferences.getString("N2", "")!!
        name3 = sharedPreferences.getString("N3", "")!!
        name4 = sharedPreferences.getString("N4", "")!!
        name5 = sharedPreferences.getString("N5", "")!!
        name6 = sharedPreferences.getString("N6", "")!!
        name7 = sharedPreferences.getString("N7", "")!!
        name8 = sharedPreferences.getString("N8", "")!!
        name9 = sharedPreferences.getString("N9", "")!!
        name10 = sharedPreferences.getString("N10", "")!!
        name11 = sharedPreferences.getString("N11", "")!!
        name12 = sharedPreferences.getString("N12", "")!!
        name13 = sharedPreferences.getString("N13", "")!!
        name14 = sharedPreferences.getString("N14", "")!!
        name15 = sharedPreferences.getString("N15", "")!!

        BrOr1 = sharedPreferences.getString("B1", "")!!
        BrOr2 = sharedPreferences.getString("B2", "")!!
        BrOr3 = sharedPreferences.getString("B3", "")!!
        BrOr4 = sharedPreferences.getString("B4", "")!!
        BrOr5 = sharedPreferences.getString("B5", "")!!
        BrOr6 = sharedPreferences.getString("B6", "")!!
        BrOr7 = sharedPreferences.getString("B7", "")!!
        BrOr8 = sharedPreferences.getString("B8", "")!!
        BrOr9 = sharedPreferences.getString("B9", "")!!
        BrOr10 = sharedPreferences.getString("B10", "")!!
        BrOr11 = sharedPreferences.getString("B11", "")!!
        BrOr12 = sharedPreferences.getString("B12", "")!!
        BrOr13 = sharedPreferences.getString("B13", "")!!
        BrOr14 = sharedPreferences.getString("B14", "")!!
        BrOr15 = sharedPreferences.getString("B15", "")!!

        Goth1 = sharedPreferences.getString("G1", "")!!
        Goth2 = sharedPreferences.getString("G2", "")!!
        Goth3 = sharedPreferences.getString("G3", "")!!
        Goth4 = sharedPreferences.getString("G4", "")!!
        Goth5 = sharedPreferences.getString("G5", "")!!
        Goth6 = sharedPreferences.getString("G6", "")!!
        Goth7 = sharedPreferences.getString("G7", "")!!
        Goth8 = sharedPreferences.getString("G8", "")!!
        Goth9 = sharedPreferences.getString("G9", "")!!
        Goth10 = sharedPreferences.getString("G10", "")!!
        Goth11 = sharedPreferences.getString("G11", "")!!
        Goth12 = sharedPreferences.getString("G12", "")!!
        Goth13 = sharedPreferences.getString("G13", "")!!
        Goth14 = sharedPreferences.getString("G14", "")!!
        Goth15 = sharedPreferences.getString("G15", "")!!

        RlShp1 = sharedPreferences.getString("R1", "")!!
        RlShp2 = sharedPreferences.getString("R2", "")!!
        RlShp3 = sharedPreferences.getString("R3", "")!!
        RlShp4 = sharedPreferences.getString("R4", "")!!
        RlShp5 = sharedPreferences.getString("R5", "")!!
        RlShp6 = sharedPreferences.getString("R6", "")!!
        RlShp7 = sharedPreferences.getString("R7", "")!!
        RlShp8 = sharedPreferences.getString("R8", "")!!
        RlShp9 = sharedPreferences.getString("R9", "")!!
        RlShp10 = sharedPreferences.getString("R10", "")!!
        RlShp11 = sharedPreferences.getString("R11", "")!!
        RlShp12 = sharedPreferences.getString("R12", "")!!
        RlShp13 = sharedPreferences.getString("R13", "")!!
        RlShp14 = sharedPreferences.getString("R14", "")!!
        RlShp15 = sharedPreferences.getString("R15", "")!!

        Gndr1 = sharedPreferences.getString("gdr1", "")!!
        Gndr2 = sharedPreferences.getString("gdr2", "")!!
        Gndr3 = sharedPreferences.getString("gdr3", "")!!
        Gndr4 = sharedPreferences.getString("gdr4", "")!!
        Gndr5 = sharedPreferences.getString("gdr5", "")!!
        Gndr6 = sharedPreferences.getString("gdr6", "")!!
        Gndr7 = sharedPreferences.getString("gdr7", "")!!
        Gndr8 = sharedPreferences.getString("gdr8", "")!!
        Gndr9 = sharedPreferences.getString("gdr9", "")!!
        Gndr10 = sharedPreferences.getString("gdr10", "")!!
        Gndr11 = sharedPreferences.getString("gdr11", "")!!
        Gndr12 = sharedPreferences.getString("gdr12", "")!!
        Gndr13 = sharedPreferences.getString("gdr13", "")!!
        Gndr14 = sharedPreferences.getString("gdr14", "")!!
        Gndr15 = sharedPreferences.getString("gdr15", "")!!
    }
    fun updateViews() {
        binding.Name1.text = name1
        binding.Name2.text = name2
        binding.Name3.text = name3
        binding.Name4.text = name4
        binding.Name5.text = name5
        binding.Name6.text = name6
        binding.Name7.text = name7
        binding.Name8.text = name8
        binding.Name9.text = name9
        binding.Name10.text = name10
        binding.Name11.text = name11
        binding.Name12.text = name12
        binding.Name13.text = name13
        binding.Name14.text = name14
        binding.Name15.text = name15

        binding.gotram1.text = Goth1
        binding.gotram2.text = Goth2
        binding.gotram3.text = Goth3
        binding.gotram4.text = Goth4
        binding.gotram5.text = Goth5
        binding.gotram6.text = Goth6
        binding.gotram7.text = Goth7
        binding.gotram8.text = Goth8
        binding.gotram9.text = Goth9
        binding.gotram10.text = Goth10
        binding.gotram11.text = Goth11
        binding.gotram12.text = Goth12
        binding.gotram13.text = Goth13
        binding.gotram14.text = Goth14
        binding.gotram15.text = Goth15

        binding.BirthOrder1.text = BrOr1
        binding.BirthOrder2.text = BrOr2
        binding.BirthOrder3.text = BrOr3
        binding.BirthOrder4.text = BrOr4
        binding.BirthOrder5.text = BrOr5
        binding.BirthOrder6.text = BrOr6
        binding.BirthOrder7.text = BrOr7
        binding.BirthOrder8.text = BrOr8
        binding.BirthOrder9.text = BrOr9
        binding.BirthOrder10.text = BrOr10
        binding.BirthOrder11.text = BrOr11
        binding.BirthOrder12.text = BrOr12
        binding.BirthOrder13.text = BrOr13
        binding.BirthOrder14.text = BrOr14
        binding.BirthOrder15.text = BrOr15

        binding.relationship1.text = RlShp1
        binding.relationship2.text = RlShp2
        binding.relationship3.text = RlShp3
        binding.relationship4.text = RlShp4
        binding.relationship5.text = RlShp5
        binding.relationship6.text = RlShp6
        binding.relationship7.text = RlShp7
        binding.relationship8.text = RlShp8
        binding.relationship9.text = RlShp9
        binding.relationship10.text = RlShp10
        binding.relationship11.text = RlShp11
        binding.relationship12.text = RlShp12
        binding.relationship13.text = RlShp13
        binding.relationship14.text = RlShp14
        binding.relationship15.text = RlShp15

    }

        // Variable to track selected row for reordering
    private var selectedRowForSwap: Int = -1

    // Function to swap two rows
    fun swapRows(fromRow: Int, toRow: Int) {
        if (fromRow == toRow || fromRow < 1 || toRow < 1 || fromRow > 15 || toRow > 15) return
        
        // Get data from both rows
        val tempName = getRowName(fromRow)
        val tempBirthOrder = getRowBirthOrder(fromRow)
        val tempGothram = getRowGothram(fromRow)
        val tempRelation = getRowRelation(fromRow)
        val tempGender = getRowGender(fromRow)
        
        // Set fromRow data from toRow
        setRowData(fromRow, getRowName(toRow), getRowBirthOrder(toRow), getRowGothram(toRow), getRowRelation(toRow), getRowGender(toRow))
        
        // Set toRow data from temp
        setRowData(toRow, tempName, tempBirthOrder, tempGothram, tempRelation, tempGender)
        
        // Save and update visibility
        savedData()
        updateRowVisibility()
    }

    // Helper functions to get row data by index
    fun getRowName(row: Int): String {
        return when(row) {
            1 -> binding.Name1.text.toString()
            2 -> binding.Name2.text.toString()
            3 -> binding.Name3.text.toString()
            4 -> binding.Name4.text.toString()
            5 -> binding.Name5.text.toString()
            6 -> binding.Name6.text.toString()
            7 -> binding.Name7.text.toString()
            8 -> binding.Name8.text.toString()
            9 -> binding.Name9.text.toString()
            10 -> binding.Name10.text.toString()
            11 -> binding.Name11.text.toString()
            12 -> binding.Name12.text.toString()
            13 -> binding.Name13.text.toString()
            14 -> binding.Name14.text.toString()
            15 -> binding.Name15.text.toString()
            else -> ""
        }
    }

    fun getRowBirthOrder(row: Int): String {
        return when(row) {
            1 -> binding.BirthOrder1.text.toString()
            2 -> binding.BirthOrder2.text.toString()
            3 -> binding.BirthOrder3.text.toString()
            4 -> binding.BirthOrder4.text.toString()
            5 -> binding.BirthOrder5.text.toString()
            6 -> binding.BirthOrder6.text.toString()
            7 -> binding.BirthOrder7.text.toString()
            8 -> binding.BirthOrder8.text.toString()
            9 -> binding.BirthOrder9.text.toString()
            10 -> binding.BirthOrder10.text.toString()
            11 -> binding.BirthOrder11.text.toString()
            12 -> binding.BirthOrder12.text.toString()
            13 -> binding.BirthOrder13.text.toString()
            14 -> binding.BirthOrder14.text.toString()
            15 -> binding.BirthOrder15.text.toString()
            else -> ""
        }
    }

    fun getRowGothram(row: Int): String {
        return when(row) {
            1 -> binding.gotram1.text.toString()
            2 -> binding.gotram2.text.toString()
            3 -> binding.gotram3.text.toString()
            4 -> binding.gotram4.text.toString()
            5 -> binding.gotram5.text.toString()
            6 -> binding.gotram6.text.toString()
            7 -> binding.gotram7.text.toString()
            8 -> binding.gotram8.text.toString()
            9 -> binding.gotram9.text.toString()
            10 -> binding.gotram10.text.toString()
            11 -> binding.gotram11.text.toString()
            12 -> binding.gotram12.text.toString()
            13 -> binding.gotram13.text.toString()
            14 -> binding.gotram14.text.toString()
            15 -> binding.gotram15.text.toString()
            else -> ""
        }
    }

    fun getRowRelation(row: Int): String {
        return when(row) {
            1 -> binding.relationship1.text.toString()
            2 -> binding.relationship2.text.toString()
            3 -> binding.relationship3.text.toString()
            4 -> binding.relationship4.text.toString()
            5 -> binding.relationship5.text.toString()
            6 -> binding.relationship6.text.toString()
            7 -> binding.relationship7.text.toString()
            8 -> binding.relationship8.text.toString()
            9 -> binding.relationship9.text.toString()
            10 -> binding.relationship10.text.toString()
            11 -> binding.relationship11.text.toString()
            12 -> binding.relationship12.text.toString()
            13 -> binding.relationship13.text.toString()
            14 -> binding.relationship14.text.toString()
            15 -> binding.relationship15.text.toString()
            else -> ""
        }
    }

    fun getRowGender(row: Int): String {
        return when(row) {
            1 -> Gndr1
            2 -> Gndr2
            3 -> Gndr3
            4 -> Gndr4
            5 -> Gndr5
            6 -> Gndr6
            7 -> Gndr7
            8 -> Gndr8
            9 -> Gndr9
            10 -> Gndr10
            11 -> Gndr11
            12 -> Gndr12
            13 -> Gndr13
            14 -> Gndr14
            15 -> Gndr15
            else -> ""
        }
    }

    fun setRowData(row: Int, name: String, birthOrder: String, gothram: String, relation: String, gender: String) {
        when(row) {
            1 -> {
                binding.Name1.text = name
                binding.BirthOrder1.text = birthOrder
                binding.gotram1.text = gothram
                binding.relationship1.text = relation
                Gndr1 = gender
            }
            2 -> {
                binding.Name2.text = name
                binding.BirthOrder2.text = birthOrder
                binding.gotram2.text = gothram
                binding.relationship2.text = relation
                Gndr2 = gender
            }
            3 -> {
                binding.Name3.text = name
                binding.BirthOrder3.text = birthOrder
                binding.gotram3.text = gothram
                binding.relationship3.text = relation
                Gndr3 = gender
            }
            4 -> {
                binding.Name4.text = name
                binding.BirthOrder4.text = birthOrder
                binding.gotram4.text = gothram
                binding.relationship4.text = relation
                Gndr4 = gender
            }
            5 -> {
                binding.Name5.text = name
                binding.BirthOrder5.text = birthOrder
                binding.gotram5.text = gothram
                binding.relationship5.text = relation
                Gndr5 = gender
            }
            6 -> {
                binding.Name6.text = name
                binding.BirthOrder6.text = birthOrder
                binding.gotram6.text = gothram
                binding.relationship6.text = relation
                Gndr6 = gender
            }
            7 -> {
                binding.Name7.text = name
                binding.BirthOrder7.text = birthOrder
                binding.gotram7.text = gothram
                binding.relationship7.text = relation
                Gndr7 = gender
            }
            8 -> {
                binding.Name8.text = name
                binding.BirthOrder8.text = birthOrder
                binding.gotram8.text = gothram
                binding.relationship8.text = relation
                Gndr8 = gender
            }
            9 -> {
                binding.Name9.text = name
                binding.BirthOrder9.text = birthOrder
                binding.gotram9.text = gothram
                binding.relationship9.text = relation
                Gndr9 = gender
            }
            10 -> {
                binding.Name10.text = name
                binding.BirthOrder10.text = birthOrder
                binding.gotram10.text = gothram
                binding.relationship10.text = relation
                Gndr10 = gender
            }
            11 -> {
                binding.Name11.text = name
                binding.BirthOrder11.text = birthOrder
                binding.gotram11.text = gothram
                binding.relationship11.text = relation
                Gndr11 = gender
            }
            12 -> {
                binding.Name12.text = name
                binding.BirthOrder12.text = birthOrder
                binding.gotram12.text = gothram
                binding.relationship12.text = relation
                Gndr12 = gender
            }
            13 -> {
                binding.Name13.text = name
                binding.BirthOrder13.text = birthOrder
                binding.gotram13.text = gothram
                binding.relationship13.text = relation
                Gndr13 = gender
            }
            14 -> {
                binding.Name14.text = name
                binding.BirthOrder14.text = birthOrder
                binding.gotram14.text = gothram
                binding.relationship14.text = relation
                Gndr14 = gender
            }
            15 -> {
                binding.Name15.text = name
                binding.BirthOrder15.text = birthOrder
                binding.gotram15.text = gothram
                binding.relationship15.text = relation
                Gndr15 = gender
            }
        }
    }

    fun updateRowVisibility() {
        binding.headRow.visibility = if (binding.Name1.text.isEmpty()) View.INVISIBLE else View.VISIBLE
        binding.firstRow.visibility = if (binding.Name1.text.isEmpty()) View.INVISIBLE else View.VISIBLE
        binding.secondRow.visibility = if (binding.Name2.text.isEmpty()) View.INVISIBLE else View.VISIBLE
        binding.thirdRow.visibility = if (binding.Name3.text.isEmpty()) View.INVISIBLE else View.VISIBLE
        binding.fourthRow.visibility = if (binding.Name4.text.isEmpty()) View.INVISIBLE else View.VISIBLE
        binding.fifthRow.visibility = if (binding.Name5.text.isEmpty()) View.INVISIBLE else View.VISIBLE
        binding.sixthRow.visibility = if (binding.Name6.text.isEmpty()) View.INVISIBLE else View.VISIBLE
        binding.seventhRow.visibility = if (binding.Name7.text.isEmpty()) View.INVISIBLE else View.VISIBLE
        binding.eighthRow.visibility = if (binding.Name8.text.isEmpty()) View.INVISIBLE else View.VISIBLE
        binding.ninethRow.visibility = if (binding.Name9.text.isEmpty()) View.INVISIBLE else View.VISIBLE
        binding.tenRow.visibility = if (binding.Name10.text.isEmpty()) View.INVISIBLE else View.VISIBLE
        binding.elevenRow.visibility = if (binding.Name11.text.isEmpty()) View.INVISIBLE else View.VISIBLE
        binding.twelveRow.visibility = if (binding.Name12.text.isEmpty()) View.INVISIBLE else View.VISIBLE
        binding.thirteenRow.visibility = if (binding.Name13.text.isEmpty()) View.INVISIBLE else View.VISIBLE
        binding.fourteenRow.visibility = if (binding.Name14.text.isEmpty()) View.INVISIBLE else View.VISIBLE
        binding.fifteenRow.visibility = if (binding.Name15.text.isEmpty()) View.INVISIBLE else View.VISIBLE
    }

    // Setup long-click listeners for drag-to-swap functionality
    fun setupRowLongClickListeners() {
        val rows = listOf(
            Pair(1, binding.firstRow),
            Pair(2, binding.secondRow),
            Pair(3, binding.thirdRow),
            Pair(4, binding.fourthRow),
            Pair(5, binding.fifthRow),
            Pair(6, binding.sixthRow),
            Pair(7, binding.seventhRow),
            Pair(8, binding.eighthRow),
            Pair(9, binding.ninethRow),
            Pair(10, binding.tenRow),
            Pair(11, binding.elevenRow),
            Pair(12, binding.twelveRow),
            Pair(13, binding.thirteenRow),
            Pair(14, binding.fourteenRow),
            Pair(15, binding.fifteenRow)
        )
        
        for ((rowNum, rowView) in rows) {
            rowView.setOnLongClickListener {
                if (selectedRowForSwap == -1) {
                    // First selection - highlight row
                    selectedRowForSwap = rowNum
                    rowView.setBackgroundColor(android.graphics.Color.parseColor("#FFEB3B"))
                    android.widget.Toast.makeText(this, "Row $rowNum selected. Tap another row to swap.", android.widget.Toast.LENGTH_SHORT).show()
                }
                true
            }
            
            rowView.setOnClickListener {
                if (selectedRowForSwap != -1 && selectedRowForSwap != rowNum) {
                    // Swap the rows
                    swapRows(selectedRowForSwap, rowNum)
                    // Reset selection and background
                    resetRowBackgrounds()
                    selectedRowForSwap = -1
                    android.widget.Toast.makeText(this, "Rows swapped!", android.widget.Toast.LENGTH_SHORT).show()
                } else if (selectedRowForSwap == rowNum) {
                    // Deselect if tapping the same row
                    resetRowBackgrounds()
                    selectedRowForSwap = -1
                }
            }
        }
    }
    
    fun resetRowBackgrounds() {
        val defaultColor = android.graphics.Color.TRANSPARENT
        binding.firstRow.setBackgroundColor(defaultColor)
        binding.secondRow.setBackgroundColor(defaultColor)
        binding.thirdRow.setBackgroundColor(defaultColor)
        binding.fourthRow.setBackgroundColor(defaultColor)
        binding.fifthRow.setBackgroundColor(defaultColor)
        binding.sixthRow.setBackgroundColor(defaultColor)
        binding.seventhRow.setBackgroundColor(defaultColor)
        binding.eighthRow.setBackgroundColor(defaultColor)
        binding.ninethRow.setBackgroundColor(defaultColor)
        binding.tenRow.setBackgroundColor(defaultColor)
        binding.elevenRow.setBackgroundColor(defaultColor)
        binding.twelveRow.setBackgroundColor(defaultColor)
        binding.thirteenRow.setBackgroundColor(defaultColor)
        binding.fourteenRow.setBackgroundColor(defaultColor)
        binding.fifteenRow.setBackgroundColor(defaultColor)
    }
}
