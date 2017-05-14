#include <stdio.h>
#include <stdlib.h>
#define p printf
#define tim 10000
struct lista
{
char dato;
}buffer[20];//estructura para almacenar la salida


main()
{

int cont=0, pronum=0, proletr=0, posicion=0, turno, num_rand,c = 1, d = 1,i;
char letra_rand;
srand(time(NULL));
getch();
do
{
turno=1*rand()%3+1;
if(turno==1)
{
if(pronum<20 && posicion<19)//validacion 20 turnos
{
num_rand=26*(rand()/(RAND_MAX+1.0));//Productor numeros
num_rand=num_rand+97;
letra_rand=(char)num_rand;//productor de letras
buffer[posicion].dato=letra_rand;
pronum++;
posicion++;
}
cont++;
}
if(turno==2 && posicion<19)//validacion 20 turnos
{
if(proletr<20)
{
num_rand=rand()%10;
buffer[posicion].dato=num_rand+'0';
proletr++;
posicion++;
}
cont++;
}
if(turno==3)//validacion para el turno de borrado
{
if(posicion==0 && pronum<20 && proletr<20)
posicion=posicion;
else if(posicion==1 && pronum==20 && proletr==20)
posicion=-1;
else
posicion--;
cont++;
}
system("cls");//limpia la pantalla para que no se repita
p("\t\t\t\t\tPractica 3\n\t\t\t\t\tSistemas Operativos\n\n\n\n\n\n");
for(i=0; i<posicion; i++)
p("%c ", buffer[i].dato);
p("\n\nContador Total: %d\tContador Letras: %d\tContador Numeros: %d\tProceso:%d", cont, pronum, proletr,turno);
for ( c = 1 ; c <= tim ; c++ )
for ( d = 1 ; d <= tim ; d++ )
{

}
}while(pronum<20 || proletr<20 || posicion>=0);//validacion para los 20 turnos de cada ciclo
p("\nBuffer Vacio\n");
return 0;
}
