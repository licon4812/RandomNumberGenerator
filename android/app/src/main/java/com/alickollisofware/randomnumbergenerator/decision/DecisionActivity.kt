package com.alickollisofware.randomnumbergenerator.decision

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.alickollisofware.randomnumbergenerator.R

class DecisionActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_decision)
    }
    fun generateRandomDecision(view: View) {
        val random = findViewById<TextView>(R.id.result)
        val randomInt = (0..1).random()
        if (randomInt == 0) {
            random.text = "Yes"
        } else {
            random.text = "No"
        }
    }
}