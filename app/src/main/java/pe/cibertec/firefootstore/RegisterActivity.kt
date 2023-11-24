package pe.cibertec.firefootstore

import SQLLite.BDHelper
import SQLLite.CustomerAdapter
import SQLLite.CustomerViewModel
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RegisterActivity : AppCompatActivity() {
    private lateinit var customerRecycler: RecyclerView
    private lateinit var adapter: CustomerAdapter
    private val registroList = ArrayList<CustomerViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        customerRecycler = findViewById(R.id.recyclerViewClientes)
        customerRecycler.layoutManager = LinearLayoutManager(this)

        // Configurar el RecyclerView con el adaptador
        adapter = CustomerAdapter(registroList)
        customerRecycler.adapter = adapter

        val btnGrabar: Button = findViewById(R.id.btnRegisterCustom)
        val btnIrIniciarSesion: Button = findViewById(R.id.btnIrLogin)

        btnIrIniciarSesion.setOnClickListener{
            val loginScreen= Intent(this, LoginActivity::class.java)
            startActivity(loginScreen)
        }

        btnGrabar.setOnClickListener {
            val txtFullName: EditText = findViewById(R.id.RegisterTxtNames)
            val txtUser: EditText = findViewById(R.id.RegisterTxtUser)
            val txtEmail: EditText = findViewById(R.id.RegisterTxtEmail)
            val txtPhone: EditText = findViewById(R.id.RegisterTxtPhone)

            val fullName = txtFullName.text.toString()
            val user = txtUser.text.toString()
            val email = txtEmail.text.toString()
            val phone = txtPhone.text.toString()

            val db = BDHelper(this, null)

            db.createRegister(fullName, user, email, phone)
            Toast.makeText(this, "Registro guardado", Toast.LENGTH_SHORT).show()
            txtFullName.text.clear()
            txtUser.text.clear()
            txtEmail.text.clear()
            txtPhone.text.clear()
            // Llama a cargarRegistrosDesdeBD() para actualizar la lista
            cargarRegistrosDesdeBD()
        }
        val btnLimpiar: Button = findViewById(R.id.btnLimpiar)
        btnLimpiar.setOnClickListener {
            val db = BDHelper(this, null)

            // Borra los registros de la base de datos
            db.clearRegisters()

            // Borra los registros de la lista
            registroList.clear()

            // Notificar al adaptador que se han actualizado los datos
            adapter.notifyDataSetChanged()
        }

    }

    private fun cargarRegistrosDesdeBD() {
        registroList.clear() // Limpia la lista antes de cargar registros

        val db = BDHelper(this, null)
        val cursor = db.customerRegisters()

        if (cursor != null && cursor.moveToFirst()) {
            do {
                val fullnameIndex = cursor.getColumnIndex("NAMES")
                val userIndex = cursor.getColumnIndex("USER")
                val emailIndex = cursor.getColumnIndex("EMAIL")
                val phoneIndex = cursor.getColumnIndex("PHONE")

                val fName = cursor.getString(fullnameIndex)
                val usuario = cursor.getString(userIndex)
                val email = cursor.getString(emailIndex)
                val phone = cursor.getString(phoneIndex)

                // Agregar los registros a la lista dinámica
                registroList.add(CustomerViewModel(R.drawable.ic_launcher_foreground, fName, usuario, email, phone))

            } while (cursor.moveToNext())
        }
        cursor?.close()
        // Notificar al adaptador que se han actualizado los datos
        adapter.notifyDataSetChanged()
    }

}