import java.util.ArrayList;
import java.util.Arrays;

public class Maze {
    
    public static void main(String[] args) {
        // int r=3;
        // int c=3;
         String s="";
        // System.err.println(countPaths(r,c));
        // System.out.println(paths(s, r, c));
        // System.out.println(pathsWithdiagonal(s, r, c));
        
        
        boolean board[][] = {
            {true,true,true},
            {true,true,true},
            {true,true,true}
        };
        // System.out.println(pathsWithObstackles(s, board, 0, 0));
        //System.out.println(pathsWithAlldir(s,board,0,0));
        int[][] path=new int[board.length][board[0].length];
        pathWithNum(s, board, 0, 0,path,1);
    }

    static int countPaths(int r,int c){
        if(r==1 ||c==1){
            return 1;
        }
        int left =countPaths(r-1, c);
        int right=countPaths(r,c-1);
        return left+right;
    }
    static ArrayList<String> paths(String s,int r,int c){
        if(r==1 && c==1){
            ArrayList<String> list =new ArrayList<>();
            list.add(s);
            return list;
        }
        ArrayList<String> list=new ArrayList<>();
        if(r>1){
            list.addAll(paths(s+'D',r-1,c));
        }
        if(c>1){
            list.addAll(paths(s+'R',r,c-1));
        }
        return list;
        
    }
    //diagonal path
    static ArrayList<String> pathsWithdiagonal(String s,int r,int c){
        if(r==1 && c==1){
            ArrayList<String> list =new ArrayList<>();
            list.add(s);
            return list;
        }
        ArrayList<String> list=new ArrayList<>();
        if(r>1 && c>1){
            list.addAll(pathsWithdiagonal(s+"D", r-1, c-1));
        }
        if(r>1){
            list.addAll(pathsWithdiagonal(s+'H',r-1,c));
        }
        if(c>1){
            list.addAll(pathsWithdiagonal(s+'V',r,c-1));
        }
        return list;
        
    }
    //maze  with obstacles
    static ArrayList<String> pathsWithObstackles(String s,boolean[][] board,int r,int c){
        if(r==board.length-1 && c==board[0].length-1){
            ArrayList<String> list =new ArrayList<>();
            list.add(s);
            return list;
        }
        ArrayList<String> list=new ArrayList<>();
        if(!board[r][c]){
            return list;
        }
        if(r<board.length-1){
            list.addAll(pathsWithObstackles(s+'D',board,r+1,c));
        }
        if(c<board[0].length-1){
            list.addAll(pathsWithObstackles(s+'R',board,r,c+1));
        }
        return list; 
    }
    //path with all directions using bactracking
    static ArrayList<String> pathsWithAlldir(String s,boolean[][] board,int r,int c){
        if(r==board.length-1 && c==board[0].length-1){
            ArrayList<String> list =new ArrayList<>();
            list.add(s);
            return list;
        }
        ArrayList<String> list=new ArrayList<>();
        if(!board[r][c]){
            return list;
        }
        board[r][c]=false;
        
        if(r > 0){
            list.addAll(pathsWithAlldir(s+'U', board, r-1, c));
        }
        if(c > 0){
            list.addAll(pathsWithAlldir(s+'L', board, r, c-1));
        }
        if(r<board.length-1){
            list.addAll(pathsWithAlldir(s+'D',board,r+1,c));
        }
        if(c<board[0].length-1){
            list.addAll(pathsWithAlldir(s+'R',board,r,c+1));
        }
        board[r][c]=true;
        return list; 
    }
    static void pathWithNum(String s,boolean board[][],int r,int c, int[][] path,int step){
        if(r==board.length-1 && c==board[0].length-1){
            for(int[] arr : path){
                path[r][c]=step;
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(s);
            System.out.println();
            return;
        }
        if(!board[r][c]){
            return;
        }
        board[r][c]=false;
        path[r][c]=step;
        if(r<board.length-1){
            pathWithNum(s+'D', board, r+1, c,path,step+1);
        }
        if(c<board[0].length-1){
            pathWithNum(s+'R', board, r ,c+1,path,step+1);
        }
        if(r>0){
            pathWithNum(s+'U', board, r-1, c,path,step+1);
        }
        if(c>0){
            pathWithNum(s+'L', board, r, c-1,path,step+1);
        }
        board[r][c]=true;
        path[r][c]=0;
    }
}
