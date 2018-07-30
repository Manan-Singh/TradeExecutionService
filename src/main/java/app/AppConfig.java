package app;

import app.Messenger.Sender;
import app.Messenger.TradeOrder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.EnableJms;


@SpringBootApplication
@EnableJms
public class AppConfig {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(app.AppConfig.class, args);
        Sender sender = new Sender(context);
        TradeOrder order = new TradeOrder("true", 0,88.0,2000,"HON" );
        sender.sendMessage(order);

    }

}



