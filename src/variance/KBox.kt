package variance

class KBox <out T>(private val value: T) {

    fun get(): T {
        return value
    }
}

fun main() {
    val kbox = KBox<Int>(123)
    process(kbox)
}

fun process(procedure: KBox<Number>) : Int{

}