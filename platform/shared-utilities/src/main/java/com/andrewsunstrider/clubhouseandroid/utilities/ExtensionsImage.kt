package com.andrewsunstrider.clubhouseandroid.utilities

import android.widget.ImageView
import coil.load
import coil.transform.CircleCropTransformation
import com.andrewsunstrider.clubhouseandroid.sharedassets.R


fun ImageView.load(url: String) {
    load(url) {
        transformations(CircleCropTransformation())
        placeholder(R.drawable.avatar_placeholder)
    }
}