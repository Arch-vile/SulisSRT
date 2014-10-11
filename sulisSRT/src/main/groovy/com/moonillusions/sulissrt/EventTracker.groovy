package com.moonillusions.sulissrt

class EventTracker {

	def eventTypes = [] as Set
	def events = [] as Set

	def add(eventType) {
		eventTypes.add(eventType)
		events.add( new Event(type: eventType, elapsedSeconds: 0))
	}

	def getEvents() {
		return events
	}

	def getEventTypes() {
		eventTypes
	}
}
