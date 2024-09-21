#include<stdio.h>
#include<stdlib.h>

void print(char b[]);
int checkwin(int a,int b,int c,char p[]);
int check(int p,char b[],char cp);
void update(int p,char b[],char cp);
void startboard(char b[]);



int main()
{
    char b[9];

    char x='x',o='o',cp=x;
    int m=0,pos;

    startboard(b);

    while(1)
    {
        system("clear");
        
        printf("\n");
        printf("Here is a simple Tic-Tac-Toe game where you can play by entering a position to the board below. The positions are numbered from 1 to 9.");
        printf("\n");
        printf("\n");
        
        print(b);
        printf("\n");

        printf("\n \t %c Turn : ",cp);

        scanf("%d",&pos);

        while(1)
        {
            if(!check(pos,b,cp))
                break;


            printf("\n \t invalid again %c Turn : ",cp);
            scanf("%d",&pos);


        }

        update(pos-1,b,cp);

        if(cp=='x')
        {
            cp=o;
        }
        else if(cp=='o')
        {
            cp=x;

        }

        if( checkwin(0,1,2,b)||
                checkwin(3,4,5,b)||
                checkwin(6,7,8,b)||
                checkwin(0,4,8,b)||
                checkwin(2,4,6,b)||
                checkwin(0,3,6,b)||
                checkwin(1,4,7,b)||
                checkwin(2,5,8,b))
        {
             printf("\n");
             
            printf("continue the game? y/n :");
            
            char g;
            scanf(" %c",&g);
            
            if(g=='y')
            {
                m=0;
                cp=x;
                system("clear");
                startboard(b);
            }
            else if(g=='n')
            {
                break;
            }

        }


        m++;

        if(m>=9)
        {
            printf("\n \t xo draw!!!");
            printf("\n");
            printf("\n");
            printf("continue the game? y/n");
            char g;
            scanf(" %c",&g);
            
            if(g=='y')
            {
                m=0;
                cp=x;
                system("clear");
                startboard(b);
            }
            
            else if(g=='n')
            {
                break;
            }

        }

    }


}

void startboard(char b[])
{
    int j=0;
    for(; j<9; j++)
    {
        b[j]='-';
    }
}

void update(int p,char b[],char cp)
{

    b[p]=cp;

}

int check(int p,char b[],char cp)
{

    int pos=p-1;

    if(b[pos]=='x' || b[pos]=='o' || (0>pos && pos>10) || b[pos]==cp)
    {
        return 1;
    }

    return 0;
}


int checkwin(int a,int b,int c,char p[])
{
    if(p[a]==p[b] && p[b]==p[c] && p[c]==p[a] && (p[a]=='x' || p[a]=='o'))
    {

        printf("\n");
        printf("\t %c  win!!",p[a]);
        printf("\n");
        printf("\n");
        print(p);
        printf("\n");

        return 1;

    }

    return 0;
}


void print(char b[])
{

    for(int i=0; i<9; i++)
    {
        printf("\t  %c  ",b[i]);
        if(i==2 || i==5)
        {
            printf("\n");
        }
    }
}