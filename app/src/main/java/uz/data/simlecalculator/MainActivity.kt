package uz.data.simlecalculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var display: EditText
    lateinit var numberText: String
    var number1:Int=0
    var amal:Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        val bFour = findViewById<Button>(R.id.b_four)
        val bFive = findViewById<Button>(R.id.b_five)
        val bPlus = findViewById<Button>(R.id.b_plus)
        val bMinus = findViewById<Button>(R.id.b_minus)
        val bKopaytirsh = findViewById<Button>(R.id.b_kopaytirish)
        val bBolish = findViewById<Button>(R.id.b_bolish)
        val bEqual = findViewById<Button>(R.id.b_equal)
        display = findViewById(R.id.et_display)

        bFour.setOnClickListener(this)
        bFive.setOnClickListener(this)
        bPlus.setOnClickListener(this)
        bEqual.setOnClickListener(this)
        bMinus.setOnClickListener(this)
        bKopaytirsh.setOnClickListener(this)
        bBolish.setOnClickListener(this)
    }

    override fun onClick(button: View?) {
        val id = button?.id

        if (display.text.toString() == "0") numberText = ""
        else numberText = display.text.toString()
        when (id) {
            R.id.b_four -> {
                numberText += "4"
                display.setText(numberText)
            }
            R.id.b_five -> {
                numberText += "5"
                display.setText(numberText)
            }
            R.id.b_plus -> {
                amal = 0
                number1 = display.text.toString().toInt()
                display.setText("")
            }

            R.id.b_minus -> {
                amal = 1
                number1 = display.text.toString().toInt()
                display.setText("")
            }

            R.id.b_equal -> {
                equal()
            }
        }
    }

    private fun equal() {
        var result=0
        when(amal){

            0 ->{
                result = number1 + display.text.toString().toInt()
            }

            1 ->{
                result = number1 - display.text.toString().toInt()
            }

        }
        display.setText(result.toString())

    }

}