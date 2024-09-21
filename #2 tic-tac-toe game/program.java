import java.util.*;
import java.io.IOException;

public class program
{
    
    public static void main(String[] ar)
    {
        Scanner s=new Scanner(System.in);
        
        char board[]=new char[9];
        
        startboard(board);
        
        char x='x',o='o',cp=x;
        int move=0,pos;
        
        // run the loop 
        
        while(true)
        {
            // clear the console
            try 
            {
                clear();   
            }
            catch (IOException | InterruptedException e)
            {
                e.printStackTrace();
            }
            
            System.out.println();
            System.out.print("!! Here is a simple Tic-Tac-Toe game where you can play by entering a position to the board below. The positions are numbered from 1 to 9..");
            System.out.println();
            System.out.println();
            
            print(board);
            System.out.println();
            System.out.println("\n\t  "+cp+" turn : ");
            pos=s.nextInt();
            
            // check if user gave correct position or not
            
            while(true)
            {
                if(!check(pos,board,cp))
                {
                    break;
                }
                
                System.out.println("invalid!! again "+cp+" turn : ");
                pos=s.nextInt();
                                      
            }
            
            update(pos,board,cp);
            
            // change the player
            
            if(cp=='x')
            {
                cp=o;
            }
            else if(cp=='o')
            {
                cp=x;
            }
            
            // checking win possibilities
            
            if( checkwin(0,1,2,board)||
            checkwin(3,4,5,board)||
            checkwin(6,7,8,board)||
            checkwin(0,4,8,board)||
            checkwin(2,4,6,board)||
            checkwin(0,3,6,board)||
            checkwin(1,4,7,board)||
            checkwin(2,5,8,board))
            {
                System.out.println();
                System.out.println("continue the game ?  y/n: ");
                
                char l=s.next().charAt(0);
                
                if(l=='y')
                {
                try {
                clear(); 
            }
                    
            catch (IOException | InterruptedException e)
            {
                e.printStackTrace();
            }
                move=0;
                cp=x;
                    
                startboard(board);
                    
                }
                
                else if(l=='n')
                {
                    break;
                }
                
            }
            
                
                
            move++;
            
            // draw condition
            
            if(move>=9)
            {
                System.out.println();
                System.out.println("\t"+"xo Draw");
                
                System.out.println();
                
                System.out.println("continue the game ? y/n: ");
                
                char l=s.next().charAt(0);
                
                if(l=='y')
                {
                try 
                    {
                clear(); 
                    }
            catch (IOException | InterruptedException e)
            {
                e.printStackTrace();
            }
                    
                move=0;
                cp=x;
                    
               startboard(board);
                    
                }
                
                else if(l=='n')
                {
                    break;
                }
                
            }
            
            
        }
        
        
    }
    
    static void startboard(char b[])
    {
 
        for(int j=0;j<b.length;j++)
        {
            b[j]='-';
        }
        
    }
    
  static void print(char b[])
    {
        
        for(int i=0;i<9;i++)
        {
            System.out.print("\t"+" "+b[i]+" ");
            if(i==2 || i==5)
            {
                System.out.println();
            }
        }
    }
    
    static boolean check(int p,char b[],char cp)
    {
         int pos=p-1;
        
        if(b[pos]=='x' || b[pos]=='o' || (0>pos && pos>10) || b[pos]==cp)
        {
            return true;
        }
        
        return false;
    }
    
    static void update(int p,char b[],char cp)
    { 
        int pos=p-1;
        for(int i=0;i<9;i++)
        {
            if(pos==i) 
            {
                b[i]=cp;
            }
        }
    }   
    
    
    static boolean checkwin(int a,int b,int c,char p[])
    {
        if(p[a]==p[b] && p[b]==p[c] && p[c]==p[a] && (p[a]=='x' || p[a]=='o'))
        {
            
            System.out.println();
            System.out.println("\t"+p[a]+" win!!");
            print(p);
            System.out.println();
            return true;
            
        }   
        
        return false;        
    }
    
    public static void clear() throws IOException, InterruptedException
    {
        if (System.getProperty("os.name").contains("Windows"))
        {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        }
        else 
            
        {
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        }
    }
    
    
}