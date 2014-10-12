package com.moonillusions.sulissrt

class EventList {

	def comparator = [ compare: {a,b -> a.elapsedSeconds < b.elapsedSeconds ? -1 : 1 }] as Comparator
	def events = new TreeSet(comparator)


	def add(event) {
		events.add(event)
	}
}
