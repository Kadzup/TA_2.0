package model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TestCountry {

    @Test
    void getInfo() {
        Country country = new Country.Builder()
                .setPopulation(41953020)
                .setName("Ukraine")
                .setCapital("Kiev")
                .setArea(603628)
                .build();

        Assert.assertEquals(true, country.getInfo().contains("Name: Ukraine"));
        Assert.assertEquals(true, country.getInfo().contains("Capital: Kiev"));

        Country c2 = new Country.Builder().build();
        Assert.assertEquals(true, c2.getInfo().contains("Capital: null"));
        Assert.assertEquals(true, c2.getInfo().contains("0.0"));
    }

    @Test
    void getCountry() {
        Country country = new Country.Builder()
                .setName("Ukraine")
                .setCapital("Kiev")
                .build();

        Assert.assertEquals(true, country.getCountry().contains("Ukraine, Kiev"));

        Country c2 = new Country.Builder().build();
        Assert.assertEquals(true, c2.getCountry().contains("null, null"));
    }
}