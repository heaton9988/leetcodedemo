import java.util.Iterator;

public class DesignHitCounter362 {
	private final int[] ts;

	private final int[] cs;

	/**
	 * Initialize your data structure here.
	 */
	public DesignHitCounter362() {
		ts = new int[300];
		cs = new int[300];
	}

	/**
	 * Record a hit.
	 *
	 * @param timestamp - The current timestamp (in seconds granularity).
	 */
	public void hit(int timestamp) {
		int i = timestamp % 300;
		if (ts[i] != timestamp) {
			ts[i] = timestamp;
			cs[i] = 1;
		} else {
			cs[i]++;
		}
	}

	/**
	 * Return the number of hits in the past 5 minutes.
	 *
	 * @param timestamp - The current timestamp (in seconds granularity).
	 */
	public int getHits(int timestamp) {
		int sum = 0;
		int ix = timestamp - 299;
		for (int m = 0; m < 300; m++) {
			if (ts[m] >= ix) {
				sum += cs[m];
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		DesignHitCounter362 counter = new DesignHitCounter362();

		// hit at timestamp 1.
		counter.hit(1);

		// hit at timestamp 2.
		counter.hit(2);

		// hit at timestamp 3.
		counter.hit(3);

		// get hits at timestamp 4, should return 3.
		counter.getHits(4);

		// hit at timestamp 300.
		counter.hit(300);

		// get hits at timestamp 300, should return 4.
		counter.getHits(300);

		// get hits at timestamp 301, should return 3.
		counter.getHits(301);

		System.out.println(System.currentTimeMillis() - start + " ms");
	}
}