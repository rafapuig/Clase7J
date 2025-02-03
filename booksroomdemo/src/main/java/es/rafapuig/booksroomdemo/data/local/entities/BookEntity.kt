package es.rafapuig.booksroomdemo.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
data class BookEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title : String,
    val length: Int,
    val cover : String? = null
)
