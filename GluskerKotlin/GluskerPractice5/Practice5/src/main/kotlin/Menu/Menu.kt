package Menu

import ButtonControl.ButtonСontrol

class Menu
{
    //отрисовка меню и нажатие кнопок
    companion object
    {
        var res = ""

        public fun CreateMenu() : Unit
        {
            println("[ADD], [DELETE], [PRINT], [SEARCH], [SORT], [EXIT]")
            ConfirmButton()
        }

        public fun ConfirmButton(): Unit
        {
            //ввод
            res = readln()
            //кидаю результат в обработчик кнопку
            ButtonСontrol.Choos(res)
            //получаю результат
        }
    }
}