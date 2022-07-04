program G03E20;
var
  Arch: text;
  Num_Lectura,Cont, Suma: integer;
begin
  Assign(Arch, 'G03E20.txt');
  Reset(Arch);
  While Num_Lectura>=0 do
    Read(Arch, Num_Lectura);
  while not eof(Arch) do
      Begin
        Suma:=0;
        Cont:=0;
        While Num_Lectura<0 do
              Read(Arch, Num_Lectura);
        While Not ((Num_Lectura<0) or eof(Arch)) do
             if Num_Lectura>0 then
                 Begin
                   Suma:= Suma + Num_Lectura;
                   Cont:= Cont+1;
                   Read(Arch, Num_Lectura);
                 end
             else Read(Arch, Num_Lectura);
        If Num_Lectura<0 then
             Write((Suma/Cont):5:2, ' ');
      end;
  Close(Arch);
  Readln();
end.

