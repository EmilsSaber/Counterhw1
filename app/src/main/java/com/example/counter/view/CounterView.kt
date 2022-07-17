package com.example.counter.view

interface CounterView {
    fun updateCount(count: String)
    fun showToastMinus()
    fun showToastIncrement()
    fun getColor()

}