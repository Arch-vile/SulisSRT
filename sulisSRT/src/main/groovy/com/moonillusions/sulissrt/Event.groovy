package com.moonillusions.sulissrt

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString


@EqualsAndHashCode(includeFields=true)
@ToString(includeNames=true)
class Event {

	def type
	def elapsedSeconds
}
