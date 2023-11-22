package pe.cibertec.firefootstore.ZapatillasREST

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pe.cibertec.firefootstore.R

class ZapatillaAdapter (private val myList: List<ZapatillaViewModel>):RecyclerView.Adapter<ZapatillaAdapter.ViewHolder>(){
    class ViewHolder(ItemView:View):RecyclerView.ViewHolder(ItemView){
        val imageView:ImageView = ItemView.findViewById(R.id.img_zapatilla)
        val nombre:TextView = ItemView.findViewById(R.id.txt_nombreZap)
        val descripcion:TextView = ItemView.findViewById(R.id.txt_descripcionZap)
        val marca:TextView = ItemView.findViewById(R.id.txt_marcaZap)
        val precio:TextView = ItemView.findViewById(R.id.txt_precioZap)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_zapatilla,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val zapatilla_viewModel =myList[position]
        holder.imageView.setImageResource(zapatilla_viewModel.image)
        holder.nombre.text = zapatilla_viewModel.nombre
        holder.descripcion.text = zapatilla_viewModel.descripcion
        holder.marca.text = zapatilla_viewModel.marca
        holder.precio.text = zapatilla_viewModel.precio
    }

}