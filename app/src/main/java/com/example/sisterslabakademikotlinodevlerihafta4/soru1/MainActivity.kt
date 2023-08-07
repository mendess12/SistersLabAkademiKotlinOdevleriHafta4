package com.example.sisterslabakademikotlinodevlerihafta4.soru1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.sisterslabakademikotlinodevlerihafta4.R
import com.example.sisterslabakademikotlinodevlerihafta4.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        /*
        * ConstraintLayout kullanarak rehbere numara kaydetme ekranı tasarlanacak bir imageView,
        * Kaydet butonu ,iki tane edittext alanı ad ve telefon numarası girilecek.
        * Telefon numarası alanına sadece numara girebilsin.
        * EditTextler boş olduğunda uyarı versin boş alanları doldurun şeklinde alanlar doldurulduktan sonra
        * “Kaydet” butonuna basıldığında sonraki sayfaya yönlendirsin ve numara başarılı bir şekilde kaydedildi texti görünsün
        * */

        val name = binding.nameEt.text
        val phoneNumber = binding.phoneNumberEt.text

        binding.saveButton.setOnClickListener {
            if (name.isEmpty() || phoneNumber.isEmpty()) {
                snackbar(it)
            } else {
                val saveIntent = Intent(this@MainActivity, HomeActivity::class.java)
                startActivity(saveIntent)
            }
        }
    }

    private fun snackbar(view: View) {
        val snackbar =
            Snackbar.make(view, R.string.snackbar_message, Snackbar.LENGTH_LONG)
        snackbar.setBackgroundTint(resources.getColor(R.color.button_background))
        snackbar.setTextColor(resources.getColor(R.color.button_text_color))
        snackbar.show()
    }
}