package tw.edu.pu.s1080310.graduationtopic

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game1.*
import kotlinx.android.synthetic.main.activity_game1.pencilbox
import kotlinx.android.synthetic.main.activity_game1_2.*
import kotlinx.android.synthetic.main.activity_game1_2_2.*

class gameActivity1_2_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game1_2_2 )

        getSupportActionBar()?.hide();


        val img4: ImageView = findViewById(R.id.img4)
        GlideApp.with(this)
            .load(R.drawable.drawbackground)
            .into(img4)

        val ten: ImageView = findViewById(R.id.ten)
        GlideApp.with(this)
            .load(R.drawable.ten)
            .into(ten)


        pencilbox.setOnClickListener(View.OnClickListener {
            val intent = Intent()
            intent.setClass(this@gameActivity1_2_2, gameActivity1_2_3::class.java)
                startActivity(intent)
                finish()

        })

    }
}