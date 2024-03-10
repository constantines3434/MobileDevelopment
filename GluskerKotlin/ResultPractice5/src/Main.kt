import java.util.*

import Operations.*
import java.util.*
import consoleUI.*

// Операция
data class Operation(
    val id: Int,
    val date: String,
    val type: String,
    val amount: Double,
    val description: String,
    val correspondent: String
)

// Интерфейс для добавления операций
interface IOperationAdder {
    fun add(operation: Operation)
}

// Интерфейс для получения всех операций
interface IOperationGetter {
    fun getAll(): List<Operation>
}

// Интерфейс для обновления операций
interface IOperationUpdater {
    fun update(id: Int, newOperation: Operation)
}

// Интерфейс для удаления операций
interface IOperationDeleter {
    fun delete(id: Int)
}

// Интерфейс для поиска операций по ID
interface IOperationFinder {
    fun findById(id: Int): Operation?
}

// Интерфейс репозитория операций
interface IOperationRepository :
    IOperationAdder,
    IOperationGetter,
    IOperationUpdater,
    IOperationDeleter,
    IOperationFinder

//============================
private val operations = mutableListOf<Operation>()
private var lastId = 0


// Класс для добавления операций
class Adder(private val operations: MutableList<Operation>, private var lastId: Int) : IOperationAdder {
    override fun add(operation: Operation) {
        lastId++
        val operationWithId = operation.copy(id = lastId)
        operations.add(operationWithId)
    }
}

// Класс для получения всех операций
class Getter(private val operations: List<Operation>) : IOperationGetter {
    override fun getAll(): List<Operation> {
        return operations.toList()
    }
}

// Класс для обновления операций
class Updater(private val operations: MutableList<Operation>) : IOperationUpdater {
    override fun update(id: Int, newOperation: Operation) {
        val index = operations.indexOfFirst { it.id == id }
        if (index != -1) {
            operations[index] = newOperation.copy(id = id)
        } else {
            throw NoSuchElementException("Operation with id $id not found")
        }
    }
}

// Класс для удаления операций
class Deleter(private val operations: MutableList<Operation>) : IOperationDeleter {
    override fun delete(id: Int) {
        val index = operations.indexOfFirst { it.id == id }
        if (index != -1) {
            operations.removeAt(index)
        } else {
            throw NoSuchElementException("Operation with id $id not found")
        }
    }
}

// Класс для поиска операций по ID
class Finder(private val operations: List<Operation>) : IOperationFinder {
    override fun findById(id: Int): Operation? {
        return operations.find { it.id == id }
    }
}

// Класс репозитория операций
class OperationDatabase : IOperationRepository
{
    private val adder = Adder(operations, lastId)
    private val getter = Getter(operations)
    private val updater = Updater(operations)
    private val deleter = Deleter(operations)
    private val finder = Finder(operations)

    override fun add(operation: Operation) {
        adder.add(operation)
    }

    override fun getAll(): List<Operation> {
        return getter.getAll()
    }

    override fun update(id: Int, newOperation: Operation) {
        updater.update(id, newOperation)
    }

    override fun delete(id: Int) {
        deleter.delete(id)
    }

    override fun findById(id: Int): Operation? {
        return finder.findById(id)
    }
}

// Класс для ввода даты
class EnterDate(private val scanner: Scanner) {
    fun execute(): String {
        println("Дата (дд.мм.гггг): ")
        return scanner.next()
    }
}

// Класс для ввода типа операции
class EnterType(private val scanner: Scanner) {
    fun execute(): String {
        println("Тип операции (доход/расход): ")
        return scanner.next()
    }
}

// Класс для ввода числовых значений
class ReadDouble(private val scanner: Scanner) {
    fun execute(): Double {
        while (true) {
            try {
                println("Объем операции: ")
                return scanner.nextDouble()
            } catch (e: InputMismatchException) {
                println("Некорректный ввод. Повторите попытку.")
                scanner.next() // Очистка буфера сканера от некорректного ввода
            }
        }
    }
}

// Класс для ввода описания операции
class EnterDescription(private val scanner: Scanner) {
    fun execute(): String {
        println("Описание: ")
        return scanner.next()
    }
}

// Класс для ввода корреспондента операции
class EnterCorrespondent(private val scanner: Scanner) {
    fun execute(): String {
        println("Корреспондент: ")
        return scanner.next()
    }
}

