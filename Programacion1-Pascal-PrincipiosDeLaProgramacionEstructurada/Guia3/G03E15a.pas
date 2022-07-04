program G03E15a;
var
  Arch: text;
  Letra1, Letra2, LetraD:Char;
  i:byte;
begin
  Write('Escribe la letra deseada: ');
  Readln(LetraD);
  Assign(Arch, 'G03E15.txt');
  Reset(Arch);
  Letra1:=' ';
  i:=0;
  While Letra2<>'.' do
        Begin
          Read(Arch,Letra2);
          If (Letra1=' ') and (upcase(Letra2)=upcase(LetraD)) then
             i:= i+1;
          Letra1:=Letra2;
        end;
  Writeln('La cantidad de palabras que comienzan con esa letra es: ', i);
  Readln();
end.

