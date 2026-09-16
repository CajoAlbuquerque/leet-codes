# Car Parking Roof

Given an array of integers `cars` representing the parking spot positions of cars along a 1D straight street, and an integer `k` representing the minimum number of cars that must be covered by a single roof, return the **minimum length of a roof** required to cover at least `k` cars.

A roof spanning from position $A$ to position $B$ has a length of $B - A + 1$.

---

### Constraints

* $1 \le k \le \text{cars.length} \le 10^5$
* $1 \le \text{cars}[i] \le 10^{14}$
* All elements in `cars` are distinct.

---

### Examples

```text
Example 1:
Input: cars = [6, 2, 12, 7], k = 3
Output: 6

Example 2:
Input: cars = [2, 10, 8, 17, 3], k = 3
Output: 7

Example 3:
Input: cars = [1, 2, 3, 4, 5], k = 4
Output: 4