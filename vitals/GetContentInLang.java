package vitals;

public class GetContentInLang {
	static String getParamInLang(String param) {
		if (Main.langIndex == 1) {
			if (param.equalsIgnoreCase("Temperature"))
				return "Temperatur";
			if (param.equalsIgnoreCase("State of Charge"))
				return "Ladezustand";
			if (param.equalsIgnoreCase("charge rate"))
				return "Ladestrom";
			else
				return "";
		} else {
			if (param.equalsIgnoreCase("Temperature"))
				return "Temperature";
			if (param.equalsIgnoreCase("State of Charge"))
				return "State of Charge";
			if (param.equalsIgnoreCase("charge rate"))
				return "charge rate";
			else
				return "";
		}
	}

	static String getLowBreachInLang() {
		if (Main.langIndex == 1)
			return " ist bei LOW BREACH !!!";
		else if (Main.langIndex == 0)
			return " is at LOW BREACH !!!";
		else
			return " is at LOW BREACH !!!";
	}

	static String getHighBreachInLang() {
		if (Main.langIndex == 1)
			return " ist bei HIGH BREACH !!!";
		else if (Main.langIndex == 0)
			return " is at HIGH BREACH !!!";
		else
			return " is at HIGH BREACH !!!";
	}

	static String getOutOfRangeInLang() {
		if (Main.langIndex == 1)
			return " ist aus Angebot!!!";
		else if (Main.langIndex == 0)
			return " is out of range!!!";
		else
			return " is out of range!!!";
	}

	static String getLowWarnInLang() {
		if (Main.langIndex == 1)
			return " ist auf NIEDRIG WARNUNG !!!";
		else if (Main.langIndex == 0)
			return " is at LOW WARNING !!!";
		else
			return " is at LOW WARNING !!!";
	}

	static String getHighWarnInLang() {
		if (Main.langIndex == 1)
			return " HOCH Warnung!!!";
		else if (Main.langIndex == 0)
			return " is at HIGH WARNING !!!";
		else
			return " is at HIGH WARNING !!!";
	}

	static String getInRangeInLang() {
		if (Main.langIndex == 1)
			return " ist im Normalzustand";
		else if (Main.langIndex == 0)
			return " is at normal state";
		else
			return " is at normal state";
	}
}
