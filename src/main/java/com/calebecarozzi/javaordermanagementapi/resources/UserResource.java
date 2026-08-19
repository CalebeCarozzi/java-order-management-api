package com.calebecarozzi.javaordermanagementapi.resources;

import com.calebecarozzi.javaordermanagementapi.entities.User;
import com.calebecarozzi.javaordermanagementapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

//pra fala que é um recurso web e que é implementado por um cntrolador web ->
//dai depois precida de um nome
@RestController
@RequestMapping(value="/Users")
public class UserResource {

    @Autowired
    private UserService service;

    //response entity -> retorna respostas de requisição web
    //o getMapping pra fala que ele responde a uma requisição de tipo get
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    //quando for colocar um novo, é o metodo post
    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }





}
