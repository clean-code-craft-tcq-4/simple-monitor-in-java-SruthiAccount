import org.junit.Test;

public class TestVitals {

	@Test
	public void testCheckMinTemperature() {
		assert(Main.checkTemperature(0.0f)==true);
	}
	@Test
	public void testCheckLessThanMinTemperature() {
		assert(Main.checkTemperature(-0.1f)==false);
	}
	@Test
	public void testCheckMaxTemperature() {
		assert(Main.checkTemperature(45.0f)==true);
	}
	@Test
	public void testCheckMoreThanMaxTemperature() {
		assert(Main.checkTemperature(45.1f)==false);
	}
	@Test
	public void testCheckTemperature() {
		assert(Main.checkTemperature(30.0f)==true);
	}
	
	@Test
	public void testCheckMinSoc() {
		assert(Main.checkSoc(20.0f)==true);
	}
	@Test
	public void testCheckLessThanMinSoc() {
		assert(Main.checkSoc(19.9f)==false);
	}
	@Test
	public void testCheckMaxSoc() {
		assert(Main.checkSoc(80.0f)==true);
	}
	@Test
	public void testCheckMoreThanMaxSoc() {
		assert(Main.checkSoc(80.1f)==false);
	}
	@Test
	public void testCheckSoc() {
		assert(Main.checkSoc(60.0f)==true);
	}
	@Test
	public void testCheckMaxChargeRate() {
		assert(Main.checkChargeRate(0.8f)==true);
	}
	@Test
	public void testCheckMoreThanMaxChargeRate() {
		assert(Main.checkChargeRate(0.81f)==false);
	}
	@Test
	public void testCheckChargeRate() {
		assert(Main.checkChargeRate(0.6f)==true);
	}
	@Test
	public void testBatteryIsOk() {
		assert(Main.batteryIsOk(0, 20, 0)==true);
	}
	@Test
	public void testBatteryIsOkTempFailed() {
		assert(Main.batteryIsOk(50, 20, 0)==false);
	}
	@Test
	public void testBatteryIsOkSocFailed() {
		assert(Main.batteryIsOk(0, 19, 0)==false);
	}
	@Test
	public void testBatteryIsOkChargeRateFailed() {
		assert(Main.batteryIsOk(0, 20, 0.9f)==false);
	}
	@Test
	public void testBatteryIsOkAllFailed() {
		assert(Main.batteryIsOk(50, 19, 0.9f)==false);
	}
}
