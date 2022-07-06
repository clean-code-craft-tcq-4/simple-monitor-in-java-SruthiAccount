package vitals;
public class Main {
	static float  minTemperature=0.0f;
	static float maxTemperature=45.0f;
	static float minSoc=20.0f;
	static float maxSoc=80.0f;
	static float maxChargeRate=0.8f;
	
    static boolean batteryIsOk(float temperature, float soc, float chargeRate) {
        return checkTemperature(temperature)&&checkSoc(soc)&&checkChargeRate(chargeRate);
    }
    
    static boolean checkTemperature(float temperature)
    {
    	 if(temperature < minTemperature || temperature > maxTemperature) {
             System.out.println("Temperature is out of range!");
             return false;
         }
    	 return true;
    }
static boolean checkSoc(float soc)
{
	if(soc < minSoc || soc > maxSoc) {
        System.out.println("State of Charge is out of range!");
        return false;
    } 
	return true;
}
static boolean checkChargeRate(float chargeRate) {
	if(chargeRate > maxChargeRate) {
        System.out.println("Charge Rate is out of range!");
        return false;
    }
    return true;

}
    public static void main(String[] args) {
    	System.out.println(batteryIsOk(25, 70, 0.7f) == true);
        System.out.println(batteryIsOk(50, 85, 0.0f) == false);
        System.out.println("Some more tests needed");
    }
}
