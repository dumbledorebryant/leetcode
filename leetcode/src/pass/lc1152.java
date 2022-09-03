package pass;
import java.util.*;;
public class lc1152 {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<UserWebsiteVisit>> tupels = new HashMap<>();
        UserWebsiteVisit userWebsiteVisit = null;
        List<UserWebsiteVisit> list = null; 
        for(int i = 0; i < username.length; i++){
            userWebsiteVisit = new UserWebsiteVisit();
            userWebsiteVisit.website = website[i];
            userWebsiteVisit.timestamp = timestamp[i];
            if(!tupels.containsKey(username[i])){
                list = new ArrayList<>();
                tupels.put(username[i], list);
            }
            tupels.get(username[i]).add(userWebsiteVisit);
        }
        Map<String, Set<String>> map = new TreeMap<String, Set<String>>();
        List<String> result = null;
        int maxNumber = -1;
        for(Map.Entry<String,List<UserWebsiteVisit>> entry : tupels.entrySet()){
            List<UserWebsiteVisit> input = entry.getValue();
            if(input.size() < 3){
                continue;
            }
            input.sort((item1, item2) -> {
                return item1.timestamp - item2.timestamp;
            });
            dfs(input,0,new ArrayList<>(), map, entry.getKey());
         }
        
    for(Map.Entry<String, Set<String>> webEntry : map.entrySet()){
            if(maxNumber < webEntry.getValue().size()){
                maxNumber = webEntry.getValue().size();
                String[] arr = webEntry.getKey().split(",");
                result = new ArrayList<>(Arrays.asList(arr));
        }
    }
    
        return result;
}
    
public void dfs(List<UserWebsiteVisit> list, int index, List<String> webList, Map<String, Set<String>> map, String user){
    if(webList.size() == 3){
        String result = webList.get(0) + "," + webList.get(1) + "," + webList.get(2);
        if(!map.containsKey(result)){
            map.put(result,new HashSet<>());
        }
        map.get(result).add(user);
        return;
    }
     
    for(int i = index; i < list.size(); i++){
        webList.add(list.get(i).website);
        dfs(list, ++index, webList, map, user);
        if(!list.isEmpty())
        webList.remove(webList.size() - 1);
    }
  }
}


class UserWebsiteVisit { 
    public String website;
    public int timestamp;    
}
