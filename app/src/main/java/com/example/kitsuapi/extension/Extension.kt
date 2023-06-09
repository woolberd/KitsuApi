package com.example.kitsuapi.extension

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.setImage(uri: String) {
    Glide.with(this.context)
        .load(uri)
        .into(this)
}
