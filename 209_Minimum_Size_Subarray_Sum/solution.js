// Attempt 1 - because n can go up to 10^5, there's not enough memory for recursion because spatiaal O(2*M!)
// var minSubArrayLen = function (target, nums) {
// const sum = nums.reduce((acc, val) => acc + val)
// if (target > sum)
//     return 0;

// const n = nums.length;
// if (n === 1)
//     return 1;

// const numsLeft = nums.slice(0, n - 1);
// const leftResult = minSubArrayLen(target, numsLeft);

// const numsRight = nums.slice(1, n);
// const rightResult = minSubArrayLen(target, numsRight);

// if (leftResult === 0 && rightResult === 0)
//     return n;
// else if (rightResult === 0)
//     return leftResult;
// else if (leftResult === 0)
//     return rightResult;

// return Math.min(leftResult, rightResult);
// };

// Attempt 2 - not performant, backtracking makes the algorithm O(N!)
// var minSubArrayLen = function (target, nums) {
//     let i = 0;
//     let j = 1;
//     let backtrack = false;
//     let result = nums.length;

//     while (j <= nums.length + 1 && i < j) {
//         const window = nums.slice(i, j);
//         const sum = window.reduce((acc, val) => acc + val);

//         // No subarray
//         if (sum < target && i === 0 && j === nums.length) {
//             return 0;
//         }

//         // Not enough
//         if (sum < target) {
//             // Go back with i
//             if (backtrack)
//             {
//                 i--;
//                 backtrack = false;
//             }

//             j++;
//             continue;
//         }

//         // Enough
//         if (sum >= target) {
//             result = Math.min(result, j - i);
//             i++;
//             backtrack = true;
//         }
//     }

//     return result;
// };

/**
 * @param {number} target
 * @param {number[]} nums
 * @return {number}
 */
var minSubArrayLen = function (target, nums) {
    let i = 0;
    let j = 0;
    let sum = 0;
    let result = Number.MAX_VALUE;

    while (j < nums.length) {
        sum += nums[j];

        while (sum >= target) {
            result = Math.min(result, j + 1 - i);
            sum -= nums[i];
            i++;
        }

        j++;
    }

    return result === Number.MAX_VALUE ? 0 : result;
}

let test1 = minSubArrayLen(7, [2, 3, 1, 2, 4, 3]) // 2
let test2 = minSubArrayLen(4, [1, 4, 4]) // 1
let test3 = minSubArrayLen(11, [1, 1, 1, 1, 1, 1, 1, 1]) // 0
let test4 = minSubArrayLen(7, [2, 3, 1, 4, 3, 2, 2]) // 2
let test5 = minSubArrayLen(8, [2, 3, 1, 2, 4, 3]) // 3
let test6 = minSubArrayLen(213, [12, 28, 83, 4, 25, 26, 25, 2, 25, 25, 25, 12]) // 8
let test7 = minSubArrayLen(7, [2, 3, 1, 2, 7, 3]) // 1
