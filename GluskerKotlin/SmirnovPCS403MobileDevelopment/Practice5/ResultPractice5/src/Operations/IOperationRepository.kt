package Operations

// Интерфейс репозитория операций
interface IOperationRepository :
    IOperationAdder,
    IOperationGetter,
    IOperationUpdater,
    IOperationDeleter,
    IOperationFinder