public class App {
    public static void main(String[] args) throws Exception {
        int[] testArray = {1,2,3,4,5,6,7,8,9};
        System.out.println(max(testArray));
        GameResult[] scoreboard = new GameResult[4];
        fillScoreboard(scoreboard);

        for (int i = 0; i < scoreboard.length; i++) {
            System.out.println(scoreboard[i]);
        }

    }
    public static void fillScoreboard(GameResult[] scoreboard) {
        int i = 0;
        int max = 500;
        String[] userlist = {"carl","lars","martin","mathias"};
        for (GameResult gameResult : scoreboard) {
            gameResult.setScore((int) (Math.random() * max));
            gameResult.setUser(userlist[i]);
            i++;
        }
    }

    public static int max(int[] array){
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i] > max){
                max = array[i];                
            }
        }
        return max;
    }

    public static int findElement(int[] array, int element) {
        for (int i = 0; i < array.length; i++) {
            if(array[i] == element){
                return i;
            }
        }
        return array.length + 1;
    }
}
