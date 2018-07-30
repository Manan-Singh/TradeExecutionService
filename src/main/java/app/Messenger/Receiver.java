package app.Messenger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class Receiver {
    /**
     * Get a copy of the application context
     */
    @Autowired
    ConfigurableApplicationContext context;

    /**
     * When you receive a message, print it out, then shut down the application.
     * Finally, clean up any ActiveMQ server stuff.
     */
    @JmsListener(destination = "OrderBroker_Reply", containerFactory = "myJmsContainerFactory")
    public void receiveMessage(String message) {
        System.out.println("<" + message + ">");
        //context.close();
    }
}

