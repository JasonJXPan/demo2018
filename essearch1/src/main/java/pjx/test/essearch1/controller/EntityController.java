package pjx.test.essearch1.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pjx.test.essearch1.entity.Entity;
import pjx.test.essearch1.service.TestService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by juqi on 19/5/2.
 */
@RestController
@RequestMapping("/entityController")
public class EntityController {


    @Autowired
    TestService cityESService;

    @RequestMapping(value="/save", method= RequestMethod.GET)
    public String save(long id, String name, String creator) {
        System.out.println("save 接口");
        if(id>0 && StringUtils.isNotEmpty(name)) {
            Entity newEntity = new Entity(id,name, creator);
            List<Entity> addList = new ArrayList<Entity>();
            addList.add(newEntity);
            cityESService.saveEntity(addList);
            return "OK";
        }else {
            return "Bad input value";
        }
    }

    @RequestMapping(value="/search", method=RequestMethod.GET)
    public List<Entity> save(String name) {
        List<Entity> entityList = null;
        if(StringUtils.isNotEmpty(name)) {
            entityList = cityESService.searchEntity(name);
        }
        return entityList;
    }
}