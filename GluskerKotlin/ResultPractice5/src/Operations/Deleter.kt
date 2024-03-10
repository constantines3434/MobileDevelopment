package Operations

import java.util.NoSuchElementException

// Класс для удаления операций
class Deleter(private val operations: MutableList<Operation>) : IOperationDeleter {
    override fun delete(id: Int) {
        val index = operations.indexOfFirst { it.id == id }
        if (index != -1) {
            operations.removeAt(index)
        } else {
            throw NoSuchElementException("Operation with id $id not found")
        }
    }
}