package schtativ.datamanagementservice.common.sql;

import lombok.Getter;
import lombok.Setter;
import schtativ.datamanagementservice.common.sql.convert.SqlConverter;
import schtativ.datamanagementservice.common.sql.entity.*;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class SqlBuilder {

    @Getter
    @Setter
    private class CreateTableInfo {
        private TableName tableName;
        private PrimaryKey key;
        private Collection<Column> columns;
        private Collection<ForeignKey> foreignKeys;
    }

    private final SqlConverter sqlConverter;

    public SqlBuilder(SqlConverter sqlConverter) {
        this.sqlConverter = sqlConverter;
    }

    public CreateTable createTable(String schema, String tableName) {
        SqlBuilder sqlBuilder = new SqlBuilder(this.sqlConverter);
        return new CreateTable(sqlBuilder, schema, tableName);
    }

    private String toSql(CreateTableInfo table) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("CREATE TABLE %s", this.sqlConverter.toSql(table.getTableName())));
        sb.append("(");
        sb.append(this.sqlConverter.toSql(table.getKey()));

        table.getColumns().forEach(column -> {
            sb.append(String.format(", %s", this.sqlConverter.toSql(column)));
        });

        if (Objects.nonNull(table.getForeignKeys())) {
            table.getForeignKeys().forEach(key -> {
                sb.append(String.format(", %s", this.sqlConverter.toSql(key)));
            });
        }

        sb.append(");");
        return sb.toString();
    }

    public class CreateTable {

        private final SqlBuilder sqlBuilder;
        private final CreateTableInfo table;

        public CreateTable(SqlBuilder sqlBuilder, String schema, String name) {
            this.sqlBuilder = sqlBuilder;
            this.table = new CreateTableInfo();
            this.table.setTableName(new TableName(schema, name));
        }

        public PrimaryKeyBuilder primaryKey(DataType type) {
            return new PrimaryKeyBuilder(sqlBuilder, table, type);
        }

        public class PrimaryKeyBuilder {

            private final SqlBuilder sqlBuilder;
            private final CreateTableInfo table;

            public PrimaryKeyBuilder(SqlBuilder sqlBuilder, CreateTableInfo table, DataType type) {
                this.sqlBuilder = sqlBuilder;
                this.table = table;
                this.table.setKey(new PrimaryKey(table.getTableName(), type));
            }

            public ColumnBuilder columns(Collection<Column> columns) {
                return new ColumnBuilder(sqlBuilder, table, columns);
            }

            public class ColumnBuilder {

                private final SqlBuilder sqlBuilder;
                private final CreateTableInfo table;

                public ColumnBuilder(SqlBuilder sqlBuilder, CreateTableInfo table, Collection<Column> columns) {
                    this.sqlBuilder = sqlBuilder;
                    this.table = table;
                    this.table.setColumns(columns);
                }

                public String build() {
                    return sqlBuilder.toSql(table);
                }

                public ForeignKeyBuilder foreignKeys(List<ForeignKey> foreignKeys) {
                    return new ForeignKeyBuilder(sqlBuilder, table, foreignKeys);
                }

                public class ForeignKeyBuilder {

                    private final SqlBuilder sqlBuilder;
                    private final CreateTableInfo table;

                    public ForeignKeyBuilder(SqlBuilder sqlBuilder, CreateTableInfo table, List<ForeignKey> foreignKeys) {
                        this.sqlBuilder = sqlBuilder;
                        this.table = table;
                        this.table.setForeignKeys(foreignKeys);
                    }

                    public String build() {
                        return sqlBuilder.toSql(table);
                    }
                }
            }
        }
    }


}
