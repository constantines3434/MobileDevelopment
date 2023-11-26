package Main

import  Menu.Menu
public class MainPart
{
    companion object
    {
        public fun RunApp(): Unit = Menu.CreateMenu()
    }
    //сюда кидает после выбора кнопки в меню
    //срабатывает выбранная кнопка
    //возврат в меню
}