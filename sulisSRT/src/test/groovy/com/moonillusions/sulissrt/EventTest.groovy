package com.moonillusions.sulissrt

import spock.lang.Specification

class EventTest extends Specification {

	def "implements equals"() {

		when: 'two events with equal fields'
		def event1 = new Event(type: "some event type", elapsedSeconds: 10)
		def event2 = new Event(type: "some event type", elapsedSeconds: 10)

		then: 'events are equal'
		event1 == event2
	}
}
