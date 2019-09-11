import org.junit.Assert.*
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class MyClassTest {

    @org.junit.Test
    fun echo() {

        val myClassTest = MyClass("Meow")               // Создание объекта тестируемого класса

        val inputString = "Tom"                               // Строка, содержащая эмулируемые входные данные


       val oldIn= System.`in`                                // Сохраняете ссылку на старый поток ввода
       val newIn= ByteArrayInputStream( inputString.toByteArray() ) // Строка, превращённая в массив - новый источник данных (вместо пользовательского ввода с клавиатуры)


        System.setIn(newIn)                                 // Теперь вход через readLine и прочее, связанное с клавиатурой - не с клавиатуры, а из строки

        // Переустанавливаем System.out.println вывод с консольного в байтовый массив, который можно будет превратить в строку
        val baos = ByteArrayOutputStream()
        val oldOut = System.out
        val ps = PrintStream(baos)
        System.setOut(ps)

        // Вызов метода
        myClassTest.echo()


        val stringResult = baos.toString()

        println(stringResult)
        assertEquals("Tom Meow"+System.lineSeparator(),stringResult)


        // Восстановление потоков ввода-вывода
        System.out.flush()
        System.setOut(oldOut)
        System.setIn(oldIn)

    }
}