package com.moonillusions.sulissrt

import spock.lang.Specification

class ElapsedTimerTest extends Specification {

	ElapsedTimer timer

	def setup() {
		timer = new ElapsedTimer()
	}

	def "jump to"() {
		when:
		timer.jumpTo(12,5)

		then:
		timer.elapsed == 12*60+5
	}

	def "elapsed time at start"() {

		when:
		def printed = timer.printTime()
		def elapsed = timer.elapsed

		then:
		printed == "00:00:00"

		and:
		elapsed == 0
	}

	def "elapsed time after few seconds"() {

		when: "Advance time by 7 seconds"
		timer.plusSeconds(7)
		def printed = timer.printTime()
		def elapsed = timer.elapsed

		then:
		printed == "00:00:07"

		and:
		elapsed == 7
	}

	def "print elapsed time after a while"() {

		when: "Advance time by 8 minutes and 12 seconds"
		timer.plusMinutes(8).plusSeconds(12)
		def printed = timer.printTime()
		def elapsed = timer.elapsed

		then:
		printed == "00:08:12"

		and:
		elapsed == 8*60+12
	}
}
