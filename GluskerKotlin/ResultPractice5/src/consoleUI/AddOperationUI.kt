package consoleUI

import java.util.*
import  Operations.IOperationRepository
import Operations.Operation

// Класс для выполнения добавления операции через UI
class AddOperationUI(
    private val repository: IOperationRepository,
    private val scanner: Scanner,
    private val enterOperationData: EnterOperationData,
    private val addOperation: AddOperation
) {
    fun execute() {
        val operation = enterOperationData.execute()
        addOperation.execute(operation)
        println("Операция успешно добавлена.")
    }
}