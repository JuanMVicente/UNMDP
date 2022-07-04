program G03E22;
var
  ArchE,ArchS: Text;
  Palabra,PVocal,Polindrona: string[20];
  Car:Char;
  Vocales,MaxV,i,Cont:word;
begin
  Assign(ArchE, 'G03E22.txt');
  Reset(ArchE);
  Car:='%';
  Assign (ArchS,'G03E22S.txt');
  Rewrite(ArchS);
  Cont:=0;
  MaxV:=0;
  While not eof(ArchE) do
    Begin
          Palabra:='';
          Polindrona:='';
          Vocales:=0;
          Car:='%';
          While (Car<>' ') and not(eof(ArchE)) do
            Begin
              Read(ArchE, Car);
              if Car<>' ' then
                Begin
                  Palabra:= Palabra + Car;
                  If ((upcase(Car)='A') or (upcase(Car)='E') or (upcase(Car)='I') or (upcase(Car)='O') or (upcase(Car)='U')) then
                    Vocales:=Vocales+1;
                end;
            end;
          If MaxV<Vocales then
              Begin
                MaxV:=Vocales;
                PVocal:=Palabra;
              end;
          If Length(Palabra)>3 then
              Begin
                 For i:= (Length(Palabra)) downto 1 do
                  Polindrona := Polindrona + Palabra[i];
                 Writeln(ArchS, Polindrona);
                 If Polindrona=Palabra Then Cont := Cont + 1;
              end;

    end;
Close(ArchE);
Close(ArchS);
Writeln('La palabra con mas vocales es: ',PVocal);
Writeln('La cantidad de palabras Polindronas es: ',Cont);
Readln();
end.

