package com.imccalcul.caculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import com.github.calculatorimcc.R


class resultMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tv_clasificacion = findViewById<TextView>(R.id.tv_clasificacion)
        val tvActivy = findViewById<TextView>(R.id.tv_activyResult)

        val result = intent.getFloatExtra("CALCULATOR", 0.1f)

        tvActivy.text = result.toString()

        var clasificacion = "Clasificación: "

        if (result < 18.5f) {
            clasificacion = "Bajo de peso"

        } else if (result >= 18.5f && result <= 24.9f) {
            clasificacion += "Normal"
        } else if (result >= 25f && result <= 29.9f) {
            clasificacion += "Sobrepeso"
        }else if (result >= 30f && result <= 39.9f) {
            clasificacion += "Obesidad"
        }else {
            clasificacion += "Obesidad grave"
        }
        tv_clasificacion.text = clasificacion.toString()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        finish()
        return super.onOptionsItemSelected(item)
    }
}