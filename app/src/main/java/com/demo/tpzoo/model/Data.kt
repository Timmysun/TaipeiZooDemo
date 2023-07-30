package com.demo.tpzoo.model

import com.google.gson.annotations.SerializedName

data class IntroductionResult(
    val result: CategoryResult
)

data class CategoryResult(
    val results: List<CategoryInfo>
)

data class CategoryInfo(
    @SerializedName("e_category")
    val category: String,
    @SerializedName("e_name")
    val name: String,
    @SerializedName("e_pic_url")
    val picUrl: String,
    @SerializedName("e_info")
    val info: String,
    @SerializedName("e_memo")
    val memo: String,
    @SerializedName("e_url")
    val url: String
)