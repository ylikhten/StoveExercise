/**
 * Defines a Burner object, representing a stove burner that can be turned up or down,
 * and that heats up or cools off over time to match its setting.
 * @author Pat Kohl
 * @author Yanina Likhtenshteyn
 *
 */
public class Burner {

	/**
	 * enum that represents the various possible temperatures of a burner.
	 */
	enum Temperature{
		BLAZING("VERY HOT! DON'T TOUCH"), HOT("CAREFUL"), WARM("warm"), COLD("cooool");
		
		String temperature;

		private Temperature(String temperature) {
			this.temperature = temperature;
		}
		
		public String toString(){
			return temperature;
		}
	}
	
	private Temperature myTemp;
	private Setting mySetting;
	
	// tracks how long it will be until a burner needs to be checked for a temperature update
	private int timer; 
	// number of minutes a burner must be on before it is eligible for a temperature change
	public static final int TIME_DURATION = 2; 


	/**
	 * Constructs a burner object that is OFF and COLD by default.
	 */
	public Burner() {
		myTemp = Temperature.COLD;
		mySetting = Setting.OFF;
		timer = 0;
	}
	
	public Temperature getMyTemp() {
		return myTemp;
	}

	public Setting getMySetting() {
		return mySetting;
	}
	
	/**
	 * Turn the burner up one unit, not going above HIGH.
	 */
	public void plusButton(){
		timer = TIME_DURATION;
		switch(mySetting){
			case OFF:
				mySetting = Setting.LOW;
				break;
			case LOW:
				mySetting = Setting.MEDIUM;
				break;
			case MEDIUM:
				mySetting = Setting.HIGH;
				break;
			case HIGH:
				break;
		}
	}

	/**
	 * Turn the burner down one unit, not going below OFF.
	 */
	public void minusButton(){
		timer = TIME_DURATION;
		switch(mySetting){
			case HIGH:
				mySetting = Setting.MEDIUM;
				break;
			case MEDIUM:
				mySetting = Setting.LOW;
				break;
			case LOW:
				mySetting = Setting.OFF;
				break;
			case OFF:
				break;
		}
	}
	
	/**
	 * Advances time by one unit and changes the temperature of the burner if appropriate.
	 * Once TIME_DURATION has elapsed for the burner, we check and see if the burner's temperature
	 * matches the equilibrium temperature for that burner's setting (OFF to COLD, LOW to WARM, 
	 * MEDIUM to HOT, and HIGH to BLAZING).  If no match, adjust the burner's temperature up or down
	 * as appropriate and reset the timer.
	 */
	public void updateTemperature(){
		// this routine advances time, so all burners with one time unit remaining will hit zero, require
		// a temperature check, and have their timers reset.
		if(timer == 1){
			if(myTemp == Temperature.BLAZING){
				if(mySetting != Setting.HIGH){
					myTemp = Temperature.HOT;
				}
			}
			else if(myTemp == Temperature.HOT){
				if(mySetting == Setting.HIGH){
					myTemp = Temperature.BLAZING;
				} 
				else if(mySetting == Setting.OFF || mySetting == Setting.LOW){
					myTemp = Temperature.WARM;
				}
			}
			else if(myTemp == Temperature.WARM){
				if(mySetting == Setting.HIGH || mySetting == Setting.MEDIUM){
					myTemp = Temperature.HOT;
				}
				else if(mySetting == Setting.OFF){
					myTemp = Temperature.COLD;
				}
			}
			else{
				if(mySetting != Setting.OFF){
					myTemp = Temperature.WARM;
				}
			}
			timer = TIME_DURATION;
		}
		// if the burner's timer hasn't expired yet, decrement it.
		else if (timer > 0){
			timer--;
		}
	}
	
	/**
	 * Creates a string representation of a burner's setting and temperature.
	 */
	public void display(){
		System.out.println("[" + mySetting + "]....." + myTemp);
	}
}
