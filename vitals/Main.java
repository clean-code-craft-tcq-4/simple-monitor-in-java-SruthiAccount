package vitals;

public class Main {
	static public enum Languages {

		ENGLISH(0), GERMAN(1);
		private int index;

		private Languages(int index) {
			this.index = index;
		}

		public int getIndex() {
			return index;
		}

	}

	static int langIndex;

	static boolean batteryIsOk(float temperature, float soc, float chargeRate, boolean needTempWarning,
			boolean needSocWarning, boolean needChargerateWarning) {
		TempParamData tempParam = new TempParamData();
		tempParam.setData(5.0f, needTempWarning);
		SocParamData socParam = new SocParamData();
		socParam.setData(5.0f, needSocWarning);
		ChargeRateParamData crParam = new ChargeRateParamData();
		crParam.setData(5.0f, needChargerateWarning);
		Boolean tempCheckParam = checkParam("Temperature", temperature, tempParam);
		Boolean socCheckParam = checkParam("State of Charge", soc, socParam);
		Boolean chargeRateCheckParam = checkParam("Charge Rate", chargeRate, crParam);
		return tempCheckParam && socCheckParam && chargeRateCheckParam;
	}

	static boolean checkParam(String param, float input, ParamDataInterface data) {
		float minValue = data.getMinValue();
		float maxValue = data.getMaxValue();
		float thresholdPercent = data.getThreshold();
		float thresholdValue = thresholdPercent * maxValue / 100;
		String printContent = GetContentInLang.getParamInLang(param);
		boolean checkValue = input < minValue || input > maxValue;
		if (checkValue && data.getWarning()) {
			validateBreach(input, minValue, thresholdValue, maxValue, param);
			return false;
		} else if (checkValue) {
			printContent = printContent.concat(GetContentInLang.getOutOfRangeInLang());
			System.out.println(printContent);
			return false;
		} else {
			if (data.getWarning()) {
				validateWarning(input, minValue, thresholdValue, maxValue, param);
			} else
				printContent = printContent.concat(GetContentInLang.getInRangeInLang());

			return true;
		}
	}

	public static void validateBreach(float input, float minValue, float thresholdValue, float maxValue, String param) {
		String printContent = GetContentInLang.getParamInLang(param);
		if (input > minValue - thresholdValue && input < minValue) {
			printContent = printContent.concat(GetContentInLang.getLowBreachInLang());
		} else if (input < maxValue + thresholdValue && input > maxValue) {
			printContent = printContent.concat(GetContentInLang.getHighBreachInLang());
		} else {
			printContent = printContent.concat(GetContentInLang.getOutOfRangeInLang());
		}
		System.out.println(printContent);
	}

	public static void validateWarning(float input, float minValue, float thresholdValue, float maxValue,
			String param) {
		String printContent = GetContentInLang.getParamInLang(param);
		if (input < minValue + thresholdValue) {
			printContent = printContent.concat(GetContentInLang.getLowWarnInLang());
		} else if (input > maxValue - thresholdValue) {
			printContent = printContent.concat(GetContentInLang.getHighWarnInLang());
		} else {
			printContent = printContent.concat(GetContentInLang.getInRangeInLang());
		}
		System.out.println(printContent);
	}

	public static void main(String[] args) {
		langIndex = Languages.ENGLISH.getIndex();
		System.out.println(batteryIsOk(1.25f, 78, 0.802f, true, true, true) == false);
		langIndex = Languages.GERMAN.getIndex();
		System.out.println(batteryIsOk(1.25f, 78, 0.802f, false, true, false) == false);
		langIndex = Languages.ENGLISH.getIndex();
		System.out.println(batteryIsOk(50, 85, 0.0f, true, true, true) == false);
		System.out.println("Some more tests needed");
	}
}
