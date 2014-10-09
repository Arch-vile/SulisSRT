package com.moonillusions.sulissrt

import org.joda.time.LocalTime
import org.joda.time.Period
import org.joda.time.format.PeriodFormatterBuilder


class ElapsedTimer {

	LocalTime time

	ElapsedTimer() {
		time = new LocalTime(0,0,0)
	}

	def plusSeconds(int seconds) {
		time = time.plusSeconds(seconds)
		this
	}

	def plusMinutes(int minutes) {
		time = time.plusMinutes(minutes)
		this
	}

	def printTime() {
		def period = new Period(new LocalTime(0,0,0), time)
		def formatter = new PeriodFormatterBuilder()
				.printZeroAlways()
				.minimumPrintedDigits(2)
				.appendSeparator(":")
				.appendHours()
				.appendSeparator(":")
				.appendMinutes()
				.appendSeparator(":")
				.appendSeconds()
				.toFormatter()

		formatter.print(period)
	}
}
