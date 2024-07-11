package br.com.projectforstudy.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import br.com.projectforstudy.activity.databinding.ActivityProgressBinding

class ProgressActivity : AppCompatActivity() {

    private var isAberto = true
    private val binding by lazy {
        ActivityProgressBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding?.run {
            btnFechar.setOnClickListener {
                if(isAberto) {
                    layoutProgress.visibility = View.GONE
                    btnFechar.text = getString(R.string.str_abrir)
                    isAberto = false
                } else {
                    layoutProgress.visibility = View.VISIBLE
                    btnFechar.text = getString(R.string.str_fechar)
                    isAberto = true
                }
            }
        }
    }
}