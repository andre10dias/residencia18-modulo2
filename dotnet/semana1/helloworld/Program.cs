#region helloworld

// See https://aka.ms/new-console-template for more information
Console.WriteLine("Hello, World!");

#endregion

#region tipos de dados

int tipoInteiro;
long tipoInteiroLongo;
double tipoDouble;
bool tipoBooleano;
string tipoString;

tipoInteiro = int.MaxValue;
System.Console.WriteLine("Valor máximo para o tipo inteiro: "+tipoInteiro);

tipoInteiroLongo = long.MaxValue;
System.Console.WriteLine("Valor máximo para o tipo inteiro longo: "+tipoInteiroLongo);

//conversão inplícita
tipoInteiroLongo = tipoInteiro;
System.Console.WriteLine("Conversão implícita entre int e long: "+tipoInteiroLongo);

tipoString = "100";
tipoInteiro = int.Parse(tipoString);
System.Console.WriteLine("Conversão string em int: "+tipoInteiro);

#endregion