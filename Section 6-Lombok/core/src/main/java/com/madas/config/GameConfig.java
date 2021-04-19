package com.madas.config;

import com.madas.GuessCount;
import com.madas.MaxNumber;
import com.madas.MinNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:config/game.properties")
@ComponentScan(basePackages = "com.madas")
public class GameConfig {

    @Value("${game.maxNumber}")
    private int maxNumber;

    @Value("${game.maxGuesses:5}")
    private int guessCount;

    @Value("${game.minNumber}")
    private int minNumber;

    @Bean
    @MaxNumber
    public int maxNumber1() {
        return maxNumber;
    }

    @Bean
    @GuessCount
    public int guessCount2() {
        return guessCount;
    }

    @Bean
    @MinNumber
    public int getMinNumber() {
        return minNumber;
    }
}
