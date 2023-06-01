package com.azimzada.myapplication.model

import android.text.BoringLayout

data class Flags(
    var nsfw: Boolean,
    var religious: Boolean,
    var political: Boolean,
    var racist: Boolean,
    var sexist: Boolean,
    var explicit: Boolean
)