fun main(args: Array<String>) {
    val str = "Sa kr am ar"
    if (str.isEmpty())
    {
        println("Ответ: Строка пустая")
        return
    }
    var res = findLastChar(
            str
            ,{it.isWhitespace() || it == '.'}
            ,{it % 2 == 0}
    )
    if(res == ' ')
    {
        println("Нет ответа")
        return
    }
    else
        println("Последний символ в последнем самом коротком слове\n" +
                " с чётным числом символов: ${res}") //чётное слов
}
fun findLastChar(str: String
                 ,IsNotSymbol:(Char) -> Boolean = {it.isWhitespace() || it == '.'}
                 ,IsEven: (Int) -> Boolean = {it % 2 == 0}
                 ,MoreOrShortCondition: ) : Char
{
    var size = 0
    var res = ' '
    for (i in 0 until str.length)
    {
        if (IsNotSymbol(str[i]))
        {
            if (IsEven(size))
                res = str[i - 1]
            size = 0
        }
        else
            size++
    }
    if (IsEven(size))
        res = str[str.length - 1]
    return res
}
