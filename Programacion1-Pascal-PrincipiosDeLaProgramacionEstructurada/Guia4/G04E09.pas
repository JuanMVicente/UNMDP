program G04E09;
procedure SumaFraccion(N1,D1,N2,D2:word;var NR,DR:word);
  Begin
    DR:= D1*D2;
    NR:=N1*D2+N2*D1;
    writeln(N1:2,'   ',N2:2,'   ',NR:2);
    writeln('-- + -- = --');
    writeln(D1:2,'   ',D2:2,'   ',DR:2);
  end;
procedure MultFraccion(N1,D1,N2,D2:word;var NR,DR:word);
  Begin
    DR:= D1*D2;
    NR:= N1*N2;
    writeln(N1:2,'   ',N2:2,'   ',NR:2);
    writeln('-- * -- = --');
    writeln(D1:2,'   ',D2:2,'   ',DR:2);
  end;
var
  N1,D1,N2,D2,NR,DR:word;
  Arch:text;
begin
  Assign(Arch,'G04E09.txt');
  Reset(Arch);
  Readln(Arch, N1);
  Readln(Arch, D1);
  Readln(Arch, N2);
  Readln(Arch, D2);
  SumaFraccion(N1,D1,N2,D2,NR,DR);
  Writeln();
  MultFraccion(N1,D1,N2,D2,NR,DR);
  Close(Arch);
  Readln();
end.

