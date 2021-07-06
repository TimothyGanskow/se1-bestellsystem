package datamodel;

public class Article {
	private String id;
	private String description;
	private long unitPrice;
	private int unitsInStore;
	Article a2;

	protected Article(String id, String descr, long price, int units) {
		this.id = id;
		this.description = descr;
		this.unitPrice = price;
		this.unitsInStore = units;
	}

	public String getId() {
		return id;
	}

	public String getDescription() {
		if (this.description != null) {
			return description;
		} else {
			return "";
		}
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getUnitPrice() {
		if (this.unitPrice >= 0) {
			return unitPrice;
		} else {
			return 0;
		}
	}

	public void setUnitPrice(long unitPrice) {
		if (unitPrice < Long.MAX_VALUE && unitPrice > Long.MIN_VALUE) {
			this.unitPrice = unitPrice;
		} else {
			this.unitPrice = 0;
		}
	}

	public int getUnitsInStore() {
		if (this.unitsInStore >= 0) {
			return unitsInStore;
		} else {
			return 0;
		}
	}

	public void setUnitsInStore(int unitsInStore) {
		if (unitsInStore < Integer.MAX_VALUE && unitsInStore > Integer.MIN_VALUE) {
			this.unitsInStore = unitsInStore;
		} else {
			this.unitsInStore = 0;
		}
	}

	public long getValue() {
		long value = getUnitPrice() * getUnitsInStore();
		return value;
	}
}
