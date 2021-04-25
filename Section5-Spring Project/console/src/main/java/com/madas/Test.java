package com.madas;

import com.madas.config.GameConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    private static final Logger logger = LoggerFactory.getLogger(Test.class);

//    private static final String BEANS_XML = "beans.xml";

    public static void main(String[] args) {
        logger.info("Hello!");

        //create a context first
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(GameConfig.class);
//        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext(BEANS_XML);

//        game.reset();

        //close context
        context.close();
    }
}
