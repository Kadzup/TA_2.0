package model;
import java.time.LocalDate;

public class Interface{
    public static void main(String args[]) {

        Client client = new Client.Builder()
                .setBDay(LocalDate.now())
                .setEmail("dstefurak@email.net")
                .setFName("Dmytro")
                .setLName("Stefurak")
                .setPaymentInfo("0000-0000-0000-0000")
                .setPhone("+380 5088 340 11")
                .build();

        Worker worker = new Worker.Builder()
                .setAddress("some street")
                .setBDay(LocalDate.now())
                .setFName("Alex")
                .setLName("Lusek")
                .setPhone("+000 000 0000 00")
                .setPosition("software engineer")
                .setSalary(1500)
                .build();

        Country country = new Country.Builder()
                .setArea(50000)
                .setCapital("some capital")
                .setName("Country")
                .setPopulation(1000000)
                .build();

        Location location = new Location.Builder()
                .setAddress("some street")
                .setAvailable(true)
                .setCountry(country)
                .setName("some name")
                .setPhone("+000 000 0000 00")
                .setRating(5)
                .build();

        Service service = new Service.Builder()
                .setName("some name")
                .setPrice(1000)
                .setProviderCompany("some company")
                .setRiskCover(true)
                .build();

        Tour tour = new Tour.Builder()
                .setAccommodation(true)
                .setAccommodation_type("some type")
                .setCompanyName("New company")
                .setExcursion(true)
                .setFood(true)
                .setFood_type("some type")
                .setLocation(location)
                .setOwner(worker)
                .setPrice(1000)
                .setService(service)
                .setTaxes(5)
                .setTransport("some car")
                .setVisa_service(true)
                .build();

        Order order = new Order.Builder()
                .setArrival(LocalDate.now())
                .setClient(client)
                .setDeparture(LocalDate.now())
                .setPrice(1000)
                .setTour(tour)
                .build();

        System.out.println(order.orderTour());

        System.out.println("\n" + location.getFullAddress());

        System.out.println("\n" + client.getClientContact() + "\n\n" + client.getFullName());
    }
}