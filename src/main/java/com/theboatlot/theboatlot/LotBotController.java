package com.theboatlot.theboatlot;


import com.theboatlot.theboatlot.Boat;
import com.theboatlot.theboatlot.Lot;
import com.theboatlot.theboatlot.Spot;
import com.theboatlot.theboatlot.Transaction;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

@RestController
public class LotBotController {
    List<Transaction> transactions = new ArrayList<>();
    List<Lot> lots = new ArrayList<>();

    @CrossOrigin
    @GetMapping(value = "/lots")
    public List<Lot> getAllLots() {
        //Get a list of all lots in the system, including # of spots.
        return lots;
    }

    @CrossOrigin
    @GetMapping(value = "lots/{id}")
    public Lot getLotStatus(@PathVariable("id") int id) {
        //Get a list of the status of all spots in the specified lot, including the license plate # of anyone parked.
        return lots.get(id);
    }

    @CrossOrigin
    @PostMapping(value = "/lots/{id}/{spot}")
    public void parkNewBoat(@PathVariable("id") int id, @PathVariable("spot") int spot, @RequestBody Boat boat) {
        //Park a new car in the specified lot. Must send the Boat object in the request body.
        //TODO: how to access the right int for spot?
        lots.get(id).getSpots()[spot].setTransaction(Transaction.createTransaction(boat, LocalDateTime.now(), lots.get(id).getHourlyPrice()));
    }

    @CrossOrigin
    @PutMapping(value = "/lots/{id}/{spot}")
    public double unparkBoatAndReturnMoneys(@PathVariable("id") int id, @PathVariable("spot") int spot) {
        //Open up the specified spot and return the total owed. PUT a null Transaction Object in replacement
        Spot s = lots.get(id).getSpots()[spot];
        Transaction t = s.getTransaction();
        double hourlyPriceForLot = lots.get(id).getHourlyPrice();

        //update checkout time
        t.setCheckedOutDate(LocalDateTime.now());

        //get the hourly price and multiply by amount of time in spot
        double totalHours = getHoursBetweenDates(t.getCheckedInDate(), t.getCheckedOutDate());
        t.setTotalCost(totalHours*hourlyPriceForLot);

        //add transaction to permanent list for records
        transactions.add(t);

        //set boat to null
        s.setTransaction(null);

        return t.getTotalCost();
    }

    @CrossOrigin
    @GetMapping(value = "/transactions")
    public List<Transaction> returnAllTransactions(){
        //Return a list of all transactions, along with the bill and license plate number of the charged vehicle.

        return transactions;
    }

    @PostConstruct
    public void postConstruct() {
        //for testing purposes

        //first, create lots with 20 spots
        lots.add(Lot.createLot("Nelson Marina", 2.00));
        lots.add(Lot.createLot("Batemans Yard", 3.00));
        lots.add(Lot.createLot("Kearnzy Harbour", 1.50));
        lots.add(Lot.createLot("Gloucester Bay", 2.50));

        //second, create some boats
        Boat boat1 = new Boat("PAL-5698");
        Boat boat2 = new Boat("WPQ-7456");
        Boat boat3 = new Boat("AKS-2828");
        Boat boat4 = new Boat("NJI-7532");
        Boat boat5 = new Boat("PAL-5698");
        Boat boat6 = new Boat("WPQ-7456");
        Boat boat7 = new Boat("WHN-7583");
        Boat boat8 = new Boat("QKS-9514");
        Boat boat9 = new Boat("PAL-5698");
        Boat boat10 = new Boat("WPQ-7456");
        Boat boat11 = new Boat("POI-1234");
        Boat boat12 = new Boat("GIK-0182");

        //third, create some transactions
        lots.get(0).getSpots()[0].setTransaction(Transaction.createTransaction(boat1, LocalDateTime.now(), 2));
        lots.get(0).getSpots()[13].setTransaction(Transaction.createTransaction(boat2, LocalDateTime.now(), 2));
        lots.get(0).getSpots()[10].setTransaction(Transaction.createTransaction(boat3, LocalDateTime.now(), 2));
        lots.get(0).getSpots()[19].setTransaction(Transaction.createTransaction(boat4, LocalDateTime.now(), 3));
        lots.get(1).getSpots()[0].setTransaction(Transaction.createTransaction(boat5, LocalDateTime.now(), 5));
        lots.get(1).getSpots()[4].setTransaction(Transaction.createTransaction(boat6, LocalDateTime.now(), 7));
        lots.get(1).getSpots()[7].setTransaction(Transaction.createTransaction(boat7, LocalDateTime.now(), 3));
        lots.get(1).getSpots()[10].setTransaction(Transaction.createTransaction(boat8, LocalDateTime.now(), 1));
        lots.get(2).getSpots()[11].setTransaction(Transaction.createTransaction(boat9, LocalDateTime.now(), 7));
        lots.get(2).getSpots()[18].setTransaction(Transaction.createTransaction(boat10, LocalDateTime.now(), 12));
        lots.get(2).getSpots()[19].setTransaction(Transaction.createTransaction(boat11, LocalDateTime.now(), 9));
        lots.get(2).getSpots()[2].setTransaction(Transaction.createTransaction(boat12, LocalDateTime.now(), 4));
        lots.get(3).getSpots()[3].setTransaction(Transaction.createTransaction(boat1, LocalDateTime.now(), 6));
        lots.get(3).getSpots()[7].setTransaction(Transaction.createTransaction(boat2, LocalDateTime.now(), 2));
        lots.get(3).getSpots()[19].setTransaction(Transaction.createTransaction(boat3, LocalDateTime.now(), 1));
        lots.get(3).getSpots()[17].setTransaction(Transaction.createTransaction(boat4, LocalDateTime.now(), 5));

        transactions.add(Transaction.createTransaction(boat1, LocalDateTime.now(), 10.99));
        transactions.get(0).setCheckedOutDate(LocalDateTime.now());
        transactions.add(Transaction.createTransaction(boat2, LocalDateTime.now(), 6.65));
        transactions.get(1).setCheckedOutDate(LocalDateTime.now());
        transactions.add(Transaction.createTransaction(boat3, LocalDateTime.now(), 3.78));
        transactions.get(2).setCheckedOutDate(LocalDateTime.now());
        transactions.add(Transaction.createTransaction(boat4, LocalDateTime.now(), 12.23));
        transactions.get(3).setCheckedOutDate(LocalDateTime.now());
    }

    public static double getHoursBetweenDates(LocalDateTime start, LocalDateTime end) {
        return Duration.between(start, end).get(ChronoUnit.SECONDS) / 3600;
    }
}