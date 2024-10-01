
public abstract class Layer {
	//A layer:
	//	calculates the values that its nodes should take using
	//	the previous layer's values and weights
	public abstract void calculateValues();

	public abstract int numberOfNodes();
	//A hidden layer has:
	//	a reference to the previous layer

	public abstract Node[] getNodes();
	//returns the array of nodes in the current layer

	public abstract void updateInputs(Datapoint data);

	public abstract void applyGradients(long trainingSpeed);
}
