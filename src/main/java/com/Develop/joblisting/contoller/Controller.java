package com.Develop.joblisting.contoller;

import com.Develop.joblisting.entity.Entity;
import com.Develop.joblisting.repository.Repository;
import com.Develop.joblisting.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private Repository repository;
    @Autowired
    private Service service;

    @ApiIgnore
    @RequestMapping("/")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/allPosts")
    public List<Entity> getAllProperties(){
    return repository.findAll();
    }

    @GetMapping("/allposts/{text}")
    public List<Entity> search(@PathVariable String text){
        return service.searchByText(text);
    }

    @PostMapping("/addPost")
    public Entity savePost(@RequestBody Entity entity){
        return repository.save(entity);
    }
}
