package com.karma.sureshtrb.enKarma

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Panchang (Astronomical/Astrological) data
 * Replaces global mutable variables with immutable data class
 */
@Parcelize
data class PanchangData(
    val shakaSamvat: String = "",
    val vedicAyana: String = "",
    val vedicRithu: String = "",
    val suryaRasi: String = "",
    val paksha: String = "",
    val weekDay: String = "",
    val naksha: String = "",
    val yoga: String = "",
    val karana: String = "",
    val suryaNakshatra: String = "",
    val chandraMasa: String = "",
    val chandraRasi: String = ""
) : Parcelable

/**
 * Family member status information
 * Replaces global mutable variables with immutable data class
 */
@Parcelize
data class FamilyStatusData(
    val motherLive: String = "",
    val yrGFatherLive: String = "",
    val fatherMotherLive: String = "",
    val mFatherLive: String = "",
    val motherMotherLive: String = ""
) : Parcelable

/**
 * Panchang calculation variables
 * Replaces global mutable variables with immutable data class
 */
@Parcelize
data class CalculationData(
    val nextDayTithiHrToMin: Int = 0,
    val nextDayTitiUptoHrOnly: Int = 0,
    val todayPaksha: String = "",
    val mapKey: String = "",
    val dataList: String = "",
    val madyana: String = "",
    val prathaSanthya: String = "",
    val sayamSandya: String = "",
    val mapKey2: String = "",
    val dataList2: String = "",
    val mapKey3: String = "",
    val dataList3: String = "",
    val mapKey4: String = "",
    val dataList4: String = ""
) : Parcelable

// Global variables for backward compatibility
// TODO: Gradually migrate to passing data via Intents/ViewModels
var shakaSamvat: String = ""
var vedicAyana: String = ""
var vedicRithu: String = ""
var suryaRasi: String = ""
var paksha: String = ""
var weekDay: String = ""
var naksha: String = ""
var yoga: String = ""
var karana: String = ""
var suryaNakshatra: String = ""
var chandraMasa: String = ""
var chandraRasi: String = ""

// Family status variables
var motherLive: String = ""
var yrGFatherLive: String = ""
var fatherMotherLive: String = ""
var mFatherLive: String = ""
var motherMotherLive: String = ""

// Calculation variables
var nextDayTithiHrToMin: Int = 0
var nextDayTitiUptoHrOnly: Int = 0
var todayPaksha: String = ""
var mapKey: String = ""
var DataList: String = ""
var madyana: String = ""
var prathaSanthya: String = ""
var sayamSandya: String = ""
var mapKey2: String = ""
var DataList2: String = ""
var mapKey3: String = ""
var DataList3: String = ""
var mapKey4: String = ""
var DataList4: String = ""

// Additional missing variables from error log
var mGothram: String = ""
var urGothram: String = ""
var gName: String = ""
var gDateStr: String = ""
var gDate: String = ""
var gMonth: String = ""
var gYear: String = ""
var gDOB: String = ""
var gTOB: String = ""
var gPOB: String = ""
var gLatitude: String = ""
var gLongitude: String = ""
var gTimeZone: String = ""
var gDayLight: String = ""
var selectedNakshatra: String = ""
var selectedPadam: String = ""
var rasiLagna: String = ""
var bhavaLagna: String = ""
var horaLagna: String = ""
var ghatikaLagna: String = ""
var vighatikaLagna: String = ""
var pranapadalagna: String = ""
var indrulagna: String = ""
var sreeRasi: String = ""
var sreeThrimsamsa: String = ""
var sreeSunRasi: String = ""
var sreeSunThrimsamsa: String = ""
var yogi: String = ""
var avayogi: String = ""
var duplicate: String = ""
var maasaadhipathi: String = ""
var vaarasadhipathi: String = ""
var lagna: String = ""
var selectedRasi: String = ""
var kuja: String = ""
var sani: String = ""
var raahu: String = ""
var lagnaRasi: String = ""
var sunRasi: String = ""
var moonRasi: String = ""
var marsRasi: String = ""
var mercuryRasi: String = ""
var jupiterRasi: String = ""
var venusRasi: String = ""
var saturnRasi: String = ""
var rahuRasi: String = ""
var ketuRasi: String = ""
var tithi: String = ""
var thidhi: String = ""
var thithiPercent: String = ""
var nityaYogam: String = ""
var chandraYogam: String = ""
var amruthaGhadiya: String = ""
var varjyam: String = ""
var rahukalam: String = ""
var yamakandakam: String = ""
var dhurMugurtham: String = ""
var varjyamInHindi: String = ""
var rahukalamInHindi: String = ""
var yamakandakamInHindi: String = ""
var dhurMugurthamInHindi: String = ""
var amruthaghadiyaInHindi: String = ""
var gulikalam: String = ""
var abhijitMuhurtham: String = ""
var sunRise: String = ""
var sunSet: String = ""
var moonRise: String = ""
var moonSet: String = ""
var ayanamsam: String = ""
