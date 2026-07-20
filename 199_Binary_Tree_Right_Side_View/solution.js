
//Definition for a binary tree node.
class TreeNode {
    constructor(val, left, right) {
        this.val = (val === undefined ? 0 : val);
        this.left = (left === undefined ? null : left);
        this.right = (right === undefined ? null : right);
    }
}

/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var rightSideView = function (root) {
    let queue = [];
    let result = [];

    if (root === null)
        return result;

    // each value is a pair of (depth, TreeNode)
    queue.push([0, root]);

    while (queue.length > 0) {
        const depth = queue[0][0];
        const node = queue[0][1];
        queue.splice(0, 1);

        if (node === null)
            continue;

        queue.push([depth + 1, node.right], [depth + 1, node.left]);
        
        if (result.length > depth)
            continue;

        result.push(node.val);
    }

    return result;
};