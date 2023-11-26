package ButtonControl

import MyBase.DataBase
import Operations.DateHandler
import Operations.Operation
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import exit.Exit
import kotlin.system.exitProcess

class ButtonСontrol
{
//обработка кнопок
    companion object
    {
        public fun Choos(res: String) :Unit
        {
            when (res)
            {
                "ADD" -> AddHandler()
                "DELETE" -> DeleteHandler()
                "PRINT" -> Operation.GetAllOperations()
                "SEARCH" -> SearchHandler()
                "SORT" -> SortHandler()
                "EXIT" -> Exit.ExitFromApp()
            }
            Menu.Menu.CreateMenu()
        }

        public fun AddHandler():Unit
        {
            println("Введите данные для добавления:\n")
            print("Дата: ")
            var myDate = readln()

            print("Тип операции: ")
            var myType = readln()

            print("Сумма: ")
            var myAmount = readln()

            print("Описание: ")
            var myDescription = readln()

            print("Корреспондент: ")
            var Mycorrespondent = readln()

            Operation.AddOperation(DataBase( DateHandler.ConvertToDate(myDate),
                                             myType,
                                             myAmount.toDouble(),
                                             myDescription,
                                             Mycorrespondent))

        }
        public fun DeleteHandler():Unit
        {
            var myIndex = readln()
            print("Выберите номер записи, которую хотите удалить: ")

            Operation.DeleteOperation(myIndex.toInt())
        }
        public fun SearchHandler():Unit
        {
            print("Введите номер записи для поиска: ")
            var myIndex = readln()
            Operation.SearchOperationByIndex(myIndex.toInt())
        }
        public fun SortHandler():Unit
        {
            print("Выберите столбец, по которому будет происходить сортировка: ")
            println("[INDEX], [DATE], [TYPE], [AMOUNT], [DESCRIPTION], [CORRESPONDENT], [EXIT]")

            var mySort = readln()

            when (mySort)
            {
                "DATE" -> Operation.SortOperationsByDate()
                "TYPE" -> Operation.SortOperationsByType()
                "DESCRIPTION" -> Operation.SortOperationsByDescription()
                "CORRESPONDENT" -> Operation.SortOperationsByCorrespondent()
                "EXIT" -> Exit()
            }
            Operation.SortOperationsByDate()
        }
    }
}