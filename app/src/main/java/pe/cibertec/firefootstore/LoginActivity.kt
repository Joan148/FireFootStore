package pe.cibertec.firefootstore

import SQLLite.BDHelper
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val inputUsuario: EditText =findViewById(R.id.LoginTxtUser)
        val inputContrasena: EditText =findViewById(R.id.LoginTxtPwd)

        val btnLogin: Button =findViewById(R.id.btnAccederLogin)

        val btnNoMeRegistre : Button = findViewById(R.id.btnNoMeRegistre)

        btnNoMeRegistre.setOnClickListener{
            val loginScreen= Intent(this, RegisterActivity::class.java)
            startActivity(loginScreen)
        }

        btnLogin.setOnClickListener {

            val usuario = inputUsuario.text.toString()
            val email = inputContrasena.text.toString()

            val bd = BDHelper(this, null)
            val cursor = bd.Acceder(usuario, email)

            if (cursor!!.count <= 0) {
                Toast.makeText(this, "Usuario y/o contraseña incorrecta", Toast.LENGTH_LONG).show()
            } else {
                /*
                cursor!!.moveToFirst()
                val usuarioIndex = cursor.getColumnIndex("USER")
                val usuario = cursor.getString(usuarioIndex)
                */
                // cambiar redireccion, ojo "NO ES HACIA MAINACTIVITY"
                val productScreen = Intent(this, ZapatillasActivity::class.java)
                startActivity(productScreen)

            }
        }
    }
}