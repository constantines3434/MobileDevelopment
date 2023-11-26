package operation

import database.DataBase


public class Operation
{
    private var dbase = mutableListOf<DataBase>()

    // Метод для добавления операции (+)
    public fun addOperation(datebase: DataBase) = dbase.add(datebase)

    // Метод для удаления операции по индексу (+)
    fun deleteOperation(index: Int) {
        if (index >= 0 && index < dbase.size) {
            dbase.removeAt(index)
            println("Операция базы данных с индексом $index")
        }
    }
    // Метод для сортировки операций по дате
    fun sortOperationsByDate() = dbase.sortBy { it.date }

    // Метод для поиска операций по описанию
    //обдумать
    fun searchOperationsByDescription(search: String): List<DataBase> =
        dbase.filter { it.description.contains(search, ignoreCase = true) }

    // Метод для вывода всех операций на экран
    fun printAllOperations()
    {
        dbase.forEachIndexed { index, operation ->
            println("Индекс: $index, Дата: ${operation.date}, Тип: ${operation.type}, " +
                    "Объем: ${operation.amount}, Описание: ${operation.description}, " +
                    "Корреспондент: ${operation.correspondent}")
        }
    }
}