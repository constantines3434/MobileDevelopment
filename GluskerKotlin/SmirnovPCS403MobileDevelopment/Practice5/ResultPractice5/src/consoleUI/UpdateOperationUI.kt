package consoleUI
import Operations.IOperationRepository
import java.util.*

// Класс для выполнения обновления операции через UI
class UpdateOperationUI(
    private val repository: IOperationRepository,
    private val scanner: Scanner,
    private val enterOperationData: EnterOperationData
) {
    fun execute() {
        println("Введите ID операции для обновления:")
        val id = scanner.nextInt()
        val operation = repository.findById(id)
        if (operation != null) {
            println("Введите новые данные для операции:")
            val newOperation = enterOperationData.execute()
            repository.update(id, newOperation)
            println("Операция с ID $id успешно обновлена.")
        } else {
            println("Операция с ID $id не найдена.")
        }
    }
}