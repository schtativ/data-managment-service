package schtativ.datamanagementservice.dal.db.repository.core;

import org.springframework.data.repository.CrudRepository;
import schtativ.datamanagementservice.dal.db.entity.core.Directory;

public interface DirectoryRepository extends CrudRepository<Directory, Long> {
}
