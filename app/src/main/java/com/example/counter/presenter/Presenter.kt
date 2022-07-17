package com.example.counter.presenter

import com.example.counter.Injector

import com.example.counter.view.CounterView

class Presenter {
    private val model =Injector.getModel()
    private lateinit var view :CounterView

    fun increment(){
        model.increment()
        view.updateCount(model.getCount().toString())
        if (model.getCount()==+10){
            view.showToastIncrement()
        }
        if (model.getCount() == +15){
            view.getColor()
        }
    }

    fun decrement(){
        model.decrement()
        view.updateCount(model.getCount().toString())
        if (model.getCount()==-5){
            view.showToastMinus()
        }
    }
    fun attachView(view: CounterView){
        this.view=view

    }
}
