package model;

import org.junit.Assert;

import static org.junit.jupiter.api.Assertions.*;

class TestsTour {

    @org.junit.jupiter.api.Test
    void isNullLinks(){
        Tour tour = new Tour.Builder().build();

        Assert.assertEquals(tour.getLocation(), null);
        Assert.assertEquals(tour.getService(), null);
        Assert.assertEquals(tour.getOwner(), null);
    }

    @org.junit.jupiter.api.Test
    void calcPrice() {
        Tour tour1 = new Tour.Builder().setPrice(100).setTaxes(17).setService(new Service.Builder().setPrice(100).build()).build();
        Tour tour2 = new Tour.Builder().setPrice(-100).setTaxes(-17).setService(new Service.Builder().setPrice(-100).build()).build();

        Tour tour3 = new Tour.Builder().build();

        Assert.assertEquals(tour1.calcPrice(),217,0);
        Assert.assertEquals(tour2.calcPrice(),-1,0);

        Assert.assertEquals(tour3.calcPrice(),-1,0);
    }

    @org.junit.jupiter.api.Test
    void getContact() {
        Tour tour1 = new Tour.Builder()
                .setOwner(new Worker.Builder()
                        .setFName("Alex")
                        .setLName("Lasek")
                        .setPhone("+111-111-111-111")
                        .build())
                .setLocation(new Location.Builder()
                        .setName("Lost spa")
                        .setAddress("Some Street")
                        .setCountry(new Country.Builder()
                                .setName("USA")
                                .setCapital("WSDC")
                                .build())
                        .setPhone("+222-222-222-222")
                        .build())
                .build();

        Assert.assertEquals(tour1.getContact().contains("Alex Lasek"), true);
        Assert.assertEquals(tour1.getContact().contains("USA, WSDC, Some Street, Lost spa"), true);

        Tour tour2 = new Tour.Builder().build();
        Assert.assertEquals(tour2.getContact().contains("Alex Lasek"), false);
        Assert.assertEquals(tour2.getContact().contains("Not enough info"), true);
    }

    @org.junit.jupiter.api.Test
    void getInfo() {
        Client client = new Client.Builder()
                .setFName("Martin")
                .setLName("Garix")
                .build();
        Service service = new Service.Builder()
                .setPrice(178)
                .setName("Horses")
                .build();
        Location location = new Location.Builder()
                .setCountry(new Country.Builder()
                        .setName("GB")
                        .setCapital("London")
                        .build())
                .setName("Super Hotel")
                .setAddress("Main street, 256b")
                .build();
        Tour tour = new Tour.Builder().setAccommodation(true)
                .setAccommodation_type("some accommodation")
                .setCompanyName("New company")
                .setExcursion(true)
                .setFood(true)
                .setFood_type("some food")
                .setLocation(location)
                .setPrice(1000)
                .setService(service)
                .setTaxes(5)
                .setTransport("some car")
                .setVisa_service(true)
                .build();

        String exp = tour.getInfo(client);

        Assert.assertEquals(true, tour.getInfo(client).contains("Martin Garix"));
        Assert.assertEquals(true, tour.getInfo(client).contains("some food"));
        Assert.assertEquals(true, tour.getInfo(client).contains("Visa services: Yes"));
        Assert.assertEquals(true, tour.getInfo(client).contains("Total: 1183.0$"));

        Tour tour1 = new Tour.Builder().build();
        String exp1 = tour1.getInfo(client);
        Assert.assertEquals(false, tour1.getInfo(client).contains("Martin Garix"));
        Assert.assertEquals(true, tour1.getInfo(client).contains("Not enough info"));
    }
}