class MoveZeroes {
    static int COUNT = 0;
    public void moveZeroes(int[] nums) {
        if(nums.length == 0) return;
        int j = 0;
        for(; j < nums.length; j++) if(nums[j] != 0) break;
        if(j == nums.length) return;                                                        	// all zeroes array
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                for(; j < nums.length; j++){
                    if(nums[j] != 0 && j > i){
                       swap(i,j,nums);
                       break;
                   }
                }
            }
        }
    }
    public void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i]  = nums[j];
        nums[j]  = temp;
    }
    public static String toString(final int[] arr){						// convert int array to string array
		String s = "";
        for(int i = 0; i < arr.length; i++){
            if(i == arr.length - 1) s += Integer.toString(arr[i]);
            else s += Integer.toString(arr[i]) + " ";
        }
        return s;
	}
    public static int[] toInt(final String s){							// convert string array to int array
        String[] str = s.split(" ");
        if(s == "") return new int[0];
        int[] arr = new int[str.length];
        if(s == "") return arr;
        for(int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(str[i]);
        return arr;
	}
    public static void test(String str1, String str2){                                     	// general test function
        MoveZeroes l = new MoveZeroes();
        int[] nums = toInt(str1);
        l.moveZeroes(nums);
        str1 = toString(nums);
		assert(str1.equals(str2));
        COUNT++;
    }
    public static void testToString(){
        int[] nums = {0,1,0,3,12};
        String s = toString(nums);
        String a = "0 1 0 3 12";
        assert(s.equals(a));
        COUNT++;
    }
    public static void main(String args[]){
        // testToString();
        test("", "");
        test("0", "0");
        test("1 0", "1 0");
        test("1 1 0", "1 1 0");
        test("0 0 0 0", "0 0 0 0");
        test("0 0 4 3", "4 3 0 0");
        test("0 1 0 3 12", "1 3 12 0 0");
        test("1 0 5 0 0 6 0 0 0 3 4", "1 5 6 3 4 0 0 0 0 0 0");
        test("0 4 0 0 6 3 0 1 0 0 0 9", "4 6 3 1 9 0 0 0 0 0 0 0");
        System.out.println("Passes: "+ COUNT + " Tests");
    }
     /**
        0 0 4 3
        4 0 0 3  -> swapping the beginnng of 0 to end of 0
        4 3 0 0

                                        i           j
        0 4 0 0 6 3 0 1 0 0 0 9     zeroes = 0, non-zeroes = 1
        4 0 0 0 6 3 0 1 0 0 0 9     zeroes = 1, non-zeroes = 4
        4 6 0 0 0 3 0 1 0 0 0 9     zeroes = 2, non-zeroes = 5
        4 6 3 0 0 0 0 1 0 0 0 9     zeroes = 3, non-zeroes = 7
        4 6 3 1 0 0 0 0 0 0 0 9     zeroes = 4, non-zeroes = 11
        4 6 3 1 9 0 0 0 0 0 0 0     zeroes = 5, non-zeroes = --
    */
}
