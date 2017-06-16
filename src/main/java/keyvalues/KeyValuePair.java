package keyvalues;

public class KeyValuePair {
	private String key = "Unknown";
	private String value = "Unknown value";

	public KeyValuePair() {
	}

	public KeyValuePair(String k, String v) {
		setKey(k);
		setValue(v);
	}

	public String getKey() {
		return key;
	}

	public void setKey(String k) {
		key = k;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String v) {
		value = v;
	}

	protected void _checkEmptyValue(String val, String name) {
		if (val == null || val.trim().length() <= 0)
			throw new IllegalArgumentException("Error: " + name
					+ " cannot be null/empty!");
	}
}