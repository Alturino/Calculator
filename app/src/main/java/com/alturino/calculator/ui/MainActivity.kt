package com.alturino.calculator.ui

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Backspace
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.alturino.calculator.ui.theme.CalculatorTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: MainScreenViewModel = hiltViewModel()
            val expression by viewModel.expression.collectAsState()
            val result by viewModel.result.collectAsState()
            Calculator {
                MainScreen(
                    onEvent = viewModel::onEvent,
                    result = if (result == null) "" else result.toString(),
                    expression = expression
                )
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
fun MainScreen(
    modifier: Modifier = Modifier,
    onEvent: (MainScreenEvent) -> Unit,
    result: String,
    expression: String,
) {
    val buttonSpacing = 8.dp
    Scaffold(modifier = modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Column(modifier = Modifier.weight(1f), verticalArrangement = Arrangement.Bottom) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            maxLines = 1,
                            textAlign = TextAlign.Right,
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Italic,
                            text = expression,
                        )
                    }
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            maxLines = 1,
                            textAlign = TextAlign.Right,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Italic,
                            text = result,
                        )
                    }
                }
            }
            HorizontalDivider()
            Column(
                modifier = Modifier
                    .weight(2f)
                    .padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ) {
                    TextButton(
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { onEvent(MainScreenEvent.OnButtonAcClicked) },
                        colors = ButtonDefaults.textButtonColors(
                            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                            contentColor = MaterialTheme.colorScheme.onTertiaryContainer
                        )
                    ) {
                        Text("AC")
                    }
                    TextButton(
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { onEvent(MainScreenEvent.OnButtonLeftParenthesesClicked()) },
                        colors = ButtonDefaults.textButtonColors(
                            containerColor = MaterialTheme.colorScheme.secondaryContainer,
                            contentColor = MaterialTheme.colorScheme.onSecondaryContainer
                        )
                    ) {
                        Text("(")
                    }
                    TextButton(
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { onEvent(MainScreenEvent.OnButtonRightParenthesesClicked()) },
                        colors = ButtonDefaults.textButtonColors(
                            containerColor = MaterialTheme.colorScheme.secondaryContainer,
                            contentColor = MaterialTheme.colorScheme.onSecondaryContainer
                        )
                    ) {
                        Text(")")
                    }
                    TextButton(
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { onEvent(MainScreenEvent.OnButtonDivClicked()) },
                        colors = ButtonDefaults.textButtonColors(
                            containerColor = MaterialTheme.colorScheme.secondaryContainer,
                            contentColor = MaterialTheme.colorScheme.onSecondaryContainer
                        )
                    ) {
                        Text("÷")
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ) {
                    TextButton(
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { onEvent(MainScreenEvent.OnButton7Clicked()) },
                        colors = ButtonDefaults.textButtonColors(
                            containerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    ) {
                        Text("7")
                    }
                    TextButton(
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { onEvent(MainScreenEvent.OnButton8Clicked()) },
                        colors = ButtonDefaults.textButtonColors(
                            containerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    ) {
                        Text("8")
                    }
                    TextButton(
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { onEvent(MainScreenEvent.OnButton9Clicked()) },
                        colors = ButtonDefaults.textButtonColors(
                            containerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    ) {
                        Text("9")
                    }
                    TextButton(
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { onEvent(MainScreenEvent.OnButtonTimesClicked()) },
                        colors = ButtonDefaults.textButtonColors(
                            containerColor = MaterialTheme.colorScheme.secondaryContainer,
                            contentColor = MaterialTheme.colorScheme.onSecondaryContainer
                        )
                    ) {
                        Text("×")
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ) {
                    TextButton(
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { onEvent(MainScreenEvent.OnButton4Clicked()) },
                        colors = ButtonDefaults.textButtonColors(
                            containerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    ) {
                        Text("4")
                    }
                    TextButton(
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { onEvent(MainScreenEvent.OnButton5Clicked()) },
                        colors = ButtonDefaults.textButtonColors(
                            containerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    ) {
                        Text("5")
                    }
                    TextButton(
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { onEvent(MainScreenEvent.OnButton6Clicked()) },
                        colors = ButtonDefaults.textButtonColors(
                            containerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    ) {
                        Text("6")
                    }
                    TextButton(
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { onEvent(MainScreenEvent.OnButtonMinusClicked()) },
                        colors = ButtonDefaults.textButtonColors(
                            containerColor = MaterialTheme.colorScheme.secondaryContainer,
                            contentColor = MaterialTheme.colorScheme.onSecondaryContainer
                        )
                    ) {
                        Text("-")
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ) {
                    TextButton(
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { onEvent(MainScreenEvent.OnButton1Clicked()) },
                        colors = ButtonDefaults.textButtonColors(
                            containerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    ) {
                        Text("1")
                    }
                    TextButton(
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { onEvent(MainScreenEvent.OnButton2Clicked()) },
                        colors = ButtonDefaults.textButtonColors(
                            containerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    ) {
                        Text("2")
                    }
                    TextButton(
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { onEvent(MainScreenEvent.OnButton3Clicked()) },
                        colors = ButtonDefaults.textButtonColors(
                            containerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    ) {
                        Text("3")
                    }
                    TextButton(
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { onEvent(MainScreenEvent.OnButtonPlusClicked()) },
                        colors = ButtonDefaults.textButtonColors(
                            containerColor = MaterialTheme.colorScheme.secondaryContainer,
                            contentColor = MaterialTheme.colorScheme.onSecondaryContainer
                        )
                    ) {
                        Text("+")
                    }
                }

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
                ) {
                    TextButton(
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { onEvent(MainScreenEvent.OnButton0Clicked()) },
                        colors = ButtonDefaults.textButtonColors(
                            containerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    ) {
                        Text("0")
                    }
                    TextButton(
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { onEvent(MainScreenEvent.OnButtonDotClicked()) },
                        colors = ButtonDefaults.textButtonColors(
                            containerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    ) {
                        Text(".")
                    }
                    FilledTonalIconButton(
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { onEvent(MainScreenEvent.OnButtonBackspaceClicked) },
                        colors = IconButtonDefaults.filledTonalIconButtonColors(
                            containerColor = MaterialTheme.colorScheme.errorContainer,
                            contentColor = MaterialTheme.colorScheme.onErrorContainer
                        )
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.Backspace,
                            contentDescription = null
                        )
                    }
                    TextButton(
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(1f),
                        onClick = { onEvent(MainScreenEvent.OnButtonEqualClicked) },
                        colors = ButtonDefaults.textButtonColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer,
                            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    ) {
                        Text("=")
                    }
                }
            }
        }
    }
}

@Preview(
    showSystemUi = true,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Preview(
    showSystemUi = true,
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun MainScreenPreview() {
    CalculatorTheme {
        MainScreen(result = "", onEvent = {}, expression = "")
    }
}