package utility;

import java.util.Comparator;
import java.util.Map;

public class WordCountComparator implements Comparator<Map.Entry<String, Integer>> {

	@Override
	public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
		return - Integer.compare(e1.getValue(), e2.getValue());
	}

}
