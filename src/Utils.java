import java.util.Arrays;
import java.util.Objects;
import java.util.OptionalDouble;
import java.util.Scanner;

public class Utils {
	static Datapoint getNext (Scanner scanner){
		int label = Integer.parseInt(scanner.next());
		int[] out = new int[785];

		double[] ret = new double[784];
		for (int i = 0; i < 784; i++) {
			ret[i] = (double) Integer.parseInt(scanner.next())/255;
		}
		return new Datapoint(label, ret);
	}

	static void view(Datapoint curr){
		System.out.print("\n");
		System.out.print(curr.label);
		for (int i = 0; i < 28; i++) {
			System.out.print("\n");
			for (int j = 0; j < 28; j++) {
//				System.out.printf(" %s ", curr.values[(i*28+j)]==0?".":"B");
				System.out.printf(" %f ", curr.values[(i*28+j)]);
			}
		}
		System.out.print("\n");
	}

	static double calculateAverage(double[] in){
		int t = 0;
		double a = 0;
		for (double d : in) {
			if (d != 0){
				t++;
				a += d;
			}
		}
		return a/t;
	}
}
