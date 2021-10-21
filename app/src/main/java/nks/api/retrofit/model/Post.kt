package nks.api.retrofit.model

import com.google.gson.annotations.SerializedName

data class Post (

    val userId:Int, //we need to keep the variable name same as that in api response or else add
                    // @SerializedName("var name") parameter above the custom variable
    val id:Int,
    val title:String,
    val body:String
)