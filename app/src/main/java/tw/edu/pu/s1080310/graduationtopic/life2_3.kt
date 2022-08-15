package tw.edu.pu.s1080310.graduationtopic

import android.content.DialogInterface
import android.content.Intent
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_life2_2.*
import kotlinx.android.synthetic.main.activity_life2_3.*

class life2_3 : AppCompatActivity() , View.OnClickListener{

    private var soundPool2: SoundPool? = null
    private val soundId = 1


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life2_3)
        getSupportActionBar()?.hide();


        policecar1.setOnClickListener(this)
        bike1.setOnClickListener(this)
        train.setOnClickListener(this)




        policecar1.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val alertDialog: android.app.AlertDialog.Builder =
                    android.app.AlertDialog.Builder(this@life2_3)

                alertDialog.setMessage("太棒了!!! 選對了，此交通工具為警車 ")
                alertDialog.setPositiveButton("繼續闖關",
                    DialogInterface.OnClickListener { dialog, which ->
                        intent = Intent(this@life2_3, life2_4::class.java)
                        startActivity(intent)
                        finish()
                    })
                alertDialog.setCancelable(false)
                alertDialog.show()

            }
        })


        ship.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val alertDialog: android.app.AlertDialog.Builder =
                    android.app.AlertDialog.Builder(this@life2_3)

                alertDialog.setMessage("此交通工具為腳踏車")
                alertDialog.setPositiveButton("繼續選答",
                    DialogInterface.OnClickListener { dialog, which ->

                    })
                alertDialog.setCancelable(false)
                alertDialog.show()

            }
        })


        train.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val alertDialog: android.app.AlertDialog.Builder =
                    android.app.AlertDialog.Builder(this@life2_3)

                alertDialog.setMessage("此交通工具為火車")
                alertDialog.setPositiveButton("繼續選答",
                    DialogInterface.OnClickListener { dialog, which ->

                    })
                alertDialog.setCancelable(false)
                alertDialog.show()

            }
        })


    }

    override fun onClick(p0: View?) {

    }
}