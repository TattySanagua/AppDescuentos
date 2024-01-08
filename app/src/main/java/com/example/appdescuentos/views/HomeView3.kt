package com.example.appdescuentos.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.appdescuentos.components.Alert
import com.example.appdescuentos.components.MainButton
import com.example.appdescuentos.components.MainTextField
import com.example.appdescuentos.components.SpaceH
import com.example.appdescuentos.components.TwoCard
import com.example.appdescuentos.viewModels.CalcularViewModel1
import com.example.appdescuentos.viewModels.CalcularViewModel2
import com.example.appdescuentos.viewModels.CalcularViewModel3

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView3(viewModel: CalcularViewModel3){
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "App Descuentos")},
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ){
        ContentHomeView3(it, viewModel)
    }
}

@Composable
fun ContentHomeView3(paddingValues: PaddingValues, viewModel: CalcularViewModel3){
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val state = viewModel.state
        TwoCard(
            title1 = "Total",
            number1 = state.totalDescuento,
            title2 = "Descuento",
            number2 = state.precioDescuento)

        MainTextField(
            value = state.precio,
            onValueChange = {viewModel.onValue(it, "prec")},
            label = "Precio")
        SpaceH()
        MainTextField(
            value = state.descuento,
            onValueChange = {viewModel.onValue(it, "desc")},
            label = "Descuento %")
        SpaceH(10.dp)
        MainButton(text = "Generar descuento") {
            viewModel.calcular()
        }
        SpaceH()
        MainButton(text = "Limpiar", color = Color.Blue) {
            viewModel.limpiar()
        }
        if(state.showAlert){
            Alert(
                title = "Alerta",
                message = "Debe ingresar el precio y el porcentaje de descuento",
                confirmText = "Aceptar",
                onConfirmClick = { viewModel.cancelAlert() }) {

            }
        }
    }
}