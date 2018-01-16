package wekaArffTest;

import weka.classifiers.meta.FilteredClassifier;
import weka.classifiers.trees.RandomForest;
import weka.core.Attribute;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.unsupervised.attribute.Remove;

public class WekaFilteredClassifierTest {

	Instances weather = null;
	RandomForest rf;
	
	public void loadArff(String arffInput) {
		DataSource source = null;
		
		try {
			source = new DataSource(arffInput);
			weather = source.getDataSet();
			weather.setClassIndex(weather.numAttributes() - 1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void buildFilteredClassifier() {
		rf = new RandomForest();
		Remove rm = new Remove();
		rm.setAttributeIndices("1");
		FilteredClassifier fc = new FilteredClassifier();
		fc.setFilter(rm);
		fc.setClassifier(rf);
		
		try {
			fc.buildClassifier(weather);
			for(int i = 0; i<weather.numAttributes();i++) {
				double pred = fc.classifyInstance(weather.instance(i));
				System.out.println("Given Value: " + weather.classAttribute().value(i));
//				System.out.println("--Pred Value: " + weather.classAttribute().value(1));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		WekaFilteredClassifierTest test = new WekaFilteredClassifierTest();
		test.loadArff("C:/Program Files/Weka-3-8/data/weather.nominal.arff");
		test.buildFilteredClassifier();

	}

}
