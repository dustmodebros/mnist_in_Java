package org.example;

public class NeuralNet {

	public Layer<?>[] layers;
	public double[] inputs;

	public NeuralNet(int size, int[] layerSizes, double[] inputs){
		this.layers = new Layer<?>[size];
		this.inputs = inputs;
		Start start = new Start(inputs, layerSizes[0]);
		start.manualGenerate();
//		start.randomiseGenerate();
		layers[0] = new Layer<>(0, start, layerSizes[0], start.calculateOutputs(), layerSizes[1]);
		layers[0].manualGenerate();
//		layers[0].randomiseGenerate();
		for (int i = 1; i < size; i++) {
			layers[i] = new Layer<>(i, layers[i-1], layerSizes[i], layers[i-1].calculateOutputs(), layerSizes[i+1]);
			layers[i].manualGenerate();
//			layers[i].randomiseGenerate();
		}

	}

	public double[] calculateOutputs() {
		return layers[layers.length-1].calculateOutputs();
	}
}
