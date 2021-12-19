package schtativ.datamanagementservice.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import schtativ.datamanagementservice.common.sql.entity.Column;
import schtativ.datamanagementservice.common.sql.entity.DataType;
import schtativ.datamanagementservice.dal.db.entity.base.ColumnInfo;
import schtativ.datamanagementservice.dal.db.entity.core.Directory;
import schtativ.datamanagementservice.dal.db.repository.base.DataStorageRepository;
import schtativ.datamanagementservice.dal.db.repository.base.DataStorageRepositoryFactory;
import schtativ.datamanagementservice.dal.db.repository.core.DirectoryRepository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@RestController()
@RequestMapping(path = "/directory")
public class DirectoryController {

    private final DirectoryRepository directoryRepository;
    private final DataStorageRepository dbmsRepository;

    public DirectoryController(DirectoryRepository directoryRepository, DataStorageRepositoryFactory dbmsFactory) {
        this.directoryRepository = directoryRepository;
        this.dbmsRepository = dbmsFactory.get();
    }

    @GetMapping()
    public Iterable<Directory> getAll() {
        return directoryRepository.findAll();
    }

    @GetMapping(path = "/tableInfo")
    public List<Column> getTableInfo() {
        return dbmsRepository.getTableInfo("directory");
    }


    @GetMapping(path = "/createTable")
    public Collection<Column> createTable() {
        Column codeColumn = new Column("code", DataType.STRING, 255, false);
        Column descriptionColumn = new Column("description", DataType.STRING, 1024, true);

        Set<Column> columns = Set.of(codeColumn, descriptionColumn);

        dbmsRepository.createTable("testtest", columns);

        return columns;
    }
}
