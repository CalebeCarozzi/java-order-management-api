package com.calebecarozzi.javaordermanagementapi.config;

//classe de configuração para o perfil de teste

import com.calebecarozzi.javaordermanagementapi.entities.Category;
import com.calebecarozzi.javaordermanagementapi.entities.Order;
import com.calebecarozzi.javaordermanagementapi.entities.User;
import com.calebecarozzi.javaordermanagementapi.entities.enums.OrderStatus;
import com.calebecarozzi.javaordermanagementapi.repositories.CategoryRepository;
import com.calebecarozzi.javaordermanagementapi.repositories.OrderRepository;
import com.calebecarozzi.javaordermanagementapi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

//serve pra fazer o database seeding -> popular o banco de dados com alguns objetos

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    //aqui vai ter que ter uma dependencia ao repository
    //com essa notação, ele vai resolver a dependencia e associar uma instancia
    // de user repository aqui dentro
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    //como fazer pra implementar os dados quando o projeto for iniciado
    //pra isso a interface, tudo aqui dentro vai ser executado quando a aplicação for iniciada
    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT ,u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

        Category cat1 = new Category(null, "Electronics");
        Category cat2 = new Category(null, "Books");
        Category cat3 = new Category(null, "Computers");

        userRepository.saveAll(Arrays.asList(u1, u2));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));
        categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
    }



}
