package max.project.myframework

import max.project.myframework.const.LoopConst
import java.util.*

class LoopFM : Runnable {

    private val loopConst = LoopConst()

    private var running: Boolean = false

    private lateinit var gameThread: Thread

    //TEMP

    var updates: Float = 0.0F
    var drawing: Float = 0.0F
    var timer: Long = 0L
    //TEMP

    override fun run() {
        var lastTime: Float = System.nanoTime().toFloat()
        var delta = 0.0F
        timer = System.currentTimeMillis()
        while (running) {
            val nowTime: Float = System.nanoTime().toFloat()
            val elapsedTime: Float = nowTime - lastTime
            lastTime = nowTime
            delta += elapsedTime / loopConst.UPDATE_TIME
            if (delta > 1) {
                updateGame()
                drawingGame()
                delta--
            }
            if (System.currentTimeMillis() - timer > 1000) {
                val date = Date()
                println("UPDATES = $updates DRAWING $drawing $date")
                updates = 0.0F
                drawing = 0.0F
                timer += 1000
            }
        }
    }

    fun startGame() {
        if (running) {
            return
        }
        running = true
        gameThread = Thread(this)
        gameThread.start()
    }

    fun stopGame() {
        if (!running) {
            return
        }
        running = false

        try {
            gameThread.join()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
    }

    private fun updateGame() {
        updates++
    }

    private fun drawingGame() {
        drawing++
    }
}