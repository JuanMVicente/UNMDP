Program G04E14;
Type
 St20=string[20];
Procedure Evalua(Var Todas: string; Var Max,j: byte);
Var
 Arch: Text;
 Car: char;
 Pal: St20;
 i: byte;
Begin
  Assign (Arch, 'G04E14.txt'); Reset(Arch);
  Max:=0;
  Read(Arch, Car);
  While Not eof(Arch) do
     begin { es el comienzo de palabra}
       Read(Arch, Car);
       Pal:= '';
       i:=0;
       While (Car <> '.') do
         begin {cuenta los caracteres y arma la palabra}
           i:=i+1;
           Pal:= Pal + Car;
           Read(Arch, Car);
         End;
       Readln(Arch,Car);
       If i>Max then {evalua si es m s larga}
         begin
           Todas := Pal;
           Max := i;
         End
       else
         if i= Max then {evalua si es igual}
           Begin
             Todas:= Todas + ' '+ Pal;
             j:=j+1;
           end;

     end;
  Close(Arch);
End;
Var
 Todas: string;
 Max, cont: byte;
Begin
Evalua(Todas, max, cont);
Writeln ('estas son las palabras mas largas') ;
writeln (Todas);
Writeln (cont,' palabras tienen ', Max, ' caracteres') ;
Readln;
end.
