package com.moonillusions.sulissrt

class EventTracker {

	def timer = new ElapsedTimer()
	def eventTypes = [] as Set
	def events = new EventList()

	def add(eventType) {
		eventTypes.add(eventType)
		events.add( new Event(type: eventType, elapsedSeconds: timer.elapsed))
	}

	def getEvents() {
		return events.events
	}

	def getEventTypes() {
		eventTypes
	}

	def getEventsAfter() {
		events.events.findAll { it.elapsedSeconds >= timer.elapsed }
	}

	def getEventsBefore() {
		events.events.findAll { it.elapsedSeconds < timer.elapsed }
	}
}
