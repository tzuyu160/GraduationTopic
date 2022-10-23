package tw.edu.pu.s1080310.graduationtopic


import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.core.content.ContextCompat
import com.innfinity.permissionflow.lib.requestPermissions
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class cam1 : AppCompatActivity() {

    lateinit var txv: TextView

    lateinit var viewFinder: PreviewView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cam1)

        txv = findViewById(R.id.txv)

        txv.text = "您尚未允許拍照權限"

        viewFinder = findViewById(R.id.viewFinder)

        GlobalScope.launch(Dispatchers.Main) {

            requestPermissions(Manifest.permission.CAMERA)

                .collect { permissions ->

                    txv.text = "用相機辨識交通工具"
                    startCamera()
                }

        }
    }

    private fun startCamera() {

        val cameraProviderFuture = ProcessCameraProvider.getInstance(this)



        cameraProviderFuture.addListener(Runnable {

            // Used to bind the lifecycle of cameras to the lifecycle owner

            val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()



            // Preview

            val preview = Preview.Builder()

                .build()

                .also {

                    it.setSurfaceProvider(viewFinder.surfaceProvider)

                }



            // Select back camera as a default

            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

            //val cameraSelector = CameraSelector.DEFAULT_FRONT_CAMERA  //自拍

            try {

                // Unbind use cases before rebinding

                cameraProvider.unbindAll()



                // Bind use cases to camera

                cameraProvider.bindToLifecycle(

                    this, cameraSelector, preview)



            } catch(exc: Exception) {

                Toast.makeText(this, "Use case binding failed: ${exc.message}",

                    Toast.LENGTH_SHORT).show()

            }



        }, ContextCompat.getMainExecutor(this))

    }
}