package com.moonillusions.sulissrt

class EventTracker {

	def events = [] as Set

	def add(event) {
		events.add(event)
	}

	def getEvents() {
		events
	}
}
