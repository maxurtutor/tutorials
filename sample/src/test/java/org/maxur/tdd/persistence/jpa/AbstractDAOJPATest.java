package org.maxur.tdd.persistence.jpa;

import org.eclipse.persistence.internal.jpa.EntityManagerImpl;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import org.apache.derby.tools.ij;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>2/14/14</pre>
 */
public class AbstractDAOJPATest {

    /** The factory that produces entity manager. */
    private static EntityManagerFactory emf;
    /** The entity manager that persists and queries the DB. */
    protected static EntityManager entityManager;
    @BeforeClass
    public static void initTestFixture() throws Exception {
        // Get the entity manager for the tests.
        emf = Persistence.createEntityManagerFactory("TDD-Persistence-Test");
        entityManager = emf.createEntityManager();

        ij.runScript(getConnection(),
                AbstractDAOJPATest.class.getResourceAsStream("/sql/schema.ddl"),
                "UTF-8", System.out, "UTF-8");

    }

    protected static Connection getConnection() {
        return ((EntityManagerImpl) (entityManager.getDelegate()))
                .getServerSession()
                .getAccessor()
                .getConnection();
    }

    /**
     * Cleans up the session.
     */
    @AfterClass
    public static void closeTestFixture() {
        entityManager.close();
        emf.close();
    }




}
