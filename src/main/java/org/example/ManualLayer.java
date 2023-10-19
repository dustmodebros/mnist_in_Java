package org.example;

public class ManualLayer extends Layer{
	float[][] weights;
	public ManualLayer(int id, Object prev, int of, float[] weightedInput, int numNodesNext, float[][] weights) {
		super(id, prev, of, weightedInput, numNodesNext);
		this.weights = weights;
	}

}
