package space.murim.ginseng

class Column {
    private var inner: MutableList<Any> = ArrayList()

    /**
     * # Invariant
     * Column#push must only be on columns of which the type is the same as the src
     */
    fun push(src: Any) {
        inner.add(src)
    }

    operator fun get(index: Int): Any? {
        return inner.getOrNull(index)
    }
}
