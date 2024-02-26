package com.example.ejercicio01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View;
import android.widget.ArrayAdapter
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var edtNumero1 : EditText
    lateinit var edtNumero2 : EditText
    lateinit var btnSumar : Button
    lateinit var txtResultado : TextView
    lateinit var operadores_spinner : Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtNumero1 = findViewById(R.id.edtNumero1)
        edtNumero2 = findViewById(R.id.edtNumero2)
        btnSumar = findViewById(R.id.btnSumar)
        txtResultado = findViewById(R.id.txtResultado)
        operadores_spinner = findViewById(R.id.operadores_spinner)

        var operaciones = arrayOf("Sumar", "Restar", "Multiplicar", "Dividir")

        val adaptador = ArrayAdapter(this,android.R.layout.simple_list_item_1, operaciones)

        operadores_spinner.setAdapter(adaptador)

        btnSumar.setOnClickListener(View.OnClickListener {
            var operacion = operadores_spinner.selectedItem.toString()

            val num1 = edtNumero1.text.toString().toDouble()
            val num2 = edtNumero2.text.toString().toDouble()

            if (operacion.equals("Sumar")){
                txtResultado.setText("Resultado: " + sumar(num1, num2))
            }
            else if (operacion.equals("Restar")){
                txtResultado.setText("Resultado: " + restar(num1, num2))
            }
            else if (operacion.equals("Multiplicar")){
                txtResultado.setText("Resultado: " + multiplicar(num1, num2))
            }
            else if (operacion.equals("Dividir")){
                txtResultado.setText("Resultado: " + dividir(num1, num2))
            }
        })
    }
    fun sumar(numero1: Double, numero2: Double) : Double {

        return numero1 + numero2
    }

    fun restar(numero1: Double, numero2: Double) : Double {

        return numero1 - numero2
    }

    fun multiplicar(numero1: Double, numero2: Double) : Double {

        return numero1 * numero2
    }

    fun dividir(numero1: Double, numero2: Double) : Double {

        return numero1 / numero2
    }
}