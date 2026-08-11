package com.calebecarozzi.javaordermanagementapi.resources;

import com.calebecarozzi.javaordermanagementapi.entities.User;
import com.calebecarozzi.javaordermanagementapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
