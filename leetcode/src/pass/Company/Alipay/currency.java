package pass.Company.Alipay;
import java.util.*;

public class currency {
    public static void main(String[] args) {
        // List<Node> data = new ArrayList<Node>();
        // data.add(new Node("USD", "JPY", 110));
        // data.add(new Node("USD", "AUD", 1.45));
        // data.add(new Node("JPY", "GBP", 0.0070));
        // System.out.println(getRatio("GBP", "AUD", data));
        List<List<String>> list = new ArrayList<>();
        List<String> a = new ArrayList<>();
        a.add("USD");
        a.add("CAD");
        a.add("1.3");

        List<String> b = new ArrayList<>();
        b.add("USD");
        b.add("GBP");
        b.add("0.71");

        List<String> c = new ArrayList<>();
        c.add("USD");
        c.add("JPY");
        c.add("109");

        List<String> d = new ArrayList<>();
        d.add("GBP");
        d.add("JPY");
        d.add("155");

        List<String> e = new ArrayList<>();
        e.add("CAD");
        e.add("KRW");
        e.add("921");
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        // list.add(e);

        currency sl = new currency();
        System.out.println(sl.cur(list, "USD", "JPY"));
    }
    

    Map<String, Double> memo = new HashMap<>();
    public double cur(List<List<String>> list, String a, String b){
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (List<String> pair : list){
            String from = pair.get(0);
            String to = pair.get(1);
            double price = Double.valueOf(pair.get(2));
            if (!graph.containsKey(from)){
                graph.put(from, new HashMap<>());
            }
            graph.get(from).put(to, price);
        }
        memo.put(a, 1.0);
        dfs(graph, a, b);
        return memo.containsKey(b) ? memo.get(b) : -1.0;
    }

    public void dfs(Map<String, Map<String, Double>> graph, String a, String b){
        if (!graph.containsKey(a)) return;
        Map<String, Double> nexts = graph.get(a);
        System.out.println(a);
        double pre = memo.get(a);
        if (a.equals(b)) return;
        
        for (String next : nexts.keySet()){
            double cur = pre * nexts.get(next);
            if (!memo.containsKey(next)) memo.put(next, cur);
            if (memo.get(next) < cur) memo.put(next, cur); 
            
            dfs(graph, next, b);
        }
    }




    public static double getRatio(String start, String end, List<Node> data) {
        Map<String, Map<String, Double>> map = new HashMap();
        for (Node node: data) {
            if (!map.containsKey(node.start)) map.put(node.start, new HashMap());
            map.get(node.start).put(node.end, node.ratio);
            if (!map.containsKey(node.end)) map.put(node.end, new HashMap());
            map.get(node.end).put(node.start, 1.0/node.ratio);
        }
        Queue<String> q = new LinkedList();
        Queue<Double> val = new LinkedList();
        q.offer(start);
        val.offer(1.0);
        Set<String> visited = new HashSet();
        while(!q.isEmpty()) {
            String cur = q.poll();
            double num = val.poll();
            if (visited.contains(cur)) continue;
            visited.add(cur);
            if (map.containsKey(cur)) {
                Map<String, Double> next = map.get(cur);
                for (String key: next.keySet()) {
                    if (!visited.contains(key)) {
                        q.offer(key);
                        if (key.equals(end)) return num*next.get(key);
                        val.offer(num*next.get(key));
                    }
                }
            }
        }
        return -1;
    }

    static class Node {
        String start;
        String end;
        double ratio;
        public Node(String s, String e, double r) {
            this.start = s;
            this.end = e;
            this.ratio = r;
        }
    }


    class node{
        String s;
        double price;
        public node(String str, double p){
            s = str;
            price = p;
        }
    }
}