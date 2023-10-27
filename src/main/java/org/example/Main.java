package org.example;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
//		NeuralNet spugnosis = new NeuralNet(3, new int[]{2, 1, 1, 1}, new double[]{0.5f, -0.6f, 0.9f},
//				new double[][][]{{{1, 1}, {1, 1}, {1, 1}}
//								 , {{0.5}, {0.5}}
//									, {{1}}
//									, {{1}}
//				}, new double[][]{
//						{0,0,0}
//						,{0,0}
//						 ,{0}
//						 ,{0}
//		});
		NeuralNet spugnosing = new NeuralNet(5, new int[]{30, 500, 20, 30, 500, 10}, new double[]{0.1d, -0.2d, 0.3d, -0.4d, 0.5d, -0.6d, 0.7d});
		System.out.println(Arrays.toString(spugnosing.calculateOutputs()));
	}
}