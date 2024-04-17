package com.example.comicfun

import android.content.ContentValues
import android.content.Context
import android.graphics.Bitmap
import android.media.Image
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.utils.ColorTemplate
import com.example.comicfun.AdminSQLiteOpenHelper
import com.example.comicfun.data.Registros
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.Utils
import org.w3c.dom.Document
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import com.github.mikephil.charting.*

import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.content.pm.PackageManager

import android.graphics.BitmapFactory
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.pdf.PdfDocument


import android.text.TextPaint
import android.view.View

import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import java.io.IOError
import java.lang.Exception

class GraficoBarras : AppCompatActivity(){
    var tituloText = "Informe Semanal"
    val db = DBHandler(this)


    lateinit var context: Context
    lateinit var grafica: BarChart

    val listaRegistros: MutableList<Registros>  = ArrayList()
   val  entradas: MutableList<BarEntry>  = ArrayList()
val btn_exportar: Button = findViewById(R.id.btnExportar)


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.grafico)
        context=this
        val grafica = findViewById<BarChart>(R.id.graficaBarrast)

        val dias: Array<String> = arrayOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes")

        val registros: Array<String> = arrayOf("100", "22", "35", "600", "87")

     insertarRegistros(dias,registros)
        obtenerRegistros()

        for (registro in listaRegistros) {
            entradas.add(BarEntry( registro.idRegistro.toFloat(), registro.totalRegistros.toFloat()))

        }

        val datos: BarDataSet = BarDataSet(entradas,"GRAFICA DE REGISTROS");
val data: BarData = BarData(datos);

        //datos.setColors(ColorTemplate.COLORFUL_COLORS);
        data.barWidth = 0.9f;
        grafica.setData(data);
        grafica.setFitBars(true);
        grafica.invalidate();



    }


    fun insertarRegistros(dias: Array<String>, registros: Array<String>) {
        //  val meh= DBHandler(this)
        //val admin = AdminSQLiteOpenHelper(context, "dbSistema", null, 1)
        val db2 = db.writableDatabase
        val values = ContentValues()

        for (i in dias.indices) {
            values.put("dia", dias[i])
            values.put("totalRegistros", registros[i])
            db2.insert("registros", null, values)
        }

        db2.close()



    }
    fun obtenerRegistros()
    {

        listaRegistros.clear();
        // val admin = AdminSQLiteOpenHelper(context, "dbSistema", null, 1)
        val db2 = db.readableDatabase
        val fila = db2.rawQuery("select * from registros", null);
        if (fila != null && fila.count != 0) {
            fila.moveToFirst()
            do {
                listaRegistros.add(
                    Registros(
                        fila.getString(0),
                        fila.getString(1),
                        fila.getString(2)
                    )
                )
            } while (fila.moveToNext())


        } else {
            Toast.makeText(context, "NO HAY REGISTROS", Toast.LENGTH_SHORT).show()
        }
        db2.close()


    }

}


