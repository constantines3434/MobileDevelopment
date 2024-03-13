    package ZodiacSignCalculator.ui.theme

    class ZodiacSignCalculator(
        private val ariesResId: Int,
        private val taurusResId: Int,
        var geminiResId: Int,
        var cancerResId: Int,
        var leoResId: Int,
        var virgoResId: Int,
        var libraResId: Int,
        var scorpioResId: Int,
        var sagittariusResId: Int,
        var capricornResId: Int,
        var aquariusResId: Int,
        var piscesResId: Int,
        var noneResId: Int,
    ) {
        fun calculateZodiacSign(month: Int, selectedDay: Int): Int {
            return when {
                (month == 3 && selectedDay >= 21) || (month == 4 && selectedDay <= 19) -> ariesResId
                (month == 4 && selectedDay >= 20) || (month == 5 && selectedDay <= 20) -> taurusResId
                (month == 5 && selectedDay >= 21) || (month == 6 && selectedDay <= 20) -> geminiResId
                (month == 6 && selectedDay >= 21) || (month == 7 && selectedDay <= 22) -> cancerResId
                (month == 7 && selectedDay >= 23) || (month == 8 && selectedDay <= 22) -> leoResId
                (month == 8 && selectedDay >= 23) || (month == 9 && selectedDay <= 22) -> virgoResId
                (month == 9 && selectedDay >= 23) || (month == 10 && selectedDay <= 22) -> libraResId
                (month == 10 && selectedDay >= 23) || (month == 11 && selectedDay <= 21) -> scorpioResId
                (month == 11 && selectedDay >= 22) || (month == 12 && selectedDay <= 21) -> sagittariusResId
                (month == 12 && selectedDay >= 22) || (month == 1 && selectedDay <= 19) -> capricornResId
                (month == 1 && selectedDay >= 20) || (month == 2 && selectedDay <= 18) ->aquariusResId
                (month == 2 && selectedDay >= 19) || (month == 3 && selectedDay <= 20) -> piscesResId
                else -> noneResId
            }
        }
    }