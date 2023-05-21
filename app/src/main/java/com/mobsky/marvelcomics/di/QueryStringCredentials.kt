package com.mobsky.marvelcomics.di

import com.google.gson.GsonBuilder
import java.security.MessageDigest
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class QueryStringCredentials(
    val apikey: String = "ddb6bbcc2f2af289df182bdbd10c3550",
    var ts: String = "",
    var hash: String = ""
) {

    init {
        ts = generateTimestamp()
        hash = ts.generateHash()
    }

    private fun generateTimestamp(): String =
        SimpleDateFormat(FORMAT_DATE, Locale.getDefault()).format(Date())

    private fun String.generateHash(): String =
        MessageDigest.getInstance(FORMAT_ALGORITHM_MD5).let { messageDigest ->
            messageDigest.digest(this.getMd5CombineValue().toByteArray())
                .joinToString("") { join -> "%02x".format(join) }
        }

    private fun String.getMd5CombineValue() = "$this$KEY_MASTER$apikey"

    fun getQueryStringMap(): Map<String, String>? =
        mapper.fromJson(mapper.toJson(this), Map::class.java) as Map<String, String>?

    companion object {
        private const val KEY_MASTER = "2746f8276b160edfcd3aa7243478f28ff7b3cc73"
        private const val FORMAT_DATE = "yyyyMMddHHmmss"
        private const val FORMAT_ALGORITHM_MD5 = "MD5"

        private val mapper = GsonBuilder().create()
    }
}
