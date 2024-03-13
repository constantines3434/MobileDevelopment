package consoleUI

import java.util.*

// Класс для ввода типа операции
class EnterType(private val scanner: Scanner) {
    fun execute(): String {
        println("Тип операции (доход/расход): ")
        return scanner.next()
    }
}