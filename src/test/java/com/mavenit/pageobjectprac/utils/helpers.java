package com.mavenit.pageobjectprac.utils;

import java.util.Random;

public class helpers {
    public int randomNumberGenerator(int size) {
        Random random = new Random();
        return random.nextInt(size - 1);
    }
}
