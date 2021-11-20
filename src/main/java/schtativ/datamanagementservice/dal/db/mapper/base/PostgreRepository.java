package schtativ.datamanagementservice.dal.db.mapper.base;

import org.apache.ibatis.annotations.*;
import schtativ.datamanagementservice.common.DbmsName;
import schtativ.datamanagementservice.dal.db.entity.base.ColumnInfo;
import schtativ.datamanagementservice.dal.db.repository.base.DbmsRepository;
import schtativ.datamanagementservice.dal.db.repository.base.DataStorageRepository;

import java.util.List;

@Mapper
@DbmsRepository(name = DbmsName.POSTGRESQL)
public interface PostgreRepository extends DataStorageRepository {
    @Select("select column_name, data_type, character_maximum_length, column_default, is_nullable from INFORMATION_SCHEMA.COLUMNS where table_name = #{name}")
    @Results({
            @Result(property = "columnName", column = "column_name"),
            @Result(property = "dataType", column = "data_type"),
            @Result(property = "characterMaximumLength", column = "character_maximum_length"),
            @Result(property = "isNullable", column = "is_nullable"),
    })
    List<ColumnInfo> getTableInfo(@Param("name") String tableName);
}
