package pe.cibertec.firefootstore

import SQLLite.CustomerAdapter
import SQLLite.CustomerViewModel
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class ProductosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productos)
    }

    // Inicio carga zapatillas EN REPEATERVIEW
    val productosRecycler: RecyclerView = findViewById(R.id.rv_list_zapatillas)
    productosRecycler.layoutManager = LinearLayoutManager(this)

    val data = ArrayList<CustomerViewModel>();
    //Aqui tambien podrian obtener informacion de alguna fuente para llenar DATA (como servicios, archivos, BD, etc)
    for(i in 1 .. 20){
        data.add(CustomerViewModel(R.mipmap.bg_sneaker, "Modelo de zapatilla " + i, "Descripcion " + i))
    }
    val adapter = CustomerAdapter(data)
    productosRecycler.adapter = adapter
    // Fin carga zapatillas EN REPEATERVIEW

}