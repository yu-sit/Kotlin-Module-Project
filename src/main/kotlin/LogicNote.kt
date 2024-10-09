import java.util.Scanner

class LogicNote
    (private val logicArchive: LogicArchive, private val archive: Archive) {

    fun displayNoteMenu() {
        val menu = Menu()
        val positionAnnotation = mutableListOf<Pair<String, () -> Unit>>(
            " Создать Заметку" to ::createNote,
            " Назад" to ::backTo
        )

        archive.notesList.forEachIndexed { index, note ->
            positionAnnotation.add("${index + 1}.${note.noteAnnotation}" to {
                displayNote(note)
            })
        }
        menu.displayMenu(" Список Заметок в Архиве ${archive.archAnnotation}: ", positionAnnotation)
    }

    private fun createNote() {
        println(" Введите название Заметки: ")
        val noteAnnotation = readLine().orEmpty().trim()
        if (noteAnnotation.isNotEmpty()) {
            println(" Введите содержание Заметки:")
            val noteContent = readLine().orEmpty().trim()
            if (noteContent.isNotEmpty()) {

                val note = Note(noteAnnotation, noteContent)
                archive.notesList.add(note)
                println(" Заметка $noteAnnotation создана.")
            } else {
                println(" Заметка не может быть пустой, введите содержание.")
            }
        } else {
                println(" У Заметки должно быть название.")
            }
            displayNoteMenu()
        }

    private fun displayNote(note:Note){
        println(" Заметка: ${note.noteAnnotation}")
        println(" Содержание: ${note.noteContent}")
        println(" Нажмите Enter чтобы продолжить")
        readLine()
        displayNoteMenu()
    }

    private fun backTo(){
        logicArchive.displayArchMenu()
    }

    }




