package vitals;

public interface ParamDataInterface {
	public void setData(float minValue, float maxValue, float thresholdPercent, boolean needWarning);

	public float getValue(String valueName);

	public boolean getWarning();

}
