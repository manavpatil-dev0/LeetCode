import java.util.AbstractList;
class Solution {
    private List<List<String>> myList;
    public List<List<String>> partition(String s) {
         return new AbstractList<List<String>>(){
            @Override 
            public int size(){
                init();
                return myList.size();
            }
            @Override
            public List<String> get (int i){
                init();
                return myList.get(i);
            }

            private void init(){
                if (myList != null) return;
                myList = new ArrayList<>();
                generator(new ArrayList<String>(), s, "", 0);
            }
        };
    }

    private void generator(List<String> list, String s, String a, int i){
        if (i == s.length()){
            if (!a.isEmpty() && checker(a)) {
                list.add(a);
                myList.add(new ArrayList<>(list));
                list.remove(list.size()-1);
                return;
            }
            else {
                return;
            }
        } 
        a+=s.charAt(i);
        if (checker(a)){
            list.add(a);
            generator(list, s, "", i+1);
            list.remove(list.size()-1);
        }
        generator(list, s, a, i+1);
    }

    private boolean checker(String a){
        int i = 0;
        int j = a.length()-1;
        while (i < j){
            if (a.charAt(i) != a.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}