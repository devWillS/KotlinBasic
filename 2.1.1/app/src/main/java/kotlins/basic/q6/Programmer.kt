package kotlins.basic.q6

class Programmer(
    name: String,
    age: Int,
    gender: Boolean,
    address: String,
    baseSalary: Double,
    var numberOfProjects: Int,
    var rank: Char
) : Employee(
    name,
    age,
    gender,
    address,
    baseSalary
) {
    override fun computeYearlyPay(): Double {
        return baseSalary + (10000 * numberOfProjects) + getBonusByRank()
    }

    private fun getBonusByRank(): Int {
        return when (rank) {
            'A' ->
                10000
            'B' ->
                7000
            'C' ->
                4000
            else ->
                0
        }
    }
}