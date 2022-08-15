package tw.edu.pu.s1080310.graduationtopic

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_life2_5.*
import kotlinx.android.synthetic.main.activity_life2_6.*

class life2_6 : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life2_6)
        getSupportActionBar()?.hide();



        trashcar1.setOnClickListener(this)
        ambulance3.setOnClickListener(this)
        car3.setOnClickListener(this)

        trashcar1.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val alertDialog: android.app.AlertDialog.Builder =
                    android.app.AlertDialog.Builder(this@life2_6)

                alertDialog.setMessage("太棒了!!! 選對了，此交通工具為垃圾車 ")
                alertDialog.setPositiveButton("繼續闖關",
                    DialogInterface.OnClickListener { dialog, which ->
                        intent = Intent(this@life2_6, life2_7::class.java)
                        startActivity(intent)
                        finish()
                    })
                alertDialog.setCancelable(false)
                alertDialog.show()

            }
        })


        ambulance3.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val alertDialog: android.app.AlertDialog.Builder =
                    android.app.AlertDialog.Builder(this@life2_6)

                alertDialog.setMessage("此交通工具為救護車")
                alertDialog.setPositiveButton("繼續選答",
                    DialogInterface.OnClickListener { dialog, which ->

                    })
                alertDialog.setCancelable(false)
                alertDialog.show()

            }
        })

        car3.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val alertDialog: android.app.AlertDialog.Builder =
                    android.app.AlertDialog.Builder(this@life2_6)

                alertDialog.setMessage("此交通工具為貨車")
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