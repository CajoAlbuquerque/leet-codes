/**
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 */
var isAnagram = function (s, t) {
    if (s.length !== t.length)
        return false;

    const map = new Map()
    for (let i = 0; i < s.length; i++) {
        const char = s.charAt(i);
        if (!map.has(char)) {
            map.set(char, 1);
            continue;
        }

        map.set(char, map.get(char) + 1);
    }

    for (let j = 0; j < t.length; j++) {
        const char = t.charAt(j);
        if (!map.has(char) || map.get(char) === 0)
            return false;

        map.set(char, map.get(char) - 1);
    }

    return true;
};

let test1 = isAnagram("anagram", "nagaram") // true
let test2 = isAnagram("rat", "car") // false
let test3 = isAnagram("hi", "I") // false