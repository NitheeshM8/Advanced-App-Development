package com.example.dreamproject.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dreamproject.entity.Booking;
import com.example.dreamproject.repository.BookingRepo;

@Service
public class BookingService {
    @Autowired
    BookingRepo bookingRepo;

    public void addBooking(Booking booking){
        bookingRepo.save(booking);
    }

    public List<Booking> getBookings(){
        return bookingRepo.findAll();
    }

    public List<Booking> getBookingsByUserId(String userId){
        return bookingRepo.findByUserId(userId);
    }

    public List<Booking> getBookingsByBoatId(String boatId){
        return bookingRepo.findByBoatId(boatId);
    }
    public void deleteBookingById(int id){
        bookingRepo.deleteById(id);
    }
}
