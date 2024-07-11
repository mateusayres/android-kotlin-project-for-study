package br.com.projectforstudy.activity

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.projectforstudy.activity.databinding.ActivitySpinnerBinding

class SpinnerActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {

    private val binding by lazy {
        ActivitySpinnerBinding.inflate(layoutInflater)
    }

    private lateinit var listaDisciplina : ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        listaDisciplina = arrayListOf("Português", "Matematica", "Ciências", "História", "Geografia","Informática")
        val arrayAdapter = ArrayAdapter(
            SpinnerActivity@this,
            android.R.layout.simple_list_item_1,
            listaDisciplina
        )

        binding?.spDisciplina?.adapter = arrayAdapter
        binding?.spDisciplina?.onItemSelectedListener = this

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        Toast.makeText(
            binding.root.context,
            "Você selecionou: "+ listaDisciplina[position],
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}