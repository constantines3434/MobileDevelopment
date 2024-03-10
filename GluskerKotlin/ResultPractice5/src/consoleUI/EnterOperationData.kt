package consoleUI
import Operation

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