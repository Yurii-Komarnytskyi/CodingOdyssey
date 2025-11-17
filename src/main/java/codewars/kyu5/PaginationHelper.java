package codewars.kyu5;

import java.util.List;

public class PaginationHelper<I> {
	// https://www.codewars.com/kata/515bb423de843ea99400000a
	private List<I> items;
	private int maxItemsPerPage;

	public PaginationHelper(List<I> collection, int itemsPerPage) {
		if (collection == null || itemsPerPage <= 0) {
			throw new IllegalArgumentException("collection must not be 'null'; itemsPerPage must be positive number.");
		}
		items = collection;
		maxItemsPerPage = itemsPerPage;
	}

	public int itemCount() {
		return items.size();
	}

	public int pageCount() {
		return (int) Math.ceil((double) items.size() / maxItemsPerPage);
	}

	public int pageItemCount(int pageIndex) {
		int startIndex = pageIndex * maxItemsPerPage;
		if (pageIndex > pageCount() - 1 || pageIndex < 0) {
			return -1;
		}
	    if (startIndex >= itemCount()) {
	        return 0;
	    }
	    return Math.min(maxItemsPerPage, itemCount() - startIndex);
	}

	public int pageIndex(int itemIndex) {
		if (itemIndex > items.size() - 1 || itemIndex < 0) {
			return -1;
		}
		return itemIndex / maxItemsPerPage;
	}
}
