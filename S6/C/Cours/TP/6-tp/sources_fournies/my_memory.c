#include <stdlib.h>

int free_counter=0;
int malloc_counter=0;

void *my_malloc(size_t size)
{
  malloc_counter++;
  return malloc(size);
};

void my_free(void *ptr)
{
  free_counter++;
  free(ptr);
}
