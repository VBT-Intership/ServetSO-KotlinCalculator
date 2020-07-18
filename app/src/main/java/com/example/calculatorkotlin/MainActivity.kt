package com.example.calculatorkotlin

//import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Numbers
        numberOne.setOnClickListener { appendOnExpresstion("1", true) }
        numberTwo.setOnClickListener { appendOnExpresstion("2", true) }
        numberThree.setOnClickListener { appendOnExpresstion("3", true) }
        numberFour.setOnClickListener { appendOnExpresstion("4", true) }
        numberFive.setOnClickListener { appendOnExpresstion("5", true) }
        numberSix.setOnClickListener { appendOnExpresstion("6", true) }
        numberSeven.setOnClickListener { appendOnExpresstion("7", true) }
        numberEight.setOnClickListener { appendOnExpresstion("8", true) }
        numberNine.setOnClickListener { appendOnExpresstion("9", true) }
        numberZero.setOnClickListener { appendOnExpresstion("0", true) }
        textDot.setOnClickListener { appendOnExpresstion(".", true) }

        //Operators
        textPlus.setOnClickListener { appendOnExpresstion("+", false) }
        textMinus.setOnClickListener { appendOnExpresstion("-", false) }
        tvMul.setOnClickListener { appendOnExpresstion("*", false) }
        textDivide.setOnClickListener { appendOnExpresstion("/", false) }
        textPercent.setOnClickListener { appendOnExpresstion("%", false) }
        textOpen.setOnClickListener { appendOnExpresstion("(", false) }
        textClose.setOnClickListener { appendOnExpresstion(")", false) }

        textClear.setOnClickListener {
            tvExpression.text = ""
            tvResult.text = ""
        }



        textEquals.setOnClickListener {
            try {

                val expression = ExpressionBuilder(tvExpression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if(result == longResult.toDouble())
                    tvResult.text = longResult.toString()
                else
                    tvResult.text = result.toString()

            }catch (e:Exception){
                Log.d("Exception"," message : " + e.message )
            }
        }

    }

    fun appendOnExpresstion(string: String, canClear: Boolean) {

        if(tvResult.text.isNotEmpty()){
            tvExpression.text = ""
        }

        if (canClear) {
            tvResult.text = ""
            tvExpression.append(string)
        } else {
            tvExpression.append(tvResult.text)
            tvExpression.append(string)
            tvResult.text = ""
        }
    }
}