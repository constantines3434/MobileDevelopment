package consoleUI
import Operations.IOperationRepository
import java.util.*

// Класс для выполнения удаления операции через UI
class DeleteOperationUI(
    private val repository: IOperationRepository,
    private val scanner: Scanner
) {
    fun execute() {
        println("Введите ID операции для удаления:")
        val id = scanner.nextInt()
        try {
            repository.delete(id)
            println("Операция с ID $id успешно удалена.")
        } catch (e: NoSuchElementException) {
            println(e.message)
        }
    }
}