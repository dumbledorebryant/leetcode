package pass;

public class lc765 {
    int[] parent;
    int connected_comp;
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        int couple = n/2;
        connected_comp = 0;
        parent = new int[couple];
        for(int i = 0; i < couple; i++){
            parent[i] = i;
        }
        
        for(int i = 0; i < couple; i++){
            if(row[2*i] != row[2*i + 1]){
                union(row[2*i]/2, row[2*i+ 1]/2);
            }
            
        }
        
        return connected_comp;        
    }
           
    public void union(int couple_a, int couple_b){        
        int a_grp = find(couple_a); 
        int b_grp = find(couple_b); 
        if(a_grp != b_grp){
            parent[a_grp] = b_grp;  
            connected_comp++;
        }        
    }
    
    
    public int find(int node){        
        while(parent[node] != node){
            node = parent[node];
        }
                return node;
    }
}
