package com.yuranos.architecture.aws.relational

import com.yuranos.architecture.aws.rest.Booking
import org.springframework.data.repository.CrudRepository

/**
 * Created by yuranos on 9/21/17.
 */
interface BookingRepository extends CrudRepository<Booking, Long> {

}
