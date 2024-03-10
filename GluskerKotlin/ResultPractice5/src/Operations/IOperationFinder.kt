package Operations

// Интерфейс для поиска операций по ID
interface IOperationFinder {
    fun findById(id: Int): Operation?
}