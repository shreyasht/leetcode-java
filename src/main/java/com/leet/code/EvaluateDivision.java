package com.leet.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res = new double[queries.size()];
        UF uf = new UF();
        for (int i = 0; i < values.length; ++i)
            uf.union(equations.get(i).get(0), equations.get(i).get(1), values[i]);
        for (int i = 0; i < queries.size(); ++i) {
            String x = queries.get(i).get(0), y = queries.get(i).get(1);
            res[i] = (uf.parents.containsKey(x) && uf.parents.containsKey(y) && uf.find(x) == uf.find(y)) ? uf.vals.get(x) / uf.vals.get(y) : -1.0;
        }
        return res;
    }

    public static void main(String[] args) {
        EvaluateDivision evaluateDivision = new EvaluateDivision();
        List<String> str1 = Arrays.asList("a", "b");
        List<String> str2 = Arrays.asList("b", "c");
        List<List<String>> equations = Arrays.asList(str1, str2);

        List<String> qer1 = Arrays.asList("a", "c");
        List<String> qer2 = Arrays.asList("b", "a");
        List<String> qer3 = Arrays.asList("a", "e");
        List<String> qer4 = Arrays.asList("a", "a");
        List<String> qer5 = Arrays.asList("x", "x");

        List<List<String>> queries = Arrays.asList(qer1, qer2, qer3, qer4, qer5);

        evaluateDivision.calcEquation(equations, new double[]{2.0, 3.0}, queries);
    }

    class UF {
        /**
         * parents: (x, root(x)), vals:(x, x/root(x)), for example, a / b = 2.0, we will have parents(a, b), vals(a, 2.0), both parents and vals have the numerator (which is 'a' here)
         * so that we can search for it and get the value a / parents(a) = vals.get(a) which is a / b = 2.0.
         */
        Map<String, String> parents;
        Map<String, Double> vals;

        UF() {
            parents = new HashMap<>();
            vals = new HashMap<>();
        }

        public void add(String x) {
            if (parents.containsKey(x)) return;
            parents.put(x, x);
            vals.put(x, 1.0);
        }

        /**
         * find the root
         * parents(x, p) = vals(x), x / p = vals(x), parents(p, pp) = vals(p), p / pp = vals(pp), when we are looking for the root, we are doing a path compression here
         * parents(x, pp)  = vals(x) / vals(pp) =  (x / p) * (p / pp) = vals(x) * vals(p)
         * For example, a / b = 2.0, b / c = 3.0,  parents(a, b) = 2.0,  parents(b, c) = 3.0, parents(a, c) = 2.0 * 3.0 = 6.0, now vals(a) = 6.0
         * So along the way, we get all the value of a / x where x is the parent of x all the way to root. In the end, only a / root(x) is saved. This is path compression.
         * It's like putting a directly under the root(x)
         */
        public String find(String x) {
            String p = parents.getOrDefault(x, x);
            if (x != p) {
                String pp = find(p);
                vals.put(x, vals.get(x) * vals.get(p));
                parents.put(x, pp);
            }
            return parents.getOrDefault(x, x);
        }

        /**
         * x / px = vals.get(x), y / py = vals.get(y), so px / py =  v * vals.get(y) / vals.get(x)
         */
        public void union(String x, String y, double v) {
            add(x);
            add(y);
            String px = find(x), py = find(y);
            parents.put(px, py);
            vals.put(px, v * vals.get(y) / vals.get(x));
        }

    }
}
