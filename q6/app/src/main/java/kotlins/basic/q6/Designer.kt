package kotlins.basic.q6

class Designer(
    name: String,
    age: Int,
    gender: Boolean,
    address: String,
    baseSalary: Double,
    var numberOfProjects: Int
) :Employee(
    name,
    age,
    gender,
    address,
    baseSalary
) {
    override fun computeYearlyPay(): Double {
        return baseSalary + (10000 * numberOfProjects)
    }
}