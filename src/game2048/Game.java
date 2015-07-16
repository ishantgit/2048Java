package game2048;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
public class Game {
	int board[][];
	Game()
	{
		board=new int[4][4];
		reset();
	}
	void reset()
	{
		ArrayList<String> list=new ArrayList<>();
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				board[i][j]=0;
				list.add(i+","+j);
			}
		}
		int index=(int) (Math.random() * list.size()) % list.size();
		String str=list.get(index);
		String s1=str.charAt(0)+"";
		String s2=str.charAt(2) +"";
		board[Integer.parseInt(s1)][Integer.parseInt(s2)]=Math.random() < 0.9 ? 2 : 4;
		list.remove(index);
		index=(int) (Math.random() * list.size()) % list.size();
		str=list.get(index);
		s1=str.charAt(0)+"";
		s2=str.charAt(2) +"";
		board[Integer.parseInt(s1)][Integer.parseInt(s2)]=Math.random() < 0.9 ? 2 : 4;
	}
	void gameStart()
	{
		Scanner console=new Scanner(System.in);
		System.out.println("enter dir");
		String s=console.next();
		while(canMove())
		{
			if(s =="a")
			{
				left();
			}
			else if(s == "d")
			{
				right();
			}
			else if(s =="w")
			{
				up();
			}
			else if(s=="x")
			{
				down();
			}
			else if(s=="q")
			{
				return ;
			}
			addTile();
			print();
			if(checkIf2048())
			{
				System.out.println("Won");
				System.out.println("New Game");
				reset();
			}
			System.out.println("enter dir");
			s=console.next();
		}
	}
	boolean checkIf2048()
	{
		for(int row=0;row<4;row++)
		{
			for(int col=0;col<4;col++)
			{
				if(board[row][col]==2048)
				{
					return true;
				}
			}
		}
		return false;
	}
	void print()
	{
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}
	void left()
	{
//		for(int row=0;row<4;row++)
//		{
//			int y=3;
//			int prev=0;
//			for(int col=3;col>=0;col--)
//			{
//				if(board[row][col]!=0)
//				{
//					if(prev==0)
//					{
//						prev=board[row][col];
//						y=col;
//					}
//					else if(prev==board[row][col])
//					{
//						prev=0;
//						board[row][col]=board[row][col]*2;
//						board[row][y]=0;
//						y=col;
//					}
//					else if(prev!=board[row][col])
//					{
//						prev=board[row][col];
//						y=col;
//					}
//				}
//				else if(board[row][col]==0)
//				{
//					if(prev!=0)
//					{
//						board[row][col]=prev;
//						board[row][y]=0;
//						y=col;
//					}
//				}
//			}
//		}
		for(int row=0;row<4;row++)
		{
			ArrayList<Integer> list1=new ArrayList<>();
			int col=4-1;
			while(col>=0)
			{
				if(board[row][col]!=0)
				{
					list1.add(board[row][col]);
				}
				col--;
			}
			ArrayList<Integer> list2=new ArrayList<>();
			for(int i=0;i<list1.size();i++)
			{
				if(i==list1.size()-1)
				{
					list2.add(list1.get(i));
					break;
				}
				if(list1.get(i)==list1.get(i+1))
				{
					list2.add(list1.get(i)*2);
					i++;
				}
				else if(list1.get(i)!=0)
				{
					list2.add(list1.get(i));
				}
			}
			int j=0;
			while(j<list2.size())
			{
				board[row][j]=list2.get(list2.size()-1-j);
				j++;
			}
			while(j<4)
			{
				board[row][j]=0;
				j++;
			}
		}
	}
	
	void right()
	{
		for(int row=0;row<4;row++)
		{
			ArrayList<Integer> list1=new ArrayList<>();
			int col=0;
			while(col<4)
			{
				if(board[row][col]!=0)
				{
					list1.add(board[row][col]);
				}
				col++;
			}
			ArrayList<Integer> list2=new ArrayList<>();
			for(int i=0;i<list1.size();i++)
			{
				if(i==list1.size()-1)
				{
					list2.add(list1.get(i));
					break;
				}
				if(list1.get(i)==list1.get(i+1))
				{
					list2.add(list1.get(i)*2);
					i++;
				}
				else if(list1.get(i)!=0)
				{
					list2.add(list1.get(i));
				}
			}
			int x=4-list2.size();
			int j=0;
			while(j<x)
			{
				board[row][j]=0;
				j++;
			}
			int index=0;
			while(j<4)
			{
				board[row][j]=list2.get(index);
				index++;
				j++;
			}
		}
	}
	void up()
	{
		for(int col=0;col<4;col++)
		{
			ArrayList<Integer> list1=new ArrayList<>();
			int row=3;
			while(row>=0)
			{
				if(board[row][col]!=0)
				{
					list1.add(board[row][col]);
				}
				row--;
			}
			ArrayList<Integer> list2=new ArrayList<>();
			for(int i=0;i<list1.size();i++)
			{
				if(i==list1.size()-1)
				{
					list2.add(list1.get(i));
					break;
				}
				if(list1.get(i)==list1.get(i+1))
				{
					list2.add(list1.get(i)*2);
					i++;
				}
				else if(list1.get(i)!=0)
				{
					list2.add(list1.get(i));
				}
			}
			int i=0;
			while(i<list2.size())
			{
				board[i][col]=list2.get(list2.size()-1-i);
				i++;
			}
			while(i<4)
			{
				board[i][col]=0;
				i++;
			}
		}
	}
	void down()
	{
		for(int col=0;col<4;col++)
		{
			ArrayList<Integer> list1=new ArrayList<>();
			int row=0;
			while(row<4)
			{
				if(board[row][col]!=0)
				{
					list1.add(board[row][col]);
				}
				row++;
			}
			ArrayList<Integer> list2=new ArrayList<>();
			for(int i=0;i<list1.size();i++)
			{
				if(i==list1.size()-1)
				{
					list2.add(list1.get(i));
					break;
				}
				if(list1.get(i)==list1.get(i+1))
				{
					list2.add(list1.get(i)*2);
					i++;
				}
				else if(list1.get(i)!=0)
				{
					list2.add(list1.get(i));
				}
			}
			int x=4-list2.size();
			int i=0;
			while(i<x)
			{
				board[i][col]=0;
				i++;
			}
			int index=0;
			while(i<4)
			{
				board[i][col]=list2.get(index);
				index++;
				i++;
			}
		}
	}
	ArrayList<String> availableSpace()
	{
		ArrayList<String> list=new ArrayList<>();
		for(int i=0;i<4;i++)
			for(int j=0;j<4;j++)
			{
				if(board[i][j]==0)
				{
					list.add(i+","+j);
				}
			}
		return list;
	}
	
	boolean isFull()
	{
		if(availableSpace().size()==0)
			return true;
		return false;
	}
	
	void addTile()
	{
		ArrayList<String> list=availableSpace();
		if(!list.isEmpty())
		{
			int index=(int) (Math.random() * list.size()) % list.size();
			String str=list.get(index);
			String s1=str.charAt(0)+"";
			String s2=str.charAt(2) +"";
			board[Integer.parseInt(s1)][Integer.parseInt(s2)]=Math.random() < 0.9 ? 2 : 4;
		}
	}
	boolean canMove()
	{
		if(!isFull())
		{
			return true;
		}
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<4;j++)
			{
				if((i<3 && board[i][j]==board[i+1][j]) || (j<3 && board[i][j]==board[i][j+1]))
				{
					return true;
				}
			}
		}
		return false;
	}
}
