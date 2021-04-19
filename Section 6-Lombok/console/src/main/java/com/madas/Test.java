package com.madas;

import com.madas.config.GameConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Test {
//    private static final Logger logger = LoggerFactory.getLogger(Test.class);

//    private static final String BEANS_XML = "beans.xml";

    public static void main(String[] args) {
        log.info("Hello!");

        //create a context first
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(GameConfig.class);
//        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(BEANS_XML);

//        game.reset();

        //close context
        context.close();
    }
}
