program G03E15b;
var
  Arch: text;
  Letra, LetraD:Char;
  i,j:byte;
begin
  Write('Escribe la letra deseada: ');
  Readln(LetraD);
  Assign(Arch, 'G03E15.txt');
  Reset(Arch);
  j:=0;
  Letra:='1';
  While Letra<>'.' do
        Begin
          i:=0;
          Read(Arch,Letra);
          While not ((Letra='.') or (letra=' ')) do
                Begin
                If (upcase(Letra)=upcase(LetraD)) then
                   i:=1;
                Read(Arch,Letra);
                end;
          j:= j+i;
        end;
  Close(Arch);
  Writeln('La cantidad de palabras que contienen esa letra es: ', j);
  Readln();
end.

