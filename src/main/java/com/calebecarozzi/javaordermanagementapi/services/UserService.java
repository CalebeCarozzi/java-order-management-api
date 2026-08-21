package com.calebecarozzi.javaordermanagementapi.services;

import com.calebecarozzi.javaordermanagementapi.entities.User;
import com.calebecarozzi.javaordermanagementapi.repositories.UserRepository;
import com.calebecarozzi.javaordermanagementapi.services.exceptions.DataBaseException;
import com.calebecarozzi.javaordermanagementapi.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> obj = repository.findById(id);
        //vou tenta da o get pra pega o usuario do Opcional, dai se não tiver, vai lança exceção
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    //vai inserir e retornar o objeto inserido
    public User insert(User obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        try{
            if (!repository.existsById(id)) {
                throw new ResourceNotFoundException(id);
            }
            repository.deleteById(id);
            repository.deleteById(id);
        }catch(DataIntegrityViolationException e){
            throw new DataBaseException(e.getMessage());
        }
    }

    public User update(Long id, User obj){
        try {
            User entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }catch(EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }

}
