/**
 * Enum that tracks and displays the setting of a stove burner.
 * @author Yanina Likhtenshteyn
 * @author Pat Kohl
 *
 */
public enum Setting {
	
	OFF("---"), LOW("--+"), MEDIUM("-++"), HIGH("+++");
	
	private String setting;
	
	Setting(String setting) {
		this.setting = setting;
	}	
	
	public String toString(){
		return setting;
	}
	
}
