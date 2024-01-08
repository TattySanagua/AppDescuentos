package com.example.appdescuentos.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.appdescuentos.models.CalcularState

class CalcularViewModel3: ViewModel() {

    var state by mutableStateOf(CalcularState())
        private set

    fun onValue(value: String, text: String){
        when(text){
            "prec" -> state = state.copy(precio = value)
            "desc" -> state = state.copy(descuento = value)
        }
    }

    fun calcular(){

        val precio = state.precio
        val descuento = state.descuento

        state = if(precio != "" && descuento != ""){
            state.copy(
                precioDescuento = calcularTotal(precio.toDouble(), descuento.toDouble()),
                totalDescuento = calcularDescuento(precio.toDouble(), descuento.toDouble())
            )

        }else{
            state.copy(showAlert = true)
        }
    }
    private fun calcularTotal(precio: Double, descuento: Double): Double{
        val result = precio - calcularDescuento(precio, descuento)
        return kotlin.math.round(result * 100)/100.0
    }

    private fun calcularDescuento(precio: Double, descuento: Double): Double{
        val result = precio * (1- descuento/100)
        return kotlin.math.round(result * 100)/100.0
    }

    fun limpiar(){
        state = state.copy(
            precio = "",
            descuento = "",
            precioDescuento = 0.0,
            totalDescuento = 0.0
        )
    }

    fun cancelAlert(){
        state = state.copy(showAlert = false)
    }
}