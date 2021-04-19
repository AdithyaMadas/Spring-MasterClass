package com.madas;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class MessageGeneratorImpl implements MessageGenerator {

    private Game game;

    private int guessCount;

    @Autowired
    public MessageGeneratorImpl(Game game, @Value("${game.maxGuesses}") int guessCount) {
        this.game = game;
        this.guessCount = guessCount;
    }

    @PostConstruct
    public void setUp() {
        log.info("\u001B[35mMessage Genertor now Setup!\u001B[0m");
        guessCount = 10;
    }

    @Override
    public String getMainMessage() {
        return "The number is in between " + game.getSmallest() + " and " + game.getBiggest() + ". Can you guess it?";
    }

    @Override
    public String getResultMessage() {
        if (game.isGameWon()) {
            return "Congrats! You guessed the right number!";
        } else if (game.isGameLost()) {
            return "You lost! :( The number was " + game.getNumber();
        } else if (!game.isValidNumberRange()) {
            return "Inavlid Number range!";
        } else if (game.getRemainingGuesses() == guessCount) {
            return "What is your first guess?";
        } else {
            String direction = "Lower";
            if (game.getGuess() < game.getNumber()) {
                direction = "Higher";
            }

            return direction + "! You have " + game.getRemainingGuesses() + "  guesses left.";
        }
    }
}
