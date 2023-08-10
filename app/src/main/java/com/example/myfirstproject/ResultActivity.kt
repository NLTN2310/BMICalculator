package com.example.myfirstproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassification = findViewById<TextView>(R.id.textview_classification)

        val result = intent.getFloatExtra("EXTRA_RESULT",0.1f)

        tvResult.text = result.toString()

        val classification = if(result <= 18.5f){
            "UNDERWEIGHT"
        }else if (result in 18.6f..24.9f){
            "HEALTHY WEIGHT"
        }else if (result in 25f..29.9f){
            "OVERWEIGHT"
        }else if(result in 30f..39.9f){
            "OBESITY"
        }else {
            "SEVERE OBESITY"
        }


        tvClassification.text = getString(R.string.message_classification, classification)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}