package tw.edu.pu.s1080310.graduationtopic

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.*
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.core.content.ContextCompat
import com.innfinity.permissionflow.lib.requestPermissions
import kotlinx.android.synthetic.main.activity_cam7.*
import kotlinx.android.synthetic.main.activity_cam8.*
import kotlinx.android.synthetic.main.activity_cam8.txv
import kotlinx.android.synthetic.main.activity_cam9.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.tensorflow.lite.support.image.TensorImage
import tw.edu.pu.s1080310.graduationtopic.ml.Transport
import java.io.ByteArrayOutputStream
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.util.concurrent.Executors

class cam9 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cam9)
        getSupportActionBar()?.hide();


        lateinit var txv: TextView
        lateinit var viewFinder8: PreviewView

        txv = findViewById(R.id.txv)
        txv.text = "您尚未允許拍照權限"
        viewFinder8 = findViewById(R.id.viewFinder8)


        GlobalScope.launch(Dispatchers.Main) {
            requestPermissions(android.Manifest.permission.CAMERA)
                .collect { permissions ->
                    txv.text = "用相機辨識交通工具"
                    startCamera()
                }

        }


    }


    @SuppressLint("UnsafeOptInUsageError")
    private fun startCamera() {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(this)
        cameraProviderFuture.addListener(Runnable {
            val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()
            val preview = Preview.Builder()
                .build()
                .also {
                    it.setSurfaceProvider(viewFinder8.surfaceProvider)
                }

            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA
            val imageAnalysis = ImageAnalysis.Builder()
                .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                .build()



            var executor = Executors.newSingleThreadExecutor()

            imageAnalysis.setAnalyzer(executor, ImageAnalysis.Analyzer { imageProxy ->
                var bitmap = imageProxy.image?.let{ toBitmap(it) }
                GlobalScope.launch(Dispatchers.Main) {

                    if (bitmap != null){
                        classifyDrawing(bitmap)
                    }
                }


                imageProxy.close()

            })





            try {
                // Unbind use cases before rebinding
                cameraProvider.unbindAll()

                // Bind use cases to camera
                cameraProvider.bindToLifecycle(
                    this, cameraSelector, preview, imageAnalysis)

            } catch(exc: Exception) {
                Toast.makeText(this, "Use case binding failed: ${exc.message}",
                    Toast.LENGTH_SHORT).show()

            }



        }, ContextCompat.getMainExecutor(this))

    }

    fun toBitmap(image: Image): Bitmap {
        val planes = image.planes
        val yBuffer: ByteBuffer = planes[0].buffer
        val uBuffer: ByteBuffer = planes[1].buffer
        val vBuffer: ByteBuffer = planes[2].buffer
        val ySize: Int = yBuffer.remaining()
        val uSize: Int = uBuffer.remaining()
        val vSize: Int = vBuffer.remaining()
        val nv21 = ByteArray(ySize + uSize + vSize)


        yBuffer.get(nv21, 0, ySize)
        vBuffer.get(nv21, ySize, vSize)
        uBuffer.get(nv21, ySize + vSize, uSize)
        val yuvImage = YuvImage(nv21, ImageFormat.NV21, image.width, image.height, null)
        val out = ByteArrayOutputStream()
        yuvImage.compressToJpeg(Rect(0, 0, yuvImage.width, yuvImage.height), 75, out)
        val imageBytes = out.toByteArray()
        return BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.size)

    }



    private fun getByteBufferNormalized(bitmapIn: Bitmap): ByteBuffer {

        val bitmap = Bitmap.createScaledBitmap(bitmapIn, 28, 28, true)

        val width = bitmap.width

        val height = bitmap.height

        val byte_buffer: ByteBuffer = ByteBuffer.allocateDirect(4 * width * height)

        byte_buffer.order(ByteOrder.nativeOrder())

        val pixels = IntArray(width * height)

        bitmap.getPixels(pixels, 0, width, 0, 0, width, height)

        for (pixel in pixels) {

            byte_buffer.putFloat(Color.blue(pixel).toFloat() / 255.0f)

        }

        return byte_buffer

    }



    fun classifyDrawing(bitmap : Bitmap) {

        val model = Transport.newInstance(this)


        val image = TensorImage.fromBitmap(bitmap)


        // val outputs = model.process(image)
        // val probability = outputs.probabilityAsCategoryList

        val outputs = model.process(image)
            .probabilityAsCategoryList.apply {
                sortByDescending { it.score } // 排序，高匹配率優先
            }.take(1)  //取最高的1個

        var Result: String = ""
        when (outputs[0].label) {
            "公車" -> Result = "公車"
            "火車" -> Result = "火車"
            "垃圾車" -> Result = "垃圾車"
            "計程車" -> Result = "計程車"
            "消防車" -> Result = "消防車"
            "捷運" -> Result = "捷運"
            "救護車" -> Result = "救護車"
            "船"-> Result = "船"
            "貨車"-> Result = "貨車"
            "腳踏車"-> Result = "腳踏車"
            "警車"-> Result = "警車"
        }


        if(Result=="捷運"&&outputs[0].score * 100.0f>10) {
            txv.text="答對"
            intent = Intent(this@cam9, life2_9::class.java)
            startActivity(intent)
            finish()


        } else {
            txv.text="答錯囉"
        }


        model.close()

    }

}