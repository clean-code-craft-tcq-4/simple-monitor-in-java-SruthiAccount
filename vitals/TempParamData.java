package vitals;

public class TempParamData implements ParamDataInterface {
	float minValue = 0.0f;
	float maxValue = 45.0f;
	float thresholdPercent;
	boolean needWarning;

	@Override
	public void setData(float thresholdPercent, boolean needWarning) {
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
		// TODO Auto-generated method stub
		return needWarning;
	}

}
