package game2048;
import java.util.Scanner;
public class GameUse {
	public static void main(String args[])
	{
		Scanner console=new Scanner(System.in);
		Game g=new Game();
		g.print();
		System.out.println("enter dir");
		String s=console.next();
		while(g.canMove())
		{
			if(s.charAt(0)=='a')
			{
				g.left();
			}
			else if(s.charAt(0) =='d')
			{
				g.right();
			}
			else if(s.charAt(0) =='w')
			{
				g.up();
			}
			else if(s.charAt(0)=='x')
			{
				g.down();
			}
			else if(s.charAt(0)=='q')
			{
				return ;
			}
			g.addTile();
			g.print();
			if(g.checkIf2048())
			{
				System.out.println("Won");
				System.out.println("New Game");
				g.reset();
			}
			System.out.println("enter dir");
			s=console.next();
		}
	}
}
