package com.stegano.randomlottonumber

import kotlinx.coroutines.*
import okhttp3.internal.wait

// Kotlin 기본 문법 연습
// https://play.kotlinlang.org/ 이 사이트에서 코틀린을 연습해 볼 수 있음

// 한 줄 주석

/**
 * 여러 줄 주석
 */

/**
 * 패키지 스코프에서 접근 제한자
 * public : 어떤 패키지에서도 접근 가능함 (기본값)
 * internal : 같은 모듈 내에서만 접근 가능함
 * private : 같은 파일 내에서만 접근 가능함
 * protected : 사용하지 않음
 *
 * 클래스 스코프에서 접근 제한자
 * public : 클래스 외부에서도 접근 가능함 (기본값)
 * internal : 사용하지 않음
 * private : 클래스 내에서만 접근 가능함
 * protected : 클래스 자신과 상속받은 클래스에서만 접근 가능함
 */

var a123 = 1  // 상위 스코프

fun main() {  // 메인으로 실행 될 함수

    println("상위 스코프의 a123 : $a123")  // 상위 스코프를 하위 스코프에서 그냥 쓸 수 있다.
    val a123 = "ddddd"
    println("하위 스코프의 a123 : $a123")  // 하위 스코프에서 같은 이름을 만들어 사용할 수도 있다.
    // 내부, 외부 스코프의 접근제한자 (public, private, protected, internal)



    // 기본 -----------------------------------------------------------------------------------------
    val a: Int = 10  // val은 값을 변경할 수 없는 변수 (객체 내부의 속성은 변경할 수 있음)
    var b: Int = 10  // var은 값을 변경할 수 있는 변수
    b = 11
    ++b
    println("a : $a, b : $b \n")  // a : 10, b : 12

    var ai: Int = 10  // 10진수
    var al: Long = 10L
    var af: Float = 10.0f
    var ad: Double = 10.0
    var ad2: Double = 10.0e10  // 지수표기 가능, 출력 : 1.0E11
    var ah: Int = 0x1af  // 16진수
    var ab: Int = 0b10110110  // 2진수, 출력 : 182, 참고로 코틀린에서 8진수의 표기는 지원하지 않는다.
    var aboolean: Boolean = true  // 논리형, true | false
    var str: String = "Hello"
    var chr: Char = 'H'  // 코틀린에서는 문자를 UTF-16BE로 관리함 (문자 하나당 2Byte)
    val str2: String = """
        |이렇게
        |여러줄도
        |가능함 str2
    """.trimMargin()  // trimMargin() 사용 시 개행이나 공백을 포함한 모든 문자를 표현해 준다. 각 줄의 시작을 |로 채워줌
    println("str2 : " + str2 + "\n")  // Java 스타일
    println("str2 : ${str2}\n")  // Kotlin 스타일

    val str3: String = """
        이렇게
        여러줄이
        가능함 str3
    """.trimIndent()  // 여러 줄에 걸쳐 문자열을 표현할 때는 큰따옴표 3개를 리터럴로 사용한다.
    println("str3 : ${str3}\n")

    val numArray: Array<Int> = arrayOf(1, 2, 3, 4, 5)  // val numArray = arrayOf(1, 2, 3, 4, 5) 동일
    // 배열 타입은 <>제네릭을 사용해서 지정함, 배열에 접근은 []를 사용한다.
    numArray[0] = 5
    numArray[3] = 1
    println("numArray : ${numArray[3]}\n")
    val numArray2 = arrayOfNulls<Int>(5)
    println("numArray2 : ${numArray2[0]} \n")

    val strTest1 = "Test.Kotlin.String.1"
    println("strTest1.length : ${strTest1.length}")  // 20
    println("strTest1.toUpperCase() : ${strTest1.toUpperCase()}")  // TEST.KOTLIN.STRING.1
    println("strTest1.toLowerCase() : ${strTest1.toLowerCase()}")  // test.kotlin.string.1
    println("strTest1.substring(1..10) : ${strTest1.substring(1..10)}")  // est.Kotlin
    println("strTest1.startWith(\"Test\") : ${strTest1.startsWith("Test")}")  // true
    println("strTest1.endsWith(\"Test\") : ${strTest1.endsWith("Test")}")  // false
    println("strTest1.contains(\"Test\") : ${strTest1.contains("Test")}")  // true

    val strTest2 = strTest1.split(".")  // split은 delimiters를 기준으로 문자를 자름
    println("strTest2 : $strTest2")  // [Test, Kotlin, String, 1]
    println("strTest2.joinToString() : ${strTest2.joinToString()}")  // Test, Kotlin, String, 1
    println("strTest2.joinToString(\"-\") : ${strTest2.joinToString("-")}")  // Test-Kotlin-String-1

    val nullString: String? = null
    val emptyString = ""
    val blankString = " "
    val normalString = "A"
    println(nullString.isNullOrEmpty())  // nullString과 emptyString 변수가 true
    println(nullString.isNullOrBlank())  // nullString과 emptyString, blankString 변수가 true



    // 타입 캐스팅 (형변환) ---------------------------------------------------------------------------
    // toByte(), toShort(), toInt(), toLong(), toFloat(), toDouble(), toChar() 등이 있음
    val num1 = 1
    val castingByte = num1.toByte()  // 1, 이런것을 "명시적 형변환"이라고 한다.
    val castingLong = num1.toLong()  // 1
    val castingFloat = num1.toFloat()  // 1.0
    val castingDouble = num1.toDouble()  // 1.0
    println("castingByte : $castingByte, castingLong : $castingLong, castingFloat : $castingFloat, castingDouble : $castingDouble")

    val text1 = "23"
    val castingInt = text1.toInt()
    println("castingInt : $castingInt")



    // 증감 연산자 (++a 전위 연산자, a++ 후위 연산자) ---------------------------------------------------
    println()
    var a_10 = 10
    var b_10 = ++a_10  // 증가를 즉시 반영함, 감소는 --를 사용함
    println("a_10 : ${a_10}, b_10 : ${b_10}")  // 11, 11
    b_10 = ++a_10
    println("a_10 : ${a_10}, b_10 : ${b_10}")  // 12, 12
    b_10 = a_10++
    println("a_10 : ${a_10}, b_10 : ${b_10}")  // 13, 12
    b_10 = a_10--
    println("a_10 : ${a_10}, b_10 : ${b_10} \n")  // 12, 13



    // 제어문 ---------------------------------------------------------------------------------------
    val aa = 30;
    val bb = 0;
    var temp = 0
    if (aa > bb) {
        temp = aa
    } else if (aa < bb) {
        temp = bb
    } else {
        temp = aa
    }
    println("if문 temp : $temp \n")

    temp = if (a > 100) {  // 변수에 if문, when문 등 작성 가능함
        a
    } else {
        b
    }
    println("if문 temp : $temp \n")

    val str1 = "aaaa"
    if (str1 == "aaaa") {  // ==는 내용의 동일성을 보고, ===는 객체의 동일성을 봄
        println("str1 = aaaa")
    } else {
        println("str1 = bb")
    }

    val x = 4
    when (x) {
        1 -> println("x == 1")
        2, 3 -> println("x == 2 or x == 3")
        in 4..7 -> println("x = 4~7")  // 출력됌
        !in 1..11 -> println("x != 1~11")
        else -> {
            println("x는 8,9,10,11 중 하나")
        }
    }
    println("")

    val numbers = arrayOf(1, 2, 3, 4, 5)
    for (num in numbers) {
        print(num)
    }  // 12345 출력
    println("")

    for (i in 1..10) {
        print(i)  // 12345678910
    }
    println("")

    for (i in 1..10 step 2) {
        print(i)  // 13579
    }
    println("")

    for (i in 10 downTo 0 step 2) {
        print(i)  // 1086420
    }
    println("")

    var c = 4
    while (c > 0) {
        c--
        print(c)  // 3210
    }
    println("")

    do {  // c = 0 부터
        c++
        print(c)  // 1234
    } while (c < 4)
    println("")

    loop@for (i in 1..10) {
        for (j in 1..10) {
            if(i == 1 && j == 2) {  // && = AND연산자, || = OR연산자, ! = Not연산자,
                break@loop
                // 반복문에 loop 키워드를 선언하면 for문 하나만 종료되지 않고 loop@를 지정한 곳까지 빠져나가게 된다.
            }
            println("i : $i, j : $j")
        }
    }
    println("")



    // 메서드 ---------------------------------------------------------------------------------------
    welcomeMsg("Kotlin")  // Welcome Kotlin

    println(add(a, b))  // add(10, 12) -> 22

    val number = 1
    fun kotlinTest(num: Int) = when (num % 2) {
        0 -> "짝"
        else -> "홀"
    }
    println(kotlinTest(number))



    // null 허용, lateinit, lazy 키워드 --------------------------------------------------------------
    //val null_a: String  // 에러, 초기화는 해줘야 함
    //val null_a: String = null  // 에러, 기본적으로 null을 허용하지 않음
    val null_a: String? = null  // 가능

    lateinit var null_b: String  // lateinit을 사용하여 나중에 초기화가 가능하다.
    /**
     * lateinit 선언 시 제약조건
     * 1. var변수만 사용가능
     * 2. null값을 초기화할 수 없다
     * 3. 초기화 전에 사용불가
     * 4. Int, Long, Float, Double 사용불가
     */
    null_b = "lateinit"
    // if(::null_b.isInitialized) {}  클래스의 함수 안에서 사용 가능하고, 초기화가 되었다면 true가 된다.
    println("null_a : ${null_a}, null_b : ${null_b}")

    val str_lazy: String by lazy {  // lazy는 바로 초기화하지 않고 변수를 사용할 때 초기화 함
        println("hi")  // 이미 초기화가 되었을 경우에는 lazy 구문을 실행하지 않는다.
        "kotlin"  // lazy{}의 마지막 줄은 초기화할 값을 작성함
    }

    val name1 = "코틀린"
    val name2: String? = name1
    val name3: String = name2!!  // !!은 null이 절대 아니라는 것을 보장함
    println("name3 : $name3")  // 출력 : name3 : 코틀린

    val upperCase1 = name2?.toUpperCase()  // 안전한 호출 ?.은 null 일 때에는 null을 반환해줌
    println(upperCase1)  // 출력 : 코틀린
    val upperCase2: String? = null
    println(upperCase2?.toUpperCase())  // 출력 : null

    val null_str: String? = null
    val upperCase3 = null_str?.toUpperCase() ?: "null값일 때 실행됌. ?:를 엘비스 연산자라고 부름"
    println(upperCase3)  // 출력 : null값일 때 실행됌. ?:를 엘비스 연산자라고 부름



    // 컬렉션 (개발에 유용한 자료구조) ------------------------------------------------------------------
    val table1: List<String> = listOf("1a", "2a", "3a")  // 읽기 전용 리스트 (변경 불가)
    //table1[1] = "ggg"  // 불가능
    println("table1 : ${table1}")  // 출력 : table1 : [1a, 2a, 3a]

    val table2 = mutableListOf("1a", "2a", "3a")  // 변경 가능한 리스트
    table2.add("4b")  // 값 추가
    table2.add("5b")
    table2.add("6b")
    table2.add(5, "1324")  // 특정 인덱스에 값을 추가
    table2.remove("3a")  // 값 "3"를 찾아서 삭제함
    table2.removeAt(0)  // 0번째 값을 삭제함
    table2[0] = "코틀린"  // 0번째 "2a"를 "코틀린"으로 변경함
    println("table2 : ${table2}")  // 출력 : table2 : [코틀린, 4b, 5b, 1324, 6b]
    table2.shuffle()  // 무작위 섞기
    table2.sort()  // 정렬
    table2.reverse()  // 순서 반대로
    println("table2 : ${table2}")  // 출력 : [코틀린, 6b, 5b, 4b, 1324]

    // map : key와 value를 갖는 컬렉션이다.
    val map1 = mapOf("a" to 1, "b" to 2, "c" to 3)  // 읽기 전용 맵
    val map2 = mutableMapOf("a" to "b", "b" to "2", "c" to "한국")  // 변경 가능한 맵
    map2["추가1"] = "서울시"  // 요소 추가
    map2.remove("b")  // 요소 삭제
    map2["a"] = "대한민국"  // 요소 값 변경 (기존 키가 대체됨)
    for ((key, value) in map2) {  // 출력
        println("key : ${key} -> value : ${value}")
    }

    // set : 순서가 없고 중복을 허용하지 않는 컬렉션이다.
    val set1 = setOf("코틀린", "자바", "노드")  // 읽기 전용 집합(셋)
    val set2 = mutableSetOf("코틀린", "자바", "노드")  // 변경 가능한 집합
    set2.add("파이썬")
    set2.add("자바")  // set은 중복을 허용하지 않음
    set2.remove("노드")
    println("set2 : $set2")  // 출력 : set2 : [코틀린, 자바, 파이썬]
    println("set2에 코틀린이 존재하나? : ${set2.contains("코틀린")}, set2 사이즈 : ${set2.size}")  // true, 3



    // 컬렉션 함수 -----------------------------------------------------------------------------------
    // (컬렉션, 배열에 일반함수, 람다함수 형태를 사용하여 참조, 조건, 구조변경 등이 가능한 여러가지 함수이다.)
    // collection.forEach{ it }  컬렉션 내의 아이템을 it으로 하나씩 참조할 수 있다.
    // collection.filter{ it 조건 }  아이템을 it으로 받아오는데 조건에 맞는 것만 반환함. (it > 2)
    // collection.map{ it 변경 }  아이템을 it으로 받아오는데 변경하여 반환할 수 있음. (it * 2)
    // collection.any{ it 조건 }  아이템 it이 하나라도 조건에 맞으면 true
    // collection.all{ it 조건 }  아이템 it이 모두 조건에 맞으면 true
    // collection.none{ it 조건 }  아이템 it이 하나도 조건에 맞지 않으면 true
    // collection.first는 일반함수(())로 부르면 첫번째 객체로 반환하지만, 컬렉션 함수({})로 부르고
    // it에 조건을 걸어주면 조건에 맞는 첫번째 객체를 반환한다.
    // collection.last도 동일하게 해주면 된다.(마지막 객체를 찾음)
    // first와 last는 조건에 맞는 객체가 없는 경우 예외(NoSuchElementException)를 발생시킴
    // 이 때 firstOrNull, LastOrNull을 사용하면 객체가 없을 때 null을 반환한다.
    // first는 find 함수로 대체 가능, last는 findLast 함수로 대체 가능하다.
    // collection.count{ it 조건 }  it 조건에 맞는 아이템의 개수를 반환해준다. count()함수를 사용 시 모든 아이템 개수를 반환한다.

    // collection.associateBy{ it.name }  아이템에서 키를 추출하여 map으로 반환하는 함수 (list.associateBy{ it.age }
    // collection.groupBy{ it.birthday }  키가 동일한 아이템끼리는 한 배열로 묶어서 map으로 반환하는 함수
    // collection.partition { it.birthday > 2002 }  아이템에 조건을 걸어 두 컬렉션으로 나누어주는 함수
    // -> Pair라는 클래스 객체로 나오는데 first와 second로 참조 가능한다. 또는 val (over2002, under2002) = ~로 변수에 담을 수 있음
    println("컬렉션 함수")
    data class PPP(val name: String, val birthday: Int)
    val pppList = listOf(
        PPP("AAA", 1999),
        PPP("BBB", 2020),
        PPP("CCC", 1989),
        PPP("AAA", 2000),
        PPP("DDD", 2000)
    )
    println(pppList.associateBy { it.birthday })  // {1999=PPP(name=AAA, birthday=1999), 2020=PPP(name=BBB, birthday=2020), 1989=PPP(name=CCC, birthday=1989), 2000=PPP(name=DDD, birthday=2000)}
    println(pppList.groupBy { it.name })  // {AAA=[PPP(name=AAA, birthday=1999), PPP(name=AAA, birthday=2000)], BBB=[PPP(name=BBB, birthday=2020)], CCC=[PPP(name=CCC, birthday=1989)], DDD=[PPP(name=DDD, birthday=2000)]}
    val (over2000, under2000) = pppList.partition { it.birthday > 2000 }
    println(over2000)  // [PPP(name=BBB, birthday=2020)]
    println(under2000)  // [PPP(name=AAA, birthday=1999), PPP(name=CCC, birthday=1989), PPP(name=AAA, birthday=2000), PPP(name=DDD, birthday=2000)]
    println()

    // collection.flatMap { it }  아이템마다 만들어진 컬렉션을 합쳐서 반환하는 함수
    // collection.getOrElse(index) { 기본값 }  인덱스 위치에 아이템이 있으면 아이템을 반환하고 아닌 경우 지정한 기본값을 반환하는 함수
    // collectionA zip collectionB  컬렉션 두 개의 아이템을 1:1로 매칭하여 새 컬렉션을 만들어 줌 (이 때 작은 쪽을 따름)
    val nummm = listOf(-4, -5, 1, 0, 2)
    println(nummm.flatMap { listOf(it*10, it+10) })  // [-40, 6, -50, 5, 10, 11, 0, 10, 20, 12]
    println(nummm.getOrElse(0) { 100 })  // -4
    println(nummm.getOrElse(50) { 100 })  // 100
    val nameee = listOf("A", "B", "C")
    println(nameee zip numbers)  // [(A, 1), (B, 2), (C, 3)]
    println()



    // 람다식 (람다함수) ------------------------------------------------------------------------------
    /**
     * 람다함수도 일반함수처럼 여러 구문을 사용할 수 있다. (참고로 람다함수가 여러 줄이 되는 경우 마지막 구문이 반환됨)
     * 람다함수에 파라미터가 없다면 실행할 구문들만 나열하면 된다.
     * 파라미터가 하나라면 it을 사용한다.
     */
    fun addOne(x: Int, y: Int): Int {
        return x + y
    }

    fun addTwo(x: Int, y: Int) = x + y  // 람다식은 함수를 표현하는 방법으로 익명 클래스, 함수를 간결하게 표현할 수 있다.
    var addThr = { x: Int, y: Int -> x + y }  // 변수에 일반 함수처럼 사용할 수 있다.
    println("addThr : ${addThr(3, 4)}")  // 출력 : 7

    /*
    button.setOnClickListener(object :
        View.OnClickListener {
            override fun onClick(v: View?) {
                // 클릭 이벤트
            }
        }
    )
    // SAM 변환 (Single Abstract Method, 자료형과 인수가 하나인 경우 생략하고 블록내에서 접근이 가능하다)
    button.setOnClickListener{
        // 클릭 이벤트
    }
     */



    // 형 변환 (as), 형 체크 (is) --------------------------------------------------------------------
    open class Animal1  // 상속이 가능한 open 클래스
    class Cat1 : Animal1()

    val cat1 = Cat1()
    val animal1 = cat1 as Animal1  // 클래스 간에 형 변환

    val str4 = "Hello"
    if (str4 is String) {  // str4가 String형이라면 실행 (자바의 instanceOf)
        println("str4 is String")  // 여기 출력됨
    } else {  // str4이 아니라면 실행
        println("str4 is not String")
    }



    // 확장 함수 ------------------------------------------------------------------------------------
    fun Int.isEven() = this % 2 == 0  // 기존 클래스에 새로운 기능을 추가하는 함수
    val aaa = 10
    val bbb = 11
    println(aaa.isEven())  // true
    println(bbb.isEven())  // false



    // 고차 함수 (함수의 인자로 함수를 전달하거나 함수를 반환할 수 있는 함수) ---------------------------------
    fun aaaaa(str: String) {
        println("$str 함수 aaaaa")
    }

    fun bbbbb(function: (String) -> Unit) {  // aaaaa의 파라미터인 String을 받고 리턴값은 없으므로 Unit을 씀
        function("bbbbb가 호출한")
    }
    bbbbb(::aaaaa)  // bbbbb가 일반함수 aaaaa를 호출함. 이때 일반함수를 고차함수로 변경해주는 :: 연산자가 필요함
    // 출력 : bbbbb가 호출한 함수 aaaaa

    //val ccccc: (String) -> Unit = { str: String -> println("$str 람다함수 ccccc") }  // bbbbb()함수를 람다함수로 변경함
    val ccccc = { str: String -> println("$str 람다함수 ccccc") }  // 람다함수는 추론이 가능해서 축약이 된다.
    bbbbb(ccccc)  // bbbbb가 람다함수 ccccc를 호출함

    fun adddd(x: Int, y: Int, callback: (sum: Int) -> Unit) {  // 함수가 받을 파라미터(자료형, 자료형) -> 반환(자료형)
        callback(x + y)
    }
    adddd(4, 6) { println(it) }  // 람다표현식 사용 전 : adddd(4, 6, { println(it) })
    // 출력 : 10



    // 스코프 함수 (let(), with(), apply(), run(), also()) ---------------------------------------------------------------
    // 스코프 내에서 깔끔하게 사용할 수 있어서 코드의 가독성을 향상 시킬 수 있는 장점이 있다.
    var str5: String? = null
    // fun <T, R> T.let(block (T) -> R): R
    val result5 = str5?.let {  // let() 함수는 블록에 자기 자신을 인수(it)로 전달하고 수행된 결과를 반환한다.
        it
        "cghjchk"
        // 마지막 문장이 return되지만 ?.으로 인해 null일 때 실행이 안되어 let은 수행하지 않고 result5에는 null이 들어간다.
    }
    println("result5 : $result5")  // 출력 : result5 : null

    // fun <T, R> with(receiver: T, block T.() -> R): R
    val abcd = with(str5) {  // with() 함수는 인수(this)를 객체로 받고 블록에 리시버 객체로 전달함.
        println(this?.toUpperCase())  // null
        "abcd"
    }
    println("abcd : $abcd")

    // fun <T> T.apply(block: T.() -> Unit): T
    // apply()는 인스턴스를 생성한 후 변수에 담기 전에 초기화 과정을 수행할 때 많이 사용한다.
    val result6 = str5.apply {  // apply() 함수는 객체의 상태를 변화시키고 그 객체를 다시 반환한다.
        str5 = "abcd"
        "abcd"
    }
    println("result6 : $result6, str5 : $str5")  // 출력 : result6 : null, str5 : abcd

    // fun <R> run(block: () -> R): R
    // run()은 인스턴스가 만들어진 후에 인스턴스의 함수나 속성을 스코프 내에서 사용해야 할 때 유용하다.
    val avg = run {  // run() 함수를 익명함수처럼 사용하기
        val ko = 100
        val en = 90
        val math = 50
        (ko + en + math) / 3.0
    }
    println("avg : $avg")  // 출력 : avg : 80.0
    // fun <T, R> T.run(block: T.() -> R): R
    val str6 = "adsfn"
    val abc = str6.run {  // 안전한 호출자를 사용할 수 있어서 with()함수보다 유용하다.
        println(this.toUpperCase())  // adsfn
        "abc"
    }
    println("str6 : $str6")  // 출력 : str6 : adsfn
    println("abc : $abc")  // 출력 : abc : abc

    /**
     * run()과 let()은 비슷하지만, 동일한 변수이름이 메인함수와 객채 내에 있을 때
     * 메인함수에서 run()을 쓰면 메인함수의 변수를 부르게 되고, let()을 쓰면 인스턴스 내에 있는 변수를
     * it으로 부를 수 있게 되는 차이점이 있다.
     * apply()와 also()도 비슷한데, also()를 사용하여 인스턴스 내의 변수를 사용하면 된다.
     */



    // 비트 연산자 -----------------------------------------------------------------------------------
    // 최상위비트는 부호비트, 상위비트 <- 10101010 -> 하위비트
    // 부호비트에는 데이터를 담지 않는 것이 좋다.
    // 부호비트를 제외하고 모든 비트를 밀어주는 shl(왼쪽으로), shr(오른쪽으로)이 있고
    // 부호비트를 포함하여 모든 비트를 밀어주는 ushl(왼쪽으로), ushr(오른쪽으로)이 있다.
    // and : 알고싶은 비트에 1을 넣고 and 연산을 하여 비트를 확인하는 용도, 원하는 비트에 clear하는 용도
    // or : 원하는 비트에 1로 설정하는 용도(set)
    // xor : 비교할 비트들이 동일한지 확인하는 용도(같으면 0, 다르면 1이니까)
    // inv() : not연산자로 비트르 모두 반전시킨다.
    var bitData: Int = 0b10000
    bitData = bitData or (1 shl 2)  // bitData = 0b10000, (1 shl 2) = 0b100을 or 연산한 값이 들어감
    println("bitData : ${bitData.toString(2)}")  // 정수형의 경우 toString의 파라미터로 진법변환을 할 수 있다. 2=이진
    // bitData : 10100
    bitData = bitData and (1 shl 4)  // bitData = 0b10100, (1 shl 4) = 0b10000을 and 연산한 값이 들어감
    println("bitData : ${bitData.toString(2)}")  // bitData : 10000
    bitData = bitData and ((1 shl 4).inv())  // bitData = 0b10000, ((1 shl 4) = 0b10000).inv() = 0b01111)을 and 연산한 값이 들어감
    println("bitData : ${bitData.toString(2)}")  // bitData : 0
    bitData = bitData xor (0b10101)  // 00000 xor 10101 = 10101
    println("bitData : ${bitData.toString(2)}")  // bitData : 10101



    // 코루틴 ---------------------------------------------------------------------------------------
    /**
     * 코루틴 사용 시 import kotlinx.coroutines.*를 선언해야 한다.
     * 코루틴 scope는 제어범위, 실행범위를 지정할 수 있다.
     *
     * GlobalScope : 프로그램 어디서나 제어, 동작이 가능한 기본 범위이다
     * CoroutineScope : 특정한 목적의 Dispatcher를 지정하여 제어 및 동작이 가능한 범위이다
     *                  Dispatchers.Default : 기본적인 백그라운드 동작
     *                  Dispatchers.IO : I/O에 최적화된 동작
     *                  Dispatchers.Main : 메인 스레드에서 동작 (UI)
     * Dispatcher들은 지원되는 플렛폼에 따라 다름
     * launch는 반환값이 없는 Job 객체, async는 반환값이 있는 Deffered 객체를 반환한다.
     * 람다함수의 형태를 가지므로 마지막 값이 반환된다
     * 코루틴은 제어되는 스코프 또는 프로그램 전체가 종료되면 함께 종료된다.
     *
     * delay() : milisecond 단위로 루틴을 잠시 대기시켜주는 함수
     * join() : Job의 실행이 끝날때까지 기다려주는 함수
     * await() : Deffered의 실행이 끝날때까지 기다려주고 결과값을 반환해주는 함수
     * 위의 세 함수는 코루틴 내부 또는 runBlocking{}과 같은 루틴의 대기가 가능한 구문 안에서만 동작이 가능하다.
     *
     * cancel() : 코루틴 실행 도중에 중단하기
     *          1. delay()나 yield()함수까지 수행된 뒤 자동으로 종료, 2. isActive가 false로 바뀌는데 이 때 수동으로 종료 시키기
     *
     * withTimeoutOrNull() : 제한 시간안에 수행되지 않으면 null을 반환하는 함수
     */
    val scope = GlobalScope
    scope.launch {
        println("scope.launch {}")
        for (i in 1..5) {
            println(i)
        }
    }
    /**
     * 결과가 나오지 않는 이유는 코루틴이 실행되기 전에 메인이 끝나버리고 코루틴도 같이 종료되기 때문이다.
     * 결과를 보려면 코루틴이 끝날 때까지 메인이 잠시 기다려주어야 한다.
     * runBlocking 블럭을 만들고 그 안에 launch나 async를 생성하면 메인 스레드가 코루틴을 처리할 때까지 잠시 기다려 준다.
     * runBlocking 주의 : 안드로이드의 메인 스레드에서 runBlocking을 걸고 일정 시간 이상 응답이 없는 경우 ANR이 발생하며
     *                  앱이 강제 종료된다.
     */
    runBlocking {
        launch {
            println("runBlocking { launch {} }")
            for(i in 1..5) {
                println(i)
            }
        }
    }  // runBlocking 처리로 인해 위의 scope.launch가 실행되는데 runBlocking 모두를 주석처리하면 scope.launch가 실행되지 않는다.
    runBlocking {
        val a = launch {
            for(i in 1..5) {
                println(i)
                delay(100)
            }
        }
        val b = async {
            "async 종료"
        }
        println("async 대기")
        println(b.await())  // 실행이 끝날때까지 기다려주고 결과값을 반환해주는 함수
        println("launch 취소")
        a.cancel()
        println("launch 대기")
        a.join()  // join()함수를 부르기 전 이미 취소되어서 실행 종료된 상태임
        println("launch 종료")

        var result = withTimeoutOrNull(90) {
            for(i in 1..10) {
                println(i)
                delay(10)
            }
            "Finish"
        }
        println(result)
    }
}

