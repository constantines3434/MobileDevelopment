package consoleUI

import java.util.*

// Класс для ввода описания операции
class EnterDescription(private val scanner: Scanner) {
    fun execute(): String {
        println("Описание: ")
        return scanner.next()
    }
}