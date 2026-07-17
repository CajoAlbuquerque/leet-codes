/**
 Do not return anything, modify nums1 in-place instead.
 */
function merge(nums1: number[], m: number, nums2: number[], n: number): void {
  if (n == 0) return;

  if (m == 0) {
    nums1.splice(0, nums1.length, ...nums2);
    return;
  }

  let result: number[] = [];
  let i = 0;
  let j = 0;
  while (true) {
    let el1: number | null = null;
    if (i < m) {
      el1 = nums1[i];
    }

    let el2: number | null = null;
    if (j < n) {
      el2 = nums2[j];
    }

    if (el1 === null && el2 === null) break;
    else if (el1 === null) {
      result.push(el2!);
      j++;
    } else if (el2 === null) {
      result.push(el1);
      i++;
    } else if (el1 < el2) {
      result.push(el1);
      i++;
    } else if (el1 > el2) {
      result.push(el2);
      j++;
    } else if (el1 == el2) {
      result.push(el1);
      result.push(el2);
      i++;
      j++;
    }
  }

  nums1.splice(0, nums1.length, ...result);
}
