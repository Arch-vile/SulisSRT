package com.moonillusions.sulissrt

import static org.hamcrest.Matchers.*
import static spock.util.matcher.HamcrestSupport.*
import spock.lang.Specification

class EventListTest extends Specification {

	def eventList

	def setup() {
		eventList = new EventList()
	}


	def "events ordered by elapsed time"() {

		expect: 'empty list'
		that eventList.events, empty()

		when:
		def middleEvent = new Event(type: "some type", elapsedSeconds: 10)
		def firstEvent = new Event(type: "some type2", elapsedSeconds: 5)
		def lastEvent = new Event(type: "some type3", elapsedSeconds: 20)
		eventList.add(middleEvent)
		eventList.add(firstEvent)
		eventList.add(lastEvent)

		then:
		that eventList.events, contains(
				firstEvent, middleEvent, lastEvent
				)
	}
}
