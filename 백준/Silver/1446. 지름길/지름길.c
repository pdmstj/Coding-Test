#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

#define INF INT_MAX

typedef struct {
    int end;
    int distance;
} Edge;

typedef struct {
    Edge* edges;
    int size;
    int capacity;
} Vertex;

void add_edge(Vertex* graph, int start, int end, int distance) {
    if (graph[start].size == graph[start].capacity) {
        graph[start].capacity *= 2;
        graph[start].edges = realloc(graph[start].edges, graph[start].capacity * sizeof(Edge));
    }
    graph[start].edges[graph[start].size].end = end;
    graph[start].edges[graph[start].size].distance = distance;
    graph[start].size++;
}

int* shortest_length(Vertex* graph, int start, int d) {
    int* distance = malloc((d + 1) * sizeof(int));
    int* visited = malloc((d + 1) * sizeof(int));
    for (int i = 0; i <= d; i++) {
        distance[i] = INF;
        visited[i] = 0;
    }
    distance[start] = 0;
    int cur = start;
    
    while (1) {
        visited[cur] = 1;
        for (int i = 0; i < graph[cur].size; i++) {
            int nei = graph[cur].edges[i].end;
            int nei_dist = graph[cur].edges[i].distance;
            if (!visited[nei] && distance[nei] > nei_dist + distance[cur]) {
                distance[nei] = nei_dist + distance[cur];
            }
        }
        int min_dist = INF;
        int next_cur = -1;
        for (int i = 0; i <= d; i++) {
            if (!visited[i] && distance[i] < min_dist) {
                min_dist = distance[i];
                next_cur = i;
            }
        }
        if (next_cur == -1) break;
        cur = next_cur;
    }
    
    free(visited);
    return distance;
}

int main() {
    int n, d;
    scanf("%d %d", &n, &d);

    Vertex* graph = malloc((d + 1) * sizeof(Vertex));
    for (int i = 0; i <= d; i++) {
        graph[i].edges = malloc(2 * sizeof(Edge));
        graph[i].size = 0;
        graph[i].capacity = 2;
        if (i < d) {
            add_edge(graph, i, i + 1, 1);
        }
    }
    
    for (int i = 0; i < n; i++) {
        int start, end, distance;
        scanf("%d %d %d", &start, &end, &distance);
        if (end <= d) {
            add_edge(graph, start, end, distance);
        }
    }
    
    int* distances = shortest_length(graph, 0, d);
    printf("%d\n", distances[d]);
    
    for (int i = 0; i <= d; i++) {
        free(graph[i].edges);
    }
    free(graph);
    free(distances);
    
    return 0;
}