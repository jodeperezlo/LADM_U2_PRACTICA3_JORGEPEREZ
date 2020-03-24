package mx.edu.ittepic.ladm_u2_practica3_jorgeperez

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // VARIABLES GENERALES
    var jugador = 0
    var ronda = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // OYENTE PARA EL CLIC DEL BOTÓN
        button.setOnClickListener{
            var hilo = Hilo(this)
            hilo.start()
            button.visibility = View.INVISIBLE // UNA VEZ CLICKEADO, DESAPARECE EL BOTÓN
        }

    }
    // FUNCIÓN PARA MOSTRAR AL GANADOR DEL JUEGO
    fun mensaje(m: String){
        AlertDialog.Builder(this)
            .setTitle("ATENCIÓN")
            .setMessage("EL GANADOR ES: " + m)
            .setPositiveButton("OK"){p, i ->}
            .show()
    }
}
