package com.alickollisofware.randomnumbergenerator.email

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.alickollisofware.randomnumbergenerator.R

class EmailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_email)

        val fragment = EmailFragment()
        val generateButton = findViewById<Button>(R.id.generateButton)

        generateButton.setOnClickListener {
            fragment.generateRandomEmail()
        }
    }
}
