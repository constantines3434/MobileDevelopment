package Operations

// Класс для добавления операций
class Adder(private val operations: MutableList<Operation>, private var lastId: Int) : IOperationAdder {
    override fun add(operation: Operation) {
        lastId++
        val operationWithId = operation.copy(id = lastId)
        operations.add(operationWithId)
    }
}