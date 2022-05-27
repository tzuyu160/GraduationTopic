package tw.edu.pu.s1080310.graduationtopic

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Color
import android.media.AudioManager
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_game1_2_3.*
import org.tensorflow.lite.support.image.TensorImage

import tw.edu.pu.s1080310.graduationtopic.ml.Shapemodel1

class gameActivity1_2_3 : AppCompatActivity() ,
    View.OnClickListener, View.OnTouchListener{

    private var soundPool1: SoundPool? = null
    private val soundId = 1
    private var soundPool2: SoundPool? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game1_2_3)
        getSupportActionBar()?.hide();


        soundPool1 = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool1!!.load(baseContext, R.raw.yes, 0)

        soundPool2 = SoundPool(6, AudioManager.STREAM_MUSIC, 0)
        soundPool2!!.load(baseContext, R.raw.wrong1, 1)


        eraser2.setOnClickListener(this)
        draw_view2.setOnTouchListener(this)

        draw_view2.setStrokeWidth(50.0f) //畫筆粗細
        draw_view2.setColor(Color.argb(0xff,205,155,155)) //畫筆顏色
        draw_view2.setBackgroundColor(Color.argb(0xff,209,238,238)) //背景顏色


    }

    override fun onClick(p0: View?) {
        draw_view2.clearCanvas()  //清除繪圖區
    }

    override fun onTouch(p0: View?, event: MotionEvent): Boolean {
        draw_view2.onTouchEvent(event)
        if (event.action == MotionEvent.ACTION_UP){
            //Toast.makeText(this, "手指彈起",Toast.LENGTH_SHORT).show()
            classifyDrawing(draw_view2.getBitmap())

        }
        return true
    }



    //繪圖區
    fun classifyDrawing(bitmap: Bitmap) {



        val model = Shapemodel1.newInstance(this)


        val image = TensorImage.fromBitmap(bitmap)


        // val outputs = model.process(image)
        //val probability = outputs.probabilityAsCategoryList


        val outputs = model.process(image)
            .probabilityAsCategoryList.apply {
                sortByDescending { it.score } // 排序，高匹配率優先
            }.take(1)  //取最高的1個
        var Result: String = ""
        when (outputs[0].label) {
            "長方形" -> Result = "長方形"
            "正方形" -> Result = "正方形"
            "星號" -> Result = "星形"
            "三角形" -> Result = "三角形"
            "圓形" -> Result = "圓形"
            "7" -> Result = "數字7"
            "十字" -> Result = "十字"
        }


        if(Result=="圓形"&&outputs[0].score * 100.0f>30) {
            soundPool1?.play(soundId, 1F, 1F, 0, 0, 1F)
            intent = Intent(this@gameActivity1_2_3, gameActivity1_2_4::class.java)
            startActivity(intent)
            finish()

            Result += ": " + String.format("%.1f%%", outputs[0].score * 100.0f)
            Toast.makeText(this, Result, Toast.LENGTH_SHORT).show()

        }else {
            Toast.makeText(baseContext, "答錯", Toast.LENGTH_SHORT).show()
            soundPool2?.play(soundId, 1F, 1F, 0, 0, 1F)
        }



        model.close()


    }


}