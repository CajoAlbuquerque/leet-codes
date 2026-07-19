/**
 * @param {number[]} ratings
 * @return {number}
 */
let candy = function (ratings) {
    const n = ratings.length;

    let candyDistribution = [];
    for (let i = 0; i < n; i++) {
        candyDistribution.push(1)
    }

    for (let i = 1; i < n; i++) {
        const current = ratings[i];
        const left = ratings[i - 1];

        if (current > left) {
            candyDistribution[i] = candyDistribution[i - 1] + 1;
        }
    }
    
    for (let j = n - 2; j >= 0; j--) {
        const current = ratings[j];
        const right = ratings[j + 1];

        if (current > right) {
            candyDistribution[j] = Math.max(candyDistribution[j], candyDistribution[j + 1] + 1);
        }
    }

    return candyDistribution.reduce((acc, val) => acc + val);
};

let test1 = candy([1, 0, 2]); // 5
let test2 = candy([1, 2, 2]); // 4
let test3 = candy([1, 1, 1]); // 3
let test4 = candy([1, 3, 2, 1, 0, 2, 1, 1, 2]); // [1,4,3,2,1,2,1,1,2] = 17
let test5 = candy([29, 51, 87, 87, 72, 12]) // 12
