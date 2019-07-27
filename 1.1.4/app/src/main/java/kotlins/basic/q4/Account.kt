package kotlins.basic.q4

class Account(
    private var name: String,
    private var age: Int,
    private var gender: String,
    private var language: String
) {
    fun printInfo() {
        if (gender.equals("male")) {
            println(name + "君は、" + language + "が得意な" + age + "歳です。" )
        } else {
            println(name + "さんは、" + language + "が得意な" + age + "歳です。")
        }
    }
}