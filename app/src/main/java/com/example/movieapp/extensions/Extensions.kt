package com.example.movieapp.extensions

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide

fun String.logMe(tag: String = "MOVIE_APP") {
    Log.d(tag, this)
}

val ViewGroup.layoutInflater: LayoutInflater
    get() = LayoutInflater.from(context)

fun ImageView.loadUrl(url: String) {
    Glide.with(this).load(url).into(this)
}