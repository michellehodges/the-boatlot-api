package com.theboatlot.theboatlot;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.*;

@RestController
public class LotBotController {
    List<Transaction> transactions = new ArrayList<>();
    List<Lot> lots = new ArrayList<>();
    Set<Spot> spotSet = new HashSet<>();
    Map<Lot, Set<Spot>> lotSetMap = new HashMap<>();

    @CrossOrigin
    @GetMapping(value = "/lots")
    public List<Lot> getAllLots() {
        //Get a list of all lots in the system, TODO: including # of spots.
        return lots;
    }

//    @CrossOrigin
//    @GetMapping(value = "lots/{id}")
//    public Set<Spot> getLotStatus(@PathVariable("id") int id) {
//        //Get a list of the status of all spots in the specified lot,
//        //including the license plate # of anyone parked.
//
//
//
//    }
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
        lots.add(Lot.createLot("Nelson Marina"));
        lots.add(Lot.createLot("Batemans Yard"));
        lots.add(Lot.createLot("Kearnzy Harbour"));
        lots.add(Lot.createLot("Gloucester Bay"));
    }
}