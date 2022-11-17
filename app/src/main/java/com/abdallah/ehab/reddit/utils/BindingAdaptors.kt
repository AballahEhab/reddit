package com.abdallah.ehab.reddit.utils

import android.view.View
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import coil.load


@BindingAdapter("imageUrl")
fun ImageView.bindImage( imgUrl: String?) {
    var url = imgUrl
    if(imgUrl == null)
        url = "https://upload.wikimedia.org/wikipedia/commons/1/14/No_Image_Available.jpg?20200913095930"
        val imgUri = url!!.toUri().buildUpon().scheme("https").build()
        this.load(imgUri)

}


@BindingAdapter("isVisible")
fun View.isVisible(visible:Boolean){
    if (visible)
        this.visibility = View.VISIBLE
    else
        this.visibility = View.GONE
}