fun welcomeMsg(msg: String) : Unit {  // 반환값으로 Unit은 생략 가능하다.
    println("Welcome $msg")
}

fun add(a: Int, b: Int) : Int {
    return a+b
}
fun add(a: String, b: String) : String {  // 오버로딩
    return a+b
}
fun add(a: String, b: String, c: String = "초기값") : String {  // 3번째 인자가 들어오지 않을 때 자동으로 값이 들어감
    return a+b+c
}
fun add(vararg numbers: Int) {  // 개수가 지정되지 않은 파라미터 vararg, 맨 마지막에 위치해야 함
    var sum = 0
    for(n in numbers) {
        sum += n
    }
    println(sum)
}  // 메인함수에서 sum(1, 2, 3, 4, 5) 으로 사용하면 됨

// infix 함수
infix fun Int.multiply(x: Int) : Int = this * x
/**
 * main함수에서 사용
 * 6 multiply 4 또는 6.multiply(4) 로 사용할 수 있다.
 * 여기서 6은 this에 해당하고, 4는 x에 해당한다.
 */



// 클래스, 추상 클래스, 인터페이스 등 -------------------------------------------------------------------
class Person {  // 클래스 선언
}
val person = Person()  // 객체 생성



class Person1 {  // 클래스 선언
    var name: String = ""
    constructor(name: String) {  // 생성자 (보조 생성자)
        this.name = name
        println("constructor")
    }
}
class Person2(var name: String, var birth: Int) {  // 클래스 선언
    init {  // 생성자 (기본 생성자, 초기화)
        println("init")
    }
    constructor(name: String) : this(name, 1994) {  // 생성자 (보조 생성자)
        println("constructor $name, $birth")
    }
    // Person2(이름) 이름만 지정 시 birth에는 1994가 들어가면서 init과 constructor가 실행된다.
}
class Person3(name: String) {
    var name = ""
    init {  // 초기화 (인스턴스화 할 때 가장 먼저 초기화 됌, 이후 생성자 호출)
        this.name = name
    }
}
// val person3 = Person3("이름")
// person3.name = "개명"


