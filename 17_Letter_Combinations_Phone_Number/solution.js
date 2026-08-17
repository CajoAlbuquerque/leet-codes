/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function (digits) {
    let result = [];
    recursiveCall(digits, "", result);
    return result;
};

/**
 * @param {string} digits
 * @param {string} acc
 * @param {string[]} result
 * @return {void}
 */
var recursiveCall = function (digits, acc, result) {
    if (digits.length === 1) {
        const maps = mappings[digits]
        maps.forEach(map => result.push(acc + map));
        return;
    }

    const digit = digits.charAt(0);
    const maps = mappings[digit];
    maps.forEach(map => recursiveCall(digits.substring(1), acc + map, result))
}

const mappings = {
    "1": [],
    "2": ["a", "b", "c"],
    "3": ["d", "e", "f"],
    "4": ["g", "h", "i"],
    "5": ["j", "k", "l"],
    "6": ["m", "n", "o"],
    "7": ["p", "q", "r", "s"],
    "8": ["t", "u", "v"],
    "9": ["w", "x", "y", "z"],
}

let test2 = letterCombinations("2") // ["a","b","c"] (3)
let test1 = letterCombinations("23") // ["ad","ae","af","bd","be","bf","cd","ce","cf"] (9)
let test3 = letterCombinations("234") // ["adg", "adh", "adi", "aeg", "aeg", "aei", etc.] (27)