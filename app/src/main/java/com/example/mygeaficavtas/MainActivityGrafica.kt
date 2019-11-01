package com.example.mygeaficavtas

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import kotlinx.android.synthetic.main.activity_main_grafica.*

class MainActivityGrafica : AppCompatActivity() {
    val entries = ArrayList<BarEntry>()
    val labels = ArrayList<String>()
    var cursor : Cursor? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_grafica)
        cargarDatos()
        setBarChart()
    }
    fun cargarDatos(){
        val admin = AdminBD(this)
        cursor=admin.consulta("Select * from Empleado Order by Ventas")
    }
// el cambio esta aqui
    fun setBarChart() {
        //Agregamos datos de tipo float, en el primer paramtro
        // se indica el angulo de las Y y en en
        // segundo parametro el lado de X
        var i = 0
        if (cursor!!.moveToFirst()){
            do {
                val nom = cursor!!.getString(1)
                val vtas = cursor!!.getFloat(2)
                entries.add(BarEntry(vtas, i))
                labels.add(nom)
                i++
            }while (cursor!!.moveToNext())
            val barDataSet = BarDataSet(entries, "Datos")
            val data = BarData(labels, barDataSet)
            barChart.data = data
            barChart.setDescription("Graficas Ejemplo")
            barDataSet.color = resources.getColor(R.color.colorAccent)
            barChart.animateY(5000)

        }

    }

}
