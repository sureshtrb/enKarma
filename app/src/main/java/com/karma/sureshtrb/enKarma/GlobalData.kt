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

/**
 * Singleton object to manage application data state
 * Provides backward compatibility for existing code
 * Gradually migrate to passing data via Intents/ViewModels instead
 */
object GlobalDataManager {
    private var panchangData: PanchangData = PanchangData()
    private var familyStatus: FamilyStatusData = FamilyStatusData()
    private var calculationData: CalculationData = CalculationData()
    
    // Panchang Data methods
    fun setPanchangData(data: PanchangData) {
        panchangData = data
    }
    
    fun getPanchangData(): PanchangData = panchangData
    
    // Family Status methods
    fun setFamilyStatus(data: FamilyStatusData) {
        familyStatus = data
    }
    
    fun getFamilyStatus(): FamilyStatusData = familyStatus
    
    // Calculation Data methods
    fun setCalculationData(data: CalculationData) {
        calculationData = data
    }
    
    fun getCalculationData(): CalculationData = calculationData
    
    // Reset all data
    fun reset() {
        panchangData = PanchangData()
        familyStatus = FamilyStatusData()
        calculationData = CalculationData()
    }
    
    // Legacy getters for backward compatibility (deprecated)
    @Deprecated("Use getPanchangData().shakaSamvat instead", ReplaceWith("getPanchangData().shakaSamvat"))
    var shakaSamvat: String
        get() = panchangData.shakaSamvat
        set(value) { panchangData = panchangData.copy(shakaSamvat = value) }
    
    @Deprecated("Use getPanchangData().vedicAyana instead", ReplaceWith("getPanchangData().vedicAyana"))
    var vedicAyana: String
        get() = panchangData.vedicAyana
        set(value) { panchangData = panchangData.copy(vedicAyana = value) }
    
    @Deprecated("Use getPanchangData().vedicRithu instead", ReplaceWith("getPanchangData().vedicRithu"))
    var vedicRithu: String
        get() = panchangData.vedicRithu
        set(value) { panchangData = panchangData.copy(vedicRithu = value) }
    
    @Deprecated("Use getPanchangData().suryaRasi instead", ReplaceWith("getPanchangData().suryaRasi"))
    var suryaRasi: String
        get() = panchangData.suryaRasi
        set(value) { panchangData = panchangData.copy(suryaRasi = value) }
    
    @Deprecated("Use getPanchangData().paksha instead", ReplaceWith("getPanchangData().paksha"))
    var paksha: String
        get() = panchangData.paksha
        set(value) { panchangData = panchangData.copy(paksha = value) }
    
    @Deprecated("Use getPanchangData().weekDay instead", ReplaceWith("getPanchangData().weekDay"))
    var weekDay: String
        get() = panchangData.weekDay
        set(value) { panchangData = panchangData.copy(weekDay = value) }
    
    @Deprecated("Use getPanchangData().naksha instead", ReplaceWith("getPanchangData().naksha"))
    var naksha: String
        get() = panchangData.naksha
        set(value) { panchangData = panchangData.copy(naksha = value) }
    
    @Deprecated("Use getPanchangData().yoga instead", ReplaceWith("getPanchangData().yoga"))
    var yoga: String
        get() = panchangData.yoga
        set(value) { panchangData = panchangData.copy(yoga = value) }
    
    @Deprecated("Use getPanchangData().karana instead", ReplaceWith("getPanchangData().karana"))
    var karana: String
        get() = panchangData.karana
        set(value) { panchangData = panchangData.copy(karana = value) }
    
    @Deprecated("Use getPanchangData().suryaNakshatra instead", ReplaceWith("getPanchangData().suryaNakshatra"))
    var suryaNakshatra: String
        get() = panchangData.suryaNakshatra
        set(value) { panchangData = panchangData.copy(suryaNakshatra = value) }
    
    @Deprecated("Use getPanchangData().chandraMasa instead", ReplaceWith("getPanchangData().chandraMasa"))
    var chandraMasa: String
        get() = panchangData.chandraMasa
        set(value) { panchangData = panchangData.copy(chandraMasa = value) }
    
    @Deprecated("Use getPanchangData().chandraRasi instead", ReplaceWith("getPanchangData().chandraRasi"))
    var chandraRasi: String
        get() = panchangData.chandraRasi
        set(value) { panchangData = panchangData.copy(chandraRasi = value) }
    
    // Family status legacy properties
    @Deprecated("Use getFamilyStatus().motherLive instead", ReplaceWith("getFamilyStatus().motherLive"))
    var motherLive: String
        get() = familyStatus.motherLive
        set(value) { familyStatus = familyStatus.copy(motherLive = value) }
    
    @Deprecated("Use getFamilyStatus().yrGFatherLive instead", ReplaceWith("getFamilyStatus().yrGFatherLive"))
    var yrGFatherLive: String
        get() = familyStatus.yrGFatherLive
        set(value) { familyStatus = familyStatus.copy(yrGFatherLive = value) }
    
