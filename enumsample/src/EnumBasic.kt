enum class GarbageType1(
    val koName : String
){
    PLASTIC("플라스틱"),
    GLASS("유리"),
    IRON("고철")
}

fun main() {

    println(GarbageType1.GLASS.compareTo(GarbageType1.PLASTIC))
    // 위에 정의한 IRON 이라는 이름값을 얻을 수 있습니다.
    println(GarbageType1.IRON.name) // "IRON"

    // zero-base index, PLASTIC은 첫 번째 임으로 0이 반환됩니다.
    println(GarbageType1.PLASTIC.ordinal) // 0

    // IRON 세 번째 임으로 2가 반환 됩니다.
    println(GarbageType1.IRON.ordinal) // 1

    // 아래 두 함수는 kotlin 1.1 버전부터 지원됩니다
    /***
     * Enum의 요소를 차례로 배열로 만들어줍니다
     * array == arrayOf(
     *    GarbageType1.PLASTIC,
     *    GarbageType1.GLASS,
     *    GarbageType1.IRON
     * )
     */
    val array = enumValues<GarbageType1>()

    // iterable이기 때문에 map, filter 등 도 가능합니다.
    array
        .filter { it.koName == "플라스틱" }
        .map { it.koName }

    /***
     * GarbageType1에 PLASTIC 이라는 이름을 가진 요소를 반환합니다.
     * type == GarbageType1.PLASTIC
     */
    val type = enumValueOf<GarbageType1>("PLASTIC") // GarbageType
}