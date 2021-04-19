package com.madas;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@Component
public class NumberGeneratorImpl implements NumberGenerator {

//    Random random = new ThreadLocalRandom();

    private final int maxNumber;
    private final int minNumber;

    @Autowired
    public NumberGeneratorImpl(@MaxNumber int maxNumber,@MinNumber int minNumber) {
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

    @Override
    public int next() {
        return ThreadLocalRandom.current().nextInt(minNumber, maxNumber);
    }

}
