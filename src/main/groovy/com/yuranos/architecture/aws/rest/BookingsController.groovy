package com.yuranos.architecture.aws.rest

import com.yuranos.architecture.aws.relational.BookingRepository
import groovy.json.JsonBuilder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
/**
 * Created by yuranos on 9/20/17.
 */
@RestController
@Newify([JsonBuilder, Booking])
class BookingsController implements ErrorHandler {

    @Autowired
    BookingRepository bookingRepository

    @GetMapping("/booking/{id}")
    String getBooking(@PathVariable(required = true) int id) {
        def booking = bookingRepository.findById(id)
        return JsonBuilder(booking.orElse(Booking())).toPrettyString()
    }

    @PostMapping("/booking")
    ResponseEntity<String> postBooking(@RequestBody Booking booking) {
        def createdBooking = bookingRepository.save(booking)
        return ResponseEntity.ok("The booking with id $createdBooking.id has been created")
    }

    @DeleteMapping("/booking/{id}")
    ResponseEntity<String> deleteBooking(@PathVariable(required = true) int id) {
        bookingRepository.deleteById(id)
        return ResponseEntity.ok("The booking with id ${id} has been deleted")
    }

    @PutMapping("/booking/{id}")
    ResponseEntity<String> putBooking(@PathVariable(required = true) int id, @RequestBody Booking booking) {
        int status = bookingRepository.update(id, booking)
        return ResponseEntity.ok("The booking with id $id has been updated")
    }

//    @RequestMapping("/")
//    @ResponseBody
//    DeferredResult<String> home() {
//        // Create DeferredResult with timeout 5s
//        final DeferredResult<String> result = new DeferredResult<>(5000);
//
//        // Let's call the backend
//        ListenableFuture<ResponseEntity<String>> future = restTemplate.getForEntity("http://www.google.com", String.class);
//        future.addCallback(new ListenableFutureCallback<ResponseEntity<String>>() {
//            @Override
//            public void onSuccess(ResponseEntity<String> response) {
//                // Will be called in HttpClient thread
//                log("Success");
//                result.setResult(response.getBody());
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                result.setErrorResult(t.getMessage());
//            }
//        });
//        // Return the thread to servlet container, the response will be processed by another thread.
//        return result;
//    }
}
