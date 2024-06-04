import java.io.*;
import java.util.*;

public class tree {
    private static Map<String,String>childToParent =new HashMap<>();
    private static Map<String,Integer>findAncestor(String name){
        int level =0;
        Map<String,Integer>result = new HashMap<>();
        while(childToParent.containsKey(name)){
            String parent= childToParent.get(name);
            result.put(parent,level);
            name = parent;
            level++;
        }
        return result;
    }
    private static String findRelationShip(String name1, String name2){
        if(childToParent.get(name1)!=null && childToParent.get(name2)!=null && childToParent.get(name1).equals(childToParent.get(name2))){
            return "sibling";
        }
        if(childToParent.get(name1)!=null && childToParent.get(name1).equals(name2)){
            return "child";
        }
        if(childToParent.get(name2)!=null && childToParent.get(name2).equals(name1)){
            return "parent";
        }

        Map<String, Integer> ancestor1 = findAncestor(name1);
        String result="";
        if(ancestor1.containsKey(name2)){
            Integer lv = ancestor1.get(name2);
            for(int i = 0; i<lv-1;i++)
                result+="great ";
            result+="grand child";
            return result;
        }

        Map<String, Integer> ancestor2 = findAncestor(name2);
        if(ancestor2.containsKey(name1)){
            Integer lv = ancestor2.get(name1);
            for(int i = 0; i<lv-1;i++)
                result+="great ";
            result+="grand parent";
            return result;
        }
        Set<String>commonAncestor = new HashSet<>(ancestor1.keySet());
        commonAncestor.retainAll(ancestor2.keySet());

        if(!commonAncestor.isEmpty()){
            String commonAnc = commonAncestor.stream().min(
                    Comparator.comparingInt(anc -> Math.max(ancestor1.get(anc), ancestor2.get(anc)))).get();
            int levelOfOne = ancestor1.get(commonAnc);
            int levelOfTwo = ancestor2.get(commonAnc);
            int n = Math.min(levelOfOne,levelOfTwo);
            int m = Math.abs(levelOfOne-levelOfTwo);
            if(m==0)
                return n+" cousin";

            return n+" cousin removed "+m;

        }
        return "no relation";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("tree.inp"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("tree.out"));
        String line;
        boolean inputChange = false;
        ArrayList<String[]>queries = new ArrayList<>();
        while((line = br.readLine())!=null){
            if(!inputChange){
                if(line.trim().equals("no.child no.parent")){
                    inputChange=true;
                }else {
                    StringTokenizer st = new StringTokenizer(line);
                    String child = st.nextToken();
                    String parent = st.nextToken();
                    childToParent.put(child,parent);
                }

            }else{
                StringTokenizer st = new StringTokenizer(line);
                String child=st.nextToken();
                String parent = st.nextToken();
                queries.add(new String[]{child,parent});
            }

        }
        for(String[] query : queries){
           bw.write(findRelationShip(query[0],query[1])+"\n");
        }

        bw.close();


    }
}
