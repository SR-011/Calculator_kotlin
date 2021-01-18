package com.sr.mycalculator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

   fun buNumEvent(view: View) {

        var etv: EditText = findViewById(R.id.et_v)
        if(newOp){
            etv.setText("")
        }
        newOp=false
        val buSelected: Button = view as Button
        var buClickVal: String = etv.text.toString()
        when (buSelected.id) {
            R.id.bu0 -> {
                buClickVal += "0"
            }
            R.id.bu1 -> {
                buClickVal += "1"
            }
            R.id.bu2 -> {
                buClickVal += "2"
            }
            R.id.bu3 -> {
                buClickVal += "3"
            }
            R.id.bu4 -> {
                buClickVal += "4"
            }
            R.id.bu5 -> {
                buClickVal += "5"
            }
            R.id.bu6 -> {
                buClickVal += "6"
            }
            R.id.bu7 -> {
                buClickVal += "7"
            }
            R.id.bu8 -> {
                buClickVal += "8"
            }
            R.id.bu9 -> {
                buClickVal += "9"
            }
            R.id.buDot -> {
                buClickVal += "."
            }
            R.id.buPlusMinus -> {
                buClickVal = "-" + buClickVal
            }
        }
        etv.setText(buClickVal)
    }
    var op=""
    var oldNum=""
    var newOp=true
    fun buOp(view: View) {
        var etv: EditText = findViewById(R.id.et_v)
        val buSelected: Button = view as Button
        when (buSelected.id) {
            R.id.buMul -> {
                op="*"
            }
            R.id.buDiv -> {
                op="/"
            }
            R.id.buSub -> {
                op="-"
            }
            R.id.buSum -> {
                op="+"
            }
        }
        oldNum=etv.text.toString()
        newOp=true
    }

    fun equalEvent(view: View) {
        var etv: EditText = findViewById(R.id.et_v)
        var newNum=etv.text.toString()
        var finalNum:Double?=null
        when(op){
            "*"->{finalNum=oldNum.toDouble()*newNum.toDouble()}
            "/"->{finalNum=oldNum.toDouble()/newNum.toDouble()}
            "-"->{finalNum=oldNum.toDouble()-newNum.toDouble()}
            "+"->{finalNum=oldNum.toDouble()+newNum.toDouble()}
        }
        etv.setText(finalNum.toString())
        newOp=true
    }

    fun perEvent(view: View) {
        var etv:EditText=findViewById(R.id.et_v)
        val num:Double=etv.text.toString().toDouble()/100
        etv.setText(num.toString())
        newOp=true
    }

    fun cleanEvent(view: View) {
        var etv:EditText=findViewById(R.id.et_v)
        etv.setText("0")
        newOp=true
    }

}
