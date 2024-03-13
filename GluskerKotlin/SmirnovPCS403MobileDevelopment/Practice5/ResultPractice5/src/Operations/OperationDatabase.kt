package Operations

private val operations = mutableListOf<Operation>()
private var lastId = 0


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