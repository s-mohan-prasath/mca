#include <omp.h>
#include <stdio.h>
#include <stdlib.h>

int main()
{
    omp_set_num_threads(5);
    // Beginning of parallel region

    #pragma omp parallel
    {
        printf("Hello world...from thread = %d\n",omp_get_thread_num());
    }
}
