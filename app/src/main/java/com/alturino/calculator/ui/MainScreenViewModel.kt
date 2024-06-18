package com.alturino.calculator.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alturino.calculator.domain.CalculatorUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.drop
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val calculatorUseCase: CalculatorUseCase
) : ViewModel() {

    private val _expressionStack = mutableListOf<String>()
    private val _resultStack = mutableListOf<Double>()

    private val _expression = MutableStateFlow("")
    val expression = _expression.asStateFlow()

    val result: StateFlow<Double?> = _expression
        .drop(1)
        .onEach { Log.d("MainScreenViewModel", "expression: $it") }
        .map {
            runCatching { calculatorUseCase.invoke(it) }
                .getOrNull()
        }
        .onEach { Log.d("MainScreenViewModel", "result: $it") }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = null
        )

    fun onEvent(event: MainScreenEvent) {
        when (event) {
            is MainScreenEvent.OnButton0Clicked -> {
                _expressionStack.add(event.value)
                _expression.update { _expressionStack.joinToString("") }
            }

            is MainScreenEvent.OnButton1Clicked -> {
                _expressionStack.add(event.value)
                _expression.update { _expressionStack.joinToString("") }
            }

            is MainScreenEvent.OnButton2Clicked -> {
                _expressionStack.add(event.value)
                _expression.update { _expressionStack.joinToString("") }
            }

            is MainScreenEvent.OnButton3Clicked -> {
                _expressionStack.add(event.value)
                _expression.update { _expressionStack.joinToString("") }
            }

            is MainScreenEvent.OnButton4Clicked -> {
                _expressionStack.add(event.value)
                _expression.update { _expressionStack.joinToString("") }
            }

            is MainScreenEvent.OnButton5Clicked -> {
                _expressionStack.add(event.value)
                _expression.update { _expressionStack.joinToString("") }
            }

            is MainScreenEvent.OnButton6Clicked -> {
                _expressionStack.add(event.value)
                _expression.update { _expressionStack.joinToString("") }
            }

            is MainScreenEvent.OnButton7Clicked -> {
                _expressionStack.add(event.value)
                _expression.update { _expressionStack.joinToString("") }
            }

            is MainScreenEvent.OnButton8Clicked -> {
                _expressionStack.add(event.value)
                _expression.update { _expressionStack.joinToString("") }
            }

            is MainScreenEvent.OnButton9Clicked -> {
                _expressionStack.add(event.value)
                _expression.update { _expressionStack.joinToString("") }
            }

            MainScreenEvent.OnButtonAcClicked -> {
                _expressionStack.clear()
                _expression.update { "" }
            }

            MainScreenEvent.OnButtonBackspaceClicked -> {
                _expressionStack.removeLast()
                _expression.update { _expressionStack.joinToString("") }
            }

            is MainScreenEvent.OnButtonDivClicked -> {
                _expressionStack.add(event.value)
                _expression.update { _expressionStack.joinToString("") }
            }

            MainScreenEvent.OnButtonEqualClicked -> {
                runCatching { calculatorUseCase.invoke(expression.value) }
                    .onSuccess {
                        Log.d("MainScreenViewModel", "result: $it")
                        _resultStack.add(it)
                    }
                    .onFailure { Log.e("MainScreenViewModel", it.message.orEmpty()) }
            }

            is MainScreenEvent.OnButtonLeftParenthesesClicked -> {
                _expressionStack.add(event.value)
                _expression.update { _expressionStack.joinToString("") }
            }

            is MainScreenEvent.OnButtonMinusClicked -> {
                _expressionStack.add(event.value)
                _expression.update { _expressionStack.joinToString("") }
            }

            is MainScreenEvent.OnButtonPlusClicked -> {
                _expressionStack.add(event.value)
                _expression.update { _expressionStack.joinToString("") }
            }

            is MainScreenEvent.OnButtonRightParenthesesClicked -> {
                _expressionStack.add(event.value)
                _expression.update { _expressionStack.joinToString("") }
            }

            is MainScreenEvent.OnButtonTimesClicked -> {
                _expressionStack.add(event.value)
                _expression.update { _expressionStack.joinToString("") }
            }

            is MainScreenEvent.OnButtonDotClicked -> {
                _expressionStack.add(event.value)
                _expression.update { _expressionStack.joinToString("") }
            }
        }
        Log.d(
            "MainScreenViewModel",
            "event: $event, _expression: $_expressionStack, _result: $_resultStack"
        )
    }
}