program G03E16;
Var
  Patente, Pat_Max: string[7];
  Combustible, Comb_Min, Kilometros, Litros_Promedio, Litros_, Suma_Kilometros, Min_Kilometros: real;
  Cantidad_Autos, Contador_Viajes, Max_Viajes, i:byte;
begin
  Writeln('Cuantos autos desea registrar? ');
  Readln(Cantidad_Autos);
  Max_Viajes:=0;
  Min_Kilometros:=1000000;
  For i:=1 to Cantidad_Autos do
      Begin
        Suma_Kilometros:=0;
        Contador_Viajes:=0;
        Write('Patente: ');
        Readln(Patente);
        Write('Combustible Consumido: ');
        Readln(Combustible);
        Write('Kilometros Recorridos en cada viaje (0 indica fin de los viajes): ');
        Readln(Kilometros);
        While Kilometros <> 0 do
              Begin
                Contador_Viajes:= Contador_Viajes+1;
                Suma_Kilometros := Suma_Kilometros + Kilometros;
                Write('Kilometros Recorridos en cada viaje (0 indica fin de los viajes): ');
                Readln(Kilometros);
              end;
        Litros_Promedio := Combustible / Suma_Kilometros;
        Writeln('El vehiculo ',Patente,' tiene un consumo de ',Litros_Promedio:10:2,' Lt/km.');
        if Suma_Kilometros<Min_Kilometros then
           Begin
             Min_Kilometros:=Suma_Kilometros;
             Comb_Min := Combustible;
           end;
        if Max_Viajes<Contador_Viajes then
           Begin
             Max_Viajes:=Contador_Viajes;
             Pat_Max := Patente;
           end;
        end;
  Writeln('Total de litros consumidos por el auto que hizo la menor cantidad de kms es ',Comb_Min:10:2,'.');
  Writeln('El vehiculo que mas viajes hizo es ',Pat_Max,'.');
  Readln();
end.