// Класс для ввода данных новой операции
class EnterOperationData(
    private val enterDate: EnterDate,
    private val enterType: EnterType,
    private val readDouble: ReadDouble,
    private val enterDescription: EnterDescription,
    private val enterCorrespondent: EnterCorrespondent
) {
    fun execute(): Operation {
        val date = enterDate.execute()
        val type = enterType.execute()
        val amount = readDouble.execute()
        val description = enterDescription.execute()
        val correspondent = enterCorrespondent.execute()
        return Operation(0, date, type, amount, description, correspondent)
    }
}

// Класс для добавления операции через UI
class AddOperation(
    private val repository: IOperationRepository
) {
    fun execute(operation: Operation) {
        repository.add(operation)
    }
}

// Класс для выполнения добавления операции через UI
class AddOperationUI(
    private val repository: IOperationRepository,
    private val scanner: Scanner,
    private val enterOperationData: EnterOperationData,
    private val addOperation: AddOperation
) {
    fun execute() {
        val operation = enterOperationData.execute()
        addOperation.execute(operation)
        println("Операция успешно добавлена.")
    }
}

// Класс для показа всех операций
class GetAllOperations(
    private val repository: IOperationRepository
) {
    fun execute() {
        val allOperations = repository.getAll()
        println("Все операции:")
        allOperations.forEachIndexed { index, operation ->
            println("${index + 1}. $operation")
        }
    }
}

// Класс для выполнения обновления операции через UI
class UpdateOperationUI(
    private val repository: IOperationRepository,
    private val scanner: Scanner,
    private val enterOperationData: EnterOperationData
) {
    fun execute() {
        println("Введите ID операции для обновления:")
        val id = scanner.nextInt()
        val operation = repository.findById(id)
        if (operation != null) {
            println("Введите новые данные для операции:")
            val newOperation = enterOperationData.execute()
            repository.update(id, newOperation)
            println("Операция с ID $id успешно обновлена.")
        } else {
            println("Операция с ID $id не найдена.")
        }
    }
}

// Класс для выполнения удаления операции через UI
class DeleteOperationUI(
    private val repository: IOperationRepository,
    private val scanner: Scanner
) {
    fun execute() {
        println("Введите ID операции для удаления:")
        val id = scanner.nextInt()
        try {
            repository.delete(id)
            println("Операция с ID $id успешно удалена.")
        } catch (e: NoSuchElementException) {
            println(e.message)
        }
    }
}

// Класс для выполнения поиска операции по ID через UI
class FindOperationByIdUI(
    private val repository: IOperationRepository,
    private val scanner: Scanner
) {
    fun execute() {
        println("Введите ID операции для поиска:")
        val id = scanner.nextInt()
        val operation = repository.findById(id)
        if (operation != null) {
            println("Операция найдена:")
            println(operation)
        } else {
            println("Операция с ID $id не найдена.")
        }
    }
}

// Класс для управления консольным интерфейсом
class ConsoleUI(
    private val repository: IOperationRepository,
    private val scanner: Scanner
) {
    fun start() {
        println("Добро пожаловать в консольную базу данных учета доходов и расходов предпринимателя.")

        var running = true
        while (running) {
            println("Выберите действие:")
            println("1. Добавить операцию")
            println("2. Показать все операции")
            println("3. Обновить операцию")
            println("4. Удалить операцию")
            println("5. Найти операцию по ID")
            println("0. Выход")

            when (scanner.nextInt()) {
                1 -> AddOperationUI(
                    repository,
                    scanner,
                    EnterOperationData(
                        EnterDate(scanner),
                        EnterType(scanner),
                        ReadDouble(scanner),
                        EnterDescription(scanner),
                        EnterCorrespondent(scanner)
                    ),
                    AddOperation(repository)
                ).execute()
                2 -> GetAllOperations(repository).execute()
                3 -> UpdateOperationUI(
                    repository,
                    scanner,
                    EnterOperationData(
                        EnterDate(scanner),
                        EnterType(scanner),
                        ReadDouble(scanner),
                        EnterDescription(scanner),
                        EnterCorrespondent(scanner)
                    )
                ).execute()
                4 -> DeleteOperationUI(repository, scanner).execute()
                5 -> FindOperationByIdUI(repository, scanner).execute()
                0 -> running = false
                else -> println("Некорректный выбор. Повторите попытку.")
            }
        }

        println("Работа программы завершена.")
    }
}

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


fun main() {
    val scanner = Scanner(System.`in`)
    val repository: IOperationRepository = OperationDatabase()
    val consoleUI = ConsoleUI(repository, scanner)
    val addTestData = AddTestData(repository)
    addTestData.execute()
    consoleUI.start()
    scanner.close()
}