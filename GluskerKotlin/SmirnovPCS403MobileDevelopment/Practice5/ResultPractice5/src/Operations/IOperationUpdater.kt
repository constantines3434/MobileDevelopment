package Operations

// Интерфейс для обновления операций
interface IOperationUpdater {
    fun update(id: Int, newOperation: Operation)
}