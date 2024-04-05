package com.example.historyapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //declare variables
    private lateinit var searchButton: Button
    private lateinit var clearButton: Button
    private lateinit var ageInput: EditText
    private lateinit var resultView: TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //intialize
        searchButton = findViewById(R.id.searchButton)
        clearButton = findViewById(R.id.clearButton)
        ageInput = findViewById(R.id.ageInput)
        resultView = findViewById(R.id.resultView)

        searchButton.setOnClickListener {
            //create a variable of age to get value from user
            val age = ageInput.text.toString().toIntOrNull()

            //if age is not full and is in range between 10 and 100
            if (age != null && age in 10..100){
                val historicalName = when (age){
                    16 -> "Annelies (Anne) Frank, Born Jewish in Nanzi Germany had a diary documenting her life on the run"
                    21 -> "Evariste Galois, French mathematician best remembered for solving a 350 year old problem"
                    39 -> "Malcolm X, Human rights activist"
                    46 -> "John F Kennedy, 35th president of USA before being assassinated"
                    57 -> "Abraham Lincoln, Ended slavery and created a possibility of social/civil freedom for African Americans"
                    64 -> "Karl Marx, Political philosophy and one of the first to engineer communism"
                    78 -> "Mahatma Gandhi, Best know for his philosophy of non-violence which inspired many"
                    80 -> "Donatello, Famous Italian sculptor best remember for his famous work David"
                    91 -> "Harriet Tubman, Helped slaves escape while using underground tunnels"
                    95 -> "Nelson Rolihlahla Mandela, First black South African President"
                    else -> null
                }

                val message = if (historicalName != null) "The Legend's name is $historicalName :)"
                else "Oops! No legend found with entered age :("
                resultView.text = message


            }else {
                resultView.text = "Oops! Input is invalid. Please enter a valid age between 10 and 100"
            }
        }

        clearButton.setOnClickListener {
            ageInput.text.clear()
            resultView.text = ""
        }
    }
}