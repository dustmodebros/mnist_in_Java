import java.util.Arrays;

public class InputLayer extends Layer{
	Node[] nodes;
	Datapoint data;

	public InputLayer(int inputLength){
		nodes = new Node[inputLength];
		for (int i = 0; i < inputLength; i++) {
			nodes[i] = new Node(0, 0);
		}
	}

	@Override
	public void calculateValues() {
		//just take in the inputs and put it in the nodes
		for (int i = 0; i < data.values.length; i++) {
			nodes[i] = new Node(data.values[i], 0);
		}
	}

	@Override
	public int numberOfNodes() {
		return nodes.length;
	}

	@Override
	public Node[] getNodes() {
		return nodes;
	}

	public void updateInputs(Datapoint data){
		this.data = data;
		calculateValues();
	}

	@Override
	public void applyGradients(long trainingSpeed) {
	}


}
