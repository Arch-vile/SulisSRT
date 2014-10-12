package com.moonillusions.sulissrt

import static org.hamcrest.Matchers.*
import static spock.util.matcher.HamcrestSupport.*
import spock.lang.Specification

class EventTrackerTest extends Specification {


	EventTracker emptyTracker
	EventTracker populatedTracker


	def setup() {
		emptyTracker = new EventTracker()
		populatedTracker = new EventTracker()

		populatedTracker.add("event on 00:00")

		populatedTracker.timer.plusSeconds(5)
		populatedTracker.add("event on 00:05")

		populatedTracker.timer.plusSeconds(20)
		populatedTracker.add("event on 00:25")

		populatedTracker.timer.plusMinutes(1)
		populatedTracker.add("event on 01:25")
	}

	def "get events after"() {

		when: 'Jump to 00:06'
		populatedTracker.timer.jumpTo(0,6)
		def events = populatedTracker.eventsAfter

		then:
		that events, contains(
				new Event(type: "event on 00:25", elapsedSeconds: 25),
				new Event(type: "event on 01:25", elapsedSeconds: 85))
	}

	def "get events after is inclusive"() {
		when: 'Jump to 00:05'
		populatedTracker.timer.jumpTo(0,5)
		def events = populatedTracker.eventsAfter

		then:
		that events, contains(
				new Event(type: "event on 00:05", elapsedSeconds: 5),
				new Event(type: "event on 00:25", elapsedSeconds: 25),
				new Event(type: "event on 01:25", elapsedSeconds: 85))
	}

	def "get events before"() {

		when: 'Jump to 00:05'
		populatedTracker.timer.jumpTo(0,5)
		def events = populatedTracker.eventsBefore

		then:
		that events, contains(
				new Event(type: "event on 00:00", elapsedSeconds: 0))
	}

	def "adding events"() {

		expect: 'no events to start with'
		that emptyTracker.events, empty()

		when: 'add first event'
		emptyTracker.add("some event")

		then: 'event with correct time is added'
		that emptyTracker.events, contains(new Event(type: "some event",elapsedSeconds: 0))

		when: 'advance elapsed time with 5 seconds'
		emptyTracker.timer.plusSeconds(5)
		emptyTracker.add("other event")

		then: 'second event added'
		that emptyTracker.events, contains(
				new Event(type: "some event",elapsedSeconds: 0),
				new Event(type: "other event",elapsedSeconds: 5))
	}

	def "adding events stores event types"() {
		expect: 'no event types to start with'
		that emptyTracker.eventTypes, empty()

		when: 'add first event'
		emptyTracker.add("event type 1")

		then: 'event type is stored'
		that emptyTracker.eventTypes, contains("event type 1")

		when: 'add second event'
		emptyTracker.add("event type 2")

		then: 'both events types stored'
		that emptyTracker.eventTypes, contains("event type 1", "event type 2")

		when: 're-add event with first event type'
		emptyTracker.add("event type 1")

		then: 'no new event types stored'
		that emptyTracker.eventTypes, contains("event type 1", "event type 2")
	}
}
