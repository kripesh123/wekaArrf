package wekaArffTest;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instances;

public class WekaArffTest {

	public static void main(String[] args) throws Exception {
		ArrayList<Attribute> attributes;
		ArrayList<String> classVals;
		Instances data;
		double[] values;

		attributes = new ArrayList<>();
		attributes.add(new Attribute("age"));

		ArrayList<String> empty = null;
		attributes.add(new Attribute("name", empty));

		attributes.add(new Attribute("dob", "yyyy-mm-dd"));
		classVals = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			classVals.add("Class" + (i + 1));
		}

		Attribute classVal = new Attribute("class", classVals);
		attributes.add(classVal);

		data = new Instances("MyRelation", attributes, 0);

		values = new double[data.numAttributes()];
		values[0] = 35;
		values[1] = data.attribute(1).addStringValue("Kripesh Bista");
		values[2] = data.attribute(2).parseDate("1992-11-13");
		values[3] = classVals.indexOf("Class1");

		data.add(new DenseInstance(1.0, values));

		BufferedWriter writer = new BufferedWriter(new FileWriter("E:/learn/pro/wekaArffTest/test.arff"));
		writer.write(data.toString());
		writer.close();

		System.out.println(data);
	}

}
