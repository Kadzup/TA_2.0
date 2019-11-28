package model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TestsWorker {

    @Test
    void getYear() {
        Worker w1 = new Worker.Builder().setBDay(LocalDate.now()).build();

        Assert.assertEquals(2019, w1.getYear());
    }

    @Test
    void getInfo() {
        Worker w1 = new Worker.Builder()
                .setBDay(LocalDate.now())
                .setFName("Alex")
                .setLName("Lusek")
                .setPosition("software engineer")
                .setSalary(1500)
                .build();

        String ex = w1.getInfo();
        Assert.assertEquals(true, w1.getInfo().contains("First Name: Alex"));
        Assert.assertEquals(true, w1.getInfo().contains(LocalDate.now().toString()));
    }

    @Test
    void getFullName() {
        Worker w1 = new Worker.Builder().setFName("Alex").setLName("Lusek").build();

        Assert.assertEquals(true, w1.getFullName().contains("Alex Lusek"));
        Assert.assertEquals(true, new Worker.Builder().build().getFullName().contains(""));
    }
}