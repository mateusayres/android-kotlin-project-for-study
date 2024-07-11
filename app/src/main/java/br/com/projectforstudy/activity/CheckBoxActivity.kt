package br.com.projectforstudy.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.projectforstudy.activity.databinding.ActivityCheckBoxBinding

class CheckBoxActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityCheckBoxBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding?.run {
            btnConcordo.setOnClickListener {
                if (cbTermo.isChecked) {
                    Toast.makeText(
                        binding.root.context,
                        "Realmente está marcado",
                        Toast.LENGTH_SHORT
                    ).show()

                } else {
                    Toast.makeText(
                        binding.root.context,
                        "Realmente não está marcado",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            cbTermo.setOnCheckedChangeListener { buttonView, isChecked ->
                if(isChecked) {
                    Toast.makeText(
                        binding.root.context,
                        "Marcado",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        binding.root.context,
                        "Não marcado",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}