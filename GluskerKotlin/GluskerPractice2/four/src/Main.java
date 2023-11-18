fun main(args: Array<String>) {
        val str = "111111 22 3333 4 555 6666 77 88888"
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
        ,IsEven: (Int) -> Boolean = {it % 2 == 0}) : Char
        {
        var size = 0
        var oldSize = Int.MAX_VALUE
        var res = ' '


        return res
        }
