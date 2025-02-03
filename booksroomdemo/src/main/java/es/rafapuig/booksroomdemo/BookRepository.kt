package es.rafapuig.booksroomdemo

import android.util.Log
import es.rafapuig.booksroomdemo.data.local.dao.BookDao
import es.rafapuig.booksroomdemo.data.network.api.BookService
import es.rafapuig.booksroomdemo.domain.model.Book
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class BookRepository(
    private val bookDao: BookDao,
    val bookService: BookService) {

    suspend fun getAllBooks() : Flow<List<Book>> {

        try {
            val books = bookService.getAllBooks()
            bookDao.clear()
            bookDao.insertAll( books.map { it.toDatabase() })

        } catch (ex : Exception) {
            Log.d("ffef", ex.message.orEmpty())
        }

        return bookDao.getAllObservable().map { list ->
            list.map { it.toDomain() }
        }
    }

}