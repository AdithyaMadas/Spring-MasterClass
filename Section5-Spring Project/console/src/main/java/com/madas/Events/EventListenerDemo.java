package com.madas.Events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EventListenerDemo implements ApplicationListener {

    public static final Logger logger = LoggerFactory.getLogger(EventListenerDemo.class);


    //We can listen to events in 2 ways, the below method is by making our class implement ApplicationListener and overriding the onApplicationEvent method
    // and performing some logic. After all bean loading is completed, spring publishes a ContextRefreshedEvent. Which comes into the below method.
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        logger.info(applicationEvent.toString());
        logger.info("Container ready for Use!");

    }
    //The 2nd way to listen for events is using the EventListener Annotation. The method can be anything but should take ApplicationEvent as parameter.
    // Before terminating all the beans, ContextClosedEvent is published , so the below method is called.
    @EventListener
    public void shutDown(ContextClosedEvent applicationEvent) {
        logger.info(applicationEvent.toString());
        logger.info("shutDown() --> Container is being closed!");
    }

    //Custom Events can also be created by implementing the ApplicationEvent class. And we can write logic for the same. When the event is published, it calls the method.
    //TODO See how to publish events.
}
