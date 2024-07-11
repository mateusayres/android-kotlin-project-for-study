package br.com.projectforstudy.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.projectforstudy.activity.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.run {
            btnEntrar.setOnClickListener{
                try {
                    validarCampo(tieLogin, tilLogin, getString(R.string.msg_campo_obrigatorio))
                    validarCampo(tieSenha, tilSenha, getString(R.string.msg_campo_obrigatorio))

                    if(tieLogin.text.toString().isNotEmpty() && tieSenha.text.toString().isNotEmpty()){
                        finishAndRemoveTask()
                        val intent = Intent(this@MainActivity,ListaActivity::class.java)
                        startActivity(intent)
                    }
                } catch (e: Exception){
                }
            }

            swSalvarLoginSenha.setOnCheckedChangeListener { buttonView, isChecked ->
                if(swSalvarLoginSenha.isChecked){
                    Toast.makeText(binding.root.context, "Login será salvo", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(binding.root.context, "Login não será salvo", Toast.LENGTH_SHORT).show()
                }
            }

            tvCadastro.setOnClickListener{
                val intent = Intent(this@MainActivity,CadastroActivity::class.java)
                startActivity(intent)
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