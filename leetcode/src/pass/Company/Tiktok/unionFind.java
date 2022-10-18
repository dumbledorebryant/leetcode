package pass.Company.Tiktok;
import java.io.*;
import java.util.Scanner;
public class unionFind {
    
}
class test {
    static class UnionFind{
        int[] parents;
        int[] nums;
        public UnionFind(int n){
            parents=new int[n];
            nums=new int[n];
            for(int i=0;i<n;i++){
                parents[i]=i;
                nums[i]=1;
            }
        }
        public int find(int x){
            if(parents[x]!=x){
                parents[x]=find(parents[x]);
            }
            return parents[x];
        }
        public boolean union(int x,int y){
            int px=find(x);
            int py=find(y);
            if(px==py) return false;
            parents[py]=px;
            nums[px]=nums[py]+nums[px];
            return true;
        }
        public int getCount(int n){
            return nums[find(n)];
        }
    }
    public static void main(String[] args){
        Scanner myObj=new Scanner(System.in);
        int t = myObj.nextInt();
        int[] max=new int[t];
        for(int i=0;i<t;i++){
            int m=myObj.nextInt();
            UnionFind union=new UnionFind(10000);
            for(int j=0;j<m;j++){
                int x=myObj.nextInt();
                int y=myObj.nextInt();
                union.union(x,y);
                max[i]=Math.max(union.getCount(x),max[i]);
            }
        }
        
        for (int i = 0; i < t; i++){
            System.out.println(max[i]);
        }
    }
}