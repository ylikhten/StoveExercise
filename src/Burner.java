
public class Burner {

	private enum Temperature{
		BLAZING, HOT, WARM, COLD
	}
	
	private Temperature myTemp;
	private Setting mySetting;
	private int timer;
	public static final int TIME_DURATION = 2;

	public Temperature getMyTemp() {
		return myTemp;
	}

	public Burner() {
		myTemp = Temperature.COLD;
		mySetting = Setting.OFF;
		timer = 0;
	}

}
