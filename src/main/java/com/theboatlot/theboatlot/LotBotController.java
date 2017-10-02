package com.theboatlot.theboatlot;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
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
    @PostMapping(value = "/lots/{id}")
    public void parkNewBoat(@PathVariable("id") int id, @RequestBody int spot, @RequestBody String boat) {
        //Park a new car in the specified lot. Must send the Car object in the request body.
        lots.get(id).getSpots()[spot].setBoat(Boat.createBoat(boat));
    }
//
//    @CrossOrigin
//    @PutMapping(value = "/lots/{id}/{spot}")
//    public int unparkBoatAndReturnMoneys() {
//        //Open up the specified spot and return the total owed. PUT a null Boat Object in replacement
//    }
//
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
        lots.add(Lot.createLot("Nelson Marina"));
        lots.add(Lot.createLot("Batemans Yard"));
        lots.add(Lot.createLot("Kearnzy Harbour"));
        lots.add(Lot.createLot("Gloucester Bay"));

        //second, create boats that already occupy the spots
        lots.get(0).getSpots()[0].setBoat(Boat.createBoat("XHJ-1123"));
        lots.get(0).getSpots()[13].setBoat(Boat.createBoat("JLK-1298"));
        lots.get(0).getSpots()[10].setBoat(Boat.createBoat("OIU-6798"));
        lots.get(0).getSpots()[19].setBoat(Boat.createBoat("POI-1234"));
        lots.get(1).getSpots()[0].setBoat(Boat.createBoat("GIK-0182"));
        lots.get(1).getSpots()[4].setBoat(Boat.createBoat("AOS-7456"));
        lots.get(1).getSpots()[7].setBoat(Boat.createBoat("PQL-9621"));
        lots.get(1).getSpots()[10].setBoat(Boat.createBoat("WHN-7583"));
        lots.get(2).getSpots()[11].setBoat(Boat.createBoat("QKS-9514"));
        lots.get(2).getSpots()[18].setBoat(Boat.createBoat("QPQ-7536"));
        lots.get(2).getSpots()[19].setBoat(Boat.createBoat("KSK-9632"));
        lots.get(2).getSpots()[2].setBoat(Boat.createBoat("PLM-1478"));
        lots.get(3).getSpots()[3].setBoat(Boat.createBoat("AKS-2828"));
        lots.get(3).getSpots()[7].setBoat(Boat.createBoat("WPQ-7456"));
        lots.get(3).getSpots()[19].setBoat(Boat.createBoat("NJI-7532"));
        lots.get(3).getSpots()[17].setBoat(Boat.createBoat("PAL-5698"));

        //third, add transactions in transaction list
        Boat boat1 = new Boat("PAL-5698");
        Boat boat2 = new Boat("WPQ-7456");
        Boat boat3 = new Boat("AKS-2828");
        Boat boat4 = new Boat("QKS-9514");

        transactions.add(Transaction.createTransaction(boat1, LocalDateTime.now(), LocalDateTime.now(), 10.99));
        transactions.add(Transaction.createTransaction(boat2, LocalDateTime.now(), LocalDateTime.now(), 6.65));
        transactions.add(Transaction.createTransaction(boat3, LocalDateTime.now(), LocalDateTime.now(), 3.78));
        transactions.add(Transaction.createTransaction(boat4, LocalDateTime.now(), LocalDateTime.now(), 12.23));
    }
}