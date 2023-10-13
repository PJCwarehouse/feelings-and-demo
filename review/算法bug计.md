10.5：LCR 121. 寻找目标值 - 二维数组
java.lang.ArrayIndexOutOfBoundsException: **Index 3 out of bounds for length 3**
  at line 10, Solution.findTargetIn2DPlants
  at line 54, __DriverSolution__.__helper__
  at line 87, __Driver__.main
解答：索引超出长度界限，这里的问题是没有明确的终止循环的条件
 while(plants[i][j] != target)