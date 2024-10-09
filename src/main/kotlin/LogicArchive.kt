import java.util.Scanner

class LogicArchive {
    private val archives = mutableListOf<Archive>()

    fun displayArchMenu() {
        val menu = Menu()
        val positionAnnotation = mutableListOf<Pair<String, () -> Unit>>(
            " Создать Архив" to ::createArch,
            " Выход" to ::exit
        )

        archives.forEachIndexed { index, archive ->
            positionAnnotation.add("${index + 1}.${archive.archAnnotation}" to {
                displayNoteMenu(archive)
            })
        }
        menu.displayMenu(" Список Архивов: ", positionAnnotation)
    }


    private fun createArch() {
        println(" Введите название Архива: ")
        val archAnnotation = readLine().orEmpty()
        if (archAnnotation.isNotEmpty()) {
            val archive = Archive(archAnnotation)
            archives.add(archive)
            println(" Архив $archAnnotation создан.")
        }
        else {
            println(" У Архива должно быть название, введите название.")
        }
    displayArchMenu()
    }

    private fun displayNoteMenu(archive: Archive) {
        val logicNote = LogicNote(this, archive)
        logicNote.displayNoteMenu()

    }

    private fun exit() {
        println(" Выход из приложения")
    }
}
