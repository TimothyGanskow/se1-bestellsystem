package datamodel;

public class OrderItem {
	private String description;
	private final Article article;
	private int unitsOrdered;

	protected OrderItem(String description, Article article, int units) {
		this.description = description;
		this.article = article;
		this.unitsOrdered = units;
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

	public Article getArticle() {
		return article;
	}

	public int getUnitsOrdered() {
		if (this.unitsOrdered >= 0) {
			return unitsOrdered;
		} else {
			return 0;
		}
	}

	public void setUnitsOrdered(int unitsOrdered) {
		this.unitsOrdered = unitsOrdered;
	}

}
