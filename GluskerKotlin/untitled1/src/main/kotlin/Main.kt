class ListNode<T>(var value: T, var next: ListNode<T>? = null)

class LinkedList<T> {
    var head: ListNode<T>? = null

    fun push(el: T) {
        val newNode = ListNode(el)
        newNode.next = head //сказать что тут происходт
        head = newNode
    }

    fun display() {
        var current = head
        while (current != null) {
            print("${current.value} -> ")
            current = current.next
        }
        println("null")
    }

    fun print() {
        if (head == null) {
            println("Список пуст")
        } else {
            println("Первый элемент списка: ${head?.value}")
        }
    }

    fun delete(): Boolean {
        if (head == null) {
            return false // Список пуст, нельзя удалить элемент
        } else if (head?.next == null) {
            head = null // В списке только один элемент, удаляем его
            return true
        }

        var prev: ListNode<T>? = null
        var current = head

        while (current?.next != null) { //пока не конец списка
            prev = current //предыдущий элемнт списка становится текущим
            current = current.next //а текущий становится следующим = перебор списка
        }

        prev?.next = null // Удаляем последний элемент
        return true
    }

    fun eraseAll() {
        head = null // Обнуляем голову списка, таким образом, очищая весь список
    }
}

fun main() {
    val linkedList = LinkedList<Int>()

    linkedList.push(3)
    linkedList.push(7)
    linkedList.push(11)

    linkedList.display()

    linkedList.print() // Новая функция для вывода первого элемента

    linkedList.eraseAll() // Очищаем весь список

    println("Список после удаления:")
    linkedList.display()
}
