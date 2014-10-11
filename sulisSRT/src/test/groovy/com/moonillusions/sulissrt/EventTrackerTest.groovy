package com.moonillusions.sulissrt

import static org.hamcrest.Matchers.*
import static spock.util.matcher.HamcrestSupport.*
import spock.lang.Specification

class EventTrackerTest extends Specification {

	EventTracker tracker


	def setup() {
		tracker = new EventTracker()
	}


	def "foo"() {

		expect:
		1 == 1
	}


	//	def "adding event"() {
	//
	//		when:
	//		tracker.add("some event")
	//
	//		then:
	//		that tracker.events contains "some event"
	//	}
}
