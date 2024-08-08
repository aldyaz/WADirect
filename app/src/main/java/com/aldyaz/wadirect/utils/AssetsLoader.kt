package com.aldyaz.wadirect.utils

import android.content.Context

class AssetsLoader(
    private val context: Context
) {

    fun loadJsonFile(fileName: String): String {
        return try {
            val inputStream = context.assets.open(fileName)
            val buffer = ByteArray(inputStream.available())
            inputStream.read(buffer)
            inputStream.close()
            buffer.toString(Charsets.UTF_8)
        } catch (err: Exception) {
            err.printStackTrace()
            ""
        }
    }
}