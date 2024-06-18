package com.alturino.calculator.ui

sealed interface MainScreenEvent {
    data class OnButton0Clicked(val value: String = "0") : MainScreenEvent
    data class OnButton1Clicked(val value: String = "1") : MainScreenEvent
    data class OnButton2Clicked(val value: String = "2") : MainScreenEvent
    data class OnButton3Clicked(val value: String = "3") : MainScreenEvent
    data class OnButton4Clicked(val value: String = "4") : MainScreenEvent
    data class OnButton5Clicked(val value: String = "5") : MainScreenEvent
    data class OnButton6Clicked(val value: String = "6") : MainScreenEvent
    data class OnButton7Clicked(val value: String = "7") : MainScreenEvent
    data class OnButton8Clicked(val value: String = "8") : MainScreenEvent
    data class OnButton9Clicked(val value: String = "9") : MainScreenEvent
    data class OnButtonPlusClicked(val value: String = "+") : MainScreenEvent
    data class OnButtonMinusClicked(val value: String = "-") : MainScreenEvent
    data class OnButtonTimesClicked(val value: String = "*") : MainScreenEvent
    data class OnButtonDivClicked(val value: String = "/") : MainScreenEvent
    data class OnButtonDotClicked(val value: String = ".") : MainScreenEvent
    data object OnButtonEqualClicked : MainScreenEvent
    data object OnButtonAcClicked : MainScreenEvent
    data object OnButtonBackspaceClicked : MainScreenEvent
    data class OnButtonLeftParenthesesClicked(val value: String = "(") : MainScreenEvent
    data class OnButtonRightParenthesesClicked(val value: String = ")") : MainScreenEvent
}
