package com.example.exercise3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnClear: Button = findViewById(R.id.buttonReset)
        btnClear.setOnClickListener {onClear()}

        val btnCalculate: Button = findViewById(R.id.buttonCalculate)
        btnCalculate.setOnClickListener {onCalculateInsurance()}

        //This option will be the default value
        radioGroupGender.check(radioButtonMale.id)
    }
@Override
    private fun onCalculateInsurance() {

    val age: Spinner = findViewById(R.id.spinnerAge)
    val gender: RadioGroup = findViewById(R.id.radioGroupGender)
    //val male: RadioButton = findViewById(R.id.radioButtonMale)
    //val female: RadioButton = findViewById(R.id.radioButtonFemale)
    val smoker: CheckBox = findViewById(R.id.checkBoxSmoker)
    val result: TextView = findViewById(R.id.textViewPremium)
    val radio: RadioButton = findViewById(gender.checkedRadioButtonId)


//    if (age.selectedItemPosition == 0){
//
//        result.text = "Insurance Premium :RM" + 60
//    }else if (age.selectedItemPosition == 1 ){
//
//        result.text = "Insurance Premium : RM" + 70
//    }else if (radio == radioButtonMale){
//
//        result.text = "Insurance Premium : RM" + 120
//
//    }else {
//
//    }

    when {
        age.selectedItemPosition == 0 -> result.text = "Insurance Premium : RM" + 60

        age.selectedItemPosition == 1 && radio == radioButtonMale && !smoker.isChecked-> result.text = "Insurance Premium : RM" + 120
        age.selectedItemPosition == 1 && radio == radioButtonMale && smoker.isChecked -> result.text = "Insurance Premium : RM" + 220
        age.selectedItemPosition == 1 && radio == radioButtonFemale && !smoker.isChecked -> result.text = "Insurance Premium : RM" + 70
        age.selectedItemPosition == 1 && radio == radioButtonFemale && smoker.isChecked -> result.text = "Insurance Premium : RM" + 170

        age.selectedItemPosition == 2 && radio == radioButtonMale && !smoker.isChecked -> result.text = "Insurance Premium : RM" + 190
        age.selectedItemPosition == 2 && radio == radioButtonMale && smoker.isChecked -> result.text = "Insurance Premium : RM" + 340
        age.selectedItemPosition == 2 && radio == radioButtonFemale && !smoker.isChecked -> result.text = "Insurance Premium : RM" + 90
        age.selectedItemPosition == 2 && radio == radioButtonFemale && smoker.isChecked -> result.text = "Insurance Premium : RM" + 140

        age.selectedItemPosition == 3 && radio == radioButtonMale && !smoker.isChecked -> result.text = "Insurance Premium : RM" + 270
        age.selectedItemPosition == 3 && radio == radioButtonMale && smoker.isChecked -> result.text = "Insurance Premium : RM" + 470
        age.selectedItemPosition == 3 && radio == radioButtonFemale && !smoker.isChecked -> result.text = "Insurance Premium : RM" + 120
        age.selectedItemPosition == 3 && radio == radioButtonFemale && smoker.isChecked -> result.text = "Insurance Premium : RM" + 220

        age.selectedItemPosition == 4 && radio == radioButtonMale && !smoker.isChecked -> result.text = "Insurance Premium : RM" + 350
        age.selectedItemPosition == 4 && radio == radioButtonMale && smoker.isChecked -> result.text = "Insurance Premium : RM" + 600
        age.selectedItemPosition == 4 && radio == radioButtonFemale && !smoker.isChecked -> result.text = "Insurance Premium : RM" + 150
        age.selectedItemPosition == 4 && radio == radioButtonFemale && smoker.isChecked -> result.text = "Insurance Premium : RM" + 400

        age.selectedItemPosition == 5 && radio == radioButtonMale && !smoker.isChecked -> result.text = "Insurance Premium : RM" + 350
        age.selectedItemPosition == 5 && radio == radioButtonMale && smoker.isChecked -> result.text = "Insurance Premium : RM" + 650
        age.selectedItemPosition == 5 && radio == radioButtonFemale && !smoker.isChecked -> result.text = "Insurance Premium : RM" + 150
        age.selectedItemPosition == 5 && radio == radioButtonFemale && smoker.isChecked -> result.text = "Insurance Premium : RM" + 450

        else -> Toast.makeText(this, "Please choose correctly!", Toast.LENGTH_SHORT).show()

    }

}


@Override
    private fun onClear() {
        val age: Spinner = findViewById(R.id.spinnerAge)
        age.setSelection(0)

        val gender: RadioGroup = findViewById(R.id.radioGroupGender)
        gender.clearCheck()

        val smoker: CheckBox = findViewById(R.id.checkBoxSmoker)
        if (smoker.isChecked()) {
            smoker.setChecked(false);
        }
        val result: TextView = findViewById(R.id.textViewPremium)
        result.text = "Insurance Premium : "
    }
}
