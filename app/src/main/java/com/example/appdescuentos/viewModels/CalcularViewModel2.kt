package com.example.appdescuentos.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalcularViewModel2: ViewModel() {

    var precio by mutableStateOf("")
        private set
    var descuento by mutableStateOf("")
        private set
//    fun onValuePrecio(value: String){
//        precio = value
//    }
//    fun onValueDescuento(value: String){
//        descuento = value
//    }

    fun onValue(value: String, text: String){
        when(text){
            "prec" -> precio = value
            "desc" -> descuento = value
        }
    }


    var precioDescuento by mutableStateOf(0.0)
        private set
    var totalDescuento by mutableStateOf(0.0)
        private set
    var showAlert by mutableStateOf(false)
    private set

    fun calcular(){

        if(precio != "" && descuento != ""){
            precioDescuento = calcularTotal(precio.toDouble(), descuento.toDouble())
            totalDescuento = calcularDescuento(precio.toDouble(), descuento.toDouble())
        }else{
            showAlert = true
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
        precio = ""
        descuento = ""
        precioDescuento = 0.0
        totalDescuento = 0.0
    }

    fun cancelAlert(){
        showAlert = false
    }
}