package tw.edu.pu.s1080310.graduationtopic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_game2_2.*
import kotlinx.android.synthetic.main.activity_game2_2.pencialbox2
import kotlinx.android.synthetic.main.activity_game2_3.*

class gameActivity2_3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game2_3)
        getSupportActionBar()?.hide();


        val img12: ImageView = findViewById(R.id.img12)
        GlideApp.with(this)
            .load(R.drawable.drawbackground)
            .into(img12)


        pencialbox3.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                intent = Intent(this@gameActivity2_3, gameActivity2_3_1::class.java)
                startActivity(intent)
                finish()

            }
        })
    }
}