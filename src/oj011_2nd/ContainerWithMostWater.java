package oj011_2nd;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 */

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        int start = 0, end = height.length - 1;
        while (start < end) {
            max = Math.max(max, (end - start) * Math.min(height[start], height[end]));
            if(height[start] < height[end]) {
                start++;
            } else {
                end--;
            }
        }
        return max;
    }
}