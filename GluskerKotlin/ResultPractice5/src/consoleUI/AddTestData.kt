package consoleUI
import Operations.IOperationRepository
import Operations.Operation

// Класс для добавления тестовых данных
class AddTestData(private val repository: IOperationRepository) {
    fun execute() {
        val testData = listOf(
            Operation(0, "01.01.2024", "Доход", 1000.0, "Продажа товаров", "Клиент 1"),
            Operation(0, "02.01.2024", "Расход", 500.0, "Покупка материалов", "Поставщик 1"),
            Operation(0, "03.01.2024", "Доход", 800.0, "Услуги по ремонту", "Клиент 2"),
            Operation(0, "04.01.2024", "Расход", 300.0, "Оплата аренды", "Арендодатель")
        )

        testData.forEach { repository.add(it) }
    }
}