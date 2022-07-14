package vitals;

public class ChargeRateParamData implements ParamDataInterface {
	float minValue = 0.0f;
	float maxValue = 0.8f;
	float thresholdPercent;
	boolean needWarning;

	@Override
	public void setData(float thresholdPercent, boolean needWarning) {
		this.thresholdPercent = thresholdPercent;
		this.needWarning = needWarning;

	}

	@Override
	public boolean getWarning() {
		// TODO Auto-generated method stub
		return needWarning;
	}

	@Override
	public float getMinValue() {
		// TODO Auto-generated method stub
		return minValue;
	}

	@Override
	public float getMaxValue() {
		// TODO Auto-generated method stub
		return maxValue;
	}

	@Override
	public float getThreshold() {
		// TODO Auto-generated method stub
		return thresholdPercent;
	}
}
