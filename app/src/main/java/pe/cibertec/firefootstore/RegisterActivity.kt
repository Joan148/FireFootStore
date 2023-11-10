package pe.cibertec.firefootstore

import SQLLite.CustomerAdapter
import SQLLite.CustomerViewModel
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView

class RegisterActivity : AppCompatActivity() {
    private lateinit var customerRecycler: RecyclerView
    private lateinit var adapter: CustomerAdapter
    private val registroList = ArrayList<CustomerViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)




        val btnRegistrar: Button = findViewById(R.id.btnRegisterCustom)
        btnRegistrar.setOnClickListener {
            val txtFullNames = findViewById<EditText>(R.id.RegisterTxtNames)
            val txtUser = findViewById<EditText>(R.id.RegisterTxtUser)
            val txtPwd = findViewById<EditText>(R.id.RegisterTxtPwd)
            val txtEmail = findViewById<EditText>(R.id.RegisterTxtEmail)
            val txtPhone = findViewById<EditText>(R.id.RegisterTxtPhone)

            val names = txtFullNames.text.toString()
            val user = txtUser.text.toString()
            val pwd = txtPwd.text.toString()
            val email = txtEmail.text.toString()
            val phone = txtPhone.text.toString()
        }

        val btnSeeCustomers: Button = findViewById(R.id.btnSeeCustomers)
        btnSeeCustomers.setOnClickListener {
            val intent = Intent(this, CustomersActivity::class.java)
            startActivity(intent)
        }

    }
}