package com.example.tribuna.models

import android.graphics.drawable.Drawable

class Author(
    val authorName:String,
    val authorDrawable: Drawable,
    val authorStatus:Boolean //false=hater, null=neutral, true=promoter
) {
}