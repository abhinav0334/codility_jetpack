package com.example.codilitytest.model

import com.google.gson.annotations.SerializedName

data class DataModelResponse (

    @SerializedName("schemeCode" )
    var schemeCode : Int?    = null,
    @SerializedName("schemeName" )
    var schemeName : String? = null

)