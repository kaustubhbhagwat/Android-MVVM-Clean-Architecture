package com.example.mvvmcleanarchitecture.feature_note.data.domain.util

sealed class OrderType{
    object Ascending: OrderType()
    object Descending: OrderType()
}
