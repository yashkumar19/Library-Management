import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
class Library {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        while(true){
            System.out.println("Enter the 1 to proceed ");
            System.out.println("Enter anything to exit ");
            System.out.println("Enter the choice:- ");
            int choice = scn.nextInt();
            if(choice==1){
                System.out.println("Enter the no. of Books");
                int N = scn.nextInt();
                System.out.println("Enter the no. of racks");
                int K = scn.nextInt();
                Book lib =new Book(N,K);
            }
            else{
                break;
            }
        }
    }
}
class Book{
    final int N;
    final int K;
    public String ISBN(){
        Random rand = new Random();
        int code1 = rand.nextInt(999999);
        int code2 = rand.nextInt(9999999);
        String isbn1 =  String.format("%06d", code1);
        String isbn2 =  String.format("%06d", code1);
        String isbn = isbn1+isbn2;
        return isbn;
    }
    public Book(int N, int K) {
        Scanner scn = new Scanner(System.in);
        this.N = N;
        this.K = K;
        int slot = N/K;
        ArrayList<String> book = new ArrayList<String>();
        ArrayList<String> ISBN = new ArrayList<String>();
        ArrayList<String> barcode = new ArrayList<String>();
        for(int i = 0; i < N; i++){
            System.out.println("Enter the Book Title:- ");
            book.add(scn.nextLine());
            ISBN.add(ISBN());
            barcode.add(ISBN());
        }
        sorting sor = new sorting(book,ISBN,barcode,N,K,slot);
    }
}
class sorting{
    String help;
    public  sorting(ArrayList<String> book, ArrayList<String> ISBN, ArrayList<String> barcode, int N,int K,int slot) {
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (book.get(i).compareTo(book.get(j)) > 0) {
                    help = book.get(i);
                    book.set(i, book.get(j));
                    book.set(j,help);
                    help = ISBN.get(i);
                    ISBN.set(i, ISBN.get(j));
                    ISBN.set(j,help);
                    help = barcode.get(i);
                    barcode.set(i, barcode.get(j));
                    barcode.set(j,help);
                }
            }
        }
        for(int m =0; m<N;m++){
            for(int n=m+1;n<N;n++){
                if(book.get(m).equals(book.get(n))){
                    for (int i = 0; i < N; i++) {
                        for (int j = i + 1; j < N; j++) {
                            if (ISBN.get(i).compareTo(ISBN.get(j)) > 0) {
                                help = book.get(i);
                                book.set(i, book.get(j));
                                book.set(j,help);
                                help = ISBN.get(i);
                                ISBN.set(i, ISBN.get(j));
                                ISBN.set(j,help);
                                help = barcode.get(i);
                                barcode.set(i, barcode.get(j));
                                barcode.set(j,help);
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (book.get(i).compareTo(book.get(j)) > 0) {
                    help = book.get(i);
                    book.set(i, book.get(j));
                    book.set(j,help);
                    help = ISBN.get(i);
                    ISBN.set(i, ISBN.get(j));
                    ISBN.set(j,help);
                    help = barcode.get(i);
                    barcode.set(i, barcode.get(j));
                    barcode.set(j,help);
                }
            }
        }
        for(int m =0; m<N;m++){
            for(int n=m+1;n<N;n++){
                if(ISBN.get(m).equals(ISBN.get(n))){
                    System.out.println(ISBN.get(m));
                    System.out.println(ISBN.get(n));
                    for (int i = 0; i < N; i++) {
                        for (int j = i + 1; j < N; j++) {
                            if (barcode.get(i).compareTo(barcode.get(j)) > 0) {
                                help = book.get(i);
                                book.set(i, book.get(j));
                                book.set(j,help);
                                help = ISBN.get(i);
                                ISBN.set(i, ISBN.get(j));
                                ISBN.set(j,help);
                                help = barcode.get(i);
                                barcode.set(i, barcode.get(j));
                                barcode.set(j,help);
                            }
                        }
                    }
                }
            }
        }
        int a=0;
        for(int i=0;i<K;i++){
            for(int j =0;j<slot;j++){
                System.out.println("Rack"+i+" "+j);
                System.out.println("The book title "+book.get(a));
                System.out.print("ISBN NO ");
                System.out.println(ISBN.get(a));
                System.out.print("Barcode NO ");
                System.out.println(barcode.get(a));
                a++;
            }
        }
    }
}