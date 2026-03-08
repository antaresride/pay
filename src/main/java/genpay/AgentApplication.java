package genpay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class AgentApplication {

    private static final Logger log = LoggerFactory.getLogger(
        AgentApplication.class
    );

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(
            AgentApplication.class,
            args
        );
        /*for (String name : ctx.getBeanDefinitionNames()) {
            log.info("Loaded Bean: " + name);
            }*/
    }
}
