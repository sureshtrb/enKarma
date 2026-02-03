package com.karma.sureshtrb.enKarma

// ============================================================================
// GLOBAL DATA - Centralized Application State
// ============================================================================

// ----------------------------------------------------------------------------
// 1. GOTHRAM & PRAVARAS (User Identity for Rituals)
// ----------------------------------------------------------------------------
var mGothram: String = ""          // Main Gothram (from GlobalData)
var mPravaras: String = ""         // Main Pravaras (from GlobalData)
var urGothram: String = ""         // User-selected Gothram (from SandhiData)
var urPravaras: String = ""        // User-selected Pravaras (from SandhiData)

// ----------------------------------------------------------------------------
// 2. SANDHYA/SANDHI TIME CALCULATIONS
// ----------------------------------------------------------------------------
var nowSandhi: String = ""         // Current Sandhi type
var tyDate: String = "__/__/____"  // Today's date
var yesterday: String = ""         // Yesterday's date

// Sayahna Sandhya (Evening) timings
var SSandyaStartHrInMinutes: Int = 0
var SSandyaFinishHrInMinutes: Int = 0

// Pratah Sandhya (Morning) timings
var PSandyaStartHrInMinutes: Int = 0
var PSandyaFinishHrInMinutes: Int = 0

var clockTimeInMinutes: Int = 0    // Current time in minutes

// Sandhya period names
var prathaSanthya: String = ""     // Morning Sandhya period
var madyana: String = ""           // Afternoon period
var sayamSandya: String = ""       // Evening Sandhya period

// ----------------------------------------------------------------------------
// 3. ASTROLOGICAL & PANCHANG DATA
// ----------------------------------------------------------------------------
// Vedic calendar
var shakaSamvat: String = ""       // Shaka year
var vedicAyana: String = ""        // Vedic season (Uttarayana/Dakshinayana)
var vedicRithu: String = ""        // Vedic season/Rithu
var chandraMasa: String = ""       // Lunar month

// Celestial positions
var suryaRasi: String = ""         // Sun's zodiac sign
var suryaNakshatra: String = ""    // Sun's nakshatra
var chandraRasi: String = ""       // Moon's zodiac sign
var naksha: String = ""            // Current nakshatra

// Tithi & lunar phase
var paksha: String = ""            // Lunar fortnight (Shukla/Krishna)
var todayPaksha: String = ""       // Today's paksha
var nextDayTithiHrToMin: Int = 0   // Next day tithi time
var nextDayTitiUptoHrOnly: Int = 0 // Next day tithi hour

// Other panchang elements
var weekDay: String = ""           // Day of week
var yoga: String = ""              // Yoga
var karana: String = ""            // Karana

// ----------------------------------------------------------------------------
// 4. FAMILY MEMBER STATUS (Living/Deceased)
// ----------------------------------------------------------------------------
var motherLive: String = ""        // Mother's living status
var yrGFatherLive: String = ""     // Your grandfather's status
var fatherMotherLive: String = ""  // Father's mother status
var mFatherLive: String = ""       // Mother's father status
var motherMotherLive: String = ""  // Mother's mother status

// ----------------------------------------------------------------------------
// 5. FAMILY NAMES (Father's Side)
// ----------------------------------------------------------------------------
var appaAmmaName: String = ""      // Father's mother name
var appaPattiName: String = ""     // Father's grandmother name
var appaKolluPattiName: String = "" // Father's great-grandmother name

// ----------------------------------------------------------------------------
// 6. FAMILY NAMES (Mother's Side)
// ----------------------------------------------------------------------------
var ammaName: String = ""          // Mother's name
var ammaAmmaName: String = ""      // Mother's mother name
var ammaPattiName: String = ""     // Mother's grandmother name
var ammaKolluPattiName: String = "" // Mother's great-grandmother name

// ----------------------------------------------------------------------------
// 7. THARPANAM CONFIGURATION
// ----------------------------------------------------------------------------
var noOfDaysTpnm: String = ""      // Number of days for Tharpanam (OneDay/15Days)

// ----------------------------------------------------------------------------
// 8. UI STATE & PREFERENCES
// ----------------------------------------------------------------------------
var spinnerPosition: Int = 0       // Spinner selection position

// ----------------------------------------------------------------------------
// 9. WEB SCRAPING DATA HOLDERS (Panchang parsing)
// ----------------------------------------------------------------------------
var mapKey: String = ""
var DataList: String = ""
var mapKey2: String = ""
var DataList2: String = ""
var mapKey3: String = ""
var DataList3: String = ""
var mapKey4: String = ""
var DataList4: String = ""
