package com.moonillusions.sulissrt

import spock.lang.Specification

class OutputProviderTest extends Specification {

	def provider

	def setup() {
		provider = new OutputProvider()
	}

	def "default ouput"() {

		expect:
		provider.output == "hello there"
	}


	def "output response"() {

		expect:
		provider.getOutput("foo") == "hello there 2"
	}
}
