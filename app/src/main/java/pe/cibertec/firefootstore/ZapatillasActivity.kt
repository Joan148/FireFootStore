package pe.cibertec.firefootstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import pe.cibertec.firefootstore.ZapatillasREST.RetrofitHelper
import pe.cibertec.firefootstore.ZapatillasREST.ZapatillaAdapter
import pe.cibertec.firefootstore.ZapatillasREST.ZapatillaViewModel
import pe.cibertec.firefootstore.ZapatillasREST.ZapatillasAPI
import retrofit2.create

class ZapatillasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zapatillas)

        val zapatilla_api = RetrofitHelper.getRetrofitInstance().create(ZapatillasAPI::class.java)
        GlobalScope.launch {
            val result = zapatilla_api.getQuotes()
            if (result!=null){
                val zapatillas = result.body()
                Log.d("ZAPATILLAS_SIZE", "Tamaño de la lista de zapatillas: ${zapatillas?.size}")
                if(zapatillas!=null){
                    val data = mutableListOf<ZapatillaViewModel>()
                    Log.d("ZapatillaAdapter", "Número de elementos en la lista: ${zapatillas.size}")
                    for(item in zapatillas){
                        val zapatilla = ZapatillaViewModel(
                            image = R.mipmap.ic_launcher,
                            nombre = item.nombre,
                            marca = item.marca,
                            descripcion = item.descripcion,
                            precio = item.precio
                        )
                        data.add(zapatilla)
                    }
        /*val data = mutableListOf<ZapatillaViewModel>()
        for(item in 1..3) {
            data.add(ZapatillaViewModel(R.mipmap.ic_launcher, "Zapatilla 1", "Marca 1", "Descripción 1", 99.99))
        }*/
                    val rv_zapatilla:RecyclerView = findViewById(R.id.rv_zapatillas)
                    rv_zapatilla.layoutManager = LinearLayoutManager(this@ZapatillasActivity)
                    val adapter = ZapatillaAdapter(data)
                    rv_zapatilla.adapter = adapter

                }
            }
        }
    }
}