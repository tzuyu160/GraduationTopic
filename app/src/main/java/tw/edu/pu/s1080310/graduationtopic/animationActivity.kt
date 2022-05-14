package tw.edu.pu.s1080310.graduationtopic

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_ani1.*
import kotlinx.android.synthetic.main.activity_animation.*
import kotlinx.android.synthetic.main.activity_game.*
import kotlinx.android.synthetic.main.activity_main.*

class animationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)
        getSupportActionBar()?.hide();


        Log.v(TAG,"Hello,I am VERBOSE");
        Log.d(TAG,"Hello,I am DEBUG");
        Log.i(TAG,"Hello,I am INFORMATION");
        Log.w(TAG,"Hello,I am WARNNING");
        Log.e(TAG,"Hello,I am ERROR");


        val img6: ImageView = findViewById(R.id.img6)
        GlideApp.with(this)
            .load(R.drawable.anibackground)
            .into(img6)




        architecture.setOnClickListener(View.OnClickListener {
            val intent = Intent()
            intent.setClass(this@animationActivity, tw.edu.pu.s1080310.graduationtopic.ani1::class.java)
            startActivity(intent)
        })

        trafic.setOnClickListener(View.OnClickListener {
            val intent = Intent()
            intent.setClass(this@animationActivity, tw.edu.pu.s1080310.graduationtopic.ani2::class.java)
            startActivity(intent)
        })

        money1.setOnClickListener(View.OnClickListener {
            val intent = Intent()
            intent.setClass(this@animationActivity, tw.edu.pu.s1080310.graduationtopic.ani3::class.java)
            startActivity(intent)
        })

        homepage.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                this@animationActivity.finish()

            }

        })



    }




}