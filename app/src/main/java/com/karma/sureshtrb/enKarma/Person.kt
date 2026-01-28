package com.karma.sureshtrb.enKarma

/**
 * Data model class representing a person.
 * Used for storing personal details like name, gothram, and relationship info.
 */
data class Person(
    var name: String = "",
    var birthOrder: String = "",
    var gothram: String = "",
    var gender: String = "",
    var relationship: String = ""
)
