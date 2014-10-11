package com.moonillusions.sulissrt

import static org.hamcrest.Matchers.*
import static spock.util.matcher.HamcrestSupport.*
import spock.lang.Specification

class EventTrackerTest extends Specification {

	EventTracker tracker


	def setup() {
		tracker = new EventTracker()
	}

	def "adding events stores event types"() {
		expect: 'no events to start with'
		that tracker.events, empty()

		when: 'add first event'
		tracker.add("event type 1")

		then: 'event type is stored'
		that tracker.events, contains("event type 1")

		when: 'add second event'
		tracker.add("event type 2")

		then: 'both events types stored'
		that tracker.events, contains("event type 1", "event type 2")

		when: 're-add event with first event type'
		tracker.add("event type 1")

		then: 'no new event types stored'
		that tracker.events, contains("event type 1", "event type 2")
	}
}
