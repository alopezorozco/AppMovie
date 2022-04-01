package com.example.appmovie

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appmovie.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //declaramos una variable del tipo lateinit que indica
    //que más tarde se iniciará en otra parte de código
    //para este ejemplo se inicializa en la línea 24.
    private lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //inflate permite  añadir las vistas a los diseños.
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        recyclerView = binding.recyclerView

        //establecemos el tipo de layout para mostrar los botones.
        recyclerView.layoutManager = LinearLayoutManager(this)

        //llamamos al adaptador correspondiente para mostrar las categorías.
        recyclerView.adapter = CategoriaAdapter(this)
    }
}