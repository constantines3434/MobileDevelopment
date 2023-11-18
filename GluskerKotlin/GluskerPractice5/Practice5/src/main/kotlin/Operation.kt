package operation

import java.util.*

public data class Operation(
    val date: Date,
    val type: String, // "доход" или "расход"
    val amount: Double,
    val description: String,
    val correspondent: String
)
