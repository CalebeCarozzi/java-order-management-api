package com.calebecarozzi.javaordermanagementapi.resources;

import com.calebecarozzi.javaordermanagementapi.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//pra fala que é um recurso web e que é implementado por um cntrolador web ->
//dai depois precida de um nome
@RestController
@RequestMapping(value="/Users")
public class UserResource {

    //response entity -> retorna respostas de requisição web
    //o getMapping pra fala que ele responde a uma requisição de tipo get
    @GetMapping
    public ResponseEntity<User> findAll(){
        //apenas para testar
        User u = new User(1L, "Maria", "maria@gmail.com", "999999999", "12345");
        return ResponseEntity.ok().body(u);
    }

    


}
