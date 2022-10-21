package pass.Company.Amazon.OOD;
import java.util.*;

public class Linux_find {
    class File {
        String name;
        int size;
        int type;
        boolean isDirectory;
        List<File> children;
    }

    abstract class Filter{
        abstract boolean apply(File file);
    }

    class SizeFilter extends Filter{
        int minSize;
        public SizeFilter(int size){
            this.minSize = size;
        }

        @Override
        boolean apply(File file){
            return file.size > minSize;
        }
    }

    class TypeFilter extends Filter{
        int type;

        public TypeFilter(int type){
            this.type = type;
        }

        @Override
        boolean apply(File file){
            return file.type == type;
        }
    }

    public List<File> findWithFilters(File dir, List<Filter> filters){
        List<File> files = new ArrayList<>();
        dfs(dir, filters, files);
        return files;
    }
    private void dfs(File dir, List<Filter> filters, List<File> files){
        if (dir.children == null){
            return;
        }

        for (File file : dir.children){
            if (file.isDirectory){
                dfs(file, filters, files);
            }
            else {
                boolean choice = true;
                for (Filter filter : filters){
                    if (!filter.apply(file)){
                        choice = false;
                        break;
                    }
                }
                if (choice) files.add(file);
            }
        }
    }
}
