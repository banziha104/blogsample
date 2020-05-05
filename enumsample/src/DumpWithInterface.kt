
// 인터페이스를 정의합니다.
interface Calculable2 {
    fun calculate(weight: Int): Int
    fun dump(weight: Int) : Int
}

enum class GarbageType6(
    val koName: String,
    val dumpingPrice : Int // 10kg미만일때 가격을 추가해줍니다
) : Calculable2 {
    PLASTIC("플라스틱",100) {
        // 각 멤버가 인터페이스에 정의된 메소드를 구현해줍니다.
        override fun calculate(weight: Int): Int = when (weight) {
            in 0..10 -> 100
            in 10..29 -> 150
            in 30..Int.MAX_VALUE -> 200
            else -> throw EnumValueMisMathedException()
        }
    },
    GLASS("유리",150) {
        override fun calculate(weight: Int): Int = when (weight) {
            in 0..10 -> 100
            in 10..29 -> 150
            in 30..kotlin.Int.MAX_VALUE -> 200
            else -> throw EnumValueMisMathedException()
        }
    },
    IRON("고철",200) {
        override fun calculate(weight: Int): Int = when (weight) {
            in 0..10 -> 100
            in 10..29 -> 150
            in 30..kotlin.Int.MAX_VALUE -> 200
            else -> throw EnumValueMisMathedException()
        }
    };

    // 각 요소가 구현하지 않고, enum class 자체에서 구현합니다
    override fun dump(weight: Int): Int = dumpingPrice * weight

}


fun main() {
    val pair = 20 to GarbageType6.PLASTIC
    val (weight, type) = pair

    // plastic의 멤버변수 dumpingPrice가 100원이므로 "총 가격은 2000입니다."가 출력됩니다.
    println("총 가격은 ${type.dump(weight)} 입니다.")
}


