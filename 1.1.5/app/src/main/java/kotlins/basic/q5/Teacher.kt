package kotlins.basic.q5

open class Teacher(
    var name: String,
    var age: Int,
    var gender: Boolean,
    var baseSalary: Double
) {
    open fun calculateSalary(): Double {
        return baseSalary
    }
}