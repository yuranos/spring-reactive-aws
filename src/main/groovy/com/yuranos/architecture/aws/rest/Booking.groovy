package com.yuranos.architecture.aws.rest

import groovy.transform.TupleConstructor

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

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
    Date departureDate
}
