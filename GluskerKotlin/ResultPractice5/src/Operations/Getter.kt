package Operations

// Класс для получения всех операций
class Getter(private val operations: List<Operation>) : IOperationGetter {
    override fun getAll(): List<Operation> {
        return operations.toList()
    }
}