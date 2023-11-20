package SQLLite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pe.cibertec.firefootstore.R


class CustomerAdapter(private val customerList : List<CustomerViewModel>) : RecyclerView.Adapter<CustomerAdapter.ViewHolder>(){
    class ViewHolder(ItemView : View) : RecyclerView.ViewHolder(ItemView) {
        val imageCustomer = itemView.findViewById<ImageView>(R.id.img_firefoot)
        val name = itemView.findViewById<TextView>(R.id.lbl_name)
        val user = itemView.findViewById<TextView>(R.id.lbl_user)
        val email = itemView.findViewById<TextView>(R.id.lbl_email)
        val phone = itemView.findViewById<TextView>(R.id.lbl_phone)
<<<<<<< HEAD
=======


>>>>>>> origin/master
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_customer, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomerAdapter.ViewHolder, position: Int) {
        val itemViewModel = customerList[position]
        holder.imageCustomer.setImageResource(itemViewModel.image)
        holder.name.text = itemViewModel.fullName
        holder.user.text = itemViewModel.user
        holder.email.text = itemViewModel.email
        holder.phone.text = itemViewModel.phone
    }

    override fun getItemCount(): Int {
        return customerList.size
    }


}