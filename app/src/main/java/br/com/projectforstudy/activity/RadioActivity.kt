package br.com.projectforstudy.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.projectforstudy.activity.databinding.ActivityRadioBinding

class RadioActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityRadioBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding?.run {
            btnContinuar.setOnClickListener {
                when (rgTermo.checkedRadioButtonId){
                    R.id.rbSim -> {
                        Toast.makeText(binding.root.context, "Você concordou com os termos", Toast.LENGTH_SHORT).show()
                    }
                    R.id.rbNao -> {
                        Toast.makeText(
                            binding.root.context,
                            "Você não concordou com os termos",
                            Toast.LENGTH_LONG
                        ).show()
                    } else -> Toast.makeText(binding.root.context, "Selecione primeiro", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
