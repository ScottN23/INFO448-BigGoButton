package edu.uw.ischool.scottng.biggobutton

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var count = 0
    private lateinit var goButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        goButton = findViewById<Button>(R.id.button)
        goButton.setOnClickListener {
            buttonClick()
        }
    }

    fun buttonClick() {
        count++

        val newText = getString(R.string.pushed_text, count, if (count > 1) "s" else "")
        goButton.text = newText

        val buttonColor = generateRandomColor()
        goButton.setBackgroundColor(buttonColor)

        val textColor = generateRandomColor()
        goButton.setTextColor(textColor)

        val animation = AnimationUtils.loadAnimation(this, androidx.constraintlayout.widget.R.anim.abc_slide_in_top)
        goButton.startAnimation(animation)
    }

    private fun generateRandomColor(): Int {
        return Color.rgb(Random.nextInt(256), Random.nextInt(256), Random.nextInt(256))
    }
}