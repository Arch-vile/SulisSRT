package com.moonillusions.sulissrt

import groovy.transform.EqualsAndHashCode


@EqualsAndHashCode(includeFields=true)
class Event {

	def type
	def elapsedSeconds
}
