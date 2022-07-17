package com.example.counter

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.counter.databinding.ActivityMainBinding
import com.example.counter.presenter.Presenter
import com.example.counter.view.CounterView

class MainActivity : AppCompatActivity(),CounterView {
    private lateinit var binding: ActivityMainBinding
    private var count =0
    private lateinit var presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter= Injector.getPresenter()
        presenter.attachView(this)
        initClickers()
    }

    private fun initClickers() {
        with(binding){
            incrementBtn.setOnClickListener {
                presenter.increment()

            }
            decrementBtn.setOnClickListener {
                presenter.decrement()

            }
        }
    }

    override fun updateCount(count: String) {
     binding.counterTv.text=count

    }

    override fun showToastMinus() {
       this.showToast("Поздравляю -5")
    }

    override fun showToastIncrement() {
        this.showToast("Поздравляю 10")
    }

    override fun getColor() {
       binding.counterTv.setBackgroundColor(Color.GREEN)

    }
}