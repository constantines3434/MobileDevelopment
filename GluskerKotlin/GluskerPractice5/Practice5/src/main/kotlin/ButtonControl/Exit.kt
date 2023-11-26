package exit

import kotlin.system.exitProcess

public class Exit
{
    companion object
    {
        public fun ExitFromApp(): Unit = exitProcess(0)
    }
}