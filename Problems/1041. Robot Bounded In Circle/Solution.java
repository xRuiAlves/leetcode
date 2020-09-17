import java.util.HashMap;
import java.util.Map;

class Solution {
    private static final class Robot {
        int x = 0;
        int y = 0;
        char dir = 'N';

        static final Map<Character, Character> RIGHT_TURNS = new HashMap<>() {{
            put('N', 'E');
            put('E', 'S');
            put('S', 'W');
            put('W', 'N');
        }};

        static final Map<Character, Character> LEFT_TURNS = new HashMap<>() {{
            put('N', 'W');
            put('W', 'S');
            put('S', 'E');
            put('E', 'N');
        }};

        void executeAction(char action) {
            switch (action) {
                case 'G':
                    moveForward();
                    break;
                case 'R':
                    dir = RIGHT_TURNS.get(dir);
                    break;
                case 'L':
                    dir = LEFT_TURNS.get(dir);
            }
        }

        private void moveForward() {
            switch (dir) {
                case 'N':
                    ++y;
                    break;
                case 'S':
                    --y;
                    break;
                case 'E':
                    ++x;
                    break;
                case 'W':
                    --x;
                    break;
            }
        }
    }

    public boolean isRobotBounded(String instructions) {
        int max_x = 0;
        int min_x = 0;
        int max_y = 0;
        int min_y = 0;
        Robot robot = new Robot();

        for (int i = 0; i < 4; ++i) {
            for (char action : instructions.toCharArray()) {
                robot.executeAction(action);
            }

            max_x = Math.max(max_x, robot.x);
            min_x = Math.min(min_x, robot.x);
            max_y = Math.max(max_y, robot.y);
            min_y = Math.min(min_y, robot.y);
        }
        
        for (int i = 0; i < 4; ++i) {
            for (char action : instructions.toCharArray()) {
                robot.executeAction(action);
            }

            if (robot.x > max_x || robot.x < min_x || robot.y > max_y || robot.y < min_y) {
                return false;
            }
        }
        
        return true;
    }
}
