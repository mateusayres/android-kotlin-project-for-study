package br.com.projectforstudy.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.projectforstudy.activity.databinding.ActivityButtonBinding

class ButtonActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityButtonBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding?.run {
            btnToque.setOnClickListener {
                Toast.makeText(
                    binding.root.context,
                    "Obrigado por tocar",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}