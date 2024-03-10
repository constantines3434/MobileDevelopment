package consoleUI

import java.util.*

// Класс для ввода числовых значений
class ReadDouble(private val scanner: Scanner) {
    fun execute(): Double {
        while (true) {
            try {
                println("Объем операции: ")
                return scanner.nextDouble()
            } catch (e: InputMismatchException) {
                println("Некорректный ввод. Повторите попытку.")
                scanner.next() // Очистка буфера сканера от некорректного ввода
            }
        }
    }
}