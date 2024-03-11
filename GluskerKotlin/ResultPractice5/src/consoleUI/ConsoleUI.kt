package consoleUI
import Operations.IOperationRepository
import java.util.*

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