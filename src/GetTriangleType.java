public class GetTriangleType {


    public enum Type{
        SCALENE, ISOCELES, EQUILATERAL, ERROR;
    }
    public Type getTriangleType (int a, int b, int c){
        if (a==b && b==c && c==a){
            return Type.EQUILATERAL;
        }else if (a==b || b==c || c==a){
            return Type.ISOCELES;
        }else if(a!=b && b!=c && c!=a){
            return Type.SCALENE;
        }else {
            return Type.ERROR;
        }
    }

    class Rec{
        int x;
        int y;

        public Rec(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    public static void findRecOverlap(Rec l1, Rec r1, Rec l2, Rec r2){

    }

    public static void main(String[] args) {

    }
}
