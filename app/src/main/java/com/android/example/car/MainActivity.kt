package com.android.example.car

import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.android.example.car.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myCar1: Mycar = Mycar("","","")
    private val myCar2: Mycar = Mycar("","","")
    private val myCar3: Mycar = Mycar("","","")
    private var slot: Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        hideButton()
        slot1.setBackgroundColor(Color.GRAY)
        slot2.setBackgroundColor(Color.GRAY)
        slot3.setBackgroundColor(Color.GRAY)
        binding.apply {
            slot1.setOnClickListener {
                slot = 1
                showSlot(it)
            }
            slot2.setOnClickListener {
                slot = 2
                showSlot(it)
            }
            slot3.setOnClickListener {
                slot = 3
                showSlot(it)
            }
            update.setOnClickListener {
                addCar(it)
            }
            delete.setOnClickListener {
                deleteCar(it)
            }
        }
        binding.myCar1 = myCar1
        binding.myCar2 = myCar2
        binding.myCar3 = myCar3
    }
    private fun hideButton(){
        binding.apply {
            Serial.visibility = View.GONE
            Brand.visibility = View.GONE
            Name.visibility = View.GONE
            update.visibility = View.GONE
            delete.visibility = View.GONE
        }
    }

    private fun showSlot(view: View) {
        binding.apply {
            Serial.visibility = View.VISIBLE
            Brand.visibility = View.VISIBLE
            Name.visibility = View.VISIBLE
            update.visibility = View.VISIBLE
            delete.visibility = View.VISIBLE

            if (slot == 1) {
                Serial.setText(myCar1?.serialnumber)
                Brand.setText(myCar1?.brand)
                Name.setText(myCar1?.name)
                invalidateAll()
            }
            else if (slot == 2) {
                Serial.setText(myCar2?.serialnumber)
                Brand.setText(myCar2?.brand)
                Name.setText(myCar2?.name)
                invalidateAll()
            }
            else{
                Serial.setText(myCar3?.serialnumber)
                Brand.setText(myCar3?.brand)
                Name.setText(myCar3?.name)
                invalidateAll()
            }
        }
    }

    private fun addCar(view: View){
        binding.apply {
            Serial.visibility = View.GONE
            Brand.visibility = View.GONE
            Name.visibility = View.GONE
            update.visibility = View.GONE
            delete.visibility = View.GONE

            if (slot == 1) {
                myCar1?.serialnumber = Serial.text.toString()
                myCar1?.brand = Brand.text.toString()
                myCar1?.name = Name.text.toString()
                slot1.setText("CAR")
                slot1.setBackgroundColor(Color.GREEN)
                invalidateAll()
            }
            else if (slot == 2) {
                myCar2?.serialnumber = Serial.text.toString()
                myCar2?.brand = Brand.text.toString()
                myCar2?.name = Name.text.toString()
                slot2.setText("CAR")
                slot2.setBackgroundColor(Color.GREEN)
                invalidateAll()
            }
            else{
                myCar3?.serialnumber = Serial.text.toString()
                myCar3?.brand = Brand.text.toString()
                myCar3?.name = Name.text.toString()
                slot3.setText("CAR")
                slot3.setBackgroundColor(Color.GREEN)
                invalidateAll()
            }
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken,0)
        }
    }

    private fun deleteCar(view: View) {
        binding.apply {
            Serial.visibility = View.GONE
            Brand.visibility = View.GONE
            Name.visibility = View.GONE
            update.visibility = View.GONE
            delete.visibility = View.GONE

            if (slot == 1) {
                myCar1?.serialnumber = ""
                myCar1?.brand = ""
                myCar1?.name = ""
                slot1.setText("")
                slot1.setTextColor(Color.RED)
                slot1.setBackgroundColor(Color.GRAY)
                invalidateAll()
            }
            else if (slot == 2) {
                myCar2?.serialnumber = ""
                myCar2?.brand = ""
                myCar2?.name = ""
                slot2.setText("")
                slot2.setTextColor(Color.RED)
                slot2.setBackgroundColor(Color.GRAY)
                invalidateAll()
            }
            else{
                myCar3?.serialnumber = ""
                myCar3?.brand = ""
                myCar3?.name = ""
                slot3.setText("")
                slot3.setTextColor(Color.RED)
                slot3.setBackgroundColor(Color.GRAY)
                invalidateAll()
            }
        }
    }
}
