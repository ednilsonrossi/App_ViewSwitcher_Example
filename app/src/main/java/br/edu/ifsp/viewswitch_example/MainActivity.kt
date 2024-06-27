package br.edu.ifsp.viewswitch_example

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.app.AppCompatActivity

import br.edu.ifsp.viewswitch_example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var showFirstView = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configViewSwitch()
        binding.buttonSwitch.setOnClickListener(this)
    }


    /**
     * Método configura a forma de troca entre as view da activity,
     * lembrando que temos apenas 2 view e a troca é tratada como
     * uma animação. Essa configuração é opcional, apenas anima a
     * troca entre as views, teste o app sem essa configuração.
     */
    private fun configViewSwitch() {
        binding.viewSwitcher.apply {
            setInAnimation(this@MainActivity, android.R.anim.fade_in)
            setOutAnimation(this@MainActivity, android.R.anim.fade_out)
        }
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_switch) {
            /*
            Ao clicar no botão é feita troca das view, sempre indo para frente
            com o método showNext() e voltando para trás com o método
            showPrevious() do viewSwitcher.
             */
            if (showFirstView) {
                binding.viewSwitcher.showNext()
            } else {
                binding.viewSwitcher.showPrevious()
            }
            showFirstView = !showFirstView
        }
    }
}