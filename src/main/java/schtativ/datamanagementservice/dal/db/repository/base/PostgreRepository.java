package schtativ.datamanagementservice.dal.db.repository.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import schtativ.datamanagementservice.common.DbmsComponent;
import schtativ.datamanagementservice.common.DbmsName;
import schtativ.datamanagementservice.common.sql.entity.Column;
import schtativ.datamanagementservice.common.sql.entity.type.CharDataTypeInfo;
import schtativ.datamanagementservice.common.sql.entity.type.DataType;

import javax.sql.DataSource;
import java.util.*;

@Repository
@DbmsComponent(name = DbmsName.POSTGRESQL)
public class PostgreRepository extends JdbcDaoSupport implements DataStorageRepository {

    @Autowired
    public PostgreRepository(@Qualifier("dataSource") DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    @Override
    public List<Column> getTableInfo(String tableName) {
        String sql = "select column_name, data_type, character_maximum_length, " +
                "column_default, is_nullable " +
                "from INFORMATION_SCHEMA.COLUMNS where table_name = ?";

        List<Map<String, Object>> maps = this.getJdbcTemplate().queryForList(sql, tableName);
        return Arrays.asList(new Column("f", new CharDataTypeInfo(DataType.STRING, 255), true));
    }

    @Override
    public void createTable(String tableName, Collection<Column> columns) {

    }
}
