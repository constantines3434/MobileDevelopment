package Operations

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

public class DateHandler
{
    companion object {
        fun ConvertToDate(myDate: String): Date? {
            try {
                val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
                val localDate = LocalDate.parse(myDate, formatter)
                return java.sql.Date.valueOf(localDate)
            } catch (e: Exception) {
                println("Ошибка при преобразовании строки в дату: ${e.message}")
                return null
            }
        }
    }
}