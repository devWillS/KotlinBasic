package kotlins.basic.q5

class FiveYearTeacher(
    name: String,
    age: Int,
    gender: Boolean,
    baseSalary: Double
) : Teacher(name, age, gender, baseSalary) {
    override fun calculateSalary(): Double {
        return baseSalary * 1.1
    }
}