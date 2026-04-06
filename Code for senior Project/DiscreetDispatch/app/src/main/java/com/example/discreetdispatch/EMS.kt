package com.example.discreetdispatch

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class EMS : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ems)
        val rootView = findViewById<View>(R.id.main)
        val finishButton: Button = findViewById(R.id.btn_finish)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        finishButton.setOnClickListener {
            // Get EditText values
            val name = findViewById<EditText>(R.id.et_name).text.toString().ifBlank { "Name not Given" }
            val address = findViewById<EditText>(R.id.et_address).text.toString().ifBlank { "Address not given" }
            val othersDetails = findViewById<EditText>(R.id.et_others_details).text.toString().ifBlank { "No details given" }
            val otherDetails = findViewById<EditText>(R.id.et_other_info).text.toString().ifBlank { "No details given" }
            val emergencyDetails = findViewById<EditText>(R.id.et_emergency_details).text.toString().ifBlank { "No details given" }

            // Get selected RadioButton values
            val genderGroup = findViewById<RadioGroup>(R.id.GenderOptions)
            val selectedGenderId = genderGroup.checkedRadioButtonId
            val gender = if (selectedGenderId != -1)
                findViewById<RadioButton>(selectedGenderId).text.toString()
            else
                "Gender not given"

            val callGroup = findViewById<RadioGroup>(R.id.CallOptions)
            val selectedCallId = callGroup.checkedRadioButtonId
            val callType = if (selectedCallId != -1)
                findViewById<RadioButton>(selectedCallId).text.toString()
            else
                "Address Unknown"

            val dangerGroup = findViewById<RadioGroup>(R.id.DangerOptions)
            val danger = if (dangerGroup.checkedRadioButtonId != -1)
                findViewById<RadioButton>(dangerGroup.checkedRadioButtonId).text.toString()
            else
                "Unknown"

            val safetyGroup = findViewById<RadioGroup>(R.id.SafetyOptions)
            val safety = if (safetyGroup.checkedRadioButtonId != -1)
                findViewById<RadioButton>(safetyGroup.checkedRadioButtonId).text.toString()
            else
                "Unknown"

            val othersGroup = findViewById<RadioGroup>(R.id.OthersOptions)
            val others = if (othersGroup.checkedRadioButtonId != -1)
                findViewById<RadioButton>(othersGroup.checkedRadioButtonId).text.toString()
            else
                "Unknown"

            val ageGroup = findViewById<RadioGroup>(R.id.AgeOptions)
            val age = if (ageGroup.checkedRadioButtonId != -1)
                findViewById<RadioButton>(ageGroup.checkedRadioButtonId).text.toString()
            else
                "Unknown"

            //Form Script
            val script = """
                Hello, my name is $name.
                I am $age.
                I am a $gender. 
                I am currently at $address.
                I am reporting a $callType incident.
                Current condition of Victim: $emergencyDetails
                Am I in Immediate danger? $danger. 
                Are others affected? $others. 
                Details about others: $othersDetails.
                Other Details: $otherDetails.
                """.trimIndent()

            //Pass script to call page
            val intent = Intent(this, CallPage::class.java)
            intent.putExtra("script", script)
            startActivity(intent)
        }
        val backButton: Button = findViewById(R.id.btn_back)
        backButton.setOnClickListener {
            finish()
        }
    }

//    override fun onClick(v: View?) {
//        // Optionally handle other clicks here later
//    }
//    }

}