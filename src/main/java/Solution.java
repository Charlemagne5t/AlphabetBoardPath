import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    int[] lastChar = {0, 0};
    public String alphabetBoardPath(String target) {
        char[][] grid = {
                {'a', 'b', 'c', 'd', 'e'},
                {'f', 'g', 'h', 'i', 'j'},
                {'k', 'l', 'm', 'n', 'o'},
                {'p', 'q', 'r', 's', 't'},
                {'u', 'v', 'w', 'x', 'y'},
                {'z', '0', '0', '0', '0'}
        };
        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < target.length(); i++){
            String str = bfs(target.charAt(i), lastChar[0], lastChar[1], grid);
            ans.append(str);
        }
        return ans.toString();
    }
    String bfs(char target, int i, int j, char[][] grid){

        Queue<Path> q = new LinkedList<>();
        q.add(new Path(i, j, ""));
        int[][] dest = {{1, 0, 68}, {-1, 0, 85}, {0, -1, 76}, {0, 1, 82}};
        int visited = 0;
        while (!q.isEmpty()){
            Path path = q.poll();
            int curI = path.i;
            int curJ = path.j;
            String curPath = path.path;
            if(grid[curI][curJ] == target){
                lastChar[0] = curI;
                lastChar[1] = curJ;
                return curPath + '!';
            }
            if((((grid[curI][curJ] - 'a') << 1) & visited) == 1){
                continue;
            }
            visited |= ((grid[curI][curJ] - 'a') << 1);
            for (int k = 0; k < dest.length; k++) {
                int nextI = curI + dest[k][0];
                int nextJ = curJ + dest[k][1];
                char ch = (char) dest[k][2];
                if(nextI < 0 || nextI == grid.length || nextJ < 0 || nextJ == grid[0].length || grid[nextI][nextJ] == '0'){
                    continue;
                }
                q.offer(new Path(nextI, nextJ, curPath + ch));
            }

        }
        return "";
    }
}
class Path{
    int i;
    int j;
    String path;

    public Path(int i, int j, String path) {
        this.i = i;
        this.j = j;
        this.path = path;
    }
}
