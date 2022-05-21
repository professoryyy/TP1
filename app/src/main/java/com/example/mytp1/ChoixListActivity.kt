package com.example.mytp1

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.RecyclerView

class ChoixListActivity : AppCompatActivity() {
    private val CAT: String = "Choix_List_Activity"
    var sp: SharedPreferences? = null
    private var editor: SharedPreferences.Editor? = null
    private lateinit var recyclerview:RecyclerView
    private var btnOk : Button? = null
    private val edttext: EditText? = findViewById(R.id.edit_text_2)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choix_list)
        sp = PreferenceManager.getDefaultSharedPreferences(this)
        editor = sp?.edit()
        var boundlePseudo = this.intent.extras
        var pseudo = boundlePseudo?.getString("pseudo")
        Log.i(CAT,"pseudo de user = $pseudo")

        recyclerview = findViewById(R.id.namelist)
        btnOk = findViewById(R.id.button_Ok_2)


        onClickFun()
    }

    private fun onClickFun(){
        btnOk!!.setOnClickListener{

            if(edttext?.text.toString() != null){
                editor?.putString("listname",edttext.toString())

            }else{
                Log.i(CAT,"please enter a name for your list")
            }
        }







    }

    override fun onStart() {
        super.onStart()
        Log.i(CAT, "start")
    }

    override fun onResume() {
        super.onResume()
        Log.i(CAT, "resume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(CAT, "Restart")
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

