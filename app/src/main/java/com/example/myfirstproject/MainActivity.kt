package com.example.myfirstproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //encontrar a view que está no activity_main através do id
        val btnCalculate: Button = findViewById(R.id.btnCalculate)
        val edtWeight: EditText = findViewById(R.id.edittext_weight)
        val edtHeight: EditText = findViewById(R.id.edittext_height)

        btnCalculate.setOnClickListener {

            val heightStr = edtHeight.text.toString()
            val weightStr = edtWeight.text.toString()

            if(heightStr.isNotEmpty() && weightStr.isNotEmpty()) {
                val height: Float = heightStr.toFloat()
                val weight: Float = weightStr.toFloat()

                val finalHeight: Float = height * height
                val result: Float = weight / finalHeight

                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", result)
                    }
                startActivity(intent)
            }else {
                Toast.makeText(this, "Fill in all spaces in blank", Toast.LENGTH_SHORT).show()
            }

        }
    }
}