package pass;

public class lc470 {
    public int rand7(){
        return 0;
    }
    public int rand10() {
        while (true){
            int internals = (rand7() - 1) * 7;
            int fillin = rand7();
            int num = fillin + internals;
            if (num <= 40) return num % 10 + 1; 
            num = (num - 1) * 7 + rand7();
            if (num <= 60) return num % 10 + 1;
            num = (num - 1) * 7 + rand7();
            if (num <= 20) return num % 10 + 1;
        }
    }
}
