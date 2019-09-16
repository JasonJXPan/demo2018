package pjx.test.essearch1.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by juqi on 19/5/2.
 */
@Data
public class Entity implements Serializable {

    private static final long serialVersionUID = -763638353551774166L;

    public static final String INDEX_NAME = "index_entity";

    public static final String TYPE = "tstype";

    private Long id;

    private String name;

    private String creator;

    public Entity() {
        super();
    }

    public Entity(Long id, String name, String creator) {
        this.id = id;
        this.name = name;
        this.creator = creator;
    }



}