import java.util.*;

public class ListClientExample {
    public static void main(String[] args){
        ListClientExample lce = new ListClientExample();
        List list = lce.getList();
        System.out.println(list);
        System.out.println("sibal");
    }
    
    private List list;

    public ListClientExample(){
        list = new LinkedList();
    }    
    private List getList(){
        return list;
    }
}
