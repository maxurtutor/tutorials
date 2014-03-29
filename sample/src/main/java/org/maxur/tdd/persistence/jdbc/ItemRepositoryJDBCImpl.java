package org.maxur.tdd.persistence.jdbc;

import org.maxur.tdd.domain.Currency;
import org.maxur.tdd.domain.Item;
import org.maxur.tdd.domain.ItemRepository;
import org.maxur.tdd.domain.Money;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Maxim Yunusov
 * @version 1.0
 * @since <pre>2/14/14</pre>
 */
public class ItemRepositoryJDBCImpl implements ItemRepository {

    private DataSource dataSource;

    public void setDataSource(DataSource ds) {
        dataSource = ds;
    }

    public Item findById(Long id) {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        final List<Item> result = select
                .query("select ID, NAME, AMOUNT, CURRENCY from ITEM where ID = ?",
                        new Object[]{id},
                        new ItemRowMapper());
        if (result.isEmpty())  {
            return null;
        }
        if (result.size() > 1) {
            throw new IllegalStateException("There are more than one item by one id");
        }
        return result.get(0);
    }

    public List<Item> findAll() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
        return select
                .query("select ID, NAME, AMOUNT, CURRENCY from ITEM",
                        new ItemRowMapper());
    }

    public static class ItemRowMapper implements RowMapper<Item> {
        @Override
        public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new ItemExtractor().extractData(rs);
        }
    }

    private static class ItemExtractor implements ResultSetExtractor<Item> {
        @Override
        public Item extractData(ResultSet rs) throws SQLException, DataAccessException {
            final Money money = new Money(rs.getLong("AMOUNT"), Currency.valueOf(rs.getString("CURRENCY")));
            return new Item(rs.getLong("ID"), rs.getString("NAME"), money);
        }
    }
}
