import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MergingOverlapping {

    /**
     * [1,3],[2,6]
     *{2,4} and {1,3}
     * @param list
     */
    public void mergeOverlap(List<Intervals> list){
        List<Intervals> list1 = new LinkedList<>();
        for (int i =0; i<list.size();i++){
            for (int j =i+1;j<list.size()-1;j++){
                Intervals i1 = list.get(i);
                Intervals i2 = list.get(j);
                if (isOverlap(list.get(i),list.get(j))){
                    list1.add(new Intervals(Math.min(i1.a,i2.a),Math.max(i1.b,i2.b)));
                }
            }
        }
        for (int i =0;i<list1.size();i++){
            Intervals intervals = list1.get(i);
            System.out.println(intervals.a +","+intervals.b);
        }
    }

    public boolean isOverlap(Intervals i1, Intervals i2){
        int front = Math.max(i1.a,i2.a);
        int back = Math.min(i1.b,i2.b);
        return (back-front)>0?true:false;
    }
    public static void main(String[] args) {
        MergingOverlapping mergingOverlapping = new MergingOverlapping();
        List<Intervals> list = new LinkedList<>();
        list.add(new Intervals(6,8));
        list.add(new Intervals(1,9));
        list.add(new Intervals(2,4));
        list.add(new Intervals(4,7));
        mergingOverlapping.mergeOverlap(list);
    }
}
class Intervals{
    int a;
    int b;

    Intervals(int a, int b){
        this.a =a;
        this.b =b;
    }
}
