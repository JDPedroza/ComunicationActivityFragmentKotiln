package com.example.comunicationactivityfragmentkotiln

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar

import kotlinx.android.synthetic.main.activity_main.*
import com.example.comunicationactivityfragmentkotiln.controller.activity.MainActivityController
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity(), MainFragment.OnNumeroAleatorio {

    val mainFrag: MainFragment = MainFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar as Toolbar?)
        MainActivityController.addFragment(supportFragmentManager, contenedorFragment, mainFrag)

        fab.setOnClickListener { view ->
            try{
                MainActivityController.actualizarNumeroAleatorio(mainFrag, etMin, etMax)
            }catch (e: Exception){
                Snackbar.make(fab, getString(R.string.error_limites), Snackbar.LENGTH_LONG).show()
            }

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                Snackbar.make(fab, getString(R.string.action_settings), Snackbar.LENGTH_LONG).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun actualizado(numero: Int) {
        Snackbar.make(fab, getString(R.string.numero_aleatorio_actualizado, numero.toString()), Snackbar.LENGTH_LONG).show()
    }
}