    @Deprecated("Use getFamilyStatus().fatherMotherLive instead", ReplaceWith("getFamilyStatus().fatherMotherLive"))
    var fatherMotherLive: String
        get() = familyStatus.fatherMotherLive
        set(value) { familyStatus = familyStatus.copy(fatherMotherLive = value) }
    
    @Deprecated("Use getFamilyStatus().mFatherLive instead", ReplaceWith("getFamilyStatus().mFatherLive"))
    var mFatherLive: String
        get() = familyStatus.mFatherLive
        set(value) { familyStatus = familyStatus.copy(mFatherLive = value) }
    
    @Deprecated("Use getFamilyStatus().motherMotherLive instead", ReplaceWith("getFamilyStatus().motherMotherLive"))
    var motherMotherLive: String
        get() = familyStatus.motherMotherLive
        set(value) { familyStatus = familyStatus.copy(motherMotherLive = value) }
    
    // Calculation data legacy properties
    @Deprecated("Use getCalculationData().nextDayTithiHrToMin instead", ReplaceWith("getCalculationData().nextDayTithiHrToMin"))
    var nextDayTithiHrToMin: Int
        get() = calculationData.nextDayTithiHrToMin
        set(value) { calculationData = calculationData.copy(nextDayTithiHrToMin = value) }
    
    @Deprecated("Use getCalculationData().nextDayTitiUptoHrOnly instead", ReplaceWith("getCalculationData().nextDayTitiUptoHrOnly"))
    var nextDayTitiUptoHrOnly: Int
        get() = calculationData.nextDayTitiUptoHrOnly
        set(value) { calculationData = calculationData.copy(nextDayTitiUptoHrOnly = value) }
    
    @Deprecated("Use getCalculationData().todayPaksha instead", ReplaceWith("getCalculationData().todayPaksha"))
    var todayPaksha: String
        get() = calculationData.todayPaksha
        set(value) { calculationData = calculationData.copy(todayPaksha = value) }
    
    @Deprecated("Use getCalculationData().mapKey instead", ReplaceWith("getCalculationData().mapKey"))
    var mapKey: String
        get() = calculationData.mapKey
        set(value) { calculationData = calculationData.copy(mapKey = value) }
    
    @Deprecated("Use getCalculationData().dataList instead", ReplaceWith("getCalculationData().dataList"))
    var DataList: String
        get() = calculationData.dataList
        set(value) { calculationData = calculationData.copy(dataList = value) }
    
    @Deprecated("Use getCalculationData().madyana instead", ReplaceWith("getCalculationData().madyana"))
    var madyana: String
        get() = calculationData.madyana
        set(value) { calculationData = calculationData.copy(madyana = value) }
    
    @Deprecated("Use getCalculationData().prathaSanthya instead", ReplaceWith("getCalculationData().prathaSanthya"))
    var prathaSanthya: String
        get() = calculationData.prathaSanthya
        set(value) { calculationData = calculationData.copy(prathaSanthya = value) }
    
    @Deprecated("Use getCalculationData().sayamSandya instead", ReplaceWith("getCalculationData().sayamSandya"))
    var sayamSandya: String
        get() = calculationData.sayamSandya
        set(value) { calculationData = calculationData.copy(sayamSandya = value) }
    
    @Deprecated("Use getCalculationData().mapKey2 instead", ReplaceWith("getCalculationData().mapKey2"))
    var mapKey2: String
        get() = calculationData.mapKey2
        set(value) { calculationData = calculationData.copy(mapKey2 = value) }
    
    @Deprecated("Use getCalculationData().dataList2 instead", ReplaceWith("getCalculationData().dataList2"))
    var DataList2: String
        get() = calculationData.dataList2
        set(value) { calculationData = calculationData.copy(dataList2 = value) }
    
    @Deprecated("Use getCalculationData().mapKey3 instead", ReplaceWith("getCalculationData().mapKey3"))
    var mapKey3: String
        get() = calculationData.mapKey3
        set(value) { calculationData = calculationData.copy(mapKey3 = value) }
    
    @Deprecated("Use getCalculationData().dataList3 instead", ReplaceWith("getCalculationData().dataList3"))
    var DataList3: String
        get() = calculationData.dataList3
        set(value) { calculationData = calculationData.copy(dataList3 = value) }
    
    @Deprecated("Use getCalculationData().mapKey4 instead", ReplaceWith("getCalculationData().mapKey4"))
    var mapKey4: String
        get() = calculationData.mapKey4
        set(value) { calculationData = calculationData.copy(mapKey4 = value) }
    
    @Deprecated("Use getCalculationData().dataList4 instead", ReplaceWith("getCalculationData().dataList4"))
    var DataList4: String
        get() = calculationData.dataList4
        set(value) { calculationData = calculationData.copy(dataList4 = value) }
}
