package consoleUI
import Operations.IOperationRepository

// Класс для показа всех операций
class GetAllOperations(
    private val repository: IOperationRepository
) {
    fun execute() {
        val allOperations = repository.getAll()
        println("Все операции:")
        allOperations.forEachIndexed { index, operation ->
            println("${index + 1}. $operation")
        }
    }
}