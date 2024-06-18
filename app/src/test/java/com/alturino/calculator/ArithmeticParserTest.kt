package com.alturino.calculator

import com.alturino.calculator.domain.CalculatorUseCase
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class ArithmeticParserTest {
    @Test
    fun testCase1() {
        val calculatorUseCase = CalculatorUseCase(ArithmeticParser)
        val actual = calculatorUseCase.invoke(arithmeticExpression = "1 + 2 * 3")
        assertThat(actual).isEqualTo(7.0)
    }
}