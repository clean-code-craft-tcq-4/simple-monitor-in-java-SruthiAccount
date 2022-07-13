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

	static boolean batteryIsOk(float temperature, float soc, float chargeRate, boolean needTempWarning,
			boolean needSocWarning, boolean needChargerateWarning, int lang) {
		TempParamData tempParam = new TempParamData();
		tempParam.setData(0.0f, 45.0f, 5.0f, needTempWarning);
		SocParamData socParam = new SocParamData();
		socParam.setData(20.0f, 80.0f, 5.0f, needSocWarning);
		ChargeRateParamData crParam = new ChargeRateParamData();
		crParam.setData(0.0f, 0.8f, 5.0f, needChargerateWarning);
		Boolean tempCheckParam = checkParam("Temperature", temperature, tempParam, lang);
		Boolean socCheckParam = checkParam("State of Charge", soc, socParam, lang);
		Boolean chargeRateCheckParam = checkParam("Charge Rate", chargeRate, crParam, lang);
		return tempCheckParam && socCheckParam && chargeRateCheckParam;
	}

	static boolean checkParam(String param, float input, ParamDataInterface data, int langIndex) {
		float minValue = data.getValue("minValue");
		float maxValue = data.getValue("maxValue");
		float thresholdPercent = data.getValue("thresholdPercent");
		float thresholdValue = thresholdPercent * maxValue / 100;
		String printContent = GetContentInLang.getParamInLang(param, langIndex);
		if (input < minValue || input > maxValue) {
			if (data.getWarning()) {
				if (input > minValue - thresholdValue && input < minValue) {
					printContent = printContent.concat(GetContentInLang.getLowBreachInLang(langIndex));
				} else if (input < maxValue + thresholdValue && input > maxValue) {
					printContent = printContent.concat(GetContentInLang.getHighBreachInLang(langIndex));
				} else {
					printContent = printContent.concat(GetContentInLang.getOutOfRangeInLang(langIndex));
				}

			} else
				printContent = printContent.concat(GetContentInLang.getOutOfRangeInLang(langIndex));
			System.out.println(printContent);
			return false;
		} else {
			if (data.getWarning()) {
				if (input < minValue + thresholdValue) {
					printContent = printContent.concat(GetContentInLang.getLowWarnInLang(langIndex));
				} else if (input > maxValue - thresholdValue) {
					printContent = printContent.concat(GetContentInLang.getHighWarnInLang(langIndex));
				} else {
					printContent = printContent.concat(GetContentInLang.getInRangeInLang(langIndex));
				}
				System.out.println(printContent);
			}

			return true;
		}
	}

	public static void main(String[] args) {
		System.out.println(batteryIsOk(1.25f, 78, 0.802f, true, true, true, Languages.ENGLISH.getIndex()) == false);
		System.out.println(batteryIsOk(1.25f, 78, 0.802f, false, true, false, Languages.GERMAN.getIndex()) == false);
		System.out.println(batteryIsOk(50, 85, 0.0f, true, true, true, Languages.ENGLISH.getIndex()) == false);
		System.out.println("Some more tests needed");
	}
}
