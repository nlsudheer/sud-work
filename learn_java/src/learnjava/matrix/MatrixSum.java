package learnjava.matrix;

/*
 * You are given a 3 * 3 Matrix - 

3 -5 10 
6 2 -1 
2 6 1 

Q: Find the sum of the elements of each rows, and each column, and then display row number \ column number having the maximum sum and the minimum sum.

http://www.careercup.com/question?id=5894737940709376


var matrix =[[ 3,-5,10]
            ,[ 6,-2,-1]
            ,[ 2, 6, 1]];

var maxRow=0
var maxRowSum=Number.MIN_VALUE
var minRow=0
var minRowSum=Number.MAX_VALUE

var maxColumn=0
var maxColumnSum=Number.MIN_VALUE
var minColumn=0
var minColumnSum=Number.MAX_VALUE

for(var i=0; i<;3; i++) {
    var rowSum=0;
    var columnSum=0;
    
    for(var j=0; j<;3; j++) {
        rowSum+=matrix[i][j];            
        columnSum+=matrix[j][i]
    }
    
    if(rowSum>maxRowSum) {
        maxRowSum=rowSum;
        maxRow=i
    }
    
    if(rowSum<minRowSum) {
        minRowSum=rowSum
        minRow=i
    }
    
    if(columnSum>maxColumnSum) {
        maxColumnSum=columnSum;
        maxcolumn=i
    }
    
    if(rowSum<minColumnSum) {
        minColumnSum=columnSum
        minColumn=i
    }
}

console.debug("max row is ", maxRow, " with ", maxRowSum)
console.debug("min row is ", minRow, " with ", minRowSum)
console.debug("max column is ", maxColumn, " with ", maxColumnSum)
console.debug("min column is ", minColumn, " with ", minColumnSum)
 *
 *
 */

public class MatrixSum {
   
   

}




