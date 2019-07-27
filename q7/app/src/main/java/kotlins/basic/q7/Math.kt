package kotlins.basic.q7

class Math(
    private var result: Result
) {

    fun calculate(a: Int, b: Int) {
        result.result(a + b)
    }
}