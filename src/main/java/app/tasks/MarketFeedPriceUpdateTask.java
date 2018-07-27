package app.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MarketFeedPriceUpdateTask {

    @Autowired
    private RestTemplate template;
    private static Logger logger = LoggerFactory.getLogger(MarketFeedPriceUpdateTask.class);

    @Scheduled(fixedRate = 2000)
    public void logPriceUpdates() {
        String s = template.getForObject("http://feed.conygre.com:8080/MockYahoo/quotes.csv?s=goog&f=p0", String.class);
        logger.info("Google " + s);
        s = template.getForObject("http://feed.conygre.com:8080/MockYahoo/quotes.csv?s=fb&f=p0", String.class);
        logger.info("Facebook " + s);
    }
}
