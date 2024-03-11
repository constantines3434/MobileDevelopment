import java.util.*

import Operations.*
import consoleUI.*

fun main() {
    val scanner = Scanner(System.`in`)
    val repository: IOperationRepository = OperationDatabase()
    val consoleUI = ConsoleUI(repository, scanner)
    val addTestData = AddTestData(repository)
    addTestData.execute()
    consoleUI.start()
    scanner.close()
}