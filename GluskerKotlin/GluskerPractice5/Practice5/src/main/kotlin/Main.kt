import operation.Operation
import database.DataBase
import java.util.*

fun main(args: Array<String>) {
    println("Hello World!")

    var data = DataBase()

    // Пример добавления операций
    data.addOperation(Operation( Date(), "доход", 1000.0, "Продажа товаров", "Клиент1"))
    data.addOperation(Operation( Date(), "расход", 500.0, "Покупка сырья", "Поставщик1"))

    // Поиск операций по описанию
    val search = "продажа товаров"
   // val searchResults = data.searchOperationsByDescription(search)
    data.printAllOperations()

    data.deleteOperation(1)
    data.printAllOperations()
}