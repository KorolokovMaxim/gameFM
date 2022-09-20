package max.project.gamefm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import max.project.myframework.LoopFM

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val loopFM = LoopFM()
        loopFM.startGame()
    }
}