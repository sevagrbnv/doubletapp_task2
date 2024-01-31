package com.example.doubletapp_task2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FirstActivity : AppCompatActivity() {

    private val logger = MyFileLogger(context = this)

    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        count = if (savedInstanceState != null) {
            savedInstanceState.getInt("number", 0).plus(1) ?: 0
        } else intent.getIntExtra("number", 0)

        val numberTextView = findViewById<TextView>(R.id.textViewFirst).apply {
            text = count.toString()
        }

        val buttonGoToSecondActivity = findViewById<Button>(R.id.buttonGoToSecond).apply {
            setOnClickListener {
                goToSecondWithParam(this@FirstActivity, count)
            }
        }

        logger.writeLogMessage(
            tag = this.componentName.toString(),
            logMessage = "Activity was created",
            type = LogMessageType.Debug
        )
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("number", count)
        super.onSaveInstanceState(outState)
        logger.writeLogMessage(
            tag = this.componentName.toString(),
            logMessage = "Configuration was changed",
            type = LogMessageType.Debug
        )
    }

    override fun onStart() {
        super.onStart()
        logger.writeLogMessage(
            tag = this.componentName.toString(),
            logMessage = "Activity was started",
            type = LogMessageType.Debug
        )
    }

    override fun onResume() {
        super.onResume()
        logger.writeLogMessage(
            tag = this.componentName.toString(),
            logMessage = "Activity was resumed",
            type = LogMessageType.Debug
        )
    }

    override fun onPause() {
        super.onPause()
        logger.writeLogMessage(
            tag = this.componentName.toString(),
            logMessage = "Activity was paused",
            type = LogMessageType.Debug
        )
    }

    override fun onStop() {
        super.onStop()
        logger.writeLogMessage(
            tag = this.componentName.toString(),
            logMessage = "Activity was stopped",
            type = LogMessageType.Debug
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        logger.writeLogMessage(
            tag = this.componentName.toString(),
            logMessage = "Activity was destroyed",
            type = LogMessageType.Debug
        )
    }

    companion object {
        fun goToSecondWithParam(context: Context, number: Int) {
            context.startActivity(
                Intent(context, SecondActivity::class.java).apply {
                    putExtra("number", number)
                }
            )
        }
    }
}