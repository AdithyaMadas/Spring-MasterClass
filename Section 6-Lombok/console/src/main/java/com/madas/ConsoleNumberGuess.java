package com.madas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleNumberGuess {

    @Autowired
    Game game;

    @Autowired
    MessageGenerator messageGenerator;

    Scanner sc = new Scanner(System.in);
    @EventListener
    public void start(ContextRefreshedEvent event) {
        while (true) {
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());


            int guess = sc.nextInt();
            sc.nextLine();
            game.setGuess(guess);
            game.check();

            if (game.isGameLost() || game.isGameWon()) {
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Do you want to play again?");
                String ans = sc.nextLine().trim();
                if (ans.equalsIgnoreCase("n")) {
                    break;
                }
                game.reset();
            }
        }
    }
}
