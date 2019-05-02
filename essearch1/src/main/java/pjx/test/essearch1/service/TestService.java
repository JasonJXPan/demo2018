package pjx.test.essearch1.service;

import pjx.test.essearch1.entity.Entity;

import java.util.List;

/**
 * Created by juqi on 19/5/2.
 */
public interface TestService {

    void saveEntity(Entity entity);

    void saveEntity(List<Entity> entityList);

    List<Entity> searchEntity(String searchContent);
}