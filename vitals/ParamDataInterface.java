package vitals;

public interface ParamDataInterface {
	public void setData(float thresholdPercent, boolean needWarning);

	public float getMinValue();

	public float getMaxValue();

	public float getThreshold();

	public boolean getWarning();

}
