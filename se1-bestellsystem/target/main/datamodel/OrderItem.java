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
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Article getArticle() {
		return article;
	}

	public int getUnitsOrdered() {
		return unitsOrdered;
	}

	public void setUnitsOrdered(int unitsOrdered) {
		this.unitsOrdered = unitsOrdered;
	}

}
