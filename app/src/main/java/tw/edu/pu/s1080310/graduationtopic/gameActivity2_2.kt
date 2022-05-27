package tw.edu.pu.s1080310.graduationtopic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_game2.*
import kotlinx.android.synthetic.main.activity_game2_2.*

class gameActivity2_2 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game2_2)
        getSupportActionBar()?.hide();


        val img11: ImageView = findViewById(R.id.img11)
        GlideApp.with(this)
            .load(R.drawable.drawbackground)
            .into(img11)


        pencialbox2.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                intent = Intent(this@gameActivity2_2, gameActivity2_2_1::class.java)
                startActivity(intent)
                finish()

            }
        })
    }
}