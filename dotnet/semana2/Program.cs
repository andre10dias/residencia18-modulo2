#region foreach example

string[] colecao = { "item1", "item2", "item3", "item4" };
foreach (string item in colecao)
{
    Console.WriteLine(item);
}

#endregion

#region readline example

System.Console.WriteLine("Digite seu nome: ");
//string? nome = System.Console.ReadLine();   //'?' Indica que a variável pode receber null
//System.Console.WriteLine($"Seu nome é: {nome}");

#endregion

//Exercicio
#region Números divisíveis por 3 ou por 4 entre 0 e 30

for (int i = 0; i <= 30; i++)
{
    if (i % 3 == 0 || i % 4 == 0)
    {
        System.Console.Write(i + ", ");
    }
}

System.Console.WriteLine("");

#endregion

#region Números de Fibonacci até passar de 100

int f1 = 0, f2 = 1;
int f3 = f1 + f2;
System.Console.Write(0 + ", ");

while (f3 <= 100)
{
    System.Console.Write(f3 + ", ");
    f3 = f1 + f2;
    f1 = f2;
    f2 = f3;
}

System.Console.WriteLine("");

#endregion

#region List example
List<int> numbers = new List<int>();
numbers.Add(1);
numbers.Add(2);
numbers.Add(3);
numbers.Add(4);
numbers.Add(5);
numbers.Add(6);

System.Console.WriteLine("Lista de inteiros: ");
foreach (int i in numbers)
{
    System.Console.WriteLine(i);
}

System.Console.WriteLine("Tamanho da lista: " + numbers.Count);
System.Console.WriteLine("Contém 4? " + numbers.Contains(4));

#endregion

//Trabalhando com datas
#region DateTime example

DateTime start = DateTime.Now;
System.Console.WriteLine("Data atual: " + start);

DateTime eastertime = start.AddHours(3);
System.Console.WriteLine("Data atual + 3 horas: " + eastertime);

DateTime tomorrow = start.AddDays(1);
System.Console.WriteLine("Data de amanhã: " + tomorrow);

DateTime yesterday = start.AddDays(-1);
System.Console.WriteLine("Data de ontem: " + yesterday);

DateTime universaltime = start.ToUniversalTime();
System.Console.WriteLine("Data universal: " + universaltime);

DateTime specifctime = new DateTime(1982, 2, 9, 10, 10, 0, DateTimeKind.Local);
System.Console.WriteLine("Data especifica: " + specifctime);

DateTime weekday = new DateTime(1982, 2, 9, 10, 10, 0, DateTimeKind.Utc);
System.Console.WriteLine("Data de um dia da semana: " + weekday);

DayOfWeek dayofweek = new DateTime(1982, 2, 9, 10, 10, 0, DateTimeKind.Utc).DayOfWeek;
System.Console.WriteLine("Dia da semana: " + dayofweek);

DayOfWeek diaDaSemana = new DateTime(1982, 2, 9, 10, 10, 0, DateTimeKind.Utc).DayOfWeek;
System.Console.WriteLine("Dia da semana: " + diaDaSemana.ToString("Terça-feira"));

#endregion