package com.algos.interview;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AlternativeParity {
    public static void main(String[] args) {
        System.out.println(alternatingParityPermutations(3));
    }

        static List<List<Integer>> perms = new ArrayList();

        public static List<List<Integer>> alternatingParityPermutations(int n) {
            int[] arr = new int[n+1];
            for(int i=1;i<=n;i++){
                arr[i] = i;
            }
            List<Integer> perm = new ArrayList();
            Set<Integer> indexSet = new HashSet<>();
            heapPermutation(arr, perm, indexSet,0 );
            return perms;
        }

        static void heapPermutation(int[] a, List<Integer> perm, Set<Integer> indexSet, int index)
        {
            if (perm.size() == a.length-1){
                perms.add(perm);
            }else {
                for (int i=1; i<a.length; i++)
                {
                    if(!indexSet.contains(i) && (index == 0 || (index%2==1 && i%2==0) || (index%2==0 && i%2==1))){
                        List<Integer> temP =  new ArrayList<>(perm);
                        Set<Integer> tempI = new HashSet<>(indexSet);
                        temP.add(a[i]);
                        tempI.add(i);
                        heapPermutation(a, temP, tempI, i);
                        i=index==0?i:i+1;
                    }
                }
            }
        }





    }

    /*public class Solution {
        public static void main(String[] args) throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<List<Integer>> result = Result.alternatingParityPermutations(n);

            result.stream()
                    .map(
                            r -> r.stream()
                                    .map(Object::toString)
                                    .collect(joining(" "))
                    )
                    .map(r -> r + "\n")
                    .collect(toList())
                    .forEach(e -> {
                        try {
                            bufferedWriter.write(e);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    });

            bufferedReader.close();
            bufferedWriter.close();
        }
    }

}*/
