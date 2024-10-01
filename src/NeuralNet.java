import java.util.Random;

public class NeuralNet {
	Layer[] layers;
	Datapoint data;
	double[] expected = new double[]{0,0,0,0,0,0,0,0,0,0};

	public NeuralNet(int inputLength, int[] hiddenLayerSizes, long seed){
		Random r = new Random(seed);
		this.layers = new Layer[hiddenLayerSizes.length+1];
		this.layers[0] = new InputLayer(inputLength);
		for (int i = 0; i < hiddenLayerSizes.length; i++) {
			this.layers[i+1] = new HiddenLayer(this, this.layers[i],hiddenLayerSizes[i], r.nextLong());
			//iterate through hiddenLayerSizes, and create as many hidden layers as necessary
			//with the corresponding size.
		}
	}

	public double calculateCost(){
		updateNet();
		double cost = 0;
		int target = 0;
		Node[] lastLayerNodes = layers[layers.length-1].getNodes();
		for (Node n : lastLayerNodes) {
			cost += n.nodeCost(expected[target]);
			target++;
		}
		return cost;
	}

	public void newData(Datapoint data){
		this.data = data;
		expected = new double[]{0,0};
		expected[data.label] = 1;
		for (Layer layer : layers) {
			layer.updateInputs(data);
		}
	}

	public double train(){
		double bCost = calculateCost();
		System.out.printf("Cost before: %f", bCost);
		for (int i = 1; i < layers.length; i++) {
			layers[i].applyGradients((10000000000L));
		}
		System.out.printf("Cost after: %f", calculateCost());
		return bCost;
	}

	public void updateNet(){
		for (Layer layer : layers) {
			layer.calculateValues();
		}
	}
}
