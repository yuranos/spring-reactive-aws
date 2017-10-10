package com.yuranos.architecture.aws.rest

import com.yuranos.architecture.aws.relational.BookingRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
/**
 * Created by yuranos on 9/20/17.
 */
@RestController
@Newify(Booking)
class BookingController implements DateFormatability {

    @Autowired
    BookingRepository bookingRepository

    @GetMapping("/booking/{id}")
    def getBooking(@PathVariable(required = true) int id) {
        def booking = bookingRepository.findById(id)
        booking.orElse(Booking())
    }

    @PostMapping("/booking")
    def postBooking(@RequestBody Booking booking) {
        def createdBooking = bookingRepository.save(booking)
        ResponseEntity.ok("The booking with id $createdBooking.id has been created")
    }

    @DeleteMapping("/booking/{id}")
    def deleteBooking(@PathVariable(required = true) int id) {
        bookingRepository.deleteById(id)
        ResponseEntity.ok("The booking with id ${id} has been deleted")
    }

    @PutMapping("/booking/{id}")
    def putBooking(@PathVariable(required = true) int id, @RequestBody Booking booking) {
        int status = bookingRepository.update(id, booking)
        if(status) {
            ResponseEntity.ok("The booking with id $id has been updated")
        } else {
            ResponseEntity.notFound().build()
        }
    }

}
