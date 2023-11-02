package pe.cibertec.firefootstore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnAccesMain = findViewById<Button>(R.id.btnAccessMain)
        val btnRegisterMain = findViewById<Button>(R.id.btnRegisterMain)

        accessMain(btnAccesMain)
    }

    private fun accessMain(btnAccesMain: Button) {
        btnAccesMain.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}