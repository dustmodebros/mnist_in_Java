package org.example;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
//		Start start = new Start(new double[]{-1.0f, 1.0f, 0.3f}, 10);
//		start.randomiseGenerate();
//		start.showContents();
//
//		Layer<?> layer1 = new Layer<>(0, start, start.numNodesOut, start.calculateOutputs(), 3);
//		layer1.randomiseGenerate();
//		layer1.showContents();
//		System.out.println("\n\n" + Arrays.toString(layer1.calculateOutputs()));
		//
		NeuralNet balls = new NeuralNet(3, new int[]{1, 1, 1, 1}, new double[]{0.5f, -0.6f, 0.9f});
		System.out.println(Arrays.toString(balls.calculateOutputs()));
	}
}