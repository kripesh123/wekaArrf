package wekaArffTest;

import weka.classifiers.functions.Logistic;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class WekaLogisticsRegressionTest {

	Instances iris = null;
	Logistic logReg;

	public void loadArff(String arffInput) {
		DataSource source = null;

		try {
			source = new DataSource(arffInput);
			iris = source.getDataSet();
			iris.setClassIndex(iris.numAttributes() - 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void buildRegression() {
		logReg = new Logistic();
		
		try {
			logReg.buildClassifier(iris);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(logReg);
	}
	
	public static void main(String[] args) {
		WekaLogisticsRegressionTest test = new WekaLogisticsRegressionTest();
		test.loadArff("C:/Program Files/Weka-3-8/data/iris.arff");
		test.buildRegression();
	}

}
