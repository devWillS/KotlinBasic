package kotlins.basic.q10

enum class ImageUtil {
    KOTLIN {
        override fun getResource(): Int {
            return R.drawable.kotlin
        }
    },
    JAVA {
        override fun getResource(): Int {
            return R.drawable.java
        }
    },
    SWIFT {
        override fun getResource(): Int {
            return R.drawable.swift
        }
    },
    OBJECTIVE_C {
        override fun getResource(): Int {
            return R.drawable.objective_c
        }
    },
    REACT_NATIVE {
        override fun getResource(): Int {
            return R.drawable.react_native
        }
    };

    abstract fun getResource(): Int
}