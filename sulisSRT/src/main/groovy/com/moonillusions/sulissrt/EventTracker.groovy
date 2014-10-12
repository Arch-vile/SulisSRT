package com.moonillusions.sulissrt

class EventTracker {

	def timer = new ElapsedTimer()
	def eventTypes = [] as Set
	def events = [] as Set

	def add(eventType) {
		eventTypes.add(eventType)
		events.add( new Event(type: eventType, elapsedSeconds: timer.elapsed))
	}

	def getEvents() {
		return events
	}

	def getEventTypes() {
		eventTypes
	}
}
