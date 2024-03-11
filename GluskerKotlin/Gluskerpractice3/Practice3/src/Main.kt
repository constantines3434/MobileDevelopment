//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val n = 3 // Количество абитуриентов
    val applicants = List(n) {
        val name = readLine()!!
        val totalScore = readLine()!!.split(" ").map(String::toInt).sum()
        name to totalScore
    }
    applicants.sortedBy { it.second }.take(3).forEach { println(it.first) }
}
