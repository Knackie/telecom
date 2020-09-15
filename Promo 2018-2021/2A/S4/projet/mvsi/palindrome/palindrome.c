#include <stdio .h>
int main() 
{
	int n, reverse = 0, temp;
	printf("Enter a number to check if it is a palindrome or not\n"); scanf("%d", &n);
	temp = n;
	while (temp != 0) 
	{
		/*@assert temp != 0; */
		reverse = reverse ∗ 10;
		/*@assert reverse == \old(reverse)*10;*/
		reverse = reverse + temp % 10;
		/*@assert reverse == \old(reverse)+temp%10; */
		temp = temp / 10;
		/*@assert temp == \old(temp) /10; */
	}
	if (n == reverse) {
		/*@assert n == reverse; */
		printf("%d is a palindrome number.\n", n);
	}
	else {
		/*@assert n != reverse; */
		printf("%d is not a palindrome number.\n", n);
	}
	return 0;
}
