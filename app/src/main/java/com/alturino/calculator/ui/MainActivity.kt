package com.alturino.calculator.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.alturino.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Calculator {
                MainScreen()
            }
        }
    }
}

@Composable
fun Calculator(content: @Composable () -> Unit) {
    CalculatorTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background,
            content = content
        )
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier.fillMaxSize()) { innerPadding ->
        Column(modifier = Modifier.fillMaxSize().padding(innerPadding)) {
            Row(modifier = Modifier.fillMaxWidth().height(250.dp)) {
                OutlinedTextField(
                    modifier = Modifier.fillMaxSize(),
                    value = "",
                    onValueChange = {},
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Transparent,
                        unfocusedBorderColor = Color.Transparent,
                    )
                )
            }
            Row(modifier = Modifier.width(IntrinsicSize.Max).height(IntrinsicSize.Max)) {
                Box(modifier = Modifier.fillMaxSize().background(Color.Green)) {
                    Text("1")
                }
                Box(modifier = Modifier.fillMaxSize().background(Color.Green)) {
                    Text("2")
                }
                Box(modifier = Modifier.fillMaxSize().background(Color.Green)) {
                    Text("3")
                }
            }
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                FilledTonalButton(modifier = Modifier.weight(1f), onClick = {}) {
                    Text("4")
                }
                FilledTonalButton(modifier = Modifier.weight(1f), onClick = {}) {
                    Text("5")
                }
                FilledTonalButton(modifier = Modifier.weight(1f), onClick = {}) {
                    Text("6")
                }
            }
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                FilledTonalButton(modifier = Modifier.weight(1f), onClick = {}) {
                    Text("7")
                }
                FilledTonalButton(modifier = Modifier.weight(1f), onClick = {}) {
                    Text("8")
                }
                FilledTonalButton(modifier = Modifier.weight(1f), onClick = {}) {
                    Text("9")
                }
            }
        }
    }
}
