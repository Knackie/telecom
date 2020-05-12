int tour , 
c1,c2 ; 
main ()
{
c1 = c2 = tour = 1;
parbegin 
p1 () ;
p2 () ;
parend
}
p1 ()
{
for ( ; ; )
{
c1 = 0; 
while (c2 == 0) 
if (tour == 2) 
{
c1 = 1;
while (tour == 2) ; 
c1 = 0; 
}
crit1;
tour = 2; 
c1 = 1; 
reste1;
}
}
/**********************************************************************/
p2 ()
{
for (; ; )
{
c2 = 0; 
while (c1 == 0) 
if (tour == 1) 
{
c2 = 1; 
while (tour == 1); 
c2 = 0; 
}
crit2;
tour = 1; 
c2 = 1; 
reste2;
}
}