import java.util.*;

public class MainProgram {
    static char R[] = new char[4];
    static char IR[] = new char[4];
    static char M[][] = new char[100][4];
    // [G][D][2][0]
    static int IC;
    static boolean C;

    public static void main(String args[]) {
        IC = 0;
        int SI;
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Alpha OS!");
        System.out.println("\nFor now you can perfomr follwoing tasks:    \n 1. Read \n 2. Write \n 3. Terminate");
        System.out.print("\nEnter the task number you want to perform: ");
        SI = sc.nextInt();
        MOS(SI);
    }

    public static void MOS(int SI) {
        switch (SI) {

            case 1:
                System.out.println("Read");
                break;

            case 2:
                System.out.println("Write");
                break;

            case 3:
                System.out.println("Terminate");
                break;

            default:
                System.out.println("Invalid Choice!");
                break;
        }
    }

    public static void ExecuteUserProgram()
    {
    while(true)
    {
        // while(IC<no. of instructions)
        for(int i=0;i<4;i++)
        {
            IR[i] = M[IC][i];
            System.out.print(IR[i]);
        }
        // IR = M [IC];
        IC = IC+1;
        if(IR[0]=='L'&&IR[1]=='R') 
            R=M[IR[2],IR[3]];
        else if(IR[0]=='S'&&IR[1]=='R')
            R=M[IR[2,3]];
        else if(IR[0]=='C'&&IR[1]=='R') 
            if(R==M[IR[2],[3]])
                C=true;
            else 
                C=;
        else if(IR[0]=="B"&&IR[1]=="T")
            if(C==T) 
                IC=R [3,4];
        else if(IR[0]=="G"&&IR[1]=="D")
            SI = 1;
        else if(IR[0]=="P"&&IR[1]=="D") 
            SI = 2;
        else if(IR[0]=="H")
            SI = 3;
    }
}

}
