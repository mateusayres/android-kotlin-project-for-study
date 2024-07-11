package br.com.projectforstudy.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.projectforstudy.activity.databinding.ActivityCadastroBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class CadastroActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityCadastroBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.run {
            btnSalvar.setOnClickListener {
                try {
                    validarCampo(tieNome, tilNome, getString(R.string.msg_campo_obrigatorio))
                    validarCampo(tieEmail, tilEmail, getString(R.string.msg_campo_obrigatorio))
                    validarCampo(tieSenha, tilSenha, getString(R.string.msg_campo_obrigatorio))
                    validarCampo(
                        tieConfirmaSenha,
                        tilConfirmaSenha,
                        getString(R.string.msg_campo_obrigatorio)
                    )

                    val senha = tieSenha.text.toString()
                    val confirmaSenha = tieConfirmaSenha.text.toString()

                    if (tieNome.text.toString().isNotEmpty() &&
                        tieEmail.text.toString().isNotEmpty() &&
                        tieSenha.text.toString().isNotEmpty() &&
                        tieConfirmaSenha.text.toString().isNotEmpty()
                    ) {
                        if (senha == confirmaSenha) {
                            if (cbConcordo.isChecked){
                                finishAndRemoveTask()
                                Toast.makeText(
                                    binding.root.context,
                                    getString(R.string.msg_sucesso_cadastro),
                                    Toast.LENGTH_SHORT).show()
                            } else {
                                Toast.makeText(
                                    binding.root.context,
                                    getString(R.string.msg_concorde_termos),
                                    Toast.LENGTH_SHORT).show()
                            }
                        } else {
                            tilSenha.error = getString(R.string.msg_campo_senha)
                            tilConfirmaSenha.error = getString(R.string.msg_campo_senha)
                        }
                    }
                } catch (e: Exception) {
                }
            }

            cbConcordo.setOnCheckedChangeListener { buttonView, isChecked ->
                if(cbConcordo.isChecked){
                    Toast.makeText(binding.root.context, "Obrigado por concordar", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(binding.root.context, "Por que não concorda?", Toast.LENGTH_SHORT).show()
                }
            }

            btnVoltar.setOnClickListener {
                finishAndRemoveTask()
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