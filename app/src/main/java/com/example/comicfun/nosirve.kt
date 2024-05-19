/*


import android.graphics.Color
import android.view.Gravity
import android.widget.FrameLayout
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

private fun showCustomSnackbar() {
    val snackbar = Snackbar.make(
        findViewById(android.R.id.content),
        "Ahora dale a 'OK' ",
        Snackbar.LENGTH_LONG
    )


    val snackbarView = snackbar.view

    // Cambiar el color de fondo del Snackbar
    //  snackbarView.setBackgroundColor(Color.BLUE) // Puedes usar cualquier color que desees

    // Personalizar el texto del Snackbar
    val snackbarText =
        snackbarView.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
    snackbarText.setTextColor(Color.BLACK) // Cambiar el color del texto
    snackbarText.setTextSize(18f)

    //snackbarText.setBackgroundColor(Color.WHITE)

    // Personalizar la posición del Snackbar
    val params = snackbarView.layoutParams
    if (params is FrameLayout.LayoutParams) {
        val frameParams = params
        frameParams.gravity = Gravity.TOP
        snackbarView.layoutParams = frameParams
    }
    snackbar.show()
}


*/