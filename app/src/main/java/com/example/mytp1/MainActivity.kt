package com.example.mytp1

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager


class MainActivity : AppCompatActivity() {

    private val CAT: String = "Main_Activity"
    private lateinit var sp: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    private var btnOK: Button? = null
    private var edtpseudo: EditText? = null




    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.i(CAT,"onCreate")
        sp = PreferenceManager.getDefaultSharedPreferences(this)
        editor = sp?.edit()

        btnOK = findViewById(R.id.button_ok_1)
        edtpseudo = findViewById(R.id.edit_text_1)



    }



    override fun onStart() {
        super.onStart()

        val s: String? = sp.getString("pseudo", "login inconnu")
        edtpseudo?.setText(s)

        onClickFun()

    }

    private fun onClickFun(){
        btnOK!!.setOnClickListener {

            var pseudo: String = edtpseudo?.text.toString()

            if(pseudo == ""){
                Toast.makeText(this@MainActivity, "Enter your name please", Toast.LENGTH_SHORT).show()

            }else{
                editor.putString("name",pseudo)
                editor.commit()


                val intent_to_ChoixListActivity:Intent = Intent(this, ChoixListActivity::class.java).apply { putExtra("pseudo",pseudo) }
                startActivity(intent_to_ChoixListActivity)
            }




        }
    }




    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.actionbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when(id){
            R.id.menu_settings -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }


}


