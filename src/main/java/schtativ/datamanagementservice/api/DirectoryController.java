package schtativ.datamanagementservice.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import schtativ.datamanagementservice.dal.db.entity.core.Directory;
import schtativ.datamanagementservice.dal.db.repository.core.DirectoryRepository;

@RestController()
@RequestMapping(path = "/directory")
public class DirectoryController {

    private final DirectoryRepository directoryRepository;

    public DirectoryController(DirectoryRepository directoryRepository) {
        this.directoryRepository = directoryRepository;
    }

    @GetMapping()
    public Iterable<Directory> getAll() {
        return directoryRepository.findAll();
    }
}
