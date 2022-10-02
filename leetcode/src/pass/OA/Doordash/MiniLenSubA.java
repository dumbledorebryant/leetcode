package pass.OA.Doordash;
import java.util.*;
public class MiniLenSubA {
    /*
     * Complete the 'findMinimumLengthSubarray' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY arr
     *  2. INTEGER k
     */

    public int findMinimumLengthSubarray(List<Integer> arr, int k) {
        // Write your code here
        int ans = Integer.MAX_VALUE;
        Map<Integer,Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int length = arr.size();
        while(r < length){
            int right = arr.get(r);
            map.put(right, map.getOrDefault(right, 0) + 1);
            r++;
                
            if (map.size() < k){
                continue;
            }
                
            while(map.size() == k){
                int curlen = r - l;
                if (curlen == k){
                    return k;
                }
                ans = Math.min(ans, curlen);
                
                if (map.get(arr.get(l)) == 1){
                    map.remove(arr.get(l));
                }
                else {
                    map.put(arr.get(l), map.get(arr.get(l)) - 1);
                }
                
                ++l;
            }
            
        }
        if (ans == Integer.MAX_VALUE) return -1;
        return ans;      
    }
    public static void main(String[] args) {
        int[] arr = {841, 894, 877, 864, 897, 820, 832, 837, 807, 802, 857, 894, 835, 870, 838, 860, 897, 900, 805, 876, 838, 808, 816, 861, 845, 877, 806, 889, 886, 831, 888, 848, 813, 893, 875, 838, 893, 825, 880, 899, 898, 878, 830, 842, 857, 817, 896, 895, 825, 812, 894, 857, 881, 835, 805, 874, 889, 845, 818, 869, 867, 867, 811, 896, 823, 859, 897, 873, 826, 868, 877, 850, 819, 817, 879, 854, 876, 864, 869, 898, 809, 842, 848, 861, 870, 819, 849, 879, 880, 881, 895, 896, 839, 863, 892, 881, 885, 898, 800, 861, 857, 830, 836, 844, 819, 838, 822, 870, 804, 875, 830, 894, 834, 859, 883, 815, 828, 881, 887, 851, 834, 842, 842, 900, 863, 855, 810, 829, 832, 838, 823, 866, 820, 836, 842, 891, 878, 864, 806, 848, 878, 883, 801, 841, 882, 850, 828, 844, 838, 823, 808, 873, 801, 850, 834, 879, 848, 843, 872, 857, 811, 842, 849, 872, 850, 821, 865, 883, 885, 878, 857, 881, 835, 896, 868, 857, 864, 802, 825, 809, 826, 853, 876, 876, 824, 891, 897, 813, 845, 868, 857, 864, 874, 864, 864, 874, 840, 847, 829, 895, 811, 845, 830, 808, 808, 900, 825, 848, 816, 895, 900, 844, 877, 896, 844, 889, 868, 890, 834, 852, 837, 807, 826, 890, 810, 811, 871, 853, 869, 862, 855, 833, 849, 836, 886, 831, 880, 870, 810, 847, 865, 875, 856, 806, 838, 834, 866, 871, 825, 834, 849, 813, 837, 816, 838, 859, 826, 819, 844, 856, 845, 807, 894, 888, 823, 873, 807, 872, 850, 803, 804, 847, 859, 890, 860, 812, 850, 822, 865, 884, 885, 893, 836, 804, 805, 835, 847, 881, 894, 821, 803, 867, 805, 877, 809, 831, 860, 800, 836, 851, 849, 886, 883, 845, 832, 814, 835, 801, 860, 889, 898, 815, 862, 810, 856, 887, 846, 818, 891, 883, 805, 845, 855, 838, 820, 886, 897, 876, 836, 851, 825, 849, 819, 812, 850, 825, 800, 849, 850, 893, 835, 822, 812, 827, 840, 835, 801, 869, 847, 877, 838, 802, 841, 845, 852, 878, 898, 816, 818, 825, 861, 873, 895, 817, 812, 871, 837, 888, 808, 826, 827, 883, 860, 801, 894, 823, 866, 809, 894, 808, 873, 818, 801, 841, 860, 854, 891, 867, 827, 816, 858, 853, 824, 802, 836, 831, 839, 846, 847, 829, 819, 895, 844, 809, 898, 848, 809, 900, 810, 897, 898, 841, 873, 896, 888, 821, 894, 833, 884, 836, 823, 845, 824, 871, 808, 900, 896, 817, 900, 801, 835, 861, 879, 804, 899, 900, 853, 867, 815, 880, 877, 865, 896, 856, 833, 877, 819, 802, 871, 812, 894, 819, 833, 871, 833, 888, 815, 896, 816, 831, 857, 855, 863, 843, 859, 853, 868, 832, 880, 807, 889, 847, 820, 895, 834, 843, 874, 867, 833, 900, 881, 892, 893, 885, 875, 832, 890, 804, 869, 821, 883, 869, 870, 861, 880, 849, 882, 850, 842, 894, 845, 818, 852, 900, 833, 850, 839, 805, 816, 868, 859, 872, 888, 864, 874, 858, 867, 861, 848, 888, 822, 862, 882, 885, 867, 861, 838, 800, 817, 802, 874, 843, 856, 808, 823, 866, 880, 882, 844, 892, 865, 878, 870, 842, 848, 816, 801, 832, 837, 897, 870, 870, 820, 855, 815, 830, 801, 874, 860, 863, 837, 868, 879, 880, 811, 867, 894, 825, 808, 868, 881, 840, 834, 874, 806, 870, 803, 846, 819, 890, 864, 851, 877, 811, 843, 871, 848, 802, 813, 823, 805, 870, 879, 822, 841, 841, 819, 892, 850, 844, 872, 837, 875, 900, 817, 844, 885, 862, 822, 882, 836, 866, 832, 814, 868, 866, 850, 834, 829, 859, 819, 836, 805, 865, 899, 866, 842, 877, 865, 829, 830, 845, 813, 838, 856, 873, 810, 857, 829, 802, 889, 899, 836, 819, 870, 890, 827, 885, 829, 819, 887, 888, 874, 893, 894, 859, 898, 857, 894, 866, 895, 864, 889, 811, 897, 823, 852, 829, 873, 900, 849, 846, 844, 882, 826, 810, 865, 814, 812, 856, 867, 815, 885, 817, 803, 848, 877, 856, 811, 879, 880, 832, 817, 809, 859, 899, 840, 853, 862, 863, 832, 853, 862, 869, 807, 851, 838, 892, 877, 831, 872, 811, 873, 887, 900, 818, 845, 822, 857, 842, 867, 843, 869, 867, 808, 855, 837, 861, 885, 860, 874, 803, 896, 897, 814, 891, 835, 803, 846, 829, 889, 822, 851, 895, 815, 825, 889, 803, 883, 898, 898, 848, 863, 803, 878, 805, 821, 808, 824, 843, 883, 900, 825, 819, 878, 832, 887, 850, 884, 894, 847, 886, 846, 859, 834, 855, 897, 814, 877, 853, 869, 862, 858, 893, 868, 833, 800, 820, 898, 805, 838, 841, 850, 847, 806, 845, 810, 830, 837, 854, 865, 808, 843, 804, 804, 854, 872, 864, 837, 834, 839, 810, 891, 862, 858, 832, 872, 849, 857, 834, 851, 837, 812, 886, 832, 895, 876, 804, 878, 852, 862, 891, 838, 822, 837, 879, 893, 843, 894, 846, 852, 833, 807, 848, 823, 879, 816, 895, 862, 842, 838, 800, 889, 856, 894, 891, 810, 837, 877, 867, 829, 834, 819, 859, 870, 894, 824, 881, 873, 810, 866, 817, 897, 831, 866, 825, 846, 808, 828, 844, 840, 867, 857, 886, 864, 899, 806, 864, 848, 863, 852, 870, 895, 860, 897, 849, 873, 874, 844, 841, 801, 847, 803, 871, 800, 852, 812, 896, 813, 875, 828, 826, 829, 868, 898, 824, 841, 834, 820, 804, 806, 814, 866, 821, 834, 817, 884, 881, 860, 811, 836, 871, 828, 870, 856, 846, 821, 868, 883, 804, 820, 863, 826, 808, 812, 817, 851, 874, 816, 889, 849, 823, 834, 900, 862, 818, 872, 809, 859, 811, 819, 839, 859, 825, 893, 819, 859, 800, 888, 881, 822, 861, 802, 894, 835, 878, 813, 843, 831, 836, 858, 804, 900, 855, 893, 805, 873, 803, 854, 839, 838, 858, 801, 882, 816, 812, 837, 844, 870, 868};
        int[] arr2 = {3,2,3,3,1,3};
        List<Integer> list = new ArrayList<>();
        for (int num : arr){
            list.add(num);
        }

        MiniLenSubA ml = new MiniLenSubA();
        int k = 19;
        int k2 = 3;
        System.out.println(ml.findMinimumLengthSubarray(list, k));
    }
}