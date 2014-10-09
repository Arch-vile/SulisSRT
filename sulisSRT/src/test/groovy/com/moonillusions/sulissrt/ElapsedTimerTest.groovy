package com.moonillusions.sulissrt

import spock.lang.Specification

class ElapsedTimerTest extends Specification {

	ElapsedTimer timer

	def setup() {
		timer = new ElapsedTimer()
	}

	def "starts with zero elapsed time"() {

		when:
		def elapsed = timer.printTime()

		then:
		elapsed == "00:00:00"
	}

	def "elapsed time after few seconds"() {

		when: "Advance time by 7 seconds"
		timer.plusSeconds(7)
		def elapsed = timer.printTime()

		then:
		elapsed == "00:00:07"
	}

	def "elapsed time after a while"() {

		when: "Advance time by 8 minutes and 12 seconds"
		timer.plusMinutes(8).plusSeconds(12)
		def elapsed = timer.printTime()

		then:
		elapsed == "00:08:12"
	}
}
