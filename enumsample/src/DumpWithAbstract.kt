
// 인터페이스를 정의합니다.

enum class GarbageType7(
    val koName: String,
    val dumpingPrice : Int // 10kg미만일때 가격을 추가해줍니다
) {
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
    abstract fun calculate(weight: Int) : Int
    // 동일한 로직을 사용하는 경우에는, abstract 하지 않고 바로 구현하면됩니다.
    fun dump(weight: Int): Int = dumpingPrice * weight

}


fun main() {
    val pair = 20 to GarbageType7.PLASTIC
    val (weight, type) = pair

    // plastic의 멤버변수 dumpingPrice가 100원이므로 "총 가격은 2000입니다."가 출력됩니다.
    println("총 가격은 ${type.dump(weight)} 입니다.")
}


