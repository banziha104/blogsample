

// 인터페이스를 정의합니다.

enum class GarbageType8(
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

    companion object{
        fun print() {
            enumValues<GarbageType8>()
                .map { "${it.koName}은(는) 10kg에 ${it.dumpingPrice}" }
                .forEach { println(it) }
        }

    }
}


fun main() {
    /**
     * Companion object이기 때문에 바로 접근이가능합니다
     * 플라스틱은(는) 10kg에 100
     * 유리은(는) 10kg에 150
     * 고철은(는) 10kg에 200
     * 출력
     */

    GarbageType8.print()
}


