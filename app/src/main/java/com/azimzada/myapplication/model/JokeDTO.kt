package com.azimzada.myapplication.model

import java.io.Serializable

data class Jokes(
    var error: Boolean,
    var category: String,
    var type: String,
    var setup: String,
    var delivery: String,
    var flags: Flags,
    var safe: Boolean,
    var id: Int,
    var lang: String
)
