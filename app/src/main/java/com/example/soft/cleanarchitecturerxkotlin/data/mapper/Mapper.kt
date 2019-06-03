package com.example.soft.cleanarchitecturerxkotlin.data.mapper

interface Mapper<E, D> {
    fun mapFromEntity(type: E): D
    //fun mapToEntity(type: D): E
}