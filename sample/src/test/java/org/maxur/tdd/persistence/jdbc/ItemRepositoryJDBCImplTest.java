package org.maxur.tdd.persistence.jdbc;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.maxur.tdd.domain.Item;
import org.maxur.tdd.persistence.jpa.AbstractDAOJPATest;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>2/28/14</pre>
 */
public class ItemRepositoryJDBCImplTest extends AbstractDAOJDBCTest {

    private ItemRepositoryJDBCImpl repository;


    @Before
    public void initTest() throws Exception {
        repository = new ItemRepositoryJDBCImpl();
        repository.setDataSource(dataSource);

        IDataSet dataSet = new FlatXmlDataSetBuilder().build(
                AbstractDAOJPATest.class.getResourceAsStream("/sql/dataset.xml"));

        IDatabaseConnection databaseConnection = new DatabaseConnection(getConnection());
        //Clean the data from previous test and insert new data test.
        DatabaseOperation.CLEAN_INSERT.execute(databaseConnection, dataSet);

    }

    @Test
    public void testFindAll() {
        List<Item> items = repository.findAll();
        assertNotNull(items);
        assertFalse(items.isEmpty());
    }

    @Test
    public void testFindById() {
        Item item = repository.findById(1l);
        assertNotNull(item);
        assertEquals("a", item.getName());
    }


    @After
    public void after() {
    }


}
