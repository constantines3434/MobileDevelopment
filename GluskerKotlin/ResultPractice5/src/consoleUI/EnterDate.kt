package consoleUI

import java.util.*

// Класс для ввода даты
class EnterDate(private val scanner: Scanner) {
    fun execute(): String {
        println("Дата (дд.мм.гггг): ")
        return scanner.next()
    }
}