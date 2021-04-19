package com.madas;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Getter
@Component
public class GameImpl implements Game {

    @Getter(AccessLevel.NONE)
    private final NumberGenerator numberGenerator;

    //    @Value("${game.maxGuesses}")
    private final int guessCount;

    @Autowired
    public GameImpl(NumberGenerator numberGenerator, @GuessCount int guessCount) {
        this.numberGenerator = numberGenerator;
        this.guessCount = guessCount;
    }

    int number;
    int smallest;
    int biggest;
    int remainingGuesses;
    boolean validNumberRange;

    @Setter
    int guess;

    @PostConstruct
    @Override
    public void reset() {
        number = numberGenerator.next();
        log.info("\u001B[34mNumber Generated is {}\u001B[0m", number);
//        System.out.println("\u001B[34mNumber Generated is {}");
        smallest = numberGenerator.getMinNumber();
        biggest = numberGenerator.getMaxNumber();
        remainingGuesses = guessCount;
        validNumberRange = true;
    }

    @PreDestroy
    public void cleanUp() {
        log.info("Destroying bean GameImpl!");
    }

    @Override
    public void check() {
        checkValidNumberRange();
        if (validNumberRange) {
            if (number < guess) {
                biggest = guess - 1;
            } else if (number > guess) {
                smallest = guess + 1;
            }
            remainingGuesses--;
        }
    }

    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }


    private void checkValidNumberRange() {
        validNumberRange = guess <= biggest && guess >= smallest;
    }
}


