package SQLLite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pe.cibertec.firefootstore.R

class CustomAdapter (private val mList: List<CustomerItemsModel>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(ItemView :View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = ItemView.findViewById(R.id.img_firefoot)
        val nombrePrincipal: TextView = ItemView.findViewById(R.id.lbl_nombre_zap)
        val descripcionPrincipal: TextView = ItemView.findViewById(R.id.lbl_descripcion_zap)
        val descripcionSecundaria: TextView = ItemView.findViewById(R.id.lbl_precio_zap)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_zapatillas, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //Si deseo alguna conexion PODRIA SER AQUI (BD, SERVICIO WEB, ETC
        val itemViewModel = mList[position]

        holder.imageView.setImageResource(itemViewModel.image)
        holder.nombrePrincipal.text = itemViewModel.modelo
        holder.descripcionPrincipal.text = itemViewModel.titulo
        holder.descripcionSecundaria.text = itemViewModel.descripcion

    }
}