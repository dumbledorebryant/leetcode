package pass;

public class lc434 {
    public int countSegments(String s) {
        if (s.length() == 0) return 0;
        String[] items = s.split(" ");
        int count = 0;
        int length = items.length;
        for (int i = 0; i < length; i++){
            if (!items[i].equals("")) {
                count++;
                System.out.println(items[i]);
            }
        }
        return count;
    }

    public void test(){
        countSegments(", , , ,        a, eaefa");
    }
}
