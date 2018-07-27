package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AppConfig {

    public static void main(String[] args) {
        SpringApplication.run(AppConfig.class);
    }

    @RequestMapping("/home")
    public String home() {
        return "Welcome to the Trading Execution Service";
    }
}
