package schtativ.datamanagementservice.dal.db.entity.core;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(schema = "core", name = "directory")
@Getter
@Setter
public class Directory {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String code;

    @Column
    private String dbname;

    @Column
    private String description;
}
