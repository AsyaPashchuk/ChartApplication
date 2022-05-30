package com.example.domain.core

interface Mapper<P, R> {
    suspend fun map(param: P): R
}