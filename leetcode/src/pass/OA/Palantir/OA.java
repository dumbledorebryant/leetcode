package pass.OA.Palantir;
import java.util.*;

public class OA {
    static class question1{
        public static List<String> tasksToRun(List<String> taskDefinitionsInput, List<String> changedFiles) {
            // Write your code here
            Set<String> set = new HashSet<>();
            for (String file : changedFiles){
                set.add(file);
            }
            int length = taskDefinitionsInput.size();
            List<String> rerun = new ArrayList<>();
            for (int i = 0; i < length; i += 4){
                String task = taskDefinitionsInput.get(i).split(" ")[1];
                String[] files = taskDefinitionsInput.get(i + 1).substring(7).split(" ");
                for (String file : files){
                    if (set.contains(file)){
                        rerun.add(task);
                    }
                }
            }
                
            return rerun;
        }
    }
    static class question2 {
        static Map<String, Boolean> visited = new HashMap<>();
        static List<String> postorder = new ArrayList<>();
        static Set<String> changeSet = new HashSet<>();
    
    public static List<String> tasksToRun(List<String> taskDefinitionsInput, List<String> changedFiles){
        Set<String> set = new HashSet<>();
        for (String file : changedFiles){
            set.add(file);
        }

        int length = taskDefinitionsInput.size();
        Map<String, List<String>> map = new HashMap<>();
       
        for (int i = 0; i < length; i += 4){
            String task = taskDefinitionsInput.get(i).split(" ")[1];
            String[] files = taskDefinitionsInput.get(i + 1).substring(7).split(" ");
            String check = taskDefinitionsInput.get(i + 2);
            
            for (String file : files){
                if (set.contains(file)){
                    changeSet.add(task);
                    
                    if (check.equals("deps:")) continue;
                    String[] deps = check.substring(6).split(" ");
                    
                    for (String dep : deps){
                        if (!map.containsKey(dep)){
                            map.put(dep, new ArrayList<>());
                        }
                        map.get(dep).add(task);
                    }
                }
            }            
        }
        
        for (String key : changeSet){
            System.out.println("set:" + key);
            traverse(map, key);
        }
        
        Collections.reverse(postorder);
        
        return postorder;
    }
    public static void traverse(Map<String, List<String>> map, String k){
        if (visited.containsKey(k) && visited.get(k) == true) return;
        visited.put(k, true);
        if (!map.containsKey(k)){
            System.out.println(k);
            postorder.add(k);
            return;
        } 
        for (String next : map.get(k)){
            traverse(map, next);
        }
        System.out.println(k);
        postorder.add(k);
        return;
    }

    static class question3{
        static Map<String, Boolean> visited = new HashMap<>();
    static List<String> postorder = new ArrayList<>();
    static Set<String> changeSet = new HashSet<>();
    
    public static List<String> tasksToRun(List<String> taskDefinitionsInput, List<String> changedFiles){
        Set<String> set = new HashSet<>();
        for (String file : changedFiles){
            set.add(file);
        }

        int length = taskDefinitionsInput.size();
        Map<String, List<String>> map = new HashMap<>();
       
        for (int i = 0; i < length; i += 4){
            String task = taskDefinitionsInput.get(i).split(" ")[1];
            String[] files = taskDefinitionsInput.get(i + 1).substring(7).split(" ");
            String check = taskDefinitionsInput.get(i + 2);
            
            for (String file : files){
                for (String t : set){
                    if (validate(file, t)){
                        changeSet.add(task);
                    
                        if (check.equals("deps:")) continue;
                        String[] deps = check.substring(6).split(" ");
                    
                        for (String dep : deps){
                            if (!map.containsKey(dep)){
                                map.put(dep, new ArrayList<>());
                            }
                            map.get(dep).add(task);
                        }
                    }
                    
                }
            }            
        }
        
        for (String key : changeSet){
            System.out.println("set:" + key);
            traverse(map, key);
        }
        
        Collections.reverse(postorder);
        
        return postorder;
    }
    public static void traverse(Map<String, List<String>> map, String k){
        if (visited.containsKey(k) && visited.get(k) == true) return;
        visited.put(k, true);
        if (!map.containsKey(k)){
            System.out.println(k);
            postorder.add(k);
            return;
        } 
        for (String next : map.get(k)){
            traverse(map, next);
        }
        System.out.println(k);
        postorder.add(k);
        return;
    }
    
    public static boolean validate(String glob, String file){
        if (glob.isEmpty() && file.isEmpty()) return true;
        if (glob.isEmpty()) return false;
        if (file.isEmpty()){
            if (glob.equals("*")) return true;
            return false;
        }
        if (glob.charAt(0) == '*'){
            String globSliced = glob.substring(1);
            
            if (validate(globSliced, file)) return true;
            if (file.charAt(0) == '/') return false;
            String fileSliced = file.substring(1);
            if (validate(glob, fileSliced)) return true;
            return false;
        }
        if (glob.charAt(0) == file.charAt(0)){
            String globSliced = glob.substring(1);
            String fileSliced = file.substring(1);
            return validate(globSliced, fileSliced);
        }
        return false;
    }
    }
    
}


class question3 {
    Map<String, Boolean> visited = new HashMap<>();
    List<String> postorder = new ArrayList<>();
    public String[] runTasks(String[] taskDefInput, String[] changed){
        Set<String> set = new HashSet<>();
        for (String file : changed){
            set.add(file);
        }

        int length = taskDefInput.length;
        Map<String, List<String>> map = new HashMap<>();
        
        for (int i = 0; i < length; i += 4){
            String task = taskDefInput[i].split(" ")[1];
            String[] files = taskDefInput[i + 1].substring(7).split(" ");
            String[] deps = taskDefInput[i + 2].substring(6).split(" ");
            
            for (String patern : files){
                for (String file : set){
                    if (validate(patern, file)){
                        for (String dep : deps){
                            if (!map.containsKey(dep)){
                                map.put(dep, new ArrayList<>());
                            }
                            map.get(dep).add(task);
                        }
                        break;
                    }   
                }
            }            
        }
        
        for (String key : map.keySet()){
            traverse(map, key);
        }
        int size = postorder.size();
        Collections.reverse(postorder);
        String[] ans = new String[size];
        for (int i = 0; i < size; i++){
            ans[i] = postorder.get(i);
        }
        return ans;
    }
    public void traverse(Map<String, List<String>> map, String k){
        if (visited.get(k) == true) return;
        visited.put(k, true);
        if (!map.containsKey(k)){
            postorder.add(k);
            return;
        } 
        for (String next : map.get(k)){
            traverse(map, next);
        }
        postorder.add(k);
        return;
    }

    public boolean validate(String glob, String file){
        if (glob.isEmpty() && file.isEmpty()) return true;
        if (glob.isEmpty()) return false;
        if (file.isEmpty()){
            if (glob.equals("*")) return true;
            return false;
        }
        if (glob.charAt(0) == '*'){
            String globSliced = glob.substring(1);
            if (file.charAt(0) == '/') return false;
            if (validate(globSliced, file)) return true;
            String fileSliced = file.substring(1);
            if (validate(glob, fileSliced)) return true;
            return false;
        }
        if (glob.charAt(0) == file.charAt(0)){
            String globSliced = glob.substring(1);
            String fileSliced = file.substring(1);
            return validate(globSliced, fileSliced);
        }
        return false;
    }
}}
