package com.calebecarozzi.javaordermanagementapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


//aqui vamos ter que colocar umas coisas do JPA
// que vão servir para instruir pra ele saber como ele vai
// converter os objetos para o modelo relacional

@Entity
@Table(name = "tb_user")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    //aqui fala que ele é a chave primaria
    // e que vai ser autoincrementada
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;

    //o outro lado é o owning side, então aqui a gente fala pra ele que já
    //esta tudo mapeado do outro lado no atributo cliente
    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();
    //isso faz na hora de chamar com get por exemplio, o jason ignorar os pedidos,
    // se não poderia virar um looping, cada order tem um cliente, dai cada
    // cliente tem varios orders e dai assim vai
    //se eu coloco o JSON ignore no meu user dentro de order, dai inverte, dai ele ignora o client e não os orders
    //dai quando eu coloco /Users na pesquisa, ele chama o usuario e todos os pediddos dele
    //e quando eu coloco /Orders ele chama os pedidos e não mostra quem são seus usuarios
    //e não da looping, porque o order nem se quer mostra mais quem são os clientes então não tem como dar loop

    public User(){}

    public User(Long id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }


}
