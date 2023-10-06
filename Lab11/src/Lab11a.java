import java.util.ArrayList;

public class Lab11a {
    public static void main(String[] args) throws Exception {
        System.out.println("=============Q2==============");
        // q1();
        q2();
    }

    final static int inf = Integer.MAX_VALUE;

    static void q2() {
        // A B C D E
        int[][] thisGraph = { 
            { 0, 3, inf, inf, 2 }, // your 1.1
            { 3, 0, 1, inf, inf },
            { inf, 1, 0, 4, inf },
            { inf, inf, 4, 0, 5 },
            { 2, inf, inf, 5, 0 } 
        };
        System.out.println("computing dfs");
        q2_dfs(thisGraph);
    }

    private static void q2_dfs(int[][] thisGraph) {
        ArrayList<Integer> stack = new ArrayList<>();
        ArrayList<Integer> visited = new ArrayList<>();
        stack.add(0); // root is at A, we'll suffix next city
        while (notEmpty(stack)) {
            int parent = stack.remove(stack.size() - 1);
            visited.add(parent);
            for (int x = 0; x < thisGraph.length; x++) {
                if (0 < thisGraph[parent][x] && thisGraph[parent][x] < inf && !visited.contains(x)) {
                    stack.add(x);
                    /* your code 1b */
                    System.out.println("Edge " + parent + ", " + x);
                }
            } //for
        }
    }

    private static boolean notEmpty(ArrayList<Integer> stack) {
        return !stack.isEmpty();
    }
}


    // private static int nextExplore(boolean[] visited, int[] dist) {
    // int city_index = -1;
    // int minDistance = inf;

    // for (int i = 0; i < visited.length; i++) {
    // if (!visited[i] && dist[i] < minDistance) {
    // minDistance = dist[i];
    // city_index = i;
    // }
    // }
    // /* your code 5 */

    // return city_index;
    // }