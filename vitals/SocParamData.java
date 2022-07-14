package vitals;

public class SocParamData implements ParamDataInterface {
	float minValue = 20.0f;
	float maxValue = 80.0f;
	float thresholdPercent;
	boolean needWarning;

	@Override
	public void setData(float thresholdPercent, boolean needWarning) {
		this.thresholdPercent = thresholdPercent;
		this.needWarning = needWarning;

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

	@Override
	public boolean getWarning() {
		return needWarning;
	}

}
