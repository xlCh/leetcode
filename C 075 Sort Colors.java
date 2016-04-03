//https://leetcode.com/problems/sort-colors/
//三种颜色排序 不占用额外空间的方法
//思考k种颜色排序：https://leetcode.com/discuss/93302/sort-colors-and-sort-k-colors-c-solution
public void sortColors(int[] nums) {
        int zero = 0, temp = 0, two = nums.length-1;
        while(temp <= two) {
            if(nums[temp] == 0) {
                nums[temp++] = nums[zero];
                nums[zero++] = 0;
            }
            else if(nums[temp] == 2) {
                nums[temp] = nums[two];//注意差别
                nums[two--] = 2;
            }
            else
                temp++;
        }
    }
