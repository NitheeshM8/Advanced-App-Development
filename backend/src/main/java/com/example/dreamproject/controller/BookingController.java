package com.example.dreamproject.controller;
import org.springframework.web.bind.annotation.RestController;
import com.example.dreamproject.entity.Booking;
import com.example.dreamproject.service.BookingService;

import io.swagger.v3.oas.annotations.Operation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    BookingService bookingService;

    @PostMapping("/")
    public void addBooking(@RequestBody Booking booking) {
        bookingService.addBooking(booking);
    }

    @GetMapping("/")
    public List<Booking> getBooking(){
        return bookingService.getBookings();
    }
    
    //Get bookings of specific user
    @Operation(summary="Get bookings of specific user")
    @GetMapping("/user/{id}")
    public List<Booking> getBookingByUserId(@PathVariable String id){
        return bookingService.getBookingsByUserId(id);
    }

    //Get bookings under specific boat
    @Operation(summary="Get bookings under specific boat")
    @GetMapping("/boat/{id}")
    public List<Booking> getBookingByBoatId(@PathVariable String id){
        return bookingService.getBookingsByBoatId(id);
    }
    @DeleteMapping("/{id}")
    public void deleteBookingById(@PathVariable int id){
        bookingService.deleteBookingById(id);
    }       
}
