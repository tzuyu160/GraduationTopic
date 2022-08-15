package tw.edu.pu.s1080310.graduationtopic

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_life2_6.*
import kotlinx.android.synthetic.main.activity_life2_6.ambulance3
import kotlinx.android.synthetic.main.activity_life2_6.car3
import kotlinx.android.synthetic.main.activity_life2_6.trashcar1
import kotlinx.android.synthetic.main.activity_life2_7.*

class life2_7 : AppCompatActivity() , View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life2_7)
        getSupportActionBar()?.hide();



        train3.setOnClickListener(this)
        taxi2.setOnClickListener(this)
        ship3.setOnClickListener(this)

        train3.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val alertDialog: android.app.AlertDialog.Builder =
                    android.app.AlertDialog.Builder(this@life2_7)

                alertDialog.setMessage("太棒了!!! 選對了，此交通工具為火車 ")
                alertDialog.setPositiveButton("繼續闖關",
                    DialogInterface.OnClickListener { dialog, which ->
                        intent = Intent(this@life2_7, life2_8::class.java)
                        startActivity(intent)
                        finish()
                    })
                alertDialog.setCancelable(false)
                alertDialog.show()

            }
        })


        taxi2.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val alertDialog: android.app.AlertDialog.Builder =
                    android.app.AlertDialog.Builder(this@life2_7)

                alertDialog.setMessage("此交通工具為計程車")
                alertDialog.setPositiveButton("繼續選答",
                    DialogInterface.OnClickListener { dialog, which ->

                    })
                alertDialog.setCancelable(false)
                alertDialog.show()

            }
        })

        ship3.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val alertDialog: android.app.AlertDialog.Builder =
                    android.app.AlertDialog.Builder(this@life2_7)

                alertDialog.setMessage("此交通工具為船")
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