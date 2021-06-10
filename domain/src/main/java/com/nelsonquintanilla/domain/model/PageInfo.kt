package com.nelsonquintanilla.domain.model

class PageInfo(
    val hasNextPage: Boolean? = false,
    val hasPreviousPage: Boolean? = false,
    val startCursor: String? = null,
    val endCursor: String? = null
)