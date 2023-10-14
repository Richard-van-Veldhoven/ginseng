package space.murim.ginseng

class Tables {
    var inner: MutableList<Table> = arrayListOf(Table());

    /**
     * Maps Table (chronologically ordered) to the contained ComponentIds
     */
    var contains: MutableList<Component> = ArrayList();


    fun addEntity(entity: Entity) {
        // The first table should only contain the entity column

    }


    class Table {
        var columns: MutableList<Pair<Component, Column>> = ArrayList()


    }
}
