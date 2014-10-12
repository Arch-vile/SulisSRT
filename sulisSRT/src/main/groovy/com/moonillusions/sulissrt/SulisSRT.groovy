package com.moonillusions.sulissrt

class SulisSRT {

	def input = new InputProvider()
	def outputProvider = new OutputProvider()
	def output = new OutputPrinter()

	SulisSRT() {
	}


	def run() {

		output.printOutput(outputProvider.getOutput())

		while(true) {
			output.printOutput(outputProvider.getOutput(input.getInput()))
		}
	}

	static void main(args) {

		def main = new SulisSRT()
		main.run()
	}
}
