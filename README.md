# Count-Submatrices-With-All-Ones
Given a m x n binary matrix filled with 0s and 1s, count the number of submatrices that have all ones.
Explanation
🔹 Step 1: Build dp matrix
We create a DP table where dp[i][j] represents the number of consecutive 1s to the left of mat[i][j] (including itself) in the same row.
Step 2: Count submatrices ending at each cell
For every cell (i, j), move upward (row by row) and compute the number of submatrices ending at that column j and going upwards to row k. You maintain the minimum width of 1s and add it to the count.

This helps count all possible submatrices ending at each (i, j).

