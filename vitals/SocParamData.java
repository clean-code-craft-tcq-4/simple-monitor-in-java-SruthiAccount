package vitals;

public class SocParamData implements ParamDataInterface {
	float minValue;
	float maxValue;
	float thresholdPercent;
	boolean needWarning;

	@Override
	public void setData(float minValue, float maxValue, float thresholdPercent, boolean needWarning) {
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.thresholdPercent = thresholdPercent;
		this.needWarning = needWarning;

	}

	@Override
	public float getValue(String valueName) {
		if (valueName.contentEquals("minValue"))
			return minValue;
		else if (valueName.contentEquals("maxValue"))
			return maxValue;
		else if (valueName.contentEquals("thresholdPercent"))
			return thresholdPercent;
		return 0.0f;
	}

	@Override
	public boolean getWarning() {
		return needWarning;
	}

}
