data class Archive(val archAnnotation: String, val notesList: MutableList<Note> = mutableListOf())
data class Note(val noteAnnotation: String, val noteContent: String)

