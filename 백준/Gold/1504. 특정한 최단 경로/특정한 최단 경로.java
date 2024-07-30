import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int end, weight;

    Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}

public class Main {
    static int N, E;
    static ArrayList<ArrayList<Node>> graph;
    static int[] dist;
    static final int INF = 200000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        dist = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end, weight));
            graph.get(end).add(new Node(start, weight));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 1 -> v1 -> v2 -> N으로 가는 경우
        int res1 = dijkstra(1, v1);
        if (res1 != INF) res1 += dijkstra(v1, v2);
        if (res1 != INF) res1 += dijkstra(v2, N);

        // 1 -> v2 -> v1 -> N으로 가는 경우
        int res2 = dijkstra(1, v2);
        if (res2 != INF) res2 += dijkstra(v2, v1);
        if (res2 != INF) res2 += dijkstra(v1, N);

        int ans = Math.min(res1, res2);
        if (ans >= INF) ans = -1;

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int dijkstra(int start, int end) {
        Arrays.fill(dist, INF);
        boolean[] visited = new boolean[N + 1];

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int current = currentNode.end;

            if (visited[current]) continue;
            visited[current] = true;

            for (Node neighbor : graph.get(current)) {
                if (!visited[neighbor.end] && dist[neighbor.end] > dist[current] + neighbor.weight) {
                    dist[neighbor.end] = dist[current] + neighbor.weight;
                    pq.add(new Node(neighbor.end, dist[neighbor.end]));
                }
            }
        }

        return dist[end];
    }
}