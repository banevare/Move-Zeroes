
var moveZeroes = function(nums) {
    if(nums.length == 0) return;
    var j = 0;
    for(; j < nums.length; j++) if(nums[j] != 0) break;
    if(j == nums.length) return;                                                        // all zeroes array
    for(var i = 0; i < nums.length; i++){
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
var swap = function(i,j,nums){
    var temp = nums[i];
    nums[i]  = nums[j];
    nums[j]  = temp;
};