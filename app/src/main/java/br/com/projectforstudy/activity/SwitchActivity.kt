package br.com.projectforstudy.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.projectforstudy.activity.databinding.ActivitySwitchBinding

class SwitchActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivitySwitchBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding?.switchOnOff?.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                Toast.makeText(
                    binding.root.context,
                    "ON",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    binding.root.context,
                    "OFF",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}