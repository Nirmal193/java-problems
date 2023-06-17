
import java.util.*;

class City {
    int id;
    int cost;
    int stops;

    public City(int id, int cost, int stops) {
        this.id = id;
        this.cost = cost;
        this.stops = stops;
    }
}

public class CheapestFlight {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
            Map<Integer, Map<Integer, Integer>> prices = new HashMap<>();
            for (int[] f : flights) {
                if (!prices.containsKey(f[0])) prices.put(f[0], new HashMap<>());
                prices.get(f[0]).put(f[1], f[2]);
            }
            Queue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));
            pq.add(new int[] {0, src, k + 1});
            while (!pq.isEmpty()) {
                int[] top = pq.remove();
                int price = top[0];
                int city = top[1];
                int stops = top[2];
                if (city == dst) return price;
                if (stops > 0) {
                    Map<Integer, Integer> adj = prices.getOrDefault(city, new HashMap<>());
                    for (int a : adj.keySet()) {
                        pq.add(new int[] {price + adj.get(a), a, stops - 1});
                    }
                }
            }
            return -1;

    }

    public static void main(String[] args) {
        int n = 5;
        int[][] flights = {{0, 1, 5}, {1, 2, 5}, {0, 3, 2}, {3, 1, 2}, {1, 4, 1}, {4, 2, 1}};
        int src = 0;
        int dst = 2;
        int k = 2;

        CheapestFlight solution = new CheapestFlight();
        int cheapestPrice = solution.findCheapestPrice(n, flights, src, dst, k);
        System.out.println("Cheapest price: " + cheapestPrice);
    }
}
