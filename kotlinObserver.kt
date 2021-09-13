package com.stegano.randomlottonumber

fun main() {
    // 익명객체와 옵저버 패턴 --------------------------------------------------------------------------
    /**
     * 이벤트 발생 시 즉각적으로 처리할 수 있도록 만드는 프로그래밍 패턴을 옵저버 패턴이라고 한다.
     * 옵저버 패턴을 구현하기 위해서는 두 개의 클래스가 필요하다. (이벤트 수신 클래스, 이벤트 발생 및 전달 클래스)
     * 이 둘 사이에 인터페이스가 필요한데 이 인터페이스를 observer 또는 listener라고 부르며,
     * 이벤트를 넘겨주는 행위를 callback 이라고 부른다.
     */
    EventPrinter1().start()

    println()

    EventPrinter2().start()

}

interface EventListener {  // 두 클래스를 연결시킬 인터페이스
    fun onEvent(count: Int)  // count 값을 반환할 예정
    /**
     * 코틀린의 인터페이스에서는
     * 구현부가 없으면 abstract 함수로 간주하고,
     * 구현부가 있으면 open 함수로 간주한다.
     */
}

class Counter1(var listener: EventListener) {  // 숫자를 카운트하며 5의 배수마다 이벤트 발생시킬 클래스
    fun count() {
        for(i in 1..100) {
            if(i%5 == 0) {
                listener.onEvent(i)  // 5의 배수마다 onEvent()함수를 호출하도록 함
            }
        }
    }
}

class EventPrinter1 : EventListener {  // 이벤트를 수신해서 출력하는 클래스
    override fun onEvent(count: Int) {  // 인터페이스의 함수를 구현 (count 값 반환)
        print("${count}-")  // 호출되면 count 값을 반환함
    }

    fun start() {
        // 여기서 this는 EventPrinter이지만 필요한거는 EventListener이므로 EventListener 구현부만 넘겨주게 된다.
        val counter = Counter1(this)
        counter.count()
    }
}

class EventPrinter2 {
    fun start() {
        val counter = Counter1(object: EventListener {
            override fun onEvent(count: Int) {
                print("${count}-")
            }
        })
        counter.count()
    }
}