

public class Main {
    public static boolean what(int[] a, int i, int j){
        for (int k = i; k < j; k++){
            if (k < a.length -1 && a[k] > a[k + 1])
                return false;
        }
        return true;
    }

    public static int secret(int []a){
        int temp = 1;
        for (int i = 0; i < a.length - 1; i++){
            for (int j = i + 1; j < a.length; j++){
                if (what(a, i, j)){
                    if (temp < j - i + 1)
                        temp = j - i + 1;
                }
            }
        }
        return temp;
    }
    public static int word(String word){
        int i = 0;
        int countWords = 0;
        int count = 0;
        int countLeters = 0;
        while (i < word.length()){
            if (word.charAt(i) == ' '){
                countWords += 1;
            }
            if (word.charAt(i) == '.')
                count += 1;
            else
                countLeters++;
            i++;
        }
        System.out.println("leters: " + countLeters + ": משפטים: " + count + " words: " + countWords);
        return count;
    }

    public static int[] what (int num) {
        int [] a = new int [10];
        int i = 0;
        while (num >0)
        {
            a[i] = num % 10;
            num = num/10;
            i++;
        }
        int length = i;
        for (int j=0; j< a.length/2; j++)
        {
            int temp = a[j];
            a[j] = a[a.length-j-1];
            a[a.length-j-1] = temp;
        }
        return a;
    }







    public static String getOriginal(String secret){
        String original = "";
        for (int i = 0; i < secret.length(); i++){
            char c = (char) (secret.charAt(i) - (i + 1));
            original += c;
        }
        return original;
    }

    public static int count(int [] arr,int n){
        int i = 0;
        int j = 1;
        int k = 2;
        int c = 0;
        while(i <= arr.length - 3){
            if(arr[i] + arr[j] + arr[k] < n){
                c = c + 1;
                if(k < arr.length - 1){
                    k = k + 1;
                }
                else if(k == arr.length - 1 && j < k){
                    j++;
                    k = j + 1;
                }
            }
            else{
                i = i + 1;
                j = i + 1;
                k = j + 1;
            }
        }
        return c;
    }


    public static void findWord(char [][] arr, String word){
        if (arr == null || word == null)
            System.out.println("no souch word");
        System.out.println(findWord(arr, word, 0, 0, ""));
    }

    private static boolean isSafe(char [][] arr, String word, boolean [][]visit, int i, int j, int index){
        return i >= 0 && i < arr.length && j >= 0 && j < arr.length && !visit[i][j] && arr[i][j] == word.charAt(index);
    }

    private static String findWord(char [][] arr, String word, int i, int j, String word3){
        if (j == arr.length){
            j = 0;
            i = i + 1;
            if (i == arr.length)
                return word3;
        }
        if (arr[i][j] == word.charAt(0)){
            int [][] arr2 = new int[arr.length][arr[0].length];
            boolean [][]arr3 = new boolean[arr.length][arr[0].length];
            word3 = findWord(arr, word, arr2, arr3, i, j, 0, "");
            if (word3 == word)
                return word3;
        }
        return findWord(arr, word, i, j + 1, word3);
    }

    private static String findWord(char [][] arr, String word, int[][]check, boolean [][]visit, int i, int j, int index, String name){
        name += arr[i][j];
        if (index >= word.length() - 1){
            System.out.println(print(check, arr));
            return name;
        }
        if (isSafe(arr, word, visit, i, j + 1, index + 1))
            return findWord(arr, word, check, visit, i, j + 1, index + 1, name);
        if (isSafe(arr, word, visit, i, j - 1, index + 1))
            return findWord(arr, word, check, visit, i, j - 1, index + 1, name);
        if (isSafe(arr, word, visit, i + 1, j, index + 1))
            return findWord(arr, word, check, visit, i + 1, j, index + 1, name);
        if (isSafe(arr, word, visit, i - 1, j, index + 1))
            return findWord(arr, word, check, visit, i - 1, j, index + 1, name);
        return name;
    }

    private static String print(int arr[][], char[][]array){
        int i = 0;
        int j = 0;
        while (i < arr.length){
            if (arr[i][j] != 0)
                System.out.println(array[i][j]);
            j++;
            if (j == arr[0].length){
                j = 0;
                i = i + 1;
                if (i == arr.length)
                    return "";
            }
        }
        return "";
    }

