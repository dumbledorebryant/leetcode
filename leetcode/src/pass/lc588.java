package pass;
import java.util.*;;
public class lc588 {
    class File{
        boolean isFile = false;
        String name;
        String content;
        Map<String, File> children = new HashMap<>();
        File(String name){
            this.name = name;
        }
        
    }
    
    File root;
    
    public lc588() {
        root = new File("");
    }
    
    public List<String> ls(String path) {
        String components[] = path.split("/");
        File currFile = root;
        for (int i = 1; i<components.length;i++){
            String currName = components[i];
            currFile = currFile.children.get(currName);
        }
        
        List<String> res = new ArrayList<String>();
        if (currFile.isFile) res.add(currFile.name);
        else{
            res.addAll(currFile.children.keySet());
            Collections.sort(res);
        }

        return res;
    }
    
    public void mkdir(String path) {
        String components[] = path.split("/");
        File currFile = root;
        for (int i = 1; i<components.length;i++){
            String currName = components[i];
            if (!currFile.children.containsKey(currName)){
                currFile.children.put(currName, new File(currName));
            }
            currFile = currFile.children.get(currName);
        }
        
    }
    
    public void addContentToFile(String filePath, String content) {
        String components[] = filePath.split("/");
        File currFile = root;
        for (int i = 1; i<components.length-1;i++){
            String currName = components[i];
            currFile = currFile.children.get(currName);
        }
        // create a new file with content
        String contentFileName = components[components.length-1];
        File contentFile = new File(contentFileName);
        contentFile.isFile = true;
        
        if (currFile.children.containsKey(contentFileName))
            contentFile.content = currFile.children.get(contentFileName).content+ content;
        else contentFile.content = content;
        currFile.children.put(contentFileName, contentFile);
    }
    
    public String readContentFromFile(String filePath) {
        String components[] = filePath.split("/");
        File currFile = root;
        for (int i = 1; i<components.length;i++){
            String currName = components[i];
            currFile = currFile.children.get(currName);
        }
        return currFile.content;
    }
}
