package org.example;

public class Start {

	float[] inputs;
	Node[] nodes;
	int numNodesOut;

	public Start(float[] inputs, int numNodesOut) {
		this.inputs = inputs;
		this.numNodesOut = numNodesOut;
	}

	public void randomiseGenerate(){
		Node[] the = new Node[inputs.length];
		for (int i=0; i<inputs.length; i++) {
			float[] fw = new float[numNodesOut];
			for (int j = 0; j < numNodesOut; j++) {
				fw[j] = (float)(-1 + 2*Math.random());
			}
			the[i] = new Node((float)(-1 + 2*Math.random()), numNodesOut, fw);
		}
		this.nodes = the;
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
	
	public float[] calculateOutputs() {
		float[] out = new float[numNodesOut];
		for (int i = 0; i < numNodesOut; i++) {
			for (int j = 0; j < nodes.length; j++) {
				out[i] += inputs[j]*nodes[j].forwardWeights[i];
			}
		}
		return out;
	}
}
