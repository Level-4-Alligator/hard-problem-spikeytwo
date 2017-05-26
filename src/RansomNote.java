import java.util.*;

public class RansomNote {
	Map<Integer, String> magazineMap;
	Map<Integer, String> noteMap;

	String mag;
	String not;

	public RansomNote(String magazine, String note) {
		mag = magazine;
		not = note;
		magazineMap = new HashMap();
		noteMap = new HashMap();
	}

	public boolean solve() {
		boolean ransom = true;
		String[] magazine = mag.split(" ");
		String[] note = not.split(" ");
		for (int i = 0; i < magazine.length; i++) {
			magazineMap.put(i, magazine[i]);
		}
		for (int i = 0; i < note.length; i++) {
			noteMap.put(i, note[i]);
		}
		for (int i = 0; i < note.length; i++) {
			if (magazineMap.get(i).equals(noteMap.get(i))) {
				ransom = true;
			}
			if (magazineMap.containsValue(note[i])) {
				ransom = true;
			} else {
				ransom = false;
			}
		}
		return ransom;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		RansomNote s = new RansomNote(scanner.nextLine(), scanner.nextLine());
		scanner.close();

		boolean answer = s.solve();
		if (answer)
			System.out.println("Yes");
		else
			System.out.println("No");

	}
}