package consoleUI

import java.util.*

// Класс для ввода корреспондента операции
class EnterCorrespondent(private val scanner: Scanner) {
    fun execute(): String {
        println("Корреспондент: ")
        return scanner.next()
    }
}