package org.example;

public class Node {
	double bias;
	int numOut;
	double[] forwardWeights;

	public Node(double bias, int numOut, double[] forwardWeights) {
		this.bias = bias;
		this.numOut = numOut;
		this.forwardWeights = forwardWeights;
	}
}
