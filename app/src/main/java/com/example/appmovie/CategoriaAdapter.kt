package com.example.appmovie

import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Settings.Global.getString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityNodeInfo
import android.widget.Button
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView

class CategoriaAdapter (context: Context):
    RecyclerView.Adapter<CategoriaAdapter.CategoriaViewHolder>(){

        //creamos un objeto de tipo Resources
        private val listaCategorias : List<String>

        init{
             listaCategorias = context.resources.getStringArray(R.array.categorias).toList()
        }

    /**
     * Proveemos una referencia a las vistas necesarias para mostrar la lista
     * de items
     */
    class CategoriaViewHolder(val view : View) : RecyclerView.ViewHolder(view){
        val button = view.findViewById<Button>(R.id.button_item)
    }

    /**
     * Crea nuevas views con R.layout.item_view como template
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriaViewHolder {
        var layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_view, parent, false)

        //configura la accessibility para la lectura de texto
        layout.accessibilityDelegate = Accessibility

        return CategoriaViewHolder(layout)
    }

    /**
     * Reemplaza el contenido de un existente view con nuevos datos
     */
    override fun onBindViewHolder(holder: CategoriaViewHolder, position: Int) {
        val item = listaCategorias.get(position)
        holder.button.text = item.toString()

        holder.button.setOnClickListener {
            val context = holder.view.context

            val intent = Intent(context, DetailActivity::class.java)

            intent.putExtra(DetailActivity.GENERO, holder.button.text.toString())

            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return listaCategorias.size
    }

    // Setup custom accessibility delegate to set the text read with
    // an accessibility service
    companion object Accessibility : View.AccessibilityDelegate() {
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun onInitializeAccessibilityNodeInfo(
            host: View?,
            info: AccessibilityNodeInfo?
        ) {
            super.onInitializeAccessibilityNodeInfo(host, info)
            // With `null` as the second argument to [AccessibilityAction], the
            // accessibility service announces "double tap to activate".
            // If a custom string is provided,
            // it announces "double tap to <custom string>".
            val customString = host?.context?.getString(R.string.look_up_movies)
            val customClick =
                AccessibilityNodeInfo.AccessibilityAction(
                    AccessibilityNodeInfo.ACTION_CLICK,
                    customString
                )
            info?.addAction(customClick)
        }
    }
}