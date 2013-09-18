package practice.designpatterns;

public class Catalog {

	private int catalogId;

	public int getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + catalogId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Catalog other = (Catalog) obj;
		if (catalogId != other.catalogId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Catalog [catalogId=" + catalogId + "]";
	}
}
