package com.example.data.model

interface ApiMapper<E, D> {
    fun mapToListDomain(apiEntity: List<E>): List<D>
}