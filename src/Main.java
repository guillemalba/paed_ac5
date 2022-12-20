import java.util.Arrays;

public class Main {

    //private static int[] treasures = {1,2,2,3,3,3,4,5};
    private static int[] treasures = {1,2,2,4,5};
    private static int[] visited = new int[treasures.length];
    //private static int vMax = 6;
    private static int vMax = 6;
    private static int currentBoxes = treasures.length;

    public static void main(String[] args) {

        Arrays.fill(visited, -1);

        int[] config = new int[treasures.length];

        Arrays.fill(config, -1);

        bruteForce(config, 0);


    }

    private static void bruteForce(int[] config, int i) {

        config[i] = 0;


        while (config[i] < config.length) {
            if (i == config.length -1) {
                // if config is full we check is valid
                //if (checkValid(config, i)) {
                    System.out.println(Arrays.toString(config));
                //}
            } else {
                if (checkValid(config, i)) {
                    bruteForce(config, i + 1);
                }
            }

            config[i]++;
        }

    }

    private static boolean checkValid(int[] config, int i) {
        int totalValue = 0;
        for (int k = 0; k <= i; k++) {
            if (config[k] == i) {
                totalValue += treasures[k]; //* config[k];
            }
            //System.out.println();
        }
        return totalValue <= vMax;
    }

    /*private static boolean correcta(int[] config, int k) {
        for (int i = 0; i < k; i++) {
            // La nova reina no pot estar estar a la mateixa columna que una altra
            if (config[i] == config[k]) {
                return false;
            }

            // La nova reina no pot estar estar a la mateixa diagonal que una altra
            if (Math.abs(config[i] - config[k]) == Math.abs(i - k)) {
                return false;
            }
        }

        return true;
    }*/
}