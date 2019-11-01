package com.example.mygeaficavtas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun graficaClic(v:View){

        val intGraf = Intent(this,MainActivityGrafica::class.java)
        startActivity(intGraf)

    }
    fun Guardarclic(v:View){
        if(etNom.text.isEmpty() || etVtas.text.isEmpty()){
            Toast.makeText(this,"Falta informacion de capturar",Toast.LENGTH_SHORT).show()
            etNom.requestFocus()
        }else{
            val admin = AdminBD(this)
            val nom = etNom.text.toString()
            val vta = etVtas.text.toString().toFloat()
            val sentenci = "Insert Into Empleado(NomEmp,Ventas) values('${nom}','${vta}')"
            if (admin.Ejecuta(sentenci) == 1){
                Toast.makeText(this,"Empleado Guardado",Toast.LENGTH_SHORT).show()
                etNom.setText("")
                etVtas.setText("0")
                etNom.requestFocus()
            }else{
                Toast.makeText(this,"Errorde capa 8",Toast.LENGTH_SHORT).show()

            }
        }
    }
}
