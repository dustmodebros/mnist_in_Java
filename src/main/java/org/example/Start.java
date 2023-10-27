package org.example;

import java.util.Scanner;

public class Start {

	double[] inputs;
	Node[] nodes;
	int numNodesOut;

	public Start(double[] inputs, int numNodesOut) {
		this.inputs = inputs;
		this.numNodesOut = numNodesOut;
	}

	public Start(double[] inputs, int numNodesOut, double[][] manualWeightsArray, double[] manualBiasArray) {
		this.inputs = inputs;
		this.numNodesOut = numNodesOut;
		Node[] nodeArray = new Node[inputs.length];
		for (int i = 0; i < inputs.length; i++) {
			nodeArray[i] = new Node(manualBiasArray[i], numNodesOut, manualWeightsArray[i]);
		}
		nodes = nodeArray;
	}

	public void randomiseGenerate(){
		Node[] the = new Node[inputs.length];
		for (int i=0; i<inputs.length; i++) {
			double[] fw = new double[numNodesOut];
			for (int j = 0; j < numNodesOut; j++) {
				fw[j] = -1 + 2*Math.random();
			}
			the[i] = new Node(-1 + 2*Math.random(), numNodesOut, fw);
		}
		this.nodes = the;
	}

	public void manualGenerate() {
		System.out.println("\n\nManually generating node weights for Start");
		Scanner input = new Scanner(System.in);
		Node[] nodeArray = new Node[inputs.length];
		double[] fw = new double[numNodesOut];
		for (int i = 0; i < inputs.length; i++) {
			for (int j = 0; j < numNodesOut; j++) {
				System.out.print("Weight from " + i + "to " + j + ": ");
				double weight = input.nextDouble();
				fw[j] = weight;
				System.out.print('\n');
			}
			System.out.print("bias for node " + i + ":");
			double bias = input.nextDouble();
			System.out.println('\n');
			nodeArray[i] = new Node(bias, numNodesOut, fw);
			System.out.println("added bias " + bias + " to node " + i + " in layer Start");

		}
		nodes = nodeArray;
		for (Node node :
				nodes) {
			System.out.println("bias is: " + node.bias);
		}
	}

	public void showContents(){
		System.out.println("number of nodes in: 0, as start" + "\nnumber of nodes: " + inputs.length + "\n\nvalues:");

		for (int i=0; i< nodes.length; i++) {
			System.out.println("Node number: " + i + "\nvalue: " + inputs[i] + "\nweights forward: ");
			for (int j = 0; j < numNodesOut; j++) {
				System.out.println(nodes[i].forwardWeights[j]);
			}
		}
	}
	
	public double[] calculateOutputs() {
		double[] out = new double[numNodesOut];
		for (int i = 0; i < numNodesOut; i++) {
			for (int j = 0; j < nodes.length; j++) {
				out[i] += inputs[j]*nodes[j].forwardWeights[i] + nodes[j].bias;
			}
		}
		return out;
	}
}
