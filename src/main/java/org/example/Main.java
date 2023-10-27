package org.example;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
//		Start start = new Start(new double[]{-1.0f, 1.0f, 0.3f}, 10);
//		start.randomiseGenerate();
//		start.showContents();

//		Layer<?> layer1 = new Layer<>(0, start, start.numNodesOut, start.calculateOutputs(), 3);
//		layer1.randomiseGenerate();
//		layer1.showContents();
//		System.out.println("\n\n" + Arrays.toString(layer1.calculateOutputs()));

		NeuralNet spugnosis = new NeuralNet(3, new int[]{1, 1, 1, 1}, new double[]{0.5f, -0.6f, 0.9f}, new double[][][]{{{1}, {1}, {1}}, {{1}}, {{1}}, {{1}}}, new double[][]{{0,0,0},{0},{0},{0}});
//		NeuralNet spugnosing = new NeuralNet(5, new int[]{30, 500, 20, 30, 500, 10}, new double[]{0.1d, -0.2d, 0.3d, -0.4d, 0.5d, -0.6d, 0.7d});
		System.out.println(Arrays.toString(spugnosis.calculateOutputs()));
	}
}