open class Animal(val name: String) { }  // open 키워드가 있어야 상속이 가능함
class Dog(name : String) : Animal(name) { }  // 상속



class OuterClass {
    var a = "Outer Class"
    companion object {  // 반드시 companion object 안에서 선언되어야 하며 기본 자료형만 가능하다.
        const val CONST_A = 123 // const는 컴파일 시점에 결정되어 절대 바꿀 수 없는 값, 성능 향상
    }
    class NestedClass {  // 중첩 클래스
        // 외부 클래스에 대한 참조를 가지고 있지 않음
        var a = "NestedClass"
    }
    inner class InnerClass {  // 내부 클래스
        // 내부 클래스는 외부 클래스에 대한 참조를 가지고 있음
        fun kotlinTest() {
            a = "InnerClass"
            println(this@OuterClass.a)  // 외부 클래스의 변수를 호출함
            println(a)
        }
    }
}



/**
 * 상속 규칙
 * 서브 클래스는 수퍼 클래스에 존재하는 속성와 같은 이름의 속성을 가질 수 없다.
 * 서브 클래스가 생성될 때에는 수퍼클래스의 생성자까지 호출해야 한다.
 */
open class Drink {  // 상속 가능한 클래스
    var name = "음료"

    open fun drink() {
        println("${name}를 마십니다.")
    }
}
class Cola : Drink() {
    var type = "콜라"

