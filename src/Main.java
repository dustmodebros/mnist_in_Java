import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.lang.Thread.sleep;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, InterruptedException {
		Scanner scanner = new Scanner(new File("mnist_test.csv"));
		scanner.useDelimiter("[,\n]");
		int width = 500;
		int height = 400;
		int imageSize = 784;
		Random r = new Random();
		JFrame frame = new JFrame("bazinga");

		NeuralNet net = new NeuralNet(imageSize, new int[]{30,10,2}, r.nextLong());
		frame.setSize(width,height);
		Drawer d = new Drawer (net);
		frame.getContentPane().add(d);
		frame.setVisible(true);
		Datapoint data;
//		net.newData(data);
//		d.paint(d.getGraphics());
//		net.train();
		Datapoint[] datas = new Datapoint[500];
		Datapoint[] datan = new Datapoint[5000];
		int sPoint = 0;
		int nPoint = 0;
		while (sPoint < 500) {
			data = Utils.getNext(scanner);
			if (data.label == 0){
				datas[sPoint] = data;
				sPoint++;
			} else {
				data.label = 1;
				datan[nPoint] = data;
				nPoint++;
			}
		}
		sPoint = 0;
		nPoint = 0;
		double averageCostS;
		double averageCostN;
		double[] averageTrackerS = new double[100];
		double[] averageTrackerN = new double[100];
		int placeS = 0;
		int placeN = 0;
		for (int i=0; i<2000; i++){ //loop
			if (placeS == 100){
				placeS = 0;
				placeN = 0;
			}
			if (sPoint == 500){
				sPoint = 0;
			}
			net.newData(datas[sPoint]);
			sPoint++;
			averageTrackerS[placeS] = net.train();
			placeS++;
			averageCostS = Utils.calculateAverage(averageTrackerS);
			d.paint(d.getGraphics());
			System.out.printf("Average cost of 0s: %f\n", averageCostS);
			net.newData(datan[nPoint]);
			nPoint++;
			averageTrackerN[placeN] = net.train();
			placeN++;
			averageCostN = Utils.calculateAverage(averageTrackerN);
			d.paint(d.getGraphics());
			System.out.printf("Average cost of non 0s: %f\n", averageCostN);
		}
		d.choice = 1;

		for (int i = 0; i < 100; i++) {
			Datapoint dp = Utils.getNext(scanner);
			if (dp.label == 7){
				dp.label = 0;
			} else {
				dp.label = 1;
			}
			net.newData(dp);
			Utils.view(dp);
			Node[] outNodes = net.layers[net.layers.length-1].getNodes();
			for (Node n : outNodes) {
				System.out.print(n.value);
			}
			d.paint(d.getGraphics());
			sleep(5000);
		}

	}


}