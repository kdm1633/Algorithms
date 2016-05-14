public class Checkers
{
    int min;
    char[][] board;

    public int compute(String startPos, String[] pieces) {
        min = 7;
		board = new char[8][8];

        int x = startPos.charAt(0) - '0';
        int y = startPos.charAt(2) - '0';
        
        for(int i=0; i < pieces.length; i++)
            board[pieces[i].charAt(0) - '0'][pieces[i].charAt(2) - '0'] = 'B';

        search(x,y,0,false);

        if(min == 7) min = -1;

        return min;
    }

    public void search(int x, int y, int count, boolean jump) {
		if(y==7) {
			if(count < min) min = count;
			return;
		}
		
		int l = x-1;
		int r = x+1;
		int u = y+1;
		
		int ll = l-1;
		int rr = r+1;
		int uu = u+1;
		
		if(l>=0) {
			if(board[l][u] == 0)
				search(l,u,count+1,false);
			else if(ll>=0 && uu<=7) {
				if(board[ll][uu] == 0)
					search(ll, uu, (jump) ? count : count+1, true);
			}	
		}
		
		if(r<=7) {
			if(board[r][u] == 0)
				search(r,u,count+1,false);
			else if(rr<=7 && uu<=7){
				if(board[rr][uu] == 0)
					search(rr, uu, (jump) ? count : count+1, true);
			}
		}
    }

    public static void main(String[] args) {
        Checkers c = new Checkers();
        System.out.println(c.compute("1,0", new String[]{"2,1", "0,3", "4,3", "5,6", "4,2"}));
        System.out.println(c.compute("4,4", new String[]{}));
        System.out.println(c.compute("4,4", new String[]{"6,6", "5,5", "3,5", "2,6"}));
        System.out.println(c.compute("4,1", new String[]{"2,4", "3,4", "4,4", "5,4", "2,6", "3,6", "4,6", "5,6"}));
        System.out.println(c.compute("0,4", new String[]{"1,7","3,7"}));
        System.out.println(c.compute("0,7", new String[]{}));
        System.out.println(c.compute("5,0", new String[]{"4,1", "2,3", "1,3", "3,4", "6,3", "2,5", "4,5"}));
        System.out.println(c.compute("1,1", new String[] {"2,2", "0,4", "1,4", "2,4", "5,5", "4,6", "7,7"}));
    }
}
