package consoleUI
import Operations.IOperationRepository
import java.util.*

// Класс для выполнения поиска операции по ID через UI
class FindOperationByIdUI(
    private val repository: IOperationRepository,
    private val scanner: Scanner
) {
    fun execute() {
        println("Введите ID операции для поиска:")
        val id = scanner.nextInt()
        val operation = repository.findById(id)
        if (operation != null) {
            println("Операция найдена:")
            println(operation)
        } else {
            println("Операция с ID $id не найдена.")
        }
    }
}