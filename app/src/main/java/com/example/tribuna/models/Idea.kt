package com.example.tribuna.models

import android.graphics.drawable.Drawable
import java.util.*

class Idea (
    val id:Int,
    val authorName:String,
    val ideaText:String,
    val ideaDate: Date,
    val link:String,
    val ideaDrawable: Drawable?,
    var likedByMe:Boolean,
    var dislikedByMe:Boolean
){
}