    public static int findSingle(int []arr){
        int i = 1;
        if (arr.length == 1 || arr[0] != arr[1])
            return arr[0];
        if (arr[arr.length -1] != arr[arr.length -2])
            return arr[arr.length-1];
        while (i < arr.length-1){
            if (arr[i] != arr[i - 1] && arr[i] != arr[i + 1])
                return i;
            i++;
        }
        return -1;
    }

    public static int cheapestRoute(int [] arr){
        return cheapestRoute(arr, 0, 0);
    }
    public static int cheapestRoute(int [] arr, int count, int i){
        if (i < arr.length){
            count += arr[i];
            if (i == arr.length - 1)
                return count;
        }

        if (i >= arr.length)
            return Integer.MAX_VALUE;

        return Math.min(cheapestRoute(arr, count, i + 1), cheapestRoute(arr, count, i + 2));
    }



    public static int []sortMod2(int[] arr, int k){
        int index = 0;
        int temp;
        int count = 0;
        for (int mod = 0; mod < k; mod++){
            for (int i = 0; i < arr.length; i ++){
                count += 1;
                if (arr[i] % k == mod){
                    temp = arr[index];
                    arr[index] = arr[i];
                    index++;
                }
            }
        }
        System.out.println("compexi is : " + count);
        return arr;
    }
    public static int []sortMod(int[] arr, int k){
        int i = 0;
        int j = 1;
        int count = 0;
        int minModIndex = 0;
        int minMod = 0;
        while (i < arr.length - 1){
            if (arr[i] % k == minMod){
                i += 1;
                j = i + 1;
            }
            count++;
            if (arr[j] % k < arr[minModIndex] % k){
                minModIndex = j;
                minMod = arr[j] % k;
            }

            if (j == arr.length-1){
                if (arr[minModIndex] % k < arr[i] % k){
                    int temp = arr[minModIndex];
                    arr[minModIndex] = arr[i];
                    arr[i] = temp;
                }

                i++;
                j = i + 1;
            }
            if (j < arr.length - 1)
                j++;
        }
        System.out.println("compexi is : " +count);
        return arr;
    }
//

    //    private static int sum(int[] vec, int lo, int hi){
//        int sum = 0;
//        if (lo >= vec.length || hi >= vec.length)
//            return -1;
//        for(int i = lo;  i <= hi; i++){
//            sum += vec[i];
//        }
//        return sum;
//    }
    public static int where(int []vec){
        return where(vec, 0, vec.length);
    }
    public static int where(int []vec, int i, int end){
        if (i == end || i < 0)
            return -1;
        if (where(vec, 0, i, 0) == where(vec, i, vec.length, 0))
            return i;
        return where(vec, i + 1, end);
    }

    public static int where(int []vec, int start, int end, int count){
        if (start == end)
            return count;
        count += vec[start];
        return where(vec, start + 1, end, count);
    }





    public static int isBalanced(int []arr, int num){
        if (where(arr, 0, arr.length) > -1)
            return 1 + isBalanced(arr, 0, where(arr, 0, arr.length), false, 0) +
                    isBalanced(arr, where(arr, 0, arr.length), arr.length, false, 0);
        return 0;
    }
    private static int isBalanced(int[] arr, int start, int end, boolean check, int count){
        if (where(arr, start, end) > -1){
            if(!check)
                count++;
            if (check){
                if (count > 0){
                    count = 0;
                    return 2;
                }
                return 1;
            }
        }
        if (start > arr.length || end > arr.length || where(arr, start, end) == -1)
            return 0;
        return isBalanced(arr, start, where(arr, start, end), true, count) + isBalanced(arr, where(arr, start, end), end, true, count);
    }

    public static int minPath(char[][]arr, int i, int j){
        boolean [][]visit = new boolean[arr.length][arr[0].length];
        return minPath(arr, i, j, 0, visit);
    }

