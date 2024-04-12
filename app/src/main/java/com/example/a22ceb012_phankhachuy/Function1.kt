package com.example.a22ceb012_phankhachuy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.a22ceb012_phankhachuy.databinding.ActivityFunction1Binding
import com.example.a22ceb012_phankhachuy.databinding.MainActivityBinding

class Function1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       val view1:ActivityFunction1Binding = DataBindingUtil.setContentView(this,R.layout.activity_function1)

        view1.btnCheck.setOnClickListener {
            val edttxt = view1.edttext.text.toString().toInt()

            val result = if (isPrime(edttxt)) {
                "Số $edttxt không phải là số nguyên tố"
            } else {
                "Số $edttxt là số nguyên tố"
            }
            view1.txtResutl.text = result
        }



    }

    fun isPrime(number: Int): Boolean {
        if (number <= 1) {
            return false
        }
        for (i in 2 until number) {
            if (number % i == 0) {
                return false
            }
        }
        return true
    }

}