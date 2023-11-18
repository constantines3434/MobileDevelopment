package database
import operation.Operation


 public class DataBase
{
    private var operations = mutableListOf<Operation>()

    // Метод для добавления операции (+)
    public fun addOperation(operation: Operation) {
        operations.add(operation)
    }

    // Метод для удаления операции по индексу (+)
    fun deleteOperation(index: Int) {
        if (index >= 0 && index < operations.size) {
            operations.removeAt(index)
            println("Операция базы данных с индексом $index")
        }
    }
    // Метод для сортировки операций по дате
    fun sortOperationsByDate() {
        operations.sortBy { it.date }
    }
    // Метод для поиска операций по описанию
    //обдумать
    fun searchOperationsByDescription(search: String): List<Operation>
    {
        return operations.filter { it.description.contains(search, ignoreCase = true) }
    }
    // Метод для вывода всех операций на экран
    fun printAllOperations()
    {
        operations.forEachIndexed { index, operation ->
            println("Индекс: $index, Дата: ${operation.date}, Тип: ${operation.type}, " +
                    "Объем: ${operation.amount}, Описание: ${operation.description}, " +
                    "Корреспондент: ${operation.correspondent}")
        }
    }
}