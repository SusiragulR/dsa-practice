public class patternPrinting {
    static void printSquarePattern(int r,int c){
        for (int i=0;i<r;i++){
            for (int j=0;j<c;j++){
                System.out.print("*\t");
            }
            System.out.println();
        }
    }

    static void printTrianglePattern(int n){
        if(n%2==0){
            System.out.println("Only odd nums possible");
            return;
        }
        int r = (n+1)/2;
        int g = r-1,t=1;
        for(int i=0;i<r;i++){
            for(int j=0;j<g;j++){
                System.out.print("\t");
            }
            int k=0;
            while(k<t){
                System.out.print((k+1)+"\t");
                k++;
            }
            t+=2;
            for(int j=0;j<g;j++){
                System.out.print("\t");
            }
            g--;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printSquarePattern(5,4);

        System.out.println();
        System.out.println();

        printTrianglePattern(9);
    }
}
