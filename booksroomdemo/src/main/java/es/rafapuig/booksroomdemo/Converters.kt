package es.rafapuig.booksroomdemo

import es.rafapuig.booksroomdemo.data.local.entities.BookEntity
import es.rafapuig.booksroomdemo.data.network.model.BookApi
import es.rafapuig.booksroomdemo.domain.model.Book

fun BookEntity.toDomain(): Book =
    Book(this.title, cover.orEmpty())

fun BookApi.toDomain(): Book =
    Book(title, cover)

fun BookApi.toDatabase(): BookEntity =
    BookEntity(
        title = title,
        length = 0,
        cover = cover
    )