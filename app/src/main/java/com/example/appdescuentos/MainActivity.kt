package com.example.appdescuentos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.appdescuentos.ui.theme.AppDescuentosTheme
import com.example.appdescuentos.viewModels.CalcularViewModel1
import com.example.appdescuentos.viewModels.CalcularViewModel2
import com.example.appdescuentos.viewModels.CalcularViewModel3
import com.example.appdescuentos.views.HomeView
import com.example.appdescuentos.views.HomeView2
import com.example.appdescuentos.views.HomeView3

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //val viewModel: CalcularViewModel1 by viewModels()
        //val viewModel: CalcularViewModel2 by viewModels()
        val viewModel: CalcularViewModel3 by viewModels()

        setContent {
            AppDescuentosTheme {
                
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //HomeView(viewModel = viewModel)
                    //HomeView2(viewModel = viewModel)
                    HomeView3(viewModel = viewModel)
                }
            }
        }
    }
}
