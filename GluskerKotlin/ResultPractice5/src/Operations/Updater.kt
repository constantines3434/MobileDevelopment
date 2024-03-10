package Operations

import java.util.NoSuchElementException

// Класс для обновления операций
class Updater(private val operations: MutableList<Operation>) : IOperationUpdater {
    override fun update(id: Int, newOperation: Operation) {
        val index = operations.indexOfFirst { it.id == id }
        if (index != -1) {
            operations[index] = newOperation.copy(id = id)
        } else {
            throw NoSuchElementException("Operation with id $id not found")
        }
    }
}