package org.example;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Start start = new Start(new float[]{-1.0f, 1.0f}, 1);
		start.randomiseGenerate();
		start.showContents();

		Layer<?> layer1 = new Layer<>(0, start, start.numNodesOut, start.calculateOutputs(), 1);
		layer1.randomiseGenerate();
		layer1.showContents();
		System.out.println("\n\n" + Arrays.toString(layer1.calculateOutputs()));
	}
}