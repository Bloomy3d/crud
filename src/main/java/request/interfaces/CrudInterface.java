package request.interfaces;

public interface CrudInterface<T, ID> {

    /**
     * Save a new entity or update an existing one.
     *
     * @param entity the entity to save
     * @return the saved entity
     */
    Object save(T entity);

    /**
     * Find an entity by its ID.
     *
     * @param id the ID of the entity
     * @return an Optional containing the found entity or empty if not found
     */
    Object findById(ID id);

    /**
     * Retrieve all entities.
     *
     * @return a list of all entities
     */
    Object findAll();

    /**
     * Update an entity.
     *
     * @param id     the long of the entity to update
     * @param entity the updated entity
     * @return the updated entity
     */
    Object update(long id, T entity);

    /**
     * Delete an entity by its ID.
     *
     * @param id the long of the entity to delete
     * @return true if the entity was deleted, false otherwise
     */
    Object deleteById(long id);

    /**
     * Delete all entities.
     */
    Object deleteAll();
}
