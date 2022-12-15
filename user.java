package os;

public class user {
    public static void main(String[] args) {
        ExecuteUserProgram();
    }

public static void ExecuteUserProgram()
{
    char R[] = new char[4];
    static char IR[] = new char[4];
    static char M[][] = new char[100][4];
    static int IC;
    static boolean C;

    while()
    {
        IR = M [IC];
        IC = IC+1;
        if(IR[0]=="L" && IR[1]=="R") 
            R=M[IR[2,3]];
        else if(IR[0]=="S"&&IR[1]=="R")
            R=M[IR[2,3]];
        else if(IR[0]=="C"&&IR[1]=="R") 
            if(R==M[IR[3,4]])
                C=T;
            else 
                C=F;
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
