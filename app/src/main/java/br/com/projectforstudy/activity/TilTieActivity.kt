package br.com.projectforstudy.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.projectforstudy.activity.databinding.ActivityTilTieBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class TilTieActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityTilTieBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.run {
            btnConfirmar.setOnClickListener {
                validarCampo(tieNome, tilNome, getString(R.string.msg_campo_obrigatorio))
                if (tieNome.text.toString().isNotEmpty()) {
                    Toast.makeText(
                        binding.root.context,
                        "Obrigado " + tieNome.text,
                        Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun validarCampo(
        tie: TextInputEditText?,
        til: TextInputLayout?,
        msgError: String?
    ){
        if(tie?.text?.toString()?.isNotEmpty() == true){
            til?.error = null
        } else {
            til?.error = msgError
        }
    }
}