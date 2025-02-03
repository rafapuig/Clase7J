package es.rafapuig.booksroomdemo.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import es.rafapuig.booksroomdemo.data.local.entities.BookEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged

@Dao
interface BookDao {

    @Query("SELECT * FROM books")
    suspend fun getAll(): List<BookEntity>

    @Query("SELECT * FROM books")
    suspend fun getAllObservable() : Flow<List<BookEntity>>


    @Query("SELECT * FROM books WHERE id = :bookId")
    suspend fun getBookByIdCore(bookId: Long): Flow<BookEntity>

    suspend fun getBookById(bookId: Long) = getBookByIdCore(bookId).distinctUntilChanged()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(books: List<BookEntity>)

    @Query("DROP TABLE books")
    suspend fun clear()


}