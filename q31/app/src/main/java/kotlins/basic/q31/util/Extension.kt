package kotlins.basic.q31.util


inline fun <T> guard(value: T?, ifNull: () -> Unit): T {
    if (value != null) return value
    ifNull()
    throw Exception("Guarded from null!")
}

internal inline fun <reified T : Any> objectOf() = T::class.java