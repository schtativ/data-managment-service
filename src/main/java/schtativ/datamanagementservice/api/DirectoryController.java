package schtativ.datamanagementservice.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import schtativ.datamanagementservice.dal.db.entity.base.ColumnInfo;
import schtativ.datamanagementservice.dal.db.entity.core.Directory;
import schtativ.datamanagementservice.dal.db.repository.base.DataStorageRepository;
import schtativ.datamanagementservice.dal.db.repository.base.DataStorageRepositoryFactory;
import schtativ.datamanagementservice.dal.db.repository.core.DirectoryRepository;

import java.util.List;

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
    public List<ColumnInfo> getTableInfo() {
        return dbmsRepository.getTableInfo("directory");
    }
}
