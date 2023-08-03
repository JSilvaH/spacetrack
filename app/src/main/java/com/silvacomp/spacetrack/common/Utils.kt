package com.silvacomp.spacetrack.common

import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Int.unixToDate(format: String = "yyyy-MM-dd HH:mm:ss "): String{
    return try {
        val date = Date(this.toLong() * 1000)
        val sdf = SimpleDateFormat(format, Locale.ENGLISH)
        sdf.format(date)
    }catch (e: Exception){
        e.printStackTrace()
        ""
    }
}