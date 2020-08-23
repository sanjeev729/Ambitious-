package arrays;

public class MajorityElement {

	public MajorityElement() {
	}

	public Integer getMajorityElement(int[] array) {

		if (array == null || array.length == 0) {
			return null;
		}

		Integer candidate = null;
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			if (count == 0) {
				candidate = array[i];
				count = 1;
				continue;
			} else {
				if (candidate == array[i]) {   //got same number so increment
					count++;
				} else {
					count--;                  // different number so decrement the count 
				}
			}
		}

		if (count == 0) {    // check if majority element is present or not
			return null;
		}

		count = 0;
		for (int i = 0; i < array.length; i++) {     
			if (candidate == array[i]) {       // check if candidate is majority or not
				count++;
			}
		}
		return (count > array.length / 2) ? candidate : null;
	}

}
