package ir.ac.kntu.SAD_fall98;

import ir.ac.kntu.SAD_fall98.model.User;
import ir.ac.kntu.SAD_fall98.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories
@EnableTransactionManagement
public class SadFall98Application {
    @Autowired
    UserRepository userRepository;

    @Component
    class DataSetup implements ApplicationRunner {

        @Override
        public void run(ApplicationArguments args) throws Exception {
            User user1 = User.builder().username("admin").password("adminadmin").email("admin@gmail.com").build();
            userRepository.save(user1);
        }
    }


    public static void main(String[] args) {
        SpringApplication.run(SadFall98Application.class, args);
    }

}
