package org.maxur.tdd.domain;

import java.util.List;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>2/28/14</pre>
 */
public interface ItemRepository {
    Item findById(Long id);

    List<Item> findAll();
}
