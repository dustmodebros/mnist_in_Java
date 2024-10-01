public class Node {
	double value;
	double bias;
	public Node(double value, double bias){
		this.value = value;
		this.bias = bias;
	}
	public double activation(double in){
		return 1/(1+Math.exp(-in));
	}

	public double nodeCost(double expected){
		return Math.pow(expected-value,2);
	}
}
