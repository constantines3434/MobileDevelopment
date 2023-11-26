package MyBase

import java.util.*

public data class DataBase(
    val date: Date?,
    val type: String, // "доход" или "расход"
    val amount: Double,
    val description: String,
    val correspondent: String
)
