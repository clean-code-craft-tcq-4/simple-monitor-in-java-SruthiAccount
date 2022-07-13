package vitals;

public interface ParamDataInterface {
	public void setData( float thresholdPercent, boolean needWarning);

	public float getValue(String valueName);

	public boolean getWarning();

}
