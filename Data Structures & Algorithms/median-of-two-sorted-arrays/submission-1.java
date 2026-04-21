class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int n = nums1.length, m = nums2.length;
        int left = 0, right = nums1.length;
        while (left <= right) {
            int cutA = left + (right - left) / 2;
            int cutB = (n + m + 1) / 2 - cutA;

            int leftA = (cutA == 0) ? Integer.MIN_VALUE : nums1[cutA - 1];
            int rightA = (cutA == n) ? Integer.MAX_VALUE : nums1[cutA];

            int leftB = (cutB == 0) ? Integer.MIN_VALUE : nums2[cutB - 1];
            int rightB = (cutB == m) ? Integer.MAX_VALUE : nums2[cutB];

            if (leftA <= rightB && leftB <= rightA) {
                if ((m + n) % 2 == 0)
                    return (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0;
                else
                    return Math.max(leftA, leftB);
            }

            else if (leftA > rightB) {
                right = cutA - 1;
            } else {
                left = cutA + 1;
            }
        }
        return 1.0D;
    }
}
