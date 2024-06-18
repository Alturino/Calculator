package com.alturino.calculator

object ArithmeticParser {
    private val opToPrecedence = mapOf(
        "+" to 1,
        "-" to 1,
        "*" to 2,
        "/" to 2,
    )

    operator fun invoke(arithmeticExpression: String): Double = arithmeticExpression
        .split(" ")
        .joinToString(prefix = "(", postfix = ")", separator = "")
        .run(::toReversePolishNotation)
        .run(::evaluateReversePolishNotation)

    private fun appendZero(tokens: List<String>): List<String> {
        val res = mutableListOf<String>()
        for ((i, token) in tokens.withIndex()) {
            if (token == "-" && tokens[i - 1] == "(") {
                res.add("0")
            }
            res.add(token)
        }
        return res.toList()
    }

    private fun arithmeticExpressionToTokens(arithmeticExpression: String): List<String> {
        var i = 0
        val tokens = mutableListOf<String>()

        while (i < arithmeticExpression.length) {
            if (arithmeticExpression[i].isDigit() || arithmeticExpression[i] == '.') {
                val digits = mutableListOf(arithmeticExpression[i])
                var j = i + 1
                while (j < arithmeticExpression.length && (arithmeticExpression[j].isDigit() || arithmeticExpression[i] == '.')) {
                    digits.add(arithmeticExpression[j])
                    j++
                }
                i = j - 1
                tokens.add(digits.joinToString(""))
            } else {
                tokens.add(arithmeticExpression[i].toString())
            }
            i++
        }
        return tokens.toList()
    }

    private fun toReversePolishNotation(arithmeticExpression: String): List<String> {
        val outputQueue = mutableListOf<String>()
        val opStack = mutableListOf<String>()

        val tokens = arithmeticExpression
            .run(::arithmeticExpressionToTokens)
            .run(::appendZero)

        for (token in tokens) {
            if (token.toDoubleOrNull() != null) {
                outputQueue.add(token)
            } else if (token == "(") {
                opStack.add(token)
            } else if (token == ")") {
                while (opStack.isNotEmpty() && opStack.last() != "(") {
                    outputQueue.add(opStack.removeLast())
                }
                opStack.removeLast()
            } else {
                while (
                    (opStack.isNotEmpty() && opStack.last() != "(") &&
                    (opToPrecedence.containsKey(token) && opToPrecedence.containsKey(opStack.last())) &&
                    (opToPrecedence[token]!! <= opToPrecedence[opStack.last()]!!)
                ) {
                    outputQueue.add(opStack.removeLast())
                }
                opStack.add(token)
            }
        }

        while (opStack.isNotEmpty()) {
            outputQueue.add(opStack.removeLast())
        }

        return outputQueue.toList()
    }

    private fun evaluateReversePolishNotation(reversePolishNotation: List<String>): Double {
        val stack = mutableListOf<Double>()
        for (token in reversePolishNotation) {
            if (token == "+") {
                val b = stack.removeLast()
                val a = stack.removeLast()
                stack.add(a + b)
            } else if (token == "-") {
                val b = stack.removeLast()
                val a = stack.removeLast()
                stack.add(a - b)
            } else if (token == "*") {
                val b = stack.removeLast()
                val a = stack.removeLast()
                stack.add(a * b)
            } else if (token == "/") {
                val b = stack.removeLast()
                val a = stack.removeLast()
                stack.add(a / b)
            } else if (token.toDoubleOrNull() != null) {
                stack.add(token.toDouble())
            }
        }
        return stack.removeLast()
    }

}