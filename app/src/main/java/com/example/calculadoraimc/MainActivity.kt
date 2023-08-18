package com.example.calculadoraimc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editWeight: EditText = findViewById(R.id.editWeight)
        val editHeight: EditText = findViewById(R.id.editHeight)
        val btnCalc: Button = findViewById(R.id.btnCalc)

        btnCalc.setOnClickListener {
            val weight = editWeight.text.toString().toDoubleOrNull() ?: 0.0
            val height = editHeight.text.toString().toDoubleOrNull() ?: 0.0
            if(weight == 0.0) Toast.makeText(this, this.getString(R.string.nullWeight), Toast.LENGTH_LONG).show()
            else if(height == 0.0) Toast.makeText(this, this.getString(R.string.nullHeight), Toast.LENGTH_LONG).show()
            else {
                val bmi = weight / (height * height)
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("bmi", bmi)
                startActivity(intent)
            }
        }

    }
}