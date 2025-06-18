import java.util.*;

class Solution {
    static Set<Set<Integer>> key;
    static List<List<Integer>> combList;
    static int colLen;

    public int solution(String[][] relation) {
        key = new HashSet<>();
        combList = new ArrayList<>();
        colLen = relation[0].length;

        for (int r = 1; r <= colLen; r++) {
            backtracking(r, 0, new ArrayList<>());
        }

        for (List<Integer> comb : combList) {
            if (isUnique(comb, relation) && isMinimal(comb)) {
                key.add(new HashSet<>(comb));
            }
        }

        return key.size();
    }

    static void backtracking(int combLen, int start, List<Integer> current) {
        if (current.size() == combLen) {
            combList.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < colLen; i++) {
            current.add(i);
            backtracking(combLen, i + 1, current);
            current.remove(current.size() - 1);
        }
    }

    static boolean isUnique(List<Integer> comb, String[][] relation) {
        Set<String> seen = new HashSet<>();
        for (String[] row : relation) {
            StringBuilder sb = new StringBuilder();
            for (int i : comb) sb.append(row[i]).append(",");
            seen.add(sb.toString());
        }
        return seen.size() == relation.length;
    }

    static boolean isMinimal(List<Integer> comb) {
        Set<Integer> combSet = new HashSet<>(comb);
        for (Set<Integer> k : key) {
            if (combSet.containsAll(k)) return false;
        }
        return true;
    }
}
