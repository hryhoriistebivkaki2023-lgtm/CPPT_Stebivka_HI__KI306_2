import java.io.*; 
import java.util.*; 

/** 
 * Клас Lab1 реалізує приклад програми до лабораторної роботи №1  
 */ 
public class HelloStebivkaKI306  
{ 
    /** 
     * Статичний метод main є точкою входу в програму 
     *  
     * @param args 
     * @throws FileNotFoundException 
     */ 
    public static void main(String[] args) throws FileNotFoundException 
    { 
        int nRows; 
        char[][] arr; 
        String filler; 
        Scanner in = new Scanner(System.in); 
        File dataFile = new File("MyFile.txt"); 
        PrintWriter fout = new PrintWriter(dataFile); 

        System.out.print("Введіть розмір квадратної матриці: "); 
        nRows = in.nextInt(); 
        in.nextLine(); 

        arr = new char[nRows][nRows]; 

        System.out.print("\nВведіть символ-заповнювач: "); 
        filler = in.nextLine(); 

        if (filler.length() == 0) {
            System.out.println("Не введено символ заповнювач"); 
            return; 
        } 
        else if (filler.length() > 1) {
            System.out.println("Забагато символів заповнювачів"); 
            return; 
        } 

        char symbol = filler.charAt(0);

        
        for (int i = 0; i < nRows; i++) {
            Arrays.fill(arr[i], ' ');
        }

        
        for (int i = 0; i < nRows; i++) {
            int stars;
            int spaces;

            if (nRows % 2 == 1) {
                
                if (i <= nRows / 2) { 
                    stars = nRows - 2 * i;
                    spaces = i;
                } else { 
                    stars = 2 * (i - nRows / 2) + 1;
                    spaces = nRows - i - 1;
                }
            } else {
                
                if (i < nRows / 2) { 
                    stars = nRows - 2 * i;
                    spaces = i;
                } else { 
                    stars = 2 * (i - nRows / 2 + 1);
                    spaces = nRows - i - 1;
                }
            }

            for (int j = 0; j < stars; j++) {
                arr[i][spaces + j] = symbol;
            }
        }

       
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nRows; j++) {
                System.out.print(arr[i][j]);
                fout.print(arr[i][j]);
            }
            System.out.println();
            fout.println();
        }

        fout.flush(); 
        fout.close(); 
    } 
}
