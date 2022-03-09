package com.example.data.model.mapper

interface ApiMapper<E, D> {
    fun mapToDomain(apiEntity: E): D
}