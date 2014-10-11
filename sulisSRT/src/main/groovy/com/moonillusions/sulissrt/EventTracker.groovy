package com.moonillusions.sulissrt

class EventTracker {

	def eventTypes = [] as Set

	def add(event) {
		eventTypes.add(event)
	}

	def getEventTypes() {
		eventTypes
	}
}
