fun main() {
    readlnOrNull()
        ?.toIntOrNull()
        ?.takeIf { it > 0 }
        ?.let {
            it.toString()
                .map { it.toString().toInt() }
                .filter { it % 3 != 0 }
                .minOrNull()
                ?.let {
                        minDigit ->
                    println("Минимальная цифра, некратная трем: $minDigit")
                }
                ?: println("ошибка: число <= 0")
        } ?: println("Ошибка: не число")
}
