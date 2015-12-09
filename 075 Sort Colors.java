//三种颜色排序 不占用额外空间的方法

public void sortColors(int[] nums) {
        int zero = 0, temp = 0, two = nums.length-1;
        while(temp <= two) {
            if(nums[temp] == 0) {
                nums[temp++] = nums[zero];
                nums[zero++] = 0;
            }
            else if(nums[temp] == 2) {
                nums[temp] = nums[two];
                nums[two--] = 2;
            }
            else
                temp++;
        }
    }
