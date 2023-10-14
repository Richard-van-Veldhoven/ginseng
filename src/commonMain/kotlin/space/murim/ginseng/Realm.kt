package space.murim.ginseng


typealias Row = Int;

class Realm {
    companion object {
        val ENTITY_ID: Entity = Entity(0, 0u);
    }

    /**
     * Entity Allocation fields
     */
    private var entities: MutableList<Triple<Entity, Tables, Row>?> = ArrayList();
    private var free: MutableList<Entity> = ArrayList();

    /**
     * Table fields
     */
    private var tables: Tables = Tables()

    fun allocate(): Entity {
        val entity = if (free.isEmpty()) {
            Entity(entities.size, 0u)
        } else {
            val entity = free.removeLast()
            entity.generation++
            entity
        }

        // Add to table with only entity in it and check the row
        tables.addEntity(entity)
    }

    fun deallocate(entity: Entity): Boolean {
        return if (isAlive(entity)) {
            entities[entity.index] = null
            free.add(entity)
            true
        } else {
            false
        }
    }

    fun isAlive(entity: Entity): Boolean = entity.generation == entities[entity.index]?.first?.generation
}
