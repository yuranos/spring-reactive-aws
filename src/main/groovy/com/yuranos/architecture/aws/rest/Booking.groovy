package com.yuranos.architecture.aws.rest

import groovy.transform.TupleConstructor
import org.springframework.format.annotation.DateTimeFormat

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import java.time.ZonedDateTime
/**
 * Created by yuranos on 9/21/17.
 */
@TupleConstructor
@Entity
class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id
    String passengerName, destination

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private ZonedDateTime departureDate;
}
//    @JsonFormat(pattern="yyyy")
//    @JsonDeserialize(using = LocalDateDeserializer.class)
//    @JsonSerialize(using = LocalDateSerializer.class)
//    private ZonedDateTime departureDate
