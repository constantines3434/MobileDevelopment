package consoleUI
import Operations.IOperationRepository
import Operations.Operation

// Класс для добавления операции через UI
class AddOperation(
    private val repository: IOperationRepository
) {
    fun execute(operation: Operation) {
        repository.add(operation)
    }
}