package kotlins.basic.q6

abstract class Employee(
    var name: String,
    var age: Int,
    var gender: Boolean,
    var address: String,
    var baseSalary: Double
) {
    abstract fun computeYearlyPay(): Double
}