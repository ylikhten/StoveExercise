
public class Burner {

	private enum Temperature{
		BLAZING("Very HOT! DON'T TOUCH"), HOT("CAREFUL"), WARM("warm"), COLD("cooool");
		
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
	private int timer;
	public static final int TIME_DURATION = 2;

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
	
	public void plusButton(){
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

	public void minusButton(){
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
}
