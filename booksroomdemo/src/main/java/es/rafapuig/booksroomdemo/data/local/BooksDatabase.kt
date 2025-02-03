package es.rafapuig.booksroomdemo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import es.rafapuig.booksroomdemo.data.local.dao.BookDao
import es.rafapuig.booksroomdemo.data.local.entities.BookEntity

@Database(entities = [BookEntity::class], version = 1)
abstract class BooksDatabase : RoomDatabase() {
    abstract fun bookDao() : BookDao
}