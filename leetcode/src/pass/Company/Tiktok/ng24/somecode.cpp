/******************************************************************************

                              Online C++ Compiler.
               Code, Compile, Run and Debug C++ program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
#define INT_MAX 1000000000
long getRes(const vector<int>& cost, const vector<int>& comp1, const vector<int>& comp2, int minComp)
{
    long len = cost.size();
    long res{};
    if(len < minComp) return -1;
    vector<int> cluster1{};
    vector<int> cluster2{};
    vector<int> clusterb{};
    vector<vector<int>> vec(len);
    for(long i=0; i<len; i++)
    {
        vec[i] = {cost[i], comp1[i], comp2[i]}; // {{cost, comp1, comp2}, ....}
    }
    sort(vec.begin(), vec.end()); //
    for(long i=0; i<len; i++)
    {
        if(vec[i][1]==1 && vec[i][2]==1)
        {
            clusterb.push_back(vec[i][0]);
        }else if(vec[i][1]==1)
        {
            cluster1.push_back(vec[i][0]);
         
        }else if(vec[i][2]==1)
        {
            cluster2.push_back(vec[i][0]);
        }
    }
    if(cluster1.size()+clusterb.size()<minComp || cluster2.size()+clusterb.size()<minComp) return -1;
    int idx1{}; int idx2{}; int bidx{};
    int forCluster1 = 0;
    int forCluster2 = 0;
    while(forCluster1<minComp || forCluster2 <minComp)
    {
        if(forCluster1<minComp && forCluster2<minComp )               // we need 2 for per cluster
        {
            long for1 = idx1<cluster1.size()? cluster1[idx1]:INT_MAX; //INT_MAX
            long for2 = idx2<cluster2.size()? cluster2[idx2]:INT_MAX; // 3 , ...
            long forb = bidx<clusterb.size()? clusterb[bidx]:INT_MAX; // 4 ,
            if(for1+for2<forb)
            {
                
                res += (for1+for2);
                idx1++; idx2++;
            }else
            {
                res+= forb;
                bidx++;
            }
            forCluster1++;
            forCluster2++;
        }
        // else if(forCluster1<minComp)
        // {
        //     long for1 = idx1<cluster1.size()? cluster1[idx1]:INT_MAX;
        //     long forb = bidx<clusterb.size()? clusterb[bidx]:INT_MAX;
        //     if(for1<forb)
        //     {
                
        //         res += for1;
        //         idx1++;
        //     }else
        //     {
        //         res+= forb;
        //         bidx++;
        //     }
        //     forCluster1++;
        // }else if (forCluster2<minComp) {
        //     long for2 = idx2<cluster2.size()? cluster2[idx2]:INT_MAX;
        //     long forb = bidx<clusterb.size()? clusterb[bidx]:INT_MAX;
        //     if(for2<forb)
        //     {
                
        //         res += for2;
        //         idx2++;
        //     }else
        //     {
        //         res+= forb;
        //         bidx++;
        //     }
        //     forCluster2++;
        // }
    }
    return res;
}

vector<int>  cost{2,4,6,5};
vector<int> comp1{0,0,1,1};
vector<int> comp2{1,1,1,1};
int minComp = 2;

// vector<int>  cost{0,6,4};
// vector<int> comp1{0,1,1};
// vector<int> comp2{1,0,1};
// int minComp = 2;

int main()
{
    cout<<getRes(cost, comp1, comp2, minComp);

    return 0;
}
