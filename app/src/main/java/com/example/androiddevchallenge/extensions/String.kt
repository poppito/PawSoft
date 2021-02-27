package io.embry.pawson.extensions

fun String.capitalCase(): String {
    val initial = toCharArray().first().toUpperCase()
    return initial.toString() + substring(1, this.length)
}