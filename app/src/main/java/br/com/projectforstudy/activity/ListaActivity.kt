package br.com.projectforstudy.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.projectforstudy.activity.databinding.ActivityListaBinding
import br.com.projectforstudy.adapter.ComponenteAdapter
import br.com.projectforstudy.modelo.Componente

class ListaActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityListaBinding.inflate(layoutInflater)
    }

    private var listaComponente = ArrayList<Componente>()
    private lateinit var componenteAdapter: ComponenteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        preencherLista()
        preencherRecycle()
    }

    private fun preencherLista(){
        val compCheckBox = Componente(
            1 ,
            "CheckBox",
            "Componente que representa uma checagem"
        )
        val compRadio = Componente(
            2,
            "Radio Group e Radio Button",
            "Componente que representa uma seleção por botão"
        )
        val compButton = Componente(
            3,
            "Button",
            "Componente que representa um botão de ação"
        )
        val compTextImput = Componente(
            4,
            "TextInputLayout e TextInputEditText",
            "Componente que representa uma caixa de texto"
        )
        val compSpinner = Componente(
            5,
            "Spinner",
            "Componente que representa uma caixa de seleção"
        )
        val compProgress = Componente(
            6,
            "ProgressBar",
            "Componente que representa uma barra de progressão"
        )
        val compSwitch = Componente(
            7,
            "Switch",
            "Componente que representa um seletor"
        )
        val compVideo = Componente(
            8,
            "Video",
            "Componente que representa um vídeo (URL) em seu app"
        )

        listaComponente.add(compCheckBox)
        listaComponente.add(compRadio)
        listaComponente.add(compButton)
        listaComponente.add(compTextImput)
        listaComponente.add(compSpinner)
        listaComponente.add(compProgress)
        listaComponente.add(compSwitch)
        listaComponente.add(compVideo)

    }

    private fun preencherRecycle(){
        componenteAdapter = ComponenteAdapter().apply {
            clickItemComponente = { position ->
                iniciarActivity(position)
            }
        }
        binding.rvComponente.adapter = componenteAdapter
        componenteAdapter.submitList(listaComponente)
    }

    private fun iniciarActivity(position: Int){
        when(position){
            0 -> {
                val intent = Intent(ListaActivity@this, CheckBoxActivity::class.java)
                startActivity(intent)
            }

            1 -> {
                val intent = Intent(ListaActivity@this, RadioActivity::class.java)
                startActivity(intent)
            }

            2 -> {
                val intent = Intent(ListaActivity@this, ButtonActivity::class.java)
                startActivity(intent)
            }

            3 -> {
                val intent = Intent(ListaActivity@this, TilTieActivity::class.java)
                startActivity(intent)
            }

            4 -> {
                val intent = Intent(ListaActivity@this, SpinnerActivity::class.java)
                startActivity(intent)
            }

            5 -> {
                val intent = Intent(ListaActivity@this, ProgressActivity::class.java)
                startActivity(intent)
            }
            6 -> {
                val intent = Intent(ListaActivity@this, SwitchActivity::class.java)
                startActivity(intent)
            }
            7 -> {
                val intent = Intent(ListaActivity@this, VideoActivity::class.java)
                startActivity(intent)
            }
        }
    }
}