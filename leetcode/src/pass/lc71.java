package pass;

import java.util.*;

public class lc71 {
    public String simplifyPath(String path) {
        String[] list = path.split("/");
        Deque<String> queue = new ArrayDeque<>();
        for (String word : list){
            if (word.equals("") || word.equals(".")) continue;
            if (word.equals("..")) {
                if (!queue.isEmpty()) queue.removeLast();
                continue;
            }
            queue.addLast(word);
        }
        StringBuilder sb = new StringBuilder();
        if (queue.isEmpty()) return "/";
        while (!queue.isEmpty()){
            sb.append('/');
            sb.append(queue.removeFirst());
        }
        return sb.toString();
    }
}
