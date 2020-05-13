#include <limits.h>
int main() 
{
	int array[100], n, c, d, position, swap;
	printf("Enter number of elements\n"); scanf("%d", &n);
	printf("Enter %d integers\n", n);
	for (c = 0; c < n; c++) scanf("%d", &array[c]); 
	//@ assert c<n;
	//@ loop invariant 0 <= c < (n-1);
	for (c = 0; c < (n - 1); c++) {
		//@ assert c<(n-1);
		position = c;
		//@ assert c<(n-1) && position == c;
		//@ loop invariant c+1 <= d <= n;
		for (d = c + 1; d < n; d++) 
		{	
			//@ assert c<(n-1);
			if (array[position] > array[d]) {
				//@ assert array[position] > array[d] && c<(n-1);
				position = d; 
				//@ assert position == d  && c<(n-1);
			}
			//@ assert c<(n-1) && (array[position] <= array[d] || position == d );
		}
		//@ assert d >= n && position >=c;
		if (position != c) 
		{
			//@ assert position != c;
			swap = array[c]; 
			//@ assert position != c && swap == array[c];
			array[c] = array[position];
			//@ assert position != c && array[c] == array[position];
			array[position] = swap;
			//@ assert array[position] > array[c] && position != c && swap == array[position];
		}
	//@ assert array[position] >= array[c];
	}
	printf("Sorted list in ascending order:\n");
	for (c = 0; c < n; c++) printf("%d\n", array[c]);
	return 0;
}