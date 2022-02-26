import java.io.*;
class RotateMatrix
{
    static int arr[][],temp[][];int m,n;
    public RotateMatrix(int a,int b)    //parameterized constructor to initialize the matrix
    {
        m=a;
        n=b;
        arr=new int[a][b];
    }

    public void accept()throws IOException
    {
        InputStreamReader reader=new InputStreamReader(System.in);
        BufferedReader input=new BufferedReader(reader);
        System.out.println("\nEnter elements of the matrix row-wise.");
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print("Enter element ");
                arr[i][j]=Integer.parseInt(input.readLine());
            }
        }
    }

    public void display()
    {
        System.out.println("\nORIGINAL MATRIX:");
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.print("\n\n");
        }
        int sl=0;   //variable to store the sum of left diagonal
        int sr=0;   //variable to store the sum of right diagonal
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==j)
                    sl=sl+arr[i][j];
                if((i+j)==m-1)
                    sr=sr+arr[i][j];
            }
        }
        System.out.println("\nSum of left diagonal= "+sl);
        System.out.println("Sum of right diagonal= "+sr);
    }

    public void change(int x)   //function to rotate the matrix
    {
        int c=0,temp[][]=new int[n][m];
        while(c<x)
        {
            for(int j=0;j<n;j++)
            {
                for(int i=m-1;i>=0;i--)
                    temp[j][m-1-i]=arr[i][j];
            }
            c++;
            if(c<x)
            {
                for(int i=0;i<m;i++)
                {
                    for(int j=0;j<n;j++)
                        arr[i][j]=temp[i][j];
                }
            }
        }
        System.out.println("\nMATRIX AFTER ROTATION:");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(temp[i][j]+"\t");
            }
            System.out.print("\n\n");
        }
        int sl=0;
        int sr=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(i==j)
                    sl=sl+temp[i][j];
                if((i+j)==m-1)
                    sr=sr+temp[i][j];
            }
        }
        System.out.println("\nSum of left diagonal= "+sl);
        System.out.println("Sum of right diagonal= "+sr);
    }

    public static void main(String args[])throws IOException
    {
        int ch;
        InputStreamReader reader=new InputStreamReader(System.in);
        BufferedReader input=new BufferedReader(reader);
        while(true)
        {
            System.out.println("\nInput a SQUARE MATRIX.");
            System.out.print("Enter the number of rows: ");
            int x=Integer.parseInt(input.readLine());
            System.out.print("Enter the number of columns: ");
            int y=Integer.parseInt(input.readLine());
            if(x==y)
            {
                RotateMatrix obj=new RotateMatrix(x,y);
                obj.accept();
                obj.display();
                System.out.print("\nEnter the number of rotation needed: ");
                int p=Integer.parseInt(input.readLine());
                obj.change(p);
            }
            else
                System.out.println("Square matrix not formed");
            System.out.print("\n1. Continue\n2. Exit\nEnter your choice: ");
            ch = Integer.parseInt(input.readLine());
            switch(ch)
            {
                case 1: continue;
                case 2: System.exit(0);
                    break;
                default: System.out.println("Invalid Entry. Please enter from the given choices.");
            }

        }

    }
}

