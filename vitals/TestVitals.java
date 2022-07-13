package vitals;

import org.junit.Test;

public class TestVitals {

	@Test
	public void testBatteryIsOk() {
		assert (Main.batteryIsOk(0, 20, 0, true, true, true, 0) == true);
	}

	@Test
	public void testBatteryIsOkTempFailed() {
		assert (Main.batteryIsOk(50, 20, 0, true, true, true, 0) == false);
	}

	@Test
	public void testBatteryIsOkSocFailed() {
		assert (Main.batteryIsOk(0, 19, 0, true, true, true, 1) == false);
	}

	@Test
	public void testBatteryIsOkChargeRateFailed() {
		assert (Main.batteryIsOk(0, 20, 0.9f, true, true, true, 1) == false);
	}

	@Test
	public void testBatteryIsOkAllFailed() {
		assert (Main.batteryIsOk(50, 19, 0.9f, true, true, true, 1) == false);
	}
}
