package agiletravel.dai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication

public class DaiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DaiApplication.class, args);
    }

}
