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


	def jumpTo(minutes, seconds) {
		time = new LocalTime(0,minutes,seconds)
	}

	def getElapsed() {
		def period = elapsedPeriod()
		period.toStandardSeconds().seconds
	}

	def printTime() {
		def period = elapsedPeriod()
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

	private Period elapsedPeriod() {
		def period = new Period(new LocalTime(0,0,0), time)
		return period
	}
}
