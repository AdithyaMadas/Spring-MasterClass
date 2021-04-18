package com.madas;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class GameImpl implements Game {

    private static final Logger log = LoggerFactory.getLogger(GameImpl.class);

    private final NumberGenerator numberGenerator;

//    @Value("${game.maxGuesses}")
    private final int guessCount;

    @Autowired
    public GameImpl(NumberGenerator numberGenerator, @GuessCount int guessCount) {
        this.numberGenerator = numberGenerator;
        this.guessCount = guessCount;
    }

    int guess;
    int number;
    int smallest;
    int biggest;
    int remainingGuesses;
    boolean validNumberRange;



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
    public int getNumber() {
        return number;
    }

    @Override
    public int getGuess() {
        return guess;
    }

    @Override
    public void setGuess(int guess) {
        this.guess = guess;
    }

    @Override
    public int getSmallest() {
        return smallest;
    }

    @Override
    public int getBiggest() {
        return biggest;
    }

    @Override
    public int getRemainingGuesses() {
        return remainingGuesses;
    }



    @Override
    public boolean isValidNumberRange() {
        return validNumberRange;
    }

    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }

    /*public GameImpl(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }*/

    private void checkValidNumberRange() {
        validNumberRange = guess <= biggest && guess >= smallest;
    }
}
