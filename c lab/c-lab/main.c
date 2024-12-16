#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>
#include "ps1.h"
#include "ps2.h"
#include "ps3.h"
#include "ps4.h"
#include "ps5.h"
#include "ps6a.h"
#include "ps7.h"
#include "ps8.h"
#include "string_ps.h"
#include "ps10.h"
#include "structs.h"
#include "ca2lab.h"

int main()
{
    FILE *file = fopen("note.txt","w");
    fputs("Good",file);
    printf("%d",ftell(file));
    fclose(file);
    return 0;
}








