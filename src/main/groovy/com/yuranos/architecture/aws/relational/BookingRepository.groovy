package com.yuranos.architecture.aws.relational

import com.yuranos.architecture.aws.rest.Booking
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

/**
 * Created by yuranos on 9/21/17.
 */
interface BookingRepository extends CrudRepository<Booking, Long> {

    @Modifying(clearAutomatically = true)
    @Query('''update Booking b set b.passengerName = :#{#booking.passengerName}, b.destination = :#{#booking.destination},
            b.destination = :#{#booking.destination} where b.id = :#{#booking.id}''')
    int update(@Param("booking") Booking booking)
}
