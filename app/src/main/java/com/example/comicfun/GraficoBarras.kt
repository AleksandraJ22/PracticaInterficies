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


   var btnGenerarPdf = findViewById<Button>(R.id.btnExportar)

        if(checkPermission()) {
            Toast.makeText(this, "Permiso Aceptado", Toast.LENGTH_LONG)
        } else {
            requestPermissions()
        }

        btnGenerarPdf.setOnClickListener(View.OnClickListener {
            generarPdf()
        })
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
       val db2 = db.writableDatabase



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


    fun generarPdf() {

        var pdfDocument = PdfDocument()
        var paint = Paint()
        var titulo = TextPaint()
        var descripcion = TextPaint()

        var paginaInfo = PdfDocument.PageInfo.Builder(816, 1054, 1).create()
        var pagina1 = pdfDocument.startPage(paginaInfo)

        var canvas = pagina1.canvas

        var bitmap = BitmapFactory.decodeResource(resources, R.drawable.logo)
        var bitmapEscala = Bitmap.createScaledBitmap(bitmap, 80,80, false)
        canvas.drawBitmap(bitmapEscala, 368f, 20f, paint)

        titulo.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD))
        titulo.textSize = 20f

        canvas.drawText(tituloText, 10f, 150f, titulo)

        descripcion.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL))
        descripcion.textSize = 14f
        var descripcionText =  "Lunes: " + listaRegistros[0] + "usuarios activos\n" +
                "Martes: " + listaRegistros[1] + "usuarios activos \n" +
                "Miercoles: " + listaRegistros[2] + "usuarios activos \n" +
                "Jueves: " + listaRegistros[3] + "usuarios activos \n" +
                "Viernes: " + listaRegistros[4] + "usuarios activos \n"
               ;
        var arrDescripcion = descripcionText.split("\n")

        var y = 200f
        for (item in arrDescripcion) {
            canvas.drawText(item, 10f, y, descripcion)
            y += 15
        }

        pdfDocument.finishPage(pagina1)

        val file = File(Environment.getExternalStorageDirectory(), "comicFunInforme.pdf")

        try {
            pdfDocument.writeTo(FileOutputStream(file))
            Toast.makeText(this, "Se creo el PDF correctamente", Toast.LENGTH_LONG).show()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        pdfDocument.close()

    }

    private fun checkPermission(): Boolean {
        val permission1 = ContextCompat.checkSelfPermission(applicationContext,android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
        val permission2 = ContextCompat.checkSelfPermission(applicationContext, android.Manifest.permission.READ_EXTERNAL_STORAGE)
        return permission1 == PackageManager.PERMISSION_GRANTED && permission2 == PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermissions() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE),
            200
        )
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 200) {
            if(grantResults.size > 0) {
                val writeStorage = grantResults[0] == PackageManager.PERMISSION_GRANTED
                val readStorage = grantResults[1] == PackageManager.PERMISSION_GRANTED

                if(writeStorage && readStorage) {
                    Toast.makeText(this, "Permisos concedidos", Toast.LENGTH_LONG)
                } else {
                    Toast.makeText(this, "Permisos rechazados", Toast.LENGTH_LONG)
                    finish()
                }
            }
        }
    }

}