    override fun drink() {  // 오버라이딩 시 서브클래스에서 부모클래스와 동일한 이름의 함수를 재구현 할 수 있다.
        println("${name}중에 ${type}를 마십니다.")
    }

    fun wash() {
        println("빈 ${type}를 청소합니다.")
    }
}

/**
 * 메인함수에서 실행
var a = Drink()
a.drink()  // 음료를 마십니다.

var b: Drink = Cola()
b.drink()  // 음료중에 콜라를 마십니다.
// Drink 변수이므로 b.wash()를 호출할 수는 없다.
if(b is Cola) {  // is는 동일한지, 호환되는지 확인함
// is나 as로 다운캐스팅을 해야하는데 여기서는 is로 조건문 안에서만 잠시 캐스팅됨
b.wash()  // 빈 콜라를 청소합니다.
}

var c = b as Cola  // as를 쓰면 변수 b 자체도 다운캐스팅된다.
c.wash()  // 빈 콜라를 청소합니다.
b.wash()  // 빈 콜라를 청소합니다. (다운캐스팅 되어 wash 함수를 사용할 수 있게 됌)

var d: Cola = Cola()
d.drink()  // 음료중에 콜라를 마십니다.
d.wash()  // 빈 콜라를 청소합니다.
 */



open class Animal1(var name: String, var age: Int, var type: String) {
    fun introduce() {
        println("${type}, ${name}이고, ${age}살 입니다.")
    }
}
class Dog1(name: String, age: Int) : Animal1(name, age, "개") {
    fun bark() {
        println("멍멍")
    }
}
class Cat1(name: String, age: Int) : Animal1(name, age, "고양이") {
    fun meow() {
        println("야옹")
    }
}
/**
 * 메인함수에서 실행
var aa = Animal1("댕댕이", 4, "개")
var bb = Dog1("댕댕이", 4)
var cc = Cat1("댕댕이", 4)
aa.introduce()
bb.introduce()
bb.bark()
cc.introduce()
cc.meow()
 */



