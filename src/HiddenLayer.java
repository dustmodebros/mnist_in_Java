import java.util.Arrays;
import java.util.Random;

public class HiddenLayer extends Layer{
	Layer prevLayer;
	Node[] nodes;
	double[][] weights;
	long seed;
	NeuralNet costReference;

	public HiddenLayer(NeuralNet costReference, Layer prevLayer, int numberOfNodes, long randomSeed){
		this.seed = randomSeed;
		this.costReference = costReference;
		this.weights = new double[prevLayer.numberOfNodes()][numberOfNodes];
		this.nodes = new Node[numberOfNodes];
		generateWeights();
		for (int i = 0; i < numberOfNodes; i++) {
			this.nodes[i] = new Node(0d, 0);
		}
		this.prevLayer = prevLayer;
	}

	public double[][] calculateWeightGradients(double smallValue){
		double[][] out = new double[prevLayer.numberOfNodes()][numberOfNodes()];
		double prevCost = costReference.calculateCost();
		for (int theirNode = 0; theirNode < prevLayer.numberOfNodes(); theirNode++) {
			for (int ourNode = 0; ourNode < numberOfNodes(); ourNode++) {
				weights[theirNode][ourNode] += smallValue;
				out[theirNode][ourNode] = -(costReference.calculateCost()-prevCost)*smallValue;
				weights[theirNode][ourNode] -= smallValue;
			}
		}
//		System.out.println(Arrays.deepToString(out));
		return out;
	}

	public double[] calculateBiasGradients(double smallValue){
		double[] out = new double[numberOfNodes()];
		double prevCost = costReference.calculateCost();
		for (int ourNode = 0; ourNode < numberOfNodes(); ourNode++) {
			nodes[ourNode].bias += smallValue;
			out[ourNode] = -(costReference.calculateCost()-prevCost)*smallValue;
			nodes[ourNode].bias -= smallValue;
		}
		return out;
	}

	public void applyGradients(long trainingSpeed){
		double h = 0.000001;
		double[][] wGs = calculateWeightGradients(h);
		double[] bGs = calculateBiasGradients(h);
		for (int ourNode = 0; ourNode < numberOfNodes(); ourNode++) {
			for (int theirNode = 0; theirNode < prevLayer.numberOfNodes(); theirNode++) {
				weights[theirNode][ourNode] += wGs[theirNode][ourNode] * trainingSpeed;
			}
			nodes[ourNode].bias += bGs[ourNode] * trainingSpeed;
		}
	}

	public void generateWeights(){
		Random r = new Random(seed);
		for (double[] arr : weights) {
			for (int i = 0; i < numberOfNodes(); i++) {
				arr[i] = (r.nextDouble()-0.5)*2;
			}
		}
	}

	@Override
	public void calculateValues() {
		Node[] prevNodes = prevLayer.getNodes();
		for (Node n :
				nodes) {
			n.value = 0;
		}
		for (int theirNode = 0; theirNode < prevLayer.numberOfNodes(); theirNode++) {
			for (int ourNode = 0; ourNode < numberOfNodes(); ourNode++){
				nodes[ourNode].value += prevNodes[theirNode].value*weights[theirNode][ourNode];
			}
		}
		for (Node node : nodes) {
			node.value += node.bias;
			node.value = node.activation(node.value);
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

	@Override
	public void updateInputs(Datapoint data) {
		calculateValues();
	}
}
