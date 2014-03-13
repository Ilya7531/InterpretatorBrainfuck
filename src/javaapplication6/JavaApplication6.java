package javaapplication6;

public class JavaApplication6 {
    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args)  throws Exception {
        /*
        String str = "";
        for (int i=0; i<=266; ++i) {  
            str += i + "\t" + (char) i + "\n";
        }
        System.out.print(str);
        */
        BrainfuckEngine bf = new BrainfuckEngine(30000);
       
        bf.interpret(
        "++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.>."
        );
    }
    
}