abstract class AbstractClass {  // 클래스 안에 추상 메서드가 있을 경우 abstract 키워드를 붙여야 함
    // 단독으로 abstract 클래스를 인스턴스로 만들 수 없음
    abstract fun func1()  // 추상 메서드
    fun fun2() { }
}
class RealizationClass : AbstractClass() {  // 추상 클래스 상속받음 (클래스 상속 시 ()를 붙인다)
    override fun func1() {
        println("추상클래스를 상속받으면 그 안의 추상메서드는 구현해야함")
    }
}
//val abstractClass = AbstractClass()  // 에러
//val realizationClass = RealizationClass()  // 가능
//realizationClass.func1()  // 출력 : 추상클래스를 상속받으면 그 안의 추상메서드는 구현해야함



interface Runnable {  // 인터페이스 선언
    fun run1()
    fun fastRun() = println("빨리 달린다.")
}
class Human : Runnable {  // 인터페이스를 상속받은 클래스, 인터페이스는 여러 개를 상속받을 수 있음.
    override fun run1() {  // 추상클래스나 인터페이스나 구현 안 된 메서드들은 구현시켜주어야 함
        println("그냥 달린다.")
    }
}
//val human = Human()  // 인터페이스를 상속받았지만 클래스는 클래스임
//human.run1()  // 출력 : 그냥 달린다.
//human.fastRun()  // 출력 : 빨리 달린다.



