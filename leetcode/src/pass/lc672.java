package pass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

class lc672 {
    private final Map<List<Integer>, Set<Integer>> memo = new HashMap<>();
    public int flipLights(int n, int presses) {
        int initialState = ((int) Math.pow(2, n)) - 1;
        List<Function<Integer, Integer>> buttons = initOperations(n);
        Set<Integer> states = new HashSet<>();
        dfs(initialState, presses, buttons, states);
        return states.size();
    }

    private Set<Integer> dfs(int state, int presses, List<Function<Integer, Integer>> buttons, Set<Integer> states) {
        List<Integer> key = List.of(state, presses);
        if(memo.containsKey(key)) return memo.get(key);
        if(presses == 0) {
            states.add(state);
            memo.put(key, states);
            return states;
        }
        Set<Integer> uniqueStates = new HashSet<>();
        Set<Integer> newStates = new HashSet<>(states);
        for (Function<Integer, Integer> button: buttons) uniqueStates.add(button.apply(state));
        for(Integer newState: uniqueStates) newStates.addAll(dfs(newState, presses - 1, buttons, states));
        memo.put(key, newStates);
        return newStates;
    }

    private List<Function<Integer, Integer>> initOperations(int n) {
        List<Function<Integer, Integer>> buttons = new ArrayList<>();
        int mask = (1 << n) - 1;
        buttons.add(i-> flipBits(i, mask));
        buttons.add(i-> flipOddBits(i, mask));
        buttons.add(i-> flipEvenBits(i, mask));
        buttons.add(i-> flipLabeledBits(i, mask));
        return buttons;
    }

    private int flipBits(int state, int mask) { return (~state) & mask; }

    private int flipOddBits(int state, int mask) { return (state ^ 0x55555555) & mask; }

    private int flipEvenBits(int state, int mask) { return (state ^ 0xAAAAAAA) & mask; }

    private int flipLabeledBits(int state, int mask) { return (state ^ 0x1249249) & mask; }
}