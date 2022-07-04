program G05E07;
Const
  MAX=20;
Type
  TV = array[1..20] of byte;

procedure StrToVec(Linea:String; var VN:TV; var N:byte);
var
  i:byte;
  code:integer;
begin
  N:= length(linea);
  For i:=1 to N do
    val(linea[i],VN[i],code);

end;

procedure LeeNros(var VN1,VN2:TV;var N,M:byte);
var
  linea: string;
  Arch:text;
begin
  Assign(Arch, 'G05E07.txt');
  Reset(Arch);

  Readln(Arch,Linea);
  StrToVec(Linea,VN1,N);

  Readln(Arch,Linea);
  StrToVec(Linea,VN2,M);

  Close(Arch);
end;

procedure Suma(VN1,VN2:TV; N,M:byte; var VN3:TV;var W:byte);
var
  result,sobra:byte;
begin
  W:=0;
  sobra:=0;

  while (N>0) or (M>0) do
    begin
      result:=sobra;

      if N>0 then
        begin
          result:=result+VN1[N];
          N:=N-1;
        end;

      if M>0 then
        begin
          result:=result+VN2[M];
          M:=M-1;
        end;

      W:=W+1;
      VN3[W]:= result mod 10;
      sobra:=result div 10;

    end;

  if sobra>0 then
    begin
      W:=W+1;
      VN3[W]:=sobra
    end;

end;

procedure Mostrar(VN:TV; N:byte);
var
  i:byte;
begin
  For i:=N downto 1 do
    write(VN[i]);
end;


var
  VN1,VN2,VN3:TV;
  N,M,W:byte;
begin
  LeeNros(VN1,VN2,N,M);
  Suma(VN1,VN2,N,M,VN3,W);
  Mostrar(VN3,W);
  Readln();
end.

