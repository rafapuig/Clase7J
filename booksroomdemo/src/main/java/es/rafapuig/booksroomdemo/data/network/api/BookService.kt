package es.rafapuig.booksroomdemo.data.network.api

import es.rafapuig.booksroomdemo.data.network.model.BookApi

interface BookService {
    suspend fun getAllBooks() : List<BookApi>
}