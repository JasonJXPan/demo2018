package com.pjx.demo2018.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author juqi
 * @date 18/5/26
 */
@Controller
public class ThymeleafController {

    @GetMapping("/index")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        view.addObject("title", "我的第一个thymeLeaf WEB界面");
        view.addObject("desc", "欢迎进入我的测试系统");
        Author author = new Author();
        author.setEmail("jasonjxpan@hotmail.com");
        author.setName("Jason Pan");
        author.setWorkingSeniority(5);
        view.addObject("author", author);
        return view;
    }
    @GetMapping("/index1")
    public String index1(HttpServletRequest request) {
        // 与上面的写法不同，但是结果一致。
        // 设置属性
        request.setAttribute("title", "我的第一个WEB页面");
        request.setAttribute("desc", "欢迎进入battcn-web 系统");
        Author author = new Author();
        author.setWorkingSeniority(5);
        author.setEmail("jasonjxpan@hotmail.com");
        author.setName("Jason Pan");
        request.setAttribute("author", author);
        // 返回的 index 默认映射到 src/main/resources/templates/xxxx.html
        return "index";
    }
    class Author {
        private String name;
        private String email;
        private int workingSeniority;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getWorkingSeniority() {
            return workingSeniority;
        }

        public void setWorkingSeniority(int workingSeniority) {
            this.workingSeniority = workingSeniority;
        }
    }
}
