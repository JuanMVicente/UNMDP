program G05E06;
Type
 ST15=String[15];
 TVS = array[1..50] of ST15;
 TVB = array[1..50] of byte;
Procedure LeeVector(var A:TVS;var B:TVB; var N:byte);
var
  Car:Char;
  Arch:text;
  Palabra:String[15];
  Cont:byte;
begin
  Assign(Arch, 'G05E06.txt');
  Reset(Arch);
  N:=0;
    While not eof(Arch) do
      Begin
        Car:='$';
        Palabra:='';
        Cont:=0;
        While (Car<>'.') and (Car<>' ') and (Car<>',') and Not eof(Arch) do
          Begin
          Read(Arch, Car);
          if (Car<>'.') and (Car<>' ') and (Car<>',') then
              Begin
                Palabra:=Palabra+Car;
                Cont:=Cont+1;
              end;
          end;
        if palabra<>'' then
            Begin
              N:=N+1;
              A[N]:=Palabra;
              B[N]:=Cont;
            end;
      end;
  close(Arch);
end;
Procedure EscribeVectorS(A:TVS;N:byte);
var
  i:byte;
Begin
  For i:=1 to N do
    Write('-',A[i],'-');
end;
Procedure EscribeVectorB(A:TVB;N:byte);
var
  i:byte;
Begin
  For i:=1 to N do
    Write('-',A[i],'-');
end;
Function MaxPalabra(A:TVB;N:byte):byte;
var
  i,Aux:byte;
begin
  Aux:=0;
  For i:=1 to N do
    if Aux<A[i] then
        begin
          Aux:=A[i];
          MaxPalabra:=i;
        end;
end;
Function PrimeraPalabra(A:TVS;N:byte):byte;
var
  i:byte;
  Aux:ST15;
begin
  Aux:=A[i];
  For i:=2 to N do
    if Aux>A[i] then
        begin
          Aux:=A[i];
          PrimeraPalabra:=i;
        end;
end;
var
  Palabras:TVS;
  Letras:TVB;
  N:byte;
begin
  LeeVector(Palabras,Letras,N);
  write('Vector: ');
  EscribeVectorS(Palabras,N);
  Writeln();
  write('Vector: ');
  EscribeVectorB(Letras,N);
  Writeln();
  Writeln('La palabra mas larga es "',Palabras[MaxPalabra(Letras,N)],'" y tiene ',Letras[MaxPalabra(Letras,N)],' caracteres.');
  Writeln();
  Writeln('La primera palabra en el diccionario es "',Palabras[PrimeraPalabra(Palabras,N)],'".');
  readln();
end.

