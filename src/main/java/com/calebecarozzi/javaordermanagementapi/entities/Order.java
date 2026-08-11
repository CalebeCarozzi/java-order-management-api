package com.calebecarozzi.javaordermanagementapi.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_order")
public class Order {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
    private Instant moment;

    //aqui o join column pra porque é esse lado da relação que controla e faz a ligação
    //é na tabela order que vai ter varias usuarios, dai tem que coloca em qual coluna
    //que o hibernate vai fazer a ligação entre o user e o order, no caso é na coluna cliente_id
    //esse é o Owning side
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    //lazy loading, significa que dentro de order ele carrega o usuario associado
    //isso porque só tem um, mas se fosse o contrario, dentro de user, ele não carrega
    //pra não estorar a memoria no trafego, porque dai o usuario pode ter varios pedidos


    public Order(){}

    public Order(Long id, Instant moment, User client) {
        this.id = id;
        this.moment = moment;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getClient() {
        return client;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
