private static int nextExplore(boolean[] visited, int[] dist) {
        int city_index = -1;
        int minDistance = inf;

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && dist[i] < minDistance) {
                minDistance = dist[i];
                city_index = i;
            }
        }
        /* your code 5 */

        return city_index;
    }