package com.example.comicfun

import android.Manifest
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.pdf.PdfDocument
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.text.TextPaint
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.comicfun.data.Registros
import com.github.mikephil.charting.data.BarEntry
import java.io.File
import java.io.FileOutputStream
import java.lang.Exception

class MainActivity : AppCompatActivity() {


    private lateinit var dbHandler: DBHandler
   // private lateinit var textViewToggle: TextView
   // private lateinit var buttonToggle: Button
    //private val sharedPreferences by lazy { getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE) }

    /*companion object {
        private const val PREFS_NAME = "TogglePrefs"
        private const val TEXT_VISIBLE_KEY = "textVisible"
    }*/
    //val db = DBHandler(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        dbHandler=DBHandler(this)
       // dbHandler.onCreate(dbHandler.writableDatabase)
       // dbHandler.insertDataTablaPersonajes();

        super.onCreate(savedInstanceState)
        setContentView(R.layout.pantalla_inicio)
     /*   val btn_generar_pdf : Button = findViewById(R.id.btn_pdf)

        btn_generar_pdf.setOnClickListener {
        }*/

      /*  textViewToggle = findViewById(R.id.textViewToggle)
        buttonToggle = findViewById(R.id.buttonToggle)

        val isTextVisible = sharedPreferences.getBoolean(TEXT_VISIBLE_KEY, false)
        textViewToggle.visibility = if (isTextVisible) View.VISIBLE else View.GONE

        buttonToggle.setOnClickListener {
            if (textViewToggle.visibility == View.GONE) {
                textViewToggle.visibility = View.VISIBLE
                saveTextVisibility(true)
            } else {
                textViewToggle.visibility = View.GONE
                saveTextVisibility(false)
            }
        }*/
        val btn_registro : Button = findViewById(R.id.button3)
        btn_registro.setOnClickListener{

            irAPoliticaDePrivacidad()

        }
    }

   /* private fun saveTextVisibility(isVisible: Boolean) {
        sharedPreferences.edit().putBoolean(TEXT_VISIBLE_KEY, isVisible).apply()
    }*/

    fun signIn(view: View){
        val intent= Intent(this, iniciar_sesion::class.java).apply{}
        startActivity(intent);

    }

    fun irAPoliticaDePrivacidad(){

        val intent= Intent(this,politicaPrivacidad::class.java).apply{}
        startActivity(intent);

    }



fun verGrafico(view:View){

    val intent= Intent(this,GraficoBarras::class.java).apply{}
    startActivity(intent);

}


    fun verExplicacion(view: View?){

        val intent= Intent(this,pantalla_explicacion_app::class.java).apply{}
        startActivity(intent);

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_ver_explicacion, menu)
        return true
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == R.id.Explicación_app) {
            verExplicacion(null)
            return true
        }


        return super.onOptionsItemSelected(item)
    }


}

/*
import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.Manifest.permission.WRITE_EXTERNAL_STORAGE
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Paint
import android.graphics.Typeface
import android.graphics.pdf.PdfDocument
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.text.TextPaint
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.File
import java.io.FileOutputStream
import java.io.IOError
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    var tituloText = "Informe comicFun"
    val dias: Array<String> = arrayOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes")

    val registros: Array<String> = arrayOf("100", "22", "35", "600", "87")

    var descripcionText =dias[0]+": " + registros[0] + "usuarios activos\n" +
            dias[1]+": "+ registros[1] + "usuarios activos \n" +
            dias[2]+": " + registros[2] + "usuarios activos \n" +
            dias[3]+": "+ registros[3] + "usuarios activos \n" +
            dias[4]+": " +registros[4] + "usuarios activos \n"
            ;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pdf)

        var btnGenerarPdf = findViewById<Button>(R.id.btn_pdf)

        if(checkPermission()) {
            Toast.makeText(this, "Permiso Aceptado", Toast.LENGTH_LONG)
        } else {
            requestPermissions()
        }

        btnGenerarPdf.setOnClickListener(View.OnClickListener {
            generarPdf()
        })
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

        var arrDescripcion = descripcionText.split("\n")

        var y = 200f
        for (item in arrDescripcion) {
            canvas.drawText(item, 10f, y, descripcion)
            y += 15
        }

        pdfDocument.finishPage(pagina1)

        val file = File(Environment.getExternalStorageDirectory(), "Informe_comicFun.pdf")
        try {
            pdfDocument.writeTo(FileOutputStream(file))
            Toast.makeText(this, "Se creo el PDF correctamente", Toast.LENGTH_LONG).show()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        pdfDocument.close()

    }

    private fun checkPermission(): Boolean {
        val permission1 = ContextCompat.checkSelfPermission(applicationContext, WRITE_EXTERNAL_STORAGE)
        val permission2 = ContextCompat.checkSelfPermission(applicationContext, READ_EXTERNAL_STORAGE)
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
}*/