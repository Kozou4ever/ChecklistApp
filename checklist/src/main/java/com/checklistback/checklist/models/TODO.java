package com.checklistback.checklist.models;

import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "todo")
public class TODO implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="list_id", nullable=false)
    private Checklist list;

    @NotBlank
    @Size(max = 255)
    private String properties;

    public TODO() {
    }

    public TODO(Long id, Checklist list, String properties) {
        this.id = id;
        this.list = list;
        this.properties = properties;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Checklist getList() {
        return list;
    }

    public void setList(Checklist list) {
        this.list = list;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }
}
