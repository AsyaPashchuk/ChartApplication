package com.example.domain.core

interface UseCase<in P, out R> {
    suspend fun execute(param: P): R
}