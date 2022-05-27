package tw.edu.pu.s1080310.graduationtopic

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game2.*
import kotlinx.android.synthetic.main.activity_game2.pencialbox1
import kotlinx.android.synthetic.main.activity_game3.*

class gameActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game3)
        getSupportActionBar()?.hide()



        val img14: ImageView = findViewById(R.id.img14)
        GlideApp.with(this)
            .load(R.drawable.drawbackground)
            .into(img14)



        pencialbox4.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                intent = Intent(this@gameActivity3, gameActivity3_1::class.java)
                startActivity(intent)
                finish()

            }
        })

        light3.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val alertDialog: android.app.AlertDialog.Builder =
                    android.app.AlertDialog.Builder(this@gameActivity3)
                alertDialog.setTitle("操作說明")
                alertDialog.setMessage("點擊下方筆筒進入繪圖區，沿圖案虛線進行描繪")
                alertDialog.setPositiveButton("確定",
                    DialogInterface.OnClickListener { dialog, which ->
                        Toast.makeText(
                            baseContext,
                            "確定",
                            Toast.LENGTH_SHORT
                        ).show()
                    })
                alertDialog.setCancelable(false)
                alertDialog.show()

            }
        })
    }
}
