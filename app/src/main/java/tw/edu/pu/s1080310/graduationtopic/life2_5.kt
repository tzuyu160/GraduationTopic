package tw.edu.pu.s1080310.graduationtopic

import android.content.DialogInterface
import android.content.Intent
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_life2_4.*
import kotlinx.android.synthetic.main.activity_life2_5.*

class life2_5 : AppCompatActivity(), View.OnClickListener {

    private var soundPool2: SoundPool? = null
    private val soundId = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life2_5)
        getSupportActionBar()?.hide();

        ship2.setOnClickListener(this)
        bus2.setOnClickListener(this)
        train2.setOnClickListener(this)

        ship2.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val alertDialog: android.app.AlertDialog.Builder =
                    android.app.AlertDialog.Builder(this@life2_5)

                alertDialog.setMessage("太棒了!!! 選對了，此交通工具為船 ")
                alertDialog.setPositiveButton("繼續闖關",
                    DialogInterface.OnClickListener { dialog, which ->
                        intent = Intent(this@life2_5, life2_6::class.java)
                        startActivity(intent)
                        finish()
                    })
                alertDialog.setCancelable(false)
                alertDialog.show()

            }
        })


        bus2.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val alertDialog: android.app.AlertDialog.Builder =
                    android.app.AlertDialog.Builder(this@life2_5)

                alertDialog.setMessage("此交通工具為公車")
                alertDialog.setPositiveButton("繼續選答",
                    DialogInterface.OnClickListener { dialog, which ->

                    })
                alertDialog.setCancelable(false)
                alertDialog.show()

            }
        })

        train2.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val alertDialog: android.app.AlertDialog.Builder =
                    android.app.AlertDialog.Builder(this@life2_5)

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