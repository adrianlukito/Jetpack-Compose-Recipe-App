package com.codingwithmitch.mvvmrecipeapp.network.responses

import com.codingwithmitch.mvvmrecipeapp.network.model.RecipeNetworkEntity
import com.google.gson.annotations.SerializedName

class RecipeSearchResponse(

    @SerializedName("count")
    var count: Int,

    @SerializedName("results")
    var recipes: List<RecipeNetworkEntity>,

    @SerializedName("next")
    var next: String? = null,

    @SerializedName("previous")
    var previous: String? = null,
)