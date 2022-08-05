#include <stdio.h>

int fact(int n) {
   int x = 0;
   
   if (n > 0) {
      x = n * fact(n - 1);
   } else {
      x = 1;
   }
   
   return x;     
}

int main() {
   int a = 10;
   int b =  0;
   
   b = fact(a);
   printf("%d!=%d\n", a,b);
   
   return 0;
}
