package com.hachatml.jjahcalc

/**
 * Calcula las operaciones matemáticas básicas
 */
class Calculo(
    /**
     * primer número de la operación
     */
    var num1: Float = 0f,
    /**
     * segundo número de la operación
     */
    var num2: Float = 0f,
    Operacion: Int = 0
) {
    /**
     * Resultado de la operación
     */
    var resultado: Float = 0.0f

    /**
     * Operación realizada
     * 0: Suma
     * 1: Resta
     * 2: Multiplicación
     * 3: División
     * 4: Sin operación seleccionada
     */
    var operacion: Int = Operacion

    /**
     * Método general que llama a otros para calcular las operaciones
     */
    fun calcular(op: Int) {
        when (op) {
            0 -> sumar(this.num1, this.num2)
            1 -> restar(this.num1, this.num2)
            2 -> multiplicar(this.num1, this.num2)
            3 -> dividir(this.num1, this.num2)
        }
    }

    /**
     * Operación básica de suma
     */
    fun sumar(num1: Float, num2: Float) {
        this.resultado = num1 + num2
    }
    /**
     * Operación básica de resta
     */
    fun restar(num1: Float, num2: Float) {
        this.resultado = num1 - num2
    }
    /**
     * Operación básica de multiplicación
     */
    fun multiplicar(num1: Float, num2: Float) {
        this.resultado = num1 * num2
    }
    /**
     * Operación básica de división
     */
    fun dividir(num1: Float, num2: Float) {
        this.resultado = num1 / num2
    }

    /**
     * Limpiar el objeto para realizar otro cálculo
     */
    fun clear() {
        num1 = 0f
        num2 = 0f
        operacion = 0
        resultado = 0f
    }
}
