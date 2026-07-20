/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var searchInsert = function (nums, target) {
    let left = 0;
    let right = nums.length - 1;

    while (left <= right) {
        const midIndex = Math.floor((left + right) / 2);

        if(nums[midIndex] === target)
            return midIndex;
        else if (nums[midIndex] > target)
            right = midIndex - 1;
        else
            left = midIndex + 1;
    }

    return left;
};

let test1 = searchInsert([1, 3, 5, 6], 5); // 2
let test2 = searchInsert([1, 3, 5, 6], 2); // 1
let test3 = searchInsert([1, 3, 5, 6], 7); // 4
let test4 = searchInsert([1, 2, 3, 5, 6], 4); // 3