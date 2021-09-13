package com.stegano.randomlottonumber

fun main() {
    // 오브젝트와 싱글턴 패턴 --------------------------------------------------------------------------
    // 오브젝트 1
    println(Counter.count)  // 0
    Counter.countUp()
    println(Counter.count)  // 1
    Counter.clear()
    println(Counter.count)  // 0

    // 오브젝트 2
    val foodPoll_a = FoodPoll("자장면")
    val foodPoll_b = FoodPoll("짬뽕")
    foodPoll_a.vote()
    foodPoll_a.vote()
    foodPoll_b.vote()
    foodPoll_a.vote()
    println("${foodPoll_a.name} : ${foodPoll_a.count}")
    println("${foodPoll_b.name} : ${foodPoll_b.count}")
    println("총 투표 수 : ${FoodPoll.total}")
}

// 오브젝트 1
object Counter {  // 오브젝트로 생성된 객체는 최초 사용 시 자동으로 생성되며 이후에는 코드 전체에서 공용으로 사용될 수 있다.
    var count = 0
    fun countUp() {
        count++
    }
    fun clear() {
        count = 0
    }
}

// 오브젝트 2
class FoodPoll(val name: String) {  // 이 방법은 Singleton Pattern이라고 한다.
    companion object {  // 공용 객체
        var total = 0
    }
    var count = 0  // 개별 객체

    fun vote() {
        total++
        count++
    }
}

// 오브젝트 3
// 동반 객체 (companion object) -> 정적인 메서드를 만들 수 있음 (자바의 static)
class Fragment1 {
    companion object {
        fun newInstance1() {
            println("생성됨")
        }
    }
}
val fragment1 = Fragment1.newInstance1()