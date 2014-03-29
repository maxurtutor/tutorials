package org.maxur.tdd.persistence.jpa;

import org.maxur.tdd.domain.Item;
import org.maxur.tdd.domain.ItemRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static java.lang.String.format;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>2/14/14</pre>
 */
public class ItemRepositoryJPAImpl implements ItemRepository {

    private EntityManager entityManager;


    @PersistenceContext(unitName = "TDD-Persistence")
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Item findById(Long id) {
        return entityManager.getReference(Item.class, id);
    }

    @Override
    public List<Item> findAll() {
        //noinspection unchecked
        return entityManager.createQuery(format(" select i from %s i", Item.class.getName())).getResultList();
    }

}
