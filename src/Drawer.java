import java.awt.*;
import javax.swing.*;

import static java.lang.Math.floor;

public class Drawer extends JComponent {
	int nodeSize = 16;
	NeuralNet net;
	int choice;
	public Drawer(NeuralNet net){
		this.net = net;
		this.choice = 1;
	}


	public void paint(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		refresh(g2);
		if (net.data != null) {
			drawData(g2, 300, 150, 2, net.data);
		}
		drawNet(g2, 50, 50, net, choice);
	}

	private void refresh(Graphics2D g2){
		g2.setColor(new Color(255,255,255));
		g2.fillRect(0,0,getWidth(), getHeight());
		g2.setColor(new Color(0,0,0));
	}

	public void drawNode(Graphics2D g2, int x, int y, int size, Node node){
		//drawNode draws a node centered at x,y
		g2.setColor(new Color(0,0,0, (int) floor(node.value*255)));
		g2.fillOval(x-size/2, y-size/2, size, size);
//		g2.setColor(new Color(0));
//		g2.drawOval(x-size/2, y-size/2, size, size);
	}

	public void drawLayer(Graphics2D g2, int x, int y, Layer layer){
		int sNodeSize = nodeSize;
		if (layer.getClass() == InputLayer.class){
			sNodeSize = 4;
		}
		g2.setColor(new Color(0));
		int top = y;
		int bottom = getHeight()-top;
		Node[] nodes = layer.getNodes();
		g2.drawRect(x-15, y-15, 30, bottom-top+30);
		for (int i = 0; i < layer.numberOfNodes(); i++) {
			drawNode(g2,x,top+((bottom-top)*i/(nodes.length-1)),sNodeSize,nodes[i]);
		}

	}

	private void drawLayerWeights(Graphics2D g2, HiddenLayer layer, int x){
		int top = 50;
		int bottom = getHeight()-top;
		int j=0;
		g2.setStroke(new BasicStroke(1));
		for (double[] nodeWeights : layer.weights){
			for (int i=0; i< layer.numberOfNodes(); i++) {
				g2.setColor(colourmap(layer.weights[j][i]));
				g2.drawLine(50*(x+1),top+((bottom-top)*i/(layer.nodes.length-1)),50*x, top+((bottom-top)*j/(layer.prevLayer.getNodes().length-1)));
			}
			j++;
		}
		g2.setStroke(new BasicStroke(1));
	}

	public void drawAllWeights(Graphics2D g2){
		refresh(g2);
		int xpos = 50;
		Layer[] layers = net.layers;
		for (int i = 1; i < layers.length; i++) {
			Layer l = layers[i];
			drawLayerWeights(g2, (HiddenLayer) l, xpos);
			xpos += 50;
		}
	}

	public Color colourmap(double weight){
		if (weight > 0){
			return (new Color(255, 0, 0, (int) floor(weight*130)));
		}
		else {
			return (new Color(0, 0, 255, (int) floor(-weight*130)));
		}
	}

	public void drawNet(Graphics2D g2, int x, int spacing, NeuralNet net, int choice){
		if (choice == 1) {
			int target = 0;
			for (Layer l : net.layers) {
				if (target != 0) {
					drawLayerWeights(g2, (HiddenLayer) l, target);
				}
				drawLayer(g2, x, 50, l);
				x += spacing;
				target++;
			}
		} else {
			int target = 0;
			for (Layer l : net.layers) {
				if (target != 0) {
					drawLayerWeights(g2, (HiddenLayer) l, target);
				}
//				drawLayer(g2, x, 50, l);
				x += spacing;
				target++;
			}		}
	}

	public void drawData(Graphics2D g2, int x, int y, int spacing, Datapoint data){
		int drawX = x;
		int drawY = y;
		for (int i = 0; i < 28; i++) {
			for (int j = 0; j < 28; j++) {
				g2.setColor(new Color((int) (255 * data.values[(i*28+j)]),(int) (255 * data.values[(i*28+j)]),(int) (255 * data.values[(i*28+j)]), 255));
				g2.fillRect(drawX, drawY, 2, 2);
				drawX += spacing;
			}
			drawY += spacing;
			drawX = x;
		}
		System.out.print("\n");
	}

}