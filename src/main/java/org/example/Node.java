package org.example;

public class Node {
	float bias;
	float activation;
	int numOut;
	float[] forwardWeights;

	public Node(float bias, int numOut, float[] forwardWeights) {
		this.bias = bias;
		this.numOut = numOut;
		this.forwardWeights = forwardWeights;
	}

	public float calcActivation(float weightedInput){
		activation = bias+weightedInput;
		return activation;
	}


}
