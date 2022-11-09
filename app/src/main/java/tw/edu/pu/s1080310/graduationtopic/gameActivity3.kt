package tw.edu.pu.s1080310.graduationtopic

import android.content.DialogInterface
import android.content.Intent
import android.media.AudioManager
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game2.*
import kotlinx.android.synthetic.main.activity_game2.pencialbox1
import kotlinx.android.synthetic.main.activity_game3.*

private var soundPool1: SoundPool? = null
private val soundId = 1

class gameActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game3)
        getSupportActionBar()?.hide()

        soundPool1 = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool1!!.load(baseContext, R.raw.prompt, 1)

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
                soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
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
