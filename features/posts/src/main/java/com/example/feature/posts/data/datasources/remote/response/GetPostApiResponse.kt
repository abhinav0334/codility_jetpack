package com.example.feature.posts.data.datasources.remote.response


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
class GetPostApiResponse : ArrayList<GetPostApiResponse.GetPostApiResponseItem>(){
    @Keep
    data class GetPostApiResponseItem(
        @SerializedName("schemeCode" )
        var schemeCode : Int?    = null,
        @SerializedName("schemeName" )
        var schemeName : String? = null
    )
}