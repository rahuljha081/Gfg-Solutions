class Solution {
    public String findOrder(String[] words) {
        // code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        boolean present[]=new boolean[26];
        for(int i=0;i<words.length;i++){
            for(int j=0;j<words[i].length();j++){
                char ch1=words[i].charAt(j);
                int index=ch1-'a';
                present[index]=true;
            }
        }
        String res="";
        for(int i=0;i<26;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<words.length-1;i++){
            String s1=words[i];
            String s2=words[i+1];
            int n=s1.length();
            int m=s2.length();
            int j=0;
            boolean found=false;
            while(j<n&&j<m){
                if(s1.charAt(j)!=s2.charAt(j)){
                    int from=s1.charAt(j)-'a';
                    int to=s2.charAt(j)-'a';
                    adj.get(from).add(to);
                    found =true;
                    break;
                }else{
                    j++;
                }
            }
            if(found==false&&n>m){
                return "";
            }
        }
        int indegree[]=new int[adj.size()];
        for(int i=0;i<adj.size();i++){
            for(int j=0;j<adj.get(i).size();j++){
                indegree[adj.get(i).get(j)]++;
            }
        }
        for(int i=0;i<indegree.length;i++){
            if(present[i]==true&&indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int val=q.poll();
            char ch=(char)('a'+val);
            res+=ch;
            for(int i=0;i<adj.get(val).size();i++){
                int neigh=adj.get(val).get(i);
                indegree[neigh]--;
                if(indegree[neigh]==0){
                    q.add(neigh);
                }
            }
        }
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]!=0) return "";
        }
        return res;
    }
}