    public static boolean isSafe(char[][]arr, int i, int j, boolean[][] visit){
        return  i >= 0 && i < arr.length && j < arr[i].length && j >= 0 && !visit[i][j];
    }
    private static int minPath(char[][]arr, int i, int j, int count, boolean[][] visit){
        if (isSafe(arr, i, j, visit)){
            if (arr[i][j] == 'K'){
                return count;
            }
        }
        if (!isSafe(arr, i, j, visit)){
            return Integer.MAX_VALUE;
        }
        visit[i][j] = true;
        return Math.min(
                Math.min(
                        Math.min(minPath(arr, i + 2, j + 1, count + 1, visit),
                                minPath(arr, i + 2, j - 1, count + 1, visit)
                        ),
                        Math.min(
                                minPath(arr, i - 2, j + 1, count + 1, visit),
                                minPath(arr, i - 2, j - 1, count + 1, visit))
                ),
                Math.min(
                        Math.min(
                                minPath(arr, i - 1, j + 2, count + 1, visit),
                                minPath(arr, i + 1, j + 2, count + 1, visit)
                        ),
                        Math.min(
                                minPath(arr, i + 1, j - 2, count + 1, visit),
                                minPath(arr, i - 1, j - 2, count + 1, visit)
                        )
                )
        );
    }
    //
    public static boolean findLimit(int []a){
        int count0 = a[1];
        int i = 0;
        int j = 1;
        while (i < a.length){
            if (j < a.length -1 && count0 != 0){
                j++;
                if (count0 < 0){
                    count0 += a[j];
                }
            }
            if (count0 == 0 && j < a.length-1){
                return true;
            }
            if (count0 > 0 || j == a.length-1){
                i++;
                j = i + 1;
                count0 = a[j];
                if (a[i] >= 0)
                    return false;
            }
        }
        return false;
    }

    public static int p(int[]a, int k){
        int b = 0;
        int f = 0;
        int s = 0;
        int m = 0;
        int i = 0;
        while (i < a.length){
            if (a[i] == 0){
                s++;
                while (a[i + 1] != 0){
                    b++;
                    i++;
                }
                b++;
                i++;
                s--;
            }
            if (f - b + 1 > m)
                m = f - b + 1;
            f++;
            i++;
        }
        return m;
    }


    public static int shortestRoad(int[]rode, int[]ride2){
        int i = 0;
        int count = 0;
        int minCount = Integer.MAX_VALUE;
        int rodeOne = rode[0];
        int rodeTow = 0;
        int rodeOneSecond = ride2[0];
        int rodeTowSecond = 0;
        int maxI = rode.length-1;
        while (i < rode.length){
            if(i == rode.length - 1 || i == maxI){
                rodeOne -= rode[i];
                rodeTow += ride2[i];
                rodeOneSecond -= ride2[i];
                rodeTowSecond += rode[i];
                i = i - 1;
                count = Math.min(rodeOne + rodeTow, rodeOneSecond + rodeTowSecond);
                if (count < minCount)
                    minCount = count;
                if (i == 0)
                    return minCount;
                maxI = maxI - 1;
            }
            else {
                i++;
                rodeOne += rode[i];
                rodeOneSecond += ride2[i];
            }
        }
        return minCount;
    }


    public static boolean isSum(int []arr, int num){
        boolean []mat = new boolean[arr.length];
        return isSum(arr, 0, false, 0, mat, num);
    }

    private static boolean isSum(int []arr, int i, boolean prev, int count, boolean []mat, int num){
        if (i >= 1){
            mat[i - 1] = prev;
            if (i > 2 && mat[i - 3] && mat[i - 2] && mat[i - 1]){
                return false;
            }
        }
        if (count == num)
            return true;
        if (i == arr.length)
            return false;

        return isSum(arr, i + 1, true, count + arr[i], mat, num) ||
                isSum(arr, i + 1, false, count, mat, num);
    }



    public static int striclyIncrusing(int[]arr){
        int equal = 0;
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++){
            if (arr[i] < arr[i + 1]){
                count++;
                equal += count;
            }
            if (arr[i] >= arr[i + 1]){
                count = 0;
            }
        }
        if (count > 0)
            equal += count;
        return equal;
    }

    public static int findMaximum(int[][]mat){
        if (mat[0][0] == -1)
            return mat[0][0];
        return findMaximum(mat, 0, 0, mat[0][0], 0);
    }
    private static boolean isSafe(int[][]mat, int i, int j){
        return i < mat.length && j >= 0 && j < mat[i].length && mat[i][j] != -1;
    }
    private static int findMaximum(int [][]mat, int i, int j, int count, int maximum){
        if (isSafe(mat, i + 1, j))
            maximum = findMaximum(mat, i + 1, j, count + mat[i + 1][j], maximum);

        if (isSafe(mat, i, j - 1))
            if (i % 2 != 0){
                maximum = findMaximum(mat, i, j - 1, count + mat[i][j - 1], maximum);
            }
        if (isSafe(mat, i, j + 1))
            if (i % 2 == 0){
                maximum = findMaximum(mat, i, j + 1, count + mat[i][j + 1], maximum);
            }
        if (count > maximum)
            maximum = count;
        return maximum;
    }

    public static void smallestSub(int[] a, int k){
        int i = 0;
        int j = 0;
        int count = 0;
        int minimum = Integer.MAX_VALUE;
        while (i < a.length){
            if (count > k){
                if (count - k < minimum)
                    minimum = j - i;
                count -= a[i];
                i++;
            }
            if (count <= k){
                count += a[j];
                j++;
                if (j == a.length)
                    break;
            }
        }
        if (i == 0)
            System.out.println("answer for smallestSub is: " +(a.length + 1));
        else
            System.out.println("answer for smallestSub is: " + minimum);
    }













//    public static void smallestSub(int []arr, int k){
//        int i = 0;
//        int j = 0;
//        int count = 0;
//        int minimum = Integer.MAX_VALUE;
//        while (i < arr.length -1){
//            if (count > k){
//                if (count - k < minimum)
//                    minimum = j - i;
//                count -= arr[i];
//                i++;
//            }
//            if (count < k){
//                count += arr[j];
//                if (j < arr.length-1)
//                    j++;
//            }
//            if (count >= k && j == arr.length -1){
//                break;
//            }
//        }
//        if (i == 0 && count > k)
//            System.out.println(j + 1 );
//        if (count <= k)
//            System.out.println(j + 2 );
//        else if(count > k && i != 0)
//            System.out.println(minimum);
//    }

    public static int[] replace(int[]arr){
        int courentPlace = 0;
        int findBigestInTheRightSide = 0;
        int maxPlaceFound = 0;
        int maxValue = 0;
        while (courentPlace < arr.length){
            if (arr[findBigestInTheRightSide] > maxValue){

                maxPlaceFound = findBigestInTheRightSide;
                maxValue = arr[findBigestInTheRightSide];

            }
            findBigestInTheRightSide++;
            if (findBigestInTheRightSide == arr.length){

                arr[courentPlace] = maxValue;
                courentPlace++;

                if (maxPlaceFound == courentPlace){

                    maxPlaceFound = arr.length;
                    findBigestInTheRightSide = courentPlace + 1;
                    maxValue = 0;

                }
                else
                    findBigestInTheRightSide--;
                if (courentPlace == arr.length - 1){
                    arr[courentPlace] = 0;
                    return arr;
                }
            }
        }
        return arr;
    }

    public static void printPath (int[][] mat){
        String my = "";
        my = printPath(mat, 0, 0, my, 0);
        String[] s = my.split("    ");
        System.out.println(s[0]);
    }

    private static boolean isSafe2(int[][] mat, int i, int j, int prev){
        return i < mat.length && i >= 0 && j < mat[0].length && j >= 0 && prev < mat[i][j];
    }

    private static String printPath (int[][] mat, int i, int j, String path, int prev){
        if(isSafe2(mat, i, j, prev)){
            path += "(" + i + "," + j +")";
            if (!isSafe2(mat, i + 1, j, mat[i][j])
                    && !isSafe2(mat, i, j + 1, mat[i][j])
                    && !isSafe2(mat, i - 1, j, mat[i][j])
                    && !isSafe2(mat, i, j - 1, mat[i][j]))
            {
                return path + "    ";
            }
        }
        if (!isSafe2(mat, i, j, prev))
            return "";
        return printPath(mat, i, j + 1, path, mat[i][j]) +
                printPath(mat, i + 1, j, path, mat[i][j]) +
                printPath(mat, i, j - 1, path, mat[i][j]) +
                printPath(mat, i - 1, j, path, mat[i][j]);
    }





//    public static void printPath(int[][] m){
//        String my = "";
//        my = printPath(m,0,0, my, 0);
//        String[] my2 = my.split("   ");
//        System.out.println(my2[0]);
//
//    }
//
//    private static String printPath(int[][]m, int i, int j, String path, int prev){
//        if(isPrintPath(m, i, j, prev)){//if is valid input
//            path += "(" + i + "," + j + ")";
//            if (!isPrintPath(m, i + 1, j, m[i][j]) &&
//                    !isPrintPath(m, i - 1, j, m[i][j]) &&
//                    !isPrintPath(m, i , j + 1, m[i][j]) &&
//                    !isPrintPath(m, i , j - 1, m[i][j]))
//                return path + "   ";
//            }
//        if (!isPrintPath(m, i, j, prev))
//            return "";
//        return printPath(m, i + 1, j, path, m[i][j]) +
//                printPath(m, i - 1, j, path, m[i][j]) +
//                printPath(m, i, j + 1, path, m[i][j]) +
//                printPath(m, i, j  - 1, path, m[i][j]);
//    }
//
//    private static boolean isPrintPath(int[][]m, int i, int j, int previos){//checks for valid inputs
//        return i >= 0 && i < m.length -1 && j >= 0 && j < m[0].length -1 && m[i][j] > previos;
//    }

    public static int average(int [] arr){
        int i = 0;
        int maxDif = 0;
        int dif = 0;
        int start = 0;
        int count3Left = 0;
        int count3Right = 0;
        int countLeftGroup = 0;
        int countRight = 0;
        int sizeRight = 1;
        int j = arr.length -1;
        while (j >= 0 && sizeRight > 0){
            if (i > 0 && j == 1){
                count3Right = countRight / sizeRight;
                count3Left = countLeftGroup / i;
                dif = Math.abs(count3Left - count3Right);
                if (dif > maxDif){
                    maxDif = dif;
                    start = i;
                }
            }
            if (j > 1){
                countRight += arr[j];
                sizeRight++;
                j--;
            }
            if (j == 1){
                countLeftGroup += arr[i];
                if (i > 0){
                    countRight -= arr[i];
                    sizeRight--;
                }
                i++;
            }
        }
        System.out.println(maxDif);
        return start;
    }


    public static int plusMinus(int []arr, int num){
        return plusMinus(arr, num, 0, 0, 0, "", false);
    }
    private static int plusMinus(int []arr, int num, int i, int numOne, int prev, String path, boolean ondo){
        if ( ondo && prev > 0)
            path += "+" + arr[i - 1] + " ";
        if ( ondo && prev < 0)
            path += "-" + arr[i - 1] + " ";
        if (num == numOne){
            System.out.println(path + " = " + num);
            return 1;
        }
        if (i == arr.length)
            return 0;
        return plusMinus(arr, num, i + 1, numOne + arr[i], arr[i], path, true) +
                plusMinus(arr, num, i + 1, numOne - arr[i], (-arr[i]), path, true) +
                plusMinus(arr, num, i + 1, numOne, 0, path, false);
    }

    public static int maxSumKnight(int[][] mat){
        boolean [][]visit = new boolean[mat.length][mat[0].length];
        return maxSumKnight(mat, 0, 0,mat[0][0], 0, visit);
    }

    private static boolean isSafe(int[][] mat, int i, int j, int prev, boolean [][]visit){
        return i < mat.length && i >= 0 && j < mat[0].length && j >= 0 && !visit[i][j] && Math.abs(prev - mat[i][j]) <= 1;
    }

    private static int maxSumKnight(int[][] mat, int i, int j, int prev, int count, boolean [][]visit){
        if (!isSafe(mat, i, j, prev, visit))
            return 0;
        if (i == mat.length -1 && j == mat[0].length -1){
            count += mat[i][j];
            return count;}
        visit[i][j] = true;
        return Math.max(
                Math.max(
                        Math.max(
                                maxSumKnight(mat, i + 2, j + 1, mat[i][j], count + mat[i][j], visit),
                                maxSumKnight(mat, i + 2, j - 1, mat[i][j], count + mat[i][j], visit)),
                        Math.max(
                                maxSumKnight(mat, i - 2, j - 1, mat[i][j], count + mat[i][j], visit),
                                maxSumKnight(mat, i - 2, j + 1, mat[i][j], count + mat[i][j], visit))),
                Math.max(
                        Math.max(
                                maxSumKnight(mat, i + 1, j - 2, mat[i][j], count + mat[i][j], visit),
                                maxSumKnight(mat, i - 1, j - 2, mat[i][j], count + mat[i][j], visit)),
                        Math.max(
                                maxSumKnight(mat, i - 1, j + 2, mat[i][j], count + mat[i][j], visit),
                                maxSumKnight(mat, i + 1, j + 2, mat[i][j], count + mat[i][j], visit)))
        );
    }


    public static int longestSequens(int[]arr, int k){
        int end = 0;
        int start0 = 0;
        int startBig = 0;
        int count0 = 0;
        int count = 0;
        int longestI = 0;
        int i = 0;
        while (i < arr.length -1){
            if (arr[i] == 0){
                if (count0 == 0)
                    start0 = i;
                count0++;
                if (count0 > k){
                    if (count > longestI){
                        longestI = count;
                        startBig = i - count;
                        end = i;
                    }
                    i = start0+1;
                    count0 = 0;
                    count = 0;
                }
                else {
                    count++;
                    i++;
                }
            }
            if (arr[i] == 1){
                count++;
                i++;
            }
        }
        if (count > longestI){
            longestI = count;
            startBig = i - count;
            end = i;
        }
        System.out.println("startAt :" + startBig + " endAt: " + end);
        return longestI;
    }


    public static int totalWays(int [][]arr, int k){
        if (arr == null || k <= 0)
            return -1;
        return totalWays(arr, k, 0, 0, 0 ,0 , 0, 0);
    }

    private static int totalWays(int [][]arr, int k, int i, int j, int equalI, int equalJ, int prevI, int prevJ){
        if (equalI > 0 && equalJ > 0){
            k--;
            if (prevI < i) {
                i--;
                equalJ = 0;
                equalI = 0;
            }
            else
            if (prevJ < j) {
                j--;
                equalJ = 0;
                equalI = 0;
            }

        }
        if (i == arr.length - 1 && k == 0 &&  j == arr.length -1)
            return 1;
        if (i > arr.length - 1 ||  j > arr.length -1)
            return 0;
        return totalWays(arr, k, i + 1, j, equalI + 1, equalJ, i, j) + totalWays(arr, k, i, j + 1, equalI, equalJ + 1, i, j);
    }

    public static int trueArea(boolean[][]array){
        boolean [][]visit = new boolean[array.length][array[0].length];
        return trueArea(array,0, 0, 0,0, 0, visit);
    }
    private static int trueArea(boolean[][]array, int val, int counterArea, int max, int i, int j, boolean [][]visit){
        if (i == array.length || j == array[0].length || j < 0 || i < 0 || visit[i][j])
            return counterArea;

        if (array[i][j]){
            if (val == 0)
                counterArea += 1;
            val += 1;
            if (counterArea > max)
                max = counterArea;
        }
        if (!array[i][j])
            val = 0;
        visit[i][j] = true;

        return Math.max(Math.max(trueArea(array, val, counterArea, max, i + 1, j, visit), trueArea(array, val, counterArea, max, i, j + 1, visit)),
                Math.max(trueArea(array, val, counterArea, max, i - 1, j, visit), trueArea(array, val, counterArea, max, i, j - 1, visit)));
    }



    public static int oneFiveSeven(int num){
        return oneFiveSeven(num, 0, 0);
    }
    public static int oneFiveSeven(int num, int count, int step){
        if (count > num)
            return Integer.MAX_VALUE;
        if (count == num)
            return step;

        return Math.min(

                Math.min(
                        oneFiveSeven(num, count + 7, step + 1),
                        oneFiveSeven(num, count + 5, step + 1)
                ),

                oneFiveSeven(num, count + 1, step + 1)
        );
    }







    public static void main(String[] args) {

        int[]array1345 = {1,2,11,4,5};
        System.out.println(isSum(array1345, 4));

        System.out.println(oneFiveSeven(12));



        boolean[][] my4 = {{false, true, true},
                {true,false,false},
                {false,true,false},
                {true, false, true}};
        System.out.println(trueArea(my4));
        int arr[][] = {{4,5,6,7,1},
                {3,5,1,7,4},
                {4,5,6,5,8},
                {3,4,7,7,9},
                {6,2,2,7,6}};
        int[][] printPathMatrix = {{3,5,7,1},
                {5,2,9,4},
                {12,14,-13,22},
                {13,16,17,52}};
        printPath(printPathMatrix);
        // write your code here
        int[]array13 = {1,4,13,6,0,19};
        smallestSub(array13, 22);


        int[] a = {6,7,4,9,5,2,3,5,6,7,4,3,2,6,7,4,3,2,1,4,5,34,44,33,22,1,4,32,2,28,5,1,32,1,0};
        System.out.println(a.length);
        int s[] = replace(a);

        for(int i = 0; i < s.length; i++){
            System.out.print(s[i]);
        }

        System.out.println();





        int arr3[][] = {{1,1,-1,1,1},
                {1,0,0,-1,1},
                {1,1,1,1,-1},
                {-1,-1,1,1,1},
                {1,1,-1,-1,1}};
        System.out.println(findMaximum(arr3));


        int[]array = {1,1,0,1,1,0,1,1,1,1,0,0};
        int[]array1 = {1,3,6,2};
        System.out.println(longestSequens(array, 3));

        System.out.println(findMaximum(arr3));
        //int [] mendi = {5, 7, -2, 10};
        //System.out.println(average(mendi));
        int[]array134 = {1,2,3,4,5};
        System.out.println(striclyIncrusing(array134));
        System.out.println(findLimit(new int[]{-8, -7, -5, -3, -2, 5, 8}));
    }
}
