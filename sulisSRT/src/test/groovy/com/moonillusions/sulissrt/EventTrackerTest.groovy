package com.moonillusions.sulissrt

import static org.hamcrest.Matchers.*
import static spock.util.matcher.HamcrestSupport.*
import spock.lang.Specification

class EventTrackerTest extends Specification {

	EventTracker tracker


	def setup() {
		tracker = new EventTracker()
	}

	def "adding events2"() {

		expect: 'no events to start with'
		that tracker.events, empty()

		when: 'add first event'
		tracker.add("some event")

		then: 'event with correct time is added'
		that tracker.events, contains(new Event(type: "some event",elapsedSeconds: 0))

		when: 'advance elapsed time with 5 seconds'
		tracker.timer.plusSeconds(5)
		tracker.add("other event")

		then: 'second event added'
		that tracker.events, contains(
				new Event(type: "some event",elapsedSeconds: 0),
				new Event(type: "other event",elapsedSeconds: 5))
	}

	def "adding events stores event types"() {
		expect: 'no event types to start with'
		that tracker.eventTypes, empty()

		when: 'add first event'
		tracker.add("event type 1")

		then: 'event type is stored'
		that tracker.eventTypes, contains("event type 1")

		when: 'add second event'
		tracker.add("event type 2")

		then: 'both events types stored'
		that tracker.eventTypes, contains("event type 1", "event type 2")

		when: 're-add event with first event type'
		tracker.add("event type 1")

		then: 'no new event types stored'
		that tracker.eventTypes, contains("event type 1", "event type 2")
	}
}
