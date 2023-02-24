package com.imccalcul.caculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.github.calculatorimcc.R


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val tvInformation = findViewById<TextView>(R.id.tvInformation)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val etPeso = findViewById<EditText>(R.id.etPeso)
        val etAltura = findViewById<EditText>(R.id.etAltura)




        btnCalcular.setOnClickListener {

            val alturaStr = etAltura.text.toString()

            val pesoStr = etPeso.text.toString()

            if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {
                val altura = alturaStr.toFloat()
                val alturaFinal = altura * altura
                val peso = pesoStr.toFloat()
                val result = peso / alturaFinal

                tvInformation.text = result.toString()



                val intent = Intent(this, resultMainActivity::class.java)

                    .apply {
                        putExtra("CALCULATOR", result)

                    }
                startActivity(intent)
            } else {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }


    }
}