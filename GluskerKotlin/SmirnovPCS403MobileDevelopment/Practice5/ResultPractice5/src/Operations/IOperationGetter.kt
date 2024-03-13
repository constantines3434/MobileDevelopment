package Operations

// Интерфейс для получения всех операций
interface IOperationGetter {
    fun getAll(): List<Operation>
}