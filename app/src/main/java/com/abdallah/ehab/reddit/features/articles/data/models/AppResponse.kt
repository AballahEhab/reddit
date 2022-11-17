package com.abdallah.ehab.reddit.features.articles.data.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose

data class AppResponse(
    @Expose
    val data: ResponseData?,
)

data class ResponseData(
    @Expose
    val children: List<Article>?,
)

data class Article(
    @Expose
    val data: ArticleData?,
)

data class ArticleData(
    val title: String?,
    val selftext: String?,
    val thumbnail_url: String? ,
    ) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(selftext)
        parcel.writeString(thumbnail_url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ArticleData> {
        override fun createFromParcel(parcel: Parcel): ArticleData {
            return ArticleData(parcel)
        }

        override fun newArray(size: Int): Array<ArticleData?> {
            return arrayOfNulls(size)
        }
    }
}
