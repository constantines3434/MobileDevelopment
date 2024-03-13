package Operations

// Класс для поиска операций по ID
class Finder(private val operations: List<Operation>) : IOperationFinder {
    override fun findById(id: Int): Operation? {
        return operations.find { it.id == id }
    }
}