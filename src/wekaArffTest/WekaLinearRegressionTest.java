package wekaArffTest;

import weka.classifiers.functions.LinearRegression;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class WekaLinearRegressionTest {
	
	Instances cpu = null;
	LinearRegression lReg;
	
	public void loadArff(String arffInput) {
		DataSource source = null;
		
		try {
			source = new DataSource(arffInput);
			cpu = source.getDataSet();
			cpu.setClassIndex(cpu.numAttributes() - 1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void buildRegression() {
		lReg = new LinearRegression();
		
		try {
			lReg.buildClassifier(cpu);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(lReg);
	}
	
	public static void main(String[] args) {
		WekaLinearRegressionTest test = new WekaLinearRegressionTest();
		test.loadArff("C:/Program Files/Weka-3-8/data/cpu.arff");
		test.buildRegression();
	}

}
