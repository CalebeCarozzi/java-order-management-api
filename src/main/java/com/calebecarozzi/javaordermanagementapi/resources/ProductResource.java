package com.calebecarozzi.javaordermanagementapi.resources;

import com.calebecarozzi.javaordermanagementapi.entities.Product;
import com.calebecarozzi.javaordermanagementapi.services.ProductService;
import com.calebecarozzi.javaordermanagementapi.services.ProductService;
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
@RequestMapping(value="/Products")
public class ProductResource {

    @Autowired
    private ProductService service;

    //response entity -> retorna respostas de requisição web
    //o getMapping pra fala que ele responde a uma requisição de tipo get
    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }


}
