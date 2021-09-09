package com.trevicano.samplegesturedetector

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import androidx.core.view.GestureDetectorCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var rootLayoutGestureDetector: GestureDetectorCompat
    private lateinit var childViewGestureDetector: GestureDetectorCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rootLayoutGestureDetector = GestureDetectorCompat(
                this,
                object : GestureDetector.SimpleOnGestureListener() {
                    override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
                        println("onScroll() 1")

                        rootLayout.setBackgroundResource(android.R.color.holo_orange_dark)

                        return true
                    }

                    override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
                        println("onFling() 1")

                        rootLayout.setBackgroundResource(R.color.yellow)

                        return true
                    }

                    override fun onSingleTapUp(e: MotionEvent?): Boolean {
                        println("onSingleTapUp() 1")

                        rootLayout.setBackgroundResource(R.color.teal_700)

                        return true
                    }

                    /**
                     * 모든 이벤트는 항상 onDown()부터 시작되기 떄문에
                     * 다른 이벤트를 처리하기위해서는 onDown()은 꼭 true를 리턴해야한다.
                     */
                    override fun onDown(e: MotionEvent?): Boolean {
                        println("onDown() 1")

                        rootLayout.setBackgroundResource(android.R.color.holo_red_light)

                        return true
                    }
                }
        )
        childViewGestureDetector = GestureDetectorCompat(
                this,
                object : GestureDetector.SimpleOnGestureListener() {
                    override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
                        println("onScroll() 2")

                        square.setBackgroundResource(android.R.color.holo_orange_dark)

                        return true
                    }

                    override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
                        println("onFling() 2")

                        square.setBackgroundResource(R.color.yellow)

                        return true
                    }

                    override fun onSingleTapUp(e: MotionEvent?): Boolean {
                        println("onSingleTapUp() 2")

                        square.setBackgroundResource(R.color.teal_700)

                        return true
                    }

                    override fun onDown(e: MotionEvent?): Boolean {
                        println("onDown() 2")

                        square.setBackgroundResource(android.R.color.holo_red_light)

                        return true
                    }
                }
        )

        rootLayout.setOnTouchListener { _, event ->
            rootLayoutGestureDetector.onTouchEvent(event)

            true
        }
        square.setOnTouchListener { _, event ->
            childViewGestureDetector.onTouchEvent(event)

            true
        }
    }
}