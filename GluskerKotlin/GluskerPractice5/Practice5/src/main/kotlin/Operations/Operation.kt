package Operations

import IAdd.IAdd
import MyBase.DataBase


public class Operation
{
    companion object
    {
        private var dbase = mutableListOf<DataBase>()

        // Метод для добавления операции (+)
        fun AddOperation(dateField: DataBase) {
            dbase.add(dateField)
        }

        // Метод для удаления операции по индексу (+)
        public fun DeleteOperation(index: Int): Unit {
            if (index >= 0 && index < dbase.size)
            {
                dbase.removeAt(index)
                //     println("Операция базы данных с индексом $index")
            }
            else
            {
                println("Нет записи с таким номером")
            }
        }

        // Метод для сортировки операций по дате
        public fun SortOperationsByDate(): Unit = dbase.sortBy { it.date }
        public fun SortOperationsByType(): Unit = dbase.sortBy { it.type }
        public fun SortOperationsByDescription(): Unit = dbase.sortBy { it.description }
        public fun SortOperationsByCorrespondent(): Unit = dbase.sortBy { it.correspondent }

        // Метод для поиска операций по индексу
        fun SearchOperationByIndex(index: Int): Unit {
            if (index >= 0 && index < dbase.size) {
                val operation = dbase[index]
                println(
                    "Индекс: $index, Дата: ${operation.date}, Тип: ${operation.type}, " +
                            "Объем: ${operation.amount}, Описание: ${operation.description}, " +
                            "Корреспондент: ${operation.correspondent}"
                )
            } else {
                println("Нет записи с таким номером")
            }
        }


        // Метод для вывода всех операций на экран
        public fun GetAllOperations(): Unit {
            dbase.forEachIndexed { index, operation ->
                println(
                    "Индекс: $index, Дата: ${operation.date}, Тип: ${operation.type}, " +
                            "Цена: ${operation.amount}, Описание: ${operation.description}, " +
                            "Корреспондент: ${operation.correspondent}"
                )
            }
        }
    }
}