package mx.edu.ittepic.ladm_u2_practica3_jorgeperez

import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class Hilo(p: MainActivity): Thread(){
    // VARIABLES QUE SE NECESITAN
    var puntero = p // VARIABLE PUNTERO QUE HACE REFERENCIA AL MAINACTIVITY
    var ciclo = true // VARIABLE PARA EL CICLO DE LAS RONDAS
    var contador1 = 0 // CONTADOR DE PUNTOS DEL JUGADOR 1
    var contador2 = 0 // CONTADOR DE PUNTOS DEL JUGADOR 2
    var contador3 = 0 // CONTADOR DE PUNTOS DEL JUGADOR 3
    var contador4 = 0 // CONTADOR DE PUNTOS DEL JUGADOR 4

    var total = ArrayList<Int>() // ARREGLO PARA GUARDAR EL TOTAL DE PUNTOS
    var gana = "" // VARIABLE PARA GUARDAR AL GANADOR

    override fun run() {
        super.run()
        // WHEN PARA EL CICLO
        while (ciclo) {
            sleep(3000)
            puntero.runOnUiThread {
                // IF PARA MOSTRAR EL NÚMERO DE RONDA
                if(puntero.jugador == 4 ) {
                    puntero.jugador = 0
                    puntero.ronda++
                    puntero.lblronda.setText("RONDA: ${puntero.ronda}")
                    // IF PARA CUANDO HAYAN FINALIZADO LAS 4 RONDAS
                    if(puntero.ronda == 5){
                        ciclo = false
                        puntero.jug2.setText("Esperando..")
                        puntero.lblronda.setText("FINALIZÓ")
                    } // IF
                } // IF
                // MIENTRAS LA RONDA SEA MENOR O IGUAL A 4
                if(puntero.ronda <= 4) {
                    if (puntero.jugador == 0) {
                        puntero.jug1.setText("Jugando")
                        puntero.jug2.setText("Esperando..")
                        puntero.jug3.setText("Esperando..")
                        puntero.jug4.setText("Esperando..")
                    }
                    if (puntero.jugador == 1) {
                        puntero.jug1.setText("Esperando..")
                        puntero.jug2.setText("Jugando")
                        puntero.jug3.setText("Esperando..")
                        puntero.jug4.setText("Esperando..")
                    }
                    if (puntero.jugador == 2) {
                        puntero.jug1.setText("Esperando..")
                        puntero.jug2.setText("Esperando..")
                        puntero.jug3.setText("Jugando")
                        puntero.jug4.setText("Esperando..")
                    }
                    if (puntero.jugador == 3) {
                        puntero.jug1.setText("Esperando..")
                        puntero.jug2.setText("Esperando..")
                        puntero.jug3.setText("Esperando..")
                        puntero.jug4.setText("Jugando")
                    }

                    var d1= (1..6).random().toInt()
                    var d2 = (1..6).random().toInt()

                    // MOSTRAR EL DADO 1 CORRESPONDIENTE AL RANDOM
                    when(d1){
                        1->{
                            puntero.imageView15.setImageResource(R.drawable.dado6)
                        }
                        2->{
                            puntero.imageView15.setImageResource(R.drawable.dado5)
                        }
                        3->{
                            puntero.imageView15.setImageResource(R.drawable.dado4)
                        }
                        4->{
                            puntero.imageView15.setImageResource(R.drawable.dado3)
                        }
                        5->{
                            puntero.imageView15.setImageResource(R.drawable.dado2)
                        }
                        6->{
                            puntero.imageView15.setImageResource(R.drawable.dado1)
                        }
                    } // WHEN
                    // MOSTRAR EL DADO 2 CORRESPONDIENTE AL RANDOM
                    when(d2){
                        1->{
                            puntero.imageView16.setImageResource(R.drawable.dado6)
                        }
                        2->{
                            puntero.imageView16.setImageResource(R.drawable.dado5)
                        }
                        3->{
                            puntero.imageView16.setImageResource(R.drawable.dado4)
                        }
                        4->{
                            puntero.imageView16.setImageResource(R.drawable.dado3)
                        }
                        5->{
                            puntero.imageView16.setImageResource(R.drawable.dado2)
                        }
                        6->{
                            puntero.imageView16.setImageResource(R.drawable.dado1)
                        }
                    } // WHEN

                    if(puntero.jugador == 0){
                        contador1 += d1+d2
                        puntero.marcador1.setText("$contador1")
                    } // IF
                    if(puntero.jugador == 1) {
                        contador2 += d1 + d2
                        puntero.marcador2.setText("$contador2")
                    } // IF
                    if(puntero.jugador == 2){
                        contador3+=d1+d2
                        puntero.marcador3.setText("$contador3")
                    } // IF
                    if(puntero.jugador == 3){
                        contador4+=d1+d2
                        puntero.marcador4.setText("$contador4")
                    } // IF
                    sleep(1000)
                    puntero.jugador++
                } // IF
            } // RUNONIUTHREAD
        } // WHILE

        puntero.runOnUiThread {
            total.add(contador1)
            total.add(contador2)
            total.add(contador3)
            total.add(contador4)
            if (total[0] == total.max()) {
                puntero.mensaje("JUGADOR 1")
            }
            if (total[1] == total.max()) {
                puntero.mensaje("JUGADOR 2")
            }
            if (total[2] == total.max()) {
                puntero.mensaje("JUGADOR 3")
            }
            if (total[3] == total.max()) {
                puntero.mensaje("JUGADOR 4")
            }
        }
    }
}