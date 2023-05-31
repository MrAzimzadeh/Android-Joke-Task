package com.azimzada.myapplication.model

import java.io.Serializable

data class JokeDTO(
    var error :  Boolean,
    var joke :  String,
    var category : String,
    var type :  String ,
    var setup :  String ,
    var delivery :  String ,
    val id :Int ,
    val safe : Boolean,
    val lang :  String
) :  Serializable
