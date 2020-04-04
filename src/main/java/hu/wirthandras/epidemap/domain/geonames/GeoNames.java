package hu.wirthandras.epidemap.domain.geonames;

import java.util.List;

public class GeoNames {

	private int totalResultsCount;
	
	private List<GeoName> geonames;

	public int getTotalResultsCount() {
		return totalResultsCount;
	}

	public void setTotalResultsCount(int totalResultsCount) {
		this.totalResultsCount = totalResultsCount;
	}

	public List<GeoName> getGeonames() {
		return geonames;
	}

	public void setGeonames(List<GeoName> geonames) {
		this.geonames = geonames;
	}
	
}
