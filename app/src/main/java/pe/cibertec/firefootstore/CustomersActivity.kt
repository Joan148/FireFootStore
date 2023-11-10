package pe.cibertec.firefootstore

import SQLLite.BDHelper
import SQLLite.CustomerAdapter
import SQLLite.CustomerViewModel
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class CustomersActivity : AppCompatActivity() {

    private val customerList = ArrayList<CustomerViewModel>()
    private val adapter = CustomerAdapter(customerList)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customers)
    }

    private fun cargarRegistrosDesdeBD() {
        customerList.clear() // Limpia la lista antes de cargar registros

        val db = BDHelper(this, null)
        val cursor = db.customerRegisters()

        if (cursor != null && cursor.moveToFirst()) {
            do {
                val namesIndex = cursor.getColumnIndex("NAMES")
                val userIndex = cursor.getColumnIndex("USER")
                val names = cursor.getString(namesIndex)
                val users = cursor.getString(userIndex)

                // Agregar los registros a la lista dinámica
                customerList.add(CustomerViewModel(R.drawable.ic_launcher_foreground, names, users))
            } while (cursor.moveToNext())
        }

        cursor?.close()

        // Notificar al adaptador que se han actualizado los datos
        adapter.notifyDataSetChanged()
    }

}