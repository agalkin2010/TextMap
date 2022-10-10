import java.util.HashMap;
import java.util.Map;

public class Main {

    private static String text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public static void main(String[] args) {

        Map<Character, Integer> latterMap = new HashMap<>();

        boolean charPresented;
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isLetter(text.charAt(i))) {
                continue;
            }
            char currentLetter = text.charAt(i);
            if (latterMap.isEmpty()) {
                latterMap.put(currentLetter, 1);
                continue;
            }
            charPresented = false;
            for (Character c : latterMap.keySet()) {
                if (c == currentLetter) {
                    latterMap.replace(c, latterMap.get(c) + 1);
                    charPresented = true;
                    break;
                }
            }
            if (!charPresented) {
                latterMap.put(currentLetter, 1);
            }
        }

        System.out.println(latterMap);
        int maxVal = max(latterMap);
        int minVal = min(latterMap);

        for (char c : latterMap.keySet()) {
            if (latterMap.get(c) == maxVal) {
                System.out.println("Максимальное значение " + c + " " + maxVal);
            }
            if (latterMap.get(c) == minVal) {
                System.out.println("Минимальное значение " + c + " " + minVal);
            }
        }
    }

    private static int max(Map<Character, Integer> map) {
        int tmax = -1;
        for (char c : map.keySet()) {
            if (map.get(c) > tmax) {
                tmax = map.get(c);
            }
        }
        return tmax;
    }
    
    private static int min(Map<Character, Integer> map) {
        int tmin = Integer.MAX_VALUE;
        for (char c : map.keySet()) {
            if (map.get(c) < tmin) {
                tmin = map.get(c);
            }
        }
        return tmin;
    }
}
