package com.example.doubletapp_task2

import android.content.Context
import android.content.Context.MODE_APPEND
import java.io.OutputStreamWriter

class MyFileLogger(
    // файл по умолчанию лежит в /data/data/com.example.doubletapp_task2/files/log_file.txt
    private val fileName: String = "log_file.txt",
    private val context: Context
) {

    fun writeLogMessage(tag: String, logMessage: String, type: LogMessageType) {
        try {
            val fileOutputStream = context.openFileOutput(fileName, MODE_APPEND)
            val outputStreamWriter = OutputStreamWriter(fileOutputStream)
            outputStreamWriter.write("$tag: $logMessage | $type\n")
            outputStreamWriter.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


}

enum class LogMessageType {
    Info,
    Debug,
    Error
}