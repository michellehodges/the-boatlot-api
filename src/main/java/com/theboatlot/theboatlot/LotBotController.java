package com.theboatlot.theboatlot;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
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
        //Get a list of the status of all spots in the specified lot,
        //including the license plate # of anyone parked.
        return lots.get(id);
    }
//
//    @CrossOrigin
//    @PostMapping(value = "/lots/{id}")
//    public Lot parkNewBoat(@PathVariable("id") int id, @RequestBody Boat boat) {
//        //Park a new car in the specified lot. Must send the Car object
//        //in the request body.
//
//    }
//
//    @CrossOrigin
//    @PutMapping(value = "/lots/{id}/{spot}")
//    public int unparkBoatAndReturnMoneys() {
//        //Open up the specified spot and return the total owed. PUT a null Boat Object
//        //in replacement
//    }
//
//    @CrossOrigin
//    @GetMapping(value = "/transactions")
//    public Transaction returnAllTransactions(){
//        //transactions
//        //Return a list of all transactions, along with the
//        //bill and license plate number of the charged vehicle.
//    }

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

        //TODO: third, add transactions in transaction list
    }
}