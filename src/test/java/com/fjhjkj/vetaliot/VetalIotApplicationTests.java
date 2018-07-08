package com.fjhjkj.vetaliot;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class VetalIotApplicationTests {
    @Test
    public void asd() {
        Arrays.asList(1, 2, 3)
                .stream()
                .filter(i -> i % 2 == 0)
                .forEach(System.out::println);
    }
}
