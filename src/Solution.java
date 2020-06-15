import java.util.*;

public class Solution {
	static int MapSize = 9;
	static HashMap<String, String> KB = new HashMap<String, String>();
	static HashMap<String, String> Adder = new HashMap<String, String>();

	public static void main(String args[]) {
		Solution s = new Solution();
		int[][] map = { { -1, -1, -1, -1, -1, -1, -1, -1, -1 }, { -1, -1, -1, -1, -1, -1, -1, -1, -1 },
				{ -1, -1, -1, 2, 2, -1, 1, 1, 1 }, { -1, 2, -1, -1, 2, 1, 2, 1, 1 }, { -1, 3, 3, 3, 1, 0, 1, -1, 1 },
				{ 1, 2, -1, 1, 0, 0, 1, 1, 1 }, { 0, 1, 1, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 0, 0, 0, 0, 0, 0, 0, 0 } };
		for (int i = 0; i < MapSize; i++)
			for (int j = 0; j < MapSize; j++)
				if (map[i][j] != -1)
					KB.put(i + "," + j, String.valueOf(map[i][j]));

		System.out.println(s.run("isSafe(0,4)"));

		s.printBoom();
	}

	public void printBoom() {
		for (int i = 0; i < MapSize; i++) {
			for (int j = 0; j < MapSize; j++) {
				if (KB.containsKey(i + "," + j))
					System.out.print(KB.get(i + "," + j) + "\t");
				else
					System.out.print("unkn\t");
			}
			System.out.println();
		}
	}

	int mapSize = 9;
	int qx = 0, qy = 0;

	public boolean run(String query) {
		String[] pos = query.split("\\,");
		qx = Integer.parseInt(pos[0].replace("isSafe(", ""));
		qy = Integer.parseInt(pos[1].replace(")", "").replace(" ", ""));
		System.out.println(qx + " " + qy);
		addBorder();
		if (KB.containsKey(qx + "," + qy)) {
			if (KB.get(qx + "," + qy).equals("Boom"))
				return false;
			else
				return true;
		}
		return false;
	}

	public void addBorder() {
		boolean hasNew = true;
		if (KB.containsKey(qx + "," + qy))
			return;
		while (hasNew) {
			hasNew = false;
			Iterator<String> it = KB.keySet().iterator();
			while (it.hasNext()) {
				if (Adder.containsKey(qx + "," + qy)) {
					KB.putAll(Adder);
					return;
				}
				String key = it.next();
				String value = KB.get(key);
				if (value.length() == 1 && value != "0")
					if (addState(key))
						hasNew = true;
			}
			if (Adder.size() != 0) {
				KB.putAll(Adder);
				Adder.clear();
			}
			if (hasNew) {
				if (KB.containsKey(qx + "," + qy)) {
					System.out.println("질의 답변 완료");
					return;
				} else
					System.out.println("질의가 답변되지 않고 새로운 지식이 추가되었으므로 반복합니다");
			}
		}
		System.out.println("찾지 못했습니다.");
	}

	public boolean addState(String key) {
		Boolean result = false;
		int x = Integer.parseInt(key.split(",")[0]);
		int y = Integer.parseInt(key.split(",")[1]);
		int b = Integer.parseInt(KB.get(key)), empty = 0;
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (i != 0 || j != 0) {
					if (x + i >= 0 && y + j >= 0 && x + i < mapSize && y + j < mapSize) {
						String pos = (x + i) + "," + (y + j);
						if (KB.containsKey(pos)) {
							if (KB.get(pos).equals("Boom"))
								b--;
						} else
							empty++;
					}
				}
			}
		}
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (i != 0 || j != 0) {
					if (x + i >= 0 && y + j >= 0 && x + i < mapSize && y + j < mapSize) {
						String pos = (x + i) + "," + (y + j);
						if (b == 0) {
							if (!KB.containsKey(pos) && !Adder.containsKey(pos)) {
								System.out.println("(" + pos + ") : Safe");
								Adder.put(pos, "Safe");
								result = true;
								if (x + i == qx && y + j == qy)
									return true;
							}
						} else if (b == empty) {
							if (!KB.containsKey(pos) && !Adder.containsKey(pos)) {
								System.out.println("(" + pos + ") : Boom");
								Adder.put(pos, "Boom");
								result = true;
								if (x + i == qx && y + j == qy)
									return true;
							}
						}
					}
				}
			}
		}
		return result;
	}
}