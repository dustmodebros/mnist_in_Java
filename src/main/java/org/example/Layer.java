package org.example;

import java.util.Scanner;

public class Layer <T> implements Bruh{
	Node[] nodes;
	T prev;
	int numNodesNext;
	int numNodesOf;
	int id;
	double[] weightedInput;
	public Layer(int id, T prev, int of, double[] weightedInput, int numNodesNext){
		this.numNodesNext = numNodesNext;
		this.prev = prev;
		this.numNodesOf = of;
		this.weightedInput = weightedInput;
		this.id = id;
	}

	@Override
	public void showContents(){
		if (prev instanceof Layer<?>){
			System.out.println("number of nodes in: " + ((Layer<?>) prev).numNodesOf + "\nnumber of nodes: " + numNodesOf);//+ "\nnumber of nodes out: " + next.numNodesOf);
			showWeights();
		} else if (prev instanceof Start){
			System.out.println("number of nodes in: " +  ((Start) prev).nodes.length + "\nnumber of nodes: " + numNodesOf);//+ "\nnumber of nodes out: " + next.numNodesOf);
			showWeights();
		}
	}

	private void showWeights() {
		for (int i=0; i<numNodesOf; i++) {
			System.out.println("Node number: " + i + "\nvalue: " + weightedInput[i] + "\nweights forward: ");
			for (int j = 0; j < numNodesNext; j++) {
				System.out.println("check");
				System.out.println(nodes[i].forwardWeights[j]);
			}
		}
	}

	public void randomiseGenerate(){
		Node[] the = new Node[numNodesOf];
		double[] fw = new double[numNodesNext];
		for (int i=0; i<numNodesOf; i++) {
			for (int j = 0; j < numNodesNext; j++) {
				fw[j] = -1 + 2*Math.random();
			}
			the[i] = new Node(-1 + 2*Math.random(), numNodesNext, fw);
		}
		nodes = the;
	}

	public void manualGenerate() {
		System.out.println("\n\nManually generating node weights for id " + id + '\n');
		Scanner input = new Scanner(System.in);
		Node[] nodeArray = new Node[numNodesOf];
		double[] fw = new double[numNodesNext];
		for (int i = 0; i < numNodesOf; i++) {
			for (int j = 0; j < numNodesNext; j++) {
				System.out.print("Weight from " + i + "to " + j + ": ");
				double weight = input.nextDouble();
				fw[j] = weight;
				System.out.print('\n');
			}
			System.out.print("bias for node " + i + ":");
			double bias = input.nextDouble();
			System.out.println('\n');
			nodeArray[i] = new Node(bias, numNodesNext, fw);
			System.out.println("added bias " + bias + " to node " + i + " in layer " + id);
		}
		nodes = nodeArray;
	}

	@Override
	public double[] calculateOutputs() {
		double[] out = new double[numNodesNext];
		for (int i = 0; i < numNodesNext; i++) {
			for (int j = 0; j < nodes.length; j++) {
				out[i] += weightedInput[j]*nodes[j].forwardWeights[i] + nodes[j].bias;
			}
		}
		return out;
	}

}
