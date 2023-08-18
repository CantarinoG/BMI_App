package com.example.calculadoraimc

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val bmi = intent.getDoubleExtra("bmi", 0.0)

        val txtBmi: TextView = findViewById(R.id.txtBmi)
        val txtResult: TextView = findViewById(R.id.txtResult)
        val imgResult: ImageView = findViewById<ImageView>(R.id.imgResult)
        val btnBack: ImageButton = findViewById(R.id.btnBack)
        val btnInfo: ImageButton = findViewById(R.id.btnInfo)

        btnBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        lateinit var alertDialog: AlertDialog
        val builder = AlertDialog.Builder(this)
        builder.setTitle(R.string.whatIsBmi)
        builder.setMessage(R.string.aboutBmi)
        builder.setPositiveButton("Ok") {_, _ ->
            alertDialog.dismiss()
        }
        builder.setNeutralButton(R.string.mainMenu) {_, _ ->
            Intent(applicationContext, MainActivity::class.java)
            finish()
        }
        alertDialog = builder.create()


        btnInfo.setOnClickListener {
            alertDialog.show()
        }

        txtBmi.text = String.format("%.1f", bmi)

        when {
            bmi < 16 -> {
                imgResult.setImageResource(R.drawable.magreza_grave)
                txtResult.text = getString(R.string.severeUnderweight)
                txtResult.setTextColor(Color.parseColor("#0C4D8B"))
                txtBmi.setTextColor(Color.parseColor("#0C4D8B"))
            }
            bmi >= 16 && bmi < 17 -> {
                imgResult.setImageResource(R.drawable.magreza_moderada)
                txtResult.text = getString(R.string.moderateUnderweight)
                txtResult.setTextColor(Color.parseColor("#0377BE"))
                txtBmi.setTextColor(Color.parseColor("#0377BE"))
            }
            bmi >= 17 && bmi < 18.5 -> {
                imgResult.setImageResource(R.drawable.abaixo_do_peso)
                txtResult.text = getString(R.string.underweight)
                txtResult.setTextColor(Color.parseColor("#64A2D7"))
                txtBmi.setTextColor(Color.parseColor("#64A2D7"))
            }
            bmi >= 18.5 && bmi < 25 -> {
                imgResult.setImageResource(R.drawable.saudavel)
                txtResult.text = getString(R.string.healthyWeight)
                txtResult.setTextColor(Color.parseColor("#66BB6A"))
                txtBmi.setTextColor(Color.parseColor("#66BB6A"))
            }
            bmi >= 25 && bmi < 30 -> {
                imgResult.setImageResource(R.drawable.sobrepeso)
                txtResult.text = getString(R.string.overweight)
                txtResult.setTextColor(Color.parseColor("#FFFFC400"))
                txtBmi.setTextColor(Color.parseColor("#FFFFC400"))
            }
            bmi >= 30 && bmi < 35 -> {
                imgResult.setImageResource(R.drawable.obesidade_grau_i)
                txtResult.text = getString(R.string.gradeIObesity)
                txtResult.setTextColor(Color.parseColor("#F2683C"))
                txtBmi.setTextColor(Color.parseColor("#F2683C"))
            }
            bmi >= 35 && bmi < 40 -> {
                imgResult.setImageResource(R.drawable.obesidade_grau_ii)
                txtResult.text = getString(R.string.gradeIIObesity)
                txtResult.setTextColor(Color.parseColor("#BE3A26"))
                txtBmi.setTextColor(Color.parseColor("#BE3A26"))
            }
            bmi >= 40 -> {
                imgResult.setImageResource(R.drawable.obesidade_grau_iii)
                txtResult.text = getString(R.string.gradeIIIObesity)
                txtResult.setTextColor(Color.parseColor("#861619"))
                txtBmi.setTextColor(Color.parseColor("#861619"))
            }
        }

    }
}