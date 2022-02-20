package com.callback.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        // 리스너란?
        // 뷰에서 발생하는 이벤트에 대해 작업을 처리해주는 곳.
        
        // TODO 명심해야할 부분
        // 리스너를 구현한 쪽에서는(UI Controller) 이벤트이후 메소드의 구체적인 처리방법을 제시함(정의)
        // 그리고 리스너를 받은 곳에서 (주로 직접적인 뷰) 구체적인 메소드를 호출
        // 익명함수는 파라미터를 익명함수로 전달해서 바로 호출하는 거 (보통 뷰에 바인딩)

        // Activity에 Interface 구현
        // setOnClickListener에 리스너를 전달해서 보내야되는데
        // -> MainActivity는 리스너를 구현한 구체적인 리스너가 되기 때문에 전달가능함.
        button.setOnClickListener(this)

        // Listener 객체 전달
        val listener = object: View.OnClickListener{
            override fun onClick(v: View?) {
                Log.d(TAG, "button clicked")
            }
        }
        button.setOnClickListener(listener)

        // 익명객체 전달
        // 버튼의 OnClickListener의 익명객체 바로 사용
        // onClick overriding해서 사용
        button.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                Log.d(TAG, "button clicked")
            }

        })


        // 람다
        button.setOnClickListener {
            Log.d(TAG, "button clicked")
        }

    }

    // https://todaycode.tistory.com/24 콜백예시

    // Activity에 OnclickListener Interface 구현
    // 이벤트 발생시 수행되는 작업을 정의 함
    override fun onClick(v: View?) {
            when(v?.id){
                R.id.button -> Log.d(TAG, "onClick: >>>>")
            }
    }
}