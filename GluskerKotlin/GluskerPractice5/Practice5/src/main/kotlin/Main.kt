import operation.Operation
import database.DataBase
import java.util.*

fun main(args: Array<String>) {
    println("Hello World!")

    var operation = Operation()

    // Пример добавления операций
    operation.addOperation(DataBase( Date(), "доход", 1000.0, "Продажа товаров", "Клиент1"))
    operation.addOperation(DataBase( Date(), "расход", 500.0, "Покупка сырья", "Поставщик1"))

    // Поиск операций по описанию
    val search = "продажа товаров"
   // val searchResults = operation.searchOperationsByDescription(search)
    operation.printAllOperations()

    operation.deleteOperation(1)
    operation.printAllOperations()
}