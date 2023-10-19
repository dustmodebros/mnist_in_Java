package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.random.RandomGenerator;

public class Layer <T>{
	Node[] nodes;
	T prev;
	int numNodesNext;
	int numNodesOf;
	int id;
	float[] weightedInput;
	public Layer(int id, T prev, int of, float[] weightedInput, int numNodesNext){
		this.numNodesNext = numNodesNext;
		this.prev = prev;
		this.numNodesOf = of;
		this.weightedInput = weightedInput;
		this.id = id;
	}

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
		float[] fw = new float[numNodesNext];
		for (int i=0; i<numNodesOf; i++) {
			for (int j = 0; j < numNodesNext; j++) {
				fw[j] = (float)(-1 + 2*Math.random());
			}
			the[i] = new Node((float)(-1 + 2*Math.random()), numNodesNext, fw);
		}
		nodes = the;
	}

	public float[] calculateOutputs() {
		float[] out = new float[numNodesNext];
		for (int i = 0; i < numNodesNext; i++) {
			for (int j = 0; j < nodes.length; j++) {
				out[i] += weightedInput[j]*nodes[j].forwardWeights[i];
			}
		}
		return out;
	}

}
