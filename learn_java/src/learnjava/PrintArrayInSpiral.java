package learnjava;

/*
 * http://www.careercup.com/question?id=5040002488598528
 * 
 * i=j=low_r=low_c=0;
  high_r=rows-1;
  high_c=columns-1;
  num=rows*columns;
  k=0;
  while(k<num){
    for(j=low_c;j<=high_c && k<num ;j++){
      printf("%d ",a[i][j]);
      k++;
    }
    j--;
    low_r++;
    for(i=low_r;i<=high_r && k<num;i++){
      printf("%d ",a[i][j]);
      k++;
    }
    i--;
    high_c--;
    for(j=high_c;j>=low_c && k<num;j--){
      printf("%d ",a[i][j]);
      k++;
    }
    j++;
    high_r--;
    for(i=high_r;i>=low_r && k<num;i--){
      printf("%d ",a[i][j]);
      k++;            
    }
    i++;
    low_c++;
  }
 */

public class PrintArrayInSpiral {

}
