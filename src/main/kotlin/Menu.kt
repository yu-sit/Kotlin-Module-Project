import java.util.Scanner

class Menu {

    fun displayMenu(position: String, positionAnnotation: List<Pair<String, () -> Unit>>) {
        while (true) {
            println (position)
            positionAnnotation.forEachIndexed {index, pos -> println("$index.${pos.first}") }
            println(" Выберите один из пунктов: ")

            val input = readLine()
            if (input != null && input.isNotEmpty() && input.all { it.isDigit() }) {
                val choice = input.toInt()
                if (choice in positionAnnotation.indices) {
                    positionAnnotation[choice].second.invoke()
                    break
                } else {
                    println(" Выбранный Вами пункт отсутствует. Выберите пункт еще раз.")
                }
            }
                else {
                    println(" Некорректный ввод. Выберите пункт еще раз.")
            }
            }
        }
    }
