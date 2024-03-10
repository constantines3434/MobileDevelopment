// В файле Operation.kt
package Operations

data class Operation(
    val id: Int,
    val date: String,
    val type: String,
    val amount: Double,
    val description: String,
    val correspondent: String
)