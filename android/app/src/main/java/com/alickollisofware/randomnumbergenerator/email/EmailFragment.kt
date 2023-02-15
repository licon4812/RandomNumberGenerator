package com.alickollisofware.randomnumbergenerator.email

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.alickollisofware.randomnumbergenerator.R
import java.util.*

class EmailFragment : Fragment() {

    private lateinit var emailEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_email, container, false)
        emailEditText = view.findViewById(R.id.emailEditText)
        val generateButton: Button = view.findViewById(R.id.generateButton)
        generateButton.setOnClickListener {
            generateRandomEmail()
        }
        return view
    }

    fun generateRandomEmail() {
        val chars = "abcdefghijklmnopqrstuvwxyz0123456789"
        val sb = StringBuilder()
        val random = Random()
        for (i in 0 until 10) {
            sb.append(chars[random.nextInt(chars.length)])
        }
        sb.append("@example.com")
        emailEditText.setText(sb.toString())
    }
}
