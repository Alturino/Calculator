package com.alturino.calculator.domain

import com.alturino.calculator.ArithmeticParser
import javax.inject.Inject

class CalculatorUseCase @Inject constructor(
    private val arithmeticParser: ArithmeticParser
) {
    operator fun invoke(arithmeticExpression: String): Double =
        arithmeticParser(arithmeticExpression)
}