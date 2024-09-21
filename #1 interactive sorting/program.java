import java.util.*;

public class program
{
    public static void main(String[] ar) 
    {
        Scanner s=new Scanner(System.in);
        
        System.out.print("!! please press enter key with empty space if given values are enough");
        System.out.println();
        System.out.println();
        
        //define array for getting values
        List <String> a=new ArrayList<>(); 
        
        // define two seperate array for greater and smaller string
        List<String> big=new ArrayList<>();
        List<String> small=new ArrayList<>();
        
        int i=0,l=0,k=0;
        
        //to getting the String arrays until user stops
        
        for(;i<100;i++)
        {
            String a1=s.nextLine();
            a.add(a1);
            if(a1.isEmpty())break;
        }
        
        
        
        for(;k<a.size()-2;k++)
        {
            System.out.print(a.get(k)+" ? "+ a.get(k+1)+": "); //show the possible comparision of two strings 
            char c=s.next().charAt(0);
            if(c=='<')
            {
                small.add(a.get(k)); // add the greater
                
                big.add(a.get(k+1)); // add the smaller
            }
            else if(c=='>')
            {
                small.add(a.get(k+1));
                big.add(a.get(k));
            
            }
        }
        
        //combine both big and small string arrays
        
        List <String> co=new ArrayList<>(big);
        co.addAll(small);
        
        
        
        for(;l<co.size()-1;l++)
        {
            if(!isequal(co.get(l),co.get(l+1),a,co))
               
            {
                System.out.println(co.get(l)+" ? "+co.get(l+1)+": ");
                char c1=s.next().charAt(0);
                if(c1=='<')
                {
                    swap(l,l+1,co); // swap the Strings
                }
            }
        }
        
        //remove the duplicate Strings
        
        Set <String> un=new LinkedHashSet<>(co);
        System.out.println();
        System.out.print("Sorting order : ");
        for(String so:un)
        {
            System.out.print(so+" ");
        }
        
        
    }
    
    static boolean isequal(String e,String e1,List<String> a, List<String> co)
    {
        int i;
        for(i=0;i<a.size()-1;i++)
        {
            if((e.equals(a.get(i)) && e1.equals(a.get(i+1))) || 
                (e1.equals(a.get(i)) && e.equals(a.get(i+1))))
            {
                
                
                return true;
            }
        }
        if(e.equals(e1))
        {
            co.remove(e1);
        return true;
            
        }
        
        return false;
    }
    
   static void swap(int s,int s1,List<String> a)
    {
      String temp=a.get(s);
        a.set(s,a.get(s1));
        a.set(s1,temp);
    }
}