#include<stdio .h>


int main() 
{
    int n, i = 3, count , c;
    printf ("Enter the number of prime numbers required\n" );
    scanf("%d",&n);
    if ( n >= 1 )
    {
	/*@assert n>=1; */
        printf ("First %d prime numbers are :\n" ,n); printf ("2\n" );
    }
    /*@ loop invariant 2 <= count <=n; */
    for ( count = 2 ; count <= n ; ) 
    {
	/*@assert count<n; */
        /*@ loop invariant 2 <= c <=i-1; */
        for ( c = 2 ; c <= i − 1 ; c++ ) 
        {
	    /*@assert c<i-1; */
            if ( i%c == 0 ) {
		/*@assert i%c == 0; */
                break;
	    }
        } 
        if ( c == i ) 
        {
	    /*@assert c==i; */
            printf ("%d\n" ,i ); 
	    count++; 
	    /*@assert count == \old(count)+1; */
        }
        i++; 
	/*@assert i == \old(i)+1; */
    }
    return 0;
} 