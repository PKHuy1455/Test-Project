package com.example.a22ceb012_phankhachuy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.a22ceb012_phankhachuy.databinding.ActivityFunction1Binding
import com.example.a22ceb012_phankhachuy.databinding.ActivityFunction2Binding

class Function2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_function2)
        val view:ActivityFunction2Binding = DataBindingUtil.setContentView(this,R.layout.activity_function2)


        view.bthCal.setOnClickListener {
            val a = view.edtA.text.toString().toDouble()
            val b = view.edtB.text.toString().toDouble()
             val resutl =  giaiPhuongTrinhBacMot(a,b)
            view.txtResutl.text = resutl
        }

    }
    fun giaiPhuongTrinhBacMot(a: Double, b: Double): String {
        return if (a == 0.0) {
            if (b == 0.0) {
                "Phương trình có vô số nghiệm."
            } else {
                "Phương trình vô nghiệm."
            }
        } else {
            val x = -b / a
            "Nghiệm của phương trình là: x = $x"
        }
    }
}