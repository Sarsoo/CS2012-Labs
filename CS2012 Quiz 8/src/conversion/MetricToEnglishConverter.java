package conversion;

public class MetricToEnglishConverter implements ScaleConverter{

	@Override
	public double convertTemperature(double tempIn) {
		return (tempIn * 9/5) + 32;
	}

	@Override
	public double convertDistance(double distanceIn) {
		return distanceIn / 1.609;
	}

	@Override
	public double convertWeight(double weightIn) {
		return weightIn * 2.2;
	}

}
