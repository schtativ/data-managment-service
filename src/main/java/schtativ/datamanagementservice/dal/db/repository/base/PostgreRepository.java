package schtativ.datamanagementservice.dal.db.repository.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import schtativ.datamanagementservice.common.DbmsComponent;
import schtativ.datamanagementservice.common.DbmsName;
import schtativ.datamanagementservice.common.sql.entity.Column;
import schtativ.datamanagementservice.dal.db.mapper.ColumnMapper;

import javax.sql.DataSource;
import java.util.Collection;
import java.util.List;

@Repository
@DbmsComponent(name = DbmsName.POSTGRESQL)
public class PostgreRepository extends JdbcDaoSupport implements DataStorageRepository {

    private final ColumnMapper mapper;

    @Autowired
    public PostgreRepository(@Qualifier("dataSource") DataSource dataSource, ColumnMapper mapper) {
        this.setDataSource(dataSource);
        this.mapper = mapper;
    }

    @Override
    public List<Column> getTableInfo(String tableName) {
        String sql = "select column_name, udt_name, character_maximum_length, " +
                "column_default, is_nullable " +
                "from INFORMATION_SCHEMA.COLUMNS where table_name = ?";

        List<Column> columns = this.getJdbcTemplate().query(sql, mapper, tableName);
        return columns;
    }

    @Override
    public void createTable(String tableName, Collection<Column> columns) {

    }
}
