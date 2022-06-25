package tw.edu.pu.s1080310.graduationtopic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat.startActivity
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast

import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_game2_4.*
import kotlinx.android.synthetic.main.activity_game3_4.*


class gameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        getSupportActionBar()?.hide();


        val img1:ImageView = findViewById(R.id.img1)
        GlideApp.with(this)
            .load(R.drawable.pbg1)
            .into(img1)

        money.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                intent = Intent(this@gameActivity, gameActivity1::class.java)
                startActivity(intent)

            }
        })

        trafficlight.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                intent = Intent(this@gameActivity, gameActivity2::class.java)
                startActivity(intent)

            }
        })

        hospital.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                intent = Intent(this@gameActivity, gameActivity3::class.java)
                startActivity(intent)

            }
        })

        homepage4.setOnClickListener(View.OnClickListener {
            val intent = Intent()
            intent.setClass(this@gameActivity, tw.edu.pu.s1080310.graduationtopic.MainActivity::class.java)
            startActivity(intent)
        })
    }



}