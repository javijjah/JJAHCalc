package com.hachatml.jjahcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity(), View.OnClickListener {
    /**
     * El obj Cálculo se encarga de todo_lo que conlleve el cálculo de las operaciones matemáticas
     */
    var calc1: Calculo = Calculo(0f, 0f, 0)

    /**
     * Numtemp almacena como String los números que va pulsando el usuario,
     * que cambia entre num1 o num2 al pulsar un botón de operación
     */
    var numtemp = ""

    // Nuestros TextView, uno para el número actual y otro para la solución final del cálculo
    lateinit var solutionTV: TextView
    lateinit var numbersTV: TextView
    var op: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //aquí en el onCreate sincronizo todos los botones al listener general que he creado
        //más sobre mi approach en el onClick
        solutionTV = findViewById<TextView>(R.id.solution)
        numbersTV = findViewById<TextView>(R.id.Numbers)
        findViewById<Button>(R.id.button_1).setOnClickListener(this)
        findViewById<Button>(R.id.button_2).setOnClickListener(this)
        findViewById<Button>(R.id.button_3).setOnClickListener(this)
        findViewById<Button>(R.id.button_4).setOnClickListener(this)
        findViewById<Button>(R.id.button_5).setOnClickListener(this)
        findViewById<Button>(R.id.button_6).setOnClickListener(this)
        findViewById<Button>(R.id.button_7).setOnClickListener(this)
        findViewById<Button>(R.id.button_8).setOnClickListener(this)
        findViewById<Button>(R.id.button_9).setOnClickListener(this)
        findViewById<Button>(R.id.button_0).setOnClickListener(this)
        findViewById<Button>(R.id.button_mas).setOnClickListener(this)
        findViewById<Button>(R.id.button_menos).setOnClickListener(this)
        findViewById<Button>(R.id.button_mult).setOnClickListener(this)
        findViewById<Button>(R.id.button_div).setOnClickListener(this)
        findViewById<Button>(R.id.button_igual).setOnClickListener(this)
        findViewById<Button>(R.id.button_D).setOnClickListener(this)
    }

    //mi approach ha sido el de no crear variables por botón sino que todos apunten directamente
    //al onClick general, el cual por ID activa un switch ya que todas las órdenes a ejecutar
    //son bastante simples y llaman directamente al objeto
    override fun onClick(view: View?) {
        when (view?.id) {
            //antes la operación numbersTV.text = numtemp la ejecutaba al final del when por
            // limpieza de código, pero con tal de añadir la funcionalidad de ver la operación
            // ejecutada al darle al igual, fue añadido por caso, pero esto no debería afectar al
            // rendimiento ya que solo se ejecuta 1 vez por botón igualmente
            R.id.button_1 -> {
                numtemp += "1"
                numbersTV.text = numtemp
            }

            R.id.button_2 -> {
                numtemp += "2"
                numbersTV.text = numtemp
            }

            R.id.button_3 -> {
                numtemp += "3"
                numbersTV.text = numtemp
            }

            R.id.button_4 -> {
                numtemp += "4"
                numbersTV.text = numtemp

            }

            R.id.button_5 -> {
                numtemp += "5"
                numbersTV.text = numtemp
            }

            R.id.button_6 -> {
                numtemp += "6"
                numbersTV.text = numtemp

            }

            R.id.button_7 -> {
                numtemp += "7"
                numbersTV.text = numtemp

            }

            R.id.button_8 -> {
                numtemp += "8"
                numbersTV.text = numtemp
            }

            R.id.button_9 -> {
                numtemp += "9"
                numbersTV.text = numtemp
            }

            R.id.button_0 -> {
                numtemp += "0"
                numbersTV.text = numtemp
                //hola
            }
            //en las operaciones de cálculo volcamos la info de numtemp en num1 y lo reiniciamos,
            //y cogemos un valor de Int dependiendo de la operación.
            //también, si numtemp está vacío, implica que el string está vacío, y que no se
            //ha introducido ningún número.
            R.id.button_mas -> {
                if (op != "" && numtemp != "") {
                    numtemp = ""
                    calc1.operacion = 0
                    op = "+"
                } else {
                    try {
                        calc1.num1 = numtemp.toFloat()
                    } catch (ex: NumberFormatException) {
                        Toast.makeText(
                            this,
                            "Por favor, introduzca dos números y una operación",
                            Toast.LENGTH_SHORT
                        ).show()
                        //limpiamos todo_
                        calc1.clear()
                        numtemp = ""
                    }
                    numtemp = ""
                    calc1.operacion = 0
                    op = "+"
                    numbersTV.text = numbersTV.text.toString() + op
                }
            }
            R.id.button_menos -> {
                if (op != "" && numtemp != "") {
                    numtemp = ""
                    calc1.operacion = 1
                    op = "-"
                } else {
                    try {
                        calc1.num1 = numtemp.toFloat()
                    } catch (ex: NumberFormatException) {
                        Toast.makeText(
                            this,
                            "Por favor, introduzca dos números y una operación",
                            Toast.LENGTH_SHORT
                        ).show()
                            //limpiamos todo_
                        calc1.clear()
                        numtemp = ""
                    }
                    numtemp = ""
                    calc1.operacion = 1
                    op = "-"
                    numbersTV.text = numbersTV.text.toString() + op
                }
            }
            //**OPCIONAL SI OS VIENE BIEN PARA VUESTRA LÓGICA** Si pulsamos el
            //símbolo = y todo_ es correcto, es decir, tenemos los dos números y la operación,
            //realizaremos el cálculo, lo asignaremos al resultado e inicializaremos num1
            //= 0, num2 = 0 y operacion = "".
            R.id.button_mult -> {
                if (op != "" && numtemp != "") {
                    numtemp = ""
                    calc1.operacion = 2
                    op = "*"
                } else {
                    try {
                        calc1.num1 = numtemp.toFloat()
                    } catch (ex: NumberFormatException) {
                        Toast.makeText(
                            this,
                            "Por favor, introduzca dos números y una operación",
                            Toast.LENGTH_SHORT
                        ).show()
                        calc1.clear()
                        numtemp = ""
                    }
                    numtemp = ""
                    calc1.operacion = 2
                    op = "*"
                    numbersTV.text = numbersTV.text.toString() + op
                }
            }
            R.id.button_div -> {
                if (op != "" && numtemp != "") {
                    numtemp = ""
                    calc1.operacion = 3
                    op = "/"
                } else {
                    try {
                        calc1.num1 = numtemp.toFloat()
                    } catch (ex: NumberFormatException) {
                        Toast.makeText(
                            this,
                            "Por favor, introduzca dos números y una operación",
                            Toast.LENGTH_SHORT
                        ).show()
                        calc1.clear()
                        numtemp = ""
                    }

                    numtemp = ""
                    calc1.operacion = 3
                    op = "/"
                    numbersTV.text = numbersTV.text.toString() + op
                }
            }
            //en igual mandaríamos a ejecutar el cálculo, además de comprobar si ambos números
            //son enteros para devolverlos sin decimales.
            R.id.button_igual -> {
                try {
                    calc1.num2 = numtemp.toFloat()
                } catch (ex: NumberFormatException) {
                    Toast.makeText(
                        this,
                        "Por favor, introduzca dos números y una operación",
                        Toast.LENGTH_SHORT
                    ).show()
                    calc1.clear()
                    numtemp = ""
                }
                calc1.calcular(calc1.operacion).toString()
                if (calc1.resultado % 1 != 0f) {
                    solutionTV.text = calc1.resultado.toString()
                } else {
                    solutionTV.text = (calc1.resultado.toInt()).toString()
                }
                if (calc1.num1 % 1 == 0f && calc1.num2 % 1 == 0f) {
                    numbersTV.text =
                        (calc1.num1.toInt()).toString() + op + (calc1.num2.toInt()).toString()
                } else {
                    numbersTV.text = (calc1.num1).toString() + op + (calc1.num2).toString()
                }
            }
            //esto reinicia todos los campos que son utilizados al calcular un número
            R.id.button_D -> {
                numtemp = ""
                calc1.clear()
                solutionTV.text = ""
                numbersTV.text = ""
                op = ""
            }
        }
    }
}
