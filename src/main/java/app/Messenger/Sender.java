package app.Messenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import sun.security.krb5.Config;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.io.Serializable;
import java.util.UUID;

@EnableJms
@Service
public class Sender implements Serializable {

    @Bean
    JmsListenerContainerFactory<?> myJmsContainerFactory(ConnectionFactory connectionFactory){
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        return factory;
    }

    private ConfigurableApplicationContext context;

    public Sender(ConfigurableApplicationContext context){
        this.context = context;
    }


    public void sendMessage(TradeOrder order){
        // Send a message
        MessageCreator messageCreator = new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                Message message = session.createTextMessage(String.format("<trade>\n" +
                        "<buy>%s</buy> \n" +
                        "<id>%s</id>\n" +
                        "<price>%s</price>\n" +
                        "<size>%s</size>\n" +
                        "<stock>%s</stock>\n" +
                        "<whenAsDate>%s</whenAsDate>\n" +
                        "</trade>", order.getBuy(), order.getId(), order.getPrice(), order.getSize(), order.getStock(), order.getWhenAsDate()));
                message.setJMSCorrelationID(UUID.randomUUID().toString());
                return message;
            }
        };
        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
        System.out.println("Sending a new message.");
        jmsTemplate.send("OrderBroker", messageCreator);

    }
}