// data 클래스 (getter, setter 구현없이 데이터를 저장하고 불러올 수 있음)
/**
 * 5가지 기능을 자동으로 생성해준다.
 * equals(), hashcode(), toString(), copy(), componentX()
 * componentX()는 x, y in 배열 에서 x, y를 의미함
 */
data class DTO (val dto: String)



// enum 클래스
enum class State(val msg: String) {
    SING("노래 부르는 중"),
    EAT("밥 먹는 중"),
    SLEEP("잠자는 중");  // 여기에는 세미콜론이 필요함

    fun isSleeping() = this == State.SLEEP
}
/**
 * 메인함수에서 실행
var state = State.SING
println("state : $state")  // state : SING
state = State.SLEEP
println("state : $state")  // state : SLEEP
println("state.isSleeping() : ${state.isSleeping()}")  // state.isSleeping() : true
state = State.EAT
println("state : $state")  // state : EAT
println("state.msg : ${state.msg}")  // state.msg : 밥 먹는 중
 */


// 제네릭 클래스
class Box<T> (t: T) {  // 타입은 알아서 추론됨
    var value = t
}
val boxInt: Box<Int> = Box<Int> (1)  // 제네릭 클래스 사용
val boxString: Box<String> = Box<String> ("generics")
// println("boxInt : ${boxInt.value}, boxString : ${boxString.value}\n")

// 상속관계에서 제네릭 클래스
open class Box1 {
    open fun shout1() {
        println("Box1이 소리칩니다.")
    }
}
class Box2 : Box1() {
    override fun shout1() {
        println("Box2가 소리칩니다.")
    }
}
class Box3 : Box1() {
    override fun shout1() {
        println("Box3이 소리칩니다.")
    }
}
class UsingGeneric<T: Box1> (val t: T) {  // 캐스팅을 방지할 수 있으므로 성능을 더 높일 수 있다.
    fun doShouting() {
        t.shout1()
    }
}
// main함수에서
//UsingGeneric(Box1()).doShouting()
//UsingGeneric(Box2()).doShouting()
//UsingGeneric(Box3()).doShouting() 으로 사용함

// 제네릭 함수
fun <T: Box1> doShouting(t: T) {
    t.shout1()
}
// main함수에서
//doShouting(Box2()) 으로 사용함