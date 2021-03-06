package com.erikmedina.article.data.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class ContentResponse {

    @SerializedName("item")
    @Expose
    var item: Item = Item()